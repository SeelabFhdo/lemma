@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.ParseProblemException
import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.NodeList
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.ast.comments.Comment
import com.github.javaparser.ast.comments.LineComment
import com.github.javaparser.ast.expr.SimpleName
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.Statement
import com.github.javaparser.ast.type.ReferenceType
import java.lang.IllegalArgumentException

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
    = getImportsInfo<ImportsInfo<SingleImportInfo>>()?.getAllImportInfo()
        ?.filter { it.targetElementType in targetElementTypes }
        ?.map { it.import }
        ?.toSet()

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
fun MethodDeclaration.setBody(code: String, withLineComment: String = "", withBlockComment: String = ""):  BlockStmt {
    val (existingBodyComments, existingStatementsComments) = getAndRemoveComments()
    val existingComments = existingBodyComments.toMutableList()
    existingComments.addAll(existingStatementsComments)

    val newBody = BlockStmt()

    val bodyStatement = newBody.addAndGetStatement(code)
    setBody(newBody)

    when {
        withLineComment.isNotEmpty() -> bodyStatement.addComments(existingComments, LineComment(withLineComment))
        withBlockComment.isNotEmpty() -> bodyStatement.addComments(existingComments, BlockComment(withBlockComment))
        else -> bodyStatement.addComments(existingComments)
    }

    return newBody
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
fun MethodDeclaration.insertBody(otherBody: BlockStmt,
    adaptStatementBeforeInsertion: ((Statement) -> Statement)? = null) {

    val statementsToInsert = if (adaptStatementBeforeInsertion != null)
            otherBody.statements.map { adaptStatementBeforeInsertion.invoke(it) }
        else
            otherBody.statements

    if (hasEmptyBody)
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

    if (hasEmptyBody) {
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
val MethodDeclaration.hasEmptyBody
    get() = body.orElse(null)?.statements?.isEmpty() ?: true

/**
 * Check if this [MethodDeclaration] is overridable.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val MethodDeclaration.isOverridable
    get() = !isPrivate && !isStatic && "Override" !in annotations.map { it.nameAsString }

/**
 * Check if this [MethodDeclaration] has a return statement.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val MethodDeclaration.hasReturnStatement
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
val MethodDeclaration.hasThrowStatement
    get() = naiveHasStatementCheck("throw")

/**
 * Copy this [MethodDeclaration] to a new [MethodDeclaration] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.copy() : MethodDeclaration {
    val copyModifiers = NodeList(modifiers.map { it.copy() })
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    val copyTypeParameters = NodeList(typeParameters.map { it.copy() })
    val copyParameters = NodeList(parameters.map { it.copy() })
    val copyThrownExpressions = NodeList(thrownExceptions.map { it.copy() })

    // TODO Do a real copy of the body.get() result
    val copyBody = if (!hasEmptyBody) body.get() else BlockStmt()

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
 * Copy this [ReferenceType] to a new [ReferenceType] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ReferenceType.copy() = StaticJavaParser.parseClassOrInterfaceType(toString()) as ReferenceType

/**
 * Copy the signature of this [MethodDeclaration] to a new [MethodDeclaration] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun MethodDeclaration.copySignature() : MethodDeclaration {
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
 * Create a delegating constructor from this [ConstructorDeclaration]. The result will be a new [ConstructorDeclaration]
 * instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ConstructorDeclaration.createDelegatingConstructor(name: String) : ConstructorDeclaration {
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
fun ConstructorDeclaration.setBody(vararg rawStatements: String, firstStatementWithLineComment: String = "",
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
fun ConstructorDeclaration.insertStatement(code: String, index: Int = 0) {
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
 * Copy this [Parameter] to a new [Parameter] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Parameter.copy() : Parameter {
    val copyModifiers = NodeList(modifiers.map { it.copy() })
    val copyName = SimpleName(nameAsString)
    val copyAnnotations = NodeList(annotations.map { it.copy() })
    val copyVarArgAnnotations = NodeList(varArgsAnnotations.map { it.copy() })
    // TODO Copy type
    return Parameter(copyModifiers, copyAnnotations, type, isVarArgs, copyVarArgAnnotations, copyName)
}