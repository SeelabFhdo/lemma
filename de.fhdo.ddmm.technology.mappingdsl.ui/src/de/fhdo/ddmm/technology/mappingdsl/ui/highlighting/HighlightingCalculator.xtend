package de.fhdo.ddmm.technology.mappingdsl.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping
import de.fhdo.ddmm.technology.mapping.MappingPackage
import de.fhdo.ddmm.technology.mappingdsl.ui.highlighting.HighlightingConfiguration

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
        resource.provideHighlightingForAnnotations(acceptor)
    }

    /**
     * Provide highlighting for annotations
     */
    private def provideHighlightingForAnnotations(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {

        /* Color technology annotations on microservice mapping nodes */
        resource.allContents.filter[it instanceof MicroserviceMapping].forEach[
            val nodes = NodeModelUtils.findNodesForFeature(it,
                MappingPackage.Literals::MICROSERVICE_MAPPING__TECHNOLOGIES)

            nodes.forEach[
                // Determine node to start highlighting
                var nodeToHighlight = it
                while (nodeToHighlight !== null &&
                    nodeToHighlight.nextSibling !== null &&
                    nodeToHighlight.nextSibling.text != "(")
                    nodeToHighlight = nodeToHighlight.previousSibling

                // Highlight nodes including the "@" sign, which marks the beginning of an
                // aspect's annotation string
                if (nodeToHighlight !== null) {
                    do {
                        acceptor.addPosition(nodeToHighlight.offset, nodeToHighlight.length,
                            HighlightingConfiguration.ANNOTATION_ID)
                        nodeToHighlight = nodeToHighlight.previousSibling
                    } while (nodeToHighlight !== null &&
                        nodeToHighlight.nextSibling !== null &&
                        nodeToHighlight.nextSibling.text != "@"
                    )
                }
            ]
        ]
    }
}