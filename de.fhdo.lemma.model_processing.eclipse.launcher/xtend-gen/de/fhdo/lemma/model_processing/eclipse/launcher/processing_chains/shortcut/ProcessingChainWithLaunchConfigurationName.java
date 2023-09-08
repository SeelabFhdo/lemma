package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.shortcut;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.ProcessingChain;
import java.util.Map;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Version of the domain concept for model processing chains that includes the name of the launch
 * configuration for which a processing chain shall be created using the launch shortcut.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ProcessingChainWithLaunchConfigurationName extends ProcessingChain implements Cloneable {
  private static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();

  @Accessors(AccessorType.PUBLIC_GETTER)
  private String launchConfigurationName;

  /**
   * Clone the chain including the launch configuration name
   */
  @Override
  public final Object clone() {
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
   * Validate the chain including the launch configuration name
   */
  @Override
  public final void validate(final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    super.validate(availableLaunchConfigurations);
    ProcessingChainWithLaunchConfigurationName.validateLaunchConfigurationName(this.launchConfigurationName);
  }

  /**
   * Validate the launch configuration name
   */
  public static void validateLaunchConfigurationName(final String launchConfigurationName) {
    try {
      Utils.notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty");
      boolean _isExistingLaunchConfigurationName = ProcessingChainWithLaunchConfigurationName.LAUNCH_MANAGER.isExistingLaunchConfigurationName(launchConfigurationName);
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
