package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.PreviousExitValueComparator;
import java.util.Map;
import javax.xml.stream.XMLStreamWriter;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.w3c.dom.Element;

/**
 * Domain concept for model processing chain entries.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ProcessingChainEntry extends ModelElementWithPropertyChangeSupport implements Cloneable {
  public static final String XML_PROCESSING_CHAIN_ENTRY = "processingChainEntry";
  
  private static final int DEFAULT_PREVIOUS_EXIT_VALUE = 0;
  
  private static final PreviousExitValueComparator.Comparator DEFAULT_PREVIOUS_EXIT_VALUE_COMPARATOR = PreviousExitValueComparator.Comparator.EQUAL;
  
  private static final String XML_LAUNCH_CONFIGURATION_NAME_ATTR = "launchConfigurationName";
  
  private static final String XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR = "previousExitValueComparator";
  
  private static final String XML_PREVIOUS_EXIT_VALUE_ATTR = "previousExitValue";
  
  @Accessors
  private ProcessingChain chain;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String launchConfigurationName;
  
  /**
   * Set the name of the entry's model processing launch configuration and fire a corresponding
   * property change event
   */
  public final void setLaunchConfigurationName(final String launchConfigurationName) {
    this.firePropertyChange("launchConfigurationName", this.launchConfigurationName, 
      this.launchConfigurationName = launchConfigurationName);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private PreviousExitValueComparator.Comparator previousExitValueComparator;
  
  /**
   * Set the entry's exit value comparator and fire a corresponding property change event
   */
  public final void setPreviousExitValueComparator(final PreviousExitValueComparator.Comparator previousExitValueComparator) {
    this.firePropertyChange("previousExitValueComparator", this.previousExitValueComparator, 
      this.previousExitValueComparator = previousExitValueComparator);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Integer previousExitValue;
  
  /**
   * Set the entry's exit value and fire a corresponding property change event
   */
  public final void setPreviousExitValue(final Integer previousExitValue) {
    this.firePropertyChange("previousExitValue", this.previousExitValue, 
      this.previousExitValue = previousExitValue);
  }
  
  /**
   * Clone the entry
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
   * Deserialize the entry from its XML representation stored in the given Element
   */
  public static ProcessingChainEntry deserializeFrom(final Element element) {
    final ProcessingChainEntry entry = new ProcessingChainEntry();
    entry.launchConfigurationName = element.getAttribute(ProcessingChainEntry.XML_LAUNCH_CONFIGURATION_NAME_ATTR);
    final String previousExitValueComparatorXmlValue = element.getAttribute(ProcessingChainEntry.XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR);
    PreviousExitValueComparator.Comparator _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(previousExitValueComparatorXmlValue);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = PreviousExitValueComparator.Comparator.valueOf(previousExitValueComparatorXmlValue);
    } else {
      _xifexpression = null;
    }
    entry.previousExitValueComparator = _xifexpression;
    final String previousExitValueXmlValue = element.getAttribute(ProcessingChainEntry.XML_PREVIOUS_EXIT_VALUE_ATTR);
    Integer _xifexpression_1 = null;
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(previousExitValueXmlValue);
    boolean _not_1 = (!_isNullOrEmpty_1);
    if (_not_1) {
      _xifexpression_1 = Integer.valueOf(previousExitValueXmlValue);
    } else {
      _xifexpression_1 = null;
    }
    entry.previousExitValue = _xifexpression_1;
    return entry;
  }
  
  /**
   * Empty constructor
   */
  private ProcessingChainEntry() {
  }
  
  /**
   * Constructor that takes the model processing configuration and chain of the entry
   */
  public ProcessingChainEntry(final String launchConfigurationName, final ProcessingChain chain) {
    this.launchConfigurationName = launchConfigurationName;
    this.chain = chain;
    this.previousExitValueComparator = ProcessingChainEntry.DEFAULT_PREVIOUS_EXIT_VALUE_COMPARATOR;
    this.previousExitValue = Integer.valueOf(ProcessingChainEntry.DEFAULT_PREVIOUS_EXIT_VALUE);
  }
  
  /**
   * Validate the entry
   */
  public final void validate(final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    this.validateLaunchConfigurationName(availableLaunchConfigurations);
    this.validatePreviousExitValueComparator();
    this.validatePreviousExitValue();
  }
  
  /**
   * Validate the name of the model processing launch configuration assigned to the entry
   */
  public final void validateLaunchConfigurationName(final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    ProcessingChainEntry.validateLaunchConfigurationName(this.launchConfigurationName, availableLaunchConfigurations);
  }
  
  /**
   * Validate the given name of a model processing launch configuration
   */
  public static void validateLaunchConfigurationName(final String launchConfigurationName, final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    Utils.notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty");
    final boolean existsLaunchConfiguration = availableLaunchConfigurations.keySet().contains(launchConfigurationName);
    if ((!existsLaunchConfiguration)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(launchConfigurationName);
      _builder.append(" does not exist or does not concern the execution ");
      String _plus = ("Launch configuration with name " + _builder);
      String _plus_1 = (_plus + 
        "of a LEMMA model processor");
      throw new IllegalArgumentException(_plus_1);
    }
  }
  
  /**
   * Validate the exit value comparator assigned to the entry
   */
  public final void validatePreviousExitValueComparator() {
    ProcessingChainEntry.validatePreviousExitValueComparator(this.previousExitValueComparator, this);
  }
  
  /**
   * Validate the given exit value comparator in the context of the given entry
   */
  public static void validatePreviousExitValueComparator(final PreviousExitValueComparator.Comparator previousExitValueComparator, final ProcessingChainEntry entry) {
    boolean _isEditable = entry.isEditable();
    if (_isEditable) {
      Utils.notNull(previousExitValueComparator, "Exit value comparator must not be empty");
    }
  }
  
  /**
   * Check if the entry is editable which is the case when it is not the first entry in the chain.
   * The check concerns the editability of all attributes of the entry besides the assigned model
   * processing launch configuration which is always editable.
   */
  public final boolean isEditable() {
    int _indexOf = this.chain.getEntries().indexOf(this);
    final boolean isFirstEntry = (_indexOf == 0);
    return (!isFirstEntry);
  }
  
  /**
   * Validate the exit value assigned to the entry
   */
  public final void validatePreviousExitValue() {
    ProcessingChainEntry.validatePreviousExitValue(this.previousExitValue, this);
  }
  
  /**
   * Validate the given exit value in the context of the given entry
   */
  public static void validatePreviousExitValue(final Integer previousExitValue, final ProcessingChainEntry entry) {
    boolean _isEditable = entry.isEditable();
    boolean _not = (!_isEditable);
    if (_not) {
      return;
    }
    Utils.notNull(previousExitValue, "Exit value must not be empty");
    if (((previousExitValue).intValue() < 0)) {
      throw new IllegalArgumentException("Exit value must be greater or equal zero");
    } else {
      boolean _equals = Objects.equal(entry.previousExitValueComparator, PreviousExitValueComparator.Comparator.LOWER);
      if (_equals) {
        throw new IllegalArgumentException(("Exit value comparison result must be greater or " + 
          "equal zero"));
      }
    }
  }
  
  /**
   * Serialize the entry to XML
   */
  public void serializeTo(final XMLStreamWriter writer) {
    try {
      writer.writeStartElement(ProcessingChainEntry.XML_PROCESSING_CHAIN_ENTRY);
      String _elvis = null;
      if (this.launchConfigurationName != null) {
        _elvis = this.launchConfigurationName;
      } else {
        _elvis = "";
      }
      writer.writeAttribute(ProcessingChainEntry.XML_LAUNCH_CONFIGURATION_NAME_ATTR, _elvis);
      String _elvis_1 = null;
      String _string = null;
      if (this.previousExitValueComparator!=null) {
        _string=this.previousExitValueComparator.toString();
      }
      if (_string != null) {
        _elvis_1 = _string;
      } else {
        _elvis_1 = "";
      }
      writer.writeAttribute(ProcessingChainEntry.XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR, _elvis_1);
      String _elvis_2 = null;
      String _string_1 = null;
      if (this.previousExitValue!=null) {
        _string_1=this.previousExitValue.toString();
      }
      if (_string_1 != null) {
        _elvis_2 = _string_1;
      } else {
        _elvis_2 = "";
      }
      writer.writeAttribute(ProcessingChainEntry.XML_PREVIOUS_EXIT_VALUE_ATTR, _elvis_2);
      writer.writeEndElement();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public ProcessingChain getChain() {
    return this.chain;
  }
  
  public void setChain(final ProcessingChain chain) {
    this.chain = chain;
  }
  
  @Pure
  public String getLaunchConfigurationName() {
    return this.launchConfigurationName;
  }
  
  @Pure
  public PreviousExitValueComparator.Comparator getPreviousExitValueComparator() {
    return this.previousExitValueComparator;
  }
  
  @Pure
  public Integer getPreviousExitValue() {
    return this.previousExitValue;
  }
}
