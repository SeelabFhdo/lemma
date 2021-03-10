package de.fhdo.lemma.visualizer.graphviz

import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import org.jgrapht.Graph
import org.jgrapht.graph.SimpleGraph
import org.jgrapht.nio.Attribute
import org.jgrapht.nio.DefaultAttribute
import java.io.StringWriter
import org.jgrapht.nio.dot.DOTExporter
import java.io.Writer

class GraphUtil {
    companion object {
        fun exportDotFromGraph(serviceGraph: Graph<MicroserviceVertex, MicroserviceEdge>): String {
            val exporter: DOTExporter<MicroserviceVertex, MicroserviceEdge> = DOTExporter(
                //Lambda which functions as id provider for the vertexes
                {v -> v.name}
            )
            //Lambda for decorating the vertices with attributes
            val vertexAttributeProvider : (MicroserviceVertex) -> Map<String, Attribute> = {
                val attributes = LinkedHashMap<String, Attribute>()
                attributes.put("type", DefaultAttribute.createAttribute(it.type.toString()))
                attributes.put("anotherTest", DefaultAttribute.createAttribute("justtesting"))
                //last part of a lambda is always considered its return value
                attributes }
            //Lambda for decorating the edges with attributes
            val edgeAttributeProvider : (MicroserviceEdge) -> Map<String, Attribute> = {
                val attributes = LinkedHashMap<String, Attribute>()
                attributes.put("type", DefaultAttribute.createAttribute(it.label))
                //last part of a lambda is always considered its return value
                attributes }

            //TODO Es gibt auch ID Provider die ich für edges nutzen könnte
            exporter.setVertexAttributeProvider(vertexAttributeProvider)
            exporter.setEdgeAttributeProvider(edgeAttributeProvider)
            val writer: Writer = StringWriter()
            exporter.exportGraph(serviceGraph, writer)
            return writer.toString()
        }
    }
}