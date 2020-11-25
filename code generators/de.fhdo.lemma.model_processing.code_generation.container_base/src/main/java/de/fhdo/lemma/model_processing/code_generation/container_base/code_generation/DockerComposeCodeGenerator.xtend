package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.OpenedDockerComposeFile
import java.io.File
import org.jetbrains.annotations.NotNull

/**
 * Main class of the docker-compose generation module of the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="dockercompose")
class DockerComposeCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap

    /**
     * Main method for the creation of the docker-compose file
     */
    @NotNull
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        /*
         * Set targetFolder for docker-compose.yml file and open an existing or create a new
         * docker-compose file
         */
        OpenedDockerComposeFile.instance.init(targetFolder)
        OpenedDockerComposeFile.instance.openExistingDockerComposeFile

        // Add docker-compose parts of the container to the docker compose file
        model.containers.forEach[container | createDockerComposeFile(container)]

        // Add docker-compose parts of the infrastructure node to the docker compose file
        model.infrastructureNodes.forEach[node | createDockerComposeFile(node)]

        // Write  docker-compose file to the file path
        val filePath = '''«targetFolder»«File.separator»docker-compose.yml'''
        content.put(filePath, OpenedDockerComposeFile.instance.toString)

        return withCharset(content, "UTF-8");
    }

    /**
     * Receive the language description for the intermediate operation model package.
     */
    @NotNull
    override getLanguageDescription() {
        new LanguageDescription(IntermediatePackage.eINSTANCE)
    }

    /**
     * This method adds the appropriate docker compose part to the docker-composite file, depending
     * on whether the IntermediateOperationNode has a DockerComposeAspect or not.
     */
    private def createDockerComposeFile(IntermediateOperationNode node) {
        val dockerComposeAspect = node.aspects.findFirst[aspect | aspect.name == "ComposePart"]

        if (dockerComposeAspect === null)
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node)
        else
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                dockerComposeAspect.propertyValues?.get(0).value)
    }
}