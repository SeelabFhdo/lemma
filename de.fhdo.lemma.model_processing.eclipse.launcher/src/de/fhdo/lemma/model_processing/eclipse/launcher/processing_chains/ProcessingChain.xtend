package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport
import org.eclipse.xtend.lib.annotations.Accessors
import javax.xml.stream.XMLStreamWriter
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.w3c.dom.Element
import org.eclipse.debug.core.ILaunchConfiguration
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import java.io.ByteArrayOutputStream
import javax.xml.stream.XMLOutputFactory
import java.nio.charset.StandardCharsets
import java.util.List
import java.beans.PropertyChangeListener
import java.util.Map

/**
 * Domain concept for model processing chains.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ProcessingChain extends ModelElementWithPropertyChangeSupport implements Cloneable {
    static val XML_CHAIN_ELEMENT = "processingChain"
    static val XML_CHAIN_ENTRIES_ELEMENT = "entries"

    @Accessors(PUBLIC_GETTER)
    var List<ProcessingChainEntry> entries = newArrayList

    /**
     * Two chains are equal if they have the same entries
     */
    final override equals(Object o) {
        return if (o === this)
            true
        else if (!(o instanceof ProcessingChain))
            false
        else {
            val otherConfig = o as ProcessingChain
            equalLists(entries, otherConfig.entries)
        }
    }

    /**
     * Clone the chain which also entails the cloning of its entries
     */
    override clone() {
        val clone = super.clone() as ProcessingChain
        clone.entries = newArrayList(entries.map[clone() as ProcessingChainEntry])
        clone.entries.forEach[it.chain = clone]
        return clone
    }

    /**
     * Deserialize the model processing chain from its XML representation stored in the given
     * ILaunchConfiguration
     */
    static def deserializeFrom(ILaunchConfiguration launchConfiguration) {
        val xml = launchConfiguration.getAttribute(PROCESSING_CHAIN_ATTRIBUTE, "")
        if (xml.empty)
            return null

        val xmlRoot = getRootElementWithTag(parseXmlString(xml), XML_CHAIN_ELEMENT)
        if (xmlRoot === null)
            throw new IllegalArgumentException("Error during deserialization of processing " +
                '''chain: Root XML element «XML_CHAIN_ELEMENT» not found''')

        val chain = new ProcessingChain()
        initializeEntries(chain, xmlRoot)
        return chain
    }

    /**
     * Initialize the entries of the given chain from the given root of the chain's XML
     * representation
     */
    private static def initializeEntries(ProcessingChain chain, Element xmlRoot) {
        chain.entries = <ProcessingChainEntry>newArrayList
        val entriesParentElement = findChildElementWithTag(xmlRoot, XML_CHAIN_ENTRIES_ELEMENT)
        val entryElements = entriesParentElement
            .getElementsByTagName(ProcessingChainEntry.XML_PROCESSING_CHAIN_ENTRY)
        for (n : 0..<entryElements.length) {
            val entry = ProcessingChainEntry.deserializeFrom(entryElements.item(n) as Element)
            entry.chain = chain
            chain.entries.add(entry)
        }
    }

    /**
     * Assign the given chain to the String attribute of the given ILaunchConfigurationWorkingCopy
     * that is responsible for storing model processing chains. Note that this assignment also
     * entails the serialization of the chain to its XML representation.
     */
    static def setProcessingChainAsAttribute(ILaunchConfigurationWorkingCopy launchConfiguration,
        ProcessingChain chain) {
        // Transfer the mapped resources of all chain entries to the chain's launch configuration.
        // Consequently, the chain will be executable from each file that is covered by a model
        // processing launch configuration.
        val chainResources = chain.entriesLaunchConfigurations
            .map[it.mappedResources.toList]
            .flatten
            .toSet
        launchConfiguration.mappedResources = chainResources

        // Serialize the chain to its XML representation
        val out = new ByteArrayOutputStream
        val factory = XMLOutputFactory.newInstance()
        val writer = factory.createXMLStreamWriter(out)
        chain.serializeTo(writer)

        // Assign the chain's XML representation to the corresponding attribute of the launch
        // configuration
        launchConfiguration.setAttribute(PROCESSING_CHAIN_ATTRIBUTE,
            out.toString(StandardCharsets.UTF_8))

        out.close()
        writer.close()
    }

    /**
     * Helper to get the ILaunchConfigurations of all chain entries
     */
    private def getEntriesLaunchConfigurations() {
        return entries.map[
            getModelProcessingLaunchConfigurations.get(it.launchConfigurationName)
        ]
        // Filter new chain entries for which yet no name pointing to an existing model processing
        // launch configuration has been determined
        .filterNull
    }

    /**
     * Add a property change listener to the chain. Note that property change listeners on chains
     * are transitive, i.e., they are assigned to the chain but also all chain entries. Thus,
     * listeners get called not only when the chain changes but also when one of its entries
     * changes.
     */
    final override addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener)
        entries.forEach[it.addPropertyChangeListener(listener)]
    }

    /**
     * Remove a property change listener from the chain and all of its entries
     */
    final override removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener)
        entries.forEach[it.removePropertyChangeListener(listener)]
    }

    /**
     * Add an entry to the chain and fire a corresponding property change event. Note that the entry
     * also gets all of the chain's property change listeners assigned.
     */
    final def addEntry(ProcessingChainEntry entry) {
        propertyChangeListeners.forEach[entry.addPropertyChangeListener(it)]
        firePropertyChange("entries", flatCopy(entries), entries = addInPlace(entries, entry))
    }

    /**
     * Move an entry up the chain and fire a corresponding property change event
     */
    final def moveUp(ProcessingChainEntry entry) {
        firePropertyChange("entries", flatCopy(entries), entries = moveUpInPlace(entries, entry))
    }

    /**
     * Move an entry down the chain and fire a corresponding property change event
     */
    final def moveDown(ProcessingChainEntry entry) {
        firePropertyChange("entries", flatCopy(entries), entries = moveDownInPlace(entries, entry))
    }

    /**
     * Remove an entry from the chain and fire a corresponding property change event
     */
    final def remove(ProcessingChainEntry entry) {
        propertyChangeListeners.forEach[entry.removePropertyChangeListener(it)]
        firePropertyChange("entries", flatCopy(entries), entries = removeInPlace(entries, entry))
    }

    /**
     * Remove all given entries from the chain and fire a single corresponding property change event
     */
    final def removeAll(List<ProcessingChainEntry> entriesToRemove) {
        propertyChangeListeners.forEach[propertyChangeListener |
            entriesToRemove.forEach[removePropertyChangeListener(propertyChangeListener)]
        ]
        firePropertyChange("entries", flatCopy(entries),
            entries = removeAllInPlace(entries, entriesToRemove))
    }

    /**
     * Serialize the chain to XML
     */
    final def void serializeTo(XMLStreamWriter writer) {
        writer.writeStartElement(XML_CHAIN_ELEMENT)

        writer.writeStartElement(XML_CHAIN_ENTRIES_ELEMENT)
        entries.forEach[it.serializeTo(writer)]
        writer.writeEndElement()

        writer.writeEndElement()
    }

    /**
     * Validate the chain and all of its entries
     */
    def validate(Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
        if (entries.empty)
            throw new IllegalArgumentException("Model processing chain must comprise at least " +
                "one element")

        entries.forEach[it.validate(availableLaunchConfigurations)]
    }
}