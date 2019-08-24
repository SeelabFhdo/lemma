package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

@AspectHandler
class Test : AspectHandlerI {
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect): Node {
        println("IN GENLET")
        return node
    }

    override fun handlesAspects() = setOf("java.Table")

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }
}