package de.fhdo.lemma.ui.highlighting;

import org.eclipse.swt.SWT;
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

  public static final String API_OPERATION_ID = "apiOperation";

  public static final String API_PARAMETER_ID = "apiParameter";

  /**
   * Configure available highlighting styles
   */
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    super.configure(acceptor);
    acceptor.acceptDefaultHighlighting(HighlightingConfiguration.ANNOTATION_ID, "Annotation", this.annotationTextStyle());
    acceptor.acceptDefaultHighlighting(HighlightingConfiguration.API_OPERATION_ID, "API Operation", this.apiOperationTextStyle());
    acceptor.acceptDefaultHighlighting(HighlightingConfiguration.API_PARAMETER_ID, "API Parameter", this.apiParameterTextStyle());
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

  /**
   * API operation style
   */
  public TextStyle apiOperationTextStyle() {
    final TextStyle textStyle = this.defaultTextStyle().copy();
    RGB _rGB = new RGB(206, 92, 0);
    textStyle.setColor(_rGB);
    return textStyle;
  }

  /**
   * API parameter style
   */
  public TextStyle apiParameterTextStyle() {
    final TextStyle textStyle = this.defaultTextStyle().copy();
    RGB _rGB = new RGB(127, 127, 159);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.ITALIC);
    return textStyle;
  }
}
