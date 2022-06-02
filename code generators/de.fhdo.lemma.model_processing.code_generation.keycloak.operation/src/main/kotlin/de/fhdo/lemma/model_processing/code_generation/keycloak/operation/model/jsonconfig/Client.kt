package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.reflect.full.memberProperties

data class Client(
    val clientId: String,
    val name: String,
    val accessType: AccessType,
    val clientRoles: ClientRole,
    val additionalProperties: MutableMap<String, Any> = mutableMapOf<String, Any>()
) {
    fun getClientAsJsonString(): Pair<String, String> {
        val clientAsMap = mutableMapOf<String, Any>()
        Client::class.memberProperties.forEach { memberProperty ->
            when (memberProperty.name) {
                "accessType" -> clientAsMap.putAll(AccessType.getProperties(accessType))
                "additionalProperties" -> clientAsMap.putAll(additionalProperties.filterValues { it != null })
                else -> memberProperty.get(this)?.let { clientAsMap.put(memberProperty.name, it) }
            }
        }
        return name to ObjectMapper().writeValueAsString(clientAsMap)
    }
}

enum class AccessType(val accessType: String) {
    PUBLIC("public"),
    CONFIDENTIAL("confidential"),
    BEARER_ONLY("bearer-only");

    companion object {
        internal fun getProperties(accessType: AccessType) = when (accessType) {
            PUBLIC -> mapOf<String, Any>("bearerOnly" to false, "publicClient" to true)
            CONFIDENTIAL -> mapOf<String, Any>("bearerOnly" to false, "publicClient" to false)
            BEARER_ONLY -> mapOf<String, Any>("bearerOnly" to true, "publicClient" to false)
        }
    }
}