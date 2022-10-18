package de.fhdo.lemma.model_processing.code_generation.deployment_base.util

import java.io.File
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import static de.fhdo.lemma.model_processing.utils.UtilsKt.*
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
import de.fhdo.lemma.model_processing.code_generation.deployment_base.DeploymentBaseGenerator

class Util {
    /**
     * Adjust the indentations in YAML-base filed like Docker Compose or Kubernetes files
     */
    static def String adjustIndentations(String indentation, String content) {
        if (content.empty)
            return null

        val numberOfIndentations = content.split("\n").filter[line|line.length > 0]
        val spaces = numberOfIndentations.get(0).length - numberOfIndentations.get(0).trim.length
        val stringBuilder = new StringBuilder
        numberOfIndentations.forEach[line |
            if (line.length > spaces)
                stringBuilder.append(indentation + line.subSequence(spaces, line.length) + "\n")
        ]
        return stringBuilder.toString
    }

    /**
     * Return a file path segment from a fully qualified name. For instance, the fully qualified
     * name "de.fhdo.service.FooService" becomes the file path segment "de/fhdo/service/FooService"
     * under Unix-like operating systems.
     */
    static def String buildPathFromQualifiedName(String qualifiedName) {
        return qualifiedName.replace('.', File.separatorChar)
    }

    /**
     * Helper to check if an operation node applies a certain aspect
     */
    static def appliesAspect(IntermediateOperationNode node, String technologyName,
        String aspectName) {
        return node.getFirstAspectApplication(technologyName, aspectName) !== null
    }

    /**
     * Helper to get the first application of an aspect on the given operation node. This version of
     * the helper uses the name of the deployment base technology to search for the aspect.
     */
    static def getFirstAspectApplication(IntermediateOperationNode node, String aspectName) {
        return node.getFirstAspectApplication(
            DeploymentBaseGenerator.DEPLOYMENT_BASE_TECHNOLOGY_NAME,
            aspectName
        )
    }

    /**
     * Helper to get the first application of an aspect on the given operation node. This version of
     * the helper expects the name of the technology as well as the aspect to search for.
     */
    static def getFirstAspectApplication(IntermediateOperationNode node, String technologyName,
        String aspectName) {
        return node.aspects.findFirst[
            it.qualifiedName.toLowerCase == '''«technologyName.toLowerCase».''' +
                aspectName.toLowerCase
        ]
    }

    /**
     * Helper to get all applications of an aspect on the given operation node
     */
    static def getAspectApplications(IntermediateOperationNode node, String technologyName,
        String aspectName) {
        return node.aspects.filter[
            it.qualifiedName.toLowerCase == '''«technologyName.toLowerCase».''' +
                aspectName.toLowerCase
        ]
    }

    /**
     * Helper to get the value of a named aspect property
     */
    static def getPropertyValue(IntermediateImportedAspect aspect, String propertyName) {
        return aspect.propertyValues.findFirst[it.property.name == propertyName]?.value
    }

    /**
     * Helper to get all containers from a given operation model that apply the deployment base
     * technology model
     */
    static def getContainersWithDeploymentBaseTechnology(IntermediateOperationModel model) {
        return model.containers.filter[hasContainerBaseTechnology(it)]
    }

    /**
     * Helper to check if a container applies the deployment base technology model
     */
    static def hasContainerBaseTechnology(IntermediateContainer container) {
        return container.qualifiedDeploymentTechnologyName.toLowerCase.startsWith(
            '''«DeploymentBaseGenerator.DEPLOYMENT_BASE_TECHNOLOGY_NAME.toLowerCase».'''
        )
    }

    /**
     * Helper to get all infrastructure nodes from a given operation model that apply the container
     * base technology model
     */
    static def getInfrastructureNodesWithDeploymentBaseTechnology(IntermediateOperationModel model) {
        return model.infrastructureNodes.filter[hasContainerBaseTechnology(it)]
    }

    /**
     * Helper to check if an infrastructure node applies the deployment base technology model
     */
    static def hasContainerBaseTechnology(IntermediateInfrastructureNode node) {
        return node.qualifiedInfrastructureTechnologyName.toLowerCase.startsWith(
            '''«DeploymentBaseGenerator.DEPLOYMENT_BASE_TECHNOLOGY_NAME.toLowerCase».'''
        )
    }

    /**
     * Helper to extract the port information of a deployed microservice from the Application aspect
     * of the Spring technology model and its "port" property. The helper returns null in case the
     * given deployed microservice does not exhibit the aspect or the "port" property isn't set.
     */
    static def getSpringServerPort(OperationMicroserviceReference serviceReference) {
        val Pair<String, IntermediateServiceModel> modelPathAndRoot = ParsedModels
            .getOrParseImportedModelRoot(serviceReference.eResource, serviceReference.import)
        val modelPath = modelPathAndRoot.key
        val serviceModelRoot = modelPathAndRoot.value

        val service = serviceModelRoot.microservices
            .findFirst[it.qualifiedName == serviceReference.qualifiedName]
        val applicationAspect = service.aspects.findFirst[
            val technologyName = parseTechnologyName(uriToFilePath(it.import.importUri), modelPath)
            "Spring".equalsIgnoreCase(technologyName) && "Application".equalsIgnoreCase(it.name)
        ]

        return if (applicationAspect !== null)
                getPropertyValue(applicationAspect, "port")
            else
                null
    }
}