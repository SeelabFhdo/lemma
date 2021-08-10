package de.fhdo.lemma.model_processing.phases.validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.callAnnotatedMethods
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.withType
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import java.lang.IllegalArgumentException
import java.lang.reflect.Method
import kotlin.reflect.jvm.isAccessible

/**
 * Abstract superclass for all Xtext-based model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractXtextModelValidator : AbstractDeclarativeValidator(), ModelValidatorI {
    // This attribute must not be of type Kotlin Array. Otherwise, the discovery of @Check methods in Java-based
    // concrete validators will fail with a KotlinReflectionInternalError from the mapPropertySignature() method of the
    // RuntimeTypeMapper Singleton from Kotlin's reflect library. The reason for this error is probably that
    // RuntimeTypeMapper does not support resolution of Java fields with Kotlin's built-ins Array type, yet (the
    // reflective javaElement field will be null for such fields which ultimately causes the error in
    // mapPropertySignature()).
    private lateinit var phaseArguments: List<String>

    private var relevantModelElements: Collection<*>? = null

    private class RelevantElementsAwareValidationMethodWrapper(
        private val validatorInstance: AbstractDeclarativeValidator?,
        method: Method?
    ) : MethodWrapper(validatorInstance, method) {
        override fun invoke(state: State?) {
            if (validatorInstance is AbstractXtextModelValidator &&
                validatorInstance.relevantModelElements != null &&
                state?.currentObject !in validatorInstance.relevantModelElements!!)
                return

            super.invoke(state)
        }
    }

    override fun createMethodWrapper(instanceToUse: AbstractDeclarativeValidator?, method: Method?): MethodWrapper {
        return RelevantElementsAwareValidationMethodWrapper(instanceToUse, method)
    }

    // Xtext-based model validation is solely driven by file extensions, i.e., it requires the implementation of
    // getSupportedFileExtensions() from the [ModelValidatorI] interface
    final override fun getLanguageNamespace() = ""

    /**
     * Setter for arguments that concern the phase
     */
    override fun setPhaseArguments(phaseArguments: Array<String>) {
        this.phaseArguments = phaseArguments.toList()
    }

    /**
     * Getter for phase arguments. May be used by concrete implementers.
     */
    override fun getPhaseArguments() = phaseArguments.toTypedArray()

    /**
     * Execute validator
     */
    override fun invoke(validationResource: Resource, languageDescription: LanguageDescription,
        relevantModelElements: Collection<*>?) : List<ValidationResult> {
        if (validationResource !is XtextResource)
            throw IllegalArgumentException("Validation resource is of type " +
                "${validationResource::class.java.simpleName} instead of ${XtextResource::class.java.simpleName}")

        this.relevantModelElements = relevantModelElements

        // Configure the Ecore EValidator registry
        EValidator.Registry.INSTANCE[languageDescription.eInstance] = this

        // Set all check methods as accessible so that they can be private in the implementer
        findAnnotatedMethods(Check::class).forEach { it.isAccessible = true }

        // Call @Before methods in concrete subclasses
        this.callAnnotatedMethods(Before::class, validationResource withType Resource::class)

        // Execute the Xtext validator
        val validationIssues = validationResource.validate()

        // Return resulting Xtext issues as ValidationResult instances
        return validationIssues.map { it.toValidationResult() }
    }
}

/**
 * Convenience extension method of [XtextResource] to execute validation on it
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun XtextResource.validate() =
    resourceServiceProvider.resourceValidator.validate(this, CheckMode.ALL, CancelIndicator.NullImpl)

/**
 * Convenience extension method of [Issue] to convert an instance of it to a [ValidationResult] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Issue.toValidationResult() : ValidationResult {
    val resultType = when(this.severity) {
        Severity.ERROR -> ValidationResultType.ERROR
        Severity.INFO -> ValidationResultType.INFO
        Severity.WARNING -> ValidationResultType.WARNING
        else -> ValidationResultType.IGNORE
    }

    return ValidationResult(
        this.lineNumber,
        this.column,
        this.offset,
        this.length,
        this.message,
        resultType
    )
}