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
    private fun handlesAspects() = setOf("role", "keycloakClient", "keycloakPropertiesConfig")

    override fun execute(eObject: IntermediateInfrastructureNode): String? {
        if (eObject.qualifiedInfrastructureTechnologyName == "Keycloak.keycloakRealm") {
            MainContext.State.createRealm(eObject.getPropertiesValuesOrDefault())
            eObject.aspects.forEach { aspect ->
                val aspectProperties = aspect.getPropertiesValuesOrDefault()
                when (aspect.name) {
                    "keycloakPropertiesConfig" -> {
                        // generate application-keycloak.properites (für jeden Client) aber nocht nicht hier
                    }
                    "group" -> {
                        MainContext.State.addGroup(aspectProperties)
                    }
                    "user" -> {
                        MainContext.State.addUser(aspectProperties)
                    }
                    else -> {}
                }
            }
        } else {
            if (!eObject.hasAspect(handlesAspects()))
                return null
            eObject.aspects.filter { handlesAspects().contains(it.name) }.forEach { aspect ->
                val aspectProperties = aspect.getPropertiesValuesOrDefault()
                when (aspect.name) {
                    "role" -> {
                        MainContext.State.addRole(eObject.name, aspectProperties)
                    }
                    "keycloakClient" -> {
                        MainContext.State.addClient(aspectProperties)
                    }
                    else -> {}
                }
            }
        }
        return "IntermediateInfrastructureNodeHandler.${eObject.name}"
    }

    private fun IntermediateInfrastructureNode.getPropertiesValuesOrDefault(): Map<String, Any> {
        val properties = mutableMapOf<String, Any>()

        this.reference.technology.properties.filter { !it.defaultValue.isNullOrEmpty() }.forEach {
            properties.putTypedValue(it.type, it.name, it.defaultValue)
        }
        this.defaultValues.forEach {
            properties.putTypedValue(it.technologySpecificProperty.type, it.technologySpecificProperty.name, it.value)
        }
        return properties
    }


}