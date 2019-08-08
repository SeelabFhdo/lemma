package de.fhdo.lemma.data.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.data.EnumerationField
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.DataOperation

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
        resource.provideHighlightingForBooleanConstants(acceptor)
        resource.provideHighlightingForFeatures(acceptor)
    }

    /**
     * Provide highlighting for boolean values
     */
    private def provideHighlightingForBooleanConstants(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        val booleanConcepts = newHashMap(
            DataField -> #[
                [
                    val value = (it as DataField).initializationValue
                    value !== null && value.booleanValue !== null
                ]
                -> DataPackage::Literals.DATA_FIELD__INITIALIZATION_VALUE
            ],

            EnumerationField -> #[
                [
                    val value = (it as EnumerationField).initializationValue
                    value !== null && value.booleanValue !== null
                ]
                -> DataPackage::Literals.ENUMERATION_FIELD__INITIALIZATION_VALUE
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

    /**
     * Provide highlighting for features
     */
    private def provideHighlightingForFeatures(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.forEach[nodesWithFeatures.forEach[
            acceptor.addPosition(offset, length, HighlightingConfiguration.FEATURE_ID)
        ]]
    }

    /**
     * Get feature nodes on EObjects that support feature specification
     */
    private def getNodesWithFeatures(EObject eObject) {
        return switch (eObject) {
            DataStructure: NodeModelUtils.findNodesForFeature(eObject,
                DataPackage::Literals.DATA_STRUCTURE__FEATURES)
            DataField: NodeModelUtils.findNodesForFeature(eObject,
                DataPackage::Literals.DATA_FIELD__FEATURES)
            DataOperation: NodeModelUtils.findNodesForFeature(eObject,
                DataPackage::Literals.DATA_OPERATION__FEATURES)
            default: emptyList
        }
    }
}