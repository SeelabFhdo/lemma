package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.ListType
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.Schema
import org.slf4j.LoggerFactory
import de.fhdo.lemma.data.DataModel
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.data.DataField

// TODO: Add Javadoc comments to methods

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
     * Map of all created Lists during a generation. The key contains the fully-qualified name while
     * the value contains the actual structured list type created.
     */
    val createdStructuredListTypes = <String, ListType>newHashMap

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

    private def initialize() {
        targetDataModel.versions.add(targetVersion)

        targetVersion.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.version)
        targetVersion.contexts.add(targetContext)

        targetContext.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.title)
        targetContext.version = targetVersion
    }

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

    private def void addDataFieldsFromSchema(DataStructure structure, Schema<?> structureSchema) {
        structure.addDataFieldsFromSchema(null, structureSchema)
    }

    private def void addDataFieldsFromSchema(DataStructure structure, String fieldName,
        Schema<?> structureSchema) {
        if (structureSchema.properties !== null)
            structureSchema.properties.forEach[name, schema |
                structure.addDataFieldsFromSchema(name, schema)
            ]
        else
            structure.dataFields.add(generateDataField(fieldName, structureSchema))
    }

    private def DataField generateDataField(String name, Schema<?> structureSchema) {
        val newDataField = dataFactory.createDataField
        newDataField.name = name

        switch (structureSchema.type) {
            case "array":
                newDataField.complexType = getOrCreateStructuredListType(targetContext, name,
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
                // TODO: What should happen when refName or refSchema is null?
                if (refName !== null && refSchema !== null)
                    newDataField.complexType = getOrCreateDataStructure(targetContext, refName,
                        refSchema)
            }

            default:
                throwUnsupportedSchemaType(structureSchema)
        }

        return newDataField
    }

    private def throwUnsupportedSchemaType(Schema<?> schema) {
        throw new IllegalArgumentException('''Schema type «schema.type» not supported''')
    }

    private def getOrCreateStructuredListType(Context context, String name,
        Schema<?> schema) {
        val typeName = name.listTypeName
        val fullyQualifiedTypeName = '''«context.buildQualifiedName(SEP)»«SEP»«typeName»'''
        val existingType = createdStructuredListTypes.get(fullyQualifiedTypeName)
        if (existingType !== null) {
            LOGGER.debug('''Found and reuse existing structured list type «existingType.name»''')
            return existingType
        }

        val newType = dataFactory.createListType
        newType.name = typeName
        context.complexTypes.add(newType)
        newType.dataFields.add(generateDataField(name, schema))
        createdStructuredListTypes.put(fullyQualifiedTypeName, newType)
        LOGGER.debug('''Created new structured list type «newType.name»''')
        return newType
    }

    static def getListTypeName(ArraySchema schema) {
        schema.type.listTypeName
    }

    static def getListTypeName(String name) {
        '''«name.toFirstUpper»List'''.toString
    }
}
