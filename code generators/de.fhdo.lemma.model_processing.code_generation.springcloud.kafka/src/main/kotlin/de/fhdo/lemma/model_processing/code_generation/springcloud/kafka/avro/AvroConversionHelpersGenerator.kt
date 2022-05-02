package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addThrownException
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.booleanAspectPropertyValueOrFalse
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.forKafkaTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.isAvroProtocolFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.methodExists
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File

private const val GENERIC_RECORD_BUILDER_BASE_NAME = "getGenericRecordBuilderFor"

internal object AvroConversionHelpersGenerator {
    private lateinit var domainPackage: String
    private lateinit var schemaCompiler: AvroSchemaCompiler
    private lateinit var convertersGenerator: AvroConvertersGenerator
    private val structuresRequiringGenericRecordBuilders = mutableListOf<IntermediateDataStructure>()

    var initialized: Boolean = false
        private set

    fun initialize(
        domainPackage: String,
        microservice: IntermediateMicroservice,
        microservicePackage: String,
        microserviceJavaPath: String,
        microserviceResourcePath: String
    ) {
        this.domainPackage = domainPackage
        schemaCompiler = AvroSchemaCompiler(
            microservice.determineBasePackage(microservicePackage),
            microserviceJavaPath,
            microserviceResourcePath
        )
        convertersGenerator = AvroConvertersGenerator(domainPackage)
        initialized = true
    }

    private fun IntermediateMicroservice.determineBasePackage(basePackageCandidate: String)
        = if (basePackageCandidate == qualifiedName)
                basePackageCandidate.substringBeforeLast(".")
            else
                basePackageCandidate

    fun reset() {
        ensureInitialized()
        initialized = false
        AvroConversionTypeManager.reset()
    }

    fun registerJavaTypeGeneratedFromComplexType(complexType: IntermediateComplexType,
        generatedType: TypeDeclaration<*>) {
        ensureInitialized()
        AvroConversionTypeManager.registerJavaTypeGeneratedFromModel(complexType, generatedType)
    }

    fun registerStructureForGenericRecordBuilderGeneration(structure: IntermediateDataStructure) {
        ensureInitialized()
        structuresRequiringGenericRecordBuilders.add(structure)
    }

    fun compileSchema(structure: IntermediateDataStructure) {
        ensureInitialized()
        val avroSchemaAspect = structure.getAspect("AvroSchema".forKafkaTechnology())!!
        // TODO: Maybe we don't need the returned File object at all.
        val avroCompiledJavaTypes = schemaCompiler.compileConfiguredSchema(structure, avroSchemaAspect)
            .map { (_, compilationUnit) -> compilationUnit.primaryType.get() }
        AvroConversionTypeManager.registerJavaTypesCompiledFromSchemaOfRootStructure(structure, avroCompiledJavaTypes)
    }

    fun generateConversionHelpers() {
        ensureInitialized()

        val genericRecordBuildersTodoIndices = structuresRequiringGenericRecordBuilders.indices.toMutableSet()
        AvroConversionTypeManager.getRootTypesOfCompiledSchemas()
            .forEach { (structure, generatedClass) ->
                val structureRecordBuilderIndex = structuresRequiringGenericRecordBuilders.indexOf(structure)
                if (structureRecordBuilderIndex > -1) {
                    generatedGenericRecordBuilder(structure)
                    genericRecordBuildersTodoIndices.remove(structureRecordBuilderIndex)
                }

                convertersGenerator.generateConverters(structure)
            }

        // Place GenericRecordBuilders for structures that do not configure an Avro schema at the end of the helpers
        // class
        genericRecordBuildersTodoIndices.forEach {
            val structure = structuresRequiringGenericRecordBuilders[it]
            generatedGenericRecordBuilder(structure)
        }
    }

    private fun ensureInitialized() = require(initialized) {
        throw IllegalStateException("${javaClass.simpleName} has not been initialized")
    }

    private fun generatedGenericRecordBuilder(structure: IntermediateDataStructure) {
        val avroSchemaAspect = structure.getAspect("AvroSchema".forKafkaTechnology())!!
        val schemaFile = avroSchemaAspect.getPropertyValue("file")!!
        val schemaFileBaseName = File(schemaFile).nameWithoutExtension
        val methodName = GENERIC_RECORD_BUILDER_BASE_NAME + schemaFileBaseName.capitalize()
        val helpersClass = AvroConversionTypeManager.getOrCreateHelpersClass(domainPackage, structure)
        if (helpersClass.methodExists(methodName))
            return

        // Note: We don't make the method static to enable its overriding
        val method = helpersClass.addMethod(methodName, Modifier.Keyword.PUBLIC)
        method.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        method.setType("GenericRecordBuilder")
        method.addRelocatableImport("org.apache.avro.generic.GenericRecordBuilder",
            ImportTargetElementType.METHOD)
        method.addThrownException("IOException")
        method.addRelocatableImport("java.io.IOException", ImportTargetElementType.METHOD)

        val fileFromResources = structure.booleanAspectPropertyValueOrFalse("AvroSchema".forKafkaTechnology(),
            "fromResources")
        method.addBuilderBoilerplate(schemaFile, fileFromResources, avroSchemaAspect.getPropertyValue("type"))
    }

    private fun MethodDeclaration.addBuilderBoilerplate(schemaFile: String, fileFromResources: Boolean,
        typeName: String?) {
        schemaFile.ensureTypeNameIfAvroProtocolFile(typeName)

        // Prepare statement for schema file reading
        addRelocatableImport("java.io.InputStream")
        val getFileAsInputStreamStatement = if (fileFromResources) {
                addRelocatableImport("java.lang.invoke.MethodHandles")
                "InputStream schemaStream = MethodHandles.lookup().lookupClass().getClassLoader()" +
                    """.getResourceAsStream("$schemaFile");"""
            } else {
                addRelocatableImport("java.io.FileInputStream")
                """InputStream schemaStream = new FileInputStream("$schemaFile");"""
            }

        // Prepare statement for schema file parsing
        val parseStatement = if (schemaFile.isAvroProtocolFile()) {
                addRelocatableImport("org.apache.avro.Protocol")
                "Protocol protocol = Protocol.parse(schemaStream);"
            } else {
                addRelocatableImport("org.apache.avro.Schema")
                "Schema schema = new Schema.Parser().parse(schemaStream);"
            }

        // Prepare statement for GenericRecordBuilder creation and return
        val builderReturnStatement = if (schemaFile.isAvroProtocolFile())
                """return new GenericRecordBuilder(protocol.getType("$typeName"));"""
            else
                """return new GenericRecordBuilder(schema);"""

        // Add statements to converter method
        addStatements("""
                |$getFileAsInputStreamStatement
                |$parseStatement
                |$builderReturnStatement
            """.trimMargin())
    }

    fun getGeneratedNodesAndReset() : Set<GenletGeneratedNode> {
        ensureInitialized()
        val generatedNodes = AvroConversionTypeManager.getGeneratedNodes()
        reset()
        return generatedNodes
    }
}

internal fun String.ensureTypeNameIfAvroProtocolFile(typeName: String?) {
    require(!isAvroProtocolFile() || typeName != null) {
        """Schema file "$this" defines Avro protocol but no Avro type name was specified"""
    }
}

internal fun IntermediateDataStructure.configuresAvroSchema() = getAspect("AvroSchema".forKafkaTechnology()) != null