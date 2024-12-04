package de.fhdo.lemma.reconstruction.ui;

import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.DataStructure;
import de.fhdo.lemma.reconstruction.domain.Field;
import java.util.List;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Content provider to display information from the architecture information,
 * loaded form the MongoDb.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class ReconstructionContentProvider implements ITreeContentProvider {
  /**
   * Get child information from reconstructed elements, e.g., context have
   * data structures and child elements in the tree.
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    List<?> _switchResult = null;
    boolean _matched = false;
    if (parentElement instanceof Context) {
      _matched=true;
      _switchResult = ((Context)parentElement).getDataStructures();
    }
    if (!_matched) {
      if (parentElement instanceof DataStructure) {
        _matched=true;
        _switchResult = ((DataStructure)parentElement).getFields();
      }
    }
    return ((Object[])Conversions.unwrapArray(_switchResult, Object.class));
  }

  /**
   * Handle input elements as a list
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    return ((Object[])Conversions.unwrapArray(((List<?>) inputElement), Object.class));
  }

  /**
   * Get parents for reconstructed elements
   */
  @Override
  public Object getParent(final Object element) {
    Object _switchResult = null;
    boolean _matched = false;
    if (element instanceof Context) {
      _matched=true;
      _switchResult = this.getParent(element);
    }
    if (!_matched) {
      if (element instanceof DataStructure) {
        _matched=true;
        _switchResult = this.getParent(element);
      }
    }
    if (!_matched) {
      if (element instanceof Field) {
        _matched=true;
        _switchResult = this.getParent(element);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }

  /**
   * Check if elements have children
   */
  @Override
  public boolean hasChildren(final Object element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof Context) {
      _matched=true;
      boolean _isEmpty = ((Context)element).getDataStructures().isEmpty();
      return (!_isEmpty);
    }
    if (!_matched) {
      if (element instanceof DataStructure) {
        _matched=true;
        boolean _isEmpty = ((DataStructure)element).getFields().isEmpty();
        return (!_isEmpty);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
