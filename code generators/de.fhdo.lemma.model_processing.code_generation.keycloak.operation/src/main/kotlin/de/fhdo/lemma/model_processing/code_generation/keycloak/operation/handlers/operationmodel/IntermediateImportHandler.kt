package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.operationmodel

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.*
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.callAllHandlers
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.EObject

@CodeGenerationHandler
class IntermediateImportHandler : CodeGenerationHandlerI<IntermediateImport> {
    override fun getSourceInstanceType() = IntermediateImport::class.java

    override fun execute(eObject: IntermediateImport): String? {
        if (!eObject.importTypeName.equals("MICROSERVICES"))
            return ""

        val serviceModelUri = eObject.importUri
        val serviceModel =
            loadModelRootRelative<IntermediateServiceModel>(
                serviceModelUri,
                eObject.eResource().uri.toString().removeFileUri()
            )
        MainContext.State.intermediateServiceModels.add(serviceModel)
        serviceModel.eResource().callAllHandlers()

        return null
    }
}