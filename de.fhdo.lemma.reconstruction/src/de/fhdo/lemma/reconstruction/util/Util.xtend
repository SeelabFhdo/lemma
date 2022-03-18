package de.fhdo.lemma.reconstruction.util

import de.fhdo.lemma.data.DataFactory

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
}