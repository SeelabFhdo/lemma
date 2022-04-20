package de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler


import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.springPropertyMapping
import de.fhdo.lemma.model_processing.utils.packageToPath

import java.io.File

internal object MainContext {
    object State {
        //
        private val propertyFiles = mutableMapOf<String, SortableProperties>()
        private lateinit var targetFolder: String
        private lateinit var currentMicroservicePackage: String


        fun initialize(targetFolder: String) {
            State.targetFolder = targetFolder
            propertyFiles.clear()
        }

        fun getCurrentMicroservicePackage() = this.currentMicroservicePackage

        fun setCurrentMicroservicePackage(currentMicroservicePackage: String) {
            this.currentMicroservicePackage = currentMicroservicePackage
        }

        fun getTargetFolder() = targetFolder

        fun addPropertyFile(fileName: String, properties: SortableProperties, pathSpecifier: PathSpecifier, servicePackage: String) {
            propertyFiles[generateFilePath(getPath(pathSpecifier, servicePackage), fileName)] = properties
        }

        fun getPropertyFiles(): Map<String, SortableProperties> {
            generateCombinedProperties("mtls")
            generateCombinedProperties("mtlsdev")

            return propertyFiles.toMap()
        }

        private fun generateCombinedProperties(profile: String) {
            if (profile !in setOf("mtls", "mtlsdev"))
                return
            var domain = ""
            // Subject is the combination of caName and caDomain
            propertyFiles.filter { it.key.contains("${profile}.var") && it.key.contains("CertificationAuthority") }
                .forEach {
                    domain = it.value[springPropertyMapping("caDomain")] as String
                    it.value[springPropertyMapping("subject")] =
                        "${it.value[springPropertyMapping("caName")]}${if (domain.isNotEmpty()) ".${domain}" else ""}"
                }
            propertyFiles.filter { it.key.contains("${profile}.var") && it.key.contains("Certificate") }
                .forEach {
                    it.value[springPropertyMapping("subject")] =
                        "${it.value[springPropertyMapping("applicationName")]}${if (domain.isNotEmpty()) ".${domain}" else ""}"
                }
            // Set correct
        }

        /**
         * Helper to calculate the target folder path of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPath(servicePackage: String) =
            "${targetFolder}${File.separator}$servicePackage.packageToPath()"


        /**
         * Helper to calculate the target folder path for Java files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForJavaFiles(servicePackage: String) = listOf(
            targetFolder,
            servicePackage.packageToPath(),
            "src", "main", "java",
            servicePackage.packageToPath()
        ).joinToString(File.separator)


        /**
         * Helper to calculate the target folder path for resource files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForResourceFiles(servicePackage: String) = listOf(
            targetFolder,
            servicePackage.packageToPath(),
            "src", "main", "resources"
        ).joinToString(File.separator)


        /**
         * Helper to calculate the target folder path for resource files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForCertifications(servicePackage: String) = listOf(
            targetFolder,
            servicePackage.packageToPath(),
            "certs"
        ).joinToString(File.separator)

        fun getPath(pathSpecifier: PathSpecifier, servicePackage: String) = when (pathSpecifier) {
            PathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH -> currentMicroserviceTargetFolderPath(
                servicePackage
            )
            PathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH -> currentMicroserviceTargetFolderPathForJavaFiles(
                servicePackage
            )
            PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH -> currentMicroserviceTargetFolderPathForResourceFiles(
                servicePackage
            )
            PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH -> currentMicroserviceTargetFolderPathForCertifications(
                servicePackage
            )
        }

        fun generateFilePath(path: String, fileName: String) =
            listOf(
                path,
                fileName
            ).joinToString(File.separator)
    }
}

enum class PathSpecifier {
    CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
    CURRENT_MICROSERVICE_RESOURCES_PATH,
    CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
    CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH
}


