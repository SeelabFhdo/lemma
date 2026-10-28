package de.fhdo.lemma.servicedsl.smells.refactoring

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A proposal read back from the folder it was written to.
 *
 * The record is the product, so it has to be readable without the session that
 * produced it. Everything a reviewer needs comes from here: what the patch
 * changes, which cause it resolves, and - above all - **which commit it was
 * produced against**, because applying a patch to the wrong base is how two
 * proposals came to be incompatible.
 *
 * Parsed with no JSON or YAML dependency: ``model.txt`` is deliberately flat
 * ``key  value`` lines, so reading it back needs nothing but ``substring``.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class RecordedProposal {
    public static val MODEL_FILE = "model.txt"
    public static val PATCH_FILE = "patch.diff"
    public static val NOTES_FILE = "notes.md"
    public static val VERIFICATION_FILE = "verification.md"

    @Accessors
    val Path folder

    /**
     * Every ``key  value`` line of ``model.txt``, by key.
     */
    @Accessors
    val Map<String, String> values = newLinkedHashMap

    private new(Path folder) {
        this.folder = folder
    }

    /**
     * Read a proposal folder, or null where it is not one.
     *
     * A folder without a patch is not a proposal: a failed run leaves its
     * reason in the record and nothing to apply, and offering it for review
     * would promise something that is not there.
     */
    static def RecordedProposal at(Path folder) {
        if (folder === null || !Files.isDirectory(folder)
            || !Files.exists(folder.resolve(PATCH_FILE))) {
            return null
        }
        val proposal = new RecordedProposal(folder)
        val model = folder.resolve(MODEL_FILE)
        if (Files.exists(model)) {
            for (line : Files.readAllLines(model, StandardCharsets.UTF_8)) {
                // Only the key/value block: a key is one word and the value is
                // separated by at least two spaces, which the prose below the
                // block does not match.
                val separator = line.indexOf("  ")
                if (separator > 0 && !line.startsWith(" ")) {
                    val key = line.substring(0, separator).trim
                    val value = line.substring(separator).trim
                    if (!key.empty && !value.empty && !key.contains(" ")) {
                        if (!proposal.values.containsKey(key)) {
                            proposal.values.put(key, value)
                        }
                    }
                }
            }
        }
        return proposal
    }

    def String getBase() {
        val recorded = values.get("base")
        return if (recorded === null || recorded == "<unrecorded>") null else recorded
    }

    def String getCause() {
        return values.get("label") ?: values.get("cause")
    }

    def String getModel() {
        return values.get("model")
    }

    def String getTarget() {
        return values.get("target")
    }

    def Path getPatch() {
        return folder.resolve(PATCH_FILE)
    }

    /**
     * Whether a verification has been recorded and every gate passed.
     *
     * Absence means "not measured", never "fine": the whole point of the
     * verdict is that a patch nobody measured is a suggestion. True for a
     * partial repair as well, because every gate did pass there - what a
     * partial repair lost is reported by [[isPartialRepair]], and whether that
     * loss is acceptable is the reviewer's to decide, not this method's.
     *
     * The older ``GATES PASSED`` and ``VERIFIED`` spellings are still accepted,
     * because records written before the verdicts were renamed carry them.
     */
    def boolean isVerified() {
        val text = verdictText
        return text.contains("**REPAIR COMPLETE**") || text.contains("REPAIR COMPLETE —")
            || text.contains("**REPAIR PARTIAL**") || text.contains("REPAIR PARTIAL —")
            || text.contains("**GATES PASSED**") || text.contains("GATES PASSED —")
            || text.contains("**VERIFIED**") || text.contains("VERIFIED —")
    }

    /**
     * Whether every gate passed and a peer was nevertheless lost.
     *
     * The distinction the declared-loss rule used to swallow: a patch that
     * breaks the monitoring scrape and declares it read exactly like a patch
     * that broke nothing.
     */
    def boolean isPartialRepair() {
        val text = verdictText
        return text.contains("**REPAIR PARTIAL**") || text.contains("REPAIR PARTIAL —")
    }

    private def String verdictText() {
        val file = folder.resolve(VERIFICATION_FILE)
        if (!Files.exists(file)) {
            return ""
        }
        return new String(Files.readAllBytes(file), StandardCharsets.UTF_8)
    }

    /**
     * The paths the patch would change, read from its ``+++`` headers.
     */
    def List<String> getChangedPaths() {
        return PatchGuard.changedPaths(
            new String(Files.readAllBytes(patch), StandardCharsets.UTF_8))
    }

    override String toString() {
        return '''«cause ?: folder.fileName.toString» («changedPaths.size» file(s), base «
            base ?: "unrecorded"»)'''.toString
    }
}
