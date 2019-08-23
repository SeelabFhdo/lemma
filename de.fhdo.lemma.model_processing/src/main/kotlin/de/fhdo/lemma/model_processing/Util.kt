package de.fhdo.lemma.model_processing

import de.fhdo.lemma.model_processing.annotations.findAnnotatedMethods
import io.github.classgraph.ClassInfo
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.fusesource.jansi.Ansi.ansi
import java.io.File
import java.io.FileInputStream
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
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
 * Find the first entry of a certain instance in an [Iterable]. Returns null, if there is none.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal inline fun <reified R> Iterable<*>.findIsInstance() = filterIsInstance<R>().firstOrNull()

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
 * Convert a [String] to a [File] object
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.asFile() = File(this)

fun String.asXmiResource() : Resource {
    val file = this.asFile()
    if (!file.exists())
        throw IllegalArgumentException("String \"$this\" does not represent a file")

    val resourceSet = ResourceSetImpl()
    val extensionFactoryMap = Resource.Factory.Registry.INSTANCE.extensionToFactoryMap
    extensionFactoryMap["xmi"] = XMIResourceFactoryImpl()
    val resource = resourceSet.createResource(URI.createURI(this)) as Resource
    resource.load(null)

    return resource
}

private const val ERROR_COLOR = "red"
private const val WARNING_COLOR = "yellow"

/**
 * [print] to the console in a given color.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printColor(message: Any, colorName: String) = print(ansi().render("@|$colorName $message|@"))

/**
 * [print] an error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printError(message: Any) = printColor(message, ERROR_COLOR)

/**
 * [print] a warning to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printWarning(message: Any) = printColor(message, WARNING_COLOR)

/**
 * [println] to the console in a given color.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnColor(message: Any, colorName: String) = println(ansi().render("@|$colorName $message|@"))

/**
 * [println] an error to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnError(message: Any) = printlnColor(message, ERROR_COLOR)

/**
 * [print] a warning to the console.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun printlnWarning(message: Any) = printlnColor(message, WARNING_COLOR)

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
        for (n in 0 until valueParameters.size) {
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

    if (expectedInterface != null && !interfaces.containsName(expectedInterface.java.name))
        throw IllegalStateException("$classSemantics $name must implement $expectedInterface")
}

/**
 * Read all modeling-related ("custom") namespaces from an XMI file. That is, all XML namespace declarations besides the
 * default ones, i.e., "xsi" and "xmi.
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
 * Check if a path is a child of another path
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal infix fun String.isChildPathOf(parent: String) = Paths.get(this).startsWith(Paths.get(parent).normalize())