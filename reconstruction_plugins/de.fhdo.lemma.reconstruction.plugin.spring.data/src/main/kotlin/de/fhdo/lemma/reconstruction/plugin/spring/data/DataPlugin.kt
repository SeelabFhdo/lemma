package de.fhdo.lemma.reconstruction.plugin.spring.data

import de.fhdo.lemma.reconstruction.plugin.spring.data.domain.DomainReconstruction
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractPlugin

/**
 * Main class of the reconstruction java plugin.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class DataPlugin() : AbstractPlugin("de.fhdo.lemma.reconstruction.plugin.spring.data") {
}

/**
 * Plugin test function
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstruction Spring Plugin!")
    val reconstruction = DomainReconstruction()
    //val microserviceTree = reconstruction.getParseTree("/Users/phil/Entwicklung/PuLS/PuLS_Platform/booking-service/booking_service_command/src/main/java/de/fhdo/puls/booking_service/command/domain/ParkBookingAggregate.java")
    //val microserviceTree = reconstruction.getParseTree("/Users/phil/Entwicklung/MasterArbeit_dev/eChargeSystem/eChargeSystem/usermanagementservice/src/main/java/de/fhdo/echarge/usermanagementservice/UserManagementServiceApplication.java")
    val microserviceTree = reconstruction.getParseTree("/Users/phil/Entwicklung/MasterArbeit_dev/eChargeSystem/eChargeSystem/usermanagementservice/src/main/java/de/fhdo/echarge/usermanagementservice/entity/user/User.java")
    //val microserviceTree = reconstruction.getParseTree("/Users/phil/Entwicklung/MasterArbeit_dev/eChargeSystem/eChargeSystem/usermanagementservice/src/main/java/de/fhdo/echarge/usermanagementservice/entity/user/USERTYPE.java")
    val microservices = reconstruction.execute(microserviceTree.second)


}