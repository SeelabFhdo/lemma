package de.fhdo.lemma.servicedsl.smells.refactoring

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Whether a proposal may be applied to a target, and what applying it means.
 *
 * Plain values in, a decision out - no git, no file system, no UI - so the one
 * part of applying that involves a judgement is the part that is tested. The
 * git work is [[ProposalApplier]]'s and contains no decision.
 *
 * ## Why the base matters this much
 *
 * Two proposals generated independently against the same commit **do not
 * compose**: measured on Lakeside Mutual, they overlapped in five files and
 * each invented its own certificate authority. So a proposal is only
 * applicable to the commit it was produced against, and the useful response to
 * a mismatch is a fresh proposal rather than a forced apply or a hand merge -
 * hand-merging two AI patches is the least reviewable way to arrive at a change
 * nobody wrote.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ProposalApplication {
    /**
     * A branch name for the cause this proposal resolves.
     *
     * Named after the cause so two proposals for one system do not collide,
     * and so a branch says what it carries.
     */
    static def String branchFor(RecordedProposal proposal) {
        val slug = (proposal?.folder?.fileName?.toString ?: "proposal")
            .replaceAll("^[0-9]{4}-[0-9]{2}-[0-9]{2}-", "")
            .replaceAll("-[0-9]{10,}$", "")
            .replaceAll("[^A-Za-z0-9]+", "-")
            .replaceAll("(^-|-$)", "")
            .toLowerCase
        return '''refactoring/«if (slug.empty) "proposal" else slug»'''.toString
    }

    /**
     * Why this proposal cannot be applied to a target at this commit, or null.
     *
     * @param proposal what is to be applied
     * @param targetHead the commit the target is on, or null where it could
     *     not be read - which is itself a refusal, because applying blind is
     *     how a tree ends up half patched
     * @param applies whether the patch applies, as git reports it
     * @return the reason, ready to show, or null when it may proceed
     */
    static def String refusal(RecordedProposal proposal, String targetHead, boolean applies) {
        if (proposal === null) {
            return "That folder holds no proposal: there is no patch in it."
        }
        if (targetHead.nullOrEmpty) {
            return '''The target is not a git checkout, or its commit could not be read.

A proposal is only applicable to the commit it was produced against, so
applying it without knowing the target's commit is not safe.'''.toString
        }

        val base = proposal.base
        if (base !== null && !sameCommit(base, targetHead)) {
            return '''The patch was produced against
  «base»
The target is on
  «targetHead»

Two proposals generated against the same commit do not compose - they overlap
and each brings its own certificate material. Generate a new proposal from the
current commit instead of forcing this one.'''.toString
        }

        if (!applies) {
            // The bases agree, or none was recorded, and it still does not
            // apply: the working tree has moved rather than the commit.
            return '''The patch does not apply to the target.

«IF base === null»This proposal records no base commit, so it cannot be told
whether it was produced for this one.«ELSE»The commit matches, so the working
tree has changed since the proposal was produced.«ENDIF»

Commit or discard the local changes, or generate a new proposal.'''.toString
        }
        return null
    }

    /**
     * Whether two commit identifiers name the same commit.
     *
     * One may be abbreviated: a record keeps a short hash and ``rev-parse``
     * gives a full one, so comparing them as strings would reject every match.
     */
    static def boolean sameCommit(String one, String other) {
        if (one.nullOrEmpty || other.nullOrEmpty) {
            return false
        }
        val shorter = if (one.length <= other.length) one else other
        val longer = if (one.length <= other.length) other else one
        return shorter.length >= 7 && longer.startsWith(shorter)
    }

    /**
     * What applying will do, for the dialog to show before it does it.
     */
    static def Plan planFor(RecordedProposal proposal, String targetRoot) {
        val plan = new Plan
        plan.branch = branchFor(proposal)
        plan.target = targetRoot
        plan.base = proposal?.base
        plan.files = if (proposal === null) 0 else proposal.changedPaths.size
        // A patch that ships a certificate script configures mutual TLS but
        // commits no key material, so the system cannot start until it runs.
        plan.certificateScript = proposal?.changedPaths
            ?.findFirst[toLowerCase.matches("generate.*certificate.*|generate.*certs.*")]
        return plan
    }

    /**
     * What an apply would do. Shown first, then carried out.
     */
    static class Plan {
        @Accessors String branch
        @Accessors String target
        @Accessors String base
        @Accessors int files
        @Accessors String certificateScript

        def boolean hasCertificateScript() {
            return !certificateScript.nullOrEmpty
        }
    }
}
