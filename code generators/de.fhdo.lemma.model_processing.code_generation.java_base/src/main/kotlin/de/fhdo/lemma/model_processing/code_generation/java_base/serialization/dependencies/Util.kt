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
 * Merge a given XML [Node] into the current one. This happens in-place, i.e., no copy of the current [Node] instance
 * will be created.
 *
 * By merging, we mean the action of adding child nodes of the other XML node under those child nodes of the current
 * node that are one the same hierarchy and have the same name. For instance, if this node represents the XML node tree
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
 * This function is particularly useful when the other node was created with the [elements] function. Note that the
 * merging process starts at the second level, not at the root level of both nodes.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
infix fun Node.merge(otherNode: Node) {
    // Iterate over the child nodes of the other node
    for (currentOtherChild in otherNode.childNodes) {
        // If there does not exist an eponymous child of this node, we add the other child to the current level (which
        // is the second level, i.e., the one under the root node)
        var equalNodeOnNextLevel = findEponymousChildNode(currentOtherChild)
        if (equalNodeOnNextLevel === null) {
            addNode(currentOtherChild)
            continue
        }

        // If there exists an eponymous node on the second level, we climb down the hierarchy until we do not find an
        // eponymous node anymore. Then at this level, all non-eponymous sub-nodes of the other node are added.
        var mergeNode = equalNodeOnNextLevel
        var equalChildNodeOnNextLevel = currentOtherChild
        while (equalNodeOnNextLevel !== null) {
            equalNodeOnNextLevel = equalNodeOnNextLevel.findEponymousChildNode(equalChildNodeOnNextLevel.childNodes)

            // Go to the next level
            if (equalNodeOnNextLevel !== null) {
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
private val Node.childNodes
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