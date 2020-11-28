@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel

import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.nio.DefaultAttribute
import org.jgrapht.nio.dot.DOTExporter
import java.io.StringWriter

/**
 * Class to represent a microservice dependency graph for the metrics suite of
 * [Engel et al.](https://link.springer.com/chapter/10.1007/978-3-319-92901-9_8). The dependency graph is a directed
 * unweighted graph. Microservices become vertices that point to the microservices they depend on by means of directed
 * edges. The [DependencyGraph] also tracks dependency cycles.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate", "CanBeParameter", "unused")
class DependencyGraph(val microservice: IntermediateMicroservice, val serviceModelFilePath: String)
    : DefaultDirectedGraph<DependencyGraphVertex, DefaultEdge>(DefaultEdge::class.java) {
    private val rootCycles = mutableListOf<List<DependencyGraphVertex>>()
    val rootVertex: DependencyGraphVertex

    /**
     * Initialization
     */
    init {
        rootVertex = addVertex(microservice, serviceModelFilePath)
        rootVertex.addDependencyVertices()
    }

    /**
     * Add a new microservice vertex. The [predecessor] parameter identifies the possible dependent microservice of the
     * given [microservice].
     */
    private fun addVertex(microservice: IntermediateMicroservice, serviceModelFilePath: String,
        predecessor: DependencyGraphVertex? = null) : DependencyGraphVertex {
        val vertex = DependencyGraphVertex(microservice.qualifiedName, serviceModelFilePath, predecessor)
        addVertex(vertex)

        if (predecessor != null)
            addEdge(predecessor, vertex)

        return vertex
    }

    /**
     * Add the dependent microservices for the microservice represented by this [DependencyGraphVertex]
     */
    private fun DependencyGraphVertex.addDependencyVertices() {
        Cache.getDependencies(microservice, serviceModelFilePath).forEach {
            val dependencyVertex = addVertex(it.resolvedDependency, it.otherServiceModelFilePath, this)
            val (hasCycle, cycle) = dependencyVertex.hasCycle()
            if (!hasCycle)
                dependencyVertex.addDependencyVertices()
            else if (dependencyVertex == rootVertex)
                rootCycles.add(cycle)
        }
    }

    /**
     * Get cycles of this [DependencyGraph] detected during its construction. The result is a [List] of [List]s of
     * [DependencyGraphVertex] instances. Each nested list represents a single cycle.
     */
    fun getCycles() : List<List<DependencyGraphVertex>> = rootCycles

    /**
     * Get the count of all detected cycles
     */
    fun getCycleCount() = rootCycles.size

    /**
     * Return a [String] representation of this [DependencyGraph] in GraphViz's DOT format
     */
    override fun toString(): String {
        val exporter = DOTExporter<DependencyGraphVertex, DefaultEdge>()
        exporter.setVertexAttributeProvider { vertex ->
            mapOf("label" to DefaultAttribute.createAttribute(vertex.qualifiedMicroserviceName))
        }

        val writer = StringWriter()
        exporter.exportGraph(this, writer)
        return writer.toString()
    }
}

/**
 * Class for a vertex in the [DependencyGraph].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate")
class DependencyGraphVertex(val qualifiedMicroserviceName: String, val serviceModelFilePath: String,
    val predecessor: DependencyGraphVertex?) {
    /**
     * Check if this vertex is part of a cycle in a [DependencyGraph]
     */
    fun hasCycle() : Pair<Boolean, List<DependencyGraphVertex>> {
        val cycleVertices = mutableListOf<DependencyGraphVertex>()
        var currentPredecessor = predecessor
        while (currentPredecessor != null) {
            cycleVertices.add(currentPredecessor)
            if (this == currentPredecessor)
                return true to cycleVertices
            else
                currentPredecessor = currentPredecessor.predecessor
        }
        return false to emptyList()
    }

    override fun hashCode() = "$qualifiedMicroserviceName$$$serviceModelFilePath".hashCode()

    override fun equals(other: Any?)
        = if (this === other)
                true
            else if (other == null)
                false
            else if (other is DependencyGraphVertex) {
                qualifiedMicroserviceName == other.qualifiedMicroserviceName &&
                serviceModelFilePath == other.serviceModelFilePath
            } else
                false

    override fun toString() = qualifiedMicroserviceName
}