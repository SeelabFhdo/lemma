package de.fhdo.lemma.model_processing.builtin_phases.live_validation

import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.printlnError
import de.fhdo.lemma.model_processing.builtin_phases.NoValidatorFoundException
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.phases.PhaseHeap
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import io.github.classgraph.ClassInfo
import java.util.concurrent.ExecutionException
import kotlin.reflect.KClass

internal typealias ValidatorClassWithPhaseArguments = Pair<ClassInfo, Array<String>>

/**
 * Implementation of the model processor's Live Validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ExplicitlyInvokedModelProcessingPhase("live_validation", true, true)
internal class LiveValidationPhase : AbstractModelProcessingPhase() {
    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        val validators = findXtextModelValidators(processorImplementationPackage)
        if (validators.isEmpty())
            throw NoValidatorFoundException("Live validation not possible, because no Xtext-enabled model validators " +
                "were be found on the classpath")

        with(PhaseCommandLine) {
            try {
                invoke(args)
            } catch (ex: java.lang.Exception) {
                throw PhaseException(ex.message)
            }

            try {
                // Connect to a running Live Validation server
                LiveValidator(validators).start(hostname, port)
                println("Live Validation client started and listening for validation requests on $hostname:$port")
            } catch (ex: Exception) {
                if (ex.cause is ExecutionException)
                    printlnError("Live Validation client could not connect to Live Validation server expected on " +
                        "$hostname:$port")

                printlnError("Live Validation client could not be started: ${ex.message}")
            }
        }
    }
}

/**
 * Helper to find, per file extension, Xtext-enabled model validators and their phase arguments on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findXtextModelValidators(implementationPackage: String)
    : Map<String, List<ValidatorClassWithPhaseArguments>> {
    val validatorsAndArgumentsForExtensions = mutableMapOf<String, MutableList<ValidatorClassWithPhaseArguments>>()

    // Find all Xtext-enabled source and intermediate model validators with their possible phase arguments
    val xtextModelValidators = findXtextModelValidators(implementationPackage, SourceModelValidator::class)
        .toMutableMap()
    xtextModelValidators.putAll(findXtextModelValidators(implementationPackage, IntermediateModelValidator::class))

    // Add found validators to result map for the file extensions they support
    for ((validatorInfo, phaseArguments) in xtextModelValidators) {
        val validatorInstance = validatorInfo
            .loadClass(AbstractXtextModelValidator::class.java)
            .getDeclaredConstructor()
            .newInstance()
        validatorInstance.getSupportedFileExtensions().forEach {
            if (!validatorsAndArgumentsForExtensions.containsKey(it))
                validatorsAndArgumentsForExtensions[it] = mutableListOf(validatorInfo to phaseArguments)
            else
                validatorsAndArgumentsForExtensions[it]!!.add(validatorInfo to phaseArguments)
        }
    }

    return validatorsAndArgumentsForExtensions
}

/**
 * Helper to find all Xtext-enabled model validators with a given [annotationClass] on the classpath. Next to the
 * [ClassInfo], each found validator will be accompanied by its possible arguments from the respective validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findXtextModelValidators(implementationPackage: String, annotationClass: KClass<out Annotation>) :
    Map<ClassInfo, Array<String>> {
    // Get possible phase arguments for the validators
    @Suppress("UNCHECKED_CAST")
    val phaseArguments = when (annotationClass) {
        SourceModelValidator::class -> PhaseHeap["intermediate_model_validation", "sourceModelValidationPhaseArguments"]
        IntermediateModelValidator::class ->
            PhaseHeap["intermediate_model_validation", "intermediateModelValidationPhaseArguments"]
        else -> throw IllegalArgumentException("Annotation class must be of type " +
            "${SourceModelValidator::class.java.name} or ${IntermediateModelValidator::class.java.name}")
    } as? Array<String> ?: emptyArray()

    return findAnnotatedClasses(implementationPackage, annotationClass)
        .filter { it.extendsSuperclass(AbstractXtextModelValidator::class.java.name) }
        .associateWith { phaseArguments }
}