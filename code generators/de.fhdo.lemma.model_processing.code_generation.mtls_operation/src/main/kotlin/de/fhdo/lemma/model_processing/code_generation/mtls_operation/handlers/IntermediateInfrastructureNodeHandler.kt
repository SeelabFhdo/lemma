package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.getNodeAspectsWithValues
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.hasAspect

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java
    fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateInfrastructureNode): String? {

        var systemProperties = mapOf<String, String>()
        val sortableProperties = SortableProperties()

        if(eObject.qualifiedInfrastructureTechnologyName == "mTLS.certificateAuthority"){
            sortableProperties.putAll(eObject.getServicePropertiesWithValues())
            MainContext.State.addPropertyFile(eObject.name, sortableProperties, "certs", "${eObject.name}.var" )
            systemProperties = eObject.getServicePropertiesWithValues()
        } else{
            if (!eObject.hasAspect(handlesAspects()))
                return null
            eObject.aspects.forEach {
                sortableProperties.putAll(eObject.getNodeAspectsWithValues(it.name))
                MainContext.State.addPropertyFile(eObject.name, sortableProperties, "certs", "${eObject.name}.var")
                systemProperties = eObject.getNodeAspectsWithValues(it.name)
            }

        }
        systemProperties.forEach{
            println("${eObject.name}: ${it.key}=${it.value}")
        }
        return "IntermediateInfrastructureNodeHandler.${eObject.name}"
    }
}

fun IntermediateInfrastructureNode.getServicePropertiesWithValues(): Map<String,String> {
    val resultMap = mutableMapOf<String, String>()
    val systemProperties = (operationEnvironment.eContainer() as IntermediateInfrastructureTechnology).properties

    systemProperties.forEach {
        if(!it.featureNames.contains("MANDATORY") && !it.defaultValue.isNullOrEmpty() )
            resultMap[it.name] = it.defaultValue
    }
    defaultValues.forEach {
        if(!it.value.isNullOrEmpty() )
            resultMap[it.technologySpecificProperty.name] = it.value
    }
    return resultMap
}