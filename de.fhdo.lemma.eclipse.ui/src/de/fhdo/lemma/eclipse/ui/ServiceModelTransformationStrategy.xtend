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
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import de.fhdo.lemma.data.DataModel
import java.util.LinkedHashMap
import de.fhdo.lemma.intermediate.transformations.service.IntermediateDataModelTransformation
import de.fhdo.lemma.intermediate.transformations.service.IntermediateServiceModelTransformation
import de.fhdo.lemma.intermediate.transformations.service.MappingModelTransformation
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription
import de.fhdo.lemma.eclipse.ui.ModelFile
import org.eclipse.swt.widgets.Display

/**
 * UI-specific intermediate model transformation strategy for models related to the Service Modeling
 * Viewpoint.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServiceModelTransformationStrategy extends AbstractUiModelTransformationStrategy {
    public static val DATA_MODEL_FILE_TYPE_ID = "DATA"
    public static val MAPPING_MODEL_FILE_TYPE_ID = "MAPPING"
    public static val SERVICE_MODEL_FILE_TYPE_ID = "SERVICE"

    public static val List<String> DATA_MODEL_FILE_EXTENSIONS
        = LemmaUiUtils.getFileExtensions(LemmaUiUtils.DATA_DSL_EDITOR_ID)
    public static val List<String> SERVICE_MODEL_FILE_EXTENSIONS
        = LemmaUiUtils.getFileExtensions(LemmaUiUtils.SERVICE_DSL_EDITOR_ID)
    public static val List<String> MAPPING_MODEL_FILE_EXTENSIONS
        = LemmaUiUtils.getFileExtensions(LemmaUiUtils.MAPPING_DSL_EDITOR_ID)
    static val String MODEL_TYPE_PREFIX = "service"

    val LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions

    new() {
        /*
         * Don't associate model file type descriptions with model file icons if no Display instance
         * is available. In this case, we're not in a UI thread and thus can't load icon images. In
         * fact, JFaceResources.getResources() will throw an NPE then.
         */
        val resourceManager = if (Display.current !== null)
                new LocalResourceManager(JFaceResources.getResources())
            else
                null

        /* Create model file type descriptions */
        modelFileTypeDescriptions = newLinkedHashMap(
            DATA_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                DATA_MODEL_FILE_TYPE_ID,
                resourceManager.loadImageIfPossible("dataModelFile.gif"),
                "Data Model",
                DATA_MODEL_FILE_EXTENSIONS,
                typeof(IntermediateDataModelTransformation)
            ),

            MAPPING_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                MAPPING_MODEL_FILE_TYPE_ID,
                resourceManager.loadImageIfPossible("mappingModelFile.gif"),
                "Mapping Model",
                MAPPING_MODEL_FILE_EXTENSIONS,
                typeof(MappingModelTransformation),
                // Refining transformation: Mapping model gets transformed to service model, which
                // then gets refined to an intermediate service model
                typeof(IntermediateServiceModelTransformation)
            ),

            SERVICE_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                SERVICE_MODEL_FILE_TYPE_ID,
                resourceManager.loadImageIfPossible("serviceModelFile.gif"),
                "Service Model",
                SERVICE_MODEL_FILE_EXTENSIONS,
                typeof(IntermediateServiceModelTransformation)
            )
        )
    }

    /**
     * Helper to load an image file if a resource manager is available
     */
    private def loadImageIfPossible(ResourceManager resourceManager, String filename) {
        return if (resourceManager !== null)
                LemmaUiUtils.createImage(resourceManager, ServiceModelTransformationStrategy,
                    filename)
            else
                null
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
            DATA_MODEL_FILE_TYPE_ID,
            MAPPING_MODEL_FILE_TYPE_ID,
            SERVICE_MODEL_FILE_TYPE_ID
        )
    }

    /**
     * Get model types' ordering for transformation
     */
    override getModelTypeTransformationOrdering() {
        return newLinkedList(
            DATA_MODEL_FILE_TYPE_ID,
            SERVICE_MODEL_FILE_TYPE_ID,
            MAPPING_MODEL_FILE_TYPE_ID
        )
    }

    /**
     * Get file extensions of the model type
     */
    override getModelFileTypeExtensions() {
        val modelTypeFileExtensions = <String> newArrayList
        modelTypeFileExtensions.addAll(SERVICE_MODEL_FILE_EXTENSIONS)
        modelTypeFileExtensions.addAll(MAPPING_MODEL_FILE_EXTENSIONS)
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
        return new IntermediateServiceModelTransformation
    }

    /**
     * Get imported files of a given model file in the form of IFile instances
     */
    override getImportedModelFiles(ModelFile modelFile) {
        if (modelFile.xtextResource.contents.empty)
            return <String, IFile>newLinkedHashMap

        /* Get aliases and import URIs of imported files */
        val importAliasesAndUris = <String, String>newLinkedHashMap

        // Service models
        if (LemmaUiUtils.hasExtension(modelFile.file, SERVICE_MODEL_FILE_EXTENSIONS)) {
            val modelRoot = modelFile.xtextResource.contents.get(0) as ServiceModel
            modelRoot.imports
                .filter[
                    importType === ImportType.DATATYPES ||
                    importType === ImportType.MICROSERVICES
                ].forEach[importAliasesAndUris.put(name, importURI)]
        }

        // Mapping models
        else if (LemmaUiUtils.hasExtension(modelFile.file, MAPPING_MODEL_FILE_EXTENSIONS)) {
            val modelRoot = modelFile.xtextResource.contents.get(0) as TechnologyMapping
            modelRoot.imports
                .filter[importType === ImportType.MICROSERVICES]
                .forEach[importAliasesAndUris.put(name, importURI)]
        }

        // Data models
        else if (LemmaUiUtils.hasExtension(modelFile.file, DATA_MODEL_FILE_EXTENSIONS)) {
            val modelRoot = modelFile.xtextResource.contents.get(0) as DataModel
            modelRoot.complexTypeImports.forEach[importAliasesAndUris.put(name, importURI)]
        }

        /*
         * Iterate over import URIs and return corresponding model files from the workspace mapped
         * to their unique aliases
         */
        val importedModelFiles = <String, IFile>newLinkedHashMap
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
        val modelFileTypePathPart = if (LemmaUiUtils.hasExtension(file, DATA_MODEL_FILE_EXTENSIONS))
                "data models"
            else if (LemmaUiUtils.hasExtension(file, SERVICE_MODEL_FILE_EXTENSIONS))
                "service models"
            else if (LemmaUiUtils.hasExtension(file, MAPPING_MODEL_FILE_EXTENSIONS))
                "mapping models"

        val filenameWithoutExtension = LemmaUiUtils.removeExtension(file, [name])
        return '''/intermediate/«modelFileTypePathPart»/«filenameWithoutExtension».xmi'''
    }
}