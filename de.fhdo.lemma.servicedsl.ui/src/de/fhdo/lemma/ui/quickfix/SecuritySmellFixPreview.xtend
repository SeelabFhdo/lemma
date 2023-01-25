package de.fhdo.lemma.ui.quickfix

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout

class SecuritySmellFixPreview extends TitleAreaDialog {
	
	new(Shell parentShell) {
		super(parentShell)
	}

    /**
     * Create dialog (to be called after constructor and before open())
     */
    def create(String operationName, String smellName) {
        super.create()
        title = "Security Smell Analysis Dialog."
        setMessage(smellName, IMessageProvider.INFORMATION)
    }
    
    override createDialogArea(Composite parent) {
    	val area = super.createDialogArea(parent) as Composite
    	val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(2, false)
     
        return area
    }
}