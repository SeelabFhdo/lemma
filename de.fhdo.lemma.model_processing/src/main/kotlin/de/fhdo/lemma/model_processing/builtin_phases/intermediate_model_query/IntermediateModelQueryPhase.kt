package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.RequiresBasicCommandLineOptions
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationPhase
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.languages.registerLanguages
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.readModelingNamespacesFromXmi
import de.fhdo.lemma.ocl.OclQueryHelper
import org.eclipse.emf.ecore.resource.Resource
import java.lang.Exception

/**
 * Implementation of the model processor's intermediate model query phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("intermediate_model_query", SourceModelValidationPhase::class)
@RequiresBasicCommandLineOptions(BasicOption.INTERMEDIATE_MODEL_FILE)
internal class IntermediateModelQueryPhase : AbstractModelProcessingPhase() {
    /**
     * Phase initialization (overridden to specify parameter constraints)
     */
    override fun initialize(id: String, isBlocking: Boolean, processorImplementationPackage: String) {
        super.initialize(id, isBlocking, processorImplementationPackage)

        parameters {
            returns {
                "relevantModelElements" withType Collection::class.java

                optional {
                    "intermediateModelFileNamespaces" withType Set::class.java
                    "resource" withType Resource::class.java
                    "queryFile" withType String::class.java
                    "query" withType String::class.java
                }
            }
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        "relevantModelElements" returns null

        val queryFile = with(PhaseCommandLine) {
            try {
                invoke(args)
            } catch (ex: Exception) {
                throw PhaseException(ex.message)
            }

            queryFile
        } ?: return

        /* Register all necessary EPackage instances to load the intermediate model file as XMI resource */
        val intermediateModelFile = BasicCommandLine.intermediateModelFile!!
        val intermediateModelFileNamespaces = readModelingNamespacesFromXmi(intermediateModelFile)
        "intermediateModelFileNamespaces" returns intermediateModelFileNamespaces
        registerLanguages(intermediateModelFileNamespaces)

        /* Load intermediate model file as XMI resource */
        val resource = BasicCommandLine.intermediateModelFile!!.asXmiResource()
        "resource" returns resource

        /* Put optional parameters on the heap */
        val query = queryFile.asFile().readText()
        "queryFile" returns queryFile

        if (query.isEmpty())
            throw PhaseException("No query found in query file $queryFile")
        "query" returns query

        /* Execute the OCL query */
        val selectedModelElements = try {
            OclQueryHelper.queryCollection(resource, query)
        } catch (ex: Exception) {
            throw PhaseException("Error when executing OCL query: ${ex.message}")
        } ?: throw PhaseException("OCL query did not return an instance of ${Collection::class.java.name}, which is " +
                "necessary when querying intermediate models")
        "relevantModelElements" returns selectedModelElements
    }
}