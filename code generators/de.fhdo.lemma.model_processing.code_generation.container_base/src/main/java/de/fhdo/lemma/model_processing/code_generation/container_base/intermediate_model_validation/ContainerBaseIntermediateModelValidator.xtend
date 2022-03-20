package de.fhdo.lemma.model_processing.code_generation.container_base.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint
import de.fhdo.lemma.model_processing.code_generation.container_base.ContainerBaseGenerator

/**
 * The container base intermediate model validator is responsible for checking general aspects for
 * the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class ContainerBaseIntermediateModelValidator extends AbstractXmiDeclarativeValidator {
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
        if (!container.hasContainerBaseTechnology)
            warning('''Ignoring container "«container.name»" as it does not apply a technology ''' +
                '''model for the "«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME»" ''' +
                "technology",
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Helper to check if a container applies the container base technology model
     */
    private def hasContainerBaseTechnology(IntermediateContainer container) {
        return container.qualifiedDeploymentTechnologyName.toLowerCase
            .startsWith('''«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME.toLowerCase».''')
    }

    /**
     * Check if infrastructure node uses the technology supported by the container base code
     * generator.
     */
    @Check
    def checkInfrastructureNodeForContainerBaseTechnology(IntermediateInfrastructureNode node) {
        if (!node.hasContainerBaseTechnology)
            warning('''Ignoring infrastructure node "«node.name»" as it does not apply a ''' +
                "technology model for the " +
                '''"«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME»" technology''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Helper to check if an infrastructure node applies the container base technology model
     */
    private def hasContainerBaseTechnology(IntermediateInfrastructureNode node) {
        return node.qualifiedInfrastructureTechnologyName.toLowerCase
            .startsWith('''«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME.toLowerCase».''')
    }

    /**
     * Check if a container applying the container base technology has at least one endpoint
     */
    @Check
    def checkEndpoints(IntermediateContainer container) {
        if (!container.hasContainerBaseTechnology) {
            return
        }

        if (container.endpoints === null || container.endpoints.empty)
            error('''Container "«container.name»" must specify at least one endpoint''',
                IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Check if an infrastructure node applying the container base technology has at least one
     * endpoint
     */
    @Check
    def checkEndpoints(IntermediateInfrastructureNode node) {
        if (!node.hasContainerBaseTechnology) {
            return
        }

        if (node.endpoints === null || node.endpoints.empty)
            error('''Infrastructure node "«node.name»" must specify at least one endpoint''',
                IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Check endpoint ports for correct value
     */
    @Check
    def checkPorts(IntermediateOperationEndpoint endpoint) {
        val ports = endpoint.addresses.map[LemmaUtils.getPortFromAddress(it)]
        val invalidPorts = ports.filter[
            val port = Integer.parseInt(it)
            !it.empty && (port < 1 || port > 65353)
        ]
        if (invalidPorts.empty) {
            return
        }

        val nodeName = endpoint.node.name
        error('''Operation node "«nodeName»" specifies an address with invalid ports ''' +
            invalidPorts.join(", "),
            IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }
}
