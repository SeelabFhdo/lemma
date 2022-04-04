package de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers

import de.fhdo.lemma.model_processing.code_generation.java_base.forEachAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.handlers.interfaces.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.MainContext
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.modul_handler.generateFilePath
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.asFormattedString
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.loadPropertiesFile
import de.fhdo.lemma.model_processing.utils.getAllServiceAspects
import de.fhdo.lemma.model_processing.utils.getServiceAspect
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology
import org.eclipse.emf.ecore.EObject

@CodeGenerationHandler
class IntermediateContainerNodeHandler : CodeGenerationHandlerI<IntermediateContainer> {
    override fun getSourceInstanceType() = IntermediateContainer::class.java
    fun handlesAspects() = setOf("mtls", "mtlsdev")

    override fun execute(eObject: IntermediateContainer): String? {
        if (!eObject.hasAspect(handlesAspects()))
            return null
        val containerAspects = mutableMapOf<String, Map<String, String>>()

        handlesAspects().forEach {
            containerAspects[it] = eObject.getAspectsOrDefaultValues(it)
        }



        eObject.deployedServices.forEach { deployedService ->
            println("${deployedService.qualifiedName}")
            val filePath = generateFilePath(deployedService.name, "certs", "${deployedService.qualifiedName}.var")
            val properties = loadPropertiesFile(filePath)
            containerAspects.forEach { aspect ->
                aspect.value.forEach {
                    properties[it.key] = it.value
//                    println("aspect ${aspect.key} -> ${it.key}=${it.value}")
                }
//                println()
            }
            MainContext.State.addPropertyFile(
                deployedService.name,
                properties,
                "certs",
                "${deployedService.qualifiedName}.var"
            )

        }


        /* println("hier mal halten")
         eObject.deployedServices.forEach { deployedService ->
             val filePath = generateFilePath(deployedService.name, "certs", "file.var")

             val properties = loadPropertiesFile(filePath)
             properties["key"] = deployedService.name
             println(properties.asFormattedString())

         }*/

        return "IntermediateContainerNodeHandler.${eObject.name}"
    }
}

fun IntermediateContainer.getAspectsOrDefaultValues(aspectName: String): Map<String, String> {
    val resultMap = mutableMapOf<String, String>()
    aspects.filter { it.name == aspectName }.forEach { aspect ->
        aspect.properties.filter {
            !it.defaultValue.isNullOrEmpty()
        }.forEach { property ->
            resultMap[property.name] = property.defaultValue
        }
        aspect.propertyValues.forEach { propertyValue ->
            resultMap[propertyValue.property.name] = propertyValue.value
        }
    }
    return resultMap
}

fun IntermediateContainer.hasAspect(aspectsSet: Set<String>) = aspects.any { aspectsSet.contains(it.name) }

