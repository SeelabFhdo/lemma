package de.fhdo.lemma.eclipse.ui.editor

import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider
import org.eclipse.xtext.validation.IResourceValidator
import com.google.inject.Inject
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor
import org.eclipse.xtext.validation.CheckMode
import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection

/**
 * Custom Xtext document provider for Live Validation. It sets up a Live Validation job to trigger
 * server-side validations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationXtextDocumentProvider extends XtextDocumentProvider {
    @Inject
    IResourceValidator resourceValidator

    @Inject
    IssueResolutionProvider issueResolutionProvider

    @Inject
    ServerConnection languageServerConnection

    /**
     * Set up the annotation issue processor and the Live Validation job
     */
    override registerAnnotationInfoProcessor(ElementInfo info) {
        val document = info.fDocument as XtextDocument
        if (info.fModel !== null) {
            val annotationIssueProcessor = new AnnotationIssueProcessor(document, info.fModel,
                issueResolutionProvider)
            val job = new LiveValidationJob(resourceValidator, document, annotationIssueProcessor,
                CheckMode.FAST_ONLY, languageServerConnection)
            document.setValidationJob(job)
        }
    }
}