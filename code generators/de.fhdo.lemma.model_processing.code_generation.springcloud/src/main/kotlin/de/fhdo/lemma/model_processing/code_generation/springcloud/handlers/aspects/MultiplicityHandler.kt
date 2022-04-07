package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
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
 * Handler for aspects related to multiplicity specification.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class MultiplicityHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("OneToOne", "OneToMany").forAllTechnologies()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    private val DEFAULT_CASCADE_TYPE = "ALL"
    private val VALID_CASCADE_TYPES = setOf(
        DEFAULT_CASCADE_TYPE,
        "DETACH",
        "MERGE",
        "PERSIST",
        "REFRESH",
        "REMOVE"
    )

    private val VALID_FETCH_TYPES = setOf("EAGER", "LAZY" )

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration
        generatedField.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")
        generatedField.addImport("javax.persistence.${aspect.name}", ImportTargetElementType.ANNOTATION)
        val annotation = generatedField.addAndGetAnnotation(aspect.name)

        /* Determine cascade type */
        var cascadeType = aspect.getPropertyValue("cascade")!!.toUpperCase()
        if (cascadeType !in VALID_CASCADE_TYPES)
            cascadeType = DEFAULT_CASCADE_TYPE
        generatedField.addImport("javax.persistence.CascadeType", ImportTargetElementType.ANNOTATION)
        annotation.addPair("cascade", "CascadeType.${cascadeType}")

        /* Determine fetch type */
        val fetchType = aspect.getPropertyValue("fetch")?.toUpperCase()
        if (fetchType != null && fetchType in VALID_FETCH_TYPES) {
            generatedField.addImport("javax.persistence.FetchType", ImportTargetElementType.ANNOTATION)
            annotation.addPair("fetch", "FetchType.${fetchType}")
        }

        return node
    }
}