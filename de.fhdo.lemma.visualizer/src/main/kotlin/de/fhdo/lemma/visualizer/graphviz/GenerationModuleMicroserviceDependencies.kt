package de.fhdo.lemma.visualizer.graphviz

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import java.nio.charset.Charset
import java.util.stream.Collectors
import kotlin.Pair

/**
 * TODO documentation
 * TODO How to call multiple models into the process?!
 * TODO build a graph of the services and their dependencies using JGraphT (cf. https://jgrapht.org/guide/HelloJGraphT)
 * TODO By calling the toString() method on the graph a DOT-String (Graph desc language) can be created
 * TODO This string should be readable by GraphViz and thus easily create a Graph
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

        /* Create sample result files' contents */try {
            resultFiles.put(targetFilePath, createSampleOutput())
        } catch (ex: ClassCastException) {
            // NOOP: May happen if passed intermediate model does not have the expected type
        }

        // You can use the withCharset() utility method to assign a charset to all items in a Map
        // that assigns file contents (value String) to file paths (key String)
        return withCharset(resultFiles, java.nio.charset.StandardCharsets.UTF_8.name())
    }

    /**
     * Create some sample code generation output. In this case, the input model will be traversed
     * for the names of all contained microservices.
     */
    private fun createSampleOutput(): String {
        // You can retrieve the input model's EMF Resource via getIntermediateModelResource()
        val modelRoot: IntermediateServiceModel = intermediateModelResource
            .getContents()
            .get(0) as IntermediateServiceModel
        val modeledMicroserviceNames: List<String> = modelRoot.getMicroservices()
            .stream()
            .map { s -> s.getName() }
            .sorted()
            .collect(Collectors.toList())
        return modeledMicroserviceNames.stream().collect(Collectors.joining("\n"))
    }
}