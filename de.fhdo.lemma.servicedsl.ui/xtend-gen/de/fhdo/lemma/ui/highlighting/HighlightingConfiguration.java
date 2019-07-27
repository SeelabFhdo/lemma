package de.fhdo.lemma.ui.highlighting;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Highlighting configuration for the Service DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class HighlightingConfiguration extends DefaultHighlightingConfiguration {
  public static final String ANNOTATION_ID = "annotation";
  
  /**
   * Configure available highlighting styles
   */
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    super.configure(acceptor);
    acceptor.acceptDefaultHighlighting(HighlightingConfiguration.ANNOTATION_ID, "Annotation", this.annotationTextStyle());
  }
  
  /**
   * Annotation style
   */
  public TextStyle annotationTextStyle() {
    final TextStyle textStyle = this.defaultTextStyle().copy();
    RGB _rGB = new RGB(111, 111, 111);
    textStyle.setColor(_rGB);
    return textStyle;
  }
}
