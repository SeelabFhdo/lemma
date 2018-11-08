package de.fhdo.ddmm.typechecking.complex_types.data_structures;

import de.fhdo.ddmm.typechecking.complex_types.data_structures.NodePair;
import de.fhdo.ddmm.typechecking.complex_types.data_structures.NodeSeriesBuilder;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents a series of node pairs.
 * 
 * See the {@link NodePair} class for a detailed explanation on the semantics and usage of series.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class NodeSeries {
  /**
   * The parent node pair from which this series resulted
   */
  @Accessors
  private NodePair parentPair;
  
  /**
   * Index of the series in the parent pair's child series
   */
  @Accessors
  private int childIndex;
  
  /**
   * List of child pairs being part of the series
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<NodePair> childPairs = CollectionLiterals.<NodePair>newArrayList();
  
  /**
   * Flag to indicate whether all child pairs of the series (and hence the series itself) are
   * compatible or not. Initially, the flag is null, which communicates that the compatibility of
   * the series has not been decided yet. Hence, it is of the object type "Boolean" rather than
   * the primitive type "boolean".
   */
  private Boolean compatible;
  
  /**
   * Convenience method to build all node series for a node pair (wrapper for
   * {@link NodeSeriesBuilder})
   */
  public static List<NodeSeries> buildAllSeriesFor(final NodePair nodePair) {
    return NodeSeriesBuilder.buildNodeSeries(nodePair);
  }
  
  /**
   * Constructor
   */
  public NodeSeries() {
  }
  
  /**
   * Constructor with initial pair
   */
  public NodeSeries(final NodePair initialPair, final NodePair parentPair) {
    this.parentPair = parentPair;
    this.addChildPair(initialPair);
  }
  
  /**
   * Add node pair to the series
   */
  public boolean addChildPair(final NodePair newPair) {
    boolean _xblockexpression = false;
    {
      newPair.setParentSeries(this);
      newPair.setSeriesIndex(this.childPairs.size());
      _xblockexpression = this.childPairs.add(newPair);
    }
    return _xblockexpression;
  }
  
  /**
   * Is this series the last one in its parent node?
   */
  public boolean isLastSeriesInPair() {
    final ArrayList<NodeSeries> siblings = this.parentPair.getChildSeries();
    int _size = siblings.size();
    int _minus = (_size - 1);
    return (this.childIndex == _minus);
  }
  
  /**
   * Set compatibility of series.
   * 
   * Note that the parameter is the object type "Boolean", even if only true or false (and not
   * null) are allowed to be passed to this method (null will result in an
   * IllegalArgumentException). The reason for still having "Boolean" and not "boolean" is a
   * strange behavior of Xtend's code generation in case of object types. When "boolean" is used
   * as the parameter's type
   *     this.compatible = compatible
   * will be generated into
   *     setCompatible(compatible)
   * resulting in the setter being called recursively forever.
   */
  public void setCompatible(final Boolean compatible) {
    if ((compatible == null)) {
      throw new IllegalArgumentException("Compatibility flag must not be null");
    }
    this.compatible = compatible;
  }
  
  /**
   * Has node series's compatibility been decided?
   */
  public boolean compatibilityUndecided() {
    return (this.compatible == null);
  }
  
  /**
   * Has the node series's compatibility been decided and is it compatible or not, eventually?
   */
  public boolean isCompatible() {
    return ((!this.compatibilityUndecided()) && (this.compatible == Boolean.valueOf(true)));
  }
  
  @Pure
  public NodePair getParentPair() {
    return this.parentPair;
  }
  
  public void setParentPair(final NodePair parentPair) {
    this.parentPair = parentPair;
  }
  
  @Pure
  public int getChildIndex() {
    return this.childIndex;
  }
  
  public void setChildIndex(final int childIndex) {
    this.childIndex = childIndex;
  }
  
  @Pure
  public ArrayList<NodePair> getChildPairs() {
    return this.childPairs;
  }
}
