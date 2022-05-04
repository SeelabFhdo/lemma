package de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.modul_handler.PathSpecifier
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.getPropertiesFormNodeAspectsForDeployedServices
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.hasAspect
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.loadOrGeneratePropertiesEntries
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.springPropertyMapping
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java
    private fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateInfrastructureNode): String? {
        var systemProperties = mapOf<String, String>()

        if (eObject.qualifiedInfrastructureTechnologyName == "mTLS.certificateAuthority") {
            MainContext.State.setCurrentMicroservicePackage("CertificationAuthority")
            val sortableProperties = SortableProperties()
            sortableProperties.putAll(eObject.getServicePropertiesWithValues())
            MainContext.State.addPropertyFile(
                "CertificationAuthority-mtlsdev.var",
                sortableProperties,
                PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH,
                "CertificationAuthority"
            )
            systemProperties = eObject.getServicePropertiesWithValues()
            generateDefaultEmptyCertificationAuthority()
        } else {
            if (!eObject.hasAspect(handlesAspects()))
                return null
            MainContext.State.setCurrentMicroservicePackage(eObject.name)

            handlesAspects().forEach { aspectName ->
                eObject.getPropertiesFormNodeAspectsForDeployedServices(aspectName)?.let {
                    it.forEach { it1 ->
                        loadOrGeneratePropertiesEntries(
                            "Certificate-${it1.key}-${aspectName}.var",
                            it1.value,
                            PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH,
                            eObject.name
                        )
                    }
                }
            }
        }
        return "IntermediateInfrastructureNodeHandler.${eObject.name}"
    }

    private fun IntermediateInfrastructureNode.getServicePropertiesWithValues(): Map<String, String> {
        val resultMap = mutableMapOf<String, String>()
        val systemProperties = (operationEnvironment.eContainer() as IntermediateInfrastructureTechnology).properties

        systemProperties.forEach {
            if (!it.featureNames.contains("MANDATORY") && !it.defaultValue.isNullOrEmpty())
                resultMap[springPropertyMapping(it.name)] = it.defaultValue
        }
        defaultValues.forEach {
            if (!it.value.isNullOrEmpty())
                resultMap[springPropertyMapping(it.technologySpecificProperty.name)] = it.value
        }
        return resultMap
    }

    private fun generateDefaultEmptyCertificationAuthority() {
        MainContext.State.setCurrentMicroservicePackage("CertificationAuthority")
        val sortableProperties = SortableProperties()
        sortableProperties[springPropertyMapping("caKeyFile")] = "ca_key_private.pem"
        sortableProperties[springPropertyMapping("caCertFile")] = "ca_cert.pem"
        sortableProperties[springPropertyMapping("caCertificatePassword")] = "\${caCertificatePassword}"
        sortableProperties[springPropertyMapping("caName")] = "ca"
        sortableProperties[springPropertyMapping("caDomain")] = "example.de"
        sortableProperties[springPropertyMapping("validityInDays")] = 365
        sortableProperties[springPropertyMapping("bitLength")] = 4096
        sortableProperties[springPropertyMapping("certificateStandard")] = "x509"
        sortableProperties[springPropertyMapping("cipher")] = "aes256"

        MainContext.State.addPropertyFile(
            "CertificationAuthority-mtls.var",
            sortableProperties,
            PathSpecifier.CURRENT_MICROSERVICE_CERTIFICATIONS_TARGET_PATH,
            "CertificationAuthority"
        )
    }
}