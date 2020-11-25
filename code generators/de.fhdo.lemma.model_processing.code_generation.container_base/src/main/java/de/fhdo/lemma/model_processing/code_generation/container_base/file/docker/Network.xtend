package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import org.eclipse.xtend.lib.annotations.Accessors

import java.util.Map
import java.util.List

/**
 * This POJO represents the data structure of a network in a docker-compose
 * file in yaml format. It is used by the snakeyaml framework for parsing an existing docker
 * compose file.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Network {
    @Accessors
    String driver;

    /*
     * This specific structure of the network configuration is necessary to support all given
     * configuration options for docker-compose networks.
     * (https://docs.docker.com/compose/networking/)
     */
    @Accessors
    Map <String, List<Map<String, String>>> configuration =  newHashMap
}