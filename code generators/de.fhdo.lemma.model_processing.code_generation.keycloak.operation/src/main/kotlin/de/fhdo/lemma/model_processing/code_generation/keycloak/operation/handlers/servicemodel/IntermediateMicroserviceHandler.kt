package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
class IntermediateMicroserviceHandler: CodeGenerationHandlerI<IntermediateMicroservice> {
    override fun getSourceInstanceType()= IntermediateMicroservice::class.java


    override fun execute(eObject: IntermediateMicroservice): String? {
        // Client erstellen Clientrollen liste anlegen aspect keycloakClient
        // Application Properties erstellen und Pfade finden "ressource"


        return null
    }

}