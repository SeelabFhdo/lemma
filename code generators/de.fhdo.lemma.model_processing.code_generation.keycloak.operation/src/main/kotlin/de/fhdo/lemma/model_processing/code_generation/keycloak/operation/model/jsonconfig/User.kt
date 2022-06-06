package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addAndCastTo

data class User(
    val username: String,
    val properties: Map<String, Any>
) {
    fun getUserAsJsonNode(): ObjectNode {
        val objectMapper = ObjectMapper()
        val userNode = objectMapper.createObjectNode()

        properties.forEach { key, value ->
            when (key) {
                "realmRoles", "groups" -> {
                    val arrayNode = userNode.putArray(key)
                    (value as String).split(",").forEach {
                        arrayNode.add(it)
                    }
                }
                "clientRoles" -> {

                }
                else -> {userNode.addAndCastTo(key, value)}
            }
        }
        return userNode
    }
}


enum class UserActions {
    CONFIGURE_OTP, UPDATE_PASSWORD, UPDATE_PROFILE, VERIFY_EMAIL, UPDATE_USER_LOCALE
}