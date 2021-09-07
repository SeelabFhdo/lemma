package de.fhdo.lemma.reconstruction.spring.web.context

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation

object SpringContext {
    private val javaClasses = mutableMapOf<String, ClassOrInterfaceDeclaration>()

    fun addClass(path: String, clazz: ClassOrInterfaceDeclaration) {
        javaClasses.put(path, clazz)
    }

    internal fun deriveMicroserviceFromJavaClass(): Map<String, String> {
        val microservices = mutableMapOf<String, String>()
        javaClasses.forEach {
            if (it.value.hasAnnotation("SpringBootApplication"))
                microservices[it.key] = "${it.value.getPackageName()}.${it.value.name}"
        }
        return microservices
    }

    internal fun deriveInterfaceFromJavaClass(): Map<String, String> {
        val interfaces = mutableMapOf<String, String>()
        javaClasses.forEach {
            if (it.value.hasAnnotation("RestController"))
                interfaces[it.key] = "${it.value.getPackageName()}.${it.value.name}"
        }
        return interfaces
    }


}