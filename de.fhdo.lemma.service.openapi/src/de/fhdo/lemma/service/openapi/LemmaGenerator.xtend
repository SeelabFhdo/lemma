package de.fhdo.lemma.service.openapi

import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.parser.core.models.ParseOptions
import java.util.List
import org.slf4j.LoggerFactory
import java.net.URL
import java.nio.file.Paths
import java.io.File
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine

/**
 * Entrypoint for the generation of LEMMA models from an OpenAPI specification file (v3.0.3). The
 * class supports the generation of LEMMA models from JSON-based and YAML-based OpenAPI
 * specification files.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */

@Command(name = "transform", description = "Transform OpenAPI specification files into LEMMA " +
    "domain, service, and technology models.")
class LemmaGenerator implements Runnable {
    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaGenerator)

    /* CLI options for standalone execution */
    @Option(names = #["-u", "--url"], description = "URL pointing to the OpenAPI specification " +
        "file (file:/ or https:// URI)", required = true)
    var String fetchUrl

    @Option(names = #["-f", "--target_folder"], description = "Path to the folder where the " +
        "generated LEMMA models shall be saved", required = true)
    var String targetFolder

    @Option(names = #["-d", "--data_model_name"], description = "Name for the generated LEMMA " +
        "data model", required = true)
    var String dataModelName

    @Option(names = #["-s", "--service_model_name"], description = "Name for the generated LEMMA " +
        "service model", required = true)
    var String serviceModelName

    @Option(names = #["-t", "--technology_model_name"], description = "Name for the generated " +
        "LEMMA technology model", required = true)
    var String technologyModelName

    @Option(names = #["-p", "--service_qualifier"], description = "Qualifier for generated " +
        "LEMMA microservice definitions in Java package notation", required = true)
    var String serviceQualifier

    /* OpenAPI schema which will be used as source for the generation */
    OpenAPI openAPI

    /* Log of all encountered exceptions during all transformations */
    List<String> transMsgs = <String>newArrayList

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
    def generateModels(String targetPath, String dataFilename, String technologyFilename,
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
     * Entrypoint for CLI-based standalone execution of the OpenAPI2LEMMA generator
     */
    def static void main(String[] args) {
        CommandLine.run(new LemmaGenerator(), args);
    }

    /**
     * Logic for the thread-based standalone execution of the OpenAPI2LEMMA generator
     */
    override run() {
        LOGGER.info("Starting standalone execution of OpenAPI2LEMMA generator")
        val fetchUrl = new URL(this.fetchUrl)
        val targetFolder = this.targetFolder.trim
        val dataModelName = this.dataModelName.trim
        val serviceModelName = this.serviceModelName.trim
        val technologyModelName = this.technologyModelName.trim
        val serviceQualifier = this.serviceQualifier.trim

        if (targetFolder.empty ||
            dataModelName.empty ||
            serviceModelName.empty ||
            technologyModelName.isEmpty ||
            serviceQualifier.empty)
            exitWithError("Arguments must not be empty")

        LOGGER.info("Parsing the OpenAPI specification URL...")
        val parsingMessages = parse(fetchUrl.toString)
        if (!isParsed)
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
        if (transMsgs.empty)
            LOGGER.info("Transformation successful")
        else
            LOGGER.info(
                '''Encountered problems during transformation:
                «FOR msg : transMsgs»
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