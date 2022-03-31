package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.java_base.forEachAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java

    override fun execute(eObject: IntermediateContainer): String? {
//        println("container")

        eObject.deployedServices.forEach { deployedService ->
            MainContext.State.addPropertyFile(deployedService.name, SortableProperties(), "certs" )
        }

        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}