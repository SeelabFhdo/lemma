package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import java.util.UUID
import org.eclipse.debug.core.ILaunchesListener2
import org.eclipse.debug.core.ILaunch
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.debug.core.ILaunchConfiguration
import java.util.Map
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.core.runtime.IProgressMonitor
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import static de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.LaunchConfigurationDelegate.*
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.MessageConsoleStream

/**
 * Executor for model processing chain launch configurations. The executor is initialized by the
 * chain to be executed. The invocation of the Thread's run() method triggers the execution of the
 * first model processing configuration in the chain. Since the executor is also an
 * ILaunchesListener, the termination of the current configuration's execution results in the
 * invocation of the launchesTerminated() callback, which will then trigger the execution of the
 * next configuration in the chain.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProcessingChainLaunchesExecutor extends Thread implements ILaunchesListener2 {
    static val LAUNCHES_IDENTIFIER_ATTRIBUTE_NAME = "lemma" +
        typeof(ProcessingChainLaunchesExecutor).name + "LaunchesIdentifier"

    val String chainName
    val ProcessingChain chain
    val Map<String, ILaunchConfiguration> processingLaunchConfigurations
    val IProgressMonitor monitor
    val String launchesIdentifier
    var int currentEntryIndex
    var MessageConsole console
    var MessageConsoleStream infoStream

    /**
     * Constructor
     */
    new(
        String chainName,
        ProcessingChain chain,
        Map<String, ILaunchConfiguration> processingLaunchConfigurations,
        IProgressMonitor monitor
    ) {
        this.chainName = chainName
        this.chain = chain
        this.processingLaunchConfigurations = processingLaunchConfigurations
        this.monitor = monitor
        launchesIdentifier = UUID.randomUUID.toString
    }

    /**
     * Run the Thread
     */
    final override void run() {
        LAUNCH_MANAGER.addLaunchListener(this)
        currentEntryIndex = 0
        console = getAndRevealConsole(CONSOLE_NAME)
        infoStream = console.newMessageStream

        // There must be at least one entry in the chain as otherwise it wouldn't be valid and thus
        // not executable
        chain.launch(currentEntryIndex)
    }

    /**
     * Launch the model processing configuration at the given index in the given chain
     */
    private def launch(ProcessingChain chain, int entryIndex) {
        console.clearConsole
        infoStream.println('''Executing LEMMA model processing chain "«chainName»": Entry ''' +
            '''«entryIndex+1» of «chain.entries.size»''' + "\n")

        val launchConfigurationName = chain.entries.get(entryIndex).launchConfigurationName
        val processingLaunchConfiguration = processingLaunchConfigurations
            .get(launchConfigurationName)
            .getWorkingCopy

        // Disable console clearing during the execution of a model processing chain so that the
        // execution of each step in the chain remains comprehensible by the user. Since the
        // execution of the model processing launch configuration of the current chain step is in
        // the responsibility of the delegate for model processing launch configurations (cf. class
        // LaunchConfigurationDelegate), we leverage a temporary attribute in the working copy of
        // the current model processing launch configuration to inform the delegate to not clear the
        // console as it would usually.
        processingLaunchConfiguration.setAttribute(DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE, true)

        val launch = DebugUITools.buildAndLaunch(
            processingLaunchConfiguration,
            ILaunchManager.RUN_MODE,
            SubMonitor.convert(monitor, 1)
        )
        launch.setAttribute(LAUNCHES_IDENTIFIER_ATTRIBUTE_NAME, launchesIdentifier)
    }

    /**
     * Callback for the termination of launches
     */
    final override launchesTerminated(ILaunch[] launches) {
        val matchingLaunches = launches.filter[
            it.getAttribute(LAUNCHES_IDENTIFIER_ATTRIBUTE_NAME) == launchesIdentifier
        ]

        if (matchingLaunches.empty)
            return
        else if (matchingLaunches.size > 1) {
            terminateChainExecution()
            throw new IllegalStateException("There should be only one launch for an entry in a " +
                '''LEMMA model processing chain with launches identifier «launchesIdentifier»''')
        }

        val currentLaunch = matchingLaunches.get(0)
        if (!executeNextChainEntry(currentLaunch)) {
            terminateChainExecution()
            return
        }

        monitor.worked(1)
        currentEntryIndex++
        chain.launch(currentEntryIndex)
    }

    /**
     * Check if the next entry in the chain shall be executed based on the executor's state and the
     * outcome of the given ILaunch
     */
    private def executeNextChainEntry(ILaunch launch) {
        /* Check for cancelation by user or whether this was the last launch for the chain */
        val lastEntryIndex = chain.entries.size - 1
        if (monitor.canceled || currentEntryIndex == lastEntryIndex)
            return false

        /* Check for expected exit value */
        // The launch configuration delegate for LEMMA model processing configurations always
        // associates exactly one process to fired launches
        val nextEntry = chain.entries.get(currentEntryIndex+1)
        val expectedExitValue = nextEntry.previousExitValue
        val exitValueComparator = nextEntry.previousExitValueComparator
        val exitValue = launch.processes.get(0).exitValue
        if (PreviousExitValueComparator.matches(exitValue, expectedExitValue, exitValueComparator))
            return true

        /* Stop execution due to unexpected exit value */
        val errorStream = newErrorMessageStream(console)
        val entryName = chain.entries.get(currentEntryIndex).launchConfigurationName
        val nextEntryName = nextEntry.launchConfigurationName
        val printableComparator = PreviousExitValueComparator
            .getUserRepresentation(exitValueComparator)
        errorStream.println(
            "\n" + '''Execution of LEMMA model processing chain "«chainName»" aborted. Launch ''' +
            '''configuration "«entryName»" returned with unexpected exit value «exitValue». ''' +
            '''The followup configuration "«nextEntryName»" however requires an exit value of ''' +
            '''«printableComparator» «expectedExitValue».'''
        )
        errorStream.close()
        return false
    }

    /**
     * Terminate the execution of the chain and reset all resources
     */
    private def terminateChainExecution() {
        infoStream.close()
        monitor.done
        LAUNCH_MANAGER.removeLaunchListener(this)
    }

    final override launchesAdded(ILaunch[] launches) {
        // NOOP
    }

    final override launchesChanged(ILaunch[] launches) {
        // NOOP
    }

    final override launchesRemoved(ILaunch[] launches) {
        // NOOP
    }

}