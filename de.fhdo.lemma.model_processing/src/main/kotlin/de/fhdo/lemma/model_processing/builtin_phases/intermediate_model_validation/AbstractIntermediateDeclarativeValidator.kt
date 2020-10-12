package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.After
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.BeforeCheck
import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.callAnnotatedMethods
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

/**
 * Abstract superclass for all intermediate model validators. Intermediate model validation currently only supports
 * declarative validation. This corresponds to the behavior of Xtext-based source model validators (see
 * [de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator]), i.e.,
 * validation is based on implementing [AbstractDeclarativeValidator] and annotating validation methods with [Check].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractIntermediateDeclarativeValidator : AbstractDeclarativeValidator() {
    // The currently validated object
    private lateinit var validatedObject: EObject

    /**
     * Get namespace of intermediate model language
     */
    abstract fun getLanguageNamespace() : String

    /**
     * Execute validator with the loaded model resource
     */
    operator fun invoke(resource: Resource, relevantModelElements: Collection<EObject>?) : List<ValidationResult> {
        // Setup MessageAcceptor to collect validation results
        messageAcceptor = ValidationResultCollector()

        // Call @Before methods in concrete subclasses
        this.callAnnotatedMethods(Before::class, resource withType Resource::class)

        // Execute the validator
        validate(resource, relevantModelElements)

        // Call @After methods in concrete subclasses
        this.callAnnotatedMethods<Nothing>(After::class)

        // Return validation results
        return (messageAcceptor as ValidationResultCollector).validationResults
    }

    /**
     * Perform the actual validations. Basically, validation is consistent with the behavior of
     * [AbstractDeclarativeValidator]. However, [AbstractDeclarativeValidator] cannot be directly employed, because
     * intermediate models are not based on Xtext. Therefore, we mimic the behavior of [AbstractDeclarativeValidator] in
     * that we collect all methods being annotated with [Check] in concrete subclasses and call them by passing model
     * element instances from intermediate models as their first parameters.
     */
    private fun validate(resource: Resource, relevantModelElements: Collection<EObject>?) {
        /* Collect all methods in the concrete subclass that are annotated with Check and exhibit only one parameter */
        // First parameter is Validator instance
        val checkMethods = this.findAnnotatedMethods(Check::class).filter { it.parameters.size == 2 }
        val checkMethodsPerInstanceType = HashMap<KType, MutableList<KFunction<*>>>()
        checkMethods.forEach {
            val instanceType = it.parameters[1].type
            var checkMethodsForType = checkMethodsPerInstanceType[instanceType]
            if (checkMethodsForType == null) {
                checkMethodsForType = mutableListOf()
                checkMethodsPerInstanceType[instanceType] = checkMethodsForType
            }
            checkMethodsForType.add(it)
        }

        /*
         * Collect all relevant model element instances that can be checked by the set of previously collected check
         * methods
         */
        val modelElementInstances = HashMap<KType, MutableList<EObject>>()
        val iter = relevantModelElements?.iterator() ?: resource.allContents
        while (iter.hasNext()) {
            val modelElementInstance = iter.next()
            val elementType = modelElementInstance::class.starProjectedType
            val checkedInstanceType =  checkMethodsPerInstanceType.keys.find { elementType.isSubtypeOf(it) }
            if (checkedInstanceType != null) {
                var relevantInstancesOfType = modelElementInstances[checkedInstanceType]
                if (relevantInstancesOfType == null) {
                    relevantInstancesOfType = mutableListOf()
                    modelElementInstances[checkedInstanceType] = relevantInstancesOfType
                }
                relevantInstancesOfType.add(modelElementInstance)
            }
        }

        /* Call the identified check methods on the model element instances */
        val beforeCheckMethods = findBeforeCheckMethods()
        checkMethodsPerInstanceType.forEach { (instanceType, checkMethods) ->
            val instancesToCheck = modelElementInstances[instanceType]
            instancesToCheck?.forEach { instance ->
                checkMethods.forEach { checkMethod ->
                    try {
                        validatedObject = instance
                        // Enable invocation of private check methods
                        checkMethod.isAccessible = true
                        // Call before-check-methods on check method. If any of the before-check-methods returns false,
                        // the check method will not be executed.
                        if (checkMethod.callBeforeCheckMethods(this, beforeCheckMethods))
                            checkMethod.call(this, instance)
                    } catch (ex: Exception) {
                        // Swallow exceptions
                    }
                }
            }
        }
    }

    /**
     * Find methods that are annotated with [BeforeCheck] and thus have to be executed prior to each call to a
     * validation method annotated with [Check]. A [BeforeCheck] method must take a single parameter of type
     * [KFunction], which receives the [Check] method to be invoked, and return a [Boolean], which indicates whether the
     * [Check] method shall be invoked.
     */
    private fun findBeforeCheckMethods()
        = this.findAnnotatedMethods(BeforeCheck::class).filter {
            // First parameter is Validator instance
            it.parameters.size == 2 &&
            it.parameters[1].type == KFunction::class.starProjectedType &&
            it.returnType == Boolean::class.starProjectedType
        }

    /**
     * Call [BeforeCheck] methods on this [KFunction]. Returns false if any of the [BeforeCheck] methods returns false.
     */
    private fun KFunction<*>.callBeforeCheckMethods(validatorInstance: AbstractIntermediateDeclarativeValidator,
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
     * Add a issue code to the currently validated object
     */
    override fun addIssueToState(issueCode: String?, message: String?, feature: EStructuralFeature?) {
        addIssue(message, validatedObject, feature, issueCode, null)
    }

    /**
     * Get the current object
     */
    override fun getCurrentObject(): EObject {
        return validatedObject
    }
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