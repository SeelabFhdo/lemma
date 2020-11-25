package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Map

/**
 * This POJO represents the data structure of a docker-compose file in a yaml format.
 * It is used by the snakeyaml Framework for parsing an existing docker compose file.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DockerComposeFile {
    @Accessors
    String version
    @Accessors
    Map<String, Service> services =  newHashMap
    @Accessors
    Map<String, Network> networks =  newHashMap
}