 package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

/**
 * Represents the context of the Genlet. The context provides state handling for the Genlet and Genlet-specific helpers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object Context {
    /*
     * Non-resettable state object of the context. By contrast to the below State object, this object does not support
     * reset of all its attributes at once.
     */
    object NonResettableState {
        var generationInvolvedMicroservices = false
    }

    /* State object of the context */
    object State {
        private val asynchronousOperations = mutableMapOf<String, MutableSet<AsynchronousOperationInfo>>()
        private var currentIntermediateMicroservice: IntermediateMicroservice? = null
        private var currentApplicationPropertiesFile: PropertyFile? = null

        /**
         * Initialize the state
         */
        fun initialize(currentIntermediateMicroservice: IntermediateMicroservice) {
            State.currentIntermediateMicroservice = currentIntermediateMicroservice
            currentApplicationPropertiesFile = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH,
                "application.properties")
        }

        /**
         * Helper to add or update an existing [AsynchronousOperationInfo] for the given [operation], and based on one
         * or more of the given [generatedMethod], [compositeInputClass], and [compositeInputClass] parameters.
         */
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

            /*
             * Add operation to the set of asynchronous operations for its asynchronous protocol, and create or
             * retrieve its corresponding AsynchronousOperationInfo instance
             */
            val protocol = operation.protocols
                .find { it.communicationType == CommunicationType.ASYNCHRONOUS.name }!!
                .protocol
            if (protocol !in asynchronousOperations)
                asynchronousOperations[protocol] = mutableSetOf()

            var operationInfo = asynchronousOperations[protocol]!!
                .find { it.operation.qualifiedName == operation.qualifiedName }
            if (operationInfo == null) {
                operationInfo = AsynchronousOperationInfo(protocol, operation)
                asynchronousOperations[protocol]!!.add(operationInfo)
            }

            /*
             * Add generated method, composite input class, and composite result class information to the
             * AsynchronousOperationInfo instance
             */
            if (generatedMethod != null)
                operationInfo.generatedMethod = generatedMethod

            if (compositeInputClass != null)
                operationInfo.compositeInputClass = compositeInputClass

            if (compositeResultClass != null)
                operationInfo.compositeResultClass = compositeResultClass
        }

        /**
         * Retrieve all composite input and result classes stored for the given [protocol] in the
         * [asynchronousOperations] map.
         */
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

        /**
         * Retrieve all receiver classes stored for the given [protocol] in the [asynchronousOperations] map. The
         * receiver class is the defining class of the asynchronous method and automatically determined when a new
         * [AsynchronousOperationInfo] instance is constructed.
         */
        fun getAsynchronousReceiverClasses(protocol: String) : Set<String> {
            val operations = asynchronousOperations[protocol] ?: return emptySet()

            val receiverClasses = mutableSetOf<String>()
            operations.forEach {
                if (it.receiverClassName != null)
                    receiverClasses.add(it.receiverClassName!!)
            }

            return receiverClasses
        }

        /**
         * Retrieve all [AsynchronousOperationInfo] instances with a composite input class stored for the given
         * [protocol]
         */
        fun getAsynchronousOperationInputInfoSet(protocol: String) : Set<AsynchronousOperationInfo>
            = asynchronousOperations[protocol]
                ?.filter { it.compositeInputClass != null }?.toSet()
                ?: emptySet()

        /**
         * Reset the state
         */
        fun reset() {
            asynchronousOperations.clear()
            currentIntermediateMicroservice = null
            currentApplicationPropertiesFile = null
        }

        /**
         * Provide delegated property values for callers
         */
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "currentIntermediateMicroservice" -> currentIntermediateMicroservice
                "currentApplicationPropertiesFile" -> currentApplicationPropertiesFile
                else -> throw IllegalArgumentException("State does not comprise property ${property.name}")
            }

            return value as T
        }
    }
}

/**
 * This class holds information about an asynchronous operation. Those information comprise
 *      - the name of the asynchronous protocol
 *      - the IntermediateOperation instance
 *      - the generated MethodDeclaration instance
 *      - the name of the composite input class
 *      - the name of the composite result class
 *      - the name of the receiver class, which is the class that defines the generated MethodDeclaration instance
 */
internal class AsynchronousOperationInfo(val protocol: String, val operation: IntermediateOperation,
    generatedMethod: MethodDeclaration? = null, var compositeInputClass: String? = null,
    var compositeResultClass: String? = null) {
    var receiverClassName: String? = null
        private set

    /**
     * Set generated method and also initialize the receiver class name
     */
    var generatedMethod: MethodDeclaration? = generatedMethod
        set(value) {
            if (value != null)
                initializeReceiverClassName(value)

            field = value
        }

    /**
     * Init block to derive the receiver class name in case a generated method has been passed to the constructor
     */
    init {
        if (generatedMethod != null)
            initializeReceiverClassName(generatedMethod)
    }

    /**
     * Helper to initialize the receiver class name
     */
    private fun initializeReceiverClassName(generatedMethod: MethodDeclaration) {
        receiverClassName = (generatedMethod.parentNode.get() as ClassOrInterfaceDeclaration).fullyQualifiedName.get()
    }

    /**
     * Two [AsynchronousOperationInfo] instance are equal when their [operation] instances' qualified names are equal
     */
    override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is AsynchronousOperationInfo) operation.qualifiedName == other.operation.qualifiedName
            else false

    /**
     * The hash code of an [AsynchronousOperationInfo] is equivalent to the hash code the qualified name of its
     * [operation]
     */
    override fun hashCode() = operation.qualifiedName.hashCode()
}