package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import java.util.Map
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.intermediate.transformations.TransformationModelType
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.core.resources.IFile

/**
 * Implementation of the ATL-based model-to-model transformation of data models to intermediate data
 * models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateDataModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    String absoluteInputModelFilePath

    /**
     * Specify reference name and transformation model type of input model
     */
    override getInputModelReferenceNameAndType() {
        return "Data" ->
            new TransformationModelType(DataPackage.eNS_URI, DataPackage.eINSTANCE, DataModel)
    }

    /**
     * Specify reference name and transformation model type of output model
     */
    override getOutputModelReferenceNameAndType() {
        return "Intermediate" ->
            new TransformationModelType(IntermediatePackage.eNS_URI,
                IntermediatePackage.eINSTANCE, IntermediateDataModel)
    }

    /**
     * Specify path to the compiled ATL transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/IntermediateDataModelTransformation.asm"
    }

    /**
     * Fetch input model file prior to transformation execution
     */
    override beforeTransformationHook(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        val inputModelFile = inputModelFiles.values.get(0)
        absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(inputModelFile)
    }

    /**
     * Prepare input model
     */
    override prepareInputModel(TransformationModelDescription modelDescription, EObject modelRoot) {
        val dataModel = modelRoot as DataModel

        // Set URI of source model
        if (!LemmaUtils.isFileUri(absoluteInputModelFilePath))
            dataModel.t_modelUri = LemmaUtils.convertToFileUri(absoluteInputModelFilePath)

        // Convert import URIs of imported model files to absolute file URIs. Otherwise the
        // transformation won't have access to them and the contained model elements.
        dataModel.complexTypeImports.forEach[
            if (!LemmaUtils.isFileUri(importURI))
                importURI = LemmaUtils.convertToFileUri(
                    LemmaUtils.convertToAbsolutePath(importURI, absoluteInputModelFilePath)
                )
        ]
    }

    /**
     * Specify validator for input model
     */
    override getInputModelValidator(TransformationModelDescription modelDescription) {
        return new DataModelTransformationValidator
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateOutputModelWithImportTargetPaths(
        TransformationModelDescription modelDescription,
        EObject modelRoot,
        Map<String, String> targetPaths
    ) {
        val intermediateModelRoot = modelRoot as IntermediateDataModel
        targetPaths.forEach[importName, targetPath |
            val import = intermediateModelRoot.imports.findFirst[name == importName]
            import.importUri = LemmaUtils.convertProjectPathToAbsoluteFileUri(targetPath)
        ]
    }

    /**
     * Convert URIs in intermediate data models to relative ones
     */
    override makeUrisRelative(TransformationResult result) {
        result.performUriRelativization()
    }

    /**
     * Reusable helper to convert URIs in intermediate data models to relative ones
     */
    static def performUriRelativization(TransformationResult result) {
        val dataModel = result.outputModel.resource.contents.get(0) as IntermediateDataModel

        // Convert source model URI
        dataModel.sourceModelUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
            LemmaUtils.removeFileUri(result.outputModel.outputPath),
            LemmaUtils.removeFileUri(result.inputModels.get(0).inputPath)
        ))

        // Convert import URIs
        dataModel.imports.forEach[
            it.importUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
                LemmaUtils.removeFileUri(result.outputModel.outputPath),
                LemmaUtils.removeFileUri(it.importUri)
            ))
        ]
    }
}