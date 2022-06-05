package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.operationmodel

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.MainContext
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.getPropertiesValuesOrDefault
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.hasAspect
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.putTypedValue
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java
    private fun handlesAspects() = setOf("role","keycloakClient","keycloakPropertiesConfig")

    override fun execute(eObject: IntermediateInfrastructureNode): String? {
        if (eObject.qualifiedInfrastructureTechnologyName == "Keycloak.keycloakRealm") {
//            create Realm form aspects
            eObject.createRealm()
//            println("Hmmm ${MainContext.State.getRealmAsJson()}")

        } else {
            if (!eObject.hasAspect(handlesAspects()))
                return null
            eObject.aspects.filter { handlesAspects().contains(it.name) }.forEach { aspect ->
                when(aspect.name){
                    "role"->{
                        println(aspect.getPropertiesValuesOrDefault())
                        MainContext.State.addRole(eObject.name, aspect.getPropertiesValuesOrDefault())
                    }
                    "keycloakClient" -> {}
                    "keycloakPropertiesConfig" -> {}
                    else -> {}
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
//            println("${it.type}, ${it.name}, ${it.defaultValue}")
            properties.putTypedValue(it.type,  it.name, it.defaultValue)
        }
        this.defaultValues.forEach {
//            println("${it.technologySpecificProperty.type}, ${it.technologySpecificProperty.name}, ${it.value}")
            properties.putTypedValue(it.technologySpecificProperty.type, it.technologySpecificProperty.name, it.value)
        }
        return properties
    }


}