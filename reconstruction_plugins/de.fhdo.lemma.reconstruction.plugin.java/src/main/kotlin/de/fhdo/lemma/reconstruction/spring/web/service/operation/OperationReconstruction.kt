package de.fhdo.lemma.reconstruction.spring.web.service.operation

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.methodsExcludingPropertyAccessors
import de.fhdo.lemma.reconstruction.spring.web.parser.JavaParseTree
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.reconstruction.framework.modules.service.operation.Operation
import de.fhdo.reconstruction.framework.modules.service.operation.ReconstructionOperationFactory
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType
import java.io.File

@ReconstructionModule(ReconstructionStage.Operation)
class OperationReconstruction : AbstractReconstructionModule() {
    override fun execute(abstractParseTree: AbstractParseTree): List<Operation> {
        val operations = mutableListOf<Operation>()
        val parseTree = abstractParseTree as JavaParseTree
        val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
            { !it.isInterface }.orElse(null)

        if (clazz != null && clazz.hasAnnotation("RestController")) {
            clazz.methodsExcludingPropertyAccessors.forEach {
                val operation = ReconstructionOperationFactory().createOperation(it.name.toString())
                operation.interfaceName = "${clazz.getPackageName()}.${clazz.name}"
                operations.add(operation)
            }
        }

        return operations
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