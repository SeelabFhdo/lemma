package de.fhdo.lemma.eclipse.ui

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IFolder

/**
 * Abstract Controller for handling the intermediate model transformation in the UI.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
abstract class AbstractIntermediateModelTransformationController extends AbstractHandler {
     protected List<String> modelFileTypeExtensions

    /**
     * Execute controller handler
     */
    abstract override execute(ExecutionEvent event) throws ExecutionException

    /**
     * Get input files for model transformations
     */
    protected def getInputModelFiles(ExecutionEvent event) {
        if (!transformationOnSelectedModelsOnly(event))
            return allWorkspaceModelFiles()

        val selectedResources = LemmaUiUtils.getSelectedResources(event)
        if (selectedResources.empty)
            return allWorkspaceModelFiles()

        // Transformation was started by user from context menu of the Eclipse Project Explorer on
        // selected projects, folders, and/or files. Find input model files from all selected
        // resources.
        val inputModelFiles = <IProject, List<IFile>>newHashMap
        selectedResources.forEach[
            val projectAndFiles = findModelFiles()
            val project = projectAndFiles.key
            val files = projectAndFiles.value
            if (project !== null && files !== null && !files.empty)
                if (!inputModelFiles.containsKey(project))
                    inputModelFiles.put(project, files)
                else
                    // Project may already be contained in map when more than one resource was
                    // selected from the same project
                    inputModelFiles.get(project).addAll(files)
        ]

        return inputModelFiles
    }

    /**
     * Check if the transformation shall be executed for models in selected resources only
     */
    private def boolean transformationOnSelectedModelsOnly(ExecutionEvent event) {
        val parameterValue = event.getParameter("de.fhdo.lemma.eclipse.ui.commands.parameters" +
            ".selectedModelsOnly")
        return parameterValue !== null && parameterValue.toLowerCase == "true"
    }

    /**
     * Get model files from all projects in the current workspace
     */
    private def allWorkspaceModelFiles() {
        return LemmaUiUtils.findFilesInWorkspaceProjects(modelFileTypeExtensions)
            .filter[project, files | !files.empty]
    }

    /**
     * Dispatcher: Find model files from IResource
     */
    private def dispatch Pair<IProject, List<IFile>> findModelFiles(IResource project) {
        return null -> null
    }

    /**
     * Dispatcher: Find model files from IProject
     */
    private def dispatch findModelFiles(IProject project) {
        return project -> LemmaUiUtils.findFilesInProject(project, modelFileTypeExtensions)
    }

    /**
     * Dispatcher: Find model files from IFolder
     */
    private def dispatch findModelFiles(IFolder folder) {
        val projectFiles = LemmaUiUtils.findFilesInProject(folder.project, modelFileTypeExtensions)
        return folder.project -> projectFiles.filter[
            // Filter model files from folder's project to start with the folder's path (and thus
            // are located physically in the folder)
            folder.location.isPrefixOf(it.location)
        ].toList
    }

    /**
     * Dispatcher: Find model files from IFile
     */
    private def dispatch findModelFiles(IFile file) {
        return file.project -> if (modelFileTypeExtensions.contains(file.fileExtension))
                newArrayList(file)
            else
                emptyList
    }

}