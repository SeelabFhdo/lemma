package de.fhdo.lemma.eclipse.ui.editor;

import com.google.inject.Inject;
import de.fhdo.lemma.live_validation.model.IssueDiagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
  private IResourceValidator resourceValidator;

  @Inject
  private IssueResolutionProvider issueResolutionProvider;

  @Inject
  private MarkerTypeProvider markerTypeProvider;

  /**
   * Add markers for the received validation results (Live Validation issues)
   */
  public void addIssueMarkers(final List<IssueDiagnostic> issues) {
    final MarkerCreator markerCreator = new MarkerCreator();
    final ArrayList<Issue> xtextIssues = CollectionLiterals.<Issue>newArrayList();
    final Function1<IssueDiagnostic, Issue> _function = (IssueDiagnostic it) -> {
      return this.xtextIssue(it);
    };
    xtextIssues.addAll(ListExtensions.<IssueDiagnostic, Issue>map(issues, _function));
    final Consumer<Issue> _function_1 = (Issue it) -> {
      try {
        markerCreator.createMarker(it, this.getResource(), this.markerTypeProvider.getMarkerType(it));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    xtextIssues.forEach(_function_1);
    xtextIssues.addAll(this.performRegularValidationOnDocument());
    IXtextDocument _document = this.getDocument();
    IAnnotationModel _annotationModel = this.getDocumentProvider().getAnnotationModel(this.getEditorInput());
    final AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(_document, _annotationModel, this.issueResolutionProvider);
    annotationIssueProcessor.processIssues(xtextIssues, this.getProgressMonitor());
  }

  /**
   * Perform a regular validation based on validators built into modeling languages on the current
   * document
   */
  private List<Issue> performRegularValidationOnDocument() {
    IXtextDocument _document = this.getDocument();
    final Supplier<List<Issue>> _function = () -> {
      return CollectionLiterals.<Issue>emptyList();
    };
    return _document.<List<Issue>>tryReadOnly(new CancelableUnitOfWork<List<Issue>, XtextResource>() {
      @Override
      public List<Issue> exec(final XtextResource resource, final CancelIndicator outerIndicator) {
        List<Issue> _xblockexpression = null;
        {
          boolean _isValidationDisabled = resource.isValidationDisabled();
          if (_isValidationDisabled) {
            return CollectionLiterals.<Issue>emptyList();
          }
          _xblockexpression = LiveValidationCapableXtextEditor.this.resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, 
            new CancelIndicator() {
              @Override
              public boolean isCanceled() {
                return outerIndicator.isCanceled();
              }
            });
        }
        return _xblockexpression;
      }
    }, _function);
  }

  /**
   * Helper to transform a Live Validation issue of type IssueDiagnostic to an Xtext issue of type
   * Issue
   */
  private Issue xtextIssue(final IssueDiagnostic issue) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field severity is undefined for the type IssueDiagnostic"
      + "\nThe method or field Information is undefined"
      + "\nThe method or field Warning is undefined");
  }
}
