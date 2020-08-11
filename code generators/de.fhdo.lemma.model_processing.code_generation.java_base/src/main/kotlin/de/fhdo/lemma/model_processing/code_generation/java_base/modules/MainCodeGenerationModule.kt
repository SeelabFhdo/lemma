package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainCodeGenerationSubModule
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesCodeGenerationSubModule
import de.fhdo.lemma.model_processing.code_generation.java_base.eObjectPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.findCodeGenerationSerializers
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.asXmiResource
import de.fhdo.lemma.model_processing.utils.hasTechnology
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

/**
 * Entry point of the Java base generator as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationModule("main")
internal class MainCodeGenerationModule : CodeGenerationModuleBase() {
    /**
     * Return the language description for the intermediate model kind with which this code generator can deal, i.e.,
     * intermediate service models
     */
    override fun getLanguageDescription() = INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION

    /**
     * Initialize the code generation module
     */
    override fun initialize(moduleArguments : Array<String>) {
        // Setup CommandLine Singleton
        val serializerPackage = javaClass.packageName.substringBeforeLast(".") + ".serialization.code_generation"
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
    }

    /**
     * Do the actual code generation
     */
    override fun generateCode() {
        /*
         * Generate domain concepts per microservice from the determined service model, as well as the services
         * themselves
         */
        val intermediateServiceModel: IntermediateServiceModel by MainState
        val javaMicroservices = intermediateServiceModel.microservices.filter{ it.hasTechnology("java") }
        if (javaMicroservices.isEmpty()) {
            val intermediateServiceModelFilePath: String by MainState
            throw PhaseException("No Java microservices found in intermediate service model " +
                "\"$intermediateServiceModelFilePath\"")
        }

        javaMicroservices.forEach {
            MainState.setCurrentMicroservice(it)
            DomainCodeGenerationSubModule.invoke()
            ServicesCodeGenerationSubModule.invoke()
        }
    }

    /**
     * Return the artifact identifier
     */
    override fun artifactIdentifier() : String? {
        val intermediateServiceModel: IntermediateServiceModel by MainState
        return if (intermediateServiceModel.microservices.isNotEmpty())
                intermediateServiceModel.microservices.first().artifactIdentifier()
            else
                null
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