package de.fhdo.lemma.eclipse.ui.editor;

import com.google.inject.Inject;
import de.fhdo.lemma.live_validation.common.IssueDiagnostic;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Xtext-specific editor that is capable of communicating with Live Validation LSP servers. It can
 * initiate a validation of an Xtext document and display received issues.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LiveValidationCapableXtextEditor extends XtextEditor {
  @Inject
  private IssueResolutionProvider issueResolutionProvider;
  
  @Inject
  private MarkerTypeProvider markerTypeProvider;
  
  /**
   * Add markers for the received validation results (Live Validation issues)
   */
  public void addIssueMarkers(final List<IssueDiagnostic> issues) {
    final MarkerCreator markerCreator = new MarkerCreator();
    final Function1<IssueDiagnostic, Issue> _function = new Function1<IssueDiagnostic, Issue>() {
      public Issue apply(final IssueDiagnostic it) {
        return LiveValidationCapableXtextEditor.this.xtextIssue(it);
      }
    };
    final List<Issue> xtextIssues = ListExtensions.<IssueDiagnostic, Issue>map(issues, _function);
    final Consumer<Issue> _function_1 = new Consumer<Issue>() {
      public void accept(final Issue it) {
        try {
          markerCreator.createMarker(it, LiveValidationCapableXtextEditor.this.getResource(), LiveValidationCapableXtextEditor.this.markerTypeProvider.getMarkerType(it));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    xtextIssues.forEach(_function_1);
    IXtextDocument _document = this.getDocument();
    IAnnotationModel _annotationModel = this.getDocumentProvider().getAnnotationModel(this.getEditorInput());
    final AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(_document, _annotationModel, this.issueResolutionProvider);
    annotationIssueProcessor.processIssues(xtextIssues, this.getProgressMonitor());
  }
  
  /**
   * Helper to transform a Live Validation issue of type IssueDiagnostic to an Xtext issue of type
   * Issue
   */
  private Issue xtextIssue(final IssueDiagnostic issue) {
    final Issue.IssueImpl xtextIssue = new Issue.IssueImpl();
    Severity _switchResult = null;
    DiagnosticSeverity _severity = issue.getSeverity();
    if (_severity != null) {
      switch (_severity) {
        case Error:
          _switchResult = Severity.ERROR;
          break;
        case Information:
          _switchResult = Severity.INFO;
          break;
        case Warning:
          _switchResult = Severity.WARNING;
          break;
        default:
          _switchResult = Severity.INFO;
          break;
      }
    } else {
      _switchResult = Severity.INFO;
    }
    xtextIssue.setSeverity(_switchResult);
    xtextIssue.setLineNumber(Integer.valueOf(issue.getRange().getLineNumber()));
    xtextIssue.setColumn(Integer.valueOf(issue.getRange().getColumn()));
    xtextIssue.setOffset(Integer.valueOf(issue.getRange().getOffset()));
    xtextIssue.setLength(Integer.valueOf(issue.getRange().getLength()));
    String _message = issue.getMessage();
    String _plus = ("Live Validation: " + _message);
    xtextIssue.setMessage(_plus);
    xtextIssue.setType(CheckType.FAST);
    return xtextIssue;
  }
}
