package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import org.eclipse.debug.core.model.ILaunchConfigurationDelegate
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunch
import org.eclipse.core.runtime.IProgressMonitor
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.CommandLineGenerator
import java.util.List
import org.eclipse.core.runtime.IStatus
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import org.eclipse.ui.console.MessageConsoleStream
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.SubMonitor
import java.util.concurrent.TimeUnit
import org.eclipse.core.runtime.CoreException
import org.eclipse.jface.dialogs.MessageDialog
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.CommandLineGenerator.CoherentCommandLineParts
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import java.util.ArrayDeque
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.Issue
import org.eclipse.core.resources.IFile
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.ui.console.MessageConsole

/**
 * Delegate for model processing launch configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
    public static val CONSOLE_NAME = "LEMMA Model Processor Run"
    public static val DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE = "lemma" +
        typeof(LaunchConfigurationDelegate).name + "DisableConsoleClearing"

    static val INDENT = "  "
    static val MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE = "Model processor execution aborted"

    var MessageConsoleStream infoStream
    var MessageConsoleStream errorStream
    var int headlineLength

    /**
     * Show the commandline of the given ILaunchConfiguration which must be a valid model processing
     * launch configuration
     */
    final override showCommandLine(ILaunchConfiguration launchConfiguration, String mode,
        ILaunch launch, IProgressMonitor monitor) {
        val configuration = ProcessingConfiguration.deserializeFrom(launchConfiguration)
        if (configuration === null)
            return null

        return try {
            val generator = new CommandLineGenerator(configuration)
            val partsAndWarnings = generator.generateCoherentCommandLineParts()
            partsAndWarnings.value.forEach[
                MessageDialog.openWarning(getActiveShell(), "Warning during commandline generation",
                    it)
            ]
            generator.toPrintableCommandLine(partsAndWarnings.key, "\n\t")
        } catch (Exception ex) {
            ex.showCommandLineGenerationError
            null
        }
    }

    /**
     * Helper to display an error message from an exception occurred during commandline generation
     */
    private def showCommandLineGenerationError(Exception ex) {
        var message = if (!ex.message.nullOrEmpty)
                ex.message
            else
                '''«ex.class.simpleName» occurred'''

        MessageDialog.openError(getActiveShell(), "Error during commandline generation", message)
    }

    /**
     * Launch the given ILaunchConfiguration which must be a valid model processing launch
     * configuration
     */
    final override launch(ILaunchConfiguration launchConfiguration, String mode, ILaunch launch,
        IProgressMonitor monitor) {
        val configuration = ProcessingConfiguration.deserializeFrom(launchConfiguration)
        if (configuration === null)
            throw new CoreException(new Status(IStatus.ERROR, LaunchConfigurationDelegate,
                "LEMMA model processor configuration not readable. Launch aborted."))

        // Validate the configuration based on its user representation
        try {
            configuration.convertToUserRepresentation
            configuration.validateInUserRepresentation
        } catch (IllegalArgumentException ex) {
            throw new CoreException(
                new Status(IStatus.ERROR, LaunchConfigurationDelegate, "Invalid LEMMA model " +
                    "processor configuration:\n" + ex.message + "\n\nLaunch aborted.")
            )
        }

        // Display the console, clear it, and retrieve the required streams. Note that it is
        // possible to disable console clearing by setting a temporary attribute with the name
        // specified by the DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE and the boolean value true in
        // the given ILaunchConfiguration. This mechanism for console clearing prevention is, for
        // example, used by the executor for model processing chains (cf. class
        // ProcessingChainLaunchesExecutor).
        val console = getAndRevealConsole(CONSOLE_NAME)
        val disableConsoleClearing = launchConfiguration
            .getAttribute(DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE, false)
        if (!disableConsoleClearing)
            console.clearConsole
        console.openStreams()

        // Stop in case the launch configuration comprises models with errors
        if (configuration.sourceModelFile.erroneousModels()) {
            errorStream.println(MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE)
            closeStreams()
            return
        }

        // Perform the actual launch, which might be preceded by intermediate model transformations
        // if required by the launch configuration
        val headline = "Executing LEMMA model processor configuration " +
            '''"«launchConfiguration.name»"'''
        headlineLength = headline.length
        infoStream.println(headline)

        val subMonitor = SubMonitor.convert(monitor, 1)
        if (configuration.intermediateTransformationRequired) {
            infoStream.printSepLine
            new IntermediateTransformationExecutor(
                configuration,
                infoStream,
                errorStream,
                [configuration.runModelProcessor(launch, subMonitor)],
                [displayAbortMessageAndCloseStreams]
            ).run()
        } else
            configuration.runModelProcessor(launch, subMonitor)
    }

    /**
     * Open all relevant console streams
     */
    private def openStreams(MessageConsole console) {
        infoStream = console.newMessageStream
        errorStream = newErrorMessageStream(console)
    }

    /**
     * Helper to check if the given IFile is a LEMMA model with errors or (possibly transitively)
     * imports LEMMA models with errors. This method will also print all direct and transitive
     * errors to the error stream of the previously opened console.
     */
    private def erroneousModels(IFile sourceModelFile) {
        val absoluteSourceModelPath = sourceModelFile.rawLocation.makeAbsolute.toString
        val erroneousModels = absoluteSourceModelPath.transitiveModelValidation()

        val modelErrors = erroneousModels.get(absoluteSourceModelPath) ?: #[]
        if (!modelErrors.empty) {
            errorStream.println("Model contains errors:\n\t" + modelErrors.join("\n\t"))
            errorStream.println()
        }

        val importedModelErrors = erroneousModels.entrySet.filter[it.key != absoluteSourceModelPath]
        if (!importedModelErrors.empty) {
            errorStream.println("Imported models contain errors:")
            importedModelErrors.forEach[
                errorStream.println('''«"\t"»- «it.key»:''')
                it.value.forEach[
                    errorStream.println('''«"\t\t"»- «it»''')
                ]
            ]
            errorStream.println()
        }

        return !erroneousModels.empty
    }

    /**
     * Helper to perform a validation of the LEMMA model located at the given file path together
     * with a validation of all directly or indirectly (i.e., transitively) imported models.
     */
    private def transitiveModelValidation(String rootModelFilepath) {
        val erroneousModels = <String, List<String>>newHashMap

        val modelsToValidate = new ArrayDeque<String>
        modelsToValidate.push(rootModelFilepath)
        val validatedModels = <String>newHashSet

        while(!modelsToValidate.empty) {
            val modelPath = modelsToValidate.pop

            if (!validatedModels.contains(modelPath)) {
                // Validate next model
                var XtextResource xtextResource = null
                try {
                    xtextResource = LemmaUiUtils.loadXtextResource(modelPath)

                    // This will throw an IndexOutOfBoundsException if the model is empty which is
                    // fine because none of LEMMA's model kinds may be empty
                    val modelRoot = xtextResource.contents.get(0)
                    makeImportPathsAbsoluteFromBasefilePath(modelRoot, rootModelFilepath)

                    val errorMessages = LemmaUiUtils.validateXtextResource(xtextResource)
                        .toErrorMessages
                    if (!errorMessages.empty)
                        erroneousModels.put(modelPath, errorMessages)
                } catch (Exception ex) {
                    erroneousModels.put(modelPath, #[ex.message])
                }

                // Gather paths of all imported, not yet validated models of the currently validated
                // model for their subsequent validation
                val importedModelPaths = try {
                    xtextResource?.getAbsolutePathsOfImportedModels(modelPath)
                } catch (Exception ex) {
                    erroneousModels.put(modelPath, #[ex.message])
                    null
                }

                importedModelPaths?.forEach[
                    if (!validatedModels.contains(it))
                        modelsToValidate.add(it)
                ]
            }
        }

        return erroneousModels
    }

    /**
     * Helper to convert a list of Issues resulting from a programmatic Xtext model validation to a
     * printable list of strings. The result list will only cover those Issues with an ERROR
     * Severity.
     */
    private def toErrorMessages(List<Issue> issues) {
        return issues.filter[it.severity == Severity.ERROR].map[
            '''«it.lineNumber»:«it.column»: «it.message»'''
        ].toList
    }

    /**
     * Helper to convert the paths of all models imported by the given XtextResource (which must
     * represent a LEMMA model) to absolute paths based on the given absolute basepath
     */
    private def getAbsolutePathsOfImportedModels(XtextResource resource, String absoluteBasepath) {
        if (resource.contents.empty)
            return #{}

        val modelRoot = resource.contents.get(0)
        makeImportPathsAbsoluteFromBasefilePath(modelRoot, absoluteBasepath)
        return typedImports(modelRoot).map[it.value.importUri].toSet
    }

    /**
     * Close all relevant console streams
     */
    private def void closeStreams() {
        infoStream.close()
        errorStream.close()
    }

    /**
     * Check if the given model processing launch configuration requires intermediate model
     * transformations
     */
    private def intermediateTransformationRequired(ProcessingConfiguration configuration) {
        return configuration.arguments
            .exists[type instanceof AbstractIntermediateModelArgumentTypeWithEnumValue]
    }

    /**
     * Print a line of separating dashes and with the length of the current headline to the given
     * console stream. In case the current headline has a length less or equal zerp, nothing will
     * be printed.
     */
    private def printSepLine(MessageConsoleStream stream) {
        if (headlineLength <= 0) {
            return
        }

        stream.println("-".repeat(headlineLength))
    }

    /**
     * Display a message that the model processor execution was aborted (e.g., due to the occurrence
     * of errors during an intermediate transformation or the preparation of a model processor's
     * execution) and close all relevant console streams
     */
    private def displayAbortMessageAndCloseStreams() {
        errorStream.println("\n" + MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE)
        closeStreams()
    }

    /**
     * Run a LEMMA model processor for the given model processing launch configuration and its
     * ILaunch instantiation
     */
    private def runModelProcessor(ProcessingConfiguration configuration, ILaunch launch,
        IProgressMonitor monitor) {
        infoStream.printSepLine

        /* Build the commandline for the model processor */
        val commandLineGenerator = new CommandLineGenerator(configuration)
        var CoherentCommandLineParts commandLineParts = null
        try {
            val partsAndWarnings = commandLineGenerator.generateCoherentCommandLineParts()

            for (warning : partsAndWarnings.value) {
                var warningMessage = warning
                if (!warningMessage.endsWith(".")) warningMessage = warningMessage + "."
                if (!warningMessage.endsWith(" ")) warningMessage = warningMessage + " "
                warningMessage = warningMessage + "Do you want to continue?"

                val continue = askForContinuationAfterWarning("Warning during commandline " +
                    "generation", warningMessage)
                if (!continue) {
                    displayAbortMessageAndCloseStreams()
                    return
                }
            }

            commandLineParts = partsAndWarnings.key
        } catch (Exception ex) {
            getWorkbenchDisplay().syncExec([ex.showCommandLineGenerationError])
            displayAbortMessageAndCloseStreams()
            return
        }

        /* Run the model processor */
        infoStream.println("Running model processor:")
        val printableCommandLine = commandLineGenerator.toPrintableCommandLine(commandLineParts,
            "\n" + INDENT.repeat(2))
        printlnIndent(infoStream, printableCommandLine)
        infoStream.println()

        try {
            // Spawn a new process for the execution of the model processor
            val commandline = commandLineGenerator.toExecutableCommandLine(commandLineParts)
            val workdir = configuration.sourceModelFile.rawLocation.makeAbsolute.toFile.parentFile
            val process = DebugPlugin.exec(commandline, workdir)
            process.inputStream.transferTo(infoStream)
            process.errorStream.transferTo(errorStream)
            DebugPlugin.newProcess(launch, process, "")

            // Reveal main console again because DebugPlugin reveals its own one
            getAndRevealConsole(CONSOLE_NAME)

            // Observe the model processor process from a separate thread spawned by the delegate.
            // This approach enables us to handle the exit value of the process and print
            // corresponding messages to the previously opened console streams.
            val processObserver = new Runnable() {
                override run() {
                    var processDestroyed = false
                    while (process.alive && !processDestroyed) {
                        try {
                            process.waitFor(250, TimeUnit.MILLISECONDS)
                        } catch (InterruptedException ex) {
                            process.destroyForcibly
                            processDestroyed = true
                        }
                    }

                    if (process.exitValue == 0)
                        infoStream.println("Model processor execution finished")
                    else
                        errorStream.println("\nModel processor execution finished with errors " +
                            '''(exit code: «process.exitValue»)''')

                    closeStreams()
                    monitor.worked(1)
                    monitor.done()
                }
            }
            new Thread(processObserver).start()
        } catch(Exception ex) {
            infoStream.println()
            errorStream.println(ex.message)
            closeStreams()
            monitor.done()
            return
        }
    }

    /**
     * Helper to ask the user for a continuation of the current action in the event of a previously
     * occurred warning
     */
    private def askForContinuationAfterWarning(String title, String message) {
        val continuationDialogRunnable = new Runnable() {
            var boolean continuationConfirmed

            override run() {
                val dialog = new MessageDialog(getActiveShell(), title, null, message,
                    MessageDialog.WARNING, #["Continue", "Cancel"], 0)
                continuationConfirmed = dialog.open() == 0
            }
        }

        getWorkbenchDisplay().syncExec(continuationDialogRunnable)
        return continuationDialogRunnable.continuationConfirmed
    }
}