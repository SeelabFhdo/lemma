package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

data class Realm(
    val id: String,
    val realm: String?,
    val enabled: Boolean,
    val realmName: String,
    val loginWithEmailAllowed: Boolean,
    val registrationAllowed: Boolean,
    val registrationEmailAsUsername: Boolean,
    val rememberMe: Boolean,
    val verifyEmail: Boolean,
    val resetPasswordAllowed: Boolean,
    val editUsernameAllowed: Boolean,
    val bruteForceProtected: Boolean,
    val additionalJsonProperties: String,
    val roles: Roles,
    val users: MutableSet<User>,
    val groups: MutableSet<Group>,
    val clients: MutableSet<Client>
)