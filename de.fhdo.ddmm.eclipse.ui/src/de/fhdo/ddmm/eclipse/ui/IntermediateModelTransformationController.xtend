package de.fhdo.ddmm.eclipse.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import java.util.List
import de.fhdo.ddmm.eclipse.ui.select_models_dialog.commands.SelectModelsHandler
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler
import de.fhdo.ddmm.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler

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
        val specifyPathsHandlerResult = specifyPathsHandler.execute(event)
        if (specifyPathsHandlerResult === null)
            return null

        /* Execute model transformations */
        val selectedModelFilesWithChildPaths = specifyPathsHandlerResult as List<ModelFile>
        val transformationHandler =
            new TransformationDialogHandler(selectedModelFilesWithChildPaths, strategy)
        transformationHandler.execute(event)

        return null
    }
}