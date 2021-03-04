package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.specify_openapi_dialog.commands.SpecifyOpenApiHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Controller for handling the extraction of lemma models from openapi specifications in the UI.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ExtractLemmaModelsFromOpenApiController extends AbstractHandler {
  private SpecifyOpenApiHandler specifyUrlHandler;
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    SpecifyOpenApiHandler _specifyOpenApiHandler = new SpecifyOpenApiHandler();
    this.specifyUrlHandler = _specifyOpenApiHandler;
    final Object specifyUrlResult = this.specifyUrlHandler.execute(event);
    if ((specifyUrlResult == null)) {
      return null;
    }
    return null;
  }
}
