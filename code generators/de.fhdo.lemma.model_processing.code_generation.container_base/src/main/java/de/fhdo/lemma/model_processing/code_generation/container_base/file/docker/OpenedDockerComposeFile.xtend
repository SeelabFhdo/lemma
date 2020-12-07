package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import org.yaml.snakeyaml.representer.Representer
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util
import de.fhdo.lemma.model_processing.code_generation.container_base.template.DockerComposeTemplate
import de.fhdo.lemma.utils.LemmaUtils

/**
 * This class uses the singleton design pattern handling the generation of the docker-compose file.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OpenedDockerComposeFile {
    static OpenedDockerComposeFile instance
    String dockerComposePath
    val dockerComposeServiceParts = <String, String> newHashMap
    val dockerComposeNetworkParts = <String> newLinkedList
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

        dockerComposePath = '''«targetFolder»«File.separator»docker-compose.yml'''
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
            createDefaultNetwork
    }

    /**
     * Add or replace a docker-compose part to the docker-compose file based on the name of the
     * operation node.The configuration of the docker-compose part is created by an intermediate
     * deployment aspect.
     */
    def addOrReplaceDockerComposePart(String name, String dockerComposeServicePart) {
        val adjustedDockerPart = Util::adjustIndentations("  ", dockerComposeServicePart) + "\n"
        addOrReplace(name, adjustedDockerPart)
    }

    /**
     * Add or replace a docker-compose part to the docker-compose file based on the name of the
     * operation node. The configuration of the docker-compose part is created by the docker-compose
     * code generation module itself.
     *
     * Note: the docker-compose part is done separately for intermediate container and intermediate
     * infrastructure nodes.
     */
    def addOrReplaceDockerComposePart(IntermediateOperationNode node) {
        switch (node) {
            IntermediateInfrastructureNode : {
                val serv = '''«getServiceFromNode(node)»«"\n"»'''
                addOrReplace(node.name, serv)
            }
            IntermediateContainer: {
                val serv = '''«getServiceFromContainer(node)»«"\n"»'''
                addOrReplace(node.name, serv)
            }
            default : throw new IllegalArgumentException("OperationNode instance not supported.")
        }
    }

    /**
     * Create a default network for the docker compose file. This is needed because LEMMA's
     * operation modeling language does not support network configurations at the moment.
     */
    private def createDefaultNetwork() {
        val network = new Network
        network.driver = "bridge"
        dockerComposeNetworkParts.add(
            DockerComposeTemplate::buildDockerComposeNetwork("default-network", network)
        )
    }

    /**
     * Add or replace the docker-compose parts based the the name of the intermediate operation
     * node.
     */
    private def addOrReplace(String name, String dockerComposeServicePart) {
        dockerComposeServiceParts.put(name.toLowerCase, dockerComposeServicePart)
    }

    /**
     * Create a POJO Service from  a container
     */
    private def String getServiceFromContainer(IntermediateContainer container) {
        val service = getBasicServiceFromOperationNode(container)

        service.build = Util.buildPathFromQualifiedName(
            container.deployedServices.get(0).qualifiedName
        )

        return DockerComposeTemplate::buildDockerComposeParts(container.name, service)
    }

    /**
     * Create a POJO Service from a infrastructure node
     */
    private def String getServiceFromNode(IntermediateInfrastructureNode node) {
        val service = getBasicServiceFromOperationNode(node)
        val imageType = node.defaultValues.findFirst[p |
            p.technologySpecificProperty.name.toLowerCase == "imagetype" &&
            p.value.toLowerCase == "springcomponent"
        ]

        if (imageType !== null)
            service.build = node.name + File.separator

        node.dependsOnNodes.forEach[depentOnNode |
            service.depends_on.add(depentOnNode.name)]

        val stringBuilder = new StringBuilder
        stringBuilder.append(DockerComposeTemplate::buildDockerComposeParts(node.name, service))

        return stringBuilder.toString
    }

    /**
     * Create basic service POJO
     */
    private def Service getBasicServiceFromOperationNode(IntermediateOperationNode node) {
        val service = new Service
        service.image = node.name
        service.container_name = node.name

        node.endpoints.forEach[endpoint |
            endpoint.addresses.forEach[address |
                val port = LemmaUtils.getPortFromAddress(address)
                service.ports.add(port + ':' + port)
            ]
        ]

        dockerComposeNetworkParts.forEach[networkPart |
            service.networks.add(getNetworkName(networkPart))]

        return service
    }

    /**
     * Get the name for the network in the docker-compose file
     */
    private def String getNetworkName(String networkName) {
        return networkName.lines.toArray.get(0)?.toString.replace(":", "").trim ?: ""
    }

    /**
     * Load a existing docker-compose file from the target folder
     */
    private def loadDockerComposePartsFromFile() {
        val stringBuilder = new StringBuilder

        val stream = Files.lines(Paths.get(dockerComposePath), StandardCharsets.UTF_8)
        stream.forEach[line | stringBuilder.append(line).append("\n")]

        val representer = new Representer
        representer.getPropertyUtils.skipMissingProperties = true

        val yaml = new Yaml(new Constructor(DockerComposeFile),representer)
        parse(yaml.loadAs(stringBuilder.toString, DockerComposeFile))
    }

    /**
     * Extract the Service and Network information out of a docker-compose file
     */
    private def parse(DockerComposeFile file) {
        file.services.forEach[name, service |
            val part = '''«DockerComposeTemplate::buildDockerComposeParts(name, service)»«"\n"»'''
            dockerComposeServiceParts.put(name.toLowerCase, part)
        ]

        if (file.networks.empty)
            createDefaultNetwork
        else {
            file.networks.forEach[name, network |
                val networkPart = DockerComposeTemplate::buildDockerComposeNetwork(name, network)
                dockerComposeNetworkParts.add(networkPart)
            ]
        }
    }

    /**
     * Create the string for the serialization process
     */
   override String toString() {
       val stringBuilder = new StringBuilder
       stringBuilder.append(DockerComposeTemplate::dockerComposeHeader)
       stringBuilder.append(DockerComposeTemplate::dockerComposeNetworkHeder)
       dockerComposeNetworkParts.forEach[network | stringBuilder.append(network)]
       stringBuilder.append(DockerComposeTemplate::dockerComposeServiceHeander)
       dockerComposeServiceParts.values.forEach[part| stringBuilder.append(part)]
       return stringBuilder.toString
   }
}