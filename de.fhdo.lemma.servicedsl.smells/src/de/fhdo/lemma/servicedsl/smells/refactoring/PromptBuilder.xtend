package de.fhdo.lemma.servicedsl.smells.refactoring

import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict

/**
 * Turns a [[RefactoringRequest]] into the two texts a proposer is given.
 *
 * Three layers instruct the proposer, and only one of them is built here:
 *
 * | Layer | Where it lives | Varies |
 * |---|---|---|
 * | Invariant constraints | ``constraints`` below, a system-prompt appendix | never |
 * | The refactoring procedure | the skill, versioned in this bundle | per smell |
 * | The finding | ``request`` below | every call |
 *
 * The split matters because a skill is instruction and not enforcement: a
 * proposer may ignore it. So nothing load-bearing is stated only in the skill -
 * the constraints repeat what must hold, and the verification step settles it.
 *
 * Deterministic: the same request yields the same text, byte for byte. That is
 * what makes the prompt recordable and this class testable.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class PromptBuilder {
    /**
     * The invariant constraints, as a system-prompt appendix.
     *
     * Every one of these was earned. Application-level only, because the
     * verifying toolchain does not read manifests and a mesh change could not
     * be shown to work. Both ends, because a server with TLS and clients
     * without is a broken system. No model edits, because a model is
     * reconstructed output. And no weakened verification, because that trades
     * one smell for another.
     */
    static def String constraints() {
        return '''
        You are resolving a security smell in a microservice system, inside a
        throwaway git worktree. Hard constraints, which override anything else:

        - Change application-level configuration and code only. Never Kubernetes
          manifests, never a service mesh: the verifying toolchain does not read
          manifests, so a mesh change cannot be shown to work.
        - Change BOTH ends of every channel. A server with TLS and clients still
          on plaintext is a broken system, not a refactored one.
        - Never edit a .services, .data or .operation file. They are
          reconstructed output, not input.
        - Never weaken verification to make a connection succeed. No
          TrustAllStrategy, no NoopHostnameVerifier, no
          InsecureTrustManagerFactory, no rejectUnauthorized:false.
        - Never disable a test or weaken an assertion. Updating a test's
          configuration so it addresses the new transport is allowed and
          expected. If you change what transport a test exercises, say so in
          REFACTORING-NOTES.md and say what coverage is lost: a fixture moved
          off the network still builds and still asserts, so no gate can see
          the difference.
        - The test suite must still pass on a CLEAN CHECKOUT of your patch, with
          no generated key material present. You cannot see this from inside
          this worktree, because the material is already here.
        - Commit no generated key material. Commit the script that generates it
          and add the output to .gitignore.
        - Stay inside this worktree.

        Work autonomously. Do not ask questions; make the reasonable choice and
        record it in REFACTORING-NOTES.md at the repository root, listing what
        you changed, what you assumed, and anything you could not verify.
        '''.toString
    }

    /**
     * The request itself: this cause, its findings, and what is out of scope.
     */
    static def String request(RefactoringRequest request) {
        val first = request.findings.head
        return '''
        Use the skill «request.skill».

        ## Finding

        Security smell: «ChannelVerdict.SMELL» («ChannelVerdict.REFERENCE»).

        «request.findings.size» finding(s) of this system share one cause:
        **«request.rootCauseLabel»**. Resolve the cause, which means changing
        every end of every channel below.

        ## The facts, as the reconstructed LEMMA models state them

        «FOR finding : request.findings»
        **«finding.caller» -> «finding.callee»** («finding.channel»)
        «IF !finding.reason.nullOrEmpty»
        Judged: «finding.reason»
        «ENDIF»
        «FOR item : finding.evidence»
            «item»
        «ENDFOR»

        «ENDFOR»
        The models carry no file paths by design. Locate the code yourself.

        ## Scope

        This cause only: «request.rootCauseLabel».
        «IF !request.otherCauses.empty»

        Do NOT touch the following, which are separate causes handled by their
        own proposals:
        «FOR other : request.otherCauses»
        - «other»
        «ENDFOR»
        «ENDIF»

        ## Done when

        - the refactoring «ChannelVerdict.REFACTORING» is in place at both ends
          of every channel above
        - every affected service still compiles
        - the test suite still passes on a clean checkout of your patch
        «IF first !== null && !first.refactoring.nullOrEmpty»

        The literature's refactoring for this smell is: «first.refactoring».
        «ENDIF»
        '''.toString
    }
}
