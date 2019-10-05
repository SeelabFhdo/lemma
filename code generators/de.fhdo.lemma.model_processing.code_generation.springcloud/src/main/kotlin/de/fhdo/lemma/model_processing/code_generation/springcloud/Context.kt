package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

internal object Context {
    object State {
        private val asynchronousOperations = mutableMapOf<String, MutableSet<AsynchronousOperationInfo>>()
        private var currentIntermediateMicroservice: IntermediateMicroservice? = null

        fun setCurrentIntermediateMicroservice(currentIntermediateMicroservice: IntermediateMicroservice) {
            State.currentIntermediateMicroservice = currentIntermediateMicroservice
        }

        fun addOrUpdateAsynchronousOperationInfo(
            operation: IntermediateOperation,
            generatedMethod: MethodDeclaration? = null,
            compositeInputClass: String? = null,
            compositeResultClass: String? = null
        ) {
            require(generatedMethod != null || compositeInputClass != null || compositeResultClass != null) {
                "At least one parameter must be passed to add or update information about an asynchronous service " +
                "operation"
            }

            val protocol = operation.protocols
                .find { it.communicationType == CommunicationType.ASYNCHRONOUS }!!
                .protocol
            if (protocol !in asynchronousOperations)
                asynchronousOperations[protocol] = mutableSetOf()

            var operationInfo = asynchronousOperations[protocol]!!
                .find { it.operation.qualifiedName == operation.qualifiedName }
            if (operationInfo == null) {
                operationInfo = AsynchronousOperationInfo(protocol, operation)
                asynchronousOperations[protocol]!!.add(operationInfo)
            }

            if (generatedMethod != null)
                operationInfo.generatedMethod = generatedMethod

            if (compositeInputClass != null)
                operationInfo.compositeInputClass = compositeInputClass

            if (compositeResultClass != null)
                operationInfo.compositeResultClass = compositeResultClass
        }

        fun getAsynchronousCompositeClasses(protocol: String) : Set<String> {
            val operations = asynchronousOperations[protocol] ?: return emptySet()

            val compositeClasses = mutableSetOf<String>()
            operations.forEach {
                if (it.compositeInputClass != null)
                    compositeClasses.add(it.compositeInputClass!!)

                if (it.compositeResultClass != null)
                    compositeClasses.add(it.compositeResultClass!!)
            }

            return compositeClasses
        }

        fun getAsynchronousReceiverClasses(protocol: String) : Set<String> {
            val operations = asynchronousOperations[protocol] ?: return emptySet()

            val receiverClasses = mutableSetOf<String>()
            operations.forEach {
                if (it.receiverClassName != null)
                    receiverClasses.add(it.receiverClassName!!)
            }

            return receiverClasses
        }

        fun getAsynchronousOperationInputInfo (protocol: String) : Set<AsynchronousOperationInfo> {
            val operations = asynchronousOperations[protocol] ?: return emptySet()
            return operations.filter { it.compositeInputClass != null }.toSet()
        }

        fun reset() {
            asynchronousOperations.clear()
            currentIntermediateMicroservice = null
        }

        /**
         * Provide delegated property values for callers
         */
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "currentIntermediateMicroservice" -> currentIntermediateMicroservice
                else -> throw IllegalArgumentException("State does not comprise property ${property.name}")
            }

            return value as T
        }
    }
}

internal class AsynchronousOperationInfo(val protocol: String, val operation: IntermediateOperation,
    generatedMethod: MethodDeclaration? = null, var compositeInputClass: String? = null,
    var compositeResultClass: String? = null) {
    var receiverClassName: String? = null
        private set

    var generatedMethod: MethodDeclaration? = generatedMethod
        set(value) {
            if (value != null)
                initializeReceiverClassName(value)

            field = value
        }

    init {
        if (generatedMethod != null)
            initializeReceiverClassName(generatedMethod!!)
    }

    private fun initializeReceiverClassName(generatedMethod: MethodDeclaration) {
        val receiverClass = generatedMethod.parentNode.get() as ClassOrInterfaceDeclaration
        // Capture here, because class might get adapted by code generation serializers
        receiverClassName = receiverClass.fullyQualifiedName.get()
    }

    override fun equals(other: Any?)
        = when {
            this === other -> true
            other == null -> false
            other !is AsynchronousOperationInfo -> false
            else -> operation.qualifiedName == operation.qualifiedName
        }

    override fun hashCode() = operation.qualifiedName.hashCode()
}