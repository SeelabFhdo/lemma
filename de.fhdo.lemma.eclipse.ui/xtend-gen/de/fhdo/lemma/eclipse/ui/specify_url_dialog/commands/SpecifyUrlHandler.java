package de.fhdo.lemma.eclipse.ui.specify_url_dialog.commands;

import de.fhdo.lemma.eclipse.ui.specify_url_dialog.SpecifyUrlDialog;
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
public class SpecifyUrlHandler extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Constructor
   */
  public SpecifyUrlHandler() {
    super();
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final SpecifyUrlDialog dialog = new SpecifyUrlDialog(this.SHELL);
    dialog.create();
    final int dialogResult = dialog.open();
    if ((dialogResult == Window.CANCEL)) {
      return null;
    }
    Object _xifexpression = null;
    if ((dialogResult == Window.OK)) {
      _xifexpression = InputOutput.<Object>println(dialog.fetchUrl);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
}
