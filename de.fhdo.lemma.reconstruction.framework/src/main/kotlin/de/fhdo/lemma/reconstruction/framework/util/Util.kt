package de.fhdo.lemma.reconstruction.framework.util

import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import org.intellij.lang.annotations.Identifier

/**
 * Helper to find annotated classes, possibly within other JAR archives leveraging the given [classLoaders].
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal fun findAnnotatedClasses(searchPackage: String, annotation: String, vararg classLoaders: ClassLoader):
        List<ClassInfo> {
    val classGraph = ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(searchPackage)

    if (classLoaders.isNotEmpty())
        classGraph.overrideClassLoaders(*classLoaders)

    return classGraph
        .scan()
        .getClassesWithAnnotation(annotation)
        .toList()
}

/**
 * Compare qualified names based on part separator and hierarchy level
 */
fun compareFullQualifiedNames(service: String, identifier: String, partSeparator: String, level: Int): Boolean {
    val serviceParts = service.split(partSeparator)
    val identifierParts = identifier.split(partSeparator)
    return serviceParts.subList(0, level) == identifierParts.subList(0, level)
}
