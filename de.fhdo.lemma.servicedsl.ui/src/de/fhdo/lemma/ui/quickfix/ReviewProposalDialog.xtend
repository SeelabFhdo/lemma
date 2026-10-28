package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalApplication
import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalApplier
import de.fhdo.lemma.servicedsl.smells.refactoring.RecordedProposal
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import org.eclipse.compare.CompareUI
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text

/**
 * Review a proposal, then decide what to do with it.
 *
 * Deliberately not a wizard and deliberately not automatic. A proposal takes
 * 13 to 25 minutes to produce, so by the time one is ready the reader has
 * moved on; this opens from the completion notification or from the menu,
 * whenever they choose.
 *
 * It says **not verified** where it can be read at the moment of deciding.
 * Until now that fact lived in ``model.txt``, after the fact, in a file nobody
 * had opened - and an unverified patch is a suggestion, which is the single
 * most important thing about it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReviewProposalDialog extends TitleAreaDialog {
    static val VERIFY = IDialogConstants.CLIENT_ID + 1
    static val SHOW_DIFF = IDialogConstants.CLIENT_ID + 2
    static val APPLY = IDialogConstants.CLIENT_ID + 3

    val RecordedProposal proposal
    val String root

    new(Shell shell, RecordedProposal proposal, String root) {
        super(shell)
        this.proposal = proposal
        this.root = root
    }

    override protected isResizable() { true }

    override protected configureShell(Shell shell) {
        super.configureShell(shell)
        shell.text = "Review a refactoring proposal"
    }

    override protected createDialogArea(Composite parent) {
        title = proposal.cause ?: proposal.folder.fileName.toString

        if (proposal.verified) {
            message = "Verified: the finding count fell and the build is green."
        } else {
            // The whole basis of the method, said where it is read.
            message = "Not verified. A patch is not evidence that the smell is resolved - "
                + "verify it before trusting it."
            setMessage(message, org.eclipse.jface.dialogs.IMessageProvider.WARNING)
        }

        val area = super.createDialogArea(parent) as Composite
        val body = new Composite(area, SWT.NONE)
        body.layout = new GridLayout(2, false)
        body.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

        row(body, "Cause", proposal.cause ?: "unrecorded")
        row(body, "Files", proposal.changedPaths.size.toString)
        row(body, "Base commit", ProposalApplier.describe(root, proposal.base)
            ?: (proposal.base ?: "unrecorded"))
        row(body, "Target", root)
        row(body, "Model", proposal.model ?: "unrecorded")
        row(body, "Folder", proposal.folder.toString)

        label(body, "Changes")
        val files = new Text(body, SWT.MULTI.bitwiseOr(SWT.READ_ONLY)
            .bitwiseOr(SWT.BORDER).bitwiseOr(SWT.V_SCROLL))
        files.text = proposal.changedPaths.join("\n")
        files.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true) => [
            heightHint = 140
            widthHint = 560
        ]

        val notes = proposal.folder.resolve(RecordedProposal.NOTES_FILE)
        if (Files.exists(notes)) {
            label(body, "Its own notes")
            val text = new Text(body, SWT.MULTI.bitwiseOr(SWT.READ_ONLY)
                .bitwiseOr(SWT.BORDER).bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.WRAP))
            text.text = new String(Files.readAllBytes(notes), StandardCharsets.UTF_8)
            text.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true) => [
                heightHint = 160
            ]
        }
        return area
    }

    override protected createButtonsForButtonBar(Composite parent) {
        createButton(parent, SHOW_DIFF, "Show the &changes…", false)
        createButton(parent, VERIFY, "&Verify…", false)
        createButton(parent, APPLY, "&Apply…", true)
        createButton(parent, IDialogConstants.CLOSE_ID, IDialogConstants.CLOSE_LABEL, false)
    }

    override protected buttonPressed(int id) {
        switch (id) {
            case SHOW_DIFF: showTheChanges
            case VERIFY: verify
            case APPLY: applyIt
            case IDialogConstants.CLOSE_ID: close
            default: super.buttonPressed(id)
        }
    }

    /**
     * Open Eclipse's compare viewer on the proposal.
     */
    private def void showTheChanges() {
        val input = new ProposalCompareInput(proposal, root)
        try {
            CompareUI.openCompareDialog(input)
        } finally {
            input.dispose
        }
    }

    /**
     * Point the reader at the verification, which is a long job and a shell
     * command rather than something to run inside a modal dialog.
     */
    private def void verify() {
        val command = '''tools/verify-refactoring.sh \
    --proposal «proposal.folder» \
    --source «root» \
    --models <generated-models> \
    --mrf <mrf-repository>«IF proposal.base !== null» \
    --base «proposal.base»«ENDIF»'''.toString

        val dialog = new MessageDialog(shell, "Verify this proposal", null,
            '''Verification re-reconstructs the patched sources, re-detects the smell and
confirms the finding count fell, the build is green on a clean checkout, and
the system still starts.

It needs Docker and MongoDB and takes about fifteen minutes, so it runs from a
shell in the smells bundle:

«command»

The verdict is appended to verification.md in the proposal folder.''',
            MessageDialog.INFORMATION, #[IDialogConstants.OK_LABEL], 0)
        dialog.open
    }

    /**
     * Check, then plan, then do - and refuse rather than guess.
     */
    private def void applyIt() {
        val head = ProposalApplier.headOf(root)
        val refusal = ProposalApplication.refusal(proposal, head,
            ProposalApplier.applies(root, proposal.patch))
        if (refusal !== null) {
            MessageDialog.openError(shell, "Cannot apply this proposal", refusal)
            return
        }
        if (ProposalApplier.isDirty(root)) {
            if (!MessageDialog.openQuestion(shell, "The target has uncommitted changes",
                '''«root» has uncommitted changes.

Applying on top of them produces a commit that mixes this proposal with work
it did not make. Continue anyway?''')) {
                return
            }
        }

        val plan = ProposalApplication.planFor(proposal, root)
        val apply = new ApplyProposalDialog(shell, plan)
        if (apply.open != IDialogConstants.OK_ID) {
            return
        }

        val outcome = ProposalApplier.apply(proposal, root,
            if (apply.commitToBranch) plan.branch else null,
            apply.commitToBranch,
            if (apply.runCertificateScript) plan.certificateScript else null)

        if (!outcome.success) {
            MessageDialog.openError(shell, "The proposal was not applied", outcome.failure)
            return
        }
        MessageDialog.openInformation(shell, "Applied",
            '''«outcome.done.join("\n")»«IF !outcome.warnings.empty»

«outcome.warnings.join("\n")»«ENDIF»

The models still describe the sources as they were. Re-run the reconstruction
to see the finding count change.'''.toString)
        close
    }

    private def void row(Composite parent, String name, String value) {
        label(parent, name)
        val text = new Text(parent, SWT.READ_ONLY.bitwiseOr(SWT.SINGLE))
        text.text = value
        text.layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
    }

    private def Control label(Composite parent, String name) {
        val label = new Label(parent, SWT.NONE)
        label.text = name + ":"
        label.layoutData = new GridData(SWT.LEFT, SWT.BEGINNING, false, false)
        return label
    }
}
