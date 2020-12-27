package de.fhdo.lemma.model_processing.code_generation.mariadb.intermediate_model_validation

import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import de.fhdo.lemma.operation.intermediate.IntermediateContainer
import org.eclipse.xtext.validation.Check
import de.fhdo.lemma.model_processing.code_generation.mariadb.code_generation.MariaDBCodeGenerator

/**
 * The MariaDB intermediate model validator is responsible for checking general aspects for
 * the MariaDB code generator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@IntermediateModelValidator
class MariaDBIntermediateModelValidator extends AbstractIntermediateDeclarativeValidator {
    /**
     * Get the namespace for the intermediate operation model
     */
    override getLanguageNamespace() {
        return IntermediatePackage.eNS_URI
    }

    /**
     * Check if the container depends on an infrastructure node with a MariaDB technology model
     */
    @Check
    def checkMariaDBTechnologyForContainer(IntermediateContainer container) {
        val mariaDBTechnology =
            container.dependsOnNodes.exists[ it.qualifiedTechnologyName.toLowerCase ==
                MariaDBCodeGenerator.MARIADB_TECHNOLOGY]

        if(!mariaDBTechnology)
            warning('''No supported technology model found for container «container.name»''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }

    /**
     * Check if the infrastructure node uses a MariaDB technology model
     */
    @Check
    def checkMariaDBTechnologyForInfrastructureNode(IntermediateInfrastructureNode node) {
        if(node.qualifiedInfrastructureTechnologyName.toLowerCase !=
            MariaDBCodeGenerator.MARIADB_TECHNOLOGY)
            warning('''No supported technology model found for InfrastructureNode «node.name».''',
                IntermediatePackage.Literals.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)
    }
}
