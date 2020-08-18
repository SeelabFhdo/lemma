package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.viewers.EditingSupport
import com.google.common.base.Predicate
import org.eclipse.jface.viewers.TableViewer
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog.LemmaModelKind
import org.eclipse.jface.viewers.TextCellEditor
import org.eclipse.swt.widgets.Composite

/**
 * Editing support for the target path column in the dialog for LEMMA paths specification.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTableTargetPathColumnEditingSupport extends EditingSupport {
    TableViewer tableViewer
    Predicate<Pair<LemmaModelKind, String>> newValueValidator

    /**
     * Constructor
     */
    new(TableViewer tableViewer, Predicate<Pair<LemmaModelKind, String>> newValueValidator) {
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
        return new TextCellEditor(tableViewer.control as Composite)
    }

    /**
     * Get value from element (target path for LEMMA model kind)
     */
    override protected getValue(Object element) {
        return (element as LemmaModelKind).targetPath
    }

    /**
     * Set value for element (target path for LEMMA model kind)
     */
    override protected setValue(Object element, Object value) {
        val modelKind = element as LemmaModelKind
        val oldValue = modelKind.targetPath
        val newValue = value.toString
        if (oldValue == newValue || !newValueValidator.apply(modelKind -> newValue)) {
            return
        }

        modelKind.targetPath = newValue
        tableViewer.update(element, null)
    }
}