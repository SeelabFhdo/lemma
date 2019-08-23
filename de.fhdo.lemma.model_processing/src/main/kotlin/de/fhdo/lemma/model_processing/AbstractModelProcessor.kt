package de.fhdo.lemma.model_processing

import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.parseCommandLine
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.phases.PhaseExecutionInfo
import de.fhdo.lemma.model_processing.phases.PhaseExecutionLog
import de.fhdo.lemma.model_processing.phases.loadExplicitlyInvokedProcessingPhases
import de.fhdo.lemma.model_processing.phases.loadProcessingPhases
import de.fhdo.lemma.model_processing.phases.validate
import org.fusesource.jansi.AnsiConsole
import picocli.CommandLine
import kotlin.system.exitProcess

val MODEL_PROCESSING_PACKAGE: String = object{}.javaClass.packageName

/**
 * Abstract superclass for model processors.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractModelProcessor(private val processorImplementationPackage: String) {
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
            processingFinished(4)
        }

        /* Initialize language descriptions singleton so that the phases can make use of it */
        LanguageDescriptions.initialize(processorImplementationPackage)

        /* Execute phases with phase-specific parameters (if any) */
        with(phaseParameters) {
            // Invoke only those phases that were explicitly specified on the commandline
            when {
                BasicCommandLine.invokeOnlySpecifiedPhases -> {
                    val specifiedPhases = (loadedPhases + loadedExplicitlyInvokedPhases)
                        .filter { it.id in phaseParameters.keys }.toSet()
                    executePhases(specifiedPhases, this)
                }

                // In case an explicitly invoked phase was stated on the commandline, only invoke those phases that need
                // to be explicitly specified
                keys.containsAny(explicitlyInvokedPhaseIds) -> executePhases(loadedExplicitlyInvokedPhases, this)

                // Invoke all phases that do not need to be invoked explicitly
                else -> executePhases(loadedPhases, this)
            }
        }
    }

    /**
     * Callback that the model processor's execution has finished
     */
    protected fun processingFinished(returnCode: Int) {
        AnsiConsole.systemUninstall()
        exitProcess(returnCode)
    }

    /**
     * Helper to execute a set of model processing phases with phase-specific parameters, if any
     */
    private fun executePhases(phasesToExecute: Set<AbstractModelProcessingPhase>,
        phaseParameters: Map<String, List<String>>) {
        var blockingPhaseExecuted = false
        phasesToExecute.forEach {
            executePhase(it, phaseParameters[it.id])

            if (it.isBlocking)
                blockingPhaseExecuted = true
        }

        // We only exit the application in case none of the executed phases was a blocking one
        if (!blockingPhaseExecuted)
            processingFinished(0)
    }

    /**
     * Helper to execute a single model processing phase
     */
    private fun executePhase(phase: AbstractModelProcessingPhase, parameters: List<String>?) {
        var phaseProcessed = false
        var exception: PhaseException? = null
        try {
            phase.checkExpectedParameters()
            phase.validate()
            phase.process(parameters?.toTypedArray() ?: emptyArray())
            phaseProcessed = true
            phase.checkReturnParameters()
        } catch (ex: PhaseException) {
            if (ex.message != null && ex.message!!.isNotEmpty()) {
                printError("""Model processing phase "${phase.id}": ${ex.message}""")
                if (!ex.message!!.endsWith("."))
                    printError(".")
                printError(" ")
            }

            exception = ex
        }

        val phaseExecutedSuccessfully = exception == null
        PhaseExecutionLog.addEntry(phase.id, PhaseExecutionInfo(phaseExecutedSuccessfully))

        if (phaseExecutedSuccessfully)
            return

        /* Do the actual exception handling */
        if (BasicCommandLine.exitOnError)
            processingFinished(4)

        if (exception!!.abortPhaseExecution) {
            printlnError("Phase execution aborted.")

            // If the exception occurred during the processing of the phase, we still check for promised return
            // parameters and warn the user in case there is anything wrong with them that subsequent phases may fail if
            // they depend on the parameters
            if (!phaseProcessed)
                try {
                    phase.checkReturnParameters()
                } catch (ex: PhaseException) {
                    printlnError("\tPhase did not return parameters as expected and subsequent phases may fail " +
                        "because of this: ${ex.message}")
                }
        } else if (exception.exitModelProcessor) {
            printlnError("Model processing aborted.")
            processingFinished(4)
        } else
            println()
    }
}