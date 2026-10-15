// Copyright Reacon contributors. Licensed under Apache-2.0.
package io.reacon.sdk.kotlin.infrastructure

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.cfg.CoercionAction
import com.fasterxml.jackson.databind.cfg.CoercionInputShape
import com.fasterxml.jackson.databind.type.LogicalType
import kotlinx.coroutines.*
import okhttp3.*
import okhttp3.Response as HttpResponse
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.io.InterruptedIOException
import java.nio.ByteBuffer
import java.nio.charset.CodingErrorAction
import java.time.Duration
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/** Optional shared cancellation for blocking calls and groups of requests. */
class CancellationToken {
    private val cancelled = AtomicBoolean()
    private val listeners = CopyOnWriteArrayList<() -> Unit>()
    val isCancelled: Boolean get() = cancelled.get()
    fun cancel() { if (cancelled.compareAndSet(false, true)) { listeners.forEach { it() }; listeners.clear() } }
    internal fun register(action: () -> Unit): AutoCloseable {
        listeners.add(action)
        if (isCancelled) { listeners.remove(action); action() }
        return AutoCloseable { listeners.remove(action) }
    }
}
data class RequestOptions(val timeout: Duration? = null, val cancellation: CancellationToken? = null)
class RequestTimeoutException(cause: Throwable) : IOException("Reacon request deadline exceeded", cause)
class RequestTransportException(cause: Throwable) : IOException("Reacon transport failed", cause)

open class HttpResponseException(message: String?, val statusCode: Int, val response: Response?, cause: Throwable? = null) : RuntimeException(message, cause) {
    val headers: Map<String, List<String>> get() = (response as? ApiResponse<*>)?.headers ?: emptyMap()
    val body: String? get() = when (response) { is ClientError<*> -> response.body?.toString(); is ServerError<*> -> response.body?.toString(); else -> null }
    val bodyBytes: ByteArray get() = when (response) { is ClientError<*> -> response.bodyBytes; is ServerError<*> -> response.bodyBytes; else -> byteArrayOf() }
    val requestId: String? get() = headers.entries.firstOrNull { it.key.equals("x-request-id", true) }?.value?.firstOrNull()
    val parsedBody: JsonNode? get() = HttpPolicy.parseError(bodyBytes)
    val errorCode: String? get() = parsedBody?.let { val code = it["code"] ?: it["error"]?.get("code"); if (code?.isTextual == true) code.asText() else null }
}
class ResponseDecodeException(snapshot: HttpSnapshot, cause: Throwable) : HttpResponseException(
    "Unable to decode Reacon response", snapshot.status,
    ClientError<Nothing>("Decode failed", snapshot.bytes.toString(Charsets.UTF_8), snapshot.status, snapshot.headers, snapshot.bytes), cause)

data class HttpSnapshot(val status: Int, val headers: Map<String, List<String>>, val bytes: ByteArray, val contentType: String, val csv: Boolean)

