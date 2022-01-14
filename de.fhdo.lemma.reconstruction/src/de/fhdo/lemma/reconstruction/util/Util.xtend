package de.fhdo.lemma.reconstruction.util

import de.fhdo.lemma.data.DataFactory

class Util {
	static val DATA_FACTORY = DataFactory.eINSTANCE

	static def getPrimitiveFrom(String type) {
		return switch type {
			case "boolean": DATA_FACTORY.createPrimitiveBoolean
			case "Byte": DATA_FACTORY.createPrimitiveByte
			case "Character": DATA_FACTORY.createPrimitiveCharacter
			case "Date": DATA_FACTORY.createPrimitiveDate
			case "Double": DATA_FACTORY.createPrimitiveDouble
			case "float": DATA_FACTORY.createPrimitiveFloat
			case "int": DATA_FACTORY.createPrimitiveInteger
			case "Long": DATA_FACTORY.createPrimitiveLong
			case "Short": DATA_FACTORY.createPrimitiveShort
			case "String": DATA_FACTORY.createPrimitiveString
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
}