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
import de.fhdo.lemma.model_processing.code_generation.springcloud.addValue
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.AttributeOverrideColumn aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class AttributeOverrideColumnHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.AttributeOverrideColumn")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration
        generatedField.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        var attributeOverridesAnnotation = generatedField.getAnnotationByName("AttributeOverrides").orElse(null)
            as? NormalAnnotationExpr
        if (attributeOverridesAnnotation == null) {
            generatedField.addImport("javax.persistence.AttributeOverrides", ImportTargetElementType.ANNOTATION)
            attributeOverridesAnnotation = generatedField.addAndGetAnnotation("AttributeOverrides")
        }

        generatedField.addImport("javax.persistence.AttributeOverride", ImportTargetElementType.ANNOTATION)
        generatedField.addImport("javax.persistence.Column", ImportTargetElementType.ANNOTATION)
        val overrideName = aspect.getPropertyValue("name")
        val columnName = aspect.getPropertyValue("column")
        attributeOverridesAnnotation!!.addValue("value",
            "@AttributeOverride(name = \"$overrideName\", column = @Column(name = \"$columnName\"))")

        return node
    }
}