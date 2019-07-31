package de.fhdo.lemma.technology.mappingdsl.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.lemma.technology.mappingdsl.ui.highlighting.HighlightingConfiguration
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.service.TechnologyReference
import de.fhdo.lemma.service.ServicePackage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.Keyword
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect
import de.fhdo.lemma.technology.mapping.MappingPackage
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment
import de.fhdo.lemma.technology.TechnologyPackage

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
        resource.provideHighlightingForBooleanConstants(acceptor)
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

    /**
     * Provide highlighting for boolean values
     */
    private def provideHighlightingForBooleanConstants(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        val booleanConcepts = newHashMap(
            TechnologySpecificImportedServiceAspect -> #[
                [
                    val value = (it as TechnologySpecificImportedServiceAspect).singlePropertyValue
                    value !== null && value.booleanValue !== null
                ]
                -> MappingPackage::Literals
                        .TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE
            ],

            TechnologySpecificPropertyValueAssignment -> #[
                [
                    val value = (it as TechnologySpecificPropertyValueAssignment).value
                    value !== null && value.booleanValue !== null
                ]
                -> TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE
            ],

            TechnologyReference -> #[
                [true]
                -> ServicePackage::Literals.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY
            ]
        )

        resource.allContents.forEach[eObject |
            val matchingBooleanConcept = booleanConcepts.keySet.findFirst[it.isInstance(eObject)]
            if (matchingBooleanConcept !== null) {
                val primitiveValueGetters = booleanConcepts.get(matchingBooleanConcept)
                primitiveValueGetters.forEach[
                    val isBooleanValue = it.key
                    val feature = it.value

                    if (isBooleanValue.apply(eObject))
                        NodeModelUtils.findNodesForFeature(eObject, feature).forEach[
                            acceptor.addPosition(offset, length,
                                HighlightingConfiguration.KEYWORD_ID)
                        ]
                ]
            }
        ]
    }
}