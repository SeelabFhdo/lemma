package de.fhdo.lemma.model_processing.code_generation.springcloud.cloud_config.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import org.jetbrains.annotations.NotNull


/**
 * Main class of the Spring Cloud Config code generation module.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@CodeGenerationModule(name="eureka")
class CloudConfigCodeGenerator extends AbstractCodeGenerationModule {
    var IntermediateOperationModel model
    val content = <String, String> newHashMap
    public static val CONFIG_TECHNOLOGY = "config.config"


    /**
     * This method is responsible for handling the instance of the intermediate operation model.
     * The corresponding functions are called depending on whether the operation node is an instance
     * of an intermediate container or infrastructure node.
     */
    override execute(String[] phaseArguments, String[] moduleArguments) {
        // Receive the intermediate operation model
        model = resource.contents.get(0) as IntermediateOperationModel
		val containerNameList = <String> newLinkedList
        // Create container-specific configurations
        model.containers.forEach[
			containerNameList.add(it.name)
        ]
		content.put("/gen", containerNameList.toString)


        return withCharset(content, "UTF-8");
    }

    /**
     * Receive the language namespace for the intermediate operation model package.
     */
    @NotNull
    override getLanguageNamespace() {
        IntermediatePackage.eNS_URI
    }


}