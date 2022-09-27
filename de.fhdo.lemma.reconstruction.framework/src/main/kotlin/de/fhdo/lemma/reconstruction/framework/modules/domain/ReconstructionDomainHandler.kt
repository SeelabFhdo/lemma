package de.fhdo.lemma.reconstruction.framework.modules.domain

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.Context
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.ReconstructionContextFactory
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.EnumType
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.lemma.reconstruction.framework.repository.ContextRepository

internal object ReconstructionDomainHandler {
    private const val symbols = "[A-Za-z0-9\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+$"
    private val domainReconstructionModules = mutableListOf<AbstractReconstructionModule>()
    private val reconstructedContexts = mutableListOf<Context>()
    private val reconstructedDataStructures = mutableListOf<DataStructure>()
    private val reconstructedEnums = mutableListOf<EnumType>()
    internal val reconstructionFilesAndParseTree = mutableMapOf<String, AbstractParseTree>()
    /**
     * Initialize the state of the main reconstruction module
     */
    init {

    }

    internal fun createParseTrees(files: List<String>) {
        files.forEach { file ->
            domainReconstructionModules.forEach { module ->
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

    internal fun executeDomainReconstructionStage() {
        domainReconstructionModules.forEach { module ->
            reconstructionFilesAndParseTree.forEach { path, tree ->
                reconstructDomainDataFromPassTree(tree, module)
            }
        }
        println()
    }

    /**
     * Execute the reconstruction for a microservice based on a parsing tree, provided by the technology specific plugin.
     */
    private fun reconstructDomainDataFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        val reconstruction = module.execute(tree)
        reconstruction.forEach {
            when (it) {
                is Context -> addContext(it)
                is DataStructure -> addDataStructure(it)
                is EnumType -> addEnumType(it)
            }
        }
    }

    private fun addContext(context: Context) {
        reconstructedContexts.add(context)
    }

    private fun addDataStructure(dataStructure: DataStructure) {
        reconstructedDataStructures.add(dataStructure)
    }

    private fun addEnumType(enumType: EnumType) {
        reconstructedEnums.add(enumType)
    }


    internal fun finishDomainReconstructionStage() {
        assignDataStructureToContext()
        assignEnumsToContext()
    }

    /**
     * Assign entity to context
     */
    private fun assignDataStructureToContext() {
        reconstructedDataStructures.forEach { dataStructure ->
            reconstructedContexts.find { context ->
                context.qualifiedName == dataStructure.qualifiedContextName
            }?.dataStructures?.add(dataStructure)
        }
    }

    private fun assignEnumsToContext() {
        reconstructedEnums.forEach { enum ->
            reconstructedContexts.find { context ->
                context.qualifiedName == enum.qualifiedContextName
            }?.enums?.add(enum)
        }
    }

    /**
     * Write reconstructed context to database
     */
    internal fun writeReconstructedContextToDatabase() {
        reconstructedContexts.forEach {
            ContextRepository.saveContext(it)
        }
    }

    internal fun addDomainReconstructionModule(module: AbstractReconstructionModule) {
        domainReconstructionModules.add(module)
    }

    internal fun stop() {
        println()
    }

    internal fun getReconstructedContexts() = reconstructedContexts

    internal fun addDataStructureDependency(dataStructure: DataStructure) {
        val existingDataStructure = reconstructedDataStructures.find {
            it.name == dataStructure.name &&
                it.qualifiedContextName == dataStructure.qualifiedContextName
        }

        /**
         * Check if context and data structure exists
         */
        if (existingDataStructure != null) {
            return
        }

        /**
         * Check if context exists and data structure is missing
         */
        val context = reconstructedContexts.find {
            it.qualifiedName == dataStructure.qualifiedContextName
        }

        if (context == null) {
            val contextName = dataStructure.qualifiedContextName.substringAfterLast(symbols)
            val newContext
                = ReconstructionContextFactory().createContext(dataStructure.qualifiedContextName, contextName)
            reconstructedContexts.add(newContext)
            reconstructedDataStructures.add(dataStructure)
            return
        } else {
            reconstructedDataStructures.add(dataStructure)
            return
        }
    }
}

fun getDomainReconstructionFilesAndParseTrees(): Map<String, AbstractParseTree> {
    return ReconstructionDomainHandler.reconstructionFilesAndParseTree
}