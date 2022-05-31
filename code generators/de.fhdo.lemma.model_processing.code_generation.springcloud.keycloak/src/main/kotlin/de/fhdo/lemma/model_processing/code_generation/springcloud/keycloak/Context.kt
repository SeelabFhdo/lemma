package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.PermissionsInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

internal object Context {

    object State {
        private val interfaces = mutableListOf<PermissionsInterface>()
        private var currentIntermediateMicroservice: IntermediateMicroservice? = null


        fun initialize(currentIntermediateMicroservice: IntermediateMicroservice){
            this.currentIntermediateMicroservice = currentIntermediateMicroservice
        }

        fun getPackage() = currentIntermediateMicroservice?.fullyQualifiedClassname?.lowercase()

        fun addInterface(myInterface : PermissionsInterface){
            interfaces.add(myInterface)
        }

        fun reset(){
            interfaces.clear()
            currentIntermediateMicroservice = null
        }

        fun getInterfaces() = interfaces.toList()
    }
}

