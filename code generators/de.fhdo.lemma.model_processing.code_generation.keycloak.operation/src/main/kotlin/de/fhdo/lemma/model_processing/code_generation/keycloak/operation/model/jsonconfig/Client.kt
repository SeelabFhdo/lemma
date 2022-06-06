package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addAndCastTo
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.keycloakPropertiesKeyMapper


data class Client(
    val clientId: String,
) {
    private val properties: MutableMap<String, Any> = mutableMapOf()
    private val redirectUris: MutableList<String> = mutableListOf()

    fun addRedirectUris(redirectUris: List<String>) {
        this.redirectUris.addAll(redirectUris)
    }

    fun addRedirectUri(redirectUri: String) {
        this.redirectUris.add(redirectUri)
    }

    fun addProperties(properties: Map<String, Any>) {
        this.properties.putAll(properties)
    }

    fun addProperty(key: String, value: Any) {
        this.properties[key] = value
    }

    fun getClientAsJsonNode(): ObjectNode {
        val objectMapper = ObjectMapper()
        val clientNode = objectMapper.createObjectNode()
        properties.forEach {property ->
            when (property.key) {
                "accessType" -> {
                    AccessType.values().find { it.accessType == property.value }?.let {
                        AccessType.getProperties(it).forEach { (key, value) ->
                            clientNode.addAndCastTo(key, value)
                        }
                    }
                }
                else -> clientNode.addAndCastTo(keycloakPropertiesKeyMapper(property.key), property.value)
            }
        }
        val redirectUrisArrayNode = clientNode.putArray("redirectUris")
        redirectUris.forEach {
            redirectUrisArrayNode.add(it)
        }
        return clientNode
    }
}



enum class AccessType(val accessType: String) {
    PUBLIC("public"),
    CONFIDENTIAL("confidential"),
    BEARER_ONLY("bearer-only");

    companion object {
        internal fun getProperties(accessType: AccessType) = when (accessType) {
            PUBLIC -> mapOf("bearerOnly" to false, "publicClient" to true)
            CONFIDENTIAL -> mapOf("bearerOnly" to false, "publicClient" to false)
            BEARER_ONLY -> mapOf("bearerOnly" to true, "publicClient" to false)
        }
    }
}