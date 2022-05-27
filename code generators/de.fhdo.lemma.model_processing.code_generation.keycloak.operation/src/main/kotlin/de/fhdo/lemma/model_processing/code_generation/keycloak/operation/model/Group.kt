package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model

data class Group(
    val groupName:String,
    val members: List<User>,
    val roleMapping: List<Role>
)