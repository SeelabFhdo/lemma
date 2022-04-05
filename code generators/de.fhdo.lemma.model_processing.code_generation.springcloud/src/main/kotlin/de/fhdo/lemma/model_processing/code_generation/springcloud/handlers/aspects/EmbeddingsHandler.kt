package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

/**
 * Handler for aspects related to object embeddings.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class EmbeddingsHandler : AspectHandlerI {
    override fun handlesAspects() = setOf(
        "java.Embeddable",
        "java.Embedded",
        "java.EmbeddedId"
    )

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        node.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        when(node) {
            is ClassOrInterfaceDeclaration -> {
                if (aspect.qualifiedName == "java.Embeddable") {
                    // For the Embeddable aspect, we add the eponymous annotation and instrument the Java Base Generator
                    // to keep it upon relocation because persistence frameworks like Hibernate expect the annotation
                    // both on managed subclasses and super classes.
                    node.addImport("javax.persistence.${aspect.name}", ImportTargetElementType.ANNOTATION,
                        SerializationCharacteristic.KEEP_ON_RELOCATION)
                    node.addAnnotation(aspect.name, SerializationCharacteristic.KEEP_ON_RELOCATION)

                    // We also add the @MappedSuperclass annotation to the relocated super classes produced by the Java
                    // Base Generator. Again, this annotation is expected by persistence frameworks on super classes of
                    // managed inheritance hierarchies.
                    node.addImport("javax.persistence.MappedSuperclass", ImportTargetElementType.ANNOTATION,
                        SerializationCharacteristic.ADD_ON_RELOCATION)
                    node.addAnnotation("MappedSuperclass", SerializationCharacteristic.ADD_ON_RELOCATION)
                } else {
                    node.addImport("javax.persistence.${aspect.name}", ImportTargetElementType.ANNOTATION)
                    node.addAnnotation(aspect.name)
                }
            }

            is FieldDeclaration -> {
                node.addImport("javax.persistence.${aspect.name}", ImportTargetElementType.ANNOTATION)
                node.addAnnotation(aspect.name)
            }
        }

        return node
    }
}