package de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler

import com.google.common.collect.ImmutableMap
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.utils.packageToPath

import java.io.File

internal object MainContext {
    object State {
        //
        private val propertyFiles = mutableMapOf<String, SortableProperties>()
        private lateinit var targetFolder: String

        fun initialize(targetFolder: String) {
            this.targetFolder = targetFolder
            propertyFiles.clear()
        }

        fun generateFilePath(currentMicroserviceName: String, vararg folders: String) =
            listOf(
                targetFolder,
                currentMicroserviceName.packageToPath(),
                folders.asList()
            ).joinToString(File.separator)

        fun addPropertyFile(name: String, properties: SortableProperties, vararg  folders: String){
            propertyFiles[generateFilePath(name, *folders)] = properties
        }

        fun getpropertyFiles() = ImmutableMap<String, SortableProperties>(this.propertyFiles as Imm)


    }
}