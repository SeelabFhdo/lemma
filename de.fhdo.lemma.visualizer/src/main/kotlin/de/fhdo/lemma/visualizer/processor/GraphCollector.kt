package de.fhdo.lemma.visualizer.processor

import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph
import java.io.File

object GraphCollector {
    val microserviceGraph: Graph<MicroserviceVertex, MicroserviceEdge> =
        DefaultDirectedGraph(MicroserviceEdge::class.java)
    var imageConfig : ImageConfig = ImageConfig(format = Format.PNG)

    fun addMicroserviceVertex(service : MicroserviceVertex){
        microserviceGraph.addVertex(service)
    }

    fun addMicroserviceEdge(v1 : MicroserviceVertex, v2 : MicroserviceVertex, relationship : MicroserviceEdge){
        microserviceGraph.addEdge(v1, v2, relationship)
    }

    fun createDotRepresentation(): String {
        return GraphUtil.exportDotFromGraph(microserviceGraph)
    }
    fun createImageRepresentation(path : File) {
        if(imageConfig.height == null && imageConfig.width == null)
            Graphviz.fromString(createDotRepresentation())
                .render(imageConfig.format).toFile(path)
        if(imageConfig.height != null && imageConfig.width != null)
            Graphviz.fromString(createDotRepresentation()).height(imageConfig.height!!).width(imageConfig.width!!)
                .render(imageConfig.format).toFile(path)
        if(imageConfig.height != null && imageConfig.width == null)
            Graphviz.fromString(createDotRepresentation()).height(imageConfig.height!!)
                .render(imageConfig.format).toFile(path)
        if(imageConfig.height == null && imageConfig.width != null)
            Graphviz.fromString(createDotRepresentation()).width(imageConfig.width!!)
                .render(imageConfig.format).toFile(path)
    }

    data class ImageConfig(val height : Int? = null, val width : Int? = null, val format : Format? = Format.PNG)
}