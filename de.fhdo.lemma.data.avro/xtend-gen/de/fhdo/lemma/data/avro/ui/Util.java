package de.fhdo.lemma.data.avro.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class collects _static_ utility methods for the UI parts of the Avro plugin.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Util {
  /**
   * Extension of Avro protocol files
   */
  public static final String PROTOCOL_FILE_EXTENSION = "avpr";
  
  /**
   * Extension of Avro schema specification files
   */
  public static final String SCHEMA_FILE_EXTENSION = "avsc";
  
  /**
   * Get selected IFile from an ExecutionEvent
   */
  public static IFile getSelectedFile(final ExecutionEvent event) {
    try {
      final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
      ISelection _selection = window.getSelectionService().getSelection();
      final IStructuredSelection selection = ((IStructuredSelection) _selection);
      final Object selectedElement = selection.getFirstElement();
      return ((IFile) selectedElement);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Show error message dialog in the current Shell
   */
  public static void showError(final String title, final String message) {
    MessageDialog.openError(Display.getCurrent().getActiveShell(), title, message);
  }
  
  /**
   * Show information message dialog in the current Shell
   */
  public static void showInfo(final String title, final String message) {
    MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, message);
  }
  
  /**
   * Show question message dialog in the current Shell
   */
  public static boolean question(final String title, final String message) {
    return MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), title, message);
  }
}
