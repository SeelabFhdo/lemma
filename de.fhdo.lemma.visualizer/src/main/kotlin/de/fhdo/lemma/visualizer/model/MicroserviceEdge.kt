package de.fhdo.lemma.visualizer.model

import org.jgrapht.graph.DefaultEdge

/**
 * Simple edge between microservices used by the JGraphT graph.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
class MicroserviceEdge(val label: String) : DefaultEdge() {

    override fun toString(): String {
        return "($source : $target : $label)"
    }
}