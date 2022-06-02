package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

abstract class Role {
    abstract val name: String
    abstract val clientRole: Boolean
    abstract val containerId: String
}

data class ClientRole(
    override val name: String,
    override val clientRole: Boolean = true,
    override val containerId: String,
) : Role()

data class RealmRole(
    override val name: String,
    override val clientRole: Boolean = false,
    override val containerId: String,
//    val composite: Boolean,
//    val composites: List<ClientRole>,
) : Role()

data class ClientRoles(
    val client: MutableList<ClientRole> = mutableListOf()
)

data class Roles(
    val realm: MutableList<RealmRole> = mutableListOf(),
    val ClientSet: MutableSet<ClientRoles> = mutableSetOf()
)

