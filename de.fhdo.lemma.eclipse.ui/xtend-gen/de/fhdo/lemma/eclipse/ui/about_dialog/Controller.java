package de.fhdo.lemma.eclipse.ui.about_dialog;

import de.fhdo.lemma.eclipse.ui.about_dialog.AboutDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Controller of the "About LEMMA" dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class Controller extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Execute a controller event
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    int _xblockexpression = (int) 0;
    {
      final AboutDialog dialog = new AboutDialog(this.SHELL);
      dialog.create();
      _xblockexpression = dialog.open();
    }
    return Integer.valueOf(_xblockexpression);
  }
}
