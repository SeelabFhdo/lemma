package de.fhdo.lemma.model_processing.languages

import de.fhdo.lemma.model_processing.getMethod
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.resource.Resource
import java.lang.IllegalArgumentException

/**
 * Helper to convert relative URIs within Xtext-conform import concept instances to absolute file://-URIs. A concept
 * instance conforms to Xtext's import mechanism, if it has a property called "importURI" (prescribed by Xtext) with a
 * getter and a setter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun <T: Any> List<T>.convertToAbsoluteFileUrisInPlace(resource: Resource) {
    if (isEmpty())
        return

    /* Check prerequisites, and retrieve importURI getter and setter */
    val getUri = first().getMethod("getImportURI", String::class)
    val setUri = first().getMethod("setImportURI", parameterClasses = *arrayOf(String::class))

    if (getUri == null || setUri == null)
        throw IllegalArgumentException("Import concept ${first()::class.qualifiedName} needs to exhibit " +
            "\"String getImportURI()\" and \"setImportURI(String)\" methods")

    /*
     * Determine the base path on whose basis absolute file://-URIs for relative import URIs shall be determined. It
     * corresponds to the URI of the passed resource with its scheme removed.
     */
    val absoluteBasePathWithoutScheme = resource.uri.let {
        val scheme = it.scheme()?.toString() ?: ""
        it.toString()
            .removePrefix(scheme)
            // Remove possibly remaining colon prefix, e.g., for a URI in the form "file:/myFolder/example.file"
            .removePrefix(":")

    }

    /* Convert relative import URIs to absolute file://-URIs */
    forEach {
        val uri = getUri.call(it) as? String

        if (uri != null) {
            // Use the same mechanism as the intermediate model transformation component of the LEMMA project
            val absoluteFileUri = LemmaUtils.convertToAbsoluteFileUri(uri, absoluteBasePathWithoutScheme)
            setUri.call(it, absoluteFileUri)
        }
    }
}