package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.JsonNode
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

        properties.forEach { (key, value) ->
            when (key) {
                "realmRoles", "groups" -> {
                    val arrayNode = userNode.putArray(key)
                    (value as String).split(",").forEach {
                        arrayNode.add(it)
                    }
                }
                "clientRoles" -> {
                    val node = ObjectMapper().createObjectNode()
                    if (value is MutableMap<*, *>) {
                        value.forEach { clientRoles ->
                            val clientArrayNode = objectMapper.createArrayNode()
                            (clientRoles.value as Set<*>).forEach {
                                clientArrayNode.add(it as String)
                            }
                            node.set<JsonNode>(clientRoles.key as String, clientArrayNode)
                        }
                    }
                    userNode.set<JsonNode>(key, node)
                }
                "requiredActions" -> {
                    val arrayNode = userNode.putArray(key)
                    val requiredActions = (value as String).split(",")
                    requiredActions.forEach { requiredAction ->
                        RequiredActions.values().find { it.requiredActions == requiredAction.trim() }?.let {
                            arrayNode.add(it.name)
                        }
                    }
                }
                else -> {
                    userNode.addAndCastTo(key, value)
                }
            }
        }
        return userNode
    }
}

enum class RequiredActions(val requiredActions: String) {
    CONFIGURE_OTP("Configure_OTP"),
    UPDATE_PASSWORD("Update_Password"),
    UPDATE_PROFILE("Update_Profile"),
    VERIFY_EMAIL("Verify_Email"),
    UPDATE_USER_LOCALE("Update_User_Locale")
}