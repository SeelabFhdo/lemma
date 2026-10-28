package de.fhdo.lemma.ui.quickfix

import org.eclipse.jface.preference.DirectoryFieldEditor
import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.jface.preference.IntegerFieldEditor
import org.eclipse.jface.preference.StringFieldEditor
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Label
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.ui.preferences.ScopedPreferenceStore
import org.eclipse.core.runtime.preferences.InstanceScope

/**
 * Where the security-smell refactoring is configured.
 *
 * **Window → Preferences → ServiceDsl → Security Smell Refactoring.**
 *
 * One setting here is not a convenience: a reconstructed model carries no
 * source paths, because those are absolute and a generated model has to be
 * identical on every machine to be diffable. So the toolchain cannot know
 * *which checkout* a model was reconstructed from, and a refactoring has
 * nowhere to act until somebody says. The quickfix refuses rather than guess,
 * and sends the reader here.
 *
 * Writes into the same instance-scope node [[SmellRefactoringPreferences]]
 * reads, so the page and the code cannot disagree about where a value lives.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellRefactoringPreferencePage extends FieldEditorPreferencePage
    implements IWorkbenchPreferencePage {

    public static val ID = "de.fhdo.lemma.ServiceDsl.smellRefactoring"

    new() {
        super(FieldEditorPreferencePage.GRID)
    }

    override init(IWorkbench workbench) {
        preferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE,
            SmellRefactoringPreferences.NODE)
        description = "How a proposal to resolve a security smell is produced."
    }

    override protected createFieldEditors() {
        // Concatenated rather than a template with .stripIndent: that method
        // is Java 12 and this bundle declares JavaSE-11.
        explain("A proposal is written by an AI in a throwaway copy of the system and is "
            + "applied nowhere. Review it, then verify it by re-running the reconstruction "
            + "and the detection - a patch is not evidence that the smell is resolved.")

        // Required, and the reason the page exists: a model carries no source
        // paths, so this cannot be inferred from anything.
        val sourceRoot = new DirectoryFieldEditor(SmellRefactoringPreferences.SOURCE_ROOT,
            "&Source root of the reconstructed system:", fieldEditorParent)
        sourceRoot.emptyStringAllowed = false
        addField(sourceRoot)
        explain("The git checkout the open models were reconstructed from. Required: "
            + "a proposal is produced in a worktree of it, and your copy is never written to.")

        addField(new StringFieldEditor(SmellRefactoringPreferences.MODEL,
            "&Model:", fieldEditorParent))
        explain("Recorded with every proposal, so a result can be attributed to a model "
            + "rather than to whatever the command line happened to default to.")

        val timeout = new IntegerFieldEditor(SmellRefactoringPreferences.TIMEOUT_MINUTES,
            "&Give up after (minutes):", fieldEditorParent)
        timeout.setValidRange(1, 240)
        addField(timeout)
        explain("A proposal took 13 and 25 minutes in the two runs this was built from.")

        val recordRoot = new DirectoryFieldEditor(SmellRefactoringPreferences.RECORD_ROOT,
            "&Keep proposals in:", fieldEditorParent)
        recordRoot.emptyStringAllowed = true
        addField(recordRoot)
        explain("Each proposal is kept as a folder: the prompt, the skill that produced it, "
            + "the patch, the model and the cost. Left empty, it goes beside the source root.")

        addField(new StringFieldEditor(SmellRefactoringPreferences.CLI_COMMAND,
            "&Command line:", fieldEditorParent))
        explain("Give the ABSOLUTE PATH if Eclipse reports it cannot run this. A bare name is "
            + "resolved against the PATH of the process that spawns it, and Eclipse does not "
            + "inherit your shell PATH: on macOS one started from the Dock sees only "
            + "/etc/paths, so a tool under /opt/homebrew/bin is invisible to it. Find it with "
            + "'which claude' in a terminal.")

        explain("The command line also has to be authenticated. On macOS "
            + "an Eclipse started from the Dock does not inherit your shell PATH, so a CLI "
            + "under /opt/homebrew/bin is invisible to it - start Eclipse from a terminal, "
            + "or the quickfix will report the command line as missing.")
    }

    /**
     * A wrapped paragraph between the fields.
     *
     * The grid layout a field editor page builds is two columns wide, so a
     * label has to say so or it sits in the first column and wraps at nothing.
     */
    private def void explain(String text) {
        val label = new Label(fieldEditorParent, SWT.WRAP)
        label.text = text
        val data = new GridData(SWT.FILL, SWT.BEGINNING, true, false)
        data.horizontalSpan = 3
        data.widthHint = 520
        data.verticalIndent = 4
        label.layoutData = data
    }
}
