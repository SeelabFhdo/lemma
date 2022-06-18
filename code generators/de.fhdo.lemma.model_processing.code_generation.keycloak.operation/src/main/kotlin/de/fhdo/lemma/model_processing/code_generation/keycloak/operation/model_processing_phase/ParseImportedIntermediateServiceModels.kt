package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model_processing_phase

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.PhaseHeap
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource

private const val modelParsingPhaseName = "intermediate_model_parsing"
private const val modelResourceParameterName = "intermediateModelResource"

@ModelProcessingPhase("parse_imported_intermediate_service_models", FindModelValidatorsPhase::class)
class ParseImportedIntermediateServiceModels : AbstractModelProcessingPhase() {
    override fun process(args: Array<String>) {
        val parseIntermediateOperationModel = PhaseHeap[modelParsingPhaseName, modelResourceParameterName] as? Resource
        val intermediateOperationModel =
            parseIntermediateOperationModel?.contents?.first() as IntermediateOperationModel

        intermediateOperationModel.imports.forEach { intermediateImport ->
            if (!intermediateImport.importTypeName.equals("MICROSERVICES"))
                return@forEach
            val serviceModelUri = intermediateImport.importUri
            val serviceModel =
                loadModelRootRelative<IntermediateServiceModel>(
                    serviceModelUri,
                    intermediateImport.eResource().uri.toString().removeFileUri()
                )
            ModelsContext.State.intermediateServiceModels.add(serviceModel)
            loadAllRoles(serviceModel)
        }
        intermediateOperationModel.infrastructureNodes
            .filter { it.qualifiedInfrastructureTechnologyName == "Keycloak.keycloakRealm" }
            .forEach { intermediateInfrasturctureNode ->
                intermediateInfrasturctureNode.aspects.filter { it.name == "group" }.forEach { intermediateImportedAspect ->
                    println(
                        "Name: ${intermediateImportedAspect.name}\nAspect Name: ${
                            intermediateImportedAspect.getPropertyValue("name")
                        }"
                    )
                    ModelsContext.State.groups.add(intermediateImportedAspect.getPropertyValue("name") as String)
                }
            }
    }

    private fun loadAllRoles(serviceModel: IntermediateServiceModel) {
        val realmRoles = mutableSetOf<String>()
        val clientRoles = mutableSetOf<String>()

        serviceModel.microservices.forEach { intermediateServiceModel ->
            intermediateServiceModel.interfaces.forEach { intermediateInterface ->
                intermediateInterface.aspects.filter { it.name == "role" }.forEach { intermediateImportedAspect ->
                    val clientRole = intermediateImportedAspect.getPropertyValue("clientRole").toBoolean()
                    println("interface : ${intermediateImportedAspect.getPropertyValue("name")}")
                    intermediateImportedAspect.getPropertyValue("name")?.let {
                        if (clientRole)
                            clientRoles.add(it)
                        else
                            realmRoles.add(it)
                    }
                }
                intermediateInterface.operations.forEach { intermediateOperation ->
                    intermediateOperation.aspects.filter { it.name == "role" }
                        .forEach { intermediateImportedAspect ->
                            val clientRole = intermediateImportedAspect.getPropertyValue("clientRole").toBoolean()
                            intermediateImportedAspect.getPropertyValue("name")?.let {
                                if (clientRole)
                                    clientRoles.add(it)
                                else
                                    realmRoles.add(it)
                            }
                        }
                }
            }
        }
        ModelsContext.State.realmRoles.addAll(realmRoles)
        ModelsContext.State.clientRoles.addAll(clientRoles)
    }

}