package de.fhdo.ddmm.eclipse.ui

import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import java.util.List
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import de.fhdo.ddmm.intermediate.transformations.service.IntermediateServiceModelTransformation
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.utils.DdmmUtils
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import java.net.URI
import de.fhdo.ddmm.service.ImportType
import de.fhdo.ddmm.technology.mapping.TechnologyMapping
import de.fhdo.ddmm.data.DataModel
import java.util.LinkedHashMap
import java.io.File
import java.util.Collections
import java.util.Map
import de.fhdo.ddmm.intermediate.transformations.service.IntermediateDataModelTransformation
import de.fhdo.ddmm.intermediate.transformations.service.MappingModelTransformation

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

    private static val DATA_DSL_EDITOR_ID = "de.fhdo.ddmm.data.DataDsl"
    private static val SERVICE_DSL_EDITOR_ID = "de.fhdo.ddmm.ServiceDsl"
    private static val MAPPING_DSL_EDITOR_ID = "de.fhdo.ddmm.technology.mappingdsl.MappingDsl"
    private static val List<String> DATA_MODEL_FILE_EXTENSIONS = newArrayList
    private static val List<String> SERVICE_MODEL_FILE_EXTENSIONS = newArrayList
    private static val List<String> MAPPING_MODEL_FILE_EXTENSIONS = newArrayList
    private static val String MODEL_TYPE_PREFIX = "service"
    private static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())
    private var LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions

    /**
     * Constructor
     */
    new() {
        // Collect all relevant file extensions
        if (SERVICE_MODEL_FILE_EXTENSIONS.empty)
            SERVICE_MODEL_FILE_EXTENSIONS.addAll(
                DdmmUiUtils.getFileExtensions(SERVICE_DSL_EDITOR_ID)
            )

        if (MAPPING_MODEL_FILE_EXTENSIONS.empty)
            MAPPING_MODEL_FILE_EXTENSIONS.addAll(
                DdmmUiUtils.getFileExtensions(MAPPING_DSL_EDITOR_ID)
            )

        if (DATA_MODEL_FILE_EXTENSIONS.empty)
            DATA_MODEL_FILE_EXTENSIONS.addAll(DdmmUiUtils.getFileExtensions(DATA_DSL_EDITOR_ID))

        setupModelFileTypeDescriptions()
    }

    /**
     * Helper to setup the map of model file type descriptions
     */
    private def setupModelFileTypeDescriptions() {
        modelFileTypeDescriptions = newLinkedHashMap(
            DATA_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                DdmmUiUtils.createImage(RESOURCE_MANAGER, "dataModelFile.gif"),
                "Data Model",
                DATA_MODEL_FILE_EXTENSIONS,
                new IntermediateDataModelTransformation()
            ),

            MAPPING_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                DdmmUiUtils.createImage(RESOURCE_MANAGER, "mappingModelFile.gif"),
                "Mapping Model",
                MAPPING_MODEL_FILE_EXTENSIONS,
                new MappingModelTransformation(),
                // Refining transformation: Mapping model gets transformed to service model, which
                // then gets refined to an intermediate service model
                new IntermediateServiceModelTransformation()
            ),

            SERVICE_MODEL_FILE_TYPE_ID -> new ModelFileTypeDescription(
                DdmmUiUtils.createImage(RESOURCE_MANAGER, "serviceModelFile.gif"),
                "Service Model",
                SERVICE_MODEL_FILE_EXTENSIONS,
                new IntermediateServiceModelTransformation()
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
     * Get model types' ordering
     */
    override getModelTypeOrdering() {
        return #[DATA_MODEL_FILE_TYPE_ID, MAPPING_MODEL_FILE_TYPE_ID, SERVICE_MODEL_FILE_TYPE_ID]
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
     * Find project-specific model files
     */
    override findProjectSpecificModelFiles() {
        return DdmmUiUtils.findFilesInWorkspaceProjects(getModelFileTypeExtensions())
            .filter[project, files | !files.empty]
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
            '''Transformation'''
    }

    /**
     * Get message of model selection dialog
     */
    override getModelSelectionDialogMessage() {
        return '''Determine «modelTypePrefix» models for intermediate model transformation by ''' +
            '''selecting the files in the project tree and clicking OK.'''
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
            '''intermediate models in the table. Click OK to invoke the intermediate model ''' +
            '''transformations.'''
    }

    /**
     * Get transformation strategy
     */
    override getTransformationStrategyInternal() {
        return new IntermediateServiceModelTransformation
    }

    /**
     * Get files being import by a given model file in the form of IFile instances
     */
    override getImportedModelFiles(ModelFile modelFile) {
        /* Get aliases and import URIs of imported files */
        var Map<String, String> importAliasesAndUris

        if (!modelFile.xtextResource.contents.empty) {
            // Service Models
            if (DdmmUiUtils.hasExtension(modelFile.file, SERVICE_MODEL_FILE_EXTENSIONS)) {
                val modelRoot = modelFile.xtextResource.contents.get(0) as ServiceModel
                importAliasesAndUris = modelRoot.imports
                    .filter[
                        importType === ImportType.DATATYPES ||
                        importType === ImportType.MICROSERVICES
                    ].toMap([name], [importURI])
            }

            // Mapping Models
            else if (DdmmUiUtils.hasExtension(modelFile.file, MAPPING_MODEL_FILE_EXTENSIONS)) {
                val modelRoot = modelFile.xtextResource.contents.get(0) as TechnologyMapping
                importAliasesAndUris = modelRoot.imports
                    .filter[
                        importType === ImportType.DATATYPES ||
                        importType === ImportType.MICROSERVICES
                    ].toMap([name], [importURI])
            }

            // Data Models
            else if (DdmmUiUtils.hasExtension(modelFile.file, DATA_MODEL_FILE_EXTENSIONS)) {
                val modelRoot = modelFile.xtextResource.contents.get(0) as DataModel
                importAliasesAndUris = modelRoot.complexTypeImports.toMap([name], [importURI])
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
            val absoluteImportPath = DdmmUtils.convertToAbsolutePath(importUri, modelFileFullPath)
            val absoluteImportUri = URI.create(DdmmUtils.convertToFileUri(absoluteImportPath))

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
        val modelFileTypePathPart = if (DdmmUiUtils.hasExtension(file, DATA_MODEL_FILE_EXTENSIONS))
                "data models"
            else if (DdmmUiUtils.hasExtension(file, SERVICE_MODEL_FILE_EXTENSIONS))
                "service models"
            else if (DdmmUiUtils.hasExtension(file, MAPPING_MODEL_FILE_EXTENSIONS))
                "mapping models"

        val filenameWithoutExtension = DdmmUiUtils.removeExtension(file, [name])
        return '''«File.separator»intermediate«File.separator»''' +
            '''«modelFileTypePathPart»«File.separator»«filenameWithoutExtension».xmi'''
    }
}