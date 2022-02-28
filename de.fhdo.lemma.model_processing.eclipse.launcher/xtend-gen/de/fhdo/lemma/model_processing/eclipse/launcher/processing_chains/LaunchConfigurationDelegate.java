package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Delegate for launching model processing chain configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
  /**
   * Launch a model processing chain configuration
   */
  @Override
  public final void launch(final ILaunchConfiguration launchConfiguration, final String mode, final ILaunch launch, final IProgressMonitor monitor) {
    try {
      final ProcessingChain chain = ProcessingChain.deserializeFrom(launchConfiguration);
      if ((chain == null)) {
        Status _status = new Status(IStatus.ERROR, LaunchConfigurationDelegate.class, 
          "LEMMA model processing chain not readable. Launch aborted.");
        throw new CoreException(_status);
      }
      final Map<String, ILaunchConfiguration> processingLaunchConfigurations = Utils.getModelProcessingLaunchConfigurations();
      try {
        chain.validate(processingLaunchConfigurations);
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException ex = (IllegalArgumentException)_t;
          String _message = ex.getMessage();
          String _plus = ("Invalid LEMMA model processing chain:\n" + _message);
          String _plus_1 = (_plus + "\n\nLaunch aborted.");
          Status _status_1 = new Status(IStatus.ERROR, LaunchConfigurationDelegate.class, _plus_1);
          throw new CoreException(_status_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      String _name = launchConfiguration.getName();
      new ProcessingChainLaunchesExecutor(_name, chain, processingLaunchConfigurations, monitor).start();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
