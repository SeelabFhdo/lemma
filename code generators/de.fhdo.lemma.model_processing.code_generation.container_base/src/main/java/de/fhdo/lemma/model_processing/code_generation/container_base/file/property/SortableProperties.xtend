package de.fhdo.lemma.model_processing.code_generation.container_base.file.property

import java.util.Properties
import java.util.Set
import java.util.Map
import java.util.Comparator
import java.util.Collections

/**
 * An implementation of {@link java.util.Properties} that allows for sorting its keys. Sorting is
 * enabled by default. Note that this class is implemented in Java rather than Kotlin, because
 * trying to override {@link java.util.Properties#entrySet()} in Kotlin results in a JVM signature
 * platform declaration clash.
 *
 * This class is a translation from the PropertyFile Kotlin class in the Java Base Generator,
 * done by the coauthor.
 * TODO Merge the Kotlin and Xtend implementation into a common jar archive.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 * @coauthor <a href="mailto:Florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SortableProperties extends Properties {
    boolean sorted

    /**
     * Default constructor
     */
    new () {
        sorted = true
    }

    /**
     * Constructor for specifying whether this instance sorts its keys or not
     */
    new (boolean sorted) {
        this.sorted = sorted
    }

    /**
     * Overridden version of {@link Properties#entrySet()} that returns the entries of this instance
     * sorted by their String representations, in case {@link #sorted} was set to <code>true</code>.
     * Otherwise, the result of calling {@link Properties#entrySet()} will be returned. In either
     * case the returned {@link java.util.Set} instance is synchronized.
     */
    override Set<Map.Entry<Object, Object>> entrySet() {
        if (!sorted)
            return super.entrySet

        var entryComparator = new Comparator<Map.Entry<Object, Object>>() {
            override compare(Map.Entry<Object, Object> entry1, Map.Entry<Object, Object> entry2) {
                var key1 = entry1.getKey().toString();
                var key2 = entry2.getKey().toString();
                return key1.compareTo(key2);
            }
        }

        var sortedEntrySet = Collections.synchronizedSortedSet(newTreeSet(entryComparator));
        sortedEntrySet.addAll(super.entrySet());

        return sortedEntrySet;
    }
}