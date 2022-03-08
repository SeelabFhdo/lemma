package de.fhdo.lemma.model_processing.code_generation.java_base.validation

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.builtin_phases.ValidationEndedWithErrorsException
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.builtin_phases.print
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext
import java.net.URLClassLoader

/**
 * Execute the given [modelValidationFunction] in the context of all Genlets on the classpath
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun executeGenletValidations(
    modelValidationFunction: (genlet: AbstractGenlet, genletClassLoader: ClassLoader) -> List<ValidationResult>
) {
    // Load Genlets from classpath
    MainContext.State.loadGenletsIfNecessary()

    // Execute the given model validation function and collect the results per Genlet
    val genletsWithClassLoaders: Map<AbstractGenlet, URLClassLoader> by MainContext.State
    val validationResultsPerGenletFilePath = mutableMapOf<String, MutableList<ValidationResult>>()
    genletsWithClassLoaders.forEach { (genlet, classLoader) ->
        val validationResults = modelValidationFunction(genlet, classLoader)

        if (validationResults.isNotEmpty()) {
            if (genlet.filePath !in validationResultsPerGenletFilePath)
                validationResultsPerGenletFilePath[genlet.filePath] = mutableListOf()
            validationResultsPerGenletFilePath[genlet.filePath]!!.addAll(validationResults)
        }
    }

    // Print validation results per Genlet and notify the model processing framework with its
    // ValidationEndedWithErrorsException in case a validation yielded a result with an error severity
    var validationError = false
    validationResultsPerGenletFilePath.forEach { (genletFilePath, validationResults) ->
        val filename = genletFilePath.asFile().name
        validationResults.print("Validation results for Genlet \"$filename\":")

        if (!validationError)
            validationError = validationResults.any { it.type == ValidationResultType.ERROR }
    }

    if (validationError)
        throw ValidationEndedWithErrorsException()
}