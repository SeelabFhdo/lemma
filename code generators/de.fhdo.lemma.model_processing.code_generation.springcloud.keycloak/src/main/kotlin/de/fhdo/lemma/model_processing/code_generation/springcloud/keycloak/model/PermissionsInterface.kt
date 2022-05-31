package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

data class PermissionsInterface(
    val roles: List<String>,
    val paths: List<String>,
    val operations: List<PermissionsOperation>,
)

data class PermissionsOperation(
    val roles: List<String>,
    val paths: List<String>,
    val vars: List<Pair<String, String>>
)

fun PermissionsInterface.getPermissions(): List<Pair<String, List<String>>> {
    val permissions = mutableListOf<Pair<String, List<String>>>()
    operations.forEach { operation ->
        val operationPaths = this.paths combine operation.paths
        permissions.add(Pair("antMatchers", operationPaths))
        val allRoles = operation.roles.toSet().toList()
        permissions.add(Pair(if (allRoles.size > 1) "hasAnyRole" else "hasRole", allRoles))
    }

    if (roles.size >= 1) {
        permissions.add(Pair("antMatchers", paths.toSet().toList()))
        permissions.add(Pair(if (roles.size > 1) "hasAnyRole" else "hasRole", roles))
    }
    return permissions.toList()
}

infix fun List<String>.combine(list: List<String>): List<String> {
    val combinedList = mutableSetOf<String>()
    this.forEach { it2 ->
        list.forEach { it1 ->
            combinedList.add("$it2/$it1".replace("//", "/"))
        }
    }
    return combinedList.toList()
}