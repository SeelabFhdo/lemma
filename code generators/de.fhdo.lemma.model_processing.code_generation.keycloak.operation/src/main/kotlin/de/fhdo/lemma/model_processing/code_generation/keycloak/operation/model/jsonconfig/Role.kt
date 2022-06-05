package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.addAndCastTo

data class Role(
    val roleProperties: Map<String, Any>
) {
    fun getRoleAsJsonNode(): ObjectNode {
        val propertiesNode = ObjectMapper().createObjectNode()
        roleProperties.forEach {
            propertiesNode.addAndCastTo(it.key, it.value)
        }
        return propertiesNode
    }
}

class Roles {
    private val realmRoles: MutableSet<Role> = mutableSetOf()
    private val clientRoles: MutableMap<String, MutableSet<Role>> = mutableMapOf()

    fun addRealmRole(role: Role) {
        realmRoles.add(role)
    }

    fun addClientRoles(client: String, role: Role) {
        if (clientRoles.containsKey(client))
            clientRoles[client]!!.add(role)
        else
            clientRoles[client] = mutableSetOf(role)
    }

    fun getRolesAsJsonNode(): ObjectNode {
        val objectMapper = ObjectMapper()
        val rolesNode = objectMapper.createObjectNode()
        val clientRolesNode = objectMapper.createObjectNode()
        val rolesArrayNode = objectMapper.createArrayNode()
        realmRoles.forEach {
            rolesArrayNode.add(it.getRoleAsJsonNode())
        }
        rolesNode.putArray("realm").addAll(rolesArrayNode)

        if (clientRoles.isNotEmpty()) {
            clientRoles.forEach {
                val arrayNode = clientRolesNode.putArray(it.key)
                it.value.forEach { role ->
                    arrayNode.add(role.getRoleAsJsonNode())
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


//data class ClientRole(
//    override val name: String,
//    override val clientRole: Boolean = true,
//    override val containerId: String,
//) : Role()
//
//data class RealmRole(
//    override val name: String,
//    override val clientRole: Boolean = false,
//    override val containerId: String,
////    val composite: Boolean,
////    val composites: List<ClientRole>,
//) : Role()

//data class ClientRoles(
//    val client: MutableList<Role> = mutableListOf()
//)
