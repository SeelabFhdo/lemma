package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.operationmodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.*
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.callAllHandlers
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel

@CodeGenerationHandler
class IntermediateOperationModelHandler : CodeGenerationHandlerI<IntermediateOperationModel> {
    override fun getSourceInstanceType() = IntermediateOperationModel::class.java

    override fun execute(eObject: IntermediateOperationModel): String? {
        ModelsContext.State.intermediateServiceModels.forEach {
            it.value.eResource().callAllHandlers()
        }
        return null
    }
}