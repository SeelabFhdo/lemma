package de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler


import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.FileType
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.generateFilePath
import de.fhdo.lemma.model_processing.utils.packageToPath

import java.io.File

internal object MainContext {
    object State {
        //
        private val propertyFiles = mutableMapOf<String, SortableProperties>()
        private lateinit var targetFolder: String
        private lateinit var currentMicroservicePackage: String


        fun initialize(targetFolder: String) {
            State.targetFolder = targetFolder.trimEnd(File.separatorChar)
            propertyFiles.clear()
        }

        fun getCurrentMicroservicePackage() = currentMicroservicePackage

        fun setCurrentMicroservicePackage(currentMicroservicePackage: String) {
            State.currentMicroservicePackage = currentMicroservicePackage
        }

        fun getTargetFolder() = targetFolder

        fun addPropertyFile(
            fileName: String,
            properties: SortableProperties,
            fileType: FileType,
            servicePackage: String
        ) {
            val pathSpecifier = fileType.filePath()
            propertyFiles[generateFilePath(getPath(pathSpecifier, servicePackage), fileName)] = properties
        }

        fun getPropertyFiles(): Map<String, SortableProperties> {
            return propertyFiles.toMap()
        }

        /**
         * Helper to calculate the target folder path of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPath(servicePackage: String) =
            "$targetFolder${File.separator}$servicePackage.packageToPath()"


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


    }
}

internal fun FileType.filePath() = when (this) {
    FileType.APPLICATION_PROPERTIES -> {
        PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH
    }
    FileType.CLIENT_CERTIFICATE_PROPERTIES, FileType.CA_CERTIFICATE_PROPERTIES -> {
        PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH
    }
}

enum class PathSpecifier {
    CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
    CURRENT_MICROSERVICE_RESOURCES_PATH,
    CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
    CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH
}


