package de.fhdo.lemma.model_processing.languages

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.loadXtextResource
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.ISetup
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

/**
 * Represents the description of an Ecore-based modeling language, which the concrete model processor is capable of
 * dealing with.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class LanguageDescription(val eInstance: EPackage) {
    val nsUri: String = eInstance.nsURI

    /**
     * Load the model
     */
    abstract fun loadModel(modelPath: String) : Resource

    /**
     * Register the described modeling language to the [EPackage] if necessary
     */
    internal fun registerLanguage() {
        if (nsUri !in EPackage.Registry.INSTANCE)
            EPackage.Registry.INSTANCE[nsUri] = eInstance
    }
}

/**
 * Language description for Xtext-based models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class XtextLanguageDescription(eInstance: EPackage, val languageSetup: ISetup) : LanguageDescription(eInstance) {
    override fun loadModel(modelPath: String)
        = loadXtextResource(languageSetup, modelPath, modelPath.asFile().inputStream())
}

/**
 * Language description for XMI models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
class XmiLanguageDescription(eInstance: EPackage) : LanguageDescription(eInstance) {
    override fun loadModel(modelPath: String) = modelPath.asXmiResource()
}

/**
 * Interface to be implemented by language description providers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface LanguageDescriptionProviderI {
    fun getLanguageDescription(forLanguageNamespace: Boolean, forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String) : LanguageDescription?
}

/**
 * Singleton to provide reusable access to language descriptions
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object LanguageDescriptions {
    private val namespaceDescriptionCache = mutableMapOf<String, LanguageDescription>()
    private val extensionDescriptionCache = mutableMapOf<String, LanguageDescription>()
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
     * Get a language description for a language namespace or language-specific file extension. Returns a cached
     * [LanguageDescription] instance if the description has already been requested once.
     */
    fun getLanguageDescription(forLanguageNamespace: Boolean, forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String) : LanguageDescription? {
        when {
            !isInitialized ->
                throw IllegalStateException("Language descriptions have not been initialized")
            provider == null ->
                throw IllegalStateException("No language description provider could be found on the classpath")
            forLanguageNamespace == forFileExtension ->
                throw IllegalArgumentException("Ambiguous language description request: A language description must " +
                    "either be requested for a language namespace or a file extension")
        }

        val cache = when {
            forLanguageNamespace -> namespaceDescriptionCache
            else -> extensionDescriptionCache
        }

        return if (cache.containsKey(languageNamespaceOrFileExtension))
            cache[languageNamespaceOrFileExtension]
        else {
            val providedDescription = provider!!.getLanguageDescription(forLanguageNamespace, forFileExtension,
                languageNamespaceOrFileExtension)
            if (providedDescription != null)
                cache[languageNamespaceOrFileExtension] = providedDescription

            providedDescription
        }
    }

    /**
     * Name of the language description provider's class (may only be invoked after successful execution of
     * [initialize])
     */
    internal fun getProviderClassname() = provider!!::class.java.name
}
/**
 * Find the language description provider, which is a class annotated with [LanguageDescriptionProvider] and
 * implementing the [LanguageDescriptionProviderI] interface, on the classpath. For a given language namespace or file
 * extension, the provider returns the respective [LanguageDescription] instance. There must exactly be one language
 * description provider on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findLanguageDescriptionProvider(processorPackage : String) : LanguageDescriptionProviderI? {
    val annotatedClasses = findAnnotatedClasses(processorPackage, LanguageDescriptionProvider::class)
    when {
        annotatedClasses.isEmpty() -> return null
        annotatedClasses.size > 1 -> throw IllegalStateException("Ambiguous language description providers: " +
            "${annotatedClasses.joinToString { it.name }}. Only one class in processor implementation package " +
            "\"$processorPackage\" can realize a language description provider.")
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