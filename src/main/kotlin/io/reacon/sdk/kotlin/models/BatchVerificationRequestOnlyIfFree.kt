// Copyright Reacon contributors. Licensed under Apache-2.0.
package io.reacon.sdk.kotlin.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode

/** A boolean or the literal string "true" or "false", preserving its JSON type. */
class BatchVerificationRequestOnlyIfFree private constructor(@get:JsonValue val value: Any) {
    constructor(value: Boolean) : this(value as Any)
    constructor(value: String) : this(value as Any) {
        require(value == "true" || value == "false") { "Expected the string true or false" }
    }

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun fromJson(value: JsonNode): BatchVerificationRequestOnlyIfFree = when {
            value.isBoolean -> BatchVerificationRequestOnlyIfFree(value.booleanValue())
            value.isTextual -> BatchVerificationRequestOnlyIfFree(value.textValue())
            else -> throw IllegalArgumentException("Expected a boolean or the string true or false")
        }
    }
}
