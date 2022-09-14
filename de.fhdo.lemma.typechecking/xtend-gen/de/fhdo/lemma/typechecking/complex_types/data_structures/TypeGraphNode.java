package de.fhdo.lemma.typechecking.complex_types.data_structures;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Represents a node of a TypeGraph.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TypeGraphNode {
  /**
   * Complex type of the node
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ComplexType type;
  
  /**
   * Full-qualified name of the field of the node's type
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String fieldName;
  
  /**
   * Parent node (null for root nodes)
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private TypeGraphNode parent;
  
  /**
   * Node depth beginning with 1
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private int depth;
  
  /**
   * Flag to indicate that the type refers to itself
   */
  @Accessors
  private boolean recursive;
  
  /**
   * The node's children, i.e., the nodes representing the complex types that this complex type
   * refers to. Empty for recursive nodes.
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final List<TypeGraphNode> children = CollectionLiterals.<TypeGraphNode>newLinkedList();
  
  /**
   * Constructor
   */
  public TypeGraphNode(final ComplexType type, final String fieldName, final TypeGraphNode parent) {
    this.type = type;
    this.fieldName = fieldName;
    this.parent = parent;
    if ((parent != null)) {
      this.depth = (parent.depth + 1);
    } else {
      this.depth = 1;
    }
  }
  
  /**
   * Is this node the root node of the graph?
   */
  public boolean isRoot() {
    return (this.depth == 1);
  }
  
  /**
   * Get information about primitive types, depending on the node type, in the form of a map of
   * fields' names to their primitive types.
   * 
   * Conceptually, each entry of the map corresponds to a DataField instance. However, as we
   * cannot instantiate this metamodel concept that easy, we just use a "simple" map for the
   * necessary information.
   */
  public HashMap<String, PrimitiveType> getPrimitiveTypeFields(final DataFieldComparator.ORDERING ordering) {
    final HashMap<String, PrimitiveType> primitiveTypeFieldInfo = CollectionLiterals.<String, PrimitiveType>newHashMap();
    if ((((!this.type.isIsPrimitiveCollection()) && (!this.type.isIsStructure())) && (!this.type.isIsStructuredCollection()))) {
      return primitiveTypeFieldInfo;
    }
    boolean _isIsPrimitiveCollection = this.type.isIsPrimitiveCollection();
    if (_isIsPrimitiveCollection) {
      primitiveTypeFieldInfo.put("", ((CollectionType) this.type).getPrimitiveType());
      return primitiveTypeFieldInfo;
    }
    EList<DataField> dataFields = null;
    boolean _isIsStructure = this.type.isIsStructure();
    if (_isIsStructure) {
      dataFields = ((DataStructure) this.type).getEffectiveFields();
    } else {
      boolean _isIsStructuredCollection = this.type.isIsStructuredCollection();
      if (_isIsStructuredCollection) {
        dataFields = ((CollectionType) this.type).getDataFields();
      }
    }
    final Function1<DataField, Boolean> _function = (DataField it) -> {
      Type _effectiveType = it.getEffectiveType();
      return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
    };
    final List<DataField> primitiveDataFields = IterableExtensions.<DataField>toList(IterableExtensions.<DataField>filter(dataFields, _function));
    if ((ordering != DataFieldComparator.ORDERING.NONE)) {
      DataFieldComparator _dataFieldComparator = new DataFieldComparator(ordering);
      primitiveDataFields.sort(_dataFieldComparator);
    }
    final Consumer<DataField> _function_1 = (DataField it) -> {
      primitiveTypeFieldInfo.put(it.getName(), it.getPrimitiveType());
    };
    primitiveDataFields.forEach(_function_1);
    return primitiveTypeFieldInfo;
  }
  
  /**
   * Convenience method that returns primitively typed fields of the node type without an ordering
   */
  public HashMap<String, PrimitiveType> getPrimitiveTypeFields() {
    return this.getPrimitiveTypeFields(DataFieldComparator.ORDERING.NONE);
  }
  
  /**
   * Add a new child node if this node is not recursive
   */
  public boolean addChild(final TypeGraphNode newChild) {
    boolean _isRecursive = this.isRecursive();
    if (_isRecursive) {
      return false;
    }
    return this.children.add(newChild);
  }
  
  @Pure
  public ComplexType getType() {
    return this.type;
  }
  
  @Pure
  public String getFieldName() {
    return this.fieldName;
  }
  
  @Pure
  public TypeGraphNode getParent() {
    return this.parent;
  }
  
  @Pure
  public int getDepth() {
    return this.depth;
  }
  
  @Pure
  public boolean isRecursive() {
    return this.recursive;
  }
  
  public void setRecursive(final boolean recursive) {
    this.recursive = recursive;
  }
  
  @Pure
  public List<TypeGraphNode> getChildren() {
    return this.children;
  }
}
