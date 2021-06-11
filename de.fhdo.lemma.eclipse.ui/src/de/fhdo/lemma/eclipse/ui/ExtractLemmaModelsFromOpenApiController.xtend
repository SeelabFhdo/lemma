package de.fhdo.lemma.eclipse.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import org.eclipse.jface.dialogs.MessageDialog
import de.fhdo.lemma.eclipse.ui.specify_url_dialog.commands.SpecifyUrlHandler

/**
 * Controller for handling the extraction of lemma models from openapi specifications in the UI.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ExtractLemmaModelsFromOpenApiController extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell
    SpecifyUrlHandler specifyUrlHandler

    override execute(ExecutionEvent event) throws ExecutionException {
        this.specifyUrlHandler = new SpecifyUrlHandler()
        val specifyUrlResult = specifyUrlHandler.execute(event)
        if (specifyUrlResult === null)
            return null
    }
}
