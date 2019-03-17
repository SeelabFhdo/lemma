package de.fhdo.ddmm.eclipse.ui.editor;

import de.fhdo.ddmm.eclipse.ui.editor.server.ServerConnection;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IReadAccess;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom Xtext validation job for Live Validation. It connects to a Live Validation server and
 * triggers the actual validations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LiveValidationJob extends ValidationJob {
  private ServerConnection liveValidationServerConnection;
  
  /**
   * Constructor
   */
  public LiveValidationJob(final IResourceValidator xtextResourceChecker, final IReadAccess<XtextResource> xtextDocument, final IValidationIssueProcessor validationIssueProcessor, final CheckMode checkMode, final ServerConnection liveValidationServerConnection) {
    super(xtextResourceChecker, xtextDocument, validationIssueProcessor, checkMode);
    this.liveValidationServerConnection = liveValidationServerConnection;
  }
  
  /**
   * Callback for issue creation during the job's processing
   */
  public List<Issue> createIssues(final IProgressMonitor monitor) {
    final List<Issue> issues = super.createIssues(monitor);
    boolean _isConnected = this.liveValidationServerConnection.isConnected();
    boolean _not = (!_isConnected);
    if (_not) {
      return issues;
    }
    final CancelableUnitOfWork<List<Issue>, XtextResource> getLiveValidationIssues = new CancelableUnitOfWork<List<Issue>, XtextResource>() {
      public List<Issue> exec(final XtextResource resource, final CancelIndicator outerIndicator) {
        if (((resource == null) || resource.isValidationDisabled())) {
          return Collections.<Issue>emptyList();
        }
        final IFile resourceFile = LemmaUtils.getFileForResource(resource);
        if ((resourceFile == null)) {
          return Collections.<Issue>emptyList();
        }
        final String documentUri = resourceFile.getLocationURI().toString();
        final String sourceCode = NodeModelUtils.getNode(resource.getContents().get(0)).getText();
        LiveValidationJob.this.liveValidationServerConnection.validate(documentUri, sourceCode);
        return Collections.<Issue>emptyList();
      }
    };
    this.getXtextDocument().<List<Issue>>readOnly(getLiveValidationIssues);
    return issues;
  }
}
