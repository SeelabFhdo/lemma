package de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils

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
    }
}

fun String.fixPath() = this.replace("/./", "/").replace("//", "/")