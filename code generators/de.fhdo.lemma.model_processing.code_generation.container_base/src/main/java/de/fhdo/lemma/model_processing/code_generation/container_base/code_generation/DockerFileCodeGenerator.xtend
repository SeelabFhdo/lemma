package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.DockerFile
import java.io.File
import org.jetbrains.annotations.NotNull
import static de.fhdo.lemma.model_processing.code_generation.container_base.util.Util.*
import javax.xml.parsers.DocumentBuilderFactory
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.code_generation.container_base.ContainerBaseGenerator

/**
 * Main class of the docker file generation module of the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="dockerfile")
class DockerFileCodeGenerator extends AbstractCodeGenerationModule {
    /*
     * The buildVersion is set to support infrastructure nodes, e.g., Zuul or Eureka, that are
     * modeled without a specific version.
     */
    val content = <String, String> newHashMap

    /**
     * Main method for the creation of the docker file
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        val model = resource.contents.get(0) as IntermediateOperationModel

        // Create a dockerfile for containers
        getContainersWithContainerBaseTechnology(model).forEach[createDockerFileForContainer(it)]

        // Create dockerfile for infrastructure nodes
        getInfrastructureNodesWithContainerBaseTechnology(model).forEach[node |
            val property = node.defaultValues.findFirst[property |
                property.technologySpecificProperty.name == "imageType"]

            if (property.value.toLowerCase != "dockerhub")
                createDockerFileForInfrastructureNode(node)
        ]

        return withCharset(content, "UTF-8");
    }

    /**
     * Receive the language namespace for the intermediate operation model package.
     */
    @NotNull
    override getLanguageNamespace() {
        IntermediatePackage.eNS_URI
    }

    /**
     * This method is responsible for the creation of the Dockerfile. The creation of the Dockerfile
     * is only supported for containers deploying a single service, because from an architectural
     * point of view the deployment of more than one microservice in a container breaks the
     * principle of an independent deployment.
     */
    private def createDockerFileForContainer(IntermediateContainer container) {
        if (container.deployedServices.size > 1)
            throw new PhaseException('''Container «container»: The Container Base Generator ''' +
                "supports only one deployed microservice per container", true)

        val serviceName = container.deployedServices.get(0).qualifiedName
        val servicePath = '''«targetFolder»«File.separator»''' +
            buildPathFromQualifiedName(serviceName)

        // The creation of the Dockerfile is supported in two different ways. First, we check if the
        // Dockerfile is explicitly defined in an aspect. Otherwise, the Dockerfile is built based
        // on the name of the container's operation environment and the Maven artifact name of the
        // microservice.
        val dockerFileAspect = getFirstAspectApplication(container, "Dockerfile")
        val dockerFile = if (dockerFileAspect !== null)
            new DockerFile(dockerFileAspect.propertyValues.get(0).value)
        else if (appliesAspect(container, ContainerBaseGenerator.BUILD_MANAGEMENT_TECHNOLOGY_NAME,
            "ArtifactId")) {
            val aspect = getAspectApplications(container, "BuildManagement", "ArtifactId")
                .findFirst[getPropertyValue(it, "serviceName") == serviceName]
            new DockerFile(container.operationEnvironment.environmentName,
                getPropertyValue(aspect, "artifactId"))
        } else
            try {
                new DockerFile(container.operationEnvironment.environmentName,
                    parseArtifactIdFromMavenPom(servicePath))
            } catch (IllegalArgumentException ex) {
                throw new PhaseException("Couldn't determine artifact ID of microservice " +
                    '''"«serviceName»" deployed to container "«container.name»": «ex.message»''',
                    true)
            }

        content.put('''«servicePath»«File.separator»Dockerfile''', dockerFile.toString)
    }

    /**
     * Helper to parse the artifactId from a Maven POM in a given folder
     */
    private def parseArtifactIdFromMavenPom(String pomFolder) {
        val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val pomFile = new File('''«pomFolder»«File.separator»pom.xml''')
        if (!pomFile.exists)
            throw new IllegalArgumentException('''Maven POM file "«pomFile.absolutePath»" does ''' +
                "not exist")

        val pomXml = builder.parse(pomFile)
        val artifactIdElements = pomXml.getElementsByTagName("artifactId")
        if (artifactIdElements.length == 0)
            throw new IllegalArgumentException('''Maven POM file "«pomFile.absolutePath»" ''' +
                '''lacks mandatory "artifactId" element''')

        return artifactIdElements.item(0).textContent
    }

    /**
     * This method is responsible for generating the Dockerfile. The file is generated depending on
     * whether the infrastructure node has a DockerFileAspect or not.
     *
     * Note: if the infrastructure node does not specify a version, it is set to the value of the
     * build version constant variable
     */
    private def createDockerFileForInfrastructureNode(IntermediateInfrastructureNode node) {
        val dockerFileAspect = getFirstAspectApplication(node, "Dockerfile")
        val dockerFile = if (dockerFileAspect !== null)
            new DockerFile(dockerFileAspect.propertyValues.get(0).value)
        else
            new DockerFile(node.operationEnvironment.environmentName, node.name.toLowerCase)

        val filePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
            '''«File.separator»Dockerfile'''
        content.put(filePath, dockerFile.toString)
    }
}