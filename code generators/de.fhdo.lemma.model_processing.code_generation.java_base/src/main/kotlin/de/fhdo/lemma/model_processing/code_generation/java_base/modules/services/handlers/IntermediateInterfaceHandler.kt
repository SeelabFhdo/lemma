package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.javaFileName
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.EObject
import java.io.File

@CodeGenerationHandler
internal class IntermediateInterfaceHandler
    : VisitingCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    private val currentInterfacesGenerationPackage: String by ServicesState
    private val interfaceSubFolderName: String by ServicesState

    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(intermediateInterface: IntermediateInterface) = intermediateInterface.aspects!!

    override fun execute(intermediateInterface: IntermediateInterface, context : Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val generatedInterfaceClass = newJavaClassOrInterface(
            currentInterfacesGenerationPackage,
            intermediateInterface.classname
        )

        intermediateInterface.operations.forEach {
            val generatedMethod = it.generateMethod(generatedInterfaceClass)
            if (generatedMethod != null) {
                CalledRequiredIntermediateOperationHandler.invoke(it, generatedInterfaceClass,
                    CommunicationType.SYNCHRONOUS)
                CalledRequiredIntermediateOperationHandler.invoke(it, generatedInterfaceClass,
                    CommunicationType.ASYNCHRONOUS)
            }
        }

        intermediateInterface.referredOperations.forEach {
            it.generateMethod(generatedInterfaceClass)
        }

        return generatedInterfaceClass to "$interfaceSubFolderName${File.separator}" +
            intermediateInterface.javaFileName
    }

    private fun EObject.generateMethod(parentClass: ClassOrInterfaceDeclaration)
        : MethodDeclaration? {
        val (methodGenerationResult, intermediateInterface) = when(this) {
            is IntermediateOperation -> CalledIntermediateOperationHandler.invoke(this, parentClass) to this.`interface`

            is IntermediateReferredOperation ->
                CalledIntermediateReferredOperationHandler.invoke(this, parentClass) to this.referringInterface

            else -> return null
        }

        if (methodGenerationResult == null)
            return null

        val (generatedMethod, _) = methodGenerationResult
        if (!generatedMethod.isPrivate && intermediateInterface.isNotImplemented) {
            generatedMethod.isFinal = true
            generatedMethod.setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented")
                """.trimToSingleLine()
            )
        }

        return generatedMethod
    }
}