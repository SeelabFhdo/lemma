package de.fhdo.lemma.model_processing.code_generation.deployment_base.intermediate_model_validation

import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import org.eclipse.xtext.validation.Check

/**
 * The Dockerfile model validator is responsible for checking the compatibility of the
 * intermediate operation model with the Dockerfile code generation module.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class DockerFileIntermediateModelValidation extends AbstractXmiDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if a container deploys more than one microservice. This behavior is not supported by
     * the Dockerfile code generation module.
     */
    @Check
    def checkNumberOfDeployedServicesForIntermediateContainers(IntermediateContainer container) {
        if (container.deployedServices.size < 1)
            error("The Dockerfile generation module does not support the deployment of more than "
                + "one microservice per container",
                IntermediatePackage.Literals.OPERATION_MICROSERVICE_REFERENCE__NODE)
    }

    /**
     * Check if the version of the deployed microservice is set.
     */
    @Check
    def checkVersionOfDeplyedServices(IntermediateContainer container) {
        if (container.deployedServices.get(0).version === null)
            warning("The version of the deployed microservice is not set, the version will be "
                + "automatically set to \"v0\"",
                IntermediatePackage.Literals.OPERATION_MICROSERVICE_REFERENCE__NODE)
    }

    /**
     * Check if the operation environment is set.
     */
    @Check
    def checkOperationEnvironment(IntermediateOperationNode node) {
        if (node.operationEnvironment === null)
            error("Operation environment is not set, but it is necessary for the Dockerfile "
                + "generation module to run properly.",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME)
    }
}