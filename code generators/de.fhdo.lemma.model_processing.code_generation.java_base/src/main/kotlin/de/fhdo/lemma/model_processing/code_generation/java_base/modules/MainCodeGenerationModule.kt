package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainCodeGenerationSubModule
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesCodeGenerationSubModule
import de.fhdo.lemma.model_processing.code_generation.java_base.eObjectPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.findCodeGenerationSerializers
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.DefaultSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.CountingMavenDependencySerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencySerializer
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.closeOpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.serializeOpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.serializeLineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.asXmiResource
import de.fhdo.lemma.model_processing.utils.hasTechnology
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject
import org.koin.dsl.module
import java.nio.charset.Charset

/**
 * Entry point of the Java base generator as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationModule("main")
internal class MainCodeGenerationModule : AbstractCodeGenerationModule(), KoinComponent {
    /**
     * Return the language description for the intermediate model kind with which this code generator can deal, i.e.,
     * intermediate service models
     */
    override fun getLanguageDescription() = INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION

    /**
     * Execute the code generation phase with the given [phaseArguments] and [moduleArguments]
     */
    override fun execute(phaseArguments: Array<String>, moduleArguments: Array<String>)
        : Map<String, Pair<String, Charset>> {

        /* Find available code generation serializers */
        val serializerPackage = javaClass.packageName.substringBeforeLast(".") + ".serialization.code_generation"
        val supportedCodeGenerationSerializers = findCodeGenerationSerializers(serializerPackage)

        /* Parse commandline */
        try {
            CommandLine(moduleArguments, supportedCodeGenerationSerializers)
        } catch (ex: Exception) {
            throw PhaseException(ex.message)
        }

        // If the chosen code generation serializer does not support line counting, there should be no path to the
        // line counting information file
        val writeLineCountInfo = CommandLine.parameterLineCountFile != null
        val (codeGenerationSerializer, codeGenerationSerializerInfo) = CommandLine.codeGenerationSerializer
        if (writeLineCountInfo && !codeGenerationSerializerInfo.supportsLineCounting)
            throw PhaseException("Selected code generation serializer ${codeGenerationSerializerInfo.name} does not " +
                "support line counting")

        /* Setup dependency injection and determine the injected implementations per expected interface */
        startKoin { modules( module {
            factory<AbstractSerializationConfiguration> { DefaultSerializationConfiguration }
            factory { codeGenerationSerializer }
            factory<DependencySerializerI<*, *>> {
                if (writeLineCountInfo)
                    CountingMavenDependencySerializer()
                else
                    MavenDependencySerializer()
            }
        } ) }

        /*
         * Determine the service model to be used to generate microservices from. The generator allows for passing an
         * alternative service model file for that reason. If an alternative service model file is passed to the
         * generator, it is used as the source for the microservices to be generated. Contrary, the domain models are
         * always generated from the intermediate service model file passed to the code generation framework. With this
         * approach it is possible to model microservices and their technologies via LEMMA's Service Modeling Language,
         * and domain models and their technologies via LEMMA's Domain and Technology Mapping Modeling Languages. Hence,
         * service technology specifications can be separated from technology specifications of domain models, if
         * desired.
         */
        val (intermediateServiceModelFilePath, intermediateServiceModelResource) =
            if (CommandLine.alternativeIntermediateServiceModelFile != null)
                CommandLine.alternativeIntermediateServiceModelFile!! to
                    CommandLine.alternativeIntermediateServiceModelFile!!.asXmiResource()
            else
                intermediateModelFile to intermediateModelResource

        /* Initialize the main state hold by the main context */
        MainState.initialize(
            intermediateServiceModelFilePath,
            intermediateServiceModelResource,
            intermediateModelResource,
            targetFolder,
            CommandLine.parameterLineCountFile
        )

        /*
         * Generate domain concepts per microservice from the determined service model, as well as the services
         * themselves
         */
        val intermediateServiceModel: IntermediateServiceModel by MainState
        val javaMicroservices = intermediateServiceModel.microservices.filter{ it.hasTechnology("java") }
        if (javaMicroservices.isEmpty())
            throw PhaseException("No Java microservices found in intermediate service model " +
                "\"$intermediateServiceModelFilePath\"")

        javaMicroservices.forEach {
            MainState.setCurrentMicroservice(it)
            DomainCodeGenerationSubModule.invoke()
            ServicesCodeGenerationSubModule.invoke()
        }

        /* Serialize dependencies and property files. They concern all generated microservices. */
        if (intermediateServiceModel.microservices.isNotEmpty()) {
            // Currently, we use the first microservice in the model to determine the artifact identifier for the
            // dependency serialization
            serializeDependencies(intermediateServiceModel.microservices.first())

            serializeOpenedPropertyFiles()
            closeOpenedPropertyFiles()
        }

        /*
         * Enable code generation serializers to adapt (or create even new) generated files in a "code generation
         * completed" callback
         */
        val generatedFileContents: Map<String, Pair<String, Charset>> by MainState
        val serializer: CodeGenerationSerializerI by inject()
        val adaptedOrNewFiles = serializer.codeGenerationPhaseCompleted(generatedFileContents)
        adaptedOrNewFiles.forEach { (filePath, content) -> MainState.addGeneratedFileContent(content, filePath) }

        /* Serialize line count information if it were collected during the code generation run */
        if (writeLineCountInfo) {
            val generatedLineCountInfo: List<LineCountInfo> by MainState
            val lineCountInfoFilePath: String by MainState
            MainState.addGeneratedFileContent(serializeLineCountInfo(generatedLineCountInfo), lineCountInfoFilePath)
        }

        /*
         * Return the map of generated file contents and their charsets per path for the model processor framework to
         * write the files to disk
         */
        return generatedFileContents
    }

    /**
     * Helper to run the serialization of the dependencies collected for the current service code generation
     */
    private fun serializeDependencies(microservice: IntermediateMicroservice) {
        val dependencySerializer: DependencySerializerI<Any, Any> by inject()
        val collectedDependencies: Set<DependencyDescription> by MainState
        val dependencyFragmentProviderInstances: List<DependencyFragmentProviderI<Any, Any>> by MainState
        val currentMicroserviceTargetFolderPath: String by MainState

        val (targetFilePath, generatedContent) = dependencySerializer.invoke(
            microservice.artifactIdentifier(),
            collectedDependencies,
            dependencyFragmentProviderInstances,
            currentMicroserviceTargetFolderPath,
            "pom.xml"
        )

        MainState.clearCollectedDependencies()
        MainState.addGeneratedFileContent(generatedContent, targetFilePath)
    }

    /**
     * Convenience function to derive dependency artifact identifier from a microservice. The identifier consists of the
     * package name, name, and possibly the version, if any, of the microservice. All name fragments are separated by
     * the [DependencyDescription.PART_SEP].
     */
    private fun IntermediateMicroservice.artifactIdentifier() : String {
        var identifier = "$eObjectPackageName${DependencyDescription.PART_SEP}$simpleName"
        if (version != null)
            identifier += "${DependencyDescription.PART_SEP}$version"
        return identifier
    }
}