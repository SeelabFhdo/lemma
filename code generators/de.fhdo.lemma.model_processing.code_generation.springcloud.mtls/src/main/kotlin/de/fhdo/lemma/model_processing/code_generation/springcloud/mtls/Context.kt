package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

data class Properties(val filename: String, val fileType: FileType, val propertiesSet: MutableSet<Pair<String, String>>)

internal object Context {

    object State {
        private val propertyFiles = mutableMapOf<String, Properties>()

        fun initialize() {
            propertyFiles.clear()
        }

        fun reset() {
            propertyFiles.clear()
        }

        fun addPropertiesToFile(fileName: String, propertiesSet: Set<Pair<String, String>>, fileType: FileType) {
            val properties = Properties(fileName, fileType, mutableSetOf())
            propertiesSet.forEach { property ->
                properties.propertiesSet.add(property)
            }
            propertyFiles[fileName] = properties
        }

        fun getPropertyFiles() = propertyFiles

    }
}

