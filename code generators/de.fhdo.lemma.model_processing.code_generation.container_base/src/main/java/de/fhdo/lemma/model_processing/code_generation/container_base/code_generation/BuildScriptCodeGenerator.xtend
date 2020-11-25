package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.code_generation.container_base.template.BuildScriptTemplate
import de.fhdo.lemma.model_processing.code_generation.container_base.buildscript.OpenedRootBuildScript
import java.io.File
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Main class of the build script code generation module of the container base code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="buildscript")
class BuildScriptCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap

    /**
     * This method is responsible for handling the instance of the intermediate operation model.
     * The corresponding functions are called depending on whether the operation node is an instance
     * of an intermediate container or infrastructure node.
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Load existing build script from file
        OpenedRootBuildScript.instance.loadExistingRootBuildScript(targetFolder)

        // Create a build script for containers
        model.containers.forEach[container |
            val nodeName = LemmaUtils.getQualifyingParts(
                container.deployedServices?.get(0).qualifiedName
            )

            createNodeSpecificBuildScripts(nodeName.toLowerCase, container.name.toLowerCase)
            createRootBuildScript(nodeName.toLowerCase)
        ]

        // Create build script for infrastructure nodes
        model.infrastructureNodes.forEach[node |
            val imageType = node.defaultValues.findFirst[property |
                property.technologySpecificProperty.name == "imageType"]
            val nodeName = node.name.toLowerCase

            /*
             * Infrastructure nodes that have the ImageType docherhub do not require a local build
             * script, as the images are pulled directly from the official Docker repository.
             */
            if (imageType.value.toLowerCase != "dockerhub") {
                createNodeSpecificBuildScripts(nodeName, nodeName)
                createRootBuildScript(node.name.toLowerCase)
            }
        ]

        val filePath = '''«targetFolder»«File.separator»build«File.separator»build.sh'''
        content.put(filePath, OpenedRootBuildScript.instance.toString)

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
     * Create an operation node specific build script.
     */
    private def createNodeSpecificBuildScripts(String nodeName, String containerName) {
        val filePath = '''«targetFolder»«File.separator»«nodeName»«File.separator»build.sh'''
        content.put(filePath, BuildScriptTemplate::getNodeSpecificBuildScript(containerName))
    }

    /**
     * Create a root build script that uses the node specific build scripts to build all operation
     * nodes present in the intermediate operation model.
     */
    private def createRootBuildScript(String nodeName) {
        OpenedRootBuildScript.instance.addBuildCommand(nodeName,
            BuildScriptTemplate::getRootCommand(nodeName))
    }
}