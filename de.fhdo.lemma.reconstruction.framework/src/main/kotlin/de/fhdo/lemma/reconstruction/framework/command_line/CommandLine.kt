package de.fhdo.lemma.reconstruction.framework.command_line

import de.fhdo.lemma.model_processing.asFile
import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec

/**
 * Object to represent the basic commandline of the software architecture reconstruction framework.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal object CommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandSpec

    /**
     * Commandline option for a path to a Plugin's JAR archive
     */
    private var parameterPlugins: Set<String>? = null
        @CommandLine.Option(
            names = ["--plugin", "-p"],
            paramLabel = "PLUGIN",
            description = ["path to a Plugin's JAR archive"]
        )
        set(value) {
            value?.forEach {
                if (!it.asFile().exists())
                    throw CommandLine.ParameterException(
                        commandSpec.commandLine(), "Plugin file $it does not " +
                            "exist")
            }
            field = value
        }

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>) {
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }

    /**
     * Get paths to all Plugins. The key of the map is the Plugin path and the value is the name of the explicitly
     * passed fully-qualified Plugin entry classname. It may be null, if it shall be automatically inferred.
     */
    fun plugins() : Map<String, String?> {
        val plugins = mutableMapOf<String, String?>()
        if (parameterPlugins != null)
            plugins.putAll(parameterPlugins!!.map { it to null })
        return plugins
    }

    /**
     *  Commandline option for a target folder to a Java project or file.
     */
    private var parameterTargetFolders: Set<String>? = null
        @CommandLine.Option(
            names = ["--targetFolder", "-t"],
            paramLabel = "Target",
            description = ["path to a target folder"]
        )
        set(value) {
            value?.forEach {
                if (!it.asFile().exists())
                    throw CommandLine.ParameterException(
                        commandSpec.commandLine(), "Folder  $it does not " +
                                "exist")
            }
            field = value
        }

    /**
     * Get paths to all Plugins. The key of the map is the Plugin path and the value is the name of the explicitly
     * passed fully-qualified Plugin entry classname. It may be null, if it shall be automatically inferred.
     */
    fun targetFolders() : Set<String> {
        val folders = mutableSetOf<String>()
        if (parameterTargetFolders != null)
            folders.addAll(parameterTargetFolders!!)
        return folders
    }
}