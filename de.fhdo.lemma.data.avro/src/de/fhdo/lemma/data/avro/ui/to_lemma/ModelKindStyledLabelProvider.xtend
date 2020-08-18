package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.LabelProvider
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog.LemmaModelKind
import org.eclipse.jface.viewers.StyledString

/**
 * Provider of styled labels for model kinds in the dialog for LEMMA paths specification.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelKindStyledLabelProvider extends LabelProvider implements IStyledLabelProvider {
    /**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        return new StyledString((element as LemmaModelKind).name)
    }

    /**
     * Get image for element
     */
    override getImage(Object element) {
        return (element as LemmaModelKind).icon
    }
}