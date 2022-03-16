package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.validators

import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.phases.validation.AbstractXmiDeclarativeValidator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check

@IntermediateModelValidator
internal class MtlsValidator : AbstractXmiDeclarativeValidator() {

    override fun getLanguageNamespace(): String {

        return IntermediatePackage.eNS_URI
    }

    @Check
    private fun checkThis(eObject: EObject){
        println(eObject.simpleName)
    }

    @Check
    private fun checkCaCommonNameBeginsWithCA(){
//        todo Prüfen ob der CN Name von dem CA Cert mit ca beginnt
//        ca CN=ca.pelki.de
    }

    @Check
    private fun checkCommonName(){
//        todo Prüfen ob der CN Name von dem CA Cert die gleiche Endung des CN Name Client Cert
//        ca CN=ca.pelki.de
//        client CN=ms1.pelki.de
    }

    @Check
    private fun checkThis(intermediateImportedComplexType: IntermediateImportedComplexType){
        println(intermediateImportedComplexType.name)
    }


}