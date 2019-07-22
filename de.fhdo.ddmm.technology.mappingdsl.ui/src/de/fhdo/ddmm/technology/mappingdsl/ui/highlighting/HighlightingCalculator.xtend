package de.fhdo.ddmm.technology.mappingdsl.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.ddmm.technology.mappingdsl.ui.highlighting.HighlightingConfiguration
import de.fhdo.ddmm.technology.mapping.ComplexTypeMapping
import de.fhdo.ddmm.service.TechnologyReference
import de.fhdo.ddmm.service.ServicePackage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.Keyword

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
        resource.provideHighlightingForDefaultTypeDefinitionFlag(acceptor)
    }

    /**
     * Provide highlighting for annotations
     */
    private def provideHighlightingForAnnotations(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {

        /* Color technology annotations on model-level mapping nodes */
        resource.allContents.filter[
            it instanceof ComplexTypeMapping || it instanceof TechnologyReference
        ].forEach[
            val nodes = NodeModelUtils.findNodesForFeature(it,
                ServicePackage.Literals::TECHNOLOGY_REFERENCE__TECHNOLOGY)

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

    /**
     * Provide highlighting for default type definition flag of built-in @technology annotation
     */
    private def provideHighlightingForDefaultTypeDefinitionFlag(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        for (eObject : resource.allContents.toList) {
            val relevantFeatures = NodeModelUtils.findNodesForFeature(eObject,
                ServicePackage.Literals::TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY)
            if (!relevantFeatures.empty) {
                var currentNode = relevantFeatures.get(0).previousSibling
                var typedefKeywordColored = false
                while (currentNode !== null && !typedefKeywordColored) {
                    if ("typedef" == currentNode.keywordValue) {
                        acceptor.addPosition(currentNode.offset, currentNode.length,
                            HighlightingConfiguration.DEFAULT_ID)
                        typedefKeywordColored = true
                    } else
                        currentNode = currentNode.previousSibling
                }
            }
        }
    }

    /**
     * Helper to return the value of a Keyword INode. Returns an empty string if the passed node is
     * not a Keyword.
     */
    private def String keywordValue(INode node) {
        val grammarElement = node.grammarElement
        return if (grammarElement instanceof Keyword)
                grammarElement.value
            else
                ""
    }
}