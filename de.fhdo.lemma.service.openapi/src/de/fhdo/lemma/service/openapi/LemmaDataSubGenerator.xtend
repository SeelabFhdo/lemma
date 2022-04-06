package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.ListType
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.Schema
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import de.fhdo.lemma.data.DataModel
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class is responsible for handling the generation of a LEMMA data model from an
 * OpenAPI file in the JSON or YAML format.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaDataSubGenerator {
    /**
     * Map of all created DataStructures during a generation. The key contains the full-qualified
     * name while the value contains the actual data structure created.
     */
    val createdDataStructures = <String, DataStructure>newHashMap
    /**
     * Map of all created Lists during a generation. The key contains the full-qualified
     * name while the value contains the actual list structure created.
     */
    val createdListStructures = <String, ListType>newHashMap

    /** Factory to actually create and manipulate a LEMMA DataModel */
    val DATA_FACTORY = DataFactory.eINSTANCE
    /** Predefined instances of the data model, version, and context
     * which are enriched with the data structures from the OpenAPI source
     */
    val myDataModel = DATA_FACTORY.createDataModel
    val myVersion = DATA_FACTORY.createVersion
    val myContext = DATA_FACTORY.createContext

    /** Separator is used to build the full qualified names during the generation */
    val separator = "."

    /** OpenAPI schema which will be used as source for generation */
    val OpenAPI openAPI

    /** Log of all encountered exceptions during the data transformation */
    @Accessors(PUBLIC_GETTER) val transMsgs = <String>newArrayList
    /** SLF4j Logger */
    val static logger = LoggerFactory.getLogger(LemmaDataSubGenerator)

    /** Location where the generated file is written */
    val String targetFolder

    new(OpenAPI openAPI, String genPath, String dataFilename) {
        super()
        logger.debug("Creating new Data Sub Generator...")
        this.openAPI = openAPI
        this.targetFolder = genPath + dataFilename
    }

    def DataModel generate() {
        logger.debug("Starting generation...")
        logger.debug("Initializing model instance...")
        initilize()
        logger.debug("...data model initialized!")
        logger.debug("Creating data structures...")

        openAPI?.components?.schemas?.forEach[
            key, value | {
                try {
                    getOrCreateDataStructure(myContext, key, value)
                } catch (Exception e) {
                    transMsgs.add(
                        '''Error for DataStructure «key», structure is skipped.
                        For details access debug log.''')
                    logger.debug(e.message)
                }
            }
        ]
        logger.debug("...data structures created!")

        if (OpenApiUtil.writeModel(myDataModel, targetFolder)) {
            logger.info("Data model generation successful!")
            logger.info('''Model written to «targetFolder»''')
        } else
            throw new Exception("Data model generation failed.")
        return myDataModel
    }

    def initilize() {
        // Data Model
        myDataModel.versions.add(myVersion)
        // Version
        myVersion.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.version)
        myVersion.contexts.add(myContext)
        // Context
        myContext.name = OpenApiUtil.removeInvalidCharsFromName(openAPI.info.title)
        myContext.version = myVersion
    }

    def DataStructure getOrCreateDataStructure(
        Context c, String name, Schema schema
    ) {
        var foundObject = findDataStructure(c, StringUtils.capitalize(name))
        if (foundObject === null) {
            val newDataStructure = DATA_FACTORY.createDataStructure
            newDataStructure.name = StringUtils.capitalize(name)
            c.complexTypes.add(newDataStructure)
            addDataFieldsToDataStructure(newDataStructure, name, schema)
            createdDataStructures.put(
                newDataStructure.buildQualifiedName(separator), newDataStructure
            )
            logger.debug('''Created new data structure «newDataStructure.name»''')
            return newDataStructure
        } else {
            logger.debug('''Found and reuse existing data structure «foundObject.name»''')
            return foundObject
        }
    }

    def ListType getOrCreateListStructure(Context c, String name, Schema schema) {
        var foundObject = findListStructure(c, name)
        if (foundObject === null) {
            val newListStructure = DATA_FACTORY.createListType
            newListStructure.name = '''«StringUtils.capitalize(name)»List'''
            c.complexTypes.add(newListStructure)
            addDataFieldsToListStructure(newListStructure, name, schema)
            createdListStructures.put(
                newListStructure.buildQualifiedName(separator), newListStructure
            )
            logger.debug('''Created new list structure «newListStructure.name»''')
            return newListStructure
        } else {
            logger.debug('''Found and reuse existing list structure «foundObject.name»''')
            return foundObject
        }
    }

    def void addDataFieldsToDataStructure(
        DataStructure ds, String structureName, Schema structureSchema
    ) {
        if (structureSchema.properties !== null) {
            structureSchema.properties.forEach[
                name, schema|addDataFieldsToDataStructure(ds, name, schema)
            ]
        } else {
            val newDataField = generateDataField(structureName, structureSchema)
            ds.dataFields.add(newDataField)
        }
    }

    def addDataFieldsToListStructure(
        ListType ds, String structureName, Schema structureSchema
    ) {
        val newDataField = generateDataField(structureName, structureSchema)
        ds.dataFields.add(newDataField)
    }

    def DataField generateDataField(
        String structureName, Schema structureSchema
    ) {
        val newDataField = DATA_FACTORY.createDataField
        newDataField.name = StringUtils.lowerCase(structureName)

        switch (structureSchema.type) {
            case "integer": {
                newDataField.primitiveType = OpenApiUtil.deriveIntType(structureSchema.format)
            }
            case "number": {
                newDataField.primitiveType = OpenApiUtil.deriveNumberType(structureSchema.format)
            }
            case "string": {
                newDataField.primitiveType = OpenApiUtil.deriveStringType(structureSchema.format)
            }
            case "boolean": {
                newDataField.primitiveType = DATA_FACTORY.createPrimitiveBoolean
            }
            case "array": {
                val itemSchema = structureSchema as ArraySchema
                val listStructure = getOrCreateListStructure(
                    myContext, structureName, itemSchema.items
                )
                newDataField.complexType = listStructure
            }
            case null: {
                // If Attribute is actually a reference...
                if (structureSchema.get$ref !== null) {
                    val s = structureSchema.get$ref
                    val key = s.substring(s.lastIndexOf("/") + 1)
                    val value = openAPI.components.schemas.get(key)
                    if (key !== null && value !== null) {
                        newDataField.complexType = getOrCreateDataStructure(
                            myContext, key, value
                        )
                    }
                }
            }
            default:
                throw new IllegalArgumentException(
                    "schema type " + structureSchema.type + " not supported"
                )
        }
        return newDataField
    }

    def DataStructure findDataStructure(Context context, String name) {
        val searchName = '''«context.buildQualifiedName(separator)».«name»'''
        return createdDataStructures.get(searchName)
    }

    def ListType findListStructure(Context context, String name) {
        val searchName = '''«context.buildQualifiedName(separator)».«name»'''
        return createdListStructures.get(searchName)
    }
}
