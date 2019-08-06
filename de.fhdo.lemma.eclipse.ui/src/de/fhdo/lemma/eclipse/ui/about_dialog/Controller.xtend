package de.fhdo.lemma.eclipse.ui.about_dialog

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI

/**
 * Controller of the "About LEMMA" dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class Controller  extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    /**
     * Execute a controller event
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        val dialog = new AboutDialog(SHELL)
        dialog.create()
        dialog.open()
    }
}