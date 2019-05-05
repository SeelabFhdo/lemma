package de.fhdo.ddmm.intermediate.transformations.service

import org.eclipse.emf.ecore.EObject
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo
import de.fhdo.ddmm.technology.mapping.MappingPackage
import de.fhdo.ddmm.service.ServicePackage
import de.fhdo.ddmm.service.ServiceModel
import org.eclipse.m2m.atl.core.emf.EMFModel
import java.util.Map
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import java.util.List
import de.fhdo.ddmm.service.Import
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.technology.mapping.TechnologyMapping
import org.eclipse.core.resources.ResourcesPlugin

/**
 * This class enables access the model-to-model transformation of technology mapping models to
 * service models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MappingModelTransformation extends AbstractIntermediateModelTransformationStrategy {
    static val TARGET_MODEL_INFO = new TargetModelInfo(
        ServicePackage.eNS_URI,
        ServicePackage.eINSTANCE,
        ServiceModel
    )

    String absoluteSourceModelPath

    /**
     * Get project-relative path to compiled ATL model transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/MappingModelTransformation.asm"
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
        val mappingModel = modelRoot as TechnologyMapping

        // Convert import URIs to absolute URIs
        convertImportUrisToAbsoluteFileUris(mappingModel.imports, absoluteSourceModelPath)
    }

    /**
     * Transformation preparation: Convert import URIs of imported model files to absolute file
     * URIs. Otherwise the transformation won't have access to them and the contained model
     * elements.
     */
    private def convertImportUrisToAbsoluteFileUris(List<Import> imports, String modelFilePath) {
        imports.forEach[
            if (!DdmmUtils.isFileUri(importURI))
                importURI = DdmmUtils.convertToFileUri(
                    DdmmUtils.convertToAbsolutePath(importURI, modelFilePath)
                )
        ]
    }

    /**
     * Get validator for source model
     */
    override getSourceModelValidator() {
        return new MappingModelTransformationValidator
    }

    /**
     * Get namespace URI of the source metamodel's EPackage
     */
    override getSourcePackageNamespaceUri() {
        return MappingPackage.eNS_URI
    }

    /**
     * Get prefix of source model in ATL transformation file
     */
    override getTransformationSourceModelPrefix() {
        return "Mapping"
    }

    /**
     * Get prefix of target model in ATL transformation file
     */
    override getTransformationTargetModelPrefix() {
        return "Service"
    }

    /**
     * Consider imports of imported service models to build import target paths. Otherwise the paths
     * of domain models imported by mapped service models will point to their original destination
     * instead of those of the intermediate models they get possibly transformed to within the
     * transformation process.
     */
    override considerChildrensChildrenForImportTargetPaths() {
        return true
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateTargetModelWithImportTargetPaths(EMFModel targetModel,
        Map<String, String> targetPaths) {
        val modelRoot = targetModel.resource.contents.get(0) as ServiceModel
        val workspacePath = ResourcesPlugin.workspace.root.location.toString
        targetPaths.forEach[importName, targetPath |
            val import = modelRoot.imports.findFirst[name == importName]
            import.importURI = DdmmUtils.convertToFileUri(workspacePath + targetPath)
        ]
    }
}