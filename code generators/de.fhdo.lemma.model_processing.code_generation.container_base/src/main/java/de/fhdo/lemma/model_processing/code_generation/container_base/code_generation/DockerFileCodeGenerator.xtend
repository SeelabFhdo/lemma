package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.model_processing.code_generation.container_base.exception.DeployedServiceNumberExcpetion
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.DockerFile
import java.io.File
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util

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
    static val buildVersion = "0.0.1-SNAPSHOT"
    //The dockerBuildVersion is set to support underspecified service specification.
    static val dockerBuildVersion = "v0"
    var IntermediateOperationModel model
    val content = <String, String> newHashMap

    /**
     * Main method for the creation of the docker file
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Create a dockerfile for containers
        model.containers.forEach[container | createDockerFileForContainer(container)]

        // Create dockerfile for infrastructure nodes
        model.infrastructureNodes.forEach[node |
            val property = node.defaultValues.findFirst[property |
                property.technologySpecificProperty.name == "imageType"]

            if (property.value.toLowerCase != "dockerhub")
                createDockerFileForInfrastructureNode(node)
        ]

        return withCharset(content, "UTF-8");
    }

    /**
     * Receive the language description for the intermediate operation model package.
     */
    @NotNull
    override getLanguageDescription() {
        new LanguageDescription(IntermediatePackage.eINSTANCE)
    }

    /**
     * This method is responsible for the creation of the Dockerfile.
     * The creation of the Dockerfile is only supported for containers deploying a single service,
     * because from an architectural point of view the deployment of more than one microservice in a
     * container breaks the principle of an independent deployment.
     */
    private def createDockerFileForContainer(IntermediateContainer container) {
        if (container.deployedServices.size > 1)
            throw new DeployedServiceNumberExcpetion("The Number of deployed services in a single"
                + "container exceeds the maximum of one service per container ")

        /**
         * The creation of the Dockerfile is supported in two different ways.
         * First we check if the Dockerfile is explicitly defined in an aspect.
         * Otherwise the Dockerfile is built based on the name of the deployed microservice,
         * operation environment and exposed port, defined by the container endpoints.
         */
        val dockerFileAspect = container.aspects.findFirst[aspect |
            aspect.name.toLowerCase == "dockerfile"]

        val serviceName = Util.buildPathFromQualifiedName(
            container.deployedServices.get(0).qualifiedName
        )

        var dockerFileContent = ""

        if (dockerFileAspect !== null) {
            val dockerFile = new DockerFile(dockerFileAspect.propertyValues.get(0).value)
            dockerFileContent = dockerFile.toString
        } else {
            val dockerFile = new DockerFile
            dockerFile.deployedServiceName = container.name.toLowerCase
            val deployedServiceVersion = container.deployedServices.get(0).version

            if (deployedServiceVersion === null)
                dockerFile.version = dockerBuildVersion
                else
                    dockerFile.version = deployedServiceVersion

            dockerFile.version = deployedServiceVersion
            dockerFile.operationEnvironment = container.operationEnvironment.environmentName
            dockerFileContent = dockerFile.toString
        }

        val filePath = '''«targetFolder»«File.separator»«serviceName»«File.separator»Dockerfile'''
        content.put(filePath, dockerFileContent)
    }

    /**
     * This method is responsible for generating the Dockerfile. The file is generated depending on
     * whether the infrastructure node has a DockerFileAspect or not.
     *
     * Note: if the infrastructure node does not specify a version, it is set to the
     * value of the build version constant variable
     */
    private def createDockerFileForInfrastructureNode(IntermediateInfrastructureNode node) {
        val dockerFileAspect = node.aspects.findFirst[aspect |
            aspect.name.toLowerCase == "dockerfile"]

        val filePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»'''
            + '''«File.separator»Dockerfile'''

        if (dockerFileAspect !== null) {
            val dockerFile = new DockerFile(dockerFileAspect.propertyValues.get(0).value)
            content.put(filePath, dockerFile.toString)
        } else {
            var dockerFile = new DockerFile
            dockerFile.deployedServiceName = node.name.toLowerCase
            dockerFile.version = buildVersion
            dockerFile.operationEnvironment = node.operationEnvironment.environmentName
            content.put(filePath,dockerFile.toString)
        }
    }
}