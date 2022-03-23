package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.databind.ObjectMapper
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util
import de.fhdo.lemma.utils.LemmaUtils
import java.io.File
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class uses the singleton design pattern handling the generation of the docker-compose file.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OpenedDockerComposeFile {
    static OpenedDockerComposeFile instance
    @Accessors
    String dockerComposePath
    @Accessors
    DockerComposeFile dockerComposeFile
    boolean initialized = false

    /**
     * Get or create instance of the OpendDockerComposeFile class.
     */
    static def OpenedDockerComposeFile getInstance() {
        if (instance === null)
            instance = new OpenedDockerComposeFile

        return instance
    }

    /**
     * This method initializes the OpendDockerComposeFile class. Therefore the target folder for the
     * docker-compose file is set. Additionally, an existing docker-compose file is loaded from the
     * file system into the DockerComposeFile date structure.
     */
    def init(String targetFolder) {
        if (initialized)
            throw new IllegalStateException("OpenedDockerComposeFile is already initialized.")

        dockerComposePath = '''«targetFolder»«File.separator»docker-compose.yaml'''
        initialized = true
    }

    /**
     * Load a existing docker-compose file form the file system. If there is no docker-compose file
     * present a default network configuration is created, because LEMMA's operation modeling
     * language does in its actual version not support the handling of network configurations.
     */
    def openExistingDockerComposeFile() {
        // Check if the file exists and contains actual lines of code
        if (new File(dockerComposePath).exists && new File(dockerComposePath).length > 0)
            loadDockerComposePartsFromFile
        else
            createNewDockerFile
    }

    /**
     * Add or replace a docker-compose part to the docker-compose file based on the name of the
     * operation node. The configuration of the docker-compose part is created by the docker-compose
     * code generation module itself.
     *
     * Note: The docker-compose part is done separately for intermediate container and intermediate
     * infrastructure nodes.
     */
    def addOrReplaceDockerComposePart(IntermediateOperationNode node) {
        switch (node) {
            IntermediateInfrastructureNode:
                dockerComposeFile.services.put(node.name, node.serviceFromNode)

            IntermediateContainer: {
                val service = node.serviceFromContainer
                dockerComposeFile.services.put(service.name, service)
            }

            default : throw new IllegalArgumentException("OperationNode instance not supported.")
        }
    }

    /**
     * Add or replace a docker-compose part to the docker-compose file based on the name of the
     * operation node.The configuration of the docker-compose part is created by an intermediate
     * deployment aspect.
     */
    def addOrReplaceDockerComposePart(String name, String dockerComposeServicePart) {
        val adjustedDockerPart = Util::adjustIndentations("", dockerComposeServicePart) + "\n"
        val mapper = new ObjectMapper(new YAMLFactory());
        val service = mapper.readValue(adjustedDockerPart, DockerComposeService)
        dockerComposeFile.services.put(name.toLowerCase, service)
    }

    /**
     * Create a new docker compose file and add ne default network. The default network is needed
     * because LEMMA's operation modeling language does not support network configurations at the
     * moment.
     */
    private def createNewDockerFile() {
        dockerComposeFile = new DockerComposeFile
        var network = new DockerComposeNetwork()
        network.driver = "bridge"
        dockerComposeFile.networks.put("default-network", network)
        dockerComposeFile.version = "3.7"
    }

    /**
     * Create a POJO Service from a container
     */
    private def DockerComposeService getServiceFromContainer(IntermediateContainer container) {
        val service = new DockerComposeService

        val deployedService = container.deployedServices.get(0)
        service.name = '''«deployedService.name»_in_«container.name»'''

        service.build = Util.buildPathFromQualifiedName(
            container.deployedServices.get(0).qualifiedName
        )
        service.image = container.name.toLowerCase
        service.containerName = container.name.toLowerCase
        service.networks.add("default-network")

        val configuredServerPort = container.getEffectiveConfigurationValues(deployedService)
            .findFirst["serverPort".equalsIgnoreCase(it.technologySpecificProperty.name)]
            ?.value
        container.endpoints.forEach[endpoint |
            // Identify the port for the container which should be the port of the deployed
            // microservice. According to the Container Base Generator, each container requires an
            // endpoint. In case the container specifies and endpoint for HTTP or REST, we try to
            // extract the port from the model of the deployed microservice, and the potential
            // application of the Spring technology model and its Application aspect. That is,
            // because the aspect's "port" property determines the HTTP port of a modeled
            // microservice. If this strategy does not yield a container port, e.g., because the
            // deployed microservice is not a Spring microservice, we leverage a potential value for
            // the "serverPort" configuration property which allows container-based specification of
            // the deployed microservice's port.
            // With the described approach, either microservice developers or operators can
            // determine a microservice's ports depending on the employed DevOps model (see also
            // the Container Base Generator's intermediate model validator by which we prevent
            // ambiguous port specifications on microservices and containers).
            var containerPort = switch (endpoint.protocol.toLowerCase) {
                case "http",
                case "rest": Util.getSpringServerPort(deployedService)
                default: null
            }
            if (containerPort === null)
                containerPort = configuredServerPort

            for (address : endpoint.addresses) {
                val hostPort = LemmaUtils.getPortFromAddress(address)
                if (containerPort.nullOrEmpty)
                    containerPort = hostPort

                if (!hostPort.nullOrEmpty && !containerPort.nullOrEmpty)
                    service.ports.add('''«hostPort»:«containerPort»''')
            }
        ]

        return service
    }

    /**
     * Create a POJO Service from a infrastructure node
     */
     def DockerComposeService getServiceFromNode(IntermediateInfrastructureNode node) {
        val service = new DockerComposeService
        service.build = node.name.toLowerCase
        service.image = node.name.toLowerCase
        service.containerName = node.name.toLowerCase
        service.networks.add("default-network")

        node.endpoints.forEach[endpoint |
            endpoint.addresses.forEach[address |
                val port = LemmaUtils.getPortFromAddress(address)
                service.ports.add('''«port»:«port»''')
            ]
        ]

        return service
    }

    /**
     * Load a existing docker-compose file from the target folder
     */
    private def loadDockerComposePartsFromFile() {
        val mapper = new ObjectMapper(new YAMLFactory());
        dockerComposeFile = mapper.readValue(new File(dockerComposePath), DockerComposeFile)
    }

    /**
     * Create the string for the serialization process
     */
    override String toString() {
        val mapper = new ObjectMapper(new YAMLFactory());
        return mapper.writeValueAsString(dockerComposeFile)
   }
}