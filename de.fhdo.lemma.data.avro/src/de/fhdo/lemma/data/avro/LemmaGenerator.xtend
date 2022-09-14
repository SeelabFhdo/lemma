package de.fhdo.lemma.data.avro

import org.apache.avro.Schema
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.Context
import org.eclipse.emf.ecore.EObject

import static de.fhdo.lemma.data.avro.Util.*
import java.util.Map
import java.util.List
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.Type
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.EnumerationField
import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.technology.mapping.MappingFactory
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.service.TechnologyReference
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap
import de.fhdo.lemma.technology.TechnologyFactory
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect
import static de.fhdo.lemma.data.avro.Shared.*
import java.util.Set
import de.fhdo.lemma.data.PrimitiveInteger
import org.apache.avro.Protocol
import de.fhdo.lemma.data.Version
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Generate LEMMA models from Avro schema specifications.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LemmaGenerator {
    static val DOMAIN_MODEL_IMPORT_ALIAS = "Domain"
    static val SERVICE_MODEL_IMPORT_ALIAS = "Services"

    static val DATA_FACTORY = DataFactory.eINSTANCE
    static val MAPPING_FACTORY = MappingFactory.eINSTANCE
    static val SERVICE_FACTORY = ServiceFactory.eINSTANCE
    static val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE

    /**
     * Generate LEMMA models from Avro protocol. Returns a pair consisting of the generated domain
     * and possibly generated mapping model.
     */
    def Pair<DataModel, TechnologyMapping> generateModelsFrom(
        Protocol protocol,
        String serviceModelPath,
        String avroModelPath
    ) {
        return protocol.generateModelsFrom(DOMAIN_MODEL_IMPORT_ALIAS, serviceModelPath,
            SERVICE_MODEL_IMPORT_ALIAS, avroModelPath, AVRO_TECHNOLOGY_NAME)
    }

    /**
     * Generate LEMMA models from Avro protocol. Returns a pair consisting of the generated domain
     * and possibly generated mapping model. This method allows for specifying import aliases of
     * generated models. Returns a pair consisting of the generated domain and possibly generated
     * mapping model.
     */
    def Pair<DataModel, TechnologyMapping> generateModelsFrom(
        Protocol protocol,
        String domainImportAlias,
        String serviceModelPath,
        String serviceImportAlias,
        String avroModelPath,
        String avroImportAlias
    ) {
        return protocol.types.toList.generateModelsFrom(domainImportAlias, serviceModelPath,
            serviceImportAlias, avroModelPath, avroImportAlias)
    }

    /**
     * Generate LEMMA models from several Avro schemas. Returns a pair consisting of the generated
     * domain and possibly generated mapping model.
     */
    def Pair<DataModel, TechnologyMapping> generateModelsFrom(
        List<Schema> schemas,
        String serviceModelPath,
        String avroModelPath
    ) {
        return schemas.generateModelsFrom(DOMAIN_MODEL_IMPORT_ALIAS, serviceModelPath,
            SERVICE_MODEL_IMPORT_ALIAS, avroModelPath, AVRO_TECHNOLOGY_NAME)
    }

    /**
     * Generate LEMMA models from several Avro schemas. Returns a pair consisting of the generated
     * domain and possibly generated mapping model. This method allows for specifying import aliases
     * of generated models. Returns a pair consisting of the generated domain and possibly generated
     * mapping model.
     */
    def Pair<DataModel, TechnologyMapping> generateModelsFrom(
        List<Schema> schemas,
        String domainImportAlias,
        String serviceModelPath,
        String serviceImportAlias,
        String avroModelPath,
        String avroImportAlias
    ) {
        val dataModelElements = <EObject>newArrayList
        val mappingModelElements = <EObject>newArrayList

        schemas.forEach[
            val generatedEObjects = it.generateEObjectsFromNamedSchema
            if (generatedEObjects !== null) {
                dataModelElements.addAll(generatedEObjects.value.get(DataModel) ?: emptyList)
                mappingModelElements.addAll(
                    generatedEObjects.value.get(TechnologyMapping) ?: emptyList
                )
            }
        ]

        val dataModel = dataModelElements.toDataModel
        val mappingModel = mappingModelElements.toMappingModel(domainImportAlias, serviceModelPath,
            serviceImportAlias, avroModelPath, avroImportAlias)
        return dataModel -> mappingModel
    }

    /**
     * Generate LEMMA EObjects from Avro named schema. Returns a pair consisting of the EObject
     * specifically derived from the passed schema and all other EObjects that were derived during
     * EObject generation in the context of the passed schema.
     */
    private def Pair<
        EObject,
        Map<Class<? extends EObject>, List<EObject>>
    > generateEObjectsFromNamedSchema(
        Schema schema
    ) {
        if (!isNamedSchema(schema))
            throw new IllegalArgumentException('''Avro schema of type «schema.type» is not a ''' +
                "named schema")

        return switch(schema.type) {
            case Schema.Type.ENUM: toEnumeration(schema)
            case Schema.Type.FIXED,
            case Schema.Type.RECORD:
                toDataStructure(schema)
            default: throw new IllegalArgumentException("EObject generation from named Avro " +
                '''schema type «schema.type» is not supported''')
        }
    }

    /**
     * Generate LEMMA EObjects from Avro Enum. Returns a pair consisting of the EObject (LEMMA
     * Enumeration) specifically derived from the passed schema and all other EObjects that were
     * derived during EObject generation in the context of the passed schema.
     */
    def Pair<
        EObject,
        Map<Class<? extends EObject>, List<EObject>>
    > toEnumeration(
        Schema schema
    ) {
        schema.ensureType(Schema.Type.ENUM)
        val enumeration = createEnumeration(schema.lemmaNameElseSchemaName, schema.namespace)
        startedEObjectCreation(DataModel, enumeration)
        enumeration.fields.addAll(schema.enumSymbols.map[createEnumerationField(it)])
        finishedEObjectCreation(DataModel, enumeration)
        return enumeration -> allCreatedEObjects()
    }

    /**
     * Helper to ensure that an Avro schema is one of the expected types. Throws an
     * IllegalArgumentException if that is not the case.
     */
    private def ensureType(Schema schema, Schema.Type... expectedTypes) {
        if (!expectedTypes.contains(schema.type))
            throw new IllegalArgumentException('''Schema «schema.fullName» is not of one of ''' +
                '''the expected types «expectedTypes.join(", ")»''')
    }

    /**
     * Return the simple LEMMA name from this schema. If a LEMMA name is not present, return the
     * simple name of the schema.
     */
    private def String lemmaNameElseSchemaName(Schema schema) {
        return LemmaUtils.getSimpleName(lemmaNameOrElse(schema, schema.name))
    }

    /**
     * Create a LEMMA Enumeration instance
     */
    private def Enumeration createEnumeration(String name, String avroNamespace) {
        val enumeration = DATA_FACTORY.createEnumeration
        enumeration.name = name
        enumeration.version = getOrCreateVersion(avroNamespace)
        enumeration.context = getOrCreateContext(avroNamespace)
        return enumeration
    }

    /**
     * Helper to retrieve a LEMMA Version from an Avro namespace. In case a corresponding Version
     * instance was already created, return it. If no version information could be extracted from
     * the Avro namespace, return null.
     */
    private def Version getOrCreateVersion(String avroNamespace) {
        if (avroNamespace === null || qualifyingLevelCount(avroNamespace) < 3)
            return null

        val versionName = getQualifyingPartsAsList(avroNamespace).get(0)
        var version = <Version>getCreatedEObject(DataModel, versionName)
        if (version === null) {
            version = DATA_FACTORY.createVersion
            version.name = versionName
            addCreatedEObject(DataModel, version)
        }

        return version
    }

    /**
     * Helper to retrieve a LEMMA Context from an Avro namespace. In case a corresponding Context
     * instance was already created, return it. If no context information could be extracted from
     * the Avro namespace, return null.
     */
    private def Context getOrCreateContext(String avroNamespace) {
        if (avroNamespace === null)
            return null

        val hasVersion = qualifyingLevelCount(avroNamespace) >= 3
        val contextNameParts = if (hasVersion) {
                val qualifyingParts = getQualifyingPartsAsList(avroNamespace)
                qualifyingParts.subList(1, qualifyingParts.size).join(".")
            } else
                avroNamespace
        val contextName = toLemmaNamespace(contextNameParts)

        var context = <Context>getCreatedEObject(DataModel, contextName)
        if (context === null) {
            context = DATA_FACTORY.createContext
            context.name = contextName
            context.version = getOrCreateVersion(avroNamespace)
            addCreatedEObject(DataModel, context)
        }

        return context
    }

    /**
     * Map of all EObjects that were successfully created during generation. The key of the map
     * identifies the model type. The value of the map is a nested map, whose key is the qualified
     * name of the value EObject under creation.
     */
    val createdEObjects = <Class<? extends EObject>, Map<String, EObject>>newHashMap

    /**
     * Map of all fully-qualified names of all EObjects discovered during a generation run for a
     * given model type. Note, that this map is never deleted.
     */
    val eObjectNames = <Class<? extends EObject>, Set<String>>newHashMap

    /**
     * Add an EObject to the map of created EObjects for the given model type
     */
    private def void addCreatedEObject(Class<? extends EObject> modelType, EObject eObject) {
        addCreatedEObject(modelType, eObject, qualifiedName(eObject))
    }

    /**
     * Add an EObject to the map of created EObjects for the given model type and qualified name
     */
    private def void addCreatedEObject(Class<? extends EObject> modelType, EObject eObject,
        String qualifiedName) {
        addToValueMap(createdEObjects, modelType, qualifiedName, eObject)
        addToValueSet(eObjectNames, modelType, qualifiedName)
    }

    /**
     * Get an EObject with the given qualified name for the given model type from the cache of
     * created EObjects
     */
    private def <T extends EObject> T getCreatedEObject(Class<? extends EObject> modelType,
        String qualifiedName) {
        return createdEObjects.get(modelType)?.getEObject(qualifiedName)
    }

    /**
     * Generic helper to retrieve an EObject with a certain type from a map of EObjects by the
     * specified qualified name
     */
    private def <T extends EObject> T getEObject(Map<String, EObject> eObjectMap,
        String qualifiedName) {
        val eObject = eObjectMap.get(qualifiedName)
        return if (eObject !== null)
                try {
                    eObject as T
                } catch(ClassCastException ex) {
                    null
                }
            else
                null
    }

    /**
     * Check if an EObject with the given qualified name got already created
     */
    private def boolean existsCreatedEObject(Class<? extends EObject> modelType,
        String qualifiedName) {
        val eObjects = createdEObjects.get(modelType)
        return if (eObjects!== null)
                eObjects.containsKey(qualifiedName)
            else
                false
    }

    /**
     * Helper to return all EObjects that were created
     */
    private def Map<Class<? extends EObject>, List<EObject>> allCreatedEObjects() {
        return createdEObjects.mapValues[it.values.toList]
    }

    /**
     * Map of all EObjects, whose creation is not finished yet, e.g., because nested EObjects are
     * currently generated. An entry is removed from the stack, as soon as the corresponding EObject
     * for a model got fully created. The structure of the map is the same as for "createdEObjects".
     */
    val eObjectCreationStack = <Class<? extends EObject>, Map<String, EObject>>newHashMap

    /**
     * Signal the start of the creation of a new EObject
     */
    private def void startedEObjectCreation(Class<? extends EObject> modelType, EObject eObject) {
        addToCreationStack(modelType, eObject)
    }

    /**
     * Add an EObject to the creation stack for the given model type
     */
    private def void addToCreationStack(Class<? extends EObject> modelType, EObject eObject) {
        addToCreationStack(modelType, eObject, qualifiedName(eObject))
    }

    /**
     * Add an EObject to the creation stack for the given model type and fully-qualified name
     */
    private def void addToCreationStack(Class<? extends EObject> modelType, EObject eObject,
        String qualifiedName) {
        //eObjectCreationStack.addEObject(eObject, qualifiedName)
        addToValueMap(eObjectCreationStack, modelType, qualifiedName, eObject)
        addToValueSet(eObjectNames, modelType, qualifiedName)
    }

    /**
     * Check if an EObject with the given qualified name exists on the EObject creation stack for
     * the given model type
     */
    private def boolean existsOnCreationStack(Class<? extends EObject> modelType,
        String qualifiedName) {
        val eObjects = eObjectCreationStack.get(modelType)
        return if (eObjects!== null)
                eObjects.containsKey(qualifiedName)
            else
                false
    }

    /**
     * Get EObject with the given qualified name and for the given model type from the EObject
     * creation stack
     */
    private def <T extends EObject> T getFromCreationStack(Class<? extends EObject> modelType,
        String qualifiedName) {
        return eObjectCreationStack.get(modelType)?.getEObject(qualifiedName)
    }

    /**
     * Remove EObject for the given model type from the EObject creation stack
     */
    private def void removeFromCreationStack(Class<? extends EObject> modelType, EObject eObject) {
        removeFromValueMap(eObjectCreationStack, modelType, qualifiedName(eObject))
    }

    /**
     * Create a LEMMA EnumerationField instance
     */
    private def EnumerationField createEnumerationField(String name) {
        val enumerationField = DATA_FACTORY.createEnumerationField
        enumerationField.name = name
        return enumerationField
    }

    /**
     * Signal the finishing of the creation of a new EObject
     */
    private def void finishedEObjectCreation(Class<? extends EObject> modelType, EObject eObject) {
        addCreatedEObject(modelType, eObject)
        removeFromCreationStack(modelType, eObject)
    }

    /**
     * Create a new LEMMA DataModel from the given EObject instances
     */
    private def DataModel toDataModel(List<EObject> eObjects) {
        val dataModel = DATA_FACTORY.createDataModel
        val versions = <String, Version>newLinkedHashMap
        val contexts = <String, Context>newLinkedHashMap
        val complexTypes = <String, ComplexType>newLinkedHashMap

        eObjects.forEach[
            switch(it) {
                Version: versions.put(it.name, it)
                Context: contexts.put(qualifiedName(it), it)
                ComplexType: complexTypes.put(qualifiedName(it), it)
            }
        ]

        if (!versions.empty)
            dataModel.versions.addAll(versions.values)
        else if (!contexts.empty)
            dataModel.contexts.addAll(contexts.values)
        else
            dataModel.complexTypes.addAll(complexTypes.values)

        return dataModel
    }

    /**
     * Create a new LEMMA TechnologyMapping model from the given EObject instances. The domain
     * import alias must correspond to the alias of the domain model in a service model. The service
     * and Avro import aliases will be used to identify Import instances from the EObject instances
     * that shall point to the given service and Avro technology model paths.
     */
    private def TechnologyMapping toMappingModel(List<EObject> eObjects, String domainImportAlias,
        String serviceModelPath, String serviceImportAlias, String avroModelPath,
        String avroImportAlias) {
        val mappingModel = MAPPING_FACTORY.createTechnologyMapping
        val imports = <String, Import>newLinkedHashMap
        val typeMappings = <String, ComplexTypeMapping>newLinkedHashMap

        eObjects.forEach[
            switch(it) {
                Import: {
                    if (it.name == SERVICE_MODEL_IMPORT_ALIAS) {
                        it.importURI = serviceModelPath
                        it.name = serviceImportAlias
                    } else if (it.name == AVRO_TECHNOLOGY_NAME) {
                        it.importURI = avroModelPath
                        it.name = avroImportAlias
                    }

                    if (it.importType == ImportType.MICROSERVICES ||
                        it.importType == ImportType.TECHNOLOGY)
                        imports.put(it.name, it)
                }

                ComplexTypeMapping: {
                    it.type.serviceModelImport.name = serviceImportAlias
                    it.type.dataModelImport.name = domainImportAlias
                    typeMappings.put(qualifiedName(it), it)
                }
            }
        ]

        mappingModel.imports.addAll(imports.values)
        mappingModel.typeMappings.addAll(typeMappings.values)
        return mappingModel
    }

    /**
     * Generate LEMMA EObjects from Avro Fixed or Record schema. Returns a pair consisting of the
     * EObject (LEMMA DataStructure) specifically derived from the passed schema and all other
     * EObjects that were derived during EObject generation in the context of the passed schema.
     */
    def Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toDataStructure(Schema schema) {
        schema.ensureType(
            Schema.Type.FIXED,
            Schema.Type.RECORD
        )

        return toDataStructure(schema, schema.namespace)
    }

    /**
     * Generate LEMMA EObjects from Avro Fixed, Map, Record, or Union schema in the given namespace.
     * Returns a pair consisting of the EObject (LEMMA DataStructure) specifically derived from the
     * passed schema and all other EObjects that were derived during EObject generation in the
     * context of the passed schema.
     */
    def Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toDataStructure(Schema schema,
        String namespace) {
        schema.ensureType(
            Schema.Type.FIXED,
            Schema.Type.MAP,
            Schema.Type.RECORD,
            Schema.Type.UNION
        )

        if (existsEObject(schema.lemmaNameElseSchemaName, namespace, DataModel))
            return null

        val dataStructure = createDataStructure(schema.lemmaNameElseSchemaName, namespace)
        startedEObjectCreation(DataModel, dataStructure)

        dataStructure.dataFields.addAll(
            schema.fields.map[toDataField(name, it.schema, defaultVal, dataStructure)]
        )

        if (schema.isError)
            dataStructure.adaptToAvroError
        else if (schema.type == Schema.Type.FIXED)
            dataStructure.adaptToAvroFixed
        else if (schema.type == Schema.Type.MAP)
            dataStructure.adaptToAvroMap
        else if (schema.type == Schema.Type.UNION)
            dataStructure.adaptToAvroUnion

        finishedEObjectCreation(DataModel, dataStructure)
        return dataStructure -> allCreatedEObjects()
    }

    /**
     * Check if an EObject with the given name and Avro namespace was already created or is under
     * creation in the context of the given model type
     */
    private def boolean existsEObject(String name, String avroNamespace,
        Class<? extends EObject> modelType) {
        val qualifiedName = '''«IF !avroNamespace.nullOrEmpty»«avroNamespace».«ENDIF»«name»'''
        return existsCreatedEObject(modelType, qualifiedName) ||
            existsOnCreationStack(modelType, qualifiedName)
    }

    /**
     * Create a LEMMA DataStructure with the given name, and a version and context corresponding to
     * the given Avro namespace
     */
    private def DataStructure createDataStructure(String name, String avroNamespace) {
        val structure = DATA_FACTORY.createDataStructure
        structure.name = name
        structure.version = getOrCreateVersion(avroNamespace)
        structure.context = getOrCreateContext(avroNamespace)
        return structure
    }

    /**
     * Create a LEMMA DataField with the given name and type derived from the given Avro schema.
     * The data field may receive an initialization value and is part of a concrete ComplexType.
     */
    private def DataField toDataField(String name, Schema typeSchema, Object initializationValue,
        ComplexType parentType) {
        val dataField = DATA_FACTORY.createDataField
        dataField.name = name
        val type = typeSchema.toType(parentType)
        switch(type) {
            PrimitiveType: dataField.primitiveType = type
            ComplexType: dataField.complexType = type
        }
        if (type instanceof PrimitiveType)
            dataField.initializationValue = toPrimitiveLemmaValue(initializationValue?.toString,
                type)
        return dataField
    }

    /**
     * Derive LEMMA Type from the given Avro schema
     */
    private def Type toType(Schema schema, ComplexType parentType) {
        val type = if (isPrimitiveAvroType(schema))
                toPrimitiveLemmaType(schema)
            else if (existsCreatedEObject(DataModel, schema.fullName))
                <ComplexType>getCreatedEObject(DataModel, schema.fullName)
            else if (existsOnCreationStack(DataModel, schema.fullName))
                <ComplexType>getFromCreationStack(DataModel, schema.fullName)
            else if (isNamedSchema(schema))
                generateEObjectsFromNamedSchema(schema).key as ComplexType
            else {
                val namespace = LemmaUtils.getQualifyingParts(qualifiedName(parentType))
                generateEObjectsFromUnnamedSchema(schema, namespace).key as ComplexType
            }

        if (type === null)
            throw new IllegalArgumentException('''Type «schema.type» of schema ''' +
                '''«schema.fullName» cannot be converted to LEMMA type''')

        return type
    }

    /**
     * Generate LEMMA EObjects from an Avro unnamed schema (Arrays, Maps, Unions). Returns a pair
     * consisting of the LEMMA EObject specifically derived from the passed schema and all other
     * EObjects that were derived during EObject generation in the context of the passed schema.
     */
    private def Pair<EObject, Map<Class<? extends EObject>, List<EObject>>>
    generateEObjectsFromUnnamedSchema(
        Schema schema,
        String namespace
    ) {
        if (isNamedSchema(schema))
            throw new IllegalArgumentException('''Avro schema of type «schema.type» is not an ''' +
                "unnamed schema")

        return switch(schema.type) {
            case Schema.Type.ARRAY: toCollectionType(schema, namespace)
            case Schema.Type.MAP,
            case Schema.Type.UNION:
                toDataStructure(schema, namespace)
            default: throw new IllegalArgumentException("EObject generation from unnamed Avro " +
                '''schema type «schema.type» is not supported''')
        }
    }

    /**
     * Generate LEMMA EObjects from Avro Array schema in the given namespace. Returns a pair
     * consisting of the EObject (LEMMA CollectionType) specifically derived from the passed schema
     * and all other EObjects that were derived during EObject generation in the context of the
     * passed schema.
     */
    def Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toCollectionType(Schema schema,
        String namespace) {
        schema.ensureType(Schema.Type.ARRAY)
        val collectionType = createCollectionType(schema.lemmaNameElseSchemaName, namespace,
            lemmaName(schema) !== null)
        startedEObjectCreation(DataModel, collectionType)

        val typeSchema = schema.elementType
        if (isPrimitiveAvroType(typeSchema))
            collectionType.primitiveType = toPrimitiveLemmaType(schema.elementType)
        else if (typeSchema.type == Schema.Type.RECORD)
            collectionType.dataFields.addAll(
                typeSchema.fields.map[toDataField(name, it.schema, null, collectionType)]
            )
        else
            collectionType.dataFields.add(
                toDataField(typeSchema.lemmaNameElseSchemaName.toFirstLower, typeSchema, null,
                    collectionType)
            )

        finishedEObjectCreation(DataModel, collectionType)
        return collectionType -> allCreatedEObjects()
    }

    /**
     * Create LEMMA CollectionType with the given name and in the LEMMA namespace corresponding to
     * the given Avro namespace. A unique name for the CollectionType may be generated, e.g., when
     * the source Avro schema was an unnamed nested schema inside another schema.
     */
    private def CollectionType createCollectionType(String name, String avroNamespace,
        boolean generateUniqueName) {
        val collectionType = DATA_FACTORY.createCollectionType
        collectionType.name = name
        collectionType.version = getOrCreateVersion(avroNamespace)
        collectionType.context = getOrCreateContext(avroNamespace)
        if (generateUniqueName)
            collectionType.name = qualifiedName(collectionType).toUniqueName(DataModel)
        return collectionType
    }

    /**
     * Adapt a LEMMA DataStructure to represent an Avro Error. Avro Errors are represented in LEMMA
     * by means of structures with the AvroError aspect.
     */
    private def void adaptToAvroError(DataStructure structure) {
        val mappingAndAvroImport = structure.createDefaultComplexTypeMapping()
        val complexTypeMapping = mappingAndAvroImport.key
        val avroImport = mappingAndAvroImport.value
        startedEObjectCreation(TechnologyMapping, complexTypeMapping)
        complexTypeMapping.addAspect(avroImport, ERROR_ASPECT)
        finishedEObjectCreation(TechnologyMapping, complexTypeMapping)
    }

    /**
     * Create a LEMMA ComplexTypeMapping for the given LEMMA DataStructure based on the Avro
     * technology model. The mapping takes default values for the Avro technology name, and service
     * and domain model import aliases. The method returns a pair consisting of the
     * ComplexTypeMapping and the Import instance for the Avro technology model.
     */
    private def Pair<ComplexTypeMapping, Import> createDefaultComplexTypeMapping(
        DataStructure structure
    ) {
        val preliminaryAvroImport = getOrCreateImport(AVRO_TECHNOLOGY_NAME, null,
            ImportType.TECHNOLOGY, TechnologyMapping)
        val preliminaryServiceModelImport = getOrCreateImport(SERVICE_MODEL_IMPORT_ALIAS, null,
            ImportType.MICROSERVICES, TechnologyMapping)
        val preliminaryDomainModelImport = getOrCreateImport(DOMAIN_MODEL_IMPORT_ALIAS, null,
            ImportType.DATATYPES, TechnologyMapping)
        return createComplexTypeMapping(
            preliminaryAvroImport,
            preliminaryServiceModelImport,
            preliminaryDomainModelImport,
            structure
        ) -> preliminaryAvroImport
    }

    /**
     * Helper to get or create an Import instance with the given name, URI and type, and for the
     * given model type
     */
    private def Import getOrCreateImport(String name, String importUri, ImportType importType,
        Class<? extends EObject> importingModelType) {
        val qualifiedName = '''$import.«name»'''
        var _import = <Import>getCreatedEObject(importingModelType, qualifiedName)
        if (_import === null) {
            _import = SERVICE_FACTORY.createImport
            _import.name = name
            _import.importURI = importUri
            _import.importType = importType
            addCreatedEObject(importingModelType, _import, qualifiedName)
        }
        return _import
    }

    /**
     * Create a LEMMA ComplexTypeMapping for the given LEMMA ComplexType using the specified
     * technology, service, and domain model Imports
     */
    private def ComplexTypeMapping createComplexTypeMapping(
        Import technologyImport,
        Import serviceModelImport,
        Import domainModelImport,
        ComplexType complexType
    ) {
        val mapping = MAPPING_FACTORY.createComplexTypeMapping
        mapping.technologyReferences.add(technologyImport.createTechnologyReference)
        mapping.type = createImportedComplexTypeToMap(serviceModelImport, domainModelImport,
            complexType)
        return mapping
    }

    /**
     * Create a LEMMA TechnologyReference for the given technology Import
     */
    private def TechnologyReference createTechnologyReference(Import technologyImport) {
        val technologyReference = SERVICE_FACTORY.createTechnologyReference
        technologyReference.technology = technologyImport
        return technologyReference
    }

    /**
     * Create a LEMMA ImportedComplexTypeToMap for the given ComplexType with the specified service
     * and domain model Imports
     */
    private def ImportedComplexTypeToMap createImportedComplexTypeToMap(
        Import serviceModelImport,
        Import domainModelImport,
        ComplexType complexType
    ) {
        val importedComplexTypeToMap = MAPPING_FACTORY.createImportedComplexTypeToMap
        importedComplexTypeToMap.serviceModelImport = serviceModelImport
        importedComplexTypeToMap.dataModelImport = domainModelImport
        importedComplexTypeToMap.type = complexType
        return importedComplexTypeToMap
    }

    /**
     * Add an aspect with the specified name from the given technology Import to the given
     * ComplexTypeMapping
     */
    private def void addAspect(ComplexTypeMapping mapping, Import technologyImport,
        String aspectName) {
        mapping.aspects.add(createImportedAspect(technologyImport, aspectName))
    }

    /**
     * Create a LEMMA TechnologySpecificImportedServiceAspect for the aspect with the given name
     * from the specified technology Import
     */
    private def TechnologySpecificImportedServiceAspect createImportedAspect(
        Import technologyImport,
        String aspectName
    ) {
        val aspect = MAPPING_FACTORY.createTechnologySpecificImportedServiceAspect
        aspect.technology = technologyImport
        aspect.aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.aspect.name = aspectName
        return aspect
    }

    /**
     * Adapt a LEMMA DataStructure to represent an Avro Fixed type. Avro Fixed types are represented
     * in LEMMA by means of structures with a single integer data field, whose initialization value
     * must be greater zero. Moreover, the structure receives the AvroFixed and the field the
     * AvroFixedSize aspect.
     */
    private def void adaptToAvroFixed(DataStructure structure) {
        val fieldCount = structure.dataFields.size
        if (fieldCount != 1)
            throw new IllegalArgumentException('''Structure «qualifiedName(structure)» does ''' +
                "not represent an Avro Fixed type: Invalid field count (expected: 1, found: " +
                '''«fieldCount»)''')

        val sizeField = structure.dataFields.get(0)
        if (!(sizeField.effectiveType instanceof PrimitiveInteger))
            throw new IllegalArgumentException('''Structure «qualifiedName(structure)» does ''' +
                '''not represent an Avro Fixed type: Size field «sizeField.name» has invalid ''' +
                "type (expected: PrimitiveInteger, found: " +
                '''«sizeField.effectiveType.class.simpleName»)''')
        else if (sizeField.initializationValue === null)
            throw new IllegalArgumentException('''Structure «qualifiedName(structure)» does ''' +
                '''not represent an Avro Fixed type: Size field «sizeField.name» has no ''' +
                "initialization value")
        else if (sizeField.initializationValue.asInteger === null ||
            sizeField.initializationValue.asInteger <= 0)
            throw new IllegalArgumentException('''Structure «qualifiedName(structure)» does ''' +
                "not represent an Avro Fixed type: Initialization value " +
                '''«sizeField.initializationValue.valueAsString» of size field ''' +
                '''«sizeField.name» is not a valid positive Integer value''')

        val mappingAndAvroImport = structure.createDefaultComplexTypeMapping()
        val complexTypeMapping = mappingAndAvroImport.key
        val avroImport = mappingAndAvroImport.value
        startedEObjectCreation(TechnologyMapping, complexTypeMapping)
        complexTypeMapping.addAspect(avroImport, FIXED_ASPECT)
        complexTypeMapping.addAspect(sizeField, avroImport, FIXED_SIZE_ASPECT)
        finishedEObjectCreation(TechnologyMapping, complexTypeMapping)
    }

    /**
     * Add an aspect with the specified name from the given technology Import and for the given data
     * field to the passed ComplexTypeMapping
     */
    private def void addAspect(ComplexTypeMapping mapping, DataField field, Import technologyImport,
        String aspectName) {
        val fieldMapping = MAPPING_FACTORY.createTechnologySpecificFieldMapping
        fieldMapping.technology = technologyImport
        fieldMapping.dataField = field
        fieldMapping.aspects.add(createImportedAspect(technologyImport, aspectName))
        mapping.fieldMappings.add(fieldMapping)
    }

    /**
     * Adapt a LEMMA DataStructure to represent an Avro Map type. Avro Map types are represented
     * in LEMMA by means of structures with a single data field for storing the map's values. The
     * structure is then adapted to comprise a second field called "key" of type String for the
     * map's keys. The structure receives the AvroMap aspect. The key and value field are augmented
     * with the AvroMapKey and AvroMapValue aspect, respectively.
     */
    private def void adaptToAvroMap(DataStructure structure) {
        // An Avro Map is an unnamed schema type. Consequently, the name might be duplicate, if no
        // lemmName property existed in the source schema
        structure.name = qualifiedName(structure).toUniqueName(DataModel)
        val fieldCount = structure.dataFields.size
        if (fieldCount != 1)
            throw new IllegalArgumentException('''Structure «qualifiedName(structure)» does ''' +
                "not represent an Avro Map: Invalid field count (expected: 1, found: " +
                '''«fieldCount»)''')

        val mappingAndAvroImport = structure.createDefaultComplexTypeMapping()
        val complexTypeMapping = mappingAndAvroImport.key
        val avroImport = mappingAndAvroImport.value
        startedEObjectCreation(TechnologyMapping, complexTypeMapping)
        complexTypeMapping.addAspect(avroImport, MAP_ASPECT)

        val valueField = structure.dataFields.get(0)
        complexTypeMapping.addAspect(valueField, avroImport, MAP_VALUE_ASPECT)

        val keyFieldCount = structure.dataFields.filter[it.name.startsWith("key")].size
        val keyFieldName = '''key«IF keyFieldCount > 0»«keyFieldCount + 1»«ENDIF»'''
        val keyField = toDataField(keyFieldName, Schema.create(Schema.Type.STRING), null, structure)
        structure.dataFields.add(keyField)
        complexTypeMapping.addAspect(keyField, avroImport, MAP_KEY_ASPECT)
        finishedEObjectCreation(TechnologyMapping, complexTypeMapping)
    }

    /**
     * Derive a unique name based on the given qualified name and in the context of the given LEMMA
     * model type. If the given qualified name is not unique already, the derived unique name will
     * be prefixed by an index starting at 1 and being incremented for each existing name.
     */
    private def String toUniqueName(String qualifiedName, Class<? extends EObject> modelType) {
        var uniqueQualifiedName = qualifiedName
        val nameParts = splitNameParts(uniqueQualifiedName)
        var uniqueName = nameParts.value
        if (!eObjectNames.containsKey(modelType) ||
            !eObjectNames.get(modelType).contains(uniqueQualifiedName))
            return uniqueName

        var uniqueIndex = 0
        while(eObjectNames.get(modelType).contains(uniqueQualifiedName)) {
            uniqueIndex += 1
            uniqueQualifiedName = uniqueQualifiedName + uniqueIndex
            uniqueName = uniqueName + uniqueIndex
        }

        return uniqueName
    }

    /**
     * Adapt a LEMMA DataStructure to represent an Avro Union. Avro Unions are represented in LEMMA
     * by means of structures with the AvroUnion aspect.
     */
    private def void adaptToAvroUnion(DataStructure structure) {
        // unnamed schema type so name might be duplicate if no LEMMA name existed
        structure.name = qualifiedName(structure).toUniqueName(DataModel)
        val mappingAndAvroImport = structure.createDefaultComplexTypeMapping()
        val complexTypeMapping = mappingAndAvroImport.key
        val avroImport = mappingAndAvroImport.value
        startedEObjectCreation(TechnologyMapping, complexTypeMapping)
        complexTypeMapping.addAspect(avroImport, UNION_ASPECT)
        finishedEObjectCreation(TechnologyMapping, complexTypeMapping)
    }
}