package de.fhdo.lemma.servicedsl.smells.refactoring

import java.util.List

/**
 * Checks a patch against the constraints that must hold, before it is recorded
 * or shown to anybody.
 *
 * The constraints are stated in the prompt, but a prompt is instruction and not
 * enforcement: a proposer may ignore it, so what it produces is checked rather
 * than trusted. This is the mechanical half of that - the rest is the
 * verification step, which re-reconstructs and re-detects.
 *
 * Reads the diff as text. That is enough for what has to be caught here and it
 * needs nothing applied anywhere, which matters because a patch is rejected
 * before anything acts on it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class PatchGuard {
    /**
     * Model files are reconstructed output. A patch that edits one would make
     * the model contradict the system it describes - and the next
     * reconstruction would truncate the edit anyway.
     */
    static val FORBIDDEN_EXTENSIONS = #[".services", ".data", ".operation"]

    /**
     * Each of these makes a connection succeed while verifying nothing, so it
     * trades this smell for a different one.
     */
    static val WEAKENINGS = #{
        "TrustAllStrategy" -> "trusts every certificate",
        "NoopHostnameVerifier" -> "verifies no hostname",
        "InsecureTrustManagerFactory" -> "disables trust management",
        "setEndpointIdentificationAlgorithm(null)" -> "disables hostname verification"
    }

    /**
     * Everything wrong with a patch, or an empty list.
     *
     * All of them rather than the first, so one run tells the whole story.
     */
    static def List<String> violations(String patch) {
        val found = <String>newLinkedList
        if (patch.nullOrEmpty) {
            found.add("the patch is empty")
            return found
        }

        for (path : patch.changedPaths) {
            if (FORBIDDEN_EXTENSIONS.exists[path.endsWith(it)]) {
                found.add('''the patch edits «path», which is reconstructed output'''.toString)
            }
        }

        for (weakening : WEAKENINGS.entrySet) {
            if (patch.addsLineContaining(weakening.key)) {
                found.add('''the patch adds «weakening.key», which «weakening.value»'''.toString)
            }
        }
        // Spelt out rather than put in the map: it is the only one whose text
        // varies by whitespace, and in JavaScript rather than Java.
        if (patch.addsRejectUnauthorizedFalse) {
            found.add("the patch adds rejectUnauthorized:false, which accepts any certificate")
        }
        return found
    }

    /**
     * The paths a diff touches, read from its ``+++`` headers.
     */
    static def List<String> changedPaths(String patch) {
        val paths = <String>newLinkedList
        for (line : patch.split("\n")) {
            if (line.startsWith("+++ ") && !line.startsWith("+++ /dev/null")) {
                var path = line.substring(4).trim
                if (path.startsWith("b/")) {
                    path = path.substring(2)
                }
                paths.add(path)
            }
        }
        return paths
    }

    /**
     * Files whose added lines are prose, not instructions to a machine.
     *
     * A proposal is asked to write down what it did and what it deliberately
     * avoided, so its notes legitimately contain the names of the things it
     * must not do. Scanning them for those names rejects a patch for being
     * honest - which is exactly what happened to the first proposal that
     * documented its own constraints.
     */
    static val PROSE_SUFFIXES = #[".md", ".markdown", ".txt", ".adoc", ".rst"]

    /**
     * Whether the patch *adds* a line of code holding this text.
     *
     * Added lines only: a patch that removes an existing weakening, or merely
     * shows one as context, is not introducing it - and a guard that cannot
     * tell the difference would block the very patches worth having.
     *
     * Code only, for the same reason: see [[PROSE_SUFFIXES]].
     */
    private static def boolean addsLineContaining(String patch, String text) {
        return patch.addedCodeLines.exists[contains(text)]
    }

    private static def boolean addsRejectUnauthorizedFalse(String patch) {
        return patch.addedCodeLines.exists[
            replaceAll("\\s", "").contains("rejectUnauthorized:false")
        ]
    }

    /**
     * Every added line of the diff that belongs to a file holding code.
     *
     * The ``+++`` headers are what says which file the following lines are in,
     * so the scan has to walk the diff in order rather than filter it.
     */
    private static def List<String> addedCodeLines(String patch) {
        val lines = <String>newLinkedList
        var prose = false
        for (line : patch.split("\n")) {
            if (line.startsWith("+++ ")) {
                val path = line.substring(4).trim
                prose = PROSE_SUFFIXES.exists[path.toLowerCase.endsWith(it)]
            } else if (line.startsWith("+") && !prose) {
                lines.add(line)
            }
        }
        return lines
    }
}
