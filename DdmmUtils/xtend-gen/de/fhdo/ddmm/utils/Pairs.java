package de.fhdo.ddmm.utils;

import de.fhdo.ddmm.utils.Pair;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Class representing a list of element Pairs
 */
@SuppressWarnings("all")
public class Pairs<T extends Object> implements Iterable<Pair<T>> {
  private List<Pair<T>> pairs = CollectionLiterals.<Pair<T>>newArrayList();
  
  /**
   * Add two elements as Pair instance to the list
   */
  public boolean addPair(final T element1, final T element2) {
    Pair<T> _pair = new Pair<T>(element1, element2);
    return this.addPair(_pair);
  }
  
  /**
   * Add a pair to the list
   */
  public boolean addPair(final Pair<T> pair) {
    return this.pairs.add(pair);
  }
  
  /**
   * Size of pair list
   */
  public int size() {
    return this.pairs.size();
  }
  
  /**
   * Get pair element at given index
   */
  public Pair<T> getPair(final int index) {
    return this.pairs.get(index);
  }
  
  /**
   * Enable callers to iterate over all pairs
   */
  @Override
  public Iterator<Pair<T>> iterator() {
    return this.pairs.iterator();
  }
}
