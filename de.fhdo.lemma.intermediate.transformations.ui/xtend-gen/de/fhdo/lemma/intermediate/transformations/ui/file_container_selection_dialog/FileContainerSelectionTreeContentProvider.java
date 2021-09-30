package de.fhdo.lemma.intermediate.transformations.ui.file_container_selection_dialog;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Content provider for the tree in file container selection dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class FileContainerSelectionTreeContentProvider implements ITreeContentProvider {
  private Class<? extends EObject> intermediateModelClass;
  
  /**
   * Constructor
   */
  public FileContainerSelectionTreeContentProvider(final Class<? extends EObject> intermediateModelClass) {
    this.intermediateModelClass = intermediateModelClass;
  }
  
  /**
   * Get children of parent element
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    try {
      if ((parentElement instanceof IWorkspace)) {
        return ((IWorkspace)parentElement).getRoot().getProjects();
      } else {
        if (((parentElement instanceof IContainer) && ((IContainer) parentElement).isAccessible())) {
          final IContainer container = ((IContainer) parentElement);
          final Function1<IResource, Boolean> _function = (IResource it) -> {
            int _type = it.getType();
            return Boolean.valueOf((_type != IResource.FILE));
          };
          final List<IResource> children = IterableExtensions.<IResource>toList(IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(container.members())), _function));
          Iterable<IResource> _xifexpression = null;
          if ((this.intermediateModelClass != null)) {
            final Function1<IResource, Boolean> _function_1 = (IResource it) -> {
              if (((it.getType() != IResource.FILE) || (!Objects.equal(it.getFileExtension(), "xmi")))) {
                return Boolean.valueOf(false);
              }
              final XMIResource xmiResource = LemmaUiUtils.loadXmiResource(((IFile) it));
              boolean _isEmpty = xmiResource.getContents().isEmpty();
              if (_isEmpty) {
                return Boolean.valueOf(false);
              }
              final EObject root = xmiResource.getContents().get(0);
              return Boolean.valueOf(this.intermediateModelClass.isAssignableFrom(root.getClass()));
            };
            _xifexpression = IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(container.members())), _function_1);
          } else {
            _xifexpression = CollectionLiterals.<IResource>emptyList();
          }
          final Iterable<IResource> applicableXmiFiles = _xifexpression;
          Iterables.<IResource>addAll(children, applicableXmiFiles);
          return ((Object[])Conversions.unwrapArray(children, Object.class));
        }
      }
      return new Object[0];
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Get root elements
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    return this.getChildren(inputElement);
  }
  
  /**
   * Get parent of an element
   */
  @Override
  public Object getParent(final Object element) {
    IContainer _xifexpression = null;
    if ((element instanceof IResource)) {
      _xifexpression = ((IResource)element).getParent();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Determine if the given element has children
   */
  @Override
  public boolean hasChildren(final Object element) {
    boolean _isEmpty = ((List<Object>)Conversions.doWrapArray(this.getChildren(element))).isEmpty();
    return (!_isEmpty);
  }
}
