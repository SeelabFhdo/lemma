package de.fhdo.lemma.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.graphics.RGB

/**
 * Highlighting configuration for the Service DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static val ANNOTATION_ID = "annotation"

    /**
     * Configure available highlighting styles
     */
    override configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor)
        acceptor.acceptDefaultHighlighting(ANNOTATION_ID, "Annotation", annotationTextStyle)
    }

    /**
     * Annotation style
     */
    def TextStyle annotationTextStyle() {
        val textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(111, 111, 111));
        return textStyle;
    }
}