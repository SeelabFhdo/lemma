package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.keycloakObjects

data class Client(
    val clientId: String,
    val name: String,
    val bearerOnly: Boolean,
)