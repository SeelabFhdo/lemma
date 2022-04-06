package de.fhdo.lemma.eclipse.ui

import de.fhdo.lemma.eclipse.ui.specify_url_dialog.commands.SpecifyUrlHandler
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException

/**
 * Controller for handling the extraction of lemma models from openapi specifications in the UI.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ExtractModelsFromOpenApiController extends AbstractHandler {
    val specifyUrlHandler = new SpecifyUrlHandler()

    override execute(ExecutionEvent event) throws ExecutionException {
        val specifyUrlResult = specifyUrlHandler.execute(event)
        if (specifyUrlResult === null)
            return null
    }
}