package de.fhdo.lemma.ui.quickfix

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IMessageProvider
import de.fhdo.lemma.servicedsl.ui.internal.ServicedslActivator
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.swt.layout.GridData
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor
import de.fhdo.lemma.ui.highlighting.HighlightingCalculator
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingHelper
import com.google.inject.Guice
import de.fhdo.lemma.ui.ServiceDslUiModule
import de.fhdo.lemma.ServiceDslRuntimeModule
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter

class SecuritySmellDialog extends TitleAreaDialog {
	ServiceDslRefacctroingPreview preview
	Resource resource
	String content
	
	new(Shell parentShell) {
		super(parentShell)
	}
	
	new(Shell parentShell, Resource resource, String content) {
		super(parentShell)
		this.resource = resource
		this.content = content
	}
	
	override create() {
        super.create()
        title = "Security Smell Refactoring Preview."
        setMessage("Refactored Microservice Endpoint.", IMessageProvider.INFORMATION)
    }
    
    def create(Resource resource) {
        super.create()
        this.resource = resource
        title = "TestBla."
        setMessage("Reconstruct LEMMA Models.", IMessageProvider.INFORMATION)
    }
	
	override createDialogArea(Composite composite) {
		val resourceProvider = new IEditedResourceProvider() {
			
			override createResource() {
				return resource as XtextResource
			}
			
		}
		
		val calculator = new HighlightingCalculator()

		
		val area = super.createDialogArea(composite) as Composite
		val injector = new ServicedslActivator().getInjector(ServicedslActivator.DE_FHDO_LEMMA_SERVICEDSL)
		new ServicedslActivator().
		val factory = injector.getInstance(EmbeddedEditorFactory)
		
		
		
		
		
		//val guiceInjector = Guice.createInjector(new ServiceDslUiModule())
		//val factory2 = guiceInjector.getInstance(EmbeddedEditorFactory)
		val handle = factory.newEditor(resourceProvider).withParent(composite)
		handle.viewer.editable = false
		
		
		
		val editor = handle.createPartialEditor("", content, "", false)
		handle.viewer.control.layoutData = new GridData(GridData.FILL, GridData.FILL, true, true, 2, 0)
		
		return area
	}
}