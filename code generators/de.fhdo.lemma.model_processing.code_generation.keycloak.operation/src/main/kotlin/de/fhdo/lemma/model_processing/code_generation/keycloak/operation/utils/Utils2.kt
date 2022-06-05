package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils

import com.fasterxml.jackson.databind.node.ObjectNode
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.service.intermediate.IntermediateInterface
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

fun propertiesKeyMapper(key: String) = when (key) {
    "authServerUrl" -> "keycloak.auth-server-url"
    "realm" -> "keycloak.realm"
    "resource" -> "keycloak.resource"
    "enabled" -> "keycloak.enabled"
    "bearerOnly" -> "keycloak.bearer-only"
    "sslRequired" -> "keycloak.ssl-required"
    "principalAttribute" -> "keycloak.principal-attribute"
    else -> key
}

fun ObjectNode.addAndCastTo(key: String, value: Any) = when (value) {
    is Int -> this.put(key, value as Int)
    is Long -> this.put(key, value as Long)
    is Double -> this.put(key, value as Double)
    is String -> this.put(key, value as String)
    is Boolean -> this.put(key, value as Boolean)
    else -> this.put(key, value.toString())
}

internal fun IntermediateOperationNode.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }
internal fun IntermediateInterface.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }
internal fun IntermediateOperation.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }

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