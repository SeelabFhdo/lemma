package de.fhdo.lemma.eclipse.ui.about_dialog

import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.TrayDialog
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.jface.resource.JFaceColors
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.graphics.Point

/**
 * Implementation of the "About LEMMA" dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class AboutDialog extends TrayDialog {
    static val MIN_DIALOG_WIDTH = 250
    static val MIN_DIALOG_HEIGHT = 100

    /**
     * Constructor
     */
    new(Shell parentShell) {
        super(parentShell)
    }

    /**
     * Create buttons
     */
    override createButtonsForButtonBar(Composite parent) {
        val okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.CLOSE_LABEL,
            true)
        okButton.setFocus()
    }

    /**
     * Configure shell
     */
    override configureShell(Shell shell) {
      super.configureShell(shell);
      shell.setText("About LEMMA");
    }

    /**
     * Create dialog area
     */
    override createDialogArea(Composite parent) {
        val background = JFaceColors.getBannerBackground(parent.getDisplay())
        val foreground = JFaceColors.getBannerForeground(parent.getDisplay())

        /* Create main container */
        val containerLayout = new GridLayout()
        containerLayout.numColumns = 1
        containerLayout.marginHeight = 0
        containerLayout.marginWidth = 0
        containerLayout.verticalSpacing = 0
        containerLayout.horizontalSpacing = 0

        val container = new Composite(parent, SWT.NONE)
        container.setLayout(containerLayout)
        container.background = background
        container.foreground = foreground

        val containerData = new GridData()
        containerData.horizontalAlignment = GridData.FILL
        containerData.verticalAlignment = GridData.FILL
        containerData.grabExcessHorizontalSpace = true
        containerData.grabExcessVerticalSpace = true
        containerData.heightHint = MIN_DIALOG_HEIGHT
        container.setLayoutData(containerData)

        /* Create and fill about text */
        val aboutTextContainer = new Composite(container, SWT.NONE)
        aboutTextContainer.setBackground(background)
        aboutTextContainer.setLayout(new GridLayout())

        // Prepare about content
        val aboutFile = getClass().getResourceAsStream("/About.md")
        val converter = new MarkdownToStyledTextConverter(aboutTextContainer,
            SWT.MULTI.bitwiseOr(SWT.WRAP).bitwiseOr(SWT.READ_ONLY))
        val aboutText = converter.convert(aboutFile)
        aboutText.setFont(parent.getFont())
        aboutText.setCursor(null)
        aboutText.setBackground(background)
        aboutText.setForeground(foreground)

        // Layout about text
        val aboutTextData = new GridData()
        aboutTextData.verticalAlignment = GridData.BEGINNING
        aboutTextData.horizontalAlignment = GridData.FILL
        aboutTextData.grabExcessHorizontalSpace = true
        aboutText.setLayoutData(aboutTextData)

        val aboutTextSize = aboutTextContainer.computeSize(MIN_DIALOG_WIDTH, SWT.DEFAULT)
        aboutTextContainer.setSize(aboutTextSize.x, aboutTextSize.y)

        /* Create horizontal bar */
        var horizontalBar = new Label(container, SWT.HORIZONTAL.bitwiseOr(SWT.SEPARATOR))
        val barData = new GridData()
        barData.horizontalAlignment = GridData.FILL
        horizontalBar.setLayoutData(barData)

        /* Create dialog bottom area */
        val bottomData = new GridData()
        bottomData.horizontalAlignment = SWT.FILL
        bottomData.verticalAlignment = SWT.FILL
        bottomData.grabExcessHorizontalSpace = true

        val bottomArea = super.createDialogArea(container) as Composite
        bottomArea.setLayout(new GridLayout())
        bottomArea.setLayoutData(containerData)

        /* Create spacer between text and bottom area */
        val spacer = new Label(bottomArea, SWT.NONE)
        val spacerData = new GridData()
        spacerData.horizontalAlignment = GridData.FILL
        spacer.setLayoutData(containerData)

        return container
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