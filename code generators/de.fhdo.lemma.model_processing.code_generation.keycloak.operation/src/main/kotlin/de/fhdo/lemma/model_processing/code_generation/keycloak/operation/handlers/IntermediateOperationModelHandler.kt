package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

@CodeGenerationHandler
class IntermediateOperationModelHandler : CodeGenerationHandlerI<IntermediateOperationModel> {
    override fun getSourceInstanceType() = IntermediateOperationModel::class.java

    override fun execute(eObject: IntermediateOperationModel): String? {
//        println("hallo Hier bin ich.")
//
//        eObject.imports.filter { it.importTypeName.equals("MICROSERVICES") }.forEach{
//            println(it.name)
//            println(it.importUri)
//            val definingModelUri = if (eObject is IntermediateOperationModel) it.importUri else null
//            val importingModelFilePath = eObject.eResource().uri.toString().removeFileUri()
//
//            val definingModel = definingModelUri?.let{
//                val importingModelFilePath = eObject.eResource().uri.toString().removeFileUri()
//                loadModelRootRelative(definingModelUri, importingModelFilePath) as IntermediateServiceModel
//            }
//
//        }


        return ""
    }

}