package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.validation

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.checkIfAllValid
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getInvalidEntries
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.splitAndTrim
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
class KeycloakOperationIntermediateModelValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    @Before
    private fun collectKeycloakAspectsFromImportedModels(resource: Resource){
        ModelsContext.State.intermediateServiceModels.forEach { (_, intermediateServiceModel) ->
            loadAllRolesFromServiceModel(intermediateServiceModel)
        }
        ModelsContext.State.intermediateOperationModels.forEach { (_, intermediateOperationModel) ->
            loadAllRolesAndGroupsFromOperationModel(intermediateOperationModel)
        }
    }

    @Check
    private fun checkKeycloakAspects(intermediateImportedAspect: IntermediateImportedAspect) {
        if (!intermediateImportedAspect.qualifiedName.startsWith("Keycloak"))
            return
        when (intermediateImportedAspect.name) {
            "User" -> {
                intermediateImportedAspect.getPropertyValue("groups")?.splitAndTrim(",")?.let {
                    if (!(it checkIfAllValid ModelsContext.State.groups.toList()))
                        callError(
                            "The following groups do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.groups.toList()}",
                            intermediateImportedAspect
                        )
                }
                intermediateImportedAspect.getPropertyValue("realmRoles")?.splitAndTrim(",")?.let {
                    if (!(it checkIfAllValid ModelsContext.State.realmRoles.toList()))
                        error(
                            "The following realm roles do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.realmRoles.toList()}",
                            intermediateImportedAspect,
                            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
                        )
                }
                intermediateImportedAspect.getPropertyValue("clientRoles")?.splitAndTrim(",")?.map {
                    it.splitAndTrim("=").component2()
                }?.let {
                    if (!(it checkIfAllValid ModelsContext.State.clientRoles.toList()))
                        callError(
                            "The following client roles do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.clientRoles.toList()}",
                            intermediateImportedAspect
                        )
                }
            }
            "Group" -> {
                intermediateImportedAspect.getPropertyValue("realmRoles")?.splitAndTrim(",")?.let {
                    if (!(it checkIfAllValid ModelsContext.State.realmRoles.toList()))
                        callError(
                            "The following realm roles do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.realmRoles.toList()}",
                            intermediateImportedAspect
                        )
                }
            }
            "KeycloakClient" -> { // todo diese Prüfung in den SourceModelValidator ins Genelt und hier schieben
                val accessTypes = listOf("public", "confidential", "bearer-only")
                val properties = intermediateImportedAspect.getPropertiesValuesOrDefault()
                properties.forEach { (key, value) ->
                    when (key) {
                        "accessType" -> {
                            if (value !in accessTypes)
                                callError(
                                    "Only one of the following values is allowed as access type: " +
                                            accessTypes.joinToString(", "),
                                    intermediateImportedAspect
                                )
                            if (value == "confidential" && intermediateImportedAspect.getPropertyValue("redirectURL")
                                    .isNullOrEmpty()
                            ) callError(
                                "If the access type is \"confidential\" a redirectURL must be specified!",
                                intermediateImportedAspect,
                            )
                        }
                        "clientProtocol" -> {
                            val clientProtocols = listOf("openid-connect", "saml")
                            if (value !in clientProtocols)
                                callError(
                                    "Only one of the following values is allowed as clientProtocol: " +
                                            clientProtocols.joinToString(", "),
                                    intermediateImportedAspect
                                )
                        }
                    }
                }
            }
            "Role" -> {
                //todo prüfe gültige HTTP Verben und HTTP Verben berücksichtigen
            }
            "KeycloakPropertiesConfig" -> {}
            else -> {}
        }
    }

    private fun callError(message: String, intermediateImportedAspect: IntermediateImportedAspect) {
        error(
            message,
            intermediateImportedAspect,
            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
        )
    }


    private fun loadAllRolesAndGroupsFromOperationModel(intermediateOperationModel: IntermediateOperationModel) {
        intermediateOperationModel.infrastructureNodes
            .forEach { intermediateInfrastructureNode ->
                intermediateInfrastructureNode.aspects.forEach { intermediateImportedAspect ->
                    when (intermediateImportedAspect.name) {
                        "Role" -> addRolesToModelContext(intermediateImportedAspect)
                        "Group" -> ModelsContext.State.groups.add(
                            intermediateImportedAspect.getPropertyValue("name") as String
                        )
                        else -> {}
                    }
                }
            }
    }

    private fun loadAllRolesFromServiceModel(serviceModel: IntermediateServiceModel) {
        serviceModel.microservices.forEach { intermediateServiceModel ->
            intermediateServiceModel.interfaces.forEach { intermediateInterface ->
                intermediateInterface.aspects.filter { it.name == "Role" }.forEach { addRolesToModelContext(it) }
                intermediateInterface.operations.forEach { intermediateOperation ->
                    intermediateOperation.aspects.filter { it.name == "Role" }.forEach { addRolesToModelContext(it) }
                }
            }
        }
    }

    private fun addRolesToModelContext(intermediateImportedAspect: IntermediateImportedAspect) {
        intermediateImportedAspect.getPropertyValue("name")?.let {
            if (intermediateImportedAspect.getPropertyValue("clientRole").toBoolean())
                ModelsContext.State.clientRoles.add(it)
            else
                ModelsContext.State.realmRoles.add(it)
        }
    }
}