package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
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

private const val CASCADE_TYPE_ALL_PROPERTY = "cascadeAll"
private const val CASCADE_TYPE_ALL_LITERAL = "ALL"
private val CASCADE_TYPE_PROPERTIES = mapOf(
    CASCADE_TYPE_ALL_PROPERTY to CASCADE_TYPE_ALL_LITERAL,
    "cascadeDetach" to "DETACH",
    "cascadeMerge" to "MERGE",
    "cascadePersist" to "PERSIST",
	"cascadeRefresh" to "REFRESH",
	"cascadeRemove" to "REMOVE"
)

/**
 * Handler for multiplicity-related aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
class MultiplicityHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("OneToMany", "OneToOne", "ManyToOne", "ManyToMany").forAllTechnologies()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration

        generatedField.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")
        generatedField.addImport("javax.persistence.${aspect.name}", ImportTargetElementType.ANNOTATION)

        val aspectAnnotation = generatedField.addAndGetAnnotation(aspect.name)
        generatedField.setCascadeType(aspect, aspectAnnotation)
        generatedField.setFetchType(aspect, aspectAnnotation)
        aspectAnnotation.setMappedBy(aspect)
        aspectAnnotation.setOptional(aspect)
        generatedField.setJoinColumn(aspect)

        return generatedField
    }

    /**
     * Helper to determine the value for the "cascade" element of the given [annotation] on this [FieldDeclaration]
     * depending on the given [aspect] application
     */
    private fun FieldDeclaration.setCascadeType(aspect: IntermediateImportedAspect, annotation: NormalAnnotationExpr) {
        val activatedCascadeProperties = aspect.effectivePropertyValues.filter { (property, value) ->
                val propertyName = property.name
                val activated = value?.toBoolean() ?: false
                propertyName in CASCADE_TYPE_PROPERTIES && activated
            }.map { (property, _) -> property.name to CASCADE_TYPE_PROPERTIES[property.name] }
            .toMap()
        if (activatedCascadeProperties.isEmpty())
            return

        addImport("javax.persistence.CascadeType", ImportTargetElementType.ANNOTATION)

        // If the aspect configures cascading for all actions, don't add any other action-specific literals of the
        // CascadeType enumeration besides ALL
        if (CASCADE_TYPE_ALL_PROPERTY in activatedCascadeProperties)
            annotation.addPair("cascade", "CascadeType.$CASCADE_TYPE_ALL_LITERAL")
        else {
            val activatedCascadeTypeLiterals = activatedCascadeProperties.values
                .joinToString(", ") { "CascadeType.$it" }
            annotation.addPair("cascade", "{$activatedCascadeTypeLiterals}")
        }
    }

    /**
     * Helper to determine the value for the "fetch" element of the given [annotation] on this [FieldDeclaration]
     * depending on the given [aspect] application
     */
    private fun FieldDeclaration.setFetchType(aspect: IntermediateImportedAspect, annotation: NormalAnnotationExpr) {
        // Lazy fetch takes priority
        if (aspect.propertyIsEffectivelyActivated("fetchLazy")) {
            addImport("javax.persistence.FetchType", ImportTargetElementType.ANNOTATION)
            annotation.addPair("fetch", "FetchType.LAZY")
        } else if (aspect.propertyIsEffectivelyActivated("fetchEager")) {
            addImport("javax.persistence.FetchType", ImportTargetElementType.ANNOTATION)
            annotation.addPair("fetch", "FetchType.EAGER")
        }
    }

    /**
     * Helper to determine if the property with the given [propertyName] is effectively activated on an application of
     * this [IntermediateImportedAspect]. In this context, effectively activated refers to the property exhibiting a
     * [Boolean]-interpretable value.
     */
    private fun IntermediateImportedAspect.propertyIsEffectivelyActivated(propertyName: String)
        = effectivePropertyValues.any { (property, value) ->
            property.name == propertyName && (value?.toBoolean() ?: false)
        }

    /**
     * Helper to determine the value for the "mappedBy" element of this [NormalAnnotationExpr] depending on the given
     * [aspect] application
     */
    private fun NormalAnnotationExpr.setMappedBy(aspect: IntermediateImportedAspect) {
        val mappedBy = aspect.getPropertyValue("mappedBy") ?: return
        addPair("mappedBy", """"$mappedBy"""")
    }

    /**
     * Helper to determine the value for the "optional" element of this [NormalAnnotationExpr] depending on the given
     * [aspect] application
     */
    private fun NormalAnnotationExpr.setOptional(aspect: IntermediateImportedAspect) {
        val optional = aspect.getPropertyValue("optional")?.toBoolean() ?: return
        addPair("optional", "$optional")
    }

    /**
     * Helper to create the JoinColumn annotation on this [FieldDeclaration] depending on the given [aspect] application
     */
    private fun FieldDeclaration.setJoinColumn(aspect: IntermediateImportedAspect) {
        val joinColumn = aspect.getPropertyValue("joinColumn") ?: return
        addImport("javax.persistence.JoinColumn", ImportTargetElementType.ANNOTATION)
        addAndGetAnnotation("JoinColumn").addPair("name", """"$joinColumn"""")
    }
}