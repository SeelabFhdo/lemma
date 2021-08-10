package de.fhdo.lemma.model_processing.phases.validation

import de.fhdo.lemma.model_processing.annotations.After
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.BeforeCheck
import de.fhdo.lemma.model_processing.annotations.ExcludeSubtypes
import de.fhdo.lemma.model_processing.annotations.RethrowExceptions
import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.callAnnotatedMethods
import de.fhdo.lemma.model_processing.debug
import de.fhdo.lemma.model_processing.ecoreMainInterface
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.withType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import java.lang.Exception
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.jvmErasure

/**
 * Abstract superclass for XMI model validators. XMI model validation currently only supports declarative validation.
 * This corresponds to the behavior of Xtext-based source model validators (see [AbstractXtextModelValidator]), i.e.,
 * validation is based on implementing [AbstractDeclarativeValidator] and annotating validation methods with [Check].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
abstract class AbstractXmiDeclarativeValidator : AbstractDeclarativeValidator(), ModelValidatorI {
    // The currently validated object
    private lateinit var validatedObject: EObject

    // Methods with the @Check annotation in concrete subclasses
    private val checkMethods = findAnnotatedMethods(Check::class).filter { it.parameters.size == 2 }

    // Methods with the @BeforeCheck annotation in concrete subclasses. These methods have to be executed prior to each
    // call to a validation method annotated with @Check. An @BeforeCheck method must take a single parameter of type
    // KFunction, which receives the @Check method to be invoked, and return a boolean value, which indicates whether
    // the @Check method shall be invoked.
    private val beforeCheckMethods = findAnnotatedMethods(BeforeCheck::class).filter {
            // First parameter is Validator instance
            it.parameters.size == 2 &&
            it.parameters[1].type == KFunction::class.starProjectedType &&
            it.returnType == Boolean::class.starProjectedType
        }

    // This attribute must not be of type Kotlin Array. Otherwise, the discovery of @Check methods in Java-based
    // concrete validators will fail with a KotlinReflectionInternalError from the mapPropertySignature() method of the
    // RuntimeTypeMapper Singleton from Kotlin's reflect library. The reason for this error is probably that
    // RuntimeTypeMapper does not support resolution of Java fields with Kotlin's built-ins Array type, yet (the
    // reflective javaElement field will be null for such fields which ultimately causes the error in
    // mapPropertySignature()).
    private lateinit var phaseArguments: List<String>

    // XMI model validation is solely driven by language namespaces, i.e., it requires the implementation of
    // getLanguageNamespace() from the [ModelValidatorI] interface
    final override fun getSupportedFileExtensions() = emptySet<String>()

    /**
     * Internal setter for arguments that concern the phase
     */
    override fun setPhaseArguments(phaseArguments: Array<String>) {
        this.phaseArguments = phaseArguments.toList()
    }

    /**
     * External getter for phase arguments. May be used by concrete implementers.
     */
    override fun getPhaseArguments() = phaseArguments.toTypedArray()

    /**
     * Execute validator with the loaded model resource
     */
    override fun invoke(validationResource: Resource, languageDescription: LanguageDescription,
        relevantModelElements: Collection<*>?) : List<ValidationResult> {
        // Setup MessageAcceptor to collect validation results
        messageAcceptor = ValidationResultCollector()

        // Call @Before methods in concrete subclasses
        this.callAnnotatedMethods(Before::class, validationResource withType Resource::class)

        // Execute the validator
        validate(validationResource, relevantModelElements)

        // Call @After methods in concrete subclasses
        this.callAnnotatedMethods<Nothing>(After::class)

        // Return validation results
        return (messageAcceptor as ValidationResultCollector).validationResults
    }

    /**
     * Perform the actual validations. Basically, XMI model validation is consistent with the behavior of
     * [AbstractDeclarativeValidator]. However, it is not possible to directly employ [AbstractDeclarativeValidator] for
     * XMI model validation because XMI models are not based on Xtext. Therefore, we mimic the behavior of
     * [AbstractDeclarativeValidator] in that we invoke all methods with the [Check] annotation in concrete
     * subclasses of [AbstractXmiDeclarativeValidator] on model elements from XMI models.
     */
    private fun validate(resource: Resource, relevantModelElements: Collection<*>?) {
        val checkMethodsPerInstanceType = HashMap<KType, List<KFunction<*>>>()
        val iter = relevantModelElements?.iterator() ?: resource.allContents
        while (iter.hasNext()) {
            val element = iter.next()
            if (element == null)
                continue
            else if (element !is EObject) {
                debug {
                    "\t\t- ${this::class.java.name}: Element $element is not of type ${EObject::class.java.name} but "
                    "${element::class.java.name}. It will therefore not be validated."
                }
                continue
            }

            val elementType = element::class.starProjectedType
            val elementInterface = element.ecoreMainInterface()

            // Find applicable check methods if they have not been identified for the element type already
            if (elementType !in checkMethodsPerInstanceType)
                checkMethodsPerInstanceType[elementType] = findApplicableCheckMethods(elementType, elementInterface)

            val checkMethods = checkMethodsPerInstanceType[elementType]!!
            checkMethods.forEach { checkMethod ->
                try {
                    validatedObject = element
                    // Enable invocation of private check methods
                    checkMethod.isAccessible = true
                    // Call before-check-methods on check method. If any of the before-check-methods returns false,
                    // the check method will not be executed.
                    if (checkMethod.callBeforeCheckMethods(this, beforeCheckMethods))
                        checkMethod.call(this, element)
                } catch (ex: Exception) {
                    // Exceptions are swallowed, except when the check method has the @RethrowExceptions annotation
                    if (checkMethod.annotations.any { it.annotationClass == RethrowExceptions::class })
                        throw(ex)
                }
            }
        }
    }

    /**
     * Find all check methods that are able to validate the given [elementType] or [elementInterface]
     */
    private fun findApplicableCheckMethods(elementType: KType, elementInterface: Class<out EObject>?)
        = checkMethods.filter { method ->
            val validatedElementType = method.parameters[1].type
            val validatedElementInterface = validatedElementType.jvmErasure.java

            // A check method is applicable when the type of its first parameter equals or is a subtype of either the
            // given element type or element interface. However, check methods may use the @ExcludeSubtypes annotation
            // to ensure that a check method only applies when the type of its first parameter is exactly equal (and not
            // a subtype) to either the given element type or element interface.
            elementType == validatedElementType ||
            elementInterface == validatedElementInterface ||
                elementType.isSubtypeOf(validatedElementType) &&
                method.annotations.none { it.annotationClass == ExcludeSubtypes::class }
        }

    /**
     * Call [BeforeCheck] methods on this [KFunction]. Returns false if any of the [BeforeCheck] methods returns false.
     */
    private fun KFunction<*>.callBeforeCheckMethods(validatorInstance: AbstractXmiDeclarativeValidator,
        beforeCheckMethods: List<KFunction<*>>) : Boolean {
        for (beforeCheckMethod in beforeCheckMethods) {
            beforeCheckMethod.isAccessible = true
            val callResult = beforeCheckMethod.call(validatorInstance, this) as Boolean
            if (!callResult)
                return false
        }
        return true
    }

    /*
     * The following methods represent overridden versions of their counterparts in [AbstractDeclarativeValidator]. The
     * overrides are necessary, because we control the validated object ourselves. In [AbstractDeclarativeValidator] an
     * instance of the currently validated object is hold in the currentObject variable and part of the validator's
     * state. However, as we do not perform the validation in an Xtext-enabled environment, the state object for the
     * validator instance is not created. The following methods therefore point to our validatedObject, i.e.,
     * currentObject in [AbstractDeclarativeValidator] (which is always null in non-Xtext-enabled environments) is
     * safely ignored.
     */

    /**
     * Yield an information message for the currently validated object
     */
    override fun info(message: String?, feature: EStructuralFeature?, index: Int, code: String?,
        vararg issueData: String?) {
        info(message, validatedObject, feature, index, code, *issueData)
    }

    /**
     * Yield an information message for the currently validated object
     */
    override fun info(message: String?, feature: EStructuralFeature?, code: String?, vararg issueData: String?) {
        info(message, validatedObject, feature, -1, code, *issueData)
    }

    /**
     * Yield a warning for the currently validated object
     */
    override fun warning(message: String?, feature: EStructuralFeature?, code: String?, vararg issueData: String?) {
        warning(message, validatedObject, feature, -1, code, *issueData)
    }

    /**
     * Yield a warning for the currently validated object
     */
    override fun warning(message: String?, feature: EStructuralFeature?, index: Int, code: String?,
        vararg issueData: String?) {
        warning(message, validatedObject, feature, index, code, *issueData)
    }

    /**
     * Yield an error for the currently validated object
     */
    override fun error(message: String?, feature: EStructuralFeature?, index: Int, code: String?,
        vararg issueData: String?) {
        error(message, validatedObject, feature, index, code, *issueData)
    }

    /**
     * Add an issue code to the currently validated object
     */
    override fun addIssueToState(issueCode: String?, message: String?, feature: EStructuralFeature?) {
        addIssue(message, validatedObject, feature, issueCode, null)
    }

    /**
     * Get the current object
     */
    override fun getCurrentObject() = validatedObject
}

