package de.fhdo.lemma.model_processing.code_generation.java_base.genlets

import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType
import de.fhdo.lemma.model_processing.code_generation.java_base.findAnnotatedClassesWithInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI

/**
 * Annotation for dependency modifiers. Dependency modifiers allow Genlets arbitrary modifications of dependency
 * specifications expressed in a concrete dependency format (cf.
 * [de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType]) beyond dependencies added in
 * the context of AST nodes (cf. the various forms of the
 * [de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency] function).
 *
 * A dependency modifier must exhibit this annotation and implement the [DependencyModifierI] interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class DependencyModifier

/**
 * Base interface for dependency modifiers (cf. [DependencyModifierI]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface DependencyModifierI<M: Any> {
    fun dependencyType() : DependencyType
    fun modify(inputDependencyModel: M) : M
}

/**
 * Find [DependencyModifierI] implementations from the given [searchPackage], of the modifier class expected by the
 * current [DependencySerializerI] instance, and within other JAR archives leveraging the passed [classLoaders].
 * Because dependency modifiers are only relevant for Genlets, [classLoaders] must not be empty.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findDependencyModifiers(searchPackage: String, dependencySerializer: DependencySerializerI<*>,
    vararg classLoaders: ClassLoader) : List<Class<DependencyModifierI<Any>>> {
    require(classLoaders.isNotEmpty()) { "Class loaders must be passed in order to find dependency modifiers" }

    val expectedModifierClass = dependencySerializer.modifierClass() ?: return emptyList()
    return findAnnotatedClassesWithInterface<DependencyModifierI<Any>>(
            searchPackage,
            DependencyModifier::class.qualifiedName!!,
            *classLoaders,
            interfaceClassname = expectedModifierClass.name
        ).filter { it.getConstructor().newInstance().dependencyType() == dependencySerializer.dependencyType }
}