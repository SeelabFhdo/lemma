package de.fhdo.ddmm.acceleo.parser

import org.eclipse.acceleo.common.internal.utils.AcceleoPackageRegistry
import org.eclipse.acceleo.common.utils.ModelUtils
import org.eclipse.emf.ecore.EPackage
import picocli.CommandLine
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import java.io.File

/**
 * Allows for executing a parsing process to derive EMTL files from Acceleo MTL files from the commandline. Therefore,
 * the JAR file with the "all-dependencies" classifier, which is produced by the build process, needs to be executed.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    val commandLine = StandaloneCommandLine(args)

    val parser = with(commandLine) {
        parser(rootPath) {
            classpathEntry(rootPath, rootPath)
            ePackage(loadMetamodelPackage(metamodelPath))
            useBinaryResources(useBinaryResources)
            usePlatformResourcePath(usePlatformResourcesPath)
            trimPosition(trimPosition)
        }
    }

    parser.buildAll()
    println(parser.printableParsingResult())
}

/**
 * Helper to retrieve an [EPackage] instance from an Ecore metamodel file.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun loadMetamodelPackage(metamodelPath: String) : EPackage {
    val resourceSet = ResourceSetImpl()
    val metamodelPackage = ModelUtils.load(File(metamodelPath), resourceSet) as EPackage
    EcoreUtil.resolveAll(metamodelPackage)

    // Assign the physical path of the metamodel file to the metamodel package URI in Acceleo's own package registry.
    // Acceleo's parser will then replace the references to the metamodel file in the resulting EMTL file with the
    // package URI. Otherwise, an error will occur in the generation process stating that "[the] type of the [...]
    // parameter of the [...] template named [...] is a proxy". That is, because in the generation process usually the
    // package URI is used and not the physical path of the metamodel file.
    AcceleoPackageRegistry.INSTANCE
        .dynamicEcorePackagePaths[metamodelPackage.nsURI] = URI.createFileURI(metamodelPath).toString()

    // TODO Fix "Cannot find operation" error when using an operation from Acceleo's OCL language extension, e.g.,
    //      tokenize on String instances (cf. https://wiki.eclipse.org/Acceleo/User_Guide#The_Acceleo_language). It
    //      seems that this has to do with the Ecore types not getting recognized correctly (they are proxies instead),
    //      when not using the language EPackage.eINSTANCE method but loading the Ecore model from a file alone.
    return metamodelPackage
}

/**
 * Commandline for the parsing process
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class StandaloneCommandLine(args: Array<String>) {
    /* Commandline option that specifies the root path that contains the Acceleo transformation modules to be parsed */
    @CommandLine.Option(
        names = ["-p", "--root_path"],
        paramLabel = "ROOT_PATH",
        description = ["the root path of the Acceleo transformation modules to be parsed"],
        required = true
    )
    lateinit var rootPath: String

    /* Commandline option that specifies the path to the Ecore metamodel referenced in the transformation modules */
    @CommandLine.Option(
        names = ["-m", "--metamodel_path"],
        paramLabel = "METAMODEL_PATH",
        description = ["the root path of the Ecore metamodel referenced in the transformation modules to be parsed"],
        required = true
    )
    lateinit var metamodelPath: String

    /* Commandline option that instructs the parser to use binary resources */
    @CommandLine.Option(
        names = ["--use_binary_resources"],
        paramLabel = "USE_BINARY_RESOURCES",
        description = ["use binary resources in the parsing process"]
    )
    var useBinaryResources = false

    /* Commandline option that instructs the parser to use platform resources path */
    @CommandLine.Option(
        names = ["--use_platform_resources_path"],
        paramLabel = "USE_PLATFORM_RESOURCES_PATH",
        description = ["use platform resources path in the parsing process"]
    )
    var usePlatformResourcesPath = false

    /* Commandline option that instructs the parser trim positions */
    @CommandLine.Option(
        names = ["--trim_position"],
        paramLabel = "TRIM_POSITION",
        description = ["trim positions in the parsing process"]
    )
    var trimPosition = false

    /**
     * Parse the commandline when it gets constructed
     */
    init {
        val parsedCommandLine = CommandLine(this).parse(*args)[0]
        parsedCommandLine
            ?.parseResult!!
            .matchedOptions()
            .map { it as CommandLine.Model.OptionSpec }
    }
}