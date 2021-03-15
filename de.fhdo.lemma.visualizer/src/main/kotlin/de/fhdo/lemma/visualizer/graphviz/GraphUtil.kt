package de.fhdo.lemma.visualizer.graphviz

import de.fhdo.lemma.visualizer.model.DetailLevel
import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import de.fhdo.lemma.visualizer.model.OperationSubVertex
import org.jgrapht.Graph
import org.jgrapht.nio.Attribute
import org.jgrapht.nio.AttributeType
import org.jgrapht.nio.DefaultAttribute
import java.io.StringWriter
import org.jgrapht.nio.dot.DOTExporter

class GraphUtil {
    companion object {
        var details = DetailLevel.SERVICES
        fun exportDotFromGraph(serviceGraph: Graph<MicroserviceVertex, MicroserviceEdge>, details : DetailLevel?): String {
            if (details != null) {
                GraphUtil.details = details
            }
            val exporter: DOTExporter<MicroserviceVertex, MicroserviceEdge> = DOTExporter(
                //Lambda which functions as id provider for the vertexes
                {v -> "\"${v.qualifiedName}\""}
            )
            //Lambda for decorating the vertices with attributes
            val vertexAttributeProvider : (MicroserviceVertex) -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes.put(
                    "label", DefaultAttribute((
                        htmlLabel(it)
                        ),
                    AttributeType.HTML))
                attributes.put("type", DefaultAttribute.createAttribute(it.type))
                attributes.put("shape", DefaultAttribute.createAttribute("plaintext"))
                val color = when(it.type) {
                    "FUNCTIONAL" -> "black"
                    "INFRASTRUCTURE" -> "blue"
                    "UTILITY" -> "purple"
                    else -> "red"
                }
                attributes.put("color", DefaultAttribute.createAttribute(color))
                //attributes.put("fontsize", DefaultAttribute.createAttribute(12))
                // Sadly the chosen font name is plattform dependent
                // See https://graphviz.org/doc/info/attrs.html#d:fontname
                // On UNIX and Mac systems the default should be Quartz
                attributes["fontname"] = DefaultAttribute.createAttribute("Roboto")
                //last part of a lambda is always considered its return value
                attributes }

            //Lambda for decorating the edges with attributes
            val edgeAttributeProvider : (MicroserviceEdge) -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes["label"] = DefaultAttribute.createAttribute(it.label)
                attributes["fontname"] = DefaultAttribute.createAttribute("Roboto")
                //last part of a lambda is always considered its return value
                attributes }

            //Lambda for decorating the graph with attributes
            val graphAttributeProvider : () -> MutableMap<String, Attribute> = {
                val attributes = mutableMapOf<String, Attribute>()
                attributes["rankdir"] = DefaultAttribute.createAttribute("LR")
                //last part of a lambda is always considered its return value
                attributes }

            // Setting the previously defined functions as new providers for the exporter
            exporter.setVertexAttributeProvider(vertexAttributeProvider)
            exporter.setEdgeAttributeProvider(edgeAttributeProvider)
            exporter.setGraphAttributeProvider(graphAttributeProvider)
            val writer = StringWriter()
            exporter.exportGraph(serviceGraph, writer)
            return writer.toString()
        }
        // TODO Make the visualization more appealing.
        private fun htmlLabel(it: MicroserviceVertex): String {

            //HTML template to display the Service vertices
            return "<table bgcolor='azure2' border='1' cellborder='0'>" +
                    "<tr><td><i>&laquo;${it.type.toString().toLowerCase().capitalize()} Service&raquo;</i></td></tr>" +
                    "<tr><td>${it.visibility.visibilityHtml()} <b>${it.qualifiedName}</b></td></tr>" +
                    "${if (it.technology != null) "<tr><td>service technology {${it.technology}}</td></tr>" else ""}" +
                    (if (details.ordinal >= DetailLevel.INTERFACES.ordinal) it.interfacesHtml() else "") +
            "</table>"
        }
        private fun MicroserviceVertex.interfacesHtml(): String {
            val lines : MutableList<String> = mutableListOf()
            this.interfaces.forEach({
                lines.add("<tr><td><table bgcolor='white' cellspacing='0'><tr><td>&laquo;Interface&raquo;<br/>${it.visibility.visibilityHtml()+it.name}</td></tr>")
                if((details.ordinal >= DetailLevel.OPERATIONS.ordinal)) {
                    lines.add("<tr><td>")
                    it.operations.forEach({
                        lines.add("${it.visibility.visibilityHtml()+it.name}(${
                            if(details.ordinal >= DetailLevel.SIGNATURES.ordinal)it.paramHtml() else ""
                        })<br/>")
                    })
                    lines.add("</td></tr>")
                }
                lines.add("</table></td></tr>")
            })
            return lines.joinToString(separator="")
        }

        private fun OperationSubVertex.paramHtml(): String {
            return this.parameters.joinToString(separator="") { "( ${it.commType} ${it.name} : ${it.datatype}"}
        }

        private fun String.visibilityHtml(): String {
            return when(this) {
                "PUBLIC" -> "+"
                "INTERNAL" -> "-"
                "IN_MODEL" -> "#"
                "ARCHITECTURE" -> "#"
                else -> ""
            }
        }
    }
}

