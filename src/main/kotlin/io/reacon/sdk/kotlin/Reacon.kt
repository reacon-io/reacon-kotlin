// Copyright Reacon contributors. Licensed under Apache-2.0.
package io.reacon.sdk.kotlin

import com.fasterxml.jackson.databind.JsonNode
import io.reacon.sdk.kotlin.apis.*
import io.reacon.sdk.kotlin.models.*
import io.reacon.sdk.kotlin.infrastructure.Serializer
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.channelFlow
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.sse.*
import java.io.Closeable
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

class ReaconProtocolException(message: String) : RuntimeException(message)
class ReaconTransportException : RuntimeException("Reacon stream transport failure")
class ReaconTimeoutException(val phase: String) : RuntimeException("Reacon $phase timeout")
class ReaconStreamApiException(val status: Int, val headers: Headers, val body: JsonNode?, val event: VerificationStreamError? = null) :
    RuntimeException(if (event == null) "Reacon returned HTTP $status" else "Reacon stream failed: ${event.code}") {
    val requestId: String? get() = headers["x-request-id"]
}
sealed interface VerificationEvent {
    val raw: JsonNode
    data class Stage(val data: VerificationStage, override val raw: JsonNode) : VerificationEvent
    data class Progress(val data: VerificationProgress, override val raw: JsonNode) : VerificationEvent
    data class Final(val data: VerificationFinal, override val raw: JsonNode) : VerificationEvent
    data class Unknown(override val raw: JsonNode) : VerificationEvent
}
data class StreamOptions(val onlyIfFree: String? = null, val cacheMaxAge: String? = null,
                         val idleTimeoutMillis: Long = 30_000, val totalTimeoutMillis: Long = 300_000)

/** Per-client authentication. An injected OkHttp client/pool remains caller-owned. */
class Reacon(apiKey: String, httpClient: OkHttpClient? = null) : Closeable {
    private val baseUrl: String = "https://api.reacon.io"
    private val owned = httpClient == null
    private val client: OkHttpClient
    val domains: DomainsApi
    val emails: EmailsApi
    val leads: LeadsApi
    val verification: VerificationApi
    init {
        require(apiKey.isNotEmpty()) { "apiKey is required" }
        client = (httpClient?.newBuilder() ?: OkHttpClient.Builder())
            .retryOnConnectionFailure(false).followRedirects(false).followSslRedirects(false)
            .addInterceptor { chain -> chain.proceed(chain.request().newBuilder().header("X-API-Key", apiKey).build()) }.build()
        domains = DomainsApi(client); emails = EmailsApi(client)
        leads = LeadsApi(client); verification = VerificationApi(client)
    }

