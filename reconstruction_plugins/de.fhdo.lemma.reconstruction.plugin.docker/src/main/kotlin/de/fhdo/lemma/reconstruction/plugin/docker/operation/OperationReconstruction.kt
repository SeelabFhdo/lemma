package de.fhdo.lemma.reconstruction.plugin.docker.operation

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.ReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.ReconstructionStage
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.lemma.reconstruction.framework.plugins.ParsingResultType
import de.fhdo.lemma.reconstruction.plugin.docker.operation.container.Container
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream

/**
 * A reconstruction module for the docker reconstruction plugin. It is used to extract information
 * from Docker-Compose files and saves it to reconstruction elements, such as a [Container].
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
@ReconstructionModule(ReconstructionStage.Operation)
class OperationReconstruction: AbstractReconstructionModule() {
    /**
     * Main method of the reconstruction module. The method extracts information from a parse tree
     * and saves it to a reconstruction element, such as a [Container].
     */
    override fun execute(abstractParseTree: AbstractParseTree) :
        List<AbstractReconstructionElement> {
        val reconstructedElements = mutableListOf<AbstractReconstructionElement>()
        val dockerParseFile = abstractParseTree as DockerParseFile
        //todo: Change the example logic to a proper version for the extraction information
        dockerParseFile.parseFile.entries.forEach { entry ->
            if (entry.key == "services") {
                val entries = entry.value as LinkedHashMap<*, *>
                entries.keys.forEach{key ->
                    val container = Container(key.toString())
                    reconstructedElements.add(container)
                }
            }
        }
        return reconstructedElements
    }

    /**
     * Create a parse tree based on a file path. This method provides the parse tree used by the
     * execute method.
     */
    override fun getParseTree(path: String) : Pair<ParsingResultType, AbstractParseTree> {
        val inputStream = FileInputStream(File(path))
        val yaml = Yaml()
        val data = yaml.load(inputStream) as LinkedHashMap<String, Any>
        val dockerParseFile = DockerParseFile(path, data)
        return Pair(ParsingResultType.FULLY_PARSED, dockerParseFile)
    }

    /**
     * Return file extension for supported file types.
     */
    override fun getSupportFileExtensions() : List<String> {
        return listOf("yaml", "yml")
    }
}