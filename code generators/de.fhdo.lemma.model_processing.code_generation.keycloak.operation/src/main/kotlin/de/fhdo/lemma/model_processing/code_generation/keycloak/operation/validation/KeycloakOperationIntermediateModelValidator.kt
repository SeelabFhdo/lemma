package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.validation

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.checkIfAllValid
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getInvalidEntries
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.splitAndTrim
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
class KeycloakOperationIntermediateModelValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    @Check
    private fun checkKeycloakAspects(intermediateImportedAspect: IntermediateImportedAspect) {
        println(intermediateImportedAspect.qualifiedName.startsWith("keycloak"))
        if (!intermediateImportedAspect.qualifiedName.startsWith("keycloak"))
            return
        when (intermediateImportedAspect.name) {
            "User" -> {
                intermediateImportedAspect.getPropertyValue("groups")?.splitAndTrim(",")?.let {
                    if (!(it checkIfAllValid ModelsContext.State.groups.toList()))
                        error(
                            "The following groups do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.groups.toList()}",
                            intermediateImportedAspect,
                            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
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
                        error(
                            "The following client roles do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.clientRoles.toList()}",
                            intermediateImportedAspect,
                            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
                        )
                }
            }
            "Group" -> {
                intermediateImportedAspect.getPropertyValue("realmRoles")?.splitAndTrim(",")?.let {
                    if (!(it checkIfAllValid ModelsContext.State.realmRoles.toList()))
                        error(
                            "The following realm roles do not exist: " +
                                    "${it getInvalidEntries ModelsContext.State.realmRoles.toList()}",
                            intermediateImportedAspect,
                            IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
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
                                error(
                                    "Only one of the following values is allowed as access type: " +
                                            accessTypes.joinToString(", "),
                                    intermediateImportedAspect,
                                    IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
                                )
                            if (value == "confidential" && intermediateImportedAspect.getPropertyValue("redirectURL")
                                    .isNullOrEmpty()
                            ) error(
                                "If the access type is \"confidential\" a redirectURL must be specified!",
                                intermediateImportedAspect,
                                IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
                            )
                        }
                        "clientProtocol" -> {
                            val clientProtocols = listOf("openid-connect", "saml")
                            if (value !in clientProtocols)
                                error(
                                    "Only one of the following values is allowed as clientProtocol: " +
                                            clientProtocols.joinToString(", "),
                                    intermediateImportedAspect,
                                    IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE__ASPECTS
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
}