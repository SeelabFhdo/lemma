package de.fhdo.lemma.reconstruction.util

import de.fhdo.lemma.data.DataFactory
import java.io.BufferedReader
import java.io.FileReader
import java.util.List
import org.eclipse.xtext.validation.Issue

/**
 * Utility class for creating LEMMA models from reconstructed architecture information 
 * in a database. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Util {
    static val DATA_FACTORY = DataFactory.eINSTANCE
	
	/** 
	 * Get a LEMMA primitive type based on a string 
	 */
    static def getPrimitiveFrom(String type) {
        return switch type.toLowerCase {
            case "boolean": DATA_FACTORY.createPrimitiveBoolean
            case "byte": DATA_FACTORY.createPrimitiveByte
            case "character": DATA_FACTORY.createPrimitiveCharacter
            case "date": DATA_FACTORY.createPrimitiveDate
            case "double": DATA_FACTORY.createPrimitiveDouble
            case "float": DATA_FACTORY.createPrimitiveFloat
            case "int": DATA_FACTORY.createPrimitiveInteger
            case "integer": DATA_FACTORY.createPrimitiveInteger
            case "long": DATA_FACTORY.createPrimitiveLong
            case "short": DATA_FACTORY.createPrimitiveShort
            case "string": DATA_FACTORY.createPrimitiveString
            default: DATA_FACTORY.createPrimitiveUnspecified

        }
    }
	
	/**
	 * Capitalizes a word in a string after a given split operator
	 */
    static def capitalizeWords(String splitOperator, String term) {
        val parts = term.split(splitOperator)
        val stringBuilder = new StringBuilder

        parts.forEach[
            stringBuilder.append(it.toFirstUpper)
        ]

        return stringBuilder.toString
    }

	/**
	 * Get the context name for a element based on it's qualified name
	 */
    static def getContextNameFromQualifedName(String qualifedName) {
        val nameParts = qualifedName.split("\\W")
        val contextName = nameParts.get(nameParts.size - 2).toFirstUpper
        return contextName
    }
	
	/**
	 * Mask a model a adding a '^' in front of LEMMA specific key word in order to 
	 * avoid syntax errors in generated models based on reconstructed architecture information
	 */
   	static def maskModel(String path, List<Issue> issues) {
   		val idMessage = "(mismatched input '){1}(.)+(expecting RULE_ID)"
   		val reader = new BufferedReader(new FileReader(path))
   		val lines = reader.lines.iterator.toList

   		issues.forEach[issue |
   			if (issue.message.matches(idMessage)) {
   				val lineNumber = issue.lineNumber - 1
   				val position = issue.column - 1
   				val line = lines.get(lineNumber)
   				val maskedLine = line.substring(0, position) + '^' + line.substring(position)
   				lines.set(lineNumber, maskedLine)
   			}
   		]
   		return lines
   	}
	
	/**
	 * Mask LEMMA-specifc keyword in a given line of a lemma model 
	 */
    static def maskLemmaKeywords(String line,char markChar, int position) {
    	return line.substring(0, position) + markChar + line.substring(position)
    }

	/**
	 * Remove the last part of a URI to get the folder of a given URI
	 */
    static def removeLastFolderFromURI(String uri) {
    	val lastIndex = uri.lastIndexOf("/")
    	val shortUri = uri.substring(0, lastIndex)
    	return shortUri
    }
    
    /** 
     * Remove leading and ending quotation marks of a text 
     */    
    static def removeFirstAndLastQuotationMark(String text) {
    	if (text.length() > 1 && text.startsWith("\"") && text.endsWith("\"")) {
            val result = text.substring(1, text.length() - 1);
            return result
        } else {
        	return text
        }
    }
}