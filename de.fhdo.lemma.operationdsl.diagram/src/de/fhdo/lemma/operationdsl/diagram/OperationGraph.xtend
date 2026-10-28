package de.fhdo.lemma.operationdsl.diagram

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The nodes of a deployment, what they hold and what they need of each other.
 *
 * Built by [[OperationModelReader]] from one or more operation models, with
 * every node reference resolved and every relation reduced to one edge per
 * fact. It exists so that no generator parses anything: resolving a relation
 * across model files and recognising that two models state the same one is the
 * hard part of drawing an operation model, it happens once, and it is testable
 * on its own.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OperationGraph {
    @Accessors(PUBLIC_GETTER)
    val List<NodeInfo> nodes = newLinkedList

    /**
     * One edge per relation, whichever end of it the models stated.
     */
    @Accessors(PUBLIC_GETTER)
    val List<NodeEdge> edges = newLinkedList

    @Accessors(PUBLIC_GETTER)
    val List<String> problems = newLinkedList

    /**
     * The models that were asked for, as opposed to those reached through their
     * imports.
     */
    @Accessors(PUBLIC_GETTER)
    val List<String> entryFiles = newLinkedList

    def void add(NodeInfo node) {
        nodes.add(node)
    }

    def void addProblem(String problem) {
        problems.add(problem)
    }

    def void addEntryFile(String file) {
        entryFiles.add(file)
    }

    def boolean isEntry(String modelFile) {
        return entryFiles.contains(modelFile)
    }

    /**
     * Add an edge, or keep the one that is already there.
     *
     * The same relation is stated from both ends in different models - a
     * container's ``depends on nodes`` and the node's own ``used by nodes`` -
     * so an edge that is already present is not added again. What it was stated
     * as is widened instead, so a relation stated both ways says so.
     */
    def void add(NodeEdge edge) {
        val existing = edges.findFirst[sameAs(edge)]
        if (existing === null) {
            edges.add(edge)
        } else {
            existing.alsoStatedAs(edge.statedAs)
        }
    }

    /**
     * The node of this name declared by this model, or null.
     */
    def NodeInfo nodeOf(String modelFile, String name) {
        return nodes.findFirst[it.modelFile == modelFile && it.name == name]
    }

    def List<NodeInfo> nodesOf(String modelFile) {
        return nodes.filter[it.modelFile == modelFile].toList
    }

    /**
     * The nodes the asked-for models declare.
     */
    def List<NodeInfo> entryNodes() {
        return nodes.filter[resolved && isEntry(modelFile)].toList
    }

    /**
     * The container that deploys a microservice of this name, or null.
     *
     * How ``used by services`` becomes an edge between nodes: the service is an
     * artifact of some container, and that container is the other end.
     */
    def NodeInfo containerDeploying(String artifactName) {
        return nodes.findFirst[
            kind === NodeKind.CONTAINER && artifacts.exists[name == artifactName]
        ]
    }

    def boolean isEmpty() {
        return nodes.empty
    }
}

/**
 * What the grammar offers: a container, or an infrastructure node.
 */
enum NodeKind {
    CONTAINER,
    INFRASTRUCTURE
}

/**
 * How a model stated a relation.
 *
 * Kept although the direction is normalised, because a relation stated only as
 * ``used by`` is stated nowhere else - and that is a fact about the models worth
 * keeping, even where the diagram does not show it.
 */
enum StatedAs {
    DEPENDS_ON,
    USED_BY,
    USED_BY_SERVICE,
    BOTH
}

/**
 * A container or an infrastructure node, with what it holds.
 *
 * A node a relation points at but no read model declares is kept as a stub:
 * ``resolved`` is false and only its name is known.
 */
class NodeInfo {
    @Accessors
    String name

    @Accessors
    NodeKind kind

    /**
     * The deployment or infrastructure technology, by its own name:
     * ``Docker`` of ``DeploymentBase::_deployment.Docker``.
     */
    @Accessors
    String technology

    /**
     * What the model wrote for the technology, path and alias included.
     */
    @Accessors
    String technologyWritten

    @Accessors
    String operationEnvironment

    @Accessors
    String modelFile

    @Accessors
    boolean resolved = true

    /**
     * The microservices a container deploys.
     */
    @Accessors
    val List<ArtifactInfo> artifacts = newLinkedList

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    /**
     * Its ``default values``, as the model wrote them: ``clientPort = 2181``.
     */
    @Accessors
    val List<String> defaultValues = newLinkedList

    @Accessors
    val List<EndpointInfo> endpoints = newLinkedList

    /**
     * The per-service deployment specifications of a container.
     */
    @Accessors
    val List<SpecificationInfo> specifications = newLinkedList

    new(String name, NodeKind kind) {
        this.name = name
        this.kind = kind
    }

    def boolean isContainer() {
        return kind === NodeKind.CONTAINER
    }
}

/**
 * A microservice a container deploys.
 *
 * Named from what the model wrote rather than from the service model: the
 * reference does not resolve outside a running Xtext, and its own text holds
 * the name.
 */
class ArtifactInfo {
    @Accessors
    String name

    @Accessors
    String written

    new(String name, String written) {
        this.name = name
        this.written = written
    }
}

/**
 * The deployment specification of one service inside a container.
 */
class SpecificationInfo {
    @Accessors
    String serviceName

    @Accessors
    val List<String> propertyValues = newLinkedList

    @Accessors
    val List<EndpointInfo> endpoints = newLinkedList

    new(String serviceName) {
        this.serviceName = serviceName
    }
}

/**
 * An endpoint: the protocol it answers and the addresses it answers under.
 */
class EndpointInfo {
    @Accessors
    String protocol

    @Accessors
    val List<String> addresses = newLinkedList

    new(String protocol) {
        this.protocol = protocol
    }
}

/**
 * An aspect a node carries, by name and as the model wrote it.
 *
 * An aspect is a cross-reference, so only its text is readable outside a
 * running Xtext. The written form keeps the values a name drops - and some of
 * those values are long: ``DockerCompose::_aspects.command`` of
 * ``examples/charging-station-management`` holds a shell script.
 */
class AspectReference {
    @Accessors
    String name

    @Accessors
    String written

    new(String name, String written) {
        this.name = name
        this.written = written
    }
}

/**
 * One node needing another.
 */
class NodeEdge {
    @Accessors
    NodeInfo source

    @Accessors
    NodeInfo target

    @Accessors
    StatedAs statedAs

    @Accessors
    String written

    @Accessors
    boolean resolved = true

    @Accessors
    String reason

    new(NodeInfo source, NodeInfo target, StatedAs statedAs, String written) {
        this.source = source
        this.target = target
        this.statedAs = statedAs
        this.written = written
    }

    /**
     * Whether this is the same relation as another, whichever end stated it.
     */
    def boolean sameAs(NodeEdge other) {
        return identityOf(source) == identityOf(other.source)
            && identityOf(target) == identityOf(other.target)
    }

    /**
     * Widen what this relation was stated as, after meeting it a second time.
     */
    def void alsoStatedAs(StatedAs other) {
        if (statedAs !== other) {
            statedAs = StatedAs.BOTH
        }
    }

    private def String identityOf(NodeInfo node) {
        if (node === null) {
            return "<none>"
        }
        return '''«node.modelFile»#«node.name»'''.toString
    }
}
