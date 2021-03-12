package de.fhdo.lemma.visualizer.processor

import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import org.jgrapht.Graph
import org.jgrapht.nio.Attribute
import org.jgrapht.nio.AttributeType
import org.jgrapht.nio.DefaultAttribute
import java.io.StringWriter
import org.jgrapht.nio.dot.DOTExporter
import java.io.Writer
import java.util.*

class GraphUtil {
    companion object {
        fun exportDotFromGraph(serviceGraph: Graph<MicroserviceVertex, MicroserviceEdge>): String {
            val exporter: DOTExporter<MicroserviceVertex, MicroserviceEdge> = DOTExporter(
                //Lambda which functions as id provider for the vertexes
                {v -> "\"${v.name}\""}
            )
            //Lambda for decorating the vertices with attributes
            val vertexAttributeProvider : (MicroserviceVertex) -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes.put("label", DefaultAttribute(("<i>&laquo;${it.type.toString()}&raquo;</i><br/><b>${it.name}</b>"), AttributeType.HTML))
                attributes.put("type", DefaultAttribute.createAttribute(it.type.toString()))
                attributes.put("shape", DefaultAttribute.createAttribute("rectangle"))
                attributes.put("style", DefaultAttribute.createAttribute("solid"))
                val color = when(it.type) {
                    "FUNCTIONAL" -> "blue"
                    "INFRASTRUCTURE" -> "deeppink"
                    "UTILITY" -> "purple"
                    else -> "red"
                }
                attributes.put("color", DefaultAttribute.createAttribute(color))
                //attributes.put("fontsize", DefaultAttribute.createAttribute(12))
                // Sadly the chosen font name is plattform dependent
                // See https://graphviz.org/doc/info/attrs.html#d:fontname
                // On UNIX and Mac systems the default should be Quartz
                attributes.put("fontname", DefaultAttribute.createAttribute("Roboto"))
                //last part of a lambda is always considered its return value
                attributes }

            //Lambda for decorating the edges with attributes
            val edgeAttributeProvider : (MicroserviceEdge) -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes.put("type", DefaultAttribute.createAttribute(it.label))
                //last part of a lambda is always considered its return value
                attributes }

            //Lambda for decorating the graph with attributes
            val graphAttributeProvider : () -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes.put("rankdir", DefaultAttribute.createAttribute("LR"))
                //last part of a lambda is always considered its return value
                attributes }
            //TODO Es gibt auch ID Provider die ich für edges nutzen könnte
            // Settings the previously defined functions as new providers for the exporter
            exporter.setVertexAttributeProvider(vertexAttributeProvider)
            exporter.setEdgeAttributeProvider(edgeAttributeProvider)
            exporter.setGraphAttributeProvider(graphAttributeProvider)
            val writer: Writer = StringWriter()
            exporter.exportGraph(serviceGraph, writer)
            return writer.toString()
        }
    }
}