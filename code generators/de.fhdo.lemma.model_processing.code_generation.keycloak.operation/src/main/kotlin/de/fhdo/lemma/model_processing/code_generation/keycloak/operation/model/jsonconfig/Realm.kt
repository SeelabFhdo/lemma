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
        realmNode.put("id", id)
        properties.forEach{
            realmNode.addAndCastTo(it.key, it.value)
        }
        return ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(realmNode)
    }

    private fun ObjectNode.addAndCastTo(key: String, value: Any) = when(value){
        is Int -> this.put(key, value as Int)
        is Long -> this.put(key, value as Long)
        is Double -> this.put(key, value as Double)
        is String -> this.put(key, value as String)
        is Boolean -> this.put(key, value as Boolean)
        else -> this.put(key, value.toString())
    }
}