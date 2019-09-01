package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.ast.comments.LineComment
import com.github.javaparser.ast.expr.AssignExpr
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.ReturnStmt
import com.github.javaparser.printer.PrettyPrinter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType.ANNOTATION
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType.METHOD
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import java.io.File
import java.lang.Exception
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import java.lang.IllegalArgumentException

/**
 * Helper to get a [ClassOrInterfaceDeclaration] that has the same name as this [File] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun File.getEponymousJavaClassOrInterface()
    = try {
        val parsedCompilationUnit = StaticJavaParser.parse(this)
        parsedCompilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java) {
            it.nameAsString == nameWithoutExtension
        }.orElseGet { null }
    } catch (ex: Exception) {
        null
    }

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
 * Enumeration to distinguish the various types of Java code elements that may be targeted by a certain import. For
 * instance, an import may be necessary because a [METHOD] parameter is typed by a class provided by the import. Another
 * example is an [ANNOTATION] provided by a framework dependency.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class ImportTargetElementType {
    ANNOTATION,
    FIELD,
    IMPLEMENTED_INTERFACE,
    METHOD,
    SUPER
}

/**
 * Represents information about an import that has been added to an AST [Node]. Effectively, this is a [HashMap], which
 * associates an import with a set of [ImportTargetElementType] instances. It is encapsulated in its own type, because
 * JavaParser's Data API distinguishes data keys by the types of the data elements (cf. [ImportInfoDataKey]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ImportInfo() : HashMap<String, MutableSet<ImportTargetElementType>>() {
    /**
     * Constructor to initialize the import map with a single import
     */
    constructor(initialImport: String, initialImportTargetElementType: ImportTargetElementType) : this() {
        this[initialImport] = mutableSetOf(initialImportTargetElementType)
    }

    /**
     * Add an additional import to this instance
     */
    fun addImport(import: String, targetElementType: ImportTargetElementType) {
        if (containsKey(import))
            this[import]!!.add(targetElementType)
        else
            this[import] = mutableSetOf(targetElementType)
    }
}

