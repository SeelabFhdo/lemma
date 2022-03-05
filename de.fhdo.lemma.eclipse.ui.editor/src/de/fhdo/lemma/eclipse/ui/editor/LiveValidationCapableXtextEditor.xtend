package de.fhdo.lemma.eclipse.ui.editor

import org.eclipse.xtext.ui.editor.XtextEditor
import java.util.List
import org.eclipse.xtext.validation.Issue.IssueImpl
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.ui.editor.validation.MarkerCreator
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider
import org.eclipse.xtext.ui.validation.MarkerTypeProvider
import com.google.inject.Inject
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor
import de.fhdo.lemma.live_validation.model.IssueDiagnostic
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.eclipse.xtext.util.CancelIndicator

/**
 * Xtext-specific editor that is capable of communicating with Live Validation LSP servers. It can
 * initiate a validation of an Xtext document and display received issues.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationCapableXtextEditor extends XtextEditor {
    @Inject
    IResourceValidator resourceValidator

    @Inject
    IssueResolutionProvider issueResolutionProvider

    @Inject
    MarkerTypeProvider markerTypeProvider

    /**
     * Add markers for the received validation results (Live Validation issues)
     */
    def addIssueMarkers(List<IssueDiagnostic> issues) {
        val markerCreator = new MarkerCreator
        val xtextIssues = <Issue>newArrayList
        xtextIssues.addAll(issues.map[xtextIssue])
        xtextIssues.forEach[
            markerCreator.createMarker(it, resource, markerTypeProvider.getMarkerType(it))
        ]

        // Re-validate the current document as otherwise processIssues() will remove markers from
        // regular model validations built into modeling languages
        xtextIssues.addAll(performRegularValidationOnDocument())

        val annotationIssueProcessor = new AnnotationIssueProcessor(document,
            documentProvider.getAnnotationModel(editorInput), issueResolutionProvider)
        annotationIssueProcessor.processIssues(xtextIssues, progressMonitor)
    }

    /**
     * Perform a regular validation based on validators built into modeling languages on the current
     * document
     */
    private def performRegularValidationOnDocument() {
        // Ported from org.eclipse.xtext.ui.editor.validation.ValidationJob.createIssues()
        document.tryReadOnly(new CancelableUnitOfWork<List<Issue>, XtextResource>() {
            override exec(XtextResource resource, CancelIndicator outerIndicator) {
                if (resource.isValidationDisabled())
                    return emptyList

                resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST,
                    new CancelIndicator() {
                        override isCanceled() {
                            return outerIndicator.canceled
                        }
                    })
            }
        }, [emptyList])
    }

    /**
     * Helper to transform a Live Validation issue of type IssueDiagnostic to an Xtext issue of type
     * Issue
     */
    private def Issue xtextIssue(IssueDiagnostic issue) {
        val xtextIssue = new IssueImpl
        xtextIssue.severity = switch(issue.severity) {
            case Error: Severity.ERROR
            case Information: Severity.INFO
            case Warning: Severity.WARNING
            // DiagnosticSeverity.Hint becomes a Severity.INFO
            default: Severity.INFO
        }

        xtextIssue.lineNumber = issue.range.lineNumber
        xtextIssue.column = issue.range.column
        xtextIssue.offset = issue.range.offset
        xtextIssue.length = issue.range.length
        xtextIssue.message = "Live Validation: " + issue.message
        xtextIssue.type = CheckType.FAST
        return xtextIssue
    }
}