package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects

import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.EObjectNodeCombinations
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice


import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class TestCAHandler : AspectHandlerI {
    override fun handlesAspects(): Set<String> =
        setOf("mTLS.Keystore", "mTLS.TestKeystore", "mTLS.Truststore", "mTLS.TestTruststore")

    override fun handlesEObjectNodeCombinations(): EObjectNodeCombinations =
        combinations { IntermediateMicroservice::class.java with ClassOrInterfaceDeclaration::class.java }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect): Node {
//        var aspects =
//            eObject.getAllAspects("mTLS.Keystore", "mTLS.TestKeystore", "mTLS.Truststore", "mTLS.TestTruststore")
//        aspects.forEach {
//            println("Aspectname: ${it.name} | Aspectvalue: ${it.properties.forEach(System.out::println)}")
//        }
//        println("uiuiuiuiuiui")
        return node
    }
}