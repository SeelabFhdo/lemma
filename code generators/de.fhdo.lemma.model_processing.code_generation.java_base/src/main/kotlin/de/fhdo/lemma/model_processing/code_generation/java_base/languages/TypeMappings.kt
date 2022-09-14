package de.fhdo.lemma.model_processing.code_generation.java_base.languages

import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.nodeTypes.NodeWithType
import de.fhdo.lemma.data.DateUtils
import de.fhdo.lemma.data.PrimitiveTypeConstants
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import java.lang.IllegalArgumentException
import java.time.format.DateTimeFormatter

/**
 * Collection of mappings of LEMMA's built-in or Java-specific primitive types to Java types.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val primitiveTypeMappings = primitiveTypeMappings {
    /* Mapping of LEMMA's built-in primitive types */
    builtin {
        PrimitiveTypeConstants.BOOLEAN.literal mapsTo "boolean"
        PrimitiveTypeConstants.BYTE.literal mapsTo "byte"
        PrimitiveTypeConstants.CHARACTER.literal mapsTo "char"
        PrimitiveTypeConstants.DATE.literal mapsTo "Date" withImport "java.util.Date"
        PrimitiveTypeConstants.DOUBLE.literal mapsTo "double"
        PrimitiveTypeConstants.FLOAT.literal mapsTo "float"
        PrimitiveTypeConstants.INTEGER.literal mapsTo "int"
        PrimitiveTypeConstants.LONG.literal mapsTo "long"
        PrimitiveTypeConstants.SHORT.literal mapsTo "short"
        PrimitiveTypeConstants.STRING.literal mapsTo "String"
    }

    /*
     * Mapping of Java-specific types, e.g., Java's object wrappers for its built-in primitive types or types from
     * Java's standard library such as BigDecimal and Currency
     */
    technology {
        "Boolean".mapsToSelf()
        "BigDecimal" withImport "java.math.BigDecimal"
        "Byte".mapsToSelf()
        "Character".mapsToSelf()
        "Currency" withImport "java.util.Currency"
        "Date".mapsToSelf() withImport "java.util.Date"
        "Double".mapsToSelf()
        "Float".mapsToSelf()
        "Integer".mapsToSelf()
        "Long".mapsToSelf()
        "Object".mapsToSelf()
        "Short".mapsToSelf()
        "String".mapsToSelf()
        "UUID" withImport "java.util.UUID"
    }
}

/**
 * Convenience function to get a [TypeMappingDescription] from an [IntermediateType] instance reflecting a primitive or
 * complex type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateType.getTypeMapping() : TypeMappingDescription? {
    return when(this) {
        is IntermediatePrimitiveType -> primitiveTypeMappings[this]
        is IntermediateImportedTechnologySpecificType -> primitiveTypeMappings[this]
        is IntermediateComplexType -> TypeMappingDescription(classname, classname, true)
        else -> throw PhaseException("Cannot derive Java type for unknown type kind ${this::class.java.name}")
    }
}

/**
 * Convenience function to get the Java object type mapping for a built-in [IntermediatePrimitiveType]. For instance,
 * the Java object type for the built-in primitive type "boolean" is "java.lang.Boolean".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediatePrimitiveType.getObjectWrapperMapping() : TypeMappingDescription {
    require(origin == IntermediateTypeOrigin.BUILTIN) { "A Java object type mapping may only be derived for built-in " +
        "primitive types" }

    return when (name) {
        PrimitiveTypeConstants.BOOLEAN.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Boolean")!!
        PrimitiveTypeConstants.BYTE.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Byte")!!
        PrimitiveTypeConstants.CHARACTER.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Character")!!
        PrimitiveTypeConstants.DATE.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Date")!!
        PrimitiveTypeConstants.DOUBLE.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Double")!!
        PrimitiveTypeConstants.FLOAT.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Float")!!
        PrimitiveTypeConstants.INTEGER.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Integer")!!
        PrimitiveTypeConstants.LONG.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Long")!!
        PrimitiveTypeConstants.SHORT.literal -> primitiveTypeMappings.getTechnologySpecificMapping("Short")!!
        PrimitiveTypeConstants.STRING.literal -> primitiveTypeMappings.getTechnologySpecificMapping("String")!!

        else -> throw PhaseException("Cannot derive Java object type mapping for unknown built-in primitive type " +
            "kind ${this::class.java.name}")
    }
}

/**
 * Description of a type mapping, i.e., the name of an original type is mapped to the name of another type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class TypeMappingDescription(val originalTypeName: String, var mappedTypeName: String,
    val isComplexTypeMapping: Boolean) {
    private val imports = mutableSetOf<String>()
    private val dependencies = mutableSetOf<DependencyDescription>()

    /**
     * Add an import to the type mapping, e.g., when the mapped type originates from a special package or framework
     */
    fun addImport(import: String) {
        imports.add(import)
    }

    /**
     * Get the imports hold by this type mapping description
     */
    fun getImports() = imports.toSet()

    /**
     * Add a dependency to the type mapping, e.g., when the mapped type originates from a framework
     */
    fun addDependency(dependency: String) {
        dependencies.add(DependencyDescription.fromString(dependency))
    }

    /**
     * First component to enable destructuring declarations in the context of type mappings. This component reflects the
     * name of the mapped type.
     */
    operator fun component1() = mappedTypeName

    /**
     * Second component to enable destructuring declarations in the context of type mappings. This component reflects
     * the flag tha indicates whether this type mapping is for a complex type.
     */
    operator fun component2() = isComplexTypeMapping

    /**
     * Third component to enable destructuring declarations in the context of type mappings. This component reflects
     * the [Set] of imports needed for the type mapping.
     */
    operator fun component3() = imports.toSet()

    /**
     * Fourth component to enable destructuring declarations in the context of type mappings. This component reflects
     * the [Set] of dependencies needed for the type mapping.
     */
    operator fun component4() = dependencies.toSet()
}

