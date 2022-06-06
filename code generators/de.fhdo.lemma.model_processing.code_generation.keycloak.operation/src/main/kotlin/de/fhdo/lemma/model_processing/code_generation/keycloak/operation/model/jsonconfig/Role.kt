package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addAndCastTo

data class Role(
    val name: String,
    val roleProperties: MutableMap<String, Any>
) {
    fun getRoleAsJsonNode(): ObjectNode {
        val propertiesNode = ObjectMapper().createObjectNode()
        roleProperties.filter { it.key != "httpMethod" }.forEach {
            propertiesNode.addAndCastTo(it.key, it.value)
        }
        return propertiesNode
    }
}

class Roles {
    private val realmRoles: MutableMap<String, Role> = mutableMapOf()
    private val clientRoles: MutableMap<String, MutableMap<String, Role>> = mutableMapOf()

    fun addRealmRole(role: Role) {
        if (!realmRoles.containsKey(role.name))
            realmRoles[role.name] = role
        else
            realmRoles[role.name]?.roleProperties?.putAll(role.roleProperties)
    }

    fun addClientRoles(client: String, role: Role) {
        val name = role.name
        if (clientRoles.containsKey(client))
            clientRoles[client]!![name] = role
        else
            clientRoles[client] = mutableMapOf(name to role)
    }

    fun getRolesAsJsonNode(): ObjectNode {
        val objectMapper = ObjectMapper()
        val rolesNode = objectMapper.createObjectNode()
        val clientRolesNode = objectMapper.createObjectNode()
        val rolesArrayNode = objectMapper.createArrayNode()
        realmRoles.forEach {
            rolesArrayNode.add(it.value.getRoleAsJsonNode())
        }
        rolesNode.putArray("realm").addAll(rolesArrayNode)

        if (clientRoles.isNotEmpty()) {
            clientRoles.forEach {
                val arrayNode = clientRolesNode.putArray(it.key)
                it.value.forEach { role ->
                    arrayNode.add(role.value.getRoleAsJsonNode())
                }
                rolesNode.set<ObjectNode>("client", clientRolesNode)
            }
        }
        return rolesNode
    }

    fun resetRoles() {
        realmRoles.clear()
        clientRoles.clear()
    }
}