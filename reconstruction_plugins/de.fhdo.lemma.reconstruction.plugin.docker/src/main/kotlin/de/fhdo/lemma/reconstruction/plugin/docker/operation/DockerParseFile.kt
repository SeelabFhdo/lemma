package de.fhdo.lemma.reconstruction.plugin.docker.operation

import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree

/**
 * Parse tree for Docker-Compose files
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
data class DockerParseFile (
    val path: String,
    //todo: change to a proper representation of a Docker-Compose file. c.f. container_base
    val parseFile: LinkedHashMap<String, Any>
    ) : AbstractParseTree("DockerComposeFile")