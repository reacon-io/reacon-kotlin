package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/** Explicit IDs and/or selection scopes for the integration lead-export queue. */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueueIntegrationLeadExportRequest (
    @param:JsonProperty("leadIds") @get:JsonProperty("leadIds")
    val leadIds: List<String>? = null,
    @param:JsonProperty("selectionScopes") @get:JsonProperty("selectionScopes")
    val selectionScopes: List<QueueIntegrationLeadExportRequestSelectionScopesInner>? = null,
    @param:JsonProperty("deselectedLeadIds") @get:JsonProperty("deselectedLeadIds")
    val deselectedLeadIds: List<String>? = null,
    @param:JsonProperty("requestId") @get:JsonProperty("requestId")
    val requestId: String? = null,

    @get:com.fasterxml.jackson.annotation.JsonIgnore
    override var reaconFieldPresence: Set<String> = setOfNotNull(if (leadIds != null) "leadIds" else null, if (selectionScopes != null) "selectionScopes" else null, if (deselectedLeadIds != null) "deselectedLeadIds" else null, if (requestId != null) "requestId" else null),
) : io.reacon.sdk.kotlin.infrastructure.FieldPresence {

    @get:com.fasterxml.jackson.annotation.JsonIgnore
    override val reaconKnownFields: Set<String> get() = setOf("leadIds", "selectionScopes", "deselectedLeadIds", "requestId")
    @get:com.fasterxml.jackson.annotation.JsonIgnore
    override val reaconRequiredFields: Set<String> get() = setOf()
    override fun reaconNullFields(): Set<String> = setOfNotNull(if (leadIds == null) "leadIds" else null, if (selectionScopes == null) "selectionScopes" else null, if (deselectedLeadIds == null) "deselectedLeadIds" else null, if (requestId == null) "requestId" else null)

    init {
        require(leadIds != null || selectionScopes != null) { "leadIds or selectionScopes is required" }
        require(leadIds == null || leadIds.size in 1..10000) { "leadIds must contain 1–10000 IDs" }
        require(selectionScopes == null || selectionScopes.size <= 1000) { "selectionScopes must contain at most 1000 scopes" }
        require(deselectedLeadIds == null || deselectedLeadIds.size <= 10000) { "deselectedLeadIds must contain at most 10000 IDs" }
        require(requestId == null || requestId.codePointCount(0, requestId.length) in 8..220) { "requestId must contain 8–220 characters" }
    }
}
