package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model

enum class HttpMethod {
    DELETE, GET, POST, PUT;

    companion object {
        internal fun getQualifiedAspectNames() =
            listOf("Spring.PostMapping", "Spring.PutMapping", "Spring.DeleteMapping", "Spring.GetMapping")
        internal fun getHttpMethodFromQualifiedAspectName (httpMethod:String) = when(httpMethod){
            "Spring.PostMapping" -> getHttpMethodAsString(POST)
            "Spring.PutMapping" -> getHttpMethodAsString(PUT)
            "Spring.DeleteMapping" -> getHttpMethodAsString(DELETE)
            "Spring.GetMapping" -> getHttpMethodAsString(GET)
            else -> getHttpMethodAsString(GET)
        }
        private fun getHttpMethodAsString (httpMethod: HttpMethod) = when(httpMethod){
            DELETE -> "HttpMethod.DELETE"
            GET -> "HttpMethod.GET"
            POST -> "HttpMethod.POST"
            PUT -> "HttpMethod.PUT"
        }
    }
}

enum class AccessType(val accessType: String) {
    PUBLIC("public"),
    CONFIDENTIAL("confidential"),
    BEARER_ONLY("bearer-only");

    companion object {
        internal fun getProperties(accessType: AccessType) = when (accessType) {
            PUBLIC -> mapOf("bearerOnly" to false, "publicClient" to true)
            CONFIDENTIAL -> mapOf("bearerOnly" to false, "publicClient" to false)
            BEARER_ONLY -> mapOf("bearerOnly" to true, "publicClient" to false)
        }
    }
}