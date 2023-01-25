package de.fhdo.lemma.ui.quickfix;

import java.util.List;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class SecuritySmellContextProvider implements ITreeContentProvider {
  private List<String> options = CollectionLiterals.<String>newLinkedList();
  
  @Override
  public Object[] getChildren(final Object parentElement) {
    Object[] _switchResult = null;
    boolean _matched = false;
    if (parentElement instanceof String) {
      _matched=true;
      _switchResult = this.getChildren(parentElement);
    }
    return _switchResult;
  }
  
  @Override
  public Object[] getElements(final Object inputElement) {
    return ((Object[])Conversions.unwrapArray(this.options, Object.class));
  }
  
  @Override
  public Object getParent(final Object element) {
    Object _switchResult = null;
    boolean _matched = false;
    if (element instanceof String) {
      _matched=true;
      _switchResult = this.getParent(element);
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  @Override
  public boolean hasChildren(final Object element) {
    return false;
  }
  
  public Object setOption(final List<String> list) {
    return this.setOption(list);
  }
}
