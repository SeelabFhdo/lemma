package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataStructure
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.Schema
import org.slf4j.LoggerFactory
import de.fhdo.lemma.data.DataModel
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.data.DataField

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

    new(OpenAPI openAPI, String targetFile) {
        this.openAPI = openAPI
        this.targetFile = targetFile
    }

    /**
     * Entrypoint method which starts the actual generation of a LEMMA data model.
     * @Returns {@link de.fhdo.lemma.data.DataModel DataModel}
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
                transMsgs.add('''Error for DataStructure «key». Structure will be skipped. ''' +
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
     * Sets meta information for the data model in generation based on information
     * given by the OpenAPI specification.
     */
    private def initialize() {
        targetDataModel.versions.add(targetVersion)

        targetVersion.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.version)
        targetVersion.contexts.add(targetContext)

        targetContext.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.title)
        targetContext.version = targetVersion
    }

    /**
     * Returns a {@link de.fhdo.lemma.data.DataStructure DataStructure} based on
     * encountered <emph>Component Objects</emph> in the OpenAPI specification.
     * For each encountered component object during parsing the OpenAPI document,
     * a HashMap is scanned whether a fitting DataStructure already exists
     * or a new instance of DataStructure is created and stored.
     * This prevents duplicates.
     * This needs to be done because the parsed OpenAPI structure
     * may define components multiple times.
     * The population of DataStructures happens in a recursive way.
     *
     * @returns {@link de.fhdo.lemma.data.DataStructure DataStructure}
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
     * Adds DataFields to a given DataStructure based on information from a given
     * OpenAPI schema.
     */
    private def void addDataFieldsFromSchema(DataStructure structure, Schema<?> structureSchema) {
        structure.addDataFieldsFromSchema(null, structureSchema)
    }

    /**
     * Distinguishes whether a DataField is a elemental data type or a OpenAPI inline-defined
     * structure, e.g., comprising multiple elemental data types or references.
     * Encountered complex structures get recursively traced down
     * for their inherent elemental data types.
     */
    private def void addDataFieldsFromSchema(DataStructure structure, String fieldName,
        Schema<?> structureSchema) {
        if (structureSchema.properties !== null)
            structureSchema.properties.forEach[name, schema |
                structure.addDataFieldsFromSchema(name, schema)
            ]
        else
            structure.dataFields.add(generateDataField(fieldName, structureSchema))
    }

    /**
     * Creates a new {@link de.fhdo.lemma.data.DataField DataField} for an OpenAPI
     * data type encoded in a structure.
     * Those can be elemental types such as <code>boolean</code> or <code>integer</code>,
     * but also references, in which case proper DataStructures are fetched or created
     * (c.f. {@link #getOrCreateDataStructure getOrCreateDataStructure(...)}).
     * In case of an array, a proper ListType is fetched or created (c.f.
     * {@link #getOrCreateStructuredListType getOrCreateStructuredListType(...)})
     *
     * @returns {@link de.fhdo.lemma.data.DataField DataField}
     * @throws {@link IllegalArgumentException IllegalArgumentException} if OpenAPI schema type
     * cannot be translated into a fitting LEMMA type.
     */
    private def DataField generateDataField(String name, Schema<?> structureSchema) {
        val newDataField = dataFactory.createDataField
        newDataField.name = name

        switch (structureSchema.type) {
            case "array":
                newDataField.complexType = getOrCreateStructuredCollectionType(targetContext, name,
                    (structureSchema as ArraySchema).items)

            case "boolean":
                newDataField.primitiveType = dataFactory.createPrimitiveBoolean

            case "integer":
                newDataField.primitiveType = OpenApiUtil.deriveIntType(structureSchema.format)

            case "number":
                newDataField.primitiveType = OpenApiUtil.deriveNumberType(structureSchema.format)

            case "string":
                newDataField.primitiveType = OpenApiUtil.deriveStringType(structureSchema.format)

            case null: {
                // Currently, we only support references for this case
                if (structureSchema.get$ref === null)
                    throwUnsupportedSchemaType(structureSchema)

                val ref = structureSchema.get$ref
                val refName = ref.substring(ref.lastIndexOf("/") + 1)
                val refSchema = openAPI.components.schemas.get(refName)
                if (refName !== null && refSchema !== null) {
                	newDataField.complexType = getOrCreateDataStructure(targetContext, refName,
                        refSchema)
                } else {
                	LOGGER.info('''Encountered reference without a parsable name and/or schema.
                	  This should not bother the transformation, but check the generated
                	  LEMMA data model for completeness.''')
                }
            }

            default:
                throwUnsupportedSchemaType(structureSchema)
        }

        return newDataField
    }

    /**
     * @throws {@link IllegalArgumentException IllegalArgumentException} if OpenAPI schema type
     * cannot be translated into a fitting LEMMA type.
     * C.f. {@link #generateDataField generateDataField(...)})
     */
    private def throwUnsupportedSchemaType(Schema<?> schema) {
        throw new IllegalArgumentException('''Schema type «schema.type» is not supported.''')
    }

    /**
     * This method is used to enable one-to-many relationships during the transformation.
     * LEMMA uses ListType structures to represent such relationships,
     * therefore, corresponding ListType structures are fetched (if they already exist)
     * or newly created. The name of such structures is always the original
     * OpenAPI component name + 'List' as suffix.
     *
     * @returns {@link ListType ListType}
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
     * Static helper method to fetch the name of an OpenAPI array schema.
     */
    static def getCollectionTypeName(ArraySchema schema) {
        schema.type.collectionTypeName
    }

    /**
     * Static helper method to append the 'List' suffix to a given name.
     */
    static def getCollectionTypeName(String name) {
        '''«name.toFirstUpper»Collection'''.toString
    }
}
