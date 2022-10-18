package de.fhdo.lemma.model_processing.code_generation.deployment_base.template

/**
 * Template class for generating Dockerfiles.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DockerFileTemplate {
    /**
     * File template for the creation of the Dockerfile by the docker file code generation module.
     */
    static def String buildDockerFile(String operationEnvironment, String deployedServiceName)
        '''
            FROM «operationEnvironment»
            ARG JAR_FILE=target/«deployedServiceName»*.jar
            COPY ${JAR_FILE} «deployedServiceName».jar
            ENTRYPOINT ["java", "-jar", "/«deployedServiceName».jar"]
        '''
}