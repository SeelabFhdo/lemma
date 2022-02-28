package de.fhdo.lemma.model_processing.eclipse.launcher.ui

import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.fieldassist.FieldDecorationRegistry

/**
 * Typed column label provider that considers element validation, and displays an image and tooltip
 * depending on validation results.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class ValidatingColumnLabelProvider<T> extends ColumnLabelProvider {
    /**
     * Get element text (generic form)
     */
    final override getText(Object element) {
        return (element as T).elementText
    }

    /**
     * Get element text (typed form)
     */
    abstract def String getElementText(T element)

    /**
     * Get element image. Returns an Image instance for FieldDecorationRegistry.DEC_ERROR in case
     * validate() threw an IllegalArgumentException, thereby indicating that the validation failed.
     * Returns null in case the validation succeeded.
     */
    final override getImage(Object element) {
        return try {
            (element as T).validate()
            null
        } catch (IllegalArgumentException ex) {
            FieldDecorationRegistry.^default
                .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
                .image
        }
    }

    /**
     * Typed element validation. The method is expected to throw an IllegalArgumentException with a
     * descriptive error message in case the element is invalid.
     */
    abstract def void validate(T element) throws IllegalArgumentException

    /**
     * Get element tooltip. Returns the exception message in case validate() threw an
     * IllegalArgumentException, thereby indicating that the validation failed. Returns null in case
     * the validation succeeded.
     */
    final override getToolTipText(Object element) {
        return try {
            (element as T).validate()
            null
        } catch (IllegalArgumentException ex) {
            ex.message
        }
    }
}