package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.shortcut

import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorPart
import org.eclipse.core.resources.IFile
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.ui.ILaunchShortcut2
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.debug.ui.DebugUITools
import java.util.Map
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.jface.dialogs.MessageDialog
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.ProcessingChain

/**
 * Launch shortcut for model processing chain launch configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchShortcut implements ILaunchShortcut2 {
    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    /**
     * Get the launch configurations associated with a selected file
     */
    final override getLaunchConfigurations(ISelection selection) {
        val file = getSelectedFile(selection)
        return if (file !== null)
                file.launchConfigurations
            else
                null
    }

    /**
     * Get the launch configurations applicable to the given IFile as a mapped resource
     */
    private def getLaunchConfigurations(IFile file) {
        return getLaunchConfigurationsForMappedResource(
            LAUNCH_MANAGER,
            PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE,
            file
        )
    }

    /**
     * Get launchable resource associated with a selected file
     */
    final override getLaunchableResource(ISelection selection) {
        // Null because the shortcut provides specific launch configurations to execute
        return null
    }

    /**
     * Execute the shortcut for the selected file in the given mode
     */
    final override launch(ISelection selection, String mode) {
        getSelectedFile(selection).launch(mode)
    }

    /**
     * Execute the shortcut on the given file in the given mode
     */
    private def launch(IFile file, String mode) {
        if (file === null)
            return

        val dialog = new LaunchConfigurationChainCreationDialog(
            getActiveShell(),
            getModelProcessingLaunchConfigurations(),
            new ProcessingChainWithLaunchConfigurationName(),
            [processingChain, availableLaunchConfigurations |
                storeAndRun(processingChain, availableLaunchConfigurations)],
            [processingChain, availableLaunchConfigurations |
                store(processingChain, availableLaunchConfigurations)]
        )
        dialog.open
    }

    /**
     * Store and run the given the model processing chain
     */
    private def storeAndRun(ProcessingChainWithLaunchConfigurationName completedProcessingChain,
        Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
            DebugUITools.launch(completedProcessingChain.store(availableLaunchConfigurations),
                ILaunchManager.RUN_MODE)
        }

    /**
     * Store the given model processing chain
     */
    private def store(ProcessingChainWithLaunchConfigurationName completedProcessingChain,
        Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
        try {
            completedProcessingChain.validate(availableLaunchConfigurations)
        } catch(IllegalArgumentException ex) {
            MessageDialog.openError(getActiveShell(), "Erroneous processing chain", "Processing " +
                '''chain is erroneous: «ex.message». Execution not possible.''')
            throw ex
        }

        val newLaunchConfigurationWorkingCopy = PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE
            .newInstance(null, completedProcessingChain.launchConfigurationName)
        ProcessingChain.setProcessingChainAsAttribute(newLaunchConfigurationWorkingCopy,
            completedProcessingChain)
        return newLaunchConfigurationWorkingCopy
            .doSave(ILaunchConfiguration.UPDATE_PROTOTYPE_CHILDREN)
    }

    /**
     * Get the launch configurations associated with the currently edited file
     */
    final override getLaunchConfigurations(IEditorPart editor) {
        val file = getEditedFile(editor)
        return if (file !== null)
                file.launchConfigurations
            else
                null
    }

    /**
     * Get launchable resource associated with the currently edited file
     */
    final override getLaunchableResource(IEditorPart editor) {
        return null
    }

    /**
     * Execute the shortcut for the currently edited file in the given mode
     */
    final override launch(IEditorPart editor, String mode) {
        getEditedFile(editor).launch(mode)
    }
}