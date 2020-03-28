package de.fhdo.lemma.model_processing.code_generation.java_base.genlets

import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType
import de.fhdo.lemma.model_processing.code_generation.java_base.findAnnotatedClassesWithInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI

/**
 * Annotation for dependency fragment providers. Dependency fragment providers allow Genlets to enrich dependency
 * specifications expressed in a concrete dependency format (cf.
 * [de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType]) with additional fragments
 * beyond dependencies added in the context of AST nodes (cf. the various forms of the
 * [de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency] function).
 *
 * A dependency fragment provider must exhibit this annotation and implemennt the [DependencyFragmentProviderI]
 * interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class DependencyFragmentProvider

/**
 * Base interface for dependency fragment providers (cf. [DependencyFragmentProvider]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface DependencyFragmentProviderI<I: Any, O: Any> {
    fun dependencyType() : DependencyType
    fun provideFragmentFor(inputDependencyModel: I) : O
}

/**
 * Find [DependencyFragmentProviderI] implementations from the given [searchPackage], of the provider class expected by
 * the current [DependencySerializerI] instance, and within other JAR archives leveraging the passed [classLoaders].
 * Because dependency fragment providers are only relevant for Genlets, [classLoaders] must not be empty.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findDependencyFragmentProviders(searchPackage: String, dependencySerializer: DependencySerializerI<*, *>,
    vararg classLoaders: ClassLoader) : List<Class<DependencyFragmentProviderI<Any, Any>>> {
    require(classLoaders.isNotEmpty()) { "Class loaders must be passed in order to find dependency fragment providers" }

    val expectedProviderClass = dependencySerializer.fragmentProviderClass() ?: return emptyList()
    return findAnnotatedClassesWithInterface<DependencyFragmentProviderI<Any, Any>>(
            searchPackage,
            DependencyFragmentProvider::class.qualifiedName!!,
            *classLoaders,
            interfaceClassname = expectedProviderClass.name
        ).filter { it.getConstructor().newInstance().dependencyType() == dependencySerializer.dependencyType }
}