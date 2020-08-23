package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.dependencies

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.elements
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProvider
import org.redundent.kotlin.xml.Node

/**
 * Dependency fragment provider for Avro.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@DependencyFragmentProvider
internal class DependencyFragmentProvider : MavenDependencyFragmentProviderI {
    override fun provideFragmentFor(inputDependencyModel: Node)
        = elements {
            "repositories" {
                "repository" {
                    "id" { -"confluent" }
                    "url" { -"http://packages.confluent.io/maven/" }
                }
            }
        }
}