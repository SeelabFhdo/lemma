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

// TODO: Add Javadoc comments to methods

/**
 * The dialog for the transformation of OpenAPI specifications to LEMMA models.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class SpecifyUrlDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 400
    static val MIN_DIALOG_HEIGHT = 250

    Text txtUrl
    Text txtTargetFolder
    Text txtDataModelName
    Text txtTechnologyModelName
    Text txtServiceModelName
    Text txtServicePrefix

    Button btnBrowseFolder
    Button btnUriWebLocation
    Button btnUriFileLocation

    @Accessors(PUBLIC_GETTER)
    URL fetchUrl

    String targetFolder
    String dataModelName
    String technologyModelName
    String serviceModelName
    String servicePrefix

    new(Shell parentShell) {
        super(parentShell)
        dialogHelpAvailable = false
        helpAvailable = false
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create
        setTitle("Specify OpenAPI Specification URL")
        setMessage("Specify the URL of the OpenAPI specification from which LEMMA models shall " +
            "be extracted.", IMessageProvider.INFORMATION)
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
     * OK button was pressed
     */
    override okPressed() {
        if (!syncInput()) {
            return
        }

         try {
            val generator = new LemmaGenerator()
            val parsingMessages = generator.parse(fetchUrl.toString)
            MessageDialog.openInformation(this.shell, "Parsing Report",
                '''«FOR msg : parsingMessages»
                «msg»
                «ENDFOR»''')

            if (generator.isParsed){
                generator.generateModels(
                    targetFolder,
                    '''«dataModelName».data''',
                    '''«technologyModelName».technology''',
                    '''«serviceModelName».services''',
                    servicePrefix
                )

                if (generator.transMsgs.empty)
                    MessageDialog.openInformation(shell, "Transformation Report",
                        "Transformation successfully completed")
                else
                    // TODO: The original code talked about "problems" when transMsgs is not empty.
                    //       Is that correct (I also invoke openError() here for that reason)?
                    MessageDialog.openError(shell, "Transformation Report",
                        '''
                        There were error during the transformation:
                        «FOR msg : generator.transMsgs»
                            - «msg»
                        «ENDFOR»
                        '''
                    )
            } else
                MessageDialog.openError(shell, "Parsing Error", "Generation of in-memory " +
                    "representation not possible for the OpenAPI specification URL " +
                    fetchUrl.toString)

        } catch (Exception ex) {
            // TODO: I recognized that throughout all OpenAPI plugins the terms "extraction",
            //       "generation", and "transformation are used interchangeably. Please decide for
            //       one term and use it consistently.
            MessageDialog.openError(shell, "Error", "Error during extraction: " +
                ex.message)
        }

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
        servicePrefix = txtServicePrefix.text.trim

        val missingValues = targetFolder.empty ||
            dataModelName.empty ||
            technologyModelName.empty ||
            serviceModelName.empty ||
            servicePrefix.empty
        if (missingValues)
            MessageDialog.openError(this.shell, "Missing Field Values", "Please specify a value " +
                "for each field")
        return !missingValues
    }

    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite

        val container = new Composite(area, SWT.NULL)
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true))

        val layout = new GridLayout(4, false)
        layout.verticalSpacing = 10

        container.setLayout(layout)
        createUrl(container)
        createTargetFolder(container)
        createDataModelName(container)
        createServiceModelName(container)
        createServicePrefix(container)
        createTechnologyModelName(container)

        return area
    }

    private def createUrl(Composite container) {
        val lblUrl = new Label(container, SWT.NONE)
        lblUrl.setText("URL:")

        val dataUrl = new GridData()
        dataUrl.grabExcessHorizontalSpace = true
        dataUrl.horizontalAlignment = GridData.FILL
        dataUrl.horizontalSpan = 1
        dataUrl.widthHint = (shell.size.x * 0.3) as int

        txtUrl = new Text(container, SWT.BORDER)
        txtUrl.enabled = false
        txtUrl.setLayoutData(dataUrl)

        val uriWebLocationButton = new GridData()
        uriWebLocationButton.grabExcessHorizontalSpace = true
        uriWebLocationButton.horizontalAlignment = SWT.RIGHT

        btnUriWebLocation = new Button(container, SWT.BUTTON1)
        btnUriWebLocation.text = "Enter URL"
        btnUriWebLocation.setLayoutData(uriWebLocationButton)
        btnUriWebLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val urlDialog = new InputDialog(
                    shell,
                    "",
                    "Enter OpenAPI specification URL",
                    "Please enter a URL to an OpenAPI specification, e.g., " +
                    "https://petstore3.swagger.io/api/v3/openapi.json",
                    new UrlInputValidator()
                )

            if (urlDialog.open() == Window.OK)
                txtUrl.text = urlDialog.getValue()
        ]))

        val uriFileLocationButton = new GridData()
        uriFileLocationButton.grabExcessHorizontalSpace = true
        uriFileLocationButton.horizontalAlignment = SWT.RIGHT

        btnUriFileLocation = new Button(container, SWT.BUTTON1)
        btnUriFileLocation.text = "Select OpenAPI Specification File"
        btnUriFileLocation.setLayoutData(uriWebLocationButton)
        btnUriFileLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val fileDialog = new FileDialog(shell)
            fileDialog.setText("Please select an OpenAPI specification file")
            // TODO: What happens if open() returns null?
            val selectedFile = fileDialog.open()
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

    private def createTargetFolder(Composite container) {
        val lblTargetFolder = new Label(container, SWT.NULL)
        lblTargetFolder.setText("Target Folder:")

        val dataTargetLocation = new GridData()
        dataTargetLocation.grabExcessHorizontalSpace = true
        dataTargetLocation.horizontalAlignment = GridData.FILL
        dataTargetLocation.horizontalSpan = 2

        txtTargetFolder = new Text(container, SWT.BORDER)
        // TODO: Target folder for what?
        txtTargetFolder.message = "Select Target Folder"
        txtTargetFolder.enabled = false
        txtTargetFolder.setLayoutData(dataTargetLocation)

        val dataTargetFolderButton = new GridData()
        dataTargetFolderButton.grabExcessHorizontalSpace = true
        dataTargetFolderButton.horizontalAlignment = SWT.RIGHT

        btnBrowseFolder = new Button(container, SWT.BUTTON1)
        // TODO: Target folder for what?
        btnBrowseFolder.text = "Select Target Folder"
        btnBrowseFolder.setLayoutData(dataTargetFolderButton)
        btnBrowseFolder.addSelectionListener(SelectionListener.widgetSelectedAdapter([ e |
            val dirDialog = new DirectoryDialog(shell)
            // TODO: Target folder for what?
            dirDialog.setText("Select target folder.")
            dirDialog.filterPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
            txtTargetFolder.text = dirDialog.open()
        ]))
    }

    private def createDataModelName(Composite container) {
        val lblDataModelName = new Label(container, SWT.NULL)
        lblDataModelName.setText("Data Model Name:")

        val dataDataModelName = new GridData()
        dataDataModelName.grabExcessHorizontalSpace = true
        dataDataModelName.horizontalAlignment = GridData.FILL
        dataDataModelName.horizontalSpan = 3

        txtDataModelName = new Text(container, SWT.BORDER)
        txtDataModelName.message = "DataModel"
        txtDataModelName.setLayoutData(dataDataModelName)
    }

    private def createServiceModelName(Composite container) {
        val lblServiceModelName = new Label(container, SWT.NULL)
        lblServiceModelName.setText("Service Model Name:")

        val dataServiceModelName = new GridData()
        dataServiceModelName.grabExcessHorizontalSpace = true
        dataServiceModelName.horizontalAlignment = GridData.FILL
        dataServiceModelName.horizontalSpan = 3

        txtServiceModelName = new Text(container, SWT.BORDER)
        txtServiceModelName.message = "ServiceModel"
        txtServiceModelName.setLayoutData(dataServiceModelName)
    }

    private def createServicePrefix(Composite container) {
        val lblServicePrefix = new Label(container, SWT.NULL)
        lblServicePrefix.setText("Service Model Prefix:")

        val dataServicePrefix = new GridData()
        dataServicePrefix.grabExcessHorizontalSpace = true
        dataServicePrefix.horizontalAlignment = GridData.FILL
        dataServicePrefix.horizontalSpan = 3

        txtServicePrefix = new Text(container, SWT.BORDER)
        txtServicePrefix.message = "org.example"
        txtServicePrefix.setLayoutData(dataServicePrefix)
    }

    private def createTechnologyModelName(Composite container) {
        val lblTechnologyModelName = new Label(container, SWT.NULL)
        lblTechnologyModelName.setText("Technology Model Name:")

        val dataTechnologyModelName = new GridData()
        dataTechnologyModelName.grabExcessHorizontalSpace = true
        dataTechnologyModelName.horizontalAlignment = GridData.FILL
        dataTechnologyModelName.horizontalSpan = 3

        txtTechnologyModelName = new Text(container, SWT.BORDER)
        txtTechnologyModelName.message = "OpenAPI"
        txtTechnologyModelName.setLayoutData(dataTechnologyModelName)
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