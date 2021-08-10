package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.shared

import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.CodeGenerationModuleBase
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.findCodeGenerationSerializers
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.filterByType
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.EObject
import org.koin.core.inject
import java.util.ArrayDeque

/**
 * Entry point of the shared library Java generator as expected by LEMMA's model processing framework. The shared
 * library Java generator is a code generation module that needs to be explicitly invoked.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ExplicitlyInvokedCodeGenerationModule("shared")
internal class SharedCodeGenerationModule : CodeGenerationModuleBase() {
    /**
     * Return the language namespace for the intermediate model kind with which this code generator can deal, i.e.,
     * intermediate domain models
     */
    override fun getLanguageNamespace() = INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION.nsUri

    /**
     * Initialize the code generation module
     */
    override fun initialize(moduleArguments : Array<String>) {
        // Setup CommandLine Singleton
        val serializerPackage = MainCodeGenerationModule::class.java.packageName
            .substringBeforeLast(".") + ".serialization.code_generation"
        val supportedCodeGenerationSerializers = findCodeGenerationSerializers(serializerPackage)

        try {
            CommandLine(moduleArguments, supportedCodeGenerationSerializers)
        } catch (ex: Exception) {
            throw PhaseException(ex.message)
        }
    }

    /**
     * Indicate whether line count information shall be generated
     */
    override fun writeLineCountInfo() = CommandLine.parameterLineCountFile != null

    /**
     * Return the selected code generation serializer and the corresponding information
     */
    override fun codeGenerationSerializerAndInfo() = CommandLine.codeGenerationSerializer

    /**
     * Initialize code generation state
     */
    override fun initializeState() {
        MainState.initialize(CommandLine.sharedPackage!!, targetFolder, CommandLine.parameterLineCountFile)
        DomainState.initialize()
    }

    /**
     * Do the actual code generation
     */
    override fun generateCode() {
        // Map the passed intermediate domain models to their URIs
        val allDomainModelUris = CommandLine.sharedIntermediateDomainModels!!.map {
            LemmaUtils.convertToFileUri(it)
        }.toMutableSet()

        // In addition, collect the URIs of all (transitively) imported intermediate domain models of the passed models
        for (sharedModelPath in CommandLine.sharedIntermediateDomainModels!!)
            allDomainModelUris.addAll(getImportedDomainModelUrisTransitively(sharedModelPath))

        // Generate code for each loaded intermediate domain model
        allDomainModelUris.forEach { uri ->
            DomainState.setCurrentIntermediateDomainModelUri(uri)
            val currentIntermediateDomainModel: IntermediateDataModel by DomainState
            currentIntermediateDomainModel.eAllContents().forEach { invokeVisitingCodeGenerationHandler(it) }
        }
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

    /**
     * Helper to retrieve the URIs of all (transitively) imported intermediate domain models of the model located at the
     * given [startModelPath]
     */
    private fun getImportedDomainModelUrisTransitively(startModelPath: String) : Set<String> {
        val startModel = loadModelRoot<IntermediateDataModel>(startModelPath)
        val startModelAbsolutePath = startModel.eResource().uri.toString().removeFileUri()
        val resolvedModelUris = mutableSetOf<String>()
        val urisTodo = ArrayDeque(startModel.imports.filterByType(ImportType.DATATYPES).map { it.importUri })

        while (urisTodo.isNotEmpty()) {
            val currentUri = urisTodo.pop()
            resolvedModelUris.add(currentUri)
            val modelRoot = loadModelRootRelative<IntermediateDataModel>(currentUri, startModelAbsolutePath)
            modelRoot.imports.filterByType(ImportType.DATATYPES).forEach { urisTodo.push(it.importUri) }
        }

        return resolvedModelUris
    }

    /**
     * Return the artifact identifier
     */
    override fun artifactIdentifier() = CommandLine.artifactIdentifier!!
}