package de.fhdo.lemma.operationdsl.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.lemma.operation.OperationNode
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.ImportedOperationAspect
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
        resource.provideHighlightingForBooleanConstants(acceptor)
    }

    /**
     * Provide highlighting for annotations
     */
    private def provideHighlightingForAnnotations(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {

        /* Color technology annotations on operation nodes */
        resource.allContents.filter[it instanceof OperationNode].forEach[
            val nodes = NodeModelUtils.findNodesForFeature(it,
                OperationPackage.Literals::OPERATION_NODE__TECHNOLOGIES)

            nodes.forEach[
                // Walk the node model backwards from the previous node of the annotated technology
                // until the beginning of the surrounding annotation, i.e., the "@" token, was
                // reached
                var currentSibling = previousSibling
                var annotationBeginReached = false
                while (currentSibling !== null && !annotationBeginReached) {
                    if (currentSibling.text == "@")
                        annotationBeginReached = true

                    // Analogous to the standard Eclipse highlighting for Java, we do not
                    // highlight possible brackets of annotation values
                    if (currentSibling.text != "(")
                        acceptor.addPosition(currentSibling.offset, currentSibling.length,
                            HighlightingConfiguration.ANNOTATION_ID)

                    currentSibling = currentSibling.previousSibling
                }
            ]
        ]
    }

    /**
     * Provide highlighting for boolean values
     */
    private def provideHighlightingForBooleanConstants(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        val booleanConcepts = newHashMap(
            ImportedOperationAspect -> #[
                [(it as ImportedOperationAspect).singlePropertyValue]
                    -> OperationPackage::Literals.IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE
            ],

            TechnologySpecificPropertyValueAssignment -> #[
                [(it as TechnologySpecificPropertyValueAssignment).value]
                    -> TechnologyPackage::Literals
                        .TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE
            ]
        )

        resource.allContents.forEach[eObject |
            val matchingBooleanConcept = booleanConcepts.keySet.findFirst[it.isInstance(eObject)]
            if (matchingBooleanConcept !== null) {
                val primitiveValueGetters = booleanConcepts.get(matchingBooleanConcept)
                primitiveValueGetters.forEach[
                    val getter = it.key
                    val feature = it.value

                    val primitiveValue = getter.apply(eObject)
                    if (primitiveValue !== null && primitiveValue.booleanValue !== null)
                        NodeModelUtils.findNodesForFeature(eObject, feature).forEach[
                            acceptor.addPosition(offset, length,
                                HighlightingConfiguration.KEYWORD_ID)
                        ]
                ]
            }
        ]
    }
}