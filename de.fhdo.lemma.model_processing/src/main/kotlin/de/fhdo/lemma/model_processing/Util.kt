package de.fhdo.lemma.model_processing

import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.utils.LemmaUtils
import io.github.classgraph.ClassInfo
import mu.KotlinLogging
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.fusesource.jansi.Ansi.ansi
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io.PrintStream
import java.io.PrintWriter
import java.io.StringWriter
import java.nio.file.Paths
import javax.xml.stream.XMLInputFactory
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.full.withNullability
import kotlin.reflect.jvm.isAccessible


/**
 * Check if an [Array] contains any of the given elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T> Array<out T>.containsAny(elements: Iterable<T>) = elements.any { contains(it) }

/**
 * Check if an [Set] contains any of the given elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T> Set<T>.containsAny(elements: Iterable<T>) = elements.any{ contains(it) }

/**
 * Create a sub-list from a [List] starting at a given index to [List.size].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <E> List<E>.subList(fromIndex: Int) = subList(fromIndex, size)

/**
 * Convert a [String] to a [File] object.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.asFile() = File(this)

/**
 * Convert a [String] to an XMI [Resource] object.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.asXmiResource() : Resource {
    val file = this.asFile()
    require(file.exists()) { """String "$this" does not represent a file""" }

    val resourceSet = ResourceSetImpl()
    val extensionFactoryMap = Resource.Factory.Registry.INSTANCE.extensionToFactoryMap
    extensionFactoryMap["xmi"] = XMIResourceFactoryImpl()
    val resource = resourceSet.createResource(file.absolutePath.toFileUri())
    resource.load(null)

    return resource
}

/**
 * Convert a [String] to a [URI].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.toFileUri() = URI.createURI(LemmaUtils.convertToFileUri(this))

private const val WARNING_COLOR = "yellow"

/**
 * [print] a phase-specific error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printPhaseError(phase: AbstractModelProcessingPhase, message: String)
    = printError("""Model processing phase "${phase.id}": $message""")

/**
 * [print] an error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printError(message: Any) = System.err.print(message)

/**
 * [println] a phase-specific error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnPhaseError(phase: AbstractModelProcessingPhase, message: String)
    = printlnError("""Model processing phase "${phase.id}": $message""")

/**
 * [println] an error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnError(message: Any) = System.err.println(message)

/**
 * [print] a warning to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnWarning(message: Any, stream: PrintStream = System.out)
    = printlnColor(message, WARNING_COLOR, stream)

/**
 * [println] to the console in a given color.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun printlnColor(message: Any, colorName: String, stream: PrintStream)
    = stream.println(ansi().render("@|$colorName $message|@"))

/**
 * Call all [KFunction] instances in a [List] sequentially.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun List<KFunction<*>>.callAll(vararg args: Any?) = forEach { it.call(*args) }

/**
 * Call all methods of a class that exhibit a certain annotation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: Any>
    Any.callAnnotatedMethods(annotationClass: KClass<out Annotation>, vararg args: Pair<T, KClass<T>>) {
    val parameterClasses = args.map { it.second }.toTypedArray()
    val methods = findAnnotatedMethods(annotationClass, *parameterClasses)
    methods.forEach { it.isAccessible = true }

    val parameterValues = args.map { it.first }.toTypedArray<Any>()
    methods.callAll(this, *parameterValues)
}

/**
 * Infix function to create a [Pair] of [Any] instance and its [KClass].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal infix fun <V: Any> V.withType(clazz: KClass<V>) : Pair<V, KClass<V>> = Pair(this, clazz)

/**
 * Find a certain method on [Any] instance with the given expected return type and parameters. Note that the comparison
 * between the provided expected and method types is based on equality (and not on subtyping relationships). If no
 * method could be found, return null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Any.getMethod(name: String, returnTypeClass: KClass<*> = Unit::class, vararg parameterClasses: KClass<*>)
    : KFunction<*>? {
    val methods = this::class.memberFunctions.filter { it.name == name }
    if (methods.isEmpty())
        return null

    for (method in methods) {
        // Check return type for equality
        val expectedReturnType = returnTypeClass.starProjectedType
        val returnType = method.returnType.withNullability(expectedReturnType.isMarkedNullable)
        if (returnType != expectedReturnType)
            continue

        // Check value parameters for equality
        val valueParameters = method.parameters.filter{ it.kind == KParameter.Kind.VALUE }
        if (valueParameters.size != parameterClasses.size)
            continue

        var parameterTypesMatch = true
        for (n in valueParameters.indices) {
            val parameter = valueParameters[n]
            val expectedParameterType = parameterClasses[n].starProjectedType
            val parameterType = parameter.type.withNullability(expectedParameterType.isMarkedNullable)
            if (parameterType != expectedParameterType) {
                parameterTypesMatch = false
                break
            }
        }

        if (parameterTypesMatch)
            return method
    }

    return null
}

/**
 * Generic helper to check that a class on the classpath extends a certain superclass and/or interface. Otherwise, an
 * IllegalStateException is thrown.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassInfo.extendsImplementsOrException(classSemantics: String, expectedSuperclass: KClass<*>? = null,
    expectedInterface: KClass<*>? = null) {
    if (expectedSuperclass != null && !extendsSuperclass(expectedSuperclass.java.name))
        throw IllegalStateException("$classSemantics $name must extend $expectedSuperclass")

    if (expectedInterface != null && !implementsInterface(expectedInterface.java.name))
        throw IllegalStateException("$classSemantics $name must implement $expectedInterface")
}

/**
 * Read all modeling-related ("custom") namespaces from an XMI file. That is, all XML namespace declarations besides the
 * default ones, i.e., "xsi" and "xmi".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun readModelingNamespacesFromXmi(xmiFile: String) : Set<String> {
    val inputFactory = XMLInputFactory.newInstance()
    val fis = FileInputStream(xmiFile)
    val eventReader = inputFactory.createXMLEventReader(fis)

    val modelingNamespaces = mutableSetOf<String>()
    while (eventReader.hasNext()) {
        val event = eventReader.nextEvent()
        if (event.isStartElement) {
            val namespaceDefiningElement = event.asStartElement()
            namespaceDefiningElement.namespaces.forEach { namespace ->
                val namespaceHasXmlPrefix = namespace.name.prefix.toLowerCase() == "xmlns"
                val localPart = namespace.name.localPart.toLowerCase()
                val hasCustomLocalPart = localPart != "xmi" && localPart != "xsi"
                // Ignore "kotlin.Unit" default namespace
                if (namespaceHasXmlPrefix && hasCustomLocalPart)
                    modelingNamespaces += namespace.value
            }

            // The first ever element in the XMI file defines the namespace
            break
        }
    }

    eventReader.close()
    fis.close()

    return modelingNamespaces
}

/**
 * Check if a path is a child of another path.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal infix fun String.isChildPathOf(parent: String) = Paths.get(this).startsWith(Paths.get(parent).normalize())

/**
 * Load a file as an Xtext resource.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun loadXtextResource(languageSetup: ISetup, filepath: String, inputStream: InputStream) : XtextResource {
    val injector = languageSetup.createInjectorAndDoEMFRegistration()
    val resourceSet = injector.getInstance(XtextResourceSet::class.java)
    resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, java.lang.Boolean.TRUE)
    val resource = resourceSet.createResource(filepath.toFileUri())
    resource.load(inputStream, resourceSet.loadOptions)
    return resource as XtextResource
}

/**
 * Get absolute base path of this [Resource]. The absolute base path of a resource corresponds to its URI without the
 * scheme.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Resource.absoluteBasePath()
    = this.uri.let {
        val scheme = it.scheme()?.toString() ?: ""
        it.toString()
            .removePrefix(scheme)
            // Remove possibly remaining colon prefix, e.g., for a URI in the form "file:/myFolder/example.file"
            .removePrefix(":")
    }

/**
 * Retrieve the main interface of this [EObject] instance, which is the first interface of the [EObject] instance that
 * can be cast to the [EObject] interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
internal fun EObject.ecoreMainInterface()
    = this::class.java.interfaces.find {
        (it as? Class<out EObject>) != null
    } as? Class<out EObject>?

/**
 * Convert this [Throwable]'s stack trace to a String.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Throwable.stackTraceAsString() : String {
    val writer = StringWriter()
    printStackTrace(PrintWriter(writer))
    return writer.toString()
}

private val LOGGER = KotlinLogging.logger {}

/**
 * Convenience function to log a debug [message] of type [String] with kind "basic" when the user activated debugging
 * via the [BasicCommandLine].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
fun debug(message: String) = debug("basic") { message }

/**
 * Log a debug [message] with kind "basic" when the user activated debugging via the [BasicCommandLine].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun debug(message: () -> Any?) = debug("basic", message)

/**
 * Log a debug [message] with kind [messageKindIdentifier] when the user activated debugging via the [BasicCommandLine].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun debug(messageKindIdentifier: String, message: () -> Any?) {
    if (BasicCommandLine.debugMessageKinds.isEmpty() ||
        BasicCommandLine.debugMessageKinds.contains(messageKindIdentifier))
        LOGGER.debug(message)
}

/**
 * Convenience function to log a debug [message] of type [String] with kind "basic" from within a model processing
 * phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
fun debugPhase(message: String) = debugPhase("basic") { message }

/**
 * Log a debug [message] with kind "basic" from within a model processing phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun debugPhase(message: () -> Any?) = debugPhase("basic", message)

/**
 * Log a debug [message] from within a model processing phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun debugPhase(messageKindIdentifier: String = "basic", message: () -> Any?)
    = debug(messageKindIdentifier) { "\t${message.invoke().toString()}" }

/**
 * Log the arguments passed to a phase in a debug message.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun debugPhaseArguments(args: Array<String>) {
    if (args.isNotEmpty()) {
        debugPhase { "Phase arguments: " }
        args.forEach { debugPhase { "\t- $it" } }
    } else
        debugPhase { "No phase arguments given" }
}

/**
 * Version of [toSet] that ensures the production of a [LinkedHashSet].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T> Iterable<T>.toLinkedHashSet()
    = if (this is Collection) {
            when (size) {
                0 -> toCollection(LinkedHashSet(0))
                1 -> toCollection(LinkedHashSet(1))
                else -> toSet() as LinkedHashSet<T>
            }
        } else
            toSet() as LinkedHashSet<T>