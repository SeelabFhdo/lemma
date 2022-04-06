package de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

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

internal fun InfrastructureNode.isCertificateAuthority() =
    (infrastructureTechnology.infrastructureTechnology.name == "certificateAuthority"
            && infrastructureTechnology.infrastructureTechnology.technology.name == "mTLS")

internal fun IntermediateOperationNode.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }

internal fun IntermediateOperationNode.getNodeAspectsWithValues(aspectName: String): Map<String,String> {
    val resultMap = mutableMapOf<String, String>()
    aspects.filter { it.name == aspectName }.forEach { aspect ->
        aspect.properties.filter {
            !it.defaultValue.isNullOrEmpty()
        }.forEach { property ->
            resultMap[springPropertyMapping(property.name)] = property.defaultValue
        }
        aspect.propertyValues.forEach { propertyValue ->
            resultMap[springPropertyMapping(propertyValue.property.name)] = propertyValue.value
        }
    }
    return resultMap
}

internal fun SortableProperties.addProperty(property: Pair<String,String>){
    this[springPropertyMapping(property.first)] = property.second
}

fun springPropertyMapping(property: String) = when (property) {
    "keyStoreRelativPath" -> "server.ssl.key-store"
    "keyStorePassword" -> "server.ssl.key-store-password"
//    "aliasPrefix", "aliasSuffix" -> "server.ssl.key-alias"
    "aliasPrefix" -> "server.ssl.key-aliasPrefix"
    "aliasSuffix" -> "server.ssl.key-aliasSuffix"
    "trustStoreRelativPath" -> "server.ssl.trust-store"
    "trustStorePassword" -> "server.ssl.trust-store-password"
    "hostnameVerifierBypass" -> "server.ssl.bypass.hostname-verifier"
    "validityInDays" -> "server.ssl.key-store.validityInDays"
    "bitLength" -> "server.ssl.bitLength"
    else -> property
}
