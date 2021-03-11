package de.fhdo.lemma.visualizer

import de.fhdo.lemma.visualizer.processor.GraphCollector
import de.fhdo.lemma.visualizer.processor.ModelProcessor

class Visualizer {
    val models : MutableList<Triple<String, String, String>> = mutableListOf()

    fun addProcessingCall(first : String, second : String, third : String) {
        models.add(Triple<String, String, String>(first, second, third))
    }

    fun execute() {
        models.forEach {
            //Starts a new thread for each entry in the models List
            val runArray = arrayOf<String>(it.first, it.second, it.third)
            ModelProcessor().run(runArray)
        }
        print(GraphCollector.microserviceGraph)
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

