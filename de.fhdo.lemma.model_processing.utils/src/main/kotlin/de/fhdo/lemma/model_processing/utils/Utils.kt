package de.fhdo.lemma.model_processing.utils

import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.asXmiResource as asXmiResourceSimple
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.Parameter
import de.fhdo.lemma.service.TechnologyReference
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.technology.mapping.DataOperationMapping
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.io.File
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.util.LinkedList
import java.util.regex.Pattern

/**
 * Check if a string represents a numeric value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.isNumeric() = toIntOrNull() != null

/**
 * Turn a package name into a sub-path by replacing name separators (default value = ".") with OS-specific file
 * separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.packageToPath(nameSeparator: String = ".") = replace(nameSeparator, File.separator)

/**
 * Turn a path into a package name by replacing OS-specific file separators with name separators (default value = ".").
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.pathToPackage(nameSeparator: String = ".") = replace(File.separator, nameSeparator)

/**
 * Trim a (possibly multiline) string literal to a single line. For instance, invoking the function on the multiline
 * string literal
 *      """
 *      System.out.println(
 *          "Hello world"
 *      );
 *      """
 * will result in the single-line string literal
 *      System.out.println("Hello world");
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.trimToSingleLine(preserveTrailingWhitespaces: Boolean = false) = trimIndent().split("\n").joinToString("") {
    if (!preserveTrailingWhitespaces) it.trim() else it.trimStart()
}

/**
 * Get an element at a given index in a list. If the index is invalid, return null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun List<*>.getOrNull(index: Int) = if (isNotEmpty() && index in 0..lastIndex) this[index] else null

/**
 * Insert a value in a map, whose value-type is a [MutableList]. That is, the value will be added to the list being
 * assigned to the given key. In case the key is not part of the map yet, it will be inserted and get a [MutableList]
 * assigned that comprises the given value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <K: Any, V: Any> MutableMap<K, MutableList<V>>.insertValue(key: K, value: V) {
    if (!this.containsKey(key))
        this[key] = LinkedList<V>()
    this[key]!!.add(value)
}

/**
 * Put a value in a map, whose value-type is a [MutableMap]. That is, the value will be put to the [MutableMap] being
 * assigned to the given key. In case the key is not part of the main map yet, it will be inserted and get a
 * [MutableMap] assigned that comprises the given value with the given key for the [MutableMap].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <K1: Any?, K2: Any?, V: Any?> MutableMap<K1, MutableMap<K2, V>>.putValue(key1: K1, key2: K2, value: V) {
    if (!this.containsKey(key1))
        this[key1] = mutableMapOf()
    this[key1]!![key2] = value
}

/**
 * Put a value in a map, whose value-type is a [MutableCollection]. That is, the value will be put to the
 * [MutableCollection] being assigned to the given key. In case the key is not part of the main map yet, it will be
 * inserted and get a [MutableCollection] assigned that comprises the given value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <K: Any?, reified V: Any?, reified C: MutableCollection<V>> MutableMap<K, C>.putValue(key: K, value: V) {
    if (!this.containsKey(key))
        this[key] = when (C::class.java.name) {
            MutableSet::class.java.name -> mutableSetOf<V>() as C
            else -> mutableListOf<V>() as C
        }

    this[key]!!.add(value)
}

/**
 * Convert a [List] of [Pair] instances to a [MutableMap] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <A: Any?, B: Any?> List<Pair<A, B>>.toMutableMap() : MutableMap<A, B> {
    val map = mutableMapOf<A, B>()
    forEach { (first, second) -> map[first] = second }
    return map
}

/**
 * Mapping function for [Pair] instances that clusters instances of the same type. The [transform] lambda is applied to
 * both components of the [Pair] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <A: Any, R: Any> Pair<A, A>.map(transform: (A) -> R) = transform(component1()) to transform(component2())

/**
 * Remove preceding "file://" scheme from a string.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.removeFileUri() : String = LemmaUtils.removeFileUri(this).removePrefix("//")

/**
 * Create an XMI [Resource] from a string that may represent a URI.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.asXmiResource() : Resource = removeFileUri().asXmiResourceSimple()

/**
 * Get the root [EObject] of an Ecore [Resource]. This assumes that the [Resource] has only one [EObject] on its
 * top-level.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
fun <T : EObject> Resource.modelRoot() : T = contents[0] as T

/**
 * Load the root of a model, whose URI or filepath is relative to the given [absoluteBasePath].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <T : EObject> loadModelRootRelative(fileUriOrPath: String, absoluteBasePath: String) : T {
    val absolutePath = LemmaUtils.convertToAbsoluteFileUri(fileUriOrPath.removeFileUri(), absoluteBasePath)
    return absolutePath.asXmiResource().modelRoot()
}

/**
 * Load the root of a model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <T : EObject> loadModelRoot(filePath: String) : T = filePath.asXmiResource().modelRoot()

/**
 * Get the path of an [IntermediateImport] by removing the "file://" scheme from its URI.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateImport.path: String
    get() = importUri.removeFileUri()

/**
 * Get the main interface of an [EObject], which typically corresponds to the class of the [EObject] without the "Impl"
 * suffix.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
val EObject.mainInterface
    get() = this::class.java.interfaces[0] as Class<out EObject>

/**
 * Filter an [IntermediateImport] list by type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EList<IntermediateImport>.filterByType(importType: ImportType)
    = this.filter { it.importTypeName == importType.toString() }

/**
 * Count lines of a String. CRLF, LF, and CR will be considered as linebreak separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.countLines(includeEmptyLines: Boolean = false, includeComments: Boolean = false,
    commentDescription: CommentDescription = JavaCommentDescription) : Int {
    val linesToCount = if (includeEmptyLines)
            lines()
        else
            lines().filter { it.isNotEmpty() && !it.matches("\\s+".toRegex()) }
    val lineCount = linesToCount.count()

    if (includeComments)
        return lineCount

    var commentLineCount = 0
    var inBlockComment = false
    val (blockCommentBegin, blockCommentEnd, lineCommentBegin) = commentDescription
    linesToCount.map { it.trim() }.forEach {
        if (!inBlockComment) {
            if (it.startsWithPrefix(lineCommentBegin))
                commentLineCount++
            else if (it.startsWithPrefix(blockCommentBegin))
                inBlockComment = true
        }

        if (inBlockComment)
            commentLineCount++

        if (it.endsWithSuffix(blockCommentEnd))
            inBlockComment = false
    }

    return lineCount - commentLineCount
}

/**
 * Represents a description of block and line comments for a certain file format as expected by [countLines].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class CommentDescription(
    private val blockCommentBegin: String? = null,
    private val blockCommentEnd: String? = null,
    private val lineCommentBegin: String? = null
) {
    /**
     * Return [blockCommentBegin] in destructuring declarations
     */
    operator fun component1() = blockCommentBegin

    /**
     * Return [blockCommentEnd] in destructuring declarations in case [blockCommentBegin] is defined. Returns null
     * otherwise.
     */
    operator fun component2() = if (blockCommentBegin != null) blockCommentEnd else null

    /**
     * Return [lineCommentBegin] in destructuring declarations
     */
    operator fun component3() = lineCommentBegin
}

