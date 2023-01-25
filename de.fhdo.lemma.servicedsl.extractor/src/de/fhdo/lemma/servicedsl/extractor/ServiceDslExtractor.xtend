package de.fhdo.lemma.servicedsl.extractor

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.PrimitiveType
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

        '''«importStatements»«microservices»'''
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
        '''
        «service.generateTechAnnotation»
        «preamble» microservice «service.lemmaName» {
            «IF service.interfaces.exists[!operations.empty]»
                «FOR iface : service.interfaces»
                    «iface.generate»
                «ENDFOR»
            «ELSE»
                [DEFINE_OPERATIONS]
            «ENDIF»
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
        '''
        interface «iface.name» {
            «FOR o: iface.operations»
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
    def generate(Operation operation) {
        val comment = if (operation.apiOperationComment !== null) {
            '''
            ---
            «operation.apiOperationComment.comment»
            «FOR param : operation.parameters.filter[!it.isOptional]»
            @required «param.name» [INSERT PARAMETER DESC HERE]
            «ENDFOR»
            «FOR param : operation.parameters.filter[it.isOptional]»
            @param «param.name» [INSERT PARAMETER DESC HERE]
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
        «FOR a: operation.aspects»«a.generate»«ENDFOR»
        '''
        
        val parameters = 
        	'''«FOR parameter : operation.parameters SEPARATOR ","»«generate(parameter)»«ENDFOR»'''

        '''«comment»«endpoints»«aspects»«operation.name»(«parameters»);'''
    }

    /**
     * Extract Parameter
     */
    private def generate(Parameter parameter) {
        '''
          	«FOR a : parameter.aspects BEFORE "\n\t" SEPARATOR "\n\t" AFTER "\n"»«a.generate»«ENDFOR» 
          	«"\t"»«parameter.communicationType.generate» «parameter.exchangePattern.generate» «
        	parameter.name» : «parameter.generateType»
    	'''
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
            getQualifiedNameParts(false, true) SEPARATOR '.'»«s»«ENDFOR»'''
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
            PrimitiveType: '''«importedType.import.name»::«type.typeName»'''
            ComplexType: '''«importedType.import.name»::«type.buildQualifiedName(".")»'''
            default:
                throw new IllegalArgumentException('''Type «type.class.simpleName» is not ''' +
                    "supported")
       }
    }
}