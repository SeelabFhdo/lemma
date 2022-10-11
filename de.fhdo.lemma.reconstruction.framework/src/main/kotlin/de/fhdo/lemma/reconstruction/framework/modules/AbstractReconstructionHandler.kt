package de.fhdo.lemma.reconstruction.framework.modules

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.framework.plugins.ParsingResultType

abstract class AbstractReconstructionHandler {
    protected val reconstructionModules = mutableListOf<AbstractReconstructionModule>()
    val reconstructionFilesAndParseTree = mutableMapOf<String, AbstractParseTree>()

    abstract fun init()

    internal fun createParseTrees(files: List<String>) {
        files.forEach { file ->
            reconstructionModules.forEach { module ->
                createParseTree(file, module)
            }
        }
    }

    private fun createParseTree(path: String, module: AbstractReconstructionModule) {
        if (reconstructionFilesAndParseTree.containsKey(path))
            return

        if (module.getSupportFileExtensions().contains(path.asFile().extension)) {
            val (result, tree) = module.getParseTree(path)
            when (result) {
                ParsingResultType.FULLY_PARSED -> {
                    reconstructionFilesAndParseTree[path] = tree
                }
                else -> null
            }
        }
    }

    /**
     * Execute the microservice reconstruction stage
     */
    internal fun executeReconstructionStage() {
        reconstructionModules.forEach { module ->
            reconstructionFilesAndParseTree.forEach { path, tree ->
                reconstructFromPassTree(tree, module)
            }
        }
    }

    abstract fun reconstructFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule)
}