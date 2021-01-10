package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import de.fhdo.lemma.model_processing.code_generation.container_base.template.DockerFileTemplate
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class is responsible for the creation of the Dockerfile for each operation node of the
 * intermediate operation model.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DockerFile {
    String fileContent
    @Accessors
    String operationEnvironment
    @Accessors
    String deployedServiceName

    /**
     * This attribute is necessary to support the creation of Dockerfiles from operation aspects.
     * Otherwise the Dockerfile is build based on the operation environment of the operation
     * node.
     */
    boolean createdByAspect

    /**
     * Standard constructor
     */
    new () {
    }

    /**
     * Constructor for creating a Dockerfile based on an operation aspect.
     */
    new(String fileContent) {
        this.fileContent = formatDockerFile(fileContent)
        createdByAspect = true
    }

    /**
     * Constructor for creating a Dockerfile based on an operation environment and deployed service
     * name.
     */
    new (String operationEnvironment, String deployedServieName) {
        this.operationEnvironment = operationEnvironment
        this.deployedServiceName = deployedServieName
    }

    /**
     * Format an existing Dockerfile. Remove unnecessary spaces and append a line break at the end
     * of each line.
     */
    private def String formatDockerFile(String fileContent){
        val stringBuilder = new StringBuilder
        fileContent.lines.forEach[line |
            stringBuilder.append('''«line.toString.trim»«"\n"»''')]

        return stringBuilder.toString.trim
    }

    /**
     * Build a Dockerfile for the operation node based on the fact, that the docker file content is
     * created directly by a deployment aspect or by the docker file code generation module itself.
     * The distinction between a Dockerfile created by an operation aspect is necessary because
     * otherwise the Dockerfile is created by based on the operation environment.
     */
    override String toString() {
        if (createdByAspect)
            fileContent.toString
        else
            DockerFileTemplate::buildDockerFile(operationEnvironment, deployedServiceName)
    }
}