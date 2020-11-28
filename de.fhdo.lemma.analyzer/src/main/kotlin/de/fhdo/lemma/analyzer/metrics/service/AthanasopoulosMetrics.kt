package de.fhdo.lemma.analyzer.metrics.service

import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemItemItem
import de.fhdo.lemma.analyzer.itemItemItemItem
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lastFolderAndFilename
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.AthanasopoulosMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos.InterfaceLevelGraph
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos.SimilarityEdge
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.simpleName
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.resource.Resource
import java.io.File

typealias CohesionGraphCalculator
    = (iface: IntermediateInterface, communicationType: CommunicationType) -> InterfaceLevelGraph

private const val VALUE_STORE_PREFIX = "athanasopoulosMetrics"

/**
 * Intermediate model validator, which implements the analysis for the metrics suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class AthanasopoulosMetrics : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "service-metrics-athanasopoulos"
        const val CLI_OPTION_VERBOSE = "verbose"
        const val CLI_OPTION_GRAPHS_TARGET_PATH = "write-graphs-to"
        const val CLI_OPTION_WRITE_OPERATION_LEVEL_GRAPHS = "include-operation-level-graphs"
    }

    private lateinit var analyzer: AthanasopoulosMetricsAnalyzerI
    private var verboseMode = false
    private var graphsTargetPath : String? = null
    private var writeOperationLevelGraphs = false

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Athanasopoulos Service Metrics", MODULE_CLI_OPTION_NAME,
        setOf(CLI_OPTION_VERBOSE, CLI_OPTION_GRAPHS_TARGET_PATH, CLI_OPTION_WRITE_OPERATION_LEVEL_GRAPHS))

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_METRICS_ATHANASOPOULOS.createAnalyzer() as AthanasopoulosMetricsAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        verboseMode = CLI_OPTION_VERBOSE in args
        graphsTargetPath = args[CLI_OPTION_GRAPHS_TARGET_PATH]
        writeOperationLevelGraphs = CLI_OPTION_WRITE_OPERATION_LEVEL_GRAPHS in args

        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        calculateMetrics()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Athanasopoulos et al. Metrics Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Calculate the metrics of the suite
     */
    private fun calculateMetrics() {
        loadedModelsWithPath.forEachInterface(
            { path, _ -> subsection("Metrics for model \"${path.asFile().lastFolderAndFilename()}\"") },
            { microservice -> item("microservice ${microservice.name}") },
        ) { iface, identifier ->
            itemItem("interface ${iface.name}")
            conversationLevelCohesionLack(iface, identifier)
            domainLevelCohesionLack(iface, identifier)
            messageLevelCohesionLack(iface, identifier)
        }
    }

    /**
     * Helper to iterate over each [IntermediateInterface] in the intermediate service models of this [Map] of
     * intermediate service model paths to [IntermediateServiceModel] instances. The lambdas realize callbacks for
     * different stages of the iteration. Specifically, they signal the beginning of the iteration over the next
     * intermediate service model ([nextModel]), microservice ([nextMicroservice]), and interface ([nextInterface]).
     */
    private fun Map<String, IntermediateServiceModel>.forEachInterface(
        nextModel: (String, IntermediateServiceModel) -> Unit,
        nextMicroservice: (IntermediateMicroservice) -> Unit,
        nextInterface: (IntermediateInterface, String) -> Unit,
    ) {
        forEach { (path, model) ->
            nextModel(path, model)
            model.microservices.forEach { microservice ->
                nextMicroservice(microservice)
                val microserviceIdentifier = microservice.simpleName()
                microservice.interfaces.forEach { iface ->
                    val interfaceIdentifier = "$microserviceIdentifier${iface.name.capitalize()}"
                    nextInterface(iface, interfaceIdentifier)
                }
            }
        }
    }

    /**
     * Handle the calculation of the conversation-level cohesion lack metric
     */
    private fun conversationLevelCohesionLack(iface: IntermediateInterface, interfaceIdentifier: String) {
        iface.communicationTypeCohesionLack(
            analyzer::calculateConversationLevelCohesionLack,
            "Conversation-Level Cohesion Lack",
            interfaceIdentifier,
            "ConversationLevelCohesionLack"
        )
    }

    /**
     * Generic helper to calculate a cohesion lack metric for this [IntermediateInterface] and different
     * [CommunicationType]s. The [cohesionGraphCalculator] lambda points to the method of the [analyzer] to use for
     * calculating the [InterfaceLevelGraph]s.
     */
    private fun IntermediateInterface.communicationTypeCohesionLack(
        cohesionGraphCalculator: CohesionGraphCalculator,
        heading: String,
        interfaceIdentifier: String,
        valueStoreSuffix: String
    ) {
        // Calculate the interface-level graphs
        val syncGraph = cohesionGraphCalculator(this, CommunicationType.SYNCHRONOUS)
        val syncCohesionLack = syncGraph.cohesionLack()
        val asyncGraph = cohesionGraphCalculator(this, CommunicationType.ASYNCHRONOUS)
        val asyncCohesionLack = asyncGraph.cohesionLack()

        // Print and store synchronous metric values
        itemItemItem(heading)
        itemItemItemItem("Synchronous: $syncCohesionLack")
        ValueStore["$VALUE_STORE_PREFIX$valueStoreSuffix"] = syncCohesionLack to
            listOf("Synchronous", interfaceIdentifier)
        syncGraph.printAndStoreSimilarityEdges(interfaceIdentifier, valueStoreSuffix)

        // Print and store asynchronous metric values
        itemItemItemItem("Asynchronous: $asyncCohesionLack")
        ValueStore["$VALUE_STORE_PREFIX$valueStoreSuffix"] = asyncCohesionLack to
            listOf("Asynchronous", interfaceIdentifier)
        asyncGraph.printAndStoreSimilarityEdges(interfaceIdentifier, valueStoreSuffix)

        // Write the interface-level graphs to the filesystem if required
        syncGraph.write("${valueStoreSuffix}Synchronous")
        asyncGraph.write("${valueStoreSuffix}Asynchronous")
    }

    /**
     * Write this [InterfaceLevelGraph] to the [graphsTargetPath] of the local filesystem (if given by the user). The
     * files will be in GraphViz's DOT format and named after the [filenamePrefix] with the ".dot" extension. In case
     * folders in the [graphsTargetPath] do not exist, the method will create them.
     */
    private fun InterfaceLevelGraph.write(filenamePrefix: String) {
        if (graphsTargetPath == null)
            return

        val graphPath = listOf(graphsTargetPath!!, iface.microservice.name, iface.name).joinToString(File.separator)
        graphPath.asFile().mkdirs()

        val filePath = "$graphPath${File.separator}$filenamePrefix.dot"
        filePath.asFile().writeText(toString())

        // Write operation-level graphs if requested by the user
        if (writeOperationLevelGraphs)
            writeOperationLevelGraphs(graphPath, filenamePrefix)
    }

    /**
     * Write the operation-level graphs of this [InterfaceLevelGraph] to the [targetPath] of the local filesystem. The
     * files will be in GraphViz's DOT format, and named after the [filenamePrefix] suffixed by a consecutive number
     * and the ".dot" extension. In case folders in the [targetPath] do not exist, the method will create them.
     */
    private fun InterfaceLevelGraph.writeOperationLevelGraphs(targetPath: String, filenamePrefix: String)
        = operationLevelGraphs.forEach { (operation, graphs) ->
            val graphPath = "$targetPath${File.separator}${operation.name}"
            graphPath.asFile().mkdirs()

            var filenameIndex = 1
            graphs.forEach {
                val filePath = "$graphPath${File.separator}$filenamePrefix$filenameIndex.dot"
                filePath.asFile().writeText(it.toString())
                filenameIndex++
            }
        }

    /**
     * Print and store the similarity edges of this [InterfaceLevelGraph]
     */
    private fun InterfaceLevelGraph.printAndStoreSimilarityEdges(interfaceIdentifier: String, valueStoreSuffix: String,
        printLevel: Int = 5) {
        similarityEdgesWithMaxWeights().printAndStoreSimilarityEdges("Greatest", interfaceIdentifier, valueStoreSuffix,
            printLevel)
        similarityEdgesWithMinWeights().printAndStoreSimilarityEdges("Lowest", interfaceIdentifier, valueStoreSuffix,
            printLevel)
    }

    /**
     * Print and store the [SimilarityEdge]s in this list. Printing will only happen in [verboseMode], while storage
     * will always occur.
     */
    private fun List<SimilarityEdge>.printAndStoreSimilarityEdges(prefix: String, interfaceIdentifier: String,
        valueStoreSuffix: String, printLevel: Int) {
        forEach { (op1, op2, similarity) ->
            if (verboseMode)
                println(
                    itemText("$prefix similarity between ${op1.name} and ${op2.name}: $similarity", level = printLevel)
                )

            ValueStore["$VALUE_STORE_PREFIX$valueStoreSuffix"] = similarity to
                listOf("${prefix}Similarity", interfaceIdentifier)
            ValueStore["$VALUE_STORE_PREFIX$valueStoreSuffix"] = op1.name to
                listOf("${prefix}SimilarityOp1", interfaceIdentifier)
            ValueStore["$VALUE_STORE_PREFIX$valueStoreSuffix"] = op2.name to
                listOf("${prefix}SimilarityOp2", interfaceIdentifier)
        }
    }

    /**
     * Handle the calculation of the message-level cohesion lack metric
     */
    private fun messageLevelCohesionLack(iface: IntermediateInterface, interfaceIdentifier: String) {
        iface.communicationTypeCohesionLack(
            analyzer::calculateMessageLevelCohesionLack,
            "Message-Level Cohesion Lack",
            interfaceIdentifier,
            "MessageLevelCohesionLack"
        )
    }

    /**
     * Handle the calculation of the domain-level cohesion lack metric
     */
    private fun domainLevelCohesionLack(iface: IntermediateInterface, interfaceIdentifier: String) {
        val graph = analyzer.calculateDomainLevelCohesionLack(iface)
        val cohesionLack = graph.cohesionLack()
        val valueStoreSuffix = "DomainLevelCohesionLack"

        itemItemItem("Domain-Level Cohesion Lack: ${graph.cohesionLack()}")
        ValueStore["${VALUE_STORE_PREFIX}$valueStoreSuffix"] = cohesionLack to listOf(interfaceIdentifier)

        graph.printAndStoreSimilarityEdges(interfaceIdentifier, valueStoreSuffix)
        graph.write(valueStoreSuffix)
    }
}