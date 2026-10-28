package de.fhdo.lemma.servicedsl.diagram

import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The microservices of a system, what they offer and what they require.
 *
 * Built by [[ServiceModelReader]] from one or more service models, with every
 * dependency already resolved to the microservice it points at. It exists so
 * that no generator parses anything: resolving a dependency across model files
 * is the hard part of drawing a service model, it happens once, it is testable
 * on its own, and a further diagram needs no further reading.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceGraph {
    @Accessors(PUBLIC_GETTER)
    val List<ServiceNode> services = newLinkedList

    @Accessors(PUBLIC_GETTER)
    val List<Dependency> dependencies = newLinkedList

    /**
     * Problems met while reading, reported rather than thrown.
     *
     * A model that cannot be read must not stop the others, and what could not
     * be read is itself worth saying.
     */
    @Accessors(PUBLIC_GETTER)
    val List<String> problems = newLinkedList

    /**
     * The models that were asked for, as opposed to those reached through their
     * imports.
     *
     * A dependency diagram wants everything reachable; an interface diagram
     * wants what was selected, because a reader who opens one model is asking
     * about that one. Both read the same graph, so the graph has to keep the
     * difference.
     */
    @Accessors(PUBLIC_GETTER)
    val List<String> entryFiles = newLinkedList

    def void add(ServiceNode service) {
        services.add(service)
    }

    def void add(Dependency dependency) {
        dependencies.add(dependency)
    }

    def void addProblem(String problem) {
        problems.add(problem)
    }

    def void addEntryFile(String file) {
        entryFiles.add(file)
    }

    /**
     * Whether a model is one of those that were asked for.
     */
    def boolean isEntry(String modelFile) {
        return entryFiles.contains(modelFile)
    }

    /**
     * The microservices the asked-for models declare.
     */
    def List<ServiceNode> entryServices() {
        return services.filter[resolved && isEntry(modelFile)].toList
    }

    /**
     * The microservice of this qualified name, or null.
     */
    def ServiceNode serviceOf(String qualifiedName) {
        return services.findFirst[it.qualifiedName == qualifiedName]
    }

    /**
     * The microservices a model file declares.
     */
    def List<ServiceNode> servicesOf(String modelFile) {
        return services.filter[it.modelFile == modelFile].toList
    }

    /**
     * Whether anything was read at all.
     */
    def boolean isEmpty() {
        return services.empty
    }
}

/**
 * A microservice, with the interfaces it offers.
 *
 * A microservice a dependency points at but no read model declares is kept as a
 * stub: ``resolved`` is false and only its name is known. A dependency the
 * diagram cannot follow is a fact about the model, not nothing.
 */
class ServiceNode {
    @Accessors
    String qualifiedName

    /**
     * The last segment of the qualified name, which is what a diagram labels a
     * microservice with.
     */
    @Accessors
    String name

    @Accessors
    String visibility

    @Accessors
    String type

    /**
     * Absolute path of the model that declares it, null for a stub.
     */
    @Accessors
    String modelFile

    @Accessors
    boolean resolved = true

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<InterfaceNode> interfaces = newLinkedList

    new(String qualifiedName) {
        this.qualifiedName = qualifiedName
        this.name = simpleNameOf(qualifiedName)
    }

    def InterfaceNode interfaceOf(String interfaceName) {
        return interfaces.findFirst[it.name == interfaceName]
    }

    /**
     * The name a qualified name ends with.
     */
    static def String simpleNameOf(String qualifiedName) {
        if (qualifiedName === null) {
            return null
        }
        val separator = qualifiedName.lastIndexOf(".")
        return if (separator >= 0) qualifiedName.substring(separator + 1) else qualifiedName
    }
}

/**
 * An interface of a microservice, with its operations.
 */
class InterfaceNode {
    @Accessors
    String name

    /**
     * The name a dependency refers to it by: its microservice's qualified name,
     * its own version if it has one, and its name.
     *
     * Built from the metamodel's own ``qualifiedNameParts`` rather than by
     * joining names here, because a version prefixes a name in a reference and
     * nothing else says so.
     */
    @Accessors
    String qualifiedName

    @Accessors
    boolean notImplemented

    /**
     * Its endpoints: the protocol each answers, and under which addresses.
     */
    @Accessors
    val List<EndpointReference> endpoints = newLinkedList

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<OperationNode> operations = newLinkedList

    new(String name) {
        this.name = name
    }

    def OperationNode operationOf(String operationName) {
        return operations.findFirst[it.name == operationName]
    }
}

/**
 * An operation of an interface, with its parameters.
 */
class OperationNode {
    @Accessors
    String name

    @Accessors
    boolean notImplemented

    /**
     * Its own endpoints, whose addresses extend its interface's.
     */
    @Accessors
    val List<EndpointReference> endpoints = newLinkedList

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    @Accessors
    val List<ParameterNode> parameters = newLinkedList

    new(String name) {
        this.name = name
    }
}

/**
 * A parameter of an operation.
 */
class ParameterNode {
    @Accessors
    String name

    /**
     * ``SYNCHRONOUS`` or ``ASYNCHRONOUS``.
     */
    @Accessors
    String communicationType

    /**
     * ``IN``, ``OUT`` or null.
     */
    @Accessors
    String exchangePattern

