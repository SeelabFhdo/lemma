@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos

import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern

/**
 * Implementation of a message-level graph according to the metrics suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104). This suite defines the message-level graph
 * of a service operation's message as an undirected, unweighted graph. The vertices of the graph represent parts of the
 * structure of the message. The root of the graph is the message itself. The direct root children are the message's
 * parameters. Their direct and indirect children on subsequent graph levels are the elements of the parameter types'
 * structures.
 *
 * In the context of LEMMA, the message of an operation is the entirety of its parameters of a given [CommunicationType]
 * and set of [ExchangePattern]s, e.g., all synchronous incoming parameters form a message. Therefore, the root of the
 * [MessageLevelGraph] will always be a vertex with a fixed name. The parameters of the operation with the given
 * [CommunicationType] and [ExchangePattern]s will constitute the immediate children of the root. Their children again
 * will then indicate the structure of the parameters. Currently, we only consider LEMMA [IntermediateDataStructure]s
 * and [IntermediateCollectionType]s to exhibit a structure. All other types, i.e., enumerations and primitive types,
 * will become leaves of the [MessageLevelGraph], i.e., vertices without children. Furthermore, we always consider
 * original, i.e., non-mapped, parameter types, because we can safely determine their structure if any.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class MessageLevelGraph(operation: IntermediateOperation, val communicationType: CommunicationType,
    val exchangePatterns: Set<ExchangePattern>) : OperationLevelGraph(operation) {

    /**
     * Initialization
     */
    init {
        // Add "static" root vertex
        val rootVertex = LevelGraphVertex("messageRoot")
        addVertex(rootVertex)

        // Add parameter vertices
        val messageParameters = operation.parameters.filter { parameter ->
            parameter.communicationType == communicationType.name &&
            parameter.exchangePattern in exchangePatterns.map { it.name }
        }

        messageParameters.forEach { parameter ->
            val parameterVertex = LevelGraphVertex(parameter)
            addVertex(parameterVertex)
            addEdge(parameterVertex, rootVertex)
            // Currently, we only consider original (non-mapped) complex types
            addTypeVertex(parameter.originalType, parameterVertex)
        }
    }

    /**
     * Add a vertex for an [IntermediateType] as child of the given [parent] vertex
     */
    private fun addTypeVertex(type: IntermediateType, parent: LevelGraphVertex) {
        val resolvedType = when(type) {
            is IntermediateComplexType -> Cache.getResolvedType(type)
            else -> type
        }

        val typeAlreadyExists = !addVertex(LevelGraphVertex(resolvedType))
        addEdge(LevelGraphVertex(resolvedType), parent)
        if (typeAlreadyExists)
            return

        when(resolvedType) {
            is IntermediateDataStructure -> resolvedType.dataFields.forEach {
                // Currently, we only consider original (non-mapped) complex types
                if (!it.isHidden && it.originalType is IntermediateComplexType)
                    addTypeVertex(it.originalType, LevelGraphVertex(resolvedType))
            }

            is IntermediateCollectionType -> {
                // Currently, we only consider original (non-mapped) complex types
                resolvedType.dataFields.forEach { addTypeVertex(it.originalType, LevelGraphVertex(resolvedType))  }
            }
        }
    }

    override fun hashCode()
        = "${operation.qualifiedName}::${communicationType}::${exchangePatterns.joinToString("::")}".hashCode()

    override fun equals(other: Any?)
        = if (this === other)
                true
            else if (other == null)
                false
            else if (other is MessageLevelGraph)
                operation.qualifiedName == other.operation.qualifiedName &&
                communicationType == other.communicationType &&
                exchangePatterns.size == other.exchangePatterns.size &&
                exchangePatterns.containsAll(other.exchangePatterns)
            else
                false
}