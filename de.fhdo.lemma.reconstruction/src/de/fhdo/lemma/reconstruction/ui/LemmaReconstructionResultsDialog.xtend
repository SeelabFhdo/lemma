package de.fhdo.lemma.reconstruction.ui

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.IStructuredSelection
import java.util.List
import de.fhdo.lemma.reconstruction.domain.Context
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.service.Interface
import de.fhdo.lemma.reconstruction.service.Operation

class LemmaReconstructionResultsDialog extends TitleAreaDialog {
	TreeViewer treeViewer
	List<Context> contexts;
	List<Microservice> microservices;
	@Accessors
	List<Context> selectedContexts = newLinkedList
	@Accessors
	List<Microservice> selectedMicroservices= newLinkedList
    
    
	new(Shell parentShell, List<Context> contexts, List<Microservice> microservice) {
		super(parentShell)
		this.contexts = contexts
		this.microservices = microservice
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
        

        createReconstructionTree(container)

		//createDemoTree(container)
        return area
    }
    
	private def createReconstructionTree(Composite parent) {
        treeViewer = new TreeViewer(parent)
        treeViewer.contentProvider = new ReconstructionContentProvider
        treeViewer.tree.headerVisible = true
        treeViewer.tree.linesVisible = true
        treeViewer.tree.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

        // Toggle element collapse state on double click
        treeViewer.addDoubleClickListener([
            if (treeViewer.selection.empty ||
                !(treeViewer.selection instanceof IStructuredSelection))
                return

            val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement
            if (treeViewer.getExpandedState(selectedElement))
                treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS)
            else
                treeViewer.expandToLevel(selectedElement, 1)
        ])

        // Columns
        createNameColumn
        createTypeColumn
        val input = newLinkedList
        input.addAll(contexts)
        input.addAll(microservices)
        treeViewer.input = input as List<?>
        val data = treeViewer.selection
        println()
	}
	
	    /**
     * Create schema name tree column
     */
    private def void createNameColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 500
        column.column.text = "Schema name"
        column.labelProvider = new DelegatingStyledCellLabelProvider(
            new ReconstructionTreeLableProvider())
    }

    /**
     * Create schema type tree column
     */
    private def void createTypeColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 300
        column.column.text = "Schema type"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return switch (element) {
                	Context: "Context"
                	DataStructure: "Entity"
                	Field: "Attribute"
                	Microservice: "Microservice"
                	Interface: "Interface"
                	Operation: "Operation"
                	default: ""
                }
            }
        }
    }
	
	private def List<? extends Object> toTreeElements(List<Context> contects) {
		
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
		treeViewer.structuredSelection.forEach[
			switch (it) {
				Context: selectedContexts.add(it)
				Microservice: selectedMicroservices.add(it)
			}
		]
		println()
    }
}