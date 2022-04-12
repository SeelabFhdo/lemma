package de.fhdo.lemma.intermediate.transformations.operation

import java.util.Map
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import org.eclipse.emf.ecore.EObject
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.lemma.intermediate.transformations.TransformationModelType
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import org.eclipse.core.resources.IFile

/**
 * Implementation of the ATL-based model-to-model transformation of operation models to intermediate
 * operation models.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class IntermediateOperationModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    IFile inputModelFile
    String absoluteInputModelFilePath

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
     * Fetch input model file prior to transformation execution
     */
    override beforeTransformationHook(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        inputModelFile = inputModelFiles.values.get(0)
        absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(inputModelFile)
    }

    /**
     * Prepare input model
     */
    override prepareInputModel(TransformationModelDescription modelDescription, EObject modelRoot) {
        val operationModel = modelRoot as OperationModel

        // Set source model URI
        operationModel.t_modelUri = LemmaUtils.convertToFileUri(absoluteInputModelFilePath)

        // Convert import URIs to absolute URIs
       operationModel.imports.forEach[
            importURI = LemmaUtils.convertToAbsoluteFileUri(importURI, absoluteInputModelFilePath)
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

    /**
     * Convert URIs in intermediate operation models to relative ones
     */
    override makeUrisRelative(TransformationResult result) {
        val operationModel = result.outputModel.resource.contents.get(0)
            as IntermediateOperationModel

        // Convert source model URI
        operationModel.sourceModelUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
            LemmaUtils.removeFileUri(result.outputModel.outputPath),
            LemmaUtils.removeFileUri(result.inputModels.get(0).inputPath)
        ))

        // Convert import URIs
        operationModel.imports.forEach[
            it.importUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
                LemmaUtils.removeFileUri(result.outputModel.outputPath),
                LemmaUtils.removeFileUri(it.importUri)
            ))
        ]
    }
}