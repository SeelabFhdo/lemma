package de.fhdo.lemma.eclipse.ui.specify_openapi_dialog.commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import org.eclipse.jface.window.Window
import de.fhdo.lemma.eclipse.ui.specify_openapi_dialog.SpecifyOpenApiDialog

/**
 * Handler for specifying the open api specification url for lemma model extraction.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class SpecifyOpenApiHandler extends AbstractHandler {
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
        val isExternal = event.getParameter(
            "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalResolve")

        /* Create dialog */
        val dialog = if (isExternal.equals("true")) {
                val fetchUrl = event.getParameter(
                    "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalUrl")
                val serviceName = event.getParameter(
                    "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalService")
                val targetLocation = event.getParameter(
                    "de.fhdo.lemma.eclipse.ui.commands.parameters.openApiExternalTargetLocation")
                new SpecifyOpenApiDialog(SHELL, fetchUrl, serviceName, targetLocation)
            } else {
                new SpecifyOpenApiDialog(SHELL)
            }
        dialog.create
        /*
         * Show dialog and handle user interactions
         */
        val dialogResult = dialog.open()
        if (dialogResult === Window.CANCEL)
            return null

        return if (dialogResult === Window.OK)
            println("Transformation success!")
        else
            null
    }

}
