package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils

import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import java.io.File
import javax.swing.plaf.basic.BasicPopupMenuSeparatorUI

fun MutableMap<String, Any>.putTypedValue(type: String, key: String, value: String) = when (type) {
    "boolean" -> this.put(key, value.toBoolean())
    "byte" -> this.put(key, value.toByte())
    "double" -> this.put(key, value.toDouble())
    "float" -> this.put(key, value.toFloat())
    "int" -> this.put(key, value.toInt())
    "long" -> this.put(key, value.toLong())
    "short" -> this.put(key, value.toShort())
    else -> this.put(key, value)
}

fun applicationPropertiesKeyMapper(key: String) = when (key) {
    "authServerUrl" -> "keycloak.auth-server-url"
    "realm" -> "keycloak.realm"
    "resource" -> "keycloak.resource"
    "enabled" -> "keycloak.enabled"
    "bearerOnly" -> "keycloak.bearer-only"
    "sslRequired" -> "keycloak.ssl-required"
    "principalAttribute" -> "keycloak.principal-attribute"
    "clientProtocol" -> "protocol"
    else -> key
}

fun keycloakPropertiesKeyMapper(key: String) = when (key) {
    "clientProtocol" -> "protocol"
    else -> key
}

fun ObjectNode.addAndCastTo(key: String, value: Any): ObjectNode = when (value) {
    is Int -> this.put(key, value)
    is Long -> this.put(key, value)
    is Double -> this.put(key, value)
    is String -> this.put(key, value)
    is Boolean -> this.put(key, value)
    else -> this.put(key, value.toString())
}

internal fun IntermediateOperationNode.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }
internal fun IntermediateInterface.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }
internal fun IntermediateOperation.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }
internal fun IntermediateMicroservice.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }

internal fun IntermediateImportedAspect.getPropertiesValuesOrDefault(): Map<String, Any> {
    val properties = mutableMapOf<String, Any>()
    this.properties.forEach { aspectPropterty ->
        aspectPropterty.defaultValue?.let { properties.putTypedValue(aspectPropterty.type, aspectPropterty.name, it) }
    }
    this.propertyValues.forEach {
        properties.putTypedValue(it.property.type, it.property.name, it.value)
    }
    return properties.toMap()
}

internal fun loadPropertiesFile(filePath: String): SortableProperties {
    val file = filePath.asFile()
    val sortableProperties = SortableProperties()
    if (file.exists()) sortableProperties.load(file.inputStream())
    return sortableProperties
}

internal fun SortableProperties.asFormattedString(): String {
    var formattedString = ""
    entries.forEach {
        formattedString += "${it.key}=${it.value}\n"
    }
    return formattedString
}

internal fun InfrastructureNode.isKeycloakRealm() =
    (infrastructureTechnology.infrastructureTechnology.name == "keycloakRealm"
            && infrastructureTechnology.infrastructureTechnology.technology.name == "Keycloak")


internal fun IntermediateInfrastructureNode.getPropertiesFormNodeAspectsForDeployedServices(aspectName: String):
        Map<String, Map<String, String>>? {
    if (!hasAspect(setOf(aspectName))) return null
    return mapOf(Pair(name, getAspectsAsMap(this, aspectName)))
}

internal fun IntermediateContainer.getPropertiesFormNodeAspectsForDeployedServices(aspectName: String):
        Map<String, Map<String, String>>? {
    if (!hasAspect(setOf(aspectName))) return null
    val resultMap = mutableMapOf<String, Map<String, String>>()
    deployedServices.forEach { service ->
        resultMap[service.qualifiedName] = getAspectsAsMap(this, aspectName)
    }
    return resultMap
}

private fun getAspectsAsMap(intermediateOperationNode: IntermediateOperationNode, aspectName: String) =
    intermediateOperationNode.aspects.findLast { it.name == aspectName }.let { aspect ->
        val propertyMap = mutableMapOf<String, String>()
        aspect!!.properties.forEach { property ->
            getPropertyValue(aspect, property.name)?.let {
                propertyMap[property.name] = it
            }
        }
        propertyMap.toMap()
    }

