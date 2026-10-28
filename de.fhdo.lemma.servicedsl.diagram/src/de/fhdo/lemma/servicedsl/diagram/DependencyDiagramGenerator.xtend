package de.fhdo.lemma.servicedsl.diagram

import java.util.LinkedHashMap
import java.util.List

/**
 * Generator of PlantUML component diagrams of what a system's services require
 * of each other.
 *
 * Two diagrams, because the levels LEMMA offers answer two questions. The
 * overview aggregates every dependency to one service-to-service arrow and
 * answers who calls whom. The detail diagram draws the interface or the
 * operation a dependency names and answers through what.
 *
 * Both are needed because the levels are alternatives rather than layers: a
 * system may declare ``required microservices`` for one service and ``required
 * operations`` for another, as Lakeside Mutual does. The overview reads evenly
 * across such a system; the detail diagram shows the evidence where the model
 * carries it.
 *
 * Unlike the interface diagram, both draw everything the reader reached rather
 * than only what was selected: a dependency crosses model files, so a diagram
 * of one file could never show the system.
 *
 * The generator is a function of a [[ServiceGraph]] and nothing else: no file
 * system, no workspace, no Eclipse.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DependencyDiagramGenerator {
    /**
     * Said on a diagram that would otherwise be blank.
     *
     * A system whose services require nothing of each other is a result, and an
     * empty image does not say it.
     */
    static val NOTHING_REQUIRED = "No dependencies are declared."

    /**
     * Generate the overview: one arrow per pair of services.
     *
     * Labelled with what backs it where the model is more specific than the
     * arrow - three required operations are one dependency in this picture, and
     * saying so keeps the aggregation from reading as the whole truth.
     *
     * @param graph the services and their dependencies
     * @return the PlantUML source of the diagram
     */
    def String generateOverview(ServiceGraph graph) {
        val edges = aggregate(graph)

        return '''
            @startuml
            ' Generated from LEMMA service models. Do not edit; regenerate.
            «preamble»

            «FOR service : overviewParticipants(graph)»
                «component(service)»
            «ENDFOR»
            «FOR edge : edges.values»
                «arrow(edge.source, aliasOf(edge.target), label(edge), edge.resolved)»
            «ENDFOR»
            «IF graph.dependencies.empty»
                «note(NOTHING_REQUIRED)»
            «ENDIF»
            @enduml
        '''.toString
    }

    /**
     * Generate the detail diagram: an arrow to what a dependency names.
     *
     * A service something is required of by name becomes a package of those
     * interfaces and operations. A dependency on a whole microservice points at
     * the microservice, and is drawn rather than left out: a reader would
     * otherwise take a service that requires a whole service to require
     * nothing.
     *
     * @param graph the services and their dependencies
     * @return the PlantUML source of the diagram
     */
    def String generateDetail(ServiceGraph graph) {
        val required = requiredByService(graph)
        val packaged = required.keySet.toList

        return '''
            @startuml
            ' Generated from LEMMA service models. Do not edit; regenerate.
            «preamble»

            «FOR service : plainParticipants(graph, packaged)»
                «component(service)»
            «ENDFOR»
            «FOR service : packaged»
                package «quote(service.name)»«unresolvedStereotype(service)» {
                    «IF coarselyRequired(graph, service)»
                        «component(service)»
                    «ENDIF»
                    «FOR name : required.get(service)»
                        [«name»] as «targetAlias(service, name)»
                    «ENDFOR»
                }
            «ENDFOR»
            «FOR dependency : graph.dependencies»
                «arrow(dependency.source, endOf(dependency), null, dependency.resolved)»
            «ENDFOR»
            «FOR reason : unresolvedReasons(graph)»
                «note(reason)»
            «ENDFOR»
            «IF graph.dependencies.empty»
                «note(NOTHING_REQUIRED)»
            «ENDIF»
            @enduml
        '''.toString
    }

    private def preamble() {
        '''
        skinparam shadowing false
        skinparam componentStyle rectangle
        skinparam wrapWidth 300
        '''
    }

    /**
     * Every dependency reduced to one edge per pair of services.
     */
    private def LinkedHashMap<String, AggregatedEdge> aggregate(ServiceGraph graph) {
        val edges = new LinkedHashMap<String, AggregatedEdge>
        for (dependency : graph.dependencies) {
            val key = aliasOf(dependency.source) + "->" + aliasOf(dependency.target)
            var edge = edges.get(key)
            if (edge === null) {
                edge = new AggregatedEdge(dependency.source, dependency.target)
                edges.put(key, edge)
            }
            edge.add(dependency)
        }
        return edges
    }

    /**
     * What backs an aggregated edge, or nothing when the model requires the
     * whole service and the arrow already says that.
     */
    private def String label(AggregatedEdge edge) {
        val parts = <String>newLinkedList
        if (edge.operations > 0) {
            parts.add(edge.operations + (if (edge.operations == 1) " op" else " ops"))
        }
        if (edge.interfaces > 0) {
            parts.add(edge.interfaces
                + (if (edge.interfaces == 1) " interface" else " interfaces"))
        }
        if (!edge.resolved) {
            parts.add("unresolved")
        }
        return if (parts.empty) null else parts.join(", ")
    }

    /**
     * Every service the overview draws.
     *
     * Each end of every arrow, plus the services that were asked for - a
     * selected service that requires nothing still belongs in its own diagram.
     * Both ends whatever the level: the overview aggregates to the service, so
     * the target of an operation-level dependency is a service here too. Leaving
     * it out let PlantUML invent a component and label it with the alias.
     */
    private def List<ServiceNode> overviewParticipants(ServiceGraph graph) {
        return distinct(ends(graph))
    }

    /**
     * Every service the detail diagram draws outside a package.
     */
    private def List<ServiceNode> plainParticipants(ServiceGraph graph,
        List<ServiceNode> packaged) {
        val aliases = packaged.map[aliasOf(it)].toSet
        return distinct(ends(graph)).filter[!aliases.contains(aliasOf(it))].toList
    }

    /**
     * Both ends of every dependency, and the services that were asked for.
     */
    private def List<ServiceNode> ends(ServiceGraph graph) {
        val services = <ServiceNode>newLinkedList
        services.addAll(graph.entryServices)
        for (dependency : graph.dependencies) {
            services.add(dependency.source)
            services.add(dependency.target)
        }
        return services
    }

    /**
     * What is required of each service by name: its interfaces and operations.
     *
     * A dependency on a whole microservice names nothing, so it adds no entry -
     * a service required only as a whole is drawn as a component rather than as
     * a package holding one component of the same name.
     */
    private def LinkedHashMap<ServiceNode, List<String>> requiredByService(ServiceGraph graph) {
        val required = new LinkedHashMap<ServiceNode, List<String>>
        for (dependency : graph.dependencies) {
            val name = requiredName(dependency)
            if (name !== null) {
                val service = dependency.target
                if (!required.containsKey(service)) {
                    required.put(service, <String>newLinkedList)
                }
                if (!required.get(service).contains(name)) {
                    required.get(service).add(name)
                }
            }
        }
        return required
    }

    /**
     * Whether anything requires this service as a whole.
     */
    private def boolean coarselyRequired(ServiceGraph graph, ServiceNode service) {
        return graph.dependencies.exists[
            target === service && requiredName(it) === null
        ]
    }

    /**
     * Why each dependency that could not be followed could not be.
     */
    private def List<String> unresolvedReasons(ServiceGraph graph) {
        return graph.dependencies
            .filter[!resolved && reason !== null]
            .map[source.name + " requires " + written + "\n" + reason]
            .toList
    }

    /**
     * The name of what a dependency requires, or null for a whole service.
     */
    private def String requiredName(Dependency dependency) {
        if (dependency.targetOperation !== null) {
            return dependency.targetInterface + "." + dependency.targetOperation
        }
        return dependency.targetInterface
    }

    /**
     * The alias an arrow of the detail diagram ends at.
     */
    private def String endOf(Dependency dependency) {
        val required = requiredName(dependency)
        return if (required === null)
                aliasOf(dependency.target)
            else
                targetAlias(dependency.target, required)
    }

    private def String component(ServiceNode service) {
        return "[" + service.name + "] as " + aliasOf(service)
            + unresolvedStereotype(service)
    }

    private def String unresolvedStereotype(ServiceNode service) {
        return if (service.resolved) "" else " <<unresolved>>"
    }

    /**
     * One arrow, dashed where the dependency could not be followed: a reader
     * must be able to tell what the model states from what it only names.
     */
    private def String arrow(ServiceNode source, String target, String label,
        boolean resolved) {
        return aliasOf(source) + (if (resolved) " --> " else " ..> ") + target
            + (if (label === null) "" else " : " + label)
    }

    /**
     * A floating note.
     *
     * Built by concatenation rather than as a template: a multi-line template
     * inside a method carries the indentation of the method into the output, and
     * PlantUML wants ``end note`` on a line of its own.
     */
    private def String note(String text) {
        return "note as N" + Integer.toHexString(text.hashCode) + "\n" + text
            + "\nend note"
    }

    /**
     * The name a service is referred to by inside a diagram.
     *
     * Its qualified name, because two microservices of a system may share a
     * simple name and PlantUML identifies a component by the name it is declared
     * with.
     */
    private def String aliasOf(ServiceNode service) {
        return ("svc_" + service.qualifiedName).replaceAll("[^A-Za-z0-9_]", "_")
    }

    private def String targetAlias(ServiceNode service, String required) {
        return ("req_" + service.qualifiedName + "_" + required)
            .replaceAll("[^A-Za-z0-9_]", "_")
    }

    /**
     * The services of a list, each once.
     */
    private def List<ServiceNode> distinct(List<ServiceNode> services) {
        val seen = <String>newLinkedHashSet
        val result = <ServiceNode>newLinkedList
        for (service : services) {
            if (seen.add(aliasOf(service))) {
                result.add(service)
            }
        }
        return result
    }

    private def String quote(String name) {
        return '"' + name + '"'
    }
}

/**
 * Every dependency between one pair of services, as one edge.
 */
class AggregatedEdge {
    public val ServiceNode source
    public val ServiceNode target
    var int operationCount = 0
    var int interfaceCount = 0
    var boolean allResolved = true

    new(ServiceNode source, ServiceNode target) {
        this.source = source
        this.target = target
    }

    def void add(Dependency dependency) {
        switch (dependency.level) {
            case OPERATION: operationCount++
            case INTERFACE: interfaceCount++
            case MICROSERVICE: {}
        }
        if (!dependency.resolved) {
            allResolved = false
        }
    }

    def int getOperations() {
        return operationCount
    }

    def int getInterfaces() {
        return interfaceCount
    }

    def boolean isResolved() {
        return allResolved
    }
}
