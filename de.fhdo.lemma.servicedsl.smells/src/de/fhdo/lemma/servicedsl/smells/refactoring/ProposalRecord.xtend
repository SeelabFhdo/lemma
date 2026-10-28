package de.fhdo.lemma.servicedsl.smells.refactoring

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDate

/**
 * Writes one proposal to disk, as ADR-0010 requires of every proposal.
 *
 * The refactoring is not reproducible - a language model does not repeat
 * itself - so the record of it has to be auditable instead. That is the whole
 * basis on which an AI is allowed into this toolchain, and it is why the folder
 * carries the skill's text rather than a reference to it: a record that needs
 * two repositories checked out at the right revisions to be read is not a
 * record.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ProposalRecord {
    /**
     * Write the folder and return it.
     *
     * @param root where proposals are kept
     * @param request what was asked
     * @param proposal what came back
     * @param skillText the skill that produced it, verbatim
     * @return the folder written
     */
    static def Path write(Path root, RefactoringRequest request, Proposal proposal,
        String skillText) {
        val folder = root.resolve(folderName(request))
        Files.createDirectories(folder)

        folder.put("request.md", PromptBuilder.request(request))
        folder.put("constraints.md", PromptBuilder.constraints)
        folder.put("skill.md", skillText)
        folder.put("patch.diff", proposal.patch)
        folder.put("notes.md", proposal.notes)
        folder.put("result.json", proposal.rawResult)
        folder.put("model.txt", summary(request, proposal))
        return folder
    }

    /**
     * Dated and named after the cause, so a folder says what it is without
     * being opened, and two proposals for one cause on one day do not collide.
     */
    static def String folderName(RefactoringRequest request) {
        val slug = (request.rootCauseId ?: "unknown")
            .replaceAll("[^A-Za-z0-9]+", "-")
            .replaceAll("(^-|-$)", "")
            .toLowerCase
        return '''«LocalDate.now»-«slug»-«System.currentTimeMillis»'''.toString
    }

    private static def String summary(RefactoringRequest request, Proposal proposal) {
        return '''
        cause         «request.rootCauseId»
        label         «request.rootCauseLabel»
        findings      «request.findings.size»
        skill         «request.skill» (copied verbatim as skill.md)
        target        «request.sourceRoot»
        base          «request.base ?: "<unrecorded>"»

        model         «proposal.model ?: "<unrecorded>"»
        cli           «proposal.cliVersion ?: "<unrecorded>"»
        session       «proposal.sessionId ?: "<unrecorded>"»
        turns         «proposal.turns»
        duration_s    «proposal.durationMs / 1000»
        cost_usd      «proposal.costUsd»
        outcome       «IF proposal.success»patch produced«ELSE»no patch: «proposal.failure»«ENDIF»

        Not verified here. A patch is not evidence that the smell is resolved -
        that needs the verification step: re-reconstruct, re-detect, and confirm
        the finding count fell, the build is green on a clean checkout, and the
        system still starts.
        '''.toString
    }

    private static def void put(Path folder, String name, String content) {
        Files.write(folder.resolve(name),
            (content ?: "").getBytes(StandardCharsets.UTF_8))
    }
}
