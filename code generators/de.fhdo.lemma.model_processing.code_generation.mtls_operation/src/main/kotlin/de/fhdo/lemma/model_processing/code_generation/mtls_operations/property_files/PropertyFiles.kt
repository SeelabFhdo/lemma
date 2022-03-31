package de.fhdo.lemma.model_processing.code_generation.mtls_operations.property_files

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import java.io.FileInputStream

class PropertyFiles (val filePath: String, private val properties: SortableProperties) {
    companion object{
        internal fun loadFromFilePath(filePath: String) : PropertyFile {
            val properties = SortableProperties()
            properties.load(FileInputStream(filePath))
            return PropertyFile(filePath, properties)
        }
    }
}