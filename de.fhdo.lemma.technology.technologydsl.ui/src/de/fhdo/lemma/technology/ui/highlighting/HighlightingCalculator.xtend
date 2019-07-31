package de.fhdo.lemma.technology.ui.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import de.fhdo.lemma.technology.ServiceAspectPointcut
import de.fhdo.lemma.technology.TechnologyPackage
import de.fhdo.lemma.technology.OperationAspectPointcut
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import de.fhdo.lemma.technology.TechnologySpecificProperty

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
        resource.provideHighlightingForPointcuts(acceptor)
        resource.provideHighlightingForBooleanConstants(acceptor)
        resource.provideHighlightingForFeatures(acceptor)
    }

    /**
     * Provide highlighting for aspects' pointcuts
     */
    private def provideHighlightingForPointcuts(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        /*
         * The following map assigns selector features, which shall be highlighted, to their
         * defining pointcut classes
         */
        val pointcuts = #{
            ServiceAspectPointcut -> #[
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE,
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT,
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN,
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL,
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN,
                TechnologyPackage.Literals::SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE
            ],
            OperationAspectPointcut -> #[
                TechnologyPackage.Literals::OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY
            ]
        }

        /*
         * Search for pointcuts in the current model file and highlight their selector keywords
         * according to the map above
         */
        val modeledPointcutsWithHighlightingFeatures = resource.allContents.filter[eObject |
            pointcuts.keySet.exists[it.isInstance(eObject)]
        ].toMap([it], [eObject |
            val pointcut = pointcuts.keySet.findFirst[it.isInstance(eObject)]
            pointcuts.get(pointcut)
        ])

        modeledPointcutsWithHighlightingFeatures.forEach[pointcut, features |
            features.forEach[feature |
                val currentPointcutFeatures = NodeModelUtils.findNodesForFeature(pointcut, feature)
                if (!currentPointcutFeatures.empty) {
                    val currentNode = currentPointcutFeatures.get(0)
                    acceptor.addPosition(currentNode.offset, currentNode.length,
                        DefaultHighlightingConfiguration.DEFAULT_ID)
                }
            ]
        ]
    }

    /**
     * Provide highlighting for boolean values
     */
    private def provideHighlightingForBooleanConstants(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.forEach[
            val booleanDefaultValue = it instanceof TechnologySpecificProperty &&
                (it as TechnologySpecificProperty).defaultValue?.booleanValue !== null
            if (booleanDefaultValue) {
                NodeModelUtils.findNodesForFeature(
                    it,
                    TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE
                ).forEach[
                    acceptor.addPosition(offset, length,
                        DefaultHighlightingConfiguration.KEYWORD_ID)
                ]
            }
        ]
    }

    /**
     * Provide highlighting for features
     */
    private def provideHighlightingForFeatures(XtextResource resource,
        IHighlightedPositionAcceptor acceptor) {
        resource.allContents.forEach[
            if (it instanceof TechnologySpecificProperty)
                NodeModelUtils.findNodesForFeature(
                    it,
                    TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES
                ).forEach[
                    acceptor.addPosition(offset, length, HighlightingConfiguration.FEATURE_ID)
                ]
        ]
    }
}