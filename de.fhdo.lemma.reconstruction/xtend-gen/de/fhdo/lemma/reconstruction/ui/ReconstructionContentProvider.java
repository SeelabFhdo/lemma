package de.fhdo.lemma.reconstruction.ui;

import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.DataStructure;
import de.fhdo.lemma.reconstruction.domain.Field;
import de.fhdo.lemma.reconstruction.service.Interface;
import de.fhdo.lemma.reconstruction.service.Microservice;
import de.fhdo.lemma.reconstruction.service.Operation;
import java.util.List;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class ReconstructionContentProvider implements ITreeContentProvider {
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
    if (!_matched) {
      if (parentElement instanceof Microservice) {
        _matched=true;
        _switchResult = ((Microservice)parentElement).getInterfaces();
      }
    }
    if (!_matched) {
      if (parentElement instanceof Interface) {
        _matched=true;
        _switchResult = ((Interface)parentElement).getOperations();
      }
    }
    return ((Object[])Conversions.unwrapArray(_switchResult, Object.class));
  }
  
  @Override
  public Object[] getElements(final Object inputElement) {
    return ((Object[])Conversions.unwrapArray(((List<?>) inputElement), Object.class));
  }
  
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
      if (element instanceof Microservice) {
        _matched=true;
        _switchResult = this.getParent(element);
      }
    }
    if (!_matched) {
      if (element instanceof Interface) {
        _matched=true;
        _switchResult = this.getParent(element);
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        _matched=true;
        _switchResult = this.getParent(element);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
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
      if (element instanceof Microservice) {
        _matched=true;
        boolean _isEmpty = ((Microservice)element).getInterfaces().isEmpty();
        return (!_isEmpty);
      }
    }
    if (!_matched) {
      if (element instanceof Interface) {
        _matched=true;
        boolean _isEmpty = ((Interface)element).getOperations().isEmpty();
        return (!_isEmpty);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
