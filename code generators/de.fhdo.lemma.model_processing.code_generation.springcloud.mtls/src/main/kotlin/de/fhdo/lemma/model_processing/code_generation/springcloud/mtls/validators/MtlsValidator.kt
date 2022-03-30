package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.validators

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
internal class MtlsValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace(): String {
        return IntermediatePackage.eNS_URI
    }

    @Check
    private fun checkCaCommonNameBeginsWithCA(eObject: EObject) {
        println("Hier bin ich nun ${eObject.qualifiedName}")
//        todo Prüfen ob der CN Name von dem CA Cert mit ca beginnt
//        ca CN=ca.pelki.de
    }

    @Check
    private fun checkCommonName() {
//        todo Prüfen ob der CN Name von dem CA Cert die gleiche Endung des CN Name Client Cert
//        ca CN=ca.pelki.de
//        client CN=ms1.pelki.de
    }

    @Check
    private fun checkPlainTextPassword(intermediateImportedAspect: IntermediateImportedAspect) {
        if (intermediateImportedAspect.qualifiedName.startsWith("mTLS")) {
            if (intermediateImportedAspect.getPropertyValue("password")?.startsWith("\${") == false) {
                warning(
                    "Security warning the password is in clear text in the model. " +
                            "Passwords should be mapped via system variables. " +
                            "Refers to ${intermediateImportedAspect.qualifiedName}.password",
                    intermediateImportedAspect,
                    IntermediatePackage.Literals.INTERMEDIATE_MICROSERVICE__ASPECTS
                )
            }
        }
    }

    @Check
    private fun checkThis(intermediateImportedComplexType: IntermediateImportedComplexType) {
        println("Oder hier${intermediateImportedComplexType.name}")
    }
}