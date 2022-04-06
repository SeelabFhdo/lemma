package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

internal fun EObject.getAspectValueOrDefault(fullyQualifiedName: String): Set<Pair<String, String>> {
    val setOfProperties = mutableSetOf<Pair<String, String>>()
    this.getAllAspects(fullyQualifiedName).forEach { aspect ->
        aspect.properties.forEach { property ->
            setOfProperties.add(
                Pair(
                    springPropertyMapping(property.name),
                    aspect.propertyValues.findValue(property.name) ?: property.defaultValue
                )
            )
        }
    }
    return setOfProperties
}

private fun EList<IntermediateAspectPropertyValue>.findValue(name: String) =
    find { it.property.name.equals(name) }?.value

fun springPropertyMapping(property: String) = when (property) {
    "keyStoreRelativPath" -> "server.ssl.key-store"
    "keyStorePassword" -> "server.ssl.key-store-password"
    "aliasPrefix", "aliasSuffix" -> "server.ssl.key-alias"
    "trustStoreRelativPath" -> "server.ssl.trust-store"
    "trustStorePassword" -> "server.ssl.trust-store-password"
    "hostnameVerifierBypass" -> "server.ssl.bypass.hostname-verifier"
    "validityInDays" -> "server.ssl.key-store.validityInDays"
    "bitLength" -> "server.ssl.bitLength"
    else -> property
}