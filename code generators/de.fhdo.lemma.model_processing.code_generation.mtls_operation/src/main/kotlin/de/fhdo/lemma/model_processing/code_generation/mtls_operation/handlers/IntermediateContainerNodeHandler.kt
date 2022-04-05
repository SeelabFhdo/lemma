package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.PathSpecifier
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.addProperty
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.getNodeAspectsWithValues
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.hasAspect
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.loadPropertiesFile
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java
    private fun handlesAspects() = setOf("mtls", "mtlsdev")
    private fun configFolder() = "configuration"

    override fun execute(eObject: IntermediateContainer): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null
        val containerAspects = mutableMapOf<String, Map<String, String>>()

        handlesAspects().forEach {
            containerAspects[it] = eObject.getNodeAspectsWithValues(it)
        }

        eObject.deployedServices.forEach { deployedService ->
            MainContext.State.setCurrentMicroservicePackage(deployedService.qualifiedName)
            val filePath = MainContext.State.generateFilePath(
                "${deployedService.qualifiedName}.var",
                MainContext.State.getPath(PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH)
            )
            val properties = loadPropertiesFile(filePath)
            containerAspects.forEach { aspect ->
                aspect.value.forEach {
                    properties.addProperty(it.toPair())
                }
            }
            MainContext.State.addPropertyFile(
                "${deployedService.qualifiedName}.var1",
                properties,
                PathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH
            )
            MainContext.State.addPropertyFile(
                "${deployedService.qualifiedName}.var",
                properties,
                PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH
            )
        }
        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}

private fun generatePropertiesFile(){
    //todo hier müssen die Sachen aufgeteilt werden auf die application-mtls.properties, application-mtlsdev.properties und die certs/name.var
    //properties truststore checken
}



