package de.fhdo.lemma.model_processing

import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.command_line.parseCommandLine
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.phases.PhaseExecutionInfo
import de.fhdo.lemma.model_processing.phases.PhaseExecutionLog
import de.fhdo.lemma.model_processing.phases.loadExplicitlyInvokedProcessingPhases
import de.fhdo.lemma.model_processing.phases.loadProcessingPhases
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import org.fusesource.jansi.AnsiConsole
import picocli.CommandLine
import kotlin.system.exitProcess

val MODEL_PROCESSING_PACKAGE: String = object{}.javaClass.packageName

private const val ERROR_EXIT_CODE = 1

/**
 * Abstract superclass for model processors.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
abstract class AbstractModelProcessor(private val processorImplementationPackage: String) {
    @Volatile
    private lateinit var currentlyExecutedPhase: AbstractModelProcessingPhase

    /**
     * Run the model processor with the given arguments
     */
    fun run(args: Array<String>) {
        AnsiConsole.systemInstall()

        /* Load built-in as well as custom phases contained in the implementer's package and classpath */
        val loadedPhases = loadProcessingPhases(
            MODEL_PROCESSING_PACKAGE,
            processorImplementationPackage
        )

        val loadedExplicitlyInvokedPhases = loadExplicitlyInvokedProcessingPhases(
            MODEL_PROCESSING_PACKAGE,
            processorImplementationPackage
        )
        val explicitlyInvokedPhaseIds = loadedExplicitlyInvokedPhases.map { it.id }

        /* Parse commandline for basic and phase-specific options */
        val allPhaseIds = mutableListOf(*explicitlyInvokedPhaseIds.toTypedArray())
        allPhaseIds.addAll(loadedPhases.map { it.id })
        val (basicParameters, phaseParameters) = parseCommandLine(args, allPhaseIds)

        try {
            BasicCommandLine(basicParameters)
        } catch (ex: CommandLine.ParameterException) {
            printlnError(ex.message!!)
            processingFinished(ERROR_EXIT_CODE)
        }

        /* Set debug-related parameters and determine log level */
        if (BasicCommandLine.debugMode())
            Configurator.setRootLevel(Level.DEBUG)
        else
            Configurator.setRootLevel(Level.ERROR)

        /*
         * Print debug information about phase parameters. Can only be done here, because for recognizing the debug
         * mode, we need to parse the commandline first.
         */
        if (phaseParameters.isNotEmpty())
            debug {
                "Commandline parsing detected the following phase parameters:\n" +
                phaseParameters.entries.joinToString ("\n") { "${it.key}: ${it.value.joinToString()}" }
            }

        /*
         * Print debug information about loaded phases. Can only be done here, because for recognizing the debug mode,
         * we need to parse the commandline, for which we again need to have loaded the available phases (see above).
         */
        debug {
            "The following built-in and custom phases were loaded and initialized from model processing package " +
            "\"$MODEL_PROCESSING_PACKAGE\" and processor implementation package \"$processorImplementationPackage\":" +
            "\n" + loadedPhases.withIndex().joinToString("\n") { "\t${it.index+1}. ${it.value}" }
        }

        debug {
            "Loaded and initialized *explicitly invoked* phases:\n" +
            loadedExplicitlyInvokedPhases.withIndex().joinToString("\n") { "\t${it.index+1}. ${it.value}" }
        }

        /* Initialize language descriptions singleton so that the phases can make use of it */
        LanguageDescriptions.initialize(processorImplementationPackage)

        /* Set global exception handler to centralize handling of PhaseExceptions during a model processor execution */
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            // Only handle PhaseExceptions and rethrow others
            val phaseException = throwable as? PhaseException ?: throwable.cause as? PhaseException
            if (phaseException == null) {
                throwable.printStackTrace()
                throw throwable
            }

            printPhaseError(currentlyExecutedPhase, phaseException.getAndDebugErrorMessage())
            printError(" ")

            exitModelProcessorIfRequested(phaseException)

            // In case we got here, either the user decided to continue after model processing errors or the phase
            // exception indicated to not stop model processing after its occurrence
            printlnError("Phase execution aborted.")

            // We still check for promised return parameters of the failed phase and warn the user in case there is
            // anything wrong with them so that subsequent phases may fail when they depend on the parameters
            try {
                currentlyExecutedPhase.checkReturnParametersOrException()
            } catch (ex: PhaseException) {
                printlnError("\tPhase did not return parameters as expected and subsequent phases may fail because " +
                    "of this: ${ex.message}")
            }
        }

        /* Execute phases with phase-specific parameters (if any) */
        with(phaseParameters) {
            when {
                // Invoke only those phases that were explicitly specified on the commandline
                BasicCommandLine.invokeOnlySpecifiedPhases -> {
                    debug {
                        "Commandline option for selective phase invocation was specified. Only explicitly stated " +
                        "phases will be executed."
                    }

                    val specifiedPhases = (loadedPhases + loadedExplicitlyInvokedPhases)
                        .filter { !it.isOmittable || it.id in phaseParameters.keys }.toLinkedHashSet()
                    executePhases(specifiedPhases.toList(), this)
                }

                // In case an explicitly invoked phase was stated on the commandline, only invoke those phases that need
                // to be explicitly invoked
                keys.containsAny(explicitlyInvokedPhaseIds) -> {
                    debug {
                        "Commandline comprised IDs of the following explicitly invoked phases: " +
                        "${explicitlyInvokedPhaseIds.filter { it in keys }.joinToString()}. Only phases that require " +
                        "explicit invocation will be considered in the processor's execution."
                    }
                    executePhases(loadedExplicitlyInvokedPhases.toList(), this)
                }

                // Invoke all phases that do not need to be invoked explicitly
                else -> executePhases(loadedPhases.toList(), this)
            }
        }
    }

    /**
     * Callback that the model processor's execution has finished
     */
    protected open fun processingFinished(returnCode: Int) {
        AnsiConsole.systemUninstall()
        exitProcess(returnCode)
    }

    /**
     * Helper to get an error message from this [PhaseException]. The helper also prints a debug message with the
     * exception's stack trace.
     */
    private fun PhaseException.getAndDebugErrorMessage() : String {
        val stackTraceString = stackTraceAsString()
        return if (!message.isNullOrEmpty()) {
                debug { stackTraceString }
                if (!message!!.endsWith(".")) "${message}." else message!!
            } else
                stackTraceString
    }

    /**
     * Exit the model processor in case the user did not specify the [BasicCommandLine.continueAfterPhaseErrors] option
     * or the occurred [phaseException] does not support processing continuation
     */
    private fun exitModelProcessorIfRequested(phaseException: PhaseException) {
        if (BasicCommandLine.continueAfterPhaseErrors && !phaseException.exitModelProcessor)
            return

        if (BasicCommandLine.continueAfterPhaseErrors)
            printlnError("Continuation after phase errors was requested but phase error is not recoverable.")

        printlnError("Model processing aborted.")
        processingFinished(ERROR_EXIT_CODE)
    }

    /**
     * Helper to execute all model processing phases in a given list
     */
    private fun executePhases(candidatePhases: List<AbstractModelProcessingPhase>,
        phaseParameters: Map<String, List<String>>) {
        /* Determine phases to execute by considering passed commandline options */
        val phasesToExecute = mutableListOf<AbstractModelProcessingPhase>()
        val missingOptions = mutableMapOf<String, List<BasicOption>>()
        for (phase in candidatePhases) {
            val (missingOptionsCausingError, missingOptionsNoError) = phase.getMissingCommandLineOptions()
            if (missingOptionsCausingError.isEmpty() && missingOptionsNoError.isEmpty()) {
                phasesToExecute.add(phase)
                continue
            }

            if (missingOptionsCausingError.isNotEmpty())
                printlnError("Phase \"${phase.id}\" requires command line options " +
                    "${missingOptionsCausingError.printableRepresentation()}, which were not passed. Phase will " +
                    "not be executed")

            missingOptions[phase.id] = missingOptionsCausingError + missingOptionsNoError
        }

        debug {
            "Candidate phases for execution:\n" +
            candidatePhases.withIndex().joinToString("\n") {
                "\t${it.index+1}. ${it.value.id}" +
                if (it.value.id in missingOptions)
                    " (will not be executed due to missing options " +
                    "${missingOptions[it.value.id]!!.printableRepresentation()})"
                else
                    ""
            }
        }

        debug {
            "The following phases will be executed:\n" +
            phasesToExecute.withIndex().joinToString("\n") { "\t${it.index+1}. ${it.value.id}" }
        }

        /* Perform the actual execution */
        val executedBlockingPhaseIds = mutableListOf<String>()
        phasesToExecute.forEachIndexed { i, phase ->
            debug { """[BEGIN] Execution of${if (phase.isBlocking) " *blocking* " else " "}phase "${phase.id}"""" }
            phasesToExecute.execute(i, phaseParameters[phase.id])

            if (phase.isBlocking)
                executedBlockingPhaseIds.add(phase.id)
            debug { """[END] Execution of phase "${phase.id}"""" }
        }

        // We only exit the application normally in case none of the executed phases was a blocking one
        if (executedBlockingPhaseIds.isEmpty())
            processingFinished(0)
        else
            debug {
                "Processor won't be exited due to the execution of blocking phases " +
                executedBlockingPhaseIds.joinToString { "\"$it\"" }
            }
    }

    /**
     * Helper to turn this list of [BasicOption]s into a printable representation
     */
    private fun List<BasicOption>.printableRepresentation() = joinToString { it.names.joinToString("/") }

    /**
     * Helper to execute a single model processing phase from a given list of phases
     */
    private fun List<AbstractModelProcessingPhase>.execute(index: Int, parameters: List<String>?) {
        currentlyExecutedPhase = this[index]
        currentlyExecutedPhase.predecessors = if (index > 0) subList(0, index).map { it.id } else emptyList()
        currentlyExecutedPhase.successors = if (index < size-1) subList(index+1, size).map { it.id } else emptyList()

        currentlyExecutedPhase.checkExpectedParametersOrException()
        currentlyExecutedPhase.process(parameters?.toTypedArray() ?: emptyArray())
        currentlyExecutedPhase.checkReturnParametersOrException()
        PhaseExecutionLog.addEntry(currentlyExecutedPhase.id, PhaseExecutionInfo(true))
    }
}