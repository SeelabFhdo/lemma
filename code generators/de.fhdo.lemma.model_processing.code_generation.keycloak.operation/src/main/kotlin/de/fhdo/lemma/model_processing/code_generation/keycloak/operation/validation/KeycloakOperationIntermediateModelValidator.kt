package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
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
            when (aspect.name) {
                "user" -> {
                    // groups: prüfen ob alle Gruppen vorhanden sind
                    // realmRoles: prüfen ob alle realmRoles vorhanden sind
                    // clientRoles: prüfen ob alle clientRoles vorhanden sind
                }
                "group" -> {
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


    private fun getAllRealmRoles(): List<String> {

        return listOf<String>()
    }

    private fun getAllClientRoles(): List<String> {

        return listOf<String>()
    }

}