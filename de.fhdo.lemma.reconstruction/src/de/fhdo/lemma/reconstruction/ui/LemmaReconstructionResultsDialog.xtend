package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import java.util.List
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.service.Interface
import de.fhdo.lemma.reconstruction.service.Operation
import de.fhdo.lemma.reconstruction.operation.OperationNode
import de.fhdo.lemma.reconstruction.operation.DeployedService
import de.fhdo.lemma.reconstruction.operation.NodeType

/**
 * User Interface class for displaying information about the reconstructed architecture,
 * loaded from the MongoDB. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaReconstructionResultsDialog extends TitleAreaDialog {
	static val DEFAULT_TECHNOLOGY_FOLDER = "technology"

	TreeViewer treeViewer
	List<Context> contexts
	List<Microservice> microservices
	List<OperationNode> operationNodes

	@Accessors
	List<Context> selectedContexts = newLinkedList
	
	@Accessors
	List<Microservice> selectedMicroservices= newLinkedList

	@Accessors
	List<OperationNode> selectedOperationNodes = newLinkedList

	Button copyTechnologyModelsButton
	Text technologyFolderText

	/**
	 * Whether the technology models are copied next to the generated models,
	 * and the folder they are copied into. An operation model imports its
	 * technology model relative to itself, so the folder is also what the
	 * generated import points at.
	 */
	@Accessors
	boolean copyTechnologyModels = true

	@Accessors
	String technologyFolder = DEFAULT_TECHNOLOGY_FOLDER

	new(Shell parentShell, List<Context> contexts, List<Microservice> microservices,
		List<OperationNode> operationNodes) {
		super(parentShell)
		this.contexts = contexts
		this.microservices = microservices
		this.operationNodes = operationNodes
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
		createTechnologyModelOption(container)
		return area
	}

	/** 
	 *Create the tree for displaying the loaded architecture information
	 */
	private def createReconstructionTree(Composite parent) {
		treeViewer = new TreeViewer(parent)
		treeViewer.contentProvider = new ReconstructionContentProvider
		treeViewer.tree.headerVisible = true
		treeViewer.tree.linesVisible = true
		treeViewer.tree.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

		// Toggle element collapse state on double click
		treeViewer.addDoubleClickListener([
			if (treeViewer.selection.empty || 
				!(treeViewer.selection instanceof IStructuredSelection)) {
				return
			}

			val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement
			if (treeViewer.getExpandedState(selectedElement))
				treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS)
			else
				treeViewer.expandToLevel(selectedElement, 1)
		])

		createNameColumn
		createTypeColumn
		val input = newLinkedList
		input.addAll(contexts)
		input.addAll(microservices)
		input.addAll(operationNodes)
		treeViewer.input = input as List<?>
		treeViewer.selection
	}

	/**
	 * Create the option to copy the technology models next to the generated
	 * ones, and the folder they are copied into
	 */
	private def createTechnologyModelOption(Composite parent) {
		copyTechnologyModelsButton = new Button(parent, SWT.CHECK)
		copyTechnologyModelsButton.text = "Copy technology models into the generated models"
		copyTechnologyModelsButton.selection = copyTechnologyModels
		copyTechnologyModelsButton.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)

		val folderComposite = new Composite(parent, SWT.NONE)
		folderComposite.layout = new GridLayout(2, false)
		folderComposite.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)

		val label = new Label(folderComposite, SWT.NONE)
		label.text = "Sub folder:"

		technologyFolderText = new Text(folderComposite, SWT.BORDER)
		technologyFolderText.text = technologyFolder
		technologyFolderText.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
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
                	OperationNode: if (element.nodeType === NodeType.INFRASTRUCTURE)
                			"Infrastructure node"
                		else
                			"Container"
                	DeployedService: "Deployed microservice"
                	default: ""
                }
            }
        }
    }
		
	/**
	 * Create buttons to continue the dialog
	 */
	override createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Continue", true)
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Enable resizing
	 */
	override isResizable() {
		true
	}

	/**
	 * Save given input
	 */
	override okPressed() {
		saveInput()
		super.okPressed
	}

	/**
	 * Save the selected input
	 */
	private def saveInput() {
		copyTechnologyModels = copyTechnologyModelsButton.selection
		val folder = technologyFolderText.text
		technologyFolder = if (folder.nullOrEmpty) DEFAULT_TECHNOLOGY_FOLDER else folder.trim

		treeViewer.structuredSelection.forEach [
			switch (it) {
				Context: selectedContexts.add(it)
				Microservice: selectedMicroservices.add(it)
				OperationNode: selectedOperationNodes.add(it)
			}
		]
	}
}