package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import javax.xml.stream.XMLStreamWriter
import org.w3c.dom.Element
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport

/**
 * Abstract superclass for all items in a model processing configuration.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class ProcessingConfigurationItem extends ModelElementWithPropertyChangeSupport
    implements Cloneable {
    /**
     * Serialize the item to its XML representation using the given XMLStreamWriter
     */
    abstract def void serializeTo(XMLStreamWriter writer)

    /**
     * Convert the item to its user representation
     */
    def convertToUserRepresentation() {
        // NOOP
    }

    /**
     * Convert the item to its internal representation
     */
    def convertToInternalRepresentation() {
        // NOOP
    }

    /**
     * Deserialize the item from its XML Element representation
     */
    abstract def void deserializeFrom(Element element)
}