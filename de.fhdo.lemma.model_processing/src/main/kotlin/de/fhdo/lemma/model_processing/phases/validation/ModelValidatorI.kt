package de.fhdo.lemma.model_processing.phases.validation

import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import org.eclipse.emf.ecore.resource.Resource

/**
 * Interface for model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface ModelValidatorI {
    operator fun invoke(validationResource: Resource, languageDescription: LanguageDescription,
        relevantModelElements: Collection<*>?) : List<ValidationResult>
    fun setPhaseArguments(phaseArguments: Array<String>)
    fun getPhaseArguments() : Array<String>
    fun getSupportedFileExtensions() : Set<String>
    fun getLanguageNamespace() : String
}