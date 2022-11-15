package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt.HttpResourceGraph
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt.ResourcesPerHttpMethod
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

/**
 * Calculate metrics from the suite of [Haupt et al.](https://ieeexplore.ieee.org/abstract/document/7930199).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface HauptMetricsAnalyzerI : AnalyzerI {
    /**
     * Count all REST resources of the given [microservice]
     */
    fun countResources(microservice: IntermediateMicroservice) : Int

    /**
     * Get all REST resources of the given [microservice] per HTTP method
     */
    fun getResourcesPerHttpMethod(microservice: IntermediateMicroservice) : ResourcesPerHttpMethod

    /**
     * Get the [IntermediateComplexType]s representing the root REST resources of the given [microservice]
     */
    fun getRootResources(microservice: IntermediateMicroservice) : Set<IntermediateComplexType>

    /**
     * Get the [IntermediateComplexType]s representing the read-only REST resources of the given [microservice]
     */
    fun getReadOnlyResources(microservice: IntermediateMicroservice) : Set<IntermediateComplexType>

    /**
     * Get the [IntermediateComplexType]s representing the DELETE REST resources of the given [microservice]
     */
    fun getDeleteResources(microservice: IntermediateMicroservice) : Set<IntermediateComplexType>

    /**
     * Get the [IntermediateComplexType]s representing the POST REST resources of the given [microservice]
     */
    fun getPostResources(microservice: IntermediateMicroservice) : Set<IntermediateComplexType>

    /**
     * Get the number of resource links of the given [microservice]
     */
    fun getResourceLinkCount(microservice: IntermediateMicroservice) : Int

    /**
     * Get the longest path between REST resources of the given [microservice]. The method will return the names of the
     * REST resources on the path in the order of their appearance on the path.
     */
    fun getLongestResourcePath(microservice: IntermediateMicroservice) : List<String>

    /**
     * Get the [HttpResourceGraph] of the given [microservice]
     */
    fun getHttpResourceGraph(microservice: IntermediateMicroservice) : HttpResourceGraph
}