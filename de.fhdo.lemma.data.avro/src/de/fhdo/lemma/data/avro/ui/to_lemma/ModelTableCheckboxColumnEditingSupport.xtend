package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.viewers.EditingSupport
import com.google.common.base.Predicate
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.CheckboxCellEditor
import org.eclipse.swt.SWT
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog.LemmaModelKind

/**
 * Editing support for the checkbox column in the dialog for LEMMA paths specification.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTableCheckboxColumnEditingSupport extends EditingSupport {
    TableViewer tableViewer
    Predicate<Pair<LemmaModelKind, Boolean>> newValueValidator

    /**
     * Constructor
     */
    new(TableViewer tableViewer, Predicate<Pair<LemmaModelKind, Boolean>> newValueValidator) {
        super(tableViewer)
        this.tableViewer = tableViewer
        this.newValueValidator = newValueValidator
    }

    /**
     * Editable flag
     */
    override protected canEdit(Object element) {
        return true
    }

    /**
     * Return cell editor
     */
    override protected getCellEditor(Object element) {
        return new CheckboxCellEditor(null, SWT.CHECK)
    }

    /**
     * Get value from element (LEMMA model kind selected for transformation?)
     */
    override protected getValue(Object element) {
        return (element as LemmaModelKind).selectedForTransformation
    }

    /**
     * Set value for element (select/deselect LEMMA model kind transformation?)
     */
    override protected setValue(Object element, Object value) {
        val modelKind = element as LemmaModelKind
        val oldValue = modelKind.selectedForTransformation
        val newValue = value as Boolean
        if (oldValue === newValue || !newValueValidator.apply(modelKind -> newValue)) {
            return
        }

        modelKind.selectedForTransformation = newValue
        tableViewer.update(element, null)
    }
}