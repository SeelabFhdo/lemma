package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.Interface
import org.eclipse.jdt.internal.compiler.ast.FakedTrackingVariable.IteratorForReporting

internal object Context {

    object State {
        private val interfaces = mutableListOf<Interface>()

        fun initialize() {
            interfaces.clear()
        }

        fun addInterface(myInterface : Interface){
            interfaces.add(myInterface)
        }

        fun getInterfaces() = interfaces.toList()
    }
}

