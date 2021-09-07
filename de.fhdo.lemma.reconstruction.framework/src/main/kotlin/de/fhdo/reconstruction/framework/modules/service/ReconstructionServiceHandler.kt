package de.fhdo.reconstruction.framework.modules.service

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.reconstruction.framework.command_line.CommandLine
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.reconstruction.framework.modules.service.`interface`.Interface
import de.fhdo.reconstruction.framework.modules.service.`interface`.InterfaceWithOperations
import de.fhdo.reconstruction.framework.modules.service.`interface`.getReconstructedInterfaceFromInterface
import de.fhdo.reconstruction.framework.modules.service.microservice.Microservice
import de.fhdo.reconstruction.framework.modules.service.microservice.ReconstructedMicroservice
import de.fhdo.reconstruction.framework.modules.service.microservice.getReconstructedMicroserviceFromMicroservice
import de.fhdo.reconstruction.framework.modules.service.operation.Operation
import de.fhdo.reconstruction.framework.modules.service.operation.getReconstructedOperationFromOperation
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.reconstruction.framework.plugins.loadPlugins
import de.fhdo.reconstruction.framework.repository.MicroserviceRepository
import de.fhdo.reconstruction.framework.util.findAnnotatedClasses
import io.github.classgraph.ClassInfo
import java.io.File

