package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils

import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation

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

internal fun IntermediateImportedAspect.getPropertiesValuesOrDefault(): Map<String, Any>{
    val properties = mutableMapOf<String, Any>()
    this.properties.forEach { aspectPropterty ->
        aspectPropterty.defaultValue?.let {properties.putTypedValue(aspectPropterty.type, aspectPropterty.name, it)}
    }
    this.propertyValues.forEach {
        properties.putTypedValue(it.property.type, it.property.name, it.value)
    }
    return properties.toMap()
}