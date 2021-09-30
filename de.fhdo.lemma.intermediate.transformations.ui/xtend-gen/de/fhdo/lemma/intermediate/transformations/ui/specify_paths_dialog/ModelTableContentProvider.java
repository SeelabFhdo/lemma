package de.fhdo.lemma.intermediate.transformations.ui.specify_paths_dialog;

import de.fhdo.lemma.intermediate.transformations.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Content provider for model files in dialog for specifying paths for intermediate model
 * transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTableContentProvider implements IStructuredContentProvider {
  private AbstractUiModelTransformationStrategy strategy;
  
  /**
   * Constructor
   */
  public ModelTableContentProvider(final AbstractUiModelTransformationStrategy strategy) {
    if ((strategy == null)) {
      throw new IllegalArgumentException("Transformation strategy must not be null");
    }
    this.strategy = strategy;
  }
  
  /**
   * Get elements
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    final Map<String, List<ModelFile>> inputModelFiles = ((Map<String, List<ModelFile>>) inputElement);
    final LinkedList<ModelFile> tableEntries = CollectionLiterals.<ModelFile>newLinkedList();
    final LinkedList<String> modelTypeOrdering = this.strategy.getModelTypeDisplayOrdering();
    final Consumer<String> _function = (String modelType) -> {
      final List<ModelFile> tableEntriesForType = inputModelFiles.get(modelType);
      if ((tableEntriesForType != null)) {
        tableEntries.addAll(IterableExtensions.<ModelFile>sort(tableEntriesForType));
      }
    };
    modelTypeOrdering.forEach(_function);
    return ((Object[])Conversions.unwrapArray(tableEntries, Object.class));
  }
}
