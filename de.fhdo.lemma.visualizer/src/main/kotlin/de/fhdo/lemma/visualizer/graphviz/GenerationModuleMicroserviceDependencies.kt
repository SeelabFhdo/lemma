package de.fhdo.lemma.visualizer.graphviz

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.visualizer.fullyQualifiedName
import de.fhdo.lemma.visualizer.graphviz.commandline.ModuleCommandLine
import de.fhdo.lemma.visualizer.graphviz.exceptions.ModuleException
import de.fhdo.lemma.visualizer.model.*
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph
import java.io.File
import java.net.URI
import java.nio.charset.Charset
import java.nio.file.Paths
import kotlin.collections.HashMap

/**
 * TODO documentation
 * TODO How to call multiple models into the process?! -> Maybe invoke the model processor FOR EACH MODEL and collect all the resulting vertices and edges as return values?
 * TODO build a graph of the services and their dependencies using JGraphT (cf. https://jgrapht.org/guide/HelloJGraphT)
 * TODO it would be nice to embed the resulting image into an html view
 * TODO (for future work maybe provide a complete dashboard e.g. using thymeleaf and spring)
 *
 * TODO How to connect subgraphs: https://stackoverflow.com/questions/2012036/graphviz-how-to-connect-subgraphs
 * PROBLEM DOTExporter of JGraphT does not allow Subgraphs which would be needed to model e.g. interfaces as seperate entities
 * Possible way to fix this is to exchange JGraphT or change the visualization.
 * https://stackoverflow.com/questions/57820898/creating-graph-with-clusters-using-jgrapht
 */
@CodeGenerationModule(name = "ServicesToGraphVizGenerator")
class GenerationModuleMicroserviceNames : AbstractCodeGenerationModule() {

    /**
     * The graph which is populated during model processing and later on can be used to generate an image.
     */
    val microserviceGraph: Graph<MicroserviceVertex, MicroserviceEdge> =
        DefaultDirectedGraph(MicroserviceEdge::class.java)

    val visitedMicroservices: MutableMap<String, MicroserviceVertex> = mutableMapOf()
    val discoveredEdges: MutableList<Pair<String, String>> = mutableListOf()
    val processedServiceModels: MutableList<URI> = mutableListOf()

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
        val resultFiles: MutableMap<String, String> = HashMap()
        with(ModuleCommandLine) {
            try {
                invoke(moduleArguments)
            } catch (ex: java.lang.Exception) {
                throw ModuleException(ex.message)
            }
        }

        //Toy example for visualization
        createExampleMicroserviceGraph()

        //Initial parsing run where the intermediateModelResource from the code generation phase
        //is added to the graph
        val initialModel: IntermediateServiceModel = intermediateModelResource
            .getContents()
            .get(0) as IntermediateServiceModel

