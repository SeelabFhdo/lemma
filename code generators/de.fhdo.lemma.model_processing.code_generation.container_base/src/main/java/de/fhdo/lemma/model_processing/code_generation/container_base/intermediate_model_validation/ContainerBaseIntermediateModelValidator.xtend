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
import static de.fhdo.lemma.model_processing.code_generation.container_base.util.Util.*
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import java.util.List

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
        if (!hasContainerBaseTechnology(container))
            warning('''Ignoring container "«container.name»" as it does not apply a technology ''' +
                '''model for the "«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME»" ''' +
                "technology",
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check the applications of the "ArtifactId" aspect
     */
    @Check
    def checkArtifactIdApplications(IntermediateContainer container) {
        val artifactIdAspects = getAspectApplications(
            container,
            ContainerBaseGenerator.BUILD_MANAGEMENT_TECHNOLOGY_NAME,
            "ArtifactId"
        ).toList

        checkArtifactIdAspectApplicationForDuplicatePropertyValues(
            artifactIdAspects,
            "artifactId",
            "ID",
            container
        )

        checkArtifactIdAspectApplicationForDuplicatePropertyValues(
            artifactIdAspects,
            "serviceName",
            "service",
            container
        )

        artifactIdAspects.forEach[it.checkArtifactIdAspectApplication(container)]
    }

    /**
     * Helper to check for duplicate property values in applications of the "ArtifactId" aspect
     */
    private def checkArtifactIdAspectApplicationForDuplicatePropertyValues(
        List<IntermediateImportedAspect> aspectApplications,
        String propertyName,
        String printablePropertyName,
        IntermediateContainer container
    ) {
        val propertyValues = aspectApplications.map[getPropertyValue(it, propertyName)].toList
        val duplicateIndex = LemmaUtils.getDuplicateIndex(propertyValues, [it])
        if (duplicateIndex == 0) {
            return
        }

        val duplicateValue = propertyValues.get(duplicateIndex)
        error('''Container «container.name»: Applications of ArtifactId aspect configure ''' +
            '''duplicate «printablePropertyName» "«duplicateValue»"''',
            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS)
    }

    /**
     * Helper to a single application of the "ArtifactId" aspect
     */
    private def checkArtifactIdAspectApplication(IntermediateImportedAspect aspect,
        IntermediateContainer container) {
        val serviceName = getPropertyValue(aspect, "serviceName")
        if (serviceName.empty)
            error('''Container «container.name»: "serviceName" property of ArtifactId aspect ''' +
                "must not be empty",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS)

        val deployedServiceNames = container.deployedServices.map[it.qualifiedName].toSet
        if (!deployedServiceNames.contains(serviceName))
            error('''Container «container.name»: ArtifactId aspect refers to service ''' +
                '''"«serviceName»" which is not deployed to the container''',
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS)

        val artifactId = getPropertyValue(aspect, "artifactId")
        if (artifactId.empty)
            error('''Container «container.name»: "artifactId" property of ArtifactId aspect ''' +
                "must not be empty",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS)
    }

    /**
     * Check if infrastructure node uses the technology supported by the container base code
     * generator.
     */
    @Check
    def checkInfrastructureNodeForContainerBaseTechnology(IntermediateInfrastructureNode node) {
        if (!hasContainerBaseTechnology(node))
            warning('''Ignoring infrastructure node "«node.name»" as it does not apply a ''' +
                "technology model for the " +
                '''"«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME»" technology''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if a container applying the container base technology has at least one endpoint
     */
    @Check
    def checkEndpoints(IntermediateContainer container) {
        if (!hasContainerBaseTechnology(container)) {
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
        if (!hasContainerBaseTechnology(node)) {
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
