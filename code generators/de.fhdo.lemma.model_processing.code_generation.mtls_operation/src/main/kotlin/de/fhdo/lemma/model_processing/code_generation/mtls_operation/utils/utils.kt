package de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties

internal fun loadPropertiesFile(filePath: String): SortableProperties {
    val file = filePath.asFile()
    val sortableProperties = SortableProperties()
    if (file.exists())
        sortableProperties.load(file.inputStream())
    return sortableProperties
}

internal fun SortableProperties.asFormattedString(): String {
    var formattedString = ""
    entries.forEach {
        formattedString += "${it.key}=${it.value}\n"
    }
    return formattedString
}


//key, value ->
//