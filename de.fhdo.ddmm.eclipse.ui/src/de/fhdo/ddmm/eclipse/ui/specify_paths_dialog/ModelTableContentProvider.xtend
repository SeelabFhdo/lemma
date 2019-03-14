package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog

import java.util.Map
import java.util.List
import de.fhdo.ddmm.eclipse.ui.ModelFile
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy
import org.eclipse.jface.viewers.IStructuredContentProvider

/**
 * Content provider for model files in dialog for specifying paths for intermediate model
 * transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTableContentProvider implements IStructuredContentProvider {
    AbstractUiModelTransformationStrategy strategy

    /**
     * Constructor
     */
    new(AbstractUiModelTransformationStrategy strategy) {
        if (strategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")

        this.strategy = strategy
    }

    /**
     * Get elements
     */
    override getElements(Object inputElement) {
        val inputModelFiles = inputElement as Map<String, List<ModelFile>>

        val tableEntries = <ModelFile> newLinkedList
        val modelTypeOrdering = strategy.modelTypeOrdering
        modelTypeOrdering.forEach[modelType |
            val tableEntriesForType = inputModelFiles.get(modelType)
            if (tableEntriesForType !== null)
                tableEntries.addAll(tableEntriesForType.sort)
        ]
        return tableEntries
    }
}