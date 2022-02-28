package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog

/**
 * Group of the launch configuration tab for model processing configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
    /**
     * Create the group tabs
     */
    final override createTabs(ILaunchConfigurationDialog dialog, String mode) {
        setTabs(#[new LaunchConfigurationTab])
    }
}