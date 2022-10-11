package de.fhdo.lemma.reconstruction.java.util.parser.util

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.VariableDeclarator
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.findParentNode
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.PrimitiveType
import de.fhdo.lemma.reconstruction.framework.modules.domain.getDomainReconstructionFilesAndParseTrees
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import java.io.File

fun String.extractContextTerm() : String {
    val candidateTerms = split("(?=\\p{Lu})".toRegex()).filter { it.isNotEmpty() }
    candidateTerms.filter { it !== "Application"}
    return candidateTerms.first()
}

fun String.capitalizeWords(splitSymbol: String):
        String = split(splitSymbol).map { it.replaceFirstChar { it.uppercase() }}.joinToString(splitSymbol)

internal fun resolveContextFromNameOld(path: String): String {
    println("resolveContextFromName $path")
    val filesAndTrees = getDomainReconstructionFilesAndParseTrees()
    filesAndTrees.forEach{
        val rootPath = it.key.replaceAfterLast(File.separator, "")
        println("Rootpath: ${rootPath}")
        println("Path: $path")
        if (path.startsWith(rootPath)) {
            println("Path match!")
            println("Class: ${it.value.javaClass}")
            val parseTree = it.value
            val clazz = getApplicationClazzFromParseTree(parseTree as JavaParseTree)
            println("After Parse Tree usesage!")
            val contextName = clazz?.nameAsString?.extractContextTerm()
            println("contextname: $contextName")
            if (contextName !== null) {
                return "${clazz.getPackageName()}.${contextName.lowercase()}"
            } else {
                return getClazzFromParseTree(parseTree).getPackageName()
            }

        }
    }
    return "unknown"
}

internal fun resolveContextFromName(path: String): String {
    val filesAndTrees = getDomainReconstructionFilesAndParseTrees()
    var applicationClass = filesAndTrees.filter {
        path.startsWith(it.key.replaceAfterLast(File.separator, ""))
            && getApplicationClazzFromParseTree(it.value as JavaParseTree) !== null
    }

    if (applicationClass.isEmpty()) {
       applicationClass = filesAndTrees.filter{
           getApplicationClazzFromParseTree(it.value as JavaParseTree) !== null
       }
    }

    val tree = applicationClass.values.first() as JavaParseTree
    val clazz = getApplicationClazzFromParseTree(tree)
    if (clazz !== null) {
        val contextName = clazz.nameAsString.extractContextTerm()
        return "${clazz.getPackageName()}.${contextName.lowercase()}"
    } else {
        throw Exception("Context name can't be resolved.")
    }
}

private fun getApplicationClazzFromParseTree(tree: JavaParseTree): ClassOrInterfaceDeclaration? {
    val clazz = tree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
        { !it.isInterface }.orElse(null)

    if (clazz != null && clazz.hasAnnotation("SpringBootApplication")) {
        return clazz
    }
    return null
}

fun getApplicationClazzFromAbstractParseTree(tree: AbstractParseTree): ClassOrInterfaceDeclaration? {
    when (tree) {
        is JavaParseTree -> {
            val clazz = tree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
             { !it.isInterface }.orElse(null)
            if (clazz != null && clazz.hasAnnotation("SpringBootApplication")) {
                return clazz
            }
            return null
        }
        else -> return null
    }
}

private fun getClazzFromParseTree(tree: JavaParseTree): ClassOrInterfaceDeclaration {
    val clazz = tree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
    { !it.isInterface }.orElse(null)

    return clazz
}


fun EnumDeclaration.packageNameAsString()= findParentNode<CompilationUnit>()!!.getPackageName().toString()

fun getComplexName(unit: CompilationUnit): String {
    val path = unit.storage.get().directory.toString()
    return resolveContextFromName(path)
}

/**
 * Methode for creating primitive type fields
 */
fun handlePrimitiveTypeAttribute(type: String) = PrimitiveType(type)