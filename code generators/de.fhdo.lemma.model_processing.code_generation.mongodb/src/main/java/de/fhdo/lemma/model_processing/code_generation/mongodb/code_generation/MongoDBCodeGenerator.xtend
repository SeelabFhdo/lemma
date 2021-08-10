package de.fhdo.lemma.model_processing.code_generation.mongodb.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.code_generation.mongodb.template.MongoDBTemplate
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.OpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.OpenedDockerComposeFile
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
import java.io.File
import java.nio.file.Paths
import java.io.ByteArrayInputStream
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.model_processing.code_generation.container_base.file.docker.DockerComposeService

/**
 * Main class of the MongoDB code generation module of the MongoDB code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="mongodb")
class MongoDBCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap
    public static val MONGODB_TECHNOLOGY = "mongodb.mongodb"

    /**
     * This method is responsible for handling the instance of the intermediate operation model.
     * The corresponding functions are called depending on whether the operation node is an instance
     * of an intermediate container or infrastructure node.
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = resource.contents.get(0) as IntermediateOperationModel

        // Create service-specific MongoDB configurations
        model.containers.forEach[
            val dependsOnMongoDB = it.dependsOnNodes.exists[it.qualifiedTechnologyName.toLowerCase
                == MONGODB_TECHNOLOGY]

            if (dependsOnMongoDB)
                createContainerSpecificConfiguration(it)
        ]

        // Create MongoDB components, e.g., docker-compose parts and Kubernetes deployments
        model.infrastructureNodes.forEach[node |
            if (node.qualifiedInfrastructureTechnologyName.toLowerCase == MONGODB_TECHNOLOGY) {
                createMongoDBKubernetesDeployment(node)
                createDockerComposeDeployment(node)
            }
        ]

        // Create application.properties files
        OpenedPropertyFiles.instance.propertyFiles.forEach[
            content.put(it.filePath, it.buildPropertyFile)
        ]

        return withCharset(content, "UTF-8");
    }

    /**
     * Receive the language namespace for the intermediate operation model package.
     */
    @NotNull
    override getLanguageNamespace() {
        IntermediatePackage.eNS_URI
    }

    /**
     * Create container specific MongoDB configuration for each deployed Spring-based microservice.
     */
    private def createContainerSpecificConfiguration(IntermediateContainer container) {
        container.deployedServices.forEach[createServiceSpecificConfiguration(it)]
    }

    /**
     * Create the MongoDB service-specific configuration in the application.properties file
     */
    private def createServiceSpecificConfiguration(OperationMicroserviceReference service) {
        val serviceFilePath = Util.buildPathFromQualifiedName(service.qualifiedName)

        // TODO: This statements only support Java or Kotlin microservices with the Spring Framework
        val path = Paths.get('''«targetFolder»«File.separator»«serviceFilePath»«File.separator»''' +
            '''/src/main/resources/application.properties''').toString

        /*
         * Load existing PropertyFile from the file path and merge it with a potentially existing
         * PropertyFile.
         */
        val loadedFile = OpenedPropertyFiles.instance.openPropertyFile(path)
        val mergedLoadedyFile = OpenedPropertyFiles.instance.mergePropertyFile(loadedFile)
        OpenedPropertyFiles.instance.add(mergedLoadedyFile)

        /*
         * Create a PropertyFile based on the intermediate operation model configuration and merge
         * it with the potentially existing one.
         */
        val serviceConfig = service.node.getEffectiveConfigurationValues(service)
        val mongoDBConfig = MongoDBTemplate::getPropertiesForMongoDBServiceConfig(serviceConfig)
        val properties = new SortableProperties
        properties.load(new ByteArrayInputStream(mongoDBConfig.getBytes()))
        val propertyFile = new PropertyFile(path, properties)
        val mergedFile = OpenedPropertyFiles.instance.mergePropertyFile(propertyFile)
        OpenedPropertyFiles.instance.add(mergedFile)
    }

    /**
     * Create MongoDB Kubernetes Deployment file.
     */
    private def createMongoDBKubernetesDeployment(IntermediateInfrastructureNode node) {
        val kubernetes = MongoDBTemplate::getKubernetesDeploymentForMongoDB(node)
        val path = '''«targetFolder»«File.separator»«node.name»«File.separator»''' +
            '''«node.name.toLowerCase»-deployment.yaml'''
        content.put(path, kubernetes)
    }

    /**
     * Create a IntermediateOperationNode-specific Docker-Compose deployment file.
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
            OpenedDockerComposeFile.instance.dockerComposeFile.services.put(node.name,
                createComposeService(node)
            )
        else
            OpenedDockerComposeFile.instance.addOrReplaceDockerComposePart(node.name,
                dockerComposeAspect.propertyValues?.get(0).value)

        // Write  Docker-Compose file to the file path
        val filePath = OpenedDockerComposeFile.instance.dockerComposePath
        content.put(filePath, OpenedDockerComposeFile.instance.toString)
    }

    /**
     * Create a DockerComposeService instance for a MongoDB.
     */
    private def DockerComposeService createComposeService(IntermediateInfrastructureNode node) {
        val service = OpenedDockerComposeFile.instance.getServiceFromNode(node)
        node.defaultValues.forEach[
            if (it.technologySpecificProperty.name.toLowerCase == "username")
                service.environment.put("MONGO_INITDB_ROOT_USERNAME", it.value)

            if (it.technologySpecificProperty.name.toLowerCase == "password")
                service.environment.put("MONGO_INITDB_ROOT_PASSWORD", it.value)

            if (it.technologySpecificProperty.name.toLowerCase == "database")
                service.environment.put("MONGO_INITDB_DATABASE", it.value)
        ]
        service.build = null
        service.image= "mongo"
        return service
    }
}