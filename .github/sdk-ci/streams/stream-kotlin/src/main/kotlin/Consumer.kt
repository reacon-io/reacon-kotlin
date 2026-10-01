import okhttp3.HttpUrl.Companion.toHttpUrl
import io.reacon.sdk.kotlin.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    System.getenv("REACON_RETAINED_JAR")?.let { retained ->
        val location = java.nio.file.Paths.get(Reacon::class.java.protectionDomain.codeSource.location.toURI())
        check(java.nio.file.Files.mismatch(location, java.nio.file.Paths.get(retained)) == -1L) { "Streaming did not load the retained Kotlin JAR" }
        check(System.getProperty("java.specification.version") == System.getenv("REACON_EXPECTED_JAVA_MAJOR")) { "Unexpected Kotlin JVM runtime" }
        val mapper = io.reacon.sdk.kotlin.infrastructure.Serializer.jacksonObjectMapper
        val proof = mapper.createObjectNode()
            .put("specificationVersion", System.getProperty("java.specification.version"))
            .put("runtime", System.getProperty("java.runtime.version"))
            .put("installedJarMatchesRetained", true)
        java.io.File("/results/streaming-runtime.json").writeText(mapper.writeValueAsString(proof))
    }
    val url = System.getenv("REACON_TEST_URL")
    Reacon("synthetic-kotlin", fixtureHttp(url)).use { client ->
        Reacon("isolated-kotlin", fixtureHttp(url)).use { isolated ->
            client.streamVerification("never@example.test") // cold Flow sends nothing
            suspend fun collect(scenario: String, owner: Reacon = client, options: StreamOptions = StreamOptions(onlyIfFree = "true")) =
                owner.streamVerification("$scenario@example.test", options).toList()
            val success = async { collect("success") }; val isolation = async { collect("isolated", isolated) }
            for (events in listOf(success.await(), isolation.await())) {
                check(events.size == 4)
                check(events[0] is VerificationEvent.Stage && events[0].raw["label"].asText() == "hé🚀")
                check(events[1] is VerificationEvent.Unknown && events[1].raw["future"]["value"].asText() == "hé🚀")
                check(events[2] is VerificationEvent.Progress)
                val final = events[3] as VerificationEvent.Final
                check(final.data.result.acceptsAll == null && final.data.result.status == "future-status")
            }
            try { collect("error"); error("Missing terminal error") }
            catch (failure: ReaconStreamApiException) {
                check(failure.status == 200 && failure.event!!.code == "INSUFFICIENT_CREDITS")
                check(failure.event!!.remainingCredits!!.toDouble() == 0.0 && failure.requestId == "req-stream")
            }
            for ((scenario, status) in listOf("pre402" to 402, "pre429" to 429, "proxy" to 502, "redirect" to 307)) {
                try { collect(scenario); error("Missing HTTP error") }
                catch (failure: ReaconStreamApiException) {
                    check(failure.status == status)
                    if (status in listOf(402, 429)) check(failure.body!!["code"].asText() == "FIXTURE_ERROR" && failure.requestId == "req-stream")
                    if (status == 502) check(failure.requestId == null && failure.body!!.isTextual)
                }
            }
            for (scenario in listOf("wrongtype", "malformed", "invalidresult", "eof")) {
                try { collect(scenario); error("Missing protocol/transport error $scenario") }
                catch (_: ReaconProtocolException) { }
            }
            try { collect("disconnect"); error("Missing transport failure") }
            catch (_: ReaconTransportException) { }
            for (phase in listOf("idle", "total")) {
                try { collect(phase, options = StreamOptions(onlyIfFree = "true", idleTimeoutMillis = 80, totalTimeoutMillis = 200)); error("Missing timeout") }
                catch (failure: ReaconTimeoutException) { check(failure.phase == phase) }
            }
            try { collect("headers", options = StreamOptions(onlyIfFree = "true", idleTimeoutMillis = 80, totalTimeoutMillis = 200)); error("Missing header timeout") }
            catch (_: ReaconTimeoutException) { }
            val received = CompletableDeferred<Unit>()
            val job = launch { client.streamVerification("cancel@example.test", StreamOptions(onlyIfFree = "true")).collect { received.complete(Unit) } }
            received.await(); delay(20); job.cancelAndJoin()
            check(client.streamVerification("early@example.test", StreamOptions(onlyIfFree = "true")).take(1).toList().single() is VerificationEvent.Stage)
            check(java.net.URI.create(url + "/_assert_closed").toURL().readText().contains("\"closed\":true"))
        }
    }
    println("Kotlin streaming: framing, terminal/error, isolation, timeout, cancellation and early-close assertions passed")
}

// Test-only HTTP routing; the SDK must emit its fixed production origin.
fun fixtureHttp(target: String): okhttp3.OkHttpClient {
    val base = target.toHttpUrl()
    require(base.host == "127.0.0.1" || base.host == "localhost")
    val executor = java.util.concurrent.Executors.newCachedThreadPool { runnable -> Thread(runnable, "reacon-fixture-http").apply { isDaemon = true } }
    return okhttp3.OkHttpClient.Builder().dispatcher(okhttp3.Dispatcher(executor)).addInterceptor { chain ->
        val request = chain.request()
        check(request.url.scheme == "https" && request.url.host == "api.reacon.io")
        val url = base.newBuilder().encodedPath(base.encodedPath.trimEnd('/') + request.url.encodedPath).encodedQuery(request.url.encodedQuery).build()
        chain.proceed(request.newBuilder().url(url).build())
    }.build()
}
