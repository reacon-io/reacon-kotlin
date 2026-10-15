@file:Suppress("unused")
package io.reacon.sdk.kotlin.infrastructure

import java.lang.RuntimeException

open class ClientException(message: kotlin.String? = null, statusCode: Int = -1, response: Response? = null) : HttpResponseException(message, statusCode, response) {

    companion object {
        private const val serialVersionUID: Long = 123L
    }
}

open class ServerException(message: kotlin.String? = null, statusCode: Int = -1, response: Response? = null) : HttpResponseException(message, statusCode, response) {

    companion object {
        private const val serialVersionUID: Long = 456L
    }
}
