package de.fhdo.ddmm.technology.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.ddmm.technology.TechnologyPackage
import de.fhdo.ddmm.technology.OperationEnvironment

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
        resource.provideHighlightingForOperationEnvironmentNames(acceptor)
    }

    /**
     * Provide string highlighting for names of operation environments
     */
    private def provideHighlightingForOperationEnvironmentNames(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.filter[
            it instanceof OperationEnvironment
        ].forEach[
            NodeModelUtils.findNodesForFeature(it,
                TechnologyPackage.Literals::OPERATION_ENVIRONMENT__NAME
            ).forEach[
                acceptor.addPosition(offset, length,
                    HighlightingConfiguration.OPERATION_ENVIRONMENT_NAME_ID)
            ]
        ]
    }
}