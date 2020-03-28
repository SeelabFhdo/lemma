package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain

import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.utils.filterByType
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.ArrayDeque

/**
 * Implementation of a code generation sub-module that handles code generation for domain models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class DomainCodeGenerationSubModule : KoinComponent {
    companion object {
        /**
         * Static invocation function for external callers
         */
        fun invoke() {
            DomainCodeGenerationSubModule().execute()
        }
    }

    /**
     * Execute the sub-module's logic
     */
    private fun execute() {
        DomainState.initialize()

        val intermediateServiceModelForDomainModels: IntermediateServiceModel by MainState
        val allDomainModelUris = resolveImportedDomainModelUrisTransitively(intermediateServiceModelForDomainModels)
        allDomainModelUris.forEach { uri ->
            DomainState.setCurrentIntermediateDomainModelUri(uri)
            val currentIntermediateDomainModel: IntermediateDataModel by DomainState
            currentIntermediateDomainModel.eAllContents().forEach { invokeVisitingCodeGenerationHandler(it) }
        }
    }

    /**
     * Helper to get all URIs of domain models being imported by the given service model and, transitively, of all
     * domain models being imported by previously resolved domain models
     */
    private fun resolveImportedDomainModelUrisTransitively(startModel: IntermediateServiceModel) : Set<String> {
        val resolvedModelUris = mutableSetOf<String>()
        val urisTodo = ArrayDeque(startModel.imports.filterByType(ImportType.DATATYPES).map { it.importUri })

        while (urisTodo.isNotEmpty()) {
            val currentUri = urisTodo.pop()
            resolvedModelUris.add(currentUri)
            val modelRoot = loadModelRoot<IntermediateDataModel>(currentUri.removeFileUri())
            modelRoot.imports.filterByType(ImportType.DATATYPES).forEach { urisTodo.push(it.importUri) }
        }

        return resolvedModelUris
    }

    /**
     * Trigger invocation of visiting code generation handlers on [EObject]. This will also lead to the invocation of
     * subsequent actions, e.g., aspect handlers and Genlet-specific code generation handlers (cf. the
     * executeSubActions() function in
     * [de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI]).
     */
    private fun invokeVisitingCodeGenerationHandler(eObject: EObject) {
        val currentDomainTargetFolderPath: String by DomainState
        val currentIntermediateDomainModel: IntermediateDataModel by DomainState
        val originalModelPath = currentIntermediateDomainModel.sourceModelUri.removeFileUri()
        val serializer: CodeGenerationSerializerI by inject()

        val generatedNodesAndTargetFiles = DomainContext.invokeVisitingCodeGenerationHandlers(eObject)
        for((generatedNode, targetFile) in generatedNodesAndTargetFiles) {
            if (targetFile == null)
                continue

            val generatedFileContents = serializer.serialize(
                generatedNode,
                currentDomainTargetFolderPath,
                targetFile,
                eObject,
                originalModelPath
            )

            generatedFileContents.forEach { (targetFilePath, generationResult) ->
                val (generatedContent, _) = generationResult
                MainState.addGeneratedFileContent(generatedContent, targetFilePath)
            }
        }
    }
}