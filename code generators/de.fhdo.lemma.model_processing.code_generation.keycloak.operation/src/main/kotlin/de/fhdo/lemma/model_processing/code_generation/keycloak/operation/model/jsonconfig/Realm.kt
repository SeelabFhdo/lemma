package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.checkJsonKeyValue

data class Realm(
    val id: String,
    val realm: String,
    val enabled: Boolean,
    val realmName: String,
    val roles: Roles,
    val users: MutableSet<User> = mutableSetOf(),
    val groups: MutableSet<Group> = mutableSetOf(),
    val clients: MutableSet<Client> = mutableSetOf(),
    val additionalProperties: MutableMap<String, Any> = mutableMapOf()
) {
    fun addJsonConfig(jsonConfiguration: String) {
        if (checkJsonKeyValue(jsonConfiguration)) {
            additionalProperties.putAll(
                ObjectMapper().readValue(
                    jsonConfiguration,
                    object : TypeReference<Map<String, Any>>() {})
            )
        }
    }

    fun getRealmAsJsonString() = realm to ObjectMapper().writeValueAsString(this)
}