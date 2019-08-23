package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isString
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo

/**
 * Get the value of the property with the given name from an [IntermediateImportedAspect].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateImportedAspect.getPropertyValue(propertyName: String) : String? {
    return propertyValues.find { it.property.name == propertyName }?.value
}

/**
 * Derived property of [IntermediateMicroservice] that represents the simple name of the microservice, i.e., its non-
 * qualified name. This will be "Service" for the example service "org.example.Service".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateMicroservice.simpleName
    get() = name.substringAfterLast(".")

/**
 * Derived property of [IntermediateMicroservice] that represents the package name of the microservice, i.e., its fully-
 * qualified name without the [simpleName]. This will be "org.example" for the example service "org.example.Service".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateMicroservice.packageName
    get() = qualifiedName.substringBeforeLast(".")

/**
 * Derived property of [IntermediateComplexType] that represent the name of the complex type as a Java classname.
 * Essentially, this is the capitalized version of the name of the complex type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateComplexType.classname
    get() = name.capitalize()

/**
 * Derived property of [IntermediateComplexType] that represents the package name of the complex type, i.e., its fully-
 * qualified name without the [classname]. This will be "org.example" for the complex type "org.example.ComplexType".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateComplexType.packageName
    get() = qualifiedName.substringBeforeLast(".")

/**
 * Derived property of [IntermediateComplexType] that represents the fully-qualified Java classname of the complex type.
 * That is, its [packageName] and [classname] separated by a dot.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateComplexType.fullyQualifiedClassname
    get() = "$packageName.$classname"

/**
 * [fullyQualifiedClassname] of [IntermediateComplexType] turned into a path. That is, the separating dots are replaced
 * by OS-specific file separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.fullyQualifiedClasspath(withExtension: Boolean = true)
    =
        """
            ${fullyQualifiedClassname.packageToPath()}
            ${if (withExtension) ".java" else ""}
        """.trimToSingleLine()

/**
 * [packageName] of [IntermediateComplexType] turned into a path. That is, the separating dots are replaced by
 * OS-specific file separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateComplexType.packagePath
    get() = packageName.packageToPath()

/**
 * Check if an [IntermediateDataStructure] has a certain aspect assigned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateDataStructure.hasAspect(aspectName: String) = aspects.any { it.name == aspectName }

/**
 * Check if an [IntermediateDataField] exhibits a certain feature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateDataField.hasFeature(feature: String) = featureNames.contains(feature)

/**
 * Get the initialization value of an [IntermediateDataField] as string. Note, that only data fields with an
 * [IntermediatePrimitiveType] can have an initialization value.
 *
 * In case the type of the field is String, the value will be returned within double quotes. Otherwise, the value itself
 * will be returned. If the field does not have an initialization value at all, two double quotes will be returned
 * (field has String type) or an empty String will be returned (else).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val IntermediateDataField.typeSpecificInitializationValueString
    get() = if (initializationValue === null) {
        if ((type as IntermediatePrimitiveType).isString) "\"\"" else ""
    } else {
        if ((type as IntermediatePrimitiveType).isString) "\"$initializationValue\"" else initializationValue
    }

/**
 * Helper to find annotated classes, possibly within other JAR archives leveraging the given [classLoaders].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findAnnotatedClasses(searchPackage: String, annotation: String, vararg classLoaders: ClassLoader,
    filter: (ClassInfo) -> Boolean) : List<ClassInfo> {
    val classgraph = ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(searchPackage)

    if (classLoaders.isNotEmpty())
        classgraph.overrideClassLoaders(*classLoaders)

    return classgraph
        .scan()
        .getClassesWithAnnotation(annotation)
        .filter { filter(it) }
        .toList()
}

/**
 * Helper to find annotated classes that also implement a certain interface. When explicitly specifying [classLoaders]
 * other JAR archives than the current one might be searched.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
internal inline fun <reified T> findAnnotatedClassesWithInterface(searchPackage: String, annotation: String,
    vararg classLoaders: ClassLoader, interfaceClassname: String = T::class.java.name)
    = findAnnotatedClasses(
            searchPackage,
            annotation,
            *classLoaders
        )
        { it.implementsInterface(interfaceClassname) }  // Interface filter
        .map { it.loadClass() as Class<T> }

/**
 * Helper to find annotated classes that also implement a certain interface. When explicitly specifying [classLoaders]
 * other JAR archives than the current one might be searched. The result of the function will be a map that assigns the
 * identifier string produced by the specified [identifierBuilder] to the found classes.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal inline fun <reified T> findAndMapAnnotatedClassesWithInterface(searchPackage: String, annotation: String,
    vararg classLoaders: ClassLoader, interfaceClassname: String = T::class.java.name,
    identifierBuilder: (T) -> String)
    : Map<String, Class<T>> {
    val foundClasses = findAnnotatedClassesWithInterface<T>(searchPackage, annotation, *classLoaders,
        interfaceClassname = interfaceClassname)

    val resultMap = mutableMapOf<String, Class<T>>()
    resultMap.putAll(
        pairs = foundClasses.map {
            val identifier = identifierBuilder(it.getDeclaredConstructor().newInstance())
            identifier to it
        }
    )
    return resultMap
}