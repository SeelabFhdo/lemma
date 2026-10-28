package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.servicedsl.smells.refactoring.RecordedProposal
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Shell

/**
 * The one way in to reviewing a proposal, from wherever it is asked for.
 *
 * Both routes land here - the link in the completion notification and the menu
 * action - so a proposal is read the same way whether it was made a minute ago
 * or last week. That is the point of the record being a folder rather than a
 * session.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReviewProposal {
    /**
     * Open the review dialog on a proposal folder.
     *
     * Refuses with the reason rather than opening something empty: a folder
     * with no patch is a failed run, and offering it for review would promise
     * a patch that is not there.
     */
    static def void open(Shell shell, Path folder, String sourceRoot) {
        val proposal = RecordedProposal.at(folder)
        if (proposal === null) {
            MessageDialog.openError(shell, "Not a proposal",
                '''«folder»

holds no patch, so there is nothing to review. A run that produced none
records why in its own folder.''')
            return
        }
        val root = sourceRoot ?: proposal.target
        if (root.nullOrEmpty) {
            MessageDialog.openError(shell, "No target",
                "This proposal records no target checkout, and none is configured. "
                    + "Set the source root in the preferences.")
            return
        }
        new ReviewProposalDialog(shell, proposal, root).open
    }

    /**
     * Ask for a folder, then open it.
     */
    static def void browseAndOpen(Shell shell, String startingFrom) {
        val dialog = new org.eclipse.swt.widgets.DirectoryDialog(shell)
        dialog.text = "Review a refactoring proposal"
        dialog.message = "Choose a proposal folder - the one holding patch.diff."
        if (!startingFrom.nullOrEmpty) {
            dialog.filterPath = startingFrom
        }
        val chosen = dialog.open
        if (chosen !== null) {
            open(shell, Paths.get(chosen), SmellRefactoringPreferences.sourceRoot)
        }
    }
}
