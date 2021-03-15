package de.fhdo.lemma.visualizer.model

import org.jgrapht.graph.DefaultEdge

class MicroserviceEdge(val label: String) : DefaultEdge() {

    override fun toString(): String {
        return "($source : $target : $label)"
    }
}