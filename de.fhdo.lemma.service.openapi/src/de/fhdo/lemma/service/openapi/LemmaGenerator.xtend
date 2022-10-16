package de.fhdo.lemma.service.openapi

import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.parser.core.models.ParseOptions
import java.util.List
import org.slf4j.LoggerFactory
import java.net.URL
import java.nio.file.Paths
import java.io.File

/**
 * This class is the central entrypoint for the generation of LEMMA models from an OpenAPI
 * specification file (v3.0.3). The class supports the generation from JSON as well as YAML OpenAPI
 * files.
 *
 * @see <a href="https://github.com/SeelabFhdo/lemma">LEMMA on GitHub</a>
 * @see <a href="https://www.openapis.org/">OpenAPI Specification</a>
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaGenerator {
    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaGenerator)

    /* OpenAPI schema which will be used as source for the generation */
    static OpenAPI openAPI

    /* Log of all encountered exceptions during all transformations */
    static List<String> transMsgs = <String>newArrayList

    def getTransMsgs() {
        return transMsgs.unmodifiableView
    }

    /* Checks whether there currently is a parsed in-memory to start the generation process */
    def isParsed() {
        return openAPI !== null
    }

     /**
      * Take a URL pointing to an OpenAPI specification file (JSON or YAML) and parse it using the
      * Swagger OpenAPI parsing framework. Return a list of all encountered messages during the
      * parsing.
      */
    def parse(String location) {
        val returnMessages = newArrayList("Encountered messages while parsing the URL")
        val parseOptions = new ParseOptions()
        parseOptions.setResolve(true)
        parseOptions.setFlatten(true)
        val result = new OpenAPIParser().readLocation(location, null, parseOptions)

        if (result.messages !== null) {
            if (result.messages.empty)
                returnMessages.add("No errors or warnings encountered")
            else
                returnMessages.addAll(result.messages)
        }

        if (result.openAPI !== null) {
            openAPI = result.openAPI
            returnMessages.add("In-memory model of OpenAPI specification URL loaded")
        } else
            returnMessages.add("There was an error generating the in-memory model for the given " +
                "OpenAPI specification URL")

        return returnMessages
    }

    /**
     * Central method which generates all models
     */
    static def generateModels(String targetPath, String dataFilename, String technologyFilename,
        String serviceFilename, String serviceQualifier) {
        val terminatedTargetPath = if (!targetPath.endsWith(File.separator))
                '''«targetPath»«File.separator»'''
            else
                targetPath

        LOGGER.info("Starting generation of LEMMA data model...")
        val dataModelPath = Paths.get(terminatedTargetPath, dataFilename).toString
        val dataGenerator = new LemmaDataSubGenerator(openAPI, dataModelPath)
        val dataModel = dataFilename -> dataGenerator.generate
        transMsgs.addAll(dataGenerator.transMsgs)

        LOGGER.info("Starting generation of LEMMA technology model...")
        val technologyModelPath = Paths.get(terminatedTargetPath, technologyFilename).toString
        val technologyGenerator = new LemmaTechnologySubGenerator(openAPI, technologyModelPath)
        val technology = technologyFilename -> technologyGenerator.generate
        transMsgs.addAll(technologyGenerator.transMsgs)

        LOGGER.info("Starting generation of LEMMA service model...")
        val serviceModelPath = Paths.get(terminatedTargetPath, serviceFilename).toString
        val serviceGenerator = new LemmaServiceSubGenerator(openAPI, dataModel, technology,
            serviceModelPath)
        serviceGenerator.generate(serviceQualifier)
        transMsgs.addAll(serviceGenerator.transMsgs)
    }

    /**
     * Entrypoint for standalone execution. It takes the following mandatory parameters in the given
     * order to call the OpenAPI2LEMMA generator.
     * <ul>
     * <li><i>openapiPath</i>: URL pointing to the OpenAPI specification (file:/ or https://).</li>
     * <li><i>genPath</i>: Path to the folder where the generated LEMMA models will be saved (e.g.,
     * C:\myfolder\test).</li>
     * <li><i>dataFilename</i>: Name for the generated LEMMA data model.</li>
     * <li><i>serviceFilename</i>: Name for the generated LEMMA service model.</li>
     * <li><i>techFilename</i>: Name for the generated LEMMA technology model.</li>
     * <li><i>prefixService</i>: Prefix for the package of the service model (e.g.,
     * "my.example.package")</li>
     * </ul>
     */
    // TODO: Refactor argument parsing towards something more sophisticated and safe like
    //       https://picocli.info.
    def static void main(String[] args) {
        val generator = new LemmaGenerator()
        LOGGER.info("Starting standalone execution of OpenAPI2LEMMA Generator")
        LOGGER.info("Checking arguments...")
        if (args.length != 6)
            exitWithError('''Not enough arguments (expected: 6, given: «args.length»)''')

        // TODO: Swap serviceModelName and technologyModelName to be consistent with sub-generator
        //       APIs and invocations
        val fetchUrl = new URL(args.get(0))
        val targetFolder = args.get(1).trim
        val dataModelName = args.get(2).trim
        val serviceModelName = args.get(3).trim
        val technologyModelName = args.get(4).trim
        val serviceQualifier = args.get(5).trim

        if (targetFolder.empty ||
            dataModelName.empty ||
            serviceModelName.empty ||
            technologyModelName.isEmpty ||
            serviceQualifier.empty)
            exitWithError("Arguments must not be empty")

        LOGGER.info("Parsing the OpenAPI specification URL...")
        val parsingMessages = generator.parse(fetchUrl.toString)
        if (!generator.isParsed)
            exitWithError("OpenAPI specification URL could not be parsed")

        if (!parsingMessages.empty)
        LOGGER.info(
            '''Encountered messages during parsing:
            «FOR msg : parsingMessages»
                - «msg»
            «ENDFOR»'''
        )
        LOGGER.info("... in-memory representation of OpenAPI specification URL parsed")

        LOGGER.info("Starting LEMMA model generation...")
        generateModels(
            targetFolder,
            '''«dataModelName».data''',
            '''«technologyModelName».technology''',
            '''«serviceModelName».services''',
            serviceQualifier
        )
        if (generator.transMsgs.empty)
            LOGGER.info("Transformation successful")
        else
            LOGGER.info(
                '''Encountered problems during transformation:
                «FOR msg : generator.transMsgs»
                    «msg»
                «ENDFOR»'''
            )
    }

    /**
     * Exit standalone execution with error return code
     */
    private static def exitWithError(String message) {
        println(message)
        System.exit(1)
    }
}