/**
 * Data key for AST [Node] instances that clusters an [ImportInfo].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object ImportInfoDataKey : DataKey<ImportInfo>()

/**
 * Add an [import] together with its [targetElementType] to the data of an AST [Node] in the form of an [ImportInfo]
 * instance. This enables to track down for which [Node] and its elements a certain [import] was added.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.addToNodeImports(import: String, targetElementType: ImportTargetElementType) {
    if (!containsData(ImportInfoDataKey))
        setData(ImportInfoDataKey, ImportInfo(import, targetElementType))
    else {
        val existingImportInfo = getData(ImportInfoDataKey)
        existingImportInfo.addImport(import, targetElementType)
        setData(ImportInfoDataKey, existingImportInfo)
    }
}

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
 * Helper to retrieve the [ClassOrInterfaceDeclaration] from a [Node]. This only returns classes, not interfaces.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.getClassDeclaration() : ClassOrInterfaceDeclaration?
    = when(this) {
        is CompilationUnit -> findFirst(ClassOrInterfaceDeclaration::class.java) { !it.isInterface }.orElseGet { null }
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
        is ClassOrInterfaceDeclaration -> this.parentNode.get() as CompilationUnit
        else -> throw IllegalArgumentException("Serialization of nodes of type ${this::class.java.name} is not" +
            "supported")
    }

    val prettyPrinter = PrettyPrinter(serializationConfiguration)
    return prettyPrinter.print(compilationUnit)
}

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
internal fun newJavaClassOrInterface(packageName: String, classname: String, isInterface: Boolean = false)
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
 * Get the name of a [CompilationUnit] instance's package declaration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun CompilationUnit.getPackageName() = packageDeclaration.get().name.asString()

/**
 * Get the name of a [ClassOrInterfaceDeclaration] instance's package declaration. This assumes that the instance is
 * bundled within a [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getPackageName() = (parentNode.get() as CompilationUnit).getPackageName()

/**
 * Set the package name of a [ClassOrInterfaceDeclaration]. This assumes that the instance is bundled within a
 * [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.setPackageName(packageName: String)
    = (parentNode.get() as CompilationUnit).setPackageDeclaration(packageName)

/**
 * Add an import statement to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The
 * import will not be added by default, if it already exists. This function should only be invoked on
 * [ClassOrInterfaceDeclaration] instances created via [newJavaClassOrInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addImport(import: String, targetElementType : ImportTargetElementType,
    onlyAddActualIfDifferentPackage: Boolean = true) {
    // Independent of whether the import exists on the class/interface or not it will be added to the "invisible" data
    // of the class's/interface's AST node. That is, to allow functions like getAllImportsForTargetElementsOfType() to
    // retrieve import information even if it is not "visible" in the class/interface.
    addToNodeImports(import, targetElementType)

    val compilationUnit = parentNode.get() as CompilationUnit
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
 * Get all imports of a class/interface for a given [targetElementType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getAllImportsForTargetElementsOfType
    (targetElementType : ImportTargetElementType) : Set<String> {
    return if (containsData(ImportInfoDataKey))
        getData(ImportInfoDataKey).filter { (import, targetElementTypes) ->
            targetElementType in targetElementTypes
        }.keys
    else
        emptySet()
}

/**
 * Set the superclass that is extended by this [ClassOrInterfaceDeclaration]. Note that this only works for classes.
 * When invoked on an interface this will throw an [IllegalArgumentException].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.setSuperclass(fullyQualifiedSuperClassname: String) {
    // Because Java only supports single inheritance on classes, clear the list of extended types
    require(!isInterface) { "Only classes may have a superclass" }

    val simpleName = fullyQualifiedSuperClassname.substringAfterLast(".")
    addExtendedType(simpleName)
    addImport(fullyQualifiedSuperClassname, ImportTargetElementType.SUPER)
    setData(SuperclassDataKey, fullyQualifiedSuperClassname)
}

/**
 * Get the fully-qualified name of this [ClassOrInterfaceDeclaration] instance's superclass.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.getSuperclass() : String? {
    return if (containsData(SuperclassDataKey))
            getData(SuperclassDataKey)
        else
            null
}

/**
 * Data key for [ClassOrInterfaceDeclaration] instances' superclasses.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object SuperclassDataKey : DataKey<String>()

/**
 * Add an attribute to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The created
 * attribute is an AST node of type [FieldDeclaration] and will be returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword) : FieldDeclaration {
    return addField(typeName, attributeName, *modifiers)
}

/**
 * Add a private attribute to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The
 * created attribute is an AST node of type [FieldDeclaration] with the modifier [Modifier.Keyword.PRIVATE] and will be
 * returned to the caller. An additional [Modifier] list may be passed to the function to add further modifiers to the
 * attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addPrivateAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword) = addAttribute(attributeName, typeName, Modifier.Keyword.PRIVATE, *modifiers)

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
internal fun ClassOrInterfaceDeclaration.addGetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
    val getter = attribute.createGetter()
    getter.setParentNode(this)
    getter.setData(GeneratedPropertyAccessorTypeDataKey, GeneratedPropertyAccessorType.GETTER)
    val returnStatement = getter.body.get().statements[0] as ReturnStmt
    val fieldName = (returnStatement.expression.get() as NameExpr).nameAsString
    return fieldName to getter
}

/**
 * Add a setter to the Java class/interface represented by a [ClassOrInterfaceDeclaration] instance. The created getter
 * is an AST node of type [MethodDeclaration]. It will be returned to the caller, together with the name of its backing
 * attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addSetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
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
    addToNodeImports(import, targetElementType)
    (parentNode.get() as ClassOrInterfaceDeclaration).addImport(import, targetElementType)
}

/**
 * Convenience method in the context of a Java method, which enables to add an import to its defining class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.addImport(import: String, targetElementType: ImportTargetElementType)  {
    addToNodeImports(import, targetElementType)
    (parentNode.get() as ClassOrInterfaceDeclaration).addImport(import, targetElementType)
}

/**
 * Helper to copy this [MethodDeclaration] to the given [target] [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.copyTo(target: ClassOrInterfaceDeclaration) {
    val copiedMethod = target.addMethod(name.asString())
    copiedMethod.modifiers = modifiers

    parameters.forEach {
        val parameter = Parameter()
        parameter.setType(it.typeAsString)
        parameter.setName(it.nameAsString)
        copiedMethod.addParameter(parameter)
    }

    copiedMethod.setBody(body.toString())
}

/**
 * Set the implementation body of a Java method. The implementation body is provided in the form of plain Java code.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.setBody(code: String, withLineComment: String = "", withBlockComment: String = "") {
    val statement = BlockStmt()
    statement.addStatement(code)
    setBody(statement)

    val newBody = body.get()
    val comment = if (newBody.statements.isNotEmpty())
        when {
            withLineComment.isNotEmpty() -> LineComment(withLineComment)
            withBlockComment.isNotEmpty() -> BlockComment(withBlockComment)
            else -> null
        }
    else
        null

    if (comment !== null)
        newBody.statements[0].setComment(comment)
}

/**
 * Helper to copy this [ConstructorDeclaration] to the given [target] [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ConstructorDeclaration.copyTo(target: ClassOrInterfaceDeclaration) {
    val copiedConstructor = target.addConstructor()
    copiedConstructor.modifiers = modifiers

    parameters.forEach {
        val parameter = Parameter()
        parameter.setType(it.typeAsString)
        parameter.setName(it.nameAsString)
        copiedConstructor.addParameter(parameter)
    }

    copiedConstructor.body = body
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

    if (comment !== null)
        body.statements[0].setComment(comment)
}

/**
 * Insert an implementation statement at a specified index in a Java method's implementation body. The statement is
 * provided in the form of plain Java code.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.insertStatement(code: String, index: Int = 0) {
    if (!body.isPresent) {
        setBody(code)
        return
    }

    val body = body.get()
    val statements = body.statements
    if (index !in 0 until statements.size)
        throw IllegalArgumentException("Invalid index for insertion of statement into method $name")

    val newStatement = StaticJavaParser.parseStatement(code)
    statements.add(index, newStatement)
    body.statements = statements
}

/**
 * Helper to check if a [MethodDeclaration] is a property accessort generated by [addGetter]/[addSetter].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.isGeneratedPropertyAccessor
    get() = containsData(GeneratedPropertyAccessorTypeDataKey)