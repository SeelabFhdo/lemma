package de.fhdo.lemma.model_processing.code_generation.mtls_operation.validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.isCertificateAuthority
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.isConformApplicationNames
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.parseApplicationNames
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.InfrastructureNode
import org.eclipse.emf.ecore.resource.Resource
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import org.eclipse.xtext.validation.Check


@SourceModelValidator
class MTLSOperationModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("operation")

    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val om = resource.contents[0] as OperationModel
        om.imports.convertToAbsoluteFileUrisInPlace(resource)
    }


    /*
    * Checks whether the Certificate Authority has been defined as infrastructure node aspects.
    * The Certificate Authority is configured using service properties only.
    * */
    @Check
    private fun checkNoAspectsForCaAuthority(infrastructureNode: InfrastructureNode) {
        if (!infrastructureNode.isCertificateAuthority()) return

        if (infrastructureNode.aspects.isNotEmpty()) error(
            "No aspects can be defined for Certificate Authority.", OperationPackage.Literals.OPERATION_NODE__ASPECTS
        )
    }

    /*
    * It is checked that no deployment specifications are defined for services that use the Certification Authority.
    * */
    @Check
    private fun checkNoAspectsForCaAuthority1(infrastructureNode: InfrastructureNode) {
        if (!infrastructureNode.isCertificateAuthority()) return

        if (infrastructureNode.deploymentSpecifications.isNotEmpty()) error(
            "No deployment specifications can be defined for the services that " + "the Certification Authority uses.",
            OperationPackage.Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS
        )
    }

    @Check
    private fun checkNamingForServicesInContainers(container: Container) {
//        if (container.deployedServices.size < 2) return
        container.aspects.forEach { importedOperationAspect ->
            importedOperationAspect.values.forEachIndexed { index, technologySpecificPropertyValueAssignment ->
                if (technologySpecificPropertyValueAssignment.property.name != "applicationName") return@forEachIndexed
                if (!isConformApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()))
                    error(
                        "The applicationName has the wrong format! " +
                                "Example: ([QualifiedName]=[Name])((,)[QualifiedName]=[Name]))*",
                        importedOperationAspect,
                        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
                        index
                    )
                if (parseApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()).size
                    < container.deployedServices.size)
                    warning("There are more defined names in the aspect applicationName than deployed services!",
                        importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index)
                if (parseApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()).size
                    > container.deployedServices.size)
                    warning("There are more deployed services than defined names in the aspect applicationName!",
                        importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index)
            }
        }
    }

    /*
    * It checks if the values of aspects or system settings do not contain a hyphen or a dot.
    * */
    @Check
    private fun checkSystemEnvironmentVariables() {

    }
}