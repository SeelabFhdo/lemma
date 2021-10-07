package de.fhdo.lemma.data.validation

import de.fhdo.lemma.data.DataModel
import java.util.ArrayList
import static de.fhdo.lemma.utils.LemmaUtils.removeFileUri
import static de.fhdo.lemma.utils.LemmaUtils.absoluteFileUriFromResourceBase
import java.util.Collections
import java.util.List

/**
 * This class holds previously loaded DataModels that are checked for cyclic imports.
 *
 * @author <a href="mailto:dominik.pelkmann@fh-dortmund.de">Dominik Pelkmann</a>
 */
class ImportChain {
    val entries = new ArrayList<String>
    var isImportedCycle = false

    /**
     * Initializes an empty ImportChain
     */
    new() {}

    /**
     * Initializes an ImportChain with a list of paths of imported files
     */
    new(List<String> entries) {
        this.entries.addAll(entries)
    }

    /**
     * Returns a copy of the ImportChain
     */
    def static copy(ImportChain sourceImportChain) {
        return new ImportChain(sourceImportChain.entries)
    }

    /**
     * Marks the ImportChain in which an imported cycle was found
     */
    def foundImportedCycle() {
        isImportedCycle = true
    }

    /**
     * Returns whether a cyclic import is present
     */
    def getIsImportedCycle() {
        return isImportedCycle
    }

    /**
     * Add a DataModel to the entries list
     */
    def ImportChain addEntry(DataModel dataModel) {
        entries.add(removeFileUri(absoluteFileUriFromResourceBase(dataModel.eResource.URI.toString,
            dataModel.eResource)))
        return this
    }

    /**
     * Checks if there is a cycle
     */
    def hasCycle() {
        return entries.toSet.size < entries.size
    }

    /**
     * Return the entries list
     */
    def getEntries() {
        return Collections.unmodifiableList(entries)
    }
}