/**
 * Implementation of [ValidationMessageAcceptor] that collects [ValidationResult] instances for their later processing
 * as expected by the Model Processor Framework.
 */
private class ValidationResultCollector(val validationResults: MutableList<ValidationResult> = mutableListOf())
    : ValidationMessageAcceptor {

    /**
     * Collect error
     */
    override fun acceptError(message: String?, eObject: EObject?, feature: EStructuralFeature?, index: Int,
        code: String?, vararg issueData: String?) {
        validationResults += ValidationResult(message = message ?: "", type = ValidationResultType.ERROR)
    }

    /**
     * Collect error
     */
    override fun acceptError(message: String?, eObject: EObject?, offset: Int, length: Int, code: String?,
        vararg issueData: String?) {
        validationResults += ValidationResult(offset = offset, length = length, message = message ?: "",
            type = ValidationResultType.ERROR)
    }

    /**
     * Collect information message
     */
    override fun acceptInfo(message: String?, eObject: EObject?, feature: EStructuralFeature?, index: Int,
        code: String?, vararg issueData: String?) {
        validationResults += ValidationResult(message = message ?: "", type = ValidationResultType.INFO)
    }

    /**
     * Collect information message
     */
    override fun acceptInfo(message: String?, eObject: EObject?, offset: Int, length: Int, code: String?,
        vararg issueData: String?) {
        validationResults += ValidationResult(offset = offset, length = length, message = message ?: "",
            type = ValidationResultType.INFO)
    }

    /**
     * Collect warning
     */
    override fun acceptWarning(message: String?, eObject: EObject?, feature: EStructuralFeature?, index: Int,
        code: String?, vararg issueData: String?) {
        validationResults += ValidationResult(message = message ?: "", type = ValidationResultType.WARNING)
    }

    /**
     * Collect warning
     */
    override fun acceptWarning(message: String?, eObject: EObject?, offset: Int, length: Int, code: String?,
        vararg issueData: String?) {
        validationResults += ValidationResult(offset = offset, length = length, message = message ?: "",
            type = ValidationResultType.WARNING)
    }
}