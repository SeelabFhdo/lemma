package de.fhdo.lemma.ui.quickfix

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.core.runtime.preferences.InstanceScope

/**
 * Where the quickfix gets what the model cannot tell it.
 *
 * A reconstructed model carries no source paths - they are absolute, and a
 * generated model has to be identical on every machine to be diffable. So the
 * one thing a refactoring needs above all, *which checkout this model was
 * reconstructed from*, has to be configured.
 *
 * Plain preferences rather than a page, for now: the quickfix refuses with the
 * key to set when the source root is missing, which is more useful than a page
 * nobody has opened.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellRefactoringPreferences {
    public static val NODE = "de.fhdo.lemma.servicedsl.ui"

    public static val SOURCE_ROOT = "smellRefactoring.sourceRoot"
    public static val MODEL = "smellRefactoring.model"
    public static val RECORD_ROOT = "smellRefactoring.recordRoot"
    public static val TIMEOUT_MINUTES = "smellRefactoring.timeoutMinutes"
    public static val CLI_COMMAND = "smellRefactoring.cliCommand"

    /**
     * A bare name, which only works where the spawning process has the tool on
     * its PATH. Eclipse often does not - see the preference page.
     */
    public static val DEFAULT_CLI_COMMAND = "claude"

    /**
     * Pinned, and recorded with every proposal, so a result can be attributed
     * to a model rather than to whatever the CLI defaulted to that week.
     */
    public static val DEFAULT_MODEL = "claude-opus-5"

    /**
     * A proposal took 13 and 25 minutes in the two runs this was built from,
     * so the default has room without waiting forever on a wedged one.
     */
    public static val DEFAULT_TIMEOUT_MINUTES = 45

    static def String sourceRoot() {
        return get(SOURCE_ROOT, null)
    }

    static def String cliCommand() {
        return get(CLI_COMMAND, DEFAULT_CLI_COMMAND)
    }

    static def String model() {
        return get(MODEL, DEFAULT_MODEL)
    }

    static def long timeoutMinutes() {
        try {
            return Long.parseLong(get(TIMEOUT_MINUTES, DEFAULT_TIMEOUT_MINUTES.toString))
        } catch (NumberFormatException exception) {
            return DEFAULT_TIMEOUT_MINUTES
        }
    }

    /**
     * Where proposals are recorded. Defaults beside the source root, so a
     * record is never written somewhere the user has to go looking for.
     */
    static def Path recordRoot() {
        val configured = get(RECORD_ROOT, null)
        if (!configured.nullOrEmpty) {
            return Paths.get(configured)
        }
        val root = sourceRoot
        if (root.nullOrEmpty) {
            return null
        }
        return Paths.get(root).parent?.resolve("lemma-refactorings")
            ?: Paths.get(root).resolve("lemma-refactorings")
    }

    /**
     * The plugin directory holding the skill, inside the installed smells
     * bundle.
     *
     * Located from the bundle rather than configured: it ships with the code
     * that runs it, so a user should never have to point at it. Null when it
     * cannot be found, which the quickfix reports rather than guessing.
     */
    static def Path skillPluginDirectory() {
        try {
            val bundle = org.eclipse.core.runtime.Platform.getBundle(
                "de.fhdo.lemma.servicedsl.smells")
            if (bundle === null) {
                return null
            }
            val url = org.eclipse.core.runtime.FileLocator.toFileURL(
                bundle.getEntry("refactoring-plugin"))
            if (url === null) {
                return null
            }
            val directory = new File(url.path)
            return if (directory.isDirectory) directory.toPath else null
        } catch (Exception exception) {
            // Not running in an OSGi platform, or the folder is not packaged.
            return null
        }
    }

    private static def String get(String key, String fallback) {
        val value = InstanceScope.INSTANCE.getNode(NODE).get(key, fallback)
        return if (value.nullOrEmpty) fallback else value
    }
}
