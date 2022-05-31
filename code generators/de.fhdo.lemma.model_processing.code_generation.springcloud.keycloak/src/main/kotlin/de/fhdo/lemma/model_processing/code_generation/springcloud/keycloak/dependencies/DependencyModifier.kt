package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.dependencies

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyModifier
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyModifierI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.addChild
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.addChildIfNotExists
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.elements
import org.redundent.kotlin.xml.Node

@DependencyModifier
internal class DependencyModifier : MavenDependencyModifierI {
    override fun modify(inputDependencyModel: Node): Node {

        println("DependencyModifier")

        inputDependencyModel.addChild(
            elements {
                "dependency"{
                    "groupId" { -"org.springframework.boot" }
                    "artifactId" { -"spring-boot-starter-security" }
                }
            },
            elements { "dependencies"{ } }
        )

        inputDependencyModel.addChild(
            elements {
                "dependency" {
                    "groupId" { -"org.keycloak.bom" }
                    "artifactId" { -"keycloak-adapter-bom" }
                    "version" { -"13.0.1" }
                    "type" { -"pom" }
                    "scope" { -"import" }
                }
            },
            elements {
                "dependencyManagement"{
                    "dependencies"{}
                }
            }
        )

        return inputDependencyModel
    }
}