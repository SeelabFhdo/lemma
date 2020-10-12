package de.fhdo.lemma.model_processing.builtin_phases.source_model_validation

import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult

/**
 * Interface to be implemented by source model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface SourceModelValidatorI {
    fun getLanguageNamespace() : String
    operator fun invoke(fileToValidate: String) : List<ValidationResult>
    fun setPhaseArguments(phaseArguments: Array<String>)
    fun getPhaseArguments() : Array<String>
}