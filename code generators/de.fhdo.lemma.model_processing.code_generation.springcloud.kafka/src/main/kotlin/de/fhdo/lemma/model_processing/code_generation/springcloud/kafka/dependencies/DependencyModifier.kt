package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.dependencies

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyModifierI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.elements
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyModifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.addChildIfNotExists
import org.redundent.kotlin.xml.Node

/**
 * Dependency modifier for Avro.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@DependencyModifier
internal class DependencyModifier : MavenDependencyModifierI {
    override fun modify(inputDependencyModel: Node) : Node {
        inputDependencyModel.addChildIfNotExists(
            elements {
                "repositories" {
                    "repository" {
                        "id" { -"confluent" }
                        "url" { -"http://packages.confluent.io/maven/" }
                    }
                }
            }
        )

        return inputDependencyModel
    }
}