package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType

/**
 * Perform basic analyses on service models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface ServiceBasicAnalyzerI : AnalyzerI {
    /**
     * Count the number of microservices
     */
    fun countMicroservices() : Int

    /**
     * Count the number of interfaces
     */
    fun countInterfaces() : Int

    /**
     * Get the largest interface by operations. In case there is more than one interface with the same maximum number of
     * operations, the method will return only the first one it found.
     */
    fun getLargestInterfaceByOperations() : Pair<IntermediateServiceModel, IntermediateInterface>?

    /**
     * Get the largest interface by operations from the given list of [interfaces]. In case there is more than one
     * interface with the same maximum number of operations, the method will return only the first one it found.
     */
    fun getLargestInterfaceByOperations(interfaces: Iterable<IntermediateInterface>)
        : Pair<IntermediateServiceModel, IntermediateInterface>?

    /**
     * Get all [IntermediateOperation]s with the given [communicationType] and protocol of name [protocolName]
     */
    fun getOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        : Iterable<IntermediateOperation>

    /**
     * Get all [IntermediateReferredOperation]s with the given [communicationType] and protocol of name [protocolName].
     * This method considers the communication type and protocol in the referring interface and _not_ in the original
     * interface of the operation.
     */
    fun getReferredOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        : Iterable<IntermediateReferredOperation>

    /**
     * Count the number of [IntermediateOperation]s. This method does not consider [IntermediateReferredOperation]s.
     */
    fun countOperations() : Int

    /**
     * Count the number of asynchronous [IntermediateOperation]s. This method does not consider
     * [IntermediateReferredOperation]s.
     */
    fun countAsynchronousOperations() : Int

    /**
     * Count the number of asynchronous [IntermediateOperation]s in the given list of [operations]. This method does not
     * consider [IntermediateReferredOperation]s.
     */
    fun countAsynchronousOperations(operations: Iterable<IntermediateOperation>) : Int

    /**
     * Count the number of asynchronous [IntermediateOperation]s in the given list of [interfaces]. This method does not
     * consider [IntermediateReferredOperation]s.
     */
    fun countAsynchronousOperationsForInterfaces(interfaces: List<IntermediateInterface>) : Int

    /**
     * Count the number of synchronous [IntermediateOperation]s. This method does not consider
     * [IntermediateReferredOperation]s.
     */
    fun countSynchronousOperations() : Int

    /**
     * Count the number of synchronous [IntermediateOperation]s in the given list of [operations]. This method does not
     * consider [IntermediateReferredOperation]s.
     */
    fun countSynchronousOperations(operations: Iterable<IntermediateOperation>) : Int

    /**
     * Count the number of synchronous [IntermediateOperation]s in the given list of [interfaces]. This method does not
     * consider [IntermediateReferredOperation]s.
     */
    fun countSynchronousOperationsForInterfaces(interfaces: List<IntermediateInterface>) : Int

    /**
     * Get hybrid [IntermediateOperation]s that define at least one asynchronous and at least one synchronous parameter
     */
    fun getHybridOperations() : List<IntermediateOperation>

    /**
     * Get all effective protocols and data formats from all microservices, interfaces, operations, and referred
     * operations. The result will be a [Set] consisting of [Triple]s. The first component of each [Triple] is the
     * protocol name. The second component identifies the data format. The third component is the [CommunicationType] of
     * the protocol.
     */
    fun getEffectiveProtocols() : Set<Triple<String, String, CommunicationType>>
}