package de.fhdo.lemma.operationdsl.diagram

import java.util.LinkedHashMap
import java.util.List
import java.util.Map

/**
 * The names the diagrams refer to nodes by.
 *
 * PlantUML identifies a shape by the name it is declared with, and two
 * operation models of one system may declare a node of the same name - so a
 * node needs an alias of its own. The alias deliberately does **not** contain
 * the model's path: the path is absolute and machine-specific, and a generated
 * diagram has to be the same on every machine to be diffable and reproducible.
 * A clash is resolved with the model's file name instead, and then with an
 * index.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DiagramNaming {
    val Map<String, String> aliases = new LinkedHashMap<String, String>

    new(List<NodeInfo> nodes) {
        val taken = <String>newLinkedHashSet
        for (node : nodes) {
            val identity = identityOf(node)
            if (!aliases.containsKey(identity)) {
                aliases.put(identity, unique(node, taken))
            }
        }
    }

    /**
     * The alias of a node, or one derived from its name when the node was not
     * among those the naming was built from - an unresolved stub, for one.
     */
    def String aliasOf(NodeInfo node) {
        return aliases.get(identityOf(node)) ?: sanitise("n_" + node.name)
    }

    def String artifactAliasOf(NodeInfo node, ArtifactInfo artifact) {
        return sanitise(aliasOf(node) + "__" + artifact.name)
    }

    private def String unique(NodeInfo node, java.util.Set<String> taken) {
        val candidates = <String>newLinkedList
        candidates.add("n_" + node.name)
        if (node.modelFile !== null) {
            candidates.add("n_" + node.name + "__" + baseNameOf(node.modelFile))
        }
        for (candidate : candidates) {
            val alias = sanitise(candidate)
            if (taken.add(alias)) {
                return alias
            }
        }
        var int index = 2
        while (true) {
            val alias = sanitise("n_" + node.name + "__" + index)
            if (taken.add(alias)) {
                return alias
            }
            index++
        }
    }

    /**
     * A node is identified by its name and the model that declares it.
     */
    private def String identityOf(NodeInfo node) {
        return '''«node.modelFile»#«node.name»'''.toString
    }

    private def String baseNameOf(String file) {
        val separator = file.lastIndexOf("/")
        var name = if (separator >= 0) file.substring(separator + 1) else file
        val dot = name.lastIndexOf(".")
        return if (dot > 0) name.substring(0, dot) else name
    }

    private def String sanitise(String text) {
        return text.replaceAll("[^A-Za-z0-9_]", "_")
    }
}
