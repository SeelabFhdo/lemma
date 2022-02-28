package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport
import org.eclipse.xtend.lib.annotations.Accessors
import javax.xml.stream.XMLStreamWriter
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.w3c.dom.Element
import java.util.Map
import org.eclipse.debug.core.ILaunchConfiguration

/**
 * Domain concept for model processing chain entries.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProcessingChainEntry extends ModelElementWithPropertyChangeSupport
    implements Cloneable {
    public static val XML_PROCESSING_CHAIN_ENTRY = "processingChainEntry"

    static val DEFAULT_PREVIOUS_EXIT_VALUE = 0
    static val DEFAULT_PREVIOUS_EXIT_VALUE_COMPARATOR = PreviousExitValueComparator.Comparator.EQUAL
    static val XML_LAUNCH_CONFIGURATION_NAME_ATTR = "launchConfigurationName"
    static val XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR = "previousExitValueComparator"
    static val XML_PREVIOUS_EXIT_VALUE_ATTR = "previousExitValue"

    @Accessors
    var ProcessingChain chain

    @Accessors(PUBLIC_GETTER)
    var String launchConfigurationName

    /**
     * Set the name of the entry's model processing launch configuration and fire a corresponding
     * property change event
     */
    final def setLaunchConfigurationName(String launchConfigurationName) {
        firePropertyChange("launchConfigurationName", this.launchConfigurationName,
            this.launchConfigurationName = launchConfigurationName)
    }

    @Accessors(PUBLIC_GETTER)
    var PreviousExitValueComparator.Comparator previousExitValueComparator

    /**
     * Set the entry's exit value comparator and fire a corresponding property change event
     */
    final def setPreviousExitValueComparator(
        PreviousExitValueComparator.Comparator previousExitValueComparator
    ) {
        firePropertyChange("previousExitValueComparator", this.previousExitValueComparator,
            this.previousExitValueComparator = previousExitValueComparator)
    }

    @Accessors(PUBLIC_GETTER)
    var Integer previousExitValue

    /**
     * Set the entry's exit value and fire a corresponding property change event
     */
    final def setPreviousExitValue(Integer previousExitValue) {
        firePropertyChange("previousExitValue", this.previousExitValue,
            this.previousExitValue = previousExitValue)
    }

    /**
     * Clone the entry
     */
    override clone() {
        // According to the protocol of the Cloneable interface, we delegate to super.clone() to
        // clone the entry and its attribute values
        return super.clone()
    }

    /**
     * Deserialize the entry from its XML representation stored in the given Element
     */
    static def deserializeFrom(Element element) {
        val entry = new ProcessingChainEntry
        entry.launchConfigurationName = element.getAttribute(XML_LAUNCH_CONFIGURATION_NAME_ATTR)

        val previousExitValueComparatorXmlValue = element
            .getAttribute(XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR)
        entry.previousExitValueComparator = if (!previousExitValueComparatorXmlValue.nullOrEmpty)
                PreviousExitValueComparator.Comparator.valueOf(previousExitValueComparatorXmlValue)
            else
                null

        val previousExitValueXmlValue = element.getAttribute(XML_PREVIOUS_EXIT_VALUE_ATTR)
        entry.previousExitValue = if (!previousExitValueXmlValue.nullOrEmpty)
                Integer.valueOf(previousExitValueXmlValue)
            else
                null

        return entry
    }

    /**
     * Empty constructor
     */
    private new() {
        // NOOP
    }

    /**
     * Constructor that takes the model processing configuration and chain of the entry
     */
    new(String launchConfigurationName, ProcessingChain chain) {
        this.launchConfigurationName = launchConfigurationName
        this.chain = chain
        this.previousExitValueComparator = DEFAULT_PREVIOUS_EXIT_VALUE_COMPARATOR
        this.previousExitValue = DEFAULT_PREVIOUS_EXIT_VALUE
    }

    /**
     * Validate the entry
     */
    final def validate(Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
        validateLaunchConfigurationName(availableLaunchConfigurations)
        validatePreviousExitValueComparator()
        validatePreviousExitValue()
    }

    /**
     * Validate the name of the model processing launch configuration assigned to the entry
     */
    final def validateLaunchConfigurationName(
        Map<String, ILaunchConfiguration> availableLaunchConfigurations
    ) {
        validateLaunchConfigurationName(launchConfigurationName, availableLaunchConfigurations)
    }

    /**
     * Validate the given name of a model processing launch configuration
     */
    static def validateLaunchConfigurationName(String launchConfigurationName,
        Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
        notNullOrEmpty(launchConfigurationName, "Launch configuration name must not be empty")

        val existsLaunchConfiguration = availableLaunchConfigurations.keySet
            .contains(launchConfigurationName)
        if (!existsLaunchConfiguration)
            throw new IllegalArgumentException("Launch configuration with name " +
                '''«launchConfigurationName» does not exist or does not concern the execution ''' +
                "of a LEMMA model processor")
    }

    /**
     * Validate the exit value comparator assigned to the entry
     */
    final def validatePreviousExitValueComparator() {
        validatePreviousExitValueComparator(previousExitValueComparator, this)
    }

    /**
     * Validate the given exit value comparator in the context of the given entry
     */
    static def validatePreviousExitValueComparator(
        PreviousExitValueComparator.Comparator previousExitValueComparator,
        ProcessingChainEntry entry
    ) {
        if (entry.editable)
            notNull(previousExitValueComparator, "Exit value comparator must not be empty")
    }

    /**
     * Check if the entry is editable which is the case when it is not the first entry in the chain.
     * The check concerns the editability of all attributes of the entry besides the assigned model
     * processing launch configuration which is always editable.
     */
    final def isEditable() {
        val isFirstEntry = chain.entries.indexOf(this) == 0
        return !isFirstEntry
    }

    /**
     * Validate the exit value assigned to the entry
     */
    final def validatePreviousExitValue() {
        validatePreviousExitValue(previousExitValue, this)
    }

    /**
     * Validate the given exit value in the context of the given entry
     */
    static def validatePreviousExitValue(Integer previousExitValue, ProcessingChainEntry entry) {
        if (!entry.editable) {
            return
        }

        notNull(previousExitValue, "Exit value must not be empty")

        if (previousExitValue < 0)
            throw new IllegalArgumentException("Exit value must be greater or equal zero")
        else if (entry.previousExitValueComparator == PreviousExitValueComparator.Comparator.LOWER)
            throw new IllegalArgumentException("Exit value comparison result must be greater or " +
                "equal zero")
    }

    /**
     * Serialize the entry to XML
     */
    def void serializeTo(XMLStreamWriter writer) {
        writer.writeStartElement(XML_PROCESSING_CHAIN_ENTRY)
        writer.writeAttribute(XML_LAUNCH_CONFIGURATION_NAME_ATTR, launchConfigurationName ?: "")
        writer.writeAttribute(XML_PREVIOUS_EXIT_VALUE_COMPARATOR_ATTR,
            previousExitValueComparator?.toString ?: "")
        writer.writeAttribute(XML_PREVIOUS_EXIT_VALUE_ATTR, previousExitValue?.toString ?: "")
        writer.writeEndElement()
    }
}