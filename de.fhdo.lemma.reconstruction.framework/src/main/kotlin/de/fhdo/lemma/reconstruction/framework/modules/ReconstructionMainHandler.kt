package de.fhdo.lemma.reconstruction.framework.modules

import de.fhdo.lemma.reconstruction.framework.command_line.CommandLine
import de.fhdo.lemma.reconstruction.framework.modules.domain.ReconstructionDomainHandler
import de.fhdo.lemma.reconstruction.framework.modules.service.ReconstructionServiceHandler
import de.fhdo.lemma.reconstruction.framework.plugins.loadPlugins
import de.fhdo.lemma.reconstruction.framework.util.findAnnotatedClasses
import io.github.classgraph.ClassInfo
import java.io.File

internal object ReconstructionMainHandler {
    private val files = mutableListOf<String>()

    init {
        loadFiles()
        loadReconstructionModules()
        executeServiceHandler()
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

    /**
     * Load reconstruction modules
     */
    private fun loadReconstructionModules() {
        val plugins = loadPlugins(CommandLine.plugins())
        plugins.forEach {
            val annotatedClasses = findAnnotatedClasses(
                it.key.pluginImplementationPackage,
                ReconstructionModule::class.java.name, it.value
            )
            println()
            annotatedClasses.forEach { module ->
                addReconstructionModule(module)
            }
        }
    }

    private fun addReconstructionModule(module: ClassInfo) {
        val stage = ReconstructionStage.valueOf(module.getAnnotationInfo(ReconstructionModule::class.java.name)
            .parameterValues.getValue("stage").toString().substringAfterLast("."))
        when (stage) {
            ReconstructionStage.Domain -> {
                ReconstructionDomainHandler.addDomainReconstructionModule(
                    module.loadClass(AbstractReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance())
            }

            ReconstructionStage.Service -> {
                ReconstructionServiceHandler.addServiceReconstructionModule(
                    module.loadClass(AbstractReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance())
            }
            ReconstructionStage.Operation -> {

            }
        }
    }

    private fun executeServiceHandler() {
        // Start domain reconstruction stage
        ReconstructionDomainHandler
        ReconstructionDomainHandler.createParseTrees(files)
        ReconstructionDomainHandler.executeDomainReconstructionStage()

        // Start service reconstruction stage
        ReconstructionServiceHandler
        ReconstructionServiceHandler.createParseTrees(files)
        ReconstructionServiceHandler.executeServiceReconstructionStage()

        // Finish reconstruction stages in the order domain, service and operation
        ReconstructionDomainHandler.finishDomainReconstructionStage()
        ReconstructionServiceHandler.finishServiceReconstructionStage()

        // Test methods
        ReconstructionDomainHandler.stop()
        ReconstructionServiceHandler.stop()


        // Write reconstructed elements to the database
        ReconstructionDomainHandler.writeReconstructedContextToDatabase()
        ReconstructionServiceHandler.writeReconstructedMicroservicesToDatabase()


    }
}