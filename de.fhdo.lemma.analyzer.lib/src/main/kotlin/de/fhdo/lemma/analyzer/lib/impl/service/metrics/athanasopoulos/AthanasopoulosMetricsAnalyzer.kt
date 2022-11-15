package de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos

import de.fhdo.lemma.analyzer.lib.analyzers.AthanasopoulosMetricsAnalyzerI
import de.fhdo.lemma.analyzer.lib.extractDomainTerms
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import org.jgrapht.Graph
import org.jgrapht.GraphMapping
import org.jgrapht.alg.isomorphism.VF2SubgraphIsomorphismInspector
import java.lang.IllegalArgumentException

private typealias SimilarityFunctionWithExchangePatterns
    = (IntermediateOperation, IntermediateOperation, CommunicationType, exchangePatterns: Set<ExchangePattern>)
        -> SimilarityFunctionWithExchangePatternsReturnValue
private typealias SimilarityFunctionWithExchangePatternsReturnValue
    = Triple<Double, MessageLevelGraph, MessageLevelGraph>

/**
 * Implementation of metrics calculation for the suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class AthanasopoulosMetricsAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    AthanasopoulosMetricsAnalyzerI {
    override fun calculateMessageLevelCohesionLack(iface: IntermediateInterface, communicationType: CommunicationType)
        = InterfaceLevelGraph(iface, communicationType) { op1, op2, ct ->
            calculateSimilarity(op1, op2, ct, ::calculateMessageSimilarity)
        }

    /**
     * Helper to calculate a similarity value between two [IntermediateOperation]s based on their parameters with the
     * given [communicationType]. The [similarityFunction] lambda implements the similarity calculation.
     */
    private fun calculateSimilarity(op1: IntermediateOperation, op2: IntermediateOperation,
        communicationType: CommunicationType, similarityFunction: SimilarityFunctionWithExchangePatterns)
        : Pair<Double, List<MessageLevelGraph>> {
        val graphs = mutableListOf<MessageLevelGraph>()

        // Calculate the input similarity and message-level graphs by means of the similarity function lambda
        val (inputSimilarity, inputGraph1, inputGraph2) = similarityFunction(op1, op2, communicationType,
            setOf(ExchangePattern.IN, ExchangePattern.INOUT))
        graphs.add(inputGraph1)
        graphs.add(inputGraph2)

        // Calculate the output similarity and message-level graphs by means of the similarity function lambda
        val (outputSimilarity, outputGraph1, outputGraph2) = similarityFunction(op1, op2, communicationType,
            setOf(ExchangePattern.OUT, ExchangePattern.INOUT))
        graphs.add(outputGraph1)
        graphs.add(outputGraph2)

        // Calculate the similarity value of both operations as the average of their input and output similarity
        val similarity = (inputSimilarity + outputSimilarity) / 2.0
        return similarity to graphs
    }

    /**
     * Implementation of message similarity calculation
     */
    @Suppress("INACCESSIBLE_TYPE")
    private fun calculateMessageSimilarity(op1: IntermediateOperation, op2: IntermediateOperation,
        communicationType: CommunicationType, exchangePatterns: Set<ExchangePattern>)
        : SimilarityFunctionWithExchangePatternsReturnValue {
        /*
         * Calculate the message-level graphs of the operations for the given communication type and exchange patterns.
         * Next, calculate all isomorphism mappings between the graphs and find the mapping with the maximum count of
         * vertices according to the metrics suite.
         */
        val graph1 = MessageLevelGraph(op1, communicationType, exchangePatterns)
        val graph2 = MessageLevelGraph(op2, communicationType, exchangePatterns)
        val inspector = VF2SubgraphIsomorphismInspector(graph1, graph2)
        val maximumSubgraphVertexCount = inspector.mappings.asSequence().maximumMappingVertexCount(graph1)

        /*
         * The similarity value is the vertex count of the largest isomorphism subgraph mapping divided by the number of
         * all unique vertices in the message-level graphs. In fact, the value constitutes the share of isomorphic
         * vertices in all message-level graph vertices.
         */
        val uniqueVertices = graph1.vertexSet().map { it.label }.toMutableSet()
        uniqueVertices.addAll(graph2.vertexSet().map { it.label })
        val similarity = maximumSubgraphVertexCount / uniqueVertices.size.toDouble()
        return Triple(similarity, graph1, graph2)
    }

    /**
     * Helper to find the [GraphMapping] with the maximum number of vertices from this [Sequence] of [GraphMapping]s
     */
    private fun <E> Sequence<GraphMapping<LevelGraphVertex, E>>
        .maximumMappingVertexCount(graph: Graph<LevelGraphVertex, E>) = map { mapping ->
            graph.vertexSet().count { vertex ->
                val correspondingVertex = mapping.getVertexCorrespondence(vertex, true)
                correspondingVertex != null && correspondingVertex.label == vertex.label
            }
        }.maxOrNull() ?: 0

    override fun calculateConversationLevelCohesionLack(iface: IntermediateInterface,
        communicationType: CommunicationType)
            = InterfaceLevelGraph(iface, communicationType) { op1, op2, ct ->
                calculateSimilarity(op1, op2, ct, ::calculateConversationSimilarity)
            }

    /**
     * Implementation of conversation similarity calculation
     */
    @Suppress("INACCESSIBLE_TYPE")
    private fun calculateConversationSimilarity(op1: IntermediateOperation, op2: IntermediateOperation,
        communicationType: CommunicationType, op1ExchangePatterns: Set<ExchangePattern>)
        : SimilarityFunctionWithExchangePatternsReturnValue {
        val graph1 = MessageLevelGraph(op1, communicationType, op1ExchangePatterns)

        // Calculate the second graph as the message-level graph with the exchange patterns opposite to those of the
        // first graph. Consider the first graph to represent an incoming message-level graph. In this case the second
        // graph will be the outgoing message-level graph and the similarity of two interfaces in the interface-level
        // graph is determined by the similarity of the first one's incoming messages to the second one's outgoing
        // messages.
        val op2ExchangePatterns = op1ExchangePatterns.oppositePatterns()
        val graph2 = MessageLevelGraph(op2, communicationType, op2ExchangePatterns)

        val inspector = VF2SubgraphIsomorphismInspector(graph1, graph1, { v1, v2 -> v1.label.compareTo(v2.label) },
            null)
        val maximumSubgraphVertexCount = inspector.mappings.asSequence().maximumMappingVertexCount(graph1)
        val uniqueVertices = graph1.vertexSet().map { it.label }.toMutableSet()
        uniqueVertices.addAll(graph2.vertexSet().map { it.label })
        val similarity = maximumSubgraphVertexCount / uniqueVertices.size.toDouble()
        return Triple(similarity, graph1, graph2)
    }

    /**
     * Determine the opposite [ExchangePattern]s of this [Set] of [ExchangePattern]s. For instance, for the
     * [ExchangePattern] [Set] (IN, INOUT) this method will return (OUT, INOUT).
     */
    private fun Set<ExchangePattern>.oppositePatterns()
        = when {
            ExchangePattern.IN in this && ExchangePattern.OUT !in this ->
                setOf(ExchangePattern.OUT, ExchangePattern.INOUT)
            ExchangePattern.OUT in this && ExchangePattern.IN !in this ->
                setOf(ExchangePattern.IN, ExchangePattern.INOUT)
            else -> throw IllegalArgumentException("Opposite exchange patterns not determinable from set " +
                "[${this.joinToString { ", " }}]: Set is empty or already contains opposites")
    }

    override fun calculateDomainLevelCohesionLack(iface: IntermediateInterface)
        = InterfaceLevelGraph(iface, ::calculateDomainSimilarity)

    /**
     * Implementation of domain similarity calculation
     */
    private fun calculateDomainSimilarity(op1: IntermediateOperation, op2: IntermediateOperation)
        : Pair<Double, List<OperationLevelGraph>> {
        val op1Terms = op1.name.extractDomainTerms(false).toSet()
        val op2Terms = op2.name.extractDomainTerms(false).toSet()
        val jaccardSimilarity = op1Terms.intersect(op2Terms).size.toDouble() / op1Terms.union(op2Terms).size
        return jaccardSimilarity to emptyList()
    }
}