package de.fhdo.lemma.reconstruction.domain

import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.data.ComplexTypeFeature
import de.fhdo.lemma.data.DataFieldFeature
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import de.fhdo.lemma.reconstruction.util.Util
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.PrimitiveUnspecified

class LemmaDomainGenerator {
    static val DATA_FACTORY = DataFactory.eINSTANCE
    static var context = DATA_FACTORY.createContext

    new () {

    }

    def generateDataModel(Context reconstructedContext) {
        // Create one domain data model per context
        context = generateContextFrom(reconstructedContext)

        // Assign reconstructed data structures, lists and enumerations to the context
        reconstructedContext.dataStructures.forEach[
            context.complexTypes.add(createDataStructureFrom(it))
        ]

        reconstructedContext.enums.forEach[
            context.complexTypes.add(createEnumFrom(it))
        ]

        /*
         * Assign data fields to the created data structures.
         * The assignment is separated from previous step to assign references to ComplexTypes and ImportedComplexTypes.
         */
        reconstructedContext.dataStructures.forEach[ reconstructedData |
            val structure = context.complexTypes.findFirst[ lemmaStructure |
                 lemmaStructure.name == reconstructedData.name
             ] as de.fhdo.lemma.data.DataStructure

            context.complexTypes.add(assignDataFieldsToStructure(structure, reconstructedData))
         ]

         reconstructedContext.enums.forEach[ reconstructedEnum |
            val enum = context.complexTypes.findFirst[ lemmaEnum |
                 lemmaEnum.name == reconstructedEnum.name
             ] as Enumeration

            context.complexTypes.add(assignEnumFieldsToStructure(enum, reconstructedEnum))
         ]

        val dataModel = DATA_FACTORY.createDataModel
        dataModel.contexts.add(context)
        return dataModel
    }

    private def generateContextFrom(Context reconstructedContext) {
        val context = DATA_FACTORY.createContext
        context.name = reconstructedContext.name
        val version = DATA_FACTORY.createVersion
        version.name = reconstructedContext.name
        context.version = version
        context
    }

    private def createDataStructureFrom(DataStructure reconstructedDataStructure) {
        val dataStructure = DATA_FACTORY.createDataStructure
        dataStructure.name = reconstructedDataStructure.name
        dataStructure
    }

    private def createEnumFrom(EnumType reconstructedEnum) {
        val enum = context.complexTypes.findFirst[it.name == reconstructedEnum.name]

        if (enum !== null)
            return enum

        val newEnum = DATA_FACTORY.createEnumeration
        newEnum.name = reconstructedEnum.name

        reconstructedEnum.values.forEach[
            val field = DATA_FACTORY.createEnumerationField
            field.name = it
            newEnum.fields.add(field)
        ]
        newEnum
    }

    private def assignDataFieldsToStructure(de.fhdo.lemma.data.DataStructure lemmaStructure, DataStructure dataStructure) {
        dataStructure.fields.forEach[
            val field = generateDataFildFrom(it)
            lemmaStructure.dataFields.add(field)
        ]

        lemmaStructure

    }


    private def assignEnumFieldsToStructure(Enumeration enumeration, EnumType reconstrcutedEnumeration) {
        enumeration
    }

    private def generateDataFildFrom(Field reconstructedAttribute) {
        val dataFild = DATA_FACTORY.createDataField
        dataFild.name = reconstructedAttribute.name
        if (reconstructedAttribute.primitiveType !== null)
            dataFild.primitiveType = getPrimitiveFrom(reconstructedAttribute.primitiveType.name)
        else
            dataFild.complexType = getComplexTypefrom(reconstructedAttribute)

        reconstructedAttribute.metaData.forEach[
            val feature = getDataFieldFeatureFrom(it.name)
            dataFild.features.add(feature)
        ]
        dataFild
    }

    private def getPrimitiveFrom(String type) {
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

    private def getComplexTypefrom(Field field) {

        return switch field.complexType.classType {
            case ClassType.DATA_STRUCTURE: getComplexTypeFromDataStructure(field.complexType)
            case ClassType.ENUMERATION: getComplexTypeFromEnumeration(field.complexType)
            case ClassType.COLLECTION: getListTypeFromCollection(field)
            case ClassType.MAP: null
            case ClassType.UNSPECIFIED: getUnspecifiedComplexType(field)
        }
    }

    private def getComplexTypeFromDataStructure(ComplexType complexType) {
        return context.complexTypes.findFirst[ it.name == complexType.name]

    }

    private def getComplexTypeFromEnumeration(ComplexType complexType) {
        val type = context.complexTypes.findFirst[complexType.qualifiedName.toLowerCase.endsWith(it.name.toLowerCase)]
        return type
    }

    private def getListTypeFromCollection(Field field) {
        val list = DATA_FACTORY.createListType
        val data = field.metaData.findFirst[ it.name == "CollectionType" ]

        val collectionInfo = data.values.entrySet.findFirst[ it.key == "Type" ]

        val reconstrcutionType = collectionInfo.value
        list.name = field.name.toFirstUpper
        val lemmaType = getPrimitiveFrom(reconstrcutionType)
        if (!(lemmaType instanceof PrimitiveUnspecified)) {
            list.primitiveType = lemmaType
        } else {
            val dataField = DATA_FACTORY.createDataField
            val complexType = context.complexTypes.findFirst[it.name == reconstrcutionType]
            if (complexType !== null) {
                dataField.complexType = complexType
                dataField.name = field.name
                list.dataFields.add(dataField)
            } else {

                list.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
            }
        }
        context.complexTypes.add(list)
        return list

    }

    private def getUnspecifiedComplexType(Field field) {
        val dataStructure = DATA_FACTORY.createDataStructure
        dataStructure.name = field.name.toFirstUpper
        val dataField = DATA_FACTORY.createDataField
        dataField.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
        dataField.name = field.name
        dataStructure.dataFields.add(dataField)
        context.complexTypes.add(dataStructure)


        return dataStructure

    }

    private def getListReference(ComplexType complexType) {
        val enum = DATA_FACTORY.createEnumerationField

        return enum
    }

    private def getEnumerationReference(ComplexType complexType) {
        return
    }

    private def getTypeFeatureFrom(String name) {
        return switch name {
            case "Aggregate": ComplexTypeFeature.AGGREGATE
            case "ApplicationService": ComplexTypeFeature.APPLICATION_SERVICE
            case "DomainEvent": ComplexTypeFeature.DOMAIN_EVENT
            case "DomainService": ComplexTypeFeature.DOMAIN_SERVICE
            case "Entity": ComplexTypeFeature.ENTITY
            case "Factory": ComplexTypeFeature.FACTORY
            case "InfrastructureService": ComplexTypeFeature.INFRASTRUCTURE_SERVICE
            case "Repository":  ComplexTypeFeature.REPOSITORY
            case "Service": ComplexTypeFeature.SERVICE
            case "Specification": ComplexTypeFeature.SPECIFICATION
            case "valueObject": ComplexTypeFeature.VALUE_OBJECT
            default: null
        }
    }

    private def getDataFieldFeatureFrom(String name) {
        return switch name {
            case "NeverEmpty": DataFieldFeature.NEVER_EMPTY
            case "Id": DataFieldFeature.IDENTIFIER
            case "Part": DataFieldFeature.PART
            default: null
        }
    }
}