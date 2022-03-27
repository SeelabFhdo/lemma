package de.fhdo.lemma.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

/**
 * This class contains custom autoedit configurations for the Service DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServiceDslAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
  /**
   * Provide autoedit configurations
   */
  @Override
  public void configure(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    super.configure(acceptor);
    this.configureApiOperationComment(acceptor);
  }
  
  /**
   * Custom autoedit configuration for API operation comments
   */
  protected void configureApiOperationComment(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    SingleLineTerminalsStrategyWithLineBreak _singleLineTerminalsStrategyWithLineBreak = new SingleLineTerminalsStrategyWithLineBreak("---", "---");
    acceptor.accept(_singleLineTerminalsStrategyWithLineBreak, 
      IDocument.DEFAULT_CONTENT_TYPE);
  }
}
