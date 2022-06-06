package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateOperation

@CodeGenerationHandler
class IntermediateOperationHandler : CodeGenerationHandlerI<IntermediateOperation> {
    override fun getSourceInstanceType() = IntermediateOperation::class.java
    private fun handlesAspects() = setOf("role")

    override fun execute(eObject: IntermediateOperation): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null
        eObject.aspects.filter { handlesAspects().contains(it.name) }.forEach { aspect ->
            val clientId =
                eObject.`interface`.microservice.getAspectPropertyValue("Keycloak.keycloakClient", "clientId")
                    ?: eObject.`interface`.microservice.classname.lowercase()
            MainContext.State.addRole(clientId, aspect.getPropertiesValuesOrDefault())
        }
        return null
    }
}