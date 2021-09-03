@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.NodeList
import com.github.javaparser.ast.expr.AnnotationExpr
import com.github.javaparser.ast.expr.MarkerAnnotationExpr
import com.github.javaparser.ast.expr.MemberValuePair
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations

/**
 * Copy this [AnnotationExpr] to a new [AnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun AnnotationExpr.copy()
    = when (this) {
        is NormalAnnotationExpr -> copy()
        is MarkerAnnotationExpr -> copy()
        else -> throw IllegalArgumentException("Copying of ${javaClass.simpleName} is not supported")
    }

/**
 * Copy this [NormalAnnotationExpr] to a new [NormalAnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun NormalAnnotationExpr.copy() : NormalAnnotationExpr {
    val copyName = StaticJavaParser.parseName(nameAsString)
    val copyPairs = NodeList(pairs.map { MemberValuePair(it.nameAsString, NameExpr(it.value.toString())) })
    return NormalAnnotationExpr(copyName, copyPairs)
}

/**
 * Copy this [MarkerAnnotationExpr] to a new [MarkerAnnotationExpr] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MarkerAnnotationExpr.copy() : MarkerAnnotationExpr {
    val copyName = StaticJavaParser.parseName(nameAsString)
    return MarkerAnnotationExpr(copyName)
}

/**
 * Check if this [NodeWithAnnotations] has an annotation of the given [name].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.hasAnnotation(name: String) = annotations.any { it.nameAsString == name }

/**
 * Get the annotation specified by its [name] from this [NodeWithAnnotations]. Returns null if the annotation does not
 * exist on this node.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <reified T: AnnotationExpr> NodeWithAnnotations<out Node>.getAnnotation(name: String)
    = annotations.find { it.nameAsString == name && it is T } as? T

/**
 * Get the value for the specified [key] in a value-pair of this [NormalAnnotationExpr].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NormalAnnotationExpr.getValueAsString(key: String) = pairs.find { it.nameAsString == key }?.value?.toString()