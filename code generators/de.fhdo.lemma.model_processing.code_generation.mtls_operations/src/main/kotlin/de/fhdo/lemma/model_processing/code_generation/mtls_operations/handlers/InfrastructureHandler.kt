package de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.CharsetAwareFileContent

@CodeGenerationModule(name = "mtls")
class InfrastructureHandler: AbstractCodeGenerationModule() {
    override fun getLanguageNamespace(): String {
        TODO("Not yet implemented")
    }

    override fun execute(phaseArguments: Array<String>, moduleArguments: Array<String> ): Map<String, CharsetAwareFileContent> {



        val content = HashMap<String, String>()

        return withCharset(content, "UTF-8")
    }


}