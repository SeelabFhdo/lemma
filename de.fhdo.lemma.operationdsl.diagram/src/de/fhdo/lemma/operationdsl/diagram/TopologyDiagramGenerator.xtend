package de.fhdo.lemma.operationdsl.diagram

/**
 * Generator of a PlantUML deployment diagram of a system's nodes.
 *
 * A container is a node, the microservices it deploys are artifacts inside it,
 * an infrastructure node is a node beside it, and a relation between two nodes
 * is an arrow. That is a UML deployment diagram, which is what an operation
 * model describes.
 *
 * Every node is drawn as a ``node`` stereotyped with the technology the model
 * names, rather than as one of PlantUML's semantic shapes. Mapping ``MongoDB``
 * onto a database and ``Kafka`` onto a queue is a guess from a name: an unknown
 * technology would silently lose its shape and a renamed one would lose it
 * without saying so. The stereotype says what the model says.
 *
 * The generator is a function of an [[OperationGraph]] and nothing else: no
 * file system, no workspace, no Eclipse.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class TopologyDiagramGenerator {
    static val NOTHING_DEPLOYED = "The models declare no node."

    /**
     * Generate the topology of everything the reader reached.
     *
     * Not only the models that were selected: a node relation crosses model
     * files - 34 times in this repository - so a diagram of one file could not
     * show the topology it belongs to.
     *
     * @param graph the nodes and their relations
     * @return the PlantUML source of the diagram
     */
    def String generate(OperationGraph graph) {
        val naming = new DiagramNaming(graph.nodes)

        return '''
            @startuml
            ' Generated from LEMMA operation models. Do not edit; regenerate.
            skinparam shadowing false
            skinparam componentStyle rectangle
            skinparam wrapWidth 300

            «FOR node : graph.nodes»
                «generateNode(node, naming)»
            «ENDFOR»
            «FOR node : stubs(graph, naming)»
                «node»
            «ENDFOR»
            «FOR edge : graph.edges»
                «generateEdge(edge, naming)»
            «ENDFOR»
            «IF graph.nodes.empty»
                «note(NOTHING_DEPLOYED)»
            «ENDIF»
            @enduml
        '''.toString
    }

    /**
     * One node, with the microservices it deploys inside it.
     */
    private def generateNode(NodeInfo node, DiagramNaming naming) {
        '''
        «IF node.artifacts.empty»
            node «quote(node.name)» as «naming.aliasOf(node)»«stereotype(node)»
        «ELSE»
            node «quote(node.name)» as «naming.aliasOf(node)»«stereotype(node)» {
                «FOR artifact : node.artifacts»
                    artifact «quote(artifact.name)» as «naming.artifactAliasOf(node, artifact)»
                «ENDFOR»
            }
        «ENDIF»
        '''
    }

    /**
     * One arrow, dashed where the relation could not be followed.
     *
     * Unlabelled: both forms the models use mean the same thing, and the arrow
     * already carries the direction. Which end declared it is a property of how
     * the models are split across files rather than of the system.
     */
    private def String generateEdge(NodeEdge edge, DiagramNaming naming) {
        return naming.aliasOf(edge.source)
            + (if (edge.resolved) " --> " else " ..> ")
            + naming.aliasOf(edge.target)
    }

    /**
     * Declarations for the nodes that only exist as the end of an unresolved
     * relation.
     *
     * Without them PlantUML invents a shape and labels it with the alias.
     * They have to come **before** the arrows: an arrow to an undeclared alias
     * creates the shape there and then, and declaring it afterwards is a
     * redefinition that PlantUML rejects outright.
     */
    private def Iterable<String> stubs(OperationGraph graph, DiagramNaming naming) {
        val declared = graph.nodes.map[naming.aliasOf(it)].toSet
        val stubs = newLinkedHashMap
        for (edge : graph.edges) {
            for (end : #[edge.source, edge.target]) {
                val alias = naming.aliasOf(end)
                if (!declared.contains(alias) && !stubs.containsKey(alias)) {
                    stubs.put(alias,
                        '''node «quote(end.name)» as «alias» <<unresolved>>'''.toString)
                }
            }
        }
        return stubs.values
    }

    private def String stereotype(NodeInfo node) {
        val names = <String>newLinkedList
        if (!node.technology.nullOrEmpty) {
            names.add(node.technology)
        }
        if (!node.resolved) {
            names.add("unresolved")
        }
        return if (names.empty) "" else ''' <<«names.join(", ")»>>'''.toString
    }

    private def String note(String text) {
        return "note as N" + Integer.toHexString(text.hashCode) + "\n" + text + "\nend note"
    }

    private def String quote(String name) {
        return '"' + name + '"'
    }
}
