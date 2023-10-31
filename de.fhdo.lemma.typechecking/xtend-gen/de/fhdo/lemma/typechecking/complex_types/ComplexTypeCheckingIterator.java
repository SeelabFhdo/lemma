package de.fhdo.lemma.typechecking.complex_types;

import de.fhdo.lemma.typechecking.complex_types.data_structures.NodePair;
import de.fhdo.lemma.typechecking.complex_types.data_structures.NodeSeries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Iterator that finds the next pair of nodes, whose compatibility shall be checked by the
 * {@link ComplexTypeChecker}.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ComplexTypeCheckingIterator implements Iterator<NodePair> {
  private NodePair rootPair;

  private NodePair currentPair;

  private HashMap<NodePair, Boolean> decisionHistory = CollectionLiterals.<NodePair, Boolean>newHashMap();

  /**
   * Constructor
   */
  public ComplexTypeCheckingIterator(final NodePair rootPair) {
    this.rootPair = rootPair;
  }

  /**
   * Return whether there is a pair to be checked or not. In case the compatibility of the initial
   * root pair has been determined, this returns false.
   * 
   * Note that hasNext() has the same runtime complexity as next(), i.e., there are optimizations
   * like caching the next element. It might therefore be advisable, for performance reasons, to
   * just use next() and catch the resulting exception.
   */
  @Override
  public boolean hasNext() {
    boolean _compatibilityUndecided = this.rootPair.compatibilityUndecided();
    boolean _not = (!_compatibilityUndecided);
    if (_not) {
      return false;
    }
    NodePair _nextUndecidedPair = this.nextUndecidedPair();
    return (_nextUndecidedPair != null);
  }

  /**
   * Get next node pair whose compatibility is yet undecided. Throws NoSuchElementException in
   * case the compatibility of the initial root pair has been determined or if there exists no
   * undecided pair anymore.
   * 
   * Note that this method also assigns the determined next pair to an internal "currentPair"
   * field. This makes the use of methods such as markCurrentPairCompatible() more convenient and
   * consistent, as no node pair needs to be passed because they directly operate on the iterators
   * current state represented by the nodePair field.
   */
  @Override
  public NodePair next() {
    boolean _compatibilityUndecided = this.rootPair.compatibilityUndecided();
    boolean _not = (!_compatibilityUndecided);
    if (_not) {
      throw new NoSuchElementException();
    }
    if ((this.currentPair == null)) {
      this.currentPair = this.rootPair;
    } else {
      this.currentPair = this.nextUndecidedPair();
    }
    if ((this.currentPair == null)) {
      throw new NoSuchElementException();
    }
    return this.currentPair;
  }

  /**
   * Helper method to find next undecided pair
   */
  private NodePair nextUndecidedPair() {
    NodePair iterPair = this.currentPair;
    while ((iterPair != null)) {
      {
        ArrayList<NodeSeries> childSeries = iterPair.getChildSeries();
        final Function1<NodeSeries, Boolean> _function = (NodeSeries it) -> {
          return Boolean.valueOf(it.compatibilityUndecided());
        };
        final NodeSeries undecidedSeries = IterableExtensions.<NodeSeries>findFirst(childSeries, _function);
        if ((undecidedSeries != null)) {
          final Function1<NodePair, Boolean> _function_1 = (NodePair it) -> {
            return Boolean.valueOf(it.compatibilityUndecided());
          };
          final NodePair undecidedPair = IterableExtensions.<NodePair>findFirst(undecidedSeries.getChildPairs(), _function_1);
          if ((undecidedPair != null)) {
            return undecidedPair;
          }
        }
        NodeSeries _parentSeries = iterPair.getParentSeries();
        boolean _tripleNotEquals = (_parentSeries != null);
        if (_tripleNotEquals) {
          iterPair = iterPair.getParentSeries().getParentPair();
        } else {
          iterPair = null;
        }
      }
    }
    return null;
  }

  /**
   * Return the compatibility of the current node pair's types if it was already decided or null
   * if it has not been decided yet
   */
  public Boolean currentPairTypeCompatibilityAlreadyDecided() {
    return this.decisionHistory.get(this.currentPair);
  }

  /**
   * Return the compatibility decision status of the currently iterated pair
   */
  public boolean currentPairCompatibilityUndecided() {
    return this.currentPair.compatibilityUndecided();
  }

  /**
   * Mark the current node pair being compatible and propagate that decision through the
   * NodePair-NodeSeries graph.
   * 
   * The boolean parameter determines if for the compatibility decision the compatibility of the
   * current pair's children should be considered. Deactivating this check will lead to setting
   * the current pair's compatibility to true and propagating that change directly through the
   * graph. This might makes sense in cases where it is obvious that a node pair is compatible,
   * e.g., when both nodes have the same type.
   */
  public void markCurrentPairCompatible(final boolean bypassChildSeriesCompatibilityCheck) {
    if (((!bypassChildSeriesCompatibilityCheck) && (!this.currentPair.getChildSeries().isEmpty()))) {
      final Function1<NodeSeries, Boolean> _function = (NodeSeries it) -> {
        return Boolean.valueOf(it.isCompatible());
      };
      boolean _exists = IterableExtensions.<NodeSeries>exists(this.currentPair.getChildSeries(), _function);
      boolean _not = (!_exists);
      if (_not) {
        return;
      }
    }
    NodePair propagationPair = this.currentPair;
    do {
      {
        propagationPair.setCompatible(Boolean.valueOf(true));
        this.addToHistory(propagationPair);
        final NodeSeries parentSeries = propagationPair.getParentSeries();
        boolean _xifexpression = false;
        if ((parentSeries != null)) {
          final Function1<NodePair, Boolean> _function_1 = (NodePair it) -> {
            boolean _isCompatible = it.isCompatible();
            return Boolean.valueOf((!_isCompatible));
          };
          boolean _exists_1 = IterableExtensions.<NodePair>exists(parentSeries.getChildPairs(), _function_1);
          _xifexpression = (!_exists_1);
        } else {
          _xifexpression = false;
        }
        final boolean allPairsOfParentSeriesCompatible = _xifexpression;
        if (allPairsOfParentSeriesCompatible) {
          parentSeries.setCompatible(Boolean.valueOf(true));
          propagationPair = parentSeries.getParentPair();
        } else {
          propagationPair = null;
        }
      }
    } while((propagationPair != null));
  }

  /**
   * Convenience method to mark the current node pair being compatible with taking its children's
   * compatibility into account
   */
  public void markCurrentPairCompatible() {
    this.markCurrentPairCompatible(false);
  }

  /**
   * Mark the current node pair being incompatible and propagate that decision through the
   * NodePair-NodeSeries graph.
   */
  public void markCurrentPairIncompatible() {
    this.currentPair.setCompatible(Boolean.valueOf(false));
    NodeSeries parentSeries = this.currentPair.getParentSeries();
    if ((parentSeries != null)) {
      NodeSeries _parentSeries = this.currentPair.getParentSeries();
      _parentSeries.setCompatible(Boolean.valueOf(false));
    }
    NodePair _xifexpression = null;
    if ((parentSeries != null)) {
      _xifexpression = this.currentPair.getParentSeries().getParentPair();
    }
    NodePair propagationPair = _xifexpression;
    while ((propagationPair != null)) {
      {
        final Function1<NodeSeries, Boolean> _function = (NodeSeries it) -> {
          return Boolean.valueOf((it.isCompatible() || it.compatibilityUndecided()));
        };
        boolean _exists = IterableExtensions.<NodeSeries>exists(propagationPair.getChildSeries(), _function);
        final boolean allSeriesOfPairIncompatible = (!_exists);
        if (allSeriesOfPairIncompatible) {
          propagationPair.setCompatible(Boolean.valueOf(false));
          this.addToHistory(propagationPair);
        }
        parentSeries = propagationPair.getParentSeries();
        if ((allSeriesOfPairIncompatible && (parentSeries != null))) {
          parentSeries.setCompatible(Boolean.valueOf(false));
          propagationPair = parentSeries.getParentPair();
        } else {
          propagationPair = null;
        }
      }
    }
  }

  /**
   * Add node series to the current node pair to be eventually iterated if necessary, i.e., if the
   * root node pair doesn't get decided before
   */
  public boolean addSeries(final NodeSeries series) {
    return this.currentPair.addChildSeries(series);
  }

  /**
   * Convenience method to add a list of series all at once
   */
  public void addAllSeries(final List<NodeSeries> series) {
    final Consumer<NodeSeries> _function = (NodeSeries it) -> {
      this.addSeries(it);
    };
    series.forEach(_function);
  }

  /**
   * Add a decided node pair to the decision history
   */
  private Boolean addToHistory(final NodePair nodePair) {
    return this.decisionHistory.put(nodePair, Boolean.valueOf(nodePair.isCompatible()));
  }
}
