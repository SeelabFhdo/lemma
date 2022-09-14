package de.fhdo.lemma.data.avro

import org.apache.avro.Schema
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.PrimitiveTypeConstants

import static de.fhdo.lemma.data.avro.Util.*
import java.util.List
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import java.util.function.BiFunction
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import java.util.Map
import org.apache.avro.Protocol
import static de.fhdo.lemma.data.avro.Shared.*
import de.fhdo.lemma.data.intermediate.IntermediateContext
import de.fhdo.lemma.data.intermediate.IntermediateVersion

/**
 * Generate Avro schema specifications from LEMMA intermediate data models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class AvroGenerator {
    /**
     * Generate schemas from IntermediateVersion
     */
    def List<Schema> generateSchemasFrom(IntermediateVersion version) {
        val complexTypes = if (!version.contexts.empty)
                version.contexts.map[it.complexTypes].flatten
            else
                version.complexTypes

        return complexTypes
            .map[it.generateSchemasFrom.value]
            .flatten
            .toList
            .withoutDuplicates
    }

    /**
     * Helper to remove duplicate schemas from a given list of schemas. Duplicate schemas are
     * identified by their LEMMA name (based on the custom helper JSON property LEMMA_NAME_PROP).
     */
    private def List<Schema> withoutDuplicates(List<Schema> schemas) {
        val uniqueSchemas = <String, Schema>newLinkedHashMap
        schemas.forEach[uniqueSchemas.put(lemmaName(it), it)]
        return uniqueSchemas.values.toList
    }

    /**
     * Generate schemas from IntermediateContext
     */
    def List<Schema> generateSchemasFrom(IntermediateContext context) {
        return context.complexTypes
            .map[it.generateSchemasFrom.value]
            .flatten
            .toList
            .withoutDuplicates
    }

    /**
     * Generate schemas from IntermediateComplexType. The return value is a pair consisting of the
     * schema specifically derived from the passed complex type and all other schemas that were
     * derived during schema generation in the context of the passed complex type, e.g., those of a
     * structure's data fields' types.
     */
    def Pair<Schema, List<Schema>> generateSchemasFrom(IntermediateComplexType complexType) {
        return switch(complexType) {
            IntermediateDataStructure: complexType.generateSchemasFrom
            IntermediateCollectionType: complexType.generateSchemasFrom
            IntermediateEnumeration: complexType.generateSchemasFrom
            default: throw new IllegalArgumentException("Schemas' generation for " +
                '''«complexType.class.simpleName» complex types is not supported''')
        }
    }

    /**
     * Generate schemas from IntermediateDataStructure. The return value is a pair consisting of the
     * schema specifically derived from the passed structure and all other schemas that were derived
     * during schema generation in the context of the passed structure, e.g., those of its data
     * fields' types.
     */
    def Pair<Schema, List<Schema>> generateSchemasFrom(IntermediateDataStructure structure) {
        return if (structure.isFixedSchemaType)
                toFixed(structure, null)
            else if (structure.isMapSchemaType)
                toMap(structure, null)
            else if (structure.isUnionSchemaType)
                toUnion(structure, null)
            else
                toRecord(structure, null)
    }

    /**
     * Helper to determine if an IntermediateDataStructure represents an Avro Fixed type. This is
     * the case, if the structure has the "AvroFixed" aspect, and the first visible data field is an
     * integer with an initialization value greater zero and exhibits the "AvroFixedSize" aspect.
     */
    private def boolean isFixedSchemaType(IntermediateDataStructure structure) {
        val visibleFields = visibleFields(structure)
        if (!hasAspect(structure, FIXED_ASPECT_FULLY_QUALIFIED) || visibleFields.size != 1)
            return false

        val sizeField = visibleFields.get(0)
        return hasAspect(sizeField, FIXED_SIZE_ASPECT_FULLY_QUALIFIED) &&
            isPrimitiveType(sizeField.originalType, PrimitiveTypeConstants.INTEGER.literal) &&
            sizeField.initializationValue !== null &&
            Integer.parseInt(sizeField.initializationValue) > 0
    }

    /**
     * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
     * Avro Fixed type. By contrast to the public toFixed(IntermediateDataStructure) method for
     * external callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toFixed(IntermediateDataStructure structure,
        String modelUri) {
        if (!structure.isFixedSchemaType)
            throw new IllegalArgumentException('''Structure «structure.qualifiedName» cannot ''' +
                "be converted to Avro Fixed type")

        val sizeField = visibleFields(structure).findFirst[
            hasAspect(it, FIXED_SIZE_ASPECT_FULLY_QUALIFIED)
        ]
        val size = Integer.parseInt(sizeField.initializationValue)
        val fixed = AvroSchemaFactory.createFixed(structure.qualifiedName, "", size)
        finishedComplexTypeSchemaCreation(fixed, modelUri)
        return fixed -> createdSchemasForModel(modelUri)
    }

    /**
     * Handle finishing of schema creation for IntermediateComplexTypes
     */
    private def void finishedComplexTypeSchemaCreation(Schema schema, String modelUri) {
        // Add created schema under the given model URI to the map of created schemas
        addToValueMap(createdSchemas, modelUri, lemmaName(schema), schema)

        // Remove the schema from the "schemas under creation" stack
        removeFromValueMap(schemasCreationStack, modelUri, lemmaName(schema))
    }

    /**
     * Map of all Avro schemas created by this instance of AvroGenerator. Note, that the map is not
     * reset after a schema generation run. The key of the map is the URI of the LEMMA model, for
     * which schemas were created. The value of the map is a nested map, whose key is the LEMMA name
     * of the schema and whose value is the schema itself.
     */
    val createdSchemas = <String, Map<String, Schema>>newLinkedHashMap

    /**
     * Map of all Avro schemas, whose creation is not finished yet, e.g., because nested schemas are
     * currently generated. An entry is removed from the stack, as soon as the corresponding schema
     * for a model got fully created. The structure of the map is the same as for the
     * "createdSchemas" map.
     */
    val schemasCreationStack = <String, Map<String, Schema>>newLinkedHashMap

    /**
     * Get all created schemas for the given modelUri
     */
    private def List<Schema> createdSchemasForModel(String modelUri) {
        return createdSchemas.get(modelUri)?.values.toList
    }

    /**
     * Generate schemas from IntermediateDataStructure, which represents an Avro Fixed type. Returns
     * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
     * created during generation.
     */
    def Pair<Schema, List<Schema>> toFixed(IntermediateDataStructure structure) {
        val fixed = toFixed(structure, null).key
        return fixed -> allCreatedSchemas()
    }

    /**
     * Get all fully created schemas across all models
     */
    private def List<Schema> allCreatedSchemas() {
        return createdSchemas.values.map[it.values].flatten().toList()
    }

    /**
     * Helper to determine if an IntermediateDataStructure represents an Avro Map type. This is the
     * case, if the structure has the "AvroMap" aspect and exactly two visible data fields. The
     * first visible data field must exhibit the "AvroMapKey" aspect and be of type string. The
     * second visible data field must exhibit the "AvroMapValue" aspect and may have an arbitrary
     * type.
     */
    private def boolean isMapSchemaType(IntermediateDataStructure structure) {
        val visibleFields = visibleFields(structure)
        if (!hasAspect(structure, MAP_ASPECT_FULLY_QUALIFIED) || visibleFields.size != 2)
            return false

        val firstField = visibleFields.get(0)
        val secondField = visibleFields.get(1)
        return hasAspect(firstField, MAP_KEY_ASPECT_FULLY_QUALIFIED)&&
            isPrimitiveType(firstField.originalType, PrimitiveTypeConstants.STRING.literal) &&
            hasAspect(secondField, MAP_VALUE_ASPECT_FULLY_QUALIFIED)
    }

    /**
     * Helper to determine if an IntermediateDataStructure represents an Avro Union type. This is
     * the case, if the structure has the "AvroUnion" aspect and visible data fields.
     */
    private def boolean isUnionSchemaType(IntermediateDataStructure structure) {
        return hasAspect(structure, UNION_ASPECT_FULLY_QUALIFIED) &&
            !visibleFields(structure).empty
    }

    /**
     * Generate schemas from IntermediateDataStructure, which represents an Avro Map type. Returns
     * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
     * created during generation.
     */
    def Pair<Schema, List<Schema>> toMap(IntermediateDataStructure structure) {
        val map = toMap(structure, null).key
        return map -> allCreatedSchemas()
    }

    /**
     * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
     * Avro Map type. By contrast to the public toMap(IntermediateDataStructure) method for external
     * callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toMap(IntermediateDataStructure structure,
        String modelUri) {
        if (!structure.isMapSchemaType)
            throw new IllegalArgumentException('''Structure «structure.qualifiedName» cannot ''' +
                "be converted to Avro Map")

        val mapValueField = visibleFields(structure).findFirst[
            hasAspect(it, MAP_VALUE_ASPECT_FULLY_QUALIFIED)
        ]
        val valueType = toRecord(newArrayList(mapValueField), modelUri, structure.qualifiedName)

        val avroMap = AvroSchemaFactory.createMap(structure.qualifiedName, valueType)
        finishedComplexTypeSchemaCreation(avroMap, modelUri)
        return avroMap -> createdSchemasForModel(modelUri)
    }

    /**
     * Create an Avro Record type from a list of IntermediateDataFields. Convenience method, which
     * creates Avro records that do not represent errors.
     */
    private def Schema toRecord(List<IntermediateDataField> dataFields, String modelUri,
        String qualifiedName) {
        return toRecord(dataFields, modelUri, qualifiedName, false)
    }

    /**
     * Create an Avro Record type from a list of IntermediateDataFields for model with the given URI
     * and with the qualifiedName. isError may be set to true, if the created Avro record shall
     * represent an error.
     */
    private def Schema toRecord(List<IntermediateDataField> dataFields, String modelUri,
        String qualifiedName, boolean isError) {
        val record = AvroSchemaFactory.createRecord(qualifiedName, "", isError)

        addToValueMap(schemasCreationStack, modelUri, lemmaName(record), record)
        // Create record fields from data structure fields
        record.fields = dataFields.map[it.toField]
        finishedComplexTypeSchemaCreation(record, modelUri)

        return record
    }

    /**
     * Create an Avro Schema Field from an IntermediateDataField
     */
    private def Schema.Field toField(IntermediateDataField field) {
        val type = field.getSchema()
        val defaultValue = if (field.initializationValue !== null)
                toPrimitiveAvroValue(field.initializationValue, field.originalType.name)
            // We always initialize schema fields with complex types with an empty value
            else if (isComplexAvroType(type))
                getEmptyComplexAvroValue(type)
        return new Schema.Field(field.name, type, "", defaultValue)
    }

    /**
     * Create an Avro Schema from the type of an IntermediateDataField
     */
    private def Schema getSchema(IntermediateDataField dataField) {
        return switch(dataField.type.kind) {
            case IntermediateTypeKind.PRIMITIVE: toPrimitiveAvroType(dataField.originalType.name)
            case IntermediateTypeKind.ENUMERATION,
            case IntermediateTypeKind.STRUCTURE,
            case IntermediateTypeKind.COLLECTION:
                dataField.type.resolveSchema
            default: throw new IllegalArgumentException("Mapping of LEMMA type " +
                '''«dataField.type.name» with kind «dataField.type.kind» and origin ''' +
                '''«dataField.type.origin» is not supported''')
        }
    }

    /**
     * Helper to resolve a type reference inside an intermediate LEMMA model to the referenced
     * type's definition and return the corresponding Avro schema
     */
    private def <RT extends IntermediateComplexType> Schema resolveSchema(
        IntermediateType typeReference
    ) {
        val BiFunction<String, RT, Pair<Schema, List<Schema>>> conversionFunction
            = switch(typeReference.kind) {
                case IntermediateTypeKind.STRUCTURE: [String modelUri, RT complexType |
                    toRecord(complexType as IntermediateDataStructure, modelUri)]
                case IntermediateTypeKind.ENUMERATION: [String modelUri, RT complexType |
                    toEnum(complexType as IntermediateEnumeration, modelUri)]
                case IntermediateTypeKind.COLLECTION: [String modelUri, RT complexType |
                    toArray(complexType as IntermediateCollectionType, modelUri)]
                default: throw new IllegalArgumentException("Schema resolution of intermediate " +
                    '''complex type «typeReference.name» with kind «typeReference.kind» and ''' +
                    '''origin «typeReference.origin» is not supported''')
            }

        val modelUriAndResolvedType = (typeReference as RT).resolve()
        val modelUri = modelUriAndResolvedType.key
        val resolvedType = modelUriAndResolvedType.value as RT
        return getSchemaFrom(modelUri, resolvedType)
            ?: conversionFunction.apply(modelUri, resolvedType).key
    }

    /**
     * Helper to resolve a type reference inside an intermediate LEMMA model to the referenced
     * type's definition. The helper returns a pair consisting of the URI of the model, which
     * specifies the type, and the type definition itself. In case the referenced type is not
     * imported from another model, the model URI is null.
     */
    private def <RT extends IntermediateComplexType> Pair<String, RT> resolve(
        IntermediateComplexType typeReference
    ) {
        val modelUriAndResolvedType = switch(typeReference) {
            IntermediateImportedComplexType: typeReference.resolve()
            IntermediateComplexType: {
                val localModel = EcoreUtil2.getContainerOfType(typeReference, IntermediateDataModel)
                null -> localModel.findComplexTypeDefinition(null, typeReference)
            }
            default: throw new IllegalArgumentException("Could not resolve intermediate complex " +
                '''type «typeReference.name» with kind «typeReference.kind» and origin ''' +
                '''«typeReference.origin»'''
            )
        }
        return modelUriAndResolvedType.key -> modelUriAndResolvedType.value as RT
    }

    /**
     * Cache for searched and found type definitions
     */
    val foundTypeDefinitionsCache = <String, IntermediateComplexType>newHashMap

    /**
     * Helper to find a complex type's definition from a given data model and reference to the type
     */
    private def IntermediateComplexType findComplexTypeDefinition(IntermediateDataModel dataModel,
        String modelUri, IntermediateComplexType typeReference) {
        val typeIdentifier = '''«IF modelUri !== null»«modelUri»$«ENDIF»''' +
            typeReference.qualifiedName

        var type = foundTypeDefinitionsCache.get(typeIdentifier)
        if (type !== null)
            return type

        // Type is not in cache, so we need to get it from the given data model
        type = dataModel.getComplexTypeDefinitions(modelUri).findFirst[
            it instanceof IntermediateComplexType &&
            qualifiedName(it) == typeReference.qualifiedName
        ]

        return if (type !== null) {
                val complexType = type as IntermediateComplexType
                foundTypeDefinitionsCache.put(typeIdentifier, complexType)
                complexType
            } else
                null
    }

    /**
     * Cache for all complex type definitions contained in traversed data models
     */
    val complexTypeDefinitionsCache = <String, List<IntermediateComplexType>>newHashMap

    /**
     * Get all complex type definitions from a data model
     */
    private def List<IntermediateComplexType> getComplexTypeDefinitions(
        IntermediateDataModel dataModel,
        String modelUri
    ) {
        var complexTypeDefinitions = complexTypeDefinitionsCache.get(modelUri)
        if (complexTypeDefinitions !== null)
            return complexTypeDefinitions

        complexTypeDefinitions = getComplexTypes(dataModel)
        complexTypeDefinitionsCache.put(modelUri, complexTypeDefinitions)
        return complexTypeDefinitions
    }

    /**
     * Helper to resolve a reference to an imported complex type. The helper returns a pair
     * consisting of the import URI of the model, which defines the complex type, and the complex
     * type definition itself.
     */
    private def Pair<String, IntermediateComplexType> resolve(
        IntermediateImportedComplexType importedType
    ) {
        val importUri = importedType.import.importUri
        val externalModel = loadExternalModel(importUri)
        var complexType = externalModel.findComplexTypeDefinition(importUri, importedType)

        if (complexType === null)
            throw new IllegalArgumentException("Could not resolve imported complex type " +
                '''«importedType.qualifiedName» in intermediate data model «importUri»''')

        return importUri -> complexType
    }

    /**
     * Cache for loaded external models
     */
    val loadedExternalModelsCache = <String, IntermediateDataModel>newHashMap

    /**
     * Load a data model from the given absolute model URI
     */
    private def IntermediateDataModel loadExternalModel(String absoluteModelUri) {
        var externalModel = loadedExternalModelsCache.get(absoluteModelUri)
        if (externalModel !== null)
            return externalModel

        externalModel = loadIntermediateDataModel(absoluteModelUri)
        if (externalModel === null)
            throw new IllegalArgumentException("Could not load intermediate data model with " +
                '''URI «absoluteModelUri»''')

        loadedExternalModelsCache.put(absoluteModelUri, externalModel)
        return externalModel
    }

    /**
     * Get an already created Avro schema specification for the given model URI and EObject. Returns
     * null if the EObject was not handled by the Avro generator thus far.
     */
    private def Schema getSchemaFrom(String modelUri, EObject eObject) {
        val lemmaName = switch (eObject) {
            IntermediateComplexType: eObject.qualifiedName
            default: throw new IllegalArgumentException("Finding schema for EObject of type " +
                '''«eObject.class.simpleName» is not supported''')
        }

        var schema = createdSchemas.get(modelUri)?.get(lemmaName)
        if (schema === null)
            schema = schemasCreationStack.get(modelUri)?.get(lemmaName)
        return null
    }

    /**
     * Generate schemas from IntermediateDataStructure, which represents an Avro Union type. Returns
     * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
     * created during generation.
     */
    def Pair<Schema, List<Schema>> toUnion(IntermediateDataStructure structure) {
        val union = toUnion(structure, null).key
        return union -> allCreatedSchemas()
    }

    /**
     * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
     * Avro Union type. By contrast to the public toUnion(IntermediateDataStructure) method for
     * external callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toUnion(IntermediateDataStructure structure,
        String modelUri) {
        if (!structure.isUnionSchemaType)
            throw new IllegalArgumentException('''Structure «structure.qualifiedName» cannot ''' +
                "be converted to Avro Union")

        val unionSchemas = visibleFields(structure).map[it.getSchema()]
        val union = AvroSchemaFactory.createUnion(structure.qualifiedName, unionSchemas, true)
        finishedComplexTypeSchemaCreation(union, modelUri)
        return union -> createdSchemasForModel(modelUri)
    }

    /**
     * Generate schemas from IntermediateDataStructure, which represents an Avro Record type.
     * Returns a pair consisting of the schema for the IntermediateDataStructure and all schemas
     * that were created during generation.
     */
    def Pair<Schema, List<Schema>> toRecord(IntermediateDataStructure structure) {
        val record = toRecord(structure, null).key
        return record -> allCreatedSchemas()
    }

    /**
     * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
     * Avro Record type. By contrast to the public toUnion(IntermediateDataStructure) method for
     * external callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toRecord(IntermediateDataStructure structure,
        String modelUri) {
        val isError = hasAspect(structure, ERROR_ASPECT_FULLY_QUALIFIED)
        val record = toRecord(visibleFields(structure), modelUri, structure.qualifiedName, isError)
        return record -> createdSchemasForModel(modelUri)
    }

    /**
     * Generate schemas from IntermediateEnumeration. The return value is a pair consisting of the
     * schema specifically derived from the passed enumeration and all other schemas that were
     * derived during schema generation in the context of the passed enumeration.
     */
    def Pair<Schema, List<Schema>> generateSchemasFrom(IntermediateEnumeration enumeration) {
        val enum = toEnum(enumeration, null).key
        return enum -> allCreatedSchemas()
    }

    /**
     * Internal helper to generate schemas from an IntermediateEnumeration, which represents an Avro
     * Enum type. By contrast to the public generateSchemasFrom(IntermediateEnumeration) method for
     * external callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toEnum(IntermediateEnumeration enumeration,
        String modelUri) {
        val avroEnum = AvroSchemaFactory.createEnum(enumeration.qualifiedName, "",
            enumeration.fields.map[it.name])
        finishedComplexTypeSchemaCreation(avroEnum, modelUri)
        return avroEnum -> createdSchemasForModel(modelUri)
    }

    /**
     * Generate schemas from IntermediateCollectionType. The return value is a pair consisting of
     * the schema specifically derived from the passed collection type and all other schemas that
     * were derived during schema generation in the context of the passed collection type.
     */
    def Pair<Schema, List<Schema>> generateSchemasFrom(IntermediateCollectionType collectionType) {
        val array = toArray(collectionType, null).key
        return array -> allCreatedSchemas()
    }

    /**
     * Internal helper to generate schemas from an IntermediateCollectionType, which represents an
     * Avro Array type. By contrast to the public generateSchemasFrom(IntermediateCollectionType)
     * method for external callers, this internal helper is model-URI-aware.
     */
    private def Pair<Schema, List<Schema>> toArray(IntermediateCollectionType collectionType,
        String modelUri) {
        val elementType = if (collectionType.primitiveCollection)
                toPrimitiveAvroType(collectionType.primitiveType.name)
            else
                toRecord(collectionType.dataFields, modelUri, collectionType.qualifiedName)

        val array = AvroSchemaFactory.createArray(collectionType.qualifiedName, elementType)
        finishedComplexTypeSchemaCreation(array, modelUri)
        return array -> createdSchemasForModel(modelUri)
    }

    /**
     * Cluster all schemas derived for the given IntermediateDataModel in an Avro protocol with the
     * specified name and namespace
     */
    def Protocol toProtocol(IntermediateDataModel dataModel, String name, String namespace) {
        return dataModel.toProtocol(name, "", namespace)
    }

    /**
     * Cluster all schemas derived for the given IntermediateDataModel in an Avro protocol with the
     * specified name, docstring, and namespace
     */
    def Protocol toProtocol(IntermediateDataModel dataModel, String name, String doc,
        String namespace) {
        val schemas = if (!dataModel.versions.empty)
                dataModel.versions.map[it.generateSchemasFrom]
            else if (!dataModel.contexts.empty)
                dataModel.contexts.map[it.generateSchemasFrom]
            else
                dataModel.complexTypes.map[it.generateSchemasFrom.value]

        return schemas.flatten.toList.withoutDuplicates.toProtocol(name, doc, namespace)
    }

    /**
     * Cluster all schemas derived for the given IntermediateVersion in an Avro protocol with the
     * specified name and namespace
     */
    def Protocol toProtocol(IntermediateVersion version, String name, String namespace) {
        return version.toProtocol(name, "", namespace)
    }

    /**
     * Cluster all schemas derived for the given IntermediateVersion in an Avro protocol with the
     * specified name, docstring, and namespace
     */
    def Protocol toProtocol(IntermediateVersion version, String name, String doc,
        String namespace) {
        val schemas = version.contexts
            .map[it.generateSchemasFrom]
            .flatten
            .toList
            .withoutDuplicates

        return schemas.toProtocol(name, doc, namespace)
    }

    /**
     * Cluster all schemas derived for the given IntermediateContext in an Avro protocol with the
     * specified name and namespace
     */
    def Protocol toProtocol(IntermediateContext context, String name, String namespace) {
        return context.toProtocol(name, "", namespace)
    }

    /**
     * Cluster all schemas derived for the given IntermediateContext in an Avro protocol with the
     * specified name, docstring, and namespace
     */
    def Protocol toProtocol(IntermediateContext context, String name, String doc,
        String namespace) {
        return context.generateSchemasFrom.toProtocol(name, doc, namespace)
    }

    /**
     * Cluster the given Avro schemas in an Avro protocol with the given name and namespace
     */
    def Protocol toProtocol(List<Schema> types, String name, String namespace) {
        return types.toProtocol(name, "", namespace)
    }

    /**
     * Cluster the given Avro schemas in an Avro protocol with the given name, docstring, and
     * namespace
     */
    def Protocol toProtocol(List<Schema> types, String name, String doc, String namespace) {
        val protocol = new Protocol(name, doc, namespace)
        protocol.types = types.filter[isNamedSchema(it)].toList
        return protocol
    }
}