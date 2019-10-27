package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers.data_operations

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom

/**
 * Called code generation handler for IntermediateDataOperationReturnType instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataOperationReturnTypeHandler
    : CallableCodeGenerationHandlerI<IntermediateDataOperationReturnType, MethodDeclaration, MethodDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperationReturnType::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(returnType: IntermediateDataOperationReturnType) = returnType.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(returnType : IntermediateDataOperationReturnType, method: MethodDeclaration)
            = DataOperationReturnTypeHandler().invoke(returnType, method)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(returnType: IntermediateDataOperationReturnType, method: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        method!!.setJavaTypeFrom(returnType.type, method) { method.addImport(it, ImportTargetElementType.METHOD) }
        return method to null
    }
}