/**
 * Convenience builder for creating and collecting primitive [TypeMappingDescription] instances of a certain kind, i.e.,
 * built-in or technology-specific (cf. [PrimitiveTypeMappingsRegistry]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class PrimitiveTypeMappingsBuilder(private val targetMap: MutableMap<String, TypeMappingDescription>) {
    /**
     * Specify a mapping for a string that represents the name of the original type to the given [typeName] of the
     * mapped type
     */
    infix fun String.mapsTo(typeName: String) = addToMap(this, typeName)

    /**
     * Helper function to create a [Pair] of original type name and [TypeMappingDescription] instance, and add it to the
     * collection of primitive type mappings managed by this [PrimitiveTypeMappingsBuilder].
     */
    private fun addToMap(originalTypeName: String, mappedTypeName: String) : Pair<String, TypeMappingDescription> {
        val typeMappingDescription = TypeMappingDescription(originalTypeName, mappedTypeName, false)
        targetMap[originalTypeName] = typeMappingDescription
        return originalTypeName to typeMappingDescription
    }

    /**
     * Map the name of a type to itself. This is useful when the original type has the same name in the target
     * technology, e.g., Boolean or String.
     */
    fun String.mapsToSelf() = addToMap(this, this)

    /**
     * Assign an import to a [Pair] of original type name and [TypeMappingDescription]
     */
    infix fun Pair<String, TypeMappingDescription>.withImport(import: String) : Pair<String, TypeMappingDescription> {
        this.second.addImport(import)
        targetMap[this.first] = this.second
        return this
    }

    /**
     * Assign an additional import to a [Pair] of original type name and [TypeMappingDescription]
     */
    infix fun Pair<String, TypeMappingDescription>.andImport(import: String) = withImport(import)

    /**
     * Assign an import to a type that has is mapped to itself
     */
    infix fun String.withImport(import: String) = this.mapsToSelf() withImport import

    /**
     * Assign a dependency to a [Pair] of original type name and [TypeMappingDescription]
     */
    infix fun Pair<String, TypeMappingDescription>.withDependency(dependency: String)
        : Pair<String, TypeMappingDescription> {
        this.second.addDependency(dependency)
        targetMap[this.first] = this.second
        return this
    }

    /**
     * Assign an additional dependency to a [Pair] of original type name and [TypeMappingDescription]
     */
    infix fun Pair<String, TypeMappingDescription>.andDependency(dependency: String) = withDependency(dependency)

    /**
     * Assign a dependency to a type that has is mapped to itself
     */
    infix fun String.withDependency(dependency: String) = this.mapsToSelf() withDependency dependency
}

