package de.fhdo.reconstruction.framework.modules.common

data class MetaData(
    val name: String,
    val values: MutableMap<String, String> = mutableMapOf()
)

fun createMetaData(name: String) = MetaData(name)

