package de.fhdo.lemma.model_processing.code_generation.java_base.validation

import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediatePackage as IntermediateDataPackage
import de.fhdo.lemma.service.intermediate.IntermediatePackage as IntermediateServicePackage
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

/**
 * Intermediate model validator that delegates validations of intermediate data models to Genlets.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@IntermediateModelValidator
@Suppress("unused")
internal class DelegatingIntermediateDataModelValidator : AbstractDelegatingIntermediateModelValidator(
    INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION,
    IntermediateDataModel::class.java
) {
    override fun getLanguageNamespace() = IntermediateDataPackage.eNS_URI
}

/**
 * Abstract class for intermediate model validators that delegate validations to Genlets.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractDelegatingIntermediateModelValidator(
    private val languageDescription: LanguageDescription,
    private val rootElementClass: Class<out EObject>
) : AbstractXmiDeclarativeValidator() {
    /**
     * Delegate validations to Genlets if the user didn't disable them
     */
    @Before
    private fun delegateValidationToGenlets(resource: Resource) {
        if (CommandLine.disableGenletValidations)
            return

        if (resource.contents.isEmpty() || resource.contents[0].mainInterface != rootElementClass)
            return

        executeGenletValidations { genlet, classLoader ->
            genlet.executeIntermediateModelValidatorsForLanguageNamespace(resource, languageDescription,
                getLanguageNamespace(), classLoader)
        }
    }
}

/**
 * Intermediate model validator that delegates validations of intermediate service models to Genlets.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@IntermediateModelValidator
@Suppress("unused")
internal class DelegatingIntermediateServiceModelValidator : AbstractDelegatingIntermediateModelValidator(
    INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION,
    IntermediateServiceModel::class.java
) {
    override fun getLanguageNamespace() = IntermediateServicePackage.eNS_URI
}