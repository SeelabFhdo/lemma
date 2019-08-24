package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain

import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.utils.filterByType
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.path
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
        val allDomainModelPaths = resolveImportedDomainModelPathsTransitively(intermediateServiceModelForDomainModels)
        allDomainModelPaths.forEach { domainModelPath ->
            DomainState.currentIntermediateDomainModelFilePath = domainModelPath
            val currentIntermediateDomainModel: IntermediateDataModel by DomainState
            currentIntermediateDomainModel.eAllContents().forEach { invokeVisitingCodeGenerationHandler(it) }
        }
    }

    /**
     * Helper to get all paths of domain models being imported by the given service model and, transitively, of all
     * domain models being imported by previously resolved domain models.
     */
    private fun resolveImportedDomainModelPathsTransitively(startModel: IntermediateServiceModel) : List<String> {
        val resolvedModelPaths = mutableListOf<String>()
        val pathsTodo = ArrayDeque(startModel.imports.filterByType(ImportType.DATATYPES).map { it.path })

        while (pathsTodo.isNotEmpty()) {
            val currentModel = pathsTodo.pop()
            resolvedModelPaths.add(currentModel)
            val modelRoot = loadModelRoot<IntermediateDataModel>(currentModel)
            modelRoot.imports.filterByType(ImportType.DATATYPES).map { it.path }.forEach(pathsTodo::push)
        }

        return resolvedModelPaths
    }

    /**
     * Trigger invocation of visiting code generation handler on [EObject]. This will also lead to the invocation of
     * subsequent actions, e.g., aspect handlers and Genlet-specific code generation handlers (cf. the
     * executeSubActions() function in
     * [de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI]).
     */
    private fun invokeVisitingCodeGenerationHandler(eObject: EObject) {
        val serializer: CodeGenerationSerializerI by inject()
        val (generatedNode, targetFile) = DomainContext.invokeVisitingCodeGenerationHandler(eObject) ?: return
        if (targetFile === null)
            return

        val currentDomainTargetFolderPath: String by DomainState
        val currentIntermediateDomainModelFilePath: String by DomainState
        val currentIntermediateDomainModel: IntermediateDataModel by DomainState
        val originalModelPath = currentIntermediateDomainModel.sourceModelUri.removeFileUri()

        val (serializationTargetFilePath, generatedCode) = serializer.serialize(
            generatedNode,
            currentDomainTargetFolderPath,
            targetFile,
            eObject,
            currentIntermediateDomainModelFilePath,
            originalModelPath
        )
        MainState.addGeneratedFileContent(generatedCode, serializationTargetFilePath)
    }
}