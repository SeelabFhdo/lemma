package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.model_processing_phase

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.modul_handler.ModelsContext
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.PhaseHeap
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource
import kotlin.system.exitProcess

private const val modelParsingPhaseName = "intermediate_model_parsing"
private const val modelResourceParameterName = "intermediateModelResource"

@ModelProcessingPhase("parse_imported_intermediate_service_models", FindModelValidatorsPhase::class)
class LoadAndParseDependentIntermediateModels : AbstractModelProcessingPhase() {
    override fun process(args: Array<String>) {
        val parseIntermediateOperationModel = PhaseHeap[modelParsingPhaseName, modelResourceParameterName] as? Resource
        val intermediateOperationModel =
            parseIntermediateOperationModel?.contents?.first() as IntermediateOperationModel
        val intermediateInfrastructureNode = intermediateOperationModel.infrastructureNodes.find {
            it.qualifiedInfrastructureTechnologyName == "Keycloak.KeycloakRealm"
        }
        if (intermediateInfrastructureNode == null) {
            println("No KeycloakRealm infrastructure was found in this operation model!")
            exitProcess(1)
        }

        ModelsContext.State.storeIntermediateModel(intermediateOperationModel)
        intermediateOperationModel.imports.forEach {
            loadAllModels(it)
        }
    }

    private fun loadAllModels(intermediateImport: IntermediateImport) {
        when (intermediateImport.importTypeName) {
            "OPERATION_NODES" -> {
                val intermediateOperationModel = loadModelRootRelative<IntermediateOperationModel>(
                    intermediateImport.importUri,
                    intermediateImport.eResource().uri.toString().removeFileUri()
                )
                ModelsContext.State.storeIntermediateModel(intermediateOperationModel)
                intermediateOperationModel.imports.filter { !ModelsContext.State.alreadyLoaded(it) }.forEach {
                    loadAllModels(it)
                }
            }
            "MICROSERVICES" -> {
                val intermediateServiceModel = loadModelRootRelative<IntermediateServiceModel>(
                    intermediateImport.importUri,
                    intermediateImport.eResource().uri.toString().removeFileUri()
                )
                ModelsContext.State.storeIntermediateModel(intermediateServiceModel)
                intermediateServiceModel.imports.filter { !ModelsContext.State.alreadyLoaded(it) }.forEach {
                    loadAllModels(it)
                }
            }
            else -> {}
        }
    }
}

