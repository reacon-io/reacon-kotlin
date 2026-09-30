// Generated branch models retained by the Reacon object-union adapter.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonSerialize(using = MailExperimentVariant.Serializer::class)
@JsonDeserialize(using = MailExperimentVariant.Deserializer::class)
sealed class MailExperimentVariant {
    data class MailCadenceMessageExperimentVariant(val value: io.reacon.sdk.kotlin.models.MailCadenceMessageExperimentVariant) : MailExperimentVariant()
    data class MailCadenceWorkflowExperimentVariant(val value: io.reacon.sdk.kotlin.models.MailCadenceWorkflowExperimentVariant) : MailExperimentVariant()

    class Serializer : JsonSerializer<MailExperimentVariant>() {
        override fun serialize(value: MailExperimentVariant, generator: JsonGenerator, provider: SerializerProvider) {
            when (value) {
                is MailCadenceMessageExperimentVariant -> provider.defaultSerializeValue(value.value, generator)
                is MailCadenceWorkflowExperimentVariant -> provider.defaultSerializeValue(value.value, generator)
            }
        }
    }
    class Deserializer : JsonDeserializer<MailExperimentVariant>() {
        override fun getNullValue(context: DeserializationContext): MailExperimentVariant = throw JsonMappingException.from(context.parser, "MailExperimentVariant must be an object")
        override fun deserialize(parser: JsonParser, context: DeserializationContext): MailExperimentVariant {
            val tree = parser.codec.readTree<JsonNode>(parser)
            if (!tree.isObject) throw JsonMappingException.from(parser, "MailExperimentVariant must be an object")
            val keys = tree.fieldNames().asSequence().toSet()
            var lastFailure: Exception? = null
            if (true && setOf<String>("id", "name", "templateId", "templateVersion", "weight").all { it in keys }) {
                try { return MailCadenceMessageExperimentVariant(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceMessageExperimentVariant::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("id", "name", "nextNodeId", "weight").all { it in keys }) {
                try { return MailCadenceWorkflowExperimentVariant(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.MailCadenceWorkflowExperimentVariant::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            throw JsonMappingException.from(parser, "No declared MailExperimentVariant alternative matches", lastFailure)
        }
    }
}
