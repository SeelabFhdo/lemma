package de.fhdo.lemma.model_processing.code_generation.deployment_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.model_processing.code_generation.deployment_base.file.docker.OpenedDockerComposeFile
import org.jetbrains.annotations.NotNull
import static de.fhdo.lemma.model_processing.code_generation.deployment_base.util.Util.*

/**
 * Main class of the docker-compose generation module of the Deployment Base Generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="dockercompose")
class DockerComposeCodeGenerator extends AbstractCodeGenerationModule {
    /**
     * Main method for the creation of the docker-compose file
     */
    @NotNull
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        val model = resource.contents.get(0) as IntermediateOperationModel

        /*
         * Set targetFolder for docker-compose.yaml file and open an existing or create a new
         * docker-compose file
         */
        OpenedDockerComposeFile.instance.init(targetFolder)
        OpenedDockerComposeFile.instance.openExistingDockerComposeFile

        // Add docker-compose parts of the container to the docker compose file
        getContainersWithDeploymentBaseTechnology(model).forEach[createDockerComposeFile(it)]

        // Add docker-compose parts of the infrastructure node to the docker compose file
        getInfrastructureNodesWithDeploymentBaseTechnology(model)
            .forEach[createDockerComposeFile(it)]

        // Write  docker-compose file to the file path
        val filePath = OpenedDockerComposeFile.instance.dockerComposePath
        return withCharset(#{filePath -> OpenedDockerComposeFile.instance.toString}, "UTF-8");
    }

    /**
     * Receive the language namespace for the intermediate operation model package.
     */
    @NotNull
    override getLanguageNamespace() {
        IntermediatePackage.eNS_URI
    }

    /**
     * This method adds the appropriate docker compose part to the docker-composite file, depending
     * on whether the IntermediateOperationNode has a DockerComposeAspect or not.
     */
    private def createDockerComposeFile(IntermediateOperationNode node) {
        val dockerComposeAspect = getFirstAspectApplication(node, "ComposePart")
        if (dockerComposeAspect === null)
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node)
        else
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                dockerComposeAspect.propertyValues?.get(0).value)
    }
}