package de.fhdo.lemma.analyzer.metrics.service

import de.fhdo.lemma.analyzer.asGraphPath
import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.forEachMicroservice
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemItemItem
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lastFolderAndFilename
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.HauptMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource
import java.io.File

private const val VALUE_STORE_PREFIX = "hauptMetrics"

/**
 * Intermediate model validator, which implements the analysis for the metrics suite of
 * [Haupt et al.](https://ieeexplore.ieee.org/abstract/document/7930199).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class HauptMetrics : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "service-metrics-haupt"
        const val CLI_OPTION_GRAPHS_TARGET_PATH = "write-graphs-to"
    }

    private lateinit var analyzer: HauptMetricsAnalyzerI
    private var graphsTargetPath : String? = null

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Haupt Service Metrics", MODULE_CLI_OPTION_NAME,
        setOf(CLI_OPTION_GRAPHS_TARGET_PATH))

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_METRICS_HAUPT.createAnalyzer() as HauptMetricsAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        graphsTargetPath = args[CLI_OPTION_GRAPHS_TARGET_PATH]

        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        calculateMetrics()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Haupt et al. Metrics Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Calculate the metrics of the suite
     */
    private fun calculateMetrics() {
        loadedModelsWithPath.forEachMicroservice(
            { path, _ -> subsection("Metrics for model \"${path.asFile().lastFolderAndFilename()}\"") }
        ) { _, microservice, microserviceIdentifier ->
            resourceOverview(microservice, microserviceIdentifier)
            resourceCharacterization(microservice, microserviceIdentifier)
            resourceTypeCounts(microservice, microserviceIdentifier)
            writeHttpResourceGraph(microservice)
        }
    }

    /**
     * Calculate metrics related to microservice resources for the given [microservice]
     */
    private fun resourceOverview(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        val resourceCount = analyzer.countResources(microservice)
        item(resourceCount, "# Resources for microservice ${microservice.name}")
        ValueStore["${VALUE_STORE_PREFIX}NumberOfResources"] = resourceCount to listOf(microserviceIdentifier)

        item("Resource Overview:")
        analyzer.getResourcesPerHttpMethod(microservice).forEach { (httpMethod, resources) ->
            itemItem("${httpMethod.string.toUpperCase()} (${resources.count()}):")
            resources.forEach { itemItemItem(it.qualifiedName) }
        }
    }

    /**
     * Calculate metrics related to resource characterization, e.g., number of resources, resources links, or longest
     * path in the resource dependency graph, for the given [microservice]
     */
    private fun resourceCharacterization(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        val rootResources = analyzer.getRootResources(microservice)
        val rootResourcesCount = rootResources.count()
        val resourceLinkCount = analyzer.getResourceLinkCount(microservice)
        val longestResourcePath = analyzer.getLongestResourcePath(microservice)
        // The Max Depth metric concerns the length of the longest path in the resource graph, which is the number of
        // edges in the path and not the number of vertices returned by getLongestResourcePath()
        val longestResourcePathDepth = if (longestResourcePath.isNotEmpty()) longestResourcePath.size - 1 else 0

        blankLine()
        item("Resource Characterization:")
        itemItem(rootResources.joinToString(", ") { it.qualifiedName }, "Root resources (count: $rootResourcesCount)")
        ValueStore["${VALUE_STORE_PREFIX}NumberOfRootResources"] = rootResourcesCount to listOf(microserviceIdentifier)

        itemItem(resourceLinkCount, "# Resource links")
        ValueStore["${VALUE_STORE_PREFIX}NumberOfResourceLinks"] = resourceLinkCount to listOf(microserviceIdentifier)

        itemItem("Longest resource path (depth: $longestResourcePathDepth):")
        println(longestResourcePath.asGraphPath(levelIndent = "\t\t\t", subLevelIndent = "\t"))
        ValueStore["${VALUE_STORE_PREFIX}MaxDepth"] = longestResourcePathDepth to listOf(microserviceIdentifier)
    }

    /**
     * Calculate metrics related to the count of certain resource types, e.g., read-only or POST resources, for the
     * given [microservice]
     */
    private fun resourceTypeCounts(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        ValueStore["${VALUE_STORE_PREFIX}DeleteResourceCount"] = analyzer.getDeleteResources(microservice).size to
            listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}ReadOnlyResourceCount"] = analyzer.getReadOnlyResources(microservice).size to
            listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}PostResourceCount"] = analyzer.getPostResources(microservice).size to
            listOf(microserviceIdentifier)
    }

    /**
     * Write the HTTP resource graph of the given [microservice] to the local filesystem in case the user requested it
     */
    private fun writeHttpResourceGraph(microservice: IntermediateMicroservice) {
        if (graphsTargetPath == null)
            return

        val graphPath = "${graphsTargetPath}${File.separator}${microservice.name}"
        graphPath.asFile().mkdirs()

        val filePath = "$graphPath${File.separator}HttpResourceGraph.dot"
        filePath.asFile().writeText(analyzer.getHttpResourceGraph(microservice).toString())
    }
}