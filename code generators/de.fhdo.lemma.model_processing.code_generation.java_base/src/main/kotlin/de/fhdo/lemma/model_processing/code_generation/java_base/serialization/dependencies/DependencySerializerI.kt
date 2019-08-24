package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies;

import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI

/**
 * Base interface for dependency serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal interface DependencySerializerI<M: Any, F: Any> {
    /**
     * The type of dependencies supported by this serializer
     */
    val dependencyType: DependencyType

    /**
     * Each concrete dependency serializer must provide the [Class] instance of its dedicated
     * [DependencyFragmentProviderI], if it wants to allow Genlets to add dependency fragments. The types of the
     * internal dependency model and the fragments must fit the types of the serializer implementation.
     */
    fun fragmentProviderClass() : Class<out DependencyFragmentProviderI<M, F>>? = null

    /**
     * Build the internal dependency model
     */
    fun buildModel(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>) : M

    /**
     * If the serializer supports dependency fragment provisioning by Genlets, it must override this function, which
     * will be called by [invoke] to add the given [fragment] to the given [model]. The function must return a version
     * of the [model] to which the fragment has been added. This may either happen in-place or an adapted copy (i.e., a
     * new instance) of the input [model] may be returned.
     */
    fun addFragment(model: M, fragment: F) : M = model

    /**
     * Serialize the given dependency model, which is the model produced by [buildModel] including portions provided by
     * [DependencyFragmentProviderI] implementations within Genlets
     */
    fun serialize(model: M, targetFolderPath: String, targetFilePath: String) : Pair<String, String>

    /**
     * Function to invoke the dependency serialization process. This is not meant to be overridden or called externally.
     */
    fun invoke(artifactIdentifier: String, dependencyDescriptions: Set<DependencyDescription>,
        dependencyFragmentProviders: List<DependencyFragmentProviderI<M, F>>, targetFolderPath: String,
        targetFilePath: String) : Pair<String, String> {
        // Build internal model
        var model = buildModel(artifactIdentifier, dependencyDescriptions)

        // Add dependency fragments
        dependencyFragmentProviders.forEach {
            model = addFragment(model, it.provideFragmentFor(model))
        }

        // Serialize the internal model
        return serialize(model, targetFolderPath, targetFilePath)
    }
}
