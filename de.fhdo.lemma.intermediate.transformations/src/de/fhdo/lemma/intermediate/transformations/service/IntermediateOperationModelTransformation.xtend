package de.fhdo.lemma.intermediate.transformations.service

import java.util.Map
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import org.eclipse.emf.ecore.EObject
import java.util.List
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.lemma.intermediate.transformations.TransformationModelType
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.Container

/**
 * Implementation of the ATL-based model-to-model transformation of operation models to intermediate
 * operation models.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class IntermediateOperationModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    String absoluteInputModelPath

    /**
     * Specify reference name and transformation model type of input model
     */
    override getInputModelReferenceNameAndType() {
        return "Operation" ->
            new TransformationModelType(OperationPackage.eNS_URI, OperationPackage.eINSTANCE,
                OperationModel)
    }

    /**
     * Specify reference name and transformation model type of output model
     */
    override getOutputModelReferenceNameAndType() {
        return "Intermediate" ->
            new TransformationModelType(IntermediatePackage.eNS_URI,
                IntermediatePackage.eINSTANCE, IntermediateOperationModel)
    }

    /**
     * Specify path to the compiled ATL transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/IntermediateOperationModelTransformation.asm"
    }

    /**
     * Fetch path of input model prior to transformation execution
     */
    override beforeTransformationHook(
        Map<TransformationModelDescription, String> absoluteInputModelPaths
    ) {
        this.absoluteInputModelPath = absoluteInputModelPaths.values.get(0)
    }

    /**
     * Prepare input model
     */
    override prepareInputModel(TransformationModelDescription modelDescription, EObject modelRoot) {
        val operationModel = modelRoot as OperationModel

        // Set source model URI.
        operationModel.t_modelUri = LemmaUtils.convertToFileUri(absoluteInputModelPath)

        // Convert import URIs to absolute URIs
       operationModel.imports.forEach[
            importURI = LemmaUtils.convertToAbsoluteFileUri(importURI, absoluteInputModelPath)
        ]

        // Populate the model's operation nodes, which specify a technology, with Technology instances
        linkTechnologyModels(operationModel.containers)
    }

    /**
     * Transformation preparation: Link technology models to operation model to prevent continuous
     * disk accesses to model files during transformation. Note that this depends on absolute file
     * URIs of the imported technology models.
     */
    private def linkTechnologyModels(List<Container> containers) {
        containers.forEach[container |
            /*  Type definition technology
            if (container.t_typeDefinitionTechnology === null) {
                container.t_typeDefinitionTechnologyImport =
                    container.typeDefinitionTechnologyImport
                container.t_typeDefinitionTechnology = microservice.typeDefinitionTechnology
            }*/

            /*  Default protocols per communication type
            microservice.technologyReferences.map[technology].forEach[technologyImport |
                val technologyModel = LemmaUtils.getImportedModelRoot(technologyImport.eResource,
                    technologyImport.importURI, Technology)
                if (microservice.t_defaultProtocols === null)
                    microservice.t_defaultProtocols =
                        <CommunicationType, Pair<Import, Protocol>> newHashMap
                technologyModel.protocols.forEach[
                    if (^default)
                        microservice.t_defaultProtocols.putIfAbsent(it.communicationType,
                            technologyImport -> it)
                ]
            ]*/
        ]
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateOutputModelWithImportTargetPaths(
        TransformationModelDescription modelDescription,
        EObject modelRoot,
        Map<String, String> targetPaths
    ) {
        val operationModelRoot = modelRoot as IntermediateOperationModel
        val workspacePath = ResourcesPlugin.workspace.root.location.toString
        targetPaths.forEach[importName, targetPath |
            val import = operationModelRoot.imports.findFirst[name == importName]
            import.importUri = LemmaUtils.convertToFileUri(workspacePath + targetPath)
        ]
    }
}