    /**
     * The name of its type: a primitive's own name, or an imported type as the
     * model wrote it, alias included.
     */
    @Accessors
    String typeName

    @Accessors
    boolean primitive

    @Accessors
    boolean optional

    /**
     * Whether it communicates a fault rather than a result.
     */
    @Accessors
    boolean fault

    @Accessors
    val List<AspectReference> aspects = newLinkedList

    new(String name) {
        this.name = name
    }

    def boolean isIncoming() {
        return "IN" == exchangePattern
    }

    def boolean isOutgoing() {
        return "OUT" == exchangePattern
    }

    def boolean isAsynchronous() {
        return "ASYNCHRONOUS" == communicationType
    }
}

/**
 * An endpoint: the protocol it answers and the addresses it answers under.
 *
 * The protocol is a cross-reference, so it is read from the parse tree and kept
 * by name - ``rest`` of ``javaWithSpring::_protocols.rest``. A diagram says
 * which protocol an interface speaks, and the technology it came from is not
 * what distinguishes one interface from another.
 */
class EndpointReference {
    @Accessors
    String protocol

    @Accessors
    val List<String> addresses = newLinkedList

    new(String protocol) {
        this.protocol = protocol
    }
}

/**
 * A technology aspect a model element carries.
 *
 * Kept as both the name and what the model wrote, because an aspect is a
 * cross-reference and therefore only readable as text outside a running Xtext.
 * The name is what a diagram decides by - a ``GetMapping`` is a ``GET`` - and
 * the written form keeps the property values a name drops.
 */
class AspectReference {
    @Accessors
    String name

    @Accessors
    String written

    /**
     * The property values the aspect carries, by property name.
     *
     * Read from the written form, because an aspect is a cross-reference and
     * only its text is available outside a running Xtext. A rule over the
     * model asks for a value - the transport of a channel, the target of a
     * call - rather than for the text it was written in.
     */
    @Accessors
    val Map<String, String> values = newLinkedHashMap

    new(String name, String written) {
        this.name = name
        this.written = written
        values.putAll(valuesOf(written))
    }

    /**
     * Whether the aspect carries this value.
     */
    def String valueOf(String property) {
        return values.get(property)
    }

    /**
     * The property values written inside an aspect's parentheses.
     *
     * ``@t::_aspects.MessageChannel(role = "producer", queue = "q")`` carries a
     * role and a queue. A single-valued aspect writes one value with no
     * property name, which belongs to no property and is therefore not a value
     * this returns - ``ServiceCommunicationTransport(transport = "plaintext")``
     * names its property because the aspect declares one.
     */
    static def Map<String, String> valuesOf(String written) {
        val values = newLinkedHashMap
        if (written === null) {
            return values
        }
        val open = written.indexOf("(")
        val close = written.lastIndexOf(")")
        if (open < 0 || close <= open) {
            return values
        }

        for (assignment : split(written.substring(open + 1, close))) {
            val separator = assignment.indexOf("=")
            if (separator > 0) {
                // A property named after a keyword is written with a caret -
                // ^protocol, ^technology - and the caret is syntax, not part of
                // the name a reader asks for.
                val name = assignment.substring(0, separator).trim.replaceFirst("^\\^", "")
                val value = assignment.substring(separator + 1).trim
                values.put(name, unquote(value))
            }
        }
        return values
    }

    /**
     * Split on commas that are not inside a quoted value.
     */
    private static def List<String> split(String text) {
        val parts = <String>newLinkedList
        var current = new StringBuilder
        var boolean quoted = false
        // Compared as strings: Xtend has no character literal, and a value may
        // hold a comma of its own - a path, a list - which must not split it.
        for (var int i = 0; i < text.length; i++) {
            val character = text.substring(i, i + 1)
            if ('"' == character) {
                quoted = !quoted
            }
            if ("," == character && !quoted) {
                parts.add(current.toString)
                current = new StringBuilder
            } else {
                current.append(character)
            }
        }
        if (!current.toString.trim.empty) {
            parts.add(current.toString)
        }
        return parts
    }

    private static def String unquote(String value) {
        val text = value.trim
        return if (text.length > 1 && text.startsWith('"') && text.endsWith('"'))
                text.substring(1, text.length - 1)
            else
                text
    }
}

/**
 * The level a dependency is declared at.
 *
 * LEMMA offers ``required microservices``, ``required interfaces`` and
 * ``required operations`` as alternatives rather than as layers, and a system
 * may use different ones for different microservices - Lakeside Mutual does.
 */
enum DependencyLevel {
    MICROSERVICE,
    INTERFACE,
    OPERATION
}

/**
 * One microservice requiring something of another.
 */
class Dependency {
    @Accessors
    ServiceNode source

    @Accessors
    ServiceNode target

    @Accessors
    DependencyLevel level

    /**
     * The interface it requires, or null when it requires the whole service.
     */
    @Accessors
    String targetInterface

    /**
     * The operation it requires, or null when it requires more than one.
     */
    @Accessors
    String targetOperation

    /**
     * What the model wrote, which is the only thing an unresolved dependency
     * has to show.
     */
    @Accessors
    String written

    @Accessors
    boolean resolved = true

    /**
     * Why it could not be resolved, or null.
     */
    @Accessors
    String reason

    new(ServiceNode source, DependencyLevel level, String written) {
        this.source = source
        this.level = level
        this.written = written
    }
}
