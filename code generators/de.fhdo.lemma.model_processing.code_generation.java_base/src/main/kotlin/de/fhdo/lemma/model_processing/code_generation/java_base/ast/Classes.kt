package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.java.ast.utils.setInitializationValue
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom

/**
 * Add a private attribute with the given intermediate [type] to this class, and add type-specific imports to the
 * [importsTargetNode] leveraging the [addImportToTargetNode] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <P: Node> ClassOrInterfaceDeclaration.addPrivateAttribute(attributeName: String, type: IntermediateType,
    importsTargetNode: P, vararg modifiers: Modifier.Keyword, initializer: String? = null,
    addImportToTargetNode: P.(String) -> Unit)
        = addAttribute(attributeName, type, importsTargetNode, Modifier.Keyword.PRIVATE, *modifiers,
            initializer = initializer, addImportToTargetNode = addImportToTargetNode)

/**
 * Add an attribute with the given intermediate [type] to this class, and add type-specific imports to the
 * [importsTargetNode] leveraging the [addImportToTargetNode] function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <P: Node> ClassOrInterfaceDeclaration.addAttribute(attributeName: String, type: IntermediateType,
    importsTargetNode: P, vararg modifiers: Modifier.Keyword, initializer: String? = null,
    addImportToTargetNode: P.(String) -> Unit) : FieldDeclaration {
    val attributeField = addField("TODO", attributeName, *modifiers)
    attributeField.variables[0].setJavaTypeFrom(type, importsTargetNode, addImportToTargetNode)

    if (initializer != null)
        attributeField.setInitializationValue(initializer)

    return attributeField
}