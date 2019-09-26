package de.fhdo.lemma.model_processing.code_generation.ddd.handlers

import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.model_processing.code_generation.ddd.getDddElementsForFeatures
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler

@CodeGenerationHandler
internal class IntermediateDataFieldHandler
    : GenletCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java

    override fun execute(dataField: IntermediateDataField, generatedField: FieldDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<FieldDeclaration>? {
        val dddElements = generatedField.getDddElementsForFeatures(dataField.featureNames.toSet())

        if (dddElements.annotations.isNotEmpty())
            generatedField.addDependency("de.fhdo.lemma.ddd:de.fhdo.lemma.ddd:0.0.1-SNAPSHOT")

        dddElements.annotations.forEach { (annotation, annotationImport) ->
            generatedField.addImport(annotationImport, ImportTargetElementType.ANNOTATION)
            generatedField.addAnnotation(annotation)
        }
        return GenletCodeGenerationHandlerResult(generatedField)
    }
}