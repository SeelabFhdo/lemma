package de.fhdo.lemma.data.avro.ui

import org.eclipse.core.resources.IFile
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display

/**
 * This class collects _static_ utility methods for the UI parts of the Avro plugin.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Util {
    /**
     * Extension of Avro protocol files
     */
    public static val PROTOCOL_FILE_EXTENSION = "avpr"

    /**
     * Extension of Avro schema specification files
     */
    public static val SCHEMA_FILE_EXTENSION = "avsc"

    /**
     * Get selected IFile from an ExecutionEvent
     */
    static def IFile getSelectedFile(ExecutionEvent event) {
        val window = HandlerUtil.getActiveWorkbenchWindowChecked(event)
        val selection = window.selectionService.selection as IStructuredSelection
        val selectedElement = selection.firstElement
        return selectedElement as IFile
    }

    /**
     * Show error message dialog in the current Shell
     */
    static def void showError(String title, String message) {
        MessageDialog.openError(Display.current.activeShell, title, message)
    }

    /**
     * Show information message dialog in the current Shell
     */
    static def void showInfo(String title, String message) {
        MessageDialog.openInformation(Display.current.activeShell, title, message)
    }

    /**
     * Show question message dialog in the current Shell
     */
    static def boolean question(String title, String message) {
        return MessageDialog.openQuestion(Display.current.activeShell, title, message)
    }
}