package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.operationmodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesFormNodeAspectsForDeployedServices
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java
    private fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateContainer): String? {
//        if (!eObject.hasAspect(handlesAspects()))
//            return null
//
//        handlesAspects().forEach { aspectName ->
//            val properties = eObject.getPropertiesFormNodeAspectsForDeployedServices(aspectName)!!
//            properties.forEach { serviceProperties ->
//                println("${serviceProperties.key} ${serviceProperties.value}")
//
//            }
//        }
        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}



