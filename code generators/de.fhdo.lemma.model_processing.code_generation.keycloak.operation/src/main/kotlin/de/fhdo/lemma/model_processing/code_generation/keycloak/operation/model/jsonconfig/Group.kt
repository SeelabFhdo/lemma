package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

data class Group(
    val name: String,
){
    val realmRoles: MutableSet<String> = mutableSetOf()
    fun getGroupAsJsonNode(): ObjectNode {
        val objectMapper = ObjectMapper()
        val groupNode = objectMapper.createObjectNode()
        groupNode.put("name", name)
        val realmRolesArrayNode = groupNode.putArray("realmRoles")
        realmRoles.forEach {
            realmRolesArrayNode.add(it)
        }
        return groupNode
    }
}