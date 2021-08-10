package de.fhdo.lemma.model_processing.phases

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.ecoreMainInterface
import de.fhdo.lemma.ocl.OclQueryHelper
import org.eclipse.emf.ecore.EObject
import picocli.CommandLine

/**
 * Superclass for all model processor phases that conduct model querying.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractModelQueryPhase(private val modelKind: ModelKind) : AbstractModelProcessingPhase() {
    private val commandSpec = CommandLine.Model.CommandSpec.create()

    // Model querying expects an argument to a phase-specific commandline option to specify the file containing the
    // model query string
    private val queryFileOption: CommandLine.Model.OptionSpec = CommandLine.Model.OptionSpec
        .builder("--query_file")
        .paramLabel("QUERY_FILE")
        .type(String::class.java)
        .description("the query file to be used to query the ${modelKind.label} model")
        .build()!!

    /**
     * Initialize the phase
     */
    final override fun initialize(id: String, isOmittable: Boolean, isBlocking: Boolean,
        processorImplementationPackage: String) {
        super.initialize(id, isOmittable, isBlocking, processorImplementationPackage)

        parameters {
            returns {
                modelKind.relevantElementsParameterName withType Collection::class.java

                optional {
                    modelKind.queryParameterName withType String::class.java
                    modelKind.queryFilePathParameterName withType String::class.java
                }
            }
        }

        commandSpec.addOption(queryFileOption)
    }

    /**
     * Execute the phase
     */
    final override fun process(args: Array<String>) {
        debugPhaseArguments(args)

        // The phase always puts the relevant model elements to the phase heap. The default value of null communicates
        // subsequent phases like model validation that no model elements shall be excluded (i.e., no querying
        // occurred).
        returnRelevantModelElements(null)

        /*
         * Read the model query string from the model query file passed as an argument to the phase-specific commandline
         * option
         */
        val queryFilePath = try {
            val parseResult = CommandLine(commandSpec).parseArgs(*args)
            val matchedQueryFileOption = parseResult.matchedOptions().find { it == queryFileOption }
            matchedQueryFileOption?.getValue<String>()
        } catch(ex: Exception) {
            throw PhaseException(ex.message)
        }

        if (queryFilePath != null)
            debugPhase { "Got file \"$queryFilePath\" for model querying" }
        else {
            debugPhase {
                "No query file passed with phase commandline option(s) \"${queryFileOption.names().joinToString()}\"." +
                " Phase will not be executed."
            }
            return
        }

        if (!queryFilePath.asFile().exists())
            throw CommandLine.ParameterException(commandSpec.commandLine(), "Model query file $queryFilePath does not " +
                "exist")

        val query = queryFilePath.asFile().readText()
        returnQueryFilePath(queryFilePath)

        if (query.isEmpty())
            throw PhaseException("No query found in query file $queryFilePath")
        returnQuery(query)

        /*
         * Execute the OCL query, if a query string could be obtained from the query file, and put the list of relevant
         * model elements (i.e., model elements that matched the query) to the phase heap
         */
        val selectedModelElements = try {
            OclQueryHelper.queryCollection(modelKind.getResourceOfPassedModel()!!, query)
        } catch (ex: java.lang.Exception) {
            throw PhaseException("Error when executing OCL query: ${ex.message}")
        } ?: throw PhaseException("OCL query did not return an instance of ${Collection::class.java.name}, which is " +
                "necessary when querying intermediate models")

        returnRelevantModelElements(selectedModelElements)
        debugPhase { "Query successfully executed (selected model element count: ${selectedModelElements.size})" }
        if (selectedModelElements.isNotEmpty()) {
            debugPhase { "\tBreakdown of selected model elements:" }
            selectedModelElements
                .groupingBy {
                    when {
                        it is EObject -> it.ecoreMainInterface()?.simpleName ?: it::class.java.simpleName
                        it != null -> it::class.java.simpleName
                        else -> "null"
                    }
                }
                .eachCount()
                .forEach { (classname, count) -> debugPhase { "\t\t- $classname: $count" } }
        }
    }

    /**
     * Convenience method to put the list of relevant model elements to the phase heap
     */
    private fun returnRelevantModelElements(elements: Collection<*>?)
        = modelKind.relevantElementsParameterName returns elements

    /**
     * Convenience method to put the model query on the phase heap
     */
    private fun returnQuery(query: String) = modelKind.queryParameterName returns query

    /**
     * Convenience method to put the path to the model query file on the phase heap
     */
    private fun returnQueryFilePath(queryFilePath: String) = modelKind.queryFilePathParameterName returns queryFilePath
}