/**
 * Convenience builder function for creating and collecting built-in and technology-specific primitive
 * [TypeMappingDescription] instances within a [PrimitiveTypeMappingsRegistry].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun primitiveTypeMappings(initializer: PrimitiveTypeMappingsRegistry.() -> Unit)
    = PrimitiveTypeMappingsRegistry().apply(initializer)

/**
 * Registry for collecting built-in and technology-specific primitive [TypeMappingDescription] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class PrimitiveTypeMappingsRegistry(private val builtin: MutableMap<String, TypeMappingDescription> = mutableMapOf(),
    private val technology: MutableMap<String, TypeMappingDescription> = mutableMapOf()) {

    /**
     * Builder function, which returns a [PrimitiveTypeMappingsBuilder] to collect built-in primitive
     * [TypeMappingDescription] instances.
     */
    fun builtin(builder: PrimitiveTypeMappingsBuilder.() -> Unit) : PrimitiveTypeMappingsBuilder {
        return PrimitiveTypeMappingsBuilder(builtin).apply(builder)
    }

    /**
     * Builder function, which returns a [PrimitiveTypeMappingsBuilder] to collect technology-specific primitive
     * [TypeMappingDescription] instances.
     */
    fun technology(builder: PrimitiveTypeMappingsBuilder.() -> Unit) : PrimitiveTypeMappingsBuilder {
        return PrimitiveTypeMappingsBuilder(technology).apply(builder)
    }

    /**
     * Get a registered built-in or technology-specific type mapping for an [IntermediateType]
     */
    operator fun get(type: IntermediateType) : TypeMappingDescription? {
        return when(type.origin) {
            IntermediateTypeOrigin.BUILTIN -> builtin[type.name]
            IntermediateTypeOrigin.TECHNOLOGY -> technology[type.name]
            else -> null
        }
    }

    /**
     * Get a registered technology-specific type mapping for an [IntermediateType]
     */
    fun getTechnologySpecificMapping(typeName: String) = technology[typeName]
}

