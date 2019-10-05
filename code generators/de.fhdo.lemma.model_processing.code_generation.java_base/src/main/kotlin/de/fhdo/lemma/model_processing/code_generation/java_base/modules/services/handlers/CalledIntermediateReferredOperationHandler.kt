package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImportsInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.removeImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.buildOperationPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateFactory
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.util.EcoreUtil

@CodeGenerationHandler
internal class CalledIntermediateReferredOperationHandlerSync {
    companion object {
        fun invoke(operation: IntermediateReferredOperation, parentClass: ClassOrInterfaceDeclaration)
            = operation.generate(parentClass, CommunicationType.SYNCHRONOUS)
    }
}

@CodeGenerationHandler
internal class CalledIntermediateReferredOperationHandlerAsync {
    companion object {
        fun invoke(operation: IntermediateReferredOperation, parentClass: ClassOrInterfaceDeclaration)
            = operation.generate(parentClass, CommunicationType.ASYNCHRONOUS)
    }
}

private fun IntermediateReferredOperation.generate(parentClass: ClassOrInterfaceDeclaration,
    communicationType: CommunicationType) : Pair<MethodDeclaration, String?>? {
    val derivedOperationForGeneration = toOperation()
    val operationGenerationResult = CalledIntermediateOperationHandlerBase(communicationType)
        .invoke(derivedOperationForGeneration, parentClass)
    restoreFrom(derivedOperationForGeneration)

    if (operationGenerationResult == null)
        return null

    val currentInterfacesGenerationPackage: String by ServicesState
    val (generatedMethod, _) = operationGenerationResult

    val generatedOperationPackage = operation.buildOperationPackageName(referringInterface.name)
    val sourceOperationPackage = operation.buildOperationPackageName()
    val generatedImportsToReplace = mutableMapOf<String, String>()
    for (generatedImportInfo in generatedMethod.getImportsInfo()) {
        val import = generatedImportInfo.import
        val targetElementType = generatedImportInfo.targetElementType
        if (targetElementType != ImportTargetElementType.METHOD || !import.startsWith(generatedOperationPackage))
            continue

        val importedType = generatedImportInfo.import.substring(generatedOperationPackage.length + 1)
        val sourceOperationImport = "$sourceOperationPackage.$importedType"
        generatedImportsToReplace[import] = sourceOperationImport
    }
    generatedImportsToReplace.forEach { (generatedImport, sourceImport) ->
        val importInfo = generatedMethod.getImportsInfo()[generatedImport, ImportTargetElementType.METHOD]!!
        generatedMethod.removeImport(generatedImport, importInfo.targetElementType)
        generatedMethod.addImport(sourceImport, importInfo.targetElementType, *importInfo.characteristics)
    }

    generatedMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

    val sourceInterfaceClassname = operation.`interface`.classname
    generatedMethod.addImport("$currentInterfacesGenerationPackage.$sourceInterfaceClassname",
        ImportTargetElementType.METHOD_BODY, SerializationCharacteristic.REMOVE_ON_RELOCATION)

    val parametersString = generatedMethod.parameters.joinToString { it.nameAsString }
    var delegatingBody = "new $sourceInterfaceClassname().${operation.name}($parametersString)"
    if (!generatedMethod.type.isVoidType)
        delegatingBody = "return $delegatingBody"
    generatedMethod.setBody(delegatingBody)

    return GenletDelegate(generatedMethod).invoke(this, parentClass)
}

private fun IntermediateReferredOperation.toOperation() : IntermediateOperation {
    val derivedOperation = IntermediateFactory.eINSTANCE.createIntermediateOperation()
    // Original operation might not have been treated by code generation at this point in time, e.g., when the
    // reference occurs in the model file before the declaration of the original operation
    EcoreUtil.resolve(operation, operation.eResource())
    derivedOperation.name = nameInReferringInterface
    derivedOperation.qualifiedName = qualifiedNameInReferringInterface
    derivedOperation.visibility = operation.visibility
    derivedOperation.parameters.addAll(operation.parameters)
    derivedOperation.isNotImplemented = operation.isNotImplemented
    derivedOperation.apiOperationComment = operation.apiOperationComment

    derivedOperation.endpoints.addAll(endpoints)
    derivedOperation.protocols.addAll(protocols)
    derivedOperation.aspects.addAll(aspects)
    derivedOperation.`interface` = referringInterface

    return derivedOperation
}

// Restore references after invoking toOperation() (Ecore removes them, e.g., on references assignments and calling
// addAll())
private fun IntermediateReferredOperation.restoreFrom(derivedOperation: IntermediateOperation) {
    operation.parameters.addAll(derivedOperation.parameters)
    operation.apiOperationComment = derivedOperation.apiOperationComment

    endpoints.addAll(derivedOperation.endpoints)
    protocols.addAll(derivedOperation.protocols)
    aspects.addAll(derivedOperation.aspects)
}

@CodeGenerationHandler
internal class GenletDelegate(private val generatedMethodForGenletProcessing: MethodDeclaration)
    : CallableCodeGenerationHandlerI<IntermediateReferredOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateReferredOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(referredOperation: IntermediateReferredOperation, parentClass: ClassOrInterfaceDeclaration?)
        = generatedMethodForGenletProcessing to null
}