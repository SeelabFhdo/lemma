package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.utils.DdmmUtils
import org.eclipse.emf.ecore.EObject
import de.fhdo.ddmm.data.intermediate.IntermediatePackage
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo
import org.eclipse.m2m.atl.core.emf.EMFModel
import java.util.Map
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.ddmm.data.intermediate.IntermediateDataModel
import de.fhdo.ddmm.data.DataModel
import de.fhdo.ddmm.data.DataPackage

/**
 * This class enables access to the model-to-model transformation of data models to intermediate
 * data models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateDataModelTransformation
    extends AbstractIntermediateModelTransformationStrategy {
    static val TARGET_MODEL_INFO = new TargetModelInfo(
        IntermediatePackage.eNS_URI,
        IntermediatePackage.eINSTANCE,
        IntermediateDataModel
    )

    String absoluteSourceModelPath

    /**
     * Get project-relative path to compiled ATL model transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/IntermediateDataModelTransformation.asm"
    }

    /**
     * Get URI and EPackage of the target intermediate metamodel
     */
    override getTargetModelInfo() {
        return TARGET_MODEL_INFO
    }

    /**
     * Before transformation hook
     *
     */
    override beforeTransformationHook(String absoluteSourceModelPath) {
        this.absoluteSourceModelPath = absoluteSourceModelPath
    }

    /**
     * Prepare source model
     */
    override prepareSourceModel(EObject modelRoot) {
        val dataModel = (modelRoot as DataModel)

        // Set URI of source model
        if (!DdmmUtils.isFileUri(absoluteSourceModelPath))
            dataModel.t_modelUri = DdmmUtils.convertToFileUri(absoluteSourceModelPath)

        // Convert import URIs of imported model files to absolute file URIs. Otherwise the
        // transformation won't have access to them and the contained model elements.
        dataModel.complexTypeImports.forEach[
            if (!DdmmUtils.isFileUri(importURI))
                importURI = DdmmUtils.convertToFileUri(
                    DdmmUtils.convertToAbsolutePath(importURI, absoluteSourceModelPath)
                )
        ]
    }

    /**
     * Get validator for source model
     */
    override getSourceModelValidator() {
        return new DataModelTransformationValidator
    }

    /**
     * Get namespace URI of the source metamodel's EPackage
     */
    override getSourcePackageNamespaceUri() {
        return DataPackage.eNS_URI
    }

    /**
     * Get prefix of source model in ATL transformation file
     */
    override getTransformationSourceModelPrefix() {
        return "Data"
    }

    /**
     * Get prefix of target model in ATL transformation file
     */
    override getTransformationTargetModelPrefix() {
        return "Intermediate"
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateTargetModelWithImportTargetPaths(EMFModel targetModel,
        Map<String, String> targetPaths) {
        val modelRoot = targetModel.resource.contents.get(0) as IntermediateDataModel
        val workspacePath = ResourcesPlugin.workspace.root.location.toString
        targetPaths.forEach[importName, targetPath |
            val import = modelRoot.imports.findFirst[name == importName]
            import.importUri = DdmmUtils.convertToFileUri(workspacePath + targetPath)
        ]
    }
}