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

/**
 * Xtext-specific editor that is capable of communicating with Live Validation LSP servers. It can
 * initiate a validation of an Xtext document and display received issues.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationCapableXtextEditor extends XtextEditor {
    @Inject
    IssueResolutionProvider issueResolutionProvider

    @Inject
    MarkerTypeProvider markerTypeProvider

    /**
     * Add markers for the received validation results (Live Validation issues)
     */
    def addIssueMarkers(List<IssueDiagnostic> issues) {
        val markerCreator = new MarkerCreator
        val xtextIssues = issues.map[xtextIssue]
        xtextIssues.forEach[
            markerCreator.createMarker(it, resource, markerTypeProvider.getMarkerType(it))
        ]

        val annotationIssueProcessor = new AnnotationIssueProcessor(document,
            documentProvider.getAnnotationModel(editorInput), issueResolutionProvider)
        annotationIssueProcessor.processIssues(xtextIssues, progressMonitor)
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