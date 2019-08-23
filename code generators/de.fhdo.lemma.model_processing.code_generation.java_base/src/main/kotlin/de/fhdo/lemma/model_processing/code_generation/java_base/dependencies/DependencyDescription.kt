package de.fhdo.lemma.model_processing.code_generation.java_base.dependencies

import java.lang.IllegalArgumentException

/**
 * Enum to distinguish the supported, concrete dependency formats.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class DependencyType {
    MAVEN
}

/**
 * This class represents the abstract, i.e., format-independent, description of a dependency. A dependency has a group
 * and artifact identifier, and possibly a version.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class DependencyDescription(val group: String, val artifact: String, val version: String?) {
    companion object {
        /**
         * Separator of dependency parts
         */
        const val PART_SEP = ":"

        /**
         * Parse a dependency from a string that has the form "<group>PART_SEP<artifact>PART_SEP<version>" or
         * "<group>PART_SEP<artifact>" (without the lesser and greater signs)
         */
        fun fromString(s: String) : DependencyDescription {
            val dependencyParts = s.split(PART_SEP)
            if (dependencyParts.size < 2)
                throw IllegalArgumentException("Dependency description string $s lacks group, artifact, or both")

            return DependencyDescription(
                dependencyParts[0],
                dependencyParts[1],
                dependencyParts.getOrNull(2)
            )
        }
    }

    /**
     * Return the string representation of this [DependencyDescription] instance, i.e.,
     * "<group>PART_SEP<artifact>PART_SEP<version>" or "<group>PART_SEP<artifact>" (without the lesser and greater
     * signs)
     */
    override fun toString() : String {
        return if (version !== null)
                "$group$PART_SEP$artifact$PART_SEP$version"
            else
                "$group$PART_SEP$artifact"
    }
}