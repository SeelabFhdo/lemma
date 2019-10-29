package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getBasicType
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
import de.fhdo.lemma.service.intermediate.IntermediateParameter

/**
 * Called code generation handler for IntermediateParameter instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class ParameterHandler
    : CallableCodeGenerationHandlerI<IntermediateParameter, MethodDeclaration, MethodDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(parameter: IntermediateParameter) = parameter.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(parameter: IntermediateParameter, parentMethod: MethodDeclaration)
            = ParameterHandler().invoke(parameter, parentMethod)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(parameter: IntermediateParameter, parentMethod: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        val generatedParameter = Parameter()
        generatedParameter.setName(parameter.name)

        val parameterType = if (parameter.hasAspect("java.Set")) {
            parentMethod!!.addImport("java.util.Set", ImportTargetElementType.METHOD)
            parameter.type.getBasicType() ?: parameter.type
        } else
            parameter.type

        generatedParameter.setJavaTypeFrom(parameterType, parentMethod!!) {
            parentMethod.addImport(it, ImportTargetElementType.METHOD)
        }

        if (parameter.hasAspect("java.Set"))
            generatedParameter.setType("Set<${generatedParameter.typeAsString}>")

        parentMethod.addParameter(generatedParameter)
        return parentMethod to null
    }
}