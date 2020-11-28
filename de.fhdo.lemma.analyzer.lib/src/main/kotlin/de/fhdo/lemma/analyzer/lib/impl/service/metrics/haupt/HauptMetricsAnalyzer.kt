package de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt

import de.fhdo.lemma.analyzer.lib.analyzers.HauptMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType

/**
 * Implementation of metrics calculation for the suite of
 * [Haupt et al.](https://ieeexplore.ieee.org/abstract/document/7930199).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class HauptMetricsAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    HauptMetricsAnalyzerI {
    private val resourceGraphs = mutableMapOf<IntermediateMicroservice, HttpResourceGraph>()

    override fun countResources(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).resources.count()

    override fun getHttpResourceGraph(microservice: IntermediateMicroservice) : HttpResourceGraph {
        if (microservice !in resourceGraphs) {
            val resourceGraph = HttpResourceGraph(microservice, "rest", CommunicationType.SYNCHRONOUS)
            resourceGraphs[microservice] = resourceGraph
        }

        return resourceGraphs[microservice]!!
    }

    override fun getResourcesPerHttpMethod(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).resourcesPerHttpMethod

    override fun getRootResources(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).rootResources

    override fun getReadOnlyResources(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).readOnlyResources

    override fun getDeleteResources(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).deleteResources

    override fun getPostResources(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).postResources

    override fun getResourceLinkCount(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).linkCount

    override fun getLongestResourcePath(microservice: IntermediateMicroservice)
        = getHttpResourceGraph(microservice).longestResourcePath
}