package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.jface.wizard.Wizard
import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.ui.INewWizard
import org.eclipse.ui.IWorkbench

/**
 * User Interface class for displaying reconstruction wizard to guide the reconstruction 
 * dialog.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaReconstructionWizard extends Wizard implements INewWizard {
	MongoDBConnectionPage mongoDBPage
	
	new (){
		super()
		needsProgressMonitor = true
	}
	
	override performFinish() {
		true
	}
	
	override init(IWorkbench workbench, IStructuredSelection selection) {
		mongoDBPage = new MongoDBConnectionPage("MongoDB Connection Page.")
		addPage(mongoDBPage)
		val dialog = new WizardDialog(shell, new LemmaReconstructionWizard())
		dialog.open()
	}
	
	override getWindowTitle() {
		return "LEMMA Reconstruction"
	}
	
	override addPage(IWizardPage page) {
      addPage(page);
	}
}