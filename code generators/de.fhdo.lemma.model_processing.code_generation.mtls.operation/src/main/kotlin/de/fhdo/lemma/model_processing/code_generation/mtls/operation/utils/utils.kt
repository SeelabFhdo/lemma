package de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler.filePath
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import java.io.File

internal fun loadPropertiesFile(filePath: String): SortableProperties {
    val file = filePath.asFile()
    val sortableProperties = SortableProperties()
    if (file.exists()) sortableProperties.load(file.inputStream())
    return sortableProperties
}

internal fun SortableProperties.asFormattedString(): String {
    val x = this.stringPropertyNames()


    var formattedString = ""
    entries.forEach {
        formattedString += "${it.key}=${it.value}\n"
    }
    return formattedString
}

internal fun InfrastructureNode.isCertificateAuthority() =
    (infrastructureTechnology.infrastructureTechnology.name == "certificateAuthority"
            && infrastructureTechnology.infrastructureTechnology.technology.name == "mTLS")

internal fun IntermediateOperationNode.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }

internal fun loadOrGeneratePropertiesEntries(
    filename: String, properties: Map<String, String>, fileType: FileType, serviceName: String
) {
    val pathSpecifier = fileType.filePath()
    val filePath = generateFilePath(MainContext.State.getPath(pathSpecifier, serviceName), filename)
    val sortableProperties = loadPropertiesFile(filePath)
    properties.filter { it.key in FileType.filter(fileType) }.forEach { property ->
        when (property.key) {
            "applicationName" -> {
                val appName = parseApplicationNames(property.value)[serviceName.lowercase()]
                properties["caDomain"]?.let {
                    sortableProperties[springPropertyMapping("subject")] =
                        "${appName}.$it"
                }
                sortableProperties[springPropertyMapping(property.key)] = appName
            }
            "keyStoreFileName", "trustStoreFileName" -> {
                sortableProperties[springPropertyMapping(property.key)] =
                    property.value.replace("##applicationName##", serviceName.packageToPath()).fixPath()
            }
            "caName" -> {
                properties["caDomain"]?.let {
                    sortableProperties[springPropertyMapping("subject")] = "${property.value}.$it"
                }
                sortableProperties[springPropertyMapping(property.key)] = property.value
            }
            else -> sortableProperties[springPropertyMapping(property.key)] = property.value
        }
    }
    MainContext.State.addPropertyFile(filename, sortableProperties, fileType, serviceName)
}

internal fun IntermediateInfrastructureNode.getPropertiesFormNodeAspectsForDeployedServices(aspectName: String):
        Map<String, Map<String, String>>? {
    if (!hasAspect(setOf(aspectName))) return null
    return mapOf(Pair(name, getAspectsAsMap(this, aspectName)))
}

internal fun IntermediateContainer.getPropertiesFormNodeAspectsForDeployedServices(aspectName: String):
        Map<String, Map<String, String>>? {
    if (!hasAspect(setOf(aspectName))) return null
    val resultMap = mutableMapOf<String, Map<String, String>>()
    deployedServices.forEach { service ->
        resultMap[service.qualifiedName] = getAspectsAsMap(this, aspectName)
    }
    return resultMap
}

private fun getAspectsAsMap(intermediateOperationNode: IntermediateOperationNode, aspectName: String) =
    intermediateOperationNode.aspects.findLast { it.name == aspectName }.let { aspect ->
        val propertyMap = mutableMapOf<String, String>()
        aspect!!.properties.forEach { property ->
            getPropertyValue(aspect, property.name)?.let {
                propertyMap[property.name] = it
            }
        }
        propertyMap.toMap()
    }

private fun getPropertyValue(aspect: IntermediateImportedAspect, propertyName: String) = when (propertyName) {
    "keyStoreRelativePath", "trustStoreRelativePath" -> null
    "keyStoreFileName" -> setOf(
        aspect.getAspectValueOrDefault("trustStoreRelativePath"), aspect.getAspectValueOrDefault(propertyName)
    ).joinToString(File.separator)
    "trustStoreFileName" -> setOf(
        aspect.getAspectValueOrDefault("keyStoreRelativePath"), aspect.getAspectValueOrDefault(propertyName)
    ).joinToString(File.separator)
    else -> aspect.getAspectValueOrDefault(propertyName)
}

internal fun SortableProperties.addProperty(property: Pair<String, String>) {
    this[property.first] = property.second
}

private fun IntermediateImportedAspect.getAspectValueOrDefault(aspectName: String): String? {
    val defaultValue = properties.find { it.name == aspectName }?.defaultValue
    val aspectValue = propertyValues.find { it.property.name == aspectName }?.value
    return if (aspectValue.isNullOrEmpty()) defaultValue else aspectValue
}

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
    "applicationName" -> "server.ssl.key-alias"
    "clientAuth" -> "server.ssl.client-auth"
    else -> property
}

fun isConformApplicationNames(applicationNames: String): Boolean {
//    ([a-z0-9_.]+[ ]?[=][ ]?[a-z0-9_.]+)((,)([a-z0-9_.]+[ ]?[=][ ]?[a-z0-9_.]+))*
//    matches follow strings:
//    "com.myexample.name1=ms1"
//    "com.myexample.name1=ms1,com.myexample.name2=name2"
//    "com.myexample.name1 =ms1,com.myexample.name2= name2,com.myexample.name3 = ms3"

    val nameChars = "[a-z0-9_.]+"
    val equal = "[ ]?[=][ ]?"
    return applicationNames.matches(
        """(${nameChars}${equal}${nameChars})((,)(${nameChars}${equal}${nameChars}))*""".toRegex()
    )
}

fun isValidSystemEnvironmentVariable(environmentVariable: String) =
    environmentVariable.matches("[\$][{]([\\w_])+[}]".toRegex())

private fun getAllSystemEnvironmentVariable(environmentVariable: String) =
    "[\$][{][\\w-#~,+*?^(){\$\\[\\]|.]+[}]".toRegex().findAll(environmentVariable).toList()

fun hasAnyInvalidSystemEnvironmentVariable(environmentVariable: String) =
    getAllSystemEnvironmentVariable(environmentVariable).any { matchResult ->
        !matchResult.groupValues.any { isValidSystemEnvironmentVariable(it) }
    }

fun parseApplicationNames(applicationNames: String): Map<String, String> {
    val retval = mutableMapOf<String, String>()
    if (!isConformApplicationNames(applicationNames)) return mapOf(Pair(applicationNames, applicationNames))
    applicationNames.split(",").forEach {
        retval[it.split("=")[0].trim()] = it.split("=")[1].trim()
    }
    return retval
}

fun generateFilePath(path: String, fileName: String) =
    listOf(
        path,
        fileName
    ).joinToString(File.separator)