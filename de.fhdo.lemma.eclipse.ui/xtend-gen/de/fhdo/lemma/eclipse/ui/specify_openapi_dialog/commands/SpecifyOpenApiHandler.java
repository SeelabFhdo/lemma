package de.fhdo.lemma.eclipse.ui.specify_openapi_dialog.commands;

import de.fhdo.lemma.eclipse.ui.specify_openapi_dialog.SpecifyOpenApiDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Handler for specifying the open api specification url for lemma model extraction.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class SpecifyOpenApiHandler extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Constructor
   */
  public SpecifyOpenApiHandler() {
    super();
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final String isExternal = event.getParameter(
      "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalResolve");
    SpecifyOpenApiDialog _xifexpression = null;
    boolean _equals = isExternal.equals("true");
    if (_equals) {
      SpecifyOpenApiDialog _xblockexpression = null;
      {
        final String fetchUrl = event.getParameter(
          "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalUrl");
        final String serviceName = event.getParameter(
          "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalService");
        final String targetLocation = event.getParameter(
          "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalTargetLocation");
        _xblockexpression = new SpecifyOpenApiDialog(this.SHELL, fetchUrl, serviceName, targetLocation);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = new SpecifyOpenApiDialog(this.SHELL);
    }
    final SpecifyOpenApiDialog dialog = _xifexpression;
    dialog.create();
    final int dialogResult = dialog.open();
    if ((dialogResult == Window.CANCEL)) {
      return null;
    }
    Object _xifexpression_1 = null;
    if ((dialogResult == Window.OK)) {
      _xifexpression_1 = InputOutput.<Object>println("Transformation success!");
    } else {
      _xifexpression_1 = null;
    }
    return _xifexpression_1;
  }
}
