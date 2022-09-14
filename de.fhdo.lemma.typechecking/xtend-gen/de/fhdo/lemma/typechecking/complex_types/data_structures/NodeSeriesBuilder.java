package de.fhdo.lemma.typechecking.complex_types.data_structures;

import com.google.common.base.Predicate;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.utils.DistinctPairSeriesBuilder;
import de.fhdo.lemma.utils.Pair;
import de.fhdo.lemma.utils.Pairs;
import de.fhdo.lemma.utils.RotatingWindowList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Build all node series that are possible for a pair.
 * 
 * See the {@link NodePair} class for a detailed explanation on the semantics and usage of series
 * and their relation to node pairs.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class NodeSeriesBuilder {
  /**
   * Build all possible (and sensible) series for a node pair
   */
  public static List<NodeSeries> buildNodeSeries(final NodePair nodePair) {
    final ArrayList<NodeSeries> builtNodeSeries = CollectionLiterals.<NodeSeries>newArrayList();
    final List<TypeGraphNode> basicChildren = nodePair.getBasicNode().getChildren();
    final List<TypeGraphNode> nodeToCheckChildren = nodePair.getNodeToCheck().getChildren();
    if ((basicChildren.isEmpty() || nodeToCheckChildren.isEmpty())) {
      return builtNodeSeries;
    }
    List<TypeGraphNode> nodesToRotate = null;
    List<TypeGraphNode> nodesToCombine = null;
    Boolean rotationOfBasicChildren = null;
    int _size = basicChildren.size();
    int _size_1 = nodeToCheckChildren.size();
    boolean _greaterEqualsThan = (_size >= _size_1);
    if (_greaterEqualsThan) {
      nodesToRotate = basicChildren;
      nodesToCombine = nodeToCheckChildren;
      rotationOfBasicChildren = Boolean.valueOf(true);
    } else {
      nodesToRotate = nodeToCheckChildren;
      nodesToCombine = basicChildren;
      rotationOfBasicChildren = Boolean.valueOf(false);
    }
    int _size_2 = nodesToCombine.size();
    final RotatingWindowList<TypeGraphNode> rotatingList = new RotatingWindowList<TypeGraphNode>(nodesToRotate, _size_2);
    int windowNumber = 1;
    do {
      {
        final List<TypeGraphNode> rotatedNodes = rotatingList.getWindow(windowNumber);
        if ((rotationOfBasicChildren).booleanValue()) {
          builtNodeSeries.addAll(NodeSeriesBuilder.buildNodeSeries(rotatedNodes, nodesToCombine));
        } else {
          builtNodeSeries.addAll(NodeSeriesBuilder.buildNodeSeries(nodesToCombine, rotatedNodes));
        }
        windowNumber++;
      }
    } while((windowNumber <= nodesToRotate.size()));
    return builtNodeSeries;
  }
  
  /**
   * Build all possible node series from the lists of basic nodes and nodes to check
   */
  private static ArrayList<NodeSeries> buildNodeSeries(final List<TypeGraphNode> basicNodes, final List<TypeGraphNode> nodesToCheck) {
    final List<Pairs<TypeGraphNode>> distinctPairSeries = CollectionLiterals.<Pairs<TypeGraphNode>>newArrayList();
    final Pairs<TypeGraphNode> mandatoryStructurePairs = NodeSeriesBuilder.buildMandatoryPairsForStructures(basicNodes, nodesToCheck);
    final Predicate<TypeGraphNode> _function = (TypeGraphNode it) -> {
      return it.getType().isIsStructure();
    };
    distinctPairSeries.addAll(
      NodeSeriesBuilder.buildPairSeriesForType(basicNodes, nodesToCheck, _function, mandatoryStructurePairs));
    final Predicate<TypeGraphNode> _function_1 = (TypeGraphNode it) -> {
      return it.getType().isIsPrimitiveCollection();
    };
    distinctPairSeries.addAll(
      NodeSeriesBuilder.buildPairSeriesForType(basicNodes, nodesToCheck, _function_1, null));
    final Predicate<TypeGraphNode> _function_2 = (TypeGraphNode it) -> {
      return it.getType().isIsStructuredCollection();
    };
    distinctPairSeries.addAll(
      NodeSeriesBuilder.buildPairSeriesForType(basicNodes, nodesToCheck, _function_2, null));
    final ArrayList<NodeSeries> nodeSeries = CollectionLiterals.<NodeSeries>newArrayList();
    final Consumer<Pairs<TypeGraphNode>> _function_3 = (Pairs<TypeGraphNode> pairs) -> {
      final NodeSeries newSeries = new NodeSeries();
      final Consumer<Pair<TypeGraphNode>> _function_4 = (Pair<TypeGraphNode> it) -> {
        TypeGraphNode _get = it.get(0);
        TypeGraphNode _get_1 = it.get(1);
        final NodePair nodePair = new NodePair(_get, _get_1);
        newSeries.addChildPair(nodePair);
      };
      pairs.forEach(_function_4);
      nodeSeries.add(newSeries);
    };
    distinctPairSeries.forEach(_function_3);
    return nodeSeries;
  }
  
  /**
   * Helper method to build distinct pair series with type-filtering the given lists of nodes
   */
  private static ArrayList<Pairs<TypeGraphNode>> buildPairSeriesForType(final List<TypeGraphNode> basicNodes, final List<TypeGraphNode> nodesToCheck, final Predicate<TypeGraphNode> typeFilterPredicate, final Pairs<TypeGraphNode> mandatoryPairs) {
    final List<TypeGraphNode> basicNodesOfType = IterableExtensions.<TypeGraphNode>toList(IterableExtensions.<TypeGraphNode>filter(basicNodes, new Function1<TypeGraphNode, Boolean>() {
        public Boolean apply(TypeGraphNode p) {
          return typeFilterPredicate.apply(p);
        }
    }));
    final List<TypeGraphNode> nodesToCheckOfType = IterableExtensions.<TypeGraphNode>toList(IterableExtensions.<TypeGraphNode>filter(nodesToCheck, new Function1<TypeGraphNode, Boolean>() {
        public Boolean apply(TypeGraphNode p) {
          return typeFilterPredicate.apply(p);
        }
    }));
    if (((!basicNodesOfType.isEmpty()) && (!nodesToCheckOfType.isEmpty()))) {
      return new DistinctPairSeriesBuilder<TypeGraphNode>().buildPairSeries(basicNodesOfType, nodesToCheckOfType, mandatoryPairs);
    } else {
      return CollectionLiterals.<Pairs<TypeGraphNode>>newArrayList();
    }
  }
  
  /**
   * Build mandatory node pairs for nodes that represent DataStructures
   */
  private static Pairs<TypeGraphNode> buildMandatoryPairsForStructures(final List<TypeGraphNode> basicNodes, final List<TypeGraphNode> nodesToCheck) {
    final Pairs<TypeGraphNode> mandatoryPairs = new Pairs<TypeGraphNode>();
    final Function1<TypeGraphNode, Boolean> _function = (TypeGraphNode it) -> {
      return Boolean.valueOf(it.getType().isIsStructure());
    };
    Iterable<TypeGraphNode> _filter = IterableExtensions.<TypeGraphNode>filter(nodesToCheck, _function);
    for (final TypeGraphNode structureNodeToCheck : _filter) {
      {
        ComplexType _type = structureNodeToCheck.getType();
        final DataStructure structureTypeToCheck = ((DataStructure) _type);
        final Function1<TypeGraphNode, Boolean> _function_1 = (TypeGraphNode it) -> {
          return Boolean.valueOf(it.getType().isIsStructure());
        };
        Iterable<TypeGraphNode> _filter_1 = IterableExtensions.<TypeGraphNode>filter(basicNodes, _function_1);
        for (final TypeGraphNode basicNode : _filter_1) {
          {
            ComplexType _type_1 = basicNode.getType();
            final DataStructure basicStructureType = ((DataStructure) _type_1);
            boolean _isExtensionOf = structureTypeToCheck.isExtensionOf(basicStructureType);
            if (_isExtensionOf) {
              mandatoryPairs.addPair(basicNode, structureNodeToCheck);
            }
          }
        }
      }
    }
    return mandatoryPairs;
  }
}
