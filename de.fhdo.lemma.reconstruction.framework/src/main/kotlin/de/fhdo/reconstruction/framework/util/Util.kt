package de.fhdo.reconstruction.framework.util

import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo

/**
 * Helper to find annotated classes, possibly within other JAR archives leveraging the given [classLoaders].
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal fun findAnnotatedClasses(searchPackage: String, annotation: String, vararg classLoaders: ClassLoader): List<ClassInfo> {
    val classGraph = ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(searchPackage)

    if (classLoaders.isNotEmpty())
        classGraph.overrideClassLoaders(*classLoaders)

    val classes = classGraph
        .scan()
        .getClassesWithAnnotation(annotation)
        .toList()

    return classes
}