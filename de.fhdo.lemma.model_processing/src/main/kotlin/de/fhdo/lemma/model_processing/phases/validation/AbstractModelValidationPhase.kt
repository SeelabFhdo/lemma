package de.fhdo.lemma.model_processing.phases.validation

import de.fhdo.lemma.model_processing.builtin_phases.ValidationEndedWithErrorsException
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase.Companion.MODEL_VALIDATOR_REGISTRY_PARAMETER
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase.Companion.ID as FIND_MODEL_VALIDATORS_PHASE_ID
import de.fhdo.lemma.model_processing.builtin_phases.print
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.PhaseHeap

/**
 * Superclass for all model processor phases that conduct model validation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractModelValidationPhase(private val modelKind: ModelKind)
    : AbstractModelProcessingPhase() {

    /**
     * Initialize the phase
     */
    final override fun initialize(id: String, isOmittable: Boolean, isBlocking: Boolean,
        processorImplementationPackage: String) {
        super.initialize(id, isOmittable, isBlocking, processorImplementationPackage)

        parameters {
            expects {
                from(FIND_MODEL_VALIDATORS_PHASE_ID) {
                    MODEL_VALIDATOR_REGISTRY_PARAMETER withType ModelValidatorRegistry::class.java
                }
            }

            returns {
                modelKind.validationPhaseArgumentsParameterName withType Array<String>::class.java
            }
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        debugPhaseArguments(args)
        // Return phase arguments so that the Live Validation phase may access them for model validator initialization.
        // Note that this is only possible when the user specified the "--invoke_only_specified_phases" option and
        // selected the validation phases (including the Live Validation phase).
        modelKind.validationPhaseArgumentsParameterName returns args

        val kindLabel = modelKind.label
        val modelFile = modelKind.getFilePathOfPassedModelFromHeap()!!
        debugPhase { "Starting validation of model file \"$modelFile\"" }

        /* Get model validators for file extension */
        val modelValidatorRegistry = PhaseHeap[FIND_MODEL_VALIDATORS_PHASE_ID, MODEL_VALIDATOR_REGISTRY_PARAMETER]
            as ModelValidatorRegistry
        val fileExtension = modelKind.getExtensionOfPassedModel()!!
        val validatorsInfo = modelValidatorRegistry.getModelValidatorsForFileExtension(fileExtension, modelKind)
            .toMutableList()

        if (validatorsInfo.isEmpty())
            debugPhase { "No $kindLabel model validators found for file extension .$fileExtension" }
        else {
            debugPhase { "Found the following $kindLabel model validators for file extension .$fileExtension:" }
            validatorsInfo.forEach { debugPhase { "\t- ${it.name}" } }
        }

        /* Get model validators for language namespaces */
        modelKind.getLanguageNamespacesOfPassedModel()!!.forEach {
            val namespaceValidatorsInfo = modelValidatorRegistry.getModelValidatorsForLanguageNamespace(it, modelKind)
            if (namespaceValidatorsInfo.isEmpty())
                debugPhase { "No $kindLabel model validators found for language namespace $it" }
            else {
                debugPhase { "Found the following $kindLabel model validators for language namespace $it:" }
                namespaceValidatorsInfo.forEach { debugPhase { "\t- ${it.name}" } }
                validatorsInfo.addAll(namespaceValidatorsInfo)
            }
        }

        if (validatorsInfo.isEmpty()) {
            debugPhase { "No $kindLabel model validators found. Phase will not be executed." }
            return
        }

        /* Execute model validators on only relevant model elements, if necessary */
        val relevantModelElements = modelKind.getRelevantElementsOfPassedModel()
        if (relevantModelElements != null)
            debugPhase {
                "Validation will only consider the ${relevantModelElements.size} element(s) returned by the previous " +
                "query phase"
            }
        else
            debugPhase {
                "The previous query phase did not return model elements. Validation will consider *all* $kindLabel " +
                "model elements equally."
            }

        val allValidationResults = mutableListOf<ValidationResult>()
        validatorsInfo.forEach {
            debugPhase { "Executing validator ${it.name}" }

            val validatorInstance = it
                .loadClass(ModelValidatorI::class.java)
                .getDeclaredConstructor()
                .newInstance()
            validatorInstance.setPhaseArguments(args)
            val validationResults = validatorInstance(
                modelKind.getResourceOfPassedModel()!!,
                modelKind.getLanguageDescriptionOfPassedModel()!!,
                relevantModelElements
            )
            allValidationResults.addAll(validationResults)

            if (validationResults.isNotEmpty()) {
                debugPhase { "\t- Received ${validationResults.size} validation result(s):" }
                validationResults.groupingBy { result -> result.type }.eachCount()
                    .forEach { (type, count) -> debugPhase { "\t\t- $type: $count" } }
            } else
                debugPhase { "\t- Did not receive any validation results" }
        }

        /* Print the validation results and exit with an error code, if there were errors among them */
        allValidationResults.print("Validation results for file \"$modelFile\":")
        if (allValidationResults.any { it.type == ValidationResultType.ERROR })
            throw ValidationEndedWithErrorsException()
    }
}