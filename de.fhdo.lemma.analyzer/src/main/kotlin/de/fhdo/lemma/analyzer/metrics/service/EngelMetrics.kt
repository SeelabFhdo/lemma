@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.metrics.service

import de.fhdo.lemma.analyzer.asGraphPath
import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.lib.divideBy
import de.fhdo.lemma.analyzer.forEachMicroservice
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemItemItem
import de.fhdo.lemma.analyzer.itemItemItemItem
import de.fhdo.lemma.analyzer.itemItemItemItemItem
import de.fhdo.lemma.analyzer.itemOn
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lastFolderAndFilename
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.EngelMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.DependencyGraph
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.DependencyGraphVertex
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import org.eclipse.emf.ecore.resource.Resource
import java.io.File

private const val VALUE_STORE_PREFIX = "engelMetrics"
private val INCOMING_EXCHANGE_PATTERNS = setOf(ExchangePattern.IN, ExchangePattern.INOUT)
private val INCOMING_EXCHANGE_PATTERNS_ARRAY = INCOMING_EXCHANGE_PATTERNS.toTypedArray()
private val OUTGOING_EXCHANGE_PATTERNS = setOf(ExchangePattern.OUT, ExchangePattern.INOUT)
private val OUTGOING_EXCHANGE_PATTERNS_ARRAY = OUTGOING_EXCHANGE_PATTERNS.toTypedArray()
private val RESULT_COLLECTOR_INPUT_KEY = InteractionSizeResultCollection.ExchangePatternsKey(INCOMING_EXCHANGE_PATTERNS)
private val RESULT_COLLECTOR_OUTPUT_KEY
    = InteractionSizeResultCollection.ExchangePatternsKey(OUTGOING_EXCHANGE_PATTERNS)

