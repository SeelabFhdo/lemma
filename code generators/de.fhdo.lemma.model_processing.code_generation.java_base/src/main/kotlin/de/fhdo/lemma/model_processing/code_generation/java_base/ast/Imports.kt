package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.findParentNode
import de.fhdo.lemma.java.ast.utils.getPackageName

/**
 * Add an import statement to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The
 * import will not be added by default, if it already exists. This function should only be invoked on
 * [ClassOrInterfaceDeclaration] instances created via [newJavaClassOrInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addImport(import: String, targetElementType: ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic, onlyAddActualIfDifferentPackage: Boolean = true) {
    // Independent of whether the import exists on the class/interface or not it will be added to the "invisible" data
    // of the class's/interface's AST node. That is, to allow functions like getAllImportsForTargetElementsOfType() to
    // retrieve import information even if it is not "visible" in the class/interface.
    val targetNodeForImports = if (isNestedType) findParentNode()!! else this
    targetNodeForImports.addImportsInfo(import, targetElementType, *characteristics)

    val compilationUnit = findParentNode<CompilationUnit>()!!
    if (onlyAddActualIfDifferentPackage) {
        val importPackage = import.substringBeforeLast(".")
        if (getPackageName() == importPackage)
            return
    }
    val existingImports = compilationUnit.imports.map { it.name.asString() }
    if (import !in existingImports)
        compilationUnit.addImport(import)
}

/**
 * Convenience function to add a list of [imports] to this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addImports(imports: List<SingleImportInfo>,
    onlyAddActualIfDifferentPackage: Boolean = true) {
    imports.forEach {
        addImport(it.import, it.targetElementType, *it.characteristics,
            onlyAddActualIfDifferentPackage = onlyAddActualIfDifferentPackage)
    }
}

/**
 * Data key for AST [Node] instances that clusters an [ImportInfo].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object ImportsInfoDataKey : DataKey<ImportsInfo>()

/**
 * Represents information about imports that were added to an AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ImportsInfo() {
    private val importsInfoMap = mutableMapOf<String, SingleImportInfo>()

    /**
     * Constructor to initialize the import map with a single import
     */
    constructor(initialImport: String, initialImportTargetElementType: ImportTargetElementType,
        vararg characteristics: SerializationCharacteristic) : this() {
        addImportInfo(initialImport, initialImportTargetElementType, *characteristics)
    }

    /**
     * Add an [import]. Note that the [characteristics] always apply for an [import] in combination with its
     * [targetElementType].
     */
    fun addImportInfo(import: String, targetElementType: ImportTargetElementType,
        vararg characteristics: SerializationCharacteristic) {
        val mapKey = importsInfoMapKey(import, targetElementType)
        if (mapKey !in importsInfoMap)
            importsInfoMap[mapKey] = SingleImportInfo(import, targetElementType, *characteristics)
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
    inline fun forEach(action: (SingleImportInfo) -> Unit) = importsInfoMap.values.forEach(action)

    /**
     * Enable iteration over the list of stored [SingleImportInfo] instances
     */
    operator fun iterator() = importsInfoMap.values.iterator()

    /**
     * Enable [filter] iteration over the list of stored [SingleImportInfo] instances
     */
    inline fun filter(predicate: (SingleImportInfo) -> Boolean) = importsInfoMap.values.filter(predicate)

    /**
     * Enable [any] iteration over the list of stored [SingleImportInfo] instances
     */
    inline fun any(predicate: (SingleImportInfo) -> Boolean) = importsInfoMap.values.any(predicate)

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
internal class SingleImportInfo(val import: String, val targetElementType: ImportTargetElementType,
    vararg val characteristics: SerializationCharacteristic) {
    /**
     * Helper to determine if the single import exhibits the given serialization [characteristic]
     */
    fun hasSerializationCharacteristic(characteristic: SerializationCharacteristic) = characteristic in characteristics
}

/**
 * Remove the given [import] for the given [targetElementType] from this [ClassOrInterfaceDeclaration]. In case the
 * [import] does not exist anymore on any elements of the [ClassOrInterfaceDeclaration], it will also be removed from
 * the compilation unit entirely.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.removeImport(import: String, targetElementType: ImportTargetElementType) {
    val targetNodeForImports = if (isNestedType) findParentNode()!! else this
    targetNodeForImports.removeImportsInfo(import, targetElementType)

    val importStillExistsInClass = getImportsInfo().any { it.import == import }
    if (importStillExistsInClass)
        return

    val compilationUnit = findParentNode<CompilationUnit>()!!
    val importInUnit = compilationUnit.imports.find { it.nameAsString == import }
    if (importInUnit !== null)
        compilationUnit.imports.remove(importInUnit)
}

/**
 * Remove information about an [import] for its [targetElementType] from this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.removeImportsInfo(import: String, targetElementType: ImportTargetElementType)
    = getImportsInfo().removeImportInfo(import, targetElementType)

/**
 * Get all [SingleImportInfo] instances assigned to this [ClassOrInterfaceDeclaration] that exhibit any of the given
 * [characteristics].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getAllImportsWithSerializationCharacteristics
    (vararg characteristics: SerializationCharacteristic)
    = getImportsInfo()
        .filter { importInfo -> importInfo.characteristics.any { it in characteristics } }
        .toList()

/**
 * Get all imports of this [MethodDeclaration] with the given [targetElementTypes]. By default, all imports that target
 * the method's signature and body are returned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.getImports(
    targetElementTypes: Set<ImportTargetElementType>
        = setOf(ImportTargetElementType.METHOD, ImportTargetElementType.METHOD_BODY)
)
    = getImportsInfo().getAllImportInfo()
        .filter { it.targetElementType in targetElementTypes }
        .map { it.import }
        .toSet()

/**
 * Remove the given [import] for the given [targetElementType] from this [MethodDeclaration] and also its defining
 * [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.removeImport(import: String, targetElementType: ImportTargetElementType)  {
    removeImportsInfo(import, targetElementType)
    findParentNode<ClassOrInterfaceDeclaration>()?.removeImport(import, targetElementType)
}

/**
 * Add an import statement to the Java enumeration represented by an [EnumDeclaration] instance. The import will not be
 * added by default, if it already exists. This function should only be invoked on [EnumDeclaration] instances created
 * via [newEnum].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EnumDeclaration.addImport(import: String, targetElementType : ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic, onlyAddActualIfDifferentPackage: Boolean = true) {
    // Independent of whether the import exists on the enumeration or not it will be added to the "invisible" data of
    // the enumeration's AST node. That is, to allow functions like getAllImportsForTargetElementsOfType() to retrieve
    // import information even if it is not "visible" in the enumeration.
    addImportsInfo(import, targetElementType, *characteristics)

    val compilationUnit = findParentNode<CompilationUnit>()!!
    if (onlyAddActualIfDifferentPackage) {
        val importPackage = import.substringBeforeLast(".")
        if (getPackageName() == importPackage)
            return
    }
    val existingImports = compilationUnit.imports.map { it.name.asString() }
    if (import !in existingImports)
        compilationUnit.addImport(import)
}

/**
 * Add an [import] together with its [targetElementType] to the data of an AST [Node] in the form of an [ImportInfo]
 * instance. This enables to track down for which [Node] and its elements a certain [import] was added.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.addImportsInfo(import: String, targetElementType: ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic) {
    if (!containsData(ImportsInfoDataKey))
        setData(ImportsInfoDataKey, ImportsInfo(import, targetElementType, *characteristics))
    else {
        val existingImportsInfo = getData(ImportsInfoDataKey)
        existingImportsInfo.addImportInfo(import, targetElementType, *characteristics)
        setData(ImportsInfoDataKey, existingImportsInfo)
    }
}

/**
 * Convenience method in the context of an attribute, which enables to add an import to its defining class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun FieldDeclaration.addImport(import: String, targetElementType: ImportTargetElementType) {
    addImportsInfo(import, targetElementType)
    findParentNode<ClassOrInterfaceDeclaration>()?.addImport(import, targetElementType)
}

/**
 * Return all [ImportInfo] instances being assigned to this AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.getImportsInfo()
    = if (containsData(ImportsInfoDataKey))
            getData(ImportsInfoDataKey)
        else
            ImportsInfo()

/**
 * Convenience method in the context of a Java method, which enables to add an import to its defining class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.addImport(import: String, targetElementType: ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic)
    = (this as CallableDeclaration<MethodDeclaration>).addImport(import, targetElementType, *characteristics)

/**
 * Convenience method in the context of a generic Java callable, which enables to add an import to its defining class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun CallableDeclaration<*>.addImport(import: String, targetElementType: ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic) {
    addImportsInfo(import, targetElementType, *characteristics)
    findParentNode<ClassOrInterfaceDeclaration>()?.addImport(import, targetElementType, *characteristics)
}