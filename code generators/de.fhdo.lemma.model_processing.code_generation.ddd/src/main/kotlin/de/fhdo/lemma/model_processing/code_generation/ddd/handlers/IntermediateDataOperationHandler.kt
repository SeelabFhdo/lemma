package de.fhdo.lemma.model_processing.code_generation.ddd.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.ddd.DDD_VERSION
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

    override fun execute(eObject: IntermediateDataOperation, node: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val dddElements = node.getDddElementsForFeatures(eObject.featureNames.toSet())

        if (dddElements.annotations.isNotEmpty())
            node.addDependency("de.fhdo.lemma.ddd:de.fhdo.lemma.ddd:${DDD_VERSION}")

        dddElements.annotations.forEach { (annotation, annotationImport) ->
            node.addImport(annotationImport, ImportTargetElementType.ANNOTATION)
            node.addAnnotation(annotation)
        }
        return GenletCodeGenerationHandlerResult(node)
    }
}