/**
 * Intermediate model validator, which implements the analysis for the metrics suite of
 * [Engel et al.](https://link.springer.com/chapter/10.1007/978-3-319-92901-9_8).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class EngelMetrics : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "service-metrics-engel"
        const val CLI_OPTION_USE_TECHNOLOGY_TYPES = "use-technology-specific-types"
        const val CLI_OPTION_VERBOSE = "verbose"
        const val CLI_OPTION_GRAPHS_TARGET_PATH = "write-graphs-to"
    }

    private lateinit var analyzer: EngelMetricsAnalyzerI
    private var useOriginalTypes = true
    private var verboseMode = false
    private var graphsTargetPath : String? = null

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Engel Service Metrics", MODULE_CLI_OPTION_NAME,
        setOf(CLI_OPTION_USE_TECHNOLOGY_TYPES, CLI_OPTION_VERBOSE, CLI_OPTION_GRAPHS_TARGET_PATH))

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_METRICS_ENGEL.createAnalyzer() as EngelMetricsAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        useOriginalTypes = CLI_OPTION_USE_TECHNOLOGY_TYPES !in args
        verboseMode = CLI_OPTION_VERBOSE in args
        graphsTargetPath = args[CLI_OPTION_GRAPHS_TARGET_PATH]

        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        calculateMetrics()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Engel et al. Metrics Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Calculate the metrics of the suite
     */
    private fun calculateMetrics() {
        overallMetrics()
        loadedModelsWithPath.forEachMicroservice(
            { path, _ -> subsection("Metrics for model \"${path.asFile().lastFolderAndFilename()}\"") }
        ) { modelPath, microservice, microserviceIdentifier ->
            item("Microservice: ${microservice.qualifiedName}")
            interfaceCount(microservice, microserviceIdentifier)
            blankLine()
            dependencyCount(modelPath, microservice, microserviceIdentifier)
            blankLine()
            averageInteractionSize(microservice, microserviceIdentifier)
            blankLine()
            cyclicDependenciesCount(modelPath, microservice, microserviceIdentifier)
        }
    }

    /**
     * Handle the calculation of metrics that concern all service models
     */
    private fun overallMetrics() {
        val microserviceCount = analyzer.microserviceCount()
        val interfaceCount = analyzer.interfaceCount()
        val averageInterfaceCountPerMicroservice = analyzer.averageInterfaceCountPerMicroservice()

        subsection("Overall Metrics")
        item(microserviceCount, "# Microservices")
        item(interfaceCount, "# Interfaces")
        item(averageInterfaceCountPerMicroservice, "Average interfaces per microservice")

        ValueStore["${VALUE_STORE_PREFIX}MicroserviceCount"] = microserviceCount
        ValueStore["${VALUE_STORE_PREFIX}InterfaceCount"] = interfaceCount
        ValueStore["${VALUE_STORE_PREFIX}AverageInterfaceCountPerMicroservice"] = averageInterfaceCountPerMicroservice
    }

    /**
     * Calculate metrics related to the interfaces of the given [microservice]
     */
    private fun interfaceCount(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        val interfaceCount = analyzer.interfaceCount(microservice)
        val synchronousInterfaceCount = analyzer.synchronousInterfaceCount(microservice)
        val asynchronousInterfaceCount = analyzer.asynchronousInterfaceCount(microservice)

        itemItem("Metric M1: Interface Count")
        itemItemItem(interfaceCount, "# Interfaces")
        itemItemItem(synchronousInterfaceCount, "# Synchronous interfaces")
        itemItemItem(asynchronousInterfaceCount, "# Asynchronous interfaces")

        ValueStore["${VALUE_STORE_PREFIX}InterfaceCount"] = interfaceCount to listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}SynchronousInterfaceCount"] = synchronousInterfaceCount to
            listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}AsynchronousInterfaceCount"] = asynchronousInterfaceCount to
            listOf(microserviceIdentifier)
    }

    /**
     * Calculate metrics related to the dependencies of the given [microservice]
     */
    private fun dependencyCount(modelPath: String, microservice: IntermediateMicroservice,
        microserviceIdentifier: String) {
        val dependencyCount = analyzer.dependencyCount(microservice, modelPath)

        itemItem("Metric M3: (Statically Determinable) Dependencies Count")
        itemItemItem(dependencyCount, "# Dependencies")

        ValueStore["${VALUE_STORE_PREFIX}DependencyCount"] = dependencyCount to listOf(microserviceIdentifier)
    }

    /**
     * Calculate the average interaction sizes of the given [microservice]
     */
    private fun averageInteractionSize(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        val asynchronousSizeResults = averageInteractionSize(microservice, CommunicationType.ASYNCHRONOUS)
        val synchronousSizeResults = averageInteractionSize(microservice, CommunicationType.SYNCHRONOUS)

        val baseType = if (useOriginalTypes) "Original Types" else "Technology-Specific Types"
        itemItem("Metric M5: (Statically Determinable) Average Interaction Size ($baseType for Size Calculation)")
        itemItemItem(microservice.qualifiedName, "Microservice")

        itemItemItemItem("Asynchronous Interaction Sizes")
        asynchronousSizeResults.printAndStoreVerboseInformation(microserviceIdentifier)
        if (verboseMode) blankLine()
        asynchronousSizeResults.printAndStoreMaxOperation(microserviceIdentifier)
        asynchronousSizeResults.printAndStoreOverallInformation(microserviceIdentifier)

        blankLine()

        itemItemItemItem("Synchronous Interaction Sizes")
        synchronousSizeResults.printAndStoreVerboseInformation(microserviceIdentifier)
        if (verboseMode) blankLine()
        synchronousSizeResults.printAndStoreMaxOperation(microserviceIdentifier)
        synchronousSizeResults.printAndStoreOverallInformation(microserviceIdentifier)
    }

    /**
     * Helper to calculate the average interaction size of the given [microservice] for the given [communicationType]
     */
    private fun averageInteractionSize(microservice: IntermediateMicroservice, communicationType: CommunicationType)
        : InteractionSizeResultCollection {
        val resultCollector = InteractionSizeResultCollection(communicationType)
        val operations = microservice.operationsWithParameterOfType(communicationType)
        for (operation in operations) {
            val (inSize, inParamCount) = analyzer.interactionSize(operation, useOriginalTypes, communicationType,
                *INCOMING_EXCHANGE_PATTERNS_ARRAY)
            resultCollector.newResult(operation, inSize, inParamCount, INCOMING_EXCHANGE_PATTERNS)

            val (outSize, outParamCount) = analyzer.interactionSize(operation, useOriginalTypes, communicationType,
                *OUTGOING_EXCHANGE_PATTERNS_ARRAY)
            resultCollector.newResult(operation, outSize, outParamCount, OUTGOING_EXCHANGE_PATTERNS)
        }
        return resultCollector
    }

    /**
     * Get all operations of this microservice, of which at least one parameter is of the given [communicationType]
     */
    private fun IntermediateMicroservice.operationsWithParameterOfType(communicationType: CommunicationType)
        = interfaces.map { iface -> iface.operations.filter {
            it.parameters.any { p -> p.communicationType == communicationType.name }
        } }.flatten()

    /**
     * Helper to print an store verbose information about this [InteractionSizeResultCollection]. The printing of
     * verbose information will only occur if [verboseMode] was activated by the user. Otherwise, the information will
     * only be stored.
     */
    private fun InteractionSizeResultCollection.printAndStoreVerboseInformation(microserviceIdentifier: String)
        = getCollectedResults().forEach { (operation, results) ->
                val inSize = results[RESULT_COLLECTOR_INPUT_KEY]?.size ?: 0
                val inParameterCount = results[RESULT_COLLECTOR_INPUT_KEY]?.parameterCount ?: 0
                val outSize = results[RESULT_COLLECTOR_OUTPUT_KEY]?.size ?: 0
                val outParameterCount = results[RESULT_COLLECTOR_OUTPUT_KEY]?.parameterCount ?: 0

                val valueStoreIdentifiers = listOf(microserviceIdentifier, operation.`interface`.name, operation.name)
                ValueStore["${VALUE_STORE_PREFIX}InputSize"] = inSize to valueStoreIdentifiers
                ValueStore["${VALUE_STORE_PREFIX}InputParameterCount"] = inParameterCount to valueStoreIdentifiers
                ValueStore["${VALUE_STORE_PREFIX}OutputSize"] = outSize to valueStoreIdentifiers
                ValueStore["${VALUE_STORE_PREFIX}OutputParameterCount"] = outParameterCount to valueStoreIdentifiers

                if (verboseMode) {
                    itemItemItemItemItem("Operation ${operation.interfaceBasedQualifiedName()}:")
                    itemOn(6, "Input size: $inSize bits (# parameters: $inParameterCount)")
                    itemOn(6, "Output size: $outSize bits (# parameters: $outParameterCount)")
                }
            }

    /**
     * Get the interface-based qualified name of this [IntermediateOperation], which consists of the simple name of the
     * interface and the operation's name separated by a dot
     */
    private fun IntermediateOperation.interfaceBasedQualifiedName() = "${`interface`.name}.$name"

    /**
     * Print and store the operations with the maximum input and output interaction sizes from this
     * [InteractionSizeResultCollection]
     */
    private fun InteractionSizeResultCollection.printAndStoreMaxOperation(microserviceIdentifier: String) {
        getStatistics()[RESULT_COLLECTOR_INPUT_KEY].printAndStoreMaxOperation(microserviceIdentifier, "input")
        getStatistics()[RESULT_COLLECTOR_OUTPUT_KEY].printAndStoreMaxOperation(microserviceIdentifier, "output")
    }

    /**
     * Print the operation with the maximum interaction size from these [InteractionSizeStatistics]
     */
    private fun InteractionSizeStatistics?.printAndStoreMaxOperation(microserviceIdentifier: String,
        sizePrefix: String) {
        val maxOperation = this?.operationWithMaxSize
        val (maxSize, maxParameterCount) = if (maxOperation != null) {
                val maxSize = this?.maxSize ?: 0
                val maxParameterCount = this?.parameterCountMaxSize ?: 0
                maxSize to maxParameterCount
            } else
                -1 to -1

        val maxOperationName = maxOperation?.interfaceBasedQualifiedName() ?: "NOT DETERMINABLE"
        itemItemItemItemItem("Operation with highest $sizePrefix size: $maxOperationName")
        itemOn(6, "Size: $maxSize bits (# parameters: $maxParameterCount)")

        if (this == null || maxOperation == null)
            return

        val communicationTypesString = communicationTypes.joinToString("") { it.name.toLowerCase().capitalize() }
        val exchangePatternsString = exchangePatterns.joinToString("") { it.name.toLowerCase().capitalize() }
        val valueStoreIdentifiers = listOf(
            microserviceIdentifier,
            maxOperation.`interface`.name,
            maxOperation.name,
            communicationTypesString,
            exchangePatternsString
        )
        ValueStore["${VALUE_STORE_PREFIX}MaxOperationName"] = maxOperation.name to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}MaxOperationSize"] = maxSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}MaxOperationParameterCount"] = maxParameterCount to valueStoreIdentifiers
    }

    /**
     * Print and store overall information from this [InteractionSizeResultCollection]. Such information include the
     * total interaction input size and output size as well as the overall average interaction size.
     */
    private fun InteractionSizeResultCollection.printAndStoreOverallInformation(microserviceIdentifier: String) {
        val (overallInSize, overallOutSize) = printAndStoreOverallInteractionSizes(microserviceIdentifier)
        printAndStoreAverageInteractionSizes(microserviceIdentifier, overallInSize, overallOutSize)
    }

    /**
     * Print and store overall the total interaction input size and output size from this
     * [InteractionSizeResultCollection]
     */
    private fun InteractionSizeResultCollection.printAndStoreOverallInteractionSizes(microserviceIdentifier: String)
        : Pair<Int, Int> {
        val (overallInSize, overallInParamCount) = getOverallSizeAndParameterCount(RESULT_COLLECTOR_INPUT_KEY)
        val (overallOutSize, overallOutParamCount) = getOverallSizeAndParameterCount(RESULT_COLLECTOR_OUTPUT_KEY)
        val overallSize = overallInSize + overallOutSize
        val overallParamCount = overallInParamCount + overallOutParamCount
        itemItemItemItemItem("Overall interaction size: $overallSize bits (# parameters: $overallParamCount)")
        itemOn(6, "Overall input size: $overallInSize bits (# parameters: $overallInParamCount)")
        itemOn(6, "Overall output size: $overallOutSize bits (# parameters: $overallOutParamCount)")

        val communicationTypesString = communicationTypes.joinToString("") { it.name.toLowerCase().capitalize() }
        val valueStoreIdentifiers = listOf(microserviceIdentifier, communicationTypesString)
        ValueStore["${VALUE_STORE_PREFIX}OverallInteractionSize"] = overallSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}OverallParameterCount"] = overallParamCount to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}OverallInputSize"] = overallInSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}OverallInputParameterCount"] = overallInParamCount to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}OverallOutputSize"] = overallOutSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}OverallOutputParameterCount"] = overallOutParamCount to valueStoreIdentifiers

        return overallInSize to overallOutSize
    }

    /**
     * Get the overall interaction size and parameter count from this [InteractionSizeResultCollection] for parameters
     * with the given [exchangePatternsKey]
     */
    private fun InteractionSizeResultCollection.getOverallSizeAndParameterCount(
        exchangePatternsKey: InteractionSizeResultCollection.ExchangePatternsKey
    ) : Pair<Int, Int> {
        val statistics = getStatistics()[exchangePatternsKey]
        return if (statistics != null)
                statistics.overallSize to statistics.overallParameterCount
            else
                0 to 0
    }

    /**
     * Print and store the overall average interaction sizes for this [InteractionSizeResultCollection]
     */
    private fun InteractionSizeResultCollection.printAndStoreAverageInteractionSizes(
        microserviceIdentifier: String,
        overallInSize: Int,
        overallOutSize: Int
    ) {
        val overallSize = overallInSize + overallOutSize
        val overallOperationCount = getOperationCount()
        val averageSize = overallSize.divideBy(overallOperationCount)
        val averageInSize = overallInSize.divideBy(overallOperationCount)
        val averageOutSize = overallOutSize.divideBy(overallOperationCount)

        itemItemItemItemItem("Average interaction size: $averageSize bits (# operations: $overallOperationCount)")
        itemOn(6, "Average input size: $averageInSize bits")
        itemOn(6, "Average output size: $averageOutSize bits")

        val communicationTypesString = communicationTypes.joinToString("") { it.name.toLowerCase().capitalize() }
        val valueStoreIdentifiers = listOf(microserviceIdentifier, communicationTypesString)
        ValueStore["${VALUE_STORE_PREFIX}AverageInteractionSize"] = averageSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}AverageInputSize"] = averageInSize to valueStoreIdentifiers
        ValueStore["${VALUE_STORE_PREFIX}AverageOutputSize"] = averageOutSize to valueStoreIdentifiers
    }

    /**
     * Calculate metrics related cyclic dependencies of the given [microservice]
     */
    private fun cyclicDependenciesCount(modelPath: String, microservice: IntermediateMicroservice,
        microserviceIdentifier: String) {
        val dependencyGraph = analyzer.dependencyGraph(microservice, modelPath)
        val cyclicDependencies = dependencyGraph.getCycles()
        val cyclicDependenciesCount = cyclicDependencies.count()

        itemItem("Metric M6: (Statically Determinable) Cyclic Dependencies Count")
        itemItemItem(cyclicDependenciesCount, "# Cyclic Dependencies")
        cyclicDependencies.forEach { it.printAsGraphPath() }

        ValueStore["${VALUE_STORE_PREFIX}CyclicDependenciesCount"] = cyclicDependenciesCount to
            listOf(microserviceIdentifier)

        dependencyGraph.writeToFileIfRequested()
    }

    /**
     * Print this [DependencyGraphVertex] list as a path with some ASCII art
     */
    private fun List<DependencyGraphVertex>.printAsGraphPath()
        = itemItemItemItem(map { it.qualifiedMicroserviceName }
            .asGraphPath(levelIndent = "", subLevelIndent = "\t".repeat(5), maxEntriesInSameRow = 1))

    /**
     * Write this [DependencyGraph] to a file if the user requested it
     */
    private fun DependencyGraph.writeToFileIfRequested() {
        if (graphsTargetPath == null)
            return

        val graphPath = "${graphsTargetPath}${File.separator}${microservice.name}"
        graphPath.asFile().mkdirs()

        val filePath = "$graphPath${File.separator}HttpResourceGraph.dot"
        filePath.asFile().writeText(toString())
    }
}

