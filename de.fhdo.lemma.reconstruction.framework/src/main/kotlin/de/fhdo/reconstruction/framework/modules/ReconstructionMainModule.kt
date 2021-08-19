package de.fhdo.reconstruction.framework.modules

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.reconstruction.framework.command_line.CommandLine
import de.fhdo.reconstruction.framework.microservice.AbstractMicroserviceReconstructionModule
import de.fhdo.reconstruction.framework.microservice.MicroserviceReconstructionModule
import de.fhdo.reconstruction.framework.microservice.ReconstructedMicroservice
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.reconstruction.framework.plugins.loadPlugins
import de.fhdo.reconstruction.framework.util.findAnnotatedClasses
import java.io.File

/**
 * Main module of the reconstruction framework. The module deals with the handling of the plugins and reconstruction
 * phases.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal object ReconstructionMainModule {
    private val plugins = loadPlugins(CommandLine.plugins())
    private val microserviceReconstructionModules = mutableListOf<AbstractMicroserviceReconstructionModule>()
    private val files = mutableListOf<String>()
    private val reconstructedMicroservices = mutableListOf<ReconstructedMicroservice>()
    private val reconstructionFilesAndParseTree = mutableMapOf<String, AbstractParseTree?>()

    /**
     * Initialize the state of the main reconstruction module
     */
    init {
        loadFiles()
        loadMicroserviceReconstructionModules()
        executeMicroserviceReconstructionForFiles()
        finishMicroserviceReconstruction()
    }

    private fun executeMicroserviceReconstructionForFiles() {
        files.forEach { file ->
            microserviceReconstructionModules.forEach { module ->
                val tree = reconstructionFilesAndParseTree[file]
                if (tree != null && module.getSupportFileExtensions().contains(tree.fileType))
                    reconstructFromPassTree(tree, module)
                else
                    reconstructFromFilePath(file, module)
            }
        }
    }

    private fun reconstructFromPassTree(tree: AbstractParseTree, module: AbstractMicroserviceReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedMicroservices.add(ReconstructedMicroservice(it))
        }
    }

    private fun reconstructFromFilePath(path: String, module: AbstractMicroserviceReconstructionModule) {
        if (module.getSupportFileExtensions().contains(path.asFile().extension)) {
            val (result, tree) = module.getParsingTree(path)
            when (result) {
                ParsingResultType.FULLY_PARSED -> {
                    reconstructionFilesAndParseTree[path] = tree
                    addMicroservice(tree, module)
                }
                ParsingResultType.PARTIALLY_PARSED -> addMicroservice(tree, module)
                ParsingResultType.NONE_PARSED -> return
            }
        }
    }

    private fun addMicroservice(tree: AbstractParseTree, module: AbstractMicroserviceReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedMicroservices.add(ReconstructedMicroservice(it))
        }
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
     * Load all file validator phases from the loaded Plugins.
     */
    private fun loadMicroserviceReconstructionModules() {
        plugins.forEach {
            val annotatedClasses = findAnnotatedClasses(
                it.key.pluginImplementationPackage,
                MicroserviceReconstructionModule::class.java.name, it.value
            )
            annotatedClasses.forEach {
                microserviceReconstructionModules.add(
                    it.loadClass(AbstractMicroserviceReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance()
                )
            }
        }
    }

    internal fun getReconstructedMicroservices(): MutableList<ReconstructedMicroservice> {
        return reconstructedMicroservices
    }

    private fun finishMicroserviceReconstruction() {

    }


}