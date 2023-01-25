package de.fhdo.lemma.ui.quickfix;

import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

@SuppressWarnings("all")
public class ServiceDslRefacctroingPreview {
  private EmbeddedEditor editorHandle;
  
  private EmbeddedEditorModelAccess modelAccess;
  
  public ServiceDslRefacctroingPreview forEmbeddedEditor(final EmbeddedEditor editorHandle) {
    if ((this.editorHandle != null)) {
      throw new IllegalStateException("This formatter preview is already binded to an embedet editor");
    }
    this.editorHandle = editorHandle;
    this.modelAccess = editorHandle.createPartialEditor();
    return this;
  }
  
  public XtextSourceViewer getEditorViewer() {
    return this.editorHandle.getViewer();
  }
}
