package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies;

import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyModifierI

/**
 * Base interface for dependency serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal interface DependencySerializerI<M: Any> {
    /**
     * The type of dependencies supported by this serializer
     */
    val dependencyType: DependencyType

    /**
     * Each concrete dependency serializer must provide the [Class] instance of its dedicated [DependencyModifierI], if
     * it wants to allow Genlets to modify dependencies. The type of the internal dependency model must fit the type of
     * the serializer implementation.
     */
    fun modifierClass() : Class<out DependencyModifierI<M>>? = null

    /**
     * Build the internal dependency model
     */
    fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>) : M

    /**
     * Serialize the given dependency model, which is the model produced by [buildModel] including portions provided by
     * [DependencyModifierI] implementations within Genlets
     */
    fun serialize(model: M, targetFolderPath: String, targetFilePath: String) : Pair<String, String>

    /**
     * Function to invoke the dependency serialization process. This is not meant to be overridden or called externally.
     */
    fun invoke(
        artifactIdentifier: String,
        dependencyDescriptions: Set<DependencyDescription>,
        dependencyModifiers: List<DependencyModifierI<M>>,
        targetFolderPath: String,
        targetFilePath: String
    ) : Pair<String, String> {
        // Build internal model
        var model = buildModel(artifactIdentifier, dependencyDescriptions)

        // Modify dependencies
        dependencyModifiers.forEach { model = it.modify(model) }

        // Serialize the internal model
        return serialize(model, targetFolderPath, targetFilePath)
    }
}
