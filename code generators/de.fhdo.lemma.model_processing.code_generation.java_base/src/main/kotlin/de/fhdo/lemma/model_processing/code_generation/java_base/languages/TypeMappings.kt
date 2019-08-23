package de.fhdo.lemma.model_processing.code_generation.java_base.languages

import de.fhdo.lemma.data.PrimitiveTypeConstants
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.phases.PhaseException

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
        PrimitiveTypeConstants.DATE.literal mapsTo "LocalDateTime" withImport "java.time.LocalDateTime"
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
        "Date" mapsTo "LocalDateTime" withImport "java.time.LocalDateTime"
        "Double".mapsToSelf()
        "Float".mapsToSelf()
        "Integer".mapsToSelf()
        "Long".mapsToSelf()
        "Object".mapsToSelf()
        "Short".mapsToSelf()
        "String".mapsToSelf()
    }
}

/**
 * Convenience function to get a [TypeMappingDescription] from an [IntermediateType] instance reflecting a primitive or
 * complex type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.getTypeMapping() : TypeMappingDescription? {
    return when(this) {
        is IntermediatePrimitiveType -> primitiveTypeMappings[this]
        is IntermediateImportedTechnologySpecificType -> primitiveTypeMappings[this]
        is IntermediateComplexType -> TypeMappingDescription(classname, classname, true)
        else -> throw PhaseException("Cannot derive Java type for unknown type kind${this::class.java.name}")
    }
}

/**
 * Description of a type mapping, i.e., the name of an original type is mapped to the name of another type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class TypeMappingDescription(val originalTypeName: String, val mappedTypeName: String,
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
    operator fun get(primitiveType: IntermediateType) : TypeMappingDescription? {
        return when(primitiveType.origin) {
            IntermediateTypeOrigin.BUILTIN -> builtin[primitiveType.name]
            IntermediateTypeOrigin.TECHNOLOGY -> technology[primitiveType.name]
            else -> null
        }
    }
}

/**
 * Convenience function to determine if an [IntermediateType] is of built-in or technology-specific, i.e., Java object
 * wrapper, type String.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateType.isString
    get() = primitiveTypeMappings[this]?.mappedTypeName == "String"

/**
 * Convenience function to determine if an [IntermediateType] is nullable, which is the case when the type is not
 * a primitive Java type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateType.isNullable
    get() = when(this) {
        is IntermediatePrimitiveType -> this.isString || "LocalDateTime" == primitiveTypeMappings[this]?.mappedTypeName
        is IntermediateImportedTechnologySpecificType -> true
        is IntermediateComplexType -> true
        else -> false
    }