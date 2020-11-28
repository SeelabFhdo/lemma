package de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel

import de.fhdo.lemma.analyzer.lib.analyzers.EngelMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.impl.CacheId
import de.fhdo.lemma.analyzer.lib.impl.SERVICE_MODEL_CLASS
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern

private val OPERATION_INTERACTION_SIZE_CACHE_ID = CacheId("operationInteractionSize", SERVICE_MODEL_CLASS)

/**
 * Implementation of metrics calculation for the suite of
 * [Engel et al.](https://link.springer.com/chapter/10.1007/978-3-319-92901-9_8).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class EngelMetricsAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    EngelMetricsAnalyzerI {
    override fun microserviceCount() = Cache.allMicroservices().count()

    override fun interfaceCount() = Cache.allInterfaces().count()

    override fun interfaceCount(microservice: IntermediateMicroservice) = microservice.interfaces.count()

    override fun averageInterfaceCountPerMicroservice()
        = Cache.allInterfaces().count().toDouble() / Cache.allMicroservices().count()

    override fun synchronousInterfaceCount(microservice: IntermediateMicroservice)
        = microservice.interfaces.count { iface ->
            iface.allOperationsOfCommunicationType(CommunicationType.SYNCHRONOUS)
        }

    override fun asynchronousInterfaceCount(microservice: IntermediateMicroservice)
        = microservice.interfaces.count { iface ->
            iface.allOperationsOfCommunicationType(CommunicationType.ASYNCHRONOUS)
        }

    /**
     * Helper to get all operations of this [IntermediateInterface] with the given [communicationType]
     */
    private fun IntermediateInterface.allOperationsOfCommunicationType(communicationType: CommunicationType)
        = operations.all {
            it.protocols.any { protocol -> protocol.communicationType == communicationType.name } &&
            (
                it.parameters.isEmpty() ||
                it.parameters.all { parameter -> parameter.communicationType == communicationType.name }
            )
    }

    override fun dependencyCount(microservice: IntermediateMicroservice, definingModelFilePath: String)
        = Cache.getDependencies(microservice, definingModelFilePath).size

    override fun dependencyGraph(microservice: IntermediateMicroservice, definingModelFilePath: String)
        = Cache.getDependencyGraph(microservice, definingModelFilePath)

    override fun cyclicDependencyCount(microservice: IntermediateMicroservice, definingModelFilePath: String)
        = Cache.getDependencyGraph(microservice, definingModelFilePath).getCycleCount()

    override fun interactionSize(operation: IntermediateOperation, useOriginalTypes: Boolean,
        communicationType: CommunicationType, vararg exchangePatterns: ExchangePattern) : Pair<Int, Int> {
        val cacheSuffix = "${operation.qualifiedName}$communicationType${exchangePatterns.joinToString("_")}"
        val cacheId = OPERATION_INTERACTION_SIZE_CACHE_ID.cloneWithSuffix(cacheSuffix)

        return Cache.addOrGetCacheObject(cacheId) {
            val parameters = operation.parameters.filter { parameter ->
                parameter.communicationType == communicationType.name &&
                parameter.exchangePattern in exchangePatterns.map { it.name }
            }

            val interactionSize = parameters.sumBy {
                val type = if (useOriginalTypes) it.originalType else it.type
                type.calculateSizeInBits(useOriginalTypes)
            }
            interactionSize to parameters.count()
        }!!
    }

    override fun averageInteractionSize(
        microservice: IntermediateMicroservice,
        useOriginalTypes: Boolean,
        communicationType: CommunicationType,
        vararg exchangePatterns: ExchangePattern
    ) = averageInteractionSize(
        microservice,
        microservice.operationsWithParameterOfType(communicationType),
        useOriginalTypes,
        communicationType,
        *exchangePatterns
    )

    /**
     * Helper to get all parameters of the operations of this [IntermediateMicroservice] with the given
     * [communicationType]
     */
    private fun IntermediateMicroservice.operationsWithParameterOfType(communicationType: CommunicationType)
        = interfaces.map { iface -> iface.operations.filter {
            it.parameters.any { p -> p.communicationType == communicationType.name }
        } }.flatten()

    override fun averageInteractionSize(
        microservice: IntermediateMicroservice,
        operations: List<IntermediateOperation>,
        useOriginalTypes: Boolean,
        communicationType: CommunicationType,
        vararg exchangePatterns: ExchangePattern
    ) : Double {
        val interactionSize = operations.sumBy {
            interactionSize(it, useOriginalTypes, communicationType, *exchangePatterns).second
        }
        return operations.count().toDouble() / interactionSize
    }
}