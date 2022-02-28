package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfigurationItem;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindIdentifier;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeIdentifier;
import javax.xml.stream.XMLStreamWriter;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.w3c.dom.Element;

/**
 * Domain concept for model processing configuration arguments.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Argument extends ProcessingConfigurationItem {
  public static final String XML_ARGUMENT_ELEMENT = "argument";
  
  private static final String XML_ARGUMENT_ATTR_KIND = "kind";
  
  private static final String XML_ARGUMENT_ATTR_TYPE = "type";
  
  private static final String XML_PARAMETER_ELEMENT = "parameter";
  
  private static final String XML_VALUE_ELEMENT = "value";
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private AbstractArgumentKind kind;
  
  /**
   * Set the argument kind and fire a corresponding property change event
   */
  public final void setKind(final AbstractArgumentKind kind) {
    this.firePropertyChange("kind", this.kind, this.kind = kind);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private AbstractArgumentType type;
  
  /**
   * Set the argument type and fire a corresponding property change event
   */
  public final void setType(final AbstractArgumentType type) {
    this.firePropertyChange("type", this.type, this.type = type);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String parameter;
  
  /**
   * Set the argument parameter and fire a corresponding property change event
   */
  public final void setParameter(final String parameter) {
    this.firePropertyChange("parameter", this.parameter, this.parameter = parameter);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String value;
  
  /**
   * Set the argument value and fire a corresponding property change event
   */
  public final void setValue(final String value) {
    this.firePropertyChange("value", this.value, this.value = value);
  }
  
  /**
   * Clone the Argument
   */
  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Empty constructor
   */
  public Argument() {
  }
  
  /**
   * Constructor
   */
  public Argument(final AbstractArgumentKind kind, final AbstractArgumentType type, final String parameter, final String value) {
    this.kind = kind;
    this.type = type;
    this.parameter = parameter;
    this.value = value;
  }
  
  /**
   * Factory method to create a new Argument instance
   */
  public static ArgumentBuilder newArgument() {
    Argument _argument = new Argument();
    return new ArgumentBuilder(_argument);
  }
  
  /**
   * Factory method to create a new Argument instance for the given model processing configuration
   */
  public static ArgumentBuilder newArgument(final ProcessingConfiguration processingConfiguration) {
    Argument _argument = new Argument();
    return new ArgumentBuilder(_argument, processingConfiguration);
  }
  
  /**
   * Convert the argument into its user representation
   */
  @Override
  public final Object convertToUserRepresentation() {
    String _elvis = null;
    String _convertValueToUserRepresentation = null;
    if (this.type!=null) {
      _convertValueToUserRepresentation=this.type.convertValueToUserRepresentation(this.value);
    }
    if (_convertValueToUserRepresentation != null) {
      _elvis = _convertValueToUserRepresentation;
    } else {
      _elvis = "";
    }
    return this.value = _elvis;
  }
  
  /**
   * Validate the argument in its user representation
   */
  public final void validateInUserRepresentation(final ProcessingConfiguration configuration) {
    this.validateKind();
    this.validateType();
    this.validateParameter();
    this.validateValueInUserRepresentation(configuration);
  }
  
  /**
   * Validate the argument kind
   */
  private void validateKind() {
    Utils.notNull(this.kind, "Processing argument kind must not be empty");
  }
  
  /**
   * Validate the argument type
   */
  private void validateType() {
    Utils.notNull(this.type, "Processing argument type must not be empty");
    this.kind.validateTypeSupport(this.type);
  }
  
  /**
   * Validate the argument parameter
   */
  public final void validateParameter() {
    Utils.notNullOrEmpty(this.parameter, "Processing argument parameter must not be empty");
  }
  
  /**
   * Validate the argument value in its user representation
   */
  private void validateValueInUserRepresentation(final ProcessingConfiguration configuration) {
    this.type.validateValueInUserRepresentation(configuration, this.value);
  }
  
  /**
   * Convert the argument into its internal representation
   */
  @Override
  public final Object convertToInternalRepresentation() {
    String _elvis = null;
    String _convertValueToInternalRepresentation = null;
    if (this.type!=null) {
      _convertValueToInternalRepresentation=this.type.convertValueToInternalRepresentation(this.value);
    }
    if (_convertValueToInternalRepresentation != null) {
      _elvis = _convertValueToInternalRepresentation;
    } else {
      _elvis = "";
    }
    return this.value = _elvis;
  }
  
  /**
   * Serialize the argument to XML
   */
  @Override
  public final void serializeTo(final XMLStreamWriter writer) {
    try {
      writer.writeStartElement(Argument.XML_ARGUMENT_ELEMENT);
      String _elvis = null;
      ArgumentKindIdentifier _identifier = null;
      if (this.kind!=null) {
        _identifier=this.kind.getIdentifier();
      }
      String _string = _identifier.toString();
      if (_string != null) {
        _elvis = _string;
      } else {
        _elvis = "";
      }
      writer.writeAttribute(Argument.XML_ARGUMENT_ATTR_KIND, _elvis);
      String _elvis_1 = null;
      ArgumentTypeIdentifier _identifier_1 = null;
      if (this.type!=null) {
        _identifier_1=this.type.getIdentifier();
      }
      String _string_1 = _identifier_1.toString();
      if (_string_1 != null) {
        _elvis_1 = _string_1;
      } else {
        _elvis_1 = "";
      }
      writer.writeAttribute(Argument.XML_ARGUMENT_ATTR_TYPE, _elvis_1);
      writer.writeStartElement(Argument.XML_PARAMETER_ELEMENT);
      String _elvis_2 = null;
      if (this.parameter != null) {
        _elvis_2 = this.parameter;
      } else {
        _elvis_2 = "";
      }
      writer.writeCharacters(_elvis_2);
      writer.writeEndElement();
      writer.writeStartElement(Argument.XML_VALUE_ELEMENT);
      String _elvis_3 = null;
      if (this.value != null) {
        _elvis_3 = this.value;
      } else {
        _elvis_3 = "";
      }
      writer.writeCharacters(_elvis_3);
      writer.writeEndElement();
      writer.writeEndElement();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Deserialize the argument from its XML representation
   */
  @Override
  public final void deserializeFrom(final Element element) {
    this.kind = ArgumentKindFactory.fromIdentifier(element.getAttribute(Argument.XML_ARGUMENT_ATTR_KIND));
    this.type = ArgumentTypeFactory.fromIdentifier(element.getAttribute(Argument.XML_ARGUMENT_ATTR_TYPE));
    Element _findChildElementWithTag = Utils.findChildElementWithTag(element, Argument.XML_PARAMETER_ELEMENT);
    String _textContent = null;
    if (_findChildElementWithTag!=null) {
      _textContent=_findChildElementWithTag.getTextContent();
    }
    this.parameter = _textContent;
    Element _findChildElementWithTag_1 = Utils.findChildElementWithTag(element, Argument.XML_VALUE_ELEMENT);
    String _textContent_1 = null;
    if (_findChildElementWithTag_1!=null) {
      _textContent_1=_findChildElementWithTag_1.getTextContent();
    }
    this.value = _textContent_1;
  }
  
  @Pure
  public AbstractArgumentKind getKind() {
    return this.kind;
  }
  
  @Pure
  public AbstractArgumentType getType() {
    return this.type;
  }
  
  @Pure
  public String getParameter() {
    return this.parameter;
  }
  
  @Pure
  public String getValue() {
    return this.value;
  }
}
