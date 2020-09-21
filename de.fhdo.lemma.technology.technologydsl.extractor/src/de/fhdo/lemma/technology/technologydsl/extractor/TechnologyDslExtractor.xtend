package de.fhdo.lemma.technology.technologydsl.extractor

import de.fhdo.lemma.technology.DataFormat
import de.fhdo.lemma.technology.Protocol
import de.fhdo.lemma.technology.Technology
import java.util.List
import java.util.function.Function
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.JoinPointType
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import de.fhdo.lemma.technology.ServiceAspect

/**
 * Model-to-text extractor for the Technology DSL.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class TechnologyDslExtractor {
    /**
     * Extract TechnologyModel
     */
    def String extractToString(Technology techModel) {
        val sb = new StringBuilder()
        sb.append('''technology «techModel.name» {''')
        sb.append("\n")
        if (techModel.protocols !== null) {
            sb.append("types {".indent)
            //Currently only supports primitiveTypes for generation
            sb.appendAsSeparatedLines(techModel.primitiveTypes, [it.extractToString], false)
            sb.append("\n}\n".indent)
            sb.append("protocols {".indent)
            sb.appendAsSeparatedLines(techModel.protocols, [it.extractToString], false)
            sb.append("\n}\n".indent)
            sb.append("service aspects {".indent)
            sb.appendAsSeparatedLines(techModel.serviceAspects, [it.extractToString], false)
            sb.append("\n}".indent)
        }
        sb.append("\n}")
        return sb.toString
    }

    /**
     * Adds four whitespaces before a string as indent
     */
    def String indent(CharSequence string) {
        // indentSize = 4
        return '''    «string»'''
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
        val stringSeparator = if(separateConvertedStrings) "\n\n" else "\n"
        val stringLines = lines.map[stringConverter.apply(it)].join(stringSeparator)
        sb.append(stringLines)
    }

    /**
     * Extract Protocol
     */
    def String extractToString(Protocol protocol) {
        return '''«IF (protocol.communicationType == CommunicationType.SYNCHRONOUS)»sync «ELSE
            »async «ENDIF»«protocol.name» data formats «
            FOR df : protocol.dataFormats SEPARATOR ', '»«df.extractToString»«ENDFOR»«
            IF (protocol.defaultFormat !== null)
            » default with format «protocol.defaultFormat.formatName»«ENDIF
            »;'''.indent.indent
    }
    /**
     * Extract Aspect
     */
    def String extractToString(ServiceAspect aspect) {
        return '''aspect «aspect.name»«IF aspect.isIsSingleValued»<singleval>«ENDIF» for «
        FOR jp : aspect.joinPoints SEPARATOR ', '»«jp.extractToString»«ENDFOR»;'''
        .indent.indent
    }
    /**
     * Extract DataFormat
     */
    def String extractToString(DataFormat dataformat) {
        return '''«dataformat.formatName»'''
    }
     /**
     * Extract JointPointType
     */
    def String extractToString(JoinPointType jpt) {
        return '''«jpt.literal.toLowerCase»'''
    }
     /**
     * Extract TechnologySpecificPrimitiveType
     */
    def String extractToString(TechnologySpecificPrimitiveType type) {
        return '''primitive type «type.name» based on «
        FOR bbp : type.basicBuiltinPrimitiveTypes SEPARATOR ', '»«bbp.typeName»«ENDFOR»«
        IF type.^default» default«ENDIF»;'''.indent.indent
    }
}
