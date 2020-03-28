package de.fhdo.lemma.model_processing.languages

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.ISetup
import java.lang.IllegalStateException

/**
 * Represents the description of an Ecore-based modeling language, which the concrete model processor is capable of
 * dealing with.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class LanguageDescription(val eInstance: EPackage) {
    val nsUri: String = eInstance.nsURI
}

/**
 * Xtext-specific language description, which, e.g., determines the language's [ISetup].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class XtextLanguageDescription(eInstance: EPackage, val languageSetup: ISetup) : LanguageDescription(eInstance)

/**
 * Interface to be implemented by language description providers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface LanguageDescriptionProviderI {
    fun getLanguageDescription(forLanguageNamespace: String) : LanguageDescription?
}

/**
 * Singleton to provide reusable access to language descriptions
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object LanguageDescriptions {
    private val descriptionCache = mutableMapOf<String, LanguageDescription>()
    private var isInitialized = false
    private var provider: LanguageDescriptionProviderI? = null

    /**
     * Initialize instance with processor package. This also triggers the search for the language description provider
     * on the classpath.
     */
    internal fun initialize(processorPackage : String) {
        if (isInitialized)
            throw IllegalStateException("Language descriptions have already been initialized")

        provider = findLanguageDescriptionProvider(processorPackage)
        isInitialized = true
    }

    /**
     * Get a language description for a language namespace. Returns a cached [LanguageDescription] instance if the
     * language namespace has already been requested.
     */
    fun getLanguageDescription(forLanguageNamespace: String) : LanguageDescription? {
        if (!isInitialized)
            throw IllegalStateException("Language descriptions have not been initialized")

        if (provider == null)
            throw PhaseException("No language description provider could be found on the classpath")

        return if (descriptionCache.containsKey(forLanguageNamespace))
                descriptionCache[forLanguageNamespace]
            else {
                val providedDescription = provider!!.getLanguageDescription(forLanguageNamespace)
                if (providedDescription != null)
                    descriptionCache[forLanguageNamespace] = providedDescription

                providedDescription
            }
    }
}

/**
 * Convenience method to retrieve a [LanguageDescription] from the [LanguageDescriptions] and register it in the
 * [EPackage.Registry].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun registerLanguage(languageNamespace: String) {
    val languageDescription = LanguageDescriptions.getLanguageDescription(languageNamespace)
        ?: throw PhaseException("No language description found for language $languageNamespace. Without a language " +
                "description, the respective models cannot be loaded and processed.")

        if (languageDescription.nsUri !in EPackage.Registry.INSTANCE)
            EPackage.Registry.INSTANCE[languageDescription.nsUri] = languageDescription.eInstance
}

/**
 * Convenience method to register a [LanguageDescription] set for a bunch of language namespaces in the
 * [EPackage.Registry].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun registerLanguages(languageNamespaces: Set<String>) {
    languageNamespaces.forEach { registerLanguage(it) }
}

/**
 * Find the language description provider, which is a class annotated with [LanguageDescriptionProvider] and
 * implementing the [LanguageDescriptionProviderI] interface, on the classpath. The provider returns for a given
 * language namespace the respective [LanguageDescription] instance. There can only be one language description provider
 * on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findLanguageDescriptionProvider(processorPackage : String) : LanguageDescriptionProviderI? {
    val annotatedClasses = findAnnotatedClasses(processorPackage, LanguageDescriptionProvider::class)
    when {
        annotatedClasses.isEmpty() ->
            return null
        annotatedClasses.size > 1 ->
            throw PhaseException("Ambiguous language description providers. Only one class on the classpath may be " +
                "annotated as being a language description provider.")
    }

    val languageDescriptionProviderInfo = annotatedClasses.first()
    languageDescriptionProviderInfo.extendsImplementsOrException(
        "Language description provider",
        expectedInterface = LanguageDescriptionProviderI::class
    )

    return languageDescriptionProviderInfo
        .loadClass(LanguageDescriptionProviderI::class.java)
        .getDeclaredConstructor()
        .newInstance()
}