package de.fhdo.lemma.reconstruction.spring.web.service.`interface`

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.spring.web.parser.JavaParseTree
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.reconstruction.framework.modules.service.`interface`.Interface
import de.fhdo.reconstruction.framework.modules.service.`interface`.ReconstructionInterfaceFactory
import de.fhdo.reconstruction.framework.modules.service.microservice.getReconstructedMicroservices
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import java.io.File

@ReconstructionModule(ReconstructionStage.Interface)
class InterfaceReconstruction: AbstractReconstructionModule() {
    override fun execute(abstractParseTree: AbstractParseTree): List<Interface> {
        val interfaces = mutableListOf<Interface>()
        val parseTree = abstractParseTree as JavaParseTree
        val clazz = parseTree.compilationUnit?.findFirst(ClassOrInterfaceDeclaration::class.java)
            { !it.isInterface }?.orElse(null)

        if (clazz != null && clazz.hasAnnotation("RestController")) {
            val interfaceName = "${clazz.getPackageName()}.${clazz.nameAsString}"
            var interFace = ReconstructionInterfaceFactory()
                .createInterface(interfaceName)
            val microservice = getReconstructedMicroservices().find { service ->
                interFace.name.startsWith(service.fullyQualifiedName.replaceAfterLast(".", ""))
            }
            interFace.microserviceName = microservice?.fullyQualifiedName
            interFace.version = "v01"
            interFace.visibility = "public"
            interfaces.add(interFace)
        }
        return interfaces
    }

    override fun getParseTree(path: String): Pair<ParsingResultType, AbstractParseTree> {
        val unit = JavaParser().parse(File(path)).result.get()
        val javaParseTree = JavaParseTree("java", unit)
        return ParsingResultType.FULLY_PARSED to javaParseTree
    }

    override fun getSupportFileExtensions(): List<String> {
        return mutableListOf("java")
    }

}