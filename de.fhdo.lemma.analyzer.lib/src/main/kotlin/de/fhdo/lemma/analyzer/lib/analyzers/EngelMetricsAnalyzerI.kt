package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.DependencyGraph
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern

/**
 * Calculate metrics from the suite of [Engel et al.](https://link.springer.com/chapter/10.1007/978-3-319-92901-9_8).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface EngelMetricsAnalyzerI : AnalyzerI {
    /**
     * Count all microservices
     */
    fun microserviceCount() : Int

    /**
     * Count all interfaces
     */
    fun interfaceCount() : Int

    /**
     * Count all interfaces of the given [microservice]
     */
    fun interfaceCount(microservice: IntermediateMicroservice) : Int

    /**
     * Calculate the average interface count per microservice
     */
    fun averageInterfaceCountPerMicroservice() : Double

    /**
     * Count all synchronous interfaces of the given [microservice]
     */
    fun synchronousInterfaceCount(microservice: IntermediateMicroservice) : Int

    /**
     * Count all asynchronous interfaces of the given [microservice]
     */
    fun asynchronousInterfaceCount(microservice: IntermediateMicroservice) : Int

    /**
     * Count all (statically determinable) dependencies for the given [microservice], whose defining service model is
     * located at the [definingModelFilePath]
     */
    fun dependencyCount(microservice: IntermediateMicroservice, definingModelFilePath: String) : Int

    /**
     * Calculate the [DependencyGraph] for the given [microservice], whose defining service model is located at the
     * [definingModelFilePath]
     */
    fun dependencyGraph(microservice: IntermediateMicroservice, definingModelFilePath: String) : DependencyGraph

    /**
     * Count the cyclic dependencies of the given [microservice], whose defining service model is located at the
     * [definingModelFilePath]
     */
    fun cyclicDependencyCount(microservice: IntermediateMicroservice, definingModelFilePath: String) : Int

    /**
     * Calculate the interaction size of the given [IntermediateOperation] in bits based on all of its parameters with
     * the given [communicationType] and [exchangePatterns]. In case the [useOriginalTypes] flag is set to true
     * (default), the size calculation will happen based on the original types of parameters instead of their possible
     * technology-specific types.
     *
     * The method returns a [Pair], whose first component is the calculated size and whose second component is the
     * number of operation parameters considered for size calculation.
     */
    fun interactionSize(operation: IntermediateOperation, useOriginalTypes: Boolean = true,
        communicationType: CommunicationType, vararg exchangePatterns: ExchangePattern) : Pair<Int, Int>

    /**
     * Calculate the average interaction size of the given [microservice] in bits based on the parameters of all of its
     * operations with the given [communicationType] and [exchangePatterns]. In case the [useOriginalTypes] flag is set
     * to true (default), the size calculation will happen based on the original types of parameters instead of their
     * possible technology-specific types.
     */
    fun averageInteractionSize(microservice: IntermediateMicroservice, useOriginalTypes: Boolean = true,
        communicationType: CommunicationType, vararg exchangePatterns: ExchangePattern) : Double

    /**
     * Calculate the average interaction size of the given [microservice] in bits for the selected [operations] with the
     * given [communicationType] and [exchangePatterns]. In case the [useOriginalTypes] flag is set to true (default),
     * the size calculation will happen based on the original types of parameters instead of their possible
     * technology-specific types.
     */
    fun averageInteractionSize(microservice: IntermediateMicroservice, operations: List<IntermediateOperation>,
        useOriginalTypes: Boolean = true, communicationType: CommunicationType,
        vararg exchangePatterns: ExchangePattern) : Double
}