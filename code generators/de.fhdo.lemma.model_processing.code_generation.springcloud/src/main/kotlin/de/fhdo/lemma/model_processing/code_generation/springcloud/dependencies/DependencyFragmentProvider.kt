package de.fhdo.lemma.model_processing.code_generation.springcloud.dependencies

import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.elements
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProvider
import org.redundent.kotlin.xml.Node

@DependencyFragmentProvider
internal class DependencyFragmentProvider : MavenDependencyFragmentProviderI {
    override fun provideFragmentFor(inputDependencyModel: Node)
        = elements {
            "parent" {
                "groupId" { -"org.springframework.boot" }
                "artifactId" { -"spring-boot-starter-parent" }
                "version" { -"2.1.0.RELEASE" }
                "relativePath" {}
            }
        }
}