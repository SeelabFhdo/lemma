package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * An implementation of {@link java.util.Properties} that allows for sorting its keys. Sorting is enabled by default.
 * Note that this class is implemented in Java rather than Kotlin, because trying to override
 * {@link java.util.Properties#entrySet()} in Kotlin results in a JVM signature platform declaration clash.
 *
 * @author Florian Rademacher (florian.rademacher@fh-dortmund.de)
 */
public class SortableProperties extends Properties {
    private boolean sorted;

    /**
     * Default constructor
     */
    public SortableProperties() {
        this.sorted = true;
    }

    /**
     * Constructor for specfying whether this instance sorts its keys or not
     */
    public SortableProperties(boolean sorted) {
        this.sorted = sorted;
    }

    /**
     * Overridden version of {@link Properties#entrySet()} that returns the entries of this instance sorted by their
     * String representations, in case {@link #sorted} was set to <code>true</code>. Otherwise, the result of calling
     * {@link Properties#entrySet()} will be returned. In either case the returned {@link java.util.Set} instance is
     * synchronized.
     */
    @Override
    public Set<Map.Entry<Object, Object>> entrySet() {
        if (!sorted)
            return super.entrySet();

        var entryComparator = new Comparator<Map.Entry<Object, Object>>() {
            @Override
            public int compare(Map.Entry<Object, Object> entry1, Map.Entry<Object, Object> entry2) {
                var key1 = entry1.getKey().toString();
                var key2 = entry2.getKey().toString();
                return key1.compareTo(key2);
            }
        };

        var sortedEntrySet = Collections.synchronizedSortedSet(new TreeSet<>(entryComparator));
        sortedEntrySet.addAll(super.entrySet());
        return sortedEntrySet;
    }
}
