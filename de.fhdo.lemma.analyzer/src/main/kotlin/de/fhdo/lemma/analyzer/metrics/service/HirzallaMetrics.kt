package de.fhdo.lemma.analyzer.metrics.service

import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.forEachMicroservice
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemItemItem
import de.fhdo.lemma.analyzer.itemItemItemItem
import de.fhdo.lemma.analyzer.itemItemItemItemItem
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lastFolderAndFilename
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.HirzallaMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.simpleName
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource

private const val VALUE_STORE_PREFIX = "hirzallaMetrics"

/**
 * Intermediate model validator, which implements the analysis for the metrics suite of
 * [Hirzalla et al.](https://link.springer.com/chapter/10.1007/978-3-642-01247-1_5).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class HirzallaMetrics : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "service-metrics-hirzalla"
        const val CLI_OPTION_VERBOSE = "verbose"
    }

    private lateinit var analyzer: HirzallaMetricsAnalyzerI
    private var verboseMode = false

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Hirzalla Service Metrics", MODULE_CLI_OPTION_NAME,
        setOf(CLI_OPTION_VERBOSE))

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_METRICS_HIRZALLA.createAnalyzer() as HirzallaMetricsAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        verboseMode = CLI_OPTION_VERBOSE in args

        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        calculateMetrics()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Hirzalla et al. Metrics Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Calculate the metrics of the suite
     */
    private fun calculateMetrics() {
        overallMetrics()
        loadedModelsWithPath.forEachMicroservice({ path, _ ->
            subsection("Metrics for model \"${path.asFile().lastFolderAndFilename()}\"")
        }) { _, microservice, microserviceIdentifier ->
            item("Microservice: ${microservice.qualifiedName}")
            wsicMetric(microservice, microserviceIdentifier)
        }
    }

    /**
     * Handle the calculation of metrics that concern all service models
     */
    private fun overallMetrics() {
        subsection("Overall Metrics")
        nosMetric()
        blankLine()
        ssMetric()
        blankLine()
        scpMetric()
        blankLine()
        novsMetric()
    }

    /**
     * Calculate the Number of Services metric
     */
    private fun nosMetric() {
        val numberOfServicesResult = analyzer.numberOfServices()

        item("Metric NoS: Number of Services")
        itemItem(numberOfServicesResult.numberOfServices, "# Microservices")

        ValueStore["${VALUE_STORE_PREFIX}NoS"] = numberOfServicesResult.numberOfServices
    }

    /**
     * Calculate the Stateless Services metric
     */
    @Suppress("MapGetWithNotNullAssertionOperator")
    private fun ssMetric() {
        val (metricResult, statelessServices, statefulServices) = analyzer.statelessServices()
        val statelessServicesCount = statelessServices.values.sumBy { it.size }
        val statefulServicesCount = statefulServices.values.sumBy { it.size }

        item("Metric SS: Stateless Services")
        itemItem(metricResult, "Metric result (fraction of stateless services in stateless and stateful services)")

        itemItem(statelessServicesCount, "# Stateless services")
        itemItem(statefulServicesCount, "# Stateful services")

        // In verbose mode, we also print the qualified names of stateless and stateful services
        if (verboseMode) {
            loadedModels.forEach { model ->
                val modelFilename = model.filename()
                val statelessServicesForModel = statelessServices[model]!!
                val statefulServicesForModel = statefulServices[model]!!

                itemItemItem("Services for model $modelFilename")
                itemItemItemItem("Stateless services:")
                statelessServicesForModel.forEach { itemItemItemItemItem(it.qualifiedName) }

                itemItemItemItem("Stateful services:")
                statefulServicesForModel.forEach { itemItemItemItemItem(it.qualifiedName) }
            }
        }

        ValueStore["${VALUE_STORE_PREFIX}SS"] = metricResult
        ValueStore["${VALUE_STORE_PREFIX}SSStatelessServiceCount"] = statelessServicesCount
        statelessServices.forEach { (model, microservices) ->
            microservices.forEachIndexed { index, microservice ->
                ValueStore["${VALUE_STORE_PREFIX}SSStatelessService"] = microservice.qualifiedName to
                    listOf(model.filename(), (index+1).toString())
            }
        }
        ValueStore["${VALUE_STORE_PREFIX}SSStatefulServiceCount"] = statefulServicesCount
        statefulServices.forEach { (model, microservices) ->
            microservices.forEachIndexed { index, microservice ->
                ValueStore["${VALUE_STORE_PREFIX}SSStatefulService"] = microservice.qualifiedName to
                    listOf(model.filename(), (index+1).toString())
            }
        }
    }

    /**
     * Helper to get the filename of this [IntermediateServiceModel] from the [loadedModelsWithPath]
     */
    private fun IntermediateServiceModel.filename()
        = loadedModelsWithPath.entries.first { it.value == this }.key.asFile().name

    /**
     * Calculate the Service Composition Pattern metric
     */
    @Suppress("MapGetWithNotNullAssertionOperator")
    private fun scpMetric() {
        val serviceCompositionResult = analyzer.serviceCompositionPattern()
        val (metricResult, scpsResult, scpwfResult) = serviceCompositionResult
        val (_,_,_, atomicServices, structurallyCompositeServices, runtimeCompositeServices) = serviceCompositionResult
        val atomicServicesCount = atomicServices.values.sumBy { it.size }
        val structurallyCompositeServicesCount = structurallyCompositeServices.values.sumBy { it.size }
        val runtimeCompositeServicesCount = runtimeCompositeServices.values.sumBy { it.size }

        item("Metric SCP: Service Composition Pattern")
        itemItem(metricResult, "Metric result")
        itemItem(scpsResult, "SCPs metric result (fraction of structurally composed services)")
        itemItem(scpwfResult,
            "SCPwf metric result (fraction of services composed at runtime via parameter initialization)")

        itemItem(atomicServicesCount, "# Atomic services")
        itemItem(structurallyCompositeServicesCount, "# Structurally composed services")
        itemItem(runtimeCompositeServicesCount, "# Services composed at runtime via parameter initialization")

        // In verbose mode, we also print the atomic, structurally composed, and runtime composite services
        if (verboseMode) {
            loadedModels.forEach { model ->
                val modelFilename = model.filename()
                val atomicServicesForModel = atomicServices[model]!!
                val structurallyCompositeServicesForModel = structurallyCompositeServices[model]!!
                val runtimeCompositeServicesForModel = runtimeCompositeServices[model]!!

                itemItemItem("Services for model $modelFilename")
                itemItemItemItem("Atomic services:")
                atomicServicesForModel.forEach { itemItemItemItemItem(it.qualifiedName) }

                itemItemItemItem("Structurally composed services:")
                structurallyCompositeServicesForModel.forEach { itemItemItemItemItem(it.qualifiedName) }

                itemItemItemItem("Services composed at runtime via parameter initialization:")
                runtimeCompositeServicesForModel.forEach { itemItemItemItemItem(it.qualifiedName) }
            }
        }

        ValueStore["${VALUE_STORE_PREFIX}SCP"] = metricResult
        ValueStore["${VALUE_STORE_PREFIX}SCPs"] = scpsResult
        ValueStore["${VALUE_STORE_PREFIX}SCPwf"] = scpwfResult

        ValueStore["${VALUE_STORE_PREFIX}SCPAtomicServiceCount"] = atomicServicesCount
        atomicServices.forEach { (model, microservices) ->
            microservices.forEachIndexed { index, microservice ->
                ValueStore["${VALUE_STORE_PREFIX}SCPAtomicService"] = microservice.qualifiedName to
                    listOf(model.filename(), (index+1).toString())
            }
        }

        ValueStore["${VALUE_STORE_PREFIX}SCPStructurallyCompositeServiceCount"] = structurallyCompositeServicesCount
        structurallyCompositeServices.forEach { (model, microservices) ->
            microservices.forEachIndexed { index, microservice ->
                ValueStore["${VALUE_STORE_PREFIX}SCPStructurallyCompositeService"] = microservice.qualifiedName to
                    listOf(model.filename(), (index+1).toString())
            }
        }

        ValueStore["${VALUE_STORE_PREFIX}SCPRuntimeCompositeServiceCount"] = runtimeCompositeServicesCount
        runtimeCompositeServices.forEach { (model, microservices) ->
            microservices.forEachIndexed { index, microservice ->
                ValueStore["${VALUE_STORE_PREFIX}SCPRuntimeCompositeService"] = microservice.qualifiedName to
                    listOf(model.filename(), (index+1).toString())
            }
        }
    }

    /**
     * Calculate the Number of Versions per Service metric
     */
    @Suppress("MapGetWithNotNullAssertionOperator")
    private fun novsMetric() {
        val (metricResult, versionsPerModelAndService) = analyzer.numberOfVersions()

        item("Metric NOVS: Number of Versions per Service")
        itemItem(metricResult, "Metric result (average number of versions per microservice)")

        // In verbose mode we also print the versions per microservice
        if (verboseMode) {
            loadedModels.forEach { model ->
                val modelFilename = model.filename()
                val versionsOfModel = versionsPerModelAndService[model]!!

                itemItemItem("Versions for model $modelFilename")
                versionsOfModel.forEach { (microservice, versions) ->
                    itemItemItemItem("Microservice ${microservice.qualifiedName}:")
                    versions.forEach { itemItemItemItemItem(it) }
                }
            }
        }

        ValueStore["${VALUE_STORE_PREFIX}NOVS"] = metricResult
        versionsPerModelAndService.forEach { (model, versionsOfModel) ->
            val modelIdentifier = model.filename()
            versionsOfModel.forEach { (microservice, versions) ->
                val microserviceIdentifier = microservice.simpleName()
                versions.forEachIndexed { index, version ->
                    ValueStore["${VALUE_STORE_PREFIX}NOVSVersions"] = version to
                        listOf(modelIdentifier, microserviceIdentifier, (index + 1).toString())
                }
            }
        }
    }

    /**
     * Calculate the Weighted Service Interface and Operation Count metric for the given [microservice]
     */
    private fun wsicMetric(microservice: IntermediateMicroservice, microserviceIdentifier: String) {
        val wsicInterfaces = analyzer.weightedInterfaceCount(microservice)
        val wsicOperations = analyzer.weightedOperationCount(microservice)

        itemItem("Metric WSIC: Weighted Service Interface and Operation Count")
        itemItemItem(wsicInterfaces, "# Exposed interfaces (unweighted WSIC)")
        itemItemItem(wsicOperations, "# Exposed operations (unweighted WSIC)")

        ValueStore["${VALUE_STORE_PREFIX}WSICInterfaces"] = wsicInterfaces to listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}WSICOperations"] = wsicOperations to listOf(microserviceIdentifier)
        ValueStore["${VALUE_STORE_PREFIX}WSICUnweightedInterfaceCount"] = wsicInterfaces.toInt()
        ValueStore["${VALUE_STORE_PREFIX}WSICUnweightedOperationCount"] = wsicOperations.toInt()
    }
}