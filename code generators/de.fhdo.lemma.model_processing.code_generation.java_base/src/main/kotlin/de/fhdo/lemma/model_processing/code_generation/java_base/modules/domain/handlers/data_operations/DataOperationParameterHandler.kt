package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers.data_operations

import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.invokeCodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom

/**
 * Called code generation handler for IntermediateDataOperationParameter instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataOperationParameterHandler
    : CallableCodeGenerationHandlerI<IntermediateDataOperationParameter, CallableDeclaration<*>,
        CallableDeclaration<*>> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperationParameter::class.java
    override fun generatesNodesOfInstance() = CallableDeclaration::class.java
    override fun getAspects(eObject: IntermediateDataOperationParameter) = eObject.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(parameter: IntermediateDataOperationParameter, method: CallableDeclaration<*>)
            = invokeCodeGenerationHandler(DataOperationParameterHandler(), parameter, method)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataOperationParameter, context: CallableDeclaration<*>?)
        : Pair<CallableDeclaration<*>, String?>? {
        val generatedParameter = Parameter()
        generatedParameter.setName(eObject.name)
        generatedParameter.setJavaTypeFrom(eObject.type, context!!) {
            context.addImport(it, ImportTargetElementType.METHOD)
        }
        context.addParameter(generatedParameter)

        return context to null
    }
}