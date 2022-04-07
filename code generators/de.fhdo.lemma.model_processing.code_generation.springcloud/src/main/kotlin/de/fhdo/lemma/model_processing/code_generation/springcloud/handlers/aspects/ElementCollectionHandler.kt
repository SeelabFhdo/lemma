package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.forAllTechnologies
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the ElementCollection aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class ElementCollectionHandler : AspectHandlerI {
    override fun handlesAspects() = "ElementCollection".forAllTechnologies()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val originalField = eObject as IntermediateDataField
        if (originalField.type.kind != IntermediateTypeKind.COLLECTION ||
            originalField.type.origin != IntermediateTypeOrigin.DATA_MODEL)
            return node

        val generatedField = node as FieldDeclaration
        if (generatedField.variables.isEmpty())
            return node

        generatedField.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        generatedField.addImport("javax.persistence.ElementCollection", ImportTargetElementType.ATTRIBUTE)
        generatedField.addAnnotation("ElementCollection")

        // Always add the @CollectionTable annotation to fields with the @ElementCollection annotation as expected by
        // persistence frameworks like Hibernate. In addition, add a value for the "name" element of the
        // @CollectionTable annotation if explicitly configured by the "collectionTable" aspect property or derivable
        // from the annotated field.
        generatedField.addImport("javax.persistence.CollectionTable", ImportTargetElementType.ATTRIBUTE)
        val collectionTableAnnotation = generatedField.addAndGetAnnotation("CollectionTable")
        val generatedAttribute = generatedField.variables[0]
        val collectionTableName = aspect.getPropertyValue("collectionTable")
            ?: generatedAttribute.nameAsString.capitalize()
        if (collectionTableName.isNotEmpty())
            collectionTableAnnotation.addPair("name", """"$collectionTableName"""")

        return node
    }
}