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
                MappingPackage.Literals::MICROSERVICE_MAPPING__TECHNOLOGY)

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
}