        // Populates the Microservice Graph with values from initialModel
        populateMicroserviceGraph(initialModel)
        // if there are service files which were not reached through the recursion
        // in createMicroserviceGraph() those are treated here
        ModuleCommandLine.models?.forEach {
            val str = Paths.get(ModuleCommandLine.intermediatePath.toString(), it.toString()).toString()
            val resource = str.asXmiResource()
            val model = resource.contents.get(0) as IntermediateServiceModel
            if (!processedServiceModels.contains(model.sourceModelUri)) {
                populateMicroserviceGraph(model)
            }
        }
        //Draws the discovered edges during the popluateGraph stage.
        //Currently only required microservices of a microservice are discovered as edges.
        drawEdges()
        println(createDotRepresentation(DetailLevel.SERVICES))
        createImageRepresentation(ImageConfig(height = 2000, format = Format.PNG), File("target/test.png"), DetailLevel.OPERATIONS)
        // You can use the withCharset() utility method to assign a charset to all items in a Map
        // that assigns file contents (value String) to file paths (key String)
        return withCharset(resultFiles, java.nio.charset.StandardCharsets.UTF_8.name())
    }

    private fun drawEdges() {
        discoveredEdges.forEach({
            microserviceGraph.addEdge(
                visitedMicroservices.get(it.first),
                visitedMicroservices.get(it.second),
                MicroserviceEdge("requires")
            )
        })


    }

    /**
     * Create a graph of MicroserviceVertex and MicroserviceEdges objects based on the modelRoot.
     *
     * @return a graph based on MicroserviceVertex objects.
     */
    private fun populateMicroserviceGraph(modelRoot : IntermediateServiceModel) {
        if (!processedServiceModels.contains(modelRoot.sourceModelUri)) {
            // mark as already processed
            processedServiceModels.add(URI(modelRoot.sourceModelUri))
            //traverse services of model file
            modelRoot.microservices.forEach({
                if (!visitedMicroservices.contains(it.qualifiedName)) {
                    visitMicroserviceVertex(it)
                }
            })
            // iterative parsing of discovered imports
            modelRoot.imports.filter { it.importTypeName == "MICROSERVICES" }.forEach({
                recursiveImportProcessing(it)
            })
        }
    }

    private fun recursiveImportProcessing(intermediateImport: IntermediateImport) {
        // Apparently there is some kind of bug going when the importUri already starts with the file:// and contains
        // a whitespace. In such cases the Uri is parsed as a relative uri instead of an absolute one.
        // Therefore, the first 7 chars are manually removed.
        val resource = intermediateImport.importUri.removeRange(0, 7).asXmiResource()
        val model = resource.contents.get(0) as IntermediateServiceModel
        if (!processedServiceModels.contains(model.sourceModelUri)) {
            model.microservices.forEach({
                visitMicroserviceVertex(it)
            })
            processedServiceModels.add(URI(model.sourceModelUri))
            model.imports.filter { it.importTypeName == "MICROSERVICES" }.forEach({
                // traverse each microservice import
                recursiveImportProcessing(it)
            })
        }
    }

    private fun visitMicroserviceVertex(service: IntermediateMicroservice): MicroserviceVertex {
        val newVertex = MicroserviceVertex(service.visibility, service.name, service.fullyQualifiedName(), service.type)
        visitedMicroservices.put(service.fullyQualifiedName(), newVertex)
        // remember edges which need to be drawn later
        service.requiredMicroservices.forEach({
            if(it.isImported) {
                discoveredEdges.add(Pair(service.fullyQualifiedName(), it.fullyQualifiedName()))
            } else {
                discoveredEdges.add(Pair(service.fullyQualifiedName(), it.localMicroservice.fullyQualifiedName()))
            }

        })
        if (!service.interfaces.isEmpty()) {
            service.interfaces.forEach({
                val iface = InterfaceSubVertex(it.name, it.visibility)
                it.operations.forEach({
                    val op = OperationSubVertex(it.name, it.visibility)
                    it.parameters.forEach({
                        val param = ParameterSubVertex(it.communicationType, it.name, it.type.name)
                        op.parameters.add(param)
                    })
                    iface.operations.add(op)
                })
                newVertex.interfaces.add(iface)
            })
        }
        microserviceGraph.addVertex(newVertex)
        return newVertex
    }

    /**
     * Create a toy graph based on MicroserviceVertex objects.
     *
     * @return a graph based on MicroserviceVertex objects.
     */
    private fun createExampleMicroserviceGraph() {
        val v1 = MicroserviceVertex("+", "Service1", "qService1", "FUNCTIONAL", "test technology")
        val v2 = MicroserviceVertex("+", "Service2", "qService2", "FUNCTIONAL")
        val v3 = MicroserviceVertex("+", "Service3", "qService3", "INFRASTRUCTURE")
        val v4 = MicroserviceVertex("+", "Service4", "qService4", "FUNCTIONAL")
        val v5 = MicroserviceVertex("+", "Service5", "qService5", "FUNCTIONAL")
        val v6 = MicroserviceVertex("+", "Service6", "qService6", "INFRASTRUCTURE")
        val v7 = MicroserviceVertex("+", "Service7", "qService7", "FUNCTIONAL")
        val v8 = MicroserviceVertex("+", "Service8", "qService8", "UTILITY")
        microserviceGraph.addVertex(v1)
        microserviceGraph.addVertex(v2)
        microserviceGraph.addVertex(v3)
        microserviceGraph.addVertex(v4)
        microserviceGraph.addVertex(v5)
        microserviceGraph.addVertex(v6)
        microserviceGraph.addVertex(v7)
        microserviceGraph.addVertex(v8)
        microserviceGraph.addEdge(v1, v2, MicroserviceEdge("TestEdge1"))
        microserviceGraph.addEdge(v2, v3, MicroserviceEdge("TestEdge2"))
        microserviceGraph.addEdge(v3, v4, MicroserviceEdge("TestEdge3"))
        microserviceGraph.addEdge(v4, v1, MicroserviceEdge("TestEdge4"))
    }

    private fun createDotRepresentation(details : DetailLevel?): String {
        return GraphUtil.exportDotFromGraph(microserviceGraph, details)
    }

    // it would also be possible to use JGraphX for visualization. Might be worth checking?
    private fun createImageRepresentation(imageConfig: ImageConfig, path: File, details : DetailLevel?) {
        if (imageConfig.height == null && imageConfig.width == null)
            Graphviz.fromString(createDotRepresentation(details))
                .render(imageConfig.format).toFile(path)
        if (imageConfig.height != null && imageConfig.width != null)
            Graphviz.fromString(createDotRepresentation(details))
                .height(imageConfig.height!!).width(imageConfig.width!!).render(imageConfig.format).toFile(path)
        if (imageConfig.height != null && imageConfig.width == null)
            Graphviz.fromString(createDotRepresentation(details)).height(imageConfig.height!!)
                .render(imageConfig.format).toFile(path)
        if (imageConfig.height == null && imageConfig.width != null)
            Graphviz.fromString(createDotRepresentation(details)).width(imageConfig.width!!)
                .render(imageConfig.format).toFile(path)
    }


}

