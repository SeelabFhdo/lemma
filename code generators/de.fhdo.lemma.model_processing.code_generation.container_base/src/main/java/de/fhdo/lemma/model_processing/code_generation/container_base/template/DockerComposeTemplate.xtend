package de.fhdo.lemma.model_processing.code_generation.container_base.template

import java.util.Map
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.Service
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.Network

/**
 * Template class for generating docker-compose files.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DockerComposeTemplate {
    /**
     * Build the operation node specific docker-compose part
     */
    static def String buildDockerComposeParts(String name, Service service) '''
          «name.toLowerCase»:
        «IF service.image !== null»    image: «service.image.toLowerCase»«ENDIF»
        «IF service.build !== null»    build: «service.build.toLowerCase»«ENDIF»
        «IF service.container_name !== null»
            «""»    container_name: «service.container_name.toLowerCase»
        «ENDIF»
        «IF service.environment !== null && !service.environment.empty»
            «""»    environment:
            «FOR Map.Entry<String, String> environment : service.environment.entrySet»
                «""»      «environment.key»: «environment.value»
            «ENDFOR»
        «ENDIF»
        «IF service.restart !== null»    restart: «service.restart»«ENDIF»
        «IF !service.volumes.empty»
            «""»    volumes:
            «FOR volume : service.volumes»
                «""»        - «volume»
            «ENDFOR»
        «ENDIF»
        «IF service.ports !== null»
            «""»    ports:
            «FOR port : service.ports»
                «""»      - "«port»"
            «ENDFOR»
        «ENDIF»
        «IF !service.networks.empty»
            «""»    networks:
            «FOR network : service.networks»
                «""»      - «network»
            «ENDFOR»
        «ENDIF»
        «IF !service.links.empty»
            «""»    links:
            «FOR link : service.links»
                «""»        - «link»
            «ENDFOR»
        «ENDIF»
        «IF service.entrypoint !== null»    entrypoint: "«service.entrypoint»"«ENDIF»
        «IF service.command !== null»    command: "«service.command»"«ENDIF»
    '''

    /**
     * Creates the header for the docker-compose file.
     */
    static def getDockerComposeHeader() '''
        version: "3.7"

    '''

    /**
     * Create a docker network for the docker-compose file.
     */
    static def String buildDockerComposeNetwork(String name, Network network) '''
        «"  "»«name»:
        «"  "»  driver: «network.driver»

    '''

    /**
     * Get the header for the network configuration in the docker-compose file.
     */
    static def String getDockerComposeNetworkHeder() '''
        networks:

    '''

    /**
     * Get the header for the services configuration in the docker-compose file.
     */
    static def String getDockerComposeServiceHeander() '''
        services:

    '''
}