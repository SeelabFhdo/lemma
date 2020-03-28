package de.fhdo.lemma.model_processing.builtin_phases.live_validation

import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.annotations.get
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.printlnError
import de.fhdo.lemma.model_processing.builtin_phases.NoValidatorFoundException
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationMode
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator
import de.fhdo.lemma.model_processing.phases.PhaseException
import io.github.classgraph.AnnotationEnumValue
import io.github.classgraph.ClassInfo
import java.util.concurrent.ExecutionException

/**
 * Implementation of the model processor's Live Validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ExplicitlyInvokedModelProcessingPhase("live_validation", true)
internal class SourceModelLiveValidationPhase : AbstractModelProcessingPhase() {
    override fun process(args: Array<String>) {
        val validators = findXtextSourceModelValidators(processorImplementationPackage)
        if (validators.isEmpty())
            throw NoValidatorFoundException("Live validation not possible, because no Xtext source model validators " +
                "could be found on the classpath")

        with(PhaseCommandLine) {
            try {
                invoke(args)
            } catch (ex: java.lang.Exception) {
                throw PhaseException(ex.message)
            }

            try {
                // Connect to a running Live Validation server
                LiveValidator(validators).start(hostname, port)
                println("Live Validation client started and listening for validation requests on $hostname:$port")
            } catch (ex: Exception) {
                if (ex.cause is ExecutionException)
                    printlnError("Live Validation client could not connect to Live Validation server expected on " +
                        "$hostname:$port")

                printlnError("Live Validation client could not be started: ${ex.message}")
            }
        }
    }
}

/**
 * Helper to find, per file extension, Xtext-specific source model validators on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findXtextSourceModelValidators(implementationPackage: String)
    : Map<String, List<ClassInfo>> {
    val validatorsForExtensions = mutableMapOf<String, MutableList<ClassInfo>>()

    // An Xtext-specific source model validator is annotated with @SourceModelValidator and validationMode set to XTEXT,
    // and extends de.fhdo.lemma.model_processing.validation.AbstractXtextSourceModelValidator
    val xtextSourceModelValidators = findAnnotatedClasses(implementationPackage, SourceModelValidator::class)
        .filter {
            if (!it.extendsSuperclass(AbstractXtextSourceModelValidator::class.java.name))
                return@filter false

            val annotationParameters = it.annotationInfo[SourceModelValidator::class]!!.parameterValues
            val validationMode = annotationParameters["validationMode"] as AnnotationEnumValue
            return@filter validationMode.valueName == SourceModelValidationMode.XTEXT.name
        }

    // Add found validators to result map for the file extensions they support
    for (validatorInfo in xtextSourceModelValidators) {
        val annotationParameters = validatorInfo.annotationInfo[SourceModelValidator::class]!!.parameterValues
        @Suppress("UNCHECKED_CAST")
        val supportedFileExtensions = annotationParameters["supportedFileExtensions"] as Array<String>
        supportedFileExtensions.forEach {
            if (!validatorsForExtensions.containsKey(it))
                validatorsForExtensions[it] = mutableListOf(validatorInfo)
            else
                validatorsForExtensions[it]!!.add(validatorInfo)
        }
    }

    return validatorsForExtensions
}