package de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla

import de.fhdo.lemma.analyzer.lib.analyzers.HirzallaMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.HttpMethod
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.HttpMethodOverview
import de.fhdo.lemma.analyzer.lib.divideBy
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

// Stateful methods according to https://tools.ietf.org/html/rfc7231#section-4.3
private val STATEFUL_HTTP_METHODS = setOf(HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.POST, HttpMethod.PUT)

/**
 * Implementation of metrics calculation for the suite of
 * [Hirzalla et al.](https://link.springer.com/chapter/10.1007/978-3-642-01247-1_5).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class HirzallaMetricsAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    HirzallaMetricsAnalyzerI {
    override fun numberOfServices() : NumberOfServicesResult {
        val servicesPerModel = models.associateWith { it.microservices.count() }
        return NumberOfServicesResult(servicesPerModel.values.sum(), servicesPerModel)
    }

    override fun numberOfVersions() : NumberOfVersionsResult {
        val allProductiveServices = Cache.allMicroservices().filter { it.visibility != Visibility.INTERNAL.name }
        val versionsPerService = allProductiveServices.associateWith { mutableSetOf<String>() }
        allProductiveServices.forEach {
            val version = it.version ?: "No explicit version specified"
            @Suppress("MapGetWithNotNullAssertionOperator")
            versionsPerService[it]!!.add(version)
        }
        val allVersionsCount = versionsPerService.values.flatten().count()
        val averageVersionsPerMicroservice = allVersionsCount.divideBy(allProductiveServices.size)

        val servicesAndVersionsPerModel = models.associateWith {
            mutableMapOf<IntermediateMicroservice, Set<String>>()
        }.toMutableMap()
        versionsPerService.forEach { (service, versions) ->
            servicesAndVersionsPerModel[service.serviceModel]!![service] = versions
        }

        return NumberOfVersionsResult(averageVersionsPerMicroservice, servicesAndVersionsPerModel)
    }

    override fun serviceCompositionPattern(): ServiceCompositionResult {
        val atomicServices = getAtomicServices()
        val runtimeComposedServices = getRuntimeComposedServices()
        val structurallyComposedServices = getStructurallyComposedServices(atomicServices, runtimeComposedServices)

        // AS
        val atomicServiceCount = atomicServices.size
        // CSwf
        val runtimeComposedServiceCount = runtimeComposedServices.size
        // CSs
        val structurallyComposedServiceCount = structurallyComposedServices.size
        // CS
        val compositeServiceCount = runtimeComposedServiceCount + structurallyComposedServiceCount
        // SCP = CS / (AS + CSs + CSwf)
        val scpMetricResult = compositeServiceCount.divideBy(
            atomicServiceCount + structurallyComposedServiceCount + runtimeComposedServiceCount
        )
        // SCPs = CSs / (AS + CSs)
        val scpsMetricResult = structurallyComposedServiceCount.divideBy(
            atomicServiceCount + structurallyComposedServiceCount
        )
        // SCPwf = CSwf / (AS + CSwf)
        val scpwfMetricResult = runtimeComposedServiceCount.divideBy(atomicServiceCount + runtimeComposedServiceCount)

        return ServiceCompositionResult(scpMetricResult, scpsMetricResult, scpwfMetricResult, atomicServices.perModel(),
            structurallyComposedServices.perModel(), runtimeComposedServices.perModel())
    }

    /**
     * Get all atomic microservices. An atomic microservice is a microservice that does not require other microservices,
     * interfaces, or operations.
     */
    private fun getAtomicServices()
        = Cache.allMicroservices().filter {
                it.requiredMicroservices.isEmpty() &&
                it.requiredInterfaces.isEmpty() &&
                it.requiredOperations.isEmpty()
            }

    /**
     * Get all runtime-composed microservices. A runtime-composed microservice is a microservice, of which at least one
     * operation parameter will be initialized at runtime from the execution of another microservice's operation.
     */
    private fun getRuntimeComposedServices()
        = Cache.allOperations().filter { operation ->
                operation.parameters.any { it.initializedByOperation?.localOperation != null }
            }.map { it.`interface`.microservice }

    /**
     * Get all structurally composed microservices. A structurally composed microservice is a microservice that is
     * neither an atomic nor a runtime-composed microservice.
     */
    private fun getStructurallyComposedServices(atomicServices: List<IntermediateMicroservice>,
        runtimeComposedServices: List<IntermediateMicroservice>)
        = Cache.allMicroservices().filter {
                it !in atomicServices && it !in runtimeComposedServices
            }

    /**
     * Helper to retrieve a [Map] that clusters each [IntermediateMicroservice] in this list per its defining
     * [IntermediateServiceModel].
     */
    private fun List<IntermediateMicroservice>.perModel()
        : Map<IntermediateServiceModel, List<IntermediateMicroservice>> {
        val servicesPerModel = models.associateWith { mutableListOf<IntermediateMicroservice>() }
        forEach {
            @Suppress("MapGetWithNotNullAssertionOperator")
            servicesPerModel[it.serviceModel]!!.add(it)
        }
        return servicesPerModel
    }

    override fun statelessServices() : StatelessServicesResult {
        val statelessServices = getStatelessServices()
        val statelessServicesPerModel = statelessServices.perModel()

        val statefulServices = getStatefulServices(statelessServices)
        val statefulServicesPerModel = statefulServices.perModel()

        val statelessServicesCount = statelessServices.count()
        val statefulServicesCount = statefulServices.count()
        val servicesSum = statelessServicesCount + statefulServicesCount
        val metricResult = if (servicesSum != 0) statelessServicesCount.toDouble() / servicesSum else 0.0

        return StatelessServicesResult(metricResult, statelessServicesPerModel, statefulServicesPerModel)
    }

    /**
     * Get all stateless microservices. A stateless microservice is a microservice, of which all operations exhibit one
     * or more [STATEFUL_HTTP_METHODS].
     */
    private fun getStatelessServices() : List<IntermediateMicroservice> {
        val statelessServices = mutableListOf<IntermediateMicroservice>()
        for (microservice in Cache.allMicroservices()) {
            val operations = Cache.getUnifiedOperations(microservice)
            val httpMethodOverview = HttpMethodOverview(operations)

            // We can only determine the statelessness of a microservice according to the metric, when all of its
            // operations have HTTP methods or the microservice does not have any operations at all (and thus no HTTP
            // methods; see below)
            if (httpMethodOverview.operationsWithHttpMethods.size != operations.size)
                continue

            // If operations are empty, this returns true, which is correct, because the state of a hypothetical
            // microservice without operations cannot be manipulated
            val hasNoStatefulMethods = operations.all { operation ->
                val httpMethods = httpMethodOverview.getHttpMethods(operation)
                httpMethods.all { it !in STATEFUL_HTTP_METHODS }
            }

            if (hasNoStatefulMethods)
                statelessServices.add(microservice)
        }
        return statelessServices
    }

    /**
     * Get all stateful microservices as the list of microservices that are not stateful
     */
    private fun getStatefulServices(statelessServices: List<IntermediateMicroservice>)
        = Cache.allMicroservices().filter { it !in statelessServices }

    override fun weightedInterfaceCount(microservice: IntermediateMicroservice)
        = microservice.interfaces.count {
            it.visibility != Visibility.INTERNAL.name &&
            it.visibility != Visibility.IN_MODEL.name
        }.toDouble()

    override fun weightedInterfaceCount(microservice: IntermediateMicroservice,
        calculateWeightMeasure: (IntermediateMicroservice) -> Double)
        = weightedInterfaceCount(microservice) / calculateWeightMeasure(microservice)

    override fun weightedOperationCount(microservice: IntermediateMicroservice)
        = microservice.interfaces.map{ it.operations }.flatten().count {
            it.visibility != Visibility.INTERNAL.name
        }.toDouble()

    override fun weightedOperationCount(microservice: IntermediateMicroservice,
        calculateWeightMeasure: (IntermediateMicroservice) -> Double)
        = weightedOperationCount(microservice) / calculateWeightMeasure(microservice)
}