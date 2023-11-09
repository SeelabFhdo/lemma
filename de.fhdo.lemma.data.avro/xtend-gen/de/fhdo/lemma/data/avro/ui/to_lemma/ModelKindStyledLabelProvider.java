package de.fhdo.lemma.data.avro.ui.to_lemma;

import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * Provider of styled labels for model kinds in the dialog for LEMMA paths specification.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelKindStyledLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  /**
   * Get styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    String _name = ((SpecifyLemmaPathsDialog.LemmaModelKind) element).getName();
    return new StyledString(_name);
  }

  /**
   * Get image for element
   */
  @Override
  public Image getImage(final Object element) {
    return ((SpecifyLemmaPathsDialog.LemmaModelKind) element).getIcon();
  }
}
