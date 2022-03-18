package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.wizard.Wizard
import org.eclipse.ui.INewWizard
import org.eclipse.ui.IWorkbench
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.ui.internal.dialogs.NewWizard
import org.eclipse.jface.wizard.WizardPage

class LemmaReconstructionWizard extends Wizard implements INewWizard {
	MongoDBConnectionPage mongoDBPage
	
	
	new (){
		super()
		needsProgressMonitor = true
	}
	
	override performFinish() {
		println("Finished")
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