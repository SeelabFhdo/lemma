package de.fhdo.lemma.typechecking.complex_types.data_structures;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents an ordered pair of TypeGraphNodes.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * 
 * NodePairs and NodeSeries may represent their own kind of "graph", which has the following
 * properties:
 *     (1) The graph's root is always a NodePair.
 *     (2) After a NodePair, a level of NodeSeries (the NodePairs "children") follows.
 *     (3) After a NodeSeries, a level of NodePairs (the NodeSeries "children") follows.
 * 
 * This (next to the TypeGraph) additional graph-like structure is used by the ComplexTypeChecker to
 * keep track of type nodes' compatibility and how it might be determined by child nodes.
 * 
 * Take for example the following structures (and ignore that an inheritance relationship would make
 * sense; if the data models are distributed, there might not necessarily exist such a
 * relationship):
 *   structure Person {
 *     string firstname,
 *     string lastname
 *   }
 * 
 *   structure Vehicle {
 *     string marque,
 *     Person owner
 *   }
 * 
 *   structure CarOwner {
 *     string forename,
 *     string secondName,
 *     string surname,
 *     int age
 *   }
 * 
 *   structure MotorDescription {
 *     int capacity,
 *     int valveCount
 *   }
 * 
 *   structure Car {
 *     string marque,
 *     MotorDescription motorDescription,
 *     CarOwner carOwner
 *   }
 * 
 * The question is now, might an instance of Car be assigned to an instance of Vehicle (vehicle =
 * car) and how to actually check that? The answer is yes. Why? Because there are "assignment
 * relationships" between all properties of Vehicle and selected properties of Car, which are valid
 * from the perspective of the underlying primitively typed fields:
 *   Vehicle.marque = Car.marque
 *   Vehicle.owner.firstname = Car.carOwner.forename,
 *   Vehicle.owner.lastname = Car.carOwner.surname (or secondName; both are strings)
 * 
 * How are these relationships checked for complex types that do not have an inheritance
 * relationship? On the basis of a NodePair-NodeSeries graph that looks like the following:
 *     0 (Pair):      (Vehicle [children: Person], Car [children: CarOwner, MotorDescription])
 *                                                       |
 *     1 (Series):                               (Series1, Series2)
 *                                                  /       \
 *     2 (Pair):               ((Person, MotorDescription)) ((Person, CarOwner))
 * For each pair on level 2 that is part of a series on level 1 a type check will be performed. If
 * all pairs of a series have valid assignment relationships, the whole series consists of valid
 * assignments and is hence compatible. Following, the pair that this series belongs to (and hence
 * the assignment of "to check node" to "basic node" (see below) is valid. This property will be
 * propagated up to the root pair if possible marking it compatible (or incompatible) based on the
 * validity of assignments in the end.
 */
@SuppressWarnings("all")
public class NodePair {
  /**
   * "Basic node", i.e., the node that needs to receive an instance of the "node to check"
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private TypeGraphNode basicNode;
  
  /**
   * "Node to check" if it's compatible, i.e., assignable, to the "basic node"
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private TypeGraphNode nodeToCheck;
  
  /**
   * Flag to indicate whether both nodes are compatible or not. Initially, the flag is null, which
   * communicates that the compatibility of the nodes has not been decided yet. Hence, it is of
   * the object type "Boolean" rather than the primitive type "boolean".
   */
  private Boolean compatible;
  
  /**
   * Series to which this pair belongs. Might be null for root pairs.
   */
  @Accessors
  private NodeSeries parentSeries;
  
  /**
   * The node's index in its parent series. Starts with 1. In case this is a root node, the index
   * is zero. The field will be set by the parent NodeSeries object of the pair.
   */
  @Accessors
  private int seriesIndex;
  
  /**
   * Child node series
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<NodeSeries> childSeries = CollectionLiterals.<NodeSeries>newArrayList();
  
  /**
   * Constructor
   */
  public NodePair(final TypeGraphNode basicNode, final TypeGraphNode nodeToCheck) {
    this.basicNode = basicNode;
    this.nodeToCheck = nodeToCheck;
  }
  
  /**
   * Add a new child series to the pair
   */
  public boolean addChildSeries(final NodeSeries newChildSeries) {
    boolean _xblockexpression = false;
    {
      newChildSeries.setParentPair(this);
      newChildSeries.setChildIndex(this.childSeries.size());
      _xblockexpression = this.childSeries.add(newChildSeries);
    }
    return _xblockexpression;
  }
  
  /**
   * Is this pair the last one in its parent series? Returns false for root node pairs.
   */
  public boolean isLastPairInSeries() {
    boolean _isRootPair = this.isRootPair();
    if (_isRootPair) {
      return false;
    }
    final ArrayList<NodePair> siblings = this.parentSeries.getChildPairs();
    int _size = siblings.size();
    int _minus = (_size - 1);
    return (this.seriesIndex == _minus);
  }
  
  /**
   * Set compatibility of pair.
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
   * Has node pair's compatibility been decided?
   */
  public boolean compatibilityUndecided() {
    return (this.compatible == null);
  }
  
  /**
   * Has the node pair's compatibility been decided and is it compatible or not, eventually?
   */
  public boolean isCompatible() {
    return ((!this.compatibilityUndecided()) && (this.compatible == Boolean.valueOf(true)));
  }
  
  /**
   * Is this a root node pair?
   */
  public boolean isRootPair() {
    return (this.parentSeries == null);
  }
  
  /**
   * Check for equality with other object based on the types encapsulated by the pair's nodes
   */
  @Override
  public boolean equals(final Object object) {
    if (((object == null) || (!(object instanceof NodePair)))) {
      return false;
    }
    final NodePair otherPair = ((NodePair) object);
    final TypeGraphNode otherBasicNode = otherPair.basicNode;
    String _xifexpression = null;
    if (((otherBasicNode != null) && (otherBasicNode.getType() != null))) {
      _xifexpression = otherBasicNode.getType().getName();
    } else {
      _xifexpression = null;
    }
    final String otherBasicName = _xifexpression;
    final TypeGraphNode otherNodeToCheck = otherPair.nodeToCheck;
    String _xifexpression_1 = null;
    if (((otherNodeToCheck != null) && (otherNodeToCheck.getType() != null))) {
      _xifexpression_1 = otherNodeToCheck.getType().getName();
    } else {
      _xifexpression_1 = null;
    }
    final String otherToCheckName = _xifexpression_1;
    String _xifexpression_2 = null;
    if (((this.basicNode != null) && (this.basicNode.getType() != null))) {
      _xifexpression_2 = this.basicNode.getType().getName();
    } else {
      _xifexpression_2 = null;
    }
    final String thisBasicName = _xifexpression_2;
    String _xifexpression_3 = null;
    if (((this.nodeToCheck != null) && (this.nodeToCheck.getType() != null))) {
      _xifexpression_3 = this.nodeToCheck.getType().getName();
    } else {
      _xifexpression_3 = null;
    }
    final String thisToCheckName = _xifexpression_3;
    if (((((otherBasicName == null) && (thisBasicName == null)) && 
      (otherToCheckName == null)) && (thisToCheckName == null))) {
      return true;
    } else {
      if ((((otherBasicName != null) && (thisBasicName == null)) || 
        ((otherBasicName == null) && (thisBasicName != null)))) {
        return false;
      } else {
        if ((((otherToCheckName != null) && (thisToCheckName == null)) || 
          ((otherToCheckName == null) && (thisToCheckName != null)))) {
          return false;
        }
      }
    }
    return (thisBasicName.equals(otherBasicName) && thisToCheckName.equals(otherToCheckName));
  }
  
  /**
   * Calculate hash code based on this node pair's types
   */
  @Override
  public int hashCode() {
    int hashCode = 0;
    if ((((this.basicNode != null) && 
      (this.basicNode.getType() != null)) && 
      (this.basicNode.getType().getName() != null))) {
      int _hashCode = hashCode;
      int _hashCode_1 = this.basicNode.getType().getName().hashCode();
      hashCode = (_hashCode + _hashCode_1);
    }
    if ((((this.nodeToCheck != null) && 
      (this.nodeToCheck.getType() != null)) && 
      (this.nodeToCheck.getType().getName() != null))) {
      int _hashCode_2 = hashCode;
      int _hashCode_3 = this.nodeToCheck.getType().getName().hashCode();
      hashCode = (_hashCode_2 + _hashCode_3);
    }
    return hashCode;
  }
  
  @Pure
  public TypeGraphNode getBasicNode() {
    return this.basicNode;
  }
  
  @Pure
  public TypeGraphNode getNodeToCheck() {
    return this.nodeToCheck;
  }
  
  @Pure
  public NodeSeries getParentSeries() {
    return this.parentSeries;
  }
  
  public void setParentSeries(final NodeSeries parentSeries) {
    this.parentSeries = parentSeries;
  }
  
  @Pure
  public int getSeriesIndex() {
    return this.seriesIndex;
  }
  
  public void setSeriesIndex(final int seriesIndex) {
    this.seriesIndex = seriesIndex;
  }
  
  @Pure
  public ArrayList<NodeSeries> getChildSeries() {
    return this.childSeries;
  }
}
