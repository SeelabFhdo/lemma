package de.fhdo.lemma.model_processing.code_generation.java_base.genlets

import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.serialize
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.mergePropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findAspectHandlers as baseFindAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findCodeGenerationHandlers as baseFindCodeGenerationHandlers
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.utils.countLines
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.net.URLClassLoader
import java.util.regex.Pattern
import javax.naming.OperationNotSupportedException
import kotlin.reflect.KProperty

/**
 * Base class for Genlets. A Genlet gathers code that can contribute information to generated AST [Node] instances in
 * another JAR archive than that of the Java base generator. For example, Genlets allow to generate Java class
 * attributes with technology-specific types from a Java-based supportive technology such as the Spring framework
 * (Genlet-specific code generation handlers) or reify generated AST [Node] instances with technology-specific
 * annotations (aspect handlers within Genlets). Genlets are always [AbstractModelProcessor]s in the sense of LEMMA's
 * model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractGenlet(processorImplementationPackage: String)
    : AbstractModelProcessor(processorImplementationPackage) {
    internal lateinit var filePath : String

    /**
     * Name of the Genlet package that clusters Genlet-specific code generation handlers
     */
    abstract fun nameOfCodeGenerationHandlerPackage() : String

    /**
     * Name of the Genlet package that clusters aspect handlers. By default, this is the same package as for the Genlet-
     * specific code generation handlers.
     */
    open fun nameOfAspectHandlerPackage() = nameOfCodeGenerationHandlerPackage()

    /**
     * Name of the Genlet package that clusters dependency modifiers. By default, this is the same package as for the
     * Genlet-specific code generation handlers.
     */
    open fun nameOfDependencyModifierPackage() = nameOfCodeGenerationHandlerPackage()

    /**
     * Callback to pass Genlet-specific class loader to Genlet.
     */
    open fun setClassLoader(classLoader: ClassLoader) {}

    /**
     * Retrieve Genlet-specific heap.
     */
    fun heap() = GenletHeapManager.getOrAddHeap(this)

    /**
     * React to a certain event, e.g., the end of the generation process for the current microservice. During events,
     * Genlets may generate an arbitrary number of new Nodes, adapt existing Nodes, or produce new file contents.
     * Returned Node instances will be passed to the current serializer, while generated file contents are not
     * processed, but stored "as is".
     */
    open fun onEvent(event: GenletEvent) : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? = null

    /**
     * Send an event to this Genlet.
     */
    internal fun sendEvent(event: GenletEvent) {
        val generatedNodesAndFiles = onEvent(event) ?: return
        val (generatedNodes, generatedFiles) = generatedNodesAndFiles

        // Serialize Node instances being received from the event leveraging the current serializer
        val codeGenerationSerializer: CodeGenerationSerializerI by MainState
        generatedNodes.forEach {
            val generatedFileContents = codeGenerationSerializer.serialize(it.generatedNode, it.folderPath, it.filePath)
            generatedFileContents.forEach { (targetFilePath, generationResult) ->
                val (generatedContent, _) = generationResult
                MainState.addGeneratedFileContent(generatedContent, targetFilePath)
            }
        }

        // Generated file contents from the event are directly stored in the main state without any additional
        // serialization action
        storeGeneratedFileContentsOfGenlet(generatedFiles)
    }
}

/**
 * Singleton to manage Genlet heaps. A Genlet heap is a [MutableMap], which enables a Genlet to store and retrieve
 * arbitrary values at any point in its runtime.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object GenletHeapManager {
    val heaps = mutableMapOf<AbstractGenlet, MutableMap<String, Any?>>()

    /**
     * Get heap for the given Genlet or create and return a new heap
     */
    fun getOrAddHeap(genlet: AbstractGenlet) : MutableMap<String, Any?> {
        if (genlet !in heaps)
            heaps[genlet] = mutableMapOf()
        return heaps[genlet]!!
    }
}

/**
 * This class clusters information about a Genlet event. More specifically, it assigns a [GenletEventType] to a set of
 * [GenletEventObject] instances and object-specific values.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class GenletEvent(val type: GenletEventType) {
    private val eventInfo = mutableMapOf<GenletEventObject, Any>()

    /**
     * Constructor
     */
    constructor(type: GenletEventType, vararg eventInfo: Pair<GenletEventObject, Any>) : this(type) {
        this.eventInfo.putAll(eventInfo)
    }

    /**
     * Assign a (new) [value] to the given [eventObject]
     */
    operator fun set(eventObject: GenletEventObject, value: Any) {
        eventInfo[eventObject] = value
    }

    /**
     * Get the current value of the given [eventObject] or null, if it does not have a value
     */
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(eventObject: GenletEventObject)
        = if (eventObject in eventInfo) eventInfo[eventObject] as T else null
}

