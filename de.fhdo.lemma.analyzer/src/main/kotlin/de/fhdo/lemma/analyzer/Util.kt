package de.fhdo.lemma.analyzer

import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import java.io.File

/**
 * Get the last folder and filename of this [File]. For a file "/org/example/file.txt" this method will yield
 * "example/file.txt".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun File.lastFolderAndFilename() : String {
    require(isFile) { "$this is not a file" }
    val filename = name
    val lastFolder = this.parentFile.name
    return if (lastFolder.isNotEmpty()) lastFolder + File.separator + filename else filename
}

/**
 * Get the ASCII representation of this [String] list as a graph path. Suppose a list of [String]s ["a", "b", "c"]. For
 * this list, the method will return the [String] "a -> b -> c". The method enables to control the
 * [maxEntriesInSameRow], after which a line break will occur in the result [String]. The [levelIndent] and
 * [subLevelIndent] allow for prefixing the appearance of the result [String] with another [String] ([levelIndent]) and
 * all sub-levels after [maxEntriesInSameRow] was reached with an additional [String] ([subLevelIndent]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun List<String>.asGraphPath(maxEntriesInSameRow: Int = 3, levelIndent: String, subLevelIndent: String)
    : String {
    val sb = StringBuffer()
    val nextPathElements = mutableListOf<String>()
    var firstLevel = true
    for (n in 0 until count()) {
        nextPathElements.add(this[n])

        if (n+1 % maxEntriesInSameRow == 0) {
            val prefix = if (!firstLevel) "$levelIndent$subLevelIndent-> " else levelIndent
            val nextPathElementsString = nextPathElements.joinToString(" -> ")
            sb.append("$prefix$nextPathElementsString\n")
            nextPathElements.clear()
            firstLevel = false
        }
    }

    if (nextPathElements.isNotEmpty()) {
        val prefix = if (!firstLevel) "$levelIndent$subLevelIndent-> " else levelIndent
        val nextPathElementsString = nextPathElements.joinToString(" -> ")
        sb.append("$prefix$nextPathElementsString")
    }

    return sb.toString().removeSuffix("\n")
}

/**
 * Helper to iterate over each [IntermediateMicroservice] in the intermediate service models of this [Map] of
 * intermediate service model paths to [IntermediateServiceModel] instances. The lambdas realize callbacks for
 * different stages of the iteration. Specifically, they signal the beginning of the iteration over the next
 * intermediate service model ([nextModel]) and microservice ([nextMicroservice]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Map<String, IntermediateServiceModel>.forEachMicroservice(
    nextModel: (String, IntermediateServiceModel) -> Unit,
    nextMicroservice: (String, IntermediateMicroservice, String) -> Unit
) {
    forEach { (path, model) ->
        nextModel(path, model)
        model.microservices.forEach { microservice ->
            val microserviceIdentifier = microservice.simpleName()
            nextMicroservice(path, microservice, microserviceIdentifier)
        }
    }
}

/**
 * Get the simple name of this [IntermediateMicroservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateMicroservice.simpleName(capitalize: Boolean = true) : String {
    val simpleName = name.substringAfterLast(".")
    return if (capitalize) simpleName.capitalize() else simpleName
}

/**
 * Put the values of this [Map] to the [ValueStore]. The keys of the map determine the keys of the values in the
 * [ValueStore] prefixed by the given [keyPrefix].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: Any> Map<String, T>.putToValueStore(keyPrefix: String)
    = entries.forEach { (k, v) -> ValueStore[keyPrefix] = v to listOf(k) }

/**
 * Put the values of the nested map of this [Map] to the [ValueStore]. The key for a value consists of the [keyPrefix],
 * the key of the value's nested map in this [Map], and the key of the value in the nested map.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: Any> Map<String, Map<String, T>>.putNestedMapToValueStore(keyPrefix: String)
    = entries.forEach { (k, nestedMap) ->
            nestedMap.entries.forEach { (nestedKey, v) ->
                ValueStore[keyPrefix] = v to listOf(k, nestedKey)
            }
        }