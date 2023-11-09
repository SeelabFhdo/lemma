package de.fhdo.lemma.technology.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Highlighting configuration for the Data DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class HighlightingConfiguration extends DefaultHighlightingConfiguration {
  public static final String FEATURE_ID = "feature";

  /**
   * Configure available highlighting styles
   */
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    super.configure(acceptor);
    acceptor.acceptDefaultHighlighting(HighlightingConfiguration.FEATURE_ID, "Feature", this.featureTextStyle());
  }

  /**
   * Feature style
   */
  public TextStyle featureTextStyle() {
    final TextStyle textStyle = this.defaultTextStyle().copy();
    textStyle.setStyle(SWT.ITALIC);
    RGB _rGB = new RGB(106, 62, 62);
    textStyle.setColor(_rGB);
    return textStyle;
  }
}
