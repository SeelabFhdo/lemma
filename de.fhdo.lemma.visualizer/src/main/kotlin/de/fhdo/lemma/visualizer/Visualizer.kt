package de.fhdo.lemma.visualizer

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import java.io.File
import java.nio.file.Path

//Apparently model processing framework completly terminates the process when finished and cant be used to spawn multiple
    //instances and gather there values in a singleton. Maybe use the filesystem instead?
    //or mess with the processing framework ;)
    // Other idea: process the graphs as Jgrapht graphs from the processing exmaples. Than use JgraphTs merge functionality
    // Graphs.addGraph(g1, g2); ( see https://stackoverflow.com/questions/13232450/merge-graphs-in-jgrapht )
    // to merge the graphs to a complete graph and then do the DOT and GraphViz processing in a single thread

    // another idea: in kotlin singleton objects unless marked with @kotlin.native.ThreadLocal
    // are frozen and shared, lazy values allowed, unless cyclic frozen structures were attempted to be created
    // i.e. when I just wait for the courtines/threads to finish it should still work?
    // runBlocking? https://dzone.com/articles/waiting-for-coroutines#:~:text=To%20wait%20for%20a%20coroutine%20to%20finish%2C%20you%20can%20call,that%20thread%20or%20thread%20pool).

/**
 * This class is the entry point for LEMMA model processors used by the main function. Therefore, it extends
 * AbstractModelProcessor and passes the package, in which to find language description providers,
 * code generation modules etc. LEMMA's Model Processing Framework (LMPF) relies on annotations to
 * find relevant implementations in the passed package at runtime.
 *
 * Model processing is the invoked by calling the run() method on an AbstractModelProcessor
 * instance. Valid commandline arguments are:
 *   - "-s": Source model file in LEMMA's concrete syntax representation.
 *   - "-i": Source model file in LEMMA's intermediate representation.
 *   - "-t": Target folder for code generation modules.
 *   - "--invoke_only_specified_phases": Invoke only those model processing phases explicitly
 *      specified via the commandline.
 *   - "--exit_on_error": Exit on any error occurring during model processing in any phase.
 *
 * Commands can be used like "-s=/my/absolute/path/to/file.xmi" (due to picocli used for the processor framework)
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
class Visualizer(var path: String) : AbstractModelProcessor("de.fhdo.lemma.visualizer") {
    /**
     * Represents the absolute paths to the service models and their corresponding intermediateModels.
     * Each entry is a Pair whereby the first entry is a File to the serviceModel and the second
     * a File to its intermediateModel.
     * All entries are parsed as moduleArguments to the model processing framework. Must not be empty before execution.
     */
    val parameters : MutableList<Pair<File, File>> = mutableListOf<Pair<File, File>>()
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
    // code_generation ServicesToGraphVizGenerator --additional_serv="yolobert.services" --additional_serv="yolobert.services" --additional_serv="yolobert.services"
    // Aus Utils paket loadAsXml (siehe comment msaresearchdudes)
    val vis = Visualizer("/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/code-gen")
    vis.parameters.add(Pair(File("/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/models-gen/b.services"),
        File("/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/intermediate/service models/b.xmi")))
    //visualizer.addProcessingCall(
    //    "-s=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/models-gen/b.services",
    //    "-i=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/intermediate/servicemodels/b.xmi",
    //    "-t=/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/code-gen"
    //)
    if(!vis.parameters.isEmpty()) {
        val runArray = mutableListOf<String>("-s=${vis.parameters[0].first}", "-i=${vis.parameters[0].second}", "-t=${vis.path}")
        //runArray.addAll(listOf("code_generation", "ServicesToGraphVizGenerator","--example=193.25.22.138"))
        val test2 = "/home/jonas/dev/lemma-dev/runtime-EclipseApplication/test-project/intermediate/service models/"
        runArray.addAll(listOf("code_generation", "ServicesToGraphVizGenerator","-aim=${test2}", "a.xmi", "a2.xmi", "b2.xmi"))
        runArray.forEach { print(it) }
        val test = vis.run(runArray.toTypedArray())
    } else {
        print("Error: no parameters given to execute model processing.")
    }
}

