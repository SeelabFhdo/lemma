package de.fhdo.lemma.data.avro.ui.to_avro;

import com.google.common.base.Objects;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Workbench provider for Eclipse projects
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ProjectWorkbenchContentProvider extends BaseWorkbenchContentProvider {
  private IProject project;
  
  /**
   * Constructor
   */
  public ProjectWorkbenchContentProvider(final IProject project) {
    this.project = project;
  }
  
  /**
   * Get project elements from workbench
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    final Object[] elements = super.getElements(inputElement);
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf(((it instanceof IProject) && Objects.equal(((IProject) it), this.project)));
    };
    Object _findFirst = IterableExtensions.<Object>findFirst(((Iterable<Object>)Conversions.doWrapArray(elements)), _function);
    return new Object[] { _findFirst };
  }
  
  /**
   * Get IContainer children of a parent workbench element
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    final Object[] children = super.getChildren(parentElement);
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf((it instanceof IContainer));
    };
    return ((Object[])Conversions.unwrapArray(IterableExtensions.<Object>filter(((Iterable<Object>)Conversions.doWrapArray(children)), _function), Object.class));
  }
}
