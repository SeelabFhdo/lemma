package de.fhdo.lemma.reconstruction.plugin.spring.web

import de.fhdo.lemma.reconstruction.plugin.spring.web.service.MicroserviceReconstruction
import de.fhdo.lemma.reconstruction.plugin.spring.web.util.testString
import de.fhdo.lemma.reconstruction.plugin.spring.web.util.testStringForImports
import de.fhdo.reconstruction.framework.plugins.AbstractPlugin


/**
 * Main class of the reconstruction java plugin.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class WebPlugin() : AbstractPlugin("de.fhdo.lemma.reconstruction.plugin.spring.web") {
}

/**
 * Entry point of the reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstruction Spring Plugin!")
    testString()
    testStringForImports()
    val microserviceReconstruction = MicroserviceReconstruction()
    //val microserviceTree = microserviceReconstruction.getParseTree("/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/BookingServiceCommandApplication.java")
    val microserviceTree = microserviceReconstruction.getParseTree("/Users/phil/Entwicklung/MasterArbeit_dev/eChargeSystem/eChargeSystem/usermanagementservice/src/main/java/de/fhdo/echarge/usermanagementservice/controller/user/UserRestController.java")
    val microservices = microserviceReconstruction.execute(microserviceTree.second)
    println()
/*
    microservices.forEach {
        println(it.name)
    }

    interfaces.forEach {
        println(it.name)
    }

     */
}