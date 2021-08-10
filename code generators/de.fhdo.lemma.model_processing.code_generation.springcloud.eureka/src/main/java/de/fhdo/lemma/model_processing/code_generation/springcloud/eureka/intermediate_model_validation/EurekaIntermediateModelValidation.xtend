package de.fhdo.lemma.model_processing.code_generation.springcloud.eureka.intermediate_model_validation

import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.model_processing.code_generation.springcloud.eureka.code_generation.EurekaCodeGenerator
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator

/**
 * The Spring Cloud Eureka model validator is responsible for checking the compatibility of the
 * intermediate operation model with the Eureka code generation module.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class EurekaIntermediateModelValidation extends AbstractXmiDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if the container depends on an infrastructure node with a Spring Cloud Eureka
     * technology model
     */
    @Check
    def checkTechnologyForContainer(IntermediateContainer container) {
        val eurekaTechnology = container.dependsOnNodes.exists[
            it.qualifiedTechnologyName.toLowerCase == EurekaCodeGenerator.EUREKA_TECHNOLOGY]

        if(!eurekaTechnology)
            warning('''No supported technology model found for container «container.name»''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if the infrastructure node uses a Spring Cloud Eureka technology model
     */
    @Check
    def checkEurekaTechnologyForInfrastructureNode(IntermediateInfrastructureNode node) {
        if(node.qualifiedInfrastructureTechnologyName.toLowerCase !=
            EurekaCodeGenerator.EUREKA_TECHNOLOGY)
            warning('''No supported technology model found for infrastructure node «node.name».''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }
}