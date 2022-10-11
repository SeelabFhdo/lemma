package de.fhdo.lemma.reconstruction.plugin.docker

import de.fhdo.lemma.reconstruction.framework.plugins.AbstractPlugin
import de.fhdo.lemma.reconstruction.plugin.docker.operation.OperationReconstruction


/**
 * Main class of the reconstruction Docker plugin.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class DockerPlugin() : AbstractPlugin("de.fhdo.lemma.reconstruction.plugin.docker")
/**
 * Entry point of the reconstruction framework
 * Normally, the plugin is controlled by the reconstruction framework, but for testing purpose it is
 * easier to do it in a standalone way.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args : Array<String>) {
    println("SoftwareArchitectureReconstruction Docker Plugin!")
    val reconstruction = OperationReconstruction()
    val parseTreeResult = reconstruction.getParseTree("/Users/phil/Entwicklung/msa-example/" +
            "LakesideMutual/docker-compose.yml")
    val reconstructionResults = reconstruction.execute(parseTreeResult.second)
    println(reconstructionResults)
}