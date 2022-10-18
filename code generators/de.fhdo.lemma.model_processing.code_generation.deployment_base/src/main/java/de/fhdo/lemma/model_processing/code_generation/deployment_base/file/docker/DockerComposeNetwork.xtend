package de.fhdo.lemma.model_processing.code_generation.deployment_base.file.docker

import org.eclipse.xtend.lib.annotations.Accessors

import java.util.Map
import java.util.List
import com.fasterxml.jackson.annotation.JsonInclude

/**
 * This POJO represents the data structure of a docker-compose file in a yaml format used by
 * the jackson data format framework.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
 @JsonInclude(NON_EMPTY)
class DockerComposeNetwork {
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