package de.fhdo.lemma.visualizer.model

import org.jgrapht.graph.DefaultEdge

//TODO CURRENTLY NOT WORKING
class MicroserviceEdge(val label: String) : DefaultEdge() {

    override fun toString(): String {
        return "($source : $target : $label)"
    }
}