package de.fhdo.lemma.model_processing.code_generation.ddd.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.ddd.getDddElementsForFeatures
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler

@CodeGenerationHandler
internal class IntermediateDataOperationHandler
    : GenletCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(dataOperation: IntermediateDataOperation, generatedMethod: MethodDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val dddElements = generatedMethod.getDddElementsForFeatures(dataOperation.featureNames.toSet())

        if (dddElements.annotations.isNotEmpty())
            generatedMethod.addDependency("de.fhdo.lemma.ddd:de.fhdo.lemma.ddd:0.0.1-SNAPSHOT")

        dddElements.annotations.forEach { (annotation, annotationImport) ->
            generatedMethod.addImport(annotationImport, ImportTargetElementType.ANNOTATION)
            generatedMethod.addAnnotation(annotation)
        }
        return GenletCodeGenerationHandlerResult(generatedMethod)
    }
}