/**
 * Helper class to maintain results form interaction size calculations for the given [communicationTypes].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class InteractionSizeResultCollection(val communicationTypes: Set<CommunicationType>) {
    companion object {
        /**
         * Compare two [Set]s of [ExchangePattern]s
         */
        private fun Set<ExchangePattern>.sameAs(other: Set<ExchangePattern>) = size == other.size && containsAll(other)
    }

    /**
     * [Map] of the collected interaction size calculation results. The results are per [IntermediateOperation] and
     * parameter [ExchangePattern]s. For example, an [InteractionSizeResultCollection] may gather interaction size
     * calculation results for all incoming and outgoing parameters of an [IntermediateOperation].
     */
    private val collectedResults = mutableMapOf<IntermediateOperation, MutableMap<ExchangePatternsKey, ResultEntry>>()

    /**
     * [Map] to gather [InteractionSizeStatistics] for a set of [ExchangePattern]s
     */
    private val statistics = mutableMapOf<ExchangePatternsKey, InteractionSizeStatistics>()

    /**
     * Construct a new [InteractionSizeResultCollection] instance from only a single [communicationType]
     */
    constructor(communicationType: CommunicationType) : this(setOf(communicationType))

    /**
     * Add a new interaction [size] calculation result for the given [operation], [parameterCount], and
     * [exchangePatterns] to an [InteractionSizeResultCollection]
     */
    fun newResult(operation: IntermediateOperation, size: Int, parameterCount: Int,
        exchangePatterns: Set<ExchangePattern>) {
        if (operation !in collectedResults)
            collectedResults[operation] = mutableMapOf()

        val operationResults = collectedResults[operation]!!
        val resultKey = ExchangePatternsKey(exchangePatterns)
        val resultEntry = ResultEntry(size, parameterCount, exchangePatterns)
        operationResults[resultKey] = resultEntry
        addToStatistics(operation, resultEntry)
    }

    /**
     * Internal class, which gathers [exchangePatterns] and acts as the key
     */
    class ExchangePatternsKey(val exchangePatterns: Set<ExchangePattern>) {
        override fun equals(other: Any?)
            = if (this === other) true
                else if (other == null) false
                else if (other is ExchangePatternsKey) exchangePatterns.sameAs(other.exchangePatterns)
                else false

        override fun hashCode() = exchangePatterns.joinToString("$$") { it.name }.hashCode()
    }

    /**
     * Interaction size calculation [ResultEntry]. It combines the calculated [size] with the [parameterCount] and
     * [exchangePatterns] involved in a size calculation.
     */
    class ResultEntry(val size: Int, val parameterCount: Int, val exchangePatterns: Set<ExchangePattern>) {
        override fun equals(other: Any?)
            = if (this === other) true
                else if (other == null) false
                else if (other is ResultEntry) exchangePatterns.sameAs(other.exchangePatterns)
                else false

        override fun hashCode() = exchangePatterns.joinToString("$$") { it.name }.hashCode()
    }

    /**
     * Add the given [resultEntry] to the [InteractionSizeStatistics] for the given [operation]
     */
    fun addToStatistics(operation: IntermediateOperation, resultEntry: ResultEntry) {
        val key = ExchangePatternsKey(resultEntry.exchangePatterns)
        if (key !in statistics)
            statistics[key] = InteractionSizeStatistics(communicationTypes, resultEntry.exchangePatterns)
        statistics[key]!!.newEntry(operation, resultEntry.size, resultEntry.parameterCount)
    }

    /**
     * Get all collected interaction size results
     */
    fun getCollectedResults() : Map<IntermediateOperation, Map<ExchangePatternsKey, ResultEntry>> = collectedResults

    /**
     * Get the number of [IntermediateOperation]s, for which we calculated interaction sizes
     */
    fun getOperationCount() = collectedResults.keys.size

    /**
     * Get gathered [InteractionSizeStatistics]
     */
    fun getStatistics() : Map<ExchangePatternsKey, InteractionSizeStatistics> = statistics
}

