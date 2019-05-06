package de.fhdo.ddmm.eclipse.ui;

import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.ServiceModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.select_models_dialog.commands.SelectModelsHandler;
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler;
import de.fhdo.ddmm.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler;
import java.util.List;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Controller for handling the intermediate model transformation in the UI.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateModelTransformationController extends AbstractHandler {
  /**
   * Execute controller handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    AbstractUiModelTransformationStrategy strategy = null;
    try {
      ServiceModelTransformationStrategy _serviceModelTransformationStrategy = new ServiceModelTransformationStrategy();
      strategy = _serviceModelTransformationStrategy;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ex.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final SelectModelsHandler selectModelsHandler = new SelectModelsHandler(strategy);
    final Object selectModelsHandlerResult = selectModelsHandler.execute(event);
    if ((selectModelsHandlerResult == null)) {
      return null;
    }
    final List<ModelFile> selectedModelFiles = ((List<ModelFile>) selectModelsHandlerResult);
    final SpecifyPathsHandler specifyPathsHandler = new SpecifyPathsHandler(selectedModelFiles, strategy);
    final Object specifyPathsRawResult = specifyPathsHandler.execute(event);
    if ((specifyPathsRawResult == null)) {
      return null;
    }
    final Pair<List<ModelFile>, Boolean> specifyPathsResult = ((Pair<List<ModelFile>, Boolean>) specifyPathsRawResult);
    final List<ModelFile> selectedModelFilesWithChildPaths = specifyPathsResult.getKey();
    final Boolean outputRefinementModels = specifyPathsResult.getValue();
    final TransformationDialogHandler transformationHandler = new TransformationDialogHandler(selectedModelFilesWithChildPaths, (outputRefinementModels).booleanValue(), strategy);
    transformationHandler.execute(event);
    return null;
  }
}
