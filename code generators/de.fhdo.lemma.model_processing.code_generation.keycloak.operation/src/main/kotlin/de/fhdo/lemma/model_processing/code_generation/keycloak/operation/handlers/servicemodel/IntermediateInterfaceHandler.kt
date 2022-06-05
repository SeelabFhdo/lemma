package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateInterface


@CodeGenerationHandler
class IntermediateInterfaceHandler : CodeGenerationHandlerI<IntermediateInterface> {
    override fun getSourceInstanceType() = IntermediateInterface::class.java
    private fun handlesAspects() = setOf("role")


    override fun execute(eObject: IntermediateInterface): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null

        eObject.aspects.filter { handlesAspects().contains(it.name)}.forEach { aspect ->
            MainContext.State.addRole(eObject.microservice.name, aspect.getPropertiesValuesOrDefault())
        }




//        println(eObject.qualifiedName)
//        eObject.endpoints.forEach { endpoint ->
//            endpoint.addresses.forEach { address ->
//                println("interface-endpoint: $address")
//            }
//        }
//        eObject.operations.forEach { operation ->
//            operation.endpoints.forEach { endpoint ->
//                endpoint.addresses.forEach { address ->
//                    println("operation-endpoint: $address")
//                }
//
//            }
//        }


        return null
    }

}