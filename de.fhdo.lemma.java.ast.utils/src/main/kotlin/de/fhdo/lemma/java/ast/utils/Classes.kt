@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.NodeList
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.body.VariableDeclarator
import com.github.javaparser.ast.expr.AssignExpr
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.SimpleName
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.ReturnStmt
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.Type
import com.github.javaparser.ast.type.TypeParameter
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Helper to get a [ClassOrInterfaceDeclaration] that has the same name as this [File] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun File.getEponymousJavaClassOrInterface()
    = try {
        val parsedCompilationUnit = StaticJavaParser.parse(this)
        parsedCompilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java) {
            it.nameAsString == nameWithoutExtension
        }.orElse(null)
    } catch (ex: Exception) {
        null
    }

/**
 * Helper to retrieve the [ClassOrInterfaceDeclaration] from a [Node]. This only returns classes, not interfaces.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.asClassOrInterfaceDeclaration() : ClassOrInterfaceDeclaration?
    = when(this) {
        is CompilationUnit -> findFirst(ClassOrInterfaceDeclaration::class.java) { !it.isInterface }.orElse(null)
        is ClassOrInterfaceDeclaration -> this
        else -> null
    }

/**
 * Get associated file path of this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.getFilePath() : String? {
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
fun newInnerJavaClass(classname: String, parentClass: ClassOrInterfaceDeclaration, isStatic: Boolean = false)
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
fun ClassOrInterfaceDeclaration.setPackageName(packageName: String)
    = findParentNode<CompilationUnit>()!!.setPackageDeclaration(packageName)

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

    val importStillExistsInClass = getImportsInfo<ImportsInfo<SingleImportInfo>>()?.any { it.import == import }
    if (importStillExistsInClass!!)
        return

    val compilationUnit = findParentNode<CompilationUnit>()!!
    val importInUnit = compilationUnit.imports.find { it.nameAsString == import }
    if (importInUnit !== null)
        compilationUnit.imports.remove(importInUnit)
}

/**
 * Add an attribute with an optional [initializer] value to the Java class/interface represented by a
 * [ClassOrInterfaceDeclaration] instance. The created attribute is an AST node of type [FieldDeclaration] and will be
 * returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword, initializer: String? = null) : FieldDeclaration {
    val attributeField = addField(typeName, attributeName, *modifiers)
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
 * Add a constructor for initializing all attributes of the given [ClassOrInterfaceDeclaration] instance at once.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addAllAttributesConstructor(
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
internal enum class GeneratedPropertyAccessorType {
    GETTER,
    SETTER
}

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
 * Data key for [MethodDeclaration] instances created by [addGetter]/[addSetter] that clusters a
 * [GeneratedPropertyAccessorTypeDataKey].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object GeneratedPropertyAccessorTypeDataKey : DataKey<GeneratedPropertyAccessorType>()

/**
 * Helper to check if a [MethodDeclaration] is a property accessor generated by [addGetter]/[addSetter].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MethodDeclaration.isGeneratedPropertyAccessor
    get() = containsData(GeneratedPropertyAccessorTypeDataKey)

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
fun ClassOrInterfaceDeclaration.addGetterForInheritedAttribute(attributeName: String, typeName: String)
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
val ClassOrInterfaceDeclaration.methodsExcludingPropertyAccessors
    get() = methods.filter { !it.isGeneratedPropertyAccessor }

/**
 * Associate this [ClassOrInterfaceDeclaration] with a [filePath].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.setFilePath(filePath: String) {
    setData(FilePathDataKey, filePath)
}

/**
 * Create a new Java enumeration named [enumName] in the package with the given [packageName]. The result is an
 * AST node of type [EnumDeclaration] that also comprises a [CompilationUnit] instance holding the [packageName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun newEnum(packageName: String, enumName: String) : EnumDeclaration {
    val compilationUnit = CompilationUnit(packageName)
    val enum = EnumDeclaration()
    enum.addModifier(Modifier.Keyword.PUBLIC)
    enum.setName(enumName)
    enum.setParentNode(compilationUnit)
    compilationUnit.addType(enum)
    return enum
}

/**
 * Get the name of an [EnumDeclaration] instance's package declaration. This assumes that the instance is bundled within
 * a [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EnumDeclaration.getPackageName() = findParentNode<CompilationUnit>()!!.getPackageName()

/**
 * Copy this [TypeParameter] to a new [TypeParameter] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun TypeParameter.copy() : TypeParameter {
    val copyName = SimpleName(nameAsString)
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    // TODO Copy typeBound
    return TypeParameter(copyName, NodeList(), copyAnnotations)
}

/**
 * Helper to check if this [Type] is a generic type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Type.isGenericType() = (this as? ClassOrInterfaceType)?.typeArguments?.isPresent ?: false

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

    var extendedTypeName = superClassname.substringAfterLast(".")
    if (typeParameters.isNotEmpty())
        extendedTypeName = "$extendedTypeName<${typeParameters.joinToString()}>"
    addExtendedType(extendedTypeName)
    setData(SuperclassDataKey, SuperclassInfo(superClassname, isExternalSuperclass, typeParameters,
        extendedTypes.last()))
}

/**
 * Information about a superclass of a [ClassOrInterfaceDeclaration] being stored in [SuperclassDataKey] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class SuperclassInfo(val fullyQualifiedClassname: String, val isExternal: Boolean,
    val typeParameters: List<String>, val superclassType: ClassOrInterfaceType)

/**
 * Data key for [ClassOrInterfaceDeclaration] instances' superclasses.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object SuperclassDataKey : DataKey<SuperclassInfo>()

/**
 * Get the fully-qualified name of this [ClassOrInterfaceDeclaration] instance's superclass.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.getSuperclass() : SuperclassInfo? {
    return if (containsData(SuperclassDataKey))
            getData(SuperclassDataKey)
        else
            null
}