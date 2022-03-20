package de.fhdo.lemma.model_processing.code_generation.container_base.util

import java.io.File
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.model_processing.code_generation.container_base.ContainerBaseGenerator
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel

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
     * the helper uses the name of the container base technology to search for the aspect.
     */
    static def getFirstAspectApplication(IntermediateOperationNode node, String aspectName) {
        return node.getFirstAspectApplication(ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME,
            aspectName)
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
     * Helper to get all containers from a given operation model that apply the container base
     * technology model
     */
    static def getContainersWithContainerBaseTechnology(IntermediateOperationModel model) {
        return model.containers.filter[hasContainerBaseTechnology(it)]
    }

    /**
     * Helper to check if a container applies the container base technology model
     */
    static def hasContainerBaseTechnology(IntermediateContainer container) {
        return container.qualifiedDeploymentTechnologyName.toLowerCase
            .startsWith('''«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME.toLowerCase».''')
    }

    /**
     * Helper to get all infrastructure nodes from a given operation model that apply the container
     * base technology model
     */
    static def getInfrastructureNodesWithContainerBaseTechnology(IntermediateOperationModel model) {
        return model.infrastructureNodes.filter[hasContainerBaseTechnology(it)]
    }

    /**
     * Helper to check if an infrastructure node applies the container base technology model
     */
    static def hasContainerBaseTechnology(IntermediateInfrastructureNode node) {
        return node.qualifiedInfrastructureTechnologyName.toLowerCase
            .startsWith('''«ContainerBaseGenerator.CONTAINER_BASE_TECHNOLOGY_NAME.toLowerCase».''')
    }
}