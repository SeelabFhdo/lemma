package de.fhdo.lemma.model_processing.builtin_phases.find_model_validators

import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.validation.ModelValidatorI
import io.github.classgraph.ClassInfo

private const val FILE_EXTENSION_IDENTIFIER_PREFIX = "::fileExtension::"
private const val LANGUAGE_NAMESPACE_IDENTIFIER_PREFIX = "::languageNamespace::"

/**
 * Object to maintain a conveniently accessible runtime list of model validators discovered on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object AvailableModelValidators {
    // Registration maps for validators (key = identifier of the validator in combination with the file extension or
    // language namespace supported by the validator, value = class information about the validator in their order of
    // classpath discovery)
    private val sourceModelValidators = mutableMapOf<String, LinkedHashSet<ClassInfo>>()
    private val intermediateModelValidators = mutableMapOf<String, LinkedHashSet<ClassInfo>>()

    /**
     * Find all model validators for the given model [modelKind] on the classpath
     */
    fun findAndRegisterModelValidators(processorPackage: String, modelKind: ModelKind) {
        val kindLabel = modelKind.label
        debugPhase {
            "Searching for $kindLabel model validators in processor implementation package \"$processorPackage\""
        }

        val registeredValidatorsInfo = mutableListOf<RegistrationInfo>()
        findAnnotatedClasses(processorPackage, modelKind.validatorAnnotation)
            .filter { it.implementsInterface(ModelValidatorI::class.java.name) }
            .forEach {
                val registrationInfo = registerValidator(it, modelKind)
                registeredValidatorsInfo.add(registrationInfo)
            }

        if (registeredValidatorsInfo.isNotEmpty()) {
            debugPhase { "Found and registered the following $kindLabel model validators:" }
            registeredValidatorsInfo.forEach {
                debugPhase {
                    "\t- ${it.validatorName} (extensions: \"${it.fileExtensions.joinToString { ".$it" }}\", " +
                    "namespace: \"${it.languageNamespace}\")"
                }
            }
        } else
            debugPhase { "No $kindLabel model validators found" }
    }

    /**
     * Helper class to cluster registration information of a model validator
     */
    private class RegistrationInfo(val validatorName: String, val fileExtensions: Set<String>,
        val languageNamespace: String)

    /**
     * Register a model validator with the given [validatorInfo] and for the given [modelKind] to the object
     */
    private fun registerValidator(validatorInfo: ClassInfo, modelKind: ModelKind) : RegistrationInfo {
        require(validatorInfo.implementsInterface(ModelValidatorI::class.java.name)) {
            "Validator class does not implement interface ${ModelValidatorI::class.simpleName}"
        }

        val validatorInstance = validatorInfo
            .loadClass(ModelValidatorI::class.java)
            .getDeclaredConstructor()
            .newInstance()
        val fileExtensions = validatorInstance.getSupportedFileExtensions()
        val languageNamespace = validatorInstance.getLanguageNamespace()

        modelKind.validatorRegistrationMap().addValidator(validatorInfo, fileExtensions, languageNamespace)

        return RegistrationInfo(validatorInfo.name, fileExtensions, languageNamespace)
    }

    /**
     * Helper to get the validator registration map for this [ModelKind]
     */
    private fun ModelKind.validatorRegistrationMap()
        = when (this) {
            ModelKind.SOURCE -> sourceModelValidators
            ModelKind.INTERMEDIATE -> intermediateModelValidators
        }

    /**
     * Helper to add a found model validator to this validator registration map
     */
    private fun MutableMap<String, LinkedHashSet<ClassInfo>>.addValidator(validatorInfo: ClassInfo,
        fileExtensions: Set<String>, languageNamespace: String) {
        // Gather all registration identifiers for the validator depending on the variety of supported file extensions
        // and the language namespace
        val identifiers = fileExtensions.map { it.identifier(FILE_EXTENSION_IDENTIFIER_PREFIX) }.toMutableList()
        if (languageNamespace.isNotEmpty())
            identifiers.add(languageNamespace.identifier(LANGUAGE_NAMESPACE_IDENTIFIER_PREFIX))

        // Add the validator information under its applicable identifiers to this registration map
        identifiers.forEach {
            if (it !in this)
                this[it] = LinkedHashSet()
            this[it]!!.add(validatorInfo)
        }
    }

    /**
     * Create an identifier with the given [prefix] for an entry in the validator registration map
     */
    private fun String.identifier(prefix: String) = "${prefix}__$this"

    /**
     * Get the available model validators for the given [fileExtension] and [modelKind]
     */
    fun getModelValidatorsForFileExtension(fileExtension: String, modelKind: ModelKind)
        = modelKind.validatorRegistrationMap()[fileExtension.identifier(FILE_EXTENSION_IDENTIFIER_PREFIX)]?.toList()
            ?: emptyList()

    /**
     * Get the available model validators for the given [languageNamespace] and [modelKind]
     */
    fun getModelValidatorsForLanguageNamespace(languageNamespace: String, modelKind: ModelKind)
        = modelKind.validatorRegistrationMap()[languageNamespace.identifier(LANGUAGE_NAMESPACE_IDENTIFIER_PREFIX)]
            ?.toList() ?: emptyList()
}