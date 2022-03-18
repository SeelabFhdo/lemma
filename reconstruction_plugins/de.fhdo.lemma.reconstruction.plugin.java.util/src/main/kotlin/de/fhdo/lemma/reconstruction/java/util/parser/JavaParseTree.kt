package de.fhdo.lemma.reconstruction.java.util.parser

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.CompilationUnit
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import java.io.File


class JavaParseTree constructor(fileType: String, val compilationUnit: CompilationUnit):
    AbstractParseTree(fileType)

fun getJavaParseTree(path: String): Pair<ParsingResultType, JavaParseTree> {
    val unit = JavaParser().parse(File(path)).result.get()
    val javaParseTree = JavaParseTree("java", unit)
    return ParsingResultType.FULLY_PARSED to javaParseTree
}