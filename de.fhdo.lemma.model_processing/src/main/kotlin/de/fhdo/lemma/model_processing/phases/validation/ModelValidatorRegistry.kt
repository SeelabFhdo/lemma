package de.fhdo.lemma.model_processing.phases.validation

import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.phases.ModelKind
import io.github.classgraph.ClassInfo

private const val FILE_EXTENSION_IDENTIFIER_PREFIX = "::fileExtension::"
private const val LANGUAGE_NAMESPACE_IDENTIFIER_PREFIX = "::languageNamespace::"

/**
 * Class to maintain a conveniently accessible runtime list of model validators discovered on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ModelValidatorRegistry {
    // Registration maps for validators (key = identifier of the validator in combination with the file extension or
    // language namespace supported by the validator, value = class information about the validator in their order of
    // classpath discovery)
    private val sourceModelValidators = mutableMapOf<String, LinkedHashSet<ClassInfo>>()
    private val intermediateModelValidators = mutableMapOf<String, LinkedHashSet<ClassInfo>>()

    /**
     * Find all model validators on the classpath for the given [processorPackage] and [modelKind]
     */
    fun findAndRegisterModelValidators(processorPackage: String, modelKind: ModelKind,
        vararg classLoaders: ClassLoader) {
        val kindLabel = modelKind.label
        debugPhase {
            "Searching for $kindLabel model validators in processor implementation package \"$processorPackage\""
        }

        val registeredValidatorsInfo = mutableListOf<RegistrationInfo>()
        findAnnotatedClasses(processorPackage, modelKind.validatorAnnotation, *classLoaders)
            .filter {
                it.implementsInterface(ModelValidatorI::class.java.name) ||
                // We also filter for validator superclasses, which implement ModelValidatorI, because ClassGraph may
                // not succeed in retrieving an interface implementation when it is transitive. For example, when the
                // Java Base Generator invokes validators clustered in Genlets, the transitive interface-implementation
                // is missing from annotated validator implementations discovered by ClassGraph.
                it.extendsSuperclass(AbstractXtextModelValidator::class.java.name) ||
                it.extendsSuperclass(AbstractXmiDeclarativeValidator::class.java.name)
            }
            .forEach {
                val registrationInfo = registerValidator(modelKind, it)
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
     * Helper to register a model validator, represented by the given [validatorInfo], for the given [modelKind]
     */
    private fun registerValidator(modelKind: ModelKind, validatorInfo: ClassInfo) : RegistrationInfo {
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
    private fun MutableMap<String, LinkedHashSet<ClassInfo>>.addValidator(
        validatorInfo: ClassInfo,
        fileExtensions: Set<String>,
        languageNamespace: String
    ) {
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