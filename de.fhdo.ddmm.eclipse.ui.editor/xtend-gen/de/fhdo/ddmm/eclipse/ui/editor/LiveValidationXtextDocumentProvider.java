package de.fhdo.ddmm.eclipse.ui.editor;

import com.google.inject.Inject;
import de.fhdo.ddmm.eclipse.ui.editor.LiveValidationJob;
import de.fhdo.ddmm.eclipse.ui.editor.server.ServerConnection;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

/**
 * Custom Xtext document provider for Live Validation. It sets up a Live Validation job to trigger
 * server-side validations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LiveValidationXtextDocumentProvider extends XtextDocumentProvider {
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private IssueResolutionProvider issueResolutionProvider;
  
  @Inject
  private ServerConnection languageServerConnection;
  
  /**
   * Set up the annotation issue processor and the Live Validation job
   */
  public void registerAnnotationInfoProcessor(final AbstractDocumentProvider.ElementInfo info) {
    final XtextDocument document = ((XtextDocument) info.fDocument);
    if ((info.fModel != null)) {
      final AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(document, info.fModel, 
        this.issueResolutionProvider);
      final LiveValidationJob job = new LiveValidationJob(this.resourceValidator, document, annotationIssueProcessor, 
        CheckMode.FAST_ONLY, this.languageServerConnection);
      document.setValidationJob(job);
    }
  }
}