/**
 * [CommentDescription] implementation for Java.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object JavaCommentDescription : CommentDescription("/*", "*/", "//")

/**
 * [CommentDescription] implementation for Java properties files.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object PropertiesCommentDescription : CommentDescription(lineCommentBegin = "#")

/**
 * [CommentDescription] implementation for XML.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object XmlCommentDescription : CommentDescription("<!--", "-->")

/**
 * Implementation of [startsWith] that accepts a nullable [prefix]. Returns false, in case the [prefix] is null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.startsWithPrefix(prefix: String?) = if (prefix != null) startsWith(prefix) else false

/**
 * Implementation of [endsWith] that accepts a nullable [suffix]. Returns false, in case the [suffix] is null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.endsWithSuffix(suffix: String?) = if (suffix != null) endsWith(suffix) else false

/**
 * Count lines of a String. CRLF, LF, and CR will be considered as linebreak separators. The [CommentDescription] to be
 * used when [includeComments] is false is determined based on the extension of the [forFile] parameter. If [forFile] is
 * empty, [JavaCommentDescription] will be used as default [CommentDescription].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.countLines(includeEmptyLines: Boolean = false, includeComments: Boolean = false, forFile: String = "")
    = countLines(includeEmptyLines, includeComments, commentDescriptionForFile(forFile))

/**
 * Helper to determine the [CommentDescription] for the given [filePath].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun commentDescriptionForFile(filePath: String)
    = when(filePath.asFile().extension.toLowerCase()) {
        "properties" -> PropertiesCommentDescription
        "xml" -> XmlCommentDescription
        else -> JavaCommentDescription
}

/**
 * Check if the technology with the given [technologyName] was assigned to this [IntermediateMicroservice]. By default,
 * the check is case-insensitive. This behavior can be altered by means of the [ignoreCase] parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateMicroservice.hasTechnology(technologyName: String, ignoreCase: Boolean = true)
    = technologies.any { it.name.equals(technologyName, ignoreCase = ignoreCase) }

/**
 * Check if one of the technologies with a name from the [technologyNames] set was assigned to this
 * [IntermediateMicroservice]. By default, the check is case-sensitive. This behavior can be altered by means of the
 * [ignoreCase] parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateMicroservice.hasTechnology(technologyNames: Set<String>, ignoreCase: Boolean = false)
    = technologyNames.any { hasTechnology(it, ignoreCase) }

/**
 * Find alias of a technology model expressed in the Technology Modeling Language from a [TechnologyReference] list.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun List<TechnologyReference>.findAliasForTechnology(technologyName: String)
    = find {
        val technologyModelFilepath = it.technology.importURI.uriToFilePath()
        val absoluteTechnologyModelFilepath = if (LemmaUtils.representsAbsolutePath(technologyModelFilepath))
                technologyModelFilepath
            else {
                val referencingModelFilepath = it.eResource().uri.toString().uriToFilePath()
                LemmaUtils.convertToAbsolutePath(technologyModelFilepath, referencingModelFilepath)
            }

        val parsedTechnologyName = if (!TechnologyModelCache.wasParsed(absoluteTechnologyModelFilepath)) {
            val parsedTechnologyName = absoluteTechnologyModelFilepath.asFile().naiveTechnologyNameExtraction()!!
            TechnologyModelCache.add(absoluteTechnologyModelFilepath, parsedTechnologyName)
        } else
            TechnologyModelCache.technologyName(absoluteTechnologyModelFilepath)

        parsedTechnologyName == technologyName
    }?.technology?.name

/**
 * Convert this URI to a file path.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.uriToFilePath() = URLDecoder.decode(this, StandardCharsets.UTF_8).removePrefix("file://")

/**
 * The [findAliasForTechnology] function involves expensive scanning of technology model files. We therefore cache the
 * parsed technology models and the names of their technologies.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object TechnologyModelCache {
    private val parsedModels = mutableMapOf<String, String>()

    /**
     * Check if the technology model at [modelFilepath] has already been parsed
     */
    fun wasParsed(modelFilepath: String) = parsedModels.containsKey(modelFilepath)

    /**
     * Add new [technologyName] for technology model at [modelFilepath]
     */
    fun add(modelFilepath: String, technologyName: String) : String {
        parsedModels[modelFilepath] = technologyName
        return technologyName
    }

    /**
     * Get the [technologyName] of the technology model at [modelFilepath]
     */
    fun technologyName(modelFilepath: String) = parsedModels[modelFilepath]
}

