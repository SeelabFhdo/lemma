package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.servicedsl.smells.refactoring.ClaudeCliProposer
import de.fhdo.lemma.servicedsl.smells.refactoring.PatchGuard
import de.fhdo.lemma.servicedsl.smells.refactoring.Preconditions
import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalRecord
import de.fhdo.lemma.servicedsl.smells.refactoring.RefactoringRequest
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job

/**
 * Runs one proposal in the background and records it.
 *
 * A background job because a quickfix's ``apply`` runs on the UI thread and a
 * proposal takes ten to twenty-five minutes. Nothing is applied to the user's
 * workspace at any point: the proposer works in a throwaway worktree of the
 * configured source root, and what comes back is a patch on disk.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ProposeRefactoringJob extends Job {
    static val PLUGIN = "de.fhdo.lemma.servicedsl.ui"

    val RefactoringRequest request
    val Path recordRoot

    new(RefactoringRequest request, Path recordRoot) {
        // Through a method, not a template: Xtend cannot compile a rich string
        // inside super(), because it would need a local variable and nothing
        // may precede the super call.
        super(nameFor(request))
        this.request = request
        this.recordRoot = recordRoot
        user = true
    }

    private static def String nameFor(RefactoringRequest request) {
        return '''Proposing «request?.rootCauseLabel ?: "a refactoring"» (AI)'''.toString
    }

    protected override IStatus run(IProgressMonitor monitor) {
        monitor.beginTask('''Proposing a refactoring for «request.rootCauseLabel»'''.toString, 3)
        try {
            val unmet = Preconditions.unmetReason(request)
            if (unmet !== null) {
                return error(unmet)
            }
            monitor.worked(1)

            val proposer = new ClaudeCliProposer(SmellRefactoringPreferences.model,
                SmellRefactoringPreferences.skillPluginDirectory,
                SmellRefactoringPreferences.timeoutMinutes)
            val proposal = proposer.propose(request)
            monitor.worked(1)
            if (monitor.canceled) {
                return Status.CANCEL_STATUS
            }
            if (!proposal.success) {
                return error('''No patch was produced: «proposal.failure».'''.toString)
            }

            // The constraints are instruction, so what came back is checked.
            val violations = PatchGuard.violations(proposal.patch)
            if (!violations.empty) {
                // Recorded anyway: a rejected patch is evidence about the
                // skill, and discarding it would lose the only copy.
                val folder = record(proposal)
                return error('''The patch was rejected and kept for inspection at «folder»:
«violations.join("\n")»'''.toString)
            }

            val folder = record(proposal)
            monitor.worked(1)
            // Offer the review rather than only naming the folder. A modal
            // dialog opening by itself 13-25 minutes later would land on top
            // of whatever the reader moved on to - the job runs in the
            // background precisely so they could.
            offerToReview(folder)
            return new Status(IStatus.INFO, PLUGIN,
                '''A patch for «request.rootCauseLabel» was written to «folder».
It has been applied nowhere. Review it, then verify it by re-running the
reconstruction and the detection - a patch is not evidence that the smell is
resolved.'''.toString)
        } catch (Exception exception) {
            return error('''The proposal failed: «exception.message»'''.toString)
        } finally {
            monitor.done
        }
    }

    private def Path record(
        de.fhdo.lemma.servicedsl.smells.refactoring.Proposal proposal) {
        val root = recordRoot ?: Files.createTempDirectory("lemma-refactorings")
        return ProposalRecord.write(root, request, proposal, skillText)
    }

    /**
     * The skill's own text, copied into the record.
     *
     * Verbatim rather than by reference: a record that needs two repositories
     * checked out at the right revisions to be read is not a record.
     */
    private def String skillText() {
        try {
            val plugin = SmellRefactoringPreferences.skillPluginDirectory
            if (plugin === null) {
                return "<the skill could not be located>"
            }
            val skill = plugin.resolve("skills")
                .resolve("resolve-non-secured-communication").resolve("SKILL.md")
            return if (Files.exists(skill))
                new String(Files.readAllBytes(skill), StandardCharsets.UTF_8)
            else
                "<the skill could not be located>"
        } catch (Exception exception) {
            return "<the skill could not be read>"
        }
    }

    /**
     * Ask, on the user interface thread, whether to review it now.
     */
    private def void offerToReview(java.nio.file.Path folder) {
        val display = org.eclipse.swt.widgets.Display.getDefault
        display.asyncExec[
            val shell = org.eclipse.ui.PlatformUI.workbench?.activeWorkbenchWindow?.shell
            if (shell === null) {
                return
            }
            val review = org.eclipse.jface.dialogs.MessageDialog.openQuestion(shell,
                "Security Smell Refactoring",
                '''A patch for «request.rootCauseLabel» was written to

«folder»

It has been applied nowhere. Review it now?''')
            if (review) {
                ReviewProposal.open(shell, folder, request.sourceRoot)
            }
        ]
    }

    private def IStatus error(String message) {
        return new Status(IStatus.ERROR, PLUGIN, message)
    }
}
