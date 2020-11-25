package de.fhdo.lemma.model_processing.code_generation.container_base.source_model_validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationMode
import de.fhdo.lemma.model_processing.languages.XtextImportUriConverterKt
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import org.eclipse.xtext.resource.XtextResource
import de.fhdo.lemma.operation.Container
import org.eclipse.xtext.validation.Check

/**
 * The container base model validator is responsible for checking general aspects for
 * the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SourceModelValidator(supportedFileExtensions='operation',
    validationMode=SourceModelValidationMode.XTEXT
)
class ContainerBaseSourceModelValidator extends AbstractXtextSourceModelValidator {
    /**
     * Get namespace for the operation model package
     */
    override getLanguageNamespace() {
        return OperationPackage.eNS_URI
    }

    /**
     * Prepare the source model for the testing process
     */
    @Before
    def prepareSourceModel(XtextResource xtextResource) {
        val operationModel = xtextResource.getContents().get(0) as OperationModel
        XtextImportUriConverterKt.convertToAbsoluteFileUrisInPlace(operationModel.imports,
            xtextResource)
    }

    /**
     * Check if the source model uses the container base technology
     */
    @Check
    def checkContainer(Container container) {
        val technology = container.technologies.findFirst[t | t.name == "container_base"]

        if (technology === null)
            error("No container base technology found for container, please use the supported"
                + "technology models and name the import container_base.",
                OperationPackage.Literals.CONTAINER__DEPLOYMENT_TECHNOLOGY)
    }
}