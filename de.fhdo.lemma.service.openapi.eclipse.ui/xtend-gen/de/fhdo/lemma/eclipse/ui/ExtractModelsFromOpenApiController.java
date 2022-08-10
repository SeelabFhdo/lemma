package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.specify_url_dialog.SpecifyUrlDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Controller for handling the extraction of LEMMA models from OpenAPI specifications.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ExtractModelsFromOpenApiController extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) {
    final SpecifyUrlDialog dialog = new SpecifyUrlDialog(this.SHELL);
    dialog.create();
    dialog.open();
    return null;
  }
}
