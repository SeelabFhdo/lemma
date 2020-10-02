package de.fhdo.lemma.eclipse.ui

import de.fhdo.lemma.eclipse.ui.select_models_dialog.commands.SelectModelsHandler
import de.fhdo.lemma.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler
import de.fhdo.lemma.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler
import java.util.List
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import org.eclipse.jface.dialogs.MessageDialog


/**
 * Controller for handling the intermediate operation model transformation in the UI.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class IntermediateOperationModelTransformationController
    extends AbstractIntermediateModelTransformationController {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    AbstractUiModelTransformationStrategy modelTransformationStrategy
    String modelTypePrefix
    /**
     * Execute controller handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        try {
            modelTransformationStrategy = new OperationModelTransformationStrategy
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
        val specifyPathsResult = specifyPathsRawResult as Pair<List<ModelFile>, Boolean>
        val selectedModelFilesWithChildPaths = specifyPathsResult.key
        val outputRefinementModels = specifyPathsResult.value
        val transformationHandler = new TransformationDialogHandler(
            selectedModelFilesWithChildPaths,
            outputRefinementModels,
            modelTransformationStrategy
        )
        transformationHandler.execute(event)

        return null
    }
}