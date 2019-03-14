package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog;

import com.google.common.base.Predicate;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of editing support for model table transformation target path column.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTableTransformationTargetPathColumnEditingSupport extends EditingSupport {
  private TableViewer tableViewer;
  
  private Predicate<Pair<ModelFile, String>> newValueValidator;
  
  /**
   * Constructor
   */
  public ModelTableTransformationTargetPathColumnEditingSupport(final TableViewer tableViewer, final Predicate<Pair<ModelFile, String>> newValueValidator) {
    super(tableViewer);
    this.tableViewer = tableViewer;
    this.newValueValidator = newValueValidator;
  }
  
  /**
   * Flag to indicate if column is editable
   */
  protected boolean canEdit(final Object element) {
    return true;
  }
  
  /**
   * Create cell editor for column
   */
  protected CellEditor getCellEditor(final Object element) {
    Control _control = this.tableViewer.getControl();
    return new TextCellEditor(((Composite) _control));
  }
  
  /**
   * Get checkbox value
   */
  protected Object getValue(final Object element) {
    return ((ModelFile) element).getTransformationTargetPath();
  }
  
  /**
   * Set checkbox value
   */
  protected void setValue(final Object element, final Object value) {
    final ModelFile modelFile = ((ModelFile) element);
    final String oldValue = modelFile.getTransformationTargetPath();
    final String newValue = value.toString();
    if ((oldValue == newValue)) {
      return;
    } else {
      Pair<ModelFile, String> _mappedTo = Pair.<ModelFile, String>of(modelFile, newValue);
      boolean _apply = this.newValueValidator.apply(_mappedTo);
      boolean _not = (!_apply);
      if (_not) {
        return;
      }
    }
    ((ModelFile) element).setTransformationTargetPath(newValue);
    this.tableViewer.update(element, null);
  }
}
