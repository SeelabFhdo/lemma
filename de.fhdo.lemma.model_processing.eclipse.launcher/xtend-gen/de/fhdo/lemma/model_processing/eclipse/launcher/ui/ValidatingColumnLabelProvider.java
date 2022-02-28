package de.fhdo.lemma.model_processing.eclipse.launcher.ui;

import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Typed column label provider that considers element validation, and displays an image and tooltip
 * depending on validation results.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class ValidatingColumnLabelProvider<T extends Object> extends ColumnLabelProvider {
  /**
   * Get element text (generic form)
   */
  @Override
  public final String getText(final Object element) {
    return this.getElementText(((T) element));
  }
  
  /**
   * Get element text (typed form)
   */
  public abstract String getElementText(final T element);
  
  /**
   * Get element image. Returns an Image instance for FieldDecorationRegistry.DEC_ERROR in case
   * validate() threw an IllegalArgumentException, thereby indicating that the validation failed.
   * Returns null in case the validation succeeded.
   */
  @Override
  public final Image getImage(final Object element) {
    Image _xtrycatchfinallyexpression = null;
    try {
      Object _xblockexpression = null;
      {
        this.validate(((T) element));
        _xblockexpression = null;
      }
      _xtrycatchfinallyexpression = ((Image)_xblockexpression);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        _xtrycatchfinallyexpression = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Typed element validation. The method is expected to throw an IllegalArgumentException with a
   * descriptive error message in case the element is invalid.
   */
  public abstract void validate(final T element) throws IllegalArgumentException;
  
  /**
   * Get element tooltip. Returns the exception message in case validate() threw an
   * IllegalArgumentException, thereby indicating that the validation failed. Returns null in case
   * the validation succeeded.
   */
  @Override
  public final String getToolTipText(final Object element) {
    String _xtrycatchfinallyexpression = null;
    try {
      Object _xblockexpression = null;
      {
        this.validate(((T) element));
        _xblockexpression = null;
      }
      _xtrycatchfinallyexpression = ((String)_xblockexpression);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException ex = (IllegalArgumentException)_t;
        _xtrycatchfinallyexpression = ex.getMessage();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
