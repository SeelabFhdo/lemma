package de.fhdo.lemma.servicedsl.smells.refactoring

/**
 * Something that can propose a patch resolving a root cause.
 *
 * An interface so the AI is replaceable and everything around it is testable:
 * [[ClaudeCliProposer]] spawns a process and contains no decision,
 * [[RecordedProposer]] returns a patch recorded earlier. Grouping, prompt
 * construction, precondition checks and the record are all on this side of the
 * line and are covered by the headless suite.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
interface RefactoringProposer {
    /**
     * Propose a patch, without applying anything.
     *
     * Must not throw for an ordinary failure - a proposer that cannot run, or
     * produced nothing, returns a [[Proposal]] carrying the reason.
     */
    def Proposal propose(RefactoringRequest request)
}
