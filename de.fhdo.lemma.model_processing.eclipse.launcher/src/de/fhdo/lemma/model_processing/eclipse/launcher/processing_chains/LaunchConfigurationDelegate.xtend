package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import org.eclipse.debug.core.model.ILaunchConfigurationDelegate
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunch
import org.eclipse.core.runtime.IProgressMonitor
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.CoreException

/**
 * Delegate for launching model processing chain configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
    /**
     * Launch a model processing chain configuration
     */
    final override launch(ILaunchConfiguration launchConfiguration, String mode, ILaunch launch,
        IProgressMonitor monitor) {
        // Deserialize the model processing chain
        val chain = ProcessingChain.deserializeFrom(launchConfiguration)
        if (chain === null)
            throw new CoreException(new Status(IStatus.ERROR, LaunchConfigurationDelegate,
                "LEMMA model processing chain not readable. Launch aborted."))

        // Validate the chain. Note that we pass all available model processing configurations to
        // ProcessingChain.validate() which will then check the correctness of the configurations
        // w.r.t. their involvement in the chain.
        val processingLaunchConfigurations = getModelProcessingLaunchConfigurations()
        try {
            chain.validate(processingLaunchConfigurations)
        } catch (IllegalArgumentException ex) {
            throw new CoreException(new Status(IStatus.ERROR, LaunchConfigurationDelegate,
                "Invalid LEMMA model processing chain:\n" + ex.message + "\n\nLaunch aborted."))
        }

        // Execute the chain configuration
        new ProcessingChainLaunchesExecutor(launchConfiguration.name, chain,
            processingLaunchConfigurations, monitor).start()
    }
}