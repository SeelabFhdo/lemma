package de.fhdo.reconstruction.framework.plugins

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.phases.PhaseException
import java.net.URLClassLoader
import java.util.regex.Pattern

/**
 * Base class for Plugins. A Plugin provides functionalities regarding the software architecture reconstruction process.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
abstract class AbstractPlugin(val pluginImplementationPackage: String) {

    /**
     * Callback to pass Plugin-specific class loader to Plugin.
     */
    open fun setClassLoader(classLoader: ClassLoader) {}
}

/**
 * Load Plugin instances from Plugins JAR archives.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
internal fun loadPlugins(pluginFilePathsAndClassnames: Map<String, String?>): Map<AbstractPlugin, URLClassLoader> {
    val classLoaders = createPluginClassLoaders(pluginFilePathsAndClassnames.keys)
    return pluginFilePathsAndClassnames.map { (filePath, explicitlySpecifiedClassname) ->
        val pluginClassLoader = classLoaders[filePath]!!
        val pluginClassnames = explicitlySpecifiedClassname?.let { listOf(it) }
            ?: filePath.inferDefaultPluginClassnames()

        // Search Plugin class in JAR archive via Plugin's class loader and based on explicit or default Plugin class
        // name(s)
        var pluginClass: Class<out AbstractPlugin>? = null
        for (classname in pluginClassnames) {
            pluginClass = try {
                Class.forName(classname, true, pluginClassLoader) as Class<AbstractPlugin>
            } catch (ex: ClassNotFoundException) {
                null
            }

            if (pluginClass != null)
                break
        }

        if (pluginClass == null)
            throw PhaseException(
                """No Plugin classes found in file "$filePath" (search names: """ +
                        "${pluginClassnames.joinToString()})."
            )

        // Load Plugin class instance
        try {
            val pluginInstance = pluginClass.getConstructor().newInstance()
            pluginInstance.setClassLoader(pluginClassLoader)
            pluginInstance to pluginClassLoader
        } catch (ex: Exception) {
            throw PhaseException(
                "Plugin class ${pluginClass.simpleName} from $filePath could not be loaded: " +
                        ex.message
            )
        }
    }.toMap()
}

/**
 * Helper to create [URLClassLoader] instances for the paths to the Plugins JAR archives.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
private fun createPluginClassLoaders(pluginFilePaths: Iterable<String>): Map<String, URLClassLoader> =
    pluginFilePaths.map {
        val pluginUrl = it.asFile().toURI().toURL()
        val pluginClassLoader = URLClassLoader.newInstance(arrayOf(pluginUrl), ClassLoader.getSystemClassLoader())
        it to pluginClassLoader
    }.toMap()

/**
 * Helper to infer the default fully-qualified names of a Plugin class from the file path to its JAR archive. The
 * default names are built by assuming that the filename of the Plugin's JAR archive is fully-qualified, e.g.,
 * "org.example.myplugin.jar" or "org.example.myplugin-0.0.1-SNAPSHOT.jar" (i.e., what is typically created by a
 * build tool like Maven or Gradle). From such a filename, several "heuristics" are employed to derive allowed default
 * Plugin classnames.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
private fun String.inferDefaultPluginClassnames(): Set<String> {
    val inferredClasspathFromFilePath = listOf(
        // Pattern with version, e.g., org.example.my_plugin-0.0.1-SNAPSHOT.jar
        Pattern.compile("(?<classpath>.*?)\\-.*\\.jar"),

        // Pattern without version, e.g., org.example.my_plugin.jar
        Pattern.compile("(?<classpath>.*?)\\.jar")
    ).map { it.matcher(this.asFile().name) }
        .find { it.matches() }
        ?.group("classpath") ?: ""

    val pluginClassnames = listOfNotNull(
        inferredClasspathFromFilePath.plainPluginClassname(),
        inferredClasspathFromFilePath.underscoreAwarePluginClassname()
    )

    return if (inferredClasspathFromFilePath.isNotEmpty())
        pluginClassnames.map { "$inferredClasspathFromFilePath.$it" }.toSet()
    else
        pluginClassnames.toSet()
}

/**
 * "Plain Plugin classname" heuristic for default Plugin classnames. From this [String] representing a Plugin classpath
 * the last classpath part is extracted, capitalized, and extended by the [PLUGIN_CLASSNAME_SUFFIX]. That is, for the
 * classpath "org.example.myplugin", the heuristic would yield the Plugin classname "MypluginGenerator".
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
private fun String.plainPluginClassname() = substringAfterLast(".").capitalize() + PLUGIN_CLASSNAME_SUFFIX

/**
 * Suffix for Plugin classnames.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
private const val PLUGIN_CLASSNAME_SUFFIX = "Plugin"

/**
 * "Underscore-aware Plugin classname" heuristic for default Plugin classnames. From this [String] representing a Plugin
 * classpath the last classpath part is extracted and split at underscore occurrences. The resulting "underscore parts"
 * are capitalized, joined together, and extended by the [PLUGIN_CLASSNAME_SUFFIX]. That is, for the classpath
 * "org.example.my_plugin", the heuristic would yield the Plugin classname "MyPluginGenerator".
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
private fun String.underscoreAwarePluginClassname(): String? {
    val lastClasspathPart = substringAfterLast(".")
    return if ("_" in lastClasspathPart)
        lastClasspathPart.split("_").joinToString("") { it.capitalize() } + PLUGIN_CLASSNAME_SUFFIX
    else
        null
}