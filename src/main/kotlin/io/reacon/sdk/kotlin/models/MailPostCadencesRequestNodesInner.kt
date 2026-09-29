// Generated branch models retained by the Reacon object-union adapter.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonSerialize(using = MailPostCadencesRequestNodesInner.Serializer::class)
@JsonDeserialize(using = MailPostCadencesRequestNodesInner.Deserializer::class)
sealed class MailPostCadencesRequestNodesInner {
    data class MailPostCadencesRequestNodesInnerAnyOf(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf1(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf1) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf2(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf2) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf3(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf3) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf4(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf4) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf5(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf5) : MailPostCadencesRequestNodesInner()
    data class MailPostCadencesRequestNodesInnerAnyOf6(val value: io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf6) : MailPostCadencesRequestNodesInner()

    class Serializer : JsonSerializer<MailPostCadencesRequestNodesInner>() {
        override fun serialize(value: MailPostCadencesRequestNodesInner, generator: JsonGenerator, provider: SerializerProvider) {
            when (value) {
                is MailPostCadencesRequestNodesInnerAnyOf -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf1 -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf2 -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf3 -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf4 -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf5 -> provider.defaultSerializeValue(value.value, generator)
                is MailPostCadencesRequestNodesInnerAnyOf6 -> provider.defaultSerializeValue(value.value, generator)
            }
        }
    }
    class Deserializer : JsonDeserializer<MailPostCadencesRequestNodesInner>() {
        override fun getNullValue(context: DeserializationContext): MailPostCadencesRequestNodesInner = throw JsonMappingException.from(context.parser, "MailPostCadencesRequestNodesInner must be an object")
        override fun deserialize(parser: JsonParser, context: DeserializationContext): MailPostCadencesRequestNodesInner {
            val tree = parser.codec.readTree<JsonNode>(parser)
            if (!tree.isObject) throw JsonMappingException.from(parser, "MailPostCadencesRequestNodesInner must be an object")
            val keys = tree.fieldNames().asSequence().toSet()
            var lastFailure: Exception? = null
            if (keys.all { it in setOf<String>("id", "kind", "name", "nextNodeId") } && setOf<String>("id", "name", "kind", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"start\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("channel", "experiment", "id", "kind", "name", "nextNodeId", "templateId", "templateVersion") } && setOf<String>("id", "name", "kind", "channel", "templateId", "templateVersion", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"message\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf1(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf1::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("durationMs", "id", "kind", "name", "nextNodeId") } && setOf<String>("id", "name", "kind", "durationMs", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"wait\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf2(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf2::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("id", "kind", "name", "nextNodeId", "taskType", "title") } && setOf<String>("id", "name", "kind", "taskType", "title", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"task\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf3(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf3::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("condition", "falseNodeId", "id", "kind", "name", "trueNodeId") } && setOf<String>("id", "name", "kind", "condition", "trueNodeId", "falseNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"branch\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf4(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf4::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("experiment", "id", "kind", "name") } && setOf<String>("id", "name", "kind", "experiment").all { it in keys } && tree.get("kind")?.toString() == "\"experiment_split\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf5(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf5::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("id", "kind", "name", "outcome") } && setOf<String>("id", "name", "kind", "outcome").all { it in keys } && tree.get("kind")?.toString() == "\"stop\"") {
                try { return MailPostCadencesRequestNodesInnerAnyOf6(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailPostCadencesRequestNodesInnerAnyOf6::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            throw JsonMappingException.from(parser, "No declared MailPostCadencesRequestNodesInner alternative matches", lastFailure)
        }
    }
}
