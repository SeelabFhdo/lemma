package de.fhdo.lemma.analyzer.lib.impl.service.basic

import de.fhdo.lemma.analyzer.lib.analyzers.ServiceBasicAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.toCommunicationTypeLiteral
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType

/**
 * Implementation of basic analyses on service models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ServiceBasicAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    ServiceBasicAnalyzerI {
    override fun countMicroservices() = Cache.allMicroservices().count()

    override fun countInterfaces() = Cache.allInterfaces().count()

    override fun getLargestInterfaceByOperations() = getLargestInterfaceByOperations(Cache.allInterfaces())

    override fun getLargestInterfaceByOperations(interfaces: Iterable<IntermediateInterface>)
        : Pair<IntermediateServiceModel, IntermediateInterface>? {
        val largestInterface = interfaces.maxByOrNull { it.operations.count() } ?: return null
        val model = largestInterface.microservice.serviceModel
        return model to largestInterface
    }

    override fun getOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        = Cache.allOperationsWithProtocol(communicationType, protocolName)

    override fun getReferredOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        = Cache.allReferredOperationsWithProtocol(communicationType, protocolName)

    override fun countOperations() = Cache.allInterfaces().sumBy { it.operations.size }

    override fun countAsynchronousOperations() = countAsynchronousOperations(Cache.allOperations())

    override fun countAsynchronousOperations(operations: Iterable<IntermediateOperation>)
        = operations.count { operation ->
            operation.parameters.any { it.communicationType == CommunicationType.ASYNCHRONOUS.name } &&
            !operation.parameters.any { it.communicationType == CommunicationType.SYNCHRONOUS.name }
        }

    override fun countAsynchronousOperationsForInterfaces(interfaces: List<IntermediateInterface>)
        = countAsynchronousOperations(interfaces.map { it.operations }.flatten())

    override fun countSynchronousOperations() = countSynchronousOperations(Cache.allOperations())

    override fun countSynchronousOperations(operations: Iterable<IntermediateOperation>)
        = operations.count { operation ->
            // Implicitly consider operations without parameters as synchronous
            !operation.parameters.any { it.communicationType == CommunicationType.ASYNCHRONOUS.name }
        }

    override fun countSynchronousOperationsForInterfaces(interfaces: List<IntermediateInterface>)
        = countSynchronousOperations(interfaces.map { it.operations }.flatten())

    override fun getEffectiveProtocols() : Set<Triple<String, String, CommunicationType>> {
        val uniqueProtocolFormatCombinations = mutableSetOf<String>()
        val result = mutableSetOf<Triple<String, String, CommunicationType>>()

        for (p in Cache.allEffectiveProtocols()) {
            val protocolFormatIdentifier = "${p.protocol}$$${p.dataFormat}"
            if (protocolFormatIdentifier in uniqueProtocolFormatCombinations)
                continue

            result.add(Triple(p.protocol, p.dataFormat, p.communicationType.toCommunicationTypeLiteral()))
            uniqueProtocolFormatCombinations.add(protocolFormatIdentifier)
        }

        return result
    }
}