package de.fhdo.ddmm.technology.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

/**
 * Highlighting configuration for the Technology DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static val OPERATION_ENVIRONMENT_NAME_ID = "operationEnvironmentName"

    /**
     * Configure available highlighting styles
     */
    override configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor)
        // Operation environment names
        acceptor.acceptDefaultHighlighting(OPERATION_ENVIRONMENT_NAME_ID, "Operation environment " +
            "name", stringTextStyle)
    }
}