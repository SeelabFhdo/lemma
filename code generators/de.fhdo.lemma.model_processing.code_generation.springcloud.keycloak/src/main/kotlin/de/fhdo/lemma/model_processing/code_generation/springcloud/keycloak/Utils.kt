package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import org.eclipse.emf.common.util.EList


data class Properties(val filename: String, val fileType: FileType, val propertiesSet: MutableSet<Pair<String, String>>)

internal fun IntermediateMicroservice.getAspectValueOrDefault(fullyQualifiedName: String): Set<Pair<String, String>> {
    val setOfProperties = mutableSetOf<Pair<String, String>>()
    this.getAllAspects(fullyQualifiedName).forEach { aspect ->
        aspect.properties.forEach { property ->
            when (property.name) {
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

fun springPropertyMapping(key: String) = when (key) {
    "authServerUrl" -> "keycloak.auth-server-url"
    "realm" -> "keycloak.realm"
    "resource" -> "keycloak.resource"
    "enabled" -> "keycloak.enabled"
    "bearerOnly" -> "keycloak.bearer-only"
    "sslRequired" -> "keycloak.ssl-required"
    "principalAttribute" -> "keycloak.principal-attribute"
    else -> key
}

enum class FileType {
    APPLICATION_PROPERTIES,
    CLIENT_CERTIFICATE_PROPERTIES,
    CA_CERTIFICATE_PROPERTIES;

    companion object {
        internal fun filter(fileType: FileType) = when (fileType) {
            APPLICATION_PROPERTIES -> {
                listOf(
                    "applicationName", springPropertyMapping("applicationName"),
                    "clientAuth", springPropertyMapping("clientAuth"),
                    "hostnameVerifierBypass", springPropertyMapping("hostnameVerifierBypass"),
                    "keyStoreFileName", springPropertyMapping("keyStoreFileName"),
                    "keyStorePassword", springPropertyMapping("keyStorePassword"),
                    "trustStoreFileName", springPropertyMapping("trustStoreFileName"),
                    "trustStorePassword", springPropertyMapping("trustStorePassword"),
                    "realm", springPropertyMapping("realm"),
                    "resource", springPropertyMapping("resource"),
                    "enabled", springPropertyMapping("enabled"),
                    "bearerOnly", springPropertyMapping("bearerOnly"),
                    "sslRequired", springPropertyMapping("sslRequired"),
                    "principalAttribute", springPropertyMapping("principalAttribute"),
                    "authServerUrl", springPropertyMapping("authServerUrl"),
                )
            }
            CLIENT_CERTIFICATE_PROPERTIES -> {
                listOf(
                    "applicationName", springPropertyMapping("applicationName"),
                    "bitLength", springPropertyMapping("bitLength"),
                    "keyStoreFileName", springPropertyMapping("keyStoreFileName"),
                    "keyStorePassword", springPropertyMapping("keyStorePassword"),
                    "caDomain", springPropertyMapping("caDomain"),
                    "trustStoreFileName", springPropertyMapping("trustStoreFileName"),
                    "trustStorePassword", springPropertyMapping("trustStorePassword"),
                    "validityInDays", springPropertyMapping("validityInDays"),
                )
            }
            CA_CERTIFICATE_PROPERTIES -> {
                listOf(
                    "bitLength", springPropertyMapping("bitLength"),
                    "caCertFile", springPropertyMapping("caCertFile"),
                    "caCertificatePassword", springPropertyMapping("caCertificatePassword"),
                    "caDomain", springPropertyMapping("caDomain"),
                    "caKeyFile", springPropertyMapping("caKeyFile"),
                    "caName", springPropertyMapping("caName"),
                    "certificateStandard", springPropertyMapping("certificateStandard"),
                    "cipher", springPropertyMapping("cipher"),
                    "subject", springPropertyMapping("subject"),
                    "validityInDays", springPropertyMapping("validityInDays"),
                )
            }
        }

        internal fun filePath(fileType: FileType) = when (fileType) {
            APPLICATION_PROPERTIES -> {
                GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH
            }
            CLIENT_CERTIFICATE_PROPERTIES, CA_CERTIFICATE_PROPERTIES -> {
                GenletPathSpecifier.CURRENT_MICROSERVICE_ROOT_PATH
            }
        }
    }
}