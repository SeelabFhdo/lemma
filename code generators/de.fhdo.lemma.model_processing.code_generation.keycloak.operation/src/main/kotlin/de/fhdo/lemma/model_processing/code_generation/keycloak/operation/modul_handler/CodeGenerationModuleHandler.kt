package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.CharsetAwareFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext.State.getClientApplicationProperties
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext.State.getPath
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.PathSpecifier
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.annotationName
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.findClassesWithAnnotationAndInterface
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.interfaceName
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.packageName
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.asFormattedString
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.io.File

@CodeGenerationModule(name = "keycloak")
class CodeGenerationModuleHandler : AbstractCodeGenerationModule() {
    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun execute(
        phaseArguments: Array<String>, moduleArguments: Array<String>
    ): Map<String, CharsetAwareFileContent> {
        val content = HashMap<String, String>()
        MainContext.State.initialize(targetFolder)
        ModelsContext.State.intermediateOperationModels.forEach { (uri, intermediateOperationModel) ->
            intermediateOperationModel.eResource().callAllHandlers()
        }

//         todo properties erstellen
//         todo keycloak config erstellen 1 x komplette und für jeden client
        ModelsContext.State.intermediateServiceModels.forEach { (uri, intermediateServiceModel) ->
            intermediateServiceModel.microservices.filter { it.hasAspect("Keycloak.KeycloakClient") }
                .forEach { intermediateMicroservice ->
                    content[
                            setOf(
                                getPath(
                                    PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH,
                                    intermediateMicroservice.qualifiedName
                                ),
                                "application-keycloak.properties"
                            ).joinToString(File.separator)] =
                        getClientApplicationProperties(intermediateMicroservice.name).asFormattedString()
                }
        }

        content[setOf(
            targetFolder,
            "keycloak",
            "realm_${MainContext.State.getRealmName()}.json"
        ).joinToString(File.separator)] =
            MainContext.State.getRealmAsJson()
        return withCharset(content, "UTF-8")
    }
}

fun Resource.callAllHandlers(): List<String?> {
    val classes = findClassesWithAnnotationAndInterface(packageName, annotationName, interfaceName)
    val returnValue = mutableListOf<String?>()
    this.allContents.forEach { element ->
        val elementInstanceType = element.mainInterface
        classes.forEach { (_, handlerClassInfo) ->
            val clazz = handlerClassInfo.loadClass()

            @Suppress("UNCHECKED_CAST")
            val handlerInstance = clazz.getConstructor().newInstance() as CodeGenerationHandlerI<EObject>
            if (elementInstanceType == handlerInstance.getSourceInstanceType()) {
                returnValue.add(handlerInstance.execute(element))
            }
        }
    }
    return returnValue.toList()
}