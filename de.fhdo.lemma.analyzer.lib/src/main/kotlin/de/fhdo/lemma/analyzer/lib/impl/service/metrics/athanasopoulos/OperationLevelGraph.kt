package de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos

import de.fhdo.lemma.service.intermediate.IntermediateOperation
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.DefaultUndirectedWeightedGraph
import org.jgrapht.nio.dot.DOTExporter
import java.io.StringWriter

/**
 * Abstract class for operation-level graphs. In the metrics suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104) there exists no direct definition of the notion
 * of operation-level graph. Instead, the [OperationLevelGraph] is the base class for graph on the level of a service
 * interface's operations like [MessageLevelGraph]. The abstract class specifies reusable methods for its concrete
 * implementations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class OperationLevelGraph(val operation: IntermediateOperation)
    : DefaultUndirectedWeightedGraph<LevelGraphVertex, DefaultEdge>(DefaultEdge::class.java) {
    /**
     * Return a [String] representation of this [InterfaceLevelGraph] in GraphViz's DOT format
     */
    override fun toString(): String {
        val exporter = DOTExporter<LevelGraphVertex, DefaultEdge>()
        exporter.setVertexAttributeProvider(::vertexAttributeProvider)
        val writer = StringWriter()
        exporter.exportGraph(this, writer)
        return writer.toString()
    }
}