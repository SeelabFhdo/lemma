package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject

internal class ServicesCodeGenerationSubModule : KoinComponent {
    companion object {
        /**
         * Static invocation function for external callers
         */
        fun invoke() {
            ServicesCodeGenerationSubModule().execute()
        }
    }

    /**
     * Execute the sub-module's logic
     */
    private fun execute() {
        ServicesState.initialize()
        invokeVisitingCodeGenerationHandler(MainState.currentMicroservice)
        MainState.currentMicroservice.eAllContents().forEach { invokeVisitingCodeGenerationHandler(it) }
    }

    private fun invokeVisitingCodeGenerationHandler(eObject: EObject) {
        val serializer: CodeGenerationSerializerI by inject()
        val (generatedNode, targetFile) = ServicesContext.invokeVisitingCodeGenerationHandler(eObject) ?: return
        if (targetFile == null)
            return

        val currentMicroserviceGenerationTargetFolderPath: String by ServicesState
        val intermediateServiceModelFilePath: String by MainState
        val intermediateServiceModel: IntermediateServiceModel by MainState
        val originalModelPath = intermediateServiceModel.sourceModelUri.removeFileUri()

        val generatedFileContents = serializer.serialize(
            generatedNode,
            currentMicroserviceGenerationTargetFolderPath,
            targetFile,
            eObject,
            intermediateServiceModelFilePath,
            originalModelPath
        )
        generatedFileContents.forEach { (targetFilePath, generatedContent) ->
            MainState.addGeneratedFileContent(generatedContent, targetFilePath)
        }
    }
}