package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.validators

import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
internal class KeycloakValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace(): String {

        return IntermediatePackage.eNS_URI
    }

    @Check
    private fun checkThis(eObject: EObject){
        println(eObject.simpleName)
    }

    @Check
    private fun checkThis(intermediateImportedComplexType: IntermediateImportedComplexType){
        println(intermediateImportedComplexType.name)
    }


}