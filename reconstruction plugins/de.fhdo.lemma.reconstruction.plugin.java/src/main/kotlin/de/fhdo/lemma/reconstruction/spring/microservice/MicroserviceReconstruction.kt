package de.fhdo.lemma.reconstruction.spring.microservice

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.reconstruction.framework.microservice.*
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.reconstruction.framework.plugins.ParsingResultType.*
import java.io.File

@TestAnnotation
@MicroserviceReconstructionModule
class MicroserviceReconstruction : AbstractMicroserviceReconstructionModule() {
    override fun execute(abstractParseTree: AbstractParseTree): List<Microservice> {
        val microservices = mutableListOf<Microservice>()
        val parseTree = abstractParseTree as JavaParseTree
        val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
        { !it.isInterface }.orElse(null)

        val test = parseTree

        if (clazz != null && clazz.hasAnnotation("SpringBootApplication"))
            microservices.add(createMicroservice(clazz.nameAsString, "v01", "functional", "public"))

        println()
        return microservices
    }

    override fun getParsingTree(path: String): Pair<ParsingResultType, AbstractParseTree> {
        val unit = JavaParser().parse(File(path)).result.get()
        val javaParseTree = JavaParseTree("java", unit)
        return FULLY_PARSED to javaParseTree
    }

    override fun getSupportFileExtensions(): List<String> {
        return mutableListOf("java")
    }

}