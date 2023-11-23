package de.fhdo.lemma.data.avro.ui.to_lemma;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Editing support for the target path column in the dialog for LEMMA paths specification.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTableTargetPathColumnEditingSupport extends EditingSupport {
  private TableViewer tableViewer;

  private Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, String>> newValueValidator;

  /**
   * Constructor
   */
  public ModelTableTargetPathColumnEditingSupport(final TableViewer tableViewer, final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, String>> newValueValidator) {
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
    Control _control = this.tableViewer.getControl();
    return new TextCellEditor(((Composite) _control));
  }

  /**
   * Get value from element (target path for LEMMA model kind)
   */
  @Override
  protected Object getValue(final Object element) {
    return ((SpecifyLemmaPathsDialog.LemmaModelKind) element).targetPath;
  }

  /**
   * Set value for element (target path for LEMMA model kind)
   */
  @Override
  protected void setValue(final Object element, final Object value) {
    final SpecifyLemmaPathsDialog.LemmaModelKind modelKind = ((SpecifyLemmaPathsDialog.LemmaModelKind) element);
    final String oldValue = modelKind.targetPath;
    final String newValue = value.toString();
    if ((Objects.equal(oldValue, newValue) || (!this.newValueValidator.apply(Pair.<SpecifyLemmaPathsDialog.LemmaModelKind, String>of(modelKind, newValue))))) {
      return;
    }
    modelKind.targetPath = newValue;
    this.tableViewer.update(element, null);
  }
}
