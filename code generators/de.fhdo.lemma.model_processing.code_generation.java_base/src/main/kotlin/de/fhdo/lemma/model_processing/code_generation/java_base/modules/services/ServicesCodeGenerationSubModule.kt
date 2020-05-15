package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventObject
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext
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

        /* Do code generation on current IntermediateMicroservice instance and contained elements */
        val currentMicroservice = MainState.currentMicroservice
        val generatedMicroserviceNodes = invokeVisitingCodeGenerationHandlers(currentMicroservice)
        currentMicroservice.eAllContents().forEach { invokeVisitingCodeGenerationHandlers(it) }

        /* Send event to Genlets that code generation on the current IntermediateMicroservice instance was finished */
        // Find generated microservice class
        val generatedMicroserviceClass = generatedMicroserviceNodes
            .filter { (_, generatedNode) ->
                (generatedNode as? ClassOrInterfaceDeclaration)?.nameAsString == currentMicroservice.classname
            }.values.first() as ClassOrInterfaceDeclaration

        // Send event
        MainContext.sendEventToGenlets(GenletEvent(
            GenletEventType.MICROSERVICE_GENERATION_FINISHED,
            GenletEventObject.GENERATED_MICROSERVICE_CLASS to generatedMicroserviceClass
        ))
    }

    /**
     * Trigger invocation of visiting code generation handlers on [EObject]. This will also lead to the invocation of
     * subsequent actions, e.g., aspect handlers and Genlet-specific code generation handlers (cf. the
     * executeSubActions() function in
     * [de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI]).
     */
    private fun invokeVisitingCodeGenerationHandlers(eObject: EObject) : Map<String, Node> {
        val currentMicroserviceGenerationTargetFolderPath: String by ServicesState
        val intermediateServiceModel: IntermediateServiceModel by MainState
        val originalModelPath = intermediateServiceModel.sourceModelUri.removeFileUri()
        val serializer: CodeGenerationSerializerI by inject()

        val generatedNodesWithTargetFiles = mutableMapOf<String, Node>()
        val generatedNodesAndTargetFiles = ServicesContext.invokeVisitingCodeGenerationHandlers(eObject)
        for((generatedNode, targetFile) in generatedNodesAndTargetFiles) {
            if (targetFile == null)
                continue

            val generatedFileContents = serializer.serialize(
                generatedNode,
                currentMicroserviceGenerationTargetFolderPath,
                targetFile,
                eObject,
                originalModelPath
            )

            generatedFileContents.forEach { (targetFilePath, generationResult) ->
                val (generatedContent, generatedNodeFromResult) = generationResult
                MainState.addGeneratedFileContent(generatedContent, targetFilePath)

                if (generatedNodeFromResult != null)
                    generatedNodesWithTargetFiles[targetFilePath] = generatedNodeFromResult
            }
        }

        return generatedNodesWithTargetFiles
    }
}