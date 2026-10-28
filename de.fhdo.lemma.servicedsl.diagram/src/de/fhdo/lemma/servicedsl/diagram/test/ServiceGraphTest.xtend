package de.fhdo.lemma.servicedsl.diagram.test

import de.fhdo.lemma.servicedsl.diagram.Dependency
import de.fhdo.lemma.servicedsl.diagram.DependencyDiagramGenerator
import de.fhdo.lemma.servicedsl.diagram.DependencyLevel
import de.fhdo.lemma.servicedsl.diagram.InterfaceDiagramGenerator
import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import java.nio.file.Path
import java.util.List
import java.nio.file.Paths

/**
 * Checks that service models are read and their dependencies resolved.
 *
 * Run it from the IDE with "Run As -> Java Application", with this bundle as
 * the working directory. No database and no running Eclipse are needed, which
 * is the point of keeping the reader free of both.
 *
 * Each check states what it would catch, because a check that cannot fail
 * proves nothing.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceGraphTest {
    static val FIXTURES = "test/fixtures"
    static val LAKESIDE =
        "../de.fhdo.lemma.reconstruction/test/expected/lakeside-mutual/service"

    static var failures = 0
    static var checks = 0

    def static void main(String[] args) {
        theLongestMatchWins
        theMatchEndsOnADot
        anUndeclaredMicroserviceIsNotInvented
        anUndeclaredAliasIsReported
        aCycleOfImportsTerminates
        lakesideMutualResolvesAcrossModels
        oneReaderServesSeveralReads
        theVerbComesFromTheAspectThatSaysSo
        anOperationShowsItsOwnPath
        aResultIsNotConfusedWithAParameter
        anInterfaceNameIsScopedToItsMicroservice
        anInterfaceDiagramShowsTheSelectionOnly
        aVersionPrefixesTheName
        anAbbreviatedNameResolves
        anAmbiguousAbbreviationResolvesToNeither
        anInterfaceLevelDependencyResolves
        theOverviewAggregatesToOneArrowPerPair
        theDetailDiagramDrawsWhatIsNamed
        aCoarseSystemIsDrawnWithoutPackages
        anUnfollowableDependencyLooksLikeOne
        nothingRequiredIsSaidRatherThanDrawnBlank

        println('''
        ---
        «checks» check(s), «failures» failed''')
        if (failures > 0) {
            System.exit(1)
        }
    }

    /**
     * One microservice's name is a dot-boundary prefix of another's.
     *
     * ``com.example.orders.Order`` and ``com.example.orders.Order.History`` are
     * both valid prefixes of the required operation's name, so a match that
     * takes the first candidate rather than the longest resolves the dependency
     * onto ``Order`` and then reads three names where it expects two.
     */
    private def static void theLongestMatchWins() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "LongestWins")

        check("the longest matching name wins",
            dependency?.target?.qualifiedName, "com.example.orders.Order.History")
        check("its interface is read", dependency?.targetInterface, "Queries")
        check("its operation is read", dependency?.targetOperation, "find")
        check("it is resolved", dependency?.resolved, true)
    }

    /**
     * A required name extends a declared one without a dot between them.
     *
     * ``com.example.orders.OrderArchive`` is not declared, but
     * ``com.example.orders.Order`` is, and the one is a textual prefix of the
     * other. Catches a match that does not end on a dot, which resolves this
     * onto ``Order`` - the wrong microservice, named in the diagram as though
     * the model had required it.
     */
    private def static void theMatchEndsOnADot() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "NeedsBoundary")

        check("a name without a dot boundary does not match",
            dependency?.target?.qualifiedName?.startsWith(
                "com.example.orders.OrderArchive"), true)
        check("and it is not resolved onto the shorter name",
            dependency?.target?.qualifiedName == "com.example.orders.Order", false)
        check("it stays unresolved", dependency?.resolved, false)
    }

    /**
     * A required operation names a microservice the provider does not declare.
     *
     * Catches resolution by position rather than by what was found: taking the
     * last two segments as interface and operation yields the plausible triple
     * (Nonexistent, Queries, find) and reports a dependency on a microservice
     * that does not exist. Matching against the microservices actually read
     * cannot do that.
     */
    private def static void anUndeclaredMicroserviceIsNotInvented() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "WrongName")

        check("an undeclared microservice stays unresolved",
            dependency?.resolved, false)
        check("a reason is given", dependency?.reason !== null, true)
        check("the edge still has a target to draw",
            dependency?.target !== null, true)
        check("the target is marked unresolved",
            dependency?.target?.resolved, false)
        check("what the model wrote is kept",
            dependency?.written?.contains("Nonexistent"), true)
    }

    /**
     * A dependency is written through an alias that no import declares.
     *
     * Catches an alias looked up without checking the imports of the model it
     * was written in, which would resolve against whatever model happened to be
     * read, or throw.
     */
    private def static void anUndeclaredAliasIsReported() {
        val graph = read(FIXTURES + "/prefix-trap/caller.services")
        val dependency = dependencyOf(graph, "WrongAlias")

        check("an unknown alias stays unresolved", dependency?.resolved, false)
        check("the reason names the alias",
            dependency?.reason?.contains("missing"), true)
    }

    /**
     * Two models import each other.
     *
     * Catches following imports without a visited set, which does not
     * terminate.
     */
    private def static void aCycleOfImportsTerminates() {
        val graph = read(FIXTURES + "/cyclic-imports/a.services")

        check("both microservices are read once", graph.services.size, 2)
        check("both dependencies are resolved",
            graph.dependencies.filter[resolved].size, 2)
        check("nothing went wrong", graph.problems.empty, true)

        val a = graph.dependencies.findFirst[source.name == "A"]
        check("A requires B", a?.target?.name, "B")
        check("at microservice level", a?.level, DependencyLevel.MICROSERVICE)
    }

    /**
     * The reconstructed Lakeside Mutual models, which mix the levels.
     *
     * Catches a reader that does not follow imports: CustomerCore is reached
     * only through the import of CustomerSelfService. Catches a reader that
     * handles one level only: CustomerManagement requires three operations
     * while the others require a whole microservice.
     */
    private def static void lakesideMutualResolvesAcrossModels() {
        val graph = read(LAKESIDE + "/CustomerSelfService.services")
        if (graph.empty) {
            check("the Lakeside Mutual fixture was found", false, true)
            return
        }

        check("CustomerCore is reached through the import",
            graph.services.exists[name == "CustomerCore"], true)
        check("nothing went wrong", graph.problems.empty, true)

        val selfService = dependencyOf(graph, "CustomerSelfService")
        check("CustomerSelfService requires CustomerCore",
            selfService?.target?.name, "CustomerCore")
        check("at microservice level",
            selfService?.level, DependencyLevel.MICROSERVICE)
        check("resolved", selfService?.resolved, true)

        // Reading the whole system is a second step: the detail level only
        // appears in CustomerManagement, which CustomerSelfService does not
        // import.
        val whole = read(#[
            LAKESIDE + "/CustomerSelfService.services",
            LAKESIDE + "/CustomerManagement.services",
            LAKESIDE + "/PolicyManagement.services"
        ])
        val operations = whole.dependencies
            .filter[level === DependencyLevel.OPERATION].toList
        check("CustomerManagement requires three operations",
            operations.size, 3)
        check("every one of them is resolved",
            operations.forall[resolved], true)
        check("they name an interface of CustomerCore",
            operations.forall[targetInterface == "CustomerInformationHolder"], true)
        check("they name the operations",
            operations.map[targetOperation].sort.join(","),
            "getCustomer,getCustomers,updateCustomer")
        check("the levels are mixed, not normalised",
            whole.dependencies.filter[level === DependencyLevel.MICROSERVICE].size, 2)
    }

    /**
     * The verb is read from the aspect, and only where the aspect says it.
     *
     * Catches a verb guessed from the operation's name, and catches
     * ``RequestMapping`` being read as a ``GET``: it carries its verb in a
     * property rather than in its name, so claiming one would state something
     * the model does not say.
     */
    private def static void theVerbComesFromTheAspectThatSaysSo() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")

        check("GetMapping is a GET",
            diagram.contains("GET read(id : string) : string"), true)
        check("RequestMapping claims no verb",
            diagram.contains("any(id : string) : string"), true)
        check("and is not read as a GET", diagram.contains("GET any"), false)
        check("an operation with no aspect claims no verb",
            diagram.contains("plain(id : string) : string"), true)
    }

    /**
     * An operation's own path is shown beside its verb.
     *
     * Catches a diagram that shows only the interface's path, which would say
     * that every operation of it answers under the same address.
     */
    private def static void anOperationShowsItsOwnPath() {
        val diagram = draw(LAKESIDE + "/CustomerCore.services")

        check("the interface's path is shown once",
            diagram.contains("/customers"), true)
        check("an operation's own path is shown with its verb",
            diagram.contains("GET /{ids} getCustomer("), true)
        check("an operation without one shows none",
            diagram.contains("POST createCustomer("), true)
    }

    /**
     * What an operation returns, and what it does not.
     *
     * Catches an outgoing parameter drawn as a parameter of the call, a fault
     * drawn as the result - which would state that a failure is what the
     * operation returns - and a second outgoing value dropped, which LEMMA
     * allows and a diagram showing only the first would hide.
     */
    private def static void aResultIsNotConfusedWithAParameter() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")

        check("an operation with nothing outgoing returns void",
            diagram.contains("notify(message : string) : void"), true)
        check("several outgoing values are all shown",
            diagram.contains("split(id : string) : (first : string, second : int)"), true)
        check("a fault is not the result",
            diagram.contains("risky(id : string) : string {fault string}"), true)
        check("an asynchronous operation is marked",
            diagram.contains("stream(id : string) : string {async}"), true)
        check("an optional parameter is marked",
            diagram.contains("search(filter? : string)"), true)
    }

    /**
     * Two microservices of one system offer an interface of the same name.
     *
     * Catches an alias that is only the interface name: PlantUML identifies a
     * type by the name it is declared with whatever package it sits in, so one
     * interface would be drawn holding the operations of both. This is the
     * defect the data model diagram was corrected for.
     */
    private def static void anInterfaceNameIsScopedToItsMicroservice() {
        val diagram = draw(FIXTURES + "/interface-shapes/shapes.services")
        val aliases = diagram.split("\n")
            .filter[contains("interface ") && contains(" as ")]
            .map[substring(indexOf(" as ") + 4).split(" ").head.trim]
            .toList

        check("both Shared interfaces are drawn",
            diagram.split("interface .Shared.").size - 1, 2)
        check("under aliases of their own", aliases.size, aliases.toSet.size)
        check("scoped to the microservice",
            aliases.exists[endsWith("Shapes_Shared")]
                && aliases.exists[endsWith("Helper_Shared")], true)
        check("a microservice that is neither public nor functional says so",
            diagram.contains("package \"Helper\" <<internal, utility>>"), true)
        check("a noimpl interface is marked",
            diagram.contains("<<noimpl>>"), true)
    }

    /**
     * An interface diagram shows the model that was opened, not its imports.
     *
     * The reader follows imports because a dependency diagram needs them, so
     * the graph of CustomerSelfService holds CustomerCore as well. Catches an
     * interface diagram that draws it too: a reader who opens one service model
     * is asking what that service offers, and drawing everything reachable made
     * this diagram two packages wide where it should be one.
     */
    private def static void anInterfaceDiagramShowsTheSelectionOnly() {
        val graph = read(LAKESIDE + "/CustomerSelfService.services")
        val diagram = new InterfaceDiagramGenerator().generate(graph)

        check("the graph still reaches CustomerCore, for the dependencies",
            graph.services.exists[name == "CustomerCore"], true)
        check("the diagram draws the selected service",
            diagram.contains("package \"CustomerSelfService\""), true)
        check("and not the one it imports",
            diagram.contains("package \"CustomerCore\""), false)
        check("exactly one package is drawn",
            diagram.split("package \"").size - 1, 1)
    }

    /**
     * The overview reduces every dependency to one arrow per pair of services.
     *
     * Catches an overview drawn at the level the model happens to declare,
     * which would show one system as three arrows and another as one. Catches a
     * missing count: three required operations are one arrow here, and an
     * unlabelled arrow would read as the whole truth.
     */
    private def static void theOverviewAggregatesToOneArrowPerPair() {
        val diagram = overviewOf(lakesideSystem)

        check("one arrow per pair of services",
            diagram.split(" --> ").size - 1, 3)
        check("the operation-level dependency says what backs it",
            diagram.contains("svc_com_lakesidemutual_customermanagement_CustomerManagement"
                + " --> svc_com_lakesidemutual_customercore_CustomerCore : 3 ops"), true)
        check("a whole-service dependency needs no label",
            diagram.contains("svc_com_lakesidemutual_policymanagement_PolicyManagement"
                + " --> svc_com_lakesidemutual_customercore_CustomerCore\n"), true)
        check("every end of every arrow is declared",
            undeclaredArrowEnds(diagram).join(", "), "")
    }

    /**
     * The detail diagram draws what a dependency names.
     *
     * Catches a detail diagram that drops the coarse dependencies: a reader
     * would take CustomerSelfService to require nothing, when it requires the
     * whole of CustomerCore. Catches a target drawn as a package when nothing
     * is required of it by name, which wraps every service of a coarse-grained
     * system in a package of one component.
     */
    private def static void theDetailDiagramDrawsWhatIsNamed() {
        val diagram = detailOf(lakesideSystem)

        check("the required operations are drawn inside the target",
            diagram.contains("[CustomerInformationHolder.getCustomer] as "), true)
        check("all three of them",
            diagram.split("\\[CustomerInformationHolder\\.").size - 1, 3)
        check("in a package named after the service",
            diagram.contains("package \"CustomerCore\""), true)
        check("a whole-service dependency is still drawn",
            diagram.contains("svc_com_lakesidemutual_customerselfservice_CustomerSelfService"
                + " --> svc_com_lakesidemutual_customercore_CustomerCore"), true)
        check("every end of every arrow is declared",
            undeclaredArrowEnds(diagram).join(", "), "")
    }

    /**
     * A coarse-grained system needs no packages at all.
     *
     * Catches a service being wrapped in a package holding one component of the
     * same name, which is what packaging every target rather than every named
     * requirement did.
     */
    private def static void aCoarseSystemIsDrawnWithoutPackages() {
        val diagram = detailOf(#[FIXTURES + "/cyclic-imports/a.services"])

        check("no package is drawn", diagram.contains("package "), false)
        check("both services are", diagram.split("\\] as ").size - 1, 2)
        check("and both arrows", diagram.split(" --> ").size - 1, 2)
    }

    /**
     * A dependency that could not be followed is visibly that.
     *
     * Catches a stub labelled with the last part of the name - "find" reads as
     * an operation, and where the microservice name ends is exactly what could
     * not be worked out. Catches an unresolved arrow drawn like a resolved one,
     * which would state what the model only names.
     */
    private def static void anUnfollowableDependencyLooksLikeOne() {
        val diagram = overviewOf(#[FIXTURES + "/prefix-trap/caller.services"])

        check("the stub keeps the whole name the model wrote",
            diagram.contains("[com.example.orders.Nonexistent.Queries.find] as "), true)
        check("and is not labelled with its last part",
            diagram.contains("[find] as "), false)
        check("it is marked unresolved", diagram.contains("<<unresolved>>"), true)
        // Checked here and not only on Lakeside Mutual: there, CustomerCore is
        // declared anyway because something requires it as a whole, so an
        // overview that declared only microservice-level targets would still
        // look right. Here nothing requires a whole service but WrongAlias, so
        // the omission shows.
        check("every end of every arrow is declared, at every level",
            undeclaredArrowEnds(diagram).join(", "), "")
        check("its arrow is dashed", diagram.contains(" ..> "), true)
        check("and labelled so", diagram.contains("unresolved\n"), true)

        val detail = detailOf(#[FIXTURES + "/prefix-trap/caller.services"])
        check("the detail diagram says why", detail.contains("no import is named missing"), true)
    }

    /**
     * A system whose services require nothing of each other.
     *
     * Catches a blank image: that a system has no dependencies is a result, and
     * an empty diagram does not say it.
     */
    private def static void nothingRequiredIsSaidRatherThanDrawnBlank() {
        val diagram = overviewOf(#[FIXTURES + "/interface-shapes/shapes.services"])

        check("the diagram says so",
            diagram.contains("No dependencies are declared."), true)
        check("end note is on a line of its own",
            diagram.contains("\nend note"), true)
        check("the services are still drawn",
            diagram.split("\\] as ").size - 1, 2)
    }

    /**
     * Every alias an arrow names, that no component or node declares.
     *
     * PlantUML invents a component for an undeclared alias and labels it with
     * the alias, which is how svc_com_example_orders_Order_History came to be a
     * box of its own.
     */
    private def static List<String> undeclaredArrowEnds(String diagram) {
        val declared = <String>newLinkedHashSet
        val used = <String>newLinkedList
        for (line : diagram.split("\n")) {
            val text = line.trim
            if (text.contains("] as ")) {
                declared.add(text.substring(text.indexOf("] as ") + 5)
                    .replace("<<unresolved>>", "").trim)
            } else if (text.contains(" --> ") || text.contains(" ..> ")) {
                val arrow = if (text.contains(" --> ")) " --> " else " ..> "
                var target = text.substring(text.indexOf(arrow) + arrow.length)
                if (target.contains(" : ")) {
                    target = target.substring(0, target.indexOf(" : "))
                }
                used.add(target.trim)
                used.add(text.substring(0, text.indexOf(arrow)).trim)
            }
        }
        return used.filter[!declared.contains(it)].toSet.sort
    }

    private def static List<String> lakesideSystem() {
        return #[
            LAKESIDE + "/CustomerSelfService.services",
            LAKESIDE + "/CustomerManagement.services",
            LAKESIDE + "/PolicyManagement.services"
        ]
    }

    private def static String overviewOf(Iterable<String> files) {
        return new DependencyDiagramGenerator().generateOverview(read(files))
    }

    private def static String detailOf(Iterable<String> files) {
        return new DependencyDiagramGenerator().generateDetail(read(files))
    }

    /**
     * A version prefixes a microservice's name in a reference.
     *
     * ``microservice de.fhdo.DiscoveryService version v01`` is referred to as
     * ``v01.de.fhdo.DiscoveryService``, which is the metamodel's own
     * ``qualifiedNameParts`` and not something a reader can assemble from the
     * name. Catches taking the name as written: every dependency of the three
     * versioned e-vehicle-charging models was unresolvable before this.
     */
    private def static void aVersionPrefixesTheName() {
        val graph = read(FIXTURES + "/abbreviated/versions.services")
        val caller = graph.dependencies.findFirst[source.name == "Caller"]

        check("the version is part of the qualified name",
            graph.services.exists[qualifiedName == "v01.de.fhdo.DiscoveryService"], true)
        check("but not of the name shown",
            graph.services.exists[name == "DiscoveryService"], true)
        check("a reference naming it in full resolves", caller?.resolved, true)
        check("onto the interface", caller?.targetInterface, "Lookup")
        check("and the operation", caller?.targetOperation, "find")
    }

    /**
     * A reference inside one model may abbreviate the name to a suffix of it.
     *
     * ``required microservices { DiscoveryService }`` names
     * ``v01.de.fhdo.DiscoveryService``, as examples/e-vehicle-charging does.
     * Catches a match that only accepts the full qualified name.
     */
    private def static void anAbbreviatedNameResolves() {
        val graph = read(FIXTURES + "/abbreviated/versions.services")
        val gateway = graph.dependencies.findFirst[source.name == "Gateway"]

        check("an abbreviated reference resolves", gateway?.resolved, true)
        check("onto the right microservice",
            gateway?.target?.qualifiedName, "v01.de.fhdo.DiscoveryService")
        check("at microservice level", gateway?.level, DependencyLevel.MICROSERVICE)
    }

    /**
     * Two microservices whose names end the same way, named by that ending.
     *
     * Catches an abbreviation resolved to whichever candidate came first:
     * naming one of them is a guess, and a guess drawn as an arrow is worse
     * than an arrow drawn as unresolved.
     */
    private def static void anAmbiguousAbbreviationResolvesToNeither() {
        val graph = read(FIXTURES + "/abbreviated/ambiguous.services")
        val caller = graph.dependencies.findFirst[source.name == "Caller"]

        check("both candidates were read",
            graph.services.filter[name == "Registry"].size, 2)
        check("the ambiguous reference stays unresolved", caller?.resolved, false)
        check("and says more than one is named",
            caller?.reason?.contains("more than one"), true)
    }

    /**
     * A dependency declared at interface level.
     *
     * No model of this repository uses ``required interfaces``, so without this
     * fixture the whole interface level went unexercised - replacing the
     * interface match with "take the first one" left every check green.
     */
    private def static void anInterfaceLevelDependencyResolves() {
        val graph = read(FIXTURES + "/abbreviated/versions.services")
        val good = graph.dependencies.findFirst[source.name == "InterfaceCaller"]
        val bad = graph.dependencies.findFirst[source.name == "WrongInterface"]

        check("it resolves", good?.resolved, true)
        check("at interface level", good?.level, DependencyLevel.INTERFACE)
        check("onto the named interface", good?.targetInterface, "Lookup")
        check("and not onto whichever came first",
            good?.targetInterface == "Trigger", false)
        check("an interface the target does not declare stays unresolved",
            bad?.resolved, false)
        check("with a reason", bad?.reason?.contains("no interface"), true)

        val overview = overviewOf(#[FIXTURES + "/abbreviated/versions.services"])
        check("the overview counts it as an interface",
            overview.contains(" : 1 interface"), true)
    }

    /**
     * One reader serves several reads.
     *
     * Catches a reader that creates a resource for a model it already holds: a
     * resource set refuses that, and the Eclipse command reads each selected
     * model for its interfaces and then all of them together for their
     * dependencies, over overlapping imports.
     */
    private def static void oneReaderServesSeveralReads() {
        val reader = new ServiceModelReader
        val first = reader.read(Paths.get(LAKESIDE + "/CustomerSelfService.services"))
        val second = reader.read(Paths.get(LAKESIDE + "/CustomerManagement.services"))
        val both = reader.read(#[
            Paths.get(LAKESIDE + "/CustomerSelfService.services") as Path,
            Paths.get(LAKESIDE + "/CustomerManagement.services") as Path
        ])

        check("the first read works", first.problems.empty, true)
        check("the second works too, over the same import",
            second.problems.empty, true)
        check("and so does reading both", both.problems.empty, true)
        check("the second read resolves its dependencies",
            second.dependencies.forall[resolved], true)
        check("each read sees only what it was asked for",
            first.entryFiles.size, 1)
        check("and both together see both", both.entryFiles.size, 2)
    }

    private def static String draw(String file) {
        return new InterfaceDiagramGenerator().generate(read(file))
    }

    private def static ServiceGraph read(String file) {
        return new ServiceModelReader().read(Paths.get(file))
    }

    private def static ServiceGraph read(Iterable<String> files) {
        return new ServiceModelReader().read(
            files.map[Paths.get(it) as Path].toList)
    }

    /**
     * The one dependency of the microservice of this name.
     */
    private def static Dependency dependencyOf(ServiceGraph graph, String serviceName) {
        return graph.dependencies.findFirst[source.name == serviceName]
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
