package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared

import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.getGenletNodeInfoOrElseNull
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getContainingDataModel

/**
 * Singleton that stores information about interface types of event groups.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object EventGroupInterfaceTypes {
    private val groupsToDataStructures = mutableMapOf<String, String>()
    private val interfaceTypes = mutableMapOf<String, Pair<String, ClassOrInterfaceType>>()
    private val groupsWithProducerElements = mutableSetOf<String>()
    private val groupsWithConsumerElements = mutableSetOf<String>()

    /**
     * Reset the Singleton
     */
    fun reset() {
        groupsToDataStructures.clear()
        interfaceTypes.clear()
        groupsWithProducerElements.clear()
        groupsWithConsumerElements.clear()
    }

    /**
     * Specify the event group of a data structure
     */
    operator fun set(dataStructure: IntermediateDataStructure, group: String) {
        groupsToDataStructures[dataStructure.identifier()] = group
    }

    /**
     * Calculate unique identifier of a data structure consisting of the source model URI of its defining data model and
     * its qualified name
     */
    private fun IntermediateDataStructure.identifier()
        = this.getContainingDataModel().sourceModelUri + "$" + this.qualifiedName

    /**
     * Get the event group of a data structure
     */
    operator fun get(dataStructure: IntermediateDataStructure) = groupsToDataStructures[dataStructure.identifier()]

    /**
     * Specify the [ClassOrInterfaceType] of an event group
     */
    operator fun set(group: String, classOrInterfaceType: ClassOrInterfaceType) {
        if (group in interfaceTypes)
            return

        val packageName = classOrInterfaceType.getGenletNodeInfoOrElseNull("DomainEventGroupInterfacePackageName")
            ?.toString()
            ?: return
        interfaceTypes[group] = packageName to classOrInterfaceType
    }

    /**
     * Get the [ClassOrInterfaceType] and its package name of an event group
     */
    operator fun get(group: String) : Pair<ClassOrInterfaceType, String>? {
        val (packageName, classOrInterfaceType) = interfaceTypes[group] ?: return null
        return classOrInterfaceType to "$packageName.${classOrInterfaceType.nameAsString}"
    }

    /**
     * Signal that the producer elements for an event group were created
     */
    fun producerElementsCreatedForGroup(group: String) = groupsWithProducerElements.add(group)

    /**
     * Check if the producer elements of an event group were created
     */
    fun existProducerElementsForGroup(group: String) = group in groupsWithProducerElements

    /**
     * Signal that the consumer elements for an event group were created
     */
    fun consumerElementsCreatedForGroup(group: String) = groupsWithConsumerElements.add(group)

    /**
     * Check if the consumer elements of an event group were created
     */
    fun existConsumerElementsForGroup(group: String) = group in groupsWithConsumerElements
}