package de.fhdo.ddmm.utils;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Class representing a pair of two arbitrary elements
 */
@SuppressWarnings("all")
public class Pair<T extends Object> {
  private List<T> elements = CollectionLiterals.<T>newArrayList();
  
  /**
   * Constructor
   */
  public Pair(final T element1, final T element2) {
    this.elements.add(element1);
    this.elements.add(element2);
  }
  
  /**
   * Get element at index
   */
  public T get(final int index) {
    return this.elements.get(index);
  }
}