    /** A cold Flow: collection starts one request. Cancellation/take() closes it.
     * One pending event is buffered; the OkHttp callback waits for downstream
     * demand beyond that bound. No reconnection or automatic replay occurs.
     */
    fun streamVerification(email: String, options: StreamOptions = StreamOptions()): Flow<VerificationEvent> = channelFlow {
        require(email.isNotEmpty() && options.idleTimeoutMillis > 0 && options.totalTimeoutMillis > 0)
        require(options.onlyIfFree in listOf(null, "true", "false"))
        require(options.cacheMaxAge in listOf(null, "live", "1d", "1w", "1m"))
        val url = (baseUrl.trimEnd('/') + "/v1/verify").toHttpUrl().newBuilder().addQueryParameter("email", email)
        options.onlyIfFree?.let { url.addQueryParameter("onlyIfFree", it) }
        options.cacheMaxAge?.let { url.addQueryParameter("cacheMaxAge", it) }
        val request = Request.Builder().url(url.build()).header("Accept", "text/event-stream").build()
        val transport = client.newBuilder().readTimeout(options.idleTimeoutMillis, TimeUnit.MILLISECONDS)
            .connectTimeout(minOf(options.idleTimeoutMillis, options.totalTimeoutMillis), TimeUnit.MILLISECONDS).build()
        val mapper = Serializer.jacksonObjectMapper
        var status = 200
        var headers = Headers.headersOf()
        val listener = object : EventSourceListener() {
            override fun onOpen(eventSource: EventSource, response: Response) { status = response.code; headers = response.headers }
            override fun onEvent(eventSource: EventSource, id: String?, type: String?, data: String) {
                try {
                    val raw = try { mapper.readTree(data) } catch (_: Exception) { throw ReaconProtocolException("Malformed SSE JSON payload") }
                    if (raw == null || !raw.isObject) throw ReaconProtocolException("Expected an SSE JSON object")
                    fun requireString(name: String) {
                        if (raw[name]?.isTextual != true) throw ReaconProtocolException("Malformed verification event")
                    }
                    if (listOf("error", "result", "stage", "state").any { raw.has(it) }) requireString("updatedAt")
                    if (raw.has("error")) {
                        requireString("error"); requireString("code")
                        val error = mapper.treeToValue(raw, VerificationStreamError::class.java)
                        close(ReaconStreamApiException(status, headers, raw, error)); eventSource.cancel(); return
                    }
                    val event = when {
                        raw.has("result") -> {
                            val result = raw["result"]
                            if (!result.isObject || result["status"]?.isTextual != true || result["catchAll"]?.isBoolean != true ||
                                result["disposable"]?.isBoolean != true || !result.has("acceptsAll") ||
                                !(result["acceptsAll"].isNull || result["acceptsAll"].isBoolean))
                                throw ReaconProtocolException("Malformed verification result event")
                            VerificationEvent.Final(mapper.treeToValue(raw, VerificationFinal::class.java), raw)
                        }
                        raw.has("stage") -> { requireString("stage"); VerificationEvent.Stage(mapper.treeToValue(raw, VerificationStage::class.java), raw) }
                        raw.has("state") -> { requireString("state"); requireString("requestId"); VerificationEvent.Progress(mapper.treeToValue(raw, VerificationProgress::class.java), raw) }
                        else -> VerificationEvent.Unknown(raw)
                    }
                    // OkHttp invokes this on its dispatcher thread; send blocks
                    // only that callback and is unblocked by channel cancellation.
                    runBlocking { send(event) }
                    if (event is VerificationEvent.Final) { close(); eventSource.cancel() }
                } catch (_: CancellationException) { eventSource.cancel() }
                catch (error: Exception) {
                    close(if (error is ReaconProtocolException) error else ReaconProtocolException("Malformed verification event"))
                    eventSource.cancel()
                }
            }
            override fun onClosed(eventSource: EventSource) { close(ReaconProtocolException("Verification stream ended before a terminal event")) }
            override fun onFailure(eventSource: EventSource, error: Throwable?, response: Response?) {
                if (response != null && !response.isSuccessful) {
                    val text = try { response.peekBody(65536).string() } catch (_: Exception) { "" }
                    val body = try { mapper.readTree(text) } catch (_: Exception) { mapper.valueToTree<JsonNode>(text) }
                    close(ReaconStreamApiException(response.code, response.headers, body))
                } else if (error is SocketTimeoutException) close(ReaconTimeoutException("idle"))
                else if (response != null && response.header("content-type")?.substringBefore(';')?.trim() != "text/event-stream")
                    close(ReaconProtocolException("Expected a text/event-stream response body"))
                else close(ReaconTransportException())
            }
        }
        val source = EventSources.createFactory(transport).newEventSource(request, listener)
        val deadline = launch {
            delay(options.totalTimeoutMillis)
            close(ReaconTimeoutException("total")); source.cancel()
        }
        awaitClose { deadline.cancel(); source.cancel() }
    }.buffer(1)

    override fun close() {
        if (owned) {
            client.dispatcher.cancelAll(); client.connectionPool.evictAll(); client.dispatcher.executorService.shutdown()
        }
    }
}