/**
 * Main module of the reconstruction framework. The module deals with the handling of the plugins and reconstruction
 * phases.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal object ReconstructionServiceHandler {
    private val microserviceReconstructionModules = mutableListOf<AbstractReconstructionModule>()
    private val interfaceReconstructionModules = mutableListOf<AbstractReconstructionModule>()
    private val operationReconstructionModules = mutableListOf<AbstractReconstructionModule>()
    val reconstructedMicroservices = mutableListOf<ReconstructedMicroservice>()
    val reconstructedInterfaces = mutableListOf<InterfaceWithOperations>()
    private val reconstructedOperations = mutableListOf<Operation>()
    private val reconstructionFilesAndParseTree = mutableMapOf<String, AbstractParseTree?>()
    private val plugins = loadPlugins(CommandLine.plugins())

    /**
     * Initialize the state of the main reconstruction module
     */
    init {
        loadReconstructionModules()
    }

    /**
     * Execute the microservice reconstruction stage
     */
    internal fun executeMicroserviceReconstructionStage(files: List<String>) {
        // Execute reconstruction for microservices
        executeMicroserviceReconstructionForFiles(files)
    }

    /**
     * Execute the interface reconstruction stage
     */
    internal fun executeInterfaceReconstructionStage(files: List<String>) {
        // Execute reconstruction for interfaces
        executeInterfaceReconstructionForFiles(files)
        assignInterfacesToMicroservice()
    }

    /**
     * Execute the operation reconstruction stage
     */
    internal fun executeOperationReconstructionStage(files: List<String>) {
        executeOperationReconstructionForFiles(files)
        assignOperationToInterfaces()
        println()
    }

    /**
    * Execute the reconstruction for all files in the included target for microservices.
    */
    private fun executeMicroserviceReconstructionForFiles(files: List<String>) {
        files.forEach { file ->
            microserviceReconstructionModules.forEach { module ->
                val tree = reconstructionFilesAndParseTree[file]
                if (tree != null && module.getSupportFileExtensions().contains(tree.fileType))
                    reconstructMicroserviceFromPassTree(tree, module)
                else
                    reconstructMicroserviceFromFilePath(file, module)
            }
        }
    }

    /**
    * Execute the reconstruction for a microservice based on a parsing tree, provided by the technology specific plugin.
    */
    private fun reconstructMicroserviceFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedMicroservices.add(getReconstructedMicroserviceFromMicroservice(it as Microservice))
        }
    }

    /**
     * Execute the reconstruction for a microservice based on a parsing tree, provided by the technology specific plugin.
     */
    private fun reconstructOperationFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedOperations.add(it as Operation)
        }
    }

    /**
     * Execute the reconstruction for all files in the included target folder for interfaces.
     */
    private fun executeInterfaceReconstructionForFiles(files: List<String>) {
        files.forEach { file ->
            interfaceReconstructionModules.forEach { module ->
                val tree = reconstructionFilesAndParseTree[file]
                if (tree != null && module.getSupportFileExtensions().contains(tree.fileType))
                    reconstructInterfaceFromPassTree(tree, module)
                else {
                    reconstructInterfaceFromFilePath(file, module)
                }
            }
        }
    }

    /**
     * Execute the reconstruction for an interface based on a parsing tree, provided by the technology specific plugin.
     */
    private fun reconstructInterfaceFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedInterfaces.add(InterfaceWithOperations(mutableListOf(), it as Interface))
        }
    }

    /**
    *  Execute the reconstruction based on a file, provided by the technology specific plugin.
    */
    private fun reconstructMicroserviceFromFilePath(path: String, module: AbstractReconstructionModule) {
        if (module.getSupportFileExtensions().contains(path.asFile().extension)) {
            val (result, tree) = module.getParseTree(path)
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

    /**
     * Execute the reconstruction for all files in the included target folder for operations.
     */
    private fun executeOperationReconstructionForFiles(files: List<String>) {
        files.forEach { file ->
            operationReconstructionModules.forEach { module ->
                val tree = reconstructionFilesAndParseTree[file]
                if (tree != null && module.getSupportFileExtensions().contains(tree.fileType))
                    reconstructOperationFromPassTree(tree, module)
                else {
                    reconstructOperationFromFilePath(file, module)
                }
            }
        }
    }

    /**
     *  Execute the reconstruction based on a file, provided by the technology specific plugin.
     */
    private fun reconstructInterfaceFromFilePath(path: String, module: AbstractReconstructionModule) {
        if (module.getSupportFileExtensions().contains(path.asFile().extension)) {
            val (result, tree) =  module.getParseTree(path)
            when (result) {
                ParsingResultType.FULLY_PARSED -> {
                    reconstructionFilesAndParseTree[path] = tree
                    addInterface(tree, module)
                }
                ParsingResultType.PARTIALLY_PARSED -> addInterface(tree, module)
                ParsingResultType.NONE_PARSED -> return
            }
        }
    }

    /**
     *  Execute the reconstruction based on a file, provided by the technology specific plugin.
     */
    private fun reconstructOperationFromFilePath(path: String, module: AbstractReconstructionModule) {
        if (module.getSupportFileExtensions().contains(path.asFile().extension)) {
            val (result, tree) =  module.getParseTree(path)
            when (result) {
                ParsingResultType.FULLY_PARSED -> {
                    reconstructionFilesAndParseTree[path] = tree
                    addInterface(tree, module)
                }
                ParsingResultType.PARTIALLY_PARSED -> addInterface(tree, module)
                ParsingResultType.NONE_PARSED -> return
            }
        }
    }

    /**
    * Add the microservice reconstructed microservice by a plugin to the main reconstruction context.
    */
    private fun addMicroservice(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedMicroservices.add(getReconstructedMicroserviceFromMicroservice(it as Microservice))
        }
    }

    /**
     * Add the microservice reconstructed microservice by a plugin to the main reconstruction context.
     */
    private fun addInterface(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedInterfaces.add(InterfaceWithOperations(mutableListOf(), it as Interface))
        }
    }

    /**
     * Add the microservice reconstructed microservice by a plugin to the main reconstruction context.
     */
    private fun addOperation(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        module.execute(tree).forEach {
            reconstructedOperations.add(it as Operation)
        }
    }

    /**
     * Load reconstruction modules
     */
    private fun loadReconstructionModules() {
        plugins.forEach {
            val annotatedClasses = findAnnotatedClasses(
                it.key.pluginImplementationPackage,
                ReconstructionModule::class.java.name, it.value
            )
            annotatedClasses.forEach { module ->
                addReconstructionModule(module)
            }
        }
    }

    private fun addReconstructionModule(module: ClassInfo) {
        val stage = ReconstructionStage.valueOf(module.getAnnotationInfo(ReconstructionModule::class.java.name)
            .parameterValues.getValue("stage").toString().substringAfterLast("."))
        when (stage) {
            ReconstructionStage.Microservice -> {
                microserviceReconstructionModules.add(
                    module.loadClass(AbstractReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance())
            }
            ReconstructionStage.Interface -> {
                interfaceReconstructionModules.add(
                    module.loadClass(AbstractReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance()
                )
            }
            ReconstructionStage.Operation -> {
                operationReconstructionModules.add(
                    module.loadClass(AbstractReconstructionModule::class.java)
                        .getDeclaredConstructor().newInstance()
                )
            }
        }
    }

    internal fun writeReconstructedMicroservicesToDatabase() {
        reconstructedMicroservices.forEach {
            MicroserviceRepository.saveMicroservice(it)
        }
    }

    private fun assignInterfacesToMicroservice() {
        reconstructedInterfaces.forEach {
            assignToMatchingMicroservice(it)
        }
    }

    private fun assignToMatchingMicroservice(interFace: InterfaceWithOperations) {
        reconstructedMicroservices.find {
            it.fullyQualifiedName == interFace.interFace.microserviceName
        }?.microservice?.interfaces?.add(getReconstructedInterfaceFromInterface(interFace))
    }

    private fun assignOperationToInterfaces() {
        reconstructedOperations.forEach {
            assignToMatchingInterface(it)
        }
    }
    private fun assignToMatchingInterface(operation: Operation) {
        reconstructedInterfaces.find {
            it.interFace.name == operation.interfaceName
        }?.operations?.add(getReconstructedOperationFromOperation(operation))
    }
}