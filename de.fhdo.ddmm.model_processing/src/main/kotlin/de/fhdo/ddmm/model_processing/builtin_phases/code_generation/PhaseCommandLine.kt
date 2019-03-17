package de.fhdo.ddmm.model_processing.builtin_phases.code_generation

import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec

/**
 * Singleton, which represents the commandline of the [CodeGenerationPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object PhaseCommandLine {
    const val ALLOW_CODE_GENERATION_OUTSIDE_TARGET_FOLDER_OPTION_NAME = "--allow_code_generation_outside_target_folder"
    const val PRESERVE_EXISTING_FILES_OPTION_NAME = "--preserve_existing_files"
    const val MODULE_SELECTION_SHORT_OPTION_NAME = "-m"
    const val MODULE_SELECTION_LONG_OPTION_NAME = "--modules"

    @CommandLine.Spec
    private lateinit var commandSpec: CommandSpec

    // Print properties commandline option
    @CommandLine.Option(
        names = ["--print_properties"],
        description = ["print all properties of the code generator"]
    )
    var printProperties: Boolean = false

    // Print modules commandline option
    @CommandLine.Option(
        names = ["--print_modules"],
        description = ["print all modules of the code generator"]
    )
    var printModules: Boolean = false

    // Allow code generation outside target folder commandline option
    @CommandLine.Option(
        names = [ALLOW_CODE_GENERATION_OUTSIDE_TARGET_FOLDER_OPTION_NAME],
        description = ["allow code generation outside target folder"]
    )
    var allowCodeGenerationOutsideTargetFolder: Boolean = false

    // Don't overwrite existing files with generated ones commandline option
    @CommandLine.Option(
        names = [PRESERVE_EXISTING_FILES_OPTION_NAME],
        description = ["don't overwrite existing files with generated ones"]
    )
    var preserveExistingFiles: Boolean = false

    // Invoke selected modules commandline option
    @CommandLine.Option(
        names = [MODULE_SELECTION_SHORT_OPTION_NAME, MODULE_SELECTION_LONG_OPTION_NAME],
        description = ["only invoke specified code generation modules"],
        arity = "*"
    )
    var modules: Array<String>? = null

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>) {
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }
}