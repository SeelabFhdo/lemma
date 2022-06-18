package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model_processing_phase

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.PhaseHeap
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
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
            val intermediateServiceModel =
                loadModelRootRelative<IntermediateServiceModel>(
                    serviceModelUri,
                    intermediateImport.eResource().uri.toString().removeFileUri()
                )

            ModelsContext.State.intermediateServiceModels.add(intermediateServiceModel)

            loadAllRolesFromServiceModel(intermediateServiceModel)
            loadAllRolesAndGroupsFromOperationModel(intermediateOperationModel)
        }

    }

    private fun loadAllRolesAndGroupsFromOperationModel(intermediateOperationModel: IntermediateOperationModel){
        intermediateOperationModel.infrastructureNodes
            .forEach { intermediateInfrastructureNode ->
                intermediateInfrastructureNode.aspects.forEach { intermediateImportedAspect ->
                    when (intermediateImportedAspect.name) {
                        "role" -> addRolesToModelContext(intermediateImportedAspect)
                        "group" -> ModelsContext.State.groups.add(
                            intermediateImportedAspect.getPropertyValue("name") as String
                        )
                        else -> {}
                    }
                }
            }
    }

    private fun loadAllRolesFromServiceModel(serviceModel: IntermediateServiceModel) {
        serviceModel.microservices.forEach { intermediateServiceModel ->
            intermediateServiceModel.interfaces.forEach { intermediateInterface ->
                intermediateInterface.aspects.filter { it.name == "role" }.forEach { addRolesToModelContext(it) }
                intermediateInterface.operations.forEach { intermediateOperation ->
                    intermediateOperation.aspects.filter { it.name == "role" }.forEach { addRolesToModelContext(it) }
                }
            }
        }
    }

    private fun addRolesToModelContext(intermediateImportedAspect: IntermediateImportedAspect) {
        intermediateImportedAspect.getPropertyValue("name")?.let {
            if (intermediateImportedAspect.getPropertyValue("clientRole").toBoolean())
                ModelsContext.State.clientRoles.add(it)
            else
                ModelsContext.State.realmRoles.add(it)
        }
    }
}

