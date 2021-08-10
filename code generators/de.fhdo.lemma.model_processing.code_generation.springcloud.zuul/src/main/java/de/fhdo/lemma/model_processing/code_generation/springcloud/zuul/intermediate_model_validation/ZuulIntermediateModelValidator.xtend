package de.fhdo.lemma.model_processing.code_generation.springcloud.zuul.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.zuul.code_generation.ZuulCodeGenerator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator

/**
 * The Spring Cloud Zuul intermediate model validator is responsible for checking general aspects
 * for the Spring Cloud Zuul code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class ZuulIntermediateModelValidator extends AbstractXmiDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if the infrastructure node uses a Spring cloud Zuul technology model
     */
    @Check
    def checkEurekaTechnologyForInfrastructureNode(IntermediateInfrastructureNode node) {
        if(node.qualifiedInfrastructureTechnologyName.toLowerCase !=
            ZuulCodeGenerator.ZUUL_TECHNOLOGY)
            warning('''No supported technology model found for infrastructure node «node.name».''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }
}