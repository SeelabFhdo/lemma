package de.fhdo.lemma.servicedsl.extractor

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.PrimitiveValue
import de.fhdo.lemma.service.Endpoint
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ImportedType
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.Parameter
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.Protocol
import de.fhdo.lemma.technology.TechnologySpecificCollectionType
import de.fhdo.lemma.technology.TechnologySpecificDataStructure
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import de.fhdo.lemma.service.ImportedServiceAspect


/**
 * Model-to-text extractor for the Service DSL.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ServiceDslExtractor {
    static val ID_PATTERN = "(\\^?)([a-zA-Z_])\\w*"
    static val QUALIFIED_NAME_PATTERN = '''«ID_PATTERN»(\.«ID_PATTERN»)*'''
    static val QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN = '''«ID_PATTERN»\.''' +
        QUALIFIED_NAME_PATTERN

    var importedTechnologyAliases = <String>newArrayList

    /**
     * Extract ServiceModel
     */
    def String extractToString(ServiceModel serviceModel) {
        val imports = serviceModel.imports.map[it.generate]
        val importStatements = if (!imports.empty)
                String.join("\n", imports) + "\n\n"
            else
                ""

        val microservices = String.join("\n\n", serviceModel.microservices.map[generate])

        return '''«importStatements»«microservices»'''.toString.withoutTrailingSpace
    }

    /**
     * Remove the space at the end of a line.
     *
     * A line separating two elements is emitted at the indentation of the
     * element, so it would otherwise consist of nothing but that indentation.
     * No line of a service model ends inside a string literal, so a space
     * before a line break is never part of the content.
     */
    private def withoutTrailingSpace(String model) {
        return model.replaceAll("(?m)[ \\t]+$", "")
    }

    /**
     * Extract Imports
     */
    private def generate(Import ^import) {
        val importTypeKeyword = switch(^import.importType) {
            case DATATYPES: "datatypes"
            case MICROSERVICES: "microservices"
            case TECHNOLOGY: "technology"
            default:
                throw new IllegalArgumentException('''Type «^import.importType» is not ''' +
                    "supported")
        }

        // If it is a technology, add it to the names list for later use in the generation
        if (importTypeKeyword == "technology")
            importedTechnologyAliases.add(^import.name)

        return '''import «importTypeKeyword» from "«^import.importURI»" as «^import.name»'''
    }

    /**
     * Extract Microservice
     */
    private def generate(Microservice service) {
        val preamble = '''«service.visibility.generate» «service.type.generate»'''

        val aspects = '''
        «FOR a: service.aspects»
            «a.generate»
        «ENDFOR»
        '''

        '''
        «service.generateTechAnnotation»
        «aspects»«preamble» microservice «service.lemmaName» {
            «service.generateRequired»«IF service.interfaces.exists[!operations.empty]»
                «FOR iface : service.interfaces SEPARATOR '\n'»
                    «iface.generate»
                «ENDFOR»
            «ELSE»
                [DEFINE_OPERATIONS]
            «ENDIF»
        }'''
    }

    /**
     * Extract what a microservice requires of others
     *
     * The three levels are written in the order the grammar expects them, and
     * only those that hold something: a microservice, an interface and an
     * operation are alternatives for one dependency, so in practice a model uses
     * one of them per callee.
     */
    private def generateRequired(Microservice service) {
        val microservices = service.requiredMicroservices.map[
            '''«^import?.name»::«microservice?.name»'''.toString]
        val interfaces = service.requiredInterfaces.map[
            '''«^import?.name»::«^interface?.name»'''.toString]
        val operations = service.requiredOperations.map[
            '''«^import?.name»::«operation?.name»'''.toString]

        if (microservices.empty && interfaces.empty && operations.empty) {
            return ""
        }

        '''
        «IF !microservices.empty»«required("microservices", microservices)»«ENDIF»
        «IF !interfaces.empty»«required("interfaces", interfaces)»«ENDIF»
        «IF !operations.empty»«required("operations", operations)»«ENDIF»

        '''
    }

    /**
     * Extract one required block, one reference per line
     */
    private def required(String kind, Iterable<String> references) {
        '''
        required «kind» {
            «FOR reference : references SEPARATOR ','»
                «reference»
            «ENDFOR»
        }'''
    }

    /**
     * Extracts the name of a Microservice
     */
    private def lemmaName(Microservice service) {
        return if (service.name.matches(QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN))
                service.name
            else
                '''ADD_QUALIFYING_PART.«service.name»'''
    }

    /**
     * Extract Visibility of a Microservice
     */
    private def generate(Visibility visibility) {
        return switch(visibility) {
            case ARCHITECTURE: 'architecture'
            case INTERNAL: 'internal'
            case PUBLIC: 'public'
            default: throw new IllegalArgumentException('''Type «visibility» is not supported.''')
        }
    }

    /**
     * Extract MicroserviceType of a Microservice
     */
    private def generate(MicroserviceType type) {
        return switch(type) {
            case FUNCTIONAL: 'functional'
            case INFRASTRUCTURE: 'infrastructure'
            case UTILITY: 'utility'
            default: throw new IllegalArgumentException('''Type «type» is not supported.''')
        }
    }

    /**
     * Extract Interface
     */
    private def generate(Interface iface) {
        var endpoints = ""
        if (!iface.endpoints.nullOrEmpty) {
            endpoints = '''
            @endpoints(«FOR e: iface.endpoints»«e.generate»«ENDFOR»)
            '''
        }

        val aspects = '''
        «FOR a: iface.aspects»
            «a.generate»
        «ENDFOR»
        '''

        '''
        «endpoints»«aspects»«IF iface.notImplemented»noimpl «ENDIF»interface «iface.name» {
            «FOR o: iface.operations SEPARATOR '\n'»
                «o.generate»
            «ENDFOR»
        }'''
    }

    /**
     * Extract Endpoint
     */
    private def generate(Endpoint endpoint) {
        '''«FOR ep: endpoint.protocols SEPARATOR '; '»
            «ep.importedProtocol.generate»:«
        ENDFOR
        »«FOR ea: endpoint.addresses SEPARATOR ', '
            »"«ea»"«
        ENDFOR»;'''
    }

    /**
     * Extract Operation
     */
    private def generate(Operation operation) {
        val comment = if (operation.apiOperationComment !== null) {
            '''
            ---
            «operation.apiOperationComment.comment»
            «FOR param : operation.parameters.filter[!it.isOptional && !it.outgoing]»
            @requires «param.name» [INSERT PARAMETER DESC HERE]
            «ENDFOR»
            «FOR param : operation.parameters.filter[it.isOptional && !it.outgoing]»
            @param «param.name» [INSERT PARAMETER DESC HERE]
            «ENDFOR»
            «FOR param : operation.parameters.filter[it.outgoing]»
            @returns «param.name» [INSERT PARAMETER DESC HERE]
            «ENDFOR»
            ---
            '''
        }

        var endpoints = ""
        if (!operation.endpoints.nullOrEmpty) {
            endpoints ='''
            @endpoints(«FOR e: operation.endpoints»«e.generate»«ENDFOR»)
            '''
        }

        val aspects = '''
        «FOR a: operation.aspects»
            «a.generate»
        «ENDFOR»
        '''

        val notImplemented = if (operation.notImplemented) "noimpl " else ""

        // One parameter per line. An operation of a reconstructed REST
        // interface carries an aspect on most of its parameters, which on one
        // line runs to several hundred characters.
        if (operation.parameters.empty)
            return '''«comment»«endpoints»«aspects»«notImplemented»«operation.name»();'''

        '''
        «comment»«endpoints»«aspects»«notImplemented»«operation.name»(
            «FOR p : operation.parameters SEPARATOR ','»
                «p.generate»
            «ENDFOR»
        );'''
    }

    /**
     * Helper to check if a given Parameter is outgoing
     */
    private def outgoing(Parameter parameter) {
        return parameter.exchangePattern == ExchangePattern.OUT
    }

    /**
     * Extract Parameter
     */
    private def generate(Parameter parameter) {
        // The separator belongs behind an aspect rather than in front of the
        // communication type, which gave a parameter without one a leading
        // space and read as ",  sync out" in the extracted model.
        val aspects = if (parameter.aspects.empty)
                ""
            else
                String.join(" ", parameter.aspects.map[generate.toString]) + " "

        '''«aspects»«parameter.communicationType.generate» «
        parameter.exchangePattern.generate» «parameter.name» : «parameter.generateType»'''
    }

    /**
     * Extract CommunicationType
     */
    private def generate(CommunicationType type) {
        return switch(type) {
            case ASYNCHRONOUS: "async"
            case SYNCHRONOUS: "sync"
            default: throw new IllegalArgumentException('''Type «type» is not supported.''')
        }
    }

    /**
     * Extract ExchangePattern
     */
    private def generate(ExchangePattern pattern) {
        return switch(pattern) {
            case IN: "in"
            case OUT: "out"
            case INOUT: "inout"
            default: throw new IllegalArgumentException('''Type «pattern» is not supported.''')
        }
    }

    /**
     * Extract ImportedServiceAspect
     */
    private def generate(ImportedServiceAspect aspect) {
        '''@«aspect.importedAspect.technology.name»::«FOR s : aspect.importedAspect.
            getQualifiedNameParts(false, true) SEPARATOR '.'»«s»«ENDFOR»«aspect.generateValues»'''
    }

    /**
     * Extract the values assigned to the properties of an ImportedServiceAspect
     *
     * An aspect with a single value states it without naming the property, and
     * one with several names each of them. An aspect without values is written
     * without parentheses, which is what a property-less aspect such as Spring's
     * GetMapping needs.
     */
    private def generateValues(ImportedServiceAspect aspect) {
        if (aspect.singlePropertyValue !== null)
            return '''(«aspect.singlePropertyValue.generate»)'''
        if (aspect.values.nullOrEmpty)
            return ""
        return '''(«FOR v : aspect.values SEPARATOR ', '»«v.property.name.escaped» = «
            v.value.generate»«ENDFOR»)'''
    }


    /**
     * Keywords of the Service DSL, which an identifier has to be escaped
     * against.
     *
     * A technology model may name an aspect property after one of these -
     * ``protocol`` and ``technology`` are both keywords and both natural names
     * for a property - and writing the name unescaped produces a model that
     * does not parse: "no viable alternative at input 'protocol'".
     *
     * Taken from the keyword literals of ServiceDsl.xtext. Single-letter
     * literals are left out: they belong to the number and string terminals
     * rather than to the syntax, and no identifier is one character that
     * collides.
     */
    static val KEYWORDS = #{
        "aggregate", "applicationService", "architecture", "as", "aspect", "aspects",
        "async", "based", "boolean", "byte", "char", "closure",
        "collection", "communication_type", "compatibility", "containers", "context", "data",
        "data_format", "datatypes", "date", "default", "deployment", "domainEvent",
        "domainService", "double", "endpoints", "entity", "enum", "environments",
        "exchange_pattern", "extends", "factory", "fault", "fields", "float",
        "for", "format", "formats", "from", "function", "functional",
        "hide", "identifier", "immutable", "import", "in", "infrastructure",
        "infrastructureService", "inout", "int", "interface", "interfaces", "internal",
        "long", "mandatory", "matrix", "microservice", "microservices", "neverEmpty",
        "noimpl", "on", "operation", "operations", "out", "param",
        "parameters", "part", "primitive", "procedure", "properties", "protocol",
        "protocols", "public", "refers", "repository", "required", "requires",
        "returned", "returns", "selector", "service", "short", "sideEffectFree",
        "singleval", "specification", "string", "structure", "sync", "technologies",
        "technology", "type", "typedef", "types", "utility", "validator",
        "valueObject", "version", "with"
    }

    /**
     * An identifier, escaped with a caret where it is a keyword.
     *
     * The same escape the DSL uses for a parameter named ``fields``, which the
     * reconstructed Lakeside Mutual models already carry as ``^fields``.
     */
    private def String escaped(String identifier) {
        if (identifier === null) {
            return identifier
        }
        return if (KEYWORDS.contains(identifier)) "^" + identifier else identifier
    }

    /**
     * Extract PrimitiveValue
     */
    private def generate(PrimitiveValue value) {
        if (value.stringValue !== null)
            '''"«value.stringValue»"'''
        else if (value.booleanValue !== null)
            '''«value.booleanValue»'''
        else if (value.numericValue !== null)
            '''«value.numericValue»'''
        else
            '''""'''
    }

    /**
     * Extract Parameter
     */
    private def generateType(Parameter parameter) {
        return if (parameter.primitiveType !== null)
            parameter.primitiveType.generate
        else if (parameter.importedType !== null)
            parameter.importedType.generate
        else
            null
    }

    /**
     * Extract PrimitiveType
     */
    private def generate(PrimitiveType type) {
        return type.typeName
    }

    /**
     * Extract Technology Annotations of a Microservice
     */
    private def generateTechAnnotation(Microservice service) {
        '''«FOR tech : service.serviceModel.imports.filter[it.importType == ImportType.TECHNOLOGY]
            »@technology(«tech.name»)«ENDFOR»'''
    }

    /**
     * Extract Protocol
     */
    private def generate(Protocol protocol) {
        val techName = protocol.technology?.name ?: '''[PROTOCOL TECHNOLOGY URI NOT DEFINED]'''
        return '''«techName»::«FOR p : protocol.qualifiedNameParts SEPARATOR '.'»«p»«ENDFOR»'''
    }

    /**
     * Extract ImportedType
     */
    private def generate(ImportedType importedType) {
        val type = importedType.type
        return switch(type) {
            // A type of a technology model is referenced by its qualified name,
            // which is what the scope of the Service DSL is built from. It
            // carries no type name, so the branches below would write none.
            TechnologySpecificPrimitiveType:
                '''«importedType.import.name»::«type.qualifiedNameParts.join(".")»'''
            TechnologySpecificCollectionType:
                '''«importedType.import.name»::«type.qualifiedNameParts.join(".")»'''
            TechnologySpecificDataStructure:
                '''«importedType.import.name»::«type.qualifiedNameParts.join(".")»'''
            PrimitiveType: '''«importedType.import.name»::«type.typeName»'''
            ComplexType: '''«importedType.import.name»::«type.buildQualifiedName(".")»'''
            default:
                throw new IllegalArgumentException('''Type «type.class.simpleName» is not ''' +
                    "supported")
       }
    }
}