/**
 * Enumeration that identifies possible Genlet events.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class GenletEventType {
    // Genlet was loaded
    GENLET_LOADED,

    // Processing of intermediate EObject starts
    INTERMEDIATE_EOBJECT_PROCESSING_STARTS,

    // Generation of current microservice was finished
    MICROSERVICE_GENERATION_FINISHED,

    // Overall code generation has finished
    OVERALL_GENERATION_FINISHED
}

/**
 * Enumeration that identifies possible Genlet event objects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class GenletEventObject {
    INTERMEDIATE_EOBJECT,

    // Generated microservice class in the form of a ClassOrInterfaceDeclaration instance
    GENERATED_MICROSERVICE_CLASS
}

/**
 * Helper to store [GenletGeneratedFileContent] instances in the main state.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun storeGeneratedFileContentsOfGenlet(generatedFiles: Set<GenletGeneratedFileContent>) {
    val writeLineCountInfo: Boolean by MainState
    generatedFiles.forEach { fileContent ->
        val (filePath, generatedContent, generatedPropertyFile) = fileContent
        if (generatedContent != null) {
            MainState.addGeneratedFileContent(generatedContent, filePath)

            if (writeLineCountInfo)
                MainState.addOrUpdateGeneratedLineCountInfo(
                    LineCountInfo(filePath, generatedContent.countLines(forFile = filePath))
                )
        } else
            // If the Genlet did not generate the raw string content of a file, it must have created a property
            // file. Created property files are merged into existing property files, if possible. Line counting
            // of property files is done later when they are serialized.
            mergePropertyFile(generatedPropertyFile!!)
    }
}

/**
 * Represents a Node instance generated by a Genlet's onEvent() callback.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class GenletGeneratedNode(baseTargetFolderSpecifier: GenletPathSpecifier, val filePath: String,
    val generatedNode: Node) {
    var folderPath: String
        private set

    /**
     * Init block
     */
    init {
        folderPath = GenletPathSpecifier.resolvePathSpecifier(baseTargetFolderSpecifier)
    }

    /**
     * Two [GenletGeneratedNode] instances are equal, if their [filePath] values are equal
     */
    override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is GenletGeneratedFileContent) filePath == other.filePath
            else false

    /**
     * The hash code of a [GenletGeneratedNode] is equal to the hash code of its [filePath]
     */
    override fun hashCode() = filePath.hashCode()
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
     * Function which needs to be realized by concrete Genlet code generation handlers. The context is an optional
     * information that may be passed to a handler, e.g., the previously generated parent [Node] of the yet-to-generate
     * [Node]. Currently, this is not done for Genlet code generation handlers, however.
     *
     * A Genlet code generation handler can either return null (i.e., no AST [Node] was reified at all for the given
     * [EObject] and context) or an instance of [GenletCodeGenerationHandlerResult].
     */
    fun execute(eObject: T, node: N, context: C? = null) : GenletCodeGenerationHandlerResult<N>?

    /**
     * Get access to certain state values provided by the Java base generator to the Genlet
     */
    @JvmDefault  // Streamline interface usage for Java-based Genlets
    fun state() = GenletStateAccess

    @JvmDefault  // Streamline interface usage for Java-based Genlets
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
class GenletGeneratedFileContent {
    private var generatedContent: String? = null
    private var propertyFile: PropertyFile? = null
    var filePath: String
        private set

    /**
     * Constructor for [generatedContent] of the file [filename] to be stored in the given [baseTargetFolderSpecifier].
     */
    constructor(baseTargetFolderSpecifier: GenletPathSpecifier, filename: String, generatedContent: String) {
        this.generatedContent = generatedContent
        filePath = "${GenletPathSpecifier.resolvePathSpecifier(baseTargetFolderSpecifier)}${File.separator}$filename"
    }

    /**
     * Constructor for [generatedNode] of the file [filename] to be stored in the given [baseTargetFolderSpecifier]. The
     * [generatedNode] will directly be serialized.
     */
    constructor(baseTargetFolderSpecifier: GenletPathSpecifier, filename: String, generatedNode: Node) {
        val serializationConfiguration: AbstractSerializationConfiguration by MainState
        this.generatedContent = generatedNode.serialize(serializationConfiguration)
        filePath = "${GenletPathSpecifier.resolvePathSpecifier(baseTargetFolderSpecifier)}${File.separator}$filename"
    }

    /**
     * Constructor for a [propertyFile] created by the Genlet.
     */
    constructor(propertyFile: PropertyFile) {
        this.propertyFile = propertyFile
        filePath = propertyFile.filePath
    }

    /**
     * Get the full [filePath] of this content
     */
    operator fun component1() = filePath

    /**
     * Get the [generatedContent]. If null, the Genlet created a [propertyFile] instead.
     */
    operator fun component2() = generatedContent

