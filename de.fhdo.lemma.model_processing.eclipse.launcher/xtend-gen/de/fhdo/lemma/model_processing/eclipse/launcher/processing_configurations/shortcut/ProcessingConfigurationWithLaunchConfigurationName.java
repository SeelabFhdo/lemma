package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

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
@SuppressWarnings("all")
public final class ProcessingConfigurationWithLaunchConfigurationName extends ProcessingConfiguration implements Cloneable {
  private static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();

  @Accessors(AccessorType.PUBLIC_GETTER)
  private String launchConfigurationName;

  /**
   * Clone the configuration
   */
  @Override
  public Object clone() {
    return super.clone();
  }

  /**
   * Set the name of the launch configuration and fire a corresponding property change event
   */
  public final void setLaunchConfigurationName(final String launchConfigurationName) {
    this.firePropertyChange("launchConfigurationName", this.launchConfigurationName, 
      this.launchConfigurationName = launchConfigurationName);
  }

  /**
   * Validate the model processing configuration in its user representation
   */
  @Override
  public final void validateInUserRepresentation() {
    ProcessingConfigurationWithLaunchConfigurationName.validateLaunchConfigurationName(this.launchConfigurationName);
    super.validateInUserRepresentation();
  }

  /**
   * Validate the given launch configuration name
   */
  public static void validateLaunchConfigurationName(final String launchConfigurationName) {
    try {
      Utils.notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty");
      boolean _isExistingLaunchConfigurationName = ProcessingConfigurationWithLaunchConfigurationName.LAUNCH_MANAGER.isExistingLaunchConfigurationName(launchConfigurationName);
      if (_isExistingLaunchConfigurationName) {
        throw new IllegalArgumentException("Launch configuration already exists");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Pure
  public String getLaunchConfigurationName() {
    return this.launchConfigurationName;
  }
}
