package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataStructure
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.Schema
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.LoggerFactory

/**
 * This class is responsible for handling the generation of a LEMMA data model from an OpenAPI file
 * in the JSON or YAML format.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaDataSubGenerator {
    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaDataSubGenerator)

    /* Separator is used to build the full qualified names during the generation */
    static val SEP = "."

    /*
     * Map of all created DataStructures during a generation. The key contains the fully-qualified
     * name while the value contains the actual data structure created.
     */
    val createdDataStructures = <String, DataStructure>newHashMap

    /*
     * Map of all collection types created during a generation. The key contains the fully-qualified
     * name while the value contains the actual structured collection type created.
     */
    val createdStructuredCollectionTypes = <String, CollectionType>newHashMap

    /* Factory to actually create and manipulate a LEMMA DataModel */
    val dataFactory = DataFactory.eINSTANCE

    /*
     * Predefined instances of the data model, version, and context which are enriched with the data
     * structures from the OpenAPI source
     */
    val targetDataModel = dataFactory.createDataModel
    val targetVersion = dataFactory.createVersion
    val targetContext = dataFactory.createContext

    /* OpenAPI schema which will be used as source for generation */
    val OpenAPI openAPI

    /* Log of all encountered exceptions during the data transformation */
    @Accessors(PUBLIC_GETTER)
    val transMsgs = <String>newArrayList

    /* Location where the generated file is written */
    val String targetFile

    /**
     * Constructor
     */
    new(OpenAPI openAPI, String targetFile) {
        this.openAPI = openAPI
        this.targetFile = targetFile
    }

    /**
     * Generate LEMMA data model from a previously parsed OpenAPI specification file. This method
     * returns the created model instance and also serializes it to the user's harddrive.
     */
    def DataModel generate() {
        LOGGER.debug("Initializing model instance...")
        initialize()
        LOGGER.debug("... data model initialized")

        LOGGER.debug("Creating data structures...")
        openAPI?.components?.schemas?.forEach[key, value |
            try {
                getOrCreateDataStructure(targetContext, key, value)
            } catch (Exception ex) {
                transMsgs.add('''Error for data structure «key». Structure will be skipped. ''' +
                    "Please refer to the debug log for details.")
                LOGGER.debug(ex.message)
            }
        ]
        LOGGER.debug("...data structures created")

        if (OpenApiUtil.writeModel(targetDataModel, targetFile)) {
            LOGGER.debug("Data model generation successful")
            LOGGER.debug('''Model written to «targetFile»''')
        } else
            throw new Exception("Generated data model could not be written to hard disk")

        return targetDataModel
    }

    /**
     * Initialize the data model instance
     */
    private def initialize() {
        targetDataModel.versions.add(targetVersion)

        targetVersion.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.version)
        targetVersion.contexts.add(targetContext)

        targetContext.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.title)
        targetContext.version = targetVersion
    }

    /**
     * Return a LEMMA data structure with the given name from an OpenAPI component object. In case a
     * data structure with the given name was already created, because OpenAPI allows the multiple
     * definition of a component object, it is returned. Otherwise, a new structure is created,
     * cached, and returned.
     */
    private def DataStructure getOrCreateDataStructure(Context context, String name,
        Schema<?> schema) {
        val structureName = name.toFirstUpper
        val fullyQualifiedStructureName = '''«context.buildQualifiedName(SEP)»«SEP»''' +
            structureName
        val existingStructure = createdDataStructures.get(fullyQualifiedStructureName)
        if (existingStructure !== null) {
            LOGGER.debug('''Found and reuse existing data structure «existingStructure.name»''')
            return existingStructure
        }

        val newStructure = dataFactory.createDataStructure
        newStructure.name = structureName
        context.complexTypes.add(newStructure)
        newStructure.addDataFieldsFromSchema(schema)
        createdDataStructures.put(fullyQualifiedStructureName, newStructure)
        LOGGER.debug('''Created new data structure «newStructure.name»''')
        return newStructure
    }

    /**
     * Add fields to a given LEMMA data structure from information of a given OpenAPI schema
     */
    private def void addDataFieldsFromSchema(DataStructure structure, Schema<?> structureSchema) {
        structure.addDataFieldsFromSchema(null, structureSchema)
    }

    /**
     * Add field of the given name to the given LEMMA data structure based on the given OpenAPI
     * schema. This method recursively creates fields for inline-defined OpenAPI structures
     * identified by schemas that have properties. In case a schema has no properties, a single data
     * field is added to the LEMMA data structure, which requires the given field name to be
     * non-null. In case a schema has no properties and no field name was given, the method yields
     * an IllegalArgumentException.
     */
    private def void addDataFieldsFromSchema(DataStructure structure, String fieldName,
        Schema<?> structureSchema) {
        if (structureSchema.properties !== null)
            structureSchema.properties.forEach[name, schema |
                structure.addDataFieldsFromSchema(name, schema)
            ]
        else if (fieldName !== null)
            structure.dataFields.add(generateDataField(fieldName, structureSchema))
        else
            throw new IllegalArgumentException("Can't add data field(s) from OpenAPI schema to " +
                '''structure «structure.buildQualifiedName(".")» because the schema has no ''' +
                "properties and no field name was given")
    }

    /**
     * Generate a LEMMA data field with the given name from the type of an OpenAPI schema. Primitive
     * schema types such as "boolean" or "integer" are mapped to the corresponding LEMMA primitive
     * types. OpenAPI arrays and references are mapped to LEMMA collection types and data
     * structures, respectively.
     */
    private def DataField generateDataField(String name, Schema<?> structureSchema) {
        val newDataField = dataFactory.createDataField
        newDataField.name = name
        
        // Due to the change from OpenAPI3.0 to OpenAPI3.1, the type field may or may not be
        // filled. In some cases, the 'type' is null but the 'types' array is filled and viceversa.
        // Unfortunately, it can also happen, that the type field is null and 'types' only has
        // one entry. And/or that the 'properties' attribute is used instead.
        // For more info check this:
        // https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---OpenAPI-3.1
        // 
        // the following is an ugly way to deal with this mess :-/
		if(structureSchema.properties !== null) {
			structureSchema.types.forEach[it |
				switch(it) {
	 			case "array":
	                newDataField.complexType = getOrCreateStructuredCollectionType(targetContext, name,
	                    (structureSchema.items))
	
	            case "boolean":
	                newDataField.primitiveType = dataFactory.createPrimitiveBoolean
	
	            case "integer":
	                newDataField.primitiveType = OpenApiUtil.deriveIntType(structureSchema.format)
	
	            case "number":
	                newDataField.primitiveType = OpenApiUtil.deriveFloatType(structureSchema.format)
	
	            case "string":
	                newDataField.primitiveType = OpenApiUtil.deriveStringType(structureSchema.format)
	
	            default:
	                throwUnsupportedSchemaType(structureSchema)				
				}
			]					
		} else if(!structureSchema.types.isNullOrEmpty) {
			structureSchema.types.forEach[it |
				switch(it) {
	 			case "array":
	                newDataField.complexType = getOrCreateStructuredCollectionType(targetContext, name,
	                    (structureSchema.items))
	
	            case "boolean":
	                newDataField.primitiveType = dataFactory.createPrimitiveBoolean
	
	            case "integer":
	                newDataField.primitiveType = OpenApiUtil.deriveIntType(structureSchema.format)
	
	            case "number":
	                newDataField.primitiveType = OpenApiUtil.deriveFloatType(structureSchema.format)
	
	            case "string":
	                newDataField.primitiveType = OpenApiUtil.deriveStringType(structureSchema.format)
	
	            default:
	                throwUnsupportedSchemaType(structureSchema)				
				}
			]						
		} else {
            // Currently, we only support references for untyped schemas
            if (structureSchema.get$ref === null)
                 throwUnsupportedSchemaType(structureSchema)
            val ref = structureSchema.get$ref
            var refName = ref.substring(ref.lastIndexOf("/") + 1)
            
            //Name fix for cases where the parser generates names in lower
            //lower case. E.g. 'PetDetails' is refed as 'petdetails' in the PetStore Example 
            for(component : openAPI.components.schemas.entrySet) {
				if(component.key.toLowerCase.equals(refName.toLowerCase))
					refName = component.key
            }
                                
            val refSchema = openAPI.components.schemas.get(refName)
                              
            if (refName !== null && refSchema !== null)
                newDataField.complexType = getOrCreateDataStructure(targetContext, refName,
                    refSchema)
            else
                LOGGER.info("Encountered reference without a parseable name and/or schema. " +
                    "The generated LEMMA data model may be incomplete.")			
		}

        return newDataField
    }

    /**
     * Throw an IllegalArgumentException in case an OpenAPI schema type cannot be transformed into 
     * a corresponding LEMMA type
     */
    private def throwUnsupportedSchemaType(Schema<?> schema) {
        throw new IllegalArgumentException('''Schema type «schema.type» is not supported.''')
    }

    /**
     * Return a LEMMA collection type with the given name from an OpenAPI schema. In case a
     * collection type with the given name was already created, because OpenAPI allows the multiple
     * definition of schema types, it is returned. Otherwise, a new collection type is created,
     * cached, and returned.
     */
    private def getOrCreateStructuredCollectionType(Context context, String name,
        Schema<?> schema) {
        val typeName = name.collectionTypeName
        val fullyQualifiedTypeName = '''«context.buildQualifiedName(SEP)»«SEP»«typeName»'''
        val existingType = createdStructuredCollectionTypes.get(fullyQualifiedTypeName)
        if (existingType !== null) {
            LOGGER.debug("Found and reuse existing structured collection type " +
                existingType.name)
            return existingType
        }

        val newType = dataFactory.createCollectionType
        newType.name = typeName
        context.complexTypes.add(newType)
        newType.dataFields.add(generateDataField(name, schema))
        createdStructuredCollectionTypes.put(fullyQualifiedTypeName, newType)
        LOGGER.debug('''Created new structured collection type «newType.name»''')
        return newType
    }


    /**
     * Helper method to get the name of a LEMMA collection type from an OpenAPI array schema
     */
    static def getCollectionTypeName(ArraySchema schema) {
        schema.type.collectionTypeName
    }

    /**
     * Helper method to derive the name of a LEMMA collection type from a given base name
     */
    static def getCollectionTypeName(String name) {
        '''«name.toFirstUpper»Collection'''.toString
    }
}
