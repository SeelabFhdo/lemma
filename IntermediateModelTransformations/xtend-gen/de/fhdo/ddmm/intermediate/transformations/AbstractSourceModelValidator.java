package de.fhdo.ddmm.intermediate.transformations;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationPhase;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Abstract class for implementing validators used in model-to-model transformation from source to
 * target intermediate models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractSourceModelValidator<T extends EObject> {
  protected String absoluteModelPath;
  
  private Predicate<IntermediateTransformationException> warningCallback;
  
  /**
   * Validate source model
   */
  public boolean validateSourceModel(final String absoluteModelPath, final T modelRoot) {
    return this.validateSourceModel(absoluteModelPath, modelRoot, null);
  }
  
  /**
   * Validate source model with warning callback
   */
  public boolean validateSourceModel(final String absoluteModelPath, final T modelRoot, final Predicate<IntermediateTransformationException> warningCallback) {
    try {
      this.absoluteModelPath = absoluteModelPath;
      this.checkSourceModelForErrors(modelRoot);
      final List<Function<T, Void>> warningFunctions = this.registerWarningFunctions();
      if ((warningFunctions == null)) {
        return true;
      }
      this.warningCallback = warningCallback;
      for (final Function<T, Void> warningFunction : warningFunctions) {
        try {
          warningFunction.apply(modelRoot);
        } catch (final Throwable _t) {
          if (_t instanceof IntermediateTransformationException) {
            final IntermediateTransformationException ex = (IntermediateTransformationException)_t;
            if (((warningCallback != null) && (!warningCallback.apply(ex)))) {
              return false;
            }
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Check source model for errors. May be overridden by sub-classes to perform custom error
   * checks on source model.
   */
  protected void checkSourceModelForErrors(final T modelRoot) throws IntermediateTransformationException {
  }
  
  /**
   * Get functions to check source model and issue warnings. May be overridden by sub-classes to
   * register warning functions.
   */
  protected List<Function<T, Void>> registerWarningFunctions() {
    return Collections.EMPTY_LIST;
  }
  
  /**
   * Throw a validation warning
   */
  protected final Void warning(final String message) {
    try {
      throw new IntermediateTransformationException(message, 
        IntermediateTransformationExceptionKind.WARNING, 
        IntermediateTransformationPhase.SOURCE_MODEL_VALIDATION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Throw a validation error
   */
  protected final Void error(final String message) {
    try {
      throw new IntermediateTransformationException(message, 
        IntermediateTransformationExceptionKind.ERROR, 
        IntermediateTransformationPhase.SOURCE_MODEL_VALIDATION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
