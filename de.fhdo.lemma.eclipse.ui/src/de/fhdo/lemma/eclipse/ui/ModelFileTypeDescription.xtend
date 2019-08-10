package de.fhdo.lemma.eclipse.ui

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.graphics.Image
import java.util.LinkedList
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import de.fhdo.lemma.intermediate.transformations.TransformationModelType

/**
 * Description of a model file type.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelFileTypeDescription {
    @Accessors
    String fileType

    @Accessors
    Image icon

    @Accessors
    String description

    @Accessors
    List<String> extensions

    // A model file may have a main transformation strategy that transforms the model file into
    // result files. In most cases, this result file corresponds to the resulting XMI file. However,
    // there might be subsequent refiningTransformationStrategies, which transform the result file
    // into more specific files.
    Class<? extends AbstractIntermediateModelTransformationStrategy> mainTransformationStrategy

    List<TransformationModelType> outputModelTypes

    // Refining transformation strategies may be used to specify model transformation chains, i.e.,
    // the model that results from executing the main transformation strategy is an input of the
    // chain and the transformation strategies in the chain get executed consecutively in order to
    // refine the initial result file. This mechanism is, for instance, used to derive a service
    // from a mapping model (main transformation strategy) and transform it to an intermediate
    // service model (refining transformation strategy).
    LinkedList<Class<? extends AbstractIntermediateModelTransformationStrategy>>
        refiningTransformationStrategies

    /**
     * Constructor
     */
    new(String fileType, Image icon, String description, List<String> extensions,
        Class<? extends AbstractIntermediateModelTransformationStrategy> mainTransformationStrategy,
        Class<? extends AbstractIntermediateModelTransformationStrategy>...
            refiningTransformationStrategies
    ) {
        this.fileType = fileType
        this.icon = icon
        this.description = description
        this.extensions = extensions
        this.mainTransformationStrategy = mainTransformationStrategy
        this.refiningTransformationStrategies = newLinkedList(refiningTransformationStrategies)
    }

    /**
     * Factory method to create a new instance of the main transformation strategy
     */
    def createMainTransformationStrategy() {
        return if (mainTransformationStrategy !== null)
                mainTransformationStrategy.newInstance
            else
                null
    }

    /**
     * Check if the model file type can be transformed to another file
     */
    def canBeTransformed() {
        return mainTransformationStrategy !== null
    }

    /**
     * If the model file type can be transformed, get output model types
     */
    def getOutputModelTypes() {
        if (!canBeTransformed)
            return emptyList

        if (outputModelTypes === null)
            outputModelTypes = mainTransformationStrategy.newInstance.outputModelTypes

        return outputModelTypes
    }

    /**
     * Factory method to create a new instance of a certain refining transformation strategy
     */
    def createRefiningTransformationStrategy(int index) {
        return if (refiningTransformationStrategies !== null && index >= 0 &&
            index < refiningTransformationStrategies.size)
                refiningTransformationStrategies.get(index).newInstance
            else
                null
    }

    /**
     * Get count of refining strategies
     */
    def refiningStrategiesCount() {
        return if (refiningTransformationStrategies !== null)
                refiningTransformationStrategies.size
            else
                -1
    }
}