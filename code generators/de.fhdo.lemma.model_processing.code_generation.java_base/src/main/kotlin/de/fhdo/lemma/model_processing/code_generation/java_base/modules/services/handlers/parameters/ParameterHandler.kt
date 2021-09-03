package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.invokeCodeGenerationHandler
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
    override fun getAspects(eObject: IntermediateParameter) = eObject.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(parameter: IntermediateParameter, parentMethod: MethodDeclaration)
            = invokeCodeGenerationHandler(ParameterHandler(), parameter, parentMethod)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateParameter, context: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        // Delegate fault parameter handling to Genlets. Note that usually fault parameters are covered by the
        // FaultParameterHandler. However, when no custom Exception class may be generated for the fault parameters,
        // they need to be treated by Genlets (cf. FaultParameterHandler.execute() and
        // OperationHandler.handleSynchronousFaultParameters() for more details).
        if (eObject.isCommunicatesFault)
            return context!! to null

        val generatedParameter = Parameter()
        generatedParameter.setName(eObject.name)

        val parameterType = if (eObject.hasAspect("java.Set")) {
            context!!.addImport("java.util.Set", ImportTargetElementType.METHOD)
            eObject.type.getBasicType() ?: eObject.type
        } else
            eObject.type

        generatedParameter.setJavaTypeFrom(parameterType, context!!) {
            context.addImport(it, ImportTargetElementType.METHOD)
        }

        if (eObject.hasAspect("java.Set"))
            generatedParameter.setType("Set<${generatedParameter.typeAsString}>")

        context.addParameter(generatedParameter)
        return context to null
    }
}