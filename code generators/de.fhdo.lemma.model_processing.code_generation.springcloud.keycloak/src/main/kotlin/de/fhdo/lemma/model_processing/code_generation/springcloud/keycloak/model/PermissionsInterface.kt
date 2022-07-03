package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

data class PermissionsInterface(
    val roles: List<String>,
    val paths: List<String>,
    val operations: List<PermissionsOperation>,
)

data class PermissionsOperation(
    val roles: List<String>,
    val paths: List<Pair<String, String>>,
    val vars: List<Pair<String, String>>
)

fun PermissionsInterface.getPermissions(): List<Pair<String, List<Pair<String,String>>>> {
    val permissions = mutableListOf<Pair<String, List<Pair<String,String>>>>()
    operations.forEach { operation ->
        val operationPaths = this.paths combine operation.paths
        permissions.add(Pair("antMatchers", operationPaths.ifEmpty { operation.paths }))
        val allRoles = operation.roles.map { Pair(it, "") }.toSet().toList()
        permissions.add(getRoleMethode(operation.roles.size) to allRoles)
    }
    if (roles.isNotEmpty()) {
        permissions.add(Pair("antMatchers", paths.map { Pair(it, "") }.toSet().toList()))
        permissions.add(getRoleMethode(roles.size) to roles.map { Pair(it, "") })
    }
    return permissions.toList()
}

infix fun List<String>.combine(list: List<Pair<String, String>>): List<Pair<String,String>> {
    val combinedList = mutableSetOf<Pair<String, String>>()
    this.forEach { it1 ->
        list.forEach { it2 ->
            combinedList.add("$it1/${it2.first}".replace("//", "/") to it2.second)
        }
    }
    return combinedList.toList()
}

private fun getRoleMethode(numberOfRolls: Int) =
    if (numberOfRolls > 1) "hasAnyRole" else if (numberOfRolls == 1) "hasRole" else "anonymous"
