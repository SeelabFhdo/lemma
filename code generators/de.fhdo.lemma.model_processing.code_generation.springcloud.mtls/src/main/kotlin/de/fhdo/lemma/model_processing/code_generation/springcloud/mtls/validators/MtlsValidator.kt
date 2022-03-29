package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.validators

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
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
    private fun checkCaCommonNameBeginsWithCA(eObject: EObject){
        println(eObject.qualifiedName)
        println(eObject.getAspect()?.name)


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
    private fun checkPlainTextPassword(intermediateImportedAspect: IntermediateImportedAspect){
        intermediateImportedAspect.getAllAspects().forEach { aspect ->
            println("hallo Hier bin ich  ${aspect.name}")
//            aspect.propertyValues.filter { it }

        }
    }

    @Check
    private fun checkThis(intermediateImportedComplexType: IntermediateImportedComplexType){
        println(intermediateImportedComplexType.name)
    }


}