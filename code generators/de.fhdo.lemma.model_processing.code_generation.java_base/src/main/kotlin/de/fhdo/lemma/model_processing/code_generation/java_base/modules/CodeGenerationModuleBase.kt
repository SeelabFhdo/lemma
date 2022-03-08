package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyModifierI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.sendEventToGenlets
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.closeOpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.serializeOpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.serializeLineCountInfo
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.nio.charset.Charset

/**
 * Base template for main code generation modules (i.e., code generation modules that are to be explicitly invoked by
 * users or called by the Java base generator).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class CodeGenerationModuleBase : AbstractCodeGenerationModule(), KoinComponent {
    /**
     * Callback to initialize the code generation state
     */
    abstract fun initializeState(moduleArguments: Array<String>)

    /**
     * Callback for actual code generation
     */
    abstract fun generateCode()

    /**
     * Callback to retrieve the artifact identifier
     */
    abstract fun artifactIdentifier() : String?

    /**
     * Execute the code generation phase with the given [phaseArguments] and [moduleArguments] and leverage the
     * implemented callbacks to retrieve information from implementers
     */
    override fun execute(phaseArguments: Array<String>, moduleArguments: Array<String>)
        : Map<String, Pair<String, Charset>> {
        // If the specified code generation serializer does not support line counting, there should be no path to the
        // line counting information file
        val (_, codeGenerationSerializerInfo) = CommandLine.codeGenerationSerializer
        val writeLineCountInfo = CommandLine.parameterLineCountFile != null
        if (writeLineCountInfo && !codeGenerationSerializerInfo.supportsLineCounting)
            throw PhaseException("Selected code generation serializer ${codeGenerationSerializerInfo.name} does not " +
                "support line counting")

        /* Initialize state */
        initializeState(moduleArguments)

        /* Generate Code */
        generateCode()

        /* Send code generation finished event to Genlets */
        sendEventToGenlets(GenletEvent(GenletEventType.OVERALL_GENERATION_FINISHED))

        /* Serialize dependencies and property files */
        val artifactIdentifier = artifactIdentifier()
        if (artifactIdentifier != null) {
            serializeDependencies(artifactIdentifier)
            serializeOpenedPropertyFiles()
            closeOpenedPropertyFiles()
        }

        /*
         * Enable code generation serializers to adapt (or create even new) generated files in a "code generation
         * completed" callback
         */
        val generatedFileContents: Map<String, Pair<String, Charset>> by MainContext.State
        val serializer: CodeGenerationSerializerI by inject()
        val adaptedOrNewFiles = serializer.codeGenerationPhaseCompleted(generatedFileContents)
        adaptedOrNewFiles.forEach { (filePath, content) -> MainContext.State.addGeneratedFileContent(content, filePath) }

        /* Serialize line count information if it were collected during the code generation run */
        if (writeLineCountInfo) {
            val generatedLineCountInfo: List<LineCountInfo> by MainContext.State
            val lineCountInfoFilePath: String by MainContext.State
            MainContext.State.addGeneratedFileContent(serializeLineCountInfo(generatedLineCountInfo), lineCountInfoFilePath)
        }

        /*
         * Return the map of generated file contents and their charsets per path for the model processor framework to
         * write the files to disk
         */
        return generatedFileContents
    }

    /**
     * Helper to serialize collected dependency information under the given [artifactIdentifier]
     */
    private fun serializeDependencies(artifactIdentifier: String) {
        val dependencySerializer: DependencySerializerI<Any> by inject()
        val collectedDependencies: Set<DependencyDescription> by MainContext.State
        val dependencyModifierInstances: List<DependencyModifierI<Any>> by MainContext.State
        val currentMicroserviceTargetFolderPath: String by MainContext.State

        val (targetFilePath, generatedContent) = dependencySerializer.invoke(
            artifactIdentifier,
            collectedDependencies,
            dependencyModifierInstances,
            currentMicroserviceTargetFolderPath,
            "pom.xml"
        )

        MainContext.State.clearCollectedDependencies()
        MainContext.State.addGeneratedFileContent(generatedContent, targetFilePath)
    }
}