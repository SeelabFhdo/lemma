package de.fhdo.lemma.servicedsl.smells.refactoring

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * What a [[RefactoringProposer]] came back with.
 *
 * A patch and the facts needed to record it, or a reason it produced none.
 * Nothing here has been applied anywhere: a proposal is a proposal.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Proposal {
    /**
     * The unified diff, against the commit the worktree was made from. Empty
     * where nothing was changed, which is a failure and not a clean system.
     */
    @Accessors
    String patch

    /**
     * What the proposer wrote about its own work, where it wrote any.
     */
    @Accessors
    String notes

    /**
     * Why there is no patch. Null on success.
     *
     * Set for a precondition that did not hold, a usage limit, a proposer that
     * changed nothing, or a patch that touched something it must not.
     */
    @Accessors
    String failure

    @Accessors
    String model

    @Accessors
    String cliVersion

    @Accessors
    String sessionId

    @Accessors
    int turns

    @Accessors
    long durationMs

    @Accessors
    double costUsd

    /**
     * The proposer's own output, kept verbatim for the record.
     */
    @Accessors
    String rawResult

    def boolean isSuccess() {
        return failure.nullOrEmpty && !patch.nullOrEmpty
    }
}
