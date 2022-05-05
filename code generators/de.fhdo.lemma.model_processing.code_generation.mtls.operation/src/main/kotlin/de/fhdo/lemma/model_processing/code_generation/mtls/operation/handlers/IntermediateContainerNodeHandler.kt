package de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers

import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.FileType
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.getPropertiesFormNodeAspectsForDeployedServices
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.hasAspect
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.loadOrGeneratePropertiesEntries
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java
    private fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateContainer): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null

        handlesAspects().forEach { aspectName ->
            val properties = eObject.getPropertiesFormNodeAspectsForDeployedServices(aspectName)!!
            properties.forEach { serviceProperties ->
                loadOrGeneratePropertiesEntries(
                    "application-${aspectName}.properties",
                    serviceProperties.value,
                    FileType.APPLICATION_PROPERTIES,
                    serviceProperties.key
                )
                loadOrGeneratePropertiesEntries(
                    "Certificate-${serviceProperties.key}-${aspectName}.var",
                    serviceProperties.value,
                    FileType.CLIENT_CERTIFICATE_PROPERTIES,
                    serviceProperties.key
                )
            }
        }
        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}



