package de.fhdo.reconstruction.framework.modules

import de.fhdo.reconstruction.framework.command_line.CommandLine
import de.fhdo.reconstruction.framework.modules.service.ReconstructionServiceHandler
import java.io.File

internal object ReconstructionMainHandler {
    private val files = mutableListOf<String>()

    init {
        loadFiles()
        executeServiceHandler()
    }

    private fun executeServiceHandler() {
        ReconstructionServiceHandler
        ReconstructionServiceHandler.executeMicroserviceReconstructionStage(files)
        ReconstructionServiceHandler.executeInterfaceReconstructionStage(files)
        ReconstructionServiceHandler.executeOperationReconstructionStage(files)
        ReconstructionServiceHandler.writeReconstructedMicroservicesToDatabase()
    }

    /**
     * Load all files from the target folder paths
     */
    private fun loadFiles() {
        CommandLine.targetFolders().forEach {
            File(it).walk().forEach {
                if (it.isFile) {
                    files.add(it.path)
                }
            }
        }
    }
}