package de.fhdo.lemma.visualizer

import de.fhdo.lemma.visualizer.processor.GraphCollector
import de.fhdo.lemma.visualizer.processor.ModelProcessor
import de.fhdo.lemma.visualizer.processor.ProcessingThread
import java.io.File

class Visualizer {
    val models : MutableList<Triple<String, String, String>> = mutableListOf()

    fun addProcessingCall(first : String, second : String, third : String) {
        models.add(Triple<String, String, String>(first, second, third))
    }

    //Apparently model processing framework completly terminates the process when finished and cant be used to spawn multiple
    //instances and gather there values in a singleton. Maybe use the filesystem instead?
    //or mess with the processing framework ;)
    // Other idea: process the graphs as Jgrapht graphs from the processing exmaples. Than use JgraphTs merge functionality
    // Graphs.addGraph(g1, g2); ( see https://stackoverflow.com/questions/13232450/merge-graphs-in-jgrapht )
    // to merge the graphs to a complete graph and then do the DOT and GraphViz processing in a single thread
    fun execute() {
        models.forEach {
            //Starts a new thread for each entry in the models List
            val runArray = arrayOf<String>(it.first, it.second, it.third)
            val test = ModelProcessor().run(runArray)
        }
    }
}

/**
 * Entrypoint to the Visualizer.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
fun main(args:Array<String>) {
    // -s "~/dev/lemma-dev/runtime-EclipseApplication/test-project/models-gen/b.services"
    // -i "~/dev/lemma-dev/runtime-EclipseApplication/test-project/intermediate/servicemodels/b.xmi"
    // -t "~/dev/lemma-dev/runtime-EclipseApplication/test-project/code-gen"
    val visualizer = Visualizer()
    visualizer.addProcessingCall(
        "-s=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/models-gen/b.services",
        "-i=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/intermediate/servicemodels/b.xmi",
        "-t=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/code-gen"
    )
    visualizer.execute()
}

