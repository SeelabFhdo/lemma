package de.fhdo.lemma.reconstruction.service

import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.reconstruction.domain.ComplexType
import java.io.File
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.reconstruction.domain.ClassType
import de.fhdo.lemma.service.ImportedType

class LemmaServiceGenerator {
	static val SERVICE_FACTORY = ServiceFactory.eINSTANCE
	static val DATA_FACTORY = DataFactory.eINSTANCE
	val model = SERVICE_FACTORY.createServiceModel

	def ServiceModel generateModelFrom(Microservice reconstructedMicroservice) {

		val microservice = generateMicroserviceFrom(reconstructedMicroservice)
		model.microservices.add(microservice)

		return model
	}

	private def generateMicroserviceFrom(Microservice reconstructedMicroservice) {
		val microservice = SERVICE_FACTORY.createMicroservice
		microservice.name = reconstructedMicroservice.name
		microservice.version = reconstructedMicroservice.version
		microservice.visibility = deriveLemmaVisibility(reconstructedMicroservice.visibility)
		microservice.type = deriveMicroserviceType(reconstructedMicroservice.type)

		reconstructedMicroservice.interfaces.forEach[
			microservice.interfaces.add(generateInterfaceFrom(it))
		]

		return microservice
	}

	private def deriveMicroserviceType(String type) {
		return switch(type.toLowerCase) {
			case "functional": MicroserviceType.FUNCTIONAL
			case "utility": MicroserviceType.UTILITY
			case "infrastructure": MicroserviceType.INFRASTRUCTURE
			default: MicroserviceType.FUNCTIONAL
		}
	}

	private def generateInterfaceFrom(Interface generatedInterface) {
		val interfaze = SERVICE_FACTORY.createInterface
		interfaze.name = generatedInterface.name.split("\\W").last
		interfaze.version = generatedInterface.version
		interfaze.visibility = deriveLemmaVisibility(generatedInterface.version)
		generatedInterface.operations.forall[
			interfaze.operations.add(generateOperationFrom(it))
		]
		return interfaze
	}

	private def deriveLemmaVisibility(String visibility) {
		return switch (visibility.toLowerCase) {
			case "internal": Visibility.INTERNAL
			case "in_model": Visibility.IN_MODEL
			case "architecture": Visibility.ARCHITECTURE
			case "public": Visibility.PUBLIC
			default: Visibility.NONE
		}
	}

	private def generateOperationFrom(Operation reconstructedOperation) {
		val operation = SERVICE_FACTORY.createOperation
		operation.name = reconstructedOperation.name
		reconstructedOperation.parameters.forEach[ reconstructedParameter |



			var parameter = operation.parameters.findFirst[param |
				param.name.toLowerCase == reconstructedParameter.name.toLowerCase
			]

			if (parameter !== null) {
				parameter.exchangePattern = ExchangePattern.INOUT
				operation.parameters.add(parameter)

			} else {
				parameter = generateParameterFrom(reconstructedParameter)
				operation.parameters.add(parameter)
			}

		]

		return operation
	}

	private def generateParameterFrom(Parameter reconstructedParameter) {
		val parameter = SERVICE_FACTORY.createParameter
		parameter.name = reconstructedParameter.name.toFirstLower
		parameter.exchangePattern
			= deriveExchangePattern(reconstructedParameter.exchangePattern.toString())
		parameter.communicationType
			= deriveCommunicationType(reconstructedParameter.communicationType.toString())

		if (reconstructedParameter.primitiveType !== null) {
			parameter.primitiveType
				= Util.getPrimitiveFrom(reconstructedParameter.primitiveType.name)
		} else {
			parameter.importedType = deriveImportedType(reconstructedParameter.complexType) as ImportedType
		}

		return parameter
	}

	private def deriveExchangePattern(String pattern) {
		return switch (pattern.toLowerCase) {
			case "in": ExchangePattern.IN
			case "out": ExchangePattern.OUT
			case "inout": ExchangePattern.INOUT
		}
	}


	private def deriveCommunicationType(String type) {
		return switch (type.toLowerCase) {
			case "synchronous": CommunicationType.SYNCHRONOUS
			case "asynchronous": CommunicationType.SYNCHRONOUS
		}
	}

	private def deriveImportedType(ComplexType complexType) {
		val importedType = SERVICE_FACTORY.createImportedType

		val import = getOrCreateImport(complexType)
		importedType.import = import

		// Create type for imported type
		val type = deriveType(complexType)
		val context = DATA_FACTORY.createContext
		val name = buildContextName(complexType.qualifiedName, complexType.name)
		context.name = name
		type.context = context
		importedType.type = type

		return importedType
	}

	private def buildContextName(String qualifiedName, String name) {
		val contextName = qualifiedName.replace(name, "")
		val capitalizeContextName = Util.capitalizeWords("\\.", contextName).replaceAll("\\W", "")
		return capitalizeContextName
	}

	private def getOrCreateImport(ComplexType complexType) {
		val capitalizeName = buildContextName(complexType.qualifiedName, complexType.name)
		var import = model.imports.findFirst[it.name == capitalizeName]
		if (import === null) {
			import = SERVICE_FACTORY.createImport

			import.name = capitalizeName
			import.importURI = '''..«File.separator»domain«File.separator»«capitalizeName».data'''
			import.importType = ImportType.DATATYPES
			model.imports.add(import)
			return import
		}
		return import
	}

	private def deriveType(ComplexType type) {
		return switch (type.classType) {
			case ClassType.COLLECTION: handleCollectionType(type)
			case ClassType.DATA_STRUCTURE: handleDataStructureType(type)
			case ClassType.ENUMERATION: handleEnumerationType(type)
			case ClassType.MAP: handleCollectionType(type)
			default: null
		}
	}

	private def handleCollectionType(ComplexType type) {
		val collection = DATA_FACTORY.createListType
		collection.name = type.name
		return collection
	}

	private def handleDataStructureType(ComplexType type) {
		val structure = DATA_FACTORY.createDataStructure
		structure.name = type.name
		return structure
	}

	private def handleEnumerationType(ComplexType type) {
		val enum = DATA_FACTORY.createEnumeration
		enum.name = type.name
		return enum
	}


}