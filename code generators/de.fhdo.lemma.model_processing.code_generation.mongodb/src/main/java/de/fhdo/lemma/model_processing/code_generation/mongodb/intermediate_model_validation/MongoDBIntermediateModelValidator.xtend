package de.fhdo.lemma.model_processing.code_generation.mongodb.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.model_processing.code_generation.mongodb.code_generation.MongoDBCodeGenerator

/**
 * The MongoDB intermediate model validator is responsible for checking general aspects for
 * the MongoDB code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class MongoDBIntermediateModelValidator extends AbstractIntermediateDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if the container depends on an infrastructure node with a MongoDB technology model
     */
    @Check
    def checkMongoDBTechnologyForContainer(IntermediateContainer container) {
        val mongoDBTechnology = container.dependsOnNodes.exists[
            it.qualifiedTechnologyName.toLowerCase == MongoDBCodeGenerator.MONGODB_TECHNOLOGY]

        if(!mongoDBTechnology)
            warning('''No supported technology model found for container «container.name»''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if the infrastructure node uses a MongoDB technology model
     */
    @Check
    def checkMongoDBTechnologyForInfrastructureNode(IntermediateInfrastructureNode node) {
        if(node.qualifiedInfrastructureTechnologyName.toLowerCase !=
            MongoDBCodeGenerator.MONGODB_TECHNOLOGY)
            warning('''No supported technology model found for InfrastructureNode «node.name».''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }
}
