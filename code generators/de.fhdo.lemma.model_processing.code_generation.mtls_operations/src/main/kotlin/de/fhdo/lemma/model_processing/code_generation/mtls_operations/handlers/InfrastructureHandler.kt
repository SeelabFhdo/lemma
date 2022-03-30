package de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.CharsetAwareFileContent
import de.fhdo.lemma.model_processing.utils.mainInterface
import org.eclipse.emf.ecore.EObject

@CodeGenerationModule(name = "mtls")
class InfrastructureHandler : AbstractCodeGenerationModule() {
    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun execute(
        phaseArguments: Array<String>,
        moduleArguments: Array<String>
    ): Map<String, CharsetAwareFileContent> {
        val content = HashMap<String, String>()
        val classes = findClassesWithAnnotationAndInterface(packageName, annotationName, interfaceName)
        var node: String? = ""
        this.resource.allContents.forEach { element ->
            val elementInstanceType = element.mainInterface
            classes.forEach { (_, handlerClassInfo) ->
                val clazz = handlerClassInfo.loadClass()
                val handlerInstance = clazz.getConstructor().newInstance() as CodeGenerationHandlerI<EObject>
                if (elementInstanceType == handlerInstance.getSourceInstanceType()) {
                    node = handlerInstance.execute(element)
                }
            }
        }
        println(node)

        return withCharset(content, "UTF-8")
    }


}