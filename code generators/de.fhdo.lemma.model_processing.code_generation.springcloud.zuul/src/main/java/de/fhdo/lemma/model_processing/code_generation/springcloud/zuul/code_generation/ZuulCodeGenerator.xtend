package de.fhdo.lemma.model_processing.code_generation.springcloud.zuul.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.zuul.template.ZuulTemplate
import java.io.File
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.OpenedDockerComposeFile

/**
 * Main class of the Spring Cloud Zuul code generation module of the Spring Cloud Zuul code
 * generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="zuul")
class ZuulCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap
    public static val ZUUL_TECHNOLOGY = "zuul.zuul"

    /**
     * This method is responsible for handling the instance of the intermediate operation model.
     * The corresponding functions are called depending on whether the operation node is an instance
     * of an intermediate container or infrastructure node.
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Create infrastructure node-specific Zuul components
        model.infrastructureNodes.forEach[
            val usesZuulTechnology =
                it.qualifiedInfrastructureTechnologyName.toLowerCase == ZUUL_TECHNOLOGY

            if (usesZuulTechnology) {
                createZuulKubernetesDeployment(it)
                createDockerComposeDeployment(it)
                createZuulComponents(it)
            }
        ]

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
     * Create an infrastructure node-specific Kubernetes deployment file for Zuul.
     */
    private def createZuulKubernetesDeployment(IntermediateInfrastructureNode node) {
        val kubernetes = ZuulTemplate::getKubernetesDeploymentForZuul(node)
        val path = '''«targetFolder»«File.separator»«node.name»«File.separator»''' +
            '''«node.name.toLowerCase»-deployment.yaml'''

        content.put(path, kubernetes)
    }

    /**
     * Create an  infrastructure node-specific Docker-Compose deployment file for Zuul.
     */
    private def createDockerComposeDeployment(IntermediateInfrastructureNode node) {
        /*
         * Set targetFolder for Docker-Compose file and open an existing or create a new
         * Docker-Compose file
         */
        OpenedDockerComposeFile.instance.init(targetFolder)
        OpenedDockerComposeFile.instance.openExistingDockerComposeFile

        // Build Docker-Compose part based on a operation aspect or node configuration
        val dockerComposeAspect = node.aspects.findFirst[aspect | aspect.name == "ComposePart"]
        if (dockerComposeAspect === null)
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                ZuulTemplate::getDockerComposeForZuul(node))
        else
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                dockerComposeAspect.propertyValues?.get(0).value)

        // Write Docker-Compose file to the file path
        val filePath = '''«targetFolder»«File.separator»docker-compose.yml'''
        content.put(filePath, OpenedDockerComposeFile.instance.toString)
    }

    /**
     * Generate a Zuul infrastructure node based on the Spring Cloud framework implemented in
     * Kotlin.
     */
    private def createZuulComponents(IntermediateInfrastructureNode node) {
        val programmingLanguage = node.defaultValues.findFirst[
            it.technologySpecificProperty.name.toLowerCase == "programminglanguage"]

        switch (programmingLanguage.value.toLowerCase) {
            case "java" : {
                // Generate pom.xml file for Java
                val pomFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                '''«File.separator»pom.xml'''
                content.put(pomFilePath, ZuulTemplate.generatePOMFileForJava(node))

                // Generate main class for the Spring-based Zuul implementation in Java
                val mainFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                    buildZuulFilePath(node, "java") + ".java"
                content.put(mainFilePath, ZuulTemplate::generateZuulApplicationFileInJava(node))
            }
            case "kotlin" : {
                // Generate pom.xml file
                val pomFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                '''«File.separator»pom.xml'''
                content.put(pomFilePath, ZuulTemplate.generatePOMFileForKotlin(node))

                // Generate main class for the Spring-based Zuul implementation in Kotlin
                val mainFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                    buildZuulFilePath(node, "kotlin") + ".kt"
                content.put(mainFilePath, ZuulTemplate::generateZuulApplicationFileInKotlin(node))
            }
            default : new Exception("Unsupported programming language for Zuul.")
        }

        // Generate Spring-based application.properties file
        val propertiesFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
            '''«File.separator»src«File.separator»main«File.separator»resources«File.separator»''' +
            "application.properties"
        content.put(propertiesFilePath, ZuulTemplate::generateApplicationPropertyFile(node))
    }

    /**
     * Build Zuul file path based on the service specific property groupId
     */
    private def String buildZuulFilePath(IntermediateInfrastructureNode node, String language) {
        val property = node.defaultValues.findFirst[
            it.technologySpecificProperty.name.toLowerCase == "mavengroupid"
        ]
        val groupIdPath = property.value.replaceAll("\\.", File.separator).toLowerCase

        val path = '''«File.separator»src«File.separator»main«File.separator»«language»''' +
            '''«File.separator»«groupIdPath»«File.separator»«node.name.toFirstUpper»''' +
            '''Application'''

        path
    }
}