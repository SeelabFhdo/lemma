package de.fhdo.lemma.reconstruction.ui;

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.DataStructure;
import de.fhdo.lemma.reconstruction.domain.Field;
import de.fhdo.lemma.reconstruction.service.Interface;
import de.fhdo.lemma.reconstruction.service.Microservice;
import de.fhdo.lemma.reconstruction.service.Operation;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

@SuppressWarnings("all")
public class ReconstructionTreeLableProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  /**
   * Icon for Avro protocols
   */
  public static final Image CONTEXT_ICON = LemmaUiUtils.createImage(
    ReconstructionTreeLableProvider.RESOURCE_MANAGER, ReconstructionTreeLableProvider.class, 
    "protocol.gif");
  
  /**
   * Get styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    final Object data = element;
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof Context) {
      _matched=true;
      _switchResult = ((Context)element).getQualifiedName();
    }
    if (!_matched) {
      if (element instanceof DataStructure) {
        _matched=true;
        _switchResult = ((DataStructure)element).getName();
      }
    }
    if (!_matched) {
      if (element instanceof Field) {
        _matched=true;
        _switchResult = ((Field)element).getName();
      }
    }
    if (!_matched) {
      if (element instanceof Microservice) {
        _matched=true;
        _switchResult = ((Microservice)element).getName();
      }
    }
    if (!_matched) {
      if (element instanceof Interface) {
        _matched=true;
        _switchResult = ((Interface)element).getName();
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        _matched=true;
        _switchResult = ((Operation)element).getName();
      }
    }
    if (!_matched) {
      _switchResult = "default";
    }
    return new StyledString(_switchResult);
  }
}
