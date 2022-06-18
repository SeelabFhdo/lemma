package de.fhdo.lemma.model_processing.builtin_phases.find_model_validators

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase.Companion.ID
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query.IntermediateModelQueryPhase
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.validation.ModelValidatorRegistry

/**
 * Implementation of the model processor's phase for finding model validators on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase(ID, IntermediateModelQueryPhase::class, false)
class FindModelValidatorsPhase : AbstractModelProcessingPhase() {
    companion object {
        const val MODEL_VALIDATOR_REGISTRY_PARAMETER = "modelValidatorRegistry"
        const val ID = "find_model_validators"
    }

    /**
     * Initialize the phase
     */
    override fun initialize(id: String, isOmittable: Boolean, isBlocking: Boolean,
        processorImplementationPackage: String) {
        super.initialize(id, isOmittable, isBlocking, processorImplementationPackage)

        parameters {
            returns {
                MODEL_VALIDATOR_REGISTRY_PARAMETER withType ModelValidatorRegistry::class.java
            }
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        debugPhaseArguments(args)
        val modelValidatorRegistry = ModelValidatorRegistry()
        findAndRegisterModelValidators(ModelKind.SOURCE, modelValidatorRegistry)
        findAndRegisterModelValidators(ModelKind.INTERMEDIATE, modelValidatorRegistry)
        MODEL_VALIDATOR_REGISTRY_PARAMETER returns modelValidatorRegistry
    }

    /**
     * Find and register model validators for the given [modelKind] to the model validator [registry] of the current
     * model processor run
     */
    private fun findAndRegisterModelValidators(modelKind: ModelKind, registry: ModelValidatorRegistry) {
        // Only search for validators if the respective validation phase is in the list of successors of this phase
        if (modelKind.validationPhase !in successors) {
            debugPhase {
                "${modelKind.label.capitalize()} model validation was excluded from the phases to execute. Search " +
                "for ${modelKind.label} model validators aborted."
            }

            return
        }

        registry.findAndRegisterModelValidators(processorImplementationPackage, modelKind)
    }
}