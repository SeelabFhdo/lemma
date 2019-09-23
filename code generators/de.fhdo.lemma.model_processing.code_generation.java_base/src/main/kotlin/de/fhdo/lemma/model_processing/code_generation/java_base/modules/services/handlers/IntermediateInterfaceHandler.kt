package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
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
import de.fhdo.lemma.technology.CommunicationType
import java.io.File

@CodeGenerationHandler
internal class IntermediateInterfaceHandler
    : VisitingCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    private val currentInterfacesGenerationPackage: String by ServicesState
    private val interfaceSubFolderName: String by ServicesState

    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(iface: IntermediateInterface) = iface.aspects!!

    override fun execute(iface: IntermediateInterface, context : Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val generatedInterfaceClass = newJavaClassOrInterface(currentInterfacesGenerationPackage, iface.classname)

        for (operation in iface.operations) {
            generatedInterfaceClass.generateMethod(iface, operation, CommunicationType.ASYNCHRONOUS)
            generatedInterfaceClass.generateMethod(iface, operation, CommunicationType.SYNCHRONOUS)
            CalledRequiredIntermediateOperationHandler.invoke(operation, generatedInterfaceClass)
        }

        return generatedInterfaceClass to "$interfaceSubFolderName${File.separator}${iface.javaFileName}"
    }

    private fun ClassOrInterfaceDeclaration.generateMethod(iface: IntermediateInterface,
        operation: IntermediateOperation, communicationType: CommunicationType) {
        val methodGenerationResult = when(communicationType) {
            CommunicationType.ASYNCHRONOUS -> CalledIntermediateOperationHandlerAsync.invoke(operation, this)
            CommunicationType.SYNCHRONOUS -> CalledIntermediateOperationHandlerSync.invoke(operation, this)
        } ?: return
        val generatedMethod = methodGenerationResult.first

        if (!generatedMethod.isPrivate && iface.isNotImplemented) {
            generatedMethod.isFinal = true
            generatedMethod.setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented");
                """.trimToSingleLine()
            )
        }
    }
}