package de.fhdo.lemma.model_processing.builtin_phases.find_model_validators

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query.IntermediateModelQueryPhase
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Implementation of the model processor's phase for finding model validators on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("find_model_validators", IntermediateModelQueryPhase::class, false)
internal class FindModelValidatorsPhase : AbstractModelProcessingPhase() {
    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        debugPhaseArguments(args)
        findAndRegisterModelValidators(ModelKind.SOURCE)
        findAndRegisterModelValidators(ModelKind.INTERMEDIATE)
    }

    /**
     * Find and register model validators in the [AvailableModelValidators] object for the given [ModelKind]
     */
    private fun findAndRegisterModelValidators(modelKind: ModelKind) {
        // Only search for validators if the respective validation phase is in the list of successors of this phase
        if (modelKind.validationPhase !in successors) {
            debugPhase {
                "${modelKind.label.capitalize()} model validation was excluded from the phases to execute. Search " +
                "for ${modelKind.label} model validators aborted."
            }
            return
        }

        AvailableModelValidators.findAndRegisterModelValidators(processorImplementationPackage, modelKind)
    }
}