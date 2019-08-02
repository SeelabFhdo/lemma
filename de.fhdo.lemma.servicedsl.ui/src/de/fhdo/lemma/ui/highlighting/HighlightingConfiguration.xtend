package de.fhdo.lemma.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.SWT

/**
 * Highlighting configuration for the Service DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingConfiguration extends DefaultHighlightingConfiguration {
    public static val ANNOTATION_ID = "annotation"
    public static val API_OPERATION_ID = "apiOperation"
    public static val API_PARAMETER_ID = "apiParameter"

    /**
     * Configure available highlighting styles
     */
    override configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor)
        acceptor.acceptDefaultHighlighting(ANNOTATION_ID, "Annotation", annotationTextStyle)
        acceptor.acceptDefaultHighlighting(API_OPERATION_ID, "API Operation", apiOperationTextStyle)
        acceptor.acceptDefaultHighlighting(API_PARAMETER_ID, "API Parameter", apiParameterTextStyle)
    }

    /**
     * Annotation style
     */
    def TextStyle annotationTextStyle() {
        val textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(111, 111, 111));
        return textStyle;
    }

    /**
     * API operation style
     */
    def TextStyle apiOperationTextStyle() {
        val textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(206, 92, 0));
        return textStyle;
    }

    /**
     * API parameter style
     */
    def TextStyle apiParameterTextStyle() {
        val textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(127, 127, 159));
        textStyle.setStyle(SWT.ITALIC)
        return textStyle;
    }
}