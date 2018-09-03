package de.fhdo.ddmm.operationdsl.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.ddmm.operation.Container
import de.fhdo.ddmm.operation.OperationPackage
import de.fhdo.ddmm.operation.InfrastructureNode

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
        resource.provideHighlightingForDeploymentTechnologyNames(acceptor)
        resource.provideHighlightingForInfrastructureTechnologyNames(acceptor)
    }

    /**
     * Provide keyword highlighting for names of deployment technologies
     */
    private def provideHighlightingForDeploymentTechnologyNames(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.filter[
            it instanceof Container
        ].forEach[
            NodeModelUtils.findNodesForFeature(it,
                OperationPackage.Literals::CONTAINER__DEPLOYMENT_TECHNOLOGY
            ).forEach[
                acceptor.addPosition(offset, length,
                    HighlightingConfiguration.DEPLOYMENT_TECHNOLOGY_NAME_ID)
            ]
        ]
    }

    /**
     * Provide keyword highlighting for names of infrastructure technologies
     */
    private def provideHighlightingForInfrastructureTechnologyNames(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.filter[
            it instanceof InfrastructureNode
        ].forEach[
            NodeModelUtils.findNodesForFeature(it,
                OperationPackage.Literals::INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY
            ).forEach[
                acceptor.addPosition(offset, length,
                    HighlightingConfiguration.INFRASTRUCTURE_TECHNOLOGY_NAME_ID)
            ]
        ]
    }
}