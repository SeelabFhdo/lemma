package de.fhdo.lemma.ui.quickfix

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.ui.handlers.HandlerUtil

/**
 * Review a proposal that was made earlier.
 *
 * The second way in, and the reason the record is a folder: a proposal made
 * last week is read exactly as one made a minute ago. Without this, reviewing
 * would only ever be possible in the minutes after a job finished.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReviewProposalHandler extends AbstractHandler {
    override execute(ExecutionEvent event) {
        // Starts where proposals are kept, so the common case is one click.
        val recordRoot = SmellRefactoringPreferences.recordRoot
        ReviewProposal.browseAndOpen(HandlerUtil.getActiveShell(event),
            recordRoot?.toString)
        return null
    }
}
