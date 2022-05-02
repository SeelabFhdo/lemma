package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.shared

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.toProperty

/**
 * Singleton that represents the contents of the Spring "application.properties" file and the properties contributed by
 * the springcloud.mtls Genlet.
 */
internal object ApplicationProperties {
    private var propertyFile: PropertyFile? = null
    private var addedNewProperties = false

    /**
     * Initialize the Singleton
     */
    fun initialize() {
        // Open the "application.properties" file created during the current code generation run
        propertyFile = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH,
            "application.properties")
    }

    /**
     * Convenience function that calls [toProperty] and sets [addedNewProperties] to true, if the new property could be
     * added
     */
    fun IntermediateImportedAspect.newApplicationProperty(aspectPropertyName: String, targetPropertyName: String)
        : String? {
        val newPropertyValue = toProperty(aspectPropertyName, propertyFile!!, targetPropertyName)
        if (newPropertyValue != null)
            addedNewProperties = true
        return newPropertyValue
    }

    /**
     * Get Singleton as [GenletGeneratedFileContent] representing the "application.properties" file contents
     */
    internal fun getGeneratedFile() = if (addedNewProperties)
            mutableSetOf(GenletGeneratedFileContent(propertyFile!!))
        else
            mutableSetOf()

    /**
     * Reset the Singleton
     */
    fun reset() {
        propertyFile = null
    }
}