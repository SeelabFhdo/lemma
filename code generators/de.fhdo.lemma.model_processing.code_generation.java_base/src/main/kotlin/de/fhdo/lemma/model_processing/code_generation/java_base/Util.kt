package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.ListType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import java.lang.IllegalStateException

/**
 * Derived property of [ComplexType] that represents the qualified name of the type. This handles all kinds of complex
 * types, i.e., [DataStructure], [ListType], and [Enumeration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ComplexType.qualifiedName
    get() = when(this) {
            is DataStructure -> qualifiedName
            is ListType -> qualifiedName
            is Enumeration -> qualifiedName
            else -> throw IllegalStateException("Derivation of qualified name for complex type of type "+
                "${this::class.java.name} is not supported")
        }

/**
 * Derived property of [DataStructure] that represents the qualified name of the structure.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val DataStructure.qualifiedName
    get() = buildQualifiedName(".")

/**
 * Derived property of [ListType] that represents the qualified name of the list type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ListType.qualifiedName
    get() = buildQualifiedName(".")

/**
 * Derived property of [Enumeration] that represents the qualified name of the enumeration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Enumeration.qualifiedName
    get() = buildQualifiedName(".")

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
 * Resolve the original [IntermediateComplexType] from this instance. To keep the intermediate models is lightweight as
 * possible, references have been omitted where possible. Instead, types, for example, are embedded as containments
 * at most places and the "reference" to the original type is established leveraging the import URI (for
 * [IntermediateImportedComplexType] instances) and the type's [qualifiedName]. This functions allows for finding the
 * original [IntermediateComplexType] to which this [IntermediateComplexType] is referencing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateComplexType.resolve() : IntermediateComplexType {
    /* Determine the defining model and referencing parts (version name, context name, and simple name) of this type */
    val definingModelUri = if (this is IntermediateImportedComplexType) import.importUri else null
    val definingModel = if (definingModelUri !== null) loadModelRoot(definingModelUri) else getContainingDataModel()
    val (versionName, contextName, simpleName) = getQualifiedNameParts()

    /* Determine sources of this type's referencing parts (version and context instances) */
    val version = if (versionName !== null) definingModel.versions.find { it.name == versionName } else null

    val context = if (contextName !== null) {
            // A context may be part of a version or reside on the top-level of a data model
            if (version !== null)
                version.contexts.find { it.name == contextName }
            else
                definingModel.contexts.find { it.name == contextName }
        } else
            null

    /* Resolve the type */
    val resolvedType = if (version !== null && context !== null)
            // According to its qualified name, the type is defined in a context within a version
            context.complexTypes.find { it.name == simpleName }
        else if (version !== null && context === null)
            // According to its qualified name, the type is directly defined in a version
            version.complexTypes.find { it.name == simpleName }
        else if (context !== null)
            // According to its qualified name, the type is directly defined in a context
            context.complexTypes.find { it.name == simpleName }
        else
            // There is neither a version nor a context surrounding the type (according to its qualified name), i.e.,
            // the type is defined on the top-level of the model itself
            definingModel.complexTypes.find { it.name == simpleName }

    require(resolvedType !== null) { "Complex type $qualifiedName could not be resolved" }
    return resolvedType!!
}

/**
 * Helper to find the data model that contains the [IntermediateComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.getContainingDataModel() : IntermediateDataModel {
    var container = eContainer()
    while (container !is IntermediateDataModel)
        container = container.eContainer()
    return container
}

/**
 * Helper to get the parts of the [qualifiedName] of an [IntermediateComplexType]. The result is a [Triple], whose
 *      - first component is the type's version (or null, if the type has no version),
 *      - second component is the type's context (or null, if the type has no context),
 *      - third component is the type's name, without a qualifying part (i.e., its "simple" name).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.getQualifiedNameParts() : Triple<String?, String?, String> {
    val qualifiedNameParts = qualifiedName.split(".")

    val version = if (qualifiedNameParts.size == 3) qualifiedNameParts[0] else null

    val context = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[1]
        2 -> qualifiedNameParts[0]
        else -> null
    }

    val simpleName = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[2]
        2 -> qualifiedNameParts[1]
        else -> qualifiedNameParts[0]
    }

    return Triple(version, context, simpleName)
}

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