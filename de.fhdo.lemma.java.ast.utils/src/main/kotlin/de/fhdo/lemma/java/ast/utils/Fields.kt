@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.ast.body.FieldDeclaration

/**
 * Set the initialization value of a class's attribute being created by [addAttribute] or its wrappers, e.g.,
 * [addPrivateAttribute].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun FieldDeclaration.setInitializationValue(value: String) = variables[0].setInitializer(value)