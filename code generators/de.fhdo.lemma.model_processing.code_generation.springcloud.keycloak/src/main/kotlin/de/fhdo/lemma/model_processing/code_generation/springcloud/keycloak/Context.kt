package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.PermissionsInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice


internal object Context {

    object State {
        private val interfaces = mutableListOf<PermissionsInterface>()
        private var currentIntermediateMicroservice: IntermediateMicroservice? = null
        private val propertyFiles = mutableMapOf<String, Properties>()

        fun initialize(currentIntermediateMicroservice: IntermediateMicroservice){
            this.currentIntermediateMicroservice = currentIntermediateMicroservice
            propertyFiles.clear()
        }

        fun getPackage() = currentIntermediateMicroservice?.fullyQualifiedClassname?.lowercase()

        fun addInterface(myInterface : PermissionsInterface){
            interfaces.add(myInterface)
        }

        fun addPropertiesToFile(fileName: String, propertiesSet: Set<Pair<String, String>>, fileType: FileType) {
            val properties = Properties(fileName, fileType, mutableSetOf())
            propertiesSet.forEach { property ->
                properties.propertiesSet.add(property)
            }
            propertyFiles[fileName] = properties
        }

        fun reset(){
            interfaces.clear()
            propertyFiles.clear()
            currentIntermediateMicroservice = null
        }

        fun getInterfaces() = interfaces.toList()

        fun getPropertyFiles() = propertyFiles
    }
}

