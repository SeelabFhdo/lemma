package de.fhdo.lemma.typechecking.complex_types;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.typechecking.TypeCheckerI;
import de.fhdo.lemma.typechecking.TypecheckingUtils;
import de.fhdo.lemma.typechecking.complex_types.data_structures.DataFieldComparator;
import de.fhdo.lemma.typechecking.complex_types.data_structures.NodePair;
import de.fhdo.lemma.typechecking.complex_types.data_structures.NodeSeries;
import de.fhdo.lemma.typechecking.complex_types.data_structures.TypeGraph;
import de.fhdo.lemma.typechecking.complex_types.data_structures.TypeGraphNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * TypeChecker implementation for ComplexTypes.
 * 
 * It basically works as follows:
 *   (1) Convert both passed complex types into type graphs.
 *   (2) Iterate over the nodes (in the form of node pairs) of the graphs until the compatibility of
 *       the pair of the passed complex types got decided.
 *   (3) The actual decision if the currently iterated node pair is compatible is based on the
 *       pair's nodes' types, which all have different compatibility requirements.
 *   (4) Add new series of node pairs to check, resulting from the currently iterated one.
 *   (5) Get the next pair to check from the accompanying iterator, if the root node pair's
 *       compatibility did not get decided along the way. Goto (iii)
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ComplexTypeChecker implements TypeCheckerI<ComplexType> {
  /**
   * Check if type to check is compatible, i.e., assignable, to basic type
   */
  @Override
  public boolean compatible(final ComplexType initialBasicType, final ComplexType initialTypeToCheck) {
    final TypeGraph basicGraph = new TypeGraph(initialBasicType);
    final TypeGraph graphToCheck = new TypeGraph(initialTypeToCheck);
    TypeGraphNode _rootNode = basicGraph.getRootNode();
    TypeGraphNode _rootNode_1 = graphToCheck.getRootNode();
    NodePair rootNodePair = new NodePair(_rootNode, _rootNode_1);
    ComplexTypeCheckingIterator iterator = new ComplexTypeCheckingIterator(rootNodePair);
    while (rootNodePair.compatibilityUndecided()) {
      {
        final NodePair iterPair = iterator.next();
        boolean _checkAndMarkAlreadyDecided = this.checkAndMarkAlreadyDecided(iterator);
        boolean _not = (!_checkAndMarkAlreadyDecided);
        if (_not) {
          this.checkAndMarkCompatibility(iterPair, iterator);
        }
        boolean _currentPairCompatibilityUndecided = iterator.currentPairCompatibilityUndecided();
        if (_currentPairCompatibilityUndecided) {
          final List<NodeSeries> newNodeSeriesToCheck = NodeSeries.buildAllSeriesFor(iterPair);
          iterator.addAllSeries(newNodeSeriesToCheck);
          iterator.markCurrentPairCompatible();
        }
      }
    }
    return rootNodePair.isCompatible();
  }
  
  /**
   * Mark a current node pair as being compatible it this decision was already made in a previous
   * run. That is, further type checks are superfluous.
   */
  private boolean checkAndMarkAlreadyDecided(final ComplexTypeCheckingIterator iterator) {
    final Boolean alreadyDecided = iterator.currentPairTypeCompatibilityAlreadyDecided();
    if ((alreadyDecided != null)) {
      if ((alreadyDecided).booleanValue()) {
        iterator.markCurrentPairCompatible(true);
      } else {
        iterator.markCurrentPairIncompatible();
      }
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Perform type checking of the current node pair and handle its results and directly mark its
   * compatibility
   */
  private void checkAndMarkCompatibility(final NodePair iterPair, final ComplexTypeCheckingIterator iterator) {
    final TypeGraphNode basicNode = iterPair.getBasicNode();
    final ComplexType basicType = basicNode.getType();
    final TypeGraphNode nodeToCheck = iterPair.getNodeToCheck();
    final ComplexType typeToCheck = nodeToCheck.getType();
    final boolean typesEqual = this.typesEqual(basicType, typeToCheck);
    final boolean structureCheck = (basicType.isIsStructure() && typeToCheck.isIsStructure());
    final boolean primitiveCollectionCheck = (basicType.isIsPrimitiveCollection() && 
      typeToCheck.isIsPrimitiveCollection());
    final boolean structuredCollectionCheck = (basicType.isIsStructuredCollection() && 
      typeToCheck.isIsStructuredCollection());
    final boolean enumerationCheck = (basicType.isIsEnumeration() && typeToCheck.isIsEnumeration());
    final boolean nodeTypeKindsEqual = (((structureCheck || primitiveCollectionCheck) || structuredCollectionCheck) || enumerationCheck);
    if (typesEqual) {
      iterator.markCurrentPairCompatible(true);
    } else {
      if ((!nodeTypeKindsEqual)) {
        iterator.markCurrentPairIncompatible();
      } else {
        if ((structureCheck && 
          (!this.structuresCompatible(((DataStructure) basicType), ((DataStructure) typeToCheck))))) {
          iterator.markCurrentPairIncompatible();
        } else {
          if ((primitiveCollectionCheck && 
            (!this.primitiveCollectionsCompatible(((CollectionType) basicType), 
              ((CollectionType) typeToCheck))))) {
            iterator.markCurrentPairIncompatible();
          } else {
            if ((structuredCollectionCheck && 
              (!this.structuredCollectionsCompatible(((CollectionType) basicType), 
                ((CollectionType) typeToCheck))))) {
              iterator.markCurrentPairIncompatible();
            } else {
              if ((enumerationCheck && 
                (!this.enumerationsCompatible(((Enumeration) basicType), ((Enumeration) typeToCheck))))) {
                iterator.markCurrentPairIncompatible();
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * Check if two types are equal
   */
  private boolean typesEqual(final ComplexType basicType, final ComplexType typeToCheck) {
    boolean _equals = Objects.equal(basicType, typeToCheck);
    if (_equals) {
      return true;
    }
    boolean _isTechnologySpecific = TypecheckingUtils.isTechnologySpecific(typeToCheck);
    boolean _not = (!_isTechnologySpecific);
    if (_not) {
      return false;
    }
    final boolean basicStructure = (basicType.isIsStructure() || 
      (basicType instanceof TechnologySpecificDataStructure));
    if ((basicStructure && (typeToCheck instanceof TechnologySpecificDataStructure))) {
      return true;
    }
    final boolean basicCollection = (basicType.isIsPrimitiveCollection() || 
      (basicType instanceof TechnologySpecificCollectionType));
    if ((basicCollection && (typeToCheck instanceof TechnologySpecificCollectionType))) {
      return true;
    }
    return false;
  }
  
  /**
   * Check if two DataStructures are compatible
   */
  private boolean structuresCompatible(final DataStructure basicStructure, final DataStructure structureToCheck) {
    boolean _isExtensionOf = structureToCheck.isExtensionOf(basicStructure);
    if (_isExtensionOf) {
      return true;
    }
    int _compareFieldCounts = basicStructure.compareFieldCounts(structureToCheck);
    final boolean basicTypeIsSmaller = (_compareFieldCounts == (-1));
    if (((!structureToCheck.isExtensionOf(basicStructure)) && basicTypeIsSmaller)) {
      return false;
    }
    final Function1<DataField, Boolean> _function = (DataField it) -> {
      Type _effectiveType = it.getEffectiveType();
      return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
    };
    final List<DataField> basicPrimitiveFields = IterableExtensions.<DataField>toList(IterableExtensions.<DataField>filter(basicStructure.getEffectiveFields(), _function));
    final Function1<DataField, Boolean> _function_1 = (DataField it) -> {
      Type _effectiveType = it.getEffectiveType();
      return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
    };
    final List<DataField> primitiveFieldsToCheck = IterableExtensions.<DataField>toList(IterableExtensions.<DataField>filter(structureToCheck.getEffectiveFields(), _function_1));
    boolean _primitiveFieldsCompatible = this.primitiveFieldsCompatible(basicPrimitiveFields, primitiveFieldsToCheck);
    boolean _not = (!_primitiveFieldsCompatible);
    if (_not) {
      return false;
    }
    return true;
  }
  
  /**
   * Check if two primitively typed collections are compatible
   */
  private boolean primitiveCollectionsCompatible(final CollectionType basicCollection, final CollectionType collectionToCheck) {
    final PrimitiveType basicPrimitiveType = basicCollection.getPrimitiveType();
    final PrimitiveType primitiveTypeToCheck = collectionToCheck.getPrimitiveType();
    return basicPrimitiveType.isCompatibleWith(primitiveTypeToCheck);
  }
  
  /**
   * Check if two structured collections are compatible
   */
  private boolean structuredCollectionsCompatible(final CollectionType basicCollection, final CollectionType collectionToCheck) {
    int _compareFieldCounts = basicCollection.compareFieldCounts(collectionToCheck);
    final boolean basicCollectionIsSmaller = (_compareFieldCounts == (-1));
    if (basicCollectionIsSmaller) {
      return false;
    }
    final Function1<DataField, Boolean> _function = (DataField it) -> {
      Type _effectiveType = it.getEffectiveType();
      return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
    };
    final List<DataField> basicPrimitiveFields = IterableExtensions.<DataField>toList(IterableExtensions.<DataField>filter(basicCollection.getDataFields(), _function));
    final Function1<DataField, Boolean> _function_1 = (DataField it) -> {
      Type _effectiveType = it.getEffectiveType();
      return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
    };
    final List<DataField> primitiveFieldsToCheck = IterableExtensions.<DataField>toList(IterableExtensions.<DataField>filter(collectionToCheck.getDataFields(), _function_1));
    boolean _primitiveFieldsCompatible = this.primitiveFieldsCompatible(basicPrimitiveFields, primitiveFieldsToCheck);
    boolean _not = (!_primitiveFieldsCompatible);
    if (_not) {
      return false;
    }
    return true;
  }
  
  /**
   * Check compatibility of primitive types of lists of primitively typed DataFields
   */
  private boolean primitiveFieldsCompatible(final List<DataField> basicPrimitiveFields, final List<DataField> toCheckPrimitiveFields) {
    int _size = basicPrimitiveFields.size();
    int _size_1 = toCheckPrimitiveFields.size();
    boolean _lessThan = (_size < _size_1);
    if (_lessThan) {
      return false;
    }
    final ArrayList<DataField> basicTypedFieldsAvailable = CollectionLiterals.<DataField>newArrayList();
    basicTypedFieldsAvailable.addAll(basicPrimitiveFields);
    DataFieldComparator _dataFieldComparator = new DataFieldComparator(DataFieldComparator.ORDERING.ASCENDING);
    IterableExtensions.<DataField>sortWith(basicTypedFieldsAvailable, _dataFieldComparator);
    DataFieldComparator _dataFieldComparator_1 = new DataFieldComparator(DataFieldComparator.ORDERING.DESCENDING);
    final List<DataField> toCheckPrimitiveFieldsSorted = IterableExtensions.<DataField>sortWith(toCheckPrimitiveFields, _dataFieldComparator_1);
    for (final DataField fieldToCheck : toCheckPrimitiveFieldsSorted) {
      {
        final PrimitiveType toCheckType = fieldToCheck.getPrimitiveType();
        boolean compatibleFieldIsAvailable = false;
        int availableCompatibleFieldIndex = 0;
        int i = 0;
        while (((!compatibleFieldIsAvailable) && (i < basicTypedFieldsAvailable.size()))) {
          {
            final PrimitiveType correspondingType = basicTypedFieldsAvailable.get(i).getPrimitiveType();
            compatibleFieldIsAvailable = correspondingType.isCompatibleWith(toCheckType);
            availableCompatibleFieldIndex = i;
            i++;
          }
        }
        if (compatibleFieldIsAvailable) {
          basicTypedFieldsAvailable.remove(availableCompatibleFieldIndex);
        } else {
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Check if two enumerations are compatible
   */
  private boolean enumerationsCompatible(final Enumeration basicEnum, final Enumeration enumToCheck) {
    final Function1<EnumerationField, Boolean> _function = (EnumerationField it) -> {
      PrimitiveValue _initializationValue = it.getInitializationValue();
      return Boolean.valueOf((_initializationValue == null));
    };
    boolean _exists = IterableExtensions.<EnumerationField>exists(enumToCheck.getFields(), _function);
    if (_exists) {
      return false;
    }
    if ((((!this.<String>containsAllInitializationValues(basicEnum, enumToCheck, ((Function<PrimitiveValue, String>) (PrimitiveValue it) -> {
      return it.getStringValue();
    }))) || 
      (!this.<Boolean>containsAllInitializationValues(basicEnum, enumToCheck, ((Function<PrimitiveValue, Boolean>) (PrimitiveValue it) -> {
        return it.getBooleanValue();
      })))) || 
      (!this.<BigDecimal>containsAllInitializationValues(basicEnum, enumToCheck, ((Function<PrimitiveValue, BigDecimal>) (PrimitiveValue it) -> {
        return it.getNumericValue();
      }))))) {
      return false;
    }
    return true;
  }
  
  /**
   * Helper to check if an enumeration contains all initialization values of another enumeration.
   * Note, that this helper does not consider the types of the values. That is, the
   * "fieldValueGetter" parameter needs to take care that only values of the same type, e.g.,
   * string or numeric, are to be compared, in case this is desired.
   */
  private <T extends Object> boolean containsAllInitializationValues(final Enumeration basicEnum, final Enumeration enumToCheck, final Function<PrimitiveValue, T> fieldValueGetter) {
    final Function1<EnumerationField, Boolean> _function = (EnumerationField it) -> {
      return Boolean.valueOf(((it.getInitializationValue() != null) && 
        (fieldValueGetter.apply(it.getInitializationValue()) != null)));
    };
    final Function1<EnumerationField, String> _function_1 = (EnumerationField it) -> {
      return it.getInitializationValue().valueAsString();
    };
    final Set<String> basicValues = IterableExtensions.<String>toSet(IterableExtensions.<EnumerationField, String>map(IterableExtensions.<EnumerationField>filter(basicEnum.getFields(), _function), _function_1));
    final Function1<EnumerationField, Boolean> _function_2 = (EnumerationField it) -> {
      return Boolean.valueOf(((it.getInitializationValue() != null) && 
        (fieldValueGetter.apply(it.getInitializationValue()) != null)));
    };
    final Function1<EnumerationField, String> _function_3 = (EnumerationField it) -> {
      return it.getInitializationValue().valueAsString();
    };
    final Set<String> toCheckValues = IterableExtensions.<String>toSet(IterableExtensions.<EnumerationField, String>map(IterableExtensions.<EnumerationField>filter(enumToCheck.getFields(), _function_2), _function_3));
    return basicValues.containsAll(toCheckValues);
  }
  
  /**
   * Get name of a ComplexType
   */
  @Override
  public String typeName(final ComplexType type) {
    return type.getName();
  }
}
