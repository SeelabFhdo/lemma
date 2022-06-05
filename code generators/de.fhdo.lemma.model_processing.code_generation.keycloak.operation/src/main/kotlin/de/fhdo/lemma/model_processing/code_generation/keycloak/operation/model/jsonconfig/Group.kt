package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model.jsonconfig

data class Group(
    val groupName:String,
){
    val members: Set<User> = mutableSetOf()
    val roles: Set<Role> = mutableSetOf()
}