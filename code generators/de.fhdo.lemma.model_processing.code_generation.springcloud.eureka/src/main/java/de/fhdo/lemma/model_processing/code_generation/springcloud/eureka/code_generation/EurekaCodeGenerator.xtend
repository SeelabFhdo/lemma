package de.fhdo.lemma.model_processing.code_generation.springcloud.eureka.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util
import java.nio.file.Paths
import java.io.File
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.OpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.SortableProperties
import java.io.ByteArrayInputStream
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.eureka.template.EurekaTemplate
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.OpenedDockerComposeFile

/**
 * Main class of the Spring Cloud Eureka code generation module of the Spring Cloud Eureka code
 * generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="eureka")
class EurekaCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap
    public static val EUREKA_TECHNOLOGY = "eureka.eureka"

    /**
     * This method is responsible for handling the instance of the intermediate operation model.
     * The corresponding functions are called depending on whether the operation node is an instance
     * of an intermediate container or infrastructure node.
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Create container-specific configurations
        model.containers.forEach[
            val dependsOnEureka = it.dependsOnNodes.exists[it.name.toLowerCase == "eureka"]

            if (dependsOnEureka)
                createContainerSpecificConfiguration(it)
        ]

        // Eureka infrastructure node-specific components
        model.infrastructureNodes.forEach[
            val usesEurekaTechnology =
                it.qualifiedInfrastructureTechnologyName.toLowerCase == EUREKA_TECHNOLOGY

            if (usesEurekaTechnology) {
                createEurekaKubernetesDeployment(it)
                createDockerComposeDeployment(it)
                createEurekaComponents(it)
            }
        ]

        // Create application.properties files
        OpenedPropertyFiles.instance.propertyFiles.forEach[
            content.put(it.filePath, it.buildPropertyFile)
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
     * Create container specific Eureka configuration for each deployed Spring-based microservice.
     */
    private def createContainerSpecificConfiguration(IntermediateContainer container) {
        container.deployedServices.forEach[createServiceSpecificConfiguration(it)]
    }

    /**
     * Create the Eureka service-specific configuration in the application.properties    file.
     */
    private def createServiceSpecificConfiguration(OperationMicroserviceReference service) {
        val serviceFilePath = Util.buildPathFromQualifiedName(service.qualifiedName)

        // FIXME: This statement only supports Java or Kotlin microservices with the Spring Framework
        val path = Paths.get('''«targetFolder»«File.separator»«serviceFilePath»«File.separator»''' +
            '''/src/main/resources/application.properties''')

        /*
         * Load existing PropertyFile from the file path and merge it with a potentially existing
         * PropertyFile.
         */
        val loadedFile = OpenedPropertyFiles.instance.openPropertyFile(path.toString)
        val mergedLoadedyFile = OpenedPropertyFiles.instance.mergePropertyFile(loadedFile)
        OpenedPropertyFiles.instance.add(mergedLoadedyFile)

        /*
         * Create a PropertyFile based on the intermediate operation model configuration and merge
         * it with the potentially existing one.
         */
        val serviceConfig = service.node.getEffectiveConfigurationValues(service)
        val eurekaConfig = EurekaTemplate::getPropertiesForEurekaServiceConfig(serviceConfig)
        val properties = new SortableProperties
        properties.load(new ByteArrayInputStream(eurekaConfig.getBytes()))
        val propertyFile = new PropertyFile(path.toString, properties)
        val mergedFile = OpenedPropertyFiles.instance.mergePropertyFile(propertyFile)
        OpenedPropertyFiles.instance.add(mergedFile)
    }

    /**
     * Create an IntermediateInfrastructure-specific Kubernetes deployment file.
     */
    private def createEurekaKubernetesDeployment(IntermediateInfrastructureNode node) {
        val kubernetes = EurekaTemplate::getKubernetesDeploymentForEureka(node)
        val path = '''«targetFolder»«File.separator»«node.name»«File.separator»''' +
            '''«node.name.toLowerCase»-deployment.yaml'''

        content.put(path, kubernetes)
    }

    /**
     * Create an IntermediateOperationNode-specific Docker-Compose deployment file.
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
                EurekaTemplate::getDockerComposeForEureka(node))
        else
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                dockerComposeAspect.propertyValues?.get(0).value)

        // Write Docker-Compose file to the file path
        val filePath = '''«targetFolder»«File.separator»docker-compose.yml'''
        content.put(filePath, OpenedDockerComposeFile.instance.toString)
    }

    /**
     * Generate Eureka infrastructure node based on the spring cloud framework implemented in
     * Kotlin.
     */
    private def createEurekaComponents(IntermediateInfrastructureNode node) {
        val programmingLanguage = node.defaultValues.findFirst[
            it.technologySpecificProperty.name.toLowerCase == "programminglanguage"]

        switch (programmingLanguage.value.toLowerCase) {
            case "java" : {
                // Generate pom.xml file for Java
                val pomFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                '''«File.separator»pom.xml'''
                content.put(pomFilePath, EurekaTemplate.generatePOMFileForJava(node))

                // Generate main class for the Spring-based Eureka implementation in Java
                val mainFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                    buildEurekaFilePath(node, "java") + ".java"
                content.put(mainFilePath, EurekaTemplate::generateEurekaApplicationFileInJava(node))
            }
            case "kotlin" : {
                // Generate pom.xml file
                val pomFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                '''«File.separator»pom.xml'''
                content.put(pomFilePath, EurekaTemplate.generatePOMFileForKotlin(node))

                // Generate main class for the Spring-based Eureka implementation in Kotlin
                val mainFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
                    buildEurekaFilePath(node, "kotlin") + ".kt"
                content.put(mainFilePath,
                    EurekaTemplate::generateEurekaApplicationFileInKotlin(node))
            }
            default : new Exception("Unsupported programming language for Eureka.")
        }

        // Generate Spring-based application.properties file
        val propertiesFilePath = '''«targetFolder»«File.separator»«node.name.toLowerCase»''' +
            '''«File.separator»src«File.separator»main«File.separator»resources«File.separator»''' +
            "application.properties"
        content.put(propertiesFilePath, EurekaTemplate::generateApplicationPropertyFile(node))
    }

    /**
     * Build Eureka file path based on the service specific property groupId
     */
    private def String buildEurekaFilePath(IntermediateInfrastructureNode node, String language) {
        val property = node.defaultValues.findFirst[
            it.technologySpecificProperty.name.toLowerCase == "mavengroupid"
        ]
        val groupIdPath = property.value.replaceAll("\\.", File.separator).toLowerCase

        val path = '''«File.separator»src«File.separator»main«File.separator»«language»''' +
            '''«File.separator»«groupIdPath»«File.separator»«node.name.toFirstUpper»''' +
            "Application"

        path
    }
}