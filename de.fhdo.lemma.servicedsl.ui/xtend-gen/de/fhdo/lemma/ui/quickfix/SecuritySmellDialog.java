package de.fhdo.lemma.ui.quickfix;

import com.google.inject.Injector;
import de.fhdo.lemma.servicedsl.ui.internal.ServicedslActivator;
import de.fhdo.lemma.ui.highlighting.HighlightingCalculator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

@SuppressWarnings("all")
public class SecuritySmellDialog extends TitleAreaDialog {
  private ServiceDslRefacctroingPreview preview;
  
  private Resource resource;
  
  private String content;
  
  public SecuritySmellDialog(final Shell parentShell) {
    super(parentShell);
  }
  
  public SecuritySmellDialog(final Shell parentShell, final Resource resource, final String content) {
    super(parentShell);
    this.resource = resource;
    this.content = content;
  }
  
  @Override
  public void create() {
    super.create();
    this.setTitle("Security Smell Refactoring Preview.");
    this.setMessage("Refactored Microservice Endpoint.", IMessageProvider.INFORMATION);
  }
  
  public void create(final Resource resource) {
    super.create();
    this.resource = resource;
    this.setTitle("TestBla.");
    this.setMessage("Reconstruct LEMMA Models.", IMessageProvider.INFORMATION);
  }
  
  @Override
  public Control createDialogArea(final Composite composite) {
    final IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
      @Override
      public XtextResource createResource() {
        return ((XtextResource) SecuritySmellDialog.this.resource);
      }
    };
    final HighlightingCalculator calculator = new HighlightingCalculator();
    Control _createDialogArea = super.createDialogArea(composite);
    final Composite area = ((Composite) _createDialogArea);
    final Injector injector = new ServicedslActivator().getInjector(ServicedslActivator.DE_FHDO_LEMMA_SERVICEDSL);
    final EmbeddedEditorFactory factory = injector.<EmbeddedEditorFactory>getInstance(EmbeddedEditorFactory.class);
    final EmbeddedEditor handle = factory.newEditor(resourceProvider).withParent(composite);
    XtextSourceViewer _viewer = handle.getViewer();
    _viewer.setEditable(false);
    final EmbeddedEditorModelAccess editor = handle.createPartialEditor("", this.content, "", false);
    Control _control = handle.getViewer().getControl();
    GridData _gridData = new GridData(GridData.FILL, GridData.FILL, true, true, 2, 0);
    _control.setLayoutData(_gridData);
    return area;
  }
}
