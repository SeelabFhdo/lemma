package de.fhdo.lemma.servicedsl.smells.refactoring

import java.io.File
import java.util.concurrent.TimeUnit

/**
 * What has to hold before a proposal is attempted.
 *
 * Checked before anything is spawned, so a failure changes nothing and says
 * which condition did not hold. A refactoring tool that half-applies is worse
 * than one that declines.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Preconditions {
    public static val CLI = "claude"

    /**
     * Why a proposal cannot be attempted, or null when it can.
     *
     * The message names the condition and, where there is one, the command to
     * run by hand instead.
     */
    static def String unmetReason(RefactoringRequest request) {
        if (request === null || !request.valid) {
            return "the finding carries no root cause this can act on"
        }

        val root = new File(request.sourceRoot)
        if (!root.isDirectory) {
            return '''The configured source root does not exist: «request.sourceRoot».
Set it to the checked-out system the models were reconstructed from.'''.toString
        }
        if (!new File(root, ".git").exists) {
            return '''The source root is not a git checkout: «request.sourceRoot».
A proposal is produced in a throwaway worktree of it, so it has to be one.'''
                .toString
        }
        val command = request.cliCommand ?: CLI
        if (!command.available) {
            return '''Cannot run "«command»".

If it is installed, this is almost certainly a PATH problem rather than a
missing tool: a bare name is resolved against the PATH of the process that
spawns it, and a desktop application does not inherit your shell PATH. On
macOS an Eclipse started from the Dock sees only /etc/paths, so a tool under
/opt/homebrew/bin is invisible to it.

Either give the absolute path in the preferences, or start Eclipse from a
terminal so it inherits your PATH.'''.toString
        }
        return null
    }

    /**
     * Whether the CLI can be run at all.
     *
     * ``--version`` rather than a real call: it is cheap and needs no network.
     *
     * It says nothing about **authentication**, which is why the message this
     * feeds no longer claims otherwise. An unauthenticated CLI reports its
     * version perfectly well and then refuses the proposal, which arrives here
     * as a run that produced no patch.
     */
    static def boolean isAvailable(String command) {
        try {
            val process = new ProcessBuilder(command, "--version")
                .redirectErrorStream(true)
                .start
            if (!process.waitFor(20, TimeUnit.SECONDS)) {
                process.destroyForcibly
                return false
            }
            return process.exitValue == 0
        } catch (Exception exception) {
            // Not on the PATH, or not executable.
            return false
        }
    }
}
