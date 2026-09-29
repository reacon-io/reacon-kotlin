// Generated branch models retained by the Reacon object-union adapter.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonSerialize(using = MailCadenceNode.Serializer::class)
@JsonDeserialize(using = MailCadenceNode.Deserializer::class)
sealed class MailCadenceNode {
    data class MailCadenceNodeAnyOf(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf) : MailCadenceNode()
    data class MailCadenceNodeAnyOf1(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf1) : MailCadenceNode()
    data class MailCadenceNodeAnyOf2(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf2) : MailCadenceNode()
    data class MailCadenceNodeAnyOf3(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf3) : MailCadenceNode()
    data class MailCadenceNodeAnyOf4(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf4) : MailCadenceNode()
    data class MailCadenceNodeAnyOf5(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf5) : MailCadenceNode()
    data class MailCadenceNodeAnyOf6(val value: io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf6) : MailCadenceNode()

    class Serializer : JsonSerializer<MailCadenceNode>() {
        override fun serialize(value: MailCadenceNode, generator: JsonGenerator, provider: SerializerProvider) {
            when (value) {
                is MailCadenceNodeAnyOf -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf1 -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf2 -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf3 -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf4 -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf5 -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceNodeAnyOf6 -> provider.defaultSerializeValue(value.value, generator)
            }
        }
    }
    class Deserializer : JsonDeserializer<MailCadenceNode>() {
        override fun getNullValue(context: DeserializationContext): MailCadenceNode = throw JsonMappingException.from(context.parser, "MailCadenceNode must be an object")
        override fun deserialize(parser: JsonParser, context: DeserializationContext): MailCadenceNode {
            val tree = parser.codec.readTree<JsonNode>(parser)
            if (!tree.isObject) throw JsonMappingException.from(parser, "MailCadenceNode must be an object")
            val keys = tree.fieldNames().asSequence().toSet()
            var lastFailure: Exception? = null
            if (true && setOf<String>("id", "name", "kind", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"start\"") {
                try { return MailCadenceNodeAnyOf(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "channel", "kind", "nextNodeId", "templateId", "templateVersion").all { it in keys } && tree.get("kind")?.toString() == "\"message\"") {
                try { return MailCadenceNodeAnyOf1(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf1::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "durationMs", "kind", "nextNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"wait\"") {
                try { return MailCadenceNodeAnyOf2(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf2::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "kind", "nextNodeId", "taskType", "title").all { it in keys } && tree.get("kind")?.toString() == "\"task\"") {
                try { return MailCadenceNodeAnyOf3(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf3::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "condition", "falseNodeId", "kind", "trueNodeId").all { it in keys } && tree.get("kind")?.toString() == "\"branch\"") {
                try { return MailCadenceNodeAnyOf4(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf4::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "experiment", "kind").all { it in keys } && tree.get("kind")?.toString() == "\"experiment_split\"") {
                try { return MailCadenceNodeAnyOf5(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf5::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "kind", "outcome").all { it in keys } && tree.get("kind")?.toString() == "\"stop\"") {
                try { return MailCadenceNodeAnyOf6(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceNodeAnyOf6::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            throw JsonMappingException.from(parser, "No declared MailCadenceNode alternative matches", lastFailure)
        }
    }
}
