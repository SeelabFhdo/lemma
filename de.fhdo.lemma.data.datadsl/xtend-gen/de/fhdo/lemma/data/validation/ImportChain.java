package de.fhdo.lemma.data.validation;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class holds previously loaded DataModels that are checked for cyclic imports.
 * 
 * @author <a href="mailto:dominik.pelkmann@fh-dortmund.de">Dominik Pelkmann</a>
 */
@SuppressWarnings("all")
public class ImportChain {
  private final ArrayList<String> entries = new ArrayList<String>();

  private boolean isImportedCycle = false;

  /**
   * Initializes an empty ImportChain
   */
  public ImportChain() {
  }

  /**
   * Initializes an ImportChain with a list of paths of imported files
   */
  public ImportChain(final List<String> entries) {
    this.entries.addAll(entries);
  }

  /**
   * Returns a copy of the ImportChain
   */
  public static ImportChain copy(final ImportChain sourceImportChain) {
    return new ImportChain(sourceImportChain.entries);
  }

  /**
   * Marks the ImportChain in which an imported cycle was found
   */
  public boolean foundImportedCycle() {
    return this.isImportedCycle = true;
  }

  /**
   * Returns whether a cyclic import is present
   */
  public boolean getIsImportedCycle() {
    return this.isImportedCycle;
  }

  /**
   * Add a DataModel to the entries list
   */
  public ImportChain addEntry(final DataModel dataModel) {
    this.entries.add(
      LemmaUtils.removeFileUri(
        LemmaUtils.absoluteFileUriFromResourceBase(dataModel.eResource().getURI().toString(), 
          dataModel.eResource())));
    return this;
  }

  /**
   * Checks if there is a cycle
   */
  public boolean hasCycle() {
    int _size = IterableExtensions.<String>toSet(this.entries).size();
    int _size_1 = this.entries.size();
    return (_size < _size_1);
  }

  /**
   * Return the entries list
   */
  public List<String> getEntries() {
    return Collections.<String>unmodifiableList(this.entries);
  }
}
