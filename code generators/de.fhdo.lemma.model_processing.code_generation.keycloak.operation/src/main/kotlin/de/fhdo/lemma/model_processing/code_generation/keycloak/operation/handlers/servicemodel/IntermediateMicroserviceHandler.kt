package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.javaFileName
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
class IntermediateMicroserviceHandler : CodeGenerationHandlerI<IntermediateMicroservice> {
    override fun getSourceInstanceType() = IntermediateMicroservice::class.java

    override fun execute(eObject: IntermediateMicroservice): String? {
        // Client erstellen Clientrollen liste anlegen aspect keycloakClient
        // Application Properties erstellen und Pfade finden "ressource"
        eObject.getAspect("Keycloak.keycloakClient")?.let {
            MainContext.State.addClient(it.getPropertiesValuesOrDefault())
        } ?: run {
            val clientId = eObject.getAspectPropertyValue("Spring.Application", "name")?.also { it.lowercase() }
                ?: eObject.classname.lowercase()
            MainContext.State.addClient(clientId)
        }
        return null
    }

}