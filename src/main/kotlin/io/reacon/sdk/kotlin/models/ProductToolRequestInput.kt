// Generated branch models retained by the Reacon object-union adapter.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonSerialize(using = ProductToolRequestInput.Serializer::class)
@JsonDeserialize(using = ProductToolRequestInput.Deserializer::class)
sealed class ProductToolRequestInput {
    data class ProductDiscoverCompaniesInput(val value: io.reacon.sdk.kotlin.models.ProductDiscoverCompaniesInput) : ProductToolRequestInput()
    data class ProductDiscoverPeopleInput(val value: io.reacon.sdk.kotlin.models.ProductDiscoverPeopleInput) : ProductToolRequestInput()
    data class ProductDomainFinderInput(val value: io.reacon.sdk.kotlin.models.ProductDomainFinderInput) : ProductToolRequestInput()
    data class ProductEmailCountInput(val value: io.reacon.sdk.kotlin.models.ProductEmailCountInput) : ProductToolRequestInput()
    data class ProductPersonEnrichInput(val value: io.reacon.sdk.kotlin.models.ProductPersonEnrichInput) : ProductToolRequestInput()
    object Empty : ProductToolRequestInput()
    data class ProductLeadsListInput(val value: io.reacon.sdk.kotlin.models.ProductLeadsListInput) : ProductToolRequestInput()
    data class ProductLeadGetInput(val value: io.reacon.sdk.kotlin.models.ProductLeadGetInput) : ProductToolRequestInput()
    data class ProductLeadCreateInput(val value: io.reacon.sdk.kotlin.models.ProductLeadCreateInput) : ProductToolRequestInput()
    data class ProductLeadUpdateInput(val value: io.reacon.sdk.kotlin.models.ProductLeadUpdateInput) : ProductToolRequestInput()
    data class ProductLeadDeleteInput(val value: io.reacon.sdk.kotlin.models.ProductLeadDeleteInput) : ProductToolRequestInput()
    data class ProductLeadBulkDeleteInput(val value: io.reacon.sdk.kotlin.models.ProductLeadBulkDeleteInput) : ProductToolRequestInput()
    data class ProductLeadTagCreateInput(val value: io.reacon.sdk.kotlin.models.ProductLeadTagCreateInput) : ProductToolRequestInput()
    data class ProductLeadTagAssignInput(val value: io.reacon.sdk.kotlin.models.ProductLeadTagAssignInput) : ProductToolRequestInput()
    data class ProductCustomAttributeCreateInput(val value: io.reacon.sdk.kotlin.models.ProductCustomAttributeCreateInput) : ProductToolRequestInput()
    data class ProductLeadListUpdateInput(val value: io.reacon.sdk.kotlin.models.ProductLeadListUpdateInput) : ProductToolRequestInput()
    data class ProductLeadListDeleteInput(val value: io.reacon.sdk.kotlin.models.ProductLeadListDeleteInput) : ProductToolRequestInput()
    data class ProductLeadListAddLeadInput(val value: io.reacon.sdk.kotlin.models.ProductLeadListAddLeadInput) : ProductToolRequestInput()
    data class ProductCompaniesListInput(val value: io.reacon.sdk.kotlin.models.ProductCompaniesListInput) : ProductToolRequestInput()
    data class ProductCompanyTrackInput(val value: io.reacon.sdk.kotlin.models.ProductCompanyTrackInput) : ProductToolRequestInput()
    data class ProductCompanyUpdateInput(val value: io.reacon.sdk.kotlin.models.ProductCompanyUpdateInput) : ProductToolRequestInput()
    data class ProductCompanyDeleteInput(val value: io.reacon.sdk.kotlin.models.ProductCompanyDeleteInput) : ProductToolRequestInput()
    data class ProductCompanyListAddInput(val value: io.reacon.sdk.kotlin.models.ProductCompanyListAddInput) : ProductToolRequestInput()
    data class ProductSequenceRecipientsListInput(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientsListInput) : ProductToolRequestInput()
    data class ProductSequenceRecipientsAddInput(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientsAddInput) : ProductToolRequestInput()
    data class ProductSequenceRecipientAddInput(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientAddInput) : ProductToolRequestInput()
    data class ProductSequenceRecipientCancelInput(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientCancelInput) : ProductToolRequestInput()
    data class ProductSequenceStartInput(val value: io.reacon.sdk.kotlin.models.ProductSequenceStartInput) : ProductToolRequestInput()
    data class ProductConnectedAppPushInput(val value: io.reacon.sdk.kotlin.models.ProductConnectedAppPushInput) : ProductToolRequestInput()

