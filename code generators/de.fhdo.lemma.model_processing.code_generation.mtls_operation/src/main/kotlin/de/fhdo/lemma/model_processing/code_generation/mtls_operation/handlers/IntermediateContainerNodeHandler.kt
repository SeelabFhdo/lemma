package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.generateFilePath
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.addProperty
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
            println("${deployedService.qualifiedName}")
            val filePath = generateFilePath(deployedService.name, "certs", "${deployedService.qualifiedName}.var")
            val properties = loadPropertiesFile(filePath)
            containerAspects.forEach { aspect ->
                aspect.value.forEach {
                    properties.addProperty(it.toPair())
                }
            }
            MainContext.State.addPropertyFile(
                deployedService.name,
                properties,
                "certs",
                "${deployedService.qualifiedName}.var"
            )
        }
        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}



