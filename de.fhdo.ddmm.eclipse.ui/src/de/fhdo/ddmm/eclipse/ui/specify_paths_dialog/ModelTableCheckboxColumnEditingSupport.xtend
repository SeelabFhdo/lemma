package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog

import org.eclipse.jface.viewers.EditingSupport
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.SWT
import org.eclipse.jface.viewers.CheckboxCellEditor
import de.fhdo.ddmm.eclipse.ui.ModelFile
import com.google.common.base.Predicate

/**
 * Implementation of editing support for model table checkbox column.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTableCheckboxColumnEditingSupport extends EditingSupport {
    private TableViewer tableViewer
    private Predicate<Pair<ModelFile, Boolean>> newValueValidator

    /**
     * Constructor
     */
    new(TableViewer tableViewer, Predicate<Pair<ModelFile, Boolean>> newValueValidator) {
        super(tableViewer)
        this.tableViewer = tableViewer
        this.newValueValidator = newValueValidator
    }

    /**
     * Flag to indicate if column is editable
     */
    override protected canEdit(Object element) {
        return true
    }

    /**
     * Create checkbox cell editor for column
     */
    override protected getCellEditor(Object element) {
        return new CheckboxCellEditor(null, SWT.CHECK)
    }

    /**
     * Get checkbox value
     */
    override protected getValue(Object element) {
        return (element as ModelFile).selectedForTransformation
    }

    /**
     * Set checkbox value
     */
    override protected setValue(Object element, Object value) {
        val modelFile = element as ModelFile

        val oldValue = modelFile.selectedForTransformation
        val newValue = value as Boolean
        if (oldValue === newValue) {
            return
        } else if (!newValueValidator.apply(modelFile -> newValue)) {
            return
        }

        modelFile.selectedForTransformation = newValue
        tableViewer.update(element, null)
    }

}