package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

data class Interface(
    val path: String,
    val roles: MutableSet<Role>,
    val operations: MutableSet<Operations>,
)

data class Operations(
    val path: String,
    val roles: MutableSet<OperationRole>,
)


abstract class AbstractRole{
    abstract val role: String
}

data class Role(
    override val role: String
): AbstractRole()


data class OperationRole(
    override val role: String,
    val httpVerb: HttpMethod,
) : AbstractRole()

enum class HttpMethod {
    DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT, TRACE
}
