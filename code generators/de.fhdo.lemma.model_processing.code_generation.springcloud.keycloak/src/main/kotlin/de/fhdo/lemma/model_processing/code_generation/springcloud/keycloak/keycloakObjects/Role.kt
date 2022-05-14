package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.keycloakObjects

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


data class RealmRole (
    override val name: String,
    override val clientRole: Boolean = false,
    override val containerId: String,
    val composite: Boolean,
    val composites: List<ClientRole>,
) : Role()

data class Roles(
    val realm: List<RealmRole>,
    val client: List<ClientRole>,
)