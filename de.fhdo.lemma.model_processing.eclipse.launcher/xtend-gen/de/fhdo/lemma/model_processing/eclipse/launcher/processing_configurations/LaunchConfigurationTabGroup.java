package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * Group of the launch configuration tab for model processing configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
  /**
   * Create the group tabs
   */
  @Override
  public final void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
    LaunchConfigurationTab _launchConfigurationTab = new LaunchConfigurationTab();
    this.setTabs(new ILaunchConfigurationTab[] { _launchConfigurationTab });
  }
}
