package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments

import org.eclipse.xtend.lib.annotations.Accessors

import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import javax.xml.stream.XMLStreamWriter
import org.w3c.dom.Element
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfigurationItem
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Domain concept for model processing configuration arguments.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Argument extends ProcessingConfigurationItem {
    public static val XML_ARGUMENT_ELEMENT = "argument"
    static val XML_ARGUMENT_ATTR_KIND = "kind"
    static val XML_ARGUMENT_ATTR_TYPE = "type"
    static val XML_PARAMETER_ELEMENT = "parameter"
    static val XML_VALUE_ELEMENT = "value"

    @Accessors(PUBLIC_GETTER)
    var AbstractArgumentKind kind

    /**
     * Set the argument kind and fire a corresponding property change event
     */
    final def setKind(AbstractArgumentKind kind) {
        firePropertyChange("kind", this.kind, this.kind = kind)
    }

    @Accessors(PUBLIC_GETTER)
    var AbstractArgumentType type

    /**
     * Set the argument type and fire a corresponding property change event
     */
    final def setType(AbstractArgumentType type) {
        firePropertyChange("type", this.type, this.type = type)
    }

    @Accessors(PUBLIC_GETTER)
    var String parameter

    /**
     * Set the argument parameter and fire a corresponding property change event
     */
    final def setParameter(String parameter) {
        firePropertyChange("parameter", this.parameter, this.parameter = parameter)
    }

    @Accessors(PUBLIC_GETTER)
    var String value

    /**
     * Set the argument value and fire a corresponding property change event
     */
    final def setValue(String value) {
        firePropertyChange("value", this.value, this.value = value)
    }

    /**
     * Clone the Argument
     */
    override clone() {
        return super.clone()
    }

    /**
     * Empty constructor
     */
    new() {
        // NOOP
    }

    /**
     * Constructor
     */
    new(AbstractArgumentKind kind, AbstractArgumentType type, String parameter, String value) {
        this.kind = kind
        this.type = type
        this.parameter = parameter
        this.value = value
    }

    /**
     * Factory method to create a new Argument instance
     */
    static def newArgument() {
        return new ArgumentBuilder(new Argument())
    }

    /**
     * Factory method to create a new Argument instance for the given model processing configuration
     */
    static def newArgument(ProcessingConfiguration processingConfiguration) {
        return new ArgumentBuilder(new Argument(), processingConfiguration)
    }

    /**
     * Convert the argument into its user representation
     */
    final override convertToUserRepresentation() {
        value = type?.convertValueToUserRepresentation(value) ?: ""
    }

    /**
     * Validate the argument in its user representation
     */
    final def validateInUserRepresentation(ProcessingConfiguration configuration) {
        validateKind()
        validateType()
        validateParameter()
        validateValueInUserRepresentation(configuration)
    }

    /**
     * Validate the argument kind
     */
    private def validateKind() {
        notNull(kind, "Processing argument kind must not be empty")
    }

    /**
     * Validate the argument type
     */
    private def validateType() {
        notNull(type, "Processing argument type must not be empty")
        kind.validateTypeSupport(type)
    }

    /**
     * Validate the argument parameter
     */
    final def validateParameter() {
        notNullOrEmpty(parameter, "Processing argument parameter must not be empty")
    }

    /**
     * Validate the argument value in its user representation
     */
    private def validateValueInUserRepresentation(ProcessingConfiguration configuration) {
        type.validateValueInUserRepresentation(configuration, value)
    }

    /**
     * Convert the argument into its internal representation
     */
    final override convertToInternalRepresentation() {
        value = type?.convertValueToInternalRepresentation(value) ?: ""
    }

    /**
     * Serialize the argument to XML
     */
    final override serializeTo(XMLStreamWriter writer) {
        writer.writeStartElement(XML_ARGUMENT_ELEMENT)
        writer.writeAttribute(XML_ARGUMENT_ATTR_KIND, kind?.identifier.toString ?: "")
        writer.writeAttribute(XML_ARGUMENT_ATTR_TYPE, type?.identifier.toString ?: "")

        writer.writeStartElement(XML_PARAMETER_ELEMENT)
        writer.writeCharacters(parameter ?: "")
        writer.writeEndElement()

        writer.writeStartElement(XML_VALUE_ELEMENT)
        writer.writeCharacters(value ?: "")
        writer.writeEndElement()

        writer.writeEndElement()
    }

    /**
     * Deserialize the argument from its XML representation
     */
    final override deserializeFrom(Element element) {
        kind = ArgumentKindFactory.fromIdentifier(element.getAttribute(XML_ARGUMENT_ATTR_KIND))
        type = ArgumentTypeFactory.fromIdentifier(element.getAttribute(XML_ARGUMENT_ATTR_TYPE))
        parameter = findChildElementWithTag(element, XML_PARAMETER_ELEMENT)?.textContent
        value = findChildElementWithTag(element, XML_VALUE_ELEMENT)?.textContent
    }
}