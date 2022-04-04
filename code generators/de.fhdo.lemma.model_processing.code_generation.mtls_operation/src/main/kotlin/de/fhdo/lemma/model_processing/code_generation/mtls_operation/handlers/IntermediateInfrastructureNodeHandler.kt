package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java

    override fun execute(eObject: IntermediateInfrastructureNode): String {


        val systemProperties = eObject.getServicePropteriesWithValues()

        println("Hier ")
//        eObject.
//        if(eObject.qualifiedInfrastructureTechnologyName == "mTLS.CaAuthority"){
//            println(eObject.getEffectiveConfigurationValues())
//        }
//        else{
//
//        }


//        eObject.deployedServices.forEach { deployedService ->
//            val filePath = generateFilePath(deployedService.name, "certs", "file.var")
//            val properties = loadPropertiesFile(filePath)
//            properties["key"] = deployedService.name
//            println(properties.asFormattedString())
//            MainContext.State.addPropertyFile(deployedService.name, properties, "certs", "file.var" )
//        }


        val sortableProperties = SortableProperties()
        MainContext.State.addPropertyFile(eObject.name, sortableProperties, "certs", "filename.var" )


        return "IntermediateInfrastructureNodeHandler.${eObject.name}"
    }
}

fun IntermediateInfrastructureNode.getServicePropteriesWithValues(): Map<String,String> {
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