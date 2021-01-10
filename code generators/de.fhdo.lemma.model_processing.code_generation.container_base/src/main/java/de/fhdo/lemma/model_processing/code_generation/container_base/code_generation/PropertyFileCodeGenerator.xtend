package de.fhdo.lemma.model_processing.code_generation.container_base.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
import de.fhdo.lemma.model_processing.code_generation.container_base.template.PropertyFileTemplate
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.SortableProperties
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.PropertyFile
import java.nio.file.Paths
import java.io.File
import java.io.ByteArrayInputStream
import org.jetbrains.annotations.NotNull
import de.fhdo.lemma.model_processing.code_generation.container_base.file.property.OpenedPropertyFiles
import de.fhdo.lemma.model_processing.code_generation.container_base.util.Util

/**
 * Main class of the spring based service property file generation module of the container base code
 * generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="propertyfile")
class PropertyFileCodeGenerator extends AbstractCodeGenerationModule{
    var IntermediateOperationModel model
    val content = <String, String> newHashMap

    @NotNull
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = intermediateModelResource.contents.get(0) as IntermediateOperationModel

        // Generate all container
        model.containers.forEach [container |
            createDeployedMicroservice(container.deployedServices?.get(0))]

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
     * This method is responsible for the creation of the application.properties file.
     * The file includes IntermediateTechnologySpecificValues for the deployed microservice,
     * e.g., the database oder service discovery configuration
     */
    private def createDeployedMicroservice(OperationMicroserviceReference service) {
        val property = PropertyFileTemplate::getPropertiesForServiceConfiguration(
                service.node.getEffectiveConfigurationValues(service))
        val buildPath =  Util.buildPathFromQualifiedName(service.qualifiedName)

        addConfigurationToPropertyFile(buildPath, property)
    }

    /**
     * This method adds the configuration parameters from the operation model to the actual
     * spring based service configuration. Existing configuration parameters will remain unchanged,
     * unless a configuration parameter is also defined in the operation model. In this case, the
     * existing configuration will be replaced with the configuration from the operation model.
     */
    private def addConfigurationToPropertyFile(String nodeName, String config) {
        // TODO: This statement only support Java or Kotlin microservices with the Spring Framework
        val path = Paths.get('''«targetFolder»«File.separator»«nodeName»«File.separator»'''
            + '''/src/main/resources/application.properties''')

        /*
         * Load existing PropertyFile from the file path and merge it with a potential existing
         * PropertyFile.
         */
        val loadedFile = OpenedPropertyFiles.instance.openPropertyFile(path.toString)
        val mergedLoadedyFile = OpenedPropertyFiles.instance.mergePropertyFile(loadedFile)
        OpenedPropertyFiles.instance.add(mergedLoadedyFile)

        /*
         * Create a PropertyFile based on the intermediate operation model configuration and merge
         * it with the potential existing one.
         */
        val properties = new SortableProperties
        properties.load(new ByteArrayInputStream(config.getBytes()))
        val propertyFile = new PropertyFile(path.toString, properties)
        val mergedFile = OpenedPropertyFiles.instance.mergePropertyFile(propertyFile)
        OpenedPropertyFiles.instance.add(mergedFile)
    }
}