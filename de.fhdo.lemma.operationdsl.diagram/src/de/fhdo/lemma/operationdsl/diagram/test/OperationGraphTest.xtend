package de.fhdo.lemma.operationdsl.diagram.test

import de.fhdo.lemma.operationdsl.diagram.DiagramNaming
import de.fhdo.lemma.operationdsl.diagram.NodeDetailDiagramGenerator
import de.fhdo.lemma.operationdsl.diagram.NodeEdge
import de.fhdo.lemma.operationdsl.diagram.NodeInfo
import de.fhdo.lemma.operationdsl.diagram.TopologyDiagramGenerator
import de.fhdo.lemma.operationdsl.diagram.NodeKind
import de.fhdo.lemma.operationdsl.diagram.OperationGraph
import de.fhdo.lemma.operationdsl.diagram.OperationModelReader
import de.fhdo.lemma.operationdsl.diagram.StatedAs
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Checks that operation models are read and their relations resolved.
 *
 * Run it from the IDE with "Run As -> Java Application", with this bundle as
 * the working directory. No database and no running Eclipse are needed.
 *
 * Each check states what it would catch, because a check that cannot fail
 * proves nothing.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OperationGraphTest {
    static val FIXTURES = "test/fixtures"
    static val CHARGING =
        "../examples/charging-station-management/models/operation"

    static var failures = 0
    static var checks = 0

    def static void main(String[] args) {
        bothEndsOfOneRelationAreOneEdge
        aRelationStatedOnlyOnceSurvives
        usedByServicesResolvesThroughTheArtifact
        anUnfollowableRelationSaysWhy
        aCycleOfNodeImportsTerminates
        whatANodeHoldsIsRead
        theTopologyNestsArtifactsAndDeclaresEveryEnd
        anAliasIsTheSameOnEveryMachine
        anUnresolvedRelationIsDrawnAsOne
        theDetailDiagramShowsTheConfiguration
        everyShapeIsDeclaredBeforeItIsUsed

        println('''
        ---
        «checks» check(s), «failures» failed''')
        if (failures > 0) {
            System.exit(1)
        }
    }

    /**
     * The same relation stated from both ends, in two files.
     *
     * Catches an edge added twice: `charging-station-management` states
     * `CommandSideContainer depends on APIGateway` in one model and
     * `APIGateway used by CommandSideContainer` in another, so a reader that
     * keeps both would report two facts where there is one - and seven arrows
     * where there are four.
     */
    private def static void bothEndsOfOneRelationAreOneEdge() {
        val graph = read(CHARGING + "/command-side/ChargingStationManagementCommandSide.operation")
        val both = edgesOf(graph, "CommandSideContainer")

        check("the three relations of the container are three edges",
            both.filter[target.name != "Broker"].size, 3)
        check("each is recognised as stated from both ends",
            both.filter[statedAs === StatedAs.BOTH].size, 3)
        check("no pair of nodes has two edges",
            duplicatePairs(graph).join(", "), "")
        check("the whole system is 19 edges, not 25",
            graph.edges.size, 19)
        check("read from one model, through its imports",
            graph.nodes.size, 13)

        // And the same shape in a fixture, where it is the only thing happening
        val fixture = read(FIXTURES + "/relations/app.operation")
        check("a mirrored relation is one edge",
            fixture.edges.filter[source.name == "AppContainer" && target.name == "Cache"].size, 1)
        check("marked as stated from both ends",
            fixture.edges.findFirst[target.name == "Cache"]?.statedAs, StatedAs.BOTH)
    }

    /**
     * A relation stated from one end only.
     *
     * Catches a reader that honours `depends on` and drops `used by`:
     * `Broker used by nodes CommandSideContainer` has no mirror in the
     * container's own model, so dropping it loses the relation entirely.
     */
    private def static void aRelationStatedOnlyOnceSurvives() {
        val graph = read(CHARGING + "/command-side/ChargingStationManagementCommandSide.operation")
        val broker = graph.edges.findFirst[
            source.name == "CommandSideContainer" && target.name == "Broker"]

        check("the relation survives", broker !== null, true)
        check("in the needing-to-needed direction", broker?.source?.name, "CommandSideContainer")
        check("and says it was stated as used by", broker?.statedAs, StatedAs.USED_BY)
        check("it is resolved", broker?.resolved, true)
    }

    /**
     * `used by services` names a microservice rather than a node.
     *
     * Catches it being dropped or drawn to a service that is not a node: the
     * service is an artifact of some container, and that container is the other
     * end. **No model of this repository uses `used by services`**, so without
     * the fixture this whole branch would go unexercised - the gap that let
     * `required interfaces` sit untested in the service bundle.
     */
    private def static void usedByServicesResolvesThroughTheArtifact() {
        val graph = read(FIXTURES + "/relations/infra.operation")
        val usage = graph.edges.findFirst[statedAs === StatedAs.USED_BY_SERVICE && resolved]

        check("the relation is read", usage !== null, true)
        check("its source is the container that deploys the service",
            usage?.source?.name, "AppContainer")
        check("and its target the node that is used", usage?.target?.name, "Database")

        val absent = graph.edges.findFirst[
            statedAs === StatedAs.USED_BY_SERVICE && !resolved]
        check("a service no container deploys stays unresolved", absent !== null, true)
        check("with a reason", absent?.reason?.contains("no container"), true)
    }

    /**
     * A relation that cannot be followed.
     *
     * Catches a relation silently dropped, and catches an alias resolved
     * against whatever model happened to be read rather than against the
     * imports of the model it was written in.
     */
    private def static void anUnfollowableRelationSaysWhy() {
        val graph = read(FIXTURES + "/relations/infra.operation")

        val missingNode = graph.edges.findFirst[source.name == "MissingTarget"]
        check("a node the imported model does not declare is unresolved",
            missingNode?.resolved, false)
        check("and says so", missingNode?.reason?.contains("no node NotThere"), true)
        check("the edge still has a target to draw", missingNode?.target !== null, true)
        check("marked unresolved", missingNode?.target?.resolved, false)

        val missingAlias = graph.edges.findFirst[source.name == "MissingAlias"]
        check("an unknown alias is unresolved", missingAlias?.resolved, false)
        check("and the reason names it",
            missingAlias?.reason?.contains("no import is named nosuch"), true)
    }

    /**
     * Two operation models importing each other.
     *
     * Catches following imports without a visited set. Not a precaution: in
     * `charging-station-management`, `Infrastructure` imports the command side
     * and the command side imports `Infrastructure`.
     */
    private def static void aCycleOfNodeImportsTerminates() {
        val graph = read(CHARGING + "/Infrastructure.operation")

        check("every node is read once", graph.nodes.size, 13)
        check("nothing went wrong", graph.problems.empty, true)
        check("and reading from the other end gives the same count",
            read(CHARGING + "/query-side/ChargingStationManagementQuerySide.operation")
                .nodes.size, 13)
    }

    /**
     * What a node holds, beside its relations.
     *
     * Catches a technology read as the whole reference rather than by name, an
     * operation environment missed - it is referred to by a string, so there is
     * no contained element whose text holds it - and a deployed service read as
     * a qualified name rather than as the artifact's name.
     */
    private def static void whatANodeHoldsIsRead() {
        val graph = read(FIXTURES + "/relations/app.operation")
        val container = graph.nodes.findFirst[name == "AppContainer"]
        val database = graph.nodes.findFirst[name == "Database"]

        check("a container is a container", container?.kind, NodeKind.CONTAINER)
        check("an infrastructure node is one", database?.kind, NodeKind.INFRASTRUCTURE)
        check("the deployment technology is read by name", container?.technology, "Docker")
        check("the infrastructure technology too", database?.technology, "Postgres")
        check("the operation environment is read",
            container?.operationEnvironment, "openjdk:11-jdk-slim")
        check("the deployed service is read as an artifact",
            container?.artifacts?.head?.name, "Shop")
        check("keeping what the model wrote",
            container?.artifacts?.head?.written, "Svc::com.example.Shop")
        check("default values are read as written",
            container?.defaultValues?.head, "port = 8080")

        // An aspect value may be an embedded shell script; its newlines carry
        // no meaning a diagram can use.
        val scripted = read(CHARGING + "/Infrastructure.operation")
            .nodes.findFirst[name == "BrokerMonitoringProvision"]
        check("a multi-line aspect value is collapsed to one line",
            scripted?.aspects?.forall[!written.contains("\n")], true)
        check("and its name is still read",
            scripted?.aspects?.exists[name == "command"], true)
    }

    /**
     * The topology: nodes, their artifacts and one arrow per relation.
     *
     * Catches an artifact drawn beside its container instead of inside it,
     * which would make this a node graph rather than a deployment diagram; and
     * catches an arrow whose end is never declared, which PlantUML answers by
     * inventing a shape and labelling it with the alias.
     */
    private def static void theTopologyNestsArtifactsAndDeclaresEveryEnd() {
        val diagram = topologyOf(CHARGING + "/command-side/ChargingStationManagementCommandSide.operation")

        check("a container is a node", diagram.contains("node \"CommandSideContainer\""), true)
        check("stereotyped with its deployment technology",
            diagram.contains("<<Docker>>"), true)
        check("what it deploys is an artifact inside it",
            diagram.contains("artifact \"ChargingStationManagementCommandSide\""), true)
        check("an infrastructure node is a node too",
            diagram.contains("node \"Broker\" as n_Broker <<Kafka>>"), true)
        check("one arrow per relation", diagram.split(" --> ").size - 1, 19)
        check("every end of every arrow is declared",
            undeclaredArrowEnds(diagram).join(", "), "")
    }

    /**
     * An alias never contains the path of the model that declared it.
     *
     * Catches identifying a node by its absolute file path, which is what the
     * reader does internally: the path is machine-specific, so a diagram
     * carrying it would differ between machines and stop being diffable or
     * reproducible.
     */
    private def static void anAliasIsTheSameOnEveryMachine() {
        val diagram = topologyOf(CHARGING + "/Infrastructure.operation")

        check("no alias holds a path separator",
            diagram.split("\n").filter[contains(" as ") && contains("/")].size, 0)
        check("and none holds the repository's location",
            diagram.contains("Entwicklung"), false)
        check("a name is still disambiguated when two models share one",
            new DiagramNaming(#[
                namedNode("Broker", "/a/one.operation"),
                namedNode("Broker", "/b/two.operation")
            ]).aliasOf(namedNode("Broker", "/b/two.operation")), "n_Broker__two")
    }

    /**
     * An unresolved relation is visibly unresolved.
     *
     * Catches an unresolved end left undeclared, and catches it drawn like a
     * resolved one - which would state what the model only names.
     */
    private def static void anUnresolvedRelationIsDrawnAsOne() {
        val diagram = topologyOf(FIXTURES + "/relations/infra.operation")

        check("its arrow is dashed", diagram.contains(" ..> "), true)
        check("the end it points at is declared",
            diagram.contains("node \"NotThere\""), true)
        check("and marked unresolved", diagram.contains("<<unresolved>>"), true)
        check("every end of every arrow is declared",
            undeclaredArrowEnds(diagram).join(", "), "")
    }

    /**
     * The detail diagram: what each node is configured with.
     *
     * Catches a separator left at the end of a box, because one is added before
     * each group whether or not the group has anything in it; catches an aspect
     * printed as the model wrote it, alias and semicolon included, where
     * everything else is named simply; and catches a value that is an embedded
     * shell script printed whole.
     */
    private def static void theDetailDiagramShowsTheConfiguration() {
        val diagram = detailOf(CHARGING + "/Infrastructure.operation")

        check("a default value is shown as written",
            diagram.contains("clientPort = 2181"), true)
        check("no box ends with a separator",
            diagram.contains("..\n}"), false)
        check("an aspect is shown by name and values",
            diagram.contains("hostname(\"broker\")"), true)
        check("not as the model wrote it",
            diagram.contains("DockerCompose::_aspects.hostname"), false)
        check("a value too long for a line is cut visibly",
            diagram.contains("…"), true)
        check("a container says it is one", diagram.contains(", container>>"), true)
        check("an infrastructure node says it is one",
            diagram.contains(", infrastructure>>"), true)

        val fixture = detailOf(FIXTURES + "/relations/app.operation")
        check("the operation environment is shown",
            fixture.contains("environment : openjdk:11-jdk-slim"), true)
        check("and what the container deploys",
            fixture.contains("deploys Shop"), true)
    }

    /**
     * Every shape is declared before the first arrow that names it.
     *
     * Catches the stub declarations being emitted after the arrows. An arrow to
     * an undeclared alias makes PlantUML create the shape there and then, so a
     * declaration afterwards is a redefinition and the whole diagram is
     * rejected - which a check for "the file is valid SVG" does not notice,
     * because PlantUML answers a rejected diagram with a picture of the error.
     */
    private def static void everyShapeIsDeclaredBeforeItIsUsed() {
        for (file : #[FIXTURES + "/relations/infra.operation",
                      FIXTURES + "/relations/app.operation",
                      CHARGING + "/Infrastructure.operation"]) {
            val lines = topologyOf(file).split("\n")
            var int firstArrow = -1
            var int lastDeclaration = -1
            for (var int i = 0; i < lines.length; i++) {
                val line = lines.get(i).trim
                if (firstArrow < 0 && (line.contains(" --> ") || line.contains(" ..> "))) {
                    firstArrow = i
                }
                if (line.startsWith("node ") && line.contains(" as ")) {
                    lastDeclaration = i
                }
            }
            check('''no node of «baseNameOf(file)» is declared after the first arrow''',
                firstArrow < 0 || lastDeclaration < firstArrow, true)
        }
    }

    private def static String baseNameOf(String file) {
        val separator = file.lastIndexOf("/")
        return if (separator >= 0) file.substring(separator + 1) else file
    }

    /**
     * Every alias an arrow names that no shape declares.
     */
    private def static Iterable<String> undeclaredArrowEnds(String diagram) {
        val declared = <String>newLinkedHashSet
        val used = <String>newLinkedList
        for (line : diagram.split("\n")) {
            val text = line.trim
            if (text.contains(" as ")) {
                declared.add(text.substring(text.indexOf(" as ") + 4)
                    .replaceAll("<<[^>]*>>", "").replace("{", "").trim)
            } else if (text.contains(" --> ") || text.contains(" ..> ")) {
                val arrow = if (text.contains(" --> ")) " --> " else " ..> "
                used.add(text.substring(text.indexOf(arrow) + arrow.length).trim)
                used.add(text.substring(0, text.indexOf(arrow)).trim)
            }
        }
        return used.filter[!declared.contains(it)].toSet.sort
    }

    private def static NodeInfo namedNode(String name, String modelFile) {
        val node = new NodeInfo(name, NodeKind.INFRASTRUCTURE)
        node.modelFile = modelFile
        return node
    }

    private def static String topologyOf(String file) {
        return new TopologyDiagramGenerator().generate(read(file))
    }

    private def static String detailOf(String file) {
        return new NodeDetailDiagramGenerator().generate(read(file))
    }

    /**
     * Pairs of nodes that have more than one edge between them.
     */
    private def static Iterable<String> duplicatePairs(OperationGraph graph) {
        val seen = <String>newLinkedList
        val twice = <String>newLinkedHashSet
        for (edge : graph.edges) {
            val key = '''«edge.source.name»->«edge.target.name»'''.toString
            if (seen.contains(key)) {
                twice.add(key)
            }
            seen.add(key)
        }
        return twice.sort
    }

    private def static Iterable<NodeEdge> edgesOf(OperationGraph graph, String nodeName) {
        return graph.edges.filter[source.name == nodeName].toList
    }

    private def static OperationGraph read(String file) {
        return new OperationModelReader().read(Paths.get(file) as Path)
    }

    private def static void check(String what, Object actual, Object expected) {
        checks++
        if (expected == actual) {
            println('''  ok    «what»''')
        } else {
            failures++
            println('''  FAIL  «what»: expected «expected», got «actual»''')
        }
    }
}
