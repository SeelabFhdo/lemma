package de.fhdo.lemma.data.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB

/**
 * Highlighting configuration for the Data DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static val FEATURE_ID = "feature"

    /**
     * Configure available highlighting styles
     */
    override configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor)
        acceptor.acceptDefaultHighlighting(FEATURE_ID, "Feature", featureTextStyle)
    }

    /**
     * Feature style
     */
    def TextStyle featureTextStyle() {
        val textStyle = defaultTextStyle().copy();
        textStyle.setStyle(SWT.ITALIC)
        textStyle.setColor(new RGB(106, 62, 62));
        return textStyle;
    }
}