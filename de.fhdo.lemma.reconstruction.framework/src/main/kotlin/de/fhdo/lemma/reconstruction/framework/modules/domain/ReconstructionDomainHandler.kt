package de.fhdo.lemma.reconstruction.framework.modules.domain

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionHandler
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.Context
import de.fhdo.lemma.reconstruction.framework.modules.domain.context.ReconstructionContextFactory
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.EnumType
import de.fhdo.lemma.reconstruction.framework.modules.service.ReconstructionServiceHandler
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.lemma.reconstruction.framework.repository.ContextRepository

internal object ReconstructionDomainHandler : AbstractReconstructionHandler() {
    private const val symbols = "[A-Za-z0-9\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+$"
    private val reconstructedContexts = mutableListOf<Context>()
    private val reconstructedDataStructures = mutableListOf<DataStructure>()
    private val reconstructedEnums = mutableListOf<EnumType>()

    /**
     * Initialize the state of the main reconstruction module
     */
    override fun init() {
        println("Init: ${ReconstructionDomainHandler.javaClass.name}")
    }

    /**
     * Execute the reconstruction for a microservice based on a parsing tree, provided by the technology specific plugin.
     */
    override fun reconstructFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        val reconstruction = module.execute(tree)
        reconstruction.forEach {
            when (it) {
                is Context -> reconstructedContexts.add(it)
                is DataStructure -> reconstructedDataStructures.add(it)
                is EnumType -> reconstructedEnums.add(it)
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
        reconstructionModules.add(module)
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