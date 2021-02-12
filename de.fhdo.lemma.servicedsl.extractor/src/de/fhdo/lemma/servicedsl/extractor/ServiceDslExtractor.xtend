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

class ServiceDslExtractor {
    static val IMPORTED_TECH_ALIASES = <String>newArrayList()
    static val ID_PATTERN = "(\\^?)([a-zA-Z_])\\w*"
    static val QUALIFIED_NAME_PATTERN = '''«ID_PATTERN»(\.«ID_PATTERN»)*'''
    static val QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN = '''«ID_PATTERN»\.''' +
        QUALIFIED_NAME_PATTERN

    /**
     * Extract ServiceModel
     */
    def String extractToString(ServiceModel serviceModel) {
        val imports = <String>newArrayList
        serviceModel.imports.forEach[imports.add(it.generate)]
        val importStatements = if (!imports.empty)
                String.join("\n", imports) + "\n\n"
            else
                ""

        val microservices = String.join("\n\n", serviceModel.microservices.map[generate])

        return '''«importStatements»«microservices»'''
    }

    private def generate(Import ^import) {
        val importTypeKeyword = switch(^import.importType) {
            case DATATYPES: "datatypes"
            case MICROSERVICES: "microservices"
            case TECHNOLOGY: "technology"
            default: null
        }
        //if it is a technology add it to the names list for later use in the generation
        if(importTypeKeyword === "technology") IMPORTED_TECH_ALIASES.add(^import.name)

        return '''import «importTypeKeyword» from "«^import.importURI»" as «^import.name»'''
    }

    private def generate(Microservice service) {
        val techImports = generateTechAnnotation(service)
        val preamble = '''«service.visibility.generate» «service.type.generate»'''
        val hasInterfaceOperations = service.interfaces.exists[!operations.empty]
        return '''
        «techImports»
        «preamble» microservice «service.lemmaName» {
            «IF hasInterfaceOperations»
                «FOR iface : service.interfaces»
                    «iface.generate»
                «ENDFOR»
            «ELSE»
                [DEFINE_OPERATIONS]
            «ENDIF»
        }'''
    }

    private def lemmaName(Microservice service) {
        return if (service.name.matches(QUALIFIED_NAME_WITH_AT_LEAST_ONE_LEVEL_PATTERN))
                service.name
            else
                '''ADD_QUALIFYING_PART.«service.name»'''
    }

    private def generate(Visibility visibility) {
        return switch(visibility) {
            case INTERNAL: 'internal'
            case PUBLIC: 'public'
            default: 'architecture'
        }
    }

    private def generate(MicroserviceType type) {
        return switch(type) {
            case FUNCTIONAL: 'functional'
            case INFRASTRUCTURE: 'infrastructure'
            case UTILITY: 'utility'
            default: null
        }
    }

    private def generate(Interface iface) {
        return '''
        interface «iface.name» {
            «FOR o: iface.operations»
                «o.generate»
            «ENDFOR»
        }'''
    }

    private def generate(Endpoint endpoint) {
        return '''«FOR ep: endpoint.protocols SEPARATOR '; '»
        «ep.importedProtocol.generate»:«ENDFOR
        »«FOR ea: endpoint.addresses SEPARATOR ', '»"«ea»"«ENDFOR»;'''
    }

    private def generate(Operation operation) {
        val endpoint =
        '''
        @endpoints(«FOR e: operation.endpoints»«e.generate»«ENDFOR»)
        '''
        val aspects = '''
        «FOR  a: operation.aspects»«a.generate»«ENDFOR»
        '''
        val parameters = String.join(", ", operation.parameters.map[generate])

        val comment = if(operation.apiOperationComment !== null) {
            '''
            ---
            «operation.apiOperationComment.comment»
            «FOR param : operation.parameters.filter[!it.isOptional]»
            @required «param.name» [INSERT PARAMETER DESC HERE]
            «ENDFOR»
            ---
            '''
        }
        return '''«comment»«endpoint»«aspects»«operation.name»(«parameters»);'''
    }

    private def generate(Parameter parameter) {
        return '''«FOR a : parameter.aspects SEPARATOR ' '»«a.generate»«ENDFOR
        » «parameter.communicationType.generate» «parameter.exchangePattern.generate» «
        parameter.name» : «parameter.generateType»'''
    }

    private def generate(CommunicationType type) {
        return switch(type) {
            case ASYNCHRONOUS: "async"
            case SYNCHRONOUS: "sync"
            default: null
        }
    }

    private def generate(ExchangePattern pattern) {
        return switch(pattern) {
            case IN: "in"
            case OUT: "out"
            case INOUT: "inout"
            default: null
        }
    }

    private def generate(ImportedServiceAspect aspect) {
        return '''@«aspect.importedAspect?.technology?.name»::«
        FOR s : aspect.importedAspect.getQualifiedNameParts(false, true) SEPARATOR '.'»«s
        »«ENDFOR»'''
    }

    private def generateType(Parameter parameter) {
        return if (parameter.primitiveType !== null)
                (parameter.primitiveType as PrimitiveType).generate
            else
                parameter.importedType.generate
    }

    private def generate(PrimitiveType type) {
        return type.typeName
    }
    private def generateTechAnnotation(Microservice service) {
        return '''«FOR tech :
            service.serviceModel.imports.filter[it.importType == ImportType.TECHNOLOGY]
            »@technology(«tech.name»)«ENDFOR»'''
    }
    private def generate(Protocol protocol) {
        val techName = protocol.technology?.name ?: '''[PROTOCOL TECHNOLOGY URI NOT DEFINED]'''
        return '''«techName»::«FOR p : protocol.qualifiedNameParts SEPARATOR '.'»«p»«ENDFOR»'''
    }

    private def generate(ImportedType importedType) {
        switch (importedType.import.importType) {
            case ImportType.TECHNOLOGY: {
                return '''«importedType.import.name»::«importedType.type»'''
            }
            case ImportType.DATATYPES: {
                val importedTypeName = (importedType.type as ComplexType).buildQualifiedName(".")
                return '''«importedType.import.name»::«importedTypeName»'''
            }
            default: {
                return '''[COULD NOT MATCH IMPORTED TYPE]'''
            }
        }
    }

}