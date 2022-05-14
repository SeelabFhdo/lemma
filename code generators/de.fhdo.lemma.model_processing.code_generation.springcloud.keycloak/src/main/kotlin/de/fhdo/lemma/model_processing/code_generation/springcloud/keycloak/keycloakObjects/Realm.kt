package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.keycloakObjects

data class Realm(
    val name: String,
    val displayName: String?,
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
)