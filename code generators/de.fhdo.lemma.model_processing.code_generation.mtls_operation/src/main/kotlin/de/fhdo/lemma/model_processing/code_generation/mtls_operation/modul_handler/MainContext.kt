package de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler


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

        fun getTargetFolder() = this.targetFolder

        fun addPropertyFile(name: String, properties: SortableProperties, vararg  folders: String){
            val test = generateFilePath(name, *folders)
            println(test)
            propertyFiles[generateFilePath(name, *folders)] = properties
        }

        fun getPropertyFiles() = this.propertyFiles.toMap()


    }
}

fun generateFilePath(currentMicroserviceName: String, vararg folders: String) =
    listOf(
        MainContext.State.getTargetFolder(),
        currentMicroserviceName.packageToPath(),
        *folders
    ).joinToString(File.separator)