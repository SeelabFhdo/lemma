package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.keycloakObjects

data class Group(
    val groupName:String,
    val members: List<User>,
    val roleMapping: List<Role>
)