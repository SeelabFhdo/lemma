package de.fhdo.lemma.typechecking.complex_types.data_structures;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents the structure of a complex type as a directed multigraph. Each node in the graph
 * corresponds to a complex type.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TypeGraph {
  /**
   * Iterator implementation for type graphs that traverses the graph using breadth-first search
   */
  public static class BreadthFirstTypeGraphIterator implements Iterator<TypeGraphNode> {
    private TypeGraph typeGraph;
    
    private final ArrayList<TypeGraphNode> nodesToVisit = CollectionLiterals.<TypeGraphNode>newArrayList();
    
    public BreadthFirstTypeGraphIterator(final TypeGraph typeGraph) {
      this.typeGraph = typeGraph;
      this.nodesToVisit.add(typeGraph.rootNode);
    }
    
    @Override
    public boolean hasNext() {
      boolean _isEmpty = this.nodesToVisit.isEmpty();
      return (!_isEmpty);
    }
    
    @Override
    public TypeGraphNode next() {
      boolean _hasNext = this.hasNext();
      boolean _not = (!_hasNext);
      if (_not) {
        throw new NoSuchElementException();
      }
      final TypeGraphNode next = this.nodesToVisit.remove(0);
      this.nodesToVisit.addAll(next.getChildren());
      return next;
    }
  }
  
  /**
   * Root node
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private TypeGraphNode rootNode;
  
  /**
   * Height of the graph
   */
  private int height = 0;
  
  /**
   * Constructor with the root type as parameter. The constructor will traverse the complex type
   * and directly build the graph.
   */
  public TypeGraph(final ComplexType type) {
    this.rootNode = this.addNode(type, "", null);
    final Deque<TypeGraphNode> nodesToVisit = new ArrayDeque<TypeGraphNode>();
    nodesToVisit.push(this.rootNode);
    final Set<ComplexType> visitedComplexTypes = CollectionLiterals.<ComplexType>newHashSet();
    do {
      {
        final TypeGraphNode currentNode = nodesToVisit.pop();
        final ComplexType currentType = currentNode.getType();
        final boolean notVisited = visitedComplexTypes.add(currentType);
        EList<DataField> currentTypeFields = null;
        boolean _isIsStructure = currentType.isIsStructure();
        if (_isIsStructure) {
          currentTypeFields = ((DataStructure) currentType).getEffectiveFields();
        } else {
          boolean _isIsStructuredCollection = currentType.isIsStructuredCollection();
          if (_isIsStructuredCollection) {
            final CollectionType currentCollectionType = ((CollectionType) currentType);
            currentTypeFields = currentCollectionType.getDataFields();
          }
        }
        if ((currentTypeFields != null)) {
          final Function1<DataField, Boolean> _function = (DataField it) -> {
            Type _effectiveType = it.getEffectiveType();
            return Boolean.valueOf((_effectiveType instanceof ComplexType));
          };
          final Consumer<DataField> _function_1 = (DataField it) -> {
            if (notVisited) {
              Type _effectiveType = it.getEffectiveType();
              final ComplexType complexType = ((ComplexType) _effectiveType);
              final String qualifiedName = QualifiedName.create(it.getQualifiedNameParts()).toString();
              final TypeGraphNode newNode = this.addNode(complexType, qualifiedName, currentNode);
              nodesToVisit.add(newNode);
            }
          };
          IterableExtensions.<DataField>filter(currentTypeFields, _function).forEach(_function_1);
        }
      }
    } while((!nodesToVisit.isEmpty()));
  }
  
  /**
   * Add a new type node to the graph
   */
  private TypeGraphNode addNode(final ComplexType type, final String fieldName, final TypeGraphNode parentNode) {
    TypeGraphNode newNode = new TypeGraphNode(type, fieldName, parentNode);
    newNode.setRecursive(this.isRecursive(newNode));
    if ((parentNode != null)) {
      parentNode.getChildren().add(newNode);
    }
    boolean _isRecursive = newNode.isRecursive();
    if (_isRecursive) {
      this.setParentsRecursive(newNode);
    }
    int _depth = newNode.getDepth();
    boolean _greaterThan = (_depth > this.height);
    if (_greaterThan) {
      this.height = newNode.getDepth();
    }
    return newNode;
  }
  
  /**
   * Check if a node is recursive, i.e., if a complex type refers to itself
   */
  private boolean isRecursive(final TypeGraphNode node) {
    TypeGraphNode parentNode = node.getParent();
    while ((parentNode != null)) {
      {
        ComplexType _type = parentNode.getType();
        ComplexType _type_1 = node.getType();
        boolean _equals = Objects.equal(_type, _type_1);
        if (_equals) {
          return true;
        }
        parentNode = parentNode.getParent();
      }
    }
    return false;
  }
  
  /**
   * Flag parents of a recursive node, that have the same type as the node (i.e. are recursive),
   * as being recursive
   */
  private void setParentsRecursive(final TypeGraphNode node) {
    boolean _isRecursive = node.isRecursive();
    boolean _not = (!_isRecursive);
    if (_not) {
      return;
    }
    final ArrayList<TypeGraphNode> parentNodesTodo = CollectionLiterals.<TypeGraphNode>newArrayList();
    TypeGraphNode currentParent = node.getParent();
    while ((currentParent != null)) {
      {
        ComplexType _type = currentParent.getType();
        ComplexType _type_1 = node.getType();
        boolean _equals = Objects.equal(_type, _type_1);
        if (_equals) {
          parentNodesTodo.add(currentParent);
        }
        currentParent = currentParent.getParent();
      }
    }
    int _size = parentNodesTodo.size();
    final int lastLevelIndex = (_size - 1);
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, lastLevelIndex, true);
    for (final Integer i : _doubleDotLessThan) {
      parentNodesTodo.get((i).intValue()).setRecursive(true);
    }
  }
  
  /**
   * Return an Iterator for the graph
   */
  public TypeGraph.BreadthFirstTypeGraphIterator iterator() {
    return new TypeGraph.BreadthFirstTypeGraphIterator(this);
  }
  
  /**
   * Build string representation of graph
   */
  @Override
  public String toString() {
    final StringBuffer buffer = new StringBuffer();
    buffer.append((("Height: " + Integer.valueOf(this.height)) + "\n"));
    final TypeGraph.BreadthFirstTypeGraphIterator iter = this.iterator();
    while (iter.hasNext()) {
      {
        final TypeGraphNode node = iter.next();
        int _depth = node.getDepth();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(1, _depth, true);
        for (final Integer i : _doubleDotLessThan) {
          buffer.append("\t");
        }
        int _depth_1 = node.getDepth();
        String _plus = (Integer.valueOf(_depth_1) + " ");
        String _name = node.getType().getName();
        String _plus_1 = (_plus + _name);
        buffer.append(_plus_1);
        boolean _isRecursive = node.isRecursive();
        if (_isRecursive) {
          buffer.append(" (recursive)");
        }
        final HashMap<String, PrimitiveType> primitiveFieldInfo = node.getPrimitiveTypeFields();
        boolean _isEmpty = primitiveFieldInfo.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          buffer.append(": ");
        }
        int _size = primitiveFieldInfo.size();
        final int lastPrimitiveFieldIndex = (_size - 1);
        int currentPrimitiveFieldIndex = 0;
        Set<Map.Entry<String, PrimitiveType>> _entrySet = primitiveFieldInfo.entrySet();
        for (final Map.Entry<String, PrimitiveType> fieldInfo : _entrySet) {
          {
            final String fieldName = fieldInfo.getKey();
            final String fieldType = fieldInfo.getValue().getTypeName();
            buffer.append(fieldType);
            boolean _isEmpty_1 = fieldName.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              buffer.append(((" (" + fieldName) + ")"));
            }
            if ((currentPrimitiveFieldIndex < lastPrimitiveFieldIndex)) {
              buffer.append(", ");
            }
            currentPrimitiveFieldIndex++;
          }
        }
        buffer.append("\n");
        boolean _isEmpty_1 = node.getChildren().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          int _depth_2 = node.getDepth();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(1, _depth_2, true);
          for (final Integer i_1 : _doubleDotLessThan_1) {
            buffer.append("\t");
          }
          buffer.append("--> ");
        }
        int _size_1 = node.getChildren().size();
        final int lastChildIndex = (_size_1 - 1);
        int _size_2 = node.getChildren().size();
        ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_2, true);
        for (final Integer i_2 : _doubleDotLessThan_2) {
          {
            final TypeGraphNode currentChild = node.getChildren().get((i_2).intValue());
            buffer.append(currentChild.getType().getName());
            boolean _isRecursive_1 = currentChild.isRecursive();
            if (_isRecursive_1) {
              buffer.append(" (recursive)");
            }
            if (((i_2).intValue() < lastChildIndex)) {
              buffer.append(", ");
            }
          }
        }
        boolean _isEmpty_2 = node.getChildren().isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          buffer.append("\n");
        }
      }
    }
    buffer.append("\n");
    return buffer.toString();
  }
  
  @Pure
  public TypeGraphNode getRootNode() {
    return this.rootNode;
  }
}
