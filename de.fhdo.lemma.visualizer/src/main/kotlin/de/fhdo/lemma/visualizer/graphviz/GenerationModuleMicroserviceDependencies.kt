package de.fhdo.lemma.visualizer.graphviz

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.visualizer.model.MicroserviceEdge
import de.fhdo.lemma.visualizer.model.MicroserviceVertex
import de.fhdo.lemma.visualizer.processor.GraphCollector
import de.fhdo.lemma.visualizer.processor.GraphUtil
import guru.nidi.graphviz.engine.Format
import org.jgrapht.Graph
import java.nio.charset.Charset
import java.util.stream.Collectors
import kotlin.Pair
import guru.nidi.graphviz.engine.Graphviz
import java.io.File

/**
 * TODO documentation
 * TODO How to call multiple models into the process?! -> Maybe invoke the model processor FOR EACH MODEL and collect all the resulting vertices and edges as return values?
 * TODO build a graph of the services and their dependencies using JGraphT (cf. https://jgrapht.org/guide/HelloJGraphT)
 * TODO it would be nice to embed the resulting image into an html view
 * TODO (for future work maybe provide a complete dashboard e.g. using thymeleaf and spring)
 */
@CodeGenerationModule(name = "ServicesToGraphVizGenerator")
class GenerationModuleMicroserviceNames : AbstractCodeGenerationModule() {

    override fun getLanguageDescription(): LanguageDescription {
        return LanguageDescriptions.getLanguageDescription(IntermediatePackage.eNS_URI)!!
    }
    /**
     * This method implements the module's core logic. It has to return a (possibly empty) Map that
     * assigns a charset and file contents (value Pair) to file paths (key String).
     */
    override fun execute(
        phaseArguments: Array<String>,
        moduleArguments: Array<String>
    ): Map<String, Pair<String, Charset>> {
        // Build target file name. This has to be preceded by the specified target folder in case
        // the code generation phase is not invoked with the
        // "--allow_code_generation_outside_target_folder" commandline argument (see above).
        // getTargetFolder() retrieves the value of the "--t" commandline argument passed to an
        // AbstractModelProcessor.
        val targetFilePath: String = targetFolder.toString() + java.io.File.separator + "microservice_names.result"
        val resultFiles: MutableMap<String, String> = HashMap<String, String>()

        // Creates the Microservice Graph and stores it in the GraphCollector Singleton
        //Toy example for visualization
        GraphCollector.imageConfig = GraphCollector.ImageConfig(height = 500)
        //createExampleMicroserviceGraph()
        createMicroserviceGraph()

        // You can use the withCharset() utility method to assign a charset to all items in a Map
        // that assigns file contents (value String) to file paths (key String)
        return withCharset(resultFiles, java.nio.charset.StandardCharsets.UTF_8.name())
    }

    /**
     * Create a toy graph based on MicroserviceVertex objects.
     *
     * @return a graph based on MicroserviceVertex objects.
     */
    fun createMicroserviceGraph() {
        val modelRoot: IntermediateServiceModel = intermediateModelResource
            .getContents()
            .get(0) as IntermediateServiceModel
        // Creates a new vertex for each defined microservice in the modelRoot
        modelRoot.microservices.forEach({
            val vertex = MicroserviceVertex(it.name, it.qualifiedName, it.type)
            GraphCollector.addMicroserviceVertex(vertex)
            print(GraphCollector.createDotRepresentation())
            print(GraphCollector.createImageRepresentation(File("target/test.png")))
        })
    }



    /**
     * Create a toy graph based on MicroserviceVertex objects.
     *
     * @return a graph based on MicroserviceVertex objects.
     */
    fun createExampleMicroserviceGraph() {
        val v1 = MicroserviceVertex("Service1","qService1","FUNCTIONAL")
        val v2 = MicroserviceVertex("Service2","qService2","FUNCTIONAL")
        val v3 = MicroserviceVertex("Service3","qService3","INFRASTRUCTURE")
        val v4 = MicroserviceVertex("Service4","qService4","FUNCTIONAL")
        val v5 = MicroserviceVertex("Service5","qService5","FUNCTIONAL")
        val v6 = MicroserviceVertex("Service6","qService6","INFRASTRUCTURE")
        val v7 = MicroserviceVertex("Service7","qService7","FUNCTIONAL")
        val v8 = MicroserviceVertex("Service8","qService8","UTILITY")
        GraphCollector.addMicroserviceVertex(v1)
        GraphCollector.addMicroserviceVertex(v2)
        GraphCollector.addMicroserviceVertex(v3)
        GraphCollector.addMicroserviceVertex(v4)
        GraphCollector.addMicroserviceVertex(v5)
        GraphCollector.addMicroserviceVertex(v6)
        GraphCollector.addMicroserviceVertex(v7)
        GraphCollector.addMicroserviceVertex(v8)
        GraphCollector.addMicroserviceEdge(v1, v2, MicroserviceEdge("TestEdge1"))
        GraphCollector.addMicroserviceEdge(v2, v3, MicroserviceEdge("TestEdge2"))
        GraphCollector.addMicroserviceEdge(v3, v4, MicroserviceEdge("TestEdge3"))
        GraphCollector.addMicroserviceEdge(v4, v1, MicroserviceEdge("TestEdge4"))

        print(GraphCollector.createDotRepresentation())
        GraphCollector.createImageRepresentation(File("target/test.png"))
    }

    /**
     * Enriches the given serviceGraph with the accessible microservices from the service file of this model processing
     * as well as draws crresponding edges between vertices, i.e., microservices, based on <b>required</b> services
     * as well as imported services in the service model.

    private fun enrichGraph(serviceGraph: Graph<MicroserviceVertex, MicroserviceEdge>): Graph<MicroserviceVertex, MicroserviceEdge> {
        val test = MicroserviceVertex("Service5", MicroserviceType.UTILITY)
        serviceGraph.addVertex(test)
        val filterVertex = serviceGraph.vertexSet().filter{it.name.equals("Service2")}[0]
        serviceGraph.addEdge(filterVertex, test, MicroserviceEdge("hihiyolo"))
        return serviceGraph
    }
     */
}