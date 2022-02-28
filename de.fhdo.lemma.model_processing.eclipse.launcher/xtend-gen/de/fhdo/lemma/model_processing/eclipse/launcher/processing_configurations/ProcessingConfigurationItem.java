package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Element;

/**
 * Abstract superclass for all items in a model processing configuration.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class ProcessingConfigurationItem extends ModelElementWithPropertyChangeSupport implements Cloneable {
  /**
   * Serialize the item to its XML representation using the given XMLStreamWriter
   */
  public abstract void serializeTo(final XMLStreamWriter writer);
  
  /**
   * Convert the item to its user representation
   */
  public Object convertToUserRepresentation() {
    return null;
  }
  
  /**
   * Convert the item to its internal representation
   */
  public Object convertToInternalRepresentation() {
    return null;
  }
  
  /**
   * Deserialize the item from its XML Element representation
   */
  public abstract void deserializeFrom(final Element element);
}
