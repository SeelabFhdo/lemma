package de.fhdo.lemma.reconstruction.domain

import de.fhdo.lemma.data.ComplexTypeFeature
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataFieldFeature
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.PrimitiveUnspecified
import de.fhdo.lemma.data.CollectionType

/**
 * Class for generating LEMMA domain data models based on reconstructed Context.  
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaDomainGenerator {
    static val DATA_FACTORY = DataFactory.eINSTANCE
    static var context = DATA_FACTORY.createContext

    new () {

    }

	/**
	 * generate LEMMA domain data model based on a reconstructed context
	 */
    def generateDataModel(Context reconstructedContext) {
        // Create one domain data model per context
        context = generateContextFrom(reconstructedContext)

        // Assign reconstructed data structures, lists and enumerations to the context
        reconstructedContext.dataStructures.forEach[
            if (context.complexTypes.findFirst[complexTyp | 
            	complexTyp.name.toLowerCase == it.name.toLowerCase
            ] === null) {
                context.complexTypes.add(createDataStructureFrom(it))
            }
        ]
        
        reconstructedContext.collections.forEach[
        	if (context.complexTypes.findFirst[ complexType |
        		complexType.name.toLowerCase == it.name.toLowerCase
        	] === null) {
        		context.complexTypes.add(createCollectionFrom(it))
        	}
        ]

        reconstructedContext.enums.forEach[
            context.complexTypes.add(createEnumFrom(it))
        ]

        /**
         * Assign data fields to the created data structures.
         * The assignment is separated from previous step to assign references to ComplexTypes and
         * ImportedComplexTypes.
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
         
         reconstructedContext.collections.forEach[reconstructedCollection | 
         	val collection = context.complexTypes.findFirst[lemmaCollection | 
         		lemmaCollection == reconstructedCollection.name
         	] as CollectionType
         	if (collection !== null) {
         		context.complexTypes.add(assignCollectionFieldsToStructure(collection, reconstructedCollection))	
         	}
         	
         ]


        val dataModel = DATA_FACTORY.createDataModel
        dataModel.contexts.add(context)
        return dataModel
    }

	/**
	 * Generate a LEMMA domain model context from a reconstructed context
	 */
    private def generateContextFrom(Context reconstructedContext) {
        val context = DATA_FACTORY.createContext
        context.name = reconstructedContext.name
        val version = DATA_FACTORY.createVersion
        version.name = reconstructedContext.name
        context.version = version
        return context
    }
	
	/**
	 * Generate a LEMMA domain model data structure from a reconstructed data structure
	 */
    private def createDataStructureFrom(DataStructure reconstructedDataStructure) {
        val dataStructure = DATA_FACTORY.createDataStructure
        dataStructure.name = reconstructedDataStructure.name
        reconstructedDataStructure.metaData.forEach[data |
            val feature = assignFeaturesToDataStructure(data)
            if (feature !== null) {
                dataStructure.features.add(feature)
            }
        ]

        return dataStructure
    }
    
    private def createCollectionFrom(Collection reconstructedCollection) {
    	val collection = DATA_FACTORY.createCollectionType
    	collection.name = reconstructedCollection.name
    	if (reconstructedCollection.primitiveType !== null) {
    		collection.primitiveType = getPrimitiveFrom(reconstructedCollection.primitiveType.toString.toLowerCase)	
    	} else {
    		collection.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
    	}
    
    	return collection
    }

	/**
	 * Assign a LEMMA domain model feature to a data structure
	 */
    private def assignFeaturesToDataStructure(MetaData data) {
        return getTypeFeatureFrom(data.name)
    }
	
	/**
	 * Get e LEMMA domain model feature based on a string
	 */
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

	/**
	 * Generate a LEMMA domain model enumeration from a reconstructed enumeration
	 */
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

	/**
     * Assign data fields to a data structure
     */
    private def assignDataFieldsToStructure(de.fhdo.lemma.data.DataStructure lemmaStructure, 
    	DataStructure dataStructure) {
        if (lemmaStructure.dataFields.size > 0) {
            return lemmaStructure
        }
        dataStructure.fields.forEach[
            val field = generateDataFildFrom(it)
            lemmaStructure.dataFields.add(field)
        ]

        return lemmaStructure

    }
    
	/**
     * Assign data fields to a data structure
     */
    private def assignCollectionFieldsToStructure(de.fhdo.lemma.data.CollectionType lemmaCollection, 
    	Collection collection) {
        lemmaCollection.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
        if (lemmaCollection.dataFields.size > 0) {
            return lemmaCollection
        } else if (collection.primitiveType !== null) {
        	return lemmaCollection
        }
        lemmaCollection.dataFields.forEach[
            lemmaCollection.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
        ]

        return lemmaCollection

    }    

	/**
     * Assign data fields to a data structure
     */
    private def assignEnumFieldsToStructure(Enumeration enumeration, 
    	EnumType reconstrcutedEnumeration) {
        enumeration
    }

	/**
     * Assign data fields to a data structure
     */
    private def generateDataFildFrom(Field reconstructedAttribute) {
        val dataFild = DATA_FACTORY.createDataField
        dataFild.name = reconstructedAttribute.name
        if (reconstructedAttribute.primitiveType !== null) {
            dataFild.primitiveType = getPrimitiveFrom(reconstructedAttribute.primitiveType.name)
        } else {
            val complexType = getComplexTypefrom(reconstructedAttribute)
            if (complexType !== null) {
                dataFild.complexType = complexType
            } else {
                // The field refers to a type this context does not hold, for
                // instance because the reconstruction placed it in the context
                // of another microservice. A field without any type is not a
                // model, so it becomes unspecified and stays visible as a gap.
                dataFild.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
            }
        }

        reconstructedAttribute.metaData.forEach[
            val feature = getDataFieldFeatureFrom(it.name)
            if (feature !== null) {
                dataFild.features.add(feature)
            }
        ]
        dataFild
    }
    
	/**
	 * Get a LEMMA domain model primitive type based on 
	 */
    def getPrimitiveFrom(String type) {
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
            case "bigdecimal": DATA_FACTORY.createPrimitiveFloat
            case "integer": DATA_FACTORY.createPrimitiveInteger
            case "instant": DATA_FACTORY.createPrimitiveDate
            default: DATA_FACTORY.createPrimitiveUnspecified

        }
    }

	/**
	 * Get a LEMMA domain model complex type based on a reconstructed field
	 */	
    private def getComplexTypefrom(Field field) {
        return switch field.complexType.classType {
            case ClassType.DATA_STRUCTURE: getComplexTypeFromDataStructure(field.complexType)
            case ClassType.ENUMERATION: getComplexTypeFromEnumeration(field.complexType)
            case ClassType.COLLECTION: getListTypeFromCollection(field)
            case ClassType.MAP: null
            case ClassType.UNSPECIFIED: getUnspecifiedComplexType(field)
        }
    }

	/**
	 * Get a complex type from a reconstructed complex type
	 */
    private def getComplexTypeFromDataStructure(ComplexType complexType) {
        return context.complexTypes.findFirst[ it.name == complexType.name]

    }
	
	/**
	 * Get an enumeration from a reconstructed complex type
	 */
    private def getComplexTypeFromEnumeration(ComplexType complexType) {
        val type = context.complexTypes.findFirst[
        	complexType.qualifiedName.toLowerCase.endsWith(it.name.toLowerCase)]
        return type
    }

	/**
	 * Get a list type from a reconstructed complex type
	 */
    private def getListTypeFromCollection(Field field) {
        val complex = context.complexTypes.findFirst[complexTyp |
            complexTyp.name.toLowerCase == field.name.toLowerCase]
        if (complex !== null) {
            return complex
        }


        val list = DATA_FACTORY.createCollectionType
        list.name = field.name.toFirstUpper

        // MRF conveys the element type of a collection in the complex type of
        // the field itself. A "CollectionType" meta-data entry is honoured as
        // well, but the reconstruction does not currently emit one, so relying
        // on it alone leaves the element type unresolved.
        val elementTypeName = field.metaData
            .findFirst[ it.name == "CollectionType" ]
            ?.values?.get("Type")
            ?: field.complexType?.name

        if (elementTypeName === null) {
            list.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
            context.complexTypes.add(list)
            return list
        }

        val lemmaType = getPrimitiveFrom(elementTypeName)
        if (!(lemmaType instanceof PrimitiveUnspecified)) {
            list.primitiveType = lemmaType
        } else {
            val dataField = DATA_FACTORY.createDataField
            val complexType = context.complexTypes.findFirst[
            	it.name.toLowerCase == elementTypeName.toLowerCase]
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
	/**
	 * Get an unspecified field type from a reconstructed field
	 */
    private def getUnspecifiedComplexType(Field field) {
        val dataStructure = DATA_FACTORY.createDataStructure
        dataStructure.name = field.name.toFirstUpper
        val dataField = DATA_FACTORY.createDataField
        dataField.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
        dataField.name = field.name
        dataStructure.dataFields.add(dataField)
        if (!context.complexTypes.exists[it.name.toLowerCase == field.name.toLowerCase]){
        	context.complexTypes.add(dataStructure)
        }
        return dataStructure
    }

    private def getDataFieldFeatureFrom(String name) {
        return switch name {
            case "NeverEmpty": DataFieldFeature.NEVER_EMPTY
            case "Identifier": DataFieldFeature.IDENTIFIER
            case "Part": DataFieldFeature.PART
            default: null
        }
    }
}