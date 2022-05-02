package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletStateAccess
import de.fhdo.lemma.model_processing.utils.packageToPath


internal object Context {

    object State {
        private val propertyFiles = mutableMapOf<String, MutableSet<Pair<String, String>>>()

        fun initialize() {
            propertyFiles.clear()
        }

        fun reset() {
            propertyFiles.clear()
        }

        fun addPropertiesToFile(fileName: String, properties: Set<Pair<String, String>>) {
            properties.forEach { property ->
                when (property.first) {
                    "keyStoreRelativePath", "trustStoreRelativePath", "qualifiedName" -> {}
                    "keyStoreFileName", "trustStoreFileName" -> {
                        val applicationName = properties.find { it.first == "qualifiedName" }!!.second
                        addPropertyToFile(
                            fileName,
                            Pair(
                                springPropertyMapping(property.first),
                                property.second.replace("##applicationName##", applicationName.packageToPath())
                                    .replace("./", "/").replace("//", "/")
                            )
                        )
                    }
                    else -> {
                        addPropertyToFile(fileName, Pair(springPropertyMapping(property.first), property.second))
                    }
                }
            }
        }

        private fun addPropertyToFile(fileName: String, property: Pair<String, String>) {
            if (propertyFiles.contains(fileName)) {
                propertyFiles[fileName]!!.add(property)
            } else {
                propertyFiles[fileName] = mutableSetOf(property)
            }
        }

        fun getPropertyFiles() = propertyFiles
    }
}

