package de.fhdo.lemma.model_processing.code_generation.mtls.operation.validation

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.hasAnyInvalidSystemEnvironmentVariable
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.isCertificateAuthority
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.isConformApplicationNames
import de.fhdo.lemma.model_processing.code_generation.mtls.operation.utils.parseApplicationNames
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.ImportedOperationAspect
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
    private fun checkNoDeploymentSpecificationsForCaAuthority(infrastructureNode: InfrastructureNode) {
        if (!infrastructureNode.isCertificateAuthority()) return

        if (infrastructureNode.deploymentSpecifications.isNotEmpty())
            error(
                "No deployment specifications can be defined for the services that the Certification Authority uses.",
                OperationPackage.Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS
            )
    }

    /*
    * Checks if the keystore or truststore files have a valid file extension.
    * */
    @Check
    private fun checkRelativePath(aspect: ImportedOperationAspect) {
        aspect.values.forEachIndexed() { index, it ->
            if (it.property.name in listOf("keyStoreRelativePath", "trustStoreRelativePath")) {
                if (!it.value.stringValue.startsWith("./") and !it.value.stringValue.startsWith("../")) {
                    error(
                        "The specified path is not relative! ${it.value.stringValue}",
                        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
                        index
                    )
                }
            }
        }
    }


    /*
    * Checks if the keystore or truststore files have a valid file extension.
    * */
    @Check
    private fun checkStoreFileName(aspect: ImportedOperationAspect) {
        aspect.values.forEachIndexed() { index, it ->
            if (it.property.name in listOf("keyStoreFileName", "trustStoreFileName")) {
                if (!it.value.stringValue.endsWith(".p12")) {
                    val filetype = when (it.property.name) {
                        "keyStoreRelativePath" -> "keystore"
                        "trustStoreRelativePath" -> "truststore"
                        else -> ""
                    }
                    error(
                        "The Java ${filetype} file needs the file extension ${it.value.stringValue}.p12",
                        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
                        index
                    )
                }
            }
        }
    }

    /*
    * It checks if the values of aspects do not contain a hyphen or a dot.
    * */
    @Check
    private fun checkSystemEnvironmentVariableChars(aspect: ImportedOperationAspect) {
        aspect.values.forEachIndexed() { index, it ->
            if (hasAnyInvalidSystemEnvironmentVariable(it.value.stringValue))
                error(
                    "The system variable can only consist of letters, digits and underscores.",
                    OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
                    index
                )
        }
    }

    /*
    * It checks if the values of service properties do not contain a hyphen or a dot.
    * */
    @Check
    private fun checkSystemEnvironmentVariableChars(infrastructureNode: InfrastructureNode) {
        if (infrastructureNode.isCertificateAuthority()) {
            infrastructureNode.defaultServicePropertyValues.forEachIndexed { index, it ->
                if (hasAnyInvalidSystemEnvironmentVariable(it.value.stringValue))
                    error(
                        "The system variable can only consist of letters, digits and underscores.",
                        OperationPackage.Literals.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES,
                        index
                    )
            }
        }
    }


    @Check
    private fun checkNamingForServicesInContainers(container: Container) {
        val x = container.aspects
        container.aspects.filter { it.aspect.name in setOf("mtls", "mtlsdev") }
            .forEach { importedOperationAspect ->
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
                        < container.deployedServices.size
                    )
                        error(
                            "There are more defined names in the aspect applicationName than deployed " +
                                    " services!",
                            importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index
                        )
                    if (parseApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()).size
                        > container.deployedServices.size
                    )
                        error(
                            "There are more deployed services than defined names in the aspect applicationName!",
                            importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index
                        )
                }
            }
    }
}