package de.fhdo.lemma.utils;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class enables the creation of distinct series of element pairs from two lists. Specifically,
 * it will create series of element pairs, in which each pair does not contain an element of either
 * list more than once. Take for example two lists of elements [E1, E2, E3] and [E4, E5, E6]. The
 * class returns a list of series of element pairs that looks like this:
 * [
 * 	 [[E1, E4], [E2, E5], [E3, E6]],
 * 	 [[E1, E4], [E2, E6], [E3, E5]],
 *   [[E1, E5], [E2, E4], [E3, E6]],
 *   [[E1, E5], [E2, E6], [E3, E4]],
 *   [[E1, E6], [E2, E4], [E3, E5]],
 *   [[E1, E6], [E2, E5], [E3, E4]]
 * ]
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DistinctPairSeriesBuilder<T extends Object> {
  /**
   * Build distinct pairs series. An optional list of mandatory pairs of elements from list1 and
   * list2 may be given. If this list is not null and not empty only series that contain all of
   * the mandatory pairs will be created. If for example, the list of mandatory pairs is
   * [[E1, E4]] then only the first two series of the example with be returned.
   */
  public ArrayList<Pairs<T>> buildPairSeries(final List<T> list1, final List<T> list2, final Pairs<T> mandatoryPairs) {
    if (((((list1 == null) || list1.isEmpty()) || (list2 == null)) || list2.isEmpty())) {
      throw new IllegalArgumentException("Lists must not be null or empty");
    }
    int _size = list1.size();
    int _size_1 = list2.size();
    boolean _tripleNotEquals = (_size != _size_1);
    if (_tripleNotEquals) {
      throw new IllegalArgumentException("Lists must have same size");
    }
    final List<Pairs<T>> cartesianPairsSeries = this.<T>buildCartesianPairsSeries(list1, list2);
    final ArrayList<Pairs<T>> distinctPairsSeries = CollectionLiterals.<Pairs<T>>newArrayList();
    final List<List<Integer>> distinctIndicesSeries = this.calculateDistinctIndexSeries(list1.size());
    for (final List<Integer> indices : distinctIndicesSeries) {
      {
        final Pairs<T> distinctPairs = new Pairs<T>();
        int _size_2 = cartesianPairsSeries.size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
        for (final Integer pairIndex : _doubleDotLessThan) {
          {
            final Pairs<T> currentPairs = cartesianPairsSeries.get((pairIndex).intValue());
            final Integer currentPairsIndex = indices.get((pairIndex).intValue());
            final Pair<T> newPair = currentPairs.getPair((currentPairsIndex).intValue());
            boolean _isMandatory = this.isMandatory(newPair, mandatoryPairs);
            if (_isMandatory) {
              distinctPairs.addPair(newPair);
            }
          }
        }
        distinctPairsSeries.add(distinctPairs);
      }
    }
    return distinctPairsSeries;
  }

  /**
   * Build distinct pairs series without mandatory pairs
   */
  public ArrayList<Pairs<T>> buildPairSeries(final List<T> list1, final List<T> list2) {
    return this.buildPairSeries(list1, list2, null);
  }

  /**
   * Check if a Pair is mandatory
   */
  private boolean isMandatory(final Pair<T> pair, final Pairs<T> mandatoryPairs) {
    if (((mandatoryPairs == null) || IterableExtensions.isEmpty(mandatoryPairs))) {
      return true;
    }
    final Function1<Pair<T>, Boolean> _function = (Pair<T> it) -> {
      return Boolean.valueOf((Objects.equal(it.get(0), pair.get(0)) && 
        Objects.equal(it.get(1), pair.get(1))));
    };
    return IterableExtensions.<Pair<T>>exists(mandatoryPairs, _function);
  }

  /**
   * Create a series of cartesian Pairs from two lists. For lists [E1, E2, E3] and [E4, E5, E6]
   * this will produce a list of the following cartesian Pairs instances (each row is a Pairs
   * instance with the first element being the same in the row):
   * [
   *   [[E1, E4], [E1, E5], [E1, E6]],
   *   [[E2, E4], [E2, E5], [E2, E6]],
   *   [[E3, E4], [E3, E5], [E3, E6]]
   * ]
   */
  private <T extends Object> List<Pairs<T>> buildCartesianPairsSeries(final List<T> list1, final List<T> list2) {
    final List<Pairs<T>> pairsList = CollectionLiterals.<Pairs<T>>newArrayList();
    for (final T element1 : list1) {
      {
        final Pairs<T> newPairsForElement1 = new Pairs<T>();
        for (final T element2 : list2) {
          newPairsForElement1.addPair(element1, element2);
        }
        pairsList.add(newPairsForElement1);
      }
    }
    return pairsList;
  }

  /**
   * Calculate series of list indices, in which all indices are distinct. For a list with 3
   * elements this will produce the following list of index series:
   * [
   *   [0, 1, 2],
   *   [0, 2, 1],
   *   [1, 0, 2],
   *   [1, 2, 0],
   *   [2, 0, 1],
   *   [2, 1, 0]
   * ]
   */
  private List<List<Integer>> calculateDistinctIndexSeries(final int elementCount) {
    final List<List<Integer>> series = CollectionLiterals.<List<Integer>>newArrayList();
    if ((elementCount == 1)) {
      final ArrayList<Integer> singleIndexSeries = CollectionLiterals.<Integer>newArrayList();
      singleIndexSeries.add(Integer.valueOf(0));
      series.add(singleIndexSeries);
      return series;
    }
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, elementCount, true);
    for (final Integer currentIndex : _doubleDotLessThan) {
      {
        final ArrayList<Integer> otherIndices = CollectionLiterals.<Integer>newArrayList();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, elementCount, true);
        for (final Integer index : _doubleDotLessThan_1) {
          if ((index != currentIndex)) {
            otherIndices.add(index);
          }
        }
        final int otherIndexCount = otherIndices.size();
        final RotatingWindowList<Integer> indicesRotation = new RotatingWindowList<Integer>(otherIndices, otherIndexCount);
        int currentWindow = 1;
        while ((currentWindow <= otherIndexCount)) {
          {
            final ArrayList<Integer> currentIndicesSeries = CollectionLiterals.<Integer>newArrayList();
            currentIndicesSeries.add(currentIndex);
            currentIndicesSeries.addAll(indicesRotation.getWindow(currentWindow));
            series.add(currentIndicesSeries);
            currentWindow++;
          }
        }
      }
    }
    return series;
  }
}
