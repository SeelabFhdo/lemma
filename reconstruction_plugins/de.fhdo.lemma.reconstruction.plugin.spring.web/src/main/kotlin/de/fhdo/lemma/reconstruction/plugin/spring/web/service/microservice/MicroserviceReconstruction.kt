package de.fhdo.lemma.reconstruction.plugin.spring.web.service.microservice

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.service.microservice.Microservice
import de.fhdo.lemma.reconstruction.framework.modules.service.microservice.ReconstructionMicroserviceFactory
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree


internal fun findMicroservices(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    val reconstructionElements = mutableListOf<Microservice>()
    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
    { !it.isInterface }.orElse(null)

    if (clazz != null && clazz.hasAnnotation("SpringBootApplication")) {
        val microservice = ReconstructionMicroserviceFactory()
            .createMicroservice("${clazz.getPackageName()}.${clazz.nameAsString}")
        microservice.type = "functional"
        microservice.version = "v01"
        microservice.visibility = "public"
        reconstructionElements.add(microservice)
    }

    return reconstructionElements
}

private fun addImportsToMicroservice(compilationUnit: CompilationUnit)
        = compilationUnit.imports.map { it.name.toString() }.toList()
