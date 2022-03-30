package de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.utils.mainInterface
import org.eclipse.emf.ecore.EObject
import io.github.classgraph.ClassGraph

const val packageName = "de.fhdo.lemma.model_processing.code_generation.ballerina"
const val annotationName = "de.fhdo.lemma.model_processing.code_generation.ballerina.handlers.CodeGenerationHandler"
const val interfaceName = "de.fhdo.lemma.model_processing.code_generation.ballerina.handlers.CodeGenerationHandlerI"

@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationHandler()


interface CodeGenerationHandlerI<T : EObject> {
    fun getSourceInstanceType(): Class<T>
    fun getAspects(eObject: T, filter: String = ""): List<IntermediateImportedAspect> = emptyList()

    fun execute(eObject: T): String?

    fun createHandlerInstance(instance: EObject): List<CodeGenerationHandlerI<EObject>> {
        val handlerInstanceList = mutableListOf<CodeGenerationHandlerI<EObject>>()
        val classes = findClassesWithAnnotationAndInterface(packageName, annotationName, interfaceName)
        val elementInstanceType = instance.mainInterface
        classes.forEach { (_, handlerClassInfo) ->
            val clazz = handlerClassInfo.loadClass()
            val handlerInstance = clazz.getConstructor().newInstance() as CodeGenerationHandlerI<*>
            if (elementInstanceType == handlerInstance.getSourceInstanceType())
                handlerInstanceList.add(handlerInstance as CodeGenerationHandlerI<*>)
        }
        return handlerInstanceList
    }
}

fun findClassesWithAnnotationAndInterface(packageName: String, annotationName: String, interfaceName: String) =
    findClassesWithAnnotation(packageName, annotationName)
        .filter { (_, classInfo) -> classInfo.interfaces.any { it.name == interfaceName } }

fun findClassesWithAnnotation(packageName: String, annotationName: String) = ClassGraph()
    .enableAllInfo()
    .whitelistPackages(packageName)
    .scan()
    .getClassesWithAnnotation(annotationName)
    .asMap()