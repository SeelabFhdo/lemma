package de.fhdo.lemma.servicedsl.diagram

import java.util.List

/**
 * Generator of a PlantUML class diagram of the interfaces a system offers.
 *
 * A microservice offers interfaces, an interface offers operations, and an
 * operation takes and returns values - which is a class diagram: an interface is
 * an interface, an operation a method, its incoming parameters the method's
 * parameters and its outgoing one the result. What makes it a REST interface
 * rather than an abstract one is the verb and the path, so those are on every
 * operation that has them.
 *
 * The generator is a function of a [[ServiceGraph]] and nothing else: no file
 * system, no workspace, no Eclipse. What invokes it is a separate concern, so
 * what it produces can be checked without any of them.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class InterfaceDiagramGenerator {
    /**
     * The verb an operation is called with, by the aspect that says so.
     *
     * Spring states the verb through the annotation it maps onto an aspect, so
     * the aspect name is where the verb is. ``RequestMapping`` is deliberately
     * absent: it carries the verb in a property rather than in its name, and
     * guessing ``GET`` for it would state something the model does not say.
     */
    static val VERBS = #{
        "GetMapping" -> "GET",
        "PostMapping" -> "POST",
        "PutMapping" -> "PUT",
        "PatchMapping" -> "PATCH",
        "DeleteMapping" -> "DELETE"
    }

    /**
     * Shown for an operation whose parameters communicate nothing outgoing.
     */
    static val NO_RESULT = "void"

    /**
     * Where PlantUML breaks a line that is too long for one.
     *
     * An operation with several parameters, several results and a fault runs to
     * over two hundred characters, and PlantUML does not wrap a class member by
     * itself: the widest reconstructed interface came out 4786 pixels wide
     * against 1010 high, which no page holds. At 500 the same diagram is
     * 2638 by 1504, which one does. It is a skinparam, so a reader who wants it
     * otherwise changes one line of the generated source.
     */
    static val WRAP_WIDTH = 500

    /**
     * Generate the diagram of the interfaces in a graph.
     *
     * One package per microservice, because an interface belongs to a service
     * and a reader asks what a service offers.
     *
     * Only the microservices of the models that were asked for. The reader
     * follows imports, which a dependency diagram needs, but a reader who opens
     * one service model is asking what *that* service offers - and drawing
     * every service reachable from it turned the widest Lakeside Mutual diagram
     * into two packages side by side at four times as wide as high.
     *
     * @param graph the services to draw
     * @return the PlantUML source of the diagram
     */
    def String generate(ServiceGraph graph) {
        val drawn = graph.entryServices.filter[!interfaces.empty].toList

        return '''
            @startuml
            ' Generated from a LEMMA service model. Do not edit; regenerate.
            hide empty members
            hide circle
            skinparam shadowing false
            skinparam classAttributeIconSize 0
            skinparam wrapWidth «WRAP_WIDTH»

            «FOR service : drawn»
                «generateService(service)»
            «ENDFOR»
            @enduml
        '''.toString
    }

    /**
     * Generate a microservice as a package of the interfaces it offers.
     */
    private def generateService(ServiceNode service) {
        '''
        package «quote(service.name)»«serviceStereotype(service)» {
            «FOR anInterface : service.interfaces»
                «generateInterface(service, anInterface)»
            «ENDFOR»
        }
        '''
    }

    /**
     * Generate an interface, with its operations as methods.
     *
     * The alias is qualified with the microservice, because PlantUML identifies
     * a type by the name it is declared with whatever package it sits in, and
     * two microservices of a system may well offer an interface of the same
     * name - which would otherwise be drawn as one holding the operations of
     * both.
     */
    private def generateInterface(ServiceNode service, InterfaceNode anInterface) {
        '''
        interface «quote(anInterface.name)» as «aliasOf(service, anInterface)»«interfaceStereotype(anInterface)» {
            «FOR address : addressesOf(anInterface.endpoints)»
                «address»
            «ENDFOR»
            «IF !addressesOf(anInterface.endpoints).empty && !anInterface.operations.empty»
                ..
            «ENDIF»
            «FOR operation : anInterface.operations»
                «generateOperation(operation)»
            «ENDFOR»
        }
        '''
    }

    /**
     * One operation: its verb, its own path, its name, its parameters and its
     * result.
     */
    private def String generateOperation(OperationNode operation) {
        val parts = <String>newLinkedList
        val verb = verbOf(operation)
        if (verb !== null) {
            parts.add(verb)
        }
        parts.addAll(addressesOf(operation.endpoints))
        parts.add('''«operation.name»(«parametersOf(operation)»)''')

        val result = '''«parts.join(" ")» : «resultOf(operation)»'''
        val faults = operation.parameters.filter[fault].toList
        val properties = <String>newLinkedList
        if (operation.notImplemented) {
            properties.add("noimpl")
        }
        if (operation.parameters.exists[asynchronous]) {
            properties.add("async")
        }
        if (!faults.empty) {
            properties.add('''fault «faults.map[typeNameOf].join(", ")»''')
        }

        return '''«result»«IF !properties.empty» {«properties.join(", ")»}«ENDIF»'''.toString
    }

    /**
     * The verb an operation is called with, or null when the model does not say.
     */
    private def String verbOf(OperationNode operation) {
        for (aspect : operation.aspects) {
            val verb = VERBS.get(aspect.name)
            if (verb !== null) {
                return verb
            }
        }
        return null
    }

    /**
     * The parameters of an operation's method: the ones it takes in.
     *
     * A fault is not a parameter of the call, and an outgoing parameter is the
     * result, so neither belongs here.
     */
    private def String parametersOf(OperationNode operation) {
        return operation.parameters
            .filter[!fault && !outgoing]
            .map['''«name»«IF optional»?«ENDIF» : «typeNameOf»''']
            .join(", ")
    }

    /**
     * The result of an operation.
     *
     * One outgoing parameter is the result. Several are all of it, named,
     * because LEMMA lets an operation communicate more than one value and
     * showing only the first would drop the rest.
     */
    private def String resultOf(OperationNode operation) {
        val outgoing = operation.parameters.filter[!fault && it.outgoing].toList
        return switch (outgoing.size) {
            case 0: NO_RESULT
            case 1: outgoing.head.typeNameOf
            default: '''(«outgoing.map['''«name» : «typeNameOf»'''].join(", ")»)'''.toString
        }
    }

    /**
     * The name a parameter's type is shown as.
     *
     * The simple name: in a service model every complex type is imported, so
     * the alias and the context would be on every single parameter and say
     * nothing about the interface.
     */
    private def String typeNameOf(ParameterNode parameter) {
        val typeName = parameter.typeName
        if (typeName.nullOrEmpty) {
            return "unspecified"
        }
        if (parameter.primitive) {
            return typeName
        }
        val separator = typeName.lastIndexOf(".")
        return if (separator >= 0) typeName.substring(separator + 1) else typeName
    }

    /**
     * Every address the endpoints of an element answer under.
     */
    private def List<String> addressesOf(List<EndpointReference> endpoints) {
        return endpoints.map[addresses].flatten.filter[!nullOrEmpty].toList
    }

    /**
     * The protocols an interface speaks, as its stereotype.
     */
    private def String interfaceStereotype(InterfaceNode anInterface) {
        val names = <String>newLinkedList
        names.addAll(anInterface.endpoints.map[protocol].filterNull)
        if (anInterface.notImplemented) {
            names.add("noimpl")
        }
        return render(names)
    }

    /**
     * What a microservice is, as its stereotype: only where it is not the
     * ordinary case, so the diagram marks what is worth noticing.
     */
    private def String serviceStereotype(ServiceNode service) {
        val names = <String>newLinkedList
        if (service.visibility !== null && "PUBLIC" != service.visibility) {
            names.add(service.visibility.toLowerCase)
        }
        if (service.type !== null && "FUNCTIONAL" != service.type) {
            names.add(service.type.toLowerCase)
        }
        return render(names)
    }

    private def String render(List<String> names) {
        val distinct = names.toSet.toList
        if (distinct.empty) {
            return ""
        }
        return ''' <<«distinct.join(", ")»>>'''.toString
    }

    /**
     * The name an interface is referred to by inside the diagram.
     */
    private def String aliasOf(ServiceNode service, InterfaceNode anInterface) {
        return '''«service.qualifiedName»_«anInterface.name»'''
            .toString.replaceAll("[^A-Za-z0-9_]", "_")
    }

    /**
     * Quote a name: a LEMMA identifier may be masked with a caret, which
     * PlantUML would otherwise read as its own syntax.
     */
    private def String quote(String name) {
        return '''"«name»"'''.toString
    }
}
