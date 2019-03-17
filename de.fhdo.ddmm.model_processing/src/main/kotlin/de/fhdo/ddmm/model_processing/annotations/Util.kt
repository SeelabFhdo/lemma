package de.fhdo.ddmm.model_processing.annotations

import io.github.classgraph.AnnotationInfo
import io.github.classgraph.AnnotationInfoList
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfoList
import io.github.classgraph.ScanResult
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.starProjectedType

/**
 * Convenience extension function of [ScanResult], which enables to pass an annotation class instead of its qualified
 * name to retrieve all classes from the result that are annotated with it.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ScanResult.getClassesWithAnnotation(annotationClass: KClass<out Annotation>) : ClassInfoList
    = getClassesWithAnnotation(annotationClass.qualifiedName)

/**
 * Convenience extension function of [AnnotationInfoList], which enables to pass an annotation class instead of its
 * qualified name to retrieve the [AnnotationInfo] objects related with it.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal operator fun AnnotationInfoList.get(annotationClass: KClass<out Annotation>) : AnnotationInfo?
    = get(annotationClass.qualifiedName)

/**
 * Helper for find all classes annotated with a given annotation class in a certain package.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findAnnotatedClasses(sourcePackage: String, annotationClass: KClass<out Annotation>) =
    ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(sourcePackage)
        .scan()
        .getClassesWithAnnotation(annotationClass)
        .toMutableList()

/**
 * Helper to find all methods of an object that have been annotated with a given annotation class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Any.findAnnotatedMethods(annotationClass: KClass<out Annotation>) =
    this::class.memberFunctions.filter { memberFunction -> memberFunction.annotations.any { annotation ->
        annotation.annotationClass == annotationClass
    } }

/**
 * Helper to find all methods of an object that have been annotated with a given annotation class and whose signatures
 * exhibit specific types. Note that the comparison of the signature types is "inclusive". That is, a type within a
 * signature is considered equal to a given type, if it can hold values of the given type. This is the case, if the
 * signature type is of the same type or a subtype of the given type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Any.findAnnotatedMethods(annotationClass: KClass<out Annotation>, vararg parameterClasses: KClass<*>)
    : List<KFunction<*>> {
    /* Find annotated methods */
    val annotatedMethods = findAnnotatedMethods(annotationClass)

    /* Check their signatures */
    val matchingMethods = mutableListOf<KFunction<*>>()
    annotatedMethods.forEach {
        // The method's signature types are those of its value parameters
        val valueParameters = it.parameters.filter{ parameter -> parameter.kind == KParameter.Kind.VALUE }
        if (valueParameters.size == parameterClasses.size) {
            var allTypesMatch = true
            for (n in 0 until valueParameters.size) {
                val parameter = valueParameters[n]
                val expectedType = parameterClasses[n].starProjectedType

                // Compare the signature type with the given (expected) type, based on their subtyping relationship
                if (!parameter.type.isSubtypeOf(expectedType)) {
                    allTypesMatch = false
                    break
                }
            }

            if (allTypesMatch)
                matchingMethods.add(it)
        }
    }

    return matchingMethods
}