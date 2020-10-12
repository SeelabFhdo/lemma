package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.RequiresBasicCommandLineOptions
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.ValidationEndedWithErrorsException
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query.IntermediateModelQueryPhase
import de.fhdo.lemma.model_processing.builtin_phases.print
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.readModelingNamespacesFromXmi
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

/**
 * Implementation of the model processor's intermediate model validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("intermediate_model_validation", IntermediateModelQueryPhase::class)
@RequiresBasicCommandLineOptions(BasicOption.INTERMEDIATE_MODEL_FILE)
internal class IntermediateModelValidationPhase : AbstractModelProcessingPhase() {
    /**
     * Phase initialization (overridden to specify parameter constraints)
     */
    override fun initialize(id: String, isBlocking: Boolean, processorImplementationPackage: String) {
        super.initialize(id, isBlocking, processorImplementationPackage)

        parameters {
            expects {
                from("intermediate_model_query") {
                    "relevantModelElements" withType Collection::class.java
                }
            }

            returns {
                "resource" withType Resource::class.java
                "intermediateModelFileNamespaces" withType Set::class.java
            }
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        val intermediateModelFile = BasicCommandLine.intermediateModelFile!!

        // Read all modeling-related namespaces either from the previous phase or directly from the intermediate model's
        // XMI representation. They could potentially been being supported by the intermediate model validators and are
        // identified by the NS URIs of the Ecore packages in the respective language description.
        @Suppress("UNCHECKED_CAST")
        val intermediateModelFileNamespaces =
            ("intermediateModelFileNamespaces" fromPhase "intermediate_model_query") as? Set<String>
            ?: readModelingNamespacesFromXmi(intermediateModelFile)
        "intermediateModelFileNamespaces" returns intermediateModelFileNamespaces

        // Find all designated intermediate model validators on the classpath
        val validators = findAnnotatedClasses(processorImplementationPackage, IntermediateModelValidator::class)

        /*
         * Execute the intermediate model validators, in case they were implemented as expected and support at least one
         * of the namespaces found in the intermediate model's XMI representation.
         */
        // Reuse return parameters from the previous phase if possible
        var intermediateModelResource = "resource" fromPhase "intermediate_model_query" withType Resource::class.java
        @Suppress("UNCHECKED_CAST")
        val relevantModelElements = ("relevantModelElements" fromPhase "intermediate_model_query")
            as? Collection<EObject>

        // Perform the actual validation
        val validationResults = mutableListOf<ValidationResult>()
        validators.forEach {
            it.extendsImplementsOrException(
                "Designated intermediate model validator",
                expectedSuperclass = AbstractIntermediateDeclarativeValidator::class
            )

            val validatorInstance = it
                .loadClass(AbstractIntermediateDeclarativeValidator::class.java)
                .getDeclaredConstructor()
                .newInstance()
            validatorInstance.setPhaseArguments(args)

            val languageNamespace = validatorInstance.getLanguageNamespace()
            if (languageNamespace in intermediateModelFileNamespaces) {
                registerLanguage(languageNamespace)

                if (intermediateModelResource == null)
                    intermediateModelResource = intermediateModelFile.asXmiResource()

                validationResults += validatorInstance(intermediateModelResource!!, relevantModelElements)
            }
        }

        "resource" returns intermediateModelResource

        // Print the validation results and exit with an error code, if there were errors among them
        validationResults.print(intermediateModelFile)
        if (validationResults.any { it.type == ValidationResultType.ERROR })
            throw ValidationEndedWithErrorsException()
    }
}