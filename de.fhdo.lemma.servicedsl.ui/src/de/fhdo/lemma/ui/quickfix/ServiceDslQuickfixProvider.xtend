package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.servicedsl.smells.refactoring.RefactoringRequest
import de.fhdo.lemma.servicedsl.smells.validation.NonSecuredCommunicationValidator
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes for service models.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class ServiceDslQuickfixProvider extends DefaultQuickfixProvider {
    static val SKILL = "lemma-smell-refactoring:resolve-non-secured-communication"

    /**
     * Offer to propose a patch resolving a non-secured channel.
     *
     * **It proposes; it never applies.** The smell is in the system, not in the
     * model - so a fix that edited the model would only make the model stop
     * describing the system, and the next reconstruction would overwrite it
     * anyway (ADR-0010). What this produces is a patch against the sources, in
     * a throwaway worktree, which nothing applies and which is only evidence of
     * anything once the verification step has re-reconstructed and re-detected.
     *
     * The label says so: it names the AI and asks for review, because a
     * nondeterministic proposal presented as a fix would be a lie about what
     * happened.
     */
    @Fix(NonSecuredCommunicationValidator.NON_SECURED_COMMUNICATION)
    def void proposeMutualTls(Issue issue, IssueResolutionAcceptor acceptor) {
        val causeLabel = issue.dataAt(
            NonSecuredCommunicationValidator.DATA_ROOT_CAUSE_LABEL) ?: "this channel"
        val causeId = issue.dataAt(NonSecuredCommunicationValidator.DATA_ROOT_CAUSE_ID)
        if (causeId === null) {
            return
        }

        acceptor.accept(issue,
            '''Propose mutual TLS for «causeLabel» (AI — review required)''',
            '''Asks an AI to write a patch resolving this smell at both ends of every
channel «causeLabel» explains. Nothing is applied: the patch is produced in a
throwaway worktree and written to disk for you to review.''',
            null,
            [ element, context |
                val aspect = if (element instanceof ImportedServiceAspect) element else null
                val sourceRoot = SmellRefactoringPreferences.sourceRoot
                if (sourceRoot.nullOrEmpty) {
                    // Open the page rather than name a preference key. The
                    // thing that is missing cannot be guessed - a model
                    // carries no source paths - so the only useful response
                    // is to put the reader in front of the field.
                    askForTheSourceRoot
                    return
                }

                val request = new RefactoringRequest
                request.rootCauseId = causeId
                request.rootCauseLabel = causeLabel
                request.sourceRoot = sourceRoot
                request.skill = SKILL
                request.cliCommand = SmellRefactoringPreferences.cliCommand
                request.findings.addAll(CauseFindings.of(aspect, causeId))
                if (request.findings.empty) {
                    throw new IllegalStateException(
                        "The channel this warning marks could not be read back from the model.")
                }

                // Off the UI thread: a proposal takes minutes, and apply() is
                // called on it.
                new ProposeRefactoringJob(request,
                    SmellRefactoringPreferences.recordRoot).schedule
            ])
    }

    /**
     * Say what is missing, and offer to go and set it.
     *
     * A quickfix that throws here shows the reader a stack trace in an error
     * log they did not ask for. This explains the one thing the toolchain
     * genuinely cannot work out for itself and opens the page that fixes it.
     */
    private def void askForTheSourceRoot() {
        val shell = org.eclipse.ui.PlatformUI.workbench?.activeWorkbenchWindow?.shell
        val open = org.eclipse.jface.dialogs.MessageDialog.openQuestion(shell,
            "Security Smell Refactoring",
            '''No source root is configured, so there is nowhere to propose a patch.

A reconstructed model carries no source paths - they are absolute, and a
generated model has to be identical on every machine - so the toolchain cannot
tell which checkout these models came from.

Set it now?''')
        if (open && shell !== null) {
            org.eclipse.ui.dialogs.PreferencesUtil.createPreferenceDialogOn(shell,
                SmellRefactoringPreferencePage.ID, null, null).open
        }
    }

    private def String dataAt(Issue issue, int index) {
        val data = issue.data
        return if (data !== null && data.length > index) data.get(index) else null
    }
}
