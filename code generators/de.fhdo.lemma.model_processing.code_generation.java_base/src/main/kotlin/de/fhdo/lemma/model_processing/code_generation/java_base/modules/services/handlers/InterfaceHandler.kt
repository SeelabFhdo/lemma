package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.java.ast.utils.newJavaClassOrInterface
import de.fhdo.lemma.java.ast.utils.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.javaFileName
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.operations.OperationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.operations.ReferredOperationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters.RequiredInputParametersHandler
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Code generation handler for IntermediateInterface instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class InterfaceHandler
    : VisitingCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(eObject: IntermediateInterface) = eObject.aspects!!

    private val currentInterfacesGenerationPackage: String by ServicesState
    private val interfaceSubFolderName: String by ServicesState

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateInterface, context : Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        /*
         * Each IntermediateInterface will be mapped to its own Java class in the current interfaces' generation
         * package
         */
        val generatedInterfaceClass = newJavaClassOrInterface(currentInterfacesGenerationPackage, eObject.classname)

        /*
         * Each IntermediateOperation instance comprised by the interface will be transformed into a method of the
         * generated interface class
         */
        for (operation in eObject.operations) {
            operation.toMethod(generatedInterfaceClass)

            // Handle required synchronous input parameters of the operation
            RequiredInputParametersHandler.invoke(operation, generatedInterfaceClass, CommunicationType.SYNCHRONOUS)

            // Handle required asynchronous input parameters of the operation
            RequiredInputParametersHandler.invoke(operation, generatedInterfaceClass, CommunicationType.ASYNCHRONOUS)
        }

        /*
         * Each IntermediateReferredOperation instance will also be transformed into a method of the generated interface
         * class. However, no guard methods for checking its required input parameters are generated, as referred
         * operations only directly delegate to the logic of other operations.
         */
        eObject.referredOperations.forEach { it.toMethod(generatedInterfaceClass) }

        return generatedInterfaceClass to "$interfaceSubFolderName${File.separator}${eObject.javaFileName}"
    }

    /**
     * Helper method to generate a [MethodDeclaration] from this [EObject], which either is an [IntermediateOperation]
     * or [IntermediateReferredOperation] instance
     */
    private fun EObject.toMethod(interfaceClass: ClassOrInterfaceDeclaration) : MethodDeclaration? {
        /* Depending on the instance, invoke the correct handler */
        val (methodGenerationResult, operationInterface) = when(this) {
            is IntermediateOperation -> OperationHandler.invoke(this, interfaceClass) to this.`interface`

            is IntermediateReferredOperation ->
                ReferredOperationHandler.invoke(this, interfaceClass) to this.referringInterface

            else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} cannot be transformed " +
                "to a method")
        }

        /* Set method body to throw an exception in case the interface is marked as being not implemented */
        val (generatedMethod, _) = methodGenerationResult!!
        if (operationInterface.isNotImplemented) {
            // The final modifier makes only sense, if a method is not private and thus may be overridden
            generatedMethod.isFinal = !generatedMethod.isPrivate
            generatedMethod.setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented")
                """.trimToSingleLine()
            )
        }

        return generatedMethod
    }
}