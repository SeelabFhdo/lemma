package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.shortcut

import org.eclipse.xtend.lib.annotations.Accessors
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.debug.core.ILaunchConfiguration
import java.util.Map
import org.eclipse.debug.core.DebugPlugin
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.ProcessingChain

/**
 * Version of the domain concept for model processing chains that includes the name of the launch
 * configuration for which a processing chain shall be created using the launch shortcut.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProcessingChainWithLaunchConfigurationName extends ProcessingChain
    implements Cloneable {
    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    @Accessors(PUBLIC_GETTER)
    var String launchConfigurationName

    /**
     * Clone the chain including the launch configuration name
     */
    final override clone() {
        super.clone
    }

    /**
     * Set the name of the launch configuration and fire a corresponding property change event
     */
    final def setLaunchConfigurationName(String launchConfigurationName) {
        firePropertyChange("launchConfigurationName", this.launchConfigurationName,
            this.launchConfigurationName = launchConfigurationName)
    }

    /**
     * Validate the chain including the launch configuration name
     */
    final override validate(Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
        super.validate(availableLaunchConfigurations)
        validateLaunchConfigurationName(launchConfigurationName)
    }

    /**
     * Validate the launch configuration name
     */
    static def validateLaunchConfigurationName(String launchConfigurationName) {
        notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty")
        if (LAUNCH_MANAGER.isExistingLaunchConfigurationName(launchConfigurationName))
            throw new IllegalArgumentException("Launch configuration already exists")
    }
}