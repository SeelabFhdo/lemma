package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation

@CodeGenerationHandler
internal class ReferredOperationHandler
    : GenletCodeGenerationHandlerI<IntermediateReferredOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateReferredOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(referredOperation: IntermediateReferredOperation, method: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val delegationTypeName = referredOperation.operation.`interface`.classname
        val delegationAttributeName = delegationTypeName.decapitalize()
        val parentClass = method.parentNode.get() as ClassOrInterfaceDeclaration
        if (parentClass.attributes.any { it.nameAsString == delegationAttributeName })
            return GenletCodeGenerationHandlerResult(method)

        val delegationAttribute = parentClass.addPrivateAttribute(delegationAttributeName, delegationTypeName)
        parentClass.addImport("org.springframework.beans.factory.annotation.Autowired",
            ImportTargetElementType.ANNOTATION)
        delegationAttribute.addAnnotation("Autowired")

        val parametersString = method.parameters.joinToString { it.nameAsString }
        var delegatingBody = "$delegationAttributeName.${referredOperation.operation.name}($parametersString)"
        if (!method.type.isVoidType)
            delegatingBody = "return $delegatingBody"
        method.setBody(delegatingBody)

        return GenletCodeGenerationHandlerResult(method)
    }
}