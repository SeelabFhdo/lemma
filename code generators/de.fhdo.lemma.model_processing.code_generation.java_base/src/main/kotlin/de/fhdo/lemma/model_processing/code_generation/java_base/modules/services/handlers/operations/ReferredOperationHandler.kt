package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.operations

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImportsInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.removeImport
import de.fhdo.lemma.model_processing.code_generation.java_base.buildOperationPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateFactory
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Called code generation handler for IntermediateReferredOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class ReferredOperationHandler
    : CallableCodeGenerationHandlerI<IntermediateReferredOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateReferredOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(referredOperation: IntermediateReferredOperation, parentClass: ClassOrInterfaceDeclaration)
            = ReferredOperationHandler().execute(referredOperation, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateReferredOperation, context: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        /*
         * Referred operations become methods that delegate to another method. For the generation of those methods, we
         * employ the following strategy:
         *      (1) Derive a "fake" IntermediateOperation instance from the IntermediateReferredOperation.
         *      (2) Leverage the OperationHandler to generate a method from the fake operation.
         *      (3) Restore the previous state of the IntermediateReferredOperation instance, before the
         *          IntermediateOperation was derived. That is mainly, set Ecore references back to their original
         *          state.
         *      (4) Adjust the method-related imports of the generated method to point to the package of the method to
         *          which the generated one will delegate.
         */
        val fakeOperation = eObject.deriveIntermediateOperation()
        val (generatedMethod, _) = OperationHandler.invoke(fakeOperation, context!!)!!
        eObject.restoreEcoreReferencesFrom(fakeOperation)
        generatedMethod.adjustImportsToPackageOf(eObject.operation, eObject.referringInterface.name)

        /*
         * A referred operation is not meant to be overridden with custom code, as it always just delegates to another
         * method
         */
        generatedMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        /*
         * Set the body of the delegating generated method. It will create a new instance of the class that represents
         * the modeled interface (cf. InterfaceHandler) and call the referred, generated method.
         */
        val currentInterfacesGenerationPackage: String by ServicesState
        val delegateInterfaceClassname = eObject.operation.`interface`.classname

        // Import the interface class
        generatedMethod.addImport(
            "$currentInterfacesGenerationPackage.$delegateInterfaceClassname",
            ImportTargetElementType.METHOD_BODY,
            SerializationCharacteristic.REMOVE_ON_RELOCATION
        )

        // Call the delegate method on a fresh interface class instance
        val parametersString = generatedMethod.parameters.joinToString { it.nameAsString }
        var delegatingBody = "new $delegateInterfaceClassname().${eObject.operation.name}($parametersString)"
        if (!generatedMethod.type.isVoidType)
            delegatingBody = "return $delegatingBody"
        generatedMethod.setBody(delegatingBody)

        return generatedMethod to null
    }

    /**
     * Create an [IntermediateOperation] from an [IntermediateReferredOperation] instance using Ecore
     */
    private fun IntermediateReferredOperation.deriveIntermediateOperation() : IntermediateOperation {
        // The operation to which this referred operation points might not have been treated by code generation yet,
        // e.g., when the reference occurs in the model file before the declaration of the original operation. Thus, we
        // first need to resolve it from the defining model's Ecore Resource
        EcoreUtil.resolve(operation, operation.eResource())

        val derivedOperation = IntermediateFactory.eINSTANCE.createIntermediateOperation()
        derivedOperation.name = nameInReferringInterface
        derivedOperation.qualifiedName = qualifiedNameInReferringInterface
        derivedOperation.`interface` = referringInterface
        derivedOperation.visibility = operation.visibility
        derivedOperation.isNotImplemented = operation.isNotImplemented
        derivedOperation.apiOperationComment = operation.apiOperationComment

        derivedOperation.parameters.addAll(operation.parameters)
        derivedOperation.endpoints.addAll(endpoints)
        derivedOperation.protocols.addAll(protocols)
        derivedOperation.aspects.addAll(aspects)

        return derivedOperation
    }

    /**
     * Restore references of [IntermediateReferredOperation] from an [IntermediateOperation] instance that was derived
     * from a referred operation via [deriveIntermediateOperation]. Ecore removes references from source lists, e.g.,
     * when calling addAll().
     */
    private fun IntermediateReferredOperation.restoreEcoreReferencesFrom(fakeOperation: IntermediateOperation) {
        operation.parameters.addAll(fakeOperation.parameters)
        operation.apiOperationComment = fakeOperation.apiOperationComment

        endpoints.addAll(fakeOperation.endpoints)
        protocols.addAll(fakeOperation.protocols)
        aspects.addAll(fakeOperation.aspects)
    }

    /**
     * Helper to change the method-related imports of this [MethodDeclaration] to point to the package of the
     * [delegatedOperation].
     */
    private fun MethodDeclaration.adjustImportsToPackageOf(delegatedOperation: IntermediateOperation, iface: String) {
        val ownPackage = delegatedOperation.buildOperationPackageName(iface)
        val delegatedPackage = delegatedOperation.buildOperationPackageName()

        val importsToAdjust = mutableMapOf<String, String>()
        getImportsInfo().forEach {
            if (it.targetElementType == ImportTargetElementType.METHOD && it.import.startsWith(ownPackage))
                importsToAdjust[it.import] = "$delegatedPackage.${it.import.substringAfterLast(".")}"
        }

        importsToAdjust.forEach { (import, sourceImport) ->
            val importInfo = getImportsInfo()[import, ImportTargetElementType.METHOD]!!
            removeImport(import, importInfo.targetElementType)
            addImport(sourceImport, importInfo.targetElementType, *importInfo.characteristics)
        }
    }
}