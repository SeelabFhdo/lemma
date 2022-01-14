package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.jface.dialogs.IDialogConstants

class LemmaReconstructionDialog extends TitleAreaDialog {
    Text mongoDbHostnameText
    Text mongoDbPortText
    
    @Accessors
    String mongoDbHostname
    @Accessors
    String mongoDbPort
    
    
	new(Shell parentShell) {
		super(parentShell)
	}
	
    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        title = "LEMMA Reconstruction from MongoDB reconstruction store."
        setMessage("Reconstruct LEMMA Models.", IMessageProvider.INFORMATION)
    }
    
    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite

        val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(2, false)
        

        createInputFiles(container)
        //createModelTree(container)
        //createBottomRow(container)

        return area
    }
    
    /**
     * Create top row in the dialog comprising schema information
     */
    private def void createInputFiles(Composite parent) {
    	val hostnameLabel = new Label(parent, SWT.NONE)
    	hostnameLabel.text = "MongoDB Hostname:"
    	val hostnameDataGrid = new GridData()
    	hostnameDataGrid.grabExcessHorizontalSpace = true
    	hostnameDataGrid.horizontalAlignment = GridData.FILL
    	mongoDbHostnameText = new Text(parent, SWT.NONE)
    	mongoDbHostnameText.layoutData = hostnameDataGrid
    	
    	val portLabel = new Label(parent, SWT.NONE)
    	portLabel.text = "MongoDB Port:"
    	val parentDataGrid = new GridData()
    	parentDataGrid.grabExcessHorizontalSpace = true
    	parentDataGrid.horizontalAlignment = GridData.FILL
    	mongoDbPortText = new Text(parent, SWT.NONE)
    	mongoDbPortText.layoutData = hostnameDataGrid	
    }
    
    
    override createButtonsForButtonBar(Composite parent) {
    	createButton(parent, IDialogConstants.OK_ID, "Continue", true)
    	createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }
    
    override isResizable() {
    	true
    }
        
    override okPressed() {
    	saveInput()
    	super.okPressed
    }
    
    private def saveInput() {
    	mongoDbHostname = mongoDbHostnameText.text
    	mongoDbPort = mongoDbPortText.text
    }
}