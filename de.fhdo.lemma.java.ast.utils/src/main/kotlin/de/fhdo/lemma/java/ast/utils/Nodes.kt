@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Node

/**
 * Find the parent node of a [Node], which is of the given type [T].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T: Node> Node.findParentNode() : T? {
    var currentParentNode = parentNode.orElse(null)
    while (currentParentNode != null && currentParentNode !is T)
        currentParentNode = currentParentNode.parentNode.orElse(null)
    return currentParentNode as T?
}

/**
 * Enumeration to distinguish the various types of Java code elements that may be targeted by a certain import. For
 * instance, an import may be necessary because a [METHOD] parameter is typed by a class provided by the import. Another
 * example is an [ANNOTATION] provided by a framework dependency.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class ImportTargetElementType {
    ANNOTATION,
    ATTRIBUTE,
    ATTRIBUTE_TYPE,
    IMPLEMENTED_INTERFACE,
    METHOD,
    METHOD_BODY,
    SUPER
}

/**
 * Represents information about imports that were added to an AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class ImportsInfo<T: SingleImportInfo>() {
    private val importsInfoMap = mutableMapOf<String, T>()

    /**
     * Constructor to initialize the import map with a single import
     */
    constructor(importInfo: T) : this() {
        addImportInfo(importInfo)
    }

    /**
     * Add an import info
     */
    fun addImportInfo(importInfo: T) {
        val mapKey = importsInfoMapKey(importInfo.import, importInfo.targetElementType)
        if (mapKey !in importsInfoMap)
            importsInfoMap[mapKey] = importInfo
    }

    /**
     * Remove an [import] for the given [targetElementType]
     */
    fun removeImportInfo(import: String, targetElementType: ImportTargetElementType) {
        val mapKey = importsInfoMapKey(import, targetElementType)
        importsInfoMap.remove(mapKey)
    }

    /**
     * Retrieve all [SingleImportInfo] instances
     */
    fun getAllImportInfo() = importsInfoMap.values.toList()

    /**
     * Get [SingleImportInfo] for the given [import] and [targetElementType]
     */
    operator fun get(import: String, targetElementType: ImportTargetElementType)
        = importsInfoMap[importsInfoMapKey(import, targetElementType)]

    /**
     * Enable [forEach] iteration over the list of stored [SingleImportInfo] instances
     */
    fun forEach(action: (T) -> Unit) = importsInfoMap.values.forEach(action)

    /**
     * Enable iteration over the list of stored [SingleImportInfo] instances
     */
    operator fun iterator() = importsInfoMap.values.iterator()

    /**
     * Enable [filter] iteration over the list of stored [SingleImportInfo] instances
     */
    fun filter(predicate: (SingleImportInfo) -> Boolean) = importsInfoMap.values.filter(predicate)

    /**
     * Enable [any] iteration over the list of stored [SingleImportInfo] instances
     */
    fun any(predicate: (SingleImportInfo) -> Boolean) = importsInfoMap.values.any(predicate)

    /**
     * Helper to create the key for the map of [SingleImportInfo] instances
     */
    private fun importsInfoMapKey(import: String, targetElementType: ImportTargetElementType)
        = "$import::${targetElementType.name}"
}

/**
 * Class that represents information about a single [import] at a certain [targetElementType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class SingleImportInfo(val import: String, val targetElementType: ImportTargetElementType)

/**
 * Data key for AST [Node] instances that clusters an [ImportsInfo].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object ImportsInfoDataKey : DataKey<ImportsInfo<SingleImportInfo>>()

/**
 * Return all [ImportsInfo] instances being assigned to this AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <reified T: ImportsInfo<*>> Node.getImportsInfo()
    = if (containsData(ImportsInfoDataKey))
            getData(ImportsInfoDataKey) as T
        else
            null

/**
 * Remove information about an [import] for its [targetElementType] from this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.removeImportsInfo(import: String, targetElementType: ImportTargetElementType)
    = getImportsInfo<ImportsInfo<SingleImportInfo>>()?.removeImportInfo(import, targetElementType)