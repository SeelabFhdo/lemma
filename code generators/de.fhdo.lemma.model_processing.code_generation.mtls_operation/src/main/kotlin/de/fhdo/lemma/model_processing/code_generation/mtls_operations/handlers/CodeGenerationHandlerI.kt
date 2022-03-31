package de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers

import org.eclipse.emf.ecore.EObject
import io.github.classgraph.ClassGraph

const val packageName = "de.fhdo.lemma.model_processing.code_generation.mtls_operations"
const val annotationName = "de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers.CodeGenerationHandler"
const val interfaceName = "de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers.CodeGenerationHandlerI"

@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationHandler()

interface CodeGenerationHandlerI<T : EObject> {
    fun getSourceInstanceType(): Class<T>
    fun execute(eObject: T): String?
}

fun findClassesWithAnnotationAndInterface(packageName: String, annotationName: String, interfaceName: String) =
    findClassesWithAnnotation(packageName, annotationName)
        .filter { (_, classInfo) -> classInfo.interfaces.any { it.name == interfaceName } }

fun findClassesWithAnnotation(packageName: String, annotationName: String) = ClassGraph()
    .enableAllInfo()
    .acceptPackages(packageName)
    .scan()
    .getClassesWithAnnotation(annotationName)
    .asMap()