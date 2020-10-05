package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.AbstractIntermediateModelTransformationController;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.select_models_dialog.commands.SelectModelsHandler;
import de.fhdo.lemma.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler;
import de.fhdo.lemma.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler;
import java.util.List;
import java.util.Map;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Controller for handling the intermediate operation model transformation in the UI.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class IntermediateOperationModelTransformationController extends AbstractIntermediateModelTransformationController {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private AbstractUiModelTransformationStrategy modelTransformationStrategy;
  
  private String modelTypePrefix;
  
  /**
   * Execute controller handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      OperationModelTransformationStrategy _operationModelTransformationStrategy = new OperationModelTransformationStrategy();
      this.modelTransformationStrategy = _operationModelTransformationStrategy;
      this.modelFileTypeExtensions = this.modelTransformationStrategy.getModelFileTypeExtensions();
      this.modelTypePrefix = this.modelTransformationStrategy.getModelTypePrefix();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ex.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if (((this.modelFileTypeExtensions == null) || this.modelFileTypeExtensions.isEmpty())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No ");
      _builder.append(this.modelTypePrefix);
      _builder.append(" models found");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(this.modelTypePrefix);
      _builder_1.append(" model files could be found, because there were no editors ");
      String _plus = ("No " + _builder_1);
      String _plus_1 = (_plus + 
        "associated with the respective file types. Do you have the editor plugins ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("for creating ");
      _builder_2.append(this.modelTypePrefix);
      _builder_2.append(" models installed?");
      String _plus_2 = (_plus_1 + _builder_2);
      MessageDialog.openError(this.SHELL, _builder.toString(), _plus_2);
    }
    Map<IProject, List<IFile>> _inputModelFiles = this.getInputModelFiles(event);
    final SelectModelsHandler selectModelsHandler = new SelectModelsHandler(this.modelTransformationStrategy, _inputModelFiles);
    final Object selectModelsHandlerResult = selectModelsHandler.execute(event);
    if ((selectModelsHandlerResult == null)) {
      return null;
    }
    final List<ModelFile> selectedModelFiles = ((List<ModelFile>) selectModelsHandlerResult);
    final SpecifyPathsHandler specifyPathsHandler = new SpecifyPathsHandler(selectedModelFiles, 
      this.modelTransformationStrategy);
    final Object specifyPathsRawResult = specifyPathsHandler.execute(event);
    if ((specifyPathsRawResult == null)) {
      return null;
    }
    final Pair<List<ModelFile>, Boolean> specifyPathsResult = ((Pair<List<ModelFile>, Boolean>) specifyPathsRawResult);
    final List<ModelFile> selectedModelFilesWithChildPaths = specifyPathsResult.getKey();
    final Boolean outputRefinementModels = specifyPathsResult.getValue();
    final TransformationDialogHandler transformationHandler = new TransformationDialogHandler(selectedModelFilesWithChildPaths, (outputRefinementModels).booleanValue(), 
      this.modelTransformationStrategy);
    transformationHandler.execute(event);
    return null;
  }
}
