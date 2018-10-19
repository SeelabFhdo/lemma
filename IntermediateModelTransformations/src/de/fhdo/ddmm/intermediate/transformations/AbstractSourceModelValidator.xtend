package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.emf.ecore.EObject
import java.util.Collections
import java.util.List
import com.google.common.base.Predicate
import com.google.common.base.Function

/**
 * Abstract class for implementing validators used in model-to-model transformation from source to
 * target intermediate models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractSourceModelValidator<T extends EObject> {
    protected String absoluteModelPath
    private Predicate<IntermediateTransformationException> warningCallback

    /**
     * Validate source model
     */
    def validateSourceModel(String absoluteModelPath, T modelRoot) {
        return validateSourceModel(absoluteModelPath, modelRoot, null)
    }

    /**
     * Validate source model with warning callback
     */
    def validateSourceModel(String absoluteModelPath, T modelRoot,
        Predicate<IntermediateTransformationException> warningCallback) {
        this.absoluteModelPath = absoluteModelPath
        checkSourceModelForErrors(modelRoot)

        val warningFunctions = registerWarningFunctions()
        if (warningFunctions === null) {
            return true
        }
        this.warningCallback = warningCallback
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
     * Check source model for errors. May be overridden by sub-classes to perform custom error
     * checks on source model.
     */
    protected def void checkSourceModelForErrors(T modelRoot)
        throws IntermediateTransformationException { }

    /**
     * Get functions to check source model and issue warnings. May be overridden by sub-classes to
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
            IntermediateTransformationPhase.SOURCE_MODEL_VALIDATION)
    }

    /**
     * Throw a validation error
     */
    protected final def Void error(String message) {
        throw new IntermediateTransformationException(message,
            IntermediateTransformationExceptionKind.ERROR,
            IntermediateTransformationPhase.SOURCE_MODEL_VALIDATION)
    }
}