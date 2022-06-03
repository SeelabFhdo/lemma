package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils

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