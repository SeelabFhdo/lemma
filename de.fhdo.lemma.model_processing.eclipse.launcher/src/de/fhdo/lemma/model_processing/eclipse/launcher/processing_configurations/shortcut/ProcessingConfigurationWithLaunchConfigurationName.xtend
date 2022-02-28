package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.debug.core.DebugPlugin

/**
 * Version of ProcessingConfiguration with name property for launch configurations. Usually, the
 * name of a model processing configuration is determined by the ILaunchConfiguration of which the
 * configuration becomes an attribute. However, for the shortcut, template-based approach to model
 * processing configuration creation and execution, the launch configuration name must be
 * temporarily determinable using a text field that got bound to the name property. This approach
 * allows maintaining all information related to model processing template completion and execution
 * in the form of an ILaunchConfiguration instance within a single context.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProcessingConfigurationWithLaunchConfigurationName extends ProcessingConfiguration
    implements Cloneable {
    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    @Accessors(PUBLIC_GETTER)
    var String launchConfigurationName

    /**
     * Clone the configuration
     */
    override clone() {
        return super.clone()
    }

    /**
     * Set the name of the launch configuration and fire a corresponding property change event
     */
    final def setLaunchConfigurationName(String launchConfigurationName) {
        firePropertyChange("launchConfigurationName", this.launchConfigurationName,
            this.launchConfigurationName = launchConfigurationName)
    }

    /**
     * Validate the model processing configuration in its user representation
     */
    final override validateInUserRepresentation() {
        validateLaunchConfigurationName(launchConfigurationName)
        super.validateInUserRepresentation()
    }

    /**
     * Validate the given launch configuration name
     */
    static def validateLaunchConfigurationName(String launchConfigurationName) {
        notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty")
        if (LAUNCH_MANAGER.isExistingLaunchConfigurationName(launchConfigurationName))
            throw new IllegalArgumentException("Launch configuration already exists")
    }
}