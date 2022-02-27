package de.fhdo.lemma.eclipse.ui

import java.util.List
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import java.util.LinkedHashMap
import java.util.LinkedList
import java.util.Comparator
import java.util.Collections
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription

/**
 * Abstract strategy for preparing, displaying and controlling intermediate models' transformation
 * in the UI.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractUiModelTransformationStrategy {
    var AbstractIntermediateModelTransformationStrategy<?, ?> transformationStrategy

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
     * Sort a list of model files according to their ordering intended for transformation. The
     * result will be a new list, i.e., the given list of model files will not be changed.
     */
    final def sortByTransformationOrder(List<ModelFile> modelFiles) {
        val orderedModelFiles = <ModelFile>newLinkedList
        orderedModelFiles.addAll(modelFiles)

        Collections.sort(orderedModelFiles, new Comparator {
            override compare(Object o1, Object o2) {
                val file1 = o1 as ModelFile
                val fileTypeIndex1 = modelTypeTransformationOrdering
                    .indexOf(file1.fileTypeDescription.fileType)

                val file2 = o2 as ModelFile
                val fileTypeIndex2 = modelTypeTransformationOrdering
                    .indexOf(file2.fileTypeDescription.fileType)
                return Integer.compare(fileTypeIndex1, fileTypeIndex2)
            }
        })

        return orderedModelFiles
    }

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
     * Get imported files of a model in their import order and mapped to their import aliases
     */
    abstract def LinkedHashMap<String, IFile> getImportedModelFiles(ModelFile modelFile)

    /**
     * Get default transformation target path for file
     */
    abstract def String getDefaultTransformationTargetPath(IFile file)

    /**
     * Get a new instance of the transformation strategy
     */
    abstract protected def AbstractIntermediateModelTransformationStrategy<?, ?>
        getTransformationStrategyInternal()
}