/**
 * Create a String for the given [value] dependent on this [IntermediateType] instance. For instance, if this
 * [IntermediateType] represents a Character and the given value is "c", the result will be the String "'c'". If this
 * [IntermediateType] represents a Float and the given value is "1.23", the result will be the String "1.23F".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateType.createTypeSpecificValueString(value: String) : Pair<String, Set<String>> {
    var valueString = ""
    val additionalImports = mutableSetOf<String>()

    val isACharacter = isA(PrimitiveTypeConstants.CHARACTER.literal) || isA("Character")
    val isAString = isA(PrimitiveTypeConstants.STRING.literal) || isA("String")
    when {
        isACharacter -> valueString += "'"
        isAString -> valueString += '"'
    }

    val isADate = isA(PrimitiveTypeConstants.DATE.literal) || isA("Date")
    if (!isADate)
        valueString += value
    else {
        val (dateValueString, dateImports) = deriveValueForDate(value)
        valueString += dateValueString
        additionalImports.addAll(dateImports)
    }

    when {
        isACharacter -> valueString += "'"
        isA(PrimitiveTypeConstants.FLOAT.literal) || isA("Float") -> valueString += "F"
        isA(PrimitiveTypeConstants.LONG.literal) || isA("Long") -> valueString += "L"
        isAString -> valueString += '"'
    }

    return valueString to additionalImports
}

/**
 * Convenience function to determine if an [IntermediateType] is of a given built-in or technology-specific, i.e., Java
 * object wrapper, type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateType.isA(typeName: String) = primitiveTypeMappings[this]?.mappedTypeName == typeName

/**
 * Derive a Java code string that creates a Date object from the given [dateString].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun deriveValueForDate(dateString: String) : Pair<String, Set<String>> {
    val format = DateUtils.determineDateFormat(dateString)
    require(format != null) { "Cannot derive value for date string $dateString. Unsupported date format." }

    return when (format) {
        DateTimeFormatter.ISO_LOCAL_DATE -> {
            """
                Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_LOCAL_DATE)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDate",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_OFFSET_DATE -> {
            """ 
                Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_OFFSET_DATE)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDate",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_DATE -> {
            """ 
                Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_DATE)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDate",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_LOCAL_TIME -> {
            """ 
                Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_LOCAL_TIME)
                    .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalTime",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_OFFSET_TIME -> {
            """ 
                Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_OFFSET_TIME)
                    .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalTime",
                "java.time.ZoneId"
            )
        }
        DateTimeFormatter.ISO_TIME -> {
            """ 
                Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_TIME)
                    .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalTime",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_LOCAL_DATE_TIME -> {
            """ 
                Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    .atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDateTime",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_OFFSET_DATE_TIME -> {
            """ 
                Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    .atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDateTime",
                "java.time.ZoneId"
            )
        }

        DateTimeFormatter.ISO_DATE_TIME -> {
            """ 
                Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_DATE_TIME)
                    .atZone(ZoneId.systemDefault()).toInstant()
            """.trimToSingleLine() to setOf(
                "java.time.format.DateTimeFormatter",
                "java.time.LocalDateTime",
                "java.time.ZoneId"
            )
        }

        else -> throw IllegalArgumentException("Cannot derive value string for date string $dateString")
    }
}

/**
 * Convenience function to determine if an [IntermediateType] is nullable, which is the case when the type is not
 * a primitive Java type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateType.isNullable
    get() = when(this) {
        is IntermediatePrimitiveType -> this.isA("String") || this.isA("Date")
        is IntermediateImportedTechnologySpecificType -> true
        is IntermediateComplexType -> true
        else -> false
    }

/**
 * Helper to set the Java type for this [NodeWithType] from the intermediate [type]. Type-specific imports will be added
 * to the [importsTargetNode] leveraging the [addImportToTargetNode] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <P: Node> NodeWithType<*, *>.setJavaTypeFrom(type: IntermediateType, importsTargetNode: P,
    addImportToTargetNode: P.(String) -> Unit) : TypeMappingDescription? {
    val typeMapping = type.getTypeMapping()
    if (typeMapping == null) {
        (this as Node).setTypeExpectedFromGenlet(type.name)
        return null
    }

    val (mappedType, complexTypeMapping, imports, dependencies) = typeMapping
    setType(mappedType)
    imports.forEach { addImportToTargetNode(importsTargetNode, it) }
    importsTargetNode.addDependencies(dependencies)

    if (complexTypeMapping) {
        val currentDomainPackage: String by DomainState
        val fullyQualifiedClassname = (type as IntermediateComplexType).fullyQualifiedClassname
        val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
        addImportToTargetNode(importsTargetNode, complexTypeFullyQualifiedName)
    }

    return typeMapping
}

/**
 * Determine that the [expectedTypeName] of this [NodeWithType] is to be set by a Genlet.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun  Node.setTypeExpectedFromGenlet(expectedTypeName: String) {
    (this as NodeWithType<*, *>).setType("${expectedTypeName}_ExpectedFromGenlet")
    setExpectedGenletTypeInformation(expectedTypeName)
}

/**
 * Data key for types expected from a Genlet.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object TypeExpectedFromGenletDataKey : DataKey<String>()

/**
 * Set information about the type expected from a Genlet for this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.setExpectedGenletTypeInformation(expectedTypeName: String) {
    if (!containsData(TypeExpectedFromGenletDataKey))
        setData(TypeExpectedFromGenletDataKey, expectedTypeName)
}

/**
 * Returns true if the type of this [Node] is expected to be set by a Genlet.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithType<*, *>.isTypeExpectedFromGenlet() = (this as Node).containsData(TypeExpectedFromGenletDataKey)

/**
 * Returns the name of the type to be expected by
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithType<*, *>.getTypeExpectedFromGenlet()
    = if (isTypeExpectedFromGenlet()) (this as Node).getData(TypeExpectedFromGenletDataKey) else null

/**
 * Get the basic type of this [IntermediateType]. For all type kinds and origins except collections defined in a data
 * model, the basic type is this [IntermediateType] itself. For collection types defined in a data model, the basic type
 * is either a primitive type (primitive collections) or the type of the single data field (structured collections).
 * Note that the method returns null in case this [IntermediateType] is a structured collection with more than one data
 * field.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.getBasicType()
    = if (kind == IntermediateTypeKind.COLLECTION && origin == IntermediateTypeOrigin.DATA_MODEL) {
            val resolvedType = (this as IntermediateComplexType).resolve() as IntermediateCollectionType
            when {
                resolvedType.isPrimitiveCollection -> resolvedType.primitiveType
                resolvedType.dataFields.size == 1 -> resolvedType.dataFields[0].type
                // FIXME Currently, we cannot deal with structured collections that have more than one data field. This
                // is contrary, however, to what we do in CollectionTypeHandler, where we meld multiple fields of a
                // structured collection to a single nested item of the generated Collection subclass, which represents
                // the collection type. In the future, to be consistent in behavior, this method should also cope with
                // structured collection with more than one data field, e.g., by pointing to the (yet) public nested
                // items in generated Collection subclasses.
                else -> null
            }
        } else
            this