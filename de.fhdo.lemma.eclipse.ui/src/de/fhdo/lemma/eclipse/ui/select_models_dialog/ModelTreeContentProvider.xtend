package de.fhdo.lemma.eclipse.ui.select_models_dialog

import org.eclipse.jface.viewers.ITreeContentProvider
import java.util.Map
import org.eclipse.core.resources.IProject
import java.util.List
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy
import java.util.Comparator
import org.eclipse.core.resources.IFile

/**
 * Tree content provider for model files from which intermediate models could be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTreeContentProvider implements ITreeContentProvider {
    Map<IProject, List<ModelFile>> inputModelFilesWithProjects
    AbstractUiModelTransformationStrategy strategy

    /**
     * Constructor
     */
    new(Map<IProject, List<ModelFile>> inputModelFilesWithProjects,
        AbstractUiModelTransformationStrategy strategy) {
        if (inputModelFilesWithProjects === null)
            throw new IllegalArgumentException("Input model files must not be null")
        else if (strategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")

        this.inputModelFilesWithProjects = inputModelFilesWithProjects
        this.strategy = strategy
    }

    /**
     * Get children of parent element
     */
    override getChildren(Object parentElement) {
        if (!hasChildren(parentElement))
            return newArrayOfSize(0)

        val children = switch (parentElement) {
            IProject: inputModelFilesWithProjects.get(parentElement)
            ModelFile: parentElement.children.sort
        }

        return children.filter[!hasErrors].toList.toArray
    }

    /**
     * Get root elements
     */
    override getElements(Object inputElement) {
        return inputModelFilesWithProjects.keySet.sortWith(new Comparator<IProject>() {
            override compare(IProject p1, IProject p2) {
                return p1.fullPath.toString.compareTo(p2.fullPath.toString)
            }
        })
    }

    /**
     * Get parent of an element
     */
    override getParent(Object element) {
        return if (element instanceof ModelFile)
            element.parent
        else
            null
    }

    /**
     * Determine if the given element has children
     */
    override hasChildren(Object element) {
        return switch (element) {
            IProject: {
                inputModelFilesWithProjects.get(element) !== null &&
                !inputModelFilesWithProjects.get(element).empty
            }
            // For modeling files the children are determined by the directly imported models and
            // depending on the current transformation strategy. Therefore, the children of a model
            // file need to be parsed from their imported files. Furthermore, they are put into the
            // list of children of the current tree representation of the model file.
            ModelFile : {
                // If the element has not been scanned for children, i.e., parsed for imported
                // files, do it now
                if (!element.scannedForChildren) {
                    val importedModelFiles = strategy.getImportedModelFiles(element)
                    importedModelFiles.forEach[importAlias, file |
                        val modelFile = createModelFile(file, element, importAlias)
                        if (!modelFile.hasErrors)
                            element.children.add(modelFile)
                    ]

                    // Perform child scanning only once per element
                    element.scannedForChildren = true
                }

                !element.children.empty
            }
            default: false
        }
    }

    /**
     * Helper to create a ModelFile instance
     */
    private def createModelFile(IFile file, ModelFile parent, String importAlias) {
        return new ModelFile(
            file,
            strategy.getModelFileTypeDescription(file.fileExtension),
            parent,
            importAlias
        )
    }
}