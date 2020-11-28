package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemItemItem
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.items
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.ServiceBasicAnalyzerI
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.HttpMethodOverview
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedOperations
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.toUnifiedOperations
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.putToValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

private typealias EffectiveProtocolsResult = Set<Triple<String, String, CommunicationType>>

/**
 * Intermediate model validator, which implements a basic analysis for service models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class IntermediateServiceModelAnalysis : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "basic-service-analysis"
    }

    private lateinit var analyzer: ServiceBasicAnalyzerI

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Basic Service Analysis", MODULE_CLI_OPTION_NAME)

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_BASIC.createAnalyzer() as ServiceBasicAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        serviceModelOverview()
        protocolOverview()
        restOverview()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Service Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Perform basic analysis for service models
     */
    private fun serviceModelOverview() {
        val serviceCount = analyzer.countMicroservices()
        val interfaceCount = analyzer.countInterfaces()
        val operationCount = analyzer.countOperations()
        val asynchronousOperationCount = analyzer.countAsynchronousOperations()
        val synchronousOperationCount = analyzer.countSynchronousOperations()
        val largestInterface = analyzer.getLargestInterfaceByOperations()
        val largestInterfaceModelFile = largestInterface?.first?.asFile()
        val largestInterfaceModelFilename = largestInterfaceModelFile?.name ?: "<No largest interface found>"
        val largestInterfaceModelSimpleFilename = largestInterfaceModelFile?.nameWithoutExtension
            ?: "<No largest interface found>"
        val largestInterfaceName = largestInterface?.second?.name ?: "<No largest interface found>"
        val largestInterfaceOperationCount = largestInterface?.second?.operations?.size ?: 0

        subsection("Overview of Service Models (Model Count: ${loadedModels.size})")
        item(serviceCount, "# Microservices")
        ValueStore["microserviceCount"] = serviceCount

        item(interfaceCount, "# Interfaces")
        ValueStore["totalInterfaceCount"] = interfaceCount

        item(operationCount, "# Operations")
        ValueStore["totalOperationCount"] = operationCount

        item(asynchronousOperationCount, "# Purely Asynchronous Operations")
        ValueStore["totalAsynchronousOperationCount"] = asynchronousOperationCount

        item(synchronousOperationCount, "# Purely Synchronous Operations")
        ValueStore["totalSynchronousOperationCount"] = synchronousOperationCount

        blankLine()
        item("Largest Interface")
        itemItem(largestInterfaceName, "Name")
        itemItem(largestInterfaceModelFilename, "Model File")
        itemItem(largestInterfaceOperationCount, "# Operations")
        ValueStore["largestInterfaceName"] = largestInterfaceName
        ValueStore["largestInterfaceModelFilename"] = largestInterfaceModelSimpleFilename
        ValueStore["largestInterfaceOperationCount"] = largestInterfaceOperationCount
    }

    /**
     * Get the File handle of this [EObject] from its [absolutePath]
     */
    private fun EObject.asFile() = absolutePath().asFile()

    /**
     * Get the absolute path of the resource of this [EObject]
     */
    private fun EObject.absolutePath() : String {
        return if (eResource().uri.toString().asFile().isAbsolute)
            eResource().uri.toString()
        else
            eResource().uri.toFileString().asFile().canonicalPath
    }

    /**
     * Perform analysis to provide an overview of the protocols in service models
     */
    private fun protocolOverview() {
        val effectiveProtocols = analyzer.getEffectiveProtocols()

        subsection("Protocol Overview (Model Count: ${loadedModels.size})")
        item("Effective Protocols")
        effectiveProtocols.printAndStoreProtocolItems(CommunicationType.ASYNCHRONOUS)
        effectiveProtocols.printAndStoreProtocolItems(CommunicationType.SYNCHRONOUS)
    }

    /**
     * Print and store the items in an [EffectiveProtocolsResult] from the [analyzer]
     */
    private fun EffectiveProtocolsResult.printAndStoreProtocolItems(communicationType: CommunicationType) {
        val items = filter { it.third == communicationType }

        val communicationTypeTitle = communicationType.name.toLowerCase().capitalize()
        itemItem(communicationTypeTitle)
        items.forEachIndexed { index, resultEntry ->
            val (protocol, dataFormat, _) = resultEntry
            itemItemItem("$protocol ($dataFormat)")
            ValueStore["effectiveProtocol$communicationTypeTitle${index+1}"] = "$protocol, $dataFormat"
        }

        itemItemItem(items.size, "# $communicationTypeTitle Protocols")
        ValueStore["effectiveProtocolCount"] = items.size to listOf(communicationTypeTitle)
    }

    /**
     * Perform analysis to provide an overview dedicated to REST
     */
    private fun restOverview() {
        val restOperations = analyzer.getOperationsWithProtocol(CommunicationType.SYNCHRONOUS, "rest")
        val restReferredOperations = analyzer.getReferredOperationsWithProtocol(CommunicationType.SYNCHRONOUS, "rest")
        val unifiedRestOperations = UnifiedOperations(restOperations, restReferredOperations)
        val restOperationCount = unifiedRestOperations.count()

        // Get REST endpoint information
        val (
            httpRestEndpointOperations,
            httpRestEndpointOperationsCount,
            nonHttpRestEndpointOperations,
            nonHttpRestEndpointOperationsCount,
            nonHttpRestEndpointOperationsWithoutEndpoint,
            nonHttpRestEndpointOperationsWithoutEndpointCount,
        ) = unifiedRestOperations.getRestEndpointInformation()

        // Gather information from HTTP method overviews
        val nonInternalHttpRestMethodCount = HttpMethodOverview
            .getHttpMethodDistribution(unifiedRestOperations.filter { !it.operation.internal() }).values.sum()
        val httpRestEndpointOperationDistribution = HttpMethodOverview
            .getHttpMethodDistribution(httpRestEndpointOperations).mapKeys { it.key.string }
        val overallHttpRestOperationDistribution = HttpMethodOverview
            .getHttpMethodDistribution(unifiedRestOperations).mapKeys { it.key.string }

        // Print the analysis values
        subsection("REST Overview (Model Count: ${loadedModels.size})")
        item("# REST operations: $restOperationCount")

        itemItem("# ... Non-internal REST operations with HTTP method: $nonInternalHttpRestMethodCount")
        itemItem("# ... REST operations with HTTP method and explicit REST endpoint: $httpRestEndpointOperationsCount")
        itemItemItem("HTTP method distribution:")
        items(httpRestEndpointOperationDistribution, toString = { it.toUpperCase() }, itemLevel = 4)

        itemItem("# ... REST operations with explicit REST endpoint but WITHOUT HTTP method: " +
            nonHttpRestEndpointOperationsCount)
        nonHttpRestEndpointOperations.printWithVisibility()

        itemItem("# ... REST operations WITHOUT HTTP method and explicit REST endpoint: " +
            nonHttpRestEndpointOperationsWithoutEndpointCount)
        nonHttpRestEndpointOperationsWithoutEndpoint.printWithVisibility()

        itemItem("... Overall HTTP method distribution:")
        items(overallHttpRestOperationDistribution, toString = { it.toUpperCase() }, itemLevel = 3)

        // Store the analysis values
        ValueStore["restOperationCount"] = restOperationCount
        ValueStore["httpOperationsWithExplicitRestEndpointCount"] = httpRestEndpointOperationsCount
        ValueStore["nonInternalRestOperationWithHttpMethodCount"] = nonInternalHttpRestMethodCount
        ValueStore["nonHttpOperationsWithExplicitRestEndpointCount"] = nonHttpRestEndpointOperationsCount
        ValueStore["restOperationsWithoutMethodAndEndpointCount"] = nonHttpRestEndpointOperationsWithoutEndpointCount
        httpRestEndpointOperationDistribution.putToValueStore("httpMethodCountWithRestEndpoint")
        overallHttpRestOperationDistribution.putToValueStore("httpMethodCount")
    }

    /**
     * Check if this [IntermediateOperation] has an internal visibility
     */
    private fun IntermediateOperation.internal()
        = visibility == Visibility.INTERNAL.name || visibility == Visibility.IN_MODEL.name

    /**
     * Helper to get [RestEndpointsInformation] from these [UnifiedOperations]
     */
    private fun UnifiedOperations.getRestEndpointInformation() : RestEndpointsInformation {
        val httpMethodOverview = HttpMethodOverview(this)

        // Get HTTP operations with explicit REST endpoint
        val httpRestEndpointOperations = httpMethodOverview.getOperationsWithExplicitEndpoint(
            CommunicationType.SYNCHRONOUS,
            "rest",
            includeNonHttpOperations = false
        )
        val httpRestEndpointOperationsCount = httpRestEndpointOperations.count()

        // Get non-HTTP operations with explicit REST endpoint
        val nonHttpRestEndpointOperations = httpMethodOverview.getOperationsWithExplicitEndpoint(
            CommunicationType.SYNCHRONOUS,
            "rest",
            includeHttpOperations = false
        )
        val nonHttpRestEndpointOperationsCount = nonHttpRestEndpointOperations.count()

        // Get non-HTTP operations without any endpoint
        val nonHttpRestEndpointOperationsWithoutEndpoint = httpMethodOverview.operationsWithoutHttpMethods
            .filter { it.endpoints.isEmpty() }
            .toUnifiedOperations()
        val nonHttpRestEndpointOperationsWithoutEndpointCount = nonHttpRestEndpointOperationsWithoutEndpoint.count()

        // Prepare and return result
        return RestEndpointsInformation(
            httpRestEndpointOperations,
            httpRestEndpointOperationsCount,
            nonHttpRestEndpointOperations,
            nonHttpRestEndpointOperationsCount,
            nonHttpRestEndpointOperationsWithoutEndpoint,
            nonHttpRestEndpointOperationsWithoutEndpointCount,
        )
    }

    /**
     * Helper class to gather information about REST endpoints
     */
    private data class RestEndpointsInformation(
        val httpRestEndpointOperations: UnifiedOperations,
        val httpRestEndpointOperationsCount: Int,
        val nonHttpRestEndpointOperations: UnifiedOperations,
        val nonHttpRestEndpointOperationsCount: Int,
        val nonHttpRestEndpointOperationsWithoutEndpoint: UnifiedOperations,
        val nonHttpRestEndpointOperationsWithoutEndpointCount: Int
    )

    /**
     * Print the qualified names of these [UnifiedOperations] prefixed by their visibility
     */
    private fun UnifiedOperations.printWithVisibility()
        = forEach { itemItemItem("${it.operation.visibility.toLowerCase()} ${it.operation.qualifiedName}") }
}