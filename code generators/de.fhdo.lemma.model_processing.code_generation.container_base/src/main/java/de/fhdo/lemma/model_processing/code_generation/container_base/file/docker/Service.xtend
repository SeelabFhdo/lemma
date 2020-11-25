package de.fhdo.lemma.model_processing.code_generation.container_base.file.docker

import java.util.Map
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This POJO represents the data structure of a service in a docker-compose
 * file in yaml format. It is used by the snakeyaml framework for parsing an existing docker
 * compose file.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Service {
    @Accessors
    String build
    @Accessors
    String image
    @Accessors
    String restart
    /*
     * The container_name attribute uses underscores to suite the docker-compose service type
     * naming conventions, to support serialization of existing docker-compose.yml files from the
     * file system.
     */
    @Accessors
    String container_name
    @Accessors
    Map<String, String> environment = newHashMap
    @Accessors
    List<String> ports = newLinkedList
    @Accessors
    List<String> networks = newLinkedList
    /*
     * The depends_on attribute uses underscores to suite the docker-compose service type
     * naming conventions, to support serialization of existing docker-compose.yml files from the
     * file system.
     */
    @Accessors
    List<String> depends_on = newLinkedList
    @Accessors
    List<String> links = newLinkedList
    @Accessors
    String entrypoint
    @Accessors
    String command
    @Accessors
    List<String> volumes = newLinkedList
}