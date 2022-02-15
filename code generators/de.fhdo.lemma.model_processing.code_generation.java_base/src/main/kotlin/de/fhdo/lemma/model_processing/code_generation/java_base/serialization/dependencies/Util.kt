package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies

import org.redundent.kotlin.xml.Node

/**
 * Convenience function to create an unnamed XML [Node], which acts as an anonymous collector for other XML elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun elements(init: Node.() -> Unit) : Node {
    val node = Node("")
    node.init()
    return node
}

/**
 * Convenience function to add a child node to this [Node] if it doesn't already comprise a child node with the same
 * name. The [elements] parameter is expected to receive a node created with the "elements" function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addChildIfNotExists(elements: Node) {
    val child = elements.childNodes.first()
    if (!this.childNodes.any { it.nodeName == child.nodeName })
        this.addNode(child)
}

/**
 * Convenience function to add a child node to a sub-tree of this [Node]. Missing sub-tree hierarchies will also be
 * created. Suppose this [Node] to represent the XML node tree
 *      node1
 *          node2
 *              node3
 *                  element1
 *                  element2
 *
 * Passing the sub-tree
 *      node2
 *          node4
 *
 * and the child element
 *      element3
 *
 * will result in the function to adapt this [Node] as follows:
 *      node1
 *          node2
 *              node3
 *                  element1
 *                  element2
 *              node4
 *                  element3
 *
 * The [elements] parameter is expected to receive a node created with the "elements" function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addChild(elements: Node, subTreeElements: Node) {
    val child = elements.childNodes.first()
    var subTree: Node? = subTreeElements.childNodes.first()
    var parent = this
    var n = parent.childNodes.find { it.nodeName == subTree!!.nodeName }

    // Reduce the passed sub-tree by all node hierarchies that already exist in this node
    while(n !== null) {
        parent = n
        subTree = subTree!!.childNodes.firstOrNull()
        if (subTree == null)
            break
        n = parent.childNodes.find { it.nodeName == subTree.nodeName }
    }

    // In case the sub-tree contains a node hierarchy not present in this node, add it to this node
    if (subTree !== null) {
        parent.addNode(subTree)
        parent = subTree
        // Change the parent for the child to the leaf of the sub-tree hierarchy
        while (parent.childNodes.isNotEmpty())
            parent = parent.childNodes.first()
    }

    // Add the child node to this node. The parent is either a child of this node that already existed before invoking
    // the function (i.e., the complete sub-tree was already a part of this node) or the leaf of the sub-tree (i.e.,
    // a missing sub-tree hierarchy had to be added to this node).
    parent.addNode(child)
}

/**
 * Merge a given XML [Node] into the current one. This happens in-place, i.e., no copy of the current [Node] instance
 * will be created.
 *
 * By merging, we mean the action of adding child nodes of the other XML node under those child nodes of the current
 * node that are on the same hierarchy and have the same name. For instance, if this node represents the XML node tree
 *      node1
 *          node2
 *              node3
 *                  element1
 *                  element2
 * and the other node represents the tree
 *      node1
 *          node2
 *              element3
 *              element4
 * then merging the latter tree into the former one results in the former tree being adapted to
 *      node1
 *          node2
 *              element3 [MERGED]
 *              element4 [MERGED]
 *              node3
 *                  element1
 *                  element2.
 *
 * This function is particularly useful when the other node was created with the [elements] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal infix fun Node.merge(otherNode: Node) {
    /*
     * If the other node has a name, i.e., it was not created with elements() for example, and it differs from the name
     * of this node, directly add the other node to this node as a child, because both nodes already differ at the
     * root-level and merging is thus trivial
     */
    if (otherNode.nodeName.isNotEmpty() && otherNode.nodeName != this.nodeName) {
        addNode(otherNode)
        return
    }

    /*
     * If no trivial difference at the root-level was determined, iterate over the child nodes of the other node for
     * non-trivial merging
     */
    for (currentOtherChild in otherNode.childNodes) {
        // If there does not exist an eponymous child of this node, we add the other child to the current level (which
        // is the second level, i.e., the one under the root node)
        var equalNodeOnNextLevel = findEponymousChildNode(currentOtherChild)
        if (equalNodeOnNextLevel == null) {
            addNode(currentOtherChild)
            continue
        }

        // If there exists an eponymous node on the second level, we climb down the hierarchy until we do not find an
        // eponymous node anymore. Then at this level, all non-eponymous sub-nodes of the other node are added.
        var mergeNode = equalNodeOnNextLevel
        var equalChildNodeOnNextLevel = currentOtherChild
        while (equalNodeOnNextLevel != null) {
            equalNodeOnNextLevel = equalNodeOnNextLevel.findEponymousChildNode(equalChildNodeOnNextLevel.childNodes)

            // Go to the next level
            if (equalNodeOnNextLevel != null) {
                equalChildNodeOnNextLevel = equalChildNodeOnNextLevel.findEponymousChildNode(equalNodeOnNextLevel)!!
                mergeNode = equalNodeOnNextLevel
            }
        }

        equalChildNodeOnNextLevel.childNodes.forEach { mergeNode!!.addNode(it) }
    }
}

/**
 * Convenience function to get the child nodes of a [Node] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Node.childNodes
    get() = children.filterIsInstance<Node>()

/**
 * Convenience function to find an eponymous child node of a [Node] instance from another [Node] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.findEponymousChildNode(compareNode: Node) = childNodes.find{ it.nodeName == compareNode.nodeName }

/**
 * Convenience function to find an eponymous child node of a [Node] instance from a list of other [Node] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Node.findEponymousChildNode(compareNodes: List<Node>)
        = childNodes.find { childNode -> childNode.nodeName in compareNodes.map { it.nodeName } }