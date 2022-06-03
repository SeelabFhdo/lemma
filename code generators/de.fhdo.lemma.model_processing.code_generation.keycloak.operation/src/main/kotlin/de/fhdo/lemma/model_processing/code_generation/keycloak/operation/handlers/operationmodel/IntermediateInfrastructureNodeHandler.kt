package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.operationmodel

import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesFormNodeAspectsForDeployedServices
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java
    private fun handlesAspects() = setOf("keycloak")

    override fun execute(eObject: IntermediateInfrastructureNode): String? {
        if (eObject.qualifiedInfrastructureTechnologyName == "Keycloak.keycloakRealm") {
//            create Realm form aspects
            eObject.createRealm()
            println("Hmmm ${MainContext.State.getRealmAsJson()}")

        } else {
            if (!eObject.hasAspect(handlesAspects()))
                return null


            handlesAspects().forEach { aspectName ->
                eObject.getPropertiesFormNodeAspectsForDeployedServices(aspectName)?.let {
                    it.forEach { it1 ->

                    }
                }
            }
        }
        return "IntermediateInfrastructureNodeHandler.${eObject.name}"
    }

    private fun IntermediateInfrastructureNode.createRealm() {

        MainContext.State.createRealm(this.getPropertiesValuesOrDefault())


    }

    private fun IntermediateInfrastructureNode.getPropertiesValuesOrDefault(): Map<String, Any>{
        val properties = mutableMapOf<String, Any>()

        this.reference.technology.properties.filter{!it.defaultValue.isNullOrEmpty()}.forEach {
            properties[it.name] = it.defaultValue
        }
        this.defaultValues.forEach {
            properties[it.technologySpecificProperty.name] = it.value
        }
        return properties
    }


}