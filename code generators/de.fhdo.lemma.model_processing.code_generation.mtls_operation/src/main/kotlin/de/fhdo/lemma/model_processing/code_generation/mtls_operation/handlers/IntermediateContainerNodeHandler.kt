package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.generateFilePath
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.asFormattedString
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.loadPropertiesFile
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java

    override fun execute(eObject: IntermediateContainer): String? {

        eObject.deployedServices.forEach { deployedService ->
            val filePath = generateFilePath(deployedService.name, "certs", "file.var")
            val properties = loadPropertiesFile(filePath)
            properties["key"] = deployedService.name
            println(properties.asFormattedString())
            MainContext.State.addPropertyFile(deployedService.name, properties, "certs", "file.var" )
        }

        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}

