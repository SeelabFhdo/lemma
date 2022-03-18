package de.fhdo.reconstruction.framework

import de.fhdo.reconstruction.framework.command_line.CommandLine
import de.fhdo.reconstruction.framework.modules.ReconstructionMainHandler
import de.fhdo.reconstruction.framework.util.compareFullQualifiedNames

/**
 * Main class of the software architecture reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */

/**
 * Entry point of the software architecture reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstructionFramework!")
    initializeReconstructionPlugin(args)
}

/**
 * Initialize the reconstruction plugins by loading all reconstruction Plugins and creating the executed phases.
 */
internal fun initializeReconstructionPlugin(args: Array<String>) {
    CommandLine(args)
    ReconstructionMainHandler
    testCompare()
}

internal fun testCompare() {
    val test = compareFullQualifiedNames("de.fhdo.puls.booking_service.command.api.ParkBookingCommandApi", "de.fhdo.puls.booking_service.query.BookingServiceQueryApplication", ".", 2)
}