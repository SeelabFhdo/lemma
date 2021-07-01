package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Map
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This POJO represents the data structure of a docker-compose file in a yaml format used by
 * the jackson data format framework.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
 @JsonInclude(NON_EMPTY)
class DockerComposeFile {
    @Accessors
    String version
    @Accessors
    @JsonProperty("services")
    Map<String, DockerComposeService> services =  newHashMap
    @Accessors
    @JsonProperty("networks")
    Map<String, DockerComposeNetwork> networks =  newHashMap
}