/**
 * Naive extraction of a technology's name from its defining technology model. The extraction is naive, because it does
 * not parse the technology model (for performance reasons), but tries to extract the name of the technology based on
 * regular expressions. Note that the extraction approach relies on the keyword "technology" and the technology name to
 * appear on the same line in the scanned [File].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun File.naiveTechnologyNameExtraction() : String? {
    useLines { lines -> lines.forEach {
        val line = it.trim()
        val matcher = TECHNOLOGY_DEFINITION_PATTERN.matcher(line)
        if (matcher.matches())
            return matcher.group("id")
        // Try to recognize file contents that may occur prior to the definition of a technology
        else if (line.isNotEmpty() &&       // Empty lines
            !line.startsWith("import") &&   // Imports of other technology models
            !line.startsWith("//") &&       // Line comments
            !line.startsWith("/*") &&       // Multi-line comment start, ...
            !line.startsWith("*") &&        // content, ...
            !line.startsWith("*/"))         // and end
            return null
    } }
    return null
}

/**
 * Regular expression corresponding to Xtext's terminal rule for IDs.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private const val XTEXT_ID_PATTERN = "(?<id>\\^?(\\p{Alpha}|_)(\\p{Alnum}|_)*)"

/**
 * Regular expression for the introduction of a technology model definition.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val TECHNOLOGY_DEFINITION_PATTERN = Pattern.compile("technology\\s+$XTEXT_ID_PATTERN.*")

/**
 * Get all endpoint addresses of a [Microservice] contained in a service model for the given technology [alias] and
 * [protocol].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Microservice.getEndpointAddresses(alias: String, protocol: String)
    = endpoints.find { e -> e.protocols.any { it.import.name == alias && it.importedProtocol.name == protocol } }
    ?.addresses?.map { it.trim() }
    ?: emptyList()

/**
 * Check if this [EObject] has an [ImportedServiceAspect] instance with the given [name] from the technology with
 * the given [alias]. Targets service model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.hasServiceAspect(alias: String, name: String)
    = serviceAspects().any { it.import.name == alias && it.importedAspect.name == name }

/**
 * Check if this [EObject] has a [TechnologySpecificImportedServiceAspect] instance with the given [name] from the
 * technology with the given [alias]. Targets mapping model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.hasMappingAspect(alias: String, name: String)
    = mappingAspects().any { it.technology.name == alias && it.aspect.name == name }

/**
 * Helper to retrieve [ImportedServiceAspect] instances from this [EObject], if it supports having aspects. Throws
 * [IllegalStateException] otherwise. Targets service model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun EObject.serviceAspects()
    = when(this) {
        is Microservice -> aspects
        is Interface -> aspects
        is Operation -> aspects
        else -> throw IllegalStateException("EObject of type ${javaClass.simpleName} does not have service aspects")
    }

/**
 * Helper to retrieve [TechnologySpecificImportedServiceAspect] instances from this [EObject], if it supports having
 * aspects. Throws [IllegalStateException] otherwise. Targets mapping model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun EObject.mappingAspects()
    = when(this) {
        is ComplexTypeMapping -> aspects
        is DataOperationMapping -> aspects
        is TechnologySpecificFieldMapping -> aspects
        else -> throw IllegalStateException("EObject of type ${javaClass.simpleName} does not have aspects in a " +
            "technology mapping context")
    }

/**
 * Get the [ImportedServiceAspect] instance with the given technology [alias] and [name] from this [EObject]. Targets
 * service model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getServiceAspect(alias: String, name: String)
    = serviceAspects().find { it.import.name == alias && it.importedAspect.name == name }

/**
 * Get the [TechnologySpecificImportedServiceAspect] instance with the given technology [alias] and [name] from this
 * [EObject]. Targets mapping model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getMappingAspect(alias: String, name: String)
    = mappingAspects().find { it.technology.name == alias && it.aspect.name == name }

/**
 * Get all [ImportedServiceAspect] instances with the given technology [alias] and [name] from this [EObject]. Targets
 * service model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAllServiceAspects(alias: String, name: String)
    = serviceAspects().filter { it.import.name == alias && it.importedAspect.name == name }

/**
 * Get all [TechnologySpecificImportedServiceAspect] instances with the given technology [alias] and [name] from this
 * [EObject]. Targets mapping model elements.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAllMappingAspects(alias: String, name: String)
    = mappingAspects().filter { it.technology.name == alias && it.aspect.name == name }

/**
 * Get the String representation of the value of the property [name] from an [ImportedServiceAspect] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun ImportedServiceAspect.getPropertyValue(name: String)
    = if (singlePropertyValue != null && importedAspect.properties.any { it.name == name })
        singlePropertyValue.valueAsString()
    else
        values.find { it.property.name == name }?.value?.valueAsString()

/**
 * Get the String representation of the value of the property [name] from a [TechnologySpecificImportedServiceAspect]
 * instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun TechnologySpecificImportedServiceAspect.getPropertyValue(name: String)
    = if (singlePropertyValue != null && aspect.properties.any { it.name == name })
        singlePropertyValue.valueAsString()
    else
        values.find { it.property.name == name }?.value?.valueAsString()

/**
 * Check for non-fault input parameters of the given [communicationType] of this [Operation] contained in a service
 * model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Operation.hasInputParameters(communicationType: CommunicationType) = countInputParameters(communicationType) > 0

/**
 * Count the non-fault input parameters for the given [communicationType] of this [Operation] contained in a service
 * model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Operation.countInputParameters(communicationType: CommunicationType)
    = parameters.count { it.isInputParameter(communicationType) }

/**
 * Check if this [Parameter] is a non-fault input parameter of the given [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Parameter.isInputParameter(communicationType: CommunicationType)
    = this.communicationType == communicationType &&
        !isCommunicatesFault &&
        (exchangePattern == ExchangePattern.INOUT || exchangePattern == ExchangePattern.IN)

/**
 * Check for non-fault result parameters of the given [communicationType] of this [Operation] contained in a service
 * model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Operation.hasResultParameters(communicationType: CommunicationType) = countResultParameters(communicationType) > 0

/**
 * Count the non-fault result parameters for the given [communicationType] of this [Operation] contained in a service
 * model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Operation.countResultParameters(communicationType: CommunicationType)
    = parameters.count { it.isResultParameter(communicationType) }

/**
 * Check if this [Parameter] is a non-fault result parameter of the given [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Parameter.isResultParameter(communicationType: CommunicationType)
    = this.communicationType == communicationType &&
        !isCommunicatesFault &&
        (exchangePattern == ExchangePattern.INOUT || exchangePattern == ExchangePattern.OUT)