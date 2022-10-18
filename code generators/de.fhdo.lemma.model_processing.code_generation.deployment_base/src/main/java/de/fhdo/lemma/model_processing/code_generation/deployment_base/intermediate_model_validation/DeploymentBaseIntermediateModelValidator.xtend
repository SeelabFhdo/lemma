package de.fhdo.lemma.model_processing.code_generation.deployment_base.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint
import static de.fhdo.lemma.model_processing.code_generation.deployment_base.util.Util.*
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import java.util.List
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
import java.util.regex.Pattern
import de.fhdo.lemma.model_processing.code_generation.deployment_base.DeploymentBaseGenerator

/**
 * The Deployment Base intermediate model validator is responsible for checking general aspects for
 * the Deployment Base Generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class DeploymentBaseIntermediateModelValidator extends AbstractXmiDeclarativeValidator {
    static val PORT_MAPPING_PATTERN = Pattern.compile("(?<hostPort>\\d+):(?<containerPort>\\d+)")

    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if container uses the technology supported by the Deployment Base Generator.
     */
    @Check
    def checkContainerForContainerBaseTechnology(IntermediateContainer container) {
        if (!hasContainerBaseTechnology(container))
            warning('''Ignoring container "«container.name»" as it does not apply a technology ''' +
                '''model for the "«DeploymentBaseGenerator.DEPLOYMENT_BASE_TECHNOLOGY_NAME»" ''' +
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
            DeploymentBaseGenerator.BUILD_MANAGEMENT_TECHNOLOGY_NAME,
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
     * Check if infrastructure node uses the technology supported by the Deployment Base Generator
     */
    @Check
    def checkInfrastructureNodeForDeploymentBaseTechnology(IntermediateInfrastructureNode node) {
        if (!hasContainerBaseTechnology(node))
            warning('''Ignoring infrastructure node "«node.name»" as it does not apply a ''' +
                "technology model for the " +
                '''"«DeploymentBaseGenerator.DEPLOYMENT_BASE_TECHNOLOGY_NAME»" technology''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if a container applying the deployment base technology has at least one endpoint
     */
    @Check
    def checkEndpoints(IntermediateContainer container) {
        if (!hasContainerBaseTechnology(container)) {
            return
        }

        val containerHasEndpoints = container.endpoints !== null && !container.endpoints.empty
        val allSpecificationsHaveEndpoints = container.specifications
            .forall[endpoints !== null && !endpoints.empty]

        if (!containerHasEndpoints && !allSpecificationsHaveEndpoints)
            error('''Container "«container.name»" must specify at least one endpoint''',
                IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Check if an infrastructure node applying the deployment base technology has at least one
     * endpoint
     */
    @Check
    def checkEndpoints(IntermediateInfrastructureNode node) {
        if (!hasContainerBaseTechnology(node)) {
            return
        }

        val nodeHasEndpoints = node.endpoints !== null && !node.endpoints.empty
        val allSpecificationsHaveEndpoints = node.specifications
            .forall[endpoints !== null && !endpoints.empty]

        if (!nodeHasEndpoints && !allSpecificationsHaveEndpoints)
            error('''Infrastructure node "«node.name»" must specify at least one endpoint''',
                IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Check endpoint ports for correct ranges
     */
    @Check
    def checkPortRange(IntermediateOperationEndpoint endpoint) {
        val ports = endpoint.addresses.map[LemmaUtils.getPortFromAddress(it)]
        val invalidPorts = ports.filter[!it.validPortRange]
        if (invalidPorts.empty) {
            return
        }

        val nodeName = endpoint.node.name
        error('''Operation node "«nodeName»" specifies an address with invalid ports ''' +
            invalidPorts.join(", "),
            IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT)
    }

    /**
     * Helper to check if a given port string represents a port with a valid value range
     */
    private def isValidPortRange(String portString) {
        val port = Integer.parseInt(portString)
        return !portString.empty && port >= 1 && port <= 65353
    }

    /**
     * Check custom port mappings modeled for deployed microservices using the "customPortMapping"
     * configuration property for correctness
     */
    @Check
    def checkCustomPortMappings(IntermediateContainer container) {
        val configuredPortMappingsPerDeployedService
            = <OperationMicroserviceReference, List<String>>newHashMap
        container.deployedServices.forEach[service |
            val configuredPortMappings = container.getEffectiveConfigurationValues(service)
                .filter["customPortMapping".equalsIgnoreCase(it.technologySpecificProperty.name)]
                .map[it.value]
                .toList
            configuredPortMappingsPerDeployedService.put(service, configuredPortMappings)
        ]

        configuredPortMappingsPerDeployedService.forEach[service, mappings | mappings.forEach[
            container.checkCustomPortMapping(service, it)
        ]]
    }

    /**
     * Helper to check a single custom port mapping of a deployed microservice for correctness
     */
    private def checkCustomPortMapping(
        IntermediateContainer container,
        OperationMicroserviceReference service,
        String mapping
    ) {
        val mappingMatcher = PORT_MAPPING_PATTERN.matcher(mapping)

        // Check for correct format
        if (!mappingMatcher.matches) {
            error('''Invalid port mapping for container "«container.name»" and deployed ''' +
                '''microservice "«service.qualifiedName»": Mapping "«mapping»" has invalid ''' +
                "format (expected: <PORT>:<PORT>)",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
            return
        }

        // Check host port for valid value range
        val hostPort = mappingMatcher.group("hostPort")
        if (!hostPort.validPortRange) {
            error('''Invalid port mapping for container "«container.name»" and deployed ''' +
                '''microservice "«service.qualifiedName»": Host port «hostPort» of mapping ''' +
                '''"«mapping»" is out of range''',
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
            return
        }

        // Check container port for valid value range
        val containerPort = mappingMatcher.group("containerPort")
        if (!containerPort.validPortRange)
            error('''Invalid port mapping for container "«container.name»" and deployed ''' +
                '''microservice "«service.qualifiedName»": Container port «containerPort» of ''' +
                '''mapping "«mapping»" is out of range''',
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
    }

    /**
     * Check the server ports configured for a container
     */
    @Check
    def checkConfiguredServerPorts(IntermediateContainer container) {
        val configuredPortsPerDeployedService
            = <OperationMicroserviceReference, List<String>>newHashMap
        container.deployedServices.forEach[service |
            val configuredPorts = container.getEffectiveConfigurationValues(service)
                .filter["serverPort".equalsIgnoreCase(it.technologySpecificProperty.name)]
                .map[it.value]
                .toList
            configuredPortsPerDeployedService.put(service, configuredPorts)
        ]

        configuredPortsPerDeployedService.forEach[service, ports |
            container.checkUnambiguousServerPorts(service, ports)
        ]
    }

    /**
     * Helper to check that the server port values specified for a deployed microservice are
     * unambiguous
     */
    private def checkUnambiguousServerPorts(
        IntermediateContainer container,
        OperationMicroserviceReference service,
        List<String> ports
    ) {
        if (ports.empty) {
            return
        }

        /*
         * Check that values for the container-specific "serverPort" configuration property are
         * unambiguous
         */
        val configuredPort = ports.get(0)
        val ambiguousPorts = ports.filter[it != configuredPort]
        if (ambiguousPorts.size == 1) {
            error('''Port specification of container "«container.name»" is ambiguous for ''' +
                '''deployed microservice "«service.qualifiedName»": First "serverPort" value ''' +
                '''is «configuredPort» which differs from the second value ''' +
                ambiguousPorts.get(0),
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
            return
        } else if (ambiguousPorts.size > 1) {
            error('''Port specification of container "«container.name»" is ambiguous for ''' +
                '''deployed microservice "«service.qualifiedName»": First "serverPort" value ''' +
                '''value is «configuredPort» which differs from the following values ''' +
                ambiguousPorts.join(", "),
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
            return
        }

        /*
         * Check that a potential port value modeled for the deployed service is unambiguous w.r.t.
         * potential values for the container-specific "serverPort" configuration property
         */
        val springPort = getSpringServerPort(service)
        if (!springPort.nullOrEmpty && springPort != configuredPort)
            error('''Port specification of container "«container.name»" is ambiguous for ''' +
                '''deployed microservice "«service.qualifiedName»": The container specifies ''' +
                '''the port «configuredPort» using the "serverPort" property, whereas the ''' +
                '''microservice specifies the port «springPort» using the Application aspect ''' +
                "from the Spring technology model",
                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__NAME)
    }
}
