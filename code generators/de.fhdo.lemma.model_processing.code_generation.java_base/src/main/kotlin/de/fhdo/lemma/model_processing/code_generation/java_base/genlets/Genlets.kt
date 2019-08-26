package de.fhdo.lemma.model_processing.code_generation.java_base.genlets

import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findAspectHandlers as baseFindAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findCodeGenerationHandlers as baseFindCodeGenerationHandlers
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.net.URLClassLoader
import java.util.regex.Pattern
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KProperty

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
    fun invoke(eObject: T, node: N, context: C? = null) = execute(eObject, node, context)

    /**
     * Function which needs to be realized by concrete Genlet code generation handlers. The context is an optional
     * information that may be passed to a handler, e.g., the previously generated parent [Node] of the yet-to-generate
     * [Node]. Currently, this is not done for Genlet code generation handlers, however.
     *
     * A Genlet code generation handler can either return null (i.e., no AST [Node] was reified at all for the given
     * [EObject] and context), or an instance of [GenletCodeGenerationHandlerResult].
     */
    fun execute(eObject: T, node: N, context: C? = null) : GenletCodeGenerationHandlerResult<N>?

    /**
     * Get access to certain state values provided by the Java base generator to the Genlet
     */
    fun state() = GenletStateAccess

    override fun invoke(eObject: T, context: C?) : Pair<N, String?>? {
        throw OperationNotSupportedException("Genlet code generation handlers do not support this kind of invocation")
    }

    override fun execute(eObject: T, context: C?) : Pair<N, String?>? {
        throw OperationNotSupportedException("Genlet code generation handlers do not support this kind of execution")
    }
}

/**
 * Class to encapsulate the result of a [GenletCodeGenerationHandlerI] invocation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class GenletCodeGenerationHandlerResult<N: Node>(val reifiedNode: N,
    val generatedFileContents: MutableSet<GenletGeneratedFileContent> = mutableSetOf()) {
    /**
     * Get the [Node] instance that was reified by the invocation of the [GenletCodeGenerationHandlerI]
     */
    operator fun component1() = reifiedNode

    /**
     * Get the file contents that were generated during the invocation of the [GenletCodeGenerationHandlerI]
     */
    operator fun component2() = generatedFileContents
}

/**
 * Represents the content of a file generated by a [GenletCodeGenerationHandlerI].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class GenletGeneratedFileContent(val baseTargetFolderSpecifier: GENLET_PATH_SPECIFIER, val filename: String,
    val generatedContent: String)  {
    /**
     * Get the full path of the generated file. It consists of the resolved path of the [baseTargetFolderSpecifier] and
     * the [filename] of this [GenletGeneratedFileContent] instance.
     */
    fun getFullPath(fileContent: GenletGeneratedFileContent = this) : String {
        val baseTargetFolderPath = GENLET_PATH_SPECIFIER.resolvePathSpecifier(fileContent.baseTargetFolderSpecifier)
        return "$baseTargetFolderPath${File.separator}${fileContent.filename}"
    }

    /**
     * Two [GenletGeneratedFileContent] instances are equal, if their full paths are equal
     */
    override fun equals(other: Any?) : Boolean {
        if (this === other)
            return true

        if (other === null)
            return false
        else if (other !is GenletGeneratedFileContent)
            return false

        return getFullPath() == getFullPath(other)
    }

    /**
     * The hash code of a [GenletGeneratedFileContent] is equal to the hash code of its full path
     */
    override fun hashCode() = getFullPath().hashCode()
}

/**
 * Enumeration to abstract the path in which a Genlet can generate file contents (cf. [GenletGeneratedFileContent]).
 * This is to give Genlets a convenient interface to specify the location to which file contents generated by them shall
 * be written in the context of a run of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class GENLET_PATH_SPECIFIER {
    CURRENT_MICROSERVICE_PATH;

    companion object {
        /**
         * Resolve a [GENLET_PATH_SPECIFIER] value to a concrete path
         */
        internal fun resolvePathSpecifier(specifier : GENLET_PATH_SPECIFIER) : String {
            return when (specifier) {
                CURRENT_MICROSERVICE_PATH -> {
                    val currentMicroserviceTargetFolderPathForJavaFiles: String by MainState
                    currentMicroserviceTargetFolderPathForJavaFiles
                }
            }
        }
    }
}

/**
 * Provide Genlets access to certain state information in the context of a run of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object GenletStateAccess {
    /**
     * Get the value of a specific state information
     */
    operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
        val value = when(property.name) {
            "currentMicroservicePackage" -> {
                val currentMicroservicePackage: String by MainState
                currentMicroservicePackage
            }

            "currentDomainPackage" -> {
                val currentDomainPackage: String by DomainState
                currentDomainPackage
            }
            else -> throw IllegalArgumentException("Genlet state does not comprise property ${property.name}")
        }

        return value as T
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