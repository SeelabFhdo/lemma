package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalApplication
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text

/**
 * The last dialog before anything is written: what applying will do.
 *
 * Both options are ticked by default, and both are defaults for a reason
 * rather than for convenience:
 *
 *  - **Commit to a branch**, because a proposal for the *second* root cause of
 *    a system has to be generated against a commit. Applying to the working
 *    tree and stopping leaves the one state that does not compose - measured
 *    on Lakeside Mutual, two proposals made against the same commit overlapped
 *    in five files and each brought its own certificate authority.
 *  - **Run the certificate script**, because the patch configures mutual TLS
 *    and commits no key material, so the system cannot start until it runs.
 *
 * The base commit is shown because applying to the wrong one is the failure
 * this whole path is arranged to prevent.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ApplyProposalDialog extends TitleAreaDialog {
    val ProposalApplication.Plan plan

    var Button commitButton
    var Button certificateButton

    /**
     * Whether to create a branch and commit. Read after the dialog closes.
     */
    public var boolean commitToBranch = true

    /**
     * Whether to run the certificate script the patch ships.
     */
    public var boolean runCertificateScript = true

    new(Shell shell, ProposalApplication.Plan plan) {
        super(shell)
        this.plan = plan
        this.runCertificateScript = plan.hasCertificateScript
    }

    override protected configureShell(Shell shell) {
        super.configureShell(shell)
        shell.text = "Apply this proposal"
    }

    override protected createDialogArea(Composite parent) {
        title = '''Apply «plan.files» file(s) to the checkout'''.toString
        message = "Nothing has been written yet. This is what will happen."

        val area = super.createDialogArea(parent) as Composite
        val body = new Composite(area, SWT.NONE)
        body.layout = new GridLayout(2, false)
        body.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

        row(body, "Target", plan.target)
        row(body, "Base", plan.base ?: "unrecorded")

        commitButton = check(body, '''Commit to branch «plan.branch»'''.toString, true)
        explain(body, "A proposal for another root cause of this system has to be generated "
            + "against a commit. Applying without committing leaves the one state that does "
            + "not compose with the next one.")

        if (plan.hasCertificateScript) {
            certificateButton = check(body,
                '''Run «plan.certificateScript»'''.toString, true)
            explain(body, "The patch configures mutual TLS but commits no key material, so "
                + "the system cannot start until this has run. It is generated, never "
                + "committed.")
        } else {
            explain(body, "This patch ships no certificate script, so none is offered.")
        }

        explain(body, "Afterwards the models still describe the sources as they were. Re-run "
            + "the reconstruction to see the finding count change.")
        return area
    }

    override protected okPressed() {
        commitToBranch = commitButton !== null && commitButton.selection
        runCertificateScript = certificateButton !== null && certificateButton.selection
        super.okPressed
    }

    override protected createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "&Apply", true)
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
    }

    private def Button check(Composite parent, String text, boolean selected) {
        val button = new Button(parent, SWT.CHECK)
        button.text = text
        button.selection = selected
        button.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false) => [
            horizontalSpan = 2
            verticalIndent = 8
        ]
        return button
    }

    private def void row(Composite parent, String name, String value) {
        val label = new Label(parent, SWT.NONE)
        label.text = name + ":"
        val text = new Text(parent, SWT.READ_ONLY.bitwiseOr(SWT.SINGLE))
        text.text = value
        text.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
    }

    private def void explain(Composite parent, String text) {
        val label = new Label(parent, SWT.WRAP)
        label.text = text
        label.layoutData = new GridData(SWT.FILL, SWT.BEGINNING, true, false) => [
            horizontalSpan = 2
            widthHint = 520
            horizontalIndent = 18
        ]
    }
}
