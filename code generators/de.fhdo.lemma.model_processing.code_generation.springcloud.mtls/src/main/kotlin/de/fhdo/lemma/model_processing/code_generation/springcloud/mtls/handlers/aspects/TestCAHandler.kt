package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.EObjectNodeCombinations
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.service.intermediate.IntermediateOperation

import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.Access aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class TestCAHandler : AspectHandlerI {
    override fun handlesAspects() : Set<String>{
        println("handlesAspects")
        return setOf("mTLS.testKeystore", "mTLS.keystore")
    }
    override fun handlesEObjectNodeCombinations() : EObjectNodeCombinations {
        println("handlesEObjectNodeCombinations ")
    return combinations { IntermediateOperation::class.java with MethodDeclaration::class.java }
    }
    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        println(eObject.qualifiedName)
        println("Ich bin hier ${aspect.name}")
        aspect.featureNames.forEach{println(it)}
        return node
    }
}