package de.fhdo.lemma.operationdsl.diagram

import java.util.List

/**
 * Generator of a PlantUML diagram of what each node of a deployment is
 * configured with.
 *
 * The topology diagram answers what is deployed where; this one answers how it
 * is configured - the `default values`, the aspects, the endpoints, the
 * operation environment and the per-service deployment specifications. They are
 * separate because the Kafka broker of
 * `examples/charging-station-management` carries fifteen default values and
 * three aspects, and one diagram holding both is dominated by whichever node is
 * configured most.
 *
 * Drawn with class shapes rather than deployment nodes: a PlantUML `node` nests
 * elements, not lines of text, and this diagram is lines of text. `hide circle`
 * takes the class marker away again, so a reader sees a box of configuration.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class NodeDetailDiagramGenerator {
    static val NOTHING_DEPLOYED = "The models declare no node."

    /**
     * Where a value is cut.
     *
     * An aspect value can be an embedded shell script - the `command` aspect of
     * `examples/charging-station-management` holds a `lenses-cli provision`
     * invocation - and one of those on a line makes the box wider than the rest
     * of the diagram together. The cut is visible, so a reader knows to look at
     * the model.
     */
    static val MAX_VALUE_LENGTH = 72
    static val ELLIPSIS = "…"

    /**
     * Generate the configuration of every node the reader reached.
     *
     * @param graph the nodes to describe
     * @return the PlantUML source of the diagram
     */
    def String generate(OperationGraph graph) {
        val naming = new DiagramNaming(graph.nodes)
        val drawn = graph.nodes.filter[resolved].toList

        return '''
            @startuml
            ' Generated from LEMMA operation models. Do not edit; regenerate.
            hide empty members
            hide circle
            skinparam shadowing false
            skinparam classAttributeIconSize 0
            skinparam wrapWidth 400

            «FOR node : drawn»
                «generateNode(node, naming)»
            «ENDFOR»
            «IF drawn.empty»
                «note(NOTHING_DEPLOYED)»
            «ENDIF»
            @enduml
        '''.toString
    }

    /**
     * One node: what it is, and everything it is configured with.
     */
    private def generateNode(NodeInfo node, DiagramNaming naming) {
        val lines = linesOf(node)
        '''
        class «quote(node.name)» as «naming.aliasOf(node)»«stereotype(node)» {
            «FOR line : lines»
                «line»
            «ENDFOR»
        }
        '''
    }

    /**
     * The configuration of a node, in the order a reader asks for it: what it
     * runs on, what it deploys, how it is set, what it answers.
     */
    private def List<String> linesOf(NodeInfo node) {
        val lines = <String>newLinkedList

        if (!node.operationEnvironment.nullOrEmpty) {
            lines.add('''environment : «node.operationEnvironment»''')
        }
        for (artifact : node.artifacts) {
            lines.add('''deploys «artifact.name»''')
        }

        separate(lines)
        for (value : node.defaultValues) {
            lines.add(truncate(value))
        }

        separate(lines)
        for (aspect : node.aspects) {
            lines.add(truncate(aspectLine(aspect)))
        }

        separate(lines)
        for (endpoint : node.endpoints) {
            lines.add(truncate(endpointLine(endpoint)))
        }

        // A separator was added before each group whether or not the group
        // turned out to have anything in it, so one may be left at the end.
        while (!lines.empty && ".." == lines.get(lines.size - 1)) {
            lines.remove(lines.size - 1)
        }

        for (specification : node.specifications) {
            separate(lines)
            lines.add('''«specification.serviceName» :''')
            for (value : specification.propertyValues) {
                lines.add('''  «truncate(value)»''')
            }
            for (endpoint : specification.endpoints) {
                lines.add('''  «truncate(endpointLine(endpoint))»''')
            }
        }
        return lines
    }

    /**
     * One aspect: its name and the values it carries.
     *
     * Not what the model wrote, which is
     * ``DockerCompose::_aspects.hostname("broker");`` - the alias and the path
     * to the aspect are the same on every line of a node and say nothing about
     * it, as with a technology.
     */
    private def String aspectLine(AspectReference aspect) {
        val written = aspect.written
        if (written === null) {
            return aspect.name ?: ""
        }
        val open = written.indexOf("(")
        if (open < 0) {
            return aspect.name ?: written
        }
        val close = written.lastIndexOf(")")
        val values = if (close > open)
                written.substring(open, close + 1)
            else
                written.substring(open)
        return (aspect.name ?: "") + values
    }

    private def String endpointLine(EndpointInfo endpoint) {
        val protocol = endpoint.protocol ?: "unspecified"
        return '''«protocol» : «endpoint.addresses.join(", ")»'''.toString
    }

    /**
     * A separator, but only between two groups that both have something in
     * them - a diagram should not show a rule above nothing.
     */
    private def void separate(List<String> lines) {
        // Indexed rather than the "last" extension: on a List that reads as
        // List.getLast(), which Java added in 21, while this bundle declares
        // JavaSE-11. A compile on a newer JDK accepts it and Eclipse does not.
        if (!lines.empty && ".." != lines.get(lines.size - 1)) {
            lines.add("..")
        }
    }

    /**
     * Cut a value that is too long for a line, visibly.
     */
    private def String truncate(String value) {
        if (value === null) {
            return ""
        }
        if (value.length <= MAX_VALUE_LENGTH) {
            return value
        }
        return value.substring(0, MAX_VALUE_LENGTH) + ELLIPSIS
    }

    private def String stereotype(NodeInfo node) {
        val names = <String>newLinkedList
        if (!node.technology.nullOrEmpty) {
            names.add(node.technology)
        }
        names.add(if (node.container) "container" else "infrastructure")
        return ''' <<«names.join(", ")»>>'''.toString
    }

    private def String note(String text) {
        return "note as N" + Integer.toHexString(text.hashCode) + "\n" + text + "\nend note"
    }

    private def String quote(String name) {
        return '"' + name + '"'
    }
}