    class Serializer : JsonSerializer<ProductToolRequestInput>() {
        override fun serialize(value: ProductToolRequestInput, generator: JsonGenerator, provider: SerializerProvider) {
            when (value) {
                is ProductDiscoverCompaniesInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductDiscoverPeopleInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductDomainFinderInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductEmailCountInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductPersonEnrichInput -> provider.defaultSerializeValue(value.value, generator)
                Empty -> { generator.writeStartObject(); generator.writeEndObject() }
                is ProductLeadsListInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadGetInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadCreateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadUpdateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadDeleteInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadBulkDeleteInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagCreateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagAssignInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCustomAttributeCreateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListUpdateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListDeleteInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListAddLeadInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompaniesListInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyTrackInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyUpdateInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyDeleteInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyListAddInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientsListInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientsAddInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientAddInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientCancelInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceStartInput -> provider.defaultSerializeValue(value.value, generator)
                is ProductConnectedAppPushInput -> provider.defaultSerializeValue(value.value, generator)
            }
        }
    }
    class Deserializer : JsonDeserializer<ProductToolRequestInput>() {
        override fun getNullValue(context: DeserializationContext): ProductToolRequestInput = throw JsonMappingException.from(context.parser, "ProductToolRequestInput must be an object")
        override fun deserialize(parser: JsonParser, context: DeserializationContext): ProductToolRequestInput {
            val tree = parser.codec.readTree<JsonNode>(parser)
            if (!tree.isObject) throw JsonMappingException.from(parser, "ProductToolRequestInput must be an object")
            val keys = tree.fieldNames().asSequence().toSet()
            var lastFailure: Exception? = null
            if (keys.all { it in setOf<String>("industry", "limit", "location", "query") } && setOf<String>().all { it in keys }) {
                try { return ProductDiscoverCompaniesInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDiscoverCompaniesInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("domain", "jobTitle", "limit", "query") } && setOf<String>().all { it in keys }) {
                try { return ProductDiscoverPeopleInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDiscoverPeopleInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("company") } && setOf<String>("company").all { it in keys }) {
                try { return ProductDomainFinderInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDomainFinderInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("domain") } && setOf<String>("domain").all { it in keys }) {
                try { return ProductEmailCountInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductEmailCountInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("email") } && setOf<String>("email").all { it in keys }) {
                try { return ProductPersonEnrichInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductPersonEnrichInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>() } && setOf<String>().all { it in keys }) {
                return Empty
            }
            if (keys.all { it in setOf<String>("limit", "listId", "offset") } && setOf<String>().all { it in keys }) {
                try { return ProductLeadsListInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadsListInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("leadId") } && setOf<String>("leadId").all { it in keys }) {
                try { return ProductLeadGetInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadGetInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("attributes", "company", "email", "firstName", "idempotencyKey", "lastName", "position") } && setOf<String>("email", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadCreateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadCreateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("attributes", "company", "firstName", "idempotencyKey", "lastName", "leadId", "position") } && setOf<String>("leadId", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadUpdateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadUpdateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "leadId") } && setOf<String>("leadId", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadDeleteInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadDeleteInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "leadIds") } && setOf<String>("leadIds", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadBulkDeleteInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadBulkDeleteInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "name") } && setOf<String>("name", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadTagCreateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagCreateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "leadId", "tagId") } && setOf<String>("leadId", "tagId", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadTagAssignInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagAssignInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "key", "name") } && setOf<String>("name", "key", "idempotencyKey").all { it in keys }) {
                try { return ProductCustomAttributeCreateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCustomAttributeCreateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "listId", "name") } && setOf<String>("listId", "name", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadListUpdateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListUpdateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "listId") } && setOf<String>("listId", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadListDeleteInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListDeleteInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "leadId", "listId") } && setOf<String>("listId", "leadId", "idempotencyKey").all { it in keys }) {
                try { return ProductLeadListAddLeadInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListAddLeadInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("limit", "offset") } && setOf<String>().all { it in keys }) {
                try { return ProductCompaniesListInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompaniesListInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("domain", "idempotencyKey", "name") } && setOf<String>("domain", "idempotencyKey").all { it in keys }) {
                try { return ProductCompanyTrackInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyTrackInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("companyId", "employeeRange", "idempotencyKey", "industry", "name") } && setOf<String>("companyId", "idempotencyKey").all { it in keys }) {
                try { return ProductCompanyUpdateInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyUpdateInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("companyId", "idempotencyKey") } && setOf<String>("companyId", "idempotencyKey").all { it in keys }) {
                try { return ProductCompanyDeleteInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyDeleteInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("companyId", "idempotencyKey", "listId") } && setOf<String>("listId", "companyId", "idempotencyKey").all { it in keys }) {
                try { return ProductCompanyListAddInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyListAddInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("sequenceId") } && setOf<String>("sequenceId").all { it in keys }) {
                try { return ProductSequenceRecipientsListInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientsListInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "recipients", "sequenceId") } && setOf<String>("sequenceId", "recipients", "idempotencyKey").all { it in keys }) {
                try { return ProductSequenceRecipientsAddInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientsAddInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("email", "idempotencyKey", "leadId", "sequenceId") } && setOf<String>("sequenceId", "email", "idempotencyKey").all { it in keys }) {
                try { return ProductSequenceRecipientAddInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientAddInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "recipientId") } && setOf<String>("recipientId", "idempotencyKey").all { it in keys }) {
                try { return ProductSequenceRecipientCancelInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientCancelInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("idempotencyKey", "sequenceId") } && setOf<String>("sequenceId", "idempotencyKey").all { it in keys }) {
                try { return ProductSequenceStartInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceStartInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (keys.all { it in setOf<String>("connectionId", "idempotencyKey", "leadIds") } && setOf<String>("connectionId", "leadIds", "idempotencyKey").all { it in keys }) {
                try { return ProductConnectedAppPushInput(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductConnectedAppPushInput::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            throw JsonMappingException.from(parser, "No declared ProductToolRequestInput alternative matches", lastFailure)
        }
    }
}