private fun getPropertyValue(aspect: IntermediateImportedAspect, propertyName: String) = when (propertyName) {
    "keyStoreRelativePath", "trustStoreRelativePath" -> null
    "keyStoreFileName" -> setOf(
        aspect.getAspectValueOrDefault("trustStoreRelativePath"), aspect.getAspectValueOrDefault(propertyName)
    ).joinToString(File.separator)
    "trustStoreFileName" -> setOf(
        aspect.getAspectValueOrDefault("keyStoreRelativePath"), aspect.getAspectValueOrDefault(propertyName)
    ).joinToString(File.separator)
    else -> aspect.getAspectValueOrDefault(propertyName)
}

internal fun SortableProperties.addProperty(property: Pair<String, String>) {
    this[property.first] = property.second
}

private fun IntermediateImportedAspect.getAspectValueOrDefault(aspectName: String): String? {
    val defaultValue = properties.find { it.name == aspectName }?.defaultValue
    val aspectValue = propertyValues.find { it.property.name == aspectName }?.value
    return if (aspectValue.isNullOrEmpty()) defaultValue else aspectValue
}


fun isConformApplicationNames(applicationNames: String): Boolean {
//    ([a-z0-9_.]+[ ]?[=][ ]?[a-z0-9_.]+)((,)([a-z0-9_.]+[ ]?[=][ ]?[a-z0-9_.]+))*
//    matches follow strings:
//    "com.myexample.name1=ms1"
//    "com.myexample.name1=ms1,com.myexample.name2=name2"
//    "com.myexample.name1 =ms1,com.myexample.name2= name2,com.myexample.name3 = ms3"

    val nameChars = "[a-z0-9_.]+"
    val equal = "[ ]?[=][ ]?"
    return applicationNames.matches(
        """(${nameChars}${equal}${nameChars})((,)(${nameChars}${equal}${nameChars}))*""".toRegex()
    )
}

fun isValidSystemEnvironmentVariable(environmentVariable: String) =
    environmentVariable.matches("[\$][{]([\\w_])+[}]".toRegex())

private fun getAllSystemEnvironmentVariable(environmentVariable: String) =
    "[\$][{][\\w-#~,+*?^(){\$\\[\\]|.]+[}]".toRegex().findAll(environmentVariable).toList()

fun hasAnyInvalidSystemEnvironmentVariable(environmentVariable: String) =
    getAllSystemEnvironmentVariable(environmentVariable).any { matchResult ->
        !matchResult.groupValues.any { isValidSystemEnvironmentVariable(it) }
    }

fun parseApplicationNames(applicationNames: String): Map<String, String> {
    val retval = mutableMapOf<String, String>()
    if (!isConformApplicationNames(applicationNames)) return mapOf(Pair(applicationNames, applicationNames))
    applicationNames.split(",").forEach {
        retval[it.split("=")[0].trim()] = it.split("=")[1].trim()
    }
    return retval
}

fun checkJsonKeyValue(jsonKeyValueString: String): Boolean {
    val quot = "[[\"]|[\']]"
    val key = "$quot{1}[\\w]+$quot{1}"
    val value = "$quot?[\\w]+$quot?"
    val keyValue = "$key\\s*:\\s*$value"
    val jsonKeyValueRegex = "[{][\\s]*$keyValue+[\\s]*[,$keyValue]*[\\s]*[}]".toRegex()
    return jsonKeyValueString.matches(jsonKeyValueRegex)
}

fun String.splitAndTrim(separator: String) = this.split(separator).map { it.trim() }


infix fun List<String>.checkIfAllValid(checkList: List<String>) = map { it in checkList }.all { it }
infix fun List<String>.getInvalidEntries(checkList: List<String>) = this.filter { it !in checkList }