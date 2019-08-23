package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainCodeGenerationSubModule
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.asXmiResource
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.nio.charset.Charset

/**
 * Entry point of the Java base generator as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationModule("main")
internal class MainModule : AbstractCodeGenerationModule(), KoinComponent {
    private val dependencySerializer: DependencySerializerI<Any, Any> by inject()

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

        /* Parse commandline */
        try {
            CommandLine(moduleArguments)
        } catch (ex: Exception) {
            throw PhaseException(ex.message)
        }

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
        val intermediateServiceModelResource =
            CommandLine.alternativeIntermediateServiceModelFile?.asXmiResource()
            ?: intermediateModelResource

        /* Initialize the main state hold by the main context */
        MainState.initialize(intermediateServiceModelResource, intermediateModelResource, targetFolder)

        /*
        * Generate domain concepts per microservice from the determined service model, as well as the service
        * themselves
        */
        val intermediateServiceModel: IntermediateServiceModel by MainState
        intermediateServiceModel.microservices.forEach {
            MainState.currentMicroservicePackage = it.packageName

            try {
                DomainCodeGenerationSubModule.invoke()
            } catch(ex: PhaseException) {
                // DEBUG
            }

            serializeDependencies(it)
        }

        return emptyMap()
    }

    /**
     * Helper to run the serialization of the dependencies collected for the current service code generation
     */
    private fun serializeDependencies(microservice: IntermediateMicroservice) {
        val collectedDependencies: Set<DependencyDescription> by MainState
        val dependencyFragmentProviderInstances: List<DependencyFragmentProviderI<Any, Any>> by MainState
        val currentMicroserviceTargetFolderPath: String by MainState

        dependencySerializer.invoke(
            microservice.artifactIdentifier(),
            collectedDependencies,
            dependencyFragmentProviderInstances,
            currentMicroserviceTargetFolderPath,
            "pom.xml"
        )

        MainState.clearCollectedDependencies()
    }

    /**
     * Convenience function to derive dependency artifact identifier from a microservice. The identifier consists of the
     * package name, name, and possibly the version, if any, of the microservice. All name fragments are separated by
     * the [DependencyDescription.PART_SEP].
     */
    private fun IntermediateMicroservice.artifactIdentifier() : String {
        var identifier = "$packageName${DependencyDescription.PART_SEP}$simpleName"
        if (version !== null)
            identifier += "${DependencyDescription.PART_SEP}$version"
        return identifier
    }
}