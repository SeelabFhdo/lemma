package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.checkJsonKeyValue


class Realm {
    lateinit var id: String
    val properties: MutableMap<String, Any> = mutableMapOf()
//    val users: MutableSet<User> = mutableSetOf()
//    val groups: MutableSet<Group> = mutableSetOf()
//    val clients: MutableSet<Client> = mutableSetOf()
//    lateinit var roles: Roles

    fun addRealmProperties(properties: Map<String, Any>) {
        id = "test"
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
        properties.forEach{
            realmNode.put(it.key, addAndCastTo(it.value))
        }
        return realmNode.asText()
    }

    private fun ObjectNode.addAndCastTo(value: Any) = when(value){
        is Int -> this.put value as Int
        is Long -> value as Long
        is Double -> value as Double
        is String -> value as String
        is Boolean -> value as Boolean
        else -> value.toString()
    }


}