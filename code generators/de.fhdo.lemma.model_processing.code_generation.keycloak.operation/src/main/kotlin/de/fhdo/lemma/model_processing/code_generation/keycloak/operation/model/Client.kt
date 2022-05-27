package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model

data class Client(
    val clientId: String,
    val name: String,
    val bearerOnly: Boolean,
)