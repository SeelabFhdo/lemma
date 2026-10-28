package de.fhdo.lemma.servicedsl.smells.refactoring

/**
 * A proposer that returns a patch decided in advance.
 *
 * What makes the rest of this package testable without an AI: grouping, prompt
 * construction, the patch guard and the record are all exercised against a
 * known result, deterministically and in milliseconds.
 *
 * It also keeps the request it was given, so a test can assert what the
 * machinery would have asked for.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class RecordedProposer implements RefactoringProposer {
    val String patch
    val String failure

    /**
     * The request of the last call, for a test to inspect.
     */
    public var RefactoringRequest lastRequest

    new(String patch) {
        this(patch, null)
    }

    new(String patch, String failure) {
        this.patch = patch
        this.failure = failure
    }

    override Proposal propose(RefactoringRequest request) {
        lastRequest = request
        val unmet = Preconditions.unmetReason(request)
        val proposal = new Proposal
        proposal.model = "recorded"
        proposal.cliVersion = "recorded"
        proposal.sessionId = "recorded"
        proposal.rawResult = "{\"subtype\":\"success\",\"is_error\":false}"
        if (failure !== null) {
            proposal.failure = failure
        } else if (unmet !== null && patch.nullOrEmpty) {
            proposal.failure = unmet
        } else {
            proposal.patch = patch
        }
        return proposal
    }
}
