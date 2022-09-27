package de.fhdo.lemma.reconstruction.util

import de.fhdo.lemma.data.DataFactory
import java.util.List
import org.eclipse.xtext.validation.Issue
import java.io.FileReader
import java.io.BufferedReader

class Util {
    static val DATA_FACTORY = DataFactory.eINSTANCE

    static def getPrimitiveFrom(String type) {
        return switch type.toLowerCase {
            case "boolean": DATA_FACTORY.createPrimitiveBoolean
            case "byte": DATA_FACTORY.createPrimitiveByte
            case "character": DATA_FACTORY.createPrimitiveCharacter
            case "date": DATA_FACTORY.createPrimitiveDate
            case "double": DATA_FACTORY.createPrimitiveDouble
            case "float": DATA_FACTORY.createPrimitiveFloat
            case "int": DATA_FACTORY.createPrimitiveInteger
            case "long": DATA_FACTORY.createPrimitiveLong
            case "short": DATA_FACTORY.createPrimitiveShort
            case "string": DATA_FACTORY.createPrimitiveString
            default: DATA_FACTORY.createPrimitiveUnspecified

        }
    }

    static def capitalizeWords(String splitOperator, String term) {
        val parts = term.split(splitOperator)
        val stringBuilder = new StringBuilder

        parts.forEach[
            stringBuilder.append(it.toFirstUpper)
        ]

        return stringBuilder.toString
    }

    static def getContextNameFromQualifedName(String qualifedName) {
        val nameParts = qualifedName.split("\\W")
        val contextName = nameParts.get(nameParts.size - 2).toFirstUpper
        return contextName
    }
    
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
    
    static def maskLemmaKeywords(String line,char markChar, int position) {
    	return line.substring(0, position) + markChar + line.substring(position)
    }
}