package de.fhdo.lemma.model_processing.code_generation.mtls_operation.validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
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
        if (infrastructureNode.infrastructureTechnology.infrastructureTechnology.name != "certificateAuthority"
            && infrastructureNode.infrastructureTechnology.infrastructureTechnology.technology.name == "mTLS")
            return
        if (infrastructureNode.aspects.isNotEmpty())
            error(
                "No aspects can be defined for Certificate Authority.",
                OperationPackage.Literals.OPERATION_NODE__ASPECTS
            )
    }

    /*
    * It is checked that no deployment specifications are defined for services that use the Certification Authority.
    * */
    @Check
    private fun checkNoAspectsForCaAuthority1(infrastructureNode: InfrastructureNode) {
        if (infrastructureNode.infrastructureTechnology.infrastructureTechnology.name != "certificateAuthority"
            && infrastructureNode.infrastructureTechnology.infrastructureTechnology.technology.name == "mTLS")
            return

        if (infrastructureNode.deploymentSpecifications.isNotEmpty())
            error(
                "No deployment specifications can be defined for the services that " +
                        "the Certification Authority uses.",
                OperationPackage.Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS
            )
    }
}