    /**
     * Get the [propertyFile]. If null, the Genlet created [generatedContent] instead.
     */
    operator fun component3() = propertyFile

    /**
     * Two [GenletGeneratedFileContent] instances are equal, if their file paths are equal
     */
    override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is GenletGeneratedFileContent) filePath == other.filePath
            else false

    /**
     * The hash code of a [GenletGeneratedFileContent] is equal to the hash code of its file path
     */
    override fun hashCode() = filePath.hashCode()
}

/**
 * Enumeration to abstract the path in which a Genlet can generate file contents (cf. [GenletGeneratedFileContent]).
 * This is to give Genlets a convenient interface to specify the location to which file contents generated by them shall
 * be written in the context of a run of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class GenletPathSpecifier {
    CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
    CURRENT_MICROSERVICE_RESOURCES_PATH,
    CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
    CURRENT_DOMAIN_GENERATION_TARGET_PATH,
    CURRENT_INTERFACE_GENERATION_TARGET_PATH;

    companion object {
        /**
         * Resolve a [GenletPathSpecifier] value to a concrete path
         */
        internal fun resolvePathSpecifier(specifier: GenletPathSpecifier) : String {
            return when (specifier) {
                CURRENT_MICROSERVICE_JAVA_ROOT_PATH -> {
                    val currentMicroserviceTargetFolderPathForJavaFiles: String by MainState
                    currentMicroserviceTargetFolderPathForJavaFiles
                }

                CURRENT_MICROSERVICE_RESOURCES_PATH -> {
                    val currentMicroserviceTargetFolderPathForResourceFiles: String by MainState
                    currentMicroserviceTargetFolderPathForResourceFiles
                }

                CURRENT_MICROSERVICE_GENERATION_TARGET_PATH -> {
                    val currentMicroserviceGenerationTargetFolderPath: String by ServicesState
                    currentMicroserviceGenerationTargetFolderPath
                }

                CURRENT_DOMAIN_GENERATION_TARGET_PATH -> {
                    val currentDomainTargetFolderPath: String by DomainState
                    currentDomainTargetFolderPath
                }

                CURRENT_INTERFACE_GENERATION_TARGET_PATH -> {
                    val currentInterfacesGenerationTargetFolderPath: String by ServicesState
                    currentInterfacesGenerationTargetFolderPath
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
    @Suppress("UNCHECKED_CAST")
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
@Suppress("UNCHECKED_CAST")
internal fun loadGenlets(genletFilePathsAndClassnames: Map<String, String?>) : Map<AbstractGenlet, URLClassLoader> {
    val classLoaders = createGenletClassLoaders(genletFilePathsAndClassnames.keys)
    return genletFilePathsAndClassnames.map { (filePath, explicitlySpecifiedClassname) ->
        val genletClassLoader = classLoaders[filePath]!!
        val genletClassnames = explicitlySpecifiedClassname?.let { listOf(it) }
            ?: filePath.inferDefaultGenletClassnames()

        // Search Genlet class in JAR archive via Genlet's class loader and based on explicit or default Genlet class
        // name(s)
        var genletClass: Class<out AbstractGenlet>? = null
        for (classname in genletClassnames) {
            genletClass = try {
                Class.forName(classname, true, genletClassLoader) as Class<AbstractGenlet>
            } catch (ex : ClassNotFoundException) {
                null
            }

            if (genletClass != null)
                break
        }

        if (genletClass == null)
            throw PhaseException("""No Genlet classes found in file "$filePath" (search names: """ +
                "${genletClassnames.joinToString()}).")

        // Load Genlet class instance
        try {
            val genletInstance = genletClass.getConstructor().newInstance()
            genletInstance.setClassLoader(genletClassLoader)
            genletInstance.filePath = filePath
            genletInstance to genletClassLoader
        } catch (ex: Exception) {
            throw PhaseException("Genlet class ${genletClass.simpleName} from $filePath could not be loaded: " +
                ex.message)
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
 * Helper to infer the default fully-qualified names of a Genlet class from the file path to its JAR archive. The
 * default names are built by assuming that the filename of the Genlet's JAR archive is fully-qualified, e.g.,
 * "org.example.mygenlet.jar" or "org.example.mygenlet-0.0.1-SNAPSHOT.jar" (i.e., what is typically created by a
 * build tool like Maven or Gradle). From such a filename, several "heuristics" are employed to derive allowed default
 * Genlet classnames.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.inferDefaultGenletClassnames() : Set<String> {
    val inferredClasspathFromFilePath = listOf(
            // Pattern with version, e.g., org.example.my_genlet-0.0.1-SNAPSHOT.jar
            Pattern.compile("(?<classpath>.*?)\\-.*\\.jar"),

            // Pattern without version, e.g., org.example.my_genlet.jar
            Pattern.compile("(?<classpath>.*?)\\.jar")
        ).map { it.matcher(this.asFile().name) }
        .find { it.matches() }
        ?.group("classpath") ?: ""

    val genletClassnames = listOfNotNull(
        inferredClasspathFromFilePath.plainGenletClassname(),
        inferredClasspathFromFilePath.underscoreAwareGenletClassname()
    )

    return if (inferredClasspathFromFilePath.isNotEmpty())
            genletClassnames.map { "$inferredClasspathFromFilePath.$it" }.toSet()
        else
            genletClassnames.toSet()
}

/**
 * "Plain Genlet classname" heuristic for default Genlet classnames. From this [String] representing a Genlet classpath
 * the last classpath part is extracted, capitalized, and extended by the [GENLET_CLASSNAME_SUFFIX]. That is, for the
 * classpath "org.example.mygenlet", the heuristic would yield the Genlet classname "MygenletGenerator".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.plainGenletClassname() = substringAfterLast(".").capitalize() + GENLET_CLASSNAME_SUFFIX

/**
 * Suffix for Genlet classnames.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private const val GENLET_CLASSNAME_SUFFIX = "Generator"

/**
 * "Underscore-aware Genlet classname" heuristic for default Genlet classnames. From this [String] representing a Genlet
 * classpath the last classpath part is extracted and split at underscore occurrences. The resulting "underscore parts"
 * are capitalized, joined together, and extended by the [GENLET_CLASSNAME_SUFFIX]. That is, for the classpath
 * "org.example.my_genlet", the heuristic would yield the Genlet classname "MyGenletGenerator".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.underscoreAwareGenletClassname() : String? {
    val lastClasspathPart = substringAfterLast(".")
    return if ("_" in lastClasspathPart)
            lastClasspathPart.split("_").joinToString("") { it.capitalize() } + GENLET_CLASSNAME_SUFFIX
        else
            null
}

/**
 * Convenience function to find aspect handlers in the context of a given [AbstractGenlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun AbstractGenlet.findAspectHandlers(classLoader: ClassLoader)
    = baseFindAspectHandlers(nameOfAspectHandlerPackage(), classLoader)

/**
 * Convenience function to find code generation handlers in the context of a given [AbstractGenlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun AbstractGenlet.findCodeGenerationHandlers(classLoader: ClassLoader)
    = baseFindCodeGenerationHandlers<GenletCodeGenerationHandlerI<EObject, Node, Any>>(
        nameOfCodeGenerationHandlerPackage(),
        classLoader
    )

/**
 * Convenience function to find dependency modifiers in the context of a given [AbstractGenlet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun AbstractGenlet.findDependencyModifiers(classLoader: ClassLoader,
    dependencySerializer: DependencySerializerI<*>)
    = findDependencyModifiers(nameOfDependencyModifierPackage(), dependencySerializer, classLoader)

/**
 * Data key for Genlet-related node information.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object GenletNodeInfoDataKey : DataKey<MutableMap<String, Any?>>()

/**
 * Set Genlet-related information [value] for [key] at this [Node]. The information is bound to the [Node] only and can
 * thus be shared across different Genlets.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.setGenletNodeInfo(key: String, value: Any?) {
    val nodeInfo = if (containsData(GenletNodeInfoDataKey))
            getData(GenletNodeInfoDataKey)
        else
            mutableMapOf()

    nodeInfo[key] = value
    setData(GenletNodeInfoDataKey, nodeInfo)
}

/**
 * Get Genlet-related information for [key] from this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.getGenletNodeInfo(key: String) : Any? = getData(GenletNodeInfoDataKey)[key]

/**
 * Get Genlet-related information for [key] from this [Node] or return [elseValue], if the [key] for the
 * Genlet-related information does not exist.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.getGenletNodeInfoOrElse(key: String, elseValue: Any?)
    = if (hasGenletNodeInfo(key))
            getGenletNodeInfo(key)
        else
            elseValue

/**
 * Check if [key] for Genlet-related information exists for this [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.hasGenletNodeInfo(key: String)
    = if (containsData(GenletNodeInfoDataKey))
    key in getData(GenletNodeInfoDataKey)
else
    false

/**
 * Convenience method for [getGenletNodeInfoOrElse], which returns null if the [key] for the Genlet-related information
 * does not exist.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.getGenletNodeInfoOrElseNull(key: String) = getGenletNodeInfoOrElse(key, null)

/**
 * Remove Genlet-related information for [key] from this [Node]. Returns true, if the key existed and false otherwise.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.removeGenletNodeInfo(key: String)
    = if (hasGenletNodeInfo(key)) {
            getData(GenletNodeInfoDataKey).remove(key)
            true
        } else
            false