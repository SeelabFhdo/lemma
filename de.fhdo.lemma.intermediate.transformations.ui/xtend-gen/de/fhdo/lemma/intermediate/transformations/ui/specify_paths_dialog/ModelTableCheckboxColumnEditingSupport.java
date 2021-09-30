package de.fhdo.lemma.intermediate.transformations.ui.specify_paths_dialog;

import com.google.common.base.Predicate;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFile;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of editing support for model table checkbox column.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTableCheckboxColumnEditingSupport extends EditingSupport {
  private TableViewer tableViewer;
  
  private Predicate<Pair<ModelFile, Boolean>> newValueValidator;
  
  /**
   * Constructor
   */
  public ModelTableCheckboxColumnEditingSupport(final TableViewer tableViewer, final Predicate<Pair<ModelFile, Boolean>> newValueValidator) {
    super(tableViewer);
    this.tableViewer = tableViewer;
    this.newValueValidator = newValueValidator;
  }
  
  /**
   * Flag to indicate if column is editable
   */
  @Override
  protected boolean canEdit(final Object element) {
    return true;
  }
  
  /**
   * Create checkbox cell editor for column
   */
  @Override
  protected CellEditor getCellEditor(final Object element) {
    return new CheckboxCellEditor(null, SWT.CHECK);
  }
  
  /**
   * Get checkbox value
   */
  @Override
  protected Object getValue(final Object element) {
    final ModelFile modelFile = ((ModelFile) element);
    boolean _xifexpression = false;
    Boolean _hasErrors = modelFile.hasErrors();
    if ((_hasErrors).booleanValue()) {
      _xifexpression = false;
    } else {
      _xifexpression = modelFile.isSelectedForTransformation();
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  /**
   * Set checkbox value
   */
  @Override
  protected void setValue(final Object element, final Object value) {
    final ModelFile modelFile = ((ModelFile) element);
    Boolean _hasErrors = modelFile.hasErrors();
    if ((_hasErrors).booleanValue()) {
      modelFile.setSelectedForTransformation(false);
      return;
    }
    final boolean oldValue = modelFile.isSelectedForTransformation();
    final Boolean newValue = ((Boolean) value);
    if ((Boolean.valueOf(oldValue) == newValue)) {
      return;
    } else {
      Pair<ModelFile, Boolean> _mappedTo = Pair.<ModelFile, Boolean>of(modelFile, newValue);
      boolean _apply = this.newValueValidator.apply(_mappedTo);
      boolean _not = (!_apply);
      if (_not) {
        return;
      }
    }
    modelFile.setSelectedForTransformation((newValue).booleanValue());
    this.tableViewer.update(element, null);
  }
}
