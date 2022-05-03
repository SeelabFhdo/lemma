package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import org.eclipse.emf.common.util.EList
import java.io.File

internal fun IntermediateMicroservice.getAspectValueOrDefault(fullyQualifiedName: String): Set<Pair<String, String>> {
    val setOfProperties = mutableSetOf<Pair<String, String>>()
    this.getAllAspects(fullyQualifiedName).forEach { aspect ->
        aspect.properties.forEach { property ->
            when (property.name) {
                "keyStoreRelativePath", "trustStoreRelativePath" -> {}
                "keyStoreFileName" -> setOfProperties.add(
                    Pair(
                        property.name,
                        setOf(
                            aspect.getAspectValueOrDefault("keyStoreRelativePath"),
                            aspect.getAspectValueOrDefault(property.name)
                        ).joinToString(File.separator)
                    )
                )
                "trustStoreFileName" -> setOfProperties.add(
                    Pair(
                        property.name,
                        setOf(
                            aspect.getAspectValueOrDefault("trustStoreRelativePath"),
                            aspect.getAspectValueOrDefault(property.name)
                        ).joinToString(File.separator)
                    )
                )
                else -> setOfProperties.add(
                    Pair(
                        property.name,
                        aspect.propertyValues.findValue(property.name) ?: property.defaultValue
                    )
                )
            }
        }
    }
    setOfProperties.add(Pair("qualifiedName", this.qualifiedName))
    return setOfProperties
}

private fun IntermediateImportedAspect.getAspectValueOrDefault(aspectName: String): String? {
    val defaultValue = properties.find { it.name == aspectName }?.defaultValue
    val aspectValue = propertyValues.find { it.property.name == aspectName }?.value
    return if (aspectValue.isNullOrEmpty()) defaultValue else aspectValue
}

private fun EList<IntermediateAspectPropertyValue>.findValue(name: String) =
    find { it.property.name.equals(name) }?.value

fun springPropertyMapping(property: String) = when (property) {
    "keyStoreFileName" -> "server.ssl.key-store"
    "keyStorePassword" -> "server.ssl.key-store-password"
    "trustStoreFileName" -> "server.ssl.trust-store"
    "trustStorePassword" -> "server.ssl.trust-store-password"
    "hostnameVerifierBypass" -> "server.ssl.bypass.hostname-verifier"
    "validityInDays" -> "server.ssl.key-store.validityInDays"
    "bitLength" -> "server.ssl.bitLength"
    "caName" -> "server.ssl.ca-name"
    "caCertificatePassword" -> "server.ssl.server.ca-password"
    "caDomain" -> "server.ssl.ca-domain.name"
    "certificateStandard" -> "server.ssl.certificateStandard"
    "cipher" -> "server.ssl.cipher"
    "caKeyFile" -> "server.ssl.ca-key.file"
    "caCertFile" -> "server.ssl.ca-Cert.file"
    "subject" -> "server.ssl.subject"
    "applicationName" -> "server.ssl.applicationName"
    else -> property
}
