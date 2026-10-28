package de.fhdo.lemma.servicedsl.smells.refactoring

import de.fhdo.lemma.servicedsl.smells.Finding
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * One refactoring to propose: a root cause, and the findings it explains.
 *
 * A cause rather than a finding, because that is the unit a refactoring acts
 * on - mutual TLS has to be applied to both ends of every channel a cause
 * covers at once, and Lakeside Mutual's nine findings come from two causes.
 *
 * Plain data. What turns it into instructions is [[PromptBuilder]]; what acts
 * on it is a [[RefactoringProposer]]. Keeping the three apart is what lets the
 * first two be tested without an AI.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class RefactoringRequest {
    /**
     * The root cause's key, as ``RootCause`` forms it.
     */
    @Accessors
    String rootCauseId

    /**
     * How the cause reads in a sentence: "the connectors of CustomerCore".
     */
    @Accessors
    String rootCauseLabel

    /**
     * Every finding this cause explains. Never empty - a request without a
     * finding has nothing to resolve.
     */
    @Accessors
    val List<Finding> findings = newLinkedList

    /**
     * The checked-out system the patch is for. The proposer works in a
     * throwaway worktree of it and never writes here.
     */
    @Accessors
    String sourceRoot

    /**
     * The skill that carries the procedure, qualified as the CLI resolves it -
     * for example ``lemma-smell-refactoring:resolve-non-secured-communication``.
     */
    @Accessors
    String skill

    /**
     * What the other causes of the same system are, so the request can tell
     * the proposer what is deliberately out of its scope. A patch that also
     * fixed the broker while asked about a connector would be unreviewable.
     */
    @Accessors
    val List<String> otherCauses = newLinkedList

    /**
     * How to run the command line, as a path or a bare name.
     *
     * Configurable because a bare name is resolved against the PATH of the
     * process that spawns it, and a desktop application's PATH is not the
     * user's shell PATH - on macOS an Eclipse started from the Dock gets
     * /etc/paths only, so a tool installed under /opt/homebrew/bin is
     * invisible to it. An absolute path sidesteps the whole question.
     */
    @Accessors
    String cliCommand = "claude"

    /**
     * The commit the patch is produced against.
     *
     * Recorded rather than inferred afterwards. Reading it back from the
     * target's git state later only answers "does this still apply"; it cannot
     * say *which commit the patch was for*, which is the thing a reader needs
     * when it does not. Two proposals generated against the same commit do not
     * compose, so getting this wrong is not a detail.
     */
    @Accessors
    String base

    def boolean isValid() {
        return !findings.empty && !rootCauseId.nullOrEmpty && !sourceRoot.nullOrEmpty
    }
}
