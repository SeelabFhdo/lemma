package de.fhdo.lemma.eclipse.ui.specify_url_dialog.commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import de.fhdo.lemma.eclipse.ui.specify_url_dialog.SpecifyUrlDialog
import org.eclipse.jface.window.Window

/**
 * Handler for specifying the OpenAPI specification url for LEMMA model extraction.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class SpecifyUrlHandler extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    /**
     * Constructor
     */
    new() {
        super()
    }

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        /* Create dialog */
        val dialog = new SpecifyUrlDialog(SHELL)
         dialog.create
         /*
         * Show dialog and handle user interactions
         */
        val dialogResult = dialog.open()
        if (dialogResult === Window.CANCEL)
            return null

        return if (dialogResult === Window.OK)
            println(dialog.fetchUrl)
        else
            null
    }


}