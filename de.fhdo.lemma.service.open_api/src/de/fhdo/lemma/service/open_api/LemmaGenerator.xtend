package de.fhdo.lemma.service.open_api

import io.swagger.parser.OpenAPIParser
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.parser.core.models.ParseOptions
import java.util.List
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * This class is the central entry point for the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3). It supports the generation from JSON as well as YAML
 * OpenAPI files, e.g.,
 * <a href="https://petstore3.swagger.io/api/v3/openapi.json">Swagger's PET Store example</a>
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaGenerator {

    OpenAPI openAPI
    Logger logger

    /*
    //This entrypoint is only needed for local testing.
    def static void main(String[] args) {
        val modelLocation = "https://petstore3.swagger.io/api/v3/openapi.json"
        val generator = new LemmaGenerator()
        generator.parse(modelLocation)
        generator.generateModels("./models-gen/", "generated.data",
        "generated.services", "openapi.technology", "de.example")
    }
    */
    new() {
        logger = LoggerFactory.getLogger(LemmaGenerator)
    }

    /** Checks whether there currently is a parsed in-memory to start the generation process */
    def boolean isParsed() {
        if(openAPI === null) false else true
    }

     /** Takes a URL pointing to an openapi specification file (yaml or json) and parses it using
      * the swagger openapi parsing framework. Returns a list of all encountered messages during
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
            returnMessages.addAll(result.messages)
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
        //
        logger.info("Starting generation of LEMMA Technology Model...")
        val technologyGenerator = new LemmaTechnologySubGenerator(openAPI, genPath, techFilename)
        val techModel = techFilename -> technologyGenerator.generate
        //
        logger.info("Starting generation of LEMMA Service Model...")
         val serviceGenerator =
            new LemmaServiceSubGenerator(openAPI, dataModel, techModel, genPath, serviceFilename)
        serviceGenerator.generate(prefixService)
    }
}
