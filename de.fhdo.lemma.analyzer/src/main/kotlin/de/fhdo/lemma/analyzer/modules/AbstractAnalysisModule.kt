package de.fhdo.lemma.analyzer.modules

import de.fhdo.lemma.analyzer.command_line.CommandLine
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.BeforeCheck
import de.fhdo.lemma.model_processing.annotations.RethrowExceptions
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check
import kotlin.reflect.KFunction

/**
 * Abstract superclass to facilitate the implementation of analysis modules in the form of intermediate model
 * validations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractAnalysisModule<T: EObject> : AbstractXmiDeclarativeValidator() {
    companion object {
        private val executedModulesList = mutableSetOf<String>()
        private val consumedAdditionalCommandLineOptions = mutableSetOf<String>()

        /**
         * Get the list of all executed analysis modules
         */
        internal fun getExecutedModulesList() : Set<String> = executedModulesList

        /**
         * Get all additionally consumed commandline options, which the commandline parser did not recognize, because
         * they do not represent built-in optionsy
         */
        internal fun getConsumedAdditionalCommandLineOptions() : Set<String> = consumedAdditionalCommandLineOptions
    }

    private var modelsHaveExpectedType = false
    private lateinit var name: String
    private lateinit var commandlineOptionName: String
    private lateinit var additionalCommandLineOptions: Map<String, String>
    protected lateinit var loadedModels: List<T>
    protected lateinit var loadedModelsWithPath: Map<String, T>

    /**
     * Perform initialization before the actual validation (and thus the analysis) starts
     */
    @Before
    protected fun init(resource: Resource) {
        if (!CommandLine.initialized)
            CommandLine(getPhaseArguments())

        setModuleInfo()
        if (commandlineOptionName !in CommandLine.modules)
            return

        loadModels(resource)
    }

    /**
     * Initialize the attributes of a concrete analysis module, which hold information about the module
     */
    private fun setModuleInfo() {
        val moduleInfo = moduleInfo()
        name = moduleInfo.moduleName
        commandlineOptionName = moduleInfo.cliOptionName
        additionalCommandLineOptions = moduleInfo.additionalCliOptions.associateBy { buildAdditionalCliOption(it) }
    }

    /**
     * Build the full name of a module-specific commandline option. The names of such options start with the commandline
     * name of the analysis module, e.g., "--basic-domain-analysis", followed by a dash and the [simpleName] of the
     * additional commandline option. For example, the full name of the "verbose-mode" additional commandline option for
     * the analysis module with the commandline name "--basic-domain-analysis" would be
     * "--basic-domain-analysis-verbose-mode".
     */
    private fun buildAdditionalCliOption(simpleName: String) : String {
        val prefix = "--$commandlineOptionName-"
        return if (!simpleName.startsWith(prefix)) "$prefix$simpleName" else simpleName
    }

    /**
     * Load the model from the given [resource] (which is the model provided to the "--intermediate_model" built-in
     * commandline option of LEMMA's model processor) as well as all additional models provided by the user via the
     * [CommandLine]. The loaded models will be store in the collections [loadedModelsWithPath] and [loadedModels].
     */
    @Suppress("UNCHECKED_CAST")
    private fun loadModels(resource: Resource) {
        val model = resource.contents[0] as? T ?: return
        LoadedModels[BasicCommandLine.intermediateModelFile!!] = model
        CommandLine.additionalIntermediateModels.forEach { LoadedModels.loadModel<T>(it) }

        loadedModelsWithPath = LoadedModels.modelRoots.entries
            .mapNotNull {
                val value = it.value as? T
                if (value != null) it.key to value else null
            }.associate { it }
        loadedModels = loadedModelsWithPath.values.toList()
        modelsHaveExpectedType = true
    }

    /**
     * Pre-check if an analysis module and its analysis actions shall be executed. The module will be executed if all
     * loaded models have the expected type of the module as indicated by the type parameter [T] and [executeModule]
     * returns true.
     */
    @Suppress("UNUSED_PARAMETER")
    @BeforeCheck
    protected fun checkModuleExecution(checkMethod: KFunction<*>) : Boolean {
        val executeModule = modelsHaveExpectedType && executeModule()
        if (executeModule)
            executedModulesList.add(name)

        return executeModule
    }

    /**
     * Get the [ModuleInfo] from a concrete analysis module
     */
    abstract fun moduleInfo() : ModuleInfo

    /**
     * This method enables concrete analysis modules to implement custom execution checks. In case an implementation of
     * [executeModule] return false, the implementing module will not be executed.
     */
    open fun executeModule() = true

    /**
     * The actual entrypoint for the execution of an analysis module as an @Check method for intermediate model
     * validation. This method will execute the [analysis] method to start analysis by a concrete analysis module.
     * Consequently, concrete analysis module should not implement @Check methods themselves, because their execution
     * order is nondeterministic.
     */
    @Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER", "unused")
    @Check
    @RethrowExceptions
    fun entrypoint(modelRoot: T) {
        analysis(getCommandLineArguments())
    }

    /**
     * Get the module-specific commandline arguments from the additionally consumed commandline options
     */
    @Suppress("MapGetWithNotNullAssertionOperator")
    private fun getCommandLineArguments() : Map<String, String> {
        val arguments = mutableMapOf<String, String>()
        for (additionalOption in CommandLine.unmatched) {
            val additionalOptionName = additionalCommandLineOptions.keys.find { additionalOption.startsWith(it) }
                ?: continue
            consumedAdditionalCommandLineOptions.add(additionalOption)

            val moduleOptionName = additionalCommandLineOptions[additionalOptionName]!!
            val argumentValue = additionalOption.substringAfter("=", "")
            arguments[moduleOptionName] = argumentValue
        }

        return arguments
    }

    /**
     * Analysis logic of a concrete analysis module
     */
    abstract fun analysis(args: Map<String, String>)
}

/**
 * Class to maintain information about a concrete analysis module.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ModuleInfo(internal val moduleName: String, internal val cliOptionName: String,
    internal val additionalCliOptions: Set<String> = emptySet())