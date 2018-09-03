package de.fhdo.ddmm.operationdsl.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

/**
 * Highlighting configuration for the Operation DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static val DEPLOYMENT_TECHNOLOGY_NAME_ID = "deploymentTechnologyName"
    public static val INFRASTRUCTURE_TECHNOLOGY_NAME_ID = "infrastructureTechnologyName"

    /**
     * Configure available highlighting styles
     */
    override configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor)
        // Deployment technology names
        acceptor.acceptDefaultHighlighting(DEPLOYMENT_TECHNOLOGY_NAME_ID, "Deployment technology " +
            "name", keywordTextStyle)
        // Infrastructure technology names
        acceptor.acceptDefaultHighlighting(INFRASTRUCTURE_TECHNOLOGY_NAME_ID, "Infrastructure " +
            "technology name", keywordTextStyle)
    }
}