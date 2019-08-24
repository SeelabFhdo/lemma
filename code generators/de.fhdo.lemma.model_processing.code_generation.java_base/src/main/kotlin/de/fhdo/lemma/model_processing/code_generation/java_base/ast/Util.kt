package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.AssignExpr
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.ReturnStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import java.lang.IllegalArgumentException

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
 * Create a new Java class named [classname] in the package with the given [packageName]. The result is an AST node of
 * type [ClassOrInterfaceDeclaration] that also comprises a [CompilationUnit] instance holding the [packageName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun newJavaClass(packageName: String, classname: String) : ClassOrInterfaceDeclaration {
    val compilationUnit = CompilationUnit(packageName)
    val clazz = ClassOrInterfaceDeclaration()
    clazz.setName(classname)
    clazz.setParentNode(compilationUnit)
    compilationUnit.addType(clazz)
    return clazz
}

/**
 * Get the name of a [CompilationUnit] instance's package declaration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun CompilationUnit.packageName() = packageDeclaration.get().name.asString()

/**
 * Get the name of a [ClassOrInterfaceDeclaration] instance's package declaration. This assumes that the instance is
 * bundled within a [CompilationUnit].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.packageName() = (parentNode.get() as CompilationUnit).packageName()

/**
 * Add an import statement to the Java class represented by a [ClassOrInterfaceDeclaration] instance. The import will
 * not be added, if it already exists. This function should only be invoked on [ClassOrInterfaceDeclaration] instances
 * created via [newJavaClass].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addImport(import: String, onlyAddIfDifferentPackage: Boolean = true) {
    val compilationUnit = parentNode.get() as CompilationUnit
    if (onlyAddIfDifferentPackage) {
        val importPackage = import.substringBeforeLast(".")
        if (packageName() == importPackage)
            return
    }
    val existingImports = compilationUnit.imports.map { name.asString() }
    if (import !in existingImports)
        compilationUnit.addImport(import)
}

/**
 * Add a set of imports to the Java class represented by a [ClassOrInterfaceDeclaration] instance. Duplicate imports
 * will not be added. This function should only be invoked on [ClassOrInterfaceDeclaration] instances created via
 * [newJavaClass].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ClassOrInterfaceDeclaration.addImports(imports: Set<String>) = imports.forEach { addImport(it) }

/**
 * Add an attribute to the Java class represented by a [ClassOrInterfaceDeclaration] instance. The created attribute is
 * an AST node of type [FieldDeclaration] and will be returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword) : FieldDeclaration {
    return addField(typeName, attributeName, *modifiers)
}

/**
 * Add a private attribute to the Java class represented by a [ClassOrInterfaceDeclaration] instance. The created
 * attribute is an AST node of type [FieldDeclaration] with the modifier [Modifier.Keyword.PRIVATE] and will be returned
 * to the caller. An additional [Modifier] list may be passed to the function to add further modifiers to the attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addPrivateAttribute(attributeName: String, typeName: String,
    vararg modifiers: Modifier.Keyword) = addAttribute(attributeName, typeName, Modifier.Keyword.PRIVATE, *modifiers)

/**
 * Add a getter to the Java class represented by a [ClassOrInterfaceDeclaration] instance. The created getter is an AST
 * node of type [MethodDeclaration]. It will be returned to the caller, together with the name of its backing attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addGetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
    val getter = attribute.createGetter()
    getter.setParentNode(this)
    val returnStatement = getter.body.get().statements[0] as ReturnStmt
    val fieldName = (returnStatement.expression.get() as NameExpr).nameAsString
    return fieldName to getter
}

/**
 * Add a setter to the Java class represented by a [ClassOrInterfaceDeclaration] instance. The created getter is an AST
 * node of type [MethodDeclaration]. It will be returned to the caller, together with the name of its backing attribute.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addSetter(attribute: FieldDeclaration) : Pair<String, MethodDeclaration> {
    val setter = attribute.createSetter()
    setter.setParentNode(this)
    val assignExpression = (setter.body.get().statements[0] as ExpressionStmt).expression as AssignExpr
    val fieldName = (assignExpression.value as NameExpr).nameAsString
    return fieldName to setter
}

/**
 * Add a getter for an inherited attribute of the Java class represented by a [ClassOrInterfaceDeclaration] instance.
 * The created getter is an AST node of type [MethodDeclaration] and will be returned to the caller.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addGetterForInheritedAttribute(attributeName: String, typeName: String)
    : MethodDeclaration {
    // For consistency, we rely on the getter creation process of JavaParser. Therefore, we create a "fake" getter
    // producer attribute to the current class, leverage it to create the getter, and then remove it again.
    val getterProducer = addPrivateAttribute(attributeName, typeName)
    val getter = getterProducer.createGetter()
    getter.setParentNode(this)
    getterProducer.setParentNode(null)
    return getter
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
fun FieldDeclaration.addImport(import: String) = (parentNode.get() as ClassOrInterfaceDeclaration).addImport(import)

/**
 * Convenience method in the context of an attribute, which enables to add a set of imports to its defining class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun FieldDeclaration.addImports(imports: Set<String>) {
    imports.forEach { addImport(it) }
}

/**
 * Set the implementation body of a Java method. The implementation body is provided in the form of plain Java code.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.setBody(code: String) {
    val statement = BlockStmt()
    statement.addStatement(code)
    setBody(statement)
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