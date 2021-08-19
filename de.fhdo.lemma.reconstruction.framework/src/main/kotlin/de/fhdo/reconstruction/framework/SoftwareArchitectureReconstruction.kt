package de.fhdo.reconstruction.framework

import de.fhdo.reconstruction.framework.command_line.CommandLine
import de.fhdo.reconstruction.framework.modules.ReconstructionMainModule
import java.io.File

/**
 * Main class of the software architecture reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class SoftwareArchitectureReconstruction

/**
 * Entry point of the software architecture reconstruction framework
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    println("SoftwareArchitectureReconstructionFramework!")
    initializeReconstructionPlugin(args)
    executePhases()
    File(CommandLine.targetFolders().first()).walk().forEach {
        //println(it)
    }
}

/**
 * Initialize the reconstruction plugins by loading all reconstruction Plugins and creating the executed phases.
 */
internal fun initializeReconstructionPlugin(args: Array<String>) {
    CommandLine(args)
    ReconstructionMainModule
    ReconstructionMainModule.getReconstructedMicroservices().forEach {
        println(it.microservice.name)
    }
}

/**
 * Execute all reconstruction phases.
 */
internal fun executePhases() {
    //FileValidatorPhase().invoke()
    //FileParsingPhase().invoke()
}