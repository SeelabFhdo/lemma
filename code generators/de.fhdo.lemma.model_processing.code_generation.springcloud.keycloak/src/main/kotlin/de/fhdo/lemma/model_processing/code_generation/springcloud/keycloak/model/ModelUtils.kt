package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

enum class HttpMethod {
    DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT, TRACE;
}

enum class AccessType (val accessType: String){
    PUBLIC("public"),
    CONFIDENTIAL("confidential"),
    BEARER_ONLY ("bearer-only");

    companion object {
        internal fun getProperties(accessType: AccessType) = when (accessType) {
            PUBLIC -> mapOf("bearerOnly" to false, "publicClient" to true)
            CONFIDENTIAL -> mapOf("bearerOnly" to false, "publicClient" to false)
            BEARER_ONLY -> mapOf("bearerOnly" to true, "publicClient" to false)
        }
    }
}