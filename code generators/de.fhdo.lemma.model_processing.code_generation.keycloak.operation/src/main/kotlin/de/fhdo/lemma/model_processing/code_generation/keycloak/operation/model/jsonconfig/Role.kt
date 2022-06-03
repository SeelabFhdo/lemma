package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

data class Role(
    val name: String,
    val clientRole: Boolean,
    val containerId: String,
)

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

class Roles {
    private val realmRoles: MutableList<Role> = mutableListOf()
    private val clientRoles: MutableMap<String, MutableList<Role>> = mutableMapOf()

    fun addRealmRole(role: Role) {
        realmRoles.add(role)
    }

    fun addClientRoles(client: String, role: Role) {
        if (clientRoles.containsKey(client))
            clientRoles[client]!!.add(role)
        else
            clientRoles[client] = mutableListOf(role)
    }

    fun resetRoles() {
        realmRoles.clear()
        clientRoles.clear()
    }
}

