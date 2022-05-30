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
    // Zuerst die spezifischsten Rollen

    operations.forEach { operation ->
        val operationPaths = mutableListOf<String>()
        operation.path.forEach { operationPath ->
            paths.forEach { interfacePath ->
                operationPaths.add("$interfacePath/$operationPath")
            }
        }

        permissions.add(Pair("antMatchers", listOf(this.path + operation.path)))
        val allRoles = (this.roles + operation.roles).toSet().toList()
        permissions.add(Pair(if (allRoles.size > 1) "hasAnyRole" else "hasRole", allRoles))
    }
    // Dann Permissions für interfaces, wenn diese eine Rolle besitzen
    if (roles.size >= 1) {
        permissions.add(Pair("antMatchers", listOf(path)))
        permissions.add(Pair(if (roles.size > 1) "hasAnyRole" else "hasRole", roles))
    }
    return permissions.toList()
}

private fun PermissionsInterface.combinePaths(): List<String> {
    val paths = mutableSetOf<String>()
    operations.forEach { operation ->
        paths.addAll(operation.paths.zip(this.paths) { a, b -> "$a/$b".replace("//", "/") })
    }
    paths.addAll(this.paths)
    paths.forEach { a -> println(a) }
    return paths.toList()
}