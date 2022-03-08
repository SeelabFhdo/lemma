package de.fhdo.lemma.model_processing

import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.command_line.parseCommandLine
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.phases.PhaseExecutionInfo
import de.fhdo.lemma.model_processing.phases.PhaseExecutionLog
import de.fhdo.lemma.model_processing.phases.loadExplicitlyInvokedProcessingPhases
import de.fhdo.lemma.model_processing.phases.loadProcessingPhases
import de.fhdo.lemma.model_processing.phases.validation.ModelValidatorI
import de.fhdo.lemma.model_processing.phases.validation.ModelValidatorRegistry
import io.github.classgraph.ClassInfo
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import org.eclipse.emf.ecore.resource.Resource
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

    /**
     * Trigger source model validation on the given [resource] which clusters a model in a language determined by the
     * given [languageDescription] and with the given file [extension]. The [classLoaders] parameter enables to also
     * specify the list of class loaders for the model processing framework to search for source validator
     * implementations.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun executeSourceModelValidatorsForFileExtension(resource: Resource, languageDescription: LanguageDescription,
        extension: String, vararg classLoaders: ClassLoader)
        = executeValidators(ModelKind.SOURCE, resource, null, languageDescription, extension, emptySet(), *classLoaders)

    /**
     * Trigger model validations for the given [modelKind] and a [resource] with that kind. The [relevantModelElements]
     * enables to constrain the validated model elements and must be null to consider all elements. The method will
     * trigger all validators for the given [languageDescription] that support the specified [fileExtension] and set of
     * [languageNamespaces]. The [classLoaders] parameter enables to also specify the list of class loaders for the
     * model processing framework to search for validator implementations.
     *
     * This method is the generic variant of [executeSourceModelValidatorsForFileExtension],
     * [executeIntermediateModelValidatorsForFileExtension], [executeSourceModelValidatorsForLanguageNamespace], and
     * [executeIntermediateModelValidatorsForLanguageNamespace].
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun executeValidators(
        modelKind: ModelKind,
        resource: Resource,
        relevantModelElements: Collection<*>?,
        languageDescription: LanguageDescription,
        fileExtension: String?,
        languageNamespaces: Set<String>,
        vararg classLoaders: ClassLoader
    ) : List<ValidationResult> {
        // Setup model validator registry and scan for validator implementations
        val modelValidatorRegistry = ModelValidatorRegistry()
        modelValidatorRegistry.findAndRegisterModelValidators(processorImplementationPackage, modelKind, *classLoaders)
        val allValidationResults = mutableListOf<ValidationResult>()

        try {
            // Invoke validators for file extension
            if (fileExtension != null)
                modelValidatorRegistry.getModelValidatorsForFileExtension(fileExtension, modelKind).forEach {
                    allValidationResults.addValidationResultsFor(it, resource, languageDescription,
                        relevantModelElements)
                }

            // Invoke validators for language namespaces
            val namespaceValidators = languageNamespaces.map {
                    modelValidatorRegistry.getModelValidatorsForLanguageNamespace(it, modelKind)
                }.flatten()
            namespaceValidators.forEach {
                allValidationResults.addValidationResultsFor(it, resource, languageDescription, relevantModelElements)
            }
        } catch (ex: PhaseException) {
            // As opposed to run(), we don't install a global exception handler because we aren't in a regular
            // phase-driven model processor execution and thus didn't load the complete set of available phases for the
            // exception handler to consider
            printError(ex.getAndDebugErrorMessage())
            exitModelProcessorIfRequested(ex)
        }

        return allValidationResults
    }

    /**
     * Helper to add model validation results to this [MutableList]. The helper loads and executes the validator
     * described by the given [validatorClassInfo] on the given [resource] using the specified [languageDescription] and
     * [relevantModelElements].
     */
    private fun MutableList<ValidationResult>.addValidationResultsFor(validatorClassInfo: ClassInfo, resource: Resource,
        languageDescription: LanguageDescription, relevantModelElements: Collection<*>?) {
        addAll(loadAndExecuteValidator(validatorClassInfo, resource, languageDescription, relevantModelElements))
    }

    /**
     * Helper to load and execute the validator described by the given [validatorClassInfo] on the given [resource]
     * using the specified [languageDescription] and [relevantModelElements].
     */
    private fun loadAndExecuteValidator(validatorClassInfo: ClassInfo, resource: Resource,
        languageDescription: LanguageDescription, relevantModelElements: Collection<*>?) : List<ValidationResult> {
        val validatorInstance = validatorClassInfo.loadClass(ModelValidatorI::class.java).getDeclaredConstructor()
            .newInstance()
        return validatorInstance(resource, languageDescription, relevantModelElements)
    }

    /**
     * Trigger intermediate model validation on the given [resource] which clusters a model in a language determined by
     * the given [languageDescription] and with the given file [extension]. The [classLoaders] parameter enables to also
     * specify the list of class loaders for the model processing framework to search for intermediate validator
     * implementations.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun executeIntermediateModelValidatorsForFileExtension(resource: Resource, languageDescription: LanguageDescription,
        extension: String, vararg classLoaders: ClassLoader)
        = executeValidators(ModelKind.INTERMEDIATE, resource, null, languageDescription, extension, emptySet(),
            *classLoaders)

    /**
     * Trigger source model validation on the given [resource] which clusters a model in a language determined by
     * the given [languageDescription] and with the given language [namespace]. The [classLoaders] parameter enables to
     * also specify the list of class loaders for the model processing framework to search for source validator
     * implementations.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun executeSourceModelValidatorsForLanguageNamespace(resource: Resource, languageDescription: LanguageDescription,
        namespace: String, vararg classLoaders: ClassLoader)
        = executeValidators(ModelKind.SOURCE, resource, null, languageDescription, null, setOf(namespace),
            *classLoaders)

    /**
     * Trigger intermediate model validation on the given [resource] which clusters a model in a language determined by
     * the given [languageDescription] and with the given language [namespace]. The [classLoaders] parameter enables to
     * also specify the list of class loaders for the model processing framework to search for intermediate validator
     * implementations.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun executeIntermediateModelValidatorsForLanguageNamespace(
        resource: Resource,
        languageDescription: LanguageDescription,
        namespace: String,
        vararg classLoaders: ClassLoader
    ) = executeValidators(ModelKind.INTERMEDIATE, resource, null, languageDescription, null, setOf(namespace),
        *classLoaders)
}