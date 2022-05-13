package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.keycloakObjects

data class Role (
    val roleName: String,
    val members: List<User>
)