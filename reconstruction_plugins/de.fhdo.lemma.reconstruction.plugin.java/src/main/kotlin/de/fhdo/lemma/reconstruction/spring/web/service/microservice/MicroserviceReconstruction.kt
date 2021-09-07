package de.fhdo.lemma.reconstruction.spring.web.service.microservice

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.spring.web.parser.JavaParseTree
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.reconstruction.framework.modules.service.microservice.Microservice
import de.fhdo.reconstruction.framework.modules.service.microservice.ReconstructionMicroserviceFactory
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.reconstruction.framework.plugins.ParsingResultType.*
import java.io.File

@ReconstructionModule(ReconstructionStage.Microservice)
class MicroserviceReconstruction : AbstractReconstructionModule() {

    override fun execute(abstractParseTree: AbstractParseTree): List<Microservice> {
        val microservices = mutableListOf<Microservice>()
        val parseTree = abstractParseTree as JavaParseTree
        val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
            { !it.isInterface }.orElse(null)

        if (clazz != null && clazz.hasAnnotation("SpringBootApplication")) {
            val microservice = ReconstructionMicroserviceFactory()
                .createMicroservice("${clazz.getPackageName()}.${clazz.nameAsString}")
            microservice.type = "functional"
            microservice.version = "v01"
            microservice.visibility = "public"
            microservices.add(microservice)
        }

        return microservices
    }

    override fun getParseTree(path: String): Pair<ParsingResultType, AbstractParseTree> {
        val unit = JavaParser().parse(File(path)).result.get()
        val javaParseTree = JavaParseTree("java", unit)
        return FULLY_PARSED to javaParseTree
    }

    override fun getSupportFileExtensions() = listOf("java")


}