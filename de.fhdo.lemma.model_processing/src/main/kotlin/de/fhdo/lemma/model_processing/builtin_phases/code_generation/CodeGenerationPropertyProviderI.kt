package de.fhdo.lemma.model_processing.builtin_phases.code_generation

/**
 * Interface to be implemented by code generation property providers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface CodeGenerationPropertyProviderI {
    fun getProperties() : Map<String, String>
}