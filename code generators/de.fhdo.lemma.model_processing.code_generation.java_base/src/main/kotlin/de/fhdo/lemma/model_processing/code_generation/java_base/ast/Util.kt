package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.JavaParser
import com.github.javaparser.ParseProblemException
import com.github.javaparser.ParserConfiguration
import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.NodeList
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.body.VariableDeclarator
import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.ast.comments.Comment
import com.github.javaparser.ast.comments.LineComment
import com.github.javaparser.ast.expr.AnnotationExpr
import com.github.javaparser.ast.expr.AssignExpr
import com.github.javaparser.ast.expr.MarkerAnnotationExpr
import com.github.javaparser.ast.expr.MemberValuePair
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.expr.SimpleName
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.ReturnStmt
import com.github.javaparser.ast.stmt.Statement
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.ReferenceType
import com.github.javaparser.ast.type.Type
import com.github.javaparser.ast.type.TypeParameter
import com.github.javaparser.printer.DefaultPrettyPrinter
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.technology.CommunicationType
import java.io.File
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState

/**
 * Helper to get a [ClassOrInterfaceDeclaration] that has the same name as this [File] instance. Note that this function
 * parses the file using lexical preservation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun File.getEponymousJavaClassOrInterface()
    = try {
        val parsedCompilationUnit = this.parseCompilationUnitWithLexicalPreservation()
        parsedCompilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java) {
            it.nameAsString == nameWithoutExtension
        }.orElse(null)
    } catch (ex: Exception) {
        null
    }

/**
 * Parse a Java [CompilationUnit] from this [File] with preserving its lexical layout, e.g., manually added empty lines.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun File.parseCompilationUnitWithLexicalPreservation() : CompilationUnit {
    val result = JavaParser(ParserConfiguration().setLexicalPreservationEnabled(true)).parse(this)

    if (!result.isSuccessful)
        throw ParseProblemException(result.problems)

    val parsedCompilationUnit = result.result.get()
    // Remember the compilation unit to being the result of parsing with lexical preservation so that we can later again
    // serialize it correspondingly
    parsedCompilationUnit.setData(ParsedWithLexicalPreservation, true)
    return parsedCompilationUnit
}

/**
 * Data key for the information that a [CompilationUnit] was the result from parsing with lexical preservation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object ParsedWithLexicalPreservation : DataKey<Boolean>()

/**
 * Helper to diff two classes based on their [CallableDeclaration] lists, i.e., their constructors or methods. The
 * functions returns all [CallableDeclaration] instances of the [source] list that are not in the [target] list. The
 * diff of the callables is based on their signatures (name and parameter types).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: CallableDeclaration<*>> diffCallables(source: List<T>, target: List<T>) : List<T> {
    val missingCallablesInTarget = mutableListOf<T>()
    val targetSignatures = target.map { targetCallable ->
        val parameterTypesString = targetCallable.parameters.joinToString { it.typeAsString }
        "${targetCallable.name}$parameterTypesString"
    }

    source.forEach { sourceCallable ->
        val parameterTypesString = sourceCallable.parameters.joinToString { it.typeAsString }
        val signatureString = "${sourceCallable.name}$parameterTypesString"
        if (signatureString !in targetSignatures)
            missingCallablesInTarget.add(sourceCallable)
    }

    return missingCallablesInTarget
}

/**
 * Enumeration to allow code generators to influence serialization of generated Java AST [Node] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class SerializationCharacteristic {
    /**
     * Add node only on relocation.
     *
     * Affects: Annotations, imports, and methods.
     */
    ADD_ON_RELOCATION,

    /**
     * Adapt method bodies to delegate to super methods on relocation.
     *
     * Affects: Methods.
     */
    DELEGATE_ON_RELOCATION,

    /**
     * Do not relocate elements from their defining compilation unit. For instance, do not pull up methods to
     * interfaces.
     *
     * Affects: Annotations, attributes, classes, imports, and methods.
     */
    DONT_RELOCATE,

    /**
     * Keep original node on relocation.
     *
     * Affects: Annotations and imports.
     */
    KEEP_ON_RELOCATION,

    /**
     * Merge method bodies on relocation.
     *
     * Affects: Methods.
     */
    MERGE_ON_RELOCATION,

    /**
     * Do not generate additional constructors for the class exhibiting this characteristic.
     *
     * Affects: Classes.
     */
    NO_CONSTRUCTORS,

    /**
     * Remove node on relocation.
     *
     * Affects: Annotations, imports, and methods.
     */
    REMOVE_ON_RELOCATION,
}

