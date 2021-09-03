package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.addStatements
import de.fhdo.lemma.java.ast.utils.addThrownException
import de.fhdo.lemma.java.ast.utils.appendStatement
import de.fhdo.lemma.java.ast.utils.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.booleanAspectPropertyValueOrFalse
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getterName
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.isAvroProtocolFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.javaType
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.methodExists
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.setterName
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.visibleFieldsAndTypes
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Singleton that stores information about Avro converters. Avro converters are utility methods within the
 * "AvroConverters" class that may aid in the construction of GenericRecord instances from Java objects (serialization)
 * and the retrieval of Java objects from GenericRecords (deserialization).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object AvroConverters {
    private const val PARENT_PACKAGE_NAME = "avro"
    private const val CLASSNAME = "AvroConverters"
    private const val TO_RECORD_CONVERTER_NAME = "getRecordBuilder"
    private const val FROM_RECORD_CONVERTER_NAME_TEMPLATE = "get{STRUCTURE_NAME}ObjectFromRecord"
    private val relativeFilepath = "$PARENT_PACKAGE_NAME${File.separator}$CLASSNAME"

    private var packageName: String? = null
    private var genletHeap: MutableMap<String, Any?>? = null
    private var avroConverters: ClassOrInterfaceDeclaration? = null
    var initialized: Boolean = false
        private set

    /**
     * Initialize the Singleton
     */
    fun initialize(currentDomainPackage: String, genletHeap: MutableMap<String, Any?>) {
        packageName = "$currentDomainPackage.$PARENT_PACKAGE_NAME"
        AvroConverters.genletHeap = genletHeap
        val fullyQualifiedName = "$packageName.$CLASSNAME"

        // Create or get the AvroConverters class from the Genlet's heap. By means of the heap, the instance can be
        // preserved, even if subsequent Genlets get called for an AST node.
        if (fullyQualifiedName in genletHeap)
            avroConverters = genletHeap[fullyQualifiedName] as ClassOrInterfaceDeclaration
        else {
            avroConverters = newJavaClassOrInterface(packageName!!, CLASSNAME)
            genletHeap[fullyQualifiedName] = avroConverters
        }
        initialized = true
    }

    /**
     * Reset the Singleton
     */
    fun reset() {
        packageName = null
        genletHeap = null
        avroConverters = null
        initialized = false
    }

    /**
     * Add Avro converters for serialization and deserialization to AvroConverters class
     */
    fun addConverters(structure: IntermediateDataStructure) {
        val avroSchemaAspect = structure.getAspect("Kafka.AvroSchema") ?: return
        addStructureToAvroConverter(structure, avroSchemaAspect)
        addAvroToStructureConverter(structure)
    }

    /**
     * Add Avro converter for the retrieval of a GenericRecordBuilder instance for a certain structure. The
     * GenericRecordBuilder may then be used to construct GenericRecords from Java objects of the type of the given
     * structure (serialization).
     */
    private fun addStructureToAvroConverter(structure: IntermediateDataStructure,
        avroSchemaAspect: IntermediateImportedAspect) {
        val (javaType, typeImports) = structure.javaType()
        if (avroConverters!!.methodExists(TO_RECORD_CONVERTER_NAME, listOf(javaType)))
            return

        val schemaFile = avroSchemaAspect.getPropertyValue("file")!!
        val fileFromResources = structure.booleanAspectPropertyValueOrFalse("Kafka.AvroSchema", "fromResources")
        val avroTypeName = avroSchemaAspect.getPropertyValue("type")

        /* Create converter method */
        val converterMethod = avroConverters!!.addMethod(
            TO_RECORD_CONVERTER_NAME, Modifier.Keyword.PUBLIC,
            Modifier.Keyword.STATIC)
        converterMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        converterMethod.setType("GenericRecordBuilder")
        converterMethod.addRelocatableImport("org.apache.avro.generic.GenericRecordBuilder",
            ImportTargetElementType.METHOD)
        converterMethod.addThrownException("IOException")
        converterMethod.addRelocatableImport("java.io.IOException", ImportTargetElementType.METHOD)

        /* Create structure parameter */
        val parameterName = javaType.asString().decapitalize()
        converterMethod.addParameter(javaType, parameterName)
        typeImports.forEach { converterMethod.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        /* Create method body */
        converterMethod.addBuilderBoilerplate(schemaFile, fileFromResources, avroTypeName)
        converterMethod.addBuilderSetters(structure, parameterName)
        converterMethod.addStatements("return builder;")

        /* Create Avro converters for nested data structures recursively */
        createNestedStructureToAvroConverters(structure)
    }

    /**
     * Add boilerplate code to an Avro converter for serialization
     */
    private fun MethodDeclaration.addBuilderBoilerplate(schemaFile: String, fileFromResources: Boolean,
        avroTypeName: String?) {
        // For Avro protocols, a certain schema type from the protocol specification must be given
        if (schemaFile.isAvroProtocolFile() && avroTypeName == null)
            throw IllegalArgumentException("Schema file comprises an Avro protocol, but no Avro type name was given")

        // Prepare statement for schema file reading
        addRelocatableImport("java.io.InputStream")
        addRelocatableImport("java.lang.invoke.MethodHandles")
        val getFileAsInputStreamStatement = if (fileFromResources)
                "InputStream schemaStream = MethodHandles.lookup().lookupClass().getClassLoader()" +
                    """.getResourceAsStream("$schemaFile");"""
            else {
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

        // Prepare statement for GenericRecordBuilder creation
        val builderStatement = if (schemaFile.isAvroProtocolFile())
                """GenericRecordBuilder builder = new GenericRecordBuilder(protocol.getType("$avroTypeName"));"""
            else
                """GenericRecordBuilder builder = new GenericRecordBuilder(schema);"""

        // Add statements to converter method
        addStatements("""
            |$getFileAsInputStreamStatement
            |$parseStatement
            |$builderStatement
        """.trimMargin())
    }

    /**
     * Add setter statements to Avro converter for serialization
     */
    private fun MethodDeclaration.addBuilderSetters(structure: IntermediateDataStructure, parameterName: String) {
        // Prepare setter statements. All visible fields of the given data structure, whose type is an enumeration or a
        // primitive type, receive setters on the GenericRecordBuilder instance.
        // TODO Support complex types
        val setterStatements = structure.visibleFieldsAndTypes()
            .filter { (_, type) -> type is IntermediateEnumeration || type is IntermediatePrimitiveType}
            .joinToString(".") { (field, _) ->
                val fieldName = field.name
                val getterName = fieldName.getterName()
                """set("$fieldName", $parameterName.$getterName())"""
            }

        // Add the setter statements. GenericRecordBuilder uses a fluent API for continuous setter invocation.
        if (setterStatements.isNotEmpty())
            addStatements("builder.$setterStatements;")
    }

    /**
     * Create serializing Avro converters for nested data structures used for typing data fields within the given
     * [structure]
     */
    private fun createNestedStructureToAvroConverters(structure: IntermediateDataStructure) {
        // Only target visible fields with a structure type and the AvroSchema aspect
        val nestedAvroStructures = structure.visibleFieldsAndTypes()
            .filter { (field, type) -> type is IntermediateDataStructure && field.hasAspect("Kafka.AvroSchema") }
            .map { (_, type) -> type as IntermediateDataStructure to type.getAspect("Kafka.AvroSchema")!! }.toMap()

        nestedAvroStructures.forEach { (structure, avroSchemaAspect) ->
            addStructureToAvroConverter(structure, avroSchemaAspect)
        }
    }

    /**
     * Add Avro converter for deserialization, i.e., the retrieval of a Java object from an Avro GenericData.Record
     * (deserialization)
     */
    private fun addAvroToStructureConverter(structure: IntermediateDataStructure) {
        val converterName = FROM_RECORD_CONVERTER_NAME_TEMPLATE.replace("{STRUCTURE_NAME}", structure.name)
        val parameterType = StaticJavaParser.parseClassOrInterfaceType("GenericData.Record")
        if (avroConverters!!.methodExists(converterName, listOf(parameterType)))
            return

        /* Create converter method */
        val converterMethod = avroConverters!!.addMethod(converterName, Modifier.Keyword.PUBLIC,
            Modifier.Keyword.STATIC)
        converterMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        val (javaType, typeImports) = structure.javaType()
        converterMethod.type = javaType
        typeImports.forEach { converterMethod.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        /* Create Record parameter */
        val javaTypeName = javaType.asString()
        val variableName = javaTypeName.decapitalize()
        val parameterName = "${variableName}Record"
        converterMethod.addParameter(parameterType, parameterName)
        converterMethod.addRelocatableImport("org.apache.avro.generic.GenericData", ImportTargetElementType.METHOD)

        /* Create method body */
        converterMethod.addStatements("""$javaTypeName $variableName = new $javaTypeName();""")
        converterMethod.addStructureSetters(structure, variableName, parameterName)
        converterMethod.addStatements("return $variableName;")

        /* Create Avro converters for nested data structures recursively */
        createNestedAvroToStructureConverters(structure)
    }

    /**
     * Add setter statements to Avro converter for deserialization
     */
    private fun MethodDeclaration.addStructureSetters(structure: IntermediateDataStructure, variableName: String,
        parameterName: String) {
        val visibleMutableFieldsAndTypes = structure.visibleFieldsAndTypes(true)

        // Prepare setter statements. All visible mutable fields of the given data structure, whose type is an
        // enumeration or a primitive type, receive setters on the structure's Java class instance.
        // TODO Support complex types
        var neverEmptyFieldFound = false
        val setterStatements = visibleMutableFieldsAndTypes
            .filter { (_, type) -> type is IntermediateEnumeration || type is IntermediatePrimitiveType }
            .joinToString("\n") { (dataField, type) ->
                val (statement, imports) = getStructureSetStatement(variableName, dataField.name, type, parameterName)
                imports.forEach { this.addRelocatableImport(it) }
                neverEmptyFieldFound = neverEmptyFieldFound || dataField.hasFeature("NEVER_EMPTY")
                statement
            }

        if (setterStatements.isEmpty())
            return

        // Prepare catch statement for AvroRuntimeException
        val catchStatement = if (neverEmptyFieldFound)
            //Setter methods for never-empty data fields comprise a guard that throws an IllegalArgumentException when
            // the passed value to be set is null
            "catch (AvroRuntimeException | IllegalArgumentException ex) {}"
        else
            "catch (AvroRuntimeException ex) {}"

        // Add prepared statements to method body
        appendStatement("""
                |try {
                |   $setterStatements
                |} $catchStatement
            """.trimMargin())
        addRelocatableImport("org.apache.avro.AvroRuntimeException")
    }

    /**
     * Get statement for setting a value on the given [variableName] for the given [fieldName]. A cast statement will
     * be inserted, if required.
     */
    private fun getStructureSetStatement(variableName: String, fieldName: String, resolvedFieldType: IntermediateType,
        parameterName: String) : Pair<String, Set<String>> {
        val (javaType, typeImports) = resolvedFieldType.javaType()
        val castStatement = if (javaType !is ClassOrInterfaceType || javaType.nameAsString != "Object")
                "($javaType) "
            else
                ""
        val setterName = fieldName.setterName()
        return """$variableName.$setterName($castStatement$parameterName.get("$fieldName"));""" to typeImports
    }

    /**
     * Create deserializing Avro converters for nested data structures used for typing data fields within the given
     * [structure]
     */
    private fun createNestedAvroToStructureConverters(structure: IntermediateDataStructure) {
        // Only target visible fields with a structure type and the AvroSchema aspect
        structure.visibleFieldsAndTypes(true).forEach { (_, type) ->
            if (type is IntermediateDataStructure)
                addAvroToStructureConverter(type)
        }
    }

    /**
     * Return the AvroConverters class as a [GenletGeneratedNode]
     */
    fun getGeneratedNodes() : Set<GenletGeneratedNode> {
        if (avroConverters == null || avroConverters!!.members.isEmpty())
            return emptySet()

        val generatedNodes = mutableSetOf<GenletGeneratedNode>()
        generatedNodes.add(GenletGeneratedNode(
            GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH,
            "$relativeFilepath.java",
            avroConverters!!))

        return generatedNodes
    }
}