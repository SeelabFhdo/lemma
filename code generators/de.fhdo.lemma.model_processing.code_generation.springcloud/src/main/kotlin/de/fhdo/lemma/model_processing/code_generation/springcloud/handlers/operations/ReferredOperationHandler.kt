package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.operations

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

/**
 * Code generation handler for IntermediateReferredOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class ReferredOperationHandler
    : GenletCodeGenerationHandlerI<IntermediateReferredOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateReferredOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateReferredOperation, node: MethodDeclaration,
        context: ClassOrInterfaceDeclaration?) : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        /*
         * The interface that defines the operation to which shall be referred will be Autowired into the referring
         * class, if this is not the case already
         */
        val definingInterface = eObject.operation.`interface`.classname
        val generatedParentClass = node.parentNode.get() as ClassOrInterfaceDeclaration
        val injectionAttribute = definingInterface.decapitalize()
        if (generatedParentClass.attributes.any { it.nameAsString == injectionAttribute })
            return GenletCodeGenerationHandlerResult(node)

        /* Add Autowired attribute to the class */
        val delegationAttribute = generatedParentClass.addPrivateAttribute(injectionAttribute, definingInterface)
        generatedParentClass.addImport(
            "org.springframework.beans.factory.annotation.Autowired",
            ImportTargetElementType.ANNOTATION
        )
        delegationAttribute.addAnnotation("Autowired")

        /*
         * The body of the method will be replaced with a delegating call to the original operation leveraging the
         * Autowired interface
         */
        val parametersString = node.parameters.joinToString { it.nameAsString }
        var delegatingBody = "$injectionAttribute.${eObject.operation.name}($parametersString)"
        if (!node.type.isVoidType)
            delegatingBody = "return $delegatingBody"
        node.setBody(delegatingBody)

        return GenletCodeGenerationHandlerResult(node)
    }
}