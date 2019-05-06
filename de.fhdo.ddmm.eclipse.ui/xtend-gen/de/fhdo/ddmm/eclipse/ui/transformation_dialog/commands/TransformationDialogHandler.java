package de.fhdo.ddmm.eclipse.ui.transformation_dialog.commands;

import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.transformation_dialog.TransformationDialog;
import java.util.List;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for the transformation dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationDialogHandler extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private List<ModelFile> inputModelFiles;
  
  private boolean outputRefinementModels;
  
  private AbstractUiModelTransformationStrategy strategy;
  
  /**
   * Constructor
   */
  public TransformationDialogHandler(final List<ModelFile> inputModelFiles, final boolean outputRefinementModels, final AbstractUiModelTransformationStrategy strategy) {
    if ((inputModelFiles == null)) {
      throw new IllegalArgumentException("Model files must not be null");
    } else {
      boolean _isEmpty = inputModelFiles.isEmpty();
      if (_isEmpty) {
        throw new IllegalArgumentException("Model files must not be empty");
      } else {
        if ((strategy == null)) {
          throw new IllegalArgumentException("Strategy must not be null");
        }
      }
    }
    this.inputModelFiles = inputModelFiles;
    this.outputRefinementModels = outputRefinementModels;
    this.strategy = strategy;
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final TransformationDialog dialog = new TransformationDialog(this.SHELL, this.strategy, this.inputModelFiles, 
      this.outputRefinementModels);
    dialog.create();
    dialog.openAndRunTransformations();
    return null;
  }
}
