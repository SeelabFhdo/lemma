package de.fhdo.lemma.model_processing.code_generation.container_base.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.utils.LemmaUtils

/**
 * The container base intermediate model validator is responsible for checking general aspects for
 * the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class ContainerBaseIntermediateModelValidator extends AbstractXmiDeclarativeValidator {
    static val CONTAINER_BASE_TECHNOLOGY_NAME = "container_base"

    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if container uses the technology supported by the container base code generator.
     */
    @Check
    def checkContainerForContainerBaseTechnology(IntermediateContainer container) {
        val hasContainerBaseTechnology = container.qualifiedDeploymentTechnologyName.toLowerCase
            .startsWith('''«CONTAINER_BASE_TECHNOLOGY_NAME».''')

        if (!hasContainerBaseTechnology)
            error("No supported technology model found for container.",
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if infrastructure node uses the technology supported by the container base code
     * generator.
     */
    def checkInfrastructureNodeForContainerBaseTechnology(IntermediateInfrastructureNode node) {
        val hasContainerBaseTechnology = node.qualifiedInfrastructureTechnologyName.toLowerCase
            .startsWith('''«CONTAINER_BASE_TECHNOLOGY_NAME».''')

        if (!hasContainerBaseTechnology)
            error("No supported technology model found for infrastructure node.",
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if the deployed microservice uses a Maven build technology as the build script
     * code generation module only supports this technology.
     */
    @Check
    def checkMavenBuildTechnologyForContainer(IntermediateContainer container) {
        val aspect = container.aspects.findFirst[aspect | aspect.name == "MavenTechnology"]
        val mavenBuild = if (aspect !== null)
                Boolean.parseBoolean(aspect.propertyValues.get(0).value)
            else
                false

        if (!mavenBuild)
            warning("The container base generation module only support Maven as a build "
                + "technology",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS)
    }

    /**
     * Check if the intermediate operation node contains an endpoint.
     */
    @Check
    def checkPortOfDeployedInfrastructureNode(IntermediateOperationNode node) {
        if (node.endpoints === null || node.endpoints.empty)
            error("The endpoints are not defined, but are required by the code generator.",
                IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Check if the port of the endpoint is set correctly.
     */
    @Check
    def checkPortsOnEndpoints(IntermediateEndpoint endpoint) {
        endpoint.addresses.forEach[address |
            val port = Integer.parseInt(LemmaUtils.getPortFromAddress(address))
            if (port < 0 && port > 65353)
                error("The value of the port is not in the specified port range between " +
                    "0 and 65353.",
                    IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
        ]
    }
}
