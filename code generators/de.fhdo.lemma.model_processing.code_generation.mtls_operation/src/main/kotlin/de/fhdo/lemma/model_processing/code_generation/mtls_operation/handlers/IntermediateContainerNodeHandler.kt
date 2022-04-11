package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.PathSpecifier
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.*
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.getNodeAspectsWithValues
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.hasAspect
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.loadPropertiesFile
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java
    private fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateContainer): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null
        val containerAspects = mutableMapOf<String, Map<String, String>>()

        handlesAspects().forEach {
            containerAspects[it] = eObject.getNodeAspectsWithValues(it)
        }

        eObject.deployedServices.forEach { deployedService ->
            MainContext.State.setCurrentMicroservicePackage(deployedService.qualifiedName)
            containerAspects.forEach { aspect ->
                loadOrGeneratePropertiesEntries(
                    "application-${aspect.key}.properties",
                    aspect.value,
                    PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH
                )
                loadOrGeneratePropertiesEntries(
                    "Certificate-${deployedService.qualifiedName}-${aspect.key}.var",
                    aspect.value,
                    PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH
                )
            }
        }
        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}

private fun loadOrGeneratePropertiesEntries(
    filename: String,
    properties: Map<String, String>,
    pathSpecifier: PathSpecifier
) {
    val filePath = MainContext.State.generateFilePath(filename, MainContext.State.getPath(pathSpecifier))
    val sortableProperties = loadPropertiesFile(filePath)
    properties.forEach {
        if (it.key == springPropertyMapping("applicationName"))
            sortableProperties[it.key] =
                parseApplicationNames(it.value)[MainContext.State.getCurrentMicroservicePackage()]
        else
            sortableProperties[it.key] = it.value
    }
    MainContext.State.addPropertyFile(filename, sortableProperties, pathSpecifier)
}


