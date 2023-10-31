package de.fhdo.lemma.data.avro.ui.to_lemma;

import com.google.common.base.Predicate;
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Editing support for the checkbox column in the dialog for LEMMA paths specification.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTableCheckboxColumnEditingSupport extends EditingSupport {
  private TableViewer tableViewer;

  private Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean>> newValueValidator;

  /**
   * Constructor
   */
  public ModelTableCheckboxColumnEditingSupport(final TableViewer tableViewer, final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean>> newValueValidator) {
    super(tableViewer);
    this.tableViewer = tableViewer;
    this.newValueValidator = newValueValidator;
  }

  /**
   * Editable flag
   */
  @Override
  protected boolean canEdit(final Object element) {
    return true;
  }

  /**
   * Return cell editor
   */
  @Override
  protected CellEditor getCellEditor(final Object element) {
    return new CheckboxCellEditor(null, SWT.CHECK);
  }

  /**
   * Get value from element (LEMMA model kind selected for transformation?)
   */
  @Override
  protected Object getValue(final Object element) {
    return Boolean.valueOf(((SpecifyLemmaPathsDialog.LemmaModelKind) element).selectedForTransformation);
  }

  /**
   * Set value for element (select/deselect LEMMA model kind transformation?)
   */
  @Override
  protected void setValue(final Object element, final Object value) {
    final SpecifyLemmaPathsDialog.LemmaModelKind modelKind = ((SpecifyLemmaPathsDialog.LemmaModelKind) element);
    final boolean oldValue = modelKind.selectedForTransformation;
    final Boolean newValue = ((Boolean) value);
    if (((Boolean.valueOf(oldValue) == newValue) || (!this.newValueValidator.apply(Pair.<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean>of(modelKind, newValue))))) {
      return;
    }
    modelKind.selectedForTransformation = (newValue).booleanValue();
    this.tableViewer.update(element, null);
  }
}
