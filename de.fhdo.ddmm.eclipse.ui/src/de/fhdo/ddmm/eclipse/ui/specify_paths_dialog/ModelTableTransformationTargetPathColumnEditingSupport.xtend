package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog

import org.eclipse.jface.viewers.EditingSupport
import org.eclipse.jface.viewers.TableViewer
import de.fhdo.ddmm.eclipse.ui.ModelFile
import org.eclipse.jface.viewers.TextCellEditor
import org.eclipse.swt.widgets.Composite
import com.google.common.base.Predicate

/**
 * Implementation of editing support for model table transformation target path column.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTableTransformationTargetPathColumnEditingSupport extends EditingSupport {
    private TableViewer tableViewer
    private Predicate<Pair<ModelFile, String>> newValueValidator

    /**
     * Constructor
     */
    new(TableViewer tableViewer, Predicate<Pair<ModelFile, String>> newValueValidator) {
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
     * Create cell editor for column
     */
    override protected getCellEditor(Object element) {
        return new TextCellEditor(tableViewer.control as Composite)
    }

    /**
     * Get checkbox value
     */
    override protected getValue(Object element) {
        return (element as ModelFile).transformationTargetPath
    }

    /**
     * Set checkbox value
     */
    override protected setValue(Object element, Object value) {
        val modelFile = element as ModelFile

        val oldValue = modelFile.transformationTargetPath
        val newValue = value.toString
        if (oldValue === newValue) {
            return
        } else if (!newValueValidator.apply(modelFile -> newValue)) {
            return
        }

        (element as ModelFile).transformationTargetPath = newValue
        tableViewer.update(element, null)
    }

}