package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

internal object ModelsContext {

    object State {
        internal var intermediateServiceModels: MutableMap<String, IntermediateServiceModel> = mutableMapOf()
        internal var intermediateOperationModels: MutableMap<String, IntermediateOperationModel> = mutableMapOf()
        internal var realmRoles: MutableSet<String> = mutableSetOf()
        internal var clientRoles: MutableSet<String> = mutableSetOf()
        internal var groups: MutableSet<String> = mutableSetOf()


        fun alreadyLoaded(intermediateImport: IntermediateImport) =
            when (intermediateImport.importTypeName) {
                "OPERATION_NODES" -> intermediateOperationModels.containsKey(intermediateImport.importUri)
                "MICROSERVICES" -> intermediateServiceModels.containsKey(intermediateImport.importUri)
                else -> false
            }

    }


}