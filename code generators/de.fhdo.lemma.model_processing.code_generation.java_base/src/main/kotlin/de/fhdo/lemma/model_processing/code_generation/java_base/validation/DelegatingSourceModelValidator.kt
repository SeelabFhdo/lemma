package de.fhdo.lemma.model_processing.code_generation.java_base.validation

import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.DATA_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.MAPPING_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.SERVICE_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import org.eclipse.emf.ecore.resource.Resource

/**
 * Source model validator that delegates validations of data, mapping, and service models to Genlets.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@SourceModelValidator
internal class DelegatingSourceModelValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("data", "services", "mapping")

    /**
     * Delegate validations to Genlets if the user didn't disable them
     */
    @Before
    private fun delegateValidationToGenlets(resource: Resource) {
        if (CommandLine.disableGenletValidations || resource.contents.isEmpty())
            return

        val modelRoot = resource.contents[0]
        val (languageDescription, fileExtension) = when(modelRoot) {
            is DataModel -> DATA_DSL_LANGUAGE_DESCRIPTION to "data"
            is ServiceModel -> SERVICE_DSL_LANGUAGE_DESCRIPTION to "services"
            is TechnologyMapping -> MAPPING_DSL_LANGUAGE_DESCRIPTION to "mapping"
            else -> return
        }

        executeGenletValidations { genlet, classLoader ->
            genlet.executeSourceModelValidatorsForFileExtension(resource, languageDescription, fileExtension,
                classLoader)
        }
    }
}