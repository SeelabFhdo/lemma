package de.fhdo.lemma.reconstruction.spring.web

import de.fhdo.lemma.reconstruction.spring.web.service.`interface`.InterfaceReconstruction
import de.fhdo.lemma.reconstruction.spring.web.service.microservice.MicroserviceReconstruction
import de.fhdo.lemma.reconstruction.spring.web.service.operation.OperationReconstruction
import de.fhdo.reconstruction.framework.modules.service.`interface`.Interface
import de.fhdo.reconstruction.framework.modules.service.microservice.Microservice
import de.fhdo.reconstruction.framework.modules.service.operation.Operation
import de.fhdo.reconstruction.framework.plugins.AbstractPlugin


/**
 * Main class of the reconstruction java plugin.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class WebPlugin() : AbstractPlugin("de.fhdo.lemma.reconstruction.spring.web") {
}

/**
 * Entry point of the reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstruction Spring Plugin!")
    /*
    val microserviceReconstruction = MicroserviceReconstruction()
    val microserviceTree = microserviceReconstruction.getParsingTree("/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/BookingServiceCommandApplication.java")
    val microservices = microserviceReconstruction.execute(microserviceTree.second)

    val interfaceReconstruction = InterfaceReconstruction()

    val interfaceTree = interfaceReconstruction.getParsingTree("/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/api/ParkBookingCommandApi.java")
    val interfaces = interfaceReconstruction.execute(interfaceTree.second)

    val operationReconstruction = OperationReconstruction()
    val operations = operationReconstruction.execute(interfaceTree.second)

    microservices.forEach {
        println(it.name)
    }

    interfaces.forEach {
        println(it.name)
    }

     */
}