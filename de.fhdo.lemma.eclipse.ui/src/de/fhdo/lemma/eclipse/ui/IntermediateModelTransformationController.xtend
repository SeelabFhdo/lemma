package de.fhdo.lemma.eclipse.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import java.util.List
import de.fhdo.lemma.eclipse.ui.select_models_dialog.commands.SelectModelsHandler
import de.fhdo.lemma.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler
import de.fhdo.lemma.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler

/**
 * Controller for handling the intermediate model transformation in the UI.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateModelTransformationController extends AbstractHandler {
    /**
     * Execute controller handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        var AbstractUiModelTransformationStrategy strategy
        try {
            strategy = new ServiceModelTransformationStrategy
        } catch (Exception ex) {
            ex.printStackTrace
        }

        /* Select models */
        val selectModelsHandler = new SelectModelsHandler(strategy)
        val selectModelsHandlerResult = selectModelsHandler.execute(event)
        if (selectModelsHandlerResult === null)
            return null

        /* Specify paths */
        val selectedModelFiles = selectModelsHandlerResult as List<ModelFile>
        val specifyPathsHandler = new SpecifyPathsHandler(selectedModelFiles, strategy)
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
            strategy
        )
        transformationHandler.execute(event)

        return null
    }
}