package de.fhdo.lemma.ui.autoedit

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider
import org.eclipse.jface.text.IDocument

/**
 * This class contains custom autoedit configurations for the Service DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServiceDslAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
    /**
     * Provide autoedit configurations
     */
    override configure(IEditStrategyAcceptor acceptor) {
        super.configure(acceptor)
        configureApiOperationComment(acceptor)
    }

    /**
     * Custom autoedit configuration for API operation comments
     */
    protected def configureApiOperationComment(IEditStrategyAcceptor acceptor) {
        acceptor.accept(
            new SingleLineTerminalsStrategyWithLineBreak("---", "---"),
            IDocument.DEFAULT_CONTENT_TYPE
        )
    }
}