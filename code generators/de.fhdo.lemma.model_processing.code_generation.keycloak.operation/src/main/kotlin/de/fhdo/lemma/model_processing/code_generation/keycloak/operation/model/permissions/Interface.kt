package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.permissions

data class Interface(
    val roles: List<String>,
    val path: List<String>,
    val operations: List<Operation>,
)

data class Operation(
    val roles: List<String>,
    val path: List<String>,
    val vars: MutableList<Pair<String, String>>
)

fun Interface.getPermissions(): List<Pair<String, List<String>>> {
    val retval = mutableListOf<Pair<String, List<String>>>()
    operations.forEach { operation ->
        retval.add(Pair("antMatchers", listOf(this.path + operation.path)))
        val allRoles = (this.roles + operation.roles).toSet().toList()
        retval.add(Pair(if (allRoles.size > 1) "hasAnyRole" else "hasRole", allRoles))
    }
    return retval
}