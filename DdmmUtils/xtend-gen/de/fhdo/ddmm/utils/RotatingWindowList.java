package de.fhdo.ddmm.utils;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

/**
 * List that enables callers to retrieve sub lists in the form of a "rotating window". Suppose a
 * list [5, 6, 7, 8, 9] and a window size 3. When a caller retrieves the window number 4 from the
 * list leveraging this list class, the result will be [8, 9, 5].
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class RotatingWindowList<T extends Object> {
  private List<T> list;
  
  private int windowSize;
  
  /**
   * Constructor
   */
  public RotatingWindowList(final List<T> list, final int windowSize) {
    if ((list == null)) {
      throw new IllegalArgumentException("List must not be null");
    }
    if ((windowSize <= 0)) {
      throw new IllegalArgumentException("Window size must be greater than zero");
    }
    int _size = list.size();
    boolean _greaterThan = (windowSize > _size);
    if (_greaterThan) {
      throw new IllegalArgumentException("Window size must not be greater than list size");
    }
    this.list = list;
    this.windowSize = windowSize;
  }
  
  /**
   * Get window with given number. Window numbers start at 1 and may theoretically be as big
   * as Integer.MAX_VALUE as the number will be calculated relatively to the list's upper
   * and lower indexes.
   */
  public List<T> getWindow(final int windowNumber) {
    if ((windowNumber <= 0)) {
      throw new IllegalArgumentException("Window number must be greater than zero");
    }
    int _size = this.list.size();
    int lowerIndex = ((windowNumber - 1) % _size);
    int _size_1 = this.list.size();
    int upperIndex = ((lowerIndex + this.windowSize) % _size_1);
    List<T> resultList = null;
    if ((lowerIndex < upperIndex)) {
      resultList = this.subListCopy(this.list, lowerIndex, upperIndex);
    } else {
      resultList = this.subListCopy(this.list, lowerIndex, this.list.size());
      resultList.addAll(this.subListCopy(this.list, 0, upperIndex));
    }
    return resultList;
  }
  
  /**
   * Create a sub-list from a list as a shallow copy of its elements, i.e., don't create a
   * sub-list view that reflects changes to the original list
   */
  private ArrayList<T> subListCopy(final List<T> list, final int lowerIndex, final int upperIndex) {
    final ArrayList<T> resultList = CollectionLiterals.<T>newArrayList();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(lowerIndex, upperIndex, true);
    for (final Integer index : _doubleDotLessThan) {
      resultList.add(list.get((index).intValue()));
    }
    return resultList;
  }
}
