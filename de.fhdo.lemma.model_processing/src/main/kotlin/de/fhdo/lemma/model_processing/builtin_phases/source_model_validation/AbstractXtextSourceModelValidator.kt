package de.fhdo.lemma.model_processing.builtin_phases.source_model_validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.callAnnotatedMethods
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.withType
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import java.io.InputStream
import kotlin.reflect.jvm.isAccessible

/**
 * Abstract superclass for all Xtext-based source model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractXtextSourceModelValidator : AbstractDeclarativeValidator(), SourceModelValidatorI {
    /**
     * Execute validator
     */
    operator fun invoke(fileToValidate: String, inputStream: InputStream) : List<ValidationResult> {
        // Register language whose models shall be validated
        val languageNamespace = getLanguageNamespace()
        registerLanguage(languageNamespace)

        val languageDescription = when (val langDesc = LanguageDescriptions.getLanguageDescription(languageNamespace)) {
            !is XtextLanguageDescription ->
                throw PhaseException("Language must be of type ${XtextLanguageDescription::class.simpleName}")
            else -> langDesc
        }

        // Configure the Ecore EValidator registry
        EValidator.Registry.INSTANCE[languageDescription.eInstance] = this

        // Load Xtext resource
        val validationResource = loadXtextResource(languageDescription.languageSetup, fileToValidate, inputStream)

        // Set all check methods as accessible so that they can be private in the implementer
        findAnnotatedMethods(Check::class).forEach { it.isAccessible = true }

        // Call @Before methods in concrete subclasses
        this.callAnnotatedMethods(Before::class, validationResource withType Resource::class)

        // Execute the Xtext validator
        val validationIssues = validationResource.validate()

        // Return resulting Xtext issues as ValidationResult instances
        return validationIssues.map { it.toValidationResult() }
    }

    /**
     * Prevent direct invocation based on filepath
     */
    override fun invoke(fileToValidate: String) : List<ValidationResult> {
        throw IllegalCallerException("Xtext validators must not be called directly with only a single file argument")
    }
}

/**
 * Internal helper to load a file as an Xtext resource.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun loadXtextResource(languageSetup: ISetup, filepath: String, inputStream: InputStream) : XtextResource {
    val injector = languageSetup.createInjectorAndDoEMFRegistration()
    val resourceSet = injector.getInstance(XtextResourceSet::class.java)
    resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, java.lang.Boolean.TRUE)
    val resource = resourceSet.createResource(URI.createURI(filepath))
    resource.load(inputStream, resourceSet.loadOptions)
    return resource as XtextResource
}

/**
 * Convenience extension method of [XtextResource] to execute validation on it
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun XtextResource.validate() =
    resourceServiceProvider.resourceValidator.validate(this, CheckMode.ALL, CancelIndicator.NullImpl)

/**
 * /**
 * Convenience extension method of [Issue] to convert an instance of it to a [ValidationResult] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
*/
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