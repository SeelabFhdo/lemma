package de.fhdo.lemma.model_processing.code_generation.springcloud.dependencies

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyModifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyModifierI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.addChild
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.addChildIfNotExists
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.elements
import org.redundent.kotlin.xml.Node

/**
 * Dependency modifier for Spring Boot.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@DependencyModifier
internal class DependencyModifier : MavenDependencyModifierI {
    override fun modify(inputDependencyModel: Node) : Node {
        inputDependencyModel.addChildIfNotExists(
            elements {
                "parent" {
                    "groupId" { -"org.springframework.boot" }
                    "artifactId" { -"spring-boot-starter-parent" }
                    "version" { -"2.1.0.RELEASE" }
                }
            }
        )

        return inputDependencyModel
    }
}