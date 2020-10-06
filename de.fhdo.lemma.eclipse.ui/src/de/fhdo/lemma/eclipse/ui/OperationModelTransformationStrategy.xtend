package de.fhdo.lemma.eclipse.ui

import java.util.List
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import de.fhdo.lemma.service.ServiceModel
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import java.net.URI
import de.fhdo.lemma.service.ImportType
import java.util.LinkedHashMap
import java.util.Collections
import java.util.Map
import de.fhdo.lemma.intermediate.transformations.service.IntermediateServiceModelTransformation
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.intermediate.transformations.operation.IntermediateOperationModelTransformation

/**
 * UI-specific intermediate model transformation strategy for models related to the Operation
 * Modeling Viewpoint.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class OperationModelTransformationStrategy extends AbstractUiModelTransformationStrategy {
    public static val OPERATION_MODEL_FILE_TYPE_ID = "OPERATION"
    public static val SERVICE_MODEL_FILE_TYPE_ID = "SERVICE"

    static val OPERATION_DSL_EDITOR_ID = "de.fhdo.lemma.operationdsl.OperationDsl"
    static val SERVICE_DSL_EDITOR_ID = "de.fhdo.lemma.ServiceDsl"
    static val List<String> OPERATION_MODEL_FILE_EXTENSIONS = newArrayList
    static val List<String> SERVICE_MODEL_FILE_EXTENSIONS = newArrayList
    static val String MODEL_TYPE_PREFIX = "operation"
    static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())
    var LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions

    /**
     * Constructor
     */
    new() {
        // Collect all relevant file extensions
        if (SERVICE_MODEL_FILE_EXTENSIONS.empty)
            SERVICE_MODEL_FILE_EXTENSIONS.addAll(
                LemmaUiUtils.getFileExtensions(SERVICE_DSL_EDITOR_ID)
            )

        if (OPERATION_MODEL_FILE_EXTENSIONS.empty)
            OPERATION_MODEL_FILE_EXTENSIONS.addAll(
                LemmaUiUtils.getFileExtensions(OPERATION_DSL_EDITOR_ID)
            )

        setupModelFileTypeDescriptions()
    }

    /**
     * Helper to setup the map of model file type descriptions
     */
    private def setupModelFileTypeDescriptions() {
        modelFileTypeDescriptions = newLinkedHashMap(
            OPERATION_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                OPERATION_MODEL_FILE_TYPE_ID,
                LemmaUiUtils.createImage(RESOURCE_MANAGER, class, "operationModelFile.png"),
                "Operation Model",
                OPERATION_MODEL_FILE_EXTENSIONS,
                typeof(IntermediateOperationModelTransformation)
            ),

            SERVICE_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                SERVICE_MODEL_FILE_TYPE_ID,
                LemmaUiUtils.createImage(RESOURCE_MANAGER, class, "serviceModelFile.gif"),
                "Service Model",
                SERVICE_MODEL_FILE_EXTENSIONS,
                typeof(IntermediateServiceModelTransformation)
            )
        )
    }

    /**
     * Get string prefix of model type
     */
    override getModelTypePrefix() {
        return MODEL_TYPE_PREFIX
    }

    /**
     * Get model types' ordering for displaying purposes
     */
    override getModelTypeDisplayOrdering() {
        return newLinkedList(
            OPERATION_MODEL_FILE_TYPE_ID,
            SERVICE_MODEL_FILE_TYPE_ID
        )
    }

    /**
     * Get model types' ordering for transformation
     */
    override getModelTypeTransformationOrdering() {
        return newLinkedList(
            OPERATION_MODEL_FILE_TYPE_ID,
            SERVICE_MODEL_FILE_TYPE_ID
        )
    }

    /**
     * Get file extensions of the model type
     */
    override getModelFileTypeExtensions() {
        val modelTypeFileExtensions = <String> newArrayList
        modelTypeFileExtensions.addAll(OPERATION_MODEL_FILE_EXTENSIONS)
        return modelTypeFileExtensions
    }

    /**
     * Get descriptions of all relevant model file types
     */
    override getModelFileTypeDescriptions() {
        return modelFileTypeDescriptions
    }

    /**
     * Get model file type description by extension
     */
    override getModelFileTypeDescription(String fileExtension) {
        val typeIdentifierAndDescription = getModelFileTypeIdentifierAndDescription(fileExtension)
        if (typeIdentifierAndDescription === null)
            return null

        return typeIdentifierAndDescription.value
    }

    /**
     * Get model file type identifier and description by extension
     */
    override getModelFileTypeIdentifierAndDescription(String fileExtension) {
        if (fileExtension !== null && !fileExtension.empty)
            for (entry : modelFileTypeDescriptions.entrySet)
                if (entry.value.extensions.contains(fileExtension))
                    return {entry.key -> entry.value}

        return null
    }

    /**
     * Get title of model selection dialog
     */
    override getModelSelectionDialogTitle() {
        return '''Select «modelTypePrefix.toFirstUpper» Models for Intermediate Model ''' +
            "Transformation"
    }

    /**
     * Get message of model selection dialog
     */
    override getModelSelectionDialogMessage() {
        return '''Determine «modelTypePrefix» models for intermediate model transformation by ''' +
            '''selecting the files in the project tree and clicking the "Continue with ''' +
            '''selected models" button. Alternatively, you may click on "Select all models and ''' +
            '''continue" to use all models for intermediate model transformation.'''
    }

    /**
     * Get title of dialog for specifying transformation paths
     */
    override getSpecifyPathsDialogTitle() {
        return '''Specify Paths for Intermediate «modelTypePrefix.toFirstUpper» Models'''
    }

    /**
     * Get message of dialog for specifying transformation paths
     */
    override getSpecifyPathsDialogMessage() {
        return '''Specify target paths for the transformation of «modelTypePrefix» models to ''' +
            "intermediate models in the table. Click OK to invoke the intermediate model " +
            "transformations."
    }

    /**
     * Get transformation strategy
     */
    override getTransformationStrategyInternal() {
        return new IntermediateOperationModelTransformation
    }

    /**
     * Get files being import by a given model file in the form of IFile instances
     */
    override getImportedModelFiles(ModelFile modelFile) {
        /* Get aliases and import URIs of imported files */
        var Map<String, String> importAliasesAndUris

        if (!modelFile.xtextResource.contents.empty) {
            // Service Models
            if (LemmaUiUtils.hasExtension(modelFile.file, SERVICE_MODEL_FILE_EXTENSIONS)) {
                val modelRoot = modelFile.xtextResource.contents.get(0) as ServiceModel
                importAliasesAndUris = modelRoot.imports
                    .filter[
                        importType === ImportType.MICROSERVICES
                    ].toMap([name], [importURI])
            }

            // Operation Models
            else if (LemmaUiUtils.hasExtension(modelFile.file, OPERATION_MODEL_FILE_EXTENSIONS)) {
                val modelRoot = modelFile.xtextResource.contents.get(0) as OperationModel
                importAliasesAndUris = modelRoot.imports
                    .filter[importType === ImportType.MICROSERVICES]
                    .toMap([name], [importURI])
            }

        } else
            return Collections.EMPTY_MAP

        /*
         * Iterate over import URIs and return corresponding model files from the workspace mapped
         * to their unique aliases
         */
        val importedModelFiles = <String, IFile> newHashMap
        importAliasesAndUris.forEach[alias, importUri |
            // Create URI for absolute path of imported model file
            val modelFileFullPath = modelFile.file.location.toString
            val absoluteImportPath = LemmaUtils.convertToAbsolutePath(importUri, modelFileFullPath)
            val absoluteImportUri = URI.create(
                LemmaUtils.convertToFileUri(absoluteImportPath).replaceAll("\\s","%20")
            )

            // Find matching files from workspace and return the first one. There should not be more
            // than one matching file as the URI points to an absolute path.
            val files = ResourcesPlugin.workspace.root.findFilesForLocationURI(absoluteImportUri)
            if (!files.empty)
                importedModelFiles.put(alias, files.get(0))
        ]

        return importedModelFiles
    }

    /**
     * Return default target path for intermediate model transformation for a given file
     */
    override getDefaultTransformationTargetPath(IFile file) {
        val modelFileTypePathPart = if (LemmaUiUtils.hasExtension(file, OPERATION_MODEL_FILE_EXTENSIONS))
                "operation models"
            else if (LemmaUiUtils.hasExtension(file, SERVICE_MODEL_FILE_EXTENSIONS))
                "service models"

        val filenameWithoutExtension = LemmaUiUtils.removeExtension(file, [name])
        return '''/intermediate/«modelFileTypePathPart»/«filenameWithoutExtension».xmi'''
    }
}