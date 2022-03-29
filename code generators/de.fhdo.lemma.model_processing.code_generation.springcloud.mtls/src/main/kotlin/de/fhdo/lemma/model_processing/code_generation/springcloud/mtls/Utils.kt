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
                    springPropertyMapping(aspect.qualifiedName + "." + property.name),
                    aspect.propertyValues.findValue(property.name) ?: property.defaultValue
                )
            )
        }
    }
    return setOfProperties
}

private fun EList<IntermediateAspectPropertyValue>.findValue(name: String) =
    find { it.property.name.equals(name) }?.value

private fun springPropertyMapping(property: String) = when (property) {
    "mTLS.Keystore.path", "mTLS.TestKeystore.path" -> "server.ssl.key-store"
    "mTLS.Keystore.password", "mTLS.TestKeystore.password" -> "server.ssl.key-store-password"
    "mTLS.Truststore.path", "mTLS.TestTruststore.path" -> "server.ssl.trust-store"
    "mTLS.Truststore.password", "mTLS.TestTruststore.password" -> "server.ssl.trust-store-password"
    "mTLS.Keystore.validityInDays", "mTLS.TestKeystore.validityInDays" -> "server.ssl.key-store.validityInDays"
    "mTLS.Truststore.validityDays", "mTLS.TestTruststore.validityInDays" -> "server.ssl.trust-store.validityInDays"
    "mTLS.Keystore.hostnameVerifierBypass",
    "mTLS.TestKeystore.hostnameVerifierBypass" -> "server.ssl.bypass.hostname-verifier"
    "mTLS.Keystore.alias", "mTLS.TestKeystore.alias" -> "server.ssl.key-alias"
    else -> property
}