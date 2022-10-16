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
import org.eclipse.jface.dialogs.IInputValidator
import org.apache.commons.validator.routines.UrlValidator
import de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator

/**
 * The dialog for the transformation of OpenAPI specifications to LEMMA models.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class SpecifyUrlDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 150

    Text txtUrl
    Text txtTargetFolder
    Text txtDataModelName
    Text txtTechnologyModelName
    Text txtServiceModelName
    Text txtServiceQualifier

    Button btnBrowseFolder
    Button btnUriWebLocation
    Button btnUriFileLocation

    @Accessors(PUBLIC_GETTER)
    URL fetchUrl

    String targetFolder
    String dataModelName
    String technologyModelName
    String serviceModelName
    String serviceQualifier

    /**
     * Constructor
     */
    new(Shell parentShell) {
        super(parentShell)
        dialogHelpAvailable = false
        helpAvailable = false
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        title = "Specify OpenAPI Specification URL"
        setMessage("Specify the URL of the OpenAPI specification from which LEMMA models shall " +
            "be extracted", IMessageProvider.INFORMATION)
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
            case IDialogConstants.OK_ID: okPressed()
            case IDialogConstants.CANCEL_ID: cancelPressed()
        }
    }

    /**
     * OK button was pressed. Trigger generation.
     */
    override okPressed() {
        if (!syncInput()) {
            return
        }

        var errorOccurred = false
        try {
            val generator = new LemmaGenerator()
            val parsingMessages = generator.parse(fetchUrl.toString)
            MessageDialog.openInformation(shell, "Parsing Report",
                '''«FOR msg : parsingMessages»
                    «msg»
                «ENDFOR»''')

            if (generator.isParsed){
                generator.generateModels(
                    targetFolder,
                    '''«dataModelName».data''',
                    '''«technologyModelName».technology''',
                    '''«serviceModelName».services''',
                    serviceQualifier
                )

                if (generator.transMsgs.empty)
                    MessageDialog.openInformation(shell, "Transformation Report",
                        "Transformation completed successfully.")
                else {
                    errorOccurred = true
                    MessageDialog.openError(shell, "Transformation Report",
                        '''
                        There were errors during the transformation:
                        «FOR msg : generator.transMsgs»
                            - «msg»
                        «ENDFOR»
                        '''
                    )
                }
            } else {
                errorOccurred = true
                MessageDialog.openError(shell, "Parsing Error", "Generation of in-memory " +
                    "representation not possible for the OpenAPI specification URL " +
                    fetchUrl.toString)
            }

        } catch (Exception ex) {
            errorOccurred = true
            MessageDialog.openError(shell, "Error", "Error during transformation: " + ex.message)
        }

        if (!errorOccurred)
            super.okPressed()
    }

    /**
     * Synchronize user input with class state
     */
    private def syncInput() {
        fetchUrl = try {
                new URL(txtUrl.getText)
            } catch (MalformedURLException ex) {
                MessageDialog.openError(shell, "Invalid URL", '''«txtUrl.getText» is not a ''' +
                    "valid URL")
                return false
            }

        targetFolder = txtTargetFolder.getText.trim
        dataModelName = txtDataModelName.getText.trim
        technologyModelName = txtTechnologyModelName.text.trim
        serviceModelName = txtServiceModelName.getText.trim
        serviceQualifier = txtServiceQualifier.text.trim

        val missingValues = targetFolder.empty ||
            dataModelName.empty ||
            technologyModelName.empty ||
            serviceModelName.empty ||
            serviceQualifier.empty
        if (missingValues)
            MessageDialog.openError(shell, "Missing Field Values", "Please specify a value for " +
                "each field")
        return !missingValues
    }

    /**
     * Create the dialog area
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(3, false)

        createUrl(container)
        createTargetFolder(container)
        createDataModelName(container)
        createTechnologyModelName(container)
        createServiceModelName(container)
        createServiceQualifier(container)

        return container
    }

    /**
     * Create UI elements for URL/file specification
     */
    private def createUrl(Composite parent) {
        new Label(parent, SWT.NULL).text = "URL or File Path:"

        txtUrl = new Text(parent, SWT.BORDER)
        txtUrl.message = "Specify URL or Select File"
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.widthHint = (shell.size.x * 0.3) as int
        txtUrl.enabled = false
        txtUrl.layoutData = layoutData

        val buttonBar = new Composite(parent, SWT.NONE)
        buttonBar.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        val layout = new GridLayout(2, false)
        layout.marginHeight = 0
        layout.marginWidth = 0
        buttonBar.layout = layout

        btnUriWebLocation = new Button(buttonBar, SWT.PUSH)
        btnUriWebLocation.text = "Specify URL"
        btnUriWebLocation.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        btnUriWebLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val urlDialog = new InputDialog(
                    shell,
                    "",
                    "Specify OpenAPI specification URL",
                    "Please specify a URL to an OpenAPI specification, e.g., " +
                    "https://petstore3.swagger.io/api/v3/openapi.json",
                    new UrlInputValidator()
                )

            if (urlDialog.open() == Window.OK)
                txtUrl.text = urlDialog.getValue()
        ]))

        btnUriFileLocation = new Button(buttonBar, SWT.BUTTON1)
        btnUriFileLocation.text = "Select OpenAPI File"
        btnUriFileLocation.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        btnUriFileLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val fileDialog = new FileDialog(shell)
            fileDialog.setText("Please select an OpenAPI specification file")
            val selectedFile = fileDialog.open()
            if (selectedFile === null)
                MessageDialog.openError(shell, "No File Selected", "Please select an OpenAPI " +
                    "specification file in JSON for YAML format.")
            else
                txtUrl.text = new File(selectedFile).toURI.toString
        ]))
    }

    /**
     * Validator for strings to represent valid URLs
     */
    private static class UrlInputValidator implements IInputValidator {
        /**
         * Perform the validation
         */
        override isValid(String newUrl) {
            return if (new UrlValidator().isValid(newUrl))
                null
            else
                "Invalid URL"
        }
    }

    /**
     * Create the UI elements for target folder selection
     */
    private def createTargetFolder(Composite parent) {
        new Label(parent, SWT.NULL).text = "Target Folder:"

        txtTargetFolder = new Text(parent, SWT.BORDER)
        txtTargetFolder.message = "Select target folder for generated models."
        txtTargetFolder.enabled = false
        txtTargetFolder.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)

        btnBrowseFolder = new Button(parent, SWT.PUSH)
        btnBrowseFolder.text = "Select Target Folder"
        btnBrowseFolder.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        btnBrowseFolder.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val dirDialog = new DirectoryDialog(shell)
            dirDialog.setText("Select target folder for generated models.")
            dirDialog.filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
            txtTargetFolder.text = dirDialog.open()
        ]))
    }

    /**
     * Create the UI elements for the data model name
     */
    private def createDataModelName(Composite container) {
        val lblDataModelName = new Label(container, SWT.NULL)
        lblDataModelName.setText("Data Model Name:")

        txtDataModelName = new Text(container, SWT.BORDER)
        txtDataModelName.message = "Data Model Name"
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        txtDataModelName.setLayoutData(layoutData)
    }

    /**
     * Create the UI elements for the technology model name
     */
    private def createTechnologyModelName(Composite container) {
        val lblTechnologyModelName = new Label(container, SWT.NULL)
        lblTechnologyModelName.setText("Technology Model Name:")

        txtTechnologyModelName = new Text(container, SWT.BORDER)
        txtTechnologyModelName.text = LemmaTechnologySubGenerator.TECHNOLOGY_MODEL_NAME
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        txtTechnologyModelName.setLayoutData(layoutData)
    }

    /**
     * Create the UI elements for the service model name
     */
    private def createServiceModelName(Composite container) {
        val lblServiceModelName = new Label(container, SWT.NULL)
        lblServiceModelName.setText("Service Model Name:")

        txtServiceModelName = new Text(container, SWT.BORDER)
        txtServiceModelName.message = "Service Model Name"
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        txtServiceModelName.setLayoutData(layoutData)
    }

    /**
     * Create the UI elements for the microservice qualifier
     */
    private def createServiceQualifier(Composite container) {
        val lblServiceQualifier = new Label(container, SWT.NULL)
        lblServiceQualifier.setText("Microservice Package Qualifier:")

        txtServiceQualifier = new Text(container, SWT.BORDER)
        txtServiceQualifier.message = "org.example"
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        txtServiceQualifier.setLayoutData(layoutData)
    }

    /**
     * Indicate that the dialog is resizable
     */
    override isResizable() {
        return true
    }

    /**
     * Set window size
     */
    override getInitialSize() {
        val shellSize = super.getInitialSize()
        return new Point(
            Math.max(convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH), shellSize.x),
            Math.max(convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT), shellSize.y)
        )
    }
}