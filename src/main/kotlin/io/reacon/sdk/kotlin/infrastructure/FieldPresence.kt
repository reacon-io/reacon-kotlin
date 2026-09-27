package io.reacon.sdk.kotlin.infrastructure

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier

/** Wire-field presence is retained by data-class copy(), without changing nullable value types. */
interface FieldPresence {
    var reaconFieldPresence: Set<String>
    val reaconKnownFields: Set<String>
    val reaconRequiredFields: Set<String>
    fun reaconNullFields(): Set<String>
}

/** A nullable constructor default means absent. Use this to send an explicit JSON null. */
fun <T : FieldPresence> T.withExplicitNulls(vararg wireNames: String): T = apply {
    require(wireNames.all { it in reaconNullFields() }) { "Explicit-null fields must be known properties whose value is null" }
    reaconFieldPresence = reaconFieldPresence + wireNames
}

/** After copy(field = null), use this to omit an optional property instead of sending null. */
fun <T : FieldPresence> T.withOmittedFields(vararg wireNames: String): T = apply {
    require(wireNames.all { it in reaconNullFields() && it !in reaconRequiredFields }) { "Only optional properties with null values can be omitted" }
    reaconFieldPresence = reaconFieldPresence - wireNames.toSet()
}

class FieldPresenceModule : SimpleModule("ReaconFieldPresence") {
    init {
        setDeserializerModifier(object : BeanDeserializerModifier() {
            override fun modifyDeserializer(config: DeserializationConfig, description: BeanDescription, deserializer: JsonDeserializer<*>): JsonDeserializer<*> =
                if (FieldPresence::class.java.isAssignableFrom(description.beanClass)) PresenceDeserializer(deserializer) else deserializer
        })
        setSerializerModifier(object : BeanSerializerModifier() {
            override fun changeProperties(config: SerializationConfig, description: BeanDescription, properties: MutableList<BeanPropertyWriter>): MutableList<BeanPropertyWriter> {
                if (!FieldPresence::class.java.isAssignableFrom(description.beanClass)) return properties
                return properties.map { original ->
                    object : BeanPropertyWriter(original) {
                        override fun serializeAsField(bean: Any, generator: JsonGenerator, provider: SerializerProvider) {
                            if (bean is FieldPresence && get(bean) == null) {
                                if (name in bean.reaconFieldPresence) {
                                    generator.writeFieldName(name)
                                    provider.defaultSerializeNull(generator)
                                }
                            } else super.serializeAsField(bean, generator, provider)
                        }
                    }
                }.toMutableList()
            }
        })
    }
}

private class PresenceDeserializer(private val delegate: JsonDeserializer<*>) : DelegatingDeserializer(delegate) {
    override fun newDelegatingInstance(newDelegatee: JsonDeserializer<*>): JsonDeserializer<*> = PresenceDeserializer(newDelegatee)
    override fun deserialize(parser: JsonParser, context: DeserializationContext): Any {
        val tree = parser.codec.readTree<JsonNode>(parser)
        if (!tree.isObject) throw JsonMappingException.from(parser, "Expected a JSON object")
        val value = tree.traverse(parser.codec).use { replay -> replay.nextToken(); delegate.deserialize(replay, context) }
        if (value is FieldPresence) {
            val fields = tree.fieldNames().asSequence().toSet()
            val missing = value.reaconRequiredFields - fields
            if (missing.isNotEmpty()) throw JsonMappingException.from(parser, "Missing required properties: $missing")
            value.reaconFieldPresence = fields.intersect(value.reaconKnownFields)
        }
        return value
    }
}
