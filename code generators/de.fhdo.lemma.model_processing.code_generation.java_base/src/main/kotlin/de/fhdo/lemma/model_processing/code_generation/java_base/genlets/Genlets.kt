package de.fhdo.lemma.model_processing.code_generation.java_base.genlets

import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findAspectHandlers as baseFindAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findCodeGenerationHandlers as baseFindCodeGenerationHandlers
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EObject
import java.net.URLClassLoader
import java.util.regex.Pattern
import javax.naming.OperationNotSupportedException

/**
 * Base interface for Genlets. A Genlet gathers code that can contribute information to generated AST [Node] instances
 * in another JAR archive than that of the Java base generator. For example, Genlets allow to generate Java class
 * attributes with technology-specific types from a Java-based supportive technology such as the Spring framework
 * (Genlet-specific code generation handlers) or reify generated AST [Node] instances with technology-specific
 * annotations (aspect handlers within Genlets).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface Genlet {
    /**
     * Name of the Genlet package that clusters Genlet-specific code generation handlers
     */
    fun nameOfCodeGenerationHandlerPackage() : String

    /**
     * Name of the Genlet package that clusters aspect handlers. By default, this is the same package as of the Genlet-
     * specific code generation handlers.
     */
    fun nameOfAspectHandlerPackage() = nameOfCodeGenerationHandlerPackage()

    /**
     * Name of the Genlet package that clusters dependency fragment providers. By default, this is the same package as
     * of the Genlet-specific code generation handlers.
     */
    fun nameOfDependencyFragmentProviderPackage() = nameOfCodeGenerationHandlerPackage()
}

/**
 * Base interface for Genlet-specific code generation handlers. Note that while for aspect handlers there is no
 * dedicated, Genlet-specific interface, Genlet-specific code generation handlers are distinguished from other types of
 * code generation handlers. That is, to allow for implementing specialized Genlet-specific code generation handlers
 * that may behave differently when their JAR archive is used as a Genlet. Like other code generation handlers,
 * Genlet-specific handlers also need to exhibit the
 * [de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler] annotation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface GenletCodeGenerationHandlerI<T: EObject, N: Node, C: Any> : CodeGenerationHandlerI<T, N, C> {
    /**
     * Function to invoke this Genlet code generation handler. It is not meant to be implemented by concrete handler
     * implementations. They need to implement [execute] instead. Moreover, never call this function directly. It will
     * be called automatically.
     */
    fun invoke(eObject: T, node: N, context: C? = null) : N? = execute(eObject, node, context)

    /**
     * Function which needs to be realized by concrete Genlet code generation handlers. The context is an optional
     * information that may be passed to a handler, e.g., the previously generated parent [Node] of the yet-to-generate
     * [Node]. Currently, this is not done for Genlet code generation handlers, however.
     *
     * A Genlet code generation handler can either return null (i.e., no AST [Node] was reified at all for the given
     * [EObject] and context), or an instance of the reified [Node]
     */
    fun execute(eObject: T, node: N, context: C? = null) : N?

    override fun invoke(eObject: T, context: C?) : Pair<N, String?>? {
        throw OperationNotSupportedException("Genlet code generation handlers do not support this kind of invocation")
    }

    override fun execute(eObject: T, context: C?) : Pair<N, String?>? {
        throw OperationNotSupportedException("Genlet code generation handlers do not support this kind of execution")
    }
}

/**
 * Load Genlet instances from Genlet JAR archives.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun loadGenlets(genletFilePathsAndClassnames: Map<String, String?>) : Map<Genlet, URLClassLoader> {
    val classLoaders = createGenletClassLoaders(genletFilePathsAndClassnames.keys)
    return genletFilePathsAndClassnames.map { (filePath, explicitlySpecifiedClassname) ->
        val genletClassname = explicitlySpecifiedClassname ?: filePath.inferDefaultGenletClassname()
        try {
            val genletClassLoader = classLoaders[filePath]!!
            val genletClass = Class.forName(genletClassname, true, genletClassLoader).asSubclass(Genlet::class.java)
            val genletInstance = genletClass.getConstructor().newInstance()
            genletInstance to genletClassLoader
        } catch (ex: Exception) {
            throw PhaseException("Genlet class $genletClassname from $filePath could not be loaded: ${ex.message}")
        }
    }.toMap()
}

/**
 * Helper to create [URLClassLoader] instances for the paths to the Genlet JAR archives.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun createGenletClassLoaders(genletFilePaths: Iterable<String>) : Map<String, URLClassLoader>
    = genletFilePaths.map {
            val genletUrl = it.asFile().toURI().toURL()
            val genletClassLoader = URLClassLoader.newInstance(arrayOf(genletUrl), ClassLoader.getSystemClassLoader())
            it to genletClassLoader
        }.toMap()

/**
 * Helper to infer the default fully-qualified name of a Genlet class from the file path to its JAR archive. The default
 * name is built by assuming that the filename of the Genlet's JAR archive is fully-qualified, e.g.,
 * "org.example.mygenlet.jar" or "org.example.mygenlet-0.0.1-SNAPSHOT.jar" (i.e., what is typically created by a
 * build tool like Maven or Gradle). From such a filename, the classpath is extracted and extended by the capitalized
 * name of the last namespace part plus the "Generator" suffix. The result is expected to point to a class in a fully-
 * qualified manner. That is, "org.example.mygenlet.jar" and "org.example.mygenlet-0.0.1-SNAPSHOT.jar" would both result
 * in the fully-qualified classname org.example.mygenlet.MygenletGenerator, where the Genlet is expected to reside in
 * the JAR archive.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.inferDefaultGenletClassname() : String {
    val inferredClasspathFromFilePath = listOf(
                // Pattern with version, e.g., org.example.my_genlet-0.0.1-SNAPSHOT.jar
                Pattern.compile("(?<classpath>.*?)\\-.*\\.jar"),

                // Pattern without version, e.g., org.example.my_genlet.jar
                Pattern.compile("(?<classpath>.*?)\\.jar")
        ).map { it.matcher(this.asFile().name) }
        .find { it.matches() }
        ?.group("classpath") ?: ""

    val classname = inferredClasspathFromFilePath.substringAfterLast(".").capitalize() + "Generator"

    return if (inferredClasspathFromFilePath.isNotEmpty())
            "$inferredClasspathFromFilePath.$classname"
        else
            classname
}

/**
 * Convenience function to find aspect handlers in the context of a given [Genlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Genlet.findAspectHandlers(classLoader: ClassLoader)
        = baseFindAspectHandlers(nameOfAspectHandlerPackage(), classLoader)

/**
 * Convenience function to find code generation handlers in the context of a given [Genlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Genlet.findCodeGenerationHandlers(classLoader: ClassLoader)
    = baseFindCodeGenerationHandlers<GenletCodeGenerationHandlerI<EObject, Node, Any>>(
        nameOfCodeGenerationHandlerPackage(),
        classLoader
    )

/**
 * Convenience function to find dependency fragment providers in the context of a given [Genlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Genlet.findDependencyFragmentProviders(classLoader: ClassLoader,
    dependencySerializer: DependencySerializerI<*, *>)
    = findDependencyFragmentProviders(nameOfDependencyFragmentProviderPackage(), dependencySerializer, classLoader)