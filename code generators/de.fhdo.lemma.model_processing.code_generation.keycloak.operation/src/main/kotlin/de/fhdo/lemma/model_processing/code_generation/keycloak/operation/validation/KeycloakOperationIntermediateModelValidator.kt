package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
class KeycloakOperationIntermediateModelValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI


    @Check
    private fun checkInfrastructureNodeAspects(intermediateInfrastructureNode: IntermediateInfrastructureNode) {
        println("Hier der IntermediateValidator")
        intermediateInfrastructureNode.aspects.forEach { aspect ->
            println(aspect.name)
            when (aspect.name) {
                "user" -> {
                    // groups: prüfen ob alle Gruppen vorhanden sind
                    // realmRoles: prüfen ob alle realmRoles vorhanden sind
                    // clientRoles: prüfen ob alle clientRoles vorhanden sind
                    println("realmRoles Anzahl: ${ModelsContext.State.realmRoles.size}")
                    ModelsContext.State.realmRoles.forEach {
                        println("realmRoles: $it")
                    }
                    println("clientRoles Anzahl: ${ModelsContext.State.clientRoles.size}")
                    ModelsContext.State.clientRoles.forEach {
                        println("clientRoles: $it")
                    }

                }
                "group" -> {
                    println("group Anzahl: ${ModelsContext.State.groups.size}")
                    ModelsContext.State.groups.forEach {
                        println("groups: $it")
                    }
                    // realmRoles -> prüfen ob alle realmRoles vorhanden sind
                }
                "role" -> {


                }
                "keycloakClient" -> {
                    // accessType -> public, confidential or bearer-only
                    // clientProtocol -> openid-connect, saml
                    // bei confidential rootURL ist Pflicht bzw. redirect
                }
                "keycloakPropertiesConfig" -> {

                }
            }
        }
    }



    private fun getAllClientRoles(): List<String> {

        return listOf<String>()
    }

}

//fun Resource.callAllHandlers(): List<String?> {
//    val classes = findClassesWithAnnotationAndInterface(packageName, annotationName, interfaceName)
//    val returnValue = mutableListOf<String?>()
//    this.allContents.forEach { element ->
//        val elementInstanceType = element.mainInterface
//        classes.forEach { (_, handlerClassInfo) ->
//            val clazz = handlerClassInfo.loadClass()
//            @Suppress("UNCHECKED_CAST")
//            val handlerInstance = clazz.getConstructor().newInstance() as CodeGenerationHandlerI<EObject>
//            if (elementInstanceType == handlerInstance.getSourceInstanceType()) {
//                returnValue.add(handlerInstance.execute(element))
//            }
//        }
//    }
//    return returnValue.toList()
//}