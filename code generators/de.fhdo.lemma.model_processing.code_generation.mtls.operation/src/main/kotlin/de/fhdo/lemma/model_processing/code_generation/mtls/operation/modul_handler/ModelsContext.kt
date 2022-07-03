package de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.EObject

internal object ModelsContext {

    object State {
        internal var intermediateServiceModels: MutableMap<String, IntermediateServiceModel> = mutableMapOf()
        internal var intermediateOperationModels: MutableMap<String, IntermediateOperationModel> = mutableMapOf()

        fun alreadyLoaded(intermediateImport: IntermediateImport) =
            when (intermediateImport.importTypeName) {
                "OPERATION_NODES" -> intermediateOperationModels.containsKey(intermediateImport.importUri)
                "MICROSERVICES" -> intermediateServiceModels.containsKey(intermediateImport.importUri)
                else -> true
            }

        fun storeIntermediateModel(model: EObject) {
            when (model) {
                is IntermediateOperationModel -> intermediateOperationModels[model.eResource().uri.toString()] = model
                is IntermediateServiceModel -> intermediateServiceModels[model.eResource().uri.toString()] = model
                else -> {}
            }
        }
    }


}