package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addAndCastTo
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.checkJsonKeyValue


data class Realm(val id: String) {
    private val properties: MutableMap<String, Any> = mutableMapOf()
//    val users: MutableSet<User> = mutableSetOf()
//    val groups: MutableSet<Group> = mutableSetOf()
//    val clients: MutableSet<Client> = mutableSetOf()
    lateinit var roles: Roles

    fun addRealmProperties(properties: Map<String, Any>) {
        this.properties.putAll(properties)
        this.properties["additionalJsonProperties"]?.let {
            this.addJsonConfig(it.toString())
            this.properties.remove("additionalJsonProperties")
        }
    }

    private fun addJsonConfig(jsonConfiguration: String) {
        if (checkJsonKeyValue(jsonConfiguration)) {
            properties.putAll(
                ObjectMapper().readValue(
                    jsonConfiguration,
                    object : TypeReference<Map<String, Any>>() {})
            )
        }
    }

    fun getRealmAsJsonString(): String {
        val realmNode = ObjectMapper().createObjectNode()
        realmNode.put("id", id)
        properties.forEach {
            realmNode.addAndCastTo(it.key, it.value)
        }
        realmNode.set<ObjectNode>("roles", roles.getRolesAsJsonNode())
        return ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(realmNode)
    }


}