package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler

import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

internal object ModelsContext {

    object State{
        internal var intermediateServiceModels: MutableList<IntermediateServiceModel> = mutableListOf()
        internal var realmRoles: MutableSet<String> = mutableSetOf()
        internal var clientRoles: MutableSet<String> = mutableSetOf()
        internal var groups: MutableSet<String> = mutableSetOf()

    }
}