object HttpPolicy {
    private val mapper: ObjectMapper by lazy {
        Serializer.jacksonObjectMapper.copy()
            .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
            .disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT)
            .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
            .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
            .apply {
                coercionConfigFor(LogicalType.Textual).setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                    .setCoercion(CoercionInputShape.Float, CoercionAction.Fail).setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
            }
    }
    fun timeoutMillis(duration: Duration): Long {
        require(!duration.isZero && !duration.isNegative) { "A positive request timeout is required" }
        val millis = try { duration.toMillis() } catch (error: ArithmeticException) { throw IllegalArgumentException("Request timeout is too large", error) }
        require(millis in 1..Int.MAX_VALUE.toLong()) { "Request timeout must be 1..2147483647 milliseconds" }
        return millis
    }
    /** TLS, proxy, pool, dispatcher and caller interceptors survive the derived configuration. */
    fun client(client: OkHttpClient): OkHttpClient = client.newBuilder().retryOnConnectionFailure(false)
        .followRedirects(false).followSslRedirects(false).authenticator(Authenticator.NONE).proxyAuthenticator(Authenticator.NONE)
        .protocols(listOf(Protocol.HTTP_1_1)).apply {
            if (networkInterceptors().none { it is NoStatusRetry }) addNetworkInterceptor(NoStatusRetry())
        }.build()
    private class StatusIOException(val snapshot: HttpSnapshot, val response: HttpResponse) : IOException("Reacon returned HTTP ${snapshot.status}")
    private class NoStatusRetry : Interceptor {
        override fun intercept(chain: Interceptor.Chain): HttpResponse {
            val response = chain.proceed(chain.request())
            if (response.code == 503 && response.header("Retry-After", "")!!.matches(Regex("0+"))) {
                response.use {
                    val snapshot = capture(it)
                    throw StatusIOException(snapshot, it.newBuilder().body(snapshot.bytes.toResponseBody(it.body.contentType())).build())
                }
            }
            return response
        }
    }
    fun responseFromFailure(error: Throwable?): HttpResponse? = (error as? StatusIOException)?.response
    private fun capture(response: HttpResponse): HttpSnapshot = HttpSnapshot(response.code, response.headers.toMultimap(), response.body.bytes(),
        response.header("Content-Type", "")!!.substringBefore(';').trim().lowercase(), response.request.header("Accept") == "text/csv")
    private fun cancelled(cause: Throwable? = null): CancellationException = CancellationException("Reacon request cancelled").apply { if (cause != null) initCause(cause) }
    private fun failure(error: IOException, token: CancellationToken?): Throwable = when {
        token?.isCancelled == true || Thread.currentThread().isInterrupted -> cancelled(error)
        error is InterruptedIOException -> RequestTimeoutException(error)
        else -> RequestTransportException(error)
    }
    fun execute(factory: Call.Factory, request: Request, options: RequestOptions, fallback: Duration): HttpSnapshot {
        val millis = timeoutMillis(options.timeout ?: fallback)
        if (options.cancellation?.isCancelled == true) throw cancelled()
        val call = factory.newCall(request); call.timeout().timeout(millis, TimeUnit.MILLISECONDS)
        val registration = options.cancellation?.register { call.cancel() }
        try { return call.execute().use { capture(it) } }
        catch (error: StatusIOException) { return error.snapshot }
        catch (error: IOException) { throw failure(error, options.cancellation) }
        finally { registration?.close() }
    }
    suspend fun executeAsync(factory: Call.Factory, request: Request, options: RequestOptions, fallback: Duration): HttpSnapshot {
        val millis = timeoutMillis(options.timeout ?: fallback)
        currentCoroutineContext().ensureActive()
        if (options.cancellation?.isCancelled == true) throw cancelled()
        // withTimeoutOrNull handles only its own timeout; an outer timeout/cancel propagates unchanged.
        return withTimeoutOrNull(millis) {
            suspendCancellableCoroutine { continuation ->
                val call = factory.newCall(request); call.timeout().timeout(millis, TimeUnit.MILLISECONDS)
                val registration = options.cancellation?.register { call.cancel(); continuation.cancel(cancelled()) }
                continuation.invokeOnCancellation { call.cancel(); registration?.close() }
                call.enqueue(object : Callback {
                    override fun onFailure(call: Call, error: IOException) {
                        registration?.close()
                        if (!continuation.isActive) return
                        if (error is StatusIOException) continuation.resume(error.snapshot)
                        else continuation.resumeWithException(failure(error, options.cancellation))
                    }
                    override fun onResponse(call: Call, response: HttpResponse) {
                        try { val snapshot = response.use { capture(it) }; if (continuation.isActive) continuation.resume(snapshot) }
                        catch (error: IOException) { if (continuation.isActive) continuation.resumeWithException(failure(error, options.cancellation)) }
                        finally { registration?.close() }
                    }
                })
            }
        } ?: throw RequestTimeoutException(TimeoutException("Total request deadline expired"))
    }
    private fun utf8(bytes: ByteArray): String = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT)
        .onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bytes)).toString()
    fun parseError(bytes: ByteArray): JsonNode? = try { mapper.readTree(utf8(bytes)) } catch (_: Exception) { null }
    fun <T> decode(snapshot: HttpSnapshot, type: TypeReference<T>): ApiResponse<T?> {
        if (snapshot.status !in 200..299) {
            val body = snapshot.bytes.toString(Charsets.UTF_8)
            return if (snapshot.status < 500) ClientError("Reacon returned HTTP ${snapshot.status}", body, snapshot.status, snapshot.headers, snapshot.bytes)
            else ServerError("Reacon returned HTTP ${snapshot.status}", body, snapshot.status, snapshot.headers, snapshot.bytes)
        }
        try {
            val javaType = mapper.typeFactory.constructType(type)
            if (javaType.rawClass == Unit::class.java) return Success(null, snapshot.status, snapshot.headers)
            val text = utf8(snapshot.bytes)
            val value: T? = if (snapshot.csv) {
                require(snapshot.contentType == "text/csv" && javaType.rawClass == String::class.java) { "Expected CSV text" }
                @Suppress("UNCHECKED_CAST") (text as T)
            } else {
                require(snapshot.contentType == "application/json" || snapshot.contentType.matches(Regex("application/[a-z0-9!#$&^_.+-]+\\+json"))) { "Expected JSON" }
                val node = mapper.readTree(text)
                require(node != null && !node.isNull && !node.isMissingNode) { "Expected a response value" }
                mapper.readValue(text, type)
            }
            return Success(value, snapshot.status, snapshot.headers)
        } catch (error: Exception) { throw ResponseDecodeException(snapshot, error) }
    }
}
