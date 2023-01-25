package de.fhdo.lemma.ui.quickfix

import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess

class ServiceDslRefacctroingPreview {
	EmbeddedEditor editorHandle;
	EmbeddedEditorModelAccess modelAccess;
	
	def ServiceDslRefacctroingPreview forEmbeddedEditor(EmbeddedEditor editorHandle) {
		if (this.editorHandle !== null) {
			throw new IllegalStateException("This formatter preview is already binded to an embedet editor");
		}
		this.editorHandle = editorHandle;
		this.modelAccess = editorHandle.createPartialEditor();
		return this;
	}
	
	def getEditorViewer() {
		return editorHandle.viewer
	}
}