/**
 * Add a [SerializationCharacteristic] to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristic(characteristic: SerializationCharacteristic) {
    if (!containsData(SerializationCharacteristicDataKey))
        setData(SerializationCharacteristicDataKey, mutableSetOf(characteristic))
    else
        getData(SerializationCharacteristicDataKey).add(characteristic)
}

/**
 * Add [SerializationCharacteristic] instances to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristics(characteristics: Iterable<SerializationCharacteristic>)
    = characteristics.forEach { addSerializationCharacteristic(it) }

/**
 * Add [SerializationCharacteristic] instances represented as an [Array] to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristics(characteristics: Array<out SerializationCharacteristic>)
    = characteristics.forEach { addSerializationCharacteristic(it) }

/**
 * Get all [SerializationCharacteristic] instances of a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.getSerializationCharacteristics() : Set<SerializationCharacteristic>
    = if (containsData(SerializationCharacteristicDataKey))
        getData(SerializationCharacteristicDataKey)
    else
        emptySet()

/**
 * Verify if a [Node] exhibits a certain [SerializationCharacteristic].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.hasSerializationCharacteristic(characteristic: SerializationCharacteristic)
    = characteristic in getSerializationCharacteristics()

/**
 * Clear the set of [SerializationCharacteristic] instances of a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.clearSerializationCharacteristics() {
    if (containsData(SerializationCharacteristicDataKey))
        setData(SerializationCharacteristicDataKey, mutableSetOf())
}

/**
 * Convenience function to add an annotation with the given [name] and serialization [characteristics] to this
 * [NodeWithAnnotations].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.addAnnotation(name: String,
    vararg characteristics: SerializationCharacteristic) : NodeWithAnnotations<out Node> {
    val annotation = this.addAndGetAnnotation(name)
    annotation.addSerializationCharacteristics(characteristics)
    return this
}

/**
 * Convenience function to add an annotation with the given [name] and serialization [characteristics] to this
 * [NodeWithAnnotations]. Returns the created annotation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.addAndGetAnnotation(name: String,
    vararg characteristics: SerializationCharacteristic) : NormalAnnotationExpr {
    val annotation = this.addAndGetAnnotation(name)
    annotation.addSerializationCharacteristics(characteristics)
    return annotation
}

/**
 * Check if this [NodeWithAnnotations] has an annotation of the given [name].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.hasAnnotation(name: String) = annotations.any { it.nameAsString == name }

/**
 * Get the annotation specified by its [name] from this [NodeWithAnnotations]. Returns null if the annotation does not
 * exist on this node.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <reified T: AnnotationExpr> NodeWithAnnotations<out Node>.getAnnotation(name: String)
    = annotations.find { it.nameAsString == name && it is T } as? T

/**
 * Get the value for the specified [key] in a value-pair of this [NormalAnnotationExpr].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NormalAnnotationExpr.getValueAsString(key: String) = pairs.find { it.nameAsString == key }?.value?.toString()

/**
 * Data key for a set of [SerializationCharacteristic] instances on a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object SerializationCharacteristicDataKey : DataKey<MutableSet<SerializationCharacteristic>>()

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
 * Data key for AST [Node] instances that clusters an [ImportsInfo].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object ImportsInfoDataKey : DataKey<ImportsInfo>()

/**
 * Add an [import] together with its [targetElementType] to the data of an AST [Node] in the form of an [ImportsInfo]
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
 * Return all [ImportsInfo] instances being assigned to this AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.getImportsInfo()
    = if (containsData(ImportsInfoDataKey))
            getData(ImportsInfoDataKey)
        else
            ImportsInfo()

/**
 * Remove information about an [import] for its [targetElementType] from this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.removeImportsInfo(import: String, targetElementType: ImportTargetElementType)
    = getImportsInfo().removeImportInfo(import, targetElementType)

/**
 * Add a new [DependencyDescription] to the collected dependencies of the [MainState] in the context of a certain
 * [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(dependency: DependencyDescription) {
    MainState.addDependency(dependency)
}

/**
 * Add a new dependency represented by a group, artifact, and possibly a version identifier to the collected
 * dependencies of the [MainState] in the context of a certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(group: String, artifact: String, version: String? = null) {
    addDependency(DependencyDescription(group, artifact, version))
}

/**
 * Add a new dependency represented as string to the collected dependencies of the [MainState] in the context of a
 * certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(descriptionString: String) {
    addDependency(DependencyDescription.fromString(descriptionString))
}

/**
 * Add [DependencyDescription] list to the collected dependencies of the [MainState] in the context of a certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependencies(dependencies: Iterable<DependencyDescription>) {
    dependencies.forEach { addDependency(it) }
}

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
 * Helper to retrieve the [ClassOrInterfaceDeclaration] from a [Node]. In case this [Node] is a [CompilationUnit], the
 * [ClassOrInterfaceDeclaration] will always constitute a class or null, if the unit clusters an interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.asClassOrInterfaceDeclaration() : ClassOrInterfaceDeclaration?
    = when(this) {
        is CompilationUnit -> findFirst(ClassOrInterfaceDeclaration::class.java) { !it.isInterface }.orElse(null)
        is ClassOrInterfaceDeclaration -> this
        else -> null
    }

/**
 * Helper to serialize an AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.serialize(serializationConfiguration: AbstractSerializationConfiguration) : String {
    val compilationUnit = when(this) {
        is CompilationUnit -> this
        is ClassOrInterfaceDeclaration,
            is EnumDeclaration -> findParentNode()!!
        else -> throw IllegalArgumentException("Serialization of nodes of type ${this::class.java.name} is not " +
            "supported")
    }

    return if (compilationUnit.containsData(ParsedWithLexicalPreservation) &&
        compilationUnit.getData(ParsedWithLexicalPreservation))
            // We need to use a dedicated JavaParser utility for serializing compilation units that resulted from
            // parsing with lexical preservation
            LexicalPreservingPrinter.print(compilationUnit)
        else
            DefaultPrettyPrinter(serializationConfiguration).print(compilationUnit)
}

/**
 * Helper to check if this [Type] is a generic type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Type.isGenericType() = (this as? ClassOrInterfaceType)?.typeArguments?.isPresent ?: false

/**
 * Associate this [ClassOrInterfaceDeclaration] with a [filePath].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.setFilePath(filePath: String) {
    setData(FilePathDataKey, filePath)
}

/**
 * Get associated file path of this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getFilePath() : String? {
    return if (containsData(FilePathDataKey))
        getData(FilePathDataKey)
    else
        null
}

/**
 * Data key for [ClassOrInterfaceDeclaration] instances that clusters the file paths being associated with them.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object FilePathDataKey : DataKey<String>()

/**
 * Create a new Java class or interface named [classname] in the package with the given [packageName]. The result is an
 * AST node of type [ClassOrInterfaceDeclaration] that also comprises a [CompilationUnit] instance holding the
 * [packageName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun newJavaClassOrInterface(packageName: String, classname: String, isInterface: Boolean = false)
    : ClassOrInterfaceDeclaration {
    val compilationUnit = CompilationUnit(packageName)
    val clazz = ClassOrInterfaceDeclaration()
    clazz.isInterface = isInterface
    clazz.setName(classname)
    clazz.addModifier(Modifier.Keyword.PUBLIC)
    clazz.setParentNode(compilationUnit)
    compilationUnit.addType(clazz)
    return clazz
}

/**
 * Create a new inner Java class named [classname], which is nested inside the given [parentClass]. The result is the
 * created [ClassOrInterfaceDeclaration] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun newInnerJavaClass(classname: String, parentClass: ClassOrInterfaceDeclaration, isStatic: Boolean = false)
    : ClassOrInterfaceDeclaration {
    val clazz = ClassOrInterfaceDeclaration()
    clazz.addModifier(Modifier.Keyword.PUBLIC)
    clazz.isStatic = isStatic
    clazz.setName(classname)
    clazz.setParentNode(parentClass)
    parentClass.addMember(clazz)
    return clazz
}

/**
 * Create a new Java enumeration named [enumName] in the package with the given [packageName]. The result is an
 * AST node of type [EnumDeclaration] that also comprises a [CompilationUnit] instance holding the [packageName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun newEnum(packageName: String, enumName: String) : EnumDeclaration {
    val compilationUnit = CompilationUnit(packageName)
    val enum = EnumDeclaration()
    enum.addModifier(Modifier.Keyword.PUBLIC)
    enum.setName(enumName)
    enum.setParentNode(compilationUnit)
    compilationUnit.addType(enum)
    return enum
}

/**
 * Get the name of a [CompilationUnit] instance's package declaration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun CompilationUnit.getPackageName() = packageDeclaration.get().name.asString()

/**
 * Get the name of a [ClassOrInterfaceDeclaration] instance's package declaration. This assumes that the instance is
 * bundled within a [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.getPackageName() = findParentNode<CompilationUnit>()!!.getPackageName()

/**
 * Set the package name of a [ClassOrInterfaceDeclaration]. This assumes that the instance is bundled within a
 * [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.setPackageName(packageName: String)
    = findParentNode<CompilationUnit>()!!.setPackageDeclaration(packageName)

/**
 * Add an import statement to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The
 * import will not be added by default, if it already exists. This function should only be invoked on
 * [ClassOrInterfaceDeclaration] instances created via [newJavaClassOrInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addImport(import: String, targetElementType: ImportTargetElementType,
    vararg characteristics: SerializationCharacteristic) {
    // Independent of whether the import exists on the class/interface or not it will be added to the "invisible" data
    // of the class's/interface's AST node. That is, to allow functions like getAllImportsForTargetElementsOfType() to
    // retrieve import information even if it is not "visible" in the class/interface.
    val targetNodeForImports = if (isNestedType) findParentNode()!! else this
    targetNodeForImports.addImportsInfo(import, targetElementType, *characteristics)

    val compilationUnit = findParentNode<CompilationUnit>()!!
    val existingFullQualifierImports = compilationUnit.imports.map { it.name.asString() }
    val alreadyImported = import in existingFullQualifierImports
    val importSimpleName = import.substringAfterLast(".")
    val existingSimpleNameImports = existingFullQualifierImports.map { it.substringAfterLast(".") }
    val ambiguousImport = !alreadyImported && importSimpleName in existingSimpleNameImports

    // Note that we accept the possible existence of unnecessary imports when the class and the imported element reside
    // in the same package. That is because we cannot decide upfront whether an element from the same package will be
    // imported. If we would however prevent unnecessary imports, then it may happen that an element with the same
    // simple name (i.e., an ambiguously imported element) would be imported *after* the occurrence of the element
    // import from the same package, thereby effectively overriding references to the element from the same package.
    if (ambiguousImport)
        throw AmbiguousImportException(importSimpleName, this)
    else if (!alreadyImported)
        compilationUnit.addImport(import)
}

/**
 * Exception to communicate an ambiguous import to callers of [addImport].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class AmbiguousImportException(importSimpleName: String, importingClass: ClassOrInterfaceDeclaration)
    : Exception("An element with simple name $importSimpleName is already imported by class " +
        importingClass.fullyQualifiedName.get())

/**
 * Convenience function to add a list of [imports] to this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addImports(imports: List<SingleImportInfo>) {
    imports.forEach { addImport(it.import, it.targetElementType, *it.characteristics) }
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
 * Set the superclass that is extended by this [ClassOrInterfaceDeclaration]. Note that this only works for classes.
 * When invoked on an interface this will throw an [IllegalArgumentException].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.setSuperclass(superClassname: String, isExternalSuperclass: Boolean = false,
    typeParameters: List<String> = emptyList()) {
    require(!isInterface) { "Only classes may have a superclass" }

    // Because Java only supports single inheritance on classes, clear the list of extended types
    extendedTypes.clear()

    if (!isExternalSuperclass)
        addImport(superClassname, ImportTargetElementType.SUPER)

    var extendedTypeName = superClassname.substringAfterLast(".")
    if (typeParameters.isNotEmpty())
        extendedTypeName = "$extendedTypeName<${typeParameters.joinToString()}>"
    addExtendedType(extendedTypeName)
    setData(SuperclassDataKey, SuperclassInfo(superClassname, isExternalSuperclass, typeParameters,
        extendedTypes.last()))
}

/**
 * Get the fully-qualified name of this [ClassOrInterfaceDeclaration] instance's superclass.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getSuperclass() : SuperclassInfo? {
    return if (containsData(SuperclassDataKey))
            getData(SuperclassDataKey)
        else
            null
}

/**
 * Information about a superclass of a [ClassOrInterfaceDeclaration] being stored in [SuperclassDataKey] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class SuperclassInfo(val fullyQualifiedClassname: String, val isExternal: Boolean,
    val typeParameters: List<String>, val superclassType: ClassOrInterfaceType)

/**
 * Data key for [ClassOrInterfaceDeclaration] instances' superclasses.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object SuperclassDataKey : DataKey<SuperclassInfo>()

/**
 * Add an attribute with an optional [initializer] value to the Java class/interface represented by a
 * [ClassOrInterfaceDeclaration] instance. The created attribute is an AST node of type [FieldDeclaration] and will be
 * returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword, initializer: String? = null) : FieldDeclaration {
    val attributeField = addField(typeName, attributeName, *modifiers)
    if (initializer != null)
        attributeField.setInitializationValue(initializer)
    return attributeField
}

/**
 * Add an attribute with the given intermediate [type] to this class, and add type-specific imports to the
 * [importsTargetNode] leveraging the [addImportToTargetNode] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <P: Node> ClassOrInterfaceDeclaration.addAttribute(attributeName: String, type: IntermediateType,
    importsTargetNode: P, vararg modifiers: Modifier.Keyword, initializer: String? = null,
    addImportToTargetNode: P.(String) -> Unit) : FieldDeclaration {
    val attributeField = addField("TODO", attributeName, *modifiers)
    attributeField.variables[0].setJavaTypeFrom(type, importsTargetNode, addImportToTargetNode)

    if (initializer != null)
        attributeField.setInitializationValue(initializer)

    return attributeField
}

/**
 * Get all attributes of this [ClassOrInterfaceDeclaration] instance. The result is a [VariableDeclarator] list that
 * contains the first variable of each of this class's fields, which conforms to what [addAttribute] results in (a
 * [FieldDeclaration] with a single variable, i.e., the actual "attribute").
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val ClassOrInterfaceDeclaration.attributes
    get() = fields.map { it.variables[0] }

/**
 * Add a private attribute with an optional [initializer] value to the Java class/interface represented by a
 * [ClassOrInterfaceDeclaration] instance. The created attribute is an AST node of type [FieldDeclaration] with the
 * modifier [Modifier.Keyword.PRIVATE] and will be returned to the caller. An additional [Modifier] list may be passed
 * to the function to add further modifiers to the attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addPrivateAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword, initializer: String? = null)
        = addAttribute(attributeName, typeName, Modifier.Keyword.PRIVATE, *modifiers, initializer = initializer)

/**
 * Add a private attribute with the given intermediate [type] to this class, and add type-specific imports to the
 * [importsTargetNode] leveraging the [addImportToTargetNode] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <P: Node> ClassOrInterfaceDeclaration.addPrivateAttribute(attributeName: String, type: IntermediateType,
    importsTargetNode: P, vararg modifiers: Modifier.Keyword, initializer: String? = null,
    addImportToTargetNode: P.(String) -> Unit)
        = addAttribute(attributeName, type, importsTargetNode, Modifier.Keyword.PRIVATE, *modifiers,
            initializer = initializer, addImportToTargetNode = addImportToTargetNode)

/**
 * Add a constructor for initializing all attributes of the given [ClassOrInterfaceDeclaration] instance at once.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addAllAttributesConstructor(
    modifier: Modifier.Keyword = Modifier.Keyword.PUBLIC
) : ConstructorDeclaration? {
    val mutableAttributes = attributes.filter { !(it.parentNode.get() as FieldDeclaration).isFinal }
    if (mutableAttributes.isEmpty())
        return null

    val constructor = addConstructor(modifier)
    val constructorBody = mutableListOf<String>()
    mutableAttributes.forEach {
        val parameter = Parameter()
        parameter.setType(it.typeAsString)
        parameter.setName(it.nameAsString)
        constructor.addParameter(parameter)
        constructorBody.add("""this.${it.nameAsString} = ${it.nameAsString};""")
    }
    constructor.setBody(*constructorBody.toTypedArray())
    return constructor
}

/**
 * Enumeration to distinguish generated property accessors (i.e., getters and setters created by [addGetter] and
 * [addSetter], respectively) from "normal" methods.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private enum class GeneratedPropertyAccessorType {
    GETTER,
    SETTER
}

/**
 * Data key for [MethodDeclaration] instances created by [addGetter]/[addSetter] that clusters a
 * [GeneratedPropertyAccessorTypeDataKey].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object GeneratedPropertyAccessorTypeDataKey : DataKey<GeneratedPropertyAccessorType>()

/**
 * Add a getter to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The created getter
 * is an AST node of type [MethodDeclaration]. It will be returned to the caller, together with the name of its backing
 * attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addGetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
    val getter = attribute.createGetter()
    getter.setParentNode(this)
    getter.setData(GeneratedPropertyAccessorTypeDataKey, GeneratedPropertyAccessorType.GETTER)
    val returnStatement = getter.body.get().statements[0] as ReturnStmt
    val fieldName = (returnStatement.expression.get() as NameExpr).nameAsString
    return fieldName to getter
}

/**
 * Add a setter to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The created setter
 * is an AST node of type [MethodDeclaration]. It will be returned to the caller, together with the name of its backing
 * attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addSetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
    val setter = attribute.createSetter()
    setter.setParentNode(this)
    setter.setData(GeneratedPropertyAccessorTypeDataKey, GeneratedPropertyAccessorType.SETTER)
    val assignExpression = (setter.body.get().statements[0] as ExpressionStmt).expression as AssignExpr
    val fieldName = (assignExpression.value as NameExpr).nameAsString
    return fieldName to setter
}

/**
 * Add a getter for an inherited attribute of the Java class/interface represented by a [ClassOrInterfaceDeclaration]
 * instance. The created getter is an AST node of type [MethodDeclaration] and will be returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addGetterForInheritedAttribute(attributeName: String, typeName: String)
    : MethodDeclaration {
    // For consistency, we rely on the getter creation process of JavaParser. Therefore, we create a "fake" getter
    // producer attribute to the current class/interface, leverage it to create the getter, and then remove it again.
    val getterProducer = addPrivateAttribute(attributeName, typeName)

    val getter = getterProducer.createGetter()
    getter.setParentNode(this)

    getterProducer.setParentNode(null)
    members.remove(getterProducer)

    return getter
}

/**
 * Property for [ClassOrInterfaceDeclaration] that returns all methods of the class/interface exlcuding property
 * accessors generated by [addGetter]/[addSetter].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ClassOrInterfaceDeclaration.methodsExcludingPropertyAccessors
    get() = methods.filter { !it.isGeneratedPropertyAccessor }

/**
 * Get the name of an [EnumDeclaration] instance's package declaration. This assumes that the instance is bundled within
 * a [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EnumDeclaration.getPackageName() = findParentNode<CompilationUnit>()!!.getPackageName()

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
 * Set the initialization value of a class's attribute being created by [addAttribute] or its wrappers, e.g.,
 * [addPrivateAttribute].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun FieldDeclaration.setInitializationValue(value: String) = variables[0].setInitializer(value)

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
 * Convenience method to add a thrown Exception class represented by a String name to this method's signature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.addThrownException(exceptionClassName: String)
    = addThrownException(StaticJavaParser.parseClassOrInterfaceType(exceptionClassName))

/**
 * Set the implementation body of a Java method. The implementation body is provided in the form of plain Java code.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.setBody(code: String, withLineComment: String = "", withBlockComment: String = "",
    vararg characteristics: SerializationCharacteristic) {
    val (existingBodyComments, existingStatementsComments) = getAndRemoveComments()
    val existingComments = existingBodyComments.toMutableList()
    existingComments.addAll(existingStatementsComments)

    val newBody = BlockStmt()
    newBody.addSerializationCharacteristics(characteristics)

    val bodyStatement = newBody.addAndGetStatement(code)
    setBody(newBody)

    when {
        withLineComment.isNotEmpty() -> bodyStatement.addComments(existingComments, LineComment(withLineComment))
        withBlockComment.isNotEmpty() -> bodyStatement.addComments(existingComments, BlockComment(withBlockComment))
        else -> bodyStatement.addComments(existingComments)
    }
}

/**
 * Get all comments of this [MethodDeclaration] and remove them in parallel.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MethodDeclaration.getAndRemoveComments() : Pair<List<Comment>, List<Comment>> {
    val actualBody = body.orElse(null) ?: return emptyList<Comment>() to emptyList()

    // Collect and remove body comment
    val collectedBodyComments = mutableListOf<Comment>()
    if (actualBody.comment.isPresent) {
        collectedBodyComments.add(actualBody.comment.get())
        actualBody.removeComment()
    }

    // Collect and remove orphan comments from the body
    actualBody.orphanComments.forEach {
        collectedBodyComments.add(it)
        actualBody.removeOrphanComment(it)
    }

    // Collect and remove, possibly nested statements' comments and orphan comments
    val collectedStatementsComments = mutableListOf<Comment>()
    actualBody.statements.forEach { statement ->
        if (statement.comment.isPresent) {
            collectedStatementsComments.add(statement.comment.get())
            statement.removeComment()
        }

        collectedStatementsComments.addAll(statement.allContainedComments)
        statement.allContainedComments.forEach { statement.removeOrphanComment(it) }
    }

    return collectedBodyComments to collectedStatementsComments
}

/**
 * Add comments to this [ExpressionStmt]. The [additionalComments] are appended to the list of [comments]. Note that in
 * any case [createCompositeComment] will be called with all given [Comment] instances and that the resulting composite
 * [Comment] will be added to the [ExpressionStmt].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ExpressionStmt.addComments(comments: List<Comment>, vararg additionalComments: Comment) {
    if (comments.isEmpty() && additionalComments.isEmpty())
        return

    val commentsToAdd = comments.toMutableList()
    commentsToAdd.addAll(additionalComments)
    val compositeComment = createCompositeComment(commentsToAdd) ?: return
    setComment(compositeComment)
}

/**
 * Create a composite [Comment] from the given list of [comments] or null, if the list is empty. A composite [Comment]
 * comprises all passed comments' contents. If there is more than one passed comment, a new [BlockComment] will be
 * created that holds the contents of all passed [comments] separated by a linebreak.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun createCompositeComment(comments: List<Comment>) : Comment? {
    return when {
        comments.isEmpty() -> null
        comments.size == 1 -> return comments[0]
        else -> BlockComment(comments.joinToString("\n") { it.content })
    }
}

/**
 * Add the given [comment] as an orphan comment to the body of this [MethodDeclaration]. In case the [MethodDeclaration]
 * does not have a body yet, an empty [BlockStmt] for the comment will be created and assigned as its body.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.addBodyComment(comment: Comment) {
    var currentBody = body.orElse(null)

    if (currentBody == null) {
        currentBody = BlockStmt()
        setBody(currentBody)
    }

    currentBody.addOrphanComment(comment)
}

/**
 * Insert statements of a [BlockStmt] into the body of this [MethodDeclaration]. The statements will be inserted prior
 * to any other possibly existing statements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.insertBody(otherBody: BlockStmt,
    adaptStatementBeforeInsertion: ((Statement) -> Statement)? = null) {

    val statementsToInsert = if (adaptStatementBeforeInsertion != null)
            otherBody.statements.map { adaptStatementBeforeInsertion.invoke(it) }
        else
            otherBody.statements

    if (emptyBody)
        setBody(BlockStmt())

    body.get().statements.addAll(0, statementsToInsert)
}

/**
 * Append the statements represented by the lines of the passed [body] to the body of this [MethodDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.addStatements(body: String) = body.lines().forEach { appendStatement(it) }

/**
 * Append an implementation statement to a Java method's implementation body.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.appendStatement(statement: String)
    = insertStatement(statement, body.orElse(null)?.statements?.count() ?: 0)

/**
 * Insert an implementation statement at a specified [index] in a Java method's implementation body. The statement is
 * provided in the form of plain Java [code]. If the [index] is greater than the current amount of statements in the
 * method's implementation body, the statement's [code] is appended as the last statement to the body.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.insertStatement(code: String, index: Int = 0) {
    require(code.isNotEmpty()) { "Code statement to insert must not be empty" }

    if (emptyBody) {
        // FIXME: Currently, there is an inconsistency between setBody() and insertStatement() concerning the completion
        //        of passed code/statements. setBody() expects its code to not be terminated by a semicolon, while
        //        insertStatement() expects statements to be terminated by semicolons. The behavior of both methods
        //        should be streamlined regarding code/statements termination.
        setBody(code.removeSuffix(";"))
        return
    }

    require(index >= 0) { "Invalid index for insertion of statement into method $name" }

    val currentBody = body.orElse(null)
    val statements = currentBody!!.statements
    val newStatement = try {
            StaticJavaParser.parseStatement(code)
        } catch (ex: ParseProblemException) {
            throw IllegalArgumentException("Error while trying to parse Java statement $code", ex)
        }

    if (index <= statements.size)
        statements.add(index, newStatement)
    else
        statements.add(newStatement)

    currentBody.statements = statements
}

/**
 * Helper to check if a [MethodDeclaration] is a property accessor generated by [addGetter]/[addSetter].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.isGeneratedPropertyAccessor
    get() = containsData(GeneratedPropertyAccessorTypeDataKey)

/**
 * Convenience function to retrieve the parameter with the specified [name] from this [MethodDeclaration]. Returns null
 * in case the parameter does not exist.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.getParameter(name: String) = parameters.find { it.nameAsString == name }

/**
 * Check if this [MethodDeclaration] has an empty body.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.emptyBody
    get() = body.orElse(null)?.statements?.isEmpty() ?: true

/**
 * Check if this [MethodDeclaration] is overridable.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.isOverridable
    get() = !isPrivate && !isStatic && "Override" !in annotations.map { it.nameAsString }

/**
 * Check if this [MethodDeclaration] has a return statement.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.hasReturnStatement
    get() = naiveHasStatementCheck("return")

/**
 * Naive implementation of a statement checker for method bodies. It splits the given [MethodDeclaration] body's
 * statements into several lines and checks if at least one line starts with [statementPrefix].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MethodDeclaration.naiveHasStatementCheck(statementPrefix: String)
    = body.orElse(null)?.statements
        ?.map { it.toString().split("\n") }
        ?.flatten()
        ?.any { it.trim().startsWith(statementPrefix) }
        ?: false

/**
 * Check if this [MethodDeclaration] has a throw statement.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.hasThrowStatement
    get() = naiveHasStatementCheck("throw")

/**
 * Copy this [MethodDeclaration] to a new [MethodDeclaration] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.copy() : MethodDeclaration {
    val copyModifiers = NodeList(modifiers.map { it.copy() })
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    val copyTypeParameters = NodeList(typeParameters.map { it.copy() })
    val copyParameters = NodeList(parameters.map { it.copy() })
    val copyThrownExpressions = NodeList(thrownExceptions.map { it.copy() })

    // TODO Do a real copy of the body.get() result
    val copyBody = if (!emptyBody) body.get() else BlockStmt()

    // TODO Copy type
    // TODO Copy receiverParameter
    return MethodDeclaration(copyModifiers, copyAnnotations, copyTypeParameters, type, name, copyParameters,
        copyThrownExpressions, copyBody, receiverParameter?.orElse(null))
}

/**
 * Copy this [Modifier] to a new [Modifier] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Modifier.copy() = Modifier(keyword)

/**
 * Copy this [AnnotationExpr] to a new [AnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun AnnotationExpr.copy()
    = when(this) {
        is NormalAnnotationExpr -> copy()
        is MarkerAnnotationExpr -> copy()
        else -> throw IllegalArgumentException("Copying of ${javaClass.simpleName} is not supported")
    }

/**
 * Copy this [NormalAnnotationExpr] to a new [NormalAnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun NormalAnnotationExpr.copy() : NormalAnnotationExpr {
    val copyName = StaticJavaParser.parseName(nameAsString)
    val copyPairs = NodeList(pairs.map { MemberValuePair(it.nameAsString, NameExpr(it.value.toString())) })
    return NormalAnnotationExpr(copyName, copyPairs)
}

/**
 * Copy this [MarkerAnnotationExpr] to a new [MarkerAnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MarkerAnnotationExpr.copy() : MarkerAnnotationExpr {
    val copyName = StaticJavaParser.parseName(nameAsString)
    return MarkerAnnotationExpr(copyName)
}

/**
 * Copy this [TypeParameter] to a new [TypeParameter] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun TypeParameter.copy() : TypeParameter {
    val copyName = SimpleName(nameAsString)
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    // TODO Copy typeBound
    return TypeParameter(copyName, NodeList(), copyAnnotations)
}

/**
 * Copy this [Parameter] to a new [Parameter] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Parameter.copy() : Parameter {
    val copyModifiers = NodeList(modifiers.map { it.copy() })
    val copyName = SimpleName(nameAsString)
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    val copyVarArgAnnotations = NodeList(varArgsAnnotations.map { it.copy() })
    // TODO Copy type
    return Parameter(copyModifiers, copyAnnotations, type, isVarArgs, copyVarArgAnnotations, copyName)
}

/**
 * Copy this [ReferenceType] to a new [ReferenceType] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ReferenceType.copy() : ReferenceType {
    return StaticJavaParser.parseClassOrInterfaceType(toString())
}

/**
 * Copy the signature of this [MethodDeclaration] to a new [MethodDeclaration] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.copySignature() : MethodDeclaration {
    val signatureMethod = MethodDeclaration()
    signatureMethod.setName(nameAsString)
    signatureMethod.removeBody()
    signatureMethod.type = type

    parameters.forEach {
        val signatureParameter = Parameter()
        signatureParameter.setType(it.typeAsString)
        signatureParameter.setName(it.nameAsString)
        signatureMethod.addParameter(signatureParameter)
    }

    thrownExceptions.forEach {
        signatureMethod.addThrownException(StaticJavaParser.parseClassOrInterfaceType(it.toString()))
    }

    return signatureMethod
}

/**
 * Replace the given list of parameters in the signature of this method with a composite [Parameter] of the specified
 * [type] and [name].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.addCompositeParameter(type: String, name: String, communicationType: CommunicationType,
    replacedParameters: List<Parameter>) : Parameter {
    replacedParameters.forEach { remove(it) }
    val compositeParameter = addAndGetParameter(type, name)
    compositeParameter.markAsCompositeParameterFor(communicationType, replacedParameters)
    return compositeParameter
}

/**
 * Create a delegating constructor from this [ConstructorDeclaration]. The result will be a new [ConstructorDeclaration]
 * instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ConstructorDeclaration.createDelegatingConstructor(name: String) : ConstructorDeclaration {
    val delegatingConstructor = ConstructorDeclaration()
    delegatingConstructor.setName(name)
    delegatingConstructor.modifiers = modifiers

    // Copy parameters
    val parameterNames = mutableListOf<String>()
    parameters.forEach {
        val copyParameter = Parameter()
        copyParameter.setType(it.typeAsString)
        copyParameter.setName(it.nameAsString)
        delegatingConstructor.addParameter(copyParameter)

        parameterNames.add(it.nameAsString)
    }

    // Add delegating body
    delegatingConstructor.setBody("""super(${parameterNames.joinToString()});""")

    return delegatingConstructor
}

/**
 * Set the implementation body of a Java constructor. The implementation body is provided in the form of plain Java code
 * statements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ConstructorDeclaration.setBody(vararg rawStatements: String, firstStatementWithLineComment: String = "",
    firstStatementWithBlockComment: String = "") {
    val bodyStatements = BlockStmt()
    rawStatements.forEach { bodyStatements.addStatement(it) }
    body = bodyStatements

    val comment = if (body.statements.isNotEmpty())
            when {
                firstStatementWithLineComment.isNotEmpty() -> LineComment(firstStatementWithLineComment)
                firstStatementWithBlockComment.isNotEmpty() -> BlockComment(firstStatementWithBlockComment)
                else -> null
            }
        else
            null

    if (comment != null)
        body.statements[0].setComment(comment)
}

/**
 * Insert an implementation statement at a specified [index] in a Java constructor's implementation body. The statement
 * is provided in the form of plain Java [code]. If the [index] is greater than the current amount of statements in the
 * constructor's implementation body, the statement's [code] is appended as the last statement to the body.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ConstructorDeclaration.insertStatement(code: String, index: Int = 0) {
    require(code.isNotEmpty()) { "Code statement to insert must not be empty" }

    if (body.isEmpty) {
        setBody(code)
        return
    }

    require(index >= 0) { "Invalid index for insertion of statement into constructor $name" }

    val statements = body.statements
    val newStatement = StaticJavaParser.parseStatement(code)
    if (index <= statements.size)
        statements.add(index, newStatement)
    else
        statements.add(newStatement)

    body.statements = statements
}

/**
 * Mark this [Parameter] as being a composite parameter that replaced the previously existing list of
 * [replacedParameters] in its defining method.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Parameter.markAsCompositeParameterFor(communicationType: CommunicationType,
    replacedParameters: List<Parameter>)
        = setData(CompositeParameterDataKey, communicationType to replacedParameters.map { it.nameAsString })

/**
 * Data key for composite parameters of generated methods.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object CompositeParameterDataKey : DataKey<Pair<CommunicationType, List<String>>>()

/**
 * Verify if this [Parameter] is a composite [Parameter] for the given [communicationType]. If no [communicationType] is
 * passed, this function returns true when the [Parameter] exhibits the [CompositeParameterDataKey], independent of its
 * assigned communication type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Parameter.isCompositeParameter(communicationType: CommunicationType? = null) : Boolean {
    if (!containsData(CompositeParameterDataKey))
        return false
    else if (communicationType == null)
        return true

    val (parameterCommunicationType, _) = getData(CompositeParameterDataKey)
    return parameterCommunicationType == communicationType
}

/**
 * Get all composite parameters of this [MethodDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.getCompositeParameters(communicationType: CommunicationType? = null)
    = parameters.filter {
        it.isCompositeParameter() &&
        (communicationType == null || it.getData(CompositeParameterDataKey).first == communicationType)
    }

/**
 * Get a map that assigns to each replaced parameter of this [MethodDeclaration] the name of the composite parameter by
 * which it was replaced.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.getParametersToCompositeParameters(communicationType: CommunicationType? = null)
    : Map<String, String> {
    val compositeParameters = getCompositeParameters(communicationType)
    if (compositeParameters.isEmpty())
        return emptyMap()

    val resultMap = mutableMapOf<String, String>()
    compositeParameters.forEach { compositeParameter ->
        compositeParameter.getReplacedParameterNames().forEach { resultMap[it] = compositeParameter.nameAsString }
    }

    return resultMap
}

/**
 * If this [Parameter] is a composite parameter, retrieve a list of the names of the parameters it replaced. Returns an
 * empty list in case this [Parameter] is not a composite parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Parameter.getReplacedParameterNames()
    = if (isCompositeParameter())
            getData(CompositeParameterDataKey).second
        else
            emptyList()