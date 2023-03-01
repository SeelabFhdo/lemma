package de.fhdo.lemma.model_processing.code_generation.springcloud.cloud_config.intermediate_model_validation

import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator

/**
 * The Spring Cloud Config model validator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class CloudConfigIntermediateModelValidation extends AbstractXmiDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Example Check
     */
    @Check
    def checkContainer(IntermediateContainer container) {

            warning(''' «container.name».''',
                IntermediatePackage.Literals.INTERMEDIATE_CONTAINER__OPERATION_MODEL)
    }
}