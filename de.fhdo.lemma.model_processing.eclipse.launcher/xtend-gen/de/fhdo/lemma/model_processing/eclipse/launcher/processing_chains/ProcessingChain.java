package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Domain concept for model processing chains.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ProcessingChain extends ModelElementWithPropertyChangeSupport implements Cloneable {
  private static final String XML_CHAIN_ELEMENT = "processingChain";

  private static final String XML_CHAIN_ENTRIES_ELEMENT = "entries";

  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<ProcessingChainEntry> entries = CollectionLiterals.<ProcessingChainEntry>newArrayList();

  /**
   * Two chains are equal if they have the same entries
   */
  @Override
  public final boolean equals(final Object o) {
    boolean _xifexpression = false;
    if ((o == this)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((!(o instanceof ProcessingChain))) {
        _xifexpression_1 = false;
      } else {
        boolean _xblockexpression = false;
        {
          final ProcessingChain otherConfig = ((ProcessingChain) o);
          _xblockexpression = Utils.<ProcessingChainEntry>equalLists(this.entries, otherConfig.entries);
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Clone the chain which also entails the cloning of its entries
   */
  @Override
  public Object clone() {
    try {
      Object _clone = super.clone();
      final ProcessingChain clone = ((ProcessingChain) _clone);
      final Function1<ProcessingChainEntry, ProcessingChainEntry> _function = (ProcessingChainEntry it) -> {
        Object _clone_1 = it.clone();
        return ((ProcessingChainEntry) _clone_1);
      };
      clone.entries = CollectionLiterals.<ProcessingChainEntry>newArrayList(((ProcessingChainEntry[])Conversions.unwrapArray(ListExtensions.<ProcessingChainEntry, ProcessingChainEntry>map(this.entries, _function), ProcessingChainEntry.class)));
      final Consumer<ProcessingChainEntry> _function_1 = (ProcessingChainEntry it) -> {
        it.setChain(clone);
      };
      clone.entries.forEach(_function_1);
      return clone;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Deserialize the model processing chain from its XML representation stored in the given
   * ILaunchConfiguration
   */
  public static ProcessingChain deserializeFrom(final ILaunchConfiguration launchConfiguration) {
    try {
      final String xml = launchConfiguration.getAttribute(LaunchConfigurationConstants.PROCESSING_CHAIN_ATTRIBUTE, "");
      boolean _isEmpty = xml.isEmpty();
      if (_isEmpty) {
        return null;
      }
      final Element xmlRoot = Utils.getRootElementWithTag(Utils.parseXmlString(xml), ProcessingChain.XML_CHAIN_ELEMENT);
      if ((xmlRoot == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("chain: Root XML element ");
        _builder.append(ProcessingChain.XML_CHAIN_ELEMENT);
        _builder.append(" not found");
        String _plus = ("Error during deserialization of processing " + _builder);
        throw new IllegalArgumentException(_plus);
      }
      final ProcessingChain chain = new ProcessingChain();
      ProcessingChain.initializeEntries(chain, xmlRoot);
      return chain;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Initialize the entries of the given chain from the given root of the chain's XML
   * representation
   */
  private static void initializeEntries(final ProcessingChain chain, final Element xmlRoot) {
    chain.entries = CollectionLiterals.<ProcessingChainEntry>newArrayList();
    final Element entriesParentElement = Utils.findChildElementWithTag(xmlRoot, ProcessingChain.XML_CHAIN_ENTRIES_ELEMENT);
    final NodeList entryElements = entriesParentElement.getElementsByTagName(ProcessingChainEntry.XML_PROCESSING_CHAIN_ENTRY);
    int _length = entryElements.getLength();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
    for (final Integer n : _doubleDotLessThan) {
      {
        Node _item = entryElements.item((n).intValue());
        final ProcessingChainEntry entry = ProcessingChainEntry.deserializeFrom(((Element) _item));
        entry.setChain(chain);
        chain.entries.add(entry);
      }
    }
  }

  /**
   * Assign the given chain to the String attribute of the given ILaunchConfigurationWorkingCopy
   * that is responsible for storing model processing chains. Note that this assignment also
   * entails the serialization of the chain to its XML representation.
   */
  public static void setProcessingChainAsAttribute(final ILaunchConfigurationWorkingCopy launchConfiguration, final ProcessingChain chain) {
    try {
      final Function1<ILaunchConfiguration, List<IResource>> _function = (ILaunchConfiguration it) -> {
        try {
          return IterableExtensions.<IResource>toList(((Iterable<IResource>)Conversions.doWrapArray(it.getMappedResources())));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final Set<IResource> chainResources = IterableExtensions.<IResource>toSet(Iterables.<IResource>concat(IterableExtensions.<ILaunchConfiguration, List<IResource>>map(chain.getEntriesLaunchConfigurations(), _function)));
      launchConfiguration.setMappedResources(((IResource[])Conversions.unwrapArray(chainResources, IResource.class)));
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      final XMLOutputFactory factory = XMLOutputFactory.newInstance();
      final XMLStreamWriter writer = factory.createXMLStreamWriter(out);
      chain.serializeTo(writer);
      launchConfiguration.setAttribute(LaunchConfigurationConstants.PROCESSING_CHAIN_ATTRIBUTE, 
        out.toString(StandardCharsets.UTF_8));
      out.close();
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Helper to get the ILaunchConfigurations of all chain entries
   */
  private Iterable<ILaunchConfiguration> getEntriesLaunchConfigurations() {
    final Function1<ProcessingChainEntry, ILaunchConfiguration> _function = (ProcessingChainEntry it) -> {
      return Utils.getModelProcessingLaunchConfigurations().get(it.getLaunchConfigurationName());
    };
    return IterableExtensions.<ILaunchConfiguration>filterNull(ListExtensions.<ProcessingChainEntry, ILaunchConfiguration>map(this.entries, _function));
  }

  /**
   * Add a property change listener to the chain. Note that property change listeners on chains
   * are transitive, i.e., they are assigned to the chain but also all chain entries. Thus,
   * listeners get called not only when the chain changes but also when one of its entries
   * changes.
   */
  @Override
  public final void addPropertyChangeListener(final PropertyChangeListener listener) {
    super.addPropertyChangeListener(listener);
    final Consumer<ProcessingChainEntry> _function = (ProcessingChainEntry it) -> {
      it.addPropertyChangeListener(listener);
    };
    this.entries.forEach(_function);
  }

  /**
   * Remove a property change listener from the chain and all of its entries
   */
  @Override
  public final void removePropertyChangeListener(final PropertyChangeListener listener) {
    super.removePropertyChangeListener(listener);
    final Consumer<ProcessingChainEntry> _function = (ProcessingChainEntry it) -> {
      it.removePropertyChangeListener(listener);
    };
    this.entries.forEach(_function);
  }

  /**
   * Add an entry to the chain and fire a corresponding property change event. Note that the entry
   * also gets all of the chain's property change listeners assigned.
   */
  public final void addEntry(final ProcessingChainEntry entry) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener it) -> {
      entry.addPropertyChangeListener(it);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("entries", Utils.<ProcessingChainEntry>flatCopy(this.entries), this.entries = Utils.<ProcessingChainEntry>addInPlace(this.entries, entry));
  }

  /**
   * Move an entry up the chain and fire a corresponding property change event
   */
  public final void moveUp(final ProcessingChainEntry entry) {
    this.firePropertyChange("entries", Utils.<ProcessingChainEntry>flatCopy(this.entries), this.entries = Utils.<ProcessingChainEntry>moveUpInPlace(this.entries, entry));
  }

  /**
   * Move an entry down the chain and fire a corresponding property change event
   */
  public final void moveDown(final ProcessingChainEntry entry) {
    this.firePropertyChange("entries", Utils.<ProcessingChainEntry>flatCopy(this.entries), this.entries = Utils.<ProcessingChainEntry>moveDownInPlace(this.entries, entry));
  }

  /**
   * Remove an entry from the chain and fire a corresponding property change event
   */
  public final void remove(final ProcessingChainEntry entry) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener it) -> {
      entry.removePropertyChangeListener(it);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("entries", Utils.<ProcessingChainEntry>flatCopy(this.entries), this.entries = Utils.<ProcessingChainEntry>removeInPlace(this.entries, entry));
  }

  /**
   * Remove all given entries from the chain and fire a single corresponding property change event
   */
  public final void removeAll(final List<ProcessingChainEntry> entriesToRemove) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener propertyChangeListener) -> {
      final Consumer<ProcessingChainEntry> _function_1 = (ProcessingChainEntry it) -> {
        it.removePropertyChangeListener(propertyChangeListener);
      };
      entriesToRemove.forEach(_function_1);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("entries", Utils.<ProcessingChainEntry>flatCopy(this.entries), 
      this.entries = Utils.<ProcessingChainEntry>removeAllInPlace(this.entries, entriesToRemove));
  }

  /**
   * Serialize the chain to XML
   */
  public final void serializeTo(final XMLStreamWriter writer) {
    try {
      writer.writeStartElement(ProcessingChain.XML_CHAIN_ELEMENT);
      writer.writeStartElement(ProcessingChain.XML_CHAIN_ENTRIES_ELEMENT);
      final Consumer<ProcessingChainEntry> _function = (ProcessingChainEntry it) -> {
        it.serializeTo(writer);
      };
      this.entries.forEach(_function);
      writer.writeEndElement();
      writer.writeEndElement();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Validate the chain and all of its entries
   */
  public void validate(final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    boolean _isEmpty = this.entries.isEmpty();
    if (_isEmpty) {
      throw new IllegalArgumentException(("Model processing chain must comprise at least " + 
        "one element"));
    }
    final Consumer<ProcessingChainEntry> _function = (ProcessingChainEntry it) -> {
      it.validate(availableLaunchConfigurations);
    };
    this.entries.forEach(_function);
  }

  @Pure
  public List<ProcessingChainEntry> getEntries() {
    return this.entries;
  }
}
