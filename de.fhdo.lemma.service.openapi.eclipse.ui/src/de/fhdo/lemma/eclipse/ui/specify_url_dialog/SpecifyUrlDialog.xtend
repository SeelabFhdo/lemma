package de.fhdo.lemma.eclipse.ui.specify_url_dialog

import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.swt.events.SelectionListener
import java.net.URL
import java.net.MalformedURLException
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.lemma.service.openapi.LemmaGenerator
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.jface.dialogs.InputDialog
import org.eclipse.jface.window.Window
import java.io.File

/**
 * The dialog for the transformation of OpenAPI specifications to LEMMA models.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class SpecifyUrlDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 400
    static val MIN_DIALOG_HEIGHT = 250

    Text txtUrl
    Text txtTargetLocation
    Text txtDataModelName
    Text txtServiceModelName
    Text txtTechnologyModelName
    Text txtServicePrefix

    Button btnBrowseLocation
    Button btnUriWebLocation
    Button btnUriFileLocation

    @Accessors(PUBLIC_GETTER) URL fetchUrl

    String targetLoc
    String dataName
    String servName
    String servPre
    String techName

    new(Shell parentShell) {
        super(parentShell)
        //hide question mark on bottom left
        dialogHelpAvailable = false
        helpAvailable = false
    }

    /**
     * OK button was pressed
     */
    override okPressed() {
        if(saveInput()) {
             try {
                val generator = new LemmaGenerator()
                val parsingMessages = generator.parse(fetchUrl.toString)
                MessageDialog.openInformation(this.shell, "Parsing Report",
                    '''«FOR msg : parsingMessages»
                    «msg»
                    «ENDFOR»''')
                if(generator.isParsed){
                    generator.generateModels('''«targetLoc»/''', '''«dataName».data''',
                        '''«servName».services''','''«techName».technology''', servPre)
                        MessageDialog.openInformation(this.shell, "Transformation Report",
                            '''
                            The transformation was a success!
                            Encountered problems (empty if none):
                            «FOR msg : generator.transMsgs»
                            «msg»
                            «ENDFOR»''')
                } else {
                    MessageDialog.openError(this.shell, "Parsing Error",
                        '''It was not possible to generate an in-memory '''+
                        '''representation of the file located at «fetchUrl.toString» .''')
                }

            } catch (Exception ex) {
                MessageDialog.openError(this.shell, "Error",
                '''An error occured during extraction...«ex.printStackTrace»''')
            }
            super.okPressed()
        }
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "Extract", true)
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case IDialogConstants.OK_ID: okPressed
            case IDialogConstants.CANCEL_ID: cancelPressed
        }
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create
        setTitle("Specify OpenAPI Address");
        setMessage("Specify the url of the OpenAPI specification from which the " +
        "LEMMA models should be extracted.", IMessageProvider.INFORMATION)
    }

    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NULL)
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true))
        val layout = new GridLayout(4, false)
        layout.verticalSpacing = 10
        container.setLayout(layout)
        createUrl(container)
        createTargetLocation(container)
        createDataModelName(container)
        createServiceModelName(container)
        createServicePrefix(container)
        createTechnologyModelName(container)
        return area
    }

    private def createUrl(Composite container) {
        val lblUrl = new Label(container, SWT.NONE)
        lblUrl.setText("URL: ")

        val dataUrl = new GridData()
        dataUrl.grabExcessHorizontalSpace = true
        dataUrl.horizontalAlignment = GridData.FILL
        dataUrl.horizontalSpan = 1
        //forced with of window
        dataUrl.widthHint = (shell.size.x * 0.3) as int

        txtUrl = new Text(container, SWT.BORDER)
        txtUrl.message = "e.g. https://petstore3.swagger.io/api/v3/openapi.json"
        txtUrl.enabled = false
        txtUrl.setLayoutData(dataUrl)

        val uriWebLocationButton = new GridData()
        uriWebLocationButton.grabExcessHorizontalSpace = true
        uriWebLocationButton.horizontalAlignment = SWT.RIGHT

        btnUriWebLocation = new Button(container, SWT.BUTTON1)
        btnUriWebLocation.text = "Enter URL"
        btnUriWebLocation.setLayoutData(uriWebLocationButton)
        btnUriWebLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val urlDialog = new InputDialog(shell, "", "Enter URL",
                "Please enter the URL", new UrlTextValidator());
            //dirDialog.filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
            if (urlDialog.open() == Window.OK) {
                txtUrl.text = urlDialog.getValue()
            }
        ]))

        val uriFileLocationButton = new GridData()
        uriFileLocationButton.grabExcessHorizontalSpace = true
        uriFileLocationButton.horizontalAlignment = SWT.RIGHT

        btnUriFileLocation = new Button(container, SWT.BUTTON1)
        btnUriFileLocation.text = "Browse Filesystem"
        btnUriFileLocation.setLayoutData(uriWebLocationButton)
        btnUriFileLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            // Starting point not specified, i.e., set to default OS selection
            val fileDialog = new FileDialog(shell);
            fileDialog.setText("Select your OpenAPI file")
            val selectedFile = fileDialog.open()
            txtUrl.text = new File(selectedFile).toURI.toString
        ]))
    }

    private def createTargetLocation(Composite container) {
        val lblTargetLocation = new Label(container, SWT.NULL)
        lblTargetLocation.setText("Target Location: ")

        val dataTargetLocation = new GridData()
        dataTargetLocation.grabExcessHorizontalSpace = true
        dataTargetLocation.horizontalAlignment = GridData.FILL
        dataTargetLocation.horizontalSpan = 2

        txtTargetLocation = new Text(container, SWT.BORDER)
        txtTargetLocation.message = "Select Directory"
        txtTargetLocation.enabled = false
        txtTargetLocation.setLayoutData(dataTargetLocation)

        val dataTargetLocationButton = new GridData()
        dataTargetLocationButton.grabExcessHorizontalSpace = true
        dataTargetLocationButton.horizontalAlignment = SWT.RIGHT

        btnBrowseLocation = new Button(container, SWT.BUTTON1)
        btnBrowseLocation.text = "Browse Filesystem"
        btnBrowseLocation.setLayoutData(dataTargetLocationButton)
        btnBrowseLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            // Directory standard selection set default to workspace
            val dirDialog = new DirectoryDialog(shell);
            dirDialog.setText("Select your target directory")
            dirDialog.filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
            val selectedDir = dirDialog.open()
            txtTargetLocation.text = selectedDir
        ]))
    }

    private def createDataModelName(Composite container) {
        val lblDataModelName = new Label(container, SWT.NULL)
        lblDataModelName.setText("Data Model Name: ")

        val dataDataModelName = new GridData()
        dataDataModelName.grabExcessHorizontalSpace = true
        dataDataModelName.horizontalAlignment = GridData.FILL
        dataDataModelName.horizontalSpan = 3

        txtDataModelName = new Text(container, SWT.BORDER)
        txtDataModelName.message = "MyServiceData"
        txtDataModelName.setLayoutData(dataDataModelName)
    }

    private def createServiceModelName(Composite container) {
        val lblServiceModelName = new Label(container, SWT.NULL)
        lblServiceModelName.setText("Service Model Name: ")

        val dataServiceModelName = new GridData()
        dataServiceModelName.grabExcessHorizontalSpace = true
        dataServiceModelName.horizontalAlignment = GridData.FILL
        dataServiceModelName.horizontalSpan = 3

        txtServiceModelName = new Text(container, SWT.BORDER)
        txtServiceModelName.message = "MyServiceService"
        txtServiceModelName.setLayoutData(dataServiceModelName)
    }

    private def createServicePrefix(Composite container) {
        val lblServicePrefix = new Label(container, SWT.NULL)
        lblServicePrefix.setText("Service Model Prefix: ")

        val dataServicePrefix = new GridData()
        dataServicePrefix.grabExcessHorizontalSpace = true
        dataServicePrefix.horizontalAlignment = GridData.FILL
        dataServicePrefix.horizontalSpan = 3

        txtServicePrefix = new Text(container, SWT.BORDER)
        txtServicePrefix.message = "de.example"
        txtServicePrefix.setLayoutData(dataServicePrefix)
    }

    private def createTechnologyModelName(Composite container) {
        val lblTechnologyModelName = new Label(container, SWT.NULL)
        lblTechnologyModelName.setText("Technology Model Name: ")

        val dataTechnologyModelName = new GridData()
        dataTechnologyModelName.grabExcessHorizontalSpace = true
        dataTechnologyModelName.horizontalAlignment = GridData.FILL
        dataTechnologyModelName.horizontalSpan = 3

        txtTechnologyModelName = new Text(container, SWT.BORDER)
        txtTechnologyModelName.message = "OpenAPI"
        txtTechnologyModelName.setLayoutData(dataTechnologyModelName)
    }

    /**
     * Stores the textfield values to actual fields.
     * Is called when a button in the dialog is pressed.
     */
    private def saveInput() {
        this.fetchUrl = try {
            new URL(txtUrl.getText)
        } catch (MalformedURLException e) {
            MessageDialog.openError(this.shell, "Invalid URL",
                '''«txtUrl.getText» is not a valid url!'''
            )
            return false
        }
            this.targetLoc = txtTargetLocation.getText
            this.dataName = txtDataModelName.getText
            this.servName = txtServiceModelName.getText
            this.techName = txtTechnologyModelName.text
            this.servPre = txtServicePrefix.text
        if(!this.targetLoc.trim.isEmpty && !this.dataName.trim.isEmpty &&
            !this.servName.trim.isEmpty && !this.techName.trim.isEmpty &&
            !this.servPre.trim.isEmpty
        ) {
            return true
        } else {
            MessageDialog.openError(this.shell, "Empty Fields",
                '''Please fill all the fields with proper data.'''
            )
            return false
        }

    }

    /**
     * Flag to indicate that dialog is resizable
     */
    override isResizable() {
        return true
    }

    /**
     * Initial size
     */
    override getInitialSize() {
        val shellSize = super.getInitialSize()
        return new Point(
            Math.max(convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH), shellSize.x),
            Math.max(convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT), shellSize.y)
        )
    }


}