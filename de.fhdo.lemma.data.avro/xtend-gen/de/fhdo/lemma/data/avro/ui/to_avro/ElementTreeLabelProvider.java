package de.fhdo.lemma.data.avro.ui.to_avro;

import de.fhdo.lemma.data.avro.Util;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * Provider of styled labels for model tree elements.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ElementTreeLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  /**
   * Icon for LEMMA Versions
   */
  public static final Image VERSION_ICON = LemmaUiUtils.createImage(
    ElementTreeLabelProvider.RESOURCE_MANAGER, ElementTreeLabelProvider.class, 
    "version.png");
  
  /**
   * Icon for LEMMA Contexts
   */
  public static final Image CONTEXT_ICON = LemmaUiUtils.createImage(
    ElementTreeLabelProvider.RESOURCE_MANAGER, ElementTreeLabelProvider.class, 
    "context.gif");
  
  /**
   * Icon for LEMMA ComplexTypes
   */
  public static final Image COMPLEX_TYPE_ICON = LemmaUiUtils.createImage(
    ElementTreeLabelProvider.RESOURCE_MANAGER, ElementTreeLabelProvider.class, 
    "complexType.gif");
  
  /**
   * Get styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    String _simpleName = Util.getSimpleName(Util.qualifiedName(((EObject) element)));
    return new StyledString(_simpleName);
  }
  
  /**
   * Get image for element
   */
  @Override
  public Image getImage(final Object element) {
    Image _switchResult = null;
    boolean _matched = false;
    if (element instanceof IntermediateVersion) {
      _matched=true;
      _switchResult = ElementTreeLabelProvider.VERSION_ICON;
    }
    if (!_matched) {
      if (element instanceof IntermediateContext) {
        _matched=true;
        _switchResult = ElementTreeLabelProvider.CONTEXT_ICON;
      }
    }
    if (!_matched) {
      if (element instanceof IntermediateComplexType) {
        _matched=true;
        _switchResult = ElementTreeLabelProvider.COMPLEX_TYPE_ICON;
      }
    }
    return _switchResult;
  }
}
