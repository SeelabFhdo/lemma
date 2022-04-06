package de.fhdo.lemma.service.openapi

import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.parser.core.models.ParseOptions
import java.util.List
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.eclipse.xtend.lib.annotations.Accessors
import java.net.MalformedURLException
import java.net.URL
import de.fhdo.lemma.service.openapi.exceptions.ParsingException

/**
 * This class is the central entry point for the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3). It supports the generation from JSON as well as YAML
 * OpenAPI files, e.g.,
 * <a href="https://petstore3.swagger.io/api/v3/openapi.json">Swagger's PET Store example</a>
 * @see <a href="https://github.com/SeelabFhdo/lemma">LEMMA on GitHub</a>
 * @see <a href="https://www.openapis.org/">OpenAPI Specification</a>
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaGenerator {
    /** OpenAPI schema which will be used as source for generation */
    OpenAPI openAPI

    /** SLF4j Logger */
    Logger logger = LoggerFactory.getLogger(LemmaGenerator)

    /** Log of all encountered exceptions during all transformations */
    @Accessors(PUBLIC_GETTER) List<String> transMsgs = <String>newArrayList

    /** Checks whether there currently is a parsed in-memory to start the generation process */
    def boolean isParsed() {
        if(openAPI === null) false else true
    }

     /** Takes a URL pointing to an OpenAPI specification file (yaml or json) and parses it using
      * the swagger OpenAPI parsing framework. Returns a list of all encountered messages during
      * the parsing.
      */
    def List<String> parse(String openapi) {
        val returnMessages = newArrayList
        returnMessages.add("Encountered messages while parsing the URL...")
        val parseOptions = new ParseOptions()
        parseOptions.setResolve(true)
        parseOptions.setFlatten(true)
        val result = new OpenAPIParser().readLocation(openapi, null, parseOptions)
        if(result.messages !== null) {
            if(result.messages.length == 0) returnMessages.add("No errors or warnings encountered!")
            else returnMessages.addAll(result.messages)
        }
        if(result.openAPI !== null) {
            openAPI = result.openAPI
            returnMessages.add("In memory model of OpenAPI model loaded!")
        } else {
            returnMessages.add(
                "There was an error generating the in memory model for the given URL :("
            )
        }

        return returnMessages
    }

    /** Central methods which generates all models */
    def generateModels(String genPath, String dataFilename, String serviceFilename,
        String techFilename,  String prefixService
    ) {
        logger.info("Starting generation of LEMMA Data Model...")
        val dataGenerator = new LemmaDataSubGenerator(openAPI, genPath, dataFilename)
        val dataModel = dataFilename -> dataGenerator.generate
        logger.debug("Adding encountered messages to log.")
        transMsgs.addAll(dataGenerator.transMsgs)

        logger.info("Starting generation of LEMMA Technology Model...")
        val technologyGenerator = new LemmaTechnologySubGenerator(openAPI, genPath, techFilename)
        val techModel = techFilename -> technologyGenerator.generate
        logger.debug("Adding encountered messages to log.")
        transMsgs.addAll(technologyGenerator.transMsgs)

        logger.info("Starting generation of LEMMA Service Model...")
        val serviceGenerator =
            new LemmaServiceSubGenerator(openAPI, dataModel, techModel, genPath, serviceFilename)
        serviceGenerator.generate(prefixService)
        logger.debug("Adding encountered messages to log.")
        transMsgs.addAll(serviceGenerator.transMsgs)
    }

    /** Entrypoint for execution outside of eclipse.
     * Takes these parameters in the following order to call the OpenAPI2LEMMA Generator.
     * All parameters are mandatory.
     * <ul>
     * <li><i>openapiPath</i>
     * - URL pointing to the OpenAPI specification (file:/ or https://).</li>
     * <li><i>genPath</i>
     * - Path to the folder where the generated LEMMA models will be saved
     * (e.g. C:/myfolder/test ).</li>
     * <li><i>dataFilename</i> - Name for the generated LEMMA Domain Data Model.</li>
     * <li><i>serviceFilename</i> - Name for the generated LEMMA Service Model.</li>
     * <li><i>techFilename</i> - Name for the generated LEMMA Technology Model.</li>
     * <li><i>prefixService</i> - Prefix for the package of
     * the service model, (e.g. my.example.package)</li>
	 * </ul>
     */
	def static void main(String[] args) {
        val generator = new LemmaGenerator()
		generator.logger.info("Starting direct invocation of OpenAPI2LEMMA Generator.")
		generator.logger.info("Checking parameters...")
		if(args.length != 6)
			throw new IllegalArgumentException("Number of parameters insufficient.")

		//throws MalformedURLException if it cannot be parsed into URL
		val fetchUrl = new URL(args.get(0))
		val targetLoc = args.get(1)
		val dataName = args.get(2)
		val servName = args.get(3)
		val techName = args.get(4)
		val servPre = args.get(5)

        if(targetLoc.trim.isEmpty || dataName.trim.isEmpty ||
            servName.trim.isEmpty || techName.trim.isEmpty ||
            servPre.trim.isEmpty
        )
			throw new IllegalArgumentException("Empty parameters encountered.")
		generator.logger.info("Parameter check successful.")

		generator.logger.info("Parsing the OpenAPI file...")
        val parsingMessages = generator.parse(fetchUrl.toString)
        if(!generator.isParsed)
        	throw new ParsingException('''It was not possible to generate an in-memory '''+
			'''representation of the file located at «fetchUrl.toString» .''')
		generator.logger.info('''Encountered messages during parsing (empty if none):
        	«FOR msg : parsingMessages»
				«msg»
			«ENDFOR» END''')
		generator.logger.info("In-memory representation of OpenAPI model loaded.")

		generator.logger.info("Starting LEMMA model generation procedure...")
        generator.generateModels('''«targetLoc»/''', '''«dataName».data''',
			'''«servName».services''','''«techName».technology''', servPre)
		generator.logger.info("The transformation was a success!")
		generator.logger.info('''Encountered problems during transformation (empty if none):
        	«FOR msg : generator.transMsgs»
				«msg»
			«ENDFOR» END''')
	}
}
