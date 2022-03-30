package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.ast

import com.github.javaparser.ast.body.VariableDeclarator
import com.github.javaparser.ast.expr.BinaryExpr
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NullLiteralExpr
import com.github.javaparser.ast.expr.BinaryExpr.Operator
import com.github.javaparser.ast.expr.MethodCallExpr
import com.github.javaparser.ast.expr.SimpleName
import com.github.javaparser.ast.expr.VariableDeclarationExpr
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.IfStmt
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect

internal fun BinaryExpr.binaryExprNotEqualsNull(variableName: String): BinaryExpr {
    return BinaryExpr(NameExpr(variableName), NullLiteralExpr(), Operator.NOT_EQUALS)
}

internal fun BinaryExpr.binaryExprAnd(leftBinaryExpr: BinaryExpr, rightBinaryExpr: BinaryExpr): BinaryExpr {
    return BinaryExpr(leftBinaryExpr, rightBinaryExpr, Operator.AND)
}

internal fun addStringVariable(variableName: String, property: String): VariableDeclarationExpr {
    val methodCallExpr =
        MethodCallExpr(null, SimpleName("environment.getProperty")).addArgument(("\"${property}\""))
    val variableDeclarator = VariableDeclarator(ClassOrInterfaceType(null, "String"), variableName, methodCallExpr)
    return VariableDeclarationExpr(variableDeclarator)
}


internal fun addVariableCheck(variableName: String, property: String): IfStmt {
    val ifStmtKeystore = IfStmt()
    ifStmtKeystore.condition = BinaryExpr().binaryExprNotEqualsNull(variableName)
    ifStmtKeystore.thenStmt = BlockStmt()
        .addStatement("System.setProperty(\"${getSystemProperty(property)}\", ${variableName});")
    return ifStmtKeystore
}

internal fun getSystemProperty(property: String) = when (property) {
    "server.ssl.key-store" -> "javax.net.ssl.keyStore"
    "server.ssl.key-store-password" -> "javax.net.ssl.keyStorePassword"
    "server.ssl.trust-store" -> "javax.net.ssl.trustStore"
    "server.ssl.trust-store-password" -> "javax.net.ssl.trustStorePassword"
    else -> ""
}

//internal fun mapAspectToSpringProperty() = when (fullyQualifiedName) {
//    //        "mTLS.Keystore", "mTLS.TestKeystore", "mTLS.Truststore", "mTLS.TestTruststore"
//    this.pr
//    "Keystore.path" -> "server.ssl.key-store"
//    "mTLS.Truststore" -> ""
//    "Truststore.path" in fullyQualifiedName -> "server.ssl.trust-store"
//    "" -> "server.ssl.key-store-password"
//    "1" -> "server.ssl.trust-store-password"
//    else -> ""
//}