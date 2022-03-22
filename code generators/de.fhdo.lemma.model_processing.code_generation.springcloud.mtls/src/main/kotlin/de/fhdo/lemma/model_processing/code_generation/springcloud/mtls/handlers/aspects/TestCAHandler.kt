package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
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
    override fun handlesAspects() : Set<String> = setOf("mTLS.Keystore")
    override fun handlesEObjectNodeCombinations() : EObjectNodeCombinations =
        combinations { IntermediateOperation::class.java with MethodDeclaration::class.java }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
//        println("Execute hier ")
//        var aspects = eObject.getAllAspects(
//            "mTLS.Keystore", "mTLS.TestKeystore", "mTLS.Truststore", "mTLS.TestTruststore")
//        println(eObject.qualifiedName)
//        aspects.forEach {
//            println("Aspectname: ${it.name} | Aspectvalue: ${it.properties.forEach(System.out::println)}")
//        }
        return node
    }
}