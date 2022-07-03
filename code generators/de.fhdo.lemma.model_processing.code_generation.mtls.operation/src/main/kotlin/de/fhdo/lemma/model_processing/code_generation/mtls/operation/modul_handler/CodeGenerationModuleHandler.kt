package de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.CharsetAwareFileContent
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.annotationName
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.findClassesWithAnnotationAndInterface
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.interfaceName
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.packageName
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.asFormattedString
import de.fhdo.lemma.model_processing.utils.mainInterface
import org.eclipse.emf.ecore.EObject

@CodeGenerationModule(name = "mtls")
class CodeGenerationModuleHandler : AbstractCodeGenerationModule() {
    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun execute(
        phaseArguments: Array<String>, moduleArguments: Array<String>
    ): Map<String, CharsetAwareFileContent> {
        val content = HashMap<String, String>()
        val classes = findClassesWithAnnotationAndInterface(packageName, annotationName, interfaceName)
        val node = mutableListOf<String?>()
        MainContext.State.initialize(targetFolder)
        ModelsContext.State.intermediateOperationModels.forEach { (_, resource) ->
            resource.eAllContents().forEach { element ->
                val elementInstanceType = element.mainInterface
                classes.forEach { (_, handlerClassInfo) ->
                    val clazz = handlerClassInfo.loadClass()
                    @Suppress("UNCHECKED_CAST")
                    val handlerInstance = clazz.getConstructor().newInstance() as CodeGenerationHandlerI<EObject>
                    if (elementInstanceType == handlerInstance.getSourceInstanceType()) {
                        node.add(handlerInstance.execute(element))
                    }
                }
            }
        }
        MainContext.State.getPropertyFiles().forEach { (filePath, properties) ->
            content[filePath] = properties.asFormattedString()
        }
        return withCharset(content, "UTF-8")
    }
}