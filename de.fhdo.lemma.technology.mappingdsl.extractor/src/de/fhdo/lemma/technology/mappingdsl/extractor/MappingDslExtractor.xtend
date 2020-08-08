package de.fhdo.lemma.technology.mappingdsl.extractor

import de.fhdo.lemma.technology.mapping.TechnologyMapping
import java.util.function.Function
import java.util.List
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.service.TechnologyReference
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping

/**
 * Model-to-text extractor for the Mapping DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MappingDslExtractor {
    /**
     * Extract TechnologyMapping
     */
    def String extractToString(TechnologyMapping mappingModel) {
        val sb = new StringBuilder()
        sb.appendAsSeparatedLines(mappingModel.imports, [it.extractToString])
        sb.appendAsSeparatedLines(mappingModel.typeMappings, [it.extractToString])
        return sb.toString
    }

    /**
     * Helper to append a list of lines to a StringBuilder and separate them from already existing
     * lines in that StringBuilder by an empty line
     */
    private def <T> void appendAsSeparatedLines(StringBuilder sb, List<T> lines,
        Function<T, String> stringConverter) {
        if (lines.empty) {
            return
        }

        if (sb.length > 0 && !sb.toString.endsWith("\n\n")) {
            if (sb.toString.endsWith("\n"))
                sb.append("\n")
            else
                sb.append("\n\n")
        }
        val stringLines = lines.map[stringConverter.apply(it)].join("\n")
        sb.append(stringLines)
    }

    /**
     * Extract Import
     */
    def String extractToString(Import _import) {
        val importTypeString = switch(_import.importType) {
            case DATATYPES: 'datatypes'
            case MICROSERVICES: 'microservices'
            case TECHNOLOGY: 'technology'
        }
        '''import «importTypeString» from «_import.importURI» as «_import.name»'''
    }

    /**
     * Extract ComplexTypeMapping
     */
    def String extractToString(ComplexTypeMapping mapping) {
        val preamble = '''
            «FOR r : mapping.technologyReferences SEPARATOR "\n"»«r.extractToString»«ENDFOR»
            type «mapping.type.extractToString»'''

        if (mapping.aspects.empty &&
            mapping.fieldMappings.empty &&
            mapping.operationMappings.empty)
            return '''«preamble» {}'''

        // Extract aspects
        var extractedMapping = '''
            «preamble» {
                «IF !mapping.aspects.empty»aspects {«ENDIF»
                    «FOR a : mapping.aspects SEPARATOR "\n"»«a.extractToString»«ENDFOR»
                «IF !mapping.aspects.empty»}«ENDIF»'''

        // Extract field mappings
        if (!mapping.fieldMappings.empty) {
            if (!mapping.aspects.empty)
                extractedMapping += "\n\n"

            extractedMapping = '''
                «extractedMapping»
                    «FOR f : mapping.fieldMappings SEPARATOR "\n"»«f.extractToString»«ENDFOR»
                '''
        }

        if (!extractedMapping.endsWith("\n"))
            extractedMapping += "\n"

        return '''«extractedMapping»}'''
    }

    /**
     * Extract TechnologyReference
     */
    private def String extractToString(TechnologyReference reference) {
        '''@technology(«reference.technology.name»''' +
        '''«IF reference.isIsTypeDefinitionTechnology», typedef=true«ENDIF»''' +
        ")"
    }

    /**
     * Extract ImportedComplexTypeToMap
     */
    private def String extractToString(ImportedComplexTypeToMap mappedType) {
        '''«mappedType.serviceModelImport.name»::''' +
        '''«mappedType.dataModelImport.name»::''' +
        mappedType.type.buildQualifiedName(".")
    }

    /**
     * Extract TechnologySpecificImportedServiceAspect
     */
    private def String extractToString(TechnologySpecificImportedServiceAspect importedAspect) {
        '''«importedAspect.technology.name»::''' +
        '''«importedAspect.aspect.buildQualifiedName(".", false, true)»;'''
    }

    /**
     * Extract TechnologySpecificFieldMapping
     */
    private def String extractToString(TechnologySpecificFieldMapping fieldMapping) {
        if (fieldMapping.aspects.empty)
            return '''«fieldMapping.dataField.name»;'''

        '''
        «fieldMapping.dataField.name» {
            aspects {
                «FOR a : fieldMapping.aspects SEPARATOR "\n"»«a.extractToString»«ENDFOR»
            }
        }
        '''
    }
}