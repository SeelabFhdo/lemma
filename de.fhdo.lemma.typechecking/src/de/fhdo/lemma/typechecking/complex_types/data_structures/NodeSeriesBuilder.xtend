package de.fhdo.lemma.typechecking.complex_types.data_structures

import de.fhdo.lemma.utils.RotatingWindowList
import java.util.List
import de.fhdo.lemma.utils.Pairs
import com.google.common.base.Predicate
import de.fhdo.lemma.utils.DistinctPairSeriesBuilder
import de.fhdo.lemma.data.DataStructure

/**
 * Build all node series that are possible for a pair.
 *
 * See the {@link NodePair} class for a detailed explanation on the semantics and usage of series
 * and their relation to node pairs.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class NodeSeriesBuilder {
    /**
     * Build all possible (and sensible) series for a node pair
     */
    def static List<NodeSeries> buildNodeSeries(NodePair nodePair) {
        val builtNodeSeries = <NodeSeries> newArrayList
        val basicChildren = nodePair.basicNode.children
        val nodeToCheckChildren = nodePair.nodeToCheck.children

        if (basicChildren.empty || nodeToCheckChildren.empty)
            return builtNodeSeries

        /*
         * Building the node series for the pair is based on rotating the children of the pair with
         * the more children against the children of the other pair. Take for example the following
         * structures forming the NodePair (Basic, ToCheck):
         *   structure Basic {
         *     Child C1,
         *     Child C2,
         *     Child C3
         *   }
         *
         *   structure ToCheck {
         *     Child C4,
         *     Child C5
         *   }
         *
         * In that case, we rotate the children of Basic three times against the children of
         * ToCheck, which basically results in the following combinations of their children:
         *   Rotation 1) C1   C4
         *               C2   C5
         *   Rotation 2) C2   C4
         *               C3   C5
         *   Rotation 3) C3   C4
         *               C1   C5
         * Thus, all possible child combinations are reached once.
         */

        // Determine list (the one with the more nodes) to rotate
        var List<TypeGraphNode> nodesToRotate
        var List<TypeGraphNode> nodesToCombine
        var Boolean rotationOfBasicChildren
        if (basicChildren.size >= nodeToCheckChildren.size) {
            nodesToRotate = basicChildren
            nodesToCombine = nodeToCheckChildren
            rotationOfBasicChildren = true
        } else {
            nodesToRotate = nodeToCheckChildren
            nodesToCombine = basicChildren
            rotationOfBasicChildren = false
        }

        // Do the rotation and build series from the resulting child combinations
        val rotatingList = new RotatingWindowList(nodesToRotate, nodesToCombine.size)
        var windowNumber = 1

        do {
            val rotatedNodes = rotatingList.getWindow(windowNumber)

            // Keep previous order of nodes (basic node before node to check)
            if (rotationOfBasicChildren)
                builtNodeSeries.addAll(buildNodeSeries(rotatedNodes, nodesToCombine))
            else
                builtNodeSeries.addAll(buildNodeSeries(nodesToCombine, rotatedNodes))

            windowNumber++
        } while(windowNumber <= nodesToRotate.size)

        return builtNodeSeries
    }

    /**
     * Build all possible node series from the lists of basic nodes and nodes to check
     */
    private def static buildNodeSeries(List<TypeGraphNode> basicNodes,
        List<TypeGraphNode> nodesToCheck) {
        val List<Pairs<TypeGraphNode>> distinctPairSeries = newArrayList

        /*
         * For building the series of nodes we use the DistinctPairSeriesBuilder. It will determine
         * all possible combinations of the nodes. However, we need to ensure that only those nodes
         * are about to be combined, that have the same type. This reduces the runtime of the type
         * checker because a pair of nodes that does not have the same kind of complex type will be
         * marked as being incompatible either.
         */

        // Nodes that represent DataStructures. In that case mandatory pairs can be passed to the
        // DistinctPairSeriesBuilder. A mandatory combination of a DataStructure is given, e.g.,
        // when the node to check's DataStructure type extends the basic node's DataStructure type
        // (Java inheritance semantics: Car extends Vehicle --> "a Car is a Vehicle" -->
        // vehicle = car is possible).
        val mandatoryStructurePairs = buildMandatoryPairsForStructures(basicNodes, nodesToCheck)
        distinctPairSeries.addAll(
            buildPairSeriesForType(basicNodes, nodesToCheck, [type.isStructure],
                mandatoryStructurePairs)
        )

        // Nodes that represent CollectionTypes of a primitive type
        distinctPairSeries.addAll(
            buildPairSeriesForType(basicNodes, nodesToCheck, [type.isPrimitiveCollection], null)
        )

        // Nodes that represent CollectionTypes with individually named and typed data fields
        // (so-called "structured collections")
        distinctPairSeries.addAll(
            buildPairSeriesForType(basicNodes, nodesToCheck, [type.isStructuredCollection], null)
        )

        /*
         * Build a list of NodeSeries from distinct Pairs of type-aligned TypeGraphNodes
         */
        val nodeSeries = <NodeSeries> newArrayList
        distinctPairSeries.forEach[pairs |
            val newSeries = new NodeSeries

            pairs.forEach[
                val nodePair = new NodePair(it.get(0), it.get(1))
                newSeries.addChildPair(nodePair)
            ]

            nodeSeries.add(newSeries)
        ]

        return nodeSeries
    }

    /**
     * Helper method to build distinct pair series with type-filtering the given lists of nodes
     */
    private def static buildPairSeriesForType(List<TypeGraphNode> basicNodes,
        List<TypeGraphNode> nodesToCheck, Predicate<TypeGraphNode> typeFilterPredicate,
        Pairs<TypeGraphNode> mandatoryPairs) {
        val basicNodesOfType = basicNodes.filter(typeFilterPredicate).toList
        val nodesToCheckOfType = nodesToCheck.filter(typeFilterPredicate).toList

        if (!basicNodesOfType.empty && !nodesToCheckOfType.empty)
            return new DistinctPairSeriesBuilder().buildPairSeries(basicNodesOfType,
                nodesToCheckOfType, mandatoryPairs)
        else
            return <Pairs<TypeGraphNode>> newArrayList
    }

        /**
     * Build mandatory node pairs for nodes that represent DataStructures
     */
    private def static buildMandatoryPairsForStructures(List<TypeGraphNode> basicNodes,
        List<TypeGraphNode> nodesToCheck) {
        val mandatoryPairs = new Pairs<TypeGraphNode>

        for (structureNodeToCheck : nodesToCheck.filter[type.isStructure]) {
            val structureTypeToCheck = structureNodeToCheck.type as DataStructure

            for (basicNode : basicNodes.filter[type.isStructure]) {
                val basicStructureType = basicNode.type as DataStructure

                // If the DataStructure of the node to check extends the DataStructure of the basic
                // node than this is a mandatory pair. At least according to Java's inheritance
                // semantics: Car extends Vehicle --> "a Car is a Vehicle" --> vehicle = car is
                // possible.
                if (structureTypeToCheck.isExtensionOf(basicStructureType))
                    mandatoryPairs.addPair(basicNode, structureNodeToCheck)
            }
        }

        return mandatoryPairs
    }
}