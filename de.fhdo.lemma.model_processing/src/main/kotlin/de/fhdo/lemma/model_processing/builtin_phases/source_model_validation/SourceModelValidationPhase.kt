package de.fhdo.lemma.model_processing.builtin_phases.source_model_validation

import de.fhdo.lemma.model_processing.annotations.InitialModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.RequiresBasicCommandLineOptions
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.annotations.get
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.builtin_phases.ValidationEndedWithErrorsException
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.builtin_phases.print
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import io.github.classgraph.AnnotationEnumValue
import io.github.classgraph.ClassInfo
import java.io.InputStream
import java.lang.IllegalArgumentException

/**
 * Support modes for source model validation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class SourceModelValidationMode {
    BASIC,
    XTEXT
}

/**
 * Implementation of the model processor's source model validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@InitialModelProcessingPhase("source_model_validation")
@RequiresBasicCommandLineOptions(BasicOption.SOURCE_MODEL_FILE)
internal class SourceModelValidationPhase : AbstractModelProcessingPhase() {
    /**
     * Static companion methods
     */
    companion object {
        internal lateinit var phaseArguments: Array<String>

        /**
         * Execute validator targeting basic model validation. Compared to an Xtext-supporting source model validator, a
         * basic source model validator just gets passed the path to the source model file.
         */
        internal fun executeBasicValidator(validatorInfo: ClassInfo, sourceModelFile: String): List<ValidationResult> {
            validatorInfo.extendsImplementsOrException(
                "Designated source model validator",
                expectedInterface = SourceModelValidatorI::class
            )

            val validatorInstance = validatorInfo
                .loadClass(SourceModelValidatorI::class.java)
                .getDeclaredConstructor()
                .newInstance()
            validatorInstance.setPhaseArguments(phaseArguments)

            return validatorInstance(sourceModelFile)
        }

        /**
         * Execute an Xtext-supporting validator. An Xtext-supporting validator is based on the Xtext annotation-based
         * validation mechanism. That is, Xtext's internal mechanism is leveraged and the validator gets the model
         * element instances passed to methods annotated with [org.eclipse.xtext.validation.Check].
         */
        internal fun executeXtextValidator(validatorInfo: ClassInfo, documentUri: String, inputStream: InputStream)
                : List<ValidationResult> {
            validatorInfo.extendsImplementsOrException(
                "Designated source model validator",
                expectedSuperclass = AbstractXtextSourceModelValidator::class
            )

            val validatorInstance = validatorInfo
                .loadClass(AbstractXtextSourceModelValidator::class.java)
                .getDeclaredConstructor()
                .newInstance()
            validatorInstance.setPhaseArguments(phaseArguments)

            return validatorInstance(documentUri, inputStream)
        }

        /**
         * Convenience version of [executeBasicValidator] that takes the path of the source model file as parameter
         */
        internal fun executeXtextValidator(validatorInfo: ClassInfo, sourceModelFile: String) : List<ValidationResult> {
            val file = sourceModelFile.asFile()
            return executeXtextValidator(validatorInfo, file.absolutePath, file.inputStream())
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        val sourceModelFile = BasicCommandLine.sourceModelFile!!
        val fileExtension = sourceModelFile.asFile().extension
        if (fileExtension.isEmpty())
            throw IllegalArgumentException("Source model file must have an extension")

        // Find all source model validators on the classpath that are capable of handling the source model file's type
        // (identified by its extension)
        val validators = findSourceModelValidators(processorImplementationPackage, fileExtension)

        // Set phase arguments for validators to pass them to implementers
        phaseArguments = args

        // Execute the found source model validators depending on the validation mode they support
        val validationResults = mutableListOf<ValidationResult>()
        validators.forEach {
            val validationMode = it.annotationInfo[SourceModelValidator::class]!!
                .parameterValues["validationMode"].value as AnnotationEnumValue
            validationResults.addAll(
                when (validationMode.valueName) {
                    SourceModelValidationMode.XTEXT.name -> executeXtextValidator(it, sourceModelFile)
                    else -> executeBasicValidator(it, sourceModelFile)
                }
            )
        }

        // Print the validation results and exit with an error code, if there were errors among them
        validationResults.print(sourceModelFile)
        if (validationResults.any { it.type == ValidationResultType.ERROR })
            throw ValidationEndedWithErrorsException()
    }

    /**
     * Helper to find source model validators on the classpath that support a given model type (identified by the file
     * extension)
     */
    private fun findSourceModelValidators(implementationPackage: String, fileExtension: String) =
        findAnnotatedClasses(implementationPackage, SourceModelValidator::class)
            .filter {
                val annotationParameters = it.annotationInfo[SourceModelValidator::class]!!.parameterValues
                @Suppress("UNCHECKED_CAST")
                val supportedFileExtensions = annotationParameters["supportedFileExtensions"].value as Array<String>
                supportedFileExtensions.contains(fileExtension.toLowerCase())
            }
}