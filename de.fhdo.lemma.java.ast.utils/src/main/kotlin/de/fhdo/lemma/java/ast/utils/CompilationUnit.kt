@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.ast.CompilationUnit

/**
 * Get the name of a [CompilationUnit] instance's package declaration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun CompilationUnit.getPackageName() = packageDeclaration.get().name.asString()