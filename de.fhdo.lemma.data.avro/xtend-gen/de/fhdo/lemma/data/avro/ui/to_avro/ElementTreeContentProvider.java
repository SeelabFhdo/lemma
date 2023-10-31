package de.fhdo.lemma.data.avro.ui.to_avro;

import de.fhdo.lemma.data.avro.Util;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Content provider for the model element selection tree in the LEMMA to Avro dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ElementTreeContentProvider implements ITreeContentProvider {
  /**
   * Get root elements
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    return ((Object[])Conversions.unwrapArray(this.sortByName(((List<? extends EObject>) inputElement)), Object.class));
  }

  /**
   * Helper to sort a list of LEMMA EObjects by their simple, i.e., non fully-qualified, names
   */
  private List<? extends EObject> sortByName(final List<? extends EObject> eObjects) {
    return IterableExtensions.sortWith(eObjects, new Comparator<EObject>() {
      @Override
      public int compare(final EObject o1, final EObject o2) {
        final String name1 = LemmaUtils.getSimpleName(Util.qualifiedName(o1));
        final String name2 = LemmaUtils.getSimpleName(Util.qualifiedName(o2));
        return name1.compareTo(name2);
      }
    });
  }

  /**
   * Get children of parent element
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    List<? extends EObject> _switchResult = null;
    boolean _matched = false;
    if (parentElement instanceof IntermediateVersion) {
      _matched=true;
      List<? extends EObject> _xifexpression = null;
      boolean _isEmpty = ((IntermediateVersion)parentElement).getContexts().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = this.sortByName(((IntermediateVersion)parentElement).getContexts());
      } else {
        _xifexpression = this.sortByName(((IntermediateVersion)parentElement).getComplexTypes());
      }
      _switchResult = _xifexpression;
    }
    if (!_matched) {
      if (parentElement instanceof IntermediateContext) {
        _matched=true;
        _switchResult = this.sortByName(((IntermediateContext)parentElement).getComplexTypes());
      }
    }
    return ((Object[])Conversions.unwrapArray(_switchResult, Object.class));
  }

  /**
   * Get parent of an element
   */
  @Override
  public Object getParent(final Object element) {
    EObject _switchResult = null;
    boolean _matched = false;
    if (element instanceof IntermediateContext) {
      _matched=true;
      _switchResult = ((IntermediateContext)element).getVersion();
    }
    if (!_matched) {
      if (element instanceof IntermediateComplexType) {
        _matched=true;
        EObject _elvis = null;
        IntermediateContext _context = ((IntermediateComplexType)element).getContext();
        if (_context != null) {
          _elvis = _context;
        } else {
          IntermediateVersion _version = ((IntermediateComplexType)element).getVersion();
          _elvis = _version;
        }
        _switchResult = _elvis;
      }
    }
    return _switchResult;
  }

  /**
   * Determine if the given element has children
   */
  @Override
  public boolean hasChildren(final Object element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof IntermediateVersion) {
      _matched=true;
      _switchResult = ((!((IntermediateVersion)element).getContexts().isEmpty()) || (!((IntermediateVersion)element).getComplexTypes().isEmpty()));
    }
    if (!_matched) {
      if (element instanceof IntermediateContext) {
        _matched=true;
        boolean _isEmpty = ((IntermediateContext)element).getComplexTypes().isEmpty();
        _switchResult = (!_isEmpty);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
