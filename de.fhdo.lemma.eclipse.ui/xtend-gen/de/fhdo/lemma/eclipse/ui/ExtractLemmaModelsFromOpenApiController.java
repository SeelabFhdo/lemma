package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.specify_url_dialog.commands.SpecifyUrlHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Controller for handling the extraction of lemma models from openapi specifications in the UI.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ExtractLemmaModelsFromOpenApiController extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private SpecifyUrlHandler specifyUrlHandler;
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    SpecifyUrlHandler _specifyUrlHandler = new SpecifyUrlHandler();
    this.specifyUrlHandler = _specifyUrlHandler;
    final Object specifyUrlResult = this.specifyUrlHandler.execute(event);
    if ((specifyUrlResult == null)) {
      return null;
    }
    return null;
  }
}
