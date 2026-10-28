package de.fhdo.lemma.reconstruction.service

import de.fhdo.lemma.reconstruction.domain.ClassType
import de.fhdo.lemma.reconstruction.util.TechnologyTypes
import java.util.LinkedHashMap
import java.util.List
import java.util.regex.Pattern

/**
 * What a reconstructed microservice requires of the others, at the finest level
 * that can be resolved.
 *
 * The reconstruction reports which endpoints of another service a client
 * addresses - a verb and a path, read from the client's own annotations. The
 * callee's interfaces and operations carry the addresses they answer under. So
 * an endpoint of a call can be matched to an operation of the callee, and the
 * dependency can be stated as `required operations` rather than as a dependency
 * on the whole service.
 *
 * Three levels exist in the Service DSL and they are **alternatives, not
 * layers**: requiring an operation whose interface or microservice is also
 * required is reported as redundant by the validation. So exactly one level is
 * chosen per callee - the finest one that resolves.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ServiceDependencies {
    /**
     * Level a dependency is stated at.
     */
    enum Level {
        OPERATION,
        INTERFACE,
        MICROSERVICE
    }

    /**
     * A dependency of one microservice on another.
     */
    static class Dependency {
        /** Name of the callee, as the reconstruction knows it. */
        public val String name

        /** Qualified name of the callee, which a reference to it needs. */
        public val String qualifiedName

        /** Level the dependency is stated at. */
        public val Level level

        /**
         * Qualified names to require, relative to the callee's model: the
         * callee itself, its interfaces, or its operations, according to the
         * level.
         */
        public val List<String> required

        new (String name, String qualifiedName, Level level, List<String> required) {
            this.name = name
            this.qualifiedName = qualifiedName
            this.level = level
            this.required = required
        }
    }

    static val SERVICE_CALL = "ServiceCall"
    static val SERVICE_CALL_ENDPOINT = "ServiceCallEndpoint"
    static val TARGET = "target"
    static val TARGET_KIND = "targetKind"
    static val TARGET_QUALIFIED_NAME = "targetQualifiedName"
    static val ENDPOINT = "Endpoint"
    static val ADDRESS = "address"
    static val VERB = "verb"
    static val PATH = "path"
    static val SERVICE = "SERVICE"
    static val MAPPING_SUFFIX = "Mapping"

    static val TECHNOLOGY_MODEL = "spring.technology"

    /**
     * A path variable, whose name each side of a call chooses for itself: a
     * client may write /{id} where the service writes /{customerId}.
     */
    static val PATH_VARIABLE = Pattern.compile("\\{[^}]*\\}")

    /**
     * Read the dependencies of a microservice on the others of its system.
     *
     * @param caller the microservice whose dependencies are wanted
     * @param microservices every reconstructed microservice of the system,
     *        including the caller
     * @return one dependency per callee, ordered by its qualified name
     */
    def static List<Dependency> of(Microservice caller, List<Microservice> microservices) {
        val dependencies = new LinkedHashMap<String, Dependency>
        if (caller === null || microservices.nullOrEmpty) {
            return dependencies.values.toList
        }

        val byQualifiedName = new LinkedHashMap<String, Microservice>
        microservices.forEach[byQualifiedName.put(qualifedName, it)]

        caller.metaData.filter[name == SERVICE_CALL].forEach[ call |
            if (call.values.get(TARGET_KIND) != SERVICE) {
                return
            }
            val qualifiedName = call.values.get(TARGET_QUALIFIED_NAME)
            val callee = byQualifiedName.get(qualifiedName)
            // A callee the reconstruction did not produce a model for cannot be
            // referred to, whatever the call says about it.
            if (qualifiedName.nullOrEmpty || callee === null || callee === caller) {
                return
            }
            dependencies.put(qualifiedName,
                resolve(caller, callee, call.values.get(TARGET), qualifiedName))
        ]

        return dependencies.values.sortBy[qualifiedName].toList
    }

    /**
     * Choose the level for one callee and collect what to require.
     */
    private def static Dependency resolve(Microservice caller, Microservice callee,
        String name, String qualifiedName) {
        val endpoints = caller.metaData.filter[
            it.name == SERVICE_CALL_ENDPOINT &&
            it.values.get(TARGET_QUALIFIED_NAME) == qualifiedName
        ].toList

        if (endpoints.empty) {
            // The client states no endpoint - every HTTP client that assembles
            // its paths in the call expression is of that kind - so the service
            // is all that can be said to be required.
            return new Dependency(name, qualifiedName, Level.MICROSERVICE,
                #[callee.qualifedName])
        }

        val operations = newLinkedHashSet
        val interfaces = newLinkedHashSet
        var allMatched = true
        for (endpoint : endpoints) {
            val match = match(callee, endpoint.values.get(VERB), endpoint.values.get(PATH))
            if (match === null) {
                allMatched = false
            } else {
                interfaces.add(interfaceName(callee, match.key))
                if (requirable(match.value)) {
                    operations.add(operationName(callee, match.key, match.value))
                } else {
                    // An operation the generator will mark noimpl is not in the
                    // scope of a reference, so the interface is as fine as this
                    // dependency can be stated.
                    allMatched = false
                }
            }
        }

        // Sorted, so the order of the references follows the names rather than
        // the order the endpoints happened to be read in.
        if (allMatched && !operations.empty) {
            return new Dependency(name, qualifiedName, Level.OPERATION, operations.sort)
        }
        if (!interfaces.empty) {
            return new Dependency(name, qualifiedName, Level.INTERFACE, interfaces.sort)
        }
        return new Dependency(name, qualifiedName, Level.MICROSERVICE, #[callee.qualifedName])
    }

    /**
     * Find the interface and operation of the callee that answer under a verb
     * and a path, or null when none or more than one does.
     */
    private def static Pair<Interface, Operation> match(Microservice callee, String verb,
        String path) {
        if (verb.nullOrEmpty || path.nullOrEmpty) {
            return null
        }
        val wanted = normalise(path)
        val matches = newLinkedList
        for (iface : callee.interfaces) {
            val base = address(iface.metaData)
            for (operation : iface.operations) {
                if (verb != verbOf(operation)) {
                    // Nothing else is checked for an operation of another verb:
                    // the same path under GET and PUT are two endpoints.
                } else if (normalise(join(base, address(operation.metaData))) == wanted) {
                    matches.add(iface -> operation)
                }
            }
        }
        // More than one match says the reconstruction cannot tell the endpoints
        // apart, which is not something to pick a winner from.
        return if (matches.size == 1) matches.head else null
    }

    /**
     * Whether an operation of the callee can be required.
     *
     * The generator marks an operation that has a parameter of an unresolvable
     * type as not implemented, and such an operation is not in the scope of a
     * reference. The condition is the generator's, repeated here because the
     * callee's model is not generated when the caller's is.
     */
    private def static boolean requirable(Operation operation) {
        return !operation.parameters.exists[ parameter |
            parameter.primitiveType === null &&
            parameter.complexType !== null &&
            parameter.complexType.classType === ClassType.UNSPECIFIED &&
            TechnologyTypes.declaredTypes(TECHNOLOGY_MODEL)
                .get(parameter.complexType.name) === null
        ]
    }

    /**
     * The verb an operation answers under, which is the name of the mapping
     * annotation the reconstruction reported for it.
     */
    private def static String verbOf(Operation operation) {
        return operation.metaData.findFirst[name.endsWith(MAPPING_SUFFIX)]?.name
    }

    /**
     * The address an element answers under, or null when it has none.
     */
    private def static String address(List<de.fhdo.lemma.reconstruction.domain.MetaData> metaData) {
        return metaData.findFirst[name == ENDPOINT]?.values?.get(ADDRESS)
    }

    /**
     * Join the address of an interface with the address of one of its
     * operations, the way Spring and LEMMA both read them: relative to the
     * element above.
     */
    private def static String join(String base, String address) {
        val parts = #[base, address].filterNull.map[replaceAll("^/+|/+$", "")].filter[!empty]
        return "/" + parts.join("/")
    }

    /**
     * Reduce a path to what a comparison can rely on: each side of a call names
     * its path variables for itself.
     */
    private def static String normalise(String path) {
        if (path === null) {
            return ""
        }
        val collapsed = PATH_VARIABLE.matcher(path).replaceAll("{}")
        return "/" + collapsed.replaceAll("^/+|/+$", "")
    }

    /**
     * Name of an interface of the callee, as a reference to it reads: the
     * callee's qualified name and the interface's simple name, which is the one
     * the generator gives it.
     */
    private def static String interfaceName(Microservice callee, Interface iface) {
        return '''«callee.qualifedName».«iface.name.split("\\W").lastOrNull»'''.toString
    }

    /**
     * Name of an operation of the callee, which is its interface's name and its
     * own.
     */
    private def static String operationName(Microservice callee, Interface iface,
        Operation operation) {
        return '''«interfaceName(callee, iface)».«operation.name»'''.toString
    }

    /**
     * The service models of a system lie beside each other, so the import of a
     * callee's model is its file name.
     */
    def static String importUriOf(Dependency dependency) {
        return '''«dependency.name».services'''.toString
    }

    /**
     * Alias a callee's model is imported under. The name of the service, which
     * is what the reconstruction already uses for the file.
     */
    def static String aliasOf(Dependency dependency) {
        return dependency.name
    }
}
