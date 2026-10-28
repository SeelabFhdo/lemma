package de.fhdo.lemma.servicedsl.smells.refactoring

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit

/**
 * Proposes a patch by running the ``claude`` command line in a throwaway
 * worktree.
 *
 * Deliberately thin: it spawns a process, collects a diff and reads a few
 * numbers. Every decision - what to ask, what counts as done, how the result is
 * recorded - is elsewhere, which is why this is the one class the headless
 * suite does not cover and why that is acceptable.
 *
 * ## Why a worktree
 *
 * ``git worktree add --detach`` materialises a commit, so the proposer gets a
 * real buildable checkout it may edit freely, the user's working copy is never
 * touched, and the patch is automatically against a clean base. It also removes
 * any need for the source tree to be clean: uncommitted work simply is not
 * there.
 *
 * ## Output format
 *
 * ``--output-format json`` buffers until the process exits, which is fine here
 * and wrong for a UI: a proposal takes ten to twenty-five minutes, so anything
 * that wants to show progress should run ``stream-json`` instead and read
 * events as they arrive.
 *
 * ## Failure
 *
 * A usage limit comes back as ``subtype: "success"`` with ``is_error: true``
 * and no edits, so ``is_error`` is what decides - testing ``subtype`` would
 * file an empty patch as a successful proposal.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ClaudeCliProposer implements RefactoringProposer {
    /**
     * What the proposer may run inside the worktree.
     *
     * Read, search and edit, plus the build so it catches its own compile and
     * configuration errors, plus the tools mutual TLS actually needs: keytool
     * and openssl for key material, and bash and chmod - without those last
     * two a generated script cannot be run or made executable, and a proposal
     * ships a script it never executed.
     */
    static val ALLOWED_TOOLS = "Read,Edit,Write,Grep,Glob,TodoWrite,"
        + "Bash(./mvnw:*),Bash(mvn:*),Bash(keytool:*),Bash(openssl:*),Bash(mkdir:*),"
        + "Bash(chmod:*),Bash(bash:*),Bash(sh:*),Bash(npm:*),Bash(node:*),"
        + "Bash(curl:*),Bash(java:*),Bash(git diff:*),Bash(git status:*),"
        + "Bash(ls:*),Bash(cat:*),Bash(find:*),Bash(grep:*),Bash(sed:*),Bash(cp:*)"

    static val NOTES = "REFACTORING-NOTES.md"

    val String model
    val Path pluginDirectory
    val long timeoutMinutes

    /**
     * @param model the model to run, recorded with every proposal
     * @param pluginDirectory the plugin holding the skill, passed as
     *     ``--plugin-dir``: a repository-root skills folder would not be seen,
     *     because the working directory is a worktree of another project
     * @param timeoutMinutes how long a proposal may take before it is abandoned
     */
    new(String model, Path pluginDirectory, long timeoutMinutes) {
        this.model = model
        this.pluginDirectory = pluginDirectory
        this.timeoutMinutes = timeoutMinutes
    }

    override Proposal propose(RefactoringRequest request) {
        val unmet = Preconditions.unmetReason(request)
        if (unmet !== null) {
            return failed(unmet)
        }

        var Path worktree = null
        try {
            // A previous run that ended some other way than returning - a
            // usage limit, a closed workbench - leaves its worktree
            // registered. Clear those first rather than accumulating them.
            ProposalApplier.releaseStaleWorktrees(request.sourceRoot)
            worktree = addWorktree(request.sourceRoot)
            if (worktree === null) {
                return failed("a throwaway worktree of the source root could not be created")
            }
            val proposal = run(request, worktree)
            if (proposal.failure.nullOrEmpty) {
                proposal.patch = diffOf(worktree)
                proposal.notes = readIfPresent(worktree.resolve(NOTES))
                if (proposal.patch.nullOrEmpty) {
                    proposal.failure = "the proposer changed nothing"
                }
            }
            return proposal
        } catch (Exception exception) {
            return failed('''the proposal failed: «exception.message»'''.toString)
        } finally {
            if (worktree !== null) {
                removeWorktree(request.sourceRoot, worktree)
            }
        }
    }

    /**
     * Run the CLI with the worktree as its working directory.
     */
    private def Proposal run(RefactoringRequest request, Path worktree) {
        val constraints = Files.createTempFile("lemma-constraints", ".md")
        Files.write(constraints, PromptBuilder.constraints.getBytes(StandardCharsets.UTF_8))
        val prompt = Files.createTempFile("lemma-request", ".md")
        Files.write(prompt, PromptBuilder.request(request).getBytes(StandardCharsets.UTF_8))

        try {
            val command = newArrayList(request.cliCommand ?: Preconditions.CLI, "-p",
                "--model", model,
                "--add-dir", worktree.toString,
                "--allowedTools", ALLOWED_TOOLS,
                "--permission-mode", "acceptEdits",
                "--append-system-prompt-file", constraints.toString,
                "--output-format", "json")
            if (pluginDirectory !== null) {
                command.add("--plugin-dir")
                command.add(pluginDirectory.toString)
            }

            val process = new ProcessBuilder(command)
                .directory(worktree.toFile)
                .redirectInput(prompt.toFile)
                .start
            val output = new String(process.inputStream.readAllBytes, StandardCharsets.UTF_8)
            if (!process.waitFor(timeoutMinutes, TimeUnit.MINUTES)) {
                process.destroyForcibly
                return failed('''the proposal did not finish within «timeoutMinutes» minute(s)'''
                    .toString)
            }

            val proposal = new Proposal
            proposal.rawResult = output
            proposal.model = model
            proposal.cliVersion = cliVersion(request.cliCommand)
            readResult(output, proposal)
            return proposal
        } finally {
            Files.deleteIfExists(constraints)
            Files.deleteIfExists(prompt)
        }
    }

    /**
     * Read what the CLI reported.
     *
     * Deliberately string-scanned rather than parsed with a JSON library: this
     * bundle has no JSON dependency, and the fields wanted are flat. A field
     * that cannot be read is left unset rather than guessed - except
     * ``is_error``, whose absence is treated as an error, because a result that
     * does not say is not a result to trust.
     */
    private def void readResult(String output, Proposal proposal) {
        if (output.nullOrEmpty) {
            proposal.failure = "the proposer produced no output"
            return
        }
        proposal.sessionId = output.stringField("session_id")
        proposal.turns = output.numberField("num_turns") as int
        proposal.durationMs = output.numberField("duration_ms") as long
        proposal.costUsd = output.numberField("total_cost_usd")

        if (!output.contains('"is_error":false') && !output.contains('"is_error": false')) {
            // A usage limit arrives here, as does any other refusal. The CLI's
            // own message is the most useful thing to report.
            proposal.failure = output.stringField("result")
                ?: "the proposer reported an error"
        }
    }

    private def String stringField(String json, String name) {
        val marker = '''"«name»":'''
        var index = json.indexOf(marker)
        if (index < 0) {
            return null
        }
        index = json.indexOf("\"", index + marker.length)
        if (index < 0) {
            return null
        }
        val end = json.indexOf("\"", index + 1)
        return if (end < 0) null else json.substring(index + 1, end)
    }

    private def double numberField(String json, String name) {
        val marker = '''"«name»":'''
        val index = json.indexOf(marker)
        if (index < 0) {
            return 0
        }
        val value = new StringBuilder
        var cursor = index + marker.length
        while (cursor < json.length) {
            val character = json.charAt(cursor)
            if (Character.isDigit(character) || character === "." .charAt(0)
                || character === "-".charAt(0)) {
                value.append(character)
                cursor = cursor + 1
            } else if (value.length == 0) {
                cursor = cursor + 1
            } else {
                cursor = json.length
            }
        }
        try {
            return if (value.length == 0) 0 else Double.parseDouble(value.toString)
        } catch (NumberFormatException exception) {
            return 0
        }
    }

    private def Path addWorktree(String sourceRoot) {
        val worktree = Files.createTempDirectory("lemma-refactoring")
        Files.delete(worktree)
        val added = git(sourceRoot, "worktree", "add", "--detach", worktree.toString, "HEAD")
        return if (added) worktree else null
    }

    private def void removeWorktree(String sourceRoot, Path worktree) {
        git(sourceRoot, "worktree", "remove", "--force", worktree.toString)
        git(sourceRoot, "worktree", "prune")
    }

    /**
     * The patch: everything the proposer changed or added, against the commit
     * the worktree was made from.
     *
     * Staged first, so files the proposer created are in the diff - a new
     * script or a new configuration class would otherwise be silently missing
     * from the patch.
     */
    private def String diffOf(Path worktree) {
        git(worktree.toString, "add", "-A")
        val diff = capture(worktree.toFile, "git", "diff", "--cached", "--binary")
        git(worktree.toString, "reset")
        return diff
    }

    private def boolean git(String directory, String... arguments) {
        try {
            val command = newArrayList("git", "-C", directory)
            command.addAll(arguments)
            val process = new ProcessBuilder(command).redirectErrorStream(true).start
            process.inputStream.readAllBytes
            return process.waitFor(2, TimeUnit.MINUTES) && process.exitValue == 0
        } catch (Exception exception) {
            return false
        }
    }

    private def String capture(File directory, String... command) {
        try {
            val process = new ProcessBuilder(command).directory(directory).start
            val output = new String(process.inputStream.readAllBytes, StandardCharsets.UTF_8)
            process.waitFor(2, TimeUnit.MINUTES)
            return output
        } catch (Exception exception) {
            return null
        }
    }

    private def String cliVersion(String command) {
        return capture(null, command ?: Preconditions.CLI, "--version")?.trim
    }

    private def String readIfPresent(Path file) {
        try {
            return if (Files.exists(file))
                new String(Files.readAllBytes(file), StandardCharsets.UTF_8)
            else
                null
        } catch (Exception exception) {
            return null
        }
    }

    private def Proposal failed(String reason) {
        val proposal = new Proposal
        proposal.failure = reason
        return proposal
    }
}
