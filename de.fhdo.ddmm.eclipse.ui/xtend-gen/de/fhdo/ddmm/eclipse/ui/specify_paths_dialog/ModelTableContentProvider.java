package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog;

import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
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
  public Object[] getElements(final Object inputElement) {
    final Map<String, List<ModelFile>> inputModelFiles = ((Map<String, List<ModelFile>>) inputElement);
    final LinkedList<ModelFile> tableEntries = CollectionLiterals.<ModelFile>newLinkedList();
    final List<String> modelTypeOrdering = this.strategy.getModelTypeOrdering();
    final Consumer<String> _function = new Consumer<String>() {
      public void accept(final String modelType) {
        final List<ModelFile> tableEntriesForType = inputModelFiles.get(modelType);
        if ((tableEntriesForType != null)) {
          tableEntries.addAll(IterableExtensions.<ModelFile>sort(tableEntriesForType));
        }
      }
    };
    modelTypeOrdering.forEach(_function);
    return ((Object[])Conversions.unwrapArray(tableEntries, Object.class));
  }
}
