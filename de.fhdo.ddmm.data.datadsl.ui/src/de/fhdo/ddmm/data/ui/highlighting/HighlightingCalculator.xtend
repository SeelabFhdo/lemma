package de.fhdo.ddmm.data.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.ddmm.data.DataPackage
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import de.fhdo.ddmm.data.EnumerationField

/**
 * Provide custom syntax highlighting for certain elements.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class HighlightingCalculator implements ISemanticHighlightingCalculator {
    /**
     * Provide highlighting
     */
    override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
        CancelIndicator cancelIndicator) {
        // Color boolean values as keywords
        resource.allContents.forEach[
            val booleanInitializedEnumerationField = it instanceof EnumerationField &&
                (it as EnumerationField).initializationValue?.booleanValue !== null
            if (booleanInitializedEnumerationField) {
                NodeModelUtils.findNodesForFeature(
                    it,
                    DataPackage::Literals.ENUMERATION_FIELD__INITIALIZATION_VALUE
                ).forEach[
                    acceptor.addPosition(offset, length,
                        DefaultHighlightingConfiguration.KEYWORD_ID)
                ]
            }
        ]
    }
}