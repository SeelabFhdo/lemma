package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla.NumberOfServicesResult
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla.NumberOfVersionsResult
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla.ServiceCompositionResult
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla.StatelessServicesResult
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

/**
 * Calculate metrics from the suite of [Hirzalla et al.](https://link.springer.com/chapter/10.1007/978-3-642-01247-1_5).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface HirzallaMetricsAnalyzerI : AnalyzerI {
    /**
     * Count the number of microservices. The [NumberOfServicesResult] will inform about the total number of
     * microservices as well as the number of services per model.
     */
    fun numberOfServices() : NumberOfServicesResult

    /**
     * Count the number of microservice versions. The [NumberOfVersionsResult] will inform about the average number of
     * versions per microservice, and the versions per microservice and service model.
     */
    fun numberOfVersions() : NumberOfVersionsResult

    /**
     * Calculate the Service Composition Pattern (SCP) metric. The resulting [ServiceCompositionResult] clusters the SCP
     * metric together with the SCPs and SCPwf metrics. Furthermore, it identifies, atomic, structurally composite, and
     * runtime composite microservices.
     */
    fun serviceCompositionPattern() : ServiceCompositionResult

    /**
     * Calculate the Stateless Services metric. The [StatelessServicesResult] comprises the metric itself, and also all
     * stateless and stateful microservices per service model.
     */
    fun statelessServices() : StatelessServicesResult

    /**
     * Calculate the Weighted Service Interface Count metric. This method does not employ any weight and its result is
     * thus equivalent to the number of exposed interfaces of the given [microservice].
     */
    fun weightedInterfaceCount(microservice: IntermediateMicroservice) : Double

    /**
     * Calculate the Weighted Service Interface Count metric. The method will invoke the provided
     * [calculateWeightMeasure] lambda to calculate the weight.
     */
    fun weightedInterfaceCount(microservice: IntermediateMicroservice,
        calculateWeightMeasure: (IntermediateMicroservice) -> Double) : Double

    /**
     * Calculate the Weighted Service Interface Count metric, but for microservice operations. This method does not
     * employ any weight and its result is thus equivalent to the number of exposed operations of the given
     * [microservice].
     */
    fun weightedOperationCount(microservice: IntermediateMicroservice) : Double

    /**
     * Calculate the Weighted Service Interface Count metric, but for microservice operations. The method will invoke
     * the provided [calculateWeightMeasure] lambda to calculate the weight.
     */
    fun weightedOperationCount(microservice: IntermediateMicroservice,
        calculateWeightMeasure: (IntermediateMicroservice) -> Double) : Double
}