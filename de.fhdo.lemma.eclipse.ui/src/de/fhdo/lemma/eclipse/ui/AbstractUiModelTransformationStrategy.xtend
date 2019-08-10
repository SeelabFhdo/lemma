package de.fhdo.lemma.eclipse.ui

import java.util.Map
import org.eclipse.core.resources.IProject
import java.util.List
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import java.util.LinkedHashMap
import java.util.LinkedList

/**
 * Abstract strategy for preparing, displaying and controlling intermediate models' transformation
 * in the UI.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractUiModelTransformationStrategy {
    var AbstractIntermediateModelTransformationStrategy transformationStrategy

    /**
     * Return the transformation strategy of the concrete subclass. Note, that this method mimics
     * the behavior of a Singleton. That is, the instance of the transformation strategy is created
     * only once to increase performance.
     */
    def getTransformationStrategy() {
        if (transformationStrategy === null)
            transformationStrategy = transformationStrategyInternal

        return transformationStrategy
    }

    /**
     * Get string prefix of the model type, e.g., "service" or "operation"
     */
    abstract def String getModelTypePrefix()

    /**
     * Get model types' ordering for displaying purposes
     */
    abstract def LinkedList<String> getModelTypeDisplayOrdering()

    /**
     * Get model types' ordering for transformation
     */
    abstract def LinkedList<String> getModelTypeTransformationOrdering()

    /**
     * Get file extensions of the model type. Files being found in the workspace that exhibit one of
     * the extensions are treated as source files for the model transformations.
     */
    abstract def List<String> getModelFileTypeExtensions()

    /**
     * Find project-specific model files, i.e., files in the workspace that exhibit one of the model
     * type's file extensions.
     */
    abstract def Map<IProject, List<IFile>> findProjectSpecificModelFiles()

    /**
     * Get descriptions of all relevant model file types including icon, description string, and
     * extensions. Note, that the descriptions may contain additional file types compared to the
     * model type file extensions (see above). Each description is identified by a string
     * identifier (the map key).
     */
    abstract def LinkedHashMap<String, ModelFileTypeDescription> getModelFileTypeDescriptions()

    /**
     * Get model file type identifier and description by extension
     */
    abstract def Pair<String, ModelFileTypeDescription>
        getModelFileTypeIdentifierAndDescription(String fileExtension)

    /**
     * Get model file type description by extension
     */
    abstract def ModelFileTypeDescription getModelFileTypeDescription(String fileExtension)

    /**
     * Get title of model selection dialog
     */
    abstract def String getModelSelectionDialogTitle()

    /**
     * Get message of model selection dialog
     */
    abstract def String getModelSelectionDialogMessage()

    /**
     * Get title of dialog for specifying transformation paths
     */
    abstract def String getSpecifyPathsDialogTitle()

    /**
     * Get message of dialog for specifying transformation paths
     */
    abstract def String getSpecifyPathsDialogMessage()

    /**
     * Get files being imported into a model file mapped to their import aliases
     */
    abstract def Map<String, IFile> getImportedModelFiles(ModelFile modelFile)

    /**
     * Get default transformation target path for file
     */
    abstract def String getDefaultTransformationTargetPath(IFile file)

    /**
     * Get a new instance of the transformation strategy
     */
    abstract protected def AbstractIntermediateModelTransformationStrategy
        getTransformationStrategyInternal()
}