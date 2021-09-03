package de.fhdo.lemma.model_processing.code_generation.java_base.dependencies

import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState

/**
 * Add a new [DependencyDescription] to the collected dependencies of the [MainState] in the context of a certain
 * [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(dependency: DependencyDescription) {
    MainState.addDependency(dependency)
}

/**
 * Add a new dependency represented by a group, artifact, and possibly a version identifier to the collected
 * dependencies of the [MainState] in the context of a certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(group: String, artifact: String, version: String? = null) {
    addDependency(DependencyDescription(group, artifact, version))
}

/**
 * Add a new dependency represented as string to the collected dependencies of the [MainState] in the context of a
 * certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependency(descriptionString: String) {
    addDependency(DependencyDescription.fromString(descriptionString))
}

/**
 * Add [DependencyDescription] list to the collected dependencies of the [MainState] in the context of a certain [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addDependencies(dependencies: Iterable<DependencyDescription>) {
    dependencies.forEach { addDependency(it) }
}