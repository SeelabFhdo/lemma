package de.fhdo.lemma.data.avro.ui.to_lemma;

import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * Provider of styled labels for the tree viewer in the Avro-to-LEMMA conversion dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SchemaTreeLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  /**
   * Icon for Avro protocols
   */
  public static final Image PROTOCOL_ICON = LemmaUiUtils.createImage(
    SchemaTreeLabelProvider.RESOURCE_MANAGER, SchemaTreeLabelProvider.class, 
    "protocol.gif");
  
  /**
   * Icon for Avro namespaces
   */
  public static final Image NAMESPACE_ICON = LemmaUiUtils.createImage(
    SchemaTreeLabelProvider.RESOURCE_MANAGER, SchemaTreeLabelProvider.class, 
    "namespace.gif");
  
  /**
   * Icon for Avro schemas
   */
  public static final Image SCHEMA_ICON = LemmaUiUtils.createImage(
    SchemaTreeLabelProvider.RESOURCE_MANAGER, SchemaTreeLabelProvider.class, 
    "schema.gif");
  
  /**
   * Get styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof AvroToLemmaDialog.AvroProtocol) {
      _matched=true;
      _switchResult = ((AvroToLemmaDialog.AvroProtocol)element).getProtocol().getName();
    }
    if (!_matched) {
      if (element instanceof AvroToLemmaDialog.AvroNamespace) {
        _matched=true;
        String _xifexpression = null;
        String _namespace = ((AvroToLemmaDialog.AvroNamespace)element).getNamespace();
        boolean _tripleNotEquals = (_namespace != null);
        if (_tripleNotEquals) {
          _xifexpression = ((AvroToLemmaDialog.AvroNamespace)element).getNamespace();
        } else {
          _xifexpression = "No namespace";
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (element instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroSchemaWithNamespace)element).getSchema().getName();
      }
    }
    return new StyledString(_switchResult);
  }
  
  /**
   * Get image for element
   */
  @Override
  public Image getImage(final Object element) {
    Image _switchResult = null;
    boolean _matched = false;
    if (element instanceof AvroToLemmaDialog.AvroProtocol) {
      _matched=true;
      _switchResult = SchemaTreeLabelProvider.PROTOCOL_ICON;
    }
    if (!_matched) {
      if (element instanceof AvroToLemmaDialog.AvroNamespace) {
        _matched=true;
        _switchResult = SchemaTreeLabelProvider.NAMESPACE_ICON;
      }
    }
    if (!_matched) {
      if (element instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
        _matched=true;
        _switchResult = SchemaTreeLabelProvider.SCHEMA_ICON;
      }
    }
    return _switchResult;
  }
}
