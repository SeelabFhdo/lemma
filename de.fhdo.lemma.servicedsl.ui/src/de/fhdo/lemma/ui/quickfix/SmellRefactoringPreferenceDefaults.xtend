package de.fhdo.lemma.ui.quickfix

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import org.eclipse.core.runtime.preferences.DefaultScope

/**
 * The defaults the preference page starts from.
 *
 * Deliberately no default for the source root: there is no sensible guess, and
 * a wrong one would send a proposal at the wrong checkout. It stays empty, the
 * quickfix refuses, and the message says where to set it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellRefactoringPreferenceDefaults extends AbstractPreferenceInitializer {
    override initializeDefaultPreferences() {
        val node = DefaultScope.INSTANCE.getNode(SmellRefactoringPreferences.NODE)
        node.put(SmellRefactoringPreferences.CLI_COMMAND,
            SmellRefactoringPreferences.DEFAULT_CLI_COMMAND)
        node.put(SmellRefactoringPreferences.MODEL,
            SmellRefactoringPreferences.DEFAULT_MODEL)
        node.putInt(SmellRefactoringPreferences.TIMEOUT_MINUTES,
            SmellRefactoringPreferences.DEFAULT_TIMEOUT_MINUTES)
    }
}
