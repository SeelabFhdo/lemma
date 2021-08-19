package de.fhdo.lemma.reconstruction.spring

import de.fhdo.lemma.reconstruction.spring.microservice.MicroserviceReconstruction
import de.fhdo.lemma.reconstruction.spring.parser.JavaDirExplorer
import de.fhdo.reconstruction.framework.plugins.AbstractPlugin


/**
 * Main class of the reconstruction java plugin.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class SpringPlugin() : AbstractPlugin("de.fhdo.lemma.reconstruction.spring") {
}

/**
 * Entry point of the reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstruction Spring Plugin!")

    val microserviceReconstruction = MicroserviceReconstruction()
    val tree = microserviceReconstruction.getParsingTree("/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/BookingServiceCommandApplication.java")
    val microservices = microserviceReconstruction.execute(tree.second)
    println("")
}