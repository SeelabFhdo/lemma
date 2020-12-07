package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util
import de.fhdo.lemma.model_processing.code_generation.container_base.template.KubernetesTemplate
import java.io.File
import org.jetbrains.annotations.NotNull

/**
 * Main class of the Kubernetes deployment file generation module of the container base code
 * generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="kubernetes")
class KubernetesCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap

    @NotNull
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Create Kubernetes deployment file for container
        model.containers.forEach[container | createKuberntesFileForContainer(container)]

        // Create Kubernetes deployment file for infrastructure node
        model.infrastructureNodes.forEach[node | createKubernetesFileForInfrastructureNode(node)]

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
     * This method is responsible for creating the Kubernetes deployment file. This file is
     * generated using either a previously defined KuberntesDeployment Aspect. If the aspect does
     * not exist, a generic template based on the container configuration is created.
     */
    private def createKuberntesFileForContainer(IntermediateContainer container) {
        var aspect = container.aspects.findFirst[aspect | aspect.name == "KubernetesDeployment"]

        val serviceName = Util.buildPathFromQualifiedName(
            container.deployedServices.get(0).qualifiedName
        )

        var kubernetesFileContent = ""

        if (aspect !== null)
            kubernetesFileContent = Util::adjustIndentations("", aspect.propertyValues.get(0).value)
        else
            kubernetesFileContent = Util::adjustIndentations("",
                KubernetesTemplate::buildKubernetesFile(container))

        val filePath = '''«targetFolder»«File.separator»«serviceName»«File.separator»'''
            + '''«container.name.toLowerCase»-deployment.yml'''

        content.put(filePath, kubernetesFileContent)
    }

    /**
     * This method is responsible for creating the Kubernetes deployment file. This file is
     * generated using either a previously defined KuberntesDeployment Aspect. If the aspect does
     * not exist, a generic template based on the infrastructure node configuration is created.
     */
    private def createKubernetesFileForInfrastructureNode(IntermediateInfrastructureNode node) {
        var aspect = node.aspects.findFirst[aspect | aspect.name == "KubernetesDeployment"]

        val filePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»«File.separator»'''
            + '''«node.name.toLowerCase»--deployment.yaml'''

        if (aspect !== null)
            content.put(filePath, Util::adjustIndentations("", aspect.propertyValues.get(0).value))
        else
            content.put(filePath,
                Util::adjustIndentations("", KubernetesTemplate::buildKubernetesFile(node)))
    }
}