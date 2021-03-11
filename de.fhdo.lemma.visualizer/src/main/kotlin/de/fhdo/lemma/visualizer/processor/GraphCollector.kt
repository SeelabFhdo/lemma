package de.fhdo.lemma.visualizer.processor

import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph

object GraphCollector {
    val microserviceGraph: Graph<MicroserviceVertex, MicroserviceEdge> = DefaultDirectedGraph(MicroserviceEdge::class.java)
    init {
        //Currently no inital actions needed
    }
    fun addMicroserviceVertex(service : MicroserviceVertex){
        microserviceGraph.addVertex(service)
    }

    fun addMicroserviceEdge(v1 : MicroserviceVertex, v2 : MicroserviceVertex, relationship : MicroserviceEdge){
        microserviceGraph.addEdge(v1, v2, relationship)
    }
}