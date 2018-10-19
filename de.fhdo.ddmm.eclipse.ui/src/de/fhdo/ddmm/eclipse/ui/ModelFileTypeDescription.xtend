package de.fhdo.ddmm.eclipse.ui

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.graphics.Image
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import java.util.LinkedList

/**
 * Description of a model file type.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelFileTypeDescription {
    @Accessors
    private Image icon

    @Accessors
    private String description

    @Accessors
    private List<String> extensions

    // Each model file type has one main transformation strategy that transforms the model file into
    // a result file. In most cases, this result file corresponds to the resulting XMI file.
    // However, there might be subsequent refiningTransformationStrategies, which transform the
    // result file into more specific files.
    @Accessors
    private AbstractIntermediateModelTransformationStrategy mainTransformationStrategy

    // Refining transformation strategies may be used to specify model transformation chains, i.e.,
    // the model that results from executing the main transformation strategy is an input of the
    // chain and the transformation strategies in the chain get executed consecutively in order to
    // refine the initial result file. This mechanism is, for instance, used to derive a service
    // from a mapping model (main transformation strategy) and transform it to an intermediate
    // service model (refining transformation strategy).
    @Accessors
    private LinkedList<AbstractIntermediateModelTransformationStrategy>
        refiningTransformationStrategies

    /**
     * Constructor
     */
    new(Image icon, String description, List<String> extensions,
        AbstractIntermediateModelTransformationStrategy mainTransformationStrategy,
        AbstractIntermediateModelTransformationStrategy... refiningTransformationStrategies) {
        this.icon = icon
        this.description = description
        this.extensions = extensions
        this.mainTransformationStrategy = mainTransformationStrategy
        this.refiningTransformationStrategies = newLinkedList(refiningTransformationStrategies)
    }
}