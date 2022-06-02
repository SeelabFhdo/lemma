package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.servicemodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.service.intermediate.IntermediateOperation

@CodeGenerationHandler
class IntermediateOperationHandler : CodeGenerationHandlerI<IntermediateOperation> {
    override fun getSourceInstanceType() = IntermediateOperation::class.java

    override fun execute(eObject: IntermediateOperation): String? {
        // Rollen suchen und entscheiden ob Client- oder Realm Rolle

        return null
    }
}