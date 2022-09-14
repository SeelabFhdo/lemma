package de.fhdo.lemma.data.datadsl.extractor

import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.ComplexTypeImport
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.ImportedComplexType
import de.fhdo.lemma.data.Type
import java.util.List
import java.util.function.Function

import static de.fhdo.lemma.data.datadsl.extractor.Util.*
import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.EnumerationField
import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.data.Version

/**
 * Model-to-text extractor for the Data DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DataDslExtractor {
    /**
     * Extract DataModel
     */
    def String extractToString(DataModel dataModel) {
        val sb = new StringBuilder()
        sb.appendAsSeparatedLines(dataModel.complexTypeImports, [it.extractToString], false)
        sb.appendAsSeparatedLines(dataModel.versions, [it.extractToString], true)
        sb.appendAsSeparatedLines(dataModel.contexts, [it.extractToString], true)
        sb.appendAsSeparatedLines(dataModel.complexTypes, [it.extractTypeDefinitionToString], true)
        return sb.toString
    }

    /**
     * Helper to append a list of lines to a StringBuilder and separate them from already existing
     * lines in that StringBuilder by an empty line. If separateConvertedStrings is set to true,
     * even the given lines are separated by an empty line.
     */
    private def <T> void appendAsSeparatedLines(StringBuilder sb, List<T> lines,
        Function<T, String> stringConverter, boolean separateConvertedStrings) {
        if (lines.empty) {
            return
        }

        if (sb.length > 0 && !sb.toString.endsWith("\n\n")) {
            if (sb.toString.endsWith("\n"))
                sb.append("\n")
            else
                sb.append("\n\n")
        }

        val stringSeparator = if (separateConvertedStrings) "\n\n" else "\n"
        val stringLines = lines.map[stringConverter.apply(it)].join(stringSeparator)
        sb.append(stringLines)
    }

    /**
     * Extract ComplexTypeImport
     */
    def String extractToString(ComplexTypeImport complexTypeImport) {
        val lemmaName = lemmaName(complexTypeImport.name)
        '''import datatypes from «complexTypeImport.importURI» as «lemmaName»'''
    }

    /**
     * Extract ComplexType
     */
    def String extractTypeDefinitionToString(ComplexType complexType) {
        return switch(complexType) {
            DataStructure: complexType.extractToString
            Enumeration: complexType.extractToString
            CollectionType: complexType.extractToString
        }
    }

    /**
     * Extract DataStructure
     */
    def String extractToString(DataStructure dataStructure) {
        val preamble = '''structure «lemmaName(dataStructure.name)»'''
        if (dataStructure.dataFields.empty)
            return '''«preamble» {}'''

        '''
        «preamble» {
            «FOR f : dataStructure.dataFields SEPARATOR ','»
                «f.extractToString»
            «ENDFOR»
        }'''
    }

    /**
     * Extract DataField
     */
    def String extractToString(DataField dataField) {
        val directFieldType = dataField.fieldType
        val type = switch(directFieldType) {
            Type: directFieldType.extractTypeReferenceToString(qualifiedName(dataField))
            ImportedComplexType: directFieldType.extractTypeReferenceToString
        }
        '''«type» «lemmaName(dataField.name)»'''
    }

    /**
     * Get the type of a DataField
     */
    private def Object fieldType(DataField dataField) {
        return if (dataField.primitiveType !== null)
                dataField.primitiveType
            else if (dataField.complexType !== null)
                dataField.complexType
            else
                dataField.importedComplexType
    }

    /**
     * Extract Type reference
     */
    def String extractTypeReferenceToString(Type type, String referringQualifier) {
        return switch(type) {
            PrimitiveType: type.extractTypeReferenceToString
            ComplexType: type.extractTypeReferenceToString(referringQualifier)
        }
    }

    /**
     * Extract PrimitiveType reference
     */
    def String extractTypeReferenceToString(PrimitiveType primitiveType) {
        primitiveType.typeName
    }

    /**
     * Extract ComplexType reference
     */
    def String extractTypeReferenceToString(ComplexType complexType, String referringQualifier) {
        return if (referringQualifier !== null)
                calculateRelativeQualifier(qualifiedName(complexType), referringQualifier)
            else
                lemmaName(complexType.name)
    }

    /**
     * Extract ImportedComplexType reference
     */
    def String extractTypeReferenceToString(ImportedComplexType importedComplexType) {
        val complexType = importedComplexType.importedType as ComplexType
        '''«lemmaName(importedComplexType.import.name)»::«qualifiedName(complexType)»'''
    }

    /**
     * Extract Enumeration
     */
    def String extractToString(Enumeration enumeration) {
        val preamble = '''enum «lemmaName(enumeration.name)»'''
        if (enumeration.fields.empty)
            return '''«preamble» {}'''

        '''
        «preamble» {
            «FOR f : enumeration.fields SEPARATOR ','»
                «f.extractToString»
            «ENDFOR»
        }'''
    }

    /**
     * Extract EnumerationField
     */
    private def String extractToString(EnumerationField field) {
        lemmaName(field.name)
    }

    /**
     * Extract CollectionType
     */
    def String extractToString(CollectionType collectionType) {
        val preamble = '''collection «lemmaName(CollectionType.name)»'''

        // Extract primitive collection
        if (collectionType.isPrimitiveCollection)
            '''«preamble» { «collectionType.primitiveType.extractTypeReferenceToString» }'''

        // Extract structured collection
        else if (collectionType.isStructuredCollection) {
            val fieldDefinitions = collectionType.dataFields.map[
                val fieldTypeReference = effectiveType.extractTypeReferenceToString(
                    qualifiedName(collectionType)
                )
                '''«fieldTypeReference» «lemmaName(name)»'''
            ].join(", ")

            '''«preamble» { «fieldDefinitions» }'''
        }

        // Empty collection
        else
            '''«preamble» {}'''
    }

    /**
     * Extract Context
     */
    def String extractToString(Context context) {
        val preamble = '''context «lemmaName(context.name)»'''
        if (context.complexTypes.empty)
            return '''«preamble» {}'''

        '''
        «preamble» {
            «FOR t : context.complexTypes SEPARATOR '\n'»
                «t.extractTypeDefinitionToString»
            «ENDFOR»
        }'''
    }

    /**
     * Extract Version
     */
    def String extractToString(Version version) {
        val preamble = '''version «lemmaName(version.name)»'''
        if (version.contexts.empty && version.complexTypes.empty)
            return '''«preamble» {}'''

        '''
        «preamble» {
            «FOR c : version.contexts SEPARATOR '\n'»
                «c.extractToString»
            «ENDFOR»
            «FOR t : version.complexTypes SEPARATOR '\n'»
                «t.extractTypeDefinitionToString»
            «ENDFOR»
        }'''
    }
}