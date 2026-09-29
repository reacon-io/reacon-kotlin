// Generated branch models retained by the Reacon object-union adapter.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonSerialize(using = ProductToolExecution.Serializer::class)
@JsonDeserialize(using = ProductToolExecution.Deserializer::class)
sealed class ProductToolExecution {
    data class ProductDiscoverCompaniesExecution(val value: io.reacon.sdk.kotlin.models.ProductDiscoverCompaniesExecution) : ProductToolExecution()
    data class ProductDiscoverPeopleExecution(val value: io.reacon.sdk.kotlin.models.ProductDiscoverPeopleExecution) : ProductToolExecution()
    data class ProductDomainFinderExecution(val value: io.reacon.sdk.kotlin.models.ProductDomainFinderExecution) : ProductToolExecution()
    data class ProductEmailCountExecution(val value: io.reacon.sdk.kotlin.models.ProductEmailCountExecution) : ProductToolExecution()
    data class ProductPersonEnrichExecution(val value: io.reacon.sdk.kotlin.models.ProductPersonEnrichExecution) : ProductToolExecution()
    data class ProductCompanyEnrichExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyEnrichExecution) : ProductToolExecution()
    data class ProductCombinedEnrichExecution(val value: io.reacon.sdk.kotlin.models.ProductCombinedEnrichExecution) : ProductToolExecution()
    data class ProductSavedSearchesListExecution(val value: io.reacon.sdk.kotlin.models.ProductSavedSearchesListExecution) : ProductToolExecution()
    data class ProductLeadsListExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadsListExecution) : ProductToolExecution()
    data class ProductLeadGetExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadGetExecution) : ProductToolExecution()
    data class ProductLeadCreateExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadCreateExecution) : ProductToolExecution()
    data class ProductLeadUpdateExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadUpdateExecution) : ProductToolExecution()
    data class ProductLeadUpsertExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadUpsertExecution) : ProductToolExecution()
    data class ProductLeadDeleteExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadDeleteExecution) : ProductToolExecution()
    data class ProductLeadEnrichExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadEnrichExecution) : ProductToolExecution()
    data class ProductLeadBulkDeleteExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadBulkDeleteExecution) : ProductToolExecution()
    data class ProductLeadTagsListExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadTagsListExecution) : ProductToolExecution()
    data class ProductLeadTagCreateExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadTagCreateExecution) : ProductToolExecution()
    data class ProductLeadTagAssignExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadTagAssignExecution) : ProductToolExecution()
    data class ProductLeadTagRemoveExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadTagRemoveExecution) : ProductToolExecution()
    data class ProductCustomAttributesListExecution(val value: io.reacon.sdk.kotlin.models.ProductCustomAttributesListExecution) : ProductToolExecution()
    data class ProductCustomAttributeCreateExecution(val value: io.reacon.sdk.kotlin.models.ProductCustomAttributeCreateExecution) : ProductToolExecution()
    data class ProductLeadListsListExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListsListExecution) : ProductToolExecution()
    data class ProductLeadListCreateExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListCreateExecution) : ProductToolExecution()
    data class ProductLeadListUpdateExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListUpdateExecution) : ProductToolExecution()
    data class ProductLeadListDeleteExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListDeleteExecution) : ProductToolExecution()
    data class ProductLeadListAddLeadExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListAddLeadExecution) : ProductToolExecution()
    data class ProductLeadListRemoveLeadExecution(val value: io.reacon.sdk.kotlin.models.ProductLeadListRemoveLeadExecution) : ProductToolExecution()
    data class ProductCompaniesListExecution(val value: io.reacon.sdk.kotlin.models.ProductCompaniesListExecution) : ProductToolExecution()
    data class ProductCompanyTrackExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyTrackExecution) : ProductToolExecution()
    data class ProductCompanyUpdateExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyUpdateExecution) : ProductToolExecution()
    data class ProductCompanyDeleteExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyDeleteExecution) : ProductToolExecution()
    data class ProductCompanyListsListExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyListsListExecution) : ProductToolExecution()
    data class ProductCompanyListCreateExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyListCreateExecution) : ProductToolExecution()
    data class ProductCompanyListAddExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyListAddExecution) : ProductToolExecution()
    data class ProductCompanyListRemoveExecution(val value: io.reacon.sdk.kotlin.models.ProductCompanyListRemoveExecution) : ProductToolExecution()
    data class ProductSequencesListExecution(val value: io.reacon.sdk.kotlin.models.ProductSequencesListExecution) : ProductToolExecution()
    data class ProductSequenceRecipientsListExecution(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientsListExecution) : ProductToolExecution()
    data class ProductSequenceRecipientsAddExecution(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientsAddExecution) : ProductToolExecution()
    data class ProductSequenceRecipientAddExecution(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientAddExecution) : ProductToolExecution()
    data class ProductSequenceRecipientCancelExecution(val value: io.reacon.sdk.kotlin.models.ProductSequenceRecipientCancelExecution) : ProductToolExecution()
    data class ProductSequenceStartExecution(val value: io.reacon.sdk.kotlin.models.ProductSequenceStartExecution) : ProductToolExecution()
    data class ProductAccountInfoExecution(val value: io.reacon.sdk.kotlin.models.ProductAccountInfoExecution) : ProductToolExecution()
    data class ProductUsageExecution(val value: io.reacon.sdk.kotlin.models.ProductUsageExecution) : ProductToolExecution()
    data class ProductUsageHistoryExecution(val value: io.reacon.sdk.kotlin.models.ProductUsageHistoryExecution) : ProductToolExecution()
    data class ProductTeamMembersExecution(val value: io.reacon.sdk.kotlin.models.ProductTeamMembersExecution) : ProductToolExecution()
    data class ProductConnectedAppsExecution(val value: io.reacon.sdk.kotlin.models.ProductConnectedAppsExecution) : ProductToolExecution()
    data class ProductConnectedAppPushExecution(val value: io.reacon.sdk.kotlin.models.ProductConnectedAppPushExecution) : ProductToolExecution()

    class Serializer : JsonSerializer<ProductToolExecution>() {
        override fun serialize(value: ProductToolExecution, generator: JsonGenerator, provider: SerializerProvider) {
            when (value) {
                is ProductDiscoverCompaniesExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductDiscoverPeopleExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductDomainFinderExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductEmailCountExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductPersonEnrichExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyEnrichExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCombinedEnrichExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSavedSearchesListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadsListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadGetExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadCreateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadUpdateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadUpsertExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadDeleteExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadEnrichExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadBulkDeleteExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagsListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagCreateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagAssignExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadTagRemoveExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCustomAttributesListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCustomAttributeCreateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListsListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListCreateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListUpdateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListDeleteExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListAddLeadExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductLeadListRemoveLeadExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompaniesListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyTrackExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyUpdateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyDeleteExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyListsListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyListCreateExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyListAddExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductCompanyListRemoveExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequencesListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientsListExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientsAddExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientAddExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceRecipientCancelExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductSequenceStartExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductAccountInfoExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductUsageExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductUsageHistoryExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductTeamMembersExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductConnectedAppsExecution -> provider.defaultSerializeValue(value.value, generator)
                is ProductConnectedAppPushExecution -> provider.defaultSerializeValue(value.value, generator)
            }
        }
    }
    class Deserializer : JsonDeserializer<ProductToolExecution>() {
        override fun getNullValue(context: DeserializationContext): ProductToolExecution = throw JsonMappingException.from(context.parser, "ProductToolExecution must be an object")
        override fun deserialize(parser: JsonParser, context: DeserializationContext): ProductToolExecution {
            val tree = parser.codec.readTree<JsonNode>(parser)
            if (!tree.isObject) throw JsonMappingException.from(parser, "ProductToolExecution must be an object")
            val keys = tree.fieldNames().asSequence().toSet()
            var lastFailure: Exception? = null
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"discover_companies\"") {
                try { return ProductDiscoverCompaniesExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDiscoverCompaniesExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"discover_people\"") {
                try { return ProductDiscoverPeopleExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDiscoverPeopleExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"domain_finder\"") {
                try { return ProductDomainFinderExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductDomainFinderExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"email_count\"") {
                try { return ProductEmailCountExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductEmailCountExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"person_enrich\"") {
                try { return ProductPersonEnrichExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductPersonEnrichExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"company_enrich\"") {
                try { return ProductCompanyEnrichExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyEnrichExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"combined_enrich\"") {
                try { return ProductCombinedEnrichExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCombinedEnrichExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"saved_searches_list\"") {
                try { return ProductSavedSearchesListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSavedSearchesListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"leads_list\"") {
                try { return ProductLeadsListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadsListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"lead_get\"") {
                try { return ProductLeadGetExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadGetExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_create\"") {
                try { return ProductLeadCreateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadCreateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_update\"") {
                try { return ProductLeadUpdateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadUpdateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_upsert\"") {
                try { return ProductLeadUpsertExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadUpsertExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_delete\"") {
                try { return ProductLeadDeleteExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadDeleteExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_enrich\"") {
                try { return ProductLeadEnrichExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadEnrichExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_bulk_delete\"") {
                try { return ProductLeadBulkDeleteExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadBulkDeleteExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"lead_tags_list\"") {
                try { return ProductLeadTagsListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagsListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_tag_create\"") {
                try { return ProductLeadTagCreateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagCreateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_tag_assign\"") {
                try { return ProductLeadTagAssignExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagAssignExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_tag_remove\"") {
                try { return ProductLeadTagRemoveExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadTagRemoveExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"custom_attributes_list\"") {
                try { return ProductCustomAttributesListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCustomAttributesListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"custom_attribute_create\"") {
                try { return ProductCustomAttributeCreateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCustomAttributeCreateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"lead_lists_list\"") {
                try { return ProductLeadListsListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListsListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_list_create\"") {
                try { return ProductLeadListCreateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListCreateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_list_update\"") {
                try { return ProductLeadListUpdateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListUpdateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_list_delete\"") {
                try { return ProductLeadListDeleteExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListDeleteExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_list_add_lead\"") {
                try { return ProductLeadListAddLeadExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListAddLeadExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"lead_list_remove_lead\"") {
                try { return ProductLeadListRemoveLeadExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductLeadListRemoveLeadExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"companies_list\"") {
                try { return ProductCompaniesListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompaniesListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_track\"") {
                try { return ProductCompanyTrackExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyTrackExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_update\"") {
                try { return ProductCompanyUpdateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyUpdateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_delete\"") {
                try { return ProductCompanyDeleteExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyDeleteExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"company_lists_list\"") {
                try { return ProductCompanyListsListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyListsListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_list_create\"") {
                try { return ProductCompanyListCreateExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyListCreateExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_list_add\"") {
                try { return ProductCompanyListAddExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyListAddExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"company_list_remove\"") {
                try { return ProductCompanyListRemoveExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductCompanyListRemoveExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"sequences_list\"") {
                try { return ProductSequencesListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequencesListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"sequence_recipients_list\"") {
                try { return ProductSequenceRecipientsListExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientsListExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"sequence_recipients_add\"") {
                try { return ProductSequenceRecipientsAddExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientsAddExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"sequence_recipient_add\"") {
                try { return ProductSequenceRecipientAddExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientAddExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"sequence_recipient_cancel\"") {
                try { return ProductSequenceRecipientCancelExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceRecipientCancelExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"sequence_start\"") {
                try { return ProductSequenceStartExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductSequenceStartExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"account_info\"") {
                try { return ProductAccountInfoExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductAccountInfoExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"usage\"") {
                try { return ProductUsageExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductUsageExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"usage_history\"") {
                try { return ProductUsageHistoryExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductUsageHistoryExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"team_members\"") {
                try { return ProductTeamMembersExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductTeamMembersExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("replay")?.toString() == "false" && tree.get("tool")?.toString() == "\"connected_apps\"") {
                try { return ProductConnectedAppsExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductConnectedAppsExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            if (true && setOf<String>("executionId", "tool", "replay", "output").all { it in keys } && tree.get("tool")?.toString() == "\"connected_app_push\"") {
                try { return ProductConnectedAppPushExecution(parser.codec.treeToValue(tree, io.reacon.sdk.kotlin.models.ProductConnectedAppPushExecution::class.java)) } catch (error: com.fasterxml.jackson.core.JacksonException) { lastFailure = error }
            }
            throw JsonMappingException.from(parser, "No declared ProductToolExecution alternative matches", lastFailure)
        }
    }
}
