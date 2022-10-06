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
 * This class is the central entrypoint for the generation of LEMMA models from an OpenAPI
 * specification file (v3.0.3). The class supports the generation from JSON as well as YAML OpenAPI
 * files.
 * It calls the sub-generators, namely, the
 * {@link de.fhdo.lemma.service.openapi.LemmaDataSubGenerator LemmaDataSubGenerator},
 * {@link de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator LemmaServiceSubGenerator},
 * {@link de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator LemmaTechnologySubGenerator},
 * for the respective LEMMA model kinds.
 *
 * @see <a href="https://github.com/SeelabFhdo/lemma">LEMMA on GitHub</a>
 * @see <a href="https://www.openapis.org/">OpenAPI Specification</a>
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */

 @Command(
  name = "transform",
  description = "Transforms a OpenAPI document into LEMMA Data, Service, and Technology models.
	Requires the following options:
	 -url: URL pointing to the OpenAPI specification (file:/ or https://).
     -tf: Path to the folder where the generated LEMMA models will be saved (e.g. C:\\myfolder\\test).
     -d: Name for the generated LEMMA data model.
     -s: Name for the generated LEMMA service model.
     -t: Name for the generated LEMMA technology model.
     '-sp: Prefix for the package of the service model (e.g. 'my.example.package')."
)
class LemmaGenerator implements Runnable {
    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaGenerator)

	/* For stand-alone execution, the generator provides several CLI options */
	@Option(names = #["-u"], required = true)
	var String fetchUrl

	@Option(names = #["-tf"], required = true)
    var String targetFolder

	@Option(names = #["-d"], required = true)
    var String dataModelName

    @Option(names = #["-s"], required = true)
    var String serviceModelName

    @Option(names = #["-t"], required = true)
    var String technologyModelName

    @Option(names = #["-sp"], required = true)
    var String servicePrefix



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
        String serviceFilename, String servicePrefix) {
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
        serviceGenerator.generate(servicePrefix)
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
    def static void main(String[] args) {
    	CommandLine.run(new LemmaGenerator(), args);
    }

    /**
     * Exit standalone execution with error return code
     */
    private static def exitWithError(String message) {
        println(message)
        System.exit(1)
    }

	//TODO CONTINIUE HERE, PROCESS PICOCLI VARIABLES. RUN TEST SEEE IF IMPLEMENATION STILL WORKS...
	override run() {
		LOGGER.info("Starting standalone execution of OpenAPI2LEMMA Generator")
        val fetchUrl = new URL(this.fetchUrl)
        val targetFolder = this.targetFolder.trim
        val dataModelName = this.dataModelName.trim
        val serviceModelName = this.serviceModelName.trim
        val technologyModelName = this.technologyModelName.trim
        val servicePrefix = this.servicePrefix.trim

        if (targetFolder.empty ||
            dataModelName.empty ||
            serviceModelName.empty ||
            technologyModelName.isEmpty ||
            servicePrefix.empty)
            exitWithError("Arguments must not be empty")

        LOGGER.info("Parsing the OpenAPI specification URL...")
        val parsingMessages = this.parse(fetchUrl.toString)
        if (!this.isParsed)
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
        this.generateModels(
            targetFolder,
            '''«dataModelName».data''',
            '''«technologyModelName».technology''',
            '''«serviceModelName».services''',
            servicePrefix
        )
        if (this.transMsgs.empty)
            LOGGER.info("Transformation successful")
        else
            LOGGER.info(
                '''Encountered problems during transformation:
                «FOR msg : this.transMsgs»
                    «msg»
                «ENDFOR»'''
            )
	}

}
