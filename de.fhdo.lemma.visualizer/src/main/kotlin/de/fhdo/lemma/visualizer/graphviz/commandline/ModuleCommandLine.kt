package de.fhdo.lemma.visualizer.graphviz.commandline

import de.fhdo.lemma.visualizer.model.DetailLevel
import picocli.CommandLine
import java.io.File
import java.nio.file.Path

/**
 * Singleton, which represents the additional commandline of the ServicesToGraphVizGenerator code_generation phase.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */

internal object ModuleCommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandLine.Model.CommandSpec

    // Specific Models
    @CommandLine.Option(
        names = ["-asm", "--additionalSpecificModels"],
        paramLabel = "SPECIFICDIR",
        description = ["Absolute path to the dir where the additional specific service models are located."]
    )
    var specificPath: Path? = null

    // Specific Models
    @CommandLine.Option(
        names = ["-lvl", "--detailLevel"],
        paramLabel = "DETAILLVL",
        description = ["Level of detail which is shown on the visualization. Valid values are SERVICES, INTERFACES, " +
                "OPERATIONS, and SIGNATURES"]
    )
    var detailLevel: DetailLevel = DetailLevel.INTERFACES

    // Height of the generated image
    @CommandLine.Option(
        names = ["-height"],
        paramLabel = "HEIGHT",
        description = ["Height of the generated image."]
    )
    var height: Int = 2000

    // Specific Models
    @CommandLine.Option(
        names = ["-aim", "--additionalModels"],
        paramLabel = "INTERMEDIATEDIR",
        description = ["Absolute path to the dir where the additional intermediate service models are located."]
    )
    var intermediatePath: Path? = null

    @CommandLine.Parameters(
        paramLabel = "MODELS",
        description = ["one ore more modeling files to process. " +
                "For each model file, always specify the appropriate intermediate model directly behind it."]
    )
    var models: Array<File>? = null

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>) {
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }
}