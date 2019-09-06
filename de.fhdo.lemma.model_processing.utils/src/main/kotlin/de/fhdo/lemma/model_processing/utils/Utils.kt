package de.fhdo.lemma.model_processing.utils

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.model_processing.asXmiResource as asXmiResourceSimple
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.service.ImportType
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.io.File
import java.util.LinkedList

/**
 * Check if a string represents a numeric value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.isNumeric() = toIntOrNull() != null

/**
 * Turn a package name into a sub-path by replacing name separators (default value = ".") with OS-specific file
 * separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.packageToPath(nameSeparator: String = ".") = replace(nameSeparator, File.separator)

/**
 * Turn a path into a package name by replacing OS-specific file separators with name separators (default value = ".").
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.pathToPackage(nameSeparator: String = ".") = replace(File.separator, nameSeparator)

/**
 * Trim a (possibly multiline) string literal to a single line. For instance, invoking the function on the multiline
 * string literal
 *      """
 *      System.out.println(
 *          "Hello world"
 *      );
 *      """
 * will result in the single-line string literal
 *      System.out.println("Hello world");
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.trimToSingleLine(preserveTrailingWhitespaces: Boolean = false) = trimIndent().split("\n").joinToString("") {
    if (!preserveTrailingWhitespaces) it.trim() else it.trimStart()
}

/**
 * Get an element at a given index in a list. If the index is invalid, return null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun List<*>.getOrNull(index: Int) = if (isNotEmpty() && index in 0..lastIndex) this[index] else null

/**
 * Insert a value in a map, whose value-type is a [MutableList]. That is, the value will be added to the list being
 * assigned to the given key. In case the key is not part of the map yet, it will be inserted and get a [MutableList]
 * assigned that comprises the given value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <K: Any, V: Any> MutableMap<K, MutableList<V>>.insertValue(key: K, value: V) {
    if (!this.containsKey(key))
        this[key] = LinkedList<V>()
    this[key]!!.add(value)
}

/**
 * Put a value in a map, whose value-type is a [MutableMap]. That is, the value will be put to the [MutableMap] being
 * assigned to the given key. In case the key is not part of the main map yet, it will be inserted and get a
 * [MutableMap] assigned that comprises the given value with the given key for the [MutableMap].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <K1: Any?, K2: Any?, V: Any?> MutableMap<K1, MutableMap<K2, V>>.putValue(key1: K1, key2: K2, value: V) {
    if (!this.containsKey(key1))
        this[key1] = mutableMapOf()
    this[key1]!![key2] = value
}

/**
 * Convert a [List] of [Pair] instances to a [MutableMap] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <A: Any?, B: Any?> List<Pair<A, B>>.toMutableMap() : MutableMap<A, B> {
    val map = mutableMapOf<A, B>()
    forEach { (first, second) -> map[first] = second }
    return map
}

/**
 * Mapping function for [Pair] instances that clusters instances of the same type. The [transform] lambda is applied to
 * both components of the [Pair] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <A: Any, R: Any> Pair<A, A>.map(transform: (A) -> R) = transform(component1()) to transform(component2())

/**
 * Remove preceding "file://" scheme from a string.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.removeFileUri() : String = LemmaUtils.removeFileUri(this).removePrefix("//")

/**
 * Create an XMI [Resource] from a string that may represent a URI.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.asXmiResource() : Resource = removeFileUri().asXmiResourceSimple()

/**
 * Get the root [EObject] of an Ecore [Resource]. This assumes that the [Resource] has only one [EObject] on its
 * top-level.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
fun <T : EObject> Resource.modelRoot() : T = contents[0] as T

/**
 * Load the root of a model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <T : EObject> loadModelRoot(filePath: String) : T = filePath.asXmiResource().modelRoot()

/**
 * Get the path of an [IntermediateImport] by removing the "file://" scheme from its URI.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateImport.path: String
    get() = importUri.removeFileUri()

/**
 * Get the main interface of an [EObject], which typically corresponds to the class of the [EObject] without the "Impl"
 * suffix.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
val EObject.mainInterface
    get() = this::class.java.interfaces[0] as Class<out EObject>

/**
 * Filter an [IntermediateImport] list by type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EList<IntermediateImport>.filterByType(importType: ImportType)
    = this.filter { it.importTypeName == importType.toString() }

/**
 * Count lines of a String. CRLF, LF, and CR will be considered as linebreak separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.countLines(includeEmptyLines: Boolean = false, includeComments: Boolean = false) : Int {
    val linesToCount = if (includeEmptyLines)
            lines()
        else
            lines().filter { it.isNotEmpty() && !it.matches("\\s+".toRegex()) }
    val lineCount = linesToCount.count()

    if (includeComments)
        return lineCount

    var commentLineCount = 0
    var inBlockComment = false
    linesToCount.map { it.trim() }.forEach {
        if (!inBlockComment) {
            if (it.startsWith("//"))
                commentLineCount++
            else if (it.startsWith("/*"))
                inBlockComment = true
        }

        if (inBlockComment)
            commentLineCount++

        if (it.endsWith("*/"))
            inBlockComment = false
    }

    return lineCount - commentLineCount
}