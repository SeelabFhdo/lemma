package de.fhdo.lemma.intermediate.transformations

import org.eclipse.emf.ecore.EObject
import java.util.Collections
import java.util.List
import com.google.common.base.Predicate
import com.google.common.base.Function

/**
 * Abstract class for implementing validators used in model-to-model transformation from input to
 * output intermediate models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractInputModelValidator<T extends EObject> {
    protected String absoluteModelPath

    /**
     * Validate input model
     */
    def validateInputModel(String absoluteModelPath, T modelRoot) {
        return validateInputModel(absoluteModelPath, modelRoot, null)
    }

    /**
     * Validate input model with warning callback
     */
    def validateInputModel(String absoluteModelPath, T modelRoot,
        Predicate<IntermediateTransformationException> warningCallback) {
        this.absoluteModelPath = absoluteModelPath
        checkInputModelForErrors(modelRoot)

        val warningFunctions = registerWarningFunctions()
        if (warningFunctions === null) {
            return true
        }

        for (warningFunction : warningFunctions)
            try {
                warningFunction.apply(modelRoot)
            } catch (IntermediateTransformationException ex) {
                if (warningCallback !== null && !warningCallback.apply(ex))
                    // User wants to abort current transformation
                    return false
            }

        return true
    }

    /**
     * Check input model for errors. May be overridden by sub-classes to perform custom error checks
     * on input model.
     */
    protected def void checkInputModelForErrors(T modelRoot)
        throws IntermediateTransformationException { }

    /**
     * Get functions to check input model and issue warnings. May be overridden by sub-classes to
     * register warning functions.
     */
    protected def List<Function<T, Void>> registerWarningFunctions() {
        return Collections.EMPTY_LIST
    }

    /**
     * Throw a validation warning
     */
    protected final def Void warning(String message) {
        throw new IntermediateTransformationException(message,
            IntermediateTransformationExceptionKind.WARNING,
            IntermediateTransformationPhase.INPUT_MODEL_VALIDATION)
    }

    /**
     * Throw a validation error
     */
    protected final def Void error(String message) {
        throw new IntermediateTransformationException(message,
            IntermediateTransformationExceptionKind.ERROR,
            IntermediateTransformationPhase.INPUT_MODEL_VALIDATION)
    }
}