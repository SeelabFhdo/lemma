package de.fhdo.lemma.model_processing.code_generation.keycloak.operation.validation

import com.fasterxml.jackson.databind.ObjectMapper
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.keycloak.operation.utils.isKeycloakRealm
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check
import java.io.IOException


@SourceModelValidator
class KeycloakOperationModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("operation")

    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val om = resource.contents[0] as OperationModel
        om.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    //todo prüfen ob ein Microservice mit Rollen einen Aspekt keycloakClient(clientId="de.pelki.ms1") besitzt eventuell auch nicht wenn ich den client aus dem kram erstellen kann
    //todo requiredActions prüfen
    //todo Group.realmRoles exist?
    //todo keycloakPropertiesConfig, group, user only for keycloakRealm
    //todo role, keycloakClient only for non-keycloakRealm

    /*
    * Checks if the service property additionalJsonProperties is valid json
    * */
    @Check
    private fun checkIsValidJsonString(infrastructureNode: InfrastructureNode) {
        if (!infrastructureNode.isKeycloakRealm()) return
        infrastructureNode.defaultServicePropertyValues.forEachIndexed { index, property ->
            when (property.property.name) {
                "additionalJsonProperties" -> {
                    if (!isValidJson(property.value.stringValue))
                        error(
                            "The value must be valid json String.",
                            OperationPackage.Literals.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES,
                            index
                        )
                }
            }
        }
    }




    /*
    * It is checked that no deployment specifications are defined for services that use the Certification Authority.
    * */
//    @Check
//    private fun checkNoDeploymentSpecificationsForCaAuthority(infrastructureNode: InfrastructureNode) {
//        if (!infrastructureNode.isKeycloakRealm()) return
//
//        if (1 == 2)
//            error(
//                "No deployment specifications can be defined for the services that the Certification Authority uses.",
//                OperationPackage.Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS
//            )
//        return
//    }

    /*
    * Checks if the keystore or truststore files have a valid file extension.
    * */
//    @Check
//    private fun checkRelativePath(aspect: ImportedOperationAspect) {
//        aspect.values.forEachIndexed() { index, it ->
//            if (it.property.name in listOf("keyStoreRelativePath", "trustStoreRelativePath")) {
//                if (!it.value.stringValue.startsWith("./") and !it.value.stringValue.startsWith("../")) {
//                    error(
//                        "The specified path is not relative! ${it.value.stringValue}",
//                        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
//                        index
//                    )
//                }
//            }
//        }
//    }


    /*
    * Checks if the keystore or truststore files have a valid file extension.
    * */
//    @Check
//    private fun checkStoreFileName(aspect: ImportedOperationAspect) {
//        aspect.values.forEachIndexed() { index, it ->
//            if (it.property.name in listOf("keyStoreFileName", "trustStoreFileName")) {
//                if (!it.value.stringValue.endsWith(".p12")) {
//                    val filetype = when (it.property.name) {
//                        "keyStoreRelativePath" -> "keystore"
//                        "trustStoreRelativePath" -> "truststore"
//                        else -> ""
//                    }
//                    error(
//                        "The Java ${filetype} file needs the file extension ${it.value.stringValue}.p12",
//                        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
//                        index
//                    )
//                }
//            }
//        }
//    }

    /*
    * It checks if the values of aspects do not contain a hyphen or a dot.
    * */
//    @Check
//    private fun checkSystemEnvironmentVariableChars(aspect: ImportedOperationAspect) {
//        aspect.values.forEachIndexed() { index, it ->
//            if (hasAnyInvalidSystemEnvironmentVariable(it.value.stringValue))
//                error(
//                    "The system variable can only consist of letters, digits and underscores.",
//                    OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
//                    index
//                )
//        }
//    }

    /*
    * It checks if the values of service properties do not contain a hyphen or a dot.
    * */
//    @Check
//    private fun checkSystemEnvironmentVariableChars(infrastructureNode: InfrastructureNode) {
//        if (infrastructureNode.isCertificateAuthority()) {
//            infrastructureNode.defaultServicePropertyValues.forEachIndexed { index, it ->
//                if (hasAnyInvalidSystemEnvironmentVariable(it.value.stringValue))
//                    error(
//                        "The system variable can only consist of letters, digits and underscores.",
//                        OperationPackage.Literals.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES,
//                        index
//                    )
//            }
//        }
//    }


//    @Check
//    private fun checkNamingForServicesInContainers(container: Container) {
//        container.aspects.filter { it.aspect.name in setOf("mtls", "mtlsdev") }
//            .forEach { importedOperationAspect ->
//                importedOperationAspect.values.forEachIndexed { index, technologySpecificPropertyValueAssignment ->
//                    if (technologySpecificPropertyValueAssignment.property.name != "applicationName") return@forEachIndexed
//                    if (!isConformApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()))
//                        error(
//                            "The applicationName has the wrong format! " +
//                                    "Example: ([QualifiedName]=[Name])((,)[QualifiedName]=[Name]))*",
//                            importedOperationAspect,
//                            OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES,
//                            index
//                        )
//                    if (parseApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()).size
//                        < container.deployedServices.size
//                    )
//                        error(
//                            "There are more defined names in the aspect applicationName than deployed " +
//                                    " services!",
//                            importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index
//                        )
//                    if (parseApplicationNames(technologySpecificPropertyValueAssignment.value.valueAsString()).size
//                        > container.deployedServices.size
//                    )
//                        error(
//                            "There are more deployed services than defined names in the aspect applicationName!",
//                            importedOperationAspect, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, index
//                        )
//                }
//            }
//    }


    private fun isValidJson(jsonString: String) = try {
        ObjectMapper().readTree(jsonString)
        true
    } catch (e: IOException) {
        false
    }
}