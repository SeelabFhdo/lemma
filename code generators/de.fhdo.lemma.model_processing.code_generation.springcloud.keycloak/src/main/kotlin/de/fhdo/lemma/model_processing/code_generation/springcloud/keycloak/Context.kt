package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.PermissionsInterface

internal object Context {

    object State {
        private val interfaces = mutableListOf<PermissionsInterface>()

        fun initialize() {
            interfaces.clear()
        }

        fun addInterface(myInterface : PermissionsInterface){
            interfaces.add(myInterface)
        }

        fun getInterfaces() = interfaces.toList()
    }
}