/**
 * Helper class to maintain statistics about interaction size calculation results for the given [communicationTypes] and
 * [exchangePatterns].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class InteractionSizeStatistics(val communicationTypes: Set<CommunicationType>,
    val exchangePatterns: Set<ExchangePattern>) {
    var overallSize: Int = 0
        private set
    var overallParameterCount: Int = 0
        private set
    var maxSize: Int = 0
        private set
    var operationWithMaxSize: IntermediateOperation? = null
        private set
    var parameterCountMaxSize: Int = 0
        private set

    /**
     * Add new entries in statistics collections from the given [operation], [size] calculation result, and
     * [parameterCount]
     */
    fun newEntry(operation: IntermediateOperation, size: Int, parameterCount: Int) {
        overallSize += size
        overallParameterCount += parameterCount
        if (size > maxSize) {
            // Currently, we only support one operation and its parameter count with max size
            maxSize = size
            operationWithMaxSize = operation
            parameterCountMaxSize = parameterCount
        }
    }

    override fun equals(other: Any?)
        = if (this === other)
                true
            else if (other == null)
                false
            else if (other is InteractionSizeStatistics)
                exchangePatterns.size == other.exchangePatterns.size &&
                exchangePatterns.containsAll(other.exchangePatterns)
            else
                false

    override fun hashCode() = exchangePatterns.joinToString("$$") { it.name }.hashCode()
}