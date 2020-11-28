package de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos

import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import org.jgrapht.graph.DefaultUndirectedWeightedGraph
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.nio.Attribute
import org.jgrapht.nio.DefaultAttribute
import org.jgrapht.nio.dot.DOTExporter
import java.io.StringWriter
import java.math.BigDecimal

internal typealias SimilarityFunction
    = (IntermediateOperation, IntermediateOperation, CommunicationType) -> SimilarityFunctionReturnValue
internal typealias SimilarityFunctionReturnValue
    = Pair<Double, List<OperationLevelGraph>>
internal typealias SimilarityFunctionNoCommunicationType
    = (IntermediateOperation, IntermediateOperation) -> SimilarityFunctionReturnValue
typealias SimilarityEdge = Triple<IntermediateOperation, IntermediateOperation, Double>

/**
 * Implementation of an interface-level graph according to the metrics suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104). This suite defines the interface-level graph
 * of a service interface as an undirected, weighted graph. The vertices of the graph represent the interface's
 * operations. An edge connects two operation vertices iff its weight is greater zero. The weight calculation for an
 * edge between two operations happens by means of a of a similarity function. It determines the similarity (and thus
 * the edge weight) between two operations as a value in the interval [0, 1] based on certain characteristics of the
 * compared operations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class InterfaceLevelGraph private constructor(iface: IntermediateInterface)
    : DefaultUndirectedWeightedGraph<LevelGraphVertex, DefaultWeightedEdge>(DefaultWeightedEdge::class.java) {
    var iface: IntermediateInterface
        private set
    var communicationType: CommunicationType? = null
        private set
    var similarityFunction : SimilarityFunction? = null
        private set
    var similarityFunctionNoCommunicationType : SimilarityFunctionNoCommunicationType? = null
        private set

    var totalSimilarity: Double = 0.0
        private set
    var operationLevelGraphs: Map<IntermediateOperation, Set<OperationLevelGraph>> = emptyMap()
        private set
    var similarityEdges: List<SimilarityEdge> = emptyList()
        private set

    /**
     * Initialization
     */
    init {
        this.iface = iface
    }

    /**
     * Constructor for an interface-level graph whose [similarityFunction] consider [CommunicationType]s
     */
    constructor(iface: IntermediateInterface, communicationType: CommunicationType,
        similarityFunction: SimilarityFunction) : this(iface) {
        this.communicationType = communicationType
        this.similarityFunction = similarityFunction
        createGraph()
    }

    /**
     * Constructor for an interface-level graph whose [similarityFunction] does not consider [CommunicationType]s
     */
    constructor(iface: IntermediateInterface, similarityFunction: SimilarityFunctionNoCommunicationType) : this(iface) {
        similarityFunctionNoCommunicationType = similarityFunction
        createGraph()
    }

    /**
     * Create the interface-level graph including its [totalSimilarity]
     */
    private fun createGraph() {
        if (iface.operations.size == 1) {
            totalSimilarity = 1.0
            return
        }

        val visitedOperations = mutableSetOf<String>()
        val collectedOperationLevelGraphs = mutableMapOf<IntermediateOperation, MutableSet<OperationLevelGraph>>()
        val similarityEdges = mutableListOf<SimilarityEdge>()

        // Iterate over all pairs the interface's operations (op1, op2) with op1 != op2. Furthermore, we handle each
        // combination of operations, i.e., (op1, op2) and (op2, op1), only once, because the interface-level graph is
        // undirected.
        for (op1 in iface.operations) {
            for (op2 in iface.operations) {
                if (op2 == op1 || op2.name in visitedOperations)
                    continue

                // Leverage the given similarity function for the graph to calculate the similarity between the two
                // operations as well as their operation-level graphs
                val (similarity, operationLevelGraphs) = invokeSimilarityFunction(op1, op2)
                operationLevelGraphs.forEach {
                    if (it.operation !in collectedOperationLevelGraphs)
                        collectedOperationLevelGraphs[it.operation] = mutableSetOf()
                    collectedOperationLevelGraphs[it.operation]!!.add(it)
                }

                // Gather total similarity and add an edge between the two operations, in case they exhibit some sort of
                // similarity (i.e., the calculated similarity is greater zero)
                totalSimilarity += similarity
                if (similarity > 0.0)
                    similarityEdges.addSimilarityEdge(op1, op2, similarity)
            }

            visitedOperations.add(op1.name)
        }

        this.operationLevelGraphs = collectedOperationLevelGraphs
        this.similarityEdges = similarityEdges
    }

    /**
     * Helper to invoke the similarity function between two operations [op1] and [op2]. In fact, this method decides
     * which of the similarity functions to apply, i.e., the one, which consider [CommunicationType]s
     * ([similarityFunction]) or the one that does not ([similarityFunctionNoCommunicationType]). This decision depends
     * on the availability of either function, which again depends on the initialization of the interface-level graph
     * triggered by the caller.
     */
    private fun invokeSimilarityFunction(op1: IntermediateOperation, op2: IntermediateOperation)
        = when {
            similarityFunction != null -> similarityFunction!!(op1, op2, communicationType!!)
            else -> similarityFunctionNoCommunicationType!!(op1, op2)
        }

    /**
     * Add a similarity edge between [op1] and [op2] with the given [weight]
     */
    private fun MutableList<SimilarityEdge>.addSimilarityEdge(op1: IntermediateOperation, op2: IntermediateOperation,
        weight: Double) {
        val op1Vertex = LevelGraphVertex(op1)
        addVertex(op1Vertex)

        val op2Vertex = LevelGraphVertex(op2)
        addVertex(op2Vertex)

        val edge = addEdge(op1Vertex, op2Vertex)
        setEdgeWeight(edge, weight)

        add(Triple(op1, op2, weight))
        add(Triple(op2, op1, weight))
    }

    /**
     * Calculate the ideal count of edges, which for an undirected graph without self-references between vertices is
     * (|V| * (|V| -1)) / 2 with V being the set of vertices, i.e., the set of operations of the given interface.
     */
    fun idealGraphEdgeCount()
        = if (iface.operations.size > 1)
            iface.operations.size * (iface.operations.size - 1) / 2
        else
            1

    /**
     * Calculate the lack of cohesion of the interface-level graph, which is the inverted share of the [totalSimilarity]
     * in the maximum possible similarity. The maximum possible similarity is equal to the [idealGraphEdgeCount] when we
     * assume that each edge has the maximum similarity 1.
     */
    fun cohesionLack() = 1.0 - (totalSimilarity / idealGraphEdgeCount())

    /**
     * Get the similarity edges with maximum weights (i.e., the edges with maximum similarity). With the
     * [filterDuplicateEdges] flag it is possible to let the method only return one edge for both pairs of operations
     * (op1, op2) and (op2, op1), since the graph is undirected.
     */
    fun similarityEdgesWithMaxWeights(filterDuplicateEdges: Boolean = true) : List<SimilarityEdge> {
        val maxSimilarityDouble = similarityEdges.maxByOrNull { it.third }?.third ?: return emptyList()
        val maxSimilarity = BigDecimal.valueOf(maxSimilarityDouble)
        return filterSimilarityEdges(filterDuplicateEdges) {
            maxSimilarity.compareTo(BigDecimal.valueOf(it.third)) == 0
        }
    }

    /**
     * Helper to filter similarity edges. With the [predicate], it is possible to provide a generic filtering lambda.
     * Additionally, the [filterDuplicateEdges] flag enables to filter duplicate edges. That is, only one edge will be
     * contained in the list of filtered [SimilarityEdge]s for both pairs of operations (op1, op2) and (op2, op1).
     */
    private fun filterSimilarityEdges(filterDuplicateEdges: Boolean = true,
        predicate: (SimilarityEdge) -> Boolean) : List<SimilarityEdge> {
        val filteredSimilarityEdges = similarityEdges.filter(predicate)

        if (!filterDuplicateEdges)
            return filteredSimilarityEdges.toList()

        val visitedOperations = mutableSetOf<String>()
        return filteredSimilarityEdges.filter {
                val visitedIdentifier = "${it.first}::${it.second}"
                if (visitedIdentifier !in visitedOperations) {
                    visitedOperations.add(visitedIdentifier)
                    visitedOperations.add("${it.second}::${it.first}")
                    true
                } else
                    false
            }.toList()
    }

    /**
     * Get the similarity edges with minimum weights (i.e., the edges with minimum similarity). With the
     * [filterDuplicateEdges] flag it is possible to let the method only return one edge for both pairs of operations
     * (op1, op2) and (op2, op1), since the graph is undirected.
     */
    fun similarityEdgesWithMinWeights(filterDuplicateEdges: Boolean = true) : List<SimilarityEdge> {
        val minSimilarityDouble = similarityEdges.minByOrNull { it.third }?.third ?: return emptyList()
        val minSimilarity = BigDecimal.valueOf(minSimilarityDouble)
        return filterSimilarityEdges(filterDuplicateEdges) {
            minSimilarity.compareTo(BigDecimal.valueOf(it.third)) == 0
        }
    }

    /**
     * Return a [String] representation of this [InterfaceLevelGraph] in GraphViz's DOT format
     */
    override fun toString(): String {
        val exporter = DOTExporter<LevelGraphVertex, DefaultWeightedEdge>()
        exporter.setVertexAttributeProvider(::vertexAttributeProvider)
        exporter.setEdgeAttributeProvider { edge ->
            val map = mutableMapOf<String, Attribute>()
            map["label"] = DefaultAttribute.createAttribute(getEdgeWeight(edge))
            map
        }

        val writer = StringWriter()
        exporter.exportGraph(this, writer)
        return writer.toString()
    }
}