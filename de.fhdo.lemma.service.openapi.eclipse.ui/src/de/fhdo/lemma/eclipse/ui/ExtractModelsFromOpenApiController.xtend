package de.fhdo.lemma.eclipse.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.ui.PlatformUI
import de.fhdo.lemma.eclipse.ui.specify_url_dialog.SpecifyUrlDialog

/**
 * Controller for handling the extraction of LEMMA models from OpenAPI specifications.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ExtractModelsFromOpenApiController extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) {
        val dialog = new SpecifyUrlDialog(SHELL)
        dialog.create
        dialog.open()
        return null
    }
}