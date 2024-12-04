package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.events.KeyEvent
import org.eclipse.swt.events.KeyListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text

/**
 * User Interface class configuring the connection to the MongoDB.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MongoDBConnectionPage extends WizardPage implements IWizardPage{
	Text text;
	Composite container;
	
	protected new(String pageName) {
		super(pageName)
		title = "MongoDB Page"
		description = "Page for connecting to a MongoDB database"
	}
	
	/**
	 * Control to manage the input for the MongoDB connection.
	 */
	override createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE)
		val layout = new GridLayout()
		container.layout = layout
		layout.numColumns = 2
		text = new Text(container, SWT.BORDER)
		text.text = ""
		
		text.addKeyListener(new KeyListener() {
			
			override keyPressed(KeyEvent e) {
				
			}
			
			override keyReleased(KeyEvent e) {
				if (!text.text.isEmpty)
					pageComplete = true
			}
		})
		
		val gridData = new GridData(GridData.FILL_HORIZONTAL)
		text.layoutData = gridData
		setControl(container);
        setPageComplete(false);
	}	
	
	/**
	 * Get the database information from the input
	 */
	def getText() {
		text.text
	}
}