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

/**
 * Implementation of the ATL-based model-to-model transformation of data models to intermediate data
 * models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateDataModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    String absoluteInputModelPath

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
        val dataModel = modelRoot as DataModel

        // Set URI of source model
        if (!LemmaUtils.isFileUri(absoluteInputModelPath))
            dataModel.t_modelUri = LemmaUtils.convertToFileUri(absoluteInputModelPath)

        // Convert import URIs of imported model files to absolute file URIs. Otherwise the
        // transformation won't have access to them and the contained model elements.
        dataModel.complexTypeImports.forEach[
            if (!LemmaUtils.isFileUri(importURI))
                importURI = LemmaUtils.convertToFileUri(
                    LemmaUtils.convertToAbsolutePath(importURI, absoluteInputModelPath)
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
}