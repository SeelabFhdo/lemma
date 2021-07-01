package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import java.util.Map
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Set

/**
 * This POJO represents the data structure of a docker-compose file in a YAML format used by
 * the Jackson data format framework.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
 @JsonInclude(NON_EMPTY)
class DockerComposeService {
    @Accessors
    String build
    @Accessors
    String image
    @Accessors
    String restart
    @Accessors
    @JsonProperty("container_name")
    String containerName
    @Accessors
    Map<String, String> environment = newHashMap
    @Accessors
    List<String> ports = newLinkedList
    @Accessors
    Set<String> networks = newHashSet
    @Accessors
    @JsonProperty("depends_on")
    List<String> dependsOn = newLinkedList
    @Accessors
    List<String> links = newLinkedList
    @Accessors
    String entrypoint
    @Accessors
    String command
    @Accessors
    List<String> volumes = newLinkedList
}