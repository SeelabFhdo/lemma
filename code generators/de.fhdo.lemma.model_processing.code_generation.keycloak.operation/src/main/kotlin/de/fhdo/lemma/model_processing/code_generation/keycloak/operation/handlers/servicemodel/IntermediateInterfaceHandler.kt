package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
class IntermediateInterfaceHandler : CodeGenerationHandlerI<IntermediateInterface> {
    override fun getSourceInstanceType() = IntermediateInterface::class.java


    override fun execute(eObject: IntermediateInterface): String? {

        // Rollen suchen und entscheiden ob Client- oder Realm Rolle

        println(eObject.qualifiedName)
        eObject.endpoints.forEach { endpoint ->
            endpoint.addresses.forEach { address ->
                println("interface-endpoint: $address")
            }
        }
        eObject.operations.forEach { operation ->
            operation.endpoints.forEach { endpoint ->
                endpoint.addresses.forEach { address ->
                    println("operation-endpoint: $address")
                }

            }
        }


        return null
    }

}