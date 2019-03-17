/*
 * generated by Xtext 2.16.0
 */
package de.fhdo.lemma.operationdsl.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import de.fhdo.lemma.operationdsl.ui.highlighting.HighlightingCalculator
import de.fhdo.lemma.operationdsl.ui.highlighting.HighlightingConfiguration
import org.eclipse.xtext.ui.editor.XtextEditor
import de.fhdo.ddmm.eclipse.ui.editor.LiveValidationCapableXtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider
import de.fhdo.ddmm.eclipse.ui.editor.LiveValidationXtextDocumentProvider
import org.eclipse.xtext.service.SingletonBinding
import de.fhdo.ddmm.eclipse.ui.editor.server.ServerConnection

/**
 * Use this class to register components to be used within the Eclipse IDE.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
@FinalFieldsConstructor
class OperationDslUiModule extends AbstractOperationDslUiModule {
    def Class<? extends XtextEditor> bindXtextEditor() {
        LiveValidationCapableXtextEditor
    }

    def Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
        LiveValidationXtextDocumentProvider
    }

    @SingletonBinding(eager=true)
    def ServerConnection bindServerConnection() {
        return ServerConnection.instance
    }

    def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
        HighlightingConfiguration
    }

    def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
        HighlightingCalculator
    }
}
