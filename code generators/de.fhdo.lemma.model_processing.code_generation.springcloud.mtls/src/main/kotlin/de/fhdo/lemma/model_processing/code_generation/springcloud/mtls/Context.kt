package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletStateAccess


internal object Context {

    object State {
        private val propertyFiles = mutableMapOf<String, MutableSet<Pair<String, String>>>()

        fun initialize() {
            propertyFiles.clear()
        }

        fun reset() {
            propertyFiles.clear()
        }

        fun addPropertyToFile(fileName: String, property: Pair<String, String>) {
            if (propertyFiles.contains(fileName)) {
                propertyFiles[fileName]!!.add(property)
            } else {
                propertyFiles[fileName] = mutableSetOf(property)
            }
        }

        fun addPropertiesToFile(fileName: String, properties: Set<Pair<String, String>>) {
            properties.forEach{
                addPropertyToFile(fileName, it)
            }
        }
        fun getPropertyFiles() = propertyFiles
    }
}

