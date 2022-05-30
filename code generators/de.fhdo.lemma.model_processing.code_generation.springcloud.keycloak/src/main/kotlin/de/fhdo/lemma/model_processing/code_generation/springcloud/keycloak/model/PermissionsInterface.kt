package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

data class PermissionsInterface(
    val roles: List<String>,
    val path: List<String>,
    val operations: List<PermissionsOperation>,
)

data class PermissionsOperation(
    val roles: List<String>,
    val path: List<String>,
    val vars: List<Pair<String, String>>
)

fun PermissionsInterface.getPermissions(): List<Pair<String, List<String>>> {
    val permissions = mutableListOf<Pair<String, List<String>>>()
    // Zuerst die spezifischsten Rollen
//    operations.forEach { operation ->
//        permissions.add(Pair("antMatchers", listOf(this.path + operation.path)))
//        val allRoles = (this.roles + operation.roles).toSet().toList()
//        permissions.add(Pair(if (allRoles.size > 1) "hasAnyRole" else "hasRole", allRoles))
//    }
//    // Dann Permissions für interfaces, wenn diese eine Rolle besitzen
//    if (roles.size >= 1){
//        permissions.add(Pair("antMatchers", listOf(path)))
//        permissions.add(Pair(if (roles.size > 1) "hasAnyRole" else "hasRole", roles))
//    }
    return permissions.toList()
}