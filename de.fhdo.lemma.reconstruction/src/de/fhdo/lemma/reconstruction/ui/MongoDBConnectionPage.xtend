package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.events.KeyListener
import org.eclipse.swt.events.KeyEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.jface.wizard.IWizardPage

class MongoDBConnectionPage extends WizardPage implements IWizardPage{
	Text text;
	Composite container;
	
	protected new(String pageName) {
		super(pageName)
		title = "MongoDB Page"
		description = "Page for connecting to a MongoDB database"
	}
	
	override createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE)
		val layout = new GridLayout()
		container.layout = layout
		layout.numColumns = 2
		val label1 = new Label(container, SWT.NONE)
		label1.text = "Dome text 1"
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

	
	def getText() {
		text.text
	}
}