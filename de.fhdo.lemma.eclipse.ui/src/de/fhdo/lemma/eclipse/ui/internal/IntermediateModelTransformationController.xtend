package de.fhdo.lemma.eclipse.ui.internal

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import java.util.List
import de.fhdo.lemma.eclipse.ui.select_models_dialog.commands.SelectModelsHandler
import de.fhdo.lemma.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler
import de.fhdo.lemma.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IFolder
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.PlatformUI
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy

/**
 * Controller for handling the intermediate model transformation in the UI.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateModelTransformationController extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    AbstractUiModelTransformationStrategy modelTransformationStrategy
    List<String> modelFileTypeExtensions
    String modelTypePrefix

    /**
     * Execute controller handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        try {
            modelTransformationStrategy = new ServiceModelTransformationStrategy
            modelFileTypeExtensions = modelTransformationStrategy.modelFileTypeExtensions
            modelTypePrefix = modelTransformationStrategy.modelTypePrefix
        } catch (Exception ex) {
            ex.printStackTrace
        }

        if (modelFileTypeExtensions === null || modelFileTypeExtensions.empty)
            MessageDialog.openError(SHELL, '''No «modelTypePrefix» models found''', "No " +
                '''«modelTypePrefix» model files could be found, because there were no editors ''' +
                "associated with the respective file types. Do you have the editor plugins " +
                '''for creating «modelTypePrefix» models installed?''')

        /* Select models */
        val selectModelsHandler = new SelectModelsHandler(modelTransformationStrategy,
            getInputModelFiles(event))
        val selectModelsHandlerResult = selectModelsHandler.execute(event)
        if (selectModelsHandlerResult === null)
            return null

        /* Specify paths */
        val selectedModelFiles = selectModelsHandlerResult as List<ModelFile>
        val specifyPathsHandler = new SpecifyPathsHandler(selectedModelFiles,
            modelTransformationStrategy)
        val specifyPathsRawResult = specifyPathsHandler.execute(event)
        if (specifyPathsRawResult === null)
            return null

        /* Execute model transformations */
        val specifyPathsResult
            = specifyPathsRawResult as SpecifyPathsHandler.SpecifyPathsDialogResult
        val transformationHandler = new TransformationDialogHandler(
            specifyPathsResult.selectedModelFiles,
            specifyPathsResult.convertToRelativeUris,
            specifyPathsResult.outputRefinementModels,
            modelTransformationStrategy
        )
        transformationHandler.execute(event)

        return null
    }

    /**
     * Get input files for model transformations
     */
    private def getInputModelFiles(